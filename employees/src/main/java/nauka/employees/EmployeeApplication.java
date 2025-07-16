package nauka.employees;

import lombok.RequiredArgsConstructor;
import nauka.employees.dataaccess.model.Employee;
import nauka.employees.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class EmployeeApplication {

    private final EmployeeService employeeService;

    public EmployeeApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println("Пример поиска сотрудника по ID");
            Long idToFind = 1L;
            Optional<Employee> employeeOpt = employeeService.findById(idToFind);
            employeeOpt.ifPresentOrElse(
                    e -> System.out.println("Найден: " + e.getFirstName() + " " + e.getLastName()),
                    () -> System.out.println("Сотрудник с ID " + idToFind + " не найден")
            );
            System.out.println("Пример группировки по имени");
            List<Object[]> grouped = employeeService.groupByName();
            for (Object[] row : grouped) {
                System.out.println("Имя: " + row[0] + ", Количество: " + row[1]);
            }

            System.out.println("\nПример поиска по диапазону дат рождения");
            LocalDate from = LocalDate.of(2000, 1, 1);
            LocalDate to = LocalDate.of(2004, 12, 31);
            List<Employee> employees = employeeService.findBetween(from, to);
            for (Employee emp : employees) {
                System.out.println(emp.getFirstName() + " " + emp.getLastName() +
                        " — " + emp.getBirthDate());
            }
        };
    }
}
