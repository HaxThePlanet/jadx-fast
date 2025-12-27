package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.boxes.mp4.a.c;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: DTSSpecificBox.java */
/* loaded from: classes2.dex */
public class DTSSpecificBox extends AbstractBox {

    public static final String TYPE = "ddts";
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
    private static final /* synthetic */ a.a ajc$tjp_22;
    private static final /* synthetic */ a.a ajc$tjp_23;
    private static final /* synthetic */ a.a ajc$tjp_24;
    private static final /* synthetic */ a.a ajc$tjp_25;
    private static final /* synthetic */ a.a ajc$tjp_26;
    private static final /* synthetic */ a.a ajc$tjp_27;
    private static final /* synthetic */ a.a ajc$tjp_28;
    private static final /* synthetic */ a.a ajc$tjp_29;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_30;
    private static final /* synthetic */ a.a ajc$tjp_31;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    long DTSSamplingFrequency;
    int LBRDurationMod;
    long avgBitRate;
    int channelLayout;
    int coreLFEPresent;
    int coreLayout;
    int coreSize;
    int frameDuration;
    long maxBitRate;
    int multiAssetFlag;
    int pcmSampleDepth;
    int representationType;
    int reserved;
    int reservedBoxPresent;
    int stereoDownmix;
    int streamConstruction;
    static {
        DTSSpecificBox.ajc$preClinit();
    }

