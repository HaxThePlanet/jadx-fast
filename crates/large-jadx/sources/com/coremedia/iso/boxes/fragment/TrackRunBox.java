package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.a.a;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: TrackRunBox.java */
/* loaded from: classes.dex */
public class TrackRunBox extends AbstractFullBox {

    public static final String TYPE = "trun";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_10;
    private static final /* synthetic */ a.a ajc$tjp_11;
    private static final /* synthetic */ a.a ajc$tjp_12;
    private static final /* synthetic */ a.a ajc$tjp_13;
    private static final /* synthetic */ a.a ajc$tjp_14;
    private static final /* synthetic */ a.a ajc$tjp_15;
    private static final /* synthetic */ a.a ajc$tjp_16;
    private static final /* synthetic */ a.a ajc$tjp_17;
    private static final /* synthetic */ a.a ajc$tjp_18;
    private static final /* synthetic */ a.a ajc$tjp_19;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    private int dataOffset;
    private List<TrackRunBox.a> entries = new ArrayList<>();
    private a firstSampleFlags;

    public static class a {

        private long a;
        private long b;
        private a c;
        private long d;
        static /* synthetic */ long a(TrackRunBox.a aVar) {
            return aVar.a;
        }

        static /* synthetic */ long b(TrackRunBox.a aVar) {
            return aVar.b;
        }

        static /* synthetic */ a c(TrackRunBox.a aVar) {
            return aVar.c;
        }

        static /* synthetic */ long d(TrackRunBox.a aVar) {
            return aVar.d;
        }

        static /* synthetic */ void e(TrackRunBox.a aVar, long j) {
            aVar.a = j;
        }

        static /* synthetic */ void f(TrackRunBox.a aVar, long j) {
            aVar.b = j;
        }

        static /* synthetic */ void g(TrackRunBox.a aVar, a aVar2) {
            aVar.c = aVar2;
        }

        static /* synthetic */ void h(TrackRunBox.a aVar, long j) {
            aVar.d = j;
        }

        public long i() {
            return this.d;
        }

        public long j() {
            return this.a;
        }

        public a k() {
            return this.c;
        }

        public long l() {
            return this.b;
        }

        public String toString() {
            String str2 = "Entry{duration=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", size=";
            String str4 = ", dlags=";
            String str5 = ", compTimeOffset=";
            str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + 125;
            return str;
        }
    }
    static {
        TrackRunBox.ajc$preClinit();
    }

