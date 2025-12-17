package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.f;
import f.b.a.g;
import f.b.a.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class TrackFragmentRandomAccessBox extends AbstractFullBox {

    public static final String TYPE = "tfra";
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
    private List<com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a> entries;
    private int lengthSizeOfSampleNum = 2;
    private int lengthSizeOfTrafNum = 2;
    private int lengthSizeOfTrunNum = 2;
    private int reserved;
    private long trackId;

    public static class a {

        private long a;
        private long b;
        private long c;
        private long d;
        private long e;
        static void a(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a, long l2) {
            a.a = l2;
        }

        static void b(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a, long l2) {
            a.b = l2;
        }

        static void c(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a, long l2) {
            a.c = l2;
        }

        static void d(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a, long l2) {
            a.d = l2;
        }

        static void e(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a, long l2) {
            a.e = l2;
        }

        static long f(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a) {
            return a.a;
        }

        static long g(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a) {
            return a.b;
        }

        static long h(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a) {
            return a.c;
        }

        static long i(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a) {
            return a.d;
        }

        static long j(com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a trackFragmentRandomAccessBox$a) {
            return a.e;
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (TrackFragmentRandomAccessBox.a.class != object.getClass()) {
                } else {
                    if (Long.compare(l, l6) != 0) {
                        return i2;
                    }
                    if (Long.compare(l2, l7) != 0) {
                        return i2;
                    }
                    if (Long.compare(l3, l8) != 0) {
                        return i2;
                    }
                    if (Long.compare(l4, l9) != 0) {
                        return i2;
                    }
                    if (Long.compare(l5, l10) != 0) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            long l = this.a;
            final int i17 = 32;
            long l2 = this.b;
            long l3 = this.c;
            long l4 = this.d;
            long l5 = this.e;
            return i9 += i16;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{time=");
            stringBuilder.append(this.a);
            stringBuilder.append(", moofOffset=");
            stringBuilder.append(this.b);
            stringBuilder.append(", trafNumber=");
            stringBuilder.append(this.c);
            stringBuilder.append(", trunNumber=");
            stringBuilder.append(this.d);
            stringBuilder.append(", sampleNumber=");
            stringBuilder.append(this.e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        TrackFragmentRandomAccessBox.ajc$preClinit();
    }

    public TrackFragmentRandomAccessBox() {
        super("tfra");
        int i = 2;
        this.entries = Collections.emptyList();
    }

    private static void ajc$preClinit() {
        b bVar14 = new b("TrackFragmentRandomAccessBox.java", TrackFragmentRandomAccessBox.class);
        final String str93 = "method-execution";
        TrackFragmentRandomAccessBox.ajc$tjp_0 = bVar14.h(str93, bVar14.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "long", "trackId", "", "void"), 145);
        TrackFragmentRandomAccessBox.ajc$tjp_1 = bVar14.h(str93, bVar14.g("1", "setLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), 149);
        TrackFragmentRandomAccessBox.ajc$tjp_10 = bVar14.h(str93, bVar14.g("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 185);
        TrackFragmentRandomAccessBox.ajc$tjp_11 = bVar14.h(str93, bVar14.g("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "java.util.List", "entries", "", "void"), 189);
        TrackFragmentRandomAccessBox.ajc$tjp_12 = bVar14.h(str93, bVar14.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.lang.String"), 290);
        TrackFragmentRandomAccessBox.ajc$tjp_2 = bVar14.h(str93, bVar14.g("1", "setLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), 153);
        TrackFragmentRandomAccessBox.ajc$tjp_3 = bVar14.h(str93, bVar14.g("1", "setLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 157);
        TrackFragmentRandomAccessBox.ajc$tjp_4 = bVar14.h(str93, bVar14.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 161);
        TrackFragmentRandomAccessBox.ajc$tjp_5 = bVar14.h(str93, bVar14.g("1", "getReserved", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 165);
        TrackFragmentRandomAccessBox.ajc$tjp_6 = bVar14.h(str93, bVar14.g("1", "getLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 169);
        TrackFragmentRandomAccessBox.ajc$tjp_7 = bVar14.h(str93, bVar14.g("1", "getLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 173);
        TrackFragmentRandomAccessBox.ajc$tjp_8 = bVar14.h(str93, bVar14.g("1", "getLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 177);
        TrackFragmentRandomAccessBox.ajc$tjp_9 = bVar14.h(str93, bVar14.g("1", "getNumberOfEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 181);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        int aVar;
        List entries;
        long l;
        parseVersionAndFlags(byteBuffer);
        this.trackId = e.k(byteBuffer);
        long l3 = e.k(byteBuffer);
        this.reserved = (int)i6;
        final int i16 = 1;
        this.lengthSizeOfTrafNum = i11 += i16;
        this.lengthSizeOfTrunNum = i14 += i16;
        this.lengthSizeOfSampleNum = i3 += i16;
        ArrayList arrayList = new ArrayList();
        this.entries = arrayList;
        i = 0;
        while (Long.compare(l5, l4) >= 0) {
            aVar = new TrackFragmentRandomAccessBox.a();
            if (getVersion() == i16) {
            } else {
            }
            TrackFragmentRandomAccessBox.a.a(aVar, e.k(byteBuffer));
            TrackFragmentRandomAccessBox.a.b(aVar, e.k(byteBuffer));
            TrackFragmentRandomAccessBox.a.c(aVar, f.a(byteBuffer, this.lengthSizeOfTrafNum));
            TrackFragmentRandomAccessBox.a.d(aVar, f.a(byteBuffer, this.lengthSizeOfTrunNum));
            TrackFragmentRandomAccessBox.a.e(aVar, f.a(byteBuffer, this.lengthSizeOfSampleNum));
            this.entries.add(aVar);
            i++;
            TrackFragmentRandomAccessBox.a.a(aVar, e.m(byteBuffer));
            TrackFragmentRandomAccessBox.a.b(aVar, e.m(byteBuffer));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l2;
        int lengthSizeOfTrunNum;
        long lengthSizeOfSampleNum;
        long l;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.trackId);
        final int i12 = 1;
        g.g(byteBuffer, i3 |= lengthSizeOfSampleNum);
        g.g(byteBuffer, (long)size);
        Iterator iterator = this.entries.iterator();
        while (!iterator.hasNext()) {
            Object next2 = iterator.next();
            if (getVersion() == i12) {
            } else {
            }
            g.g(byteBuffer, TrackFragmentRandomAccessBox.a.f((TrackFragmentRandomAccessBox.a)next2));
            g.g(byteBuffer, TrackFragmentRandomAccessBox.a.g(next2));
            h.a(TrackFragmentRandomAccessBox.a.h(next2), obj5, byteBuffer);
            lengthSizeOfTrunNum = this.lengthSizeOfTrunNum;
            h.a(TrackFragmentRandomAccessBox.a.i(next2), obj5, byteBuffer);
            h.a(TrackFragmentRandomAccessBox.a.j(next2), lengthSizeOfTrunNum, byteBuffer);
            g.i(byteBuffer, TrackFragmentRandomAccessBox.a.f(next2));
            g.i(byteBuffer, TrackFragmentRandomAccessBox.a.g(next2));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (getVersion() == 1) {
            size *= 16;
        } else {
            size2 *= 8;
        }
        return i8 += l4;
    }

    public List<com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a> getEntries() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_10, this, this));
        return Collections.unmodifiableList(this.entries);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLengthSizeOfSampleNum() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_8, this, this));
        return this.lengthSizeOfSampleNum;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLengthSizeOfTrafNum() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_6, this, this));
        return this.lengthSizeOfTrafNum;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLengthSizeOfTrunNum() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_7, this, this));
        return this.lengthSizeOfTrunNum;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getNumberOfEntries() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_9, this, this));
        return (long)size;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getReserved() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_5, this, this));
        return this.reserved;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTrackId() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_4, this, this));
        return this.trackId;
    }

    public void setEntries(List<com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a> list) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_11, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLengthSizeOfSampleNum(int i) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_3, this, this, a.e(i)));
        this.lengthSizeOfSampleNum = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLengthSizeOfTrafNum(int i) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_1, this, this, a.e(i)));
        this.lengthSizeOfTrafNum = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLengthSizeOfTrunNum(int i) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_2, this, this, a.e(i)));
        this.lengthSizeOfTrunNum = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackId(long l) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_0, this, this, a.f(l)));
        this.trackId = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_12, this, this));
        StringBuilder stringBuilder = new StringBuilder("TrackFragmentRandomAccessBox{trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
