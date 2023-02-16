package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {

    private final RequestLine requestLine;
//    private final HttpHeaders httpHeaders;
//    private final Body body;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    // GET 메서드인지 체크하는 메서드
    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    // 요청한 url이 제대로 들어왔는지 체크
    public boolean matchPath(String requestPath) {
        return requestLine.matchPath(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
