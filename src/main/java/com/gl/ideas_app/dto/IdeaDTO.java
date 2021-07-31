package com.gl.ideas_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 *
 * {
 *   "id" : 5 ,
 *   "idea_name" : "My Idea",
 *   "author_name" : "Vishwa",
 *   "idea_description" : "My description"
 *
 * }
 *
 *
 */
public class IdeaDTO {

  @JsonProperty("id")
  private long id ;

  @JsonProperty("idea_name")
  private String ideaName ;

  @JsonProperty("author_name")
  private String authorName ;

  @JsonProperty("idea_description")
  private String ideaDescription ;

  @Override
  public String toString() {
    return "IdeaDTO{" + "id=" + id + ", ideaName='" + ideaName + '\'' + ", authorName='" + authorName + '\''
        + ", ideaDescription='" + ideaDescription + '\'' + '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getIdeaName() {
    return ideaName;
  }

  public void setIdeaName(String ideaName) {
    this.ideaName = ideaName;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getIdeaDescription() {
    return ideaDescription;
  }

  public void setIdeaDescription(String ideaDescription) {
    this.ideaDescription = ideaDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdeaDTO ideaDTO = (IdeaDTO) o;
    return id == ideaDTO.id && Objects.equals(ideaName, ideaDTO.ideaName) && Objects.equals(authorName,
        ideaDTO.authorName) && Objects.equals(ideaDescription, ideaDTO.ideaDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ideaName, authorName, ideaDescription);
  }
}
