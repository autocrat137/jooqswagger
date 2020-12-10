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

public class GetoneApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    private static final String GETONE_SERVICE_ID = "getone";
    

    private GetoneApi service = createServiceImplementation();

    //Handler for getone
    final Handler<Message<JsonObject>> getoneHandler = message -> {
        try {
            Integer id = Json.mapper.readValue(message.body().getString("id"), Integer.class);
            service.getone(id, verticleHelper.getAsyncResultHandler(message, GETONE_SERVICE_ID, true, new TypeReference<GroupDto>(){}));

        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETONE_SERVICE_ID);
        }
    };

    

    @Override
    public void start() throws Exception {
        vertx.eventBus().<JsonObject> consumer(GETONE_SERVICE_ID).handler(getoneHandler);
        
    }

    protected GetoneApi createServiceImplementation() {
        return new GetoneApiImpl();
    }
}
