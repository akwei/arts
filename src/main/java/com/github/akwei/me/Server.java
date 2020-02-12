package com.github.akwei.me;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("begin connect ... ...");
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put("hi akwei".getBytes(StandardCharsets.UTF_8));
            buf.flip();
            socketChannel.write(buf);
            socketChannel.close();
            System.out.println("end connect ... ...");
        }
    }
}
