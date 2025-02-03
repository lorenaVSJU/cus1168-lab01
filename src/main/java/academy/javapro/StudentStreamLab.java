package academy.javapro;

import java.util.*;
import java.util.stream.*;

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // TODO - Filtering: Students with GPA > 3.0
        List<Student> filteredStudents = students.stream()
                                                .filter(student -> student.getGpa() > 3.0)
                                                .collect(Collectors.toList());
        System.out.println("Students with GPA > 3.0: ");
        filteredStudents.forEach(System.out::println);

        // TODO - Mapping: Extract names of students with GPA > 3.0
        List<String> studentNames = students.stream()
                                            .filter(student -> student.getGpa() > 3.0)
                                            .map(Student::getName)
                                            .collect(Collectors.toList());
        System.out.println("\nHigh GPA student names:");
        studentNames.forEach(System.out::println);


        // TODO - Reducing: Calculate the average GPA of all students
        OptionalDouble averageGPA = students.stream()
							                 .mapToDouble(Student::getGpa)
							                 .average();
		System.out.println("\nAverage GPA: " + averageGPA.orElse(0.0));
        


        // TODO Collecting: Collect all "Junior" students into a list
        List<Student> juniors = students.stream()
						                 .filter(student -> "Junior".equals(student.getCollegeYear()))
						                 .collect(Collectors.toList());
		System.out.println("\nJuniors:");
		juniors.forEach(System.out::println);
    }
}
