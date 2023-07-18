package com.example.sale.practice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    private Integer age;
    @NotNull
    private Date birthDay;
    @NotNull
    private UserDTO user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id) && Objects.equals(name, clientDTO.name) && Objects.equals(lastname, clientDTO.lastname) && Objects.equals(age, clientDTO.age) && Objects.equals(birthDay, clientDTO.birthDay) && Objects.equals(user, clientDTO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, age, birthDay, user);
    }
}
