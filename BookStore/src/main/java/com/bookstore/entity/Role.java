package com.bookstore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Size(max =  50, message = "ten quyen cho phep toi da 50 ki tu ")
    @NotBlank(message = "Ten quyen khong duoc de trong")
    @Column(name = "name", length = 50,nullable = false)
    private  String name;

    @Size(max = 250, message = "Mo ta quyen cho phep toi da 250 ki tu")
    @Column(name = "description", length = 250)
    private String descripyion;

    @ManyToMany(fetch =  FetchType.LAZY)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns= @JoinColumn(name = "user_id"))
    private List<User> users;

}
