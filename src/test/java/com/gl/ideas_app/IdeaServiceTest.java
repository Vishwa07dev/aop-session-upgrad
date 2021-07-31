package com.gl.ideas_app;

import com.gl.ideas_app.dao.IdeaDAO;
import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.exceptions.IdeaNotFoundException;
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
public class IdeaServiceTest {



  @Mock
  IdeaDAO ideaDAO ;  // this will create a dummy or  mocked ideaDAO

  @InjectMocks
  IdeaServiceImpl ideaService ;


  public void testUpdateIdeaThrowsExceptionWhenIdeaIsNotPresent(){

  }

  @Test
  public void testUpdateIdea() throws IdeaNotFoundException {
    System.out.println(ideaService);
    //Insert an idea record
    IdeaDTO ideaDTO = new IdeaDTO();
    ideaDTO.setIdeaName("MyIdea");
    ideaDTO.setIdeaDescription("Desc");
    ideaDTO.setAuthorName("Vishwa");
    ideaDTO.setId(123L);

    Mockito.when(ideaDAO.save(PojoConvertor.convertIdeaDtoToEntity(ideaDTO))).
        thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));

    ideaService.saveIdea(ideaDTO);

    Mockito.when(ideaDAO.find(123L)).thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));

    Mockito.when(ideaDAO.update(PojoConvertor.convertIdeaDtoToEntity(ideaDTO)))
        .thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));

    //Update the idea record
    ideaDTO.setIdeaDescription("UPDATED");
    Mockito.when(ideaDAO.update(PojoConvertor.convertIdeaDtoToEntity(ideaDTO)))
        .thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO));

    IdeaDTO result= ideaService.updateIdea(ideaDTO);

    //Test if the idea record has been updated successfully
    Assertions.assertNotNull(result);
    Assertions.assertEquals("UPDATED", result.getIdeaDescription());

  }






}
