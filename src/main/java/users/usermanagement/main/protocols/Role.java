package users.usermanagement.main.protocols;

public enum Role {
    ADMIN("admin"),
    EMPLOYER("employer");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
