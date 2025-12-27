package com.mp4parser.iso14496.part12;

import com.googlecode.mp4parser.AbstractFullBox;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SampleAuxiliaryInformationSizesBox.java */
/* loaded from: classes2.dex */
public class SampleAuxiliaryInformationSizesBox extends AbstractFullBox {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "saiz";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_10;
    private static final /* synthetic */ a.a ajc$tjp_11;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private short defaultSampleInfoSize;
    private int sampleCount;
    private short[] sampleInfoSizes;
    public SampleAuxiliaryInformationSizesBox() {
        super("saiz");
        this.sampleInfoSizes = new short[0];
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SampleAuxiliaryInformationSizesBox.java", SampleAuxiliaryInformationSizesBox.class);
        final String str86 = "method-execution";
        SampleAuxiliaryInformationSizesBox.ajc$tjp_0 = bVar.h(str86, bVar.g("1", "getSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "index", "", "short"), 57);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_1 = bVar.h(str86, bVar.g("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 106);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_10 = bVar.h(str86, bVar.g("1", "setSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 146);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_11 = bVar.h(str86, bVar.g("1", "toString", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 151);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_2 = bVar.h(str86, bVar.g("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 110);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_3 = bVar.h(str86, bVar.g("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 114);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_4 = bVar.h(str86, bVar.g("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 118);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_5 = bVar.h(str86, bVar.g("1", "getDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 122);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_6 = bVar.h(str86, bVar.g("1", "setDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 126);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_7 = bVar.h(str86, bVar.g("1", "getSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "[S"), 131);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_8 = bVar.h(str86, bVar.g("1", "setSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "[S", "sampleInfoSizes", "", "void"), 137);
        SampleAuxiliaryInformationSizesBox.ajc$tjp_9 = bVar.h(str86, bVar.g("1", "getSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 142);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i2 = 0;
        short s;
        parseVersionAndFlags(byteBuffer);
        int i4 = 1;
        i = getFlags() & i4;
        if ((this.getFlags() & i4) == i4) {
            this.auxInfoType = e.b(byteBuffer);
            this.auxInfoTypeParameter = e.b(byteBuffer);
        }
        this.defaultSampleInfoSize = (short)e.n(byteBuffer);
        i2 = b.a(e.k(byteBuffer));
        this.sampleCount = i2;
        if (this.defaultSampleInfoSize == 0) {
            this.sampleInfoSizes = new short[i2];
            i2 = 0;
            while (i2 >= this.sampleCount) {
                s = (short)e.n(byteBuffer);
                this.sampleInfoSizes[i2] = s;
                i2 = i2 + 1;
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
        int i2 = 0;
        int i3;
        writeVersionAndFlags(byteBuffer);
        int length = 1;
        i = getFlags() & length;
        if ((this.getFlags() & length) == length) {
            byteBuffer.put(d.e(this.auxInfoType));
            byteBuffer.put(d.e(this.auxInfoTypeParameter));
        }
        g.j(byteBuffer, this.defaultSampleInfoSize);
        if (this.defaultSampleInfoSize == 0) {
            g.g(byteBuffer, (long)this.sampleInfoSizes.length);
            length = sampleInfoSizes22.length;
            i2 = 0;
            for (short s : sampleInfoSizes22) {
                g.j(byteBuffer, s);
            }
        } else {
            l = (long)this.sampleCount;
            g.g(byteBuffer, l);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 12;
        int length = 0;
        int i5 = 1;
        int r0 = (getFlags() & i5) == i5 ? 12 : 4;
        length = this.defaultSampleInfoSize == 0 ? sampleInfoSizes2.length : 0;
        return (long)((getFlags() & i5) == i5 ? 12 : 4) + 5 + length;
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
        short[] sArr = new short[sampleInfoSizes2.length];
        final int i = 0;
        System.arraycopy(this.sampleInfoSizes, i, sArr, i, sampleInfoSizes2.length);
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
    public void setAuxInfoType(String str) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_2, this, this, str));
        this.auxInfoType = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuxInfoTypeParameter(String str) {
        d.b().c(b.d(SampleAuxiliaryInformationSizesBox.ajc$tjp_4, this, this, str));
        this.auxInfoTypeParameter = str;
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
        String str2 = "SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", sampleCount=";
        String str4 = ", auxInfoType='";
        char c = '\'';
        String str5 = ", auxInfoTypeParameter='";
        str = str2 + this.defaultSampleInfoSize + str3 + this.sampleCount + str4 + this.auxInfoType + c + str5 + this.auxInfoTypeParameter + c + 125;
        return str;
    }

    static {
        SampleAuxiliaryInformationSizesBox.ajc$preClinit();
    }
}
