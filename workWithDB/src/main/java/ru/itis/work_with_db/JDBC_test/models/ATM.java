package ru.itis.work_with_db.JDBC_test.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "dbTest_atm")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ATM {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany(mappedBy = "atm")
    private List<Operation> operations;
}
