package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;

public class ZooException extends RuntimeException{

    private HttpStatus status;



}
