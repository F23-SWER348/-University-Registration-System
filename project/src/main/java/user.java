public abstract class user {
String name;
String role;
String contactDetails;

public user(String name, String role, String contactDetails) {
    this.name = name;
    this.role = role;
    this.contactDetails = contactDetails;
}

// Getter methods
public String getName() {
    return name;
}

public String getRole() {
    return role;
}

public String getContactDetails() {
    return contactDetails;
}

// Setter methods
public void setName(String name) {
    this.name = name;
}

public void setRole(String role) {
    this.role = role;
}

public void setContactDetails(String contactDetails) {
    this.contactDetails = contactDetails;
}

//aditional method to dispaly user informations
public void displayUserInfo() {
    System.out.println("User Information:");
    System.out.println("Name: " + name);
    System.out.println("Role: " + role);
    System.out.println("Contact Details: " + contactDetails);
}

//aditional method to update Contact Details
public void updateContactDetails(String newContactDetails) {
    System.out.println("Updating contact details for " + name);
    System.out.println("Old Contact Details: " + contactDetails);
    contactDetails = newContactDetails;
    System.out.println("New Contact Details: " + contactDetails);
}
    
    

    
}
