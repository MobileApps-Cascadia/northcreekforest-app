package edu.cascadia.mobas.northcreekforest;



import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.room.Room;
import edu.cascadia.mobas.northcreekforest.db.AppDatabase;
import edu.cascadia.mobas.northcreekforest.db.PhotoDao;
import edu.cascadia.mobas.northcreekforest.db.PhotoPointDao;
import edu.cascadia.mobas.northcreekforest.db.UserDao;
import edu.cascadia.mobas.northcreekforest.models.User;
import edu.cascadia.mobas.northcreekforest.utilities.SampleData;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private AppDatabase aDB;
    private PhotoDao pDao;
    private PhotoPointDao ppDao;
    private UserDao uDao;

    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getContext();
        aDB   = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        pDao  = aDB.photoDao();
        ppDao = aDB.photoPointDao();
        uDao  = aDB.userDao();
        Log.i(TAG, "create Db");
    }

    @After
    public void closeDb(){
        aDB.close();
        Log.i(TAG, "closeDb");
    }

    @Test
    public void createAndRetrieveUsers(){
        uDao.addAll(SampleData.getUsers());
        int count = uDao.getCount();
        Log.i(TAG, "createAndRetrieveUsers"+ count);
        assertEquals(SampleData.getUsers().size(), count);
    }

    @Test
    public void compareStrings(){
        uDao.addAll(SampleData.getUsers());
        User Original = SampleData.getUsers().get(0);
        User fromDb = uDao.getUser(1);
        assertEquals(Original.getUser_Name(), fromDb.getUser_Name());
        assertEquals(1, fromDb.getId());

    }

}
