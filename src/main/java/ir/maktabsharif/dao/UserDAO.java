package ir.maktabsharif.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany
    @ToString.Exclude
    @Builder.Default
    private List<PostDAO> postDAO = new ArrayList<>();


}
