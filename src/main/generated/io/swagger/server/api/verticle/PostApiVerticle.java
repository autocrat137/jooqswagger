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

public class PostApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    private static final String ADD_SERVICE_ID = "add";
    

    private PostApi service = createServiceImplementation();

    //Handler for add
    final Handler<Message<JsonObject>> addHandler = message -> {
        try {
            Integer id = Json.mapper.readValue(message.body().getString("id"), Integer.class);
            String fn = message.body().getString("fn");
            String ln = message.body().getString("ln");
            service.add(id, fn, ln, verticleHelper.getAsyncResultHandler(message, ADD_SERVICE_ID, true, new TypeReference<GroupDto>(){}));

        } catch (Exception e) {
            verticleHelper.manageError(message, e, ADD_SERVICE_ID);
        }
    };

    

    @Override
    public void start() throws Exception {
        vertx.eventBus().<JsonObject> consumer(ADD_SERVICE_ID).handler(addHandler);
        
    }

    protected PostApi createServiceImplementation() {
        return new PostApiImpl();
    }
}
