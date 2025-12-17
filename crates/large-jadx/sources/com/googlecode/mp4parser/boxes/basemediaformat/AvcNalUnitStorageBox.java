package com.googlecode.mp4parser.boxes.basemediaformat;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.mp4parser.iso14496.part15.a;
import java.nio.ByteBuffer;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class AvcNalUnitStorageBox extends AbstractBox {

    public static final String TYPE = "avcn";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    a avcDecoderConfigurationRecord;
    static {
        AvcNalUnitStorageBox.ajc$preClinit();
    }

    public AvcNalUnitStorageBox() {
        super("avcn");
    }

    public AvcNalUnitStorageBox(AvcConfigurationBox avcConfigurationBox) {
        super("avcn");
        this.avcDecoderConfigurationRecord = avcConfigurationBox.getavcDecoderConfigurationRecord();
    }

    private static void ajc$preClinit() {
        b bVar9 = new b("AvcNalUnitStorageBox.java", AvcNalUnitStorageBox.class);
        final String str58 = "method-execution";
        AvcNalUnitStorageBox.ajc$tjp_0 = bVar9.h(str58, bVar9.g("1", "getAvcDecoderConfigurationRecord", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 44);
        AvcNalUnitStorageBox.ajc$tjp_1 = bVar9.h(str58, bVar9.g("1", "getLengthSizeMinusOne", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "int"), 49);
        AvcNalUnitStorageBox.ajc$tjp_2 = bVar9.h(str58, bVar9.g("1", "getSPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 53);
        AvcNalUnitStorageBox.ajc$tjp_3 = bVar9.h(str58, bVar9.g("1", "getPPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 57);
        AvcNalUnitStorageBox.ajc$tjp_4 = bVar9.h(str58, bVar9.g("1", "getSequenceParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 61);
        AvcNalUnitStorageBox.ajc$tjp_5 = bVar9.h(str58, bVar9.g("1", "getSequenceParameterSetExtsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 65);
        AvcNalUnitStorageBox.ajc$tjp_6 = bVar9.h(str58, bVar9.g("1", "getPictureParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 69);
        AvcNalUnitStorageBox.ajc$tjp_7 = bVar9.h(str58, bVar9.g("1", "toString", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.lang.String"), 89);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        a aVar = new a(byteBuffer);
        this.avcDecoderConfigurationRecord = aVar;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public a getAvcDecoderConfigurationRecord() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_0, this, this));
        return this.avcDecoderConfigurationRecord;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord.a(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.avcDecoderConfigurationRecord.b();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getLengthSizeMinusOne() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_1, this, this));
        return avcDecoderConfigurationRecord.e;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String[] getPPS() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_3, this, this));
        return this.avcDecoderConfigurationRecord.c();
    }

    public List<String> getPictureParameterSetsAsStrings() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_6, this, this));
        return this.avcDecoderConfigurationRecord.d();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String[] getSPS() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_2, this, this));
        return this.avcDecoderConfigurationRecord.e();
    }

    public List<String> getSequenceParameterSetExtsAsStrings() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_5, this, this));
        return this.avcDecoderConfigurationRecord.f();
    }

    public List<String> getSequenceParameterSetsAsStrings() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_4, this, this));
        return this.avcDecoderConfigurationRecord.g();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(AvcNalUnitStorageBox.ajc$tjp_7, this, this));
        StringBuilder stringBuilder = new StringBuilder("AvcNalUnitStorageBox{SPS=");
        stringBuilder.append(this.avcDecoderConfigurationRecord.g());
        stringBuilder.append(",PPS=");
        stringBuilder.append(this.avcDecoderConfigurationRecord.d());
        stringBuilder.append(",lengthSize=");
        stringBuilder.append(i++);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
