package com.gl.ideas_app.service.serviceImpl;

import com.gl.ideas_app.dao.IdeaDAO;
import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.entities.IdeaEntity;
import com.gl.ideas_app.exceptions.IdeaNotFoundException;
import com.gl.ideas_app.service.IdeaService;
import com.gl.ideas_app.utils.PojoConvertor;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IdeaServiceImpl implements IdeaService {

  @Autowired
  private IdeaDAO ideaDAO ;


  @Override
  public IdeaDTO saveIdea(IdeaDTO ideaDTO) {
    return PojoConvertor.convertIdeaEntityToDto(ideaDAO.save(PojoConvertor.convertIdeaDtoToEntity(ideaDTO)));
  }

  /**
   *
   * @param ideaDTO
   * @return
   * @throws IdeaNotFoundException
   */
  @Override
  public IdeaDTO updateIdea(IdeaDTO ideaDTO) throws IdeaNotFoundException {

    IdeaEntity ideaEntity = ideaDAO.find(ideaDTO.getId());

    if(ideaEntity==null){
      throw new IdeaNotFoundException("Idea details for the id : "+ ideaDTO.getId() + " is not found");
    }

    return PojoConvertor.convertIdeaEntityToDto(ideaDAO.update(PojoConvertor.convertIdeaDtoToEntity(ideaDTO)));
  }





  @Override
  public List<IdeaDTO> getAllIdeas() {
    return ideaDAO.findAll().stream().map(ideaEntity -> PojoConvertor.convertIdeaEntityToDto(ideaEntity)).collect(
        Collectors.toList());
  }

  @Override
  public IdeaDTO getIdea(long id) throws IdeaNotFoundException {

    IdeaEntity ideaEntity = ideaDAO.find(id);

    if(ideaEntity==null){
      throw new IdeaNotFoundException("Idea details for the id : "+ id + " is not found");
    }
    return PojoConvertor.convertIdeaEntityToDto(ideaEntity);
  }

  @Override
  public void deleteIdea(long id) {
    ideaDAO.delete(id);
  }

  public IdeaDAO getIdeaDAO() {
    return ideaDAO;
  }

  public void setIdeaDAO(IdeaDAO ideaDAO) {
    this.ideaDAO = ideaDAO;
  }

}
