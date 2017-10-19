package io.vertx.ext.web.router;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.ext.web.router.impl.BaseConcurrentRoutingNode;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public interface ConcurrentRoutingTree {

  @Fluent ConcurrentRoutingTree addRoute(Route route);

  ConcurrentRoutingTreeWalker walker(String requestUrl);

}
