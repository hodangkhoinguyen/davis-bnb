package com.example.nguyenho.davisbnb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="app_user")
public class User implements UserDetails {

    @Id
    @UuidGenerator
    private String id;
    private String email;
    @JsonIgnore
    private String password;
    private String name;
    private String profileImageUrl;
    @OneToMany
    @JsonIgnore
    private Collection<RefreshToken> refreshToken;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
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


    public Collection<RefreshToken> getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(Collection<RefreshToken> refreshToken) {
        this.refreshToken = refreshToken;
    }
}
