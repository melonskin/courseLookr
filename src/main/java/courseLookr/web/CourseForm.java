package courseLookr.web;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CourseForm {

    private String department;

    private String number;

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Credit cannot be empty")
    @Digits(integer = 2, fraction = 0, message = "Credit must be a reasonable integer")
    @Positive(message = "Credit must be positive")
    private String credit;

    @NotNull(message = "Description cannot be empty")
    @Size(min = 6, message = "Description length cannot be shorter than 6")
    private String description;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
