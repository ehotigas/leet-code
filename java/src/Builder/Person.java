
package Builder;



public class Person {
    private String name;
    private Integer age;


    public static class PersonBuilder {
        private String name;
        private Integer age;

        public PersonBuilder() {

        }

        public PersonBuilder(Person person) {
            this.name = person.getName();
            this.age = person.getAge();
        }

        public Person build() {
            return new Person(name, age);
        }

        public PersonBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }
    }

    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person.PersonBuilder builder = new Person.PersonBuilder();
        builder.age(23);
        builder.name("Tiago");
        System.out.println(builder.build());
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}