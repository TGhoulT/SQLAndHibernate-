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
        CriteriaQuery<Subscription> courseCriteriaQuery = criteriaBuilder.createQuery(Subscription.class);
        Root<Subscription> root = courseCriteriaQuery.from(Subscription.class);
        courseCriteriaQuery.select(root);
        List<Subscription> purchasesList = session.createQuery(courseCriteriaQuery).getResultList();
        try {
            purchasesList.forEach(pL -> {
                LinkedPurchaseListId id = new LinkedPurchaseListId(pL.getStudentId(), pL.getCourseId());
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(id);

                session.save(linkedPurchaseList);
                session.flush();
                session.clear();

                System.out.println(linkedPurchaseList);
            });
        } catch (Exception ex) {
            ex.getMessage();
        }

        transaction.commit();
        sessionFactory.close();
    }
}













