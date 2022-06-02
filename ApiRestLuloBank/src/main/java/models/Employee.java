package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Employee {

    @JsonProperty("id")
    private String employeeId;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_salary")
    private String employeeSalary;

    @JsonProperty("employee_age")
    private String employeeAge;

    @JsonProperty("profile_image")
    private String profileImage;

    public Employee() {

    }

    public Employee(int id, String name, long salary, int age) {
        this.employeeId = String.valueOf(id);
        this.employeeName = name;
        this.employeeSalary = String.valueOf(salary);
        this.employeeAge = String.valueOf(age);
    }
}
