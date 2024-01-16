package org.example.springProject.data;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NonNull
public class EmployeeWeb {
    private Long employeeId;

    private String employeeName;

    private String employeeAge;

    private LocalDate employeeDOB;
    private LocalDate joiningDate;

    private String daysWorked;

    private String emailId;
}
