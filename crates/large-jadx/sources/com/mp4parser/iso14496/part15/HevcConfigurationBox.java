package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class HevcConfigurationBox extends AbstractBox {

    public static final String TYPE = "hvcC";
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
    private com.mp4parser.iso14496.part15.b hevcDecoderConfigurationRecord;
    static {
        HevcConfigurationBox.ajc$preClinit();
    }

    public HevcConfigurationBox() {
        super("hvcC");
        b bVar = new b();
        this.hevcDecoderConfigurationRecord = bVar;
    }

    private static void ajc$preClinit() {
        b bVar23 = new b("HevcConfigurationBox.java", HevcConfigurationBox.class);
        final String str156 = "method-execution";
        HevcConfigurationBox.ajc$tjp_0 = bVar23.h(str156, bVar23.g("1", "getHevcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord"), 38);
        HevcConfigurationBox.ajc$tjp_1 = bVar23.h(str156, bVar23.g("1", "setHevcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord", "hevcDecoderConfigurationRecord", "", "void"), 42);
        HevcConfigurationBox.ajc$tjp_10 = bVar23.h(str156, bVar23.g("1", "getGeneral_level_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 90);
        HevcConfigurationBox.ajc$tjp_11 = bVar23.h(str156, bVar23.g("1", "getMin_spatial_segmentation_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 94);
        HevcConfigurationBox.ajc$tjp_12 = bVar23.h(str156, bVar23.g("1", "getParallelismType", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 98);
        HevcConfigurationBox.ajc$tjp_13 = bVar23.h(str156, bVar23.g("1", "getChromaFormat", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 102);
        HevcConfigurationBox.ajc$tjp_14 = bVar23.h(str156, bVar23.g("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 106);
        HevcConfigurationBox.ajc$tjp_15 = bVar23.h(str156, bVar23.g("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 110);
        HevcConfigurationBox.ajc$tjp_16 = bVar23.h(str156, bVar23.g("1", "getAvgFrameRate", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 114);
        HevcConfigurationBox.ajc$tjp_17 = bVar23.h(str156, bVar23.g("1", "getNumTemporalLayers", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 118);
        HevcConfigurationBox.ajc$tjp_18 = bVar23.h(str156, bVar23.g("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 122);
        HevcConfigurationBox.ajc$tjp_19 = bVar23.h(str156, bVar23.g("1", "isTemporalIdNested", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 126);
        HevcConfigurationBox.ajc$tjp_2 = bVar23.h(str156, bVar23.g("1", "equals", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "java.lang.Object", "o", "", "boolean"), 47);
        HevcConfigurationBox.ajc$tjp_20 = bVar23.h(str156, bVar23.g("1", "getConstantFrameRate", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 130);
        HevcConfigurationBox.ajc$tjp_21 = bVar23.h(str156, bVar23.g("1", "getArrays", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "java.util.List"), 134);
        HevcConfigurationBox.ajc$tjp_3 = bVar23.h(str156, bVar23.g("1", "hashCode", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 60);
        HevcConfigurationBox.ajc$tjp_4 = bVar23.h(str156, bVar23.g("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 65);
        HevcConfigurationBox.ajc$tjp_5 = bVar23.h(str156, bVar23.g("1", "getGeneral_profile_space", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 69);
        HevcConfigurationBox.ajc$tjp_6 = bVar23.h(str156, bVar23.g("1", "isGeneral_tier_flag", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 73);
        HevcConfigurationBox.ajc$tjp_7 = bVar23.h(str156, bVar23.g("1", "getGeneral_profile_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 78);
        HevcConfigurationBox.ajc$tjp_8 = bVar23.h(str156, bVar23.g("1", "getGeneral_profile_compatibility_flags", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 82);
        HevcConfigurationBox.ajc$tjp_9 = bVar23.h(str156, bVar23.g("1", "getGeneral_constraint_indicator_flags", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 86);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.hevcDecoderConfigurationRecord.b(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public boolean equals(Object object) {
        Class class;
        Class class2;
        boolean obj5;
        d.b().c(b.d(HevcConfigurationBox.ajc$tjp_2, this, this, object));
        int i = 1;
        if (this == object) {
            return i;
        }
        int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                com.mp4parser.iso14496.part15.b hevcDecoderConfigurationRecord = this.hevcDecoderConfigurationRecord;
                obj5 = object.hevcDecoderConfigurationRecord;
                if (hevcDecoderConfigurationRecord != null) {
                    if (!hevcDecoderConfigurationRecord.equals(obj5)) {
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

    public List<com.mp4parser.iso14496.part15.b.a> getArrays() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_21, this, this));
        return hevcDecoderConfigurationRecord.w;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getAvgFrameRate() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_16, this, this));
        return hevcDecoderConfigurationRecord.r;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getBitDepthChromaMinus8() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_15, this, this));
        return hevcDecoderConfigurationRecord.q;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getBitDepthLumaMinus8() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_14, this, this));
        return hevcDecoderConfigurationRecord.o;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getChromaFormat() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_13, this, this));
        return hevcDecoderConfigurationRecord.m;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getConfigurationVersion() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_4, this, this));
        return hevcDecoderConfigurationRecord.a;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getConstantFrameRate() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_20, this, this));
        return hevcDecoderConfigurationRecord.s;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        this.hevcDecoderConfigurationRecord.c(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getGeneral_constraint_indicator_flags() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_9, this, this));
        return hevcDecoderConfigurationRecord.f;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getGeneral_level_idc() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_10, this, this));
        return hevcDecoderConfigurationRecord.g;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getGeneral_profile_compatibility_flags() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_8, this, this));
        return hevcDecoderConfigurationRecord.e;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getGeneral_profile_idc() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_7, this, this));
        return hevcDecoderConfigurationRecord.d;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getGeneral_profile_space() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_5, this, this));
        return hevcDecoderConfigurationRecord.b;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public com.mp4parser.iso14496.part15.b getHevcDecoderConfigurationRecord() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_0, this, this));
        return this.hevcDecoderConfigurationRecord;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getLengthSizeMinusOne() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_18, this, this));
        return hevcDecoderConfigurationRecord.v;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getMin_spatial_segmentation_idc() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_11, this, this));
        return hevcDecoderConfigurationRecord.i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getNumTemporalLayers() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_17, this, this));
        return hevcDecoderConfigurationRecord.t;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getParallelismType() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_12, this, this));
        return hevcDecoderConfigurationRecord.k;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int hashCode() {
        int i;
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_3, this, this));
        com.mp4parser.iso14496.part15.b hevcDecoderConfigurationRecord = this.hevcDecoderConfigurationRecord;
        if (hevcDecoderConfigurationRecord != null) {
            i = hevcDecoderConfigurationRecord.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public boolean isGeneral_tier_flag() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_6, this, this));
        return hevcDecoderConfigurationRecord.c;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public boolean isTemporalIdNested() {
        d.b().c(b.c(HevcConfigurationBox.ajc$tjp_19, this, this));
        return hevcDecoderConfigurationRecord.u;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setHevcDecoderConfigurationRecord(com.mp4parser.iso14496.part15.b b) {
        d.b().c(b.d(HevcConfigurationBox.ajc$tjp_1, this, this, b));
        this.hevcDecoderConfigurationRecord = b;
    }
}
