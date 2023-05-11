import java.time.LocalDate;
import java.time.Period;

class Customer {
    public String name;
    public String address;
    public String dateOfBirth;
    public String PIN;

    public Customer(String name, String address, String dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.PIN = "";
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String pin) {
        this.PIN = pin;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(dateOfBirth);
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
}
