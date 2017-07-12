package com.hhmedic.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lcssos on 17-7-12.
 */
@Getter
@Setter
@Builder
public class ShiroUser {
    private String loginname;
    private String name;
    private Long uuid;
}
