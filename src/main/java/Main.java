import InheritanceMapping.Module;
import InheritanceMapping.Project;
import InheritanceMapping.Task;
import ManyToMany.Delegates;
import ManyToMany.Event;
import ManyToOne.College;
import ManyToOne.Student;
import OneToOne.Person;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        //type code here
//        OneToOne.PersonDetails alexDetail = new OneToOne.PersonDetails();
//        alexDetail.setIncome(23451.21);
//        alexDetail.setJob("Accountant");
//        alexDetail.setZipCode("20213");
//
//        OneToOne.Person alex = new OneToOne.Person();
//        alex.setPersonName("Alex Barry");
//        alex.setpDetails(alexDetail);
//
//        entityManager.persist(alex);

//        College college1 = new College();
//        college1.setCollegeName("My ManyToOne.College");
//
//        Student s1= new Student();
//        s1.setStudentName("Alex Rod");
//
//        Student s2= new Student();
//        s2.setStudentName("Linda Berry");
//
//        s1.setCollege(college1);
//        s2.setCollege(college1);
//
//        entityManager.persist(college1);
//        entityManager.persist(s1);
//        entityManager.persist(s2);

//        Project project = new Project();
////        project.setProjectName("Hibernate Lessons");
////
////        Module module = new Module();
////        module.setProjectName("Spring Lessons");
////        module.setModuleName("AOP");
////
////        Task task = new Task();
////        task.setProjectName("Java lessons");
////        task.setModuleName("Collections");
////        task.setTaskName("ArrayList");
////
////        entityManager.persist(project);
////        entityManager.persist(module);
////        entityManager.persist(task);

//        Delegates delegate1 = new Delegates();
//        delegate1.setDelegateName("Alex Rod");
//
//        Delegates delegate2 = new Delegates();
//        delegate2.setDelegateName("Linda Berry");
//
//        Delegates delegate3 = new Delegates();
//        delegate3.setDelegateName("John Doe");
//
//        Event event1 = new Event();
//        event1.setEventName("Java-101");
//        Event event2 = new Event();
//        event2.setEventName("C++ - 101");
//        Event event3 = new Event();
//        event3.setEventName("Math -101");
//
//        event1.getDelegates().add(delegate1);
//        event1.getDelegates().add(delegate2);
//        event1.getDelegates().add(delegate3);
//
//        event2.getDelegates().add(delegate2);
//        event2.getDelegates().add(delegate3);
//
//        event3.getDelegates().add(delegate1);
//
//        entityManager.persist(delegate1);
//        entityManager.persist(delegate2);
//        entityManager.persist(delegate3);
//
//        entityManager.persist(event1);
//        entityManager.persist(event2);
//        entityManager.persist(event3);
//        entityManager.getTransaction().commit();
//        entityManagerFactory.close();
        Query query = entityManager.createQuery("select p from Person p");
        ArrayList<Person> lists = new ArrayList();
        lists = (ArrayList<Person>) query.getResultList();
        lists.forEach(results-> {
            System.out.println(results.getPersonName() + " ");
        });
    }
}
