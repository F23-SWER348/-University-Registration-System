public abstract class user {
String name;
String role;
String faculty;

public user(String name, String role, String faculty) {
    this.name = name;
    this.role = role;
    this.faculty = faculty;
}

// Getter methods
public String getName() {
    return name;
}

public String getRole() {
    return role;
}

public String getFaculty() {
    return faculty;
}

// Setter methods
public void setName(String name) {
    this.name = name;
}

public void setRole(String role) {
    this.role = role;
}

public void setFaculty(String faculty) {
    this.faculty = faculty;
}

//aditional method to dispaly user informations
public void displayUserInfo() {
    System.out.println("User Information:");
    System.out.println("Name: " + name);
    System.out.println("Role: " + role);
    System.out.println("Faculty: " + faculty);
}


    
    

    
}
