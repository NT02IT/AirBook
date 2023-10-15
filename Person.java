

public class Person {
    String name;
    public Person() {
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person person = new Person();
        Person reference = person;
        person.setName("John Doe");
        System.out.println(reference.getName());

    }
}