    public TrackRunBox() {
        super("trun");
        ArrayList arrayList = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("TrackRunBox.java", TrackRunBox.class);
        final String str142 = "method-execution";
        TrackRunBox.ajc$tjp_0 = bVar.h(str142, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.util.List"), 57);
        TrackRunBox.ajc$tjp_1 = bVar.h(str142, bVar.g("1", "setDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "int", "dataOffset", "", "void"), 120);
        TrackRunBox.ajc$tjp_10 = bVar.h(str142, bVar.g("1", "setDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 267);
        TrackRunBox.ajc$tjp_11 = bVar.h(str142, bVar.g("1", "setSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 275);
        TrackRunBox.ajc$tjp_12 = bVar.h(str142, bVar.g("1", "setSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 283);
        TrackRunBox.ajc$tjp_13 = bVar.h(str142, bVar.g("1", "setSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 292);
        TrackRunBox.ajc$tjp_14 = bVar.h(str142, bVar.g("1", "setSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 300);
        TrackRunBox.ajc$tjp_15 = bVar.h(str142, bVar.g("1", "getDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "int"), 309);
        TrackRunBox.ajc$tjp_16 = bVar.h(str142, bVar.g("1", "getFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 313);
        TrackRunBox.ajc$tjp_17 = bVar.h(str142, bVar.g("1", "setFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "firstSampleFlags", "", "void"), 317);
        TrackRunBox.ajc$tjp_18 = bVar.h(str142, bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.lang.String"), 327);
        TrackRunBox.ajc$tjp_19 = bVar.h(str142, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "java.util.List", "entries", "", "void"), 342);
        TrackRunBox.ajc$tjp_2 = bVar.h(str142, bVar.g("1", "getSampleCompositionTimeOffsets", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "[J"), 129);
        TrackRunBox.ajc$tjp_3 = bVar.h(str142, bVar.g("1", "getSampleCount", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "long"), 238);
        TrackRunBox.ajc$tjp_4 = bVar.h(str142, bVar.g("1", "isDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 242);
        TrackRunBox.ajc$tjp_5 = bVar.h(str142, bVar.g("1", "isFirstSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 246);
        TrackRunBox.ajc$tjp_6 = bVar.h(str142, bVar.g("1", "isSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 251);
        TrackRunBox.ajc$tjp_7 = bVar.h(str142, bVar.g("1", "isSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 255);
        TrackRunBox.ajc$tjp_8 = bVar.h(str142, bVar.g("1", "isSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 259);
        TrackRunBox.ajc$tjp_9 = bVar.h(str142, bVar.g("1", "isSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 263);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i3 = 0;
        parseVersionAndFlags(byteBuffer);
        final long l = e.k(byteBuffer);
        int i10 = 1;
        if ((getFlags() & i10) == i10) {
            this.dataOffset = b.a(e.k(byteBuffer));
        } else {
            int i = -1;
            this.dataOffset = i;
        }
        int i4 = 4;
        i2 = getFlags() & i4;
        if ((this.getFlags() & i4) == i4) {
            this.firstSampleFlags = new a(byteBuffer);
        }
        i3 = 0;
        long l3 = (long)i3;
        while (l3 >= l) {
            com.coremedia.iso.boxes.fragment.TrackRunBox.a aVar2 = new TrackRunBox.a();
            int i11 = 256;
            i5 = getFlags() & i11;
            aVar2.b = e.k(byteBuffer);
            int i13 = 1024;
            i7 = getFlags() & i13;
            aVar2.d = (long)byteBuffer.getInt();
            this.entries.add(aVar2);
            i3 = i3 + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)this.entries.size());
        int flags = getFlags();
        i = flags & 1;
        int i8 = 1;
        if ((flags & 1) == i8) {
            g.g(byteBuffer, (long)this.dataOffset);
        }
        i2 = flags & 4;
        int i3 = 4;
        if ((flags & 4) == 4) {
            this.firstSampleFlags.a(byteBuffer);
        }
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            i4 = flags & 256;
            int i9 = 256;
            g.g(byteBuffer, item.b);
            i6 = flags & 1024;
            int version = getVersion();
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 8;
        int i2 = 0;
        int flags = getFlags();
        int r1 = (flags & 1) == 1 ? 12 : 8;
        long l = 4L;
        if ((flags & 4) == 4) {
            i += l;
        }
        i2 = 0;
        if ((flags & 256) == 256) {
        }
        if ((flags & 512) == 512) {
            i2 += l;
        }
        if ((flags & 1024) == 1024) {
            i2 += l;
        }
        int i11 = 2048;
        if ((flags & i11) == i11) {
            i2 += l;
        }
        return i + (i2 * (long)this.entries.size());
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDataOffset() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_15, this, this));
        return this.dataOffset;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<TrackRunBox.a> getEntries() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public a getFirstSampleFlags() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_16, this, this));
        return this.firstSampleFlags;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getSampleCompositionTimeOffsets() {
        int i = 0;
        d.b().c(b.c(TrackRunBox.ajc$tjp_2, this, this));
        if (isSampleCompositionTimeOffsetPresent()) {
            int size = this.entries.size();
            long[] lArr = new long[size];
            i = 0;
            while (i >= TrackRunBox.ajc$tjp_2) {
                lArr[i] = (TrackRunBox.a)this.entries.get(i).i();
                i = i + 1;
            }
            return lArr;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleCount() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_3, this, this));
        return (long)this.entries.size();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isDataOffsetPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_4, this, this));
        int i3 = 1;
        if ((getFlags() & i3) == i3) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isFirstSampleFlagsPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_5, this, this));
        int i4 = 4;
        if ((getFlags() & i4) == i4) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleCompositionTimeOffsetPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_9, this, this));
        int i4 = 2048;
        if ((getFlags() & i4) == i4) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleDurationPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_7, this, this));
        int i4 = 256;
        if ((getFlags() & i4) == i4) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleFlagsPresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_8, this, this));
        int i4 = 1024;
        if ((getFlags() & i4) == i4) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSampleSizePresent() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_6, this, this));
        int i4 = 512;
        if ((getFlags() & i4) == i4) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDataOffset(int i) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_1, this, this, a.e(i)));
        if (i == -1) {
            int i3 = 16777214;
            i2 = getFlags() & i3;
            setFlags(i2);
        } else {
            i2 = getFlags() | 1;
            setFlags(i2);
        }
        this.dataOffset = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDataOffsetPresent(boolean z) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_10, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 1;
            setFlags(i);
        } else {
            i = getFlags() & 16777214;
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<TrackRunBox.a> list) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_19, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setFirstSampleFlags(a aVar) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_17, this, this, aVar));
        if (aVar == null) {
            int i2 = 16777211;
            i = getFlags() & i2;
            setFlags(i);
        } else {
            i = getFlags() | 4;
            setFlags(i);
        }
        this.firstSampleFlags = aVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleCompositionTimeOffsetPresent(boolean z) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_14, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 2048;
            setFlags(i);
        } else {
            i = getFlags() & 16775167;
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleDurationPresent(boolean z) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_12, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 256;
            setFlags(i);
        } else {
            i = getFlags() & 16776959;
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleFlagsPresent(boolean z) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_13, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 1024;
            setFlags(i);
        } else {
            i = getFlags() & 16776191;
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleSizePresent(boolean z) {
        d.b().c(b.d(TrackRunBox.ajc$tjp_11, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 512;
            setFlags(i);
        } else {
            i = getFlags() & 16776703;
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackRunBox.ajc$tjp_18, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrackRunBox";
        String str3 = "{sampleCount=";
        int size = this.entries.size();
        String str4 = ", dataOffset=";
        String str5 = ", dataOffsetPresent=";
        boolean dataOffsetPresent = isDataOffsetPresent();
        String str6 = ", sampleSizePresent=";
        boolean sampleSizePresent = isSampleSizePresent();
        String str7 = ", sampleDurationPresent=";
        boolean sampleDurationPresent = isSampleDurationPresent();
        String str8 = ", sampleFlagsPresentPresent=";
        boolean sampleFlagsPresent = isSampleFlagsPresent();
        String str9 = ", sampleCompositionTimeOffsetPresent=";
        boolean sampleCompositionTimeOffsetPresent = isSampleCompositionTimeOffsetPresent();
        String str10 = ", firstSampleFlags=";
        str = str2 + str3 + size + str4 + this.dataOffset + str5 + dataOffsetPresent + str6 + sampleSizePresent + str7 + sampleDurationPresent + str8 + sampleFlagsPresent + str9 + sampleCompositionTimeOffsetPresent + str10 + this.firstSampleFlags + 125;
        return str;
    }
}
