package nauka.employees.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import nauka.employees.dataaccess.model.Employee;
import nauka.employees.dataaccess.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public Optional<Employee> findById(Long id) {
        return repository.findByIdNative(id);
    }

    public List<Object[]> groupByName() {
        return repository.groupByName();
    }

    public List<Employee> findBetween(LocalDate from, LocalDate to) {
        return repository.findBetweenBirthDates(from, to);
    }
}