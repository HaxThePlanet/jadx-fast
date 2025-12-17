package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.boxes.mp4.a.c;
import com.googlecode.mp4parser.boxes.mp4.a.d;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class DTSSpecificBox extends AbstractBox {

    public static final String TYPE = "ddts";
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
    private static final a.a ajc$tjp_22;
    private static final a.a ajc$tjp_23;
    private static final a.a ajc$tjp_24;
    private static final a.a ajc$tjp_25;
    private static final a.a ajc$tjp_26;
    private static final a.a ajc$tjp_27;
    private static final a.a ajc$tjp_28;
    private static final a.a ajc$tjp_29;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_30;
    private static final a.a ajc$tjp_31;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
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

    private static void ajc$preClinit() {
        b bVar33 = new b("DTSSpecificBox.java", DTSSpecificBox.class);
        final String str226 = "method-execution";
        DTSSpecificBox.ajc$tjp_0 = bVar33.h(str226, bVar33.g("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 89);
        DTSSpecificBox.ajc$tjp_1 = bVar33.h(str226, bVar33.g("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "avgBitRate", "", "void"), 93);
        DTSSpecificBox.ajc$tjp_10 = bVar33.h(str226, bVar33.g("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 129);
        DTSSpecificBox.ajc$tjp_11 = bVar33.h(str226, bVar33.g("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 133);
        DTSSpecificBox.ajc$tjp_12 = bVar33.h(str226, bVar33.g("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 137);
        DTSSpecificBox.ajc$tjp_13 = bVar33.h(str226, bVar33.g("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 141);
        DTSSpecificBox.ajc$tjp_14 = bVar33.h(str226, bVar33.g("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 145);
        DTSSpecificBox.ajc$tjp_15 = bVar33.h(str226, bVar33.g("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), 149);
        DTSSpecificBox.ajc$tjp_16 = bVar33.h(str226, bVar33.g("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 153);
        DTSSpecificBox.ajc$tjp_17 = bVar33.h(str226, bVar33.g("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 157);
        DTSSpecificBox.ajc$tjp_18 = bVar33.h(str226, bVar33.g("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 161);
        DTSSpecificBox.ajc$tjp_19 = bVar33.h(str226, bVar33.g("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), 165);
        DTSSpecificBox.ajc$tjp_2 = bVar33.h(str226, bVar33.g("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 97);
        DTSSpecificBox.ajc$tjp_20 = bVar33.h(str226, bVar33.g("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 169);
        DTSSpecificBox.ajc$tjp_21 = bVar33.h(str226, bVar33.g("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 173);
        DTSSpecificBox.ajc$tjp_22 = bVar33.h(str226, bVar33.g("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 177);
        DTSSpecificBox.ajc$tjp_23 = bVar33.h(str226, bVar33.g("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), 181);
        DTSSpecificBox.ajc$tjp_24 = bVar33.h(str226, bVar33.g("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 185);
        DTSSpecificBox.ajc$tjp_25 = bVar33.h(str226, bVar33.g("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), 189);
        DTSSpecificBox.ajc$tjp_26 = bVar33.h(str226, bVar33.g("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 193);
        DTSSpecificBox.ajc$tjp_27 = bVar33.h(str226, bVar33.g("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 197);
        DTSSpecificBox.ajc$tjp_28 = bVar33.h(str226, bVar33.g("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 201);
        DTSSpecificBox.ajc$tjp_29 = bVar33.h(str226, bVar33.g("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reserved", "", "void"), 205);
        DTSSpecificBox.ajc$tjp_3 = bVar33.h(str226, bVar33.g("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 101);
        DTSSpecificBox.ajc$tjp_30 = bVar33.h(str226, bVar33.g("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 209);
        DTSSpecificBox.ajc$tjp_31 = bVar33.h(str226, bVar33.g("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), 213);
        DTSSpecificBox.ajc$tjp_4 = bVar33.h(str226, bVar33.g("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 105);
        DTSSpecificBox.ajc$tjp_5 = bVar33.h(str226, bVar33.g("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "maxBitRate", "", "void"), 109);
        DTSSpecificBox.ajc$tjp_6 = bVar33.h(str226, bVar33.g("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 113);
        DTSSpecificBox.ajc$tjp_7 = bVar33.h(str226, bVar33.g("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 117);
        DTSSpecificBox.ajc$tjp_8 = bVar33.h(str226, bVar33.g("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 121);
        DTSSpecificBox.ajc$tjp_9 = bVar33.h(str226, bVar33.g("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 125);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.DTSSamplingFrequency = e.k(byteBuffer);
        this.maxBitRate = e.k(byteBuffer);
        this.avgBitRate = e.k(byteBuffer);
        this.pcmSampleDepth = e.n(byteBuffer);
        c cVar = new c(byteBuffer);
        this.frameDuration = cVar.a(2);
        int obj4 = 5;
        this.streamConstruction = cVar.a(obj4);
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
        this.reserved = cVar.a(obj4);
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
        d dVar = new d(byteBuffer);
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
    protected long getContentSize() {
        return 20;
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
        int i3;
        int i8;
        int i4;
        int i7;
        int i9;
        int i10;
        int i;
        int i6;
        int i2;
        int i5;
        int channelLayout = getChannelLayout();
        i8 = 4;
        final int i20 = 0;
        final int i21 = 1;
        if (channelLayout & 1 == i21) {
            i5 = i8;
            i3 = i21;
        } else {
            i5 = i3;
        }
        final int i29 = 2;
        if (channelLayout & 2 == i29) {
            i3 += 2;
            i22 |= i29;
        }
        if (channelLayout & 4 == i8) {
            i3 += 2;
            i5 = i8 | 32;
        }
        if (channelLayout & 8 == 8) {
            i3++;
            i5 |= 8;
        }
        if (channelLayout & 16 == 16) {
            i3++;
            i5 |= 256;
        }
        if (channelLayout & 32 == 32) {
            i3 += 2;
            i5 = i4 | 16384;
        }
        if (channelLayout & 64 == 64) {
            i3 += 2;
            i5 = i7 | 32;
        }
        if (channelLayout & 128 == 128) {
            i3++;
            i5 |= 8192;
        }
        if (channelLayout & 256 == 256) {
            i3++;
            i5 |= 2048;
        }
        if (channelLayout & 512 == 512) {
            i3 += 2;
            i5 = i9 | 128;
        }
        if (channelLayout & 1024 == 1024) {
            i3 += 2;
            i5 = i10 | 1024;
        }
        if (channelLayout & 2048 == 2048) {
            i3 += 2;
            i5 = i | 32;
        }
        if (channelLayout & 4096 == 4096) {
            i3++;
            i5 |= 8;
        }
        if (channelLayout & 8192 == 8192) {
            i3 += 2;
            i5 = i6 | 32;
        }
        int i31 = 65536;
        if (channelLayout & 16384 == 16384) {
            i3++;
            i5 |= i31;
        }
        i2 = 32768;
        int i38 = 131072;
        if (channelLayout & i2 == i2) {
            i3 += 2;
            i5 = i2 | i38;
        }
        if (channelLayout & i31 == i31) {
            i3++;
        }
        if (channelLayout &= i38 == i38) {
            i3 += 2;
        }
        int[] iArr = new int[i29];
        iArr[i20] = i3;
        iArr[i21] = i5;
        return iArr;
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
    public void setAvgBitRate(long l) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_1, this, this, a.f(l)));
        this.avgBitRate = l;
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
    public void setDTSSamplingFrequency(long l) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_3, this, this, a.f(l)));
        this.DTSSamplingFrequency = l;
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
    public void setMaxBitRate(long l) {
        d.b().c(b.d(DTSSpecificBox.ajc$tjp_5, this, this, a.f(l)));
        this.maxBitRate = l;
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
}
