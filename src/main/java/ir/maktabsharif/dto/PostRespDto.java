package ir.maktabsharif.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRespDto {
    private Long id;

    private String title;

    private String TextOfPost;
}
