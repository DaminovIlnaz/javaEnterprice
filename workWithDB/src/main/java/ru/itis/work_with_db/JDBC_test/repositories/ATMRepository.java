package ru.itis.work_with_db.JDBC_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.work_with_db.JDBC_test.models.ATM;

public interface ATMRepository extends JpaRepository<ATM,Long> {
}
