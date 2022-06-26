package com.example.comsumerApp.modeller.Partner;



import javax.persistence.*;

@Entity (name = "Student")
@Table(
        name = "student"
)
public class Partner {

    @Id

    @SequenceGenerator(
            name = "sequence_name",
            sequenceName = "sequence_name",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_name"
    )


//    @Column (
//            name = "id",
//            updatable = false
//    )
    private long ID;

//    @Column(
//            name = "first_name",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
    private String partnerName;




    public Partner(String partnerName) {
        this.partnerName = partnerName;

    }

    public Partner() {

    }

    public Partner(long ID, String partnerName) {
        this.ID = ID;
        this.partnerName = partnerName;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String firstName) {
        this.partnerName = firstName;
    }



    @Override
    public String toString() {
        return "student{" +
                "ID=" + ID +
                ", firstName='" + partnerName + '\'' +
                '}';
    }
}
