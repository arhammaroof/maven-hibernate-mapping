import ManyToMany.Event;
import ManyToOne.College;
import ManyToOne.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;


import javax.persistence.*;
import javax.persistence.criteria.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

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
//        project.setProjectName("Hibernate Lessons");
//
//        Module module = new Module();
//        module.setProjectName("Spring Lessons");
//        module.setModuleName("AOP");
//
//        Task task = new Task();
//        task.setProjectName("Java lessons");
//        task.setModuleName("Collections");
//        task.setTaskName("ArrayList");
//
//        entityManager.persist(project);
//        entityManager.persist(module);
//        entityManager.persist(task);

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


//        Query query = entityManager.createQuery("select p.personName from Person p");
//        ArrayList<String> lists = new ArrayList();
//        lists = (ArrayList<String>) query.getResultList();
//        lists.forEach(results-> {
//            System.out.println(results.toString() + " ");
//        };

        /**
         * query to get all the fields of a record
         * queries are stored as a String in createQuery method
         * we can use list of our objects(i.e Event in our case )to retrieve all the records from a table into Our object list.
         */

//        Query query = entityManager.createQuery("select e from Event e");
//
//        ArrayList<Event> lists= (ArrayList<Event>) query.getResultList();
//        lists.forEach(results-> {
//            System.out.println(results.getEventName() + " " + results.getDelegateName());
//        });


        /**
         * query to pick particular fields from different tables.
         * We need to make a parametrized constructor in our Entity class to hand pick the fields we'd like to retrieve from the table
         * for instance we can make a constructor in our Event class that takes only the event name.
         * we can the write hql/jpql using the new keyword to create abject according to our desired result. (in this case create an Event object with parametrized constructor which takes event name as argument)
         * If we want to retrieve multiple tables from the database we can create a custom class which does not need to be an entity class and create a constructor having parameters of our desired fields
         * In the code below we have Used Result class to retrieve event name and delegate name from event and delegate table.
         */
//        Query query = entityManager.createQuery("select new ManyToMany.Result(e.eventName, d.delegateName)" + "from Event e, Delegates d");
//
//        ArrayList<Result> lists= (ArrayList<Result>) query.getResultList();
//        lists.forEach(results-> {
//            System.out.println(results.getEventName() + " " + results.getDelegateName());
//        });

        /**
         * Criteria Builder Query
         * These are used when we want to build a dynamic query based on filters user fills at runtime.
         * Since it detects the error at compile time. Runtime query error can not occur.
         * The CriteriaBuilder interface serves as the main factory of criteria queries and criteria query elements.
         * It can be obtained either by the EntityManagerFactory's getCriteriaBuilder method or by the EntityManager's getCriteriaBuilder method (both methods are equivalent).
         * Root instance is created to define range variable in the FROM clause.
         * The ParameterExpression instance, p, is created to represent the query parameter. The where method sets the WHERE clause.
         * Criteria Builder has this range of methods for comparison in the where clause(in our case, cb.equal() is used)
         * Criteria query requires typedQuery instance for running because when we Create a CrtiteriaQuery we need to mention the type of object it is going to return
         */

//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Event> q = cb.createQuery(Event.class);
//        Root<Event> c = q.from(Event.class);
//        ParameterExpression<Integer> p = cb.parameter(Integer.class);
//        q.select(c).where(cb.equal(c.get("eventId"), 35));
//
//        TypedQuery<Event> query = entityManager.createQuery(q);
//        List<Event> results = query.getResultList();
//        results.forEach(result->{
//            System.out.println(result.getEventName() + " "  + result.getEventId());
//        });


        /**
         * Joining through HQL
         */

//       Query query = entityManager.createQuery("select new ManyToOne.Result(c.collegeName, s.studentName)" + "from College c inner join Student s on s.college.collegeId = c.collegeId");
//        ArrayList<Result> lists = (ArrayList<Result> ) query.getResultList();
//        lists.forEach(results-> {
//            System.out.println(results.getCollegeName()+ " " + results.getStudentName());
//        });
        /**
         * Joining through Criteria Api
         */
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<College> query = cb.createQuery(College.class);
//        Root<Student> student = query.from(Student.class);
//        Join<Student, College> college = student.join("college");
//        query.select(college);
//
//        List<College> results = entityManager.createQuery(query).getResultList();
//        for (College college1 : results) {
//            System.out.println(college1.toString());
//        }

        /**
         * Criteria multiselect example
         */
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
//        Root<College> rootCol = criteriaQuery.from(College.class);
//        Root<Student> rootStu = criteriaQuery.from(Student.class);
//        criteriaQuery.multiselect(rootCol,rootStu);
//        criteriaQuery.where(builder.equal(rootStu.get("college"), rootCol.get("collegeId")));
//        Query<Object[]> query = (Query<Object[]>) entityManager.createQuery(criteriaQuery);
//        List<Object[]> lists = query.getResultList();
//        for(Object[] objects: lists){
//            College college = (College) objects[0];
//            System.out.println(college.getCollegeName()+ " " );
//            Student student = (Student) objects[1];
//            System.out.println(student.getStudentName());
//        }
        /**
         * projection example.
         */
//        Session session = (Session) entityManager.getDelegate();
//        Criteria criteria = session.createCriteria(Event.class);
//        criteria.setProjection(Projections.property("eventName"));
//        List<String> list1 = criteria.list();
//        for (String s: list1){
//            System.out.println("Event name == " + s);
//        }

        /**
         * Projection through JPA
         * Using JPQL
         */
//        Query query = entityManager.createQuery("Select name from Product");
//        List<String> resultList = query.getResultList();
//        System.out.println(resultList);

        /**
         * Using criteria builder
         */
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<String> query = builder.createQuery(String.class);
//        Root<Product> product = query.from(Product.class);
//        query.select(product.get("name"));
//        List<String> resultList = entityManager.createQuery(query).getResultList();
//
//        System.out.println(resultList);

        /**
         * Multi-Column projection JPQL
         */
//        Query query = entityManager.createQuery("select productId, name, Description from Product");
//        List resultList = query.getResultList();

        /**
         * Multi Column projection Criteria builder
         */
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Product> query = builder.createQuery(Product.class);
//        Root<Product> product = query.from(Product.class);
//        query.multiselect(product.get("productId"), product.get("name"), product.get("Description"));
//        List<Product> resultList = entityManager.createQuery(query).getResultList();
//        System.out.println(resultList);
//        for(Object[] objects: resultList){
//           long productid = (long) objects[0];
//           String name = (String) objects[1];
//           String description = (String) objects[2];
//            System.out.println(productid + "\t" + name + "\t" + description);
//        }
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}