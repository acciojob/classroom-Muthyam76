package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    private HashMap<String,Student> studentMap=new HashMap<>();
    private HashMap<String,Teacher> teacherMap=new HashMap<>();

    private HashMap<String, List<String>>teacherStudentMap=new HashMap<>();
    public void addStudent(Student student) {
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(),teacher);
    }

    public void addTeacherStudent(String student, String teacher) {
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
           // studentMap.put(student, studentMap.get(student));
           // teacherMap.put(teacher, teacherMap.get(teacher));
            List<String> currentPair = new ArrayList<String>();
            if(teacherStudentMap.containsKey(teacher)) currentPair = teacherStudentMap.get(teacher);
            currentPair.add(student);
            teacherStudentMap.put(teacher, currentPair);
        }
    }

    public Student getStudentData(String name) {
        return studentMap.get(name);
    }

    public Teacher getTeacherData(String name) {
        return teacherMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String>studentsList=new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)){
            studentsList=teacherStudentMap.get(teacher);
        }
        return studentsList;

    }

    public List<String> getAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacherByName(String teacher) {
        List<String> data = new ArrayList<String>();
        if(teacherStudentMap.containsKey(teacher)){
            data = teacherStudentMap.get(teacher);
            for(String student: data){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }

            teacherStudentMap.remove(teacher);

        }

        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }

    }

    public void deleteAllTeachers() {
        HashSet<String> studentSet = new HashSet<String>();

        //directorMap = new HashMap<>();
        HashSet<String>teacherSet=new HashSet<>();

       for(String teacher: teacherStudentMap.keySet()){
           teacherSet.add(teacher);
            for(String student: teacherStudentMap.get(teacher)){
                studentSet.add(student);
            }
        }
        for(String student: studentSet){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
        for(String teacher: teacherSet){
            if(teacherMap.containsKey(teacher)){
                teacherMap.remove(teacher);
            }
        }
        teacherStudentMap.clear();


    }
}
