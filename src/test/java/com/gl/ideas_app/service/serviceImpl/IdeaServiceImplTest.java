package com.gl.ideas_app.service.serviceImpl;

import com.gl.ideas_app.dao.daoimpl.IdeaDAOImpl;
import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.entities.IdeaEntity;
import com.gl.ideas_app.exceptions.IdeaNotFoundException;
import com.gl.ideas_app.utils.PojoConvertor;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IdeaServiceImplTest {

  @Mock
  private IdeaDAOImpl ideaDAO ;

  @InjectMocks
  private IdeaServiceImpl ideaService ;


  @BeforeEach
  public void settingUpDataForTesting(){
    IdeaDTO ideaDTO1 = new IdeaDTO();
    ideaDTO1.setId(121);
    ideaDTO1.setAuthorName("Vishwa");
    ideaDTO1.setIdeaDescription("Cool Idea");
    ideaDTO1.setIdeaName("My first idea");

    Mockito.when(ideaDAO.save(PojoConvertor.convertIdeaDtoToEntity(ideaDTO1))).thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO1));

    ideaService.saveIdea(ideaDTO1);


    IdeaDTO ideaDTO2 = new IdeaDTO();
    ideaDTO2.setId(122);
    ideaDTO2.setAuthorName("Vishwa2");
    ideaDTO2.setIdeaDescription("Cool Idea");
    ideaDTO2.setIdeaName("My first idea");

    Mockito.when(ideaDAO.save(PojoConvertor.convertIdeaDtoToEntity(ideaDTO2))).thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO2));

    ideaService.saveIdea(ideaDTO2);


    IdeaDTO ideaDTO3 = new IdeaDTO();
    ideaDTO3.setId(123);
    ideaDTO3.setAuthorName("Vishwa3");
    ideaDTO3.setIdeaDescription("Cool Idea");
    ideaDTO3.setIdeaName("My first idea");

    Mockito.when(ideaDAO.save(PojoConvertor.convertIdeaDtoToEntity(ideaDTO3))).thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO3));

    ideaService.saveIdea(ideaDTO3);


    List<IdeaEntity> entities = new ArrayList<>();
    entities.add(PojoConvertor.convertIdeaDtoToEntity(ideaDTO1));
    entities.add(PojoConvertor.convertIdeaDtoToEntity(ideaDTO2));
    entities.add(PojoConvertor.convertIdeaDtoToEntity(ideaDTO3));

    Mockito.when(ideaDAO.findAll()).thenReturn(entities);

    Mockito.when(ideaDAO.find(123)).thenReturn(PojoConvertor.convertIdeaDtoToEntity(ideaDTO3));

  }


  @Test
  public void testSaveIdea(){
    IdeaDTO ideaDTO = new IdeaDTO();
    ideaDTO.setId(12345);
    ideaDTO.setAuthorName("Vishwa");
    ideaDTO.setIdeaDescription("Cool Idea");
    ideaDTO.setIdeaName("My first idea");

    IdeaEntity ideaEntity = PojoConvertor.convertIdeaDtoToEntity(ideaDTO);

    Mockito.when(ideaDAO.save(ideaEntity)).thenReturn(ideaEntity);


    IdeaDTO ideaDTOSaved = ideaService.saveIdea(ideaDTO);

    Assertions.assertNotNull(ideaDTOSaved);
    Assertions.assertEquals(12345, ideaDTOSaved.getId());
    Assertions.assertEquals("Vishwa", ideaDTOSaved.getAuthorName());
    Assertions.assertNotNull(ideaDTOSaved.getIdeaDescription());
    Assertions.assertNotNull(ideaDTOSaved.getIdeaName());
  }

  @Test
  public void testUpdateIdea() throws IdeaNotFoundException {

    IdeaDTO ideaDTO = new IdeaDTO();
    ideaDTO.setId(12345);
    ideaDTO.setAuthorName("Vishwa");
    ideaDTO.setIdeaDescription("Cool Idea : UPDATED");
    ideaDTO.setIdeaName("My first idea");

    IdeaEntity ideaEntity = PojoConvertor.convertIdeaDtoToEntity(ideaDTO);
    Mockito.when(ideaDAO.find(12345)).thenReturn(ideaEntity);
    Mockito.when(ideaDAO.update(ideaEntity)).thenReturn(ideaEntity);

    IdeaDTO ideaDTOResult = ideaService.updateIdea(ideaDTO);

    Assertions.assertNotNull(ideaDTOResult);
    Assertions.assertTrue(ideaDTOResult.getIdeaDescription().contains("UPDATED"));

  }


  @Test
  public void testGetAllIdeas(){

     List<IdeaDTO> ideaDTOList = ideaService.getAllIdeas();
     Assertions.assertNotNull(ideaDTOList);
     Assertions.assertEquals(3, ideaDTOList.size());
  }

  @Test
  public void testGetIdeadBasedOnId() throws IdeaNotFoundException {
    IdeaDTO ideaDTO = ideaService.getIdea(123);
    Assertions.assertNotNull(ideaDTO);
    Assertions.assertEquals(123, ideaDTO.getId());
  }


}
