package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

/* compiled from: TemporalLevelEntry.java */
/* loaded from: classes2.dex */
public class e extends b {

    private boolean a;
    private short b;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        int i = 128;
        ByteBuffer allocate = ByteBuffer.allocate(1);
        int r1 = this.a ? 128 : 0;
        allocate.put((this.a ? 128 : 0));
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int i = 1;
        final int i2 = 128;
        byteBuffer = (byteBuffer.get() & i2) == i2 ? 1 : 0;
        this.a = ((byteBuffer.get() & i2) == i2 ? 1 : 0);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = e.class;
            if (obj == object.getClass()) {
                if (this.a != object.a) {
                    return false;
                }
                return this.b != object.b ? z2 : z;
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TemporalLevelEntry";
        String str3 = "{levelIndependentlyDecodable=";
        str = str2 + str3 + this.a + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "tele";
    }
}
