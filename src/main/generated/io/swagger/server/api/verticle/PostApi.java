package io.swagger.server.api.verticle;

import io.swagger.server.api.model.GroupDto;
import io.swagger.server.api.MainApiException;
import io.swagger.server.api.MainApiHeader;
import io.swagger.server.api.util.ResourceResponse;
import io.swagger.server.api.util.VerticleHelper;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.auth.User;

import java.util.List;
import java.util.Map;

public interface PostApi  {
    //add
    void add(Integer id, String fn, String ln, Handler<AsyncResult<ResourceResponse<GroupDto>>> handler);
    
}
