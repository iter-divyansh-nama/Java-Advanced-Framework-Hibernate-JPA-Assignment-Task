package java_dev.framework.hibernate_jpa.main;
import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java_dev.framework.hibernate_jpa.entity.Employee;
import java_dev.framework.hibernate_jpa.entity.Student;

public class JavaApp {
public static void execution() {
	EntityManagerFactory entitiyManagerFactory=Persistence.createEntityManagerFactory("Student");
	EntityManager entityManager = entitiyManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	
	Student student1 =new Student();
	student1.setId(1);
	student1.setName("raja");
	student1.setMailId("raja@gmail.com");
	student1.setContactNumber(987654l);
	
	Student student2 =new Student();
	student2.setId(2);
	student2.setName("rani");
	student2.setMailId("rani@gmail.com");
	student2.setContactNumber(941654l);
	
	//entityManager.persist(student1);
	//entityManager.persist(student2);
	
	Student student= entityManager.find(Student.class, 1);

	if(student != null) {
	System.out.println(student);
	student.setMailId("king@gmail.com");
	student.setContactNumber(4848734l);
	entityManager.merge(student);
	}
	else {
		System.out.println("student data not found");
	}
	entityTransaction.commit();
	entityManager.close();
	System.out.println("Hello world.");
}

public static void execution1() {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    Scanner sc = new Scanner(System.in);

    et.begin();

    System.out.print("Enter number of employees to create: ");
    int n = sc.nextInt();

    for(int i = 0; i < n; i++) {

        Employee emp = new Employee();

        System.out.print("Enter Employee ID: ");
        emp.setId(sc.nextInt());

        System.out.print("Enter Name: ");
        emp.setName(sc.next());

        System.out.print("Enter Mail ID: ");
        emp.setMailId(sc.next());

        System.out.print("Enter Contact Number: ");
        emp.setContactNumber(sc.nextLong());

        em.persist(emp);
    }

    et.commit();

    // READ (find)
    System.out.print("\nEnter Employee ID to search: ");
    int id = sc.nextInt();

    Employee employee = em.find(Employee.class, id);

    if(employee != null) {

        System.out.println("Employee Found:");
        System.out.println(employee);

        // UPDATE
        et.begin();

        System.out.print("Enter new mail id: ");
        employee.setMailId(sc.next());

        System.out.print("Enter new contact number: ");
        employee.setContactNumber(sc.nextLong());

        em.merge(employee);

        et.commit();

        System.out.println("Employee Updated Successfully");

        // DELETE
        System.out.print("\nDo you want to delete this employee? (yes/no): ");
        String choice = sc.next();

        if(choice.equalsIgnoreCase("yes")) {

            et.begin();

            em.remove(employee);

            et.commit();

            System.out.println("Employee Deleted Successfully");
        }

    }
    else {
        System.out.println("Employee not found");
    }

    em.close();
    emf.close();
}

}