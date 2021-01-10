package com.security.uaa.model.dto;

import lombok.Data;

/**
 * @author: gaolingfeng
 * @date: 2020/12/23 22:43
 * @description:
 */
@Data
public class PermissionDTO {
    private String id;
    private String code;
    private String description;
    private String url;
}
