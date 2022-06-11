package _1_DefiningClassesOpinionPoll;



public class NameBook {
    private String name;
    private int age;
    public NameBook() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age >= 0){
            this.age = age;
        } else {
            throw new Exception("should not be negative age");
        }
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAge();
    }


}
