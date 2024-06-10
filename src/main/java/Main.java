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

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> courseCriteriaQuery = criteriaBuilder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = courseCriteriaQuery.from(PurchaseList.class);
        courseCriteriaQuery.select(root);
        List<PurchaseList> purchasesList = session.createQuery(courseCriteriaQuery).getResultList();
        try {
            purchasesList.forEach(pL -> {
                Student student = session.get(Student.class, pL.getPurchaseListId().getStudentName());
                Course course = session.get(Course.class, pL.getPurchaseListId().getCourseName());
                int studentId = student.getId();
                int courseId = course.getId();
                System.out.println("Student id: " + studentId + "\nCourse id: " + courseId);

                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(new LinkedPurchaseListId(studentId, courseId));
                session.save(linkedPurchaseList);
                session.flush();
                session.clear();


            });
        } catch (Exception ex) {
            ex.getMessage();
        }

        transaction.commit();
        sessionFactory.close();
    }
}













