
package ru.ignatovichanastasiia.alfa.domein;

import java.util.HashMap;



/**
 *
 * @author ignatovichanastasiia
 */


public class Rates { 
   HashMap<String, String> allCourses;

    public Rates() {
    }
   
    public Rates(HashMap allCourses) {
        this.allCourses = allCourses;
    }

    public HashMap getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(HashMap allCourses) {
        this.allCourses = allCourses;
    }
}
