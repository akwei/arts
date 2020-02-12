package com.github.akwei.me;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NioTest {

    @Test
    public void file() throws Exception {
        String path = "/Users/akwei/Movies/.C3FE51B4B4520B303FCE90A93A532F1335FAC2E9.js";
        RandomAccessFile rfile = new RandomAccessFile(path, "rw");
        FileChannel inChannel = rfile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(10);
        int read = inChannel.read(buf);
        while (read != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            buf.clear();
            read = inChannel.read(buf);
        }
        rfile.close();
    }

    @Test
    public void socket() throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9999));
        ByteBuffer buf = ByteBuffer.allocate(2);
        int read = socketChannel.read(buf);
        byte[] data = new byte[1024];
        int pos = 0;
        while (read != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                buf.get(data, pos, buf.remaining());
            }
            int position = buf.position();
            pos = pos + position;
            buf.clear();
            read = socketChannel.read(buf);
        }
        socketChannel.close();
    }
}
