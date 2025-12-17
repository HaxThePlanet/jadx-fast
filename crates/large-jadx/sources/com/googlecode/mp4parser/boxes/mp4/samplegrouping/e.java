package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class e extends com.googlecode.mp4parser.boxes.mp4.samplegrouping.b {

    private boolean a;
    private short b;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        int i;
        ByteBuffer allocate = ByteBuffer.allocate(1);
        i = this.a ? 128 : 0;
        allocate.put((byte)i);
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "tele";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int obj2;
        final int i = 128;
        obj2 = obj2 &= i == i ? 1 : 0;
        this.a = obj2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.e> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (e.class != object.getClass()) {
            } else {
                if (this.a != object.a) {
                    return i2;
                }
                if (this.b != object.b) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        return i += s;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemporalLevelEntry");
        stringBuilder.append("{levelIndependentlyDecodable=");
        stringBuilder.append(this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
