package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.h.k;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: CencSampleEncryptionInformationGroupEntry.java */
/* loaded from: classes2.dex */
public class a extends b {

    private boolean a;
    private byte b;
    private UUID c;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
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
    public void c(ByteBuffer byteBuffer) {
        int i = 1;
        i = 1;
        if (e.j(byteBuffer) != 1) {
            i = 0;
        }
        this.a = i;
        this.b = (byte)e.n(byteBuffer);
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.c = k.a(bArr);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = a.class;
            if (obj == object.getClass()) {
                if (this.a != object.a) {
                    return false;
                }
                if (this.b != object.b) {
                    return false;
                }
                if (this.c != null) {
                    if (!this.c.equals(object.c)) {
                        return false;
                    }
                } else {
                    return object.c != null ? z2 : z;
                }
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        int i = 7;
        int i2 = 0;
        int r0 = this.a ? 7 : 19;
        if (this.c != null) {
            i2 = this.c.hashCode();
        } else {
            i2 = 0;
        }
        return (this.a ? 7 : 19) * 31 + i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        String str2 = "CencSampleEncryptionInformationGroupEntry{isEncrypted=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", ivSize=";
        String str4 = ", kid=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "seig";
    }
}
