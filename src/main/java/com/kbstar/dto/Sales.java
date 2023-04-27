package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Sales {
    private Date rdate;
    private int price;
    private String gender;
}
