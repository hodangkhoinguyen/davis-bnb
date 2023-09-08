package com.example.nguyenho.davisbnb.payload.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String profileImageUrl;
}
