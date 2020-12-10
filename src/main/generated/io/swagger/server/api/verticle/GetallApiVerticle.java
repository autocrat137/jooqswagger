package io.swagger.server.api.verticle;

import com.fasterxml.jackson.core.type.TypeReference;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import com.github.phiz71.vertx.swagger.router.SwaggerRouter;

import io.swagger.server.api.model.GroupDto;
import io.swagger.server.api.MainApiException;
import io.swagger.server.api.MainApiHeader;
import io.swagger.server.api.util.ResourceResponse;
import io.swagger.server.api.util.VerticleHelper;

import java.util.List;
import java.util.Map;

public class GetallApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    private static final String GETALL_SERVICE_ID = "getall";
    

    private GetallApi service = createServiceImplementation();

    //Handler for getall
    final Handler<Message<JsonObject>> getallHandler = message -> {
        try {
            service.getall(verticleHelper.getAsyncResultHandler(message, GETALL_SERVICE_ID, true, new TypeReference<List<GroupDto>>(){}));

        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETALL_SERVICE_ID);
        }
    };

    

    @Override
    public void start() throws Exception {
        vertx.eventBus().<JsonObject> consumer(GETALL_SERVICE_ID).handler(getallHandler);
        
    }

    protected GetallApi createServiceImplementation() {
        return new GetallApiImpl();
    }
}
