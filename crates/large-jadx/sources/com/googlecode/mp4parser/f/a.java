package com.googlecode.mp4parser.f;

import com.googlecode.mp4parser.boxes.piff.a;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public class a extends a {

    public static UUID c;
    ByteBuffer b;
    static {
        a.c = UUID.fromString("00000000-0000-0000-0000-000000000000");
        a.a.put(a.c, a.class);
    }

    @Override // com.googlecode.mp4parser.boxes.piff.a
    public ByteBuffer b() {
        return this.b;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.a
    public void c(ByteBuffer byteBuffer) {
        this.b = byteBuffer;
    }
}
