package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class PixelAspectRationAtom extends AbstractBox {

    public static final String TYPE = "pasp";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private int hSpacing;
    private int vSpacing;
    static {
        PixelAspectRationAtom.ajc$preClinit();
    }

    public PixelAspectRationAtom() {
        super("pasp");
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("PixelAspectRationAtom.java", PixelAspectRationAtom.class);
        final String str30 = "method-execution";
        PixelAspectRationAtom.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "gethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 35);
        PixelAspectRationAtom.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "sethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "hSpacing", "", "void"), 39);
        PixelAspectRationAtom.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "getvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 43);
        PixelAspectRationAtom.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "setvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "vSpacing", "", "void"), 47);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.hSpacing = byteBuffer.getInt();
        this.vSpacing = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.hSpacing);
        byteBuffer.putInt(this.vSpacing);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 8;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int gethSpacing() {
        d.b().c(b.c(PixelAspectRationAtom.ajc$tjp_0, this, this));
        return this.hSpacing;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getvSpacing() {
        d.b().c(b.c(PixelAspectRationAtom.ajc$tjp_2, this, this));
        return this.vSpacing;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void sethSpacing(int i) {
        d.b().c(b.d(PixelAspectRationAtom.ajc$tjp_1, this, this, a.e(i)));
        this.hSpacing = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setvSpacing(int i) {
        d.b().c(b.d(PixelAspectRationAtom.ajc$tjp_3, this, this, a.e(i)));
        this.vSpacing = i;
    }
}
