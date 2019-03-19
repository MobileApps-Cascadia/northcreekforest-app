package edu.cascadia.mobas.northcreekforest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.media.Image;
import android.support.annotation.NonNull;
import java.sql.Blob;

public class UploadViewModel extends AndroidViewModel {
    //private <AppRepository> repository;

    public UploadViewModel(@NonNull Application application) {
        super(application);

        //repository = new AppRepository(application);
    }

    public void insert(Image image){
        //repository.insert(image);
    }

    public void delete(Image image){
        //repository.delete(image);
    }

    public void deletetest(Blob image){

    }
}