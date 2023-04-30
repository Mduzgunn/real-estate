package com.md.estate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(name = "home_phone_number")
    private String homePhoneNumber;

    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Estate> estates;

    public Customer(String name, String surname, String homePhoneNumber, String mobilePhoneNumber,
                    String emailAddress, Business business, List<Estate> estates) {
        this.name = name;
        this.surname = surname;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailAddress = emailAddress;
        this.business = business;
        this.estates = estates;

    }

    public Customer(String name, String surname, String homePhoneNumber,
                    String mobilePhoneNumber, String emailAddress) {
        this.name = name;
        this.surname = surname;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailAddress = emailAddress;
    }
}
