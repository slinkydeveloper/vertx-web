package io.vertx.ext.web.router.impl;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.router.Route;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.List;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public abstract class BaseConcurrentRoutingNode {

  private RouteImpl thisRoute;

  protected MutableList<BaseConcurrentRoutingNode> childStringRoutes;
  protected MutableList<BaseConcurrentRoutingNode> childRegexRoutes;

  public BaseConcurrentRoutingNode() {
    this.childStringRoutes = new FastList<>();
    this.childStringRoutes = this.childStringRoutes.asSynchronized();
    this.childRegexRoutes = new FastList<>();
    this.childRegexRoutes = this.childRegexRoutes.asSynchronized();
  }

  public Route route() {
    return thisRoute;
  }

  public abstract boolean matches(RoutingContext routingContext);

  public abstract boolean hasRegexNodes();

}
