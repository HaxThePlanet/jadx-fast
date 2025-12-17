package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.h.k;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes2.dex */
public class a extends com.googlecode.mp4parser.boxes.mp4.samplegrouping.b {

    private boolean a;
    private byte b;
    private UUID c;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        byte[] bArr;
        ByteBuffer allocate = ByteBuffer.allocate(20);
        g.f(allocate, this.a);
        if (this.a) {
            g.j(allocate, this.b);
            allocate.put(k.b(this.c));
        } else {
            allocate.put(new byte[17]);
        }
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "seig";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int i;
        if (e.j(byteBuffer) == 1) {
        } else {
            i = 0;
        }
        this.a = i;
        this.b = (byte)i3;
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.c = k.a(bArr);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.a> obj;
        Class class;
        UUID obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (a.class != object.getClass()) {
            } else {
                if (this.a != object.a) {
                    return i2;
                }
                if (this.b != object.b) {
                    return i2;
                }
                UUID uuid = this.c;
                obj5 = object.c;
                if (uuid != null) {
                    if (!uuid.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        int i2;
        int i;
        i2 = this.a ? 7 : 19;
        UUID uuid = this.c;
        if (uuid != null) {
            i = uuid.hashCode();
        } else {
            i = 0;
        }
        return i5 += i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CencSampleEncryptionInformationGroupEntry{isEncrypted=");
        stringBuilder.append(this.a);
        stringBuilder.append(", ivSize=");
        stringBuilder.append(this.b);
        stringBuilder.append(", kid=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
