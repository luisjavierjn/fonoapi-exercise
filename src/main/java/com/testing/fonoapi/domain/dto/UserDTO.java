package com.testing.fonoapi.domain.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long user_id;
    private String name;
    private String lastname;
    private String email;
    private Integer age;
    private LocalDateTime registration_date;
}
