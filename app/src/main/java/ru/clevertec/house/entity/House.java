package ru.clevertec.house.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "house")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", unique = true, nullable = false)
    private String uuid;

    @Column(name = "area")
    private String area;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "create_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate ;

    @OneToMany(mappedBy = "house")
    private Set<Person> residents;

    @OneToMany(mappedBy = "ownedHouse")
    private Set<Person> owners;

    @PrePersist
    protected void onCreate() {
        createDate = new Date();
    }

}