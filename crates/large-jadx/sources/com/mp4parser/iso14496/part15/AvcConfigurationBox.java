package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public final class AvcConfigurationBox extends AbstractBox {

    public static final String TYPE = "avcC";
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
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    public com.mp4parser.iso14496.part15.a avcDecoderConfigurationRecord;
    static {
        AvcConfigurationBox.ajc$preClinit();
    }

    public AvcConfigurationBox() {
        super("avcC");
        a aVar = new a();
        this.avcDecoderConfigurationRecord = aVar;
    }

    private static void ajc$preClinit() {
        b bVar31 = new b("AvcConfigurationBox.java", AvcConfigurationBox.class);
        final String str212 = "method-execution";
        AvcConfigurationBox.ajc$tjp_0 = bVar31.h(str212, bVar31.g("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        AvcConfigurationBox.ajc$tjp_1 = bVar31.h(str212, bVar31.g("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        AvcConfigurationBox.ajc$tjp_10 = bVar31.h(str212, bVar31.g("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        AvcConfigurationBox.ajc$tjp_11 = bVar31.h(str212, bVar31.g("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        AvcConfigurationBox.ajc$tjp_12 = bVar31.h(str212, bVar31.g("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        AvcConfigurationBox.ajc$tjp_13 = bVar31.h(str212, bVar31.g("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        AvcConfigurationBox.ajc$tjp_14 = bVar31.h(str212, bVar31.g("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        AvcConfigurationBox.ajc$tjp_15 = bVar31.h(str212, bVar31.g("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        AvcConfigurationBox.ajc$tjp_16 = bVar31.h(str212, bVar31.g("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        AvcConfigurationBox.ajc$tjp_17 = bVar31.h(str212, bVar31.g("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        AvcConfigurationBox.ajc$tjp_18 = bVar31.h(str212, bVar31.g("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        AvcConfigurationBox.ajc$tjp_19 = bVar31.h(str212, bVar31.g("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        AvcConfigurationBox.ajc$tjp_2 = bVar31.h(str212, bVar31.g("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        AvcConfigurationBox.ajc$tjp_20 = bVar31.h(str212, bVar31.g("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        AvcConfigurationBox.ajc$tjp_21 = bVar31.h(str212, bVar31.g("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        AvcConfigurationBox.ajc$tjp_22 = bVar31.h(str212, bVar31.g("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), 132);
        AvcConfigurationBox.ajc$tjp_23 = bVar31.h(str212, bVar31.g("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 136);
        AvcConfigurationBox.ajc$tjp_24 = bVar31.h(str212, bVar31.g("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 147);
        AvcConfigurationBox.ajc$tjp_25 = bVar31.h(str212, bVar31.g("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        AvcConfigurationBox.ajc$tjp_26 = bVar31.h(str212, bVar31.g("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        AvcConfigurationBox.ajc$tjp_27 = bVar31.h(str212, bVar31.g("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 162);
        AvcConfigurationBox.ajc$tjp_28 = bVar31.h(str212, bVar31.g("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        AvcConfigurationBox.ajc$tjp_29 = bVar31.h(str212, bVar31.g("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        AvcConfigurationBox.ajc$tjp_3 = bVar31.h(str212, bVar31.g("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        AvcConfigurationBox.ajc$tjp_4 = bVar31.h(str212, bVar31.g("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        AvcConfigurationBox.ajc$tjp_5 = bVar31.h(str212, bVar31.g("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        AvcConfigurationBox.ajc$tjp_6 = bVar31.h(str212, bVar31.g("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        AvcConfigurationBox.ajc$tjp_7 = bVar31.h(str212, bVar31.g("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        AvcConfigurationBox.ajc$tjp_8 = bVar31.h(str212, bVar31.g("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        AvcConfigurationBox.ajc$tjp_9 = bVar31.h(str212, bVar31.g("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        a aVar = new a(byteBuffer);
        this.avcDecoderConfigurationRecord = aVar;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getAvcLevelIndication() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_3, this, this));
        return avcDecoderConfigurationRecord.d;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getAvcProfileIndication() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_1, this, this));
        return avcDecoderConfigurationRecord.b;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getBitDepthChromaMinus8() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_18, this, this));
        return avcDecoderConfigurationRecord.k;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getBitDepthLumaMinus8() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_16, this, this));
        return avcDecoderConfigurationRecord.j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getChromaFormat() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_14, this, this));
        return avcDecoderConfigurationRecord.i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getConfigurationVersion() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_0, this, this));
        return avcDecoderConfigurationRecord.a;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_25, this, this, byteBuffer));
        this.avcDecoderConfigurationRecord.a(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_24, this, this));
        return this.avcDecoderConfigurationRecord.b();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getLengthSizeMinusOne() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_4, this, this));
        return avcDecoderConfigurationRecord.e;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String[] getPPS() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_27, this, this));
        return this.avcDecoderConfigurationRecord.c();
    }

    public List<byte[]> getPictureParameterSets() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_6, this, this));
        return Collections.unmodifiableList(avcDecoderConfigurationRecord.g);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getProfileCompatibility() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_2, this, this));
        return avcDecoderConfigurationRecord.c;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String[] getSPS() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_26, this, this));
        return this.avcDecoderConfigurationRecord.e();
    }

    public List<byte[]> getSequenceParameterSetExts() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_20, this, this));
        return avcDecoderConfigurationRecord.l;
    }

    public List<byte[]> getSequenceParameterSets() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_5, this, this));
        return Collections.unmodifiableList(avcDecoderConfigurationRecord.f);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public com.mp4parser.iso14496.part15.a getavcDecoderConfigurationRecord() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_28, this, this));
        return this.avcDecoderConfigurationRecord;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public boolean hasExts() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_22, this, this));
        return avcDecoderConfigurationRecord.h;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setAvcLevelIndication(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_10, this, this, a.e(i)));
        avcDecoderConfigurationRecord.d = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setAvcProfileIndication(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_8, this, this, a.e(i)));
        avcDecoderConfigurationRecord.b = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setBitDepthChromaMinus8(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_19, this, this, a.e(i)));
        avcDecoderConfigurationRecord.k = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setBitDepthLumaMinus8(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_17, this, this, a.e(i)));
        avcDecoderConfigurationRecord.j = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setChromaFormat(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_15, this, this, a.e(i)));
        avcDecoderConfigurationRecord.i = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setConfigurationVersion(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_7, this, this, a.e(i)));
        avcDecoderConfigurationRecord.a = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setHasExts(boolean z) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_23, this, this, a.a(z)));
        avcDecoderConfigurationRecord.h = z;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setLengthSizeMinusOne(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_11, this, this, a.e(i)));
        avcDecoderConfigurationRecord.e = i;
    }

    public void setPictureParameterSets(List<byte[]> list) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_13, this, this, list));
        avcDecoderConfigurationRecord.g = list;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setProfileCompatibility(int i) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_9, this, this, a.e(i)));
        avcDecoderConfigurationRecord.c = i;
    }

    public void setSequenceParameterSetExts(List<byte[]> list) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_21, this, this, list));
        avcDecoderConfigurationRecord.l = list;
    }

    public void setSequenceParameterSets(List<byte[]> list) {
        d.b().c(b.d(AvcConfigurationBox.ajc$tjp_12, this, this, list));
        avcDecoderConfigurationRecord.f = list;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(AvcConfigurationBox.ajc$tjp_29, this, this));
        StringBuilder stringBuilder = new StringBuilder("AvcConfigurationBox{avcDecoderConfigurationRecord=");
        stringBuilder.append(this.avcDecoderConfigurationRecord);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
