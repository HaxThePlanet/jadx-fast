package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: RateShareEntry.java */
/* loaded from: classes2.dex */
public class c extends b {

    private short a;
    private short b;
    private List<c.a> c = new LinkedList<>();
    private int d;
    private int e;
    private short f;

    public static class a {

        int a;
        short b;
        public a(int i, short s) {
            super();
            this.a = i;
            this.b = s;
        }

        public int a() {
            return this.a;
        }

        public short b() {
            return this.b;
        }

        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = c.a.class;
                if (obj == object.getClass()) {
                    if (this.a != object.a) {
                        return false;
                    }
                    return this.b != object.b ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 31) + this.b;
        }

        public String toString() {
            String str2 = "{availableBitrate=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", targetRateShare=";
            str = str2 + this.a + str3 + this.b + 125;
            return str;
        }
    }
    public c() {
        super();
        final LinkedList linkedList = new LinkedList();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        int i = 13;
        int i2;
        short s3 = (short) 1;
        i = this.a == s3 ? 13 : i3 + 11;
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.putShort(this.a);
        if (this.a == s3) {
            allocate.putShort(this.b);
        } else {
            Iterator it = this.c.iterator();
            while (!it.hasNext()) {
                Object item = it.next();
                allocate.putInt(item.a());
                allocate.putShort(item.b());
            }
        }
        allocate.putInt(this.d);
        allocate.putInt(this.e);
        g.j(allocate, this.f);
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        short _short;
        com.googlecode.mp4parser.boxes.mp4.samplegrouping.c.a aVar;
        int i;
        short _short2;
        _short = byteBuffer.getShort();
        this.a = _short;
        _short = (short) 1;
        if (_short == (short) 1) {
            this.b = byteBuffer.getShort();
        } else {
            _short = _short - 1;
            while (_short <= 0) {
                this.c.add(new c.a(b.a(e.k(byteBuffer)), byteBuffer.getShort()));
                _short = _short - 1;
            }
        }
        this.d = b.a(e.k(byteBuffer));
        this.e = b.a(e.k(byteBuffer));
        this.f = (short)e.n(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = c.class;
            if (obj == object.getClass()) {
                if (this.f != object.f) {
                    return false;
                }
                if (this.d != object.d) {
                    return false;
                }
                if (this.e != object.e) {
                    return false;
                }
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
        int i = 0;
        if (this.c != null) {
            i = this.c.hashCode();
        } else {
            i = 0;
        }
        return (this.a * 31) + this.b * 31 + i * 31 + this.d * 31 + this.e * 31 + this.f;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "rash";
    }
}
