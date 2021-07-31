package com.gl.ideas_app;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gl.ideas_app.dao.IdeaDAO;
import com.gl.ideas_app.dao.daoimpl.IdeaDAOImpl;
import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.exceptions.IdeaNotFoundException;
import com.gl.ideas_app.service.serviceImpl.IdeaServiceImpl;
import com.gl.ideas_app.utils.PojoConvertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IdeaServiceTestDemo {

  @Mock
  IdeaDAO ideaDAO ;

  @InjectMocks
  IdeaServiceImpl ideaService ;

  IdeaDTO ideaDTO ;

  @BeforeEach
  public void setupData(){
    ideaDTO = new IdeaDTO();
    ideaDTO.setId(1);
    ideaDTO.setIdeaName("First Idea");
    ideaDTO.setIdeaDescription("Best idea ever");
    ideaDTO.setAuthorName("Vishwa");

    //ideaService.saveIdea(ideaDTO);

    ideaDTO.setIdeaDescription("Updated :Best idea ever");

  }

  /**
   * Test the happy flow
   * @throws IdeaNotFoundException
   */
  @Test
  public void testUpdateIdea() throws IdeaNotFoundException {

    Mockito.when(ideaDAO.find(ideaDTO.getId())).
        thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));
    //Mocking
    Mockito.when(ideaDAO.update(PojoConvertor.convertIdeaDtoToEntity(ideaDTO)))
        .thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));

    IdeaDTO response = ideaService.updateIdea(ideaDTO);



    //Response should be not null
    Assertions.assertNotNull(response);


  }
}
