package org.jt.hmsapptests.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ErrorDetails {
    
    private Date timeStamp;
    private String details;
    private String message;
}
