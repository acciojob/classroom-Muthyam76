package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addTeacherStudent(String student, String teacher) {
        studentRepository.addTeacherStudent(student,teacher);
    }

    public Student getStudentData(String name) {
        return studentRepository.getStudentData(name);
    }

    public Teacher getTeacherData(String name) {
        return studentRepository.getTeacherData(name);

    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
         studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository. deleteAllTeachers();
    }
}
