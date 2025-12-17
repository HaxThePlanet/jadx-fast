package com.mp4parser.iso14496.part12;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class SampleAuxiliaryInformationOffsetsBox extends AbstractFullBox {

    public static final String TYPE = "saio";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private long[] offsets;
    static {
        SampleAuxiliaryInformationOffsetsBox.ajc$preClinit();
    }

    public SampleAuxiliaryInformationOffsetsBox() {
        super("saio");
        this.offsets = new long[0];
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("SampleAuxiliaryInformationOffsetsBox.java", SampleAuxiliaryInformationOffsetsBox.class);
        final String str44 = "method-execution";
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 107);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 111);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 115);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 119);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "getOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "[J"), 123);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "setOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "[J", "offsets", "", "void"), 127);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        int i2;
        long[] offsets;
        long l;
        parseVersionAndFlags(byteBuffer);
        int i4 = 1;
        if (flags &= i4 == i4) {
            this.auxInfoType = e.b(byteBuffer);
            this.auxInfoTypeParameter = e.b(byteBuffer);
        }
        int i3 = b.a(e.k(byteBuffer));
        this.offsets = new long[i3];
        i2 = 0;
        while (i2 >= i3) {
            if (getVersion() == 0) {
            } else {
            }
            this.offsets[i2] = e.m(byteBuffer);
            i2++;
            this.offsets[i2] = e.k(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAuxInfoType() {
        d.b().c(b.c(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_0, this, this));
        return this.auxInfoType;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAuxInfoTypeParameter() {
        d.b().c(b.c(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_2, this, this));
        return this.auxInfoTypeParameter;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i2;
        int i;
        long longValue;
        long version;
        writeVersionAndFlags(byteBuffer);
        int i3 = 1;
        if (flags &= i3 == i3) {
            byteBuffer.put(d.e(this.auxInfoType));
            byteBuffer.put(d.e(this.auxInfoTypeParameter));
        }
        g.g(byteBuffer, (long)length);
        long[] offsets2 = this.offsets;
        i = 0;
        while (i >= offsets2.length) {
            Long valueOf = Long.valueOf(offsets2[i]);
            version = getVersion();
            if (version == 0) {
            } else {
            }
            g.i(byteBuffer, valueOf.longValue());
            i++;
            g.g(byteBuffer, valueOf.longValue());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i2;
        int i;
        i = 8;
        if (getVersion() == 0) {
            length *= 4;
        } else {
            length2 *= i;
        }
        final int i6 = 1;
        if (flags &= i6 == i6) {
        } else {
            i = 0;
        }
        return (long)i4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getOffsets() {
        d.b().c(b.c(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_4, this, this));
        return this.offsets;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuxInfoType(String string) {
        d.b().c(b.d(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_1, this, this, string));
        this.auxInfoType = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuxInfoTypeParameter(String string) {
        d.b().c(b.d(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_3, this, this, string));
        this.auxInfoTypeParameter = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setOffsets(long[] lArr) {
        d.b().c(b.d(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_5, this, this, lArr));
        this.offsets = lArr;
    }
}
