package io.swagger.server.api.verticle;

import io.swagger.server.api.model.GroupDto;
import io.swagger.server.api.MainApiException;
import io.swagger.server.api.MainApiHeader;
import io.swagger.server.api.util.ResourceResponse;
import io.swagger.server.api.util.VerticleHelper;

public final class PostApiHeader extends MainApiHeader {
    private PostApiHeader(String name, String value) {
        super(name, value);
    }
    
    private PostApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    

}