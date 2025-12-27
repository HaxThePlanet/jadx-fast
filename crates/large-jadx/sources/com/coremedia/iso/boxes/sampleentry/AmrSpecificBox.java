package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractBox;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AmrSpecificBox.java */
/* loaded from: classes.dex */
public class AmrSpecificBox extends AbstractBox {

    public static final String TYPE = "damr";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private int decoderVersion;
    private int framesPerSample;
    private int modeChangePeriod;
    private int modeSet;
    private String vendor;
    static {
        AmrSpecificBox.ajc$preClinit();
    }

    public AmrSpecificBox() {
        super("damr");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AmrSpecificBox.java", AmrSpecificBox.class);
        final String str51 = "method-execution";
        AmrSpecificBox.ajc$tjp_0 = bVar.h(str51, bVar.g("1", "getVendor", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 46);
        AmrSpecificBox.ajc$tjp_1 = bVar.h(str51, bVar.g("1", "getDecoderVersion", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 50);
        AmrSpecificBox.ajc$tjp_2 = bVar.h(str51, bVar.g("1", "getModeSet", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 54);
        AmrSpecificBox.ajc$tjp_3 = bVar.h(str51, bVar.g("1", "getModeChangePeriod", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 58);
        AmrSpecificBox.ajc$tjp_4 = bVar.h(str51, bVar.g("1", "getFramesPerSample", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 62);
        AmrSpecificBox.ajc$tjp_5 = bVar.h(str51, bVar.g("1", "getContent", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 84);
        AmrSpecificBox.ajc$tjp_6 = bVar.h(str51, bVar.g("1", "toString", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 92);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.vendor = d.c(bArr);
        this.decoderVersion = e.n(byteBuffer);
        this.modeSet = e.i(byteBuffer);
        this.modeChangePeriod = e.n(byteBuffer);
        this.framesPerSample = e.n(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        d.b().c(b.d(AmrSpecificBox.ajc$tjp_5, this, this, byteBuffer));
        byteBuffer.put(d.e(this.vendor));
        g.j(byteBuffer, this.decoderVersion);
        g.e(byteBuffer, this.modeSet);
        g.j(byteBuffer, this.modeChangePeriod);
        g.j(byteBuffer, this.framesPerSample);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDecoderVersion() {
        d.b().c(b.c(AmrSpecificBox.ajc$tjp_1, this, this));
        return this.decoderVersion;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getFramesPerSample() {
        d.b().c(b.c(AmrSpecificBox.ajc$tjp_4, this, this));
        return this.framesPerSample;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getModeChangePeriod() {
        d.b().c(b.c(AmrSpecificBox.ajc$tjp_3, this, this));
        return this.modeChangePeriod;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getModeSet() {
        d.b().c(b.c(AmrSpecificBox.ajc$tjp_2, this, this));
        return this.modeSet;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getVendor() {
        d.b().c(b.c(AmrSpecificBox.ajc$tjp_0, this, this));
        return this.vendor;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(AmrSpecificBox.ajc$tjp_6, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "AmrSpecificBox[vendor=";
        String vendor = getVendor();
        String str3 = ";decoderVersion=";
        int decoderVersion = getDecoderVersion();
        String str4 = ";modeSet=";
        int modeSet = getModeSet();
        String str5 = ";modeChangePeriod=";
        int modeChangePeriod = getModeChangePeriod();
        String str6 = ";framesPerSample=";
        int framesPerSample = getFramesPerSample();
        String str7 = "]";
        str = str2 + vendor + str3 + decoderVersion + str4 + modeSet + str5 + modeChangePeriod + str6 + framesPerSample + str7;
        return str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 9;
    }
}
