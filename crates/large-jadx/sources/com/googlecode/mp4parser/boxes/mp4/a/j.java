package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.c;
import java.nio.ByteBuffer;

/* compiled from: ExtensionProfileLevelDescriptor.java */
@g(tags = 19)
/* loaded from: classes2.dex */
public class j extends b {

    byte[] d;
    public j() {
        super();
        this.a = 19;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        throw new RuntimeException("Not Implemented");
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        if (b() > 0) {
            byte[] bArr = new byte[b()];
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
        if (this.d == null) {
            str = "null";
        } else {
            str = c.a(this.d);
        }
        stringBuilder.append(str);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
