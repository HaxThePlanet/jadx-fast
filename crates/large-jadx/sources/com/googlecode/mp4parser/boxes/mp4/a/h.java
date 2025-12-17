package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
@g(tags = 3)
public class h extends com.googlecode.mp4parser.boxes.mp4.a.b {

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
    com.googlecode.mp4parser.boxes.mp4.a.e n;
    com.googlecode.mp4parser.boxes.mp4.a.n o;
    List<com.googlecode.mp4parser.boxes.mp4.a.b> p;
    static {
        Logger.getLogger(h.class.getName());
    }

    public h() {
        super();
        int i = 0;
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        this.a = 3;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        int i2;
        int i;
        i2 = this.e > 0 ? 5 : 3;
        if (this.f > 0) {
            i2 += i;
        }
        if (this.g > 0) {
            i2 += 2;
        }
        if (this.p.size() > 0) {
        } else {
            return i4 += i8;
        }
        RuntimeException runtimeException = new RuntimeException(" Doesn't handle other descriptors yet");
        throw runtimeException;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        int i4;
        int i3;
        int i2;
        int i;
        this.d = e.i(byteBuffer);
        int i6 = e.n(byteBuffer);
        i = i6 >>> 7;
        this.e = i;
        final int i13 = 1;
        this.f = i9 &= i13;
        this.g = i11 &= i13;
        this.h = i6 &= 31;
        if (i == i13) {
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
            i2 = l.a(-1, byteBuffer);
            if (i2 instanceof e != 0) {
            } else {
            }
            if (i2 instanceof n != 0) {
            } else {
            }
            this.p.add(i2);
            this.o = (n)i2;
            this.n = (e)i2;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        boolean equals;
        com.googlecode.mp4parser.boxes.mp4.a.e equals2;
        boolean equals3;
        Class<com.googlecode.mp4parser.boxes.mp4.a.h> obj;
        String i;
        Class class;
        boolean obj5;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        final int i3 = 0;
        if (object != null) {
            if (h.class != object.getClass()) {
            } else {
                if (this.f != object.f) {
                    return i3;
                }
                if (this.i != object.i) {
                    return i3;
                }
                if (this.l != object.l) {
                    return i3;
                }
                if (this.d != object.d) {
                    return i3;
                }
                if (this.m != object.m) {
                    return i3;
                }
                if (this.g != object.g) {
                    return i3;
                }
                if (this.k != object.k) {
                    return i3;
                }
                if (this.e != object.e) {
                    return i3;
                }
                if (this.h != object.h) {
                    return i3;
                }
                String str = this.j;
                if (str != null) {
                    if (!str.equals(object.j)) {
                        return i3;
                    }
                } else {
                    if (object.j != null) {
                    }
                }
                com.googlecode.mp4parser.boxes.mp4.a.e eVar = this.n;
                if (eVar != null) {
                    if (!eVar.equals(object.n)) {
                        return i3;
                    }
                } else {
                    if (object.n != null) {
                    }
                }
                List list = this.p;
                if (list != null) {
                    if (!list.equals(object.p)) {
                        return i3;
                    }
                } else {
                    if (object.p != null) {
                    }
                }
                com.googlecode.mp4parser.boxes.mp4.a.n nVar = this.o;
                obj5 = object.o;
                if (nVar != null) {
                    if (!nVar.equals(obj5)) {
                        return i3;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i2;
        }
        return i3;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public ByteBuffer g() {
        int i;
        int i2;
        int i3;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[b()]);
        g.j(wrap, 3);
        f(wrap, a());
        g.e(wrap, this.d);
        g.j(wrap, i11 |= i19);
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
        int i2;
        int i4;
        int i;
        int i3;
        String str = this.j;
        i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = i3;
        }
        com.googlecode.mp4parser.boxes.mp4.a.e eVar = this.n;
        if (eVar != null) {
            i4 = eVar.hashCode();
        } else {
            i4 = i3;
        }
        com.googlecode.mp4parser.boxes.mp4.a.n nVar = this.o;
        if (nVar != null) {
            i = nVar.hashCode();
        } else {
            i = i3;
        }
        List list = this.p;
        if (list != null) {
            i3 = list.hashCode();
        }
        return i28 += i3;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ESDescriptor");
        stringBuilder.append("{esId=");
        stringBuilder.append(this.d);
        stringBuilder.append(", streamDependenceFlag=");
        stringBuilder.append(this.e);
        stringBuilder.append(", URLFlag=");
        stringBuilder.append(this.f);
        stringBuilder.append(", oCRstreamFlag=");
        stringBuilder.append(this.g);
        stringBuilder.append(", streamPriority=");
        stringBuilder.append(this.h);
        stringBuilder.append(", URLLength=");
        stringBuilder.append(this.i);
        stringBuilder.append(", URLString='");
        stringBuilder.append(this.j);
        stringBuilder.append('\'');
        stringBuilder.append(", remoteODFlag=");
        stringBuilder.append(this.k);
        stringBuilder.append(", dependsOnEsId=");
        stringBuilder.append(this.l);
        stringBuilder.append(", oCREsId=");
        stringBuilder.append(this.m);
        stringBuilder.append(", decoderConfigDescriptor=");
        stringBuilder.append(this.n);
        stringBuilder.append(", slConfigDescriptor=");
        stringBuilder.append(this.o);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
