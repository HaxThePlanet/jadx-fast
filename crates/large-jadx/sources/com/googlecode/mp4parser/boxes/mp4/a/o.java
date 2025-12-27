package com.googlecode.mp4parser.boxes.mp4.a;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* compiled from: UnknownDescriptor.java */
/* loaded from: classes2.dex */
public class o extends b {

    private ByteBuffer d;
    static {
        Logger.getLogger(o.class.getName());
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        throw new RuntimeException("sdjlhfl");
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        this.d = byteBuffer.slice();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UnknownDescriptor";
        String str3 = "{tag=";
        String str4 = ", sizeOfInstance=";
        String str5 = ", data=";
        str = str2 + str3 + this.a + str4 + this.b + str5 + this.d + 125;
        return str;
    }
}
