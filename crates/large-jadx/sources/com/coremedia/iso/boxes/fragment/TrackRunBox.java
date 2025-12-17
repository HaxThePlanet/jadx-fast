package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class TrackRunBox extends AbstractFullBox {

    public static final String TYPE = "trun";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_12;
    private static final a.a ajc$tjp_13;
    private static final a.a ajc$tjp_14;
    private static final a.a ajc$tjp_15;
    private static final a.a ajc$tjp_16;
    private static final a.a ajc$tjp_17;
    private static final a.a ajc$tjp_18;
    private static final a.a ajc$tjp_19;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    private int dataOffset;
    private List<com.coremedia.iso.boxes.fragment.TrackRunBox.a> entries;
    private com.coremedia.iso.boxes.fragment.a firstSampleFlags;

    public static class a {

        private long a;
        private long b;
        private com.coremedia.iso.boxes.fragment.a c;
        private long d;
        static long a(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a) {
            return a.a;
        }

        static long b(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a) {
            return a.b;
        }

        static com.coremedia.iso.boxes.fragment.a c(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a) {
            return a.c;
        }

        static long d(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a) {
            return a.d;
        }

        static void e(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a, long l2) {
            a.a = l2;
        }

        static void f(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a, long l2) {
            a.b = l2;
        }

        static void g(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a, com.coremedia.iso.boxes.fragment.a a2) {
            a.c = a2;
        }

        static void h(com.coremedia.iso.boxes.fragment.TrackRunBox.a trackRunBox$a, long l2) {
            a.d = l2;
        }

        public long i() {
            return this.d;
        }

        public long j() {
            return this.a;
        }

        public com.coremedia.iso.boxes.fragment.a k() {
            return this.c;
        }

        public long l() {
            return this.b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{duration=");
            stringBuilder.append(this.a);
            stringBuilder.append(", size=");
            stringBuilder.append(this.b);
            stringBuilder.append(", dlags=");
            stringBuilder.append(this.c);
            stringBuilder.append(", compTimeOffset=");
            stringBuilder.append(this.d);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        TrackRunBox.ajc$preClinit();
    }

    public TrackRunBox() {
        super("trun");
        ArrayList arrayList = new ArrayList();
        this.entries = arrayList;
    }

    private static void ajc$preClinit() {
        b bVar21 = new b("TrackRunBox.java", TrackRunBox.class);
        final String str142 = "method-execution";
        TrackRunBox.ajc$tjp_0 = bVar21.h(str142, bVar21.g("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.util.List"), 57);
        TrackRunBox.ajc$tjp_1 = bVar21.h(str142, bVar21.g("1", "setDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "int", "dataOffset", "", "void"), 120);
        TrackRunBox.ajc$tjp_10 = bVar21.h(str142, bVar21.g("1", "setDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 267);
        TrackRunBox.ajc$tjp_11 = bVar21.h(str142, bVar21.g("1", "setSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 275);
        TrackRunBox.ajc$tjp_12 = bVar21.h(str142, bVar21.g("1", "setSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 283);
        TrackRunBox.ajc$tjp_13 = bVar21.h(str142, bVar21.g("1", "setSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 292);
        TrackRunBox.ajc$tjp_14 = bVar21.h(str142, bVar21.g("1", "setSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 300);
        TrackRunBox.ajc$tjp_15 = bVar21.h(str142, bVar21.g("1", "getDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "int"), 309);
        TrackRunBox.ajc$tjp_16 = bVar21.h(str142, bVar21.g("1", "getFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 313);
        TrackRunBox.ajc$tjp_17 = bVar21.h(str142, bVar21.g("1", "setFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "firstSampleFlags", "", "void"), 317);
        TrackRunBox.ajc$tjp_18 = bVar21.h(str142, bVar21.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.lang.String"), 327);
        TrackRunBox.ajc$tjp_19 = bVar21.h(str142, bVar21.g("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "java.util.List", "entries", "", "void"), 342);
        TrackRunBox.ajc$tjp_2 = bVar21.h(str142, bVar21.g("1", "getSampleCompositionTimeOffsets", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "[J"), 129);
        TrackRunBox.ajc$tjp_3 = bVar21.h(str142, bVar21.g("1", "getSampleCount", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "long"), 238);
        TrackRunBox.ajc$tjp_4 = bVar21.h(str142, bVar21.g("1", "isDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 242);
        TrackRunBox.ajc$tjp_5 = bVar21.h(str142, bVar21.g("1", "isFirstSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 246);
        TrackRunBox.ajc$tjp_6 = bVar21.h(str142, bVar21.g("1", "isSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 251);
        TrackRunBox.ajc$tjp_7 = bVar21.h(str142, bVar21.g("1", "isSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 255);
        TrackRunBox.ajc$tjp_8 = bVar21.h(str142, bVar21.g("1", "isSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 259);
        TrackRunBox.ajc$tjp_9 = bVar21.h(str142, bVar21.g("1", "isSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 263);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i6;
        int aVar3;
        int i;
        int aVar;
        List entries;
        int i2;
        int i3;
        int aVar2;
        int i5;
        int i4;
        parseVersionAndFlags(byteBuffer);
        int i8 = 1;
        if (flags &= i8 == i8) {
            this.dataOffset = b.a(e.k(byteBuffer));
        } else {
            this.dataOffset = -1;
        }
        aVar = 4;
        if (flags2 &= aVar == aVar) {
            aVar3 = new a(byteBuffer);
            this.firstSampleFlags = aVar3;
        }
        i = 0;
        while (Long.compare(l3, l) >= 0) {
            aVar = new TrackRunBox.a();
            int i9 = 256;
            if (flags3 &= i9 == i9) {
            }
            int i10 = 512;
            if (flags4 &= i10 == i10) {
            }
            int i11 = 1024;
            if (flags5 &= i11 == i11) {
            }
            i4 = 2048;
            if (flags6 &= i4 == i4) {
            }
            this.entries.add(aVar);
            i++;
            TrackRunBox.a.h(aVar, (long)int);
            aVar2 = new a(byteBuffer);
            TrackRunBox.a.g(aVar, aVar2);
            TrackRunBox.a.f(aVar, e.k(byteBuffer));
            TrackRunBox.a.e(aVar, e.k(byteBuffer));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        int firstSampleFlags;
        int next;
        int version;
        int i3;
        int i4;
        int i5;
        int i2;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)size);
        int flags = getFlags();
        int i6 = 1;
        if (flags & 1 == i6) {
            g.g(byteBuffer, (long)dataOffset);
        }
        if (flags & 4 == 4) {
            this.firstSampleFlags.a(byteBuffer);
        }
        Iterator iterator = this.entries.iterator();
        while (!iterator.hasNext()) {
            next = iterator.next();
            int i7 = 256;
            if (flags & 256 == i7) {
            }
            int i8 = 512;
            if (flags & 512 == i8) {
            }
            if (flags & 1024 == 1024) {
            }
            if (flags & 2048 == 2048) {
            }
            version = getVersion();
            if (version == 0) {
            } else {
            }
            byteBuffer.putInt((int)l2);
            g.g(byteBuffer, TrackRunBox.a.d(next));
            TrackRunBox.a.c(next).a(byteBuffer);
            g.g(byteBuffer, TrackRunBox.a.b(next));
            g.g(byteBuffer, TrackRunBox.a.a(next));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i2;
        int i;
        int flags = getFlags();
        i2 = flags & 1 == 1 ? 12 : 8;
        int i10 = 4;
        if (flags & 4 == 4) {
            i2 += i10;
        }
        i = 0;
        if (flags & 256 == 256) {
            i = i10;
        }
        if (flags & 512 == 512) {
            i += i10;
        }
        if (flags & 1024 == 1024) {
            i += i10;
        }
        int i14 = 2048;
        if (flags &= i14 == i14) {
            i += i10;
        }
        return i2 += i8;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDataOffset() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_15, this, this));
        return this.dataOffset;
    }

    public List<com.coremedia.iso.boxes.fragment.TrackRunBox.a> getEntries() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public com.coremedia.iso.boxes.fragment.a getFirstSampleFlags() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_16, this, this));
        return this.firstSampleFlags;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getSampleCompositionTimeOffsets() {
        int i;
        long l;
        d.b().c(b.c(TrackRunBox.ajc$tjp_2, this, this));
        if (isSampleCompositionTimeOffsetPresent()) {
            int size = this.entries.size();
            long[] lArr = new long[size];
            i = 0;
            while (i >= size) {
                lArr[i] = (TrackRunBox.a)this.entries.get(i).i();
                i++;
            }
            return lArr;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleCount() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_3, this, this));
        return (long)size;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isDataOffsetPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_4, this, this));
        int i3 = 1;
        if (flags &= i3 == i3) {
            return i3;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isFirstSampleFlagsPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_5, this, this));
        int i4 = 4;
        if (flags &= i4 == i4) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleCompositionTimeOffsetPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_9, this, this));
        int i4 = 2048;
        if (flags &= i4 == i4) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleDurationPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_7, this, this));
        int i4 = 256;
        if (flags &= i4 == i4) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleFlagsPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_8, this, this));
        int i4 = 1024;
        if (flags &= i4 == i4) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleSizePresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_6, this, this));
        int i4 = 512;
        if (flags &= i4 == i4) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDataOffset(int i) {
        int i2;
        int dVar;
        d.b().c(b.d(TrackRunBox.ajc$tjp_1, this, this, a.e(i)));
        if (i == -1) {
            setFlags(flags &= dVar);
        } else {
            setFlags(flags2 |= 1);
        }
        this.dataOffset = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDataOffsetPresent(boolean z) {
        org.mp4parser.aspectj.lang.a aVar;
        int obj3;
        d.b().c(b.d(TrackRunBox.ajc$tjp_10, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 1);
        } else {
            setFlags(obj3 &= aVar);
        }
    }

    public void setEntries(List<com.coremedia.iso.boxes.fragment.TrackRunBox.a> list) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_19, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setFirstSampleFlags(com.coremedia.iso.boxes.fragment.a a) {
        int i;
        int dVar;
        d.b().c(b.d(TrackRunBox.ajc$tjp_17, this, this, a));
        if (a == null) {
            setFlags(flags &= dVar);
        } else {
            setFlags(flags2 |= 4);
        }
        this.firstSampleFlags = a;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleCompositionTimeOffsetPresent(boolean z) {
        org.mp4parser.aspectj.lang.a aVar;
        int obj3;
        d.b().c(b.d(TrackRunBox.ajc$tjp_14, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 2048);
        } else {
            setFlags(obj3 &= aVar);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleDurationPresent(boolean z) {
        org.mp4parser.aspectj.lang.a aVar;
        int obj3;
        d.b().c(b.d(TrackRunBox.ajc$tjp_12, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 256);
        } else {
            setFlags(obj3 &= aVar);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleFlagsPresent(boolean z) {
        org.mp4parser.aspectj.lang.a aVar;
        int obj3;
        d.b().c(b.d(TrackRunBox.ajc$tjp_13, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 1024);
        } else {
            setFlags(obj3 &= aVar);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleSizePresent(boolean z) {
        org.mp4parser.aspectj.lang.a aVar;
        int obj3;
        d.b().c(b.d(TrackRunBox.ajc$tjp_11, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 512);
        } else {
            setFlags(obj3 &= aVar);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_18, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackRunBox");
        stringBuilder.append("{sampleCount=");
        stringBuilder.append(this.entries.size());
        stringBuilder.append(", dataOffset=");
        stringBuilder.append(this.dataOffset);
        stringBuilder.append(", dataOffsetPresent=");
        stringBuilder.append(isDataOffsetPresent());
        stringBuilder.append(", sampleSizePresent=");
        stringBuilder.append(isSampleSizePresent());
        stringBuilder.append(", sampleDurationPresent=");
        stringBuilder.append(isSampleDurationPresent());
        stringBuilder.append(", sampleFlagsPresentPresent=");
        stringBuilder.append(isSampleFlagsPresent());
        stringBuilder.append(", sampleCompositionTimeOffsetPresent=");
        stringBuilder.append(isSampleCompositionTimeOffsetPresent());
        stringBuilder.append(", firstSampleFlags=");
        stringBuilder.append(this.firstSampleFlags);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
