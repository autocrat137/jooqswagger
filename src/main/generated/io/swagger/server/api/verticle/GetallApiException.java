package io.swagger.server.api.verticle;

import io.swagger.server.api.model.GroupDto;
import io.swagger.server.api.MainApiException;
import io.swagger.server.api.MainApiHeader;
import io.swagger.server.api.util.ResourceResponse;
import io.swagger.server.api.util.VerticleHelper;

public final class GetallApiException extends MainApiException {
    public GetallApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    

}