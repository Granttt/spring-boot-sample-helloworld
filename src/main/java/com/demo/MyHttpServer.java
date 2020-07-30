package com.demo;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

/**
 * @author GXY
 * @Package com.demo
 * @date 2020/6/3 17:46
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class MyHttpServer {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        //创建一个HttpServer
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(httpServerRequest -> {
            // 获取到response对象
            HttpServerResponse response = httpServerRequest.response();

            // 设置响应头
            response.putHeader("Content-type", "text/html;charset=utf-8");

            // 响应数据
            response.end("Hello World");
        });
        //监听8888端口
        httpServer.listen(8888);
    }
}
