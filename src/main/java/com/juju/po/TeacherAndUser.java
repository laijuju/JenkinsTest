package com.juju.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherAndUser {
    User user;
    Teacher teacher;

    @Override
    public String toString() {
        return "TeacherAndUser{" +
                "user=" + user +
                ", teacher=" + teacher +
                '}';
    }
}
