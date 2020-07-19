package ru.itis.work_with_db.JDBC_test.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "dbTest_passport")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passport {
    @Id
    @GeneratedValue
    private Long id;
    private Integer series;
    private Integer number;
    private Date whenIssued;
    private String whoIssued;
    private String address;
    private Date dateOfBirth;

    @OneToOne(mappedBy = "passport")
    private Client client;
}
