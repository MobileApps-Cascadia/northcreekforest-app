package edu.cascadia.mobas.northcreekforest.utilities

import java.util.ArrayList

import edu.cascadia.mobas.northcreekforest.models.User

object SampleData {

    val users: List<User>
        get() {
            val usersList = ArrayList<User>()

            usersList.add(User("bill bob", "billbob@gmail.com", 4))
            usersList.add(User("z dog", "zbeezy@gmail.com", 34))
            usersList.add(User("jon smith", "jsmith@hotmail.com", 15))

            return usersList
        }
}
