package com.googlecode.mp4parser.boxes.mp4.a;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class o extends com.googlecode.mp4parser.boxes.mp4.a.b {

    private ByteBuffer d;
    static {
        Logger.getLogger(o.class.getName());
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        RuntimeException runtimeException = new RuntimeException("sdjlhfl");
        throw runtimeException;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        this.d = byteBuffer.slice();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UnknownDescriptor");
        stringBuilder.append("{tag=");
        stringBuilder.append(this.a);
        stringBuilder.append(", sizeOfInstance=");
        stringBuilder.append(this.b);
        stringBuilder.append(", data=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
