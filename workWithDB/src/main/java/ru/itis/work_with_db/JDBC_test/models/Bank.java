package ru.itis.work_with_db.JDBC_test.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "dbTest_banks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bank {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String phone;

    @ManyToMany(mappedBy = "banks")
    private List<Client> clients;

    @ManyToMany(mappedBy = "banks")
    private List<Company> companies;

    @OneToMany(mappedBy = "bank")
    private List<Employee> employees;

    @OneToMany(mappedBy = "bank")
    private List<ATM> atms;
}
