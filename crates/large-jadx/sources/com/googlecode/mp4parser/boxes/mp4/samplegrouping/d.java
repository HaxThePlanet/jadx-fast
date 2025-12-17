package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class d extends com.googlecode.mp4parser.boxes.mp4.samplegrouping.b {

    private short a;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort(this.a);
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "roll";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        this.a = byteBuffer.getShort();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.d> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (d.class != object.getClass()) {
            } else {
                if (this.a != object.a) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        return this.a;
    }
}
