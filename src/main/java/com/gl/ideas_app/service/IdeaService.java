package com.gl.ideas_app.service;

import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.exceptions.IdeaNotFoundException;
import java.util.List;


public interface IdeaService {


  public IdeaDTO saveIdea(IdeaDTO ideaDTO);

  public IdeaDTO updateIdea(IdeaDTO ideaDTO) throws IdeaNotFoundException;

  public List<IdeaDTO> getAllIdeas();

  public IdeaDTO getIdea(long id) throws  IdeaNotFoundException;

  public void deleteIdea(long id);
}
