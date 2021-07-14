package org.app.service;

import org.app.model.School;
import org.app.model.Student;

import java.util.*;

public class StudentService {
    private static final Map<Long, List<Student>> studentsBySchoolIndex = new HashMap<>();
    private static final NavigableMap<Long, Student> studentsByIndex = new TreeMap<>();

    public StudentService() {
        Long schoolIndexFirst = (long) 1;
        Long schoolIndexSecond = (long) 2;

        Student studentGeorge = new Student((long) 0, "George",
                "Lucas",
                11,
                new School(schoolIndexFirst));

        Student studentLina = new Student((long) 1, "Lina",
                "Higgi",
                15,
                new School(schoolIndexFirst));

        Student studentJara = new Student((long) 2, "Jara",
                "Kuomo",
                17,
                new School(schoolIndexSecond));

        studentsByIndex.put(studentGeorge.getId(), studentGeorge);
        studentsByIndex.put(studentLina.getId(), studentLina);
        studentsByIndex.put(studentJara.getId(), studentJara);

        List<Student> studentsFirstSchool = new ArrayList<>();
        studentsFirstSchool.add(studentGeorge);
        studentsFirstSchool.add(studentLina);

        List<Student> studentsSecondSchool = new ArrayList<>();
        studentsSecondSchool.add(studentJara);

        studentsBySchoolIndex.put(schoolIndexFirst, studentsFirstSchool);
        studentsBySchoolIndex.put(schoolIndexSecond, studentsSecondSchool);
    }

    public List<Student> getListOfStudents() {

        for (Map.Entry<Long, Student> studentEntry: studentsByIndex.entrySet()) {
            System.out.println(studentEntry.getKey() + " " + studentEntry.getValue().toString());
        }
        return new ArrayList<>(studentsByIndex.values());
    }

    public Optional<Student> getStudentOrEmpty(Long id) {
        return Optional.ofNullable(studentsByIndex.get(id));
    }

    public Long addStudent(Student student) {
        Long index = studentsByIndex.ceilingKey(Long.MIN_VALUE);

        studentsByIndex.put(index, student);

        getListOfStudents();

        return index;
    }

    public boolean deleteStudent(Long id) {

        if (studentsByIndex.containsKey(id)) {

            studentsByIndex.remove(id);

            return true;

        } else {
            return false;
        }
    }

    public Optional<Student> updateStudentIfExists(Long id,
                                                   Student student) {

        if (studentsByIndex.containsKey(id)) {

            System.out.println("FOUND: " + studentsByIndex.get(id));
            studentsByIndex.put(id, student);
            System.out.println("ALTERED: " + studentsByIndex.get(id));

            return Optional.of(studentsByIndex.get(id));

        } else {

            return Optional.empty();
        }
    }
}
