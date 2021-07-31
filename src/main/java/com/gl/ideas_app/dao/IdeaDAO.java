package com.gl.ideas_app.dao;

import com.gl.ideas_app.entities.IdeaEntity;
import java.util.List;


/**
 * This is the dao layer interface for the IdeaDAO
 */
public interface IdeaDAO {


  public IdeaEntity save(IdeaEntity ideaEntity);

  public IdeaEntity find(long id);

  public List<IdeaEntity> findAll();

  public IdeaEntity update(IdeaEntity ideaEntity);

  public void delete(long id);
}
