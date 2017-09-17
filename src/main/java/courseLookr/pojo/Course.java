package courseLookr.pojo;

public class Course {
    private final int id;
    private final String department;
    private final String number;
    private final String name;
    private final String credit;
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
