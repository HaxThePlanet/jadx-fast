package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        return ByteBuffer.allocate(0);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "stsa";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.mp4parser.iso14496.part15.c> obj;
        Class obj3;
        final int i = 1;
        if (this == object) {
            return i;
        }
        if (object != null && c.class != object.getClass()) {
            if (c.class != object.getClass()) {
            }
            return i;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        return 37;
    }
}
