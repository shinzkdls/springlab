package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cart {
    private int id;
    private String cust_id;
    private int item_id;
    private int cnt;
    private Date rdate;
}
