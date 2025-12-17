package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class TrackFragmentHeaderBox extends AbstractFullBox {

    public static final String TYPE = "tfhd";
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
    private static final a.a ajc$tjp_20;
    private static final a.a ajc$tjp_21;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    private long baseDataOffset = -1;
    private boolean defaultBaseIsMoof;
    private long defaultSampleDuration = -1;
    private com.coremedia.iso.boxes.fragment.a defaultSampleFlags;
    private long defaultSampleSize = -1;
    private boolean durationIsEmpty;
    private long sampleDescriptionIndex;
    private long trackId;
    static {
        TrackFragmentHeaderBox.ajc$preClinit();
    }

    public TrackFragmentHeaderBox() {
        super("tfhd");
        int i = -1;
    }

    private static void ajc$preClinit() {
        b bVar23 = new b("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        final String str156 = "method-execution";
        TrackFragmentHeaderBox.ajc$tjp_0 = bVar23.h(str156, bVar23.g("1", "hasBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 126);
        TrackFragmentHeaderBox.ajc$tjp_1 = bVar23.h(str156, bVar23.g("1", "hasSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 130);
        TrackFragmentHeaderBox.ajc$tjp_10 = bVar23.h(str156, bVar23.g("1", "setSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 171);
        TrackFragmentHeaderBox.ajc$tjp_11 = bVar23.h(str156, bVar23.g("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 180);
        TrackFragmentHeaderBox.ajc$tjp_12 = bVar23.h(str156, bVar23.g("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), 184);
        TrackFragmentHeaderBox.ajc$tjp_13 = bVar23.h(str156, bVar23.g("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 191);
        TrackFragmentHeaderBox.ajc$tjp_14 = bVar23.h(str156, bVar23.g("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), 195);
        TrackFragmentHeaderBox.ajc$tjp_15 = bVar23.h(str156, bVar23.g("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 204);
        TrackFragmentHeaderBox.ajc$tjp_16 = bVar23.h(str156, bVar23.g("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 208);
        TrackFragmentHeaderBox.ajc$tjp_17 = bVar23.h(str156, bVar23.g("1", "isDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 217);
        TrackFragmentHeaderBox.ajc$tjp_18 = bVar23.h(str156, bVar23.g("1", "setDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), 221);
        TrackFragmentHeaderBox.ajc$tjp_19 = bVar23.h(str156, bVar23.g("1", "isDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 230);
        TrackFragmentHeaderBox.ajc$tjp_2 = bVar23.h(str156, bVar23.g("1", "hasDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 134);
        TrackFragmentHeaderBox.ajc$tjp_20 = bVar23.h(str156, bVar23.g("1", "setDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), 234);
        TrackFragmentHeaderBox.ajc$tjp_21 = bVar23.h(str156, bVar23.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 244);
        TrackFragmentHeaderBox.ajc$tjp_3 = bVar23.h(str156, bVar23.g("1", "hasDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 138);
        TrackFragmentHeaderBox.ajc$tjp_4 = bVar23.h(str156, bVar23.g("1", "hasDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 142);
        TrackFragmentHeaderBox.ajc$tjp_5 = bVar23.h(str156, bVar23.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 146);
        TrackFragmentHeaderBox.ajc$tjp_6 = bVar23.h(str156, bVar23.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "trackId", "", "void"), 150);
        TrackFragmentHeaderBox.ajc$tjp_7 = bVar23.h(str156, bVar23.g("1", "getBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 154);
        TrackFragmentHeaderBox.ajc$tjp_8 = bVar23.h(str156, bVar23.g("1", "setBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), 158);
        TrackFragmentHeaderBox.ajc$tjp_9 = bVar23.h(str156, bVar23.g("1", "getSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 167);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int aVar;
        long l;
        int i;
        int i3;
        int i2;
        parseVersionAndFlags(byteBuffer);
        this.trackId = e.k(byteBuffer);
        final int i10 = 1;
        if (flags &= i10 == i10) {
            this.baseDataOffset = e.m(byteBuffer);
        }
        i = 2;
        if (flags2 &= i == i) {
            this.sampleDescriptionIndex = e.k(byteBuffer);
        }
        i3 = 8;
        if (flags3 &= i3 == i3) {
            this.defaultSampleDuration = e.k(byteBuffer);
        }
        i2 = 16;
        if (flags4 &= i2 == i2) {
            this.defaultSampleSize = e.k(byteBuffer);
        }
        int i11 = 32;
        if (flags5 &= i11 == i11) {
            aVar = new a(byteBuffer);
            this.defaultSampleFlags = aVar;
        }
        int i8 = 65536;
        if (obj5 &= i8 == i8) {
            this.durationIsEmpty = i10;
        }
        int i9 = 131072;
        if (obj5 &= i9 == i9) {
            this.defaultBaseIsMoof = i10;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getBaseDataOffset() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_7, this, this));
        return this.baseDataOffset;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int baseDataOffset;
        int sampleDescriptionIndex;
        int defaultSampleDuration;
        int defaultSampleSize;
        int defaultSampleFlags;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.trackId);
        int i = 1;
        if (flags &= i == i) {
            g.i(byteBuffer, getBaseDataOffset());
        }
        int i2 = 2;
        if (flags2 &= i2 == i2) {
            g.g(byteBuffer, getSampleDescriptionIndex());
        }
        int i3 = 8;
        if (flags3 &= i3 == i3) {
            g.g(byteBuffer, getDefaultSampleDuration());
        }
        int i4 = 16;
        if (flags4 &= i4 == i4) {
            g.g(byteBuffer, getDefaultSampleSize());
        }
        int i5 = 32;
        if (flags5 &= i5 == i5) {
            this.defaultSampleFlags.a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        int flags = getFlags();
        i = flags & 1 == 1 ? 16 : 8;
        final int i12 = 4;
        if (flags & 2 == 2) {
            i += i12;
        }
        if (flags & 8 == 8) {
            i += i12;
        }
        if (flags & 16 == 16) {
            i += i12;
        }
        int i8 = 32;
        if (flags &= i8 == i8) {
            i += i12;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDefaultSampleDuration() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_11, this, this));
        return this.defaultSampleDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public com.coremedia.iso.boxes.fragment.a getDefaultSampleFlags() {
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
        int i3 = 1;
        if (flags &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasDefaultSampleDuration() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_2, this, this));
        if (flags &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasDefaultSampleFlags() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_4, this, this));
        if (flags &= 32 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasDefaultSampleSize() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_3, this, this));
        if (flags &= 16 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean hasSampleDescriptionIndex() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_1, this, this));
        if (flags &= 2 != 0) {
            return 1;
        }
        return 0;
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
    public void setBaseDataOffset(long l) {
        int i;
        int dVar;
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_8, this, this, a.f(l)));
        if (Long.compare(l, i2) == 0) {
            setFlags(flags &= dVar);
        } else {
            setFlags(flags2 |= 1);
        }
        this.baseDataOffset = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultBaseIsMoof(boolean z) {
        int i2;
        int i;
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_20, this, this, a.a(z)));
        if (z) {
            setFlags(flags |= i);
        } else {
            setFlags(flags2 &= i);
        }
        this.defaultBaseIsMoof = z;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleDuration(long l) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_12, this, this, a.f(l)));
        setFlags(flags |= 8);
        this.defaultSampleDuration = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleFlags(com.coremedia.iso.boxes.fragment.a a) {
        int i;
        d dVar;
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_16, this, this, a));
        if (a != null) {
            setFlags(flags |= 32);
        } else {
            setFlags(flags2 &= dVar);
        }
        this.defaultSampleFlags = a;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleSize(long l) {
        int i;
        d dVar;
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_14, this, this, a.f(l)));
        if (Long.compare(l, i2) != 0) {
            setFlags(flags |= 16);
        } else {
            setFlags(flags2 &= dVar);
        }
        this.defaultSampleSize = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDurationIsEmpty(boolean z) {
        int i2;
        int i;
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_18, this, this, a.a(z)));
        if (this.defaultBaseIsMoof) {
            setFlags(flags |= i);
        } else {
            setFlags(flags2 &= i);
        }
        this.durationIsEmpty = z;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleDescriptionIndex(long l) {
        int i;
        int dVar;
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_10, this, this, a.f(l)));
        if (Long.compare(l, i2) == 0) {
            setFlags(flags &= dVar);
        } else {
            setFlags(flags2 |= 2);
        }
        this.sampleDescriptionIndex = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackId(long l) {
        d.b().c(b.d(TrackFragmentHeaderBox.ajc$tjp_6, this, this, a.f(l)));
        this.trackId = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackFragmentHeaderBox.ajc$tjp_21, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackFragmentHeaderBox");
        stringBuilder.append("{trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", baseDataOffset=");
        stringBuilder.append(this.baseDataOffset);
        stringBuilder.append(", sampleDescriptionIndex=");
        stringBuilder.append(this.sampleDescriptionIndex);
        stringBuilder.append(", defaultSampleDuration=");
        stringBuilder.append(this.defaultSampleDuration);
        stringBuilder.append(", defaultSampleSize=");
        stringBuilder.append(this.defaultSampleSize);
        stringBuilder.append(", defaultSampleFlags=");
        stringBuilder.append(this.defaultSampleFlags);
        stringBuilder.append(", durationIsEmpty=");
        stringBuilder.append(this.durationIsEmpty);
        stringBuilder.append(", defaultBaseIsMoof=");
        stringBuilder.append(this.defaultBaseIsMoof);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
