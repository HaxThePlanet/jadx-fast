package com.google.firebase.database.tubesock;

import java.io.DataInputStream;

/* loaded from: classes2.dex */
class WebSocketReceiver {

    private com.google.firebase.database.tubesock.WebSocketEventHandler eventHandler = null;
    private DataInputStream input = null;
    private byte[] inputHeader;
    private com.google.firebase.database.tubesock.MessageBuilderFactory.Builder pendingBuilder;
    private volatile boolean stop = false;
    private com.google.firebase.database.tubesock.WebSocket websocket = null;
    WebSocketReceiver(com.google.firebase.database.tubesock.WebSocket webSocket) {
        super();
        int i = 0;
        this.inputHeader = new byte[112];
        int i3 = 0;
        this.websocket = webSocket;
    }

    private void appendBytes(boolean z, byte b2, byte[] b3Arr3) {
        int pendingBuilder;
        com.google.firebase.database.tubesock.WebSocketMessage obj2;
        int obj3;
        if (b2 == 9) {
            if (z == null) {
            } else {
                handlePing(b3Arr3);
            }
            obj2 = new WebSocketException("PING must not fragment across frames");
            throw obj2;
        }
        pendingBuilder = this.pendingBuilder;
        if (pendingBuilder != null) {
            if (b2 != 0) {
            } else {
            }
            obj2 = new WebSocketException("Failed to continue outstanding frame");
            throw obj2;
        }
        if (pendingBuilder == null) {
            if (b2 == 0) {
            } else {
            }
            obj2 = new WebSocketException("Received continuing frame, but there's nothing to continue");
            throw obj2;
        }
        if (pendingBuilder == null) {
            this.pendingBuilder = MessageBuilderFactory.builder(b2);
        }
        if (!this.pendingBuilder.appendBytes(b3Arr3)) {
        } else {
            if (z != null) {
                obj2 = this.pendingBuilder.toMessage();
                this.pendingBuilder = 0;
                if (obj2 == null) {
                } else {
                    this.eventHandler.onMessage(obj2);
                }
                obj2 = new WebSocketException("Failed to decode whole message");
                throw obj2;
            }
        }
        obj2 = new WebSocketException("Failed to decode frame");
        throw obj2;
    }

    private void handleError(com.google.firebase.database.tubesock.WebSocketException webSocketException) {
        stopit();
        this.websocket.handleReceiverError(webSocketException);
    }

    private void handlePing(byte[] bArr) {
        if (bArr.length > 125) {
        } else {
            this.websocket.pong(bArr);
        }
        WebSocketException obj3 = new WebSocketException("PING frame too long");
        throw obj3;
    }

    private long parseLong(byte[] bArr, int i2) {
        return i9 += obj6;
    }

    private int read(byte[] bArr, int i2, int i3) {
        this.input.readFully(bArr, i2, i3);
        return i3;
    }

    boolean isRunning() {
        return stop ^= 1;
    }

    void run() {
        com.google.firebase.database.tubesock.WebSocketEventHandler eventHandler;
        int i2;
        com.google.firebase.database.tubesock.WebSocketException webSocketException;
        String str;
        byte[] bArr;
        int inputHeader;
        int i5;
        byte b;
        int i3;
        int i7;
        int long;
        long l;
        int i6;
        int i4;
        int i;
        this.eventHandler = this.websocket.getEventHandler();
        while (!this.stop) {
            webSocketException = 1;
            str = 0;
            read += str;
            byte[] inputHeader4 = this.inputHeader;
            if (b4 &= 128 != 0) {
            } else {
            }
            i5 = str;
            if (b5 &= 112 != 0) {
            } else {
            }
            i3 = str;
            b = (byte)i14;
            i8 += read2;
            inputHeader = this.inputHeader;
            i7 = inputHeader[webSocketException];
            long = 0;
            i6 = 126;
            i4 = 2;
            i = 8;
            if (i7 < i6) {
            } else {
            }
            if (i7 == i6) {
            } else {
            }
            if (i7 == 127) {
            }
            int i10 = (int)long;
            bArr = new byte[i10];
            read(bArr, str, i10);
            appendBytes(i5, b, bArr);
            this.websocket.onCloseOpReceived();
            long = parseLong(this.inputHeader, i9 -= i);
            read(inputHeader, i2, i4);
            byte[] inputHeader3 = this.inputHeader;
            long = i7 | l;
            long = (long)i7;
            i3 = webSocketException;
            i5 = webSocketException;
        }
    }

    void setInput(DataInputStream dataInputStream) {
        this.input = dataInputStream;
    }

    void stopit() {
        this.stop = true;
    }
}
