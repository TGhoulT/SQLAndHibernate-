//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "linked_purchase_list")
//public class LinkedPurchaseList {
//    @Id
//    @Column(name = "student_id")
//    private int studentId;
//    @Column(name = "course_id")
//    private int courseId;
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }
//
//    @Override
//    public String toString() {
//        return "LinkedPurchaseList{" +
//                "studentId=" + studentId +
//                ", courseId=" + courseId +
//                '}';
//    }
//}


import jakarta.persistence.*;

@Entity
@Table(name = "linked_purchase_list")
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListId id;

    public LinkedPurchaseList() {}

    public LinkedPurchaseList(LinkedPurchaseListId id) {
        this.id = id;
    }

    public LinkedPurchaseListId getId() {
        return id;
    }

    public void setId(LinkedPurchaseListId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LinkedPurchaseList{" +
                "studentId=" + id.getStudentId() +
                ", courseId=" + id.getCourseId() +
                '}';
    }
}
