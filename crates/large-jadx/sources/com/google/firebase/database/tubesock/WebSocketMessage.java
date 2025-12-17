package com.google.firebase.database.tubesock;

/* loaded from: classes2.dex */
public class WebSocketMessage {

    private byte[] byteMessage;
    private byte opcode;
    private String stringMessage;
    public WebSocketMessage(String string) {
        super();
        this.stringMessage = string;
        this.opcode = 1;
    }

    public WebSocketMessage(byte[] bArr) {
        super();
        this.byteMessage = bArr;
        this.opcode = 2;
    }

    public byte[] getBytes() {
        return this.byteMessage;
    }

    public String getText() {
        return this.stringMessage;
    }

    public boolean isBinary() {
        int i;
        i = this.opcode == 2 ? 1 : 0;
        return i;
    }

    public boolean isText() {
        int i;
        if (this.opcode == 1) {
        } else {
            i = 0;
        }
        return i;
    }
}