    public DTSSpecificBox() {
        super("ddts");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("DTSSpecificBox.java", DTSSpecificBox.class);
        final String str226 = "method-execution";
        DTSSpecificBox.ajc$tjp_0 = bVar.h(str226, bVar.g("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 89);
        DTSSpecificBox.ajc$tjp_1 = bVar.h(str226, bVar.g("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "avgBitRate", "", "void"), 93);
        DTSSpecificBox.ajc$tjp_10 = bVar.h(str226, bVar.g("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 129);
        DTSSpecificBox.ajc$tjp_11 = bVar.h(str226, bVar.g("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 133);
        DTSSpecificBox.ajc$tjp_12 = bVar.h(str226, bVar.g("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 137);
        DTSSpecificBox.ajc$tjp_13 = bVar.h(str226, bVar.g("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 141);
        DTSSpecificBox.ajc$tjp_14 = bVar.h(str226, bVar.g("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 145);
        DTSSpecificBox.ajc$tjp_15 = bVar.h(str226, bVar.g("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), 149);
        DTSSpecificBox.ajc$tjp_16 = bVar.h(str226, bVar.g("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 153);
        DTSSpecificBox.ajc$tjp_17 = bVar.h(str226, bVar.g("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 157);
        DTSSpecificBox.ajc$tjp_18 = bVar.h(str226, bVar.g("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 161);
        DTSSpecificBox.ajc$tjp_19 = bVar.h(str226, bVar.g("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), 165);
        DTSSpecificBox.ajc$tjp_2 = bVar.h(str226, bVar.g("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 97);
        DTSSpecificBox.ajc$tjp_20 = bVar.h(str226, bVar.g("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 169);
        DTSSpecificBox.ajc$tjp_21 = bVar.h(str226, bVar.g("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 173);
        DTSSpecificBox.ajc$tjp_22 = bVar.h(str226, bVar.g("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 177);
        DTSSpecificBox.ajc$tjp_23 = bVar.h(str226, bVar.g("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), 181);
        DTSSpecificBox.ajc$tjp_24 = bVar.h(str226, bVar.g("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 185);
        DTSSpecificBox.ajc$tjp_25 = bVar.h(str226, bVar.g("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), 189);
        DTSSpecificBox.ajc$tjp_26 = bVar.h(str226, bVar.g("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 193);
        DTSSpecificBox.ajc$tjp_27 = bVar.h(str226, bVar.g("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 197);
        DTSSpecificBox.ajc$tjp_28 = bVar.h(str226, bVar.g("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 201);
        DTSSpecificBox.ajc$tjp_29 = bVar.h(str226, bVar.g("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reserved", "", "void"), 205);
        DTSSpecificBox.ajc$tjp_3 = bVar.h(str226, bVar.g("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 101);
        DTSSpecificBox.ajc$tjp_30 = bVar.h(str226, bVar.g("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 209);
        DTSSpecificBox.ajc$tjp_31 = bVar.h(str226, bVar.g("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), 213);
        DTSSpecificBox.ajc$tjp_4 = bVar.h(str226, bVar.g("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 105);
        DTSSpecificBox.ajc$tjp_5 = bVar.h(str226, bVar.g("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "maxBitRate", "", "void"), 109);
        DTSSpecificBox.ajc$tjp_6 = bVar.h(str226, bVar.g("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 113);
        DTSSpecificBox.ajc$tjp_7 = bVar.h(str226, bVar.g("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 117);
        DTSSpecificBox.ajc$tjp_8 = bVar.h(str226, bVar.g("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 121);
        DTSSpecificBox.ajc$tjp_9 = bVar.h(str226, bVar.g("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 125);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.DTSSamplingFrequency = e.k(byteBuffer);
        this.maxBitRate = e.k(byteBuffer);
        this.avgBitRate = e.k(byteBuffer);
        this.pcmSampleDepth = e.n(byteBuffer);
        c cVar = new c(byteBuffer);
        this.frameDuration = cVar.a(2);
        int i19 = 5;
        this.streamConstruction = cVar.a(i19);
        int i3 = 1;
        this.coreLFEPresent = cVar.a(i3);
        this.coreLayout = cVar.a(6);
        this.coreSize = cVar.a(14);
        this.stereoDownmix = cVar.a(i3);
        this.representationType = cVar.a(3);
        this.channelLayout = cVar.a(16);
        this.multiAssetFlag = cVar.a(i3);
        this.LBRDurationMod = cVar.a(i3);
        this.reservedBoxPresent = cVar.a(i3);
        this.reserved = cVar.a(i19);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getAvgBitRate() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_0, this, this));
        return this.avgBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getChannelLayout() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_22, this, this));
        return this.channelLayout;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        g.g(byteBuffer, this.DTSSamplingFrequency);
        g.g(byteBuffer, this.maxBitRate);
        g.g(byteBuffer, this.avgBitRate);
        g.j(byteBuffer, this.pcmSampleDepth);
        com.googlecode.mp4parser.boxes.mp4.a.d dVar = new d(byteBuffer);
        dVar.a(this.frameDuration, 2);
        int i2 = 5;
        dVar.a(this.streamConstruction, i2);
        final int i3 = 1;
        dVar.a(this.coreLFEPresent, i3);
        dVar.a(this.coreLayout, 6);
        dVar.a(this.coreSize, 14);
        dVar.a(this.stereoDownmix, i3);
        dVar.a(this.representationType, 3);
        dVar.a(this.channelLayout, 16);
        dVar.a(this.multiAssetFlag, i3);
        dVar.a(this.LBRDurationMod, i3);
        dVar.a(this.reservedBoxPresent, i3);
        dVar.a(this.reserved, i2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getCoreLFEPresent() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_12, this, this));
        return this.coreLFEPresent;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getCoreLayout() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_14, this, this));
        return this.coreLayout;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getCoreSize() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_16, this, this));
        return this.coreSize;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getDTSSamplingFrequency() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_2, this, this));
        return this.DTSSamplingFrequency;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int[] getDashAudioChannelConfiguration() {
        int i;
        int channelLayout = getChannelLayout();
        i = 4;
        i = 0;
        i = 1;
        if ((channelLayout & 1) == i) {
        } else {
        }
        final int i25 = 2;
        if ((channelLayout & 2) == i25) {
            i = i + 2;
            i = (i | 1) | i25;
        }
        if ((channelLayout & 4) == i) {
            i = i + 2;
            i = i | 16;
            i = i | 32;
        }
        if ((channelLayout & 8) == 8) {
            i = i + 1;
            i = i | 8;
        }
        if ((channelLayout & 16) == 16) {
            i = i + 1;
            i = i | 256;
        }
        i2 = channelLayout & 32;
        if ((channelLayout & 32) == 32) {
            i = i + 2;
            i2 = i | 4096;
            i = i2 | 16384;
        }
        i3 = channelLayout & 64;
        if ((channelLayout & 64) == 64) {
            i = i + 2;
            i3 = i | 16;
            i = i3 | 32;
        }
        if ((channelLayout & 128) == 128) {
            i = i + 1;
            i = i | 8192;
        }
        if ((channelLayout & 256) == 256) {
            i = i + 1;
            i = i | 2048;
        }
        i4 = channelLayout & 512;
        if ((channelLayout & 512) == 512) {
            i = i + 2;
            i4 = i | 64;
            i = i4 | 128;
        }
        i5 = channelLayout & 1024;
        if ((channelLayout & 1024) == 1024) {
            i = i + 2;
            i5 = i | 512;
            i = i5 | 1024;
        }
        i6 = channelLayout & 2048;
        if ((channelLayout & 2048) == 2048) {
            i = i + 2;
            i6 = i | 16;
            i = i6 | 32;
        }
        if ((channelLayout & 4096) == 4096) {
            i = i + 1;
            i = i | 8;
        }
        i7 = channelLayout & 8192;
        if ((channelLayout & 8192) == 8192) {
            i = i + 2;
            i7 = i | 16;
            i = i7 | 32;
        }
        int i27 = 65536;
        if ((channelLayout & 16384) == 16384) {
            i = i + 1;
            i = i | i27;
        }
        int i8 = 32768;
        int i34 = 131072;
        if ((channelLayout & i8) == i8) {
            i = i + 2;
            i8 = i8 | i;
            i = i8 | i34;
        }
        if ((channelLayout & i27) == i27) {
            i = i + 1;
        }
        if ((channelLayout & i34) == i34) {
            i = i + 2;
        }
        int[] iArr = new int[i25];
        return new int[] { i, i };
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getFrameDuration() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_8, this, this));
        return this.frameDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getLBRDurationMod() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_26, this, this));
        return this.LBRDurationMod;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getMaxBitRate() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_4, this, this));
        return this.maxBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getMultiAssetFlag() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_24, this, this));
        return this.multiAssetFlag;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getPcmSampleDepth() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_6, this, this));
        return this.pcmSampleDepth;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getRepresentationType() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_20, this, this));
        return this.representationType;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_28, this, this));
        return this.reserved;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReservedBoxPresent() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_30, this, this));
        return this.reservedBoxPresent;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getStereoDownmix() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_18, this, this));
        return this.stereoDownmix;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getStreamConstruction() {
        d.b().c(b.c(DTSSpecificBox.ajc$tjp_10, this, this));
        return this.streamConstruction;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setAvgBitRate(long j) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_1, this, this, a.f(j)));
        this.avgBitRate = j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setChannelLayout(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_23, this, this, a.e(i)));
        this.channelLayout = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setCoreLFEPresent(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_13, this, this, a.e(i)));
        this.coreLFEPresent = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setCoreLayout(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_15, this, this, a.e(i)));
        this.coreLayout = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setCoreSize(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_17, this, this, a.e(i)));
        this.coreSize = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDTSSamplingFrequency(long j) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_3, this, this, a.f(j)));
        this.DTSSamplingFrequency = j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setFrameDuration(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_9, this, this, a.e(i)));
        this.frameDuration = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setLBRDurationMod(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_27, this, this, a.e(i)));
        this.LBRDurationMod = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMaxBitRate(long j) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_5, this, this, a.f(j)));
        this.maxBitRate = j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMultiAssetFlag(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_25, this, this, a.e(i)));
        this.multiAssetFlag = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setPcmSampleDepth(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_7, this, this, a.e(i)));
        this.pcmSampleDepth = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setRepresentationType(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_21, this, this, a.e(i)));
        this.representationType = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_29, this, this, a.e(i)));
        this.reserved = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReservedBoxPresent(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_31, this, this, a.e(i)));
        this.reservedBoxPresent = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setStereoDownmix(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_19, this, this, a.e(i)));
        this.stereoDownmix = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setStreamConstruction(int i) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_11, this, this, a.e(i)));
        this.streamConstruction = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 20;
    }
}
