package com.gl.ideas_app.service.serviceImpl;

import com.gl.ideas_app.dao.IdeaDAO;
import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.utils.PojoConvertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest  // Brings the power of Spring
public class IdeaServiceImpTest {  //naming convention

  @Mock
  IdeaDAO _ideaDAO ;


  @InjectMocks
  IdeaServiceImpl ideaService ;

//  @Test
//  public void testSaveIdea(){   // Unit test or integration ?
//    //Setting up of data
//    IdeaDTO ideaDTO = new IdeaDTO();
//    ideaDTO.setIdeaName("Great Idea");
//    ideaDTO.setIdeaName("What a idea sir ji !!");
//    ideaDTO.setAuthorName("Vishwa");
//    ideaDTO.setId(1);
//
//    //Actual execution
//    IdeaDTO response  = ideaService.saveIdea(ideaDTO);  // Actual
//
//
//    //Validation
//    Assertions.assertNotNull(response);
//    Assertions.assertEquals("Vishwa" , ideaDTO.getAuthorName());
//
//  }
//
  // Real Unit testing
  @Test
  public void unitTestSaveIdea(){
    IdeaDTO ideaDTO = new IdeaDTO();
    ideaDTO.setIdeaName("Great Idea");
    ideaDTO.setIdeaName("What a idea sir ji !!");
    ideaDTO.setAuthorName("Vishwa");
    ideaDTO.setId(1);

    //Give the functionality to mocked or dummy idea dao
    Mockito.when(_ideaDAO.save(PojoConvertor.convertIdeaDtoToEntity(ideaDTO))).
        thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));

    //Actual execution
    IdeaDTO response  = ideaService.saveIdea(ideaDTO);  // Actual


    //Validation
    Assertions.assertNotNull(response);
    Assertions.assertEquals("Vishwa" , response.getAuthorName());


  }






}
