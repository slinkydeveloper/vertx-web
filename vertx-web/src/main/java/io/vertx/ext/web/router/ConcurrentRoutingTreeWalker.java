package io.vertx.ext.web.router;

import io.vertx.ext.web.RoutingContext;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public interface ConcurrentRoutingTreeWalker {

  String requestUrl();

  Route currentRoute();

  Route next(RoutingContext routingContext);

}
