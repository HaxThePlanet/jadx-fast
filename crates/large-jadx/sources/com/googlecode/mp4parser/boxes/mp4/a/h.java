package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: ESDescriptor.java */
@g(tags = 3)
/* loaded from: classes2.dex */
public class h extends b {

    int d;
    int e;
    int f;
    int g;
    int h;
    int i = 0;
    String j;
    int k;
    int l;
    int m;
    e n;
    n o;
    List<b> p = new ArrayList<>();
    static {
        Logger.getLogger(h.class.getName());
    }

    public h() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = 3;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        int i = 3;
        int r0 = this.e > 0 ? 5 : 3;
        if (this.f > 0) {
            i2 = this.i + 1;
            i = i + i2;
        }
        if (this.g > 0) {
            i = i + 2;
        }
        if (this.p.size() > 0) {
            throw new RuntimeException(" Doesn't handle other descriptors yet");
        } else {
            return (i + this.n.b()) + this.o.b();
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        this.d = e.i(byteBuffer);
        int i6 = e.n(byteBuffer);
        i4 = i6 >>> 7;
        this.e = i4;
        final int i13 = 1;
        this.f = (i6 >>> 6) & i13;
        this.g = (i6 >>> 5) & i13;
        i = i6 & 31;
        this.h = i;
        if (i4 == i13) {
            this.l = e.i(byteBuffer);
        }
        if (this.f == i13) {
            int i7 = e.n(byteBuffer);
            this.i = i7;
            this.j = e.h(byteBuffer, i7);
        }
        if (this.g == i13) {
            this.m = e.i(byteBuffer);
        }
        while (byteBuffer.remaining() <= i13) {
            com.googlecode.mp4parser.boxes.mp4.a.b bVar = l.a(-1, byteBuffer);
            i4 = bVar instanceof e;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        String str;
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = h.class;
            if (obj == object.getClass()) {
                if (this.f != object.f) {
                    return false;
                }
                if (this.i != object.i) {
                    return false;
                }
                if (this.l != object.l) {
                    return false;
                }
                if (this.d != object.d) {
                    return false;
                }
                if (this.m != object.m) {
                    return false;
                }
                if (this.g != object.g) {
                    return false;
                }
                if (this.k != object.k) {
                    return false;
                }
                if (this.e != object.e) {
                    return false;
                }
                if (this.h != object.h) {
                    return false;
                }
                if (this.j != null) {
                    if (!this.j.equals(object.j)) {
                        return false;
                    }
                }
                if (this.n != null) {
                    if (!this.n.equals(object.n)) {
                        return false;
                    }
                }
                if (this.p != null) {
                    if (!this.p.equals(object.p)) {
                        return false;
                    }
                }
                if (this.o != null) {
                    if (!this.o.equals(object.o)) {
                        return false;
                    }
                } else {
                    return object.o != null ? z2 : z;
                }
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public ByteBuffer g() {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[b()]);
        g.j(wrap, 3);
        f(wrap, a());
        g.e(wrap, this.d);
        g.j(wrap, (this.e << 7) | (this.f << 6) | (this.g << 5) | (this.h & 31));
        if (this.e > 0) {
            g.e(wrap, this.l);
        }
        if (this.f > 0) {
            g.j(wrap, this.i);
            g.k(wrap, this.j);
        }
        if (this.g > 0) {
            g.e(wrap, this.m);
        }
        wrap.put(this.n.g().array());
        wrap.put(this.o.g().array());
        return wrap;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public int hashCode() {
        int i;
        i = 0;
        if (this.j != null) {
            i = this.j.hashCode();
        } else {
        }
        if (this.n != null) {
            i = this.n.hashCode();
        } else {
        }
        if (this.o != null) {
            i = this.o.hashCode();
        } else {
        }
        if (this.p != null) {
            i = this.p.hashCode();
        }
        return (this.d * 31) + this.e * 31 + this.f * 31 + this.g * 31 + this.h * 31 + this.i * 31 + i * 31 + this.k * 31 + this.l * 31 + this.m * 31 + i * 31 + i * 31 + i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ESDescriptor";
        String str3 = "{esId=";
        String str4 = ", streamDependenceFlag=";
        String str5 = ", URLFlag=";
        String str6 = ", oCRstreamFlag=";
        String str7 = ", streamPriority=";
        String str8 = ", URLLength=";
        String str9 = ", URLString='";
        String str11 = ", remoteODFlag=";
        String str12 = ", dependsOnEsId=";
        String str13 = ", oCREsId=";
        String str14 = ", decoderConfigDescriptor=";
        String str15 = ", slConfigDescriptor=";
        str = str2 + str3 + this.d + str4 + this.e + str5 + this.f + str6 + this.g + str7 + this.h + str8 + this.i + str9 + this.j + 39 + str11 + this.k + str12 + this.l + str13 + this.m + str14 + this.n + str15 + this.o + 125;
        return str;
    }
}
