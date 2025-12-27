package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: TrackFragmentHeaderBox.java */
/* loaded from: classes.dex */
public class TrackFragmentHeaderBox extends AbstractFullBox {

    public static final String TYPE = "tfhd";
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
    private static final /* synthetic */ a.a ajc$tjp_20;
    private static final /* synthetic */ a.a ajc$tjp_21;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    private long baseDataOffset = -1;
    private boolean defaultBaseIsMoof;
    private long defaultSampleDuration = -1;
    private a defaultSampleFlags;
    private long defaultSampleSize = -1;
    private boolean durationIsEmpty;
    private long sampleDescriptionIndex;
    private long trackId;
    static {
        TrackFragmentHeaderBox.ajc$preClinit();
    }

    public TrackFragmentHeaderBox() {
        super("tfhd");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        final String str156 = "method-execution";
        TrackFragmentHeaderBox.ajc$tjp_0 = bVar.h(str156, bVar.g("1", "hasBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 126);
        TrackFragmentHeaderBox.ajc$tjp_1 = bVar.h(str156, bVar.g("1", "hasSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 130);
        TrackFragmentHeaderBox.ajc$tjp_10 = bVar.h(str156, bVar.g("1", "setSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 171);
        TrackFragmentHeaderBox.ajc$tjp_11 = bVar.h(str156, bVar.g("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 180);
        TrackFragmentHeaderBox.ajc$tjp_12 = bVar.h(str156, bVar.g("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), 184);
        TrackFragmentHeaderBox.ajc$tjp_13 = bVar.h(str156, bVar.g("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 191);
        TrackFragmentHeaderBox.ajc$tjp_14 = bVar.h(str156, bVar.g("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), 195);
        TrackFragmentHeaderBox.ajc$tjp_15 = bVar.h(str156, bVar.g("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 204);
        TrackFragmentHeaderBox.ajc$tjp_16 = bVar.h(str156, bVar.g("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 208);
        TrackFragmentHeaderBox.ajc$tjp_17 = bVar.h(str156, bVar.g("1", "isDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 217);
        TrackFragmentHeaderBox.ajc$tjp_18 = bVar.h(str156, bVar.g("1", "setDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), 221);
        TrackFragmentHeaderBox.ajc$tjp_19 = bVar.h(str156, bVar.g("1", "isDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 230);
        TrackFragmentHeaderBox.ajc$tjp_2 = bVar.h(str156, bVar.g("1", "hasDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 134);
        TrackFragmentHeaderBox.ajc$tjp_20 = bVar.h(str156, bVar.g("1", "setDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), 234);
        TrackFragmentHeaderBox.ajc$tjp_21 = bVar.h(str156, bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 244);
        TrackFragmentHeaderBox.ajc$tjp_3 = bVar.h(str156, bVar.g("1", "hasDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 138);
        TrackFragmentHeaderBox.ajc$tjp_4 = bVar.h(str156, bVar.g("1", "hasDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 142);
        TrackFragmentHeaderBox.ajc$tjp_5 = bVar.h(str156, bVar.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 146);
        TrackFragmentHeaderBox.ajc$tjp_6 = bVar.h(str156, bVar.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "trackId", "", "void"), 150);
        TrackFragmentHeaderBox.ajc$tjp_7 = bVar.h(str156, bVar.g("1", "getBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 154);
        TrackFragmentHeaderBox.ajc$tjp_8 = bVar.h(str156, bVar.g("1", "setBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), 158);
        TrackFragmentHeaderBox.ajc$tjp_9 = bVar.h(str156, bVar.g("1", "getSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 167);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = e.k(byteBuffer);
        final int i11 = 1;
        if ((getFlags() & i11) == i11) {
            this.baseDataOffset = e.m(byteBuffer);
        }
        int i2 = 2;
        if ((getFlags() & i2) == i2) {
            this.sampleDescriptionIndex = e.k(byteBuffer);
        }
        int i3 = 8;
        if ((getFlags() & i3) == i3) {
            this.defaultSampleDuration = e.k(byteBuffer);
        }
        int i4 = 16;
        if ((getFlags() & i4) == i4) {
            this.defaultSampleSize = e.k(byteBuffer);
        }
        int i12 = 32;
        i = getFlags() & i12;
        if ((this.getFlags() & i12) == i12) {
            this.defaultSampleFlags = new a(byteBuffer);
        }
        int i9 = 65536;
        if ((getFlags() & i9) == i9) {
            this.durationIsEmpty = true;
        }
        int i10 = 131072;
        if ((getFlags() & i10) == i10) {
            this.defaultBaseIsMoof = true;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getBaseDataOffset() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_7, this, this));
        return this.baseDataOffset;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.trackId);
        int i6 = 1;
        i = getFlags() & i6;
        if ((this.getFlags() & i6) == i6) {
            g.i(byteBuffer, getBaseDataOffset());
        }
        int i7 = 2;
        i2 = getFlags() & i7;
        if ((this.getFlags() & i7) == i7) {
            g.g(byteBuffer, getSampleDescriptionIndex());
        }
        int i8 = 8;
        i3 = getFlags() & i8;
        if ((this.getFlags() & i8) == i8) {
            g.g(byteBuffer, getDefaultSampleDuration());
        }
        int i9 = 16;
        i4 = getFlags() & i9;
        if ((this.getFlags() & i9) == i9) {
            g.g(byteBuffer, getDefaultSampleSize());
        }
        int i10 = 32;
        i5 = getFlags() & i10;
        if ((this.getFlags() & i10) == i10) {
            this.defaultSampleFlags.a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 8;
        int flags = getFlags();
        int r1 = (flags & 1) == 1 ? 16 : 8;
        final long l5 = 4L;
        if ((flags & 2) == 2) {
            i += l5;
        }
        if ((flags & 8) == 8) {
            i += l5;
        }
        if ((flags & 16) == 16) {
            i += l5;
        }
        int i8 = 32;
        if ((flags & i8) == i8) {
            i += l5;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDefaultSampleDuration() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_11, this, this));
        return this.defaultSampleDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public a getDefaultSampleFlags() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_15, this, this));
        return this.defaultSampleFlags;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDefaultSampleSize() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_13, this, this));
        return this.defaultSampleSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleDescriptionIndex() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_9, this, this));
        return this.sampleDescriptionIndex;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTrackId() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_5, this, this));
        return this.trackId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasBaseDataOffset() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_0, this, this));
        boolean z = true;
        if (getFlags() & z != 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasDefaultSampleDuration() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_2, this, this));
        if (getFlags() & 8 != 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasDefaultSampleFlags() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_4, this, this));
        if (getFlags() & 32 != 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasDefaultSampleSize() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_3, this, this));
        if (getFlags() & 16 != 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasSampleDescriptionIndex() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_1, this, this));
        if (getFlags() & 2 != 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isDefaultBaseIsMoof() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_19, this, this));
        return this.defaultBaseIsMoof;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isDurationIsEmpty() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_17, this, this));
        return this.durationIsEmpty;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setBaseDataOffset(long j) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_8, this, this, a.f(j)));
        if (j == -1) {
            int i2 = 2147483646;
            i = getFlags() & i2;
            setFlags(i);
        } else {
            i = getFlags() | 1;
            setFlags(i);
        }
        this.baseDataOffset = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultBaseIsMoof(boolean z) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_20, this, this, a.a(z)));
        if (z) {
            int i2 = 131072;
            i = getFlags() | i2;
            setFlags(i);
        } else {
            i2 = 16646143;
            i = getFlags() & i2;
            setFlags(i);
        }
        this.defaultBaseIsMoof = z;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleDuration(long j) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_12, this, this, a.f(j)));
        setFlags(getFlags() | 8);
        this.defaultSampleDuration = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleFlags(a aVar) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_16, this, this, aVar));
        if (aVar != null) {
            i = getFlags() | 32;
            setFlags(i);
        } else {
            i = getFlags() & 16777183;
            setFlags(i);
        }
        this.defaultSampleFlags = aVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleSize(long j) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_14, this, this, a.f(j)));
        if (j != -1) {
            i = getFlags() | 16;
            setFlags(i);
        } else {
            i = getFlags() & 16777199;
            setFlags(i);
        }
        this.defaultSampleSize = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDurationIsEmpty(boolean z) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_18, this, this, a.a(z)));
        if (this.defaultBaseIsMoof) {
            int i2 = 65536;
            i = getFlags() | i2;
            setFlags(i);
        } else {
            i2 = 16711679;
            i = getFlags() & i2;
            setFlags(i);
        }
        this.durationIsEmpty = z;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleDescriptionIndex(long j) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_10, this, this, a.f(j)));
        if (j == -1) {
            int i2 = 2147483645;
            i = getFlags() & i2;
            setFlags(i);
        } else {
            i = getFlags() | 2;
            setFlags(i);
        }
        this.sampleDescriptionIndex = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackId(long j) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_6, this, this, a.f(j)));
        this.trackId = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_21, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrackFragmentHeaderBox";
        String str3 = "{trackId=";
        String str4 = ", baseDataOffset=";
        String str5 = ", sampleDescriptionIndex=";
        String str6 = ", defaultSampleDuration=";
        String str7 = ", defaultSampleSize=";
        String str8 = ", defaultSampleFlags=";
        String str9 = ", durationIsEmpty=";
        String str10 = ", defaultBaseIsMoof=";
        str = str2 + str3 + this.trackId + str4 + this.baseDataOffset + str5 + this.sampleDescriptionIndex + str6 + this.defaultSampleDuration + str7 + this.defaultSampleSize + str8 + this.defaultSampleFlags + str9 + this.durationIsEmpty + str10 + this.defaultBaseIsMoof + 125;
        return str;
    }
}
