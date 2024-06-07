import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Infinity cycle for input.
//        Get course Java-developer!
//        String text = "";
//        while (!text.equals("Java-разработчик")) {
//            System.out.println("Input search course: ");
//            text = new Scanner(System.in).nextLine();
//            if (text.equals("Java-разработчик")) {
//
//                Course course = session.get(Course.class, "Java-разработчик");
//                System.out.println(course.toString());
//            }
//        }

//        Course course = session.get(Course.class, "Java-разработчик");
//        Teacher teacher =  course.getTeacher();
//        System.out.println("Information about teacher: " + teacher.toString());

//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Subscription> courseCriteriaQuery = criteriaBuilder.createQuery(Subscription.class);
//        Root<Subscription> root = courseCriteriaQuery.from(Subscription.class);
//        courseCriteriaQuery.select(root);
//        List<Subscription> purchasesList = session.createQuery(courseCriteriaQuery).getResultList();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> courseCriteriaQuery = criteriaBuilder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = courseCriteriaQuery.from(PurchaseList.class);
        courseCriteriaQuery.select(root);
        List<PurchaseList> purchasesList = session.createQuery(courseCriteriaQuery).getResultList();
        try {
            purchasesList.forEach(pL -> {
//                LinkedPurchaseListId id = new LinkedPurchaseListId(pL.getStudentId(), pL.getCourseId());
//                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(id);
//
//                session.save(linkedPurchaseList);
//                session.flush();
//                session.clear();
//
//                System.out.println(linkedPurchaseList);
                PurchaseListId id = new PurchaseListId(pL.getPurchaseListId().getStudentName(), pL.getPurchaseListId().getCourseName());
                PurchaseList linkedPurchaseList = new PurchaseList(id);

                System.out.println(linkedPurchaseList);
                session.save(linkedPurchaseList);
                session.flush();
                session.clear();


            });
        } catch (Exception ex) {
            ex.getMessage();
        }

//        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
//        Student student = new Student();
//        student.setName("Vasya");
//        Course course = new Course();
//        course.setName("Java and Python");
//        for (int i = 0; i < 10; i++) {
//            Course currentCourse = session.get(Course.class, "Java-разработчик");
//            System.out.println("Course id: " + currentCourse.getId() + "\nCourse name: " + currentCourse.getName());
//        }
//        linkedPurchaseList.setStudentId(currentCourse.getId());
//        linkedPurchaseList.setCourseId(currentCourse.getId());

        transaction.commit();
        sessionFactory.close();
    }
}













