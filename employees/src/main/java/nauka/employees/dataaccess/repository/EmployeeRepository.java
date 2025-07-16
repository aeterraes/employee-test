package nauka.employees.dataaccess.repository;

import nauka.employees.dataaccess.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee WHERE id = :id", nativeQuery = true)
    Optional<Employee> findByIdNative(@Param("id") Long id);

    @Query(value = "SELECT first_name, COUNT(*) FROM employee GROUP BY first_name", nativeQuery = true)
    List<Object[]> groupByName();

    @Query(value = "SELECT * FROM employee WHERE birth_date BETWEEN :from AND :to", nativeQuery = true)
    List<Employee> findBetweenBirthDates(@Param("from") LocalDate from, @Param("to") LocalDate to);
}