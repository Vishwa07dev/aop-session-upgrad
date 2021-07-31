package com.gl.ideas_app.controller;

import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.exceptions.IdeaNotFoundException;
import com.gl.ideas_app.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ideas")
public class IdeaServiceController {

  @Autowired
  private IdeaService ideaService ;

  /**
   * POST
   *  127.0.0.1:8070/ideas
   */

  @PostMapping
  public ResponseEntity createIdea(@RequestBody IdeaDTO ideaDTO){
    System.out.println("Post method is invoked");
    ideaService.saveIdea(ideaDTO);

    return  new ResponseEntity(ideaDTO, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity getIdea(@PathVariable("id") Long id) throws IdeaNotFoundException {
    return new ResponseEntity(ideaService.getIdea(id) , HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getAllIdeas(){
    return  new ResponseEntity(ideaService.getAllIdeas(), HttpStatus.OK);
  }


  @PutMapping("/{id}")
  public ResponseEntity updateIdea(@PathVariable("id") Long id , @RequestBody IdeaDTO ideaDTO)
      throws IdeaNotFoundException {
    ideaService.updateIdea(ideaDTO);

    return new ResponseEntity(ideaDTO, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteIdea(@PathVariable("id") Long id){
    ideaService.deleteIdea(id);
    return new ResponseEntity(null,HttpStatus.OK);
  }



}
