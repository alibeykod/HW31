package ir.maktabsharif.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRespDto {

    private Long id;

    private String fullName;

    private String username;
}
