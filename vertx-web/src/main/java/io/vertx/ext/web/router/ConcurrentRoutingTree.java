package io.vertx.ext.web.router;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.ext.web.router.impl.BaseConcurrentRoutingNode;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public interface ConcurrentRoutingTree {

  @Fluent ConcurrentRoutingTree addStringRoute(Route route);

  @Fluent ConcurrentRoutingTree addRegexRoute(Route route);

  @Fluent ConcurrentRoutingTree addParametrizedRoute(Route route);

  ConcurrentRoutingTreeWalker walker(String requestUrl);

}
