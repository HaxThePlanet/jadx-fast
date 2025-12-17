package com.google.firebase.database.tubesock;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
class WebSocketWriter {

    private WritableByteChannel channel;
    private boolean closeSent = false;
    private final Thread innerThread;
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private final Random random;
    private volatile boolean stop = false;
    private com.google.firebase.database.tubesock.WebSocket websocket;
    WebSocketWriter(com.google.firebase.database.tubesock.WebSocket webSocket, String string2, int i3) {
        super();
        Random random = new Random();
        this.random = random;
        int i = 0;
        WebSocketWriter.1 anon = new WebSocketWriter.1(this);
        this.innerThread = WebSocket.getThreadFactory().newThread(anon);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("Writer-");
        stringBuilder.append(i3);
        WebSocket.getIntializer().setName(getInnerThread(), stringBuilder.toString());
        this.websocket = webSocket;
        LinkedBlockingQueue obj4 = new LinkedBlockingQueue();
        this.pendingBuffers = obj4;
    }

    static void access$000(com.google.firebase.database.tubesock.WebSocketWriter webSocketWriter) {
        webSocketWriter.runWriter();
    }

    private ByteBuffer frameInBuffer(byte b, boolean z2, byte[] b3Arr3) {
        int i2;
        int length;
        int i4;
        int i;
        int i3;
        int obj6;
        byte[] obj7;
        i2 = z2 != null ? 6 : 2;
        length = b3Arr3.length;
        i = 65535;
        i3 = 126;
        if (length < i3) {
        } else {
            i2 = length <= i ? i2 + 2 : i2 + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length2 += i2);
        allocate.put((byte)obj6);
        if (length < i3) {
            if (z2 != null) {
                length |= 128;
            }
            allocate.put((byte)length);
        } else {
            if (length <= i) {
                if (z2 != null) {
                    i3 = 254;
                }
                allocate.put((byte)i3);
                allocate.putShort((short)length);
            } else {
                i4 = 127;
                if (z2 != null) {
                    i4 = 255;
                }
                allocate.put((byte)i4);
                allocate.putInt(0);
                allocate.putInt(length);
            }
        }
        if (z2 != null) {
            obj7 = generateMask();
            allocate.put(obj7);
            for (byte b2 : b3Arr3) {
                allocate.put((byte)i5);
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] generateMask() {
        byte[] bArr = new byte[4];
        this.random.nextBytes(bArr);
        return bArr;
    }

    private void handleError(com.google.firebase.database.tubesock.WebSocketException webSocketException) {
        this.websocket.handleReceiverError(webSocketException);
    }

    private void runWriter() {
        boolean interrupted;
        int i;
        com.google.firebase.database.tubesock.WebSocketException webSocketException;
        String str;
        try {
            while (!this.stop) {
                if (!Thread.interrupted()) {
                }
                writeMessage();
            }
            if (!Thread.interrupted()) {
            }
            writeMessage();
            i = 0;
            while (i < this.pendingBuffers.size()) {
                writeMessage();
                i++;
            }
            writeMessage();
            i++;
            webSocketException = new WebSocketException("IO Exception", th);
            handleError(webSocketException);
        }
    }

    private void writeMessage() {
        this.channel.write((ByteBuffer)this.pendingBuffers.take());
    }

    Thread getInnerThread() {
        return this.innerThread;
    }

    void send(byte b, boolean z2, byte[] b3Arr3) {
        byte obj2;
        boolean obj4;
        final int i = 8;
        synchronized (this) {
            try {
                if (this.closeSent) {
                } else {
                }
                if (b != i) {
                } else {
                }
                obj2 = new WebSocketException("Shouldn't be sending");
                throw obj2;
                if (b == i) {
                }
                this.closeSent = true;
                this.pendingBuffers.add(frameInBuffer(b, z2, b3Arr3));
                throw b;
            }
        }
    }

    void setOutput(OutputStream outputStream) {
        this.channel = Channels.newChannel(outputStream);
    }

    void stopIt() {
        this.stop = true;
    }
}
