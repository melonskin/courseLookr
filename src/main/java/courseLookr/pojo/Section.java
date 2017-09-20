package courseLookr.pojo;

public class Section {
    private final String number;
    private final String instructor;
    private final String term;
    private final String year;
    private final double gpa;
    private final int student;
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double f;
    private final double q;
    private final int course_id;

    public Section(String number, String instructor,
                   String term, String year,
                   double gpa, int student,
                   double a, double b, double c,
                   double d, double f, double q,
                   int course_id) {
        this.number = number;
        this.instructor = instructor;
        this.term = term;
        this.year = year;
        this.gpa = gpa;
        this.student = student;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.q = q;
        this.course_id = course_id;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getF() {
        return f;
    }

    public double getGpa() {
        return gpa;
    }

    public double getQ() {
        return q;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getStudent() {
        return student;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getNumber() {
        return number;
    }

    public String getTerm() {
        return term;
    }

    public String getYear() {
        return year;
    }
}
