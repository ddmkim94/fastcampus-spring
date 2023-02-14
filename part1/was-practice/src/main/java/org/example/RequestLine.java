package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPath;
    private QueryStrings queryStrings;

    public RequestLine(String method, String urlPath, String queryStrings) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryStrings);
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    public boolean isGetRequest() {
        return this.method.equals("GET");
    }

    public boolean matchPath(String requestPath) {
        return this.urlPath.equals(requestPath);
    }

    public String getMethod() {
        return method;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }
}
