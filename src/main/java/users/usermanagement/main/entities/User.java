package users.usermanagement.main.entities;

import jakarta.persistence.*;
import lombok.*;
import users.usermanagement.main.protocols.Role;

@Table(name = "users")
@Entity(name = "User")
@Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login;
    private String password;
    private Role role;
}
