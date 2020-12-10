package io.swagger.server.api.verticle;

import io.swagger.server.api.model.GroupDto;
import io.swagger.server.api.MainApiException;
import io.swagger.server.api.MainApiHeader;
import io.swagger.server.api.util.ResourceResponse;
import io.swagger.server.api.util.VerticleHelper;

public final class GetallApiHeader extends MainApiHeader {
    private GetallApiHeader(String name, String value) {
        super(name, value);
    }
    
    private GetallApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    

}