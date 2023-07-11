package com.example.sale.practice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO <T extends Object>{
    private String code;
    private String message;
    private T content;
}
