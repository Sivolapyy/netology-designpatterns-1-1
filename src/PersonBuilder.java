public class PersonBuilder {

    private String name = "";
    private String surname = "";
    private int age = -1;
    private String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Ошибка! Возраст не может быть меньше нуля!");
        }

        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name.isEmpty() || this.surname.isEmpty()) {
            throw new IllegalStateException("Ошибка! Имя и Фамилия должны быть указаны обязательно!");
        }

        Person person = new Person(this.name, this.surname, this.age);
        person.setAddress(this.address);

        return person;
    }

}