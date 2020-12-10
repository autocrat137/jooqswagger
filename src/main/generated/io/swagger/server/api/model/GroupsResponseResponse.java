package io.swagger.server.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.server.api.model.GroupDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class GroupsResponseResponse   {
  
  private List<GroupDto> results = new ArrayList<GroupDto>();

  public GroupsResponseResponse () {

  }

  public GroupsResponseResponse (List<GroupDto> results) {
    this.results = results;
  }

    
  @JsonProperty("results")
  public List<GroupDto> getResults() {
    return results;
  }
  public GroupsResponseResponse setResults(List<GroupDto> results) {
    this.results = results;
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
    GroupsResponseResponse groupsResponseResponse = (GroupsResponseResponse) o;
    return Objects.equals(results, groupsResponseResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupsResponseResponse {\n");
    
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
