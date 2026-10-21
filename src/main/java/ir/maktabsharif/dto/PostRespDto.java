package ir.maktabsharif.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRespDto {
    private Long id;

    private String title;

    private String TextOfPost;

    private LocalDateTime createdAt;
}
