package courseLookr.pojo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Course {
    private final int id;
    private final String department;
    private final String number;
    @NotNull
    @Size(min = 6)
    private final String name;
    @NotNull
    @Digits(integer = 2, fraction = 0)
    @Positive
    private final String credit;
    @NotNull
    @Size(min = 6)
    private final String description;

    public Course(
            int id, String department, String number,
            String name, String credit, String description) {
        this.id = id;
        this.department = department;
        this.number = number;
        this.name = name;
        this.credit = credit;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public String getName() { return name; }

    public String getCredit() {
        return credit;
    }

    public String getDescription() {
        return description;
    }
}
