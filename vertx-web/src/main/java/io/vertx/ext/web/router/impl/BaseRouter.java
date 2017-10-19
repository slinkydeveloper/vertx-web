package io.vertx.ext.web.router.impl;

import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public class BaseRouter implements Router {
  @Override
  public void accept(HttpServerRequest request) {

  }

  @Override
  public Route route() {
    return null;
  }

  @Override
  public Route route(HttpMethod method, String path) {
    return null;
  }

  @Override
  public Route route(String path) {
    return null;
  }

  @Override
  public Route routeWithRegex(HttpMethod method, String regex) {
    return null;
  }

  @Override
  public Route routeWithRegex(String regex) {
    return null;
  }

  @Override
  public Route get() {
    return null;
  }

  @Override
  public Route get(String path) {
    return null;
  }

  @Override
  public Route getWithRegex(String regex) {
    return null;
  }

  @Override
  public Route head() {
    return null;
  }

  @Override
  public Route head(String path) {
    return null;
  }

  @Override
  public Route headWithRegex(String regex) {
    return null;
  }

  @Override
  public Route options() {
    return null;
  }

  @Override
  public Route options(String path) {
    return null;
  }

  @Override
  public Route optionsWithRegex(String regex) {
    return null;
  }

  @Override
  public Route put() {
    return null;
  }

  @Override
  public Route put(String path) {
    return null;
  }

  @Override
  public Route putWithRegex(String regex) {
    return null;
  }

  @Override
  public Route post() {
    return null;
  }

  @Override
  public Route post(String path) {
    return null;
  }

  @Override
  public Route postWithRegex(String regex) {
    return null;
  }

  @Override
  public Route delete() {
    return null;
  }

  @Override
  public Route delete(String path) {
    return null;
  }

  @Override
  public Route deleteWithRegex(String regex) {
    return null;
  }

  @Override
  public Route trace() {
    return null;
  }

  @Override
  public Route trace(String path) {
    return null;
  }

  @Override
  public Route traceWithRegex(String regex) {
    return null;
  }

  @Override
  public Route connect() {
    return null;
  }

  @Override
  public Route connect(String path) {
    return null;
  }

  @Override
  public Route connectWithRegex(String regex) {
    return null;
  }

  @Override
  public Route patch() {
    return null;
  }

  @Override
  public Route patch(String path) {
    return null;
  }

  @Override
  public Route patchWithRegex(String regex) {
    return null;
  }

  @Override
  public List<Route> getRoutes() {
    return null;
  }

  @Override
  public Router clear() {
    return null;
  }

  @Override
  public Router mountSubRouter(String mountPoint, Router subRouter) {
    return null;
  }

  @Override
  public Router exceptionHandler(@Nullable Handler<Throwable> exceptionHandler) {
    return null;
  }

  @Override
  public void handleContext(RoutingContext context) {

  }

  @Override
  public void handleFailure(RoutingContext context) {

  }
}
