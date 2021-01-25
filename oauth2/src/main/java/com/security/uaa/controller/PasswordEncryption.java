package com.security.uaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2020/12/27 18:07
 * @description:
 */
@RestController
public class PasswordEncryption {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 只有P4权限才有 输入密码获得加密后的密码
     *
     * @param password
     * @return
     */
    @PreAuthorize("hasAuthority('P4')")
    @GetMapping(value = "getEncryptedPassword")
    public String getEncryptedPassword(String password) {
        return password + ":" + passwordEncoder.encode(password);
    }
}
