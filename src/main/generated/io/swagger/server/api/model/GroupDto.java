package io.swagger.server.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class GroupDto   {
  
  private Integer id = null;
  private String name = null;

  public GroupDto () {

  }

  public GroupDto (Integer id, String name) {
    this.id = id;
    this.name = name;
  }

    
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public GroupDto setId(Integer id) {
    this.id = id;
    return this;
  }

    
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public GroupDto setName(String name) {
    this.name = name;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupDto groupDto = (GroupDto) o;
    return Objects.equals(id, groupDto.id) &&
        Objects.equals(name, groupDto.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
