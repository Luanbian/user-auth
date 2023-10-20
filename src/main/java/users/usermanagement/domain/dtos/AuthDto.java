package users.usermanagement.domain.dtos;

public record AuthDto (
        String login,
        String password
) {}
