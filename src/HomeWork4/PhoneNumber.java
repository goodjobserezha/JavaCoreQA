package HomeWork4;

public class PhoneNumber {

    public final Long number;
    public final String lastName;

    public PhoneNumber(Long number, String lastName) {
        this.number = number;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number=" + number +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}