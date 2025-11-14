package com.example.lmssystem.Service;

import com.example.lmssystem.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers () {
        return teachers;
    }


    public void addTeacher (Teacher teacher) {
        teachers.add(teacher);
    }



    public boolean updateTeacher (String id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }


    public boolean deleteTeacher (String id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }


    public Teacher getTeacherById (String id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                return teachers.get(i);
            }
        }
        return null;
    }



    public ArrayList<Teacher> getTeacherBySalary (double salary) {
        ArrayList<Teacher> salaries = new ArrayList<>();

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getSalary() >= salary) {
                salaries.add(teachers.get(i));
            }
        }
        return salaries;
    }










}

