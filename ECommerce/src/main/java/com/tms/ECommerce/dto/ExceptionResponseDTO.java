package com.tms.ECommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDTO {
    private String apipath;
    private HttpStatus statuscode;
    private String errormsg;
    private LocalDateTime errotime;
}
