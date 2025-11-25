import java.util.Stack;

public class random {
    public static class Address {
        String city;
        String street;

        public Address(String city, String street) {
            this.city = city;
            this.street = street;
        }

        public Address(Address obj) {
            this.city = obj.city;
            this.street = obj.street;
        }
    }

    public static class Person {
        String name;

        Address address;

        public Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        public Person(Person obj) {
            this.name = obj.name;
            this.address = new Address(obj.address);
        }

        public void display() {
            System.out.println("Name: " + name + ", City: " + address.city + ", Street: " + address.street);
        }
    }

   

    public static void main(String[] args) {
        Address addr1 = new Address("New York", "5th Avenue");
        Person p1 = new Person("John", addr1);
        Person p2 = new Person(p1);
        p2.address.city = "Los Angeles";
        p1.display();
        p2.display();
    }
}
