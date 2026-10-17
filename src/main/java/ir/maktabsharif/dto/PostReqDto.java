package ir.maktabsharif.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostReqDto {
    private String title;

    private String TextOfPost;
}
