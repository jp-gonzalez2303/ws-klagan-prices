package com.example.wsklaganprices.price.infrastructure.exceptions;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Error {
    private String code;
    private String message;

}
