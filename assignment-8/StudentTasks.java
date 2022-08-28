//Jac Assignment -8
//Date : 2/08/2022
//Name: Naman Sharma 
//Sectin: JAC444ZAA
//StudentId: 157151200

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StudentTasks {
	
	public static void main(String[] args) {
		Student[] student = {
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")
		};
			
	//Task -1
		List<Student> studentList = Arrays.asList(student);
		System.out.println("--------TASK 1--------\n");
		System.out.println("Complete Student list:");
		studentList
			.stream()
			.forEach(System.out::println);
		
	//Task-2
		System.out.println("\n--------TASK 2--------\n");
		System.out.println("Students who got 50.0 - 100.0 sorted by grade:");
		studentList
			.stream()
			.sorted(Comparator.comparing(Student::getGrade))
			.filter(stu -> stu.getGrade() >= 50.0 && stu.getGrade() <= 100.0)
			.forEach(System.out::println);
		
	//Task-3
		System.out.println("\n--------TASK 3--------\n");
		System.out.println("First Student who got 50.0 - 100.0:");
		System.out.println(
				studentList
					.stream()
					.findFirst()
					.get()
		);
		
	//Task-4  Ascending
		System.out.println("\n--------TASK 4--------\n");
		System.out.println("Students in ascending order by last name then first:");
		studentList
			.stream()
			.sorted(
					Comparator.comparing(Student::getLastName)
					.thenComparing(Comparator.comparing(Student::getFirstName))
			)
			.forEach(System.out::println);;
		
	//Task-4 Descending 
		System.out.println("\nStudents in descending order by last name then first:");
		studentList
			.stream()
			.sorted(
					Comparator.comparing(Student::getLastName)
					.thenComparing(Comparator.comparing(Student::getFirstName))
					.reversed()
			)
			.forEach(System.out::println);
		
	//Task-5
		System.out.println("\n--------TASK 5--------\n");
		System.out.println("Unique Student last names:");
		studentList
			.stream()
			.map(Student::getLastName)
			.distinct()
			.sorted()
			.forEach(System.out::println);



	//Task-6

	System.out.println("\n----------LAB 9----------"+ "\nTASK 6:\n");
        System.out.println("Student names in order by last name then first name:");
        studentList.stream().sorted(Comparator.comparing(Student::getLastName)
                        .thenComparing(Student::getFirstName))
                        .map(Student::getName)
                        .forEach(System.out::println);

	//Task -7

	System.out.println("\nTASK 7:\n");
        System.out.println("Students by department:");
        Map<String, List<Student>> departmentSort = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment));
        departmentSort.forEach( (element, list) -> {
            System.out.println(element);
            list.forEach(st -> System.out.println("     " + st));
		});

	//Task -8 

	System.out.println("\nTASK 8:\n");
        System.out.println("Count of Students by department:");
        Map<String, Long> count = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        count.forEach( (element, list) ->
                System.out.println(element+" has " +list+" Student(s)"));

	//Task -9

	System.out.println("\nTASK 9:\n");
	DoubleStream sumOfGrades = studentList.stream().mapToDouble(Student::getGrade);
	System.out.println("Sum of Students' grades: "+sumOfGrades.sum());
	

	//Task -10
	System.out.println("\nTASK 10:\n");
	DoubleStream gradeAverage = studentList.stream().mapToDouble(Student::getGrade);
	OptionalDouble average = gradeAverage.average();
	if(average.isPresent())
		System.out.println("Average of Students' grades: " + average.getAsDouble() + "\n\n ---------- END OF WORKSHOP ----------");
	}
}