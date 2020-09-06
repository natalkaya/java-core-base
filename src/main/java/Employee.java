public class Employee {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final Integer salary;
    private final Integer age;

    public Integer getAge() {
        return age;
    }

    public Employee(
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            Integer salary,
            Integer age
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printToConsole() {
        System.out.printf("Employee info: " +
                        "firstName = %s, " +
                        "lastName = %s, " +
                        "email = %s, " +
                        "phoneNumber = %s, " +
                        "salary = %d, " +
                        "age = %d\n",
                this.firstName,
                this.lastName,
                this.email,
                this.phoneNumber,
                this.salary,
                this.age);
    }
}