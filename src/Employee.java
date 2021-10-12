public class Employee {
    private long id;
    private String name;
    private int age;
    private double salary;
    private Gender gender;
    private int fixedBugs;
    private double defaultBugRate;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(long id, String name, int age, double salary,
                    Gender gender, int fixedBugs, double defaultBugRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.fixedBugs = fixedBugs;
        this.defaultBugRate = defaultBugRate;
    }

    public Employee clone()  {
        return new Employee(id, name, age, salary, gender, fixedBugs, defaultBugRate);
    }

    @Override
    public String toString() {
        return "ID:\t" + id + "\n" +
                "Name:\t" + name + "\n" +
                "Age:\t" + age + "\n" +
                "Salary:\t" + salary + "\n" +
                "Gender:\t" + gender + "\n" +
                "Fixed bugs:\t" + fixedBugs + "\n" +
                "Default bug rate:\t" + defaultBugRate + "\n";
    }

    public double totalSalary() {
        return salary + (fixedBugs * defaultBugRate);
    }

}

