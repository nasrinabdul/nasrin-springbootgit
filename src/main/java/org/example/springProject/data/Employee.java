package org.example.springProject.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NonNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@Table(name = "Employee")
@NonNull
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "name", nullable = false)
    private String employeeName;
    @Transient
    private String employeeAge;

   // @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate employeeDOB;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Transient
    private String daysWorked;
    @Column(name = "email_id")
    private String emailId;


    /*public String getDaysWorked() {

     //   return calculateDaysWorked(this.getJoiningDate());
    }

    public String getEmployeeAge() {
      //  return calculateDaysWorked(this.getEmployeeDOB());
    }
*/
    public static String calculateDaysWorked(LocalDate joinDate) {
        Optional<LocalDate> opt = Optional.ofNullable(joinDate);
        if(opt.isPresent()) {
           // long dateDiff = joiningDate.getTime();
            LocalDate now = LocalDate.now();
            //Calendar joinDate = Calendar.getInstance();
            //joinDate.setTime(joiningDate);

            int nowYear = now.getYear();
            int joinYear = joinDate.getYear();
            int years = nowYear-joinYear;

            int nowMonth = now.getMonthValue();
            int joinMonth = joinDate.getMonthValue();
            int months = 0;
            if(joinMonth >= nowMonth) {
                years--;
                months = (12-joinMonth) + nowMonth;
            } else {
                months = nowMonth-joinMonth;
            }
            
            int nowDays = now.getDayOfMonth();
            int joinDays = joinDate.getDayOfMonth();

            int days = 0;
            if(joinDays > nowDays) {
                months--;
                //if(List.of(1,3,5,7,8,10,12).contains(nowMonth)) {
                  //  days = (31-joinDays) - nowDays;
                //}
                days = nowDays;
            } else {
                days = nowDays-joinDays;
            }
            
            return "" + years + "years " + months + "months " + days + "days";
            

           
        }
        return "";

    }
}
