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
  public ConcurrentRoutingTree addStringRoute(Route route) {
    return null;
  }

  @Override
  public ConcurrentRoutingTree addRegexRoute(Route route) {
    return null;
  }

  @Override
  public ConcurrentRoutingTree addParametrizedRoute(Route route) {
    //TODO Convert vertx style/RFC6570 (not required for now) route to regex and call addRegexRoute
    return null;
  }

  @Override
  public ConcurrentRoutingTreeWalker walker(String requestUrl) {
    return new ConcurrentRoutingTreeWalkerImpl(requestUrl, this);
  }
}
