package io.vertx.ext.web.router.impl;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.router.*;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public class ConcurrentRoutingTreeWalkerImpl implements ConcurrentRoutingTreeWalker {

  boolean haveToIterateThroughRegexNodes;

  BaseConcurrentRoutingNode currentNode;

  String trimmedRequestUrl;
  String originalRequestUrl;

  ConcurrentRoutingTreeWalkerImpl(String requestUrl, ConcurrentRoutingTree tree) {
    this.originalRequestUrl = requestUrl;
    this.trimmedRequestUrl = this.originalRequestUrl;
    this.currentNode = ((ConcurrentRoutingTreeImpl)tree).root();
  }

  ConcurrentRoutingTreeWalkerImpl(String originalRequestUrl, String trimmedRequestUrl, BaseConcurrentRoutingNode currentNode) {
    this.originalRequestUrl = originalRequestUrl;
    resetFlagsForNextStep(trimmedRequestUrl, currentNode);
  }

  @Override
  public String requestUrl() {
    return this.originalRequestUrl;
  }

  @Override
  public Route currentRoute() {
    return this.currentNode.route();
  }

  @Override
  public Route next(RoutingContext routingContext) {
    if (this.haveToIterateThroughRegexNodes) {
      synchronized (currentNode.childRegexRoutes) {
        for (BaseConcurrentRoutingNode node : currentNode.childRegexRoutes) {
          BaseConcurrentRoutingNode.MatchStatus s = node.matches(routingContext);
          if (s.isMatch()) {
            //TODO Where I have to place the params?
            this.resetFlagsForNextStep(s.getUrlChunk(), node);
            return node.route();
          }
        }
      }
      this.haveToIterateThroughRegexNodes = false;
    }
    synchronized (currentNode.childStringRoutes) {
      for (BaseConcurrentRoutingNode node : currentNode.childStringRoutes) {
        BaseConcurrentRoutingNode.MatchStatus s = node.matches(routingContext);
        if (s.isMatch()) {
          this.resetFlagsForNextStep(s.getUrlChunk(), node);
          return node.route();
        }
      }
    }
    return null;
  }

  private void resetFlagsForNextStep(String urlToCheck, BaseConcurrentRoutingNode currentNode) {
    this.trimmedRequestUrl = urlToCheck;
    this.currentNode = currentNode;
    this.haveToIterateThroughRegexNodes = currentNode.hasRegexNodes();
  }
}
