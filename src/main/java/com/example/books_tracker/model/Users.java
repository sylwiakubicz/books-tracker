package com.example.books_tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Field can not be empty")
    private String username;

    @Email
    @NotBlank(message = "Field can not be empty")
    private String email;

    @NotBlank(message = "Field can not be empty")
    private String password;

    private Boolean active;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRoles role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_book_states",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_state_id")
    )
    private List<BookStates> bookList;

    @CreationTimestamp
    private Instant creationDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public List<BookStates> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookStates> bookList) {
        this.bookList = bookList;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }
}
