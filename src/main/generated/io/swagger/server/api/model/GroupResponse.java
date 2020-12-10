package io.swagger.server.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.server.api.model.GroupDto;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class GroupResponse   {
  
  private GroupDto response = null;

  public GroupResponse () {

  }

  public GroupResponse (GroupDto response) {
    this.response = response;
  }

    
  @JsonProperty("response")
  public GroupDto getResponse() {
    return response;
  }
  public GroupResponse setResponse(GroupDto response) {
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
    GroupResponse groupResponse = (GroupResponse) o;
    return Objects.equals(response, groupResponse.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupResponse {\n");
    
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
