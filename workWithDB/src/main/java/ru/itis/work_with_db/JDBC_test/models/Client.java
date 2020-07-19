package ru.itis.work_with_db.JDBC_test.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "dbTest_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String phone;

    @OneToOne()
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @ManyToMany
    @JoinTable(name = "db_client_bank",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "id"))
    private List<Bank> banks;
}
