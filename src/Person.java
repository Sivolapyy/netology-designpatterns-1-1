import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = "";

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age == -1 ? OptionalInt.empty() : OptionalInt.of(age);
    }

    public String getAddress() {
        return hasAddress() ? address : "Не указан";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.age != -1) {
            this.age++;
        } else {
            System.out.println("Возраст не известен!");
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setAddress(this.address);
        childBuilder.setSurname(this.surname);
        return childBuilder;
    }

    @Override
    public String toString() {
        String age = this.age != -1 ? String.valueOf(this.age) : "Не известен";
        String address = hasAddress() ? getAddress() : "Не указан";

        return "Имя: " + name + "\nФамилия:" + surname +
                "\nВозраст: " + age + "\nАдрес: " + address + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

}