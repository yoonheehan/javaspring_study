package com.example.demo.enitity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "users")
@Data
@DynamicUpdate
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    public User(String name, String email){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }

        if (email == null || email.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }

        this.name = name;
        this.email = email;
    }

    public void updateUser(String name, String email){
        if (name != null && !name.isBlank()) {
            this.name = name;
        }

        if (email != null && !email.isBlank()) {
            this.email = email;
        }
    }
}
