package com.medicalservices.medical.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(
            generator = "medicineid-sequence"
           )
    @GenericGenerator(
            name = "medicineid-sequence",
            parameters =@org.hibernate.annotations.Parameter(name="prefix",value="medicine"),
            strategy = "com.medicalservices.medical.Idgenerator.MedicalIdGenerator"

    )

    private String id;
    @Column(name = "tablets" )
    private String tablets;
    @Column(name = "NoOfTablets")
    private int NoOfTablets;

    @Column(name = "price")
    private float price;
    public int getNoOfTablets() {
        return NoOfTablets;
    }

    public void setNoOfTablets(int noOfTablets) {
        NoOfTablets = noOfTablets;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTablets() {
        return tablets;
    }

    public void setTablets(String tablets) {
        this.tablets = tablets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Medicine(String id, String tablets, int NoOfTablets,float price) {
        super();
        this.id=id;
        this.tablets=tablets;
        this.NoOfTablets=NoOfTablets;
        this.price=price;
    }
    public Medicine(){
        super();
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", tablets='" + tablets + '\'' +
                ", NoOfTablets=" + NoOfTablets +
                ", price=" + price +
                '}';
    }
}
