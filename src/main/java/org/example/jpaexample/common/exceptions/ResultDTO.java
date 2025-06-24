package org.example.jpaexample.common.exceptions;

import lombok.Data;

@Data
public class ResultDTO {

    private int errorCode;
    private String errorMsg;

}
