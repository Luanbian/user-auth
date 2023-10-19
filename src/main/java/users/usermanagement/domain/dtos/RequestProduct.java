package users.usermanagement.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct (
    String id,

    @NotNull
    @NotBlank
    String name,

    @NotNull
    Integer price_in_cents
) {}
