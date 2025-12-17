package com.googlecode.mp4parser.boxes.threegpp26244;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.boxes.mp4.a.c;
import com.googlecode.mp4parser.boxes.mp4.a.d;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class SegmentIndexBox extends AbstractFullBox {

    public static final String TYPE = "sidx";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_12;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    long earliestPresentationTime;
    List<com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox.a> entries;
    long firstOffset;
    long referenceId;
    int reserved;
    long timeScale;

    public static class a {

        byte a;
        int b;
        long c;
        byte d;
        byte e;
        int f;
        public byte a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.f;
        }

        public byte d() {
            return this.e;
        }

        public byte e() {
            return this.d;
        }

        public boolean equals(Object object) {
            Class<com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (SegmentIndexBox.a.class != object.getClass()) {
                } else {
                    if (this.a != object.a) {
                        return i2;
                    }
                    if (this.b != object.b) {
                        return i2;
                    }
                    if (this.f != object.f) {
                        return i2;
                    }
                    if (this.e != object.e) {
                        return i2;
                    }
                    if (this.d != object.d) {
                        return i2;
                    }
                    if (Long.compare(l, l2) != 0) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public long f() {
            return this.c;
        }

        public void g(byte b) {
            this.a = b;
        }

        public void h(int i) {
            this.b = i;
        }

        public int hashCode() {
            long l = this.c;
            return i9 += i14;
        }

        public void i(int i) {
            this.f = i;
        }

        public void j(byte b) {
            this.e = b;
        }

        public void k(byte b) {
            this.d = b;
        }

        public void l(long l) {
            this.c = l;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{referenceType=");
            stringBuilder.append(this.a);
            stringBuilder.append(", referencedSize=");
            stringBuilder.append(this.b);
            stringBuilder.append(", subsegmentDuration=");
            stringBuilder.append(this.c);
            stringBuilder.append(", startsWithSap=");
            stringBuilder.append(this.d);
            stringBuilder.append(", sapType=");
            stringBuilder.append(this.e);
            stringBuilder.append(", sapDeltaTime=");
            stringBuilder.append(this.f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        SegmentIndexBox.ajc$preClinit();
    }

    public SegmentIndexBox() {
        super("sidx");
        ArrayList arrayList = new ArrayList();
        this.entries = arrayList;
    }

    private static void ajc$preClinit() {
        b bVar14 = new b("SegmentIndexBox.java", SegmentIndexBox.class);
        final String str93 = "method-execution";
        SegmentIndexBox.ajc$tjp_0 = bVar14.h(str93, bVar14.g("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.util.List"), 128);
        SegmentIndexBox.ajc$tjp_1 = bVar14.h(str93, bVar14.g("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "java.util.List", "entries", "", "void"), 132);
        SegmentIndexBox.ajc$tjp_10 = bVar14.h(str93, bVar14.g("1", "getReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "int"), 168);
        SegmentIndexBox.ajc$tjp_11 = bVar14.h(str93, bVar14.g("1", "setReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "int", "reserved", "", "void"), 172);
        SegmentIndexBox.ajc$tjp_12 = bVar14.h(str93, bVar14.g("1", "toString", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.lang.String"), 298);
        SegmentIndexBox.ajc$tjp_2 = bVar14.h(str93, bVar14.g("1", "getReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 136);
        SegmentIndexBox.ajc$tjp_3 = bVar14.h(str93, bVar14.g("1", "setReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "referenceId", "", "void"), 140);
        SegmentIndexBox.ajc$tjp_4 = bVar14.h(str93, bVar14.g("1", "getTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 144);
        SegmentIndexBox.ajc$tjp_5 = bVar14.h(str93, bVar14.g("1", "setTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "timeScale", "", "void"), 148);
        SegmentIndexBox.ajc$tjp_6 = bVar14.h(str93, bVar14.g("1", "getEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 152);
        SegmentIndexBox.ajc$tjp_7 = bVar14.h(str93, bVar14.g("1", "setEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "earliestPresentationTime", "", "void"), 156);
        SegmentIndexBox.ajc$tjp_8 = bVar14.h(str93, bVar14.g("1", "getFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 160);
        SegmentIndexBox.ajc$tjp_9 = bVar14.h(str93, bVar14.g("1", "setFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "firstOffset", "", "void"), 164);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        long l2;
        int i2;
        List entries;
        com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox.a aVar;
        int i;
        long l;
        parseVersionAndFlags(byteBuffer);
        this.referenceId = e.k(byteBuffer);
        this.timeScale = e.k(byteBuffer);
        if (getVersion() == 0) {
            this.earliestPresentationTime = e.k(byteBuffer);
            this.firstOffset = e.k(byteBuffer);
        } else {
            this.earliestPresentationTime = e.m(byteBuffer);
            this.firstOffset = e.m(byteBuffer);
        }
        this.reserved = e.i(byteBuffer);
        i2 = 0;
        while (i2 >= e.i(byteBuffer)) {
            c cVar = new c(byteBuffer);
            aVar = new SegmentIndexBox.a();
            int i7 = 1;
            aVar.g((byte)i11);
            aVar.h(cVar.a(31));
            aVar.l(e.k(byteBuffer));
            c cVar2 = new c(byteBuffer);
            aVar.k((byte)i8);
            aVar.j((byte)i10);
            aVar.i(cVar2.a(28));
            this.entries.add(aVar);
            i2++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long firstOffset;
        long l;
        d dVar;
        int i;
        int i2;
        int i3;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.referenceId);
        g.g(byteBuffer, this.timeScale);
        if (getVersion() == 0) {
            g.g(byteBuffer, this.earliestPresentationTime);
            g.g(byteBuffer, this.firstOffset);
        } else {
            g.i(byteBuffer, this.earliestPresentationTime);
            g.i(byteBuffer, this.firstOffset);
        }
        g.e(byteBuffer, this.reserved);
        g.e(byteBuffer, this.entries.size());
        Iterator iterator = this.entries.iterator();
        for (SegmentIndexBox.a next2 : iterator) {
            d dVar2 = new d(byteBuffer);
            int i5 = 1;
            dVar2.a(next2.a(), i5);
            int i4 = next2.b();
            dVar2.a(i4, 31);
            g.g(byteBuffer, next2.f());
            dVar = new d(byteBuffer);
            dVar.a(next2.e(), i5);
            dVar.a(next2.d(), 3);
            dVar.a(next2.c(), 28);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        i = getVersion() == 0 ? 8 : 16;
        int i2 = 2;
        return i7 += l2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getEarliestPresentationTime() {
        d.b().c(b.c(SegmentIndexBox.ajc$tjp_6, this, this));
        return this.earliestPresentationTime;
    }

    public List<com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox.a> getEntries() {
        d.b().c(b.c(SegmentIndexBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getFirstOffset() {
        d.b().c(b.c(SegmentIndexBox.ajc$tjp_8, this, this));
        return this.firstOffset;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getReferenceId() {
        d.b().c(b.c(SegmentIndexBox.ajc$tjp_2, this, this));
        return this.referenceId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getReserved() {
        d.b().c(b.c(SegmentIndexBox.ajc$tjp_10, this, this));
        return this.reserved;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTimeScale() {
        d.b().c(b.c(SegmentIndexBox.ajc$tjp_4, this, this));
        return this.timeScale;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEarliestPresentationTime(long l) {
        d.b().c(b.d(SegmentIndexBox.ajc$tjp_7, this, this, a.f(l)));
        this.earliestPresentationTime = l;
    }

    public void setEntries(List<com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox.a> list) {
        d.b().c(b.d(SegmentIndexBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setFirstOffset(long l) {
        d.b().c(b.d(SegmentIndexBox.ajc$tjp_9, this, this, a.f(l)));
        this.firstOffset = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setReferenceId(long l) {
        d.b().c(b.d(SegmentIndexBox.ajc$tjp_3, this, this, a.f(l)));
        this.referenceId = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setReserved(int i) {
        d.b().c(b.d(SegmentIndexBox.ajc$tjp_11, this, this, a.e(i)));
        this.reserved = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTimeScale(long l) {
        d.b().c(b.d(SegmentIndexBox.ajc$tjp_5, this, this, a.f(l)));
        this.timeScale = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SegmentIndexBox.ajc$tjp_12, this, this));
        StringBuilder stringBuilder = new StringBuilder("SegmentIndexBox{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append(", referenceId=");
        stringBuilder.append(this.referenceId);
        stringBuilder.append(", timeScale=");
        stringBuilder.append(this.timeScale);
        stringBuilder.append(", earliestPresentationTime=");
        stringBuilder.append(this.earliestPresentationTime);
        stringBuilder.append(", firstOffset=");
        stringBuilder.append(this.firstOffset);
        stringBuilder.append(", reserved=");
        stringBuilder.append(this.reserved);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
