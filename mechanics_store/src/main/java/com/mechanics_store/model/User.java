package com.mechanics_store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Represents entity in database called user.
 *
 * It's also used as for an identification of application user Stores all the
 * important information about a user such as: first name, last name, username
 * and password
 *
 * @author Nebojsa Brankovic
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "user")
public class User implements UserDetails {

    /**
     * Auto generated identifier which is unique and it's used to identify an
     * instance (row) in database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * First name of a user
     *
     * Value can't be empty
     */
    @NotBlank(message = "First name must be filled")
    private String firstName;

    /**
     * Last name of a user
     *
     * Value can't be empty
     */
    @NotBlank(message = "Last name must be filled")
    private String lastName;

    /**
     * Username of a user
     *
     * It's a natural identifier which means his value can't be changed in
     * database afterwards.
     *
     */
    @NotBlank(message = "Username must be filled")
    @NaturalId
    private String username;

    /**
     * User's password which is hashed inside the database.
     */
    @NotBlank(message = "Password must be filled")
    private String password;

    /**
     * Role that a user has in the system.
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
