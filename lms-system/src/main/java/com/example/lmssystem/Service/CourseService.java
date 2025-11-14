package com.example.lmssystem.Service;

import com.example.lmssystem.Model.Course;
import com.example.lmssystem.Model.Teacher;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;

@Service
public class CourseService {

    ArrayList<Course> courses = new ArrayList<>();

    //get all courses
    public ArrayList<Course> getCourses () {
        return courses;
    }


    //add new course
    public void addCourse (Course course) {
        courses.add(course);
    }



    //update course by id
    public boolean updateCourse (String id, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(id)) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }



    //delete course by id
    public boolean  deleteCourse (String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(id)) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }



    //search for a course by category
    public ArrayList<Course> getByCategory (String category) {
        ArrayList<Course> categories = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCategory().equals(category)) {
                categories.add(courses.get(i));
             }
        }
        return categories;
    }



    //get the course teacher by course id
    public Teacher getCourseTeacher (String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(id)) {
                return courses.get(i).getTeacher();
            }
        }
        return null;
    }




    //get the courses by rang of capacity
    public ArrayList<Course> getByCapacity (int minNum, int maxNum) {
        ArrayList<Course> numbers = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCapacity() <= maxNum && courses.get(i).getCapacity() >= minNum) {
                numbers.add(courses.get(i));
            }
        }
        return numbers;
    }




    //update course capacity by id
    public boolean updateCapacity (String id, int capacity) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(id)) {
                courses.get(i).setCapacity(capacity);
                return true;
            }
        }
        return false;
    }





}
