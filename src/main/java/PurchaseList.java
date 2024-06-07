import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
    @EmbeddedId
    private PurchaseListId purchaseListId;

    public PurchaseList() {}

    public PurchaseList(PurchaseListId purchaseListId) {
        this.purchaseListId = purchaseListId;
    }

    public PurchaseList(LinkedPurchaseListId purchaseListId) {
    }

    public PurchaseListId getPurchaseListId() {
        return purchaseListId;
    }

    public void setPurchaseListId(PurchaseListId purchaseListId) {
        this.purchaseListId = purchaseListId;
    }

    @Override
    public String toString() {
        return "PurchaseList{" +
                "studentName=" + purchaseListId.getStudentName() +
                ", courseName=" + purchaseListId.getCourseName() +
                '}';
    }
}
