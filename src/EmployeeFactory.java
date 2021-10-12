import java.util.Random;

public class EmployeeFactory {

    static private long id = 0;

    static public Employee generate() {
        Random random = new Random();
        String[] names = {
                "Liam",
                "Olivia",
                "Noah",
                "Emma",
                "Oliver",
                "Ava",
                "William",
                "Sophia",
                "Elijah",
                "Isabella",
                "James",
                "Charlotte",
                "Benjamin",
                "Amelia",
                "Lucas",
                "Mia",
                "Mason",
                "Harper",
                "Ethan",
                "Evelyn"
        };

        String name = names[random.nextInt(names.length)];
        int age = random.nextInt(50) + 18;
        double salary = random.nextDouble() * 1000;
        Gender gender = random.nextBoolean() ? Gender.FEMALE : Gender.MALE;
        int fixedBugs = random.nextInt(30);
        double defaultBugRate = 21.74;

        return new Employee(id++, name, age, salary, gender, fixedBugs, defaultBugRate);
    }

    static public Employee[] generate(int count) {
        Employee[] employees = new Employee[count];
        for (int i = 0; i < employees.length; ++i) {
            employees[i] = generate();
        }
        return employees;
    }
}
