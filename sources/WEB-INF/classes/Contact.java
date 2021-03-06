public class Contact {

  ////////////
  //Attributes
  ////////////
  private int id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private String email;
  private String comment;

  /////////////
  //Constructor
  /////////////

  public Contact(){
    this.id = -1;
    this.firstName = "";
    this.lastName = "";
    this.phoneNumber = "";
    this.address = "";
    this.email = "";
    this.comment = "";
  }
  public Contact(int id, String firstName, String lastName,
            String phoneNumber, String address,
            String email, String comment){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.email = email;
    this.comment = comment;
  }

  /////////
  //Getters
  /////////
  public int getId(){
    return this.id;
  }

  public String getFirstName(){
    return this.firstName;
  }

  public String getLastName(){
    return this.lastName;
  }

  public String getPhoneNumber(){
    return this.phoneNumber;
  }

  public String getAddress(){
    return this.address;
  }

  public String getEmail(){
    return this.email;
  }

  public String getComment(){
    return this.comment;
  }

  /////////
  //Setters
  /////////
  public void setId(int id){
    this.id = id;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setComment(String comment){
    this.comment = comment;
  }
}
