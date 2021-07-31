package com.gl.ideas_app.utils;

import com.gl.ideas_app.dto.IdeaDTO;
import com.gl.ideas_app.entities.IdeaEntity;


public class PojoConvertor {
  public static IdeaEntity convertIdeaDtoToEntity(IdeaDTO ideaDTO) {

    IdeaEntity ideaEntity = new IdeaEntity();

    ideaEntity.setIdeaName(ideaDTO.getIdeaName());
    ideaEntity.setId(ideaDTO.getId());
    ideaEntity.setAuthorName(ideaDTO.getAuthorName());
    ideaEntity.setDescription(ideaDTO.getIdeaDescription());

    return ideaEntity;
  }

  public static IdeaDTO convertIdeaEntityToDto(IdeaEntity ideaEntity) {

    IdeaDTO ideaDTO = new IdeaDTO();

    ideaDTO.setIdeaName(ideaEntity.getIdeaName());
    ideaDTO.setIdeaDescription(ideaEntity.getDescription());
    ideaDTO.setAuthorName(ideaEntity.getAuthorName());
    ideaDTO.setId(ideaEntity.getId());


    return  ideaDTO;

  }
}
