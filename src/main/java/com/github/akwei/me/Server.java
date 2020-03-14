package com.github.akwei.me;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {

    }

    public static void server1(String[] args) throws IOException {
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

    public static void server2(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress addr = new InetSocketAddress(9999);
        serverSocket.bind(addr);
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        int num = selector.select();
    }
}
