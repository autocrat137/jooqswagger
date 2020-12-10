package io.swagger.server.api;

import java.nio.charset.Charset;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.phiz71.vertx.swagger.router.OperationIdServiceIdResolver;
import com.github.phiz71.vertx.swagger.router.SwaggerRouter;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.swagger.server.api.util.SwaggerManager;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.file.FileSystem;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;

public class MainApiVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainApiVerticle.class);
    
    private final Router router = Router.router(vertx);
    
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        Json.mapper.registerModule(new JavaTimeModule());
    	FileSystem vertxFileSystem = vertx.fileSystem();
        vertxFileSystem.readFile("swagger.json", readFile -> {
            if (readFile.succeeded()) {
                Swagger swagger = new SwaggerParser().parse(readFile.result().toString(Charset.forName("utf-8")));
                SwaggerManager.getInstance().setSwagger(swagger);
                Router swaggerRouter = SwaggerRouter.swaggerRouter(Router.router(vertx), swagger, vertx.eventBus(), new OperationIdServiceIdResolver());
            
                deployVerticles(startFuture);

                vertx.createHttpServer() 
                    .requestHandler(swaggerRouter::accept) 
                    .listen(config().getInteger("http.port", 9090));
                startFuture.complete();
            } else {
            	startFuture.fail(readFile.cause());
            }
        });        		        
    }
      
    public void deployVerticles(Future<Void> startFuture) {
        
        vertx.deployVerticle("io.swagger.server.api.verticle.GetallApiVerticle", res -> {
            if (res.succeeded()) {
                LOGGER.info("GetallApiVerticle : Deployed");
            } else {
                startFuture.fail(res.cause());
                LOGGER.error("GetallApiVerticle : Deployement failed");
            }
        });
        
        vertx.deployVerticle("io.swagger.server.api.verticle.GetoneApiVerticle", res -> {
            if (res.succeeded()) {
                LOGGER.info("GetoneApiVerticle : Deployed");
            } else {
                startFuture.fail(res.cause());
                LOGGER.error("GetoneApiVerticle : Deployement failed");
            }
        });
        
        vertx.deployVerticle("io.swagger.server.api.verticle.PostApiVerticle", res -> {
            if (res.succeeded()) {
                LOGGER.info("PostApiVerticle : Deployed");
            } else {
                startFuture.fail(res.cause());
                LOGGER.error("PostApiVerticle : Deployement failed");
            }
        });
        
    }
}