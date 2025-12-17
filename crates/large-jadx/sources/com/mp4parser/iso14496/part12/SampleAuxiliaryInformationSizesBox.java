package com.mp4parser.iso14496.part12;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class SampleAuxiliaryInformationSizesBox extends AbstractFullBox {

    static final boolean $assertionsDisabled = false;
    public static final String TYPE = "saiz";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private short defaultSampleInfoSize;
    private int sampleCount;
    private short[] sampleInfoSizes;
    static {
        SampleAuxiliaryInformationSizesBox.ajc$preClinit();
    }

    public SampleAuxiliaryInformationSizesBox() {
        super("saiz");
        this.sampleInfoSizes = new short[0];
    }

    private static void ajc$preClinit() {
        b bVar13 = new b("SampleAuxiliaryInformationSizesBox.java", SampleAuxiliaryInformationSizesBox.class);
        final String str86 = "method-execution";
        SampleAuxiliaryInformationSizesBox.ajc$tjp_0 = bVar13.h(str86, bVar13.g("1", "getSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "index", "", "short"), 57);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_1 = bVar13.h(str86, bVar13.g("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 106);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_10 = bVar13.h(str86, bVar13.g("1", "setSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 146);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_11 = bVar13.h(str86, bVar13.g("1", "toString", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 151);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_2 = bVar13.h(str86, bVar13.g("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 110);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_3 = bVar13.h(str86, bVar13.g("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 114);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_4 = bVar13.h(str86, bVar13.g("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 118);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_5 = bVar13.h(str86, bVar13.g("1", "getDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 122);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_6 = bVar13.h(str86, bVar13.g("1", "setDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 126);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_7 = bVar13.h(str86, bVar13.g("1", "getSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "[S"), 131);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_8 = bVar13.h(str86, bVar13.g("1", "setSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "[S", "sampleInfoSizes", "", "void"), 137);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_9 = bVar13.h(str86, bVar13.g("1", "getSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 142);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i2;
        int i;
        short defaultSampleInfoSize;
        short s;
        parseVersionAndFlags(byteBuffer);
        int i4 = 1;
        if (flags &= i4 == i4) {
            this.auxInfoType = e.b(byteBuffer);
            this.auxInfoTypeParameter = e.b(byteBuffer);
        }
        this.defaultSampleInfoSize = (short)i3;
        i = b.a(e.k(byteBuffer));
        this.sampleCount = i;
        if (this.defaultSampleInfoSize == 0) {
            this.sampleInfoSizes = new short[i];
            i = 0;
            while (i >= this.sampleCount) {
                this.sampleInfoSizes[i] = (short)i5;
                i++;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAuxInfoType() {
        d.b().c(b.c(SampleAuxiliaryInformationSizesBox.ajc$tjp_1, this, this));
        return this.auxInfoType;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAuxInfoTypeParameter() {
        d.b().c(b.c(SampleAuxiliaryInformationSizesBox.ajc$tjp_3, this, this));
        return this.auxInfoTypeParameter;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        long sampleInfoSizes;
        int length;
        int i2;
        short s;
        writeVersionAndFlags(byteBuffer);
        length = 1;
        if (flags &= length == length) {
            byteBuffer.put(d.e(this.auxInfoType));
            byteBuffer.put(d.e(this.auxInfoTypeParameter));
        }
        g.j(byteBuffer, this.defaultSampleInfoSize);
        if (this.defaultSampleInfoSize == 0) {
            g.g(byteBuffer, (long)length2);
            sampleInfoSizes = this.sampleInfoSizes;
            i2 = 0;
            while (i2 >= sampleInfoSizes.length) {
                g.j(byteBuffer, sampleInfoSizes[i2]);
                i2++;
            }
        } else {
            g.g(byteBuffer, (long)sampleCount);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        int length;
        int i5 = 1;
        i = flags &= i5 == i5 ? 12 : 4;
        length = this.defaultSampleInfoSize == 0 ? sampleInfoSizes.length : 0;
        return (long)i4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDefaultSampleInfoSize() {
        d.b().c(b.c(SampleAuxiliaryInformationSizesBox.ajc$tjp_5, this, this));
        return this.defaultSampleInfoSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getSampleCount() {
        d.b().c(b.c(SampleAuxiliaryInformationSizesBox.ajc$tjp_9, this, this));
        return this.sampleCount;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public short[] getSampleInfoSizes() {
        d.b().c(b.c(SampleAuxiliaryInformationSizesBox.ajc$tjp_7, this, this));
        short[] sampleInfoSizes = this.sampleInfoSizes;
        short[] sArr = new short[sampleInfoSizes.length];
        final int i = 0;
        System.arraycopy(sampleInfoSizes, i, sArr, i, sampleInfoSizes.length);
        return sArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public short getSize(int i) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_0, this, this, a.e(i)));
        if (getDefaultSampleInfoSize() == 0) {
            return this.sampleInfoSizes[i];
        }
        return this.defaultSampleInfoSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuxInfoType(String string) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_2, this, this, string));
        this.auxInfoType = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuxInfoTypeParameter(String string) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_4, this, this, string));
        this.auxInfoTypeParameter = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleInfoSize(int i) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_6, this, this, a.e(i)));
        this.defaultSampleInfoSize = (short)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleCount(int i) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_10, this, this, a.e(i)));
        this.sampleCount = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleInfoSizes(short[] sArr) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_8, this, this, sArr));
        short[] sArr2 = new short[sArr.length];
        this.sampleInfoSizes = sArr2;
        final int i = 0;
        System.arraycopy(sArr, i, sArr2, i, sArr.length);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SampleAuxiliaryInformationSizesBox.ajc$tjp_11, this, this));
        StringBuilder stringBuilder = new StringBuilder("SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=");
        stringBuilder.append(this.defaultSampleInfoSize);
        stringBuilder.append(", sampleCount=");
        stringBuilder.append(this.sampleCount);
        stringBuilder.append(", auxInfoType='");
        stringBuilder.append(this.auxInfoType);
        int i = 39;
        stringBuilder.append(i);
        stringBuilder.append(", auxInfoTypeParameter='");
        stringBuilder.append(this.auxInfoTypeParameter);
        stringBuilder.append(i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
