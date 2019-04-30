package edu.cascadia.mobas.northcreekforest;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import edu.cascadia.mobas.northcreekforest.db.AppDatabase;
import edu.cascadia.mobas.northcreekforest.models.User;

public class activity_account_formViewModel extends AndroidViewModel{

 private AppDatabase appDatabase;

    public activity_account_formViewModel(@NonNull Application application) {

        super(application);

        appDatabase = AppDatabase.getInstance(getApplication());
    }

    public void addUser(User user){
        new addAsyncTask(appDatabase).execute(user);
    }

    private static class addAsyncTask extends AsyncTask<User, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase){
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(User... users) {
           db.userDao().addUser(users[0]);
            return null;
        }
    }


}
