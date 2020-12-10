package io.swagger.server.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.server.api.model.GroupsResponseResponse;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class GroupsResponse   {
  
  private GroupsResponseResponse response = null;

  public GroupsResponse () {

  }

  public GroupsResponse (GroupsResponseResponse response) {
    this.response = response;
  }

    
  @JsonProperty("response")
  public GroupsResponseResponse getResponse() {
    return response;
  }
  public GroupsResponse setResponse(GroupsResponseResponse response) {
    this.response = response;
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
    GroupsResponse groupsResponse = (GroupsResponse) o;
    return Objects.equals(response, groupsResponse.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupsResponse {\n");
    
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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
