package ru.itis.work_with_db.JDBC_test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "dbTest_company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long money;

    @ManyToMany
    @JoinTable(name = "db_company_bank",
            joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "id"))
    private List<Bank> banks;
}
