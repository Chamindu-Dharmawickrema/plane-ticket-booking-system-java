public class Person {
    // Attributes for Person class
    private String name;
    private String surname;
    private String email;

    // Constructor
    public Person(String name, String surname,String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    //Getters ,Setters
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname= surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

    //Method for print person details
    public void print(){
        System.out.println("Name    : "+name);
        System.out.println("Surname : "+surname);
        System.out.println("Email   : "+email);
    }
}

