public class EmployeeService {
    private Employee[] employees;

    public Employee[] getEmployees() {
        return employees;
    }

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    public void printEmployees() {
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public double calculateSalaryAndBonus() {
        double totalSalary = 0;
        for(Employee employee : employees) {
            totalSalary += employee.totalSalary();
        }
        return totalSalary;
    }

    public Employee getById(long id) {
        for(Employee employee : employees) {
            if(employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    public EmployeeService getByName(String name) {
        // List<Employee> better ?
        int employeesCount = 0;
        for(Employee employee : this.employees) {
            if(employee.getName() == name) {
                employeesCount++;
            }
        }

        int i = 0;
        Employee[] employees = new Employee[employeesCount];
        for(Employee employee : this.employees) {
            if(employee.getName().equals(name)) {
                employees[i++] = employee;
            }
        }

        return new EmployeeService(employees);
    }

    public EmployeeService sortByName() {
        Employee[] employees = this.employees.clone();

        for(int i = 0; i < employees.length; ++i) {
            int min = i;
            for(int j = i + 1; j < employees.length; ++j) {
                if(employees[min].getName().compareTo(employees[j].getName()) > 0) {
                    min = j;
                }
            }
            Employee temporary = employees[i] ;
            employees[i] = employees[min];
            employees[min] = temporary;
        }

        return new EmployeeService(employees);
    }

    public EmployeeService sortBySalary() {
        Employee[] employees = this.employees.clone();

        for(int i = 0; i < employees.length; ++i) {
            int min = i;
            for(int j = i + 1; j < employees.length; ++j) {
                if(employees[min].getSalary() > employees[j].getSalary()) {
                    min = j;
                }
            }
            Employee temporary = employees[i] ;
            employees[i] = employees[min];
            employees[min] = temporary;
        }

        return new EmployeeService(employees);
    }

    public Employee edit(Employee to) {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == to.getId()) {
                Employee from = employees[i];
                employees[i] = to;
                return from;
            }
        }

        return null;
    }

    public Employee remove(long id) {
        Employee[] employees = new Employee[this.employees.length - 1];
        Employee deletedEmployee = null;
        int employeesCounter = 0;

        for (int i = 0; i < this.employees.length; i++) {
            if(this.employees[i].getId() == id) {
                deletedEmployee = this.employees[i];
                continue;
            }
            employees[employeesCounter++] = this.employees[i];
        }

        this.employees = employees;

        return deletedEmployee;
    }
}
