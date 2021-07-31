package com.gl.ideas_app.exceptionhandler;

import com.gl.ideas_app.exceptions.IdeaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class IdeaNotFoundExceptionHandler {

  @ExceptionHandler(IdeaNotFoundException.class)
  public ResponseEntity handleIdeaNotFoundException(){
    return new ResponseEntity("Idea id passed is not present", HttpStatus.BAD_REQUEST);

  }


}
