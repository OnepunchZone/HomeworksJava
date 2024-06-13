package ru.otus.java.basic.clientservercalculator.client;

import java.io.*;
import java.net.Socket;

public class PingClient {
    private final DataInputStream in;
    private final DataOutputStream out;

    public PingClient(Socket socket) throws IOException {
        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        this.out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void sendNum(double num) throws IOException {
        out.writeDouble(num);
        out.flush();
    }

    public void sendSymbol(char symbol) throws IOException {
        out.writeChar(symbol);
        out.flush();
    }

    public double read() throws IOException {
        return  in.readDouble();
    }
}
