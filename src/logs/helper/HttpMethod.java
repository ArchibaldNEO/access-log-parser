package logs.helper;

enum HttpMethod {
  GET("GET"),
  POST("POST"),
  PUT("PUT"),
  DELETE("DELETE"),
  PATCH("PATCH"),
  HEAD("HEAD"),
  OPTIONS("OPTIONS"),
  CONNECT("CONNECT"),
  TRACE("TRACE");

  private final String title;

  HttpMethod(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }
}
