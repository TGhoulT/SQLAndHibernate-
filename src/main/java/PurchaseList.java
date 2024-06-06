import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
    @Id
    @Column(name = "student_name")
    private String studentName;
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Student student;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Column(name = "course_name")
//    private Course course;
    @Column(name = "course_name")
    private String courseName;
    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

//    @Override
//    public String toString() {
//        return "PurchaseList{" +
//                "student=" + student +
//                ", course=" + course +
//                ", price=" + price +
//                ", subscriptionDate=" + subscriptionDate +
//                '}';
//    }
}
