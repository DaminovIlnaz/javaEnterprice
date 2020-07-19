package ru.itis.work_with_db.JDBC_test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "dbTest_operation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "atm_id")
    private ATM atm;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Operations operation;


}
