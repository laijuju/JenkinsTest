package com.juju.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUser {
    List<User> users;

    @Override
    public String toString() {
        return "ListUser{" +
                "users=" + users +
                '}';
    }
}
