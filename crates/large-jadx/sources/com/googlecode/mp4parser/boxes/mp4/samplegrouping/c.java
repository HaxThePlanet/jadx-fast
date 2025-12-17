package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class c extends com.googlecode.mp4parser.boxes.mp4.samplegrouping.b {

    private short a;
    private short b;
    private List<com.googlecode.mp4parser.boxes.mp4.samplegrouping.c.a> c;
    private int d;
    private int e;
    private short f;

    public static class a {

        int a;
        short b;
        public a(int i, short s2) {
            super();
            this.a = i;
            this.b = s2;
        }

        public int a() {
            return this.a;
        }

        public short b() {
            return this.b;
        }

        public boolean equals(Object object) {
            Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.c.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (c.a.class != object.getClass()) {
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

        public int hashCode() {
            return i2 += s;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{availableBitrate=");
            stringBuilder.append(this.a);
            stringBuilder.append(", targetRateShare=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    public c() {
        super();
        LinkedList linkedList = new LinkedList();
        this.c = linkedList;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        int i2;
        Iterator iterator;
        boolean next;
        int i;
        short s = this.a;
        int i4 = 1;
        i2 = s == i4 ? 13 : i3 + 11;
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.putShort(this.a);
        if (this.a == i4) {
            allocate.putShort(this.b);
        } else {
            iterator = this.c.iterator();
            for (c.a next2 : iterator) {
                allocate.putInt(next2.a());
                allocate.putShort(next2.b());
            }
        }
        allocate.putInt(this.d);
        allocate.putInt(this.e);
        g.j(allocate, this.f);
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "rash";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        short short;
        int i;
        com.googlecode.mp4parser.boxes.mp4.samplegrouping.c.a aVar;
        int i2;
        long short2;
        short = byteBuffer.getShort();
        this.a = short;
        if (short == 1) {
            this.b = byteBuffer.getShort();
        }
        this.d = b.a(e.k(byteBuffer));
        this.e = b.a(e.k(byteBuffer));
        this.f = (short)obj6;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.c> obj;
        Class class;
        List obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (c.class != object.getClass()) {
            } else {
                if (this.f != object.f) {
                    return i2;
                }
                if (this.d != object.d) {
                    return i2;
                }
                if (this.e != object.e) {
                    return i2;
                }
                if (this.a != object.a) {
                    return i2;
                }
                if (this.b != object.b) {
                    return i2;
                }
                List list = this.c;
                obj5 = object.c;
                if (list != null) {
                    if (!list.equals(obj5)) {
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
        int i;
        List list = this.c;
        if (list != null) {
            i = list.hashCode();
        } else {
            i = 0;
        }
        return i10 += s3;
    }
}
