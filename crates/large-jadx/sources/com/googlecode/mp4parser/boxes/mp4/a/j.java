package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.c;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
@g(tags = 19)
public class j extends com.googlecode.mp4parser.boxes.mp4.a.b {

    byte[] d;
    public j() {
        super();
        this.a = 19;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        RuntimeException runtimeException = new RuntimeException("Not Implemented");
        throw runtimeException;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        int bArr;
        if (b() > 0) {
            bArr = new byte[b()];
            this.d = bArr;
            byteBuffer.get(bArr);
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtensionDescriptor");
        stringBuilder.append("{bytes=");
        byte[] bArr = this.d;
        if (bArr == null) {
            str = "null";
        } else {
            str = c.a(bArr);
        }
        stringBuilder.append(str);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
