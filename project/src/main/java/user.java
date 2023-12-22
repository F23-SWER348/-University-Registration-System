
public abstract class user {
String name;
String role;
String Faculty;

public user(String name, String role, String Faculty) {
    this.name = name;
    this.role = role;
    this.Faculty = Faculty;
}

// Getter methods
public String getName() {
    return name;
}

public String getRole() {
    return role;
}

public String getFaculty() {
    return Faculty;
}

// Setter methods
public void setName(String name) {
    this.name = name;
}

public void setRole(String role) {
    this.role = role;
}

public void setFaculty(String Faculty) {
    this.Faculty = Faculty;
}

//aditional method to dispaly user informations
public void displayUserInfo() {
    System.out.println("User Information:");
    System.out.println("Name: " + name);
    System.out.println("Role: " + role);
    System.out.println("Faculty: " + Faculty);
}


}
