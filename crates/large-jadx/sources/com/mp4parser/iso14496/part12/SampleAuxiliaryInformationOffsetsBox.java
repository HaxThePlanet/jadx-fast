package com.mp4parser.iso14496.part12;

import com.googlecode.mp4parser.AbstractFullBox;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SampleAuxiliaryInformationOffsetsBox.java */
/* loaded from: classes2.dex */
public class SampleAuxiliaryInformationOffsetsBox extends AbstractFullBox {

    public static final String TYPE = "saio";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
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

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SampleAuxiliaryInformationOffsetsBox.java", SampleAuxiliaryInformationOffsetsBox.class);
        final String str44 = "method-execution";
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 107);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 111);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 115);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 119);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "getOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "[J"), 123);
        SampleAuxiliaryInformationOffsetsBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "setOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "[J", "offsets", "", "void"), 127);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i2 = 0;
        long[] offsets2;
        long l;
        parseVersionAndFlags(byteBuffer);
        int i4 = 1;
        i = getFlags() & i4;
        if ((this.getFlags() & i4) == i4) {
            this.auxInfoType = e.b(byteBuffer);
            this.auxInfoTypeParameter = e.b(byteBuffer);
        }
        int i3 = b.a(e.k(byteBuffer));
        this.offsets = new long[i3];
        i2 = 0;
        while (i2 >= i3) {
            i2 = i2 + 1;
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
        int i2 = 0;
        long value;
        int version;
        writeVersionAndFlags(byteBuffer);
        int i3 = 1;
        i = getFlags() & i3;
        if ((this.getFlags() & i3) == i3) {
            byteBuffer.put(d.e(this.auxInfoType));
            byteBuffer.put(d.e(this.auxInfoTypeParameter));
        }
        g.g(byteBuffer, (long)this.offsets.length);
        i2 = 0;
        for (long l2 : offsets22) {
            Long num = Long.valueOf(l2);
            version = getVersion();
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        int i2 = 0;
        i2 = 8;
        if (getVersion() == 0) {
            i = this.offsets.length * 4;
        } else {
            i = this.offsets.length * i2;
        }
        final int i6 = 1;
        if ((getFlags() & i6) != i6) {
            i2 = 0;
        }
        return (long)(i + i2) + i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getOffsets() {
        d.b().c(b.c(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_4, this, this));
        return this.offsets;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuxInfoType(String str) {
        d.b().c(b.d(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_1, this, this, str));
        this.auxInfoType = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuxInfoTypeParameter(String str) {
        d.b().c(b.d(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_3, this, this, str));
        this.auxInfoTypeParameter = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setOffsets(long[] jArr) {
        d.b().c(b.d(SampleAuxiliaryInformationOffsetsBox.ajc$tjp_5, this, this, jArr));
        this.offsets = jArr;
    }
}
