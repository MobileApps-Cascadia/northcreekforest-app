package edu.cascadia.mobas.northcreekforest.utilities;

import java.util.ArrayList;
import java.util.List;

import edu.cascadia.mobas.northcreekforest.models.User;

public class SampleData {

        public static List<User> getUsers(){
        List<User> usersList = new ArrayList<User>();

        usersList.add(new User("bill bob", "billbob@gmail.com", 4));
        usersList.add(new User("z dog", "zbeezy@gmail.com", 34));
        usersList.add(new User("jon smith", "jsmith@hotmail.com", 15));

        return usersList;
    }
}
