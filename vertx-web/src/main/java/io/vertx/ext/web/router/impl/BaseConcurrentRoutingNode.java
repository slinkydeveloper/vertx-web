package io.vertx.ext.web.router.impl;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.router.Route;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.List;
import java.util.Map;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public abstract class BaseConcurrentRoutingNode {

  protected class MatchStatus {
    private boolean match;
    private Map<String, String> params;
    private String urlChunk;

    protected MatchStatus(boolean m, String urlChunck) {
      this.match = m;
      this.urlChunk = urlChunck;
    }

    protected MatchStatus(Map<String, String> params, String urlChunck) {
      this.params = params;
      this.urlChunk = urlChunck;
    }

    protected boolean isMatch() {
      return match;
    }

    protected Map<String, String> getParams() {
      return params;
    }

    protected String getUrlChunk() {
      return urlChunk;
    }

    protected boolean emptyParams() {
      return params.isEmpty();
    }
  }

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

  public abstract MatchStatus matches(RoutingContext routingContext);

  public abstract boolean hasRegexNodes();

}
