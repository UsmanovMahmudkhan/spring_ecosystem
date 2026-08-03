package com.mahmudkhon.springRedisLab.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {
    private Integer id;
    private String text;
}
