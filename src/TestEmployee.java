public class TestEmployee extends Test{

    EmployeeService employeeService;

    public TestEmployee() {
        employeeService = new EmployeeService(EmployeeFactory.generate(10));

        System.out.println("---- Sort employees by name");
        employeeService.sortByName().printEmployees();

        System.out.println("---- Sort employees by salary");
        employeeService.sortBySalary().printEmployees();

        System.out.println("---- Employees total salary with bonus:");
        System.out.println(employeeService.calculateSalaryAndBonus());

        System.out.println("---- Get by id 5: ");
        System.out.println(employeeService.getById(5));

        testEmployeeServiceEdit();

        System.out.println("---- Get by name \"Emma\"");
        employeeService.getByName("Emma").printEmployees();

        testEmployeeServiceRemove();

        System.out.println("---- Array after tests: ");
        employeeService.printEmployees();

    }

    public void testEmployeeServiceEdit() {
        String testId = "employeeService.edit()";
        Employee expected = new Employee(5, "Emma", 33,1000,
                Gender.FEMALE, 10, 44.2);
        employeeService.edit(expected);
        Employee actual = employeeService.getById(5);
        assertEquals(testId, expected, actual);
    }

    public void testEmployeeServiceRemove() {
        String testId = "employeeService.remove()";
        employeeService.remove(4);
        Employee actual = employeeService.getById(4);
        assertEquals(testId, null, actual);
    }

}
