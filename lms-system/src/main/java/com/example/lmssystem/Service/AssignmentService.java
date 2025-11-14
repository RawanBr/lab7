package com.example.lmssystem.Service;

import com.example.lmssystem.Controller.AssignmentController;
import com.example.lmssystem.Model.Assignment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class AssignmentService {

    ArrayList<Assignment> assignments = new ArrayList<>();


    //get all assignments
    public ArrayList<Assignment> getAssignments () {
        return assignments;
    }



    //add new assignments
    public void addAssignment (Assignment assignment) {
        assignments.add(assignment);
    }



    //update assignments by id
    public boolean updateAssignment (String id, Assignment assignment) {
        for (int i = 0 ; i < assignments.size(); i++) {
            if (assignments.get(i).getId().equals(id)) {
                assignments.set(i,assignment);
                return true;
            }
        }
        return false;
    }



    //delete assignments by id
    public boolean deleteAssignment (String id) {
        for (int i = 0 ; i < assignments.size(); i++) {
            if (assignments.get(i).getId().equals(id)) {
                assignments.remove(i);
                 return true;
            }
        }
        return false;
    }



    //get all assignments with the same course id
    public ArrayList<Assignment> getAssignmentByCourseId (String id) {
        ArrayList<Assignment> courseAssi = new ArrayList<>();

        for (int i = 0 ; i < assignments.size(); i++) {
            if (assignments.get(i).getCourse().getCourseId().equals(id)) {
                courseAssi.add(assignments.get(i));
            }
        }
        return courseAssi;
    }



    //get expired assignment
    public ArrayList<Assignment> getExpiredAssignment() {
        LocalDate today = LocalDate.now();
        ArrayList<Assignment> expired = new ArrayList<>();

        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getDueDate().isBefore(today)) {
                expired.add(assignments.get(i));
            }
        }
        return expired;
    }



    //get assignment by id
    public Assignment getAssignmentsById (String id) {
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getId().equals(id)) {
                return assignments.get(i);
            }
        }
        return null;
    }



    //update assignment title
    public boolean updateTitle (String id, String title) {
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getId().equals(id)) {
                assignments.get(i).setTitle(title);
                return true;
            }
        }
        return false;
    }


}
