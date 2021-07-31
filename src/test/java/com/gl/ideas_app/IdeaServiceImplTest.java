package com.gl.ideas_app;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gl.ideas_app.dao.IdeaDAO;
import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.service.serviceImpl.IdeaServiceImpl;
import com.gl.ideas_app.utils.PojoConvertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IdeaServiceImplTest {

  @Mock
  IdeaDAO ideaDAO ;  // some dummy instance of ideaDAO

  @InjectMocks
  IdeaServiceImpl ideaServiceImpl ;



 @Test
  public void saveIdeaUnitTest(){
     // Create the data
     IdeaDTO ideaDTO = new IdeaDTO();
     ideaDTO.setId(112L);
     ideaDTO.setIdeaDescription("My great idea");
     ideaDTO.setIdeaName("My idea");
     ideaDTO.setAuthorName("Vishwa");

     //Training the moc
   Mockito.when(ideaDAO.save(PojoConvertor.convertIdeaDtoToEntity(ideaDTO))).
       thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));

   //Execution
   IdeaDTO result = ideaServiceImpl.saveIdea(ideaDTO);

        //Validate if it's working
     Assertions.assertNotNull(result);
     Assertions.assertEquals("Vishwa", result.getAuthorName());




  }

//  @Test
//   public void saveIdeaTest(){
//
//     // Create the data
//     IdeaDTO ideaDTO = new IdeaDTO();
//     ideaDTO.setId(112L);
//     ideaDTO.setIdeaDescription("My great idea");
//     ideaDTO.setIdeaName("My idea");
//     ideaDTO.setAuthorName("Vishwa");
//
//
//     // Call the service
//     IdeaDTO result = ideaServiceImpl.saveIdea(ideaDTO);
//
//     //Validate if it's working
//     Assertions.assertNotNull(result);
//     Assertions.assertEquals("Mohan", result.getAuthorName());
//
//   }

   @Test
   public void updateIdeaTest(){
     // code here for the testing
   }



}
