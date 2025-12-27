package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: OmaDrmAccessUnitFormatBox.java */
/* loaded from: classes.dex */
public final class OmaDrmAccessUnitFormatBox extends AbstractFullBox {

    public static final String TYPE = "odaf";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private byte allBits;
    private int initVectorLength;
    private int keyIndicatorLength;
    private boolean selectiveEncryption;
    static {
        OmaDrmAccessUnitFormatBox.ajc$preClinit();
    }

    public OmaDrmAccessUnitFormatBox() {
        super("odaf");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("OmaDrmAccessUnitFormatBox.java", OmaDrmAccessUnitFormatBox.class);
        final String str44 = "method-execution";
        OmaDrmAccessUnitFormatBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "isSelectiveEncryption", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "boolean"), 46);
        OmaDrmAccessUnitFormatBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "getKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 50);
        OmaDrmAccessUnitFormatBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "getInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 54);
        OmaDrmAccessUnitFormatBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "setInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "initVectorLength", "", "void"), 58);
        OmaDrmAccessUnitFormatBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "setKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "keyIndicatorLength", "", "void"), 62);
        OmaDrmAccessUnitFormatBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "setAllBits", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "byte", "allBits", "", "void"), 66);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 1;
        parseVersionAndFlags(byteBuffer);
        byte b = (byte)e.n(byteBuffer);
        this.allBits = b;
        final int i5 = 128;
        int r0 = (b & i5) == i5 ? 1 : 0;
        this.selectiveEncryption = ((b & i5) == i5 ? 1 : 0);
        this.keyIndicatorLength = ((b & i5) == i5 ? 1 : 0);
        this.initVectorLength = e.n(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.j(byteBuffer, this.allBits);
        g.j(byteBuffer, this.keyIndicatorLength);
        g.j(byteBuffer, this.initVectorLength);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getInitVectorLength() {
        d.b().c(b.c(OmaDrmAccessUnitFormatBox.ajc$tjp_2, this, this));
        return this.initVectorLength;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getKeyIndicatorLength() {
        d.b().c(b.c(OmaDrmAccessUnitFormatBox.ajc$tjp_1, this, this));
        return this.keyIndicatorLength;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSelectiveEncryption() {
        d.b().c(b.c(OmaDrmAccessUnitFormatBox.ajc$tjp_0, this, this));
        return this.selectiveEncryption;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAllBits(byte b) {
        int i = 1;
        d.b().c(b.d(OmaDrmAccessUnitFormatBox.ajc$tjp_5, this, this, a.b(b)));
        this.allBits = b;
        int i2 = 128;
        b = (b & i2) == i2 ? 1 : 0;
        this.selectiveEncryption = ((b & i2) == i2 ? 1 : 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInitVectorLength(int i) {
        d.b().c(b.d(OmaDrmAccessUnitFormatBox.ajc$tjp_3, this, this, a.e(i)));
        this.initVectorLength = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setKeyIndicatorLength(int i) {
        d.b().c(b.d(OmaDrmAccessUnitFormatBox.ajc$tjp_4, this, this, a.e(i)));
        this.keyIndicatorLength = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 7;
    }
}
