package users.usermanagement.domain.dtos;

import users.usermanagement.main.protocols.Role;

public record RegisterDto(
        String login,
        String password,
        Role role
) {}
