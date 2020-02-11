package com.juju.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    String username;
    String password;

    @Override
    public String toString() {
        return "Teacher{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
