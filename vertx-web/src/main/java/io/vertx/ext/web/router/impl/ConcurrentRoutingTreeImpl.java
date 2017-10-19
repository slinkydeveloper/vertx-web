package io.vertx.ext.web.router.impl;

import io.vertx.ext.web.router.ConcurrentRoutingTree;
import io.vertx.ext.web.router.ConcurrentRoutingTreeWalker;
import io.vertx.ext.web.router.Route;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public class ConcurrentRoutingTreeImpl implements ConcurrentRoutingTree {

  private BaseConcurrentRoutingNode root;

  protected BaseConcurrentRoutingNode root() {
    return this.root;
  }

  @Override
  public ConcurrentRoutingTree addRoute(Route route) {
    return null;
  }

  @Override
  public ConcurrentRoutingTreeWalker walker(String requestUrl) {
    return new ConcurrentRoutingTreeWalkerImpl(requestUrl, this);
  }
}
