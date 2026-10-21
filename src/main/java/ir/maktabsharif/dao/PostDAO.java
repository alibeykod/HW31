package ir.maktabsharif.dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PostDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String textOfPost;

    private LocalDateTime createdAt;

    @ManyToOne
    private UserDAO userDAO;

    @PrePersist
    public void create(){
        this.createdAt = LocalDateTime.now();
    }
}
