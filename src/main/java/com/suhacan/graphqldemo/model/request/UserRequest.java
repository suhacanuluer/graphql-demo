package com.suhacan.graphqldemo.model.request;

import com.suhacan.graphqldemo.model.Role;
import lombok.Data;

@Data
public class UserRequest {

    private Long id;
    private String username;
    private String mail;
    private Role role;

}
