package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class GenericMediaHeaderTextAtom extends AbstractBox {

    public static final String TYPE = "text";
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
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    int unknown_1 = 65536;
    int unknown_2;
    int unknown_3;
    int unknown_4;
    int unknown_5 = 65536;
    int unknown_6;
    int unknown_7;
    int unknown_8;
    int unknown_9 = 1073741824;
    static {
        GenericMediaHeaderTextAtom.ajc$preClinit();
    }

    public GenericMediaHeaderTextAtom() {
        super("text");
        int i = 65536;
        int i2 = 1073741824;
    }

    private static void ajc$preClinit() {
        b bVar19 = new b("GenericMediaHeaderTextAtom.java", GenericMediaHeaderTextAtom.class);
        final String str128 = "method-execution";
        GenericMediaHeaderTextAtom.ajc$tjp_0 = bVar19.h(str128, bVar19.g("1", "getUnknown_1", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 60);
        GenericMediaHeaderTextAtom.ajc$tjp_1 = bVar19.h(str128, bVar19.g("1", "setUnknown_1", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_1", "", "void"), 64);
        GenericMediaHeaderTextAtom.ajc$tjp_10 = bVar19.h(str128, bVar19.g("1", "getUnknown_6", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 100);
        GenericMediaHeaderTextAtom.ajc$tjp_11 = bVar19.h(str128, bVar19.g("1", "setUnknown_6", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_6", "", "void"), 104);
        GenericMediaHeaderTextAtom.ajc$tjp_12 = bVar19.h(str128, bVar19.g("1", "getUnknown_7", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 108);
        GenericMediaHeaderTextAtom.ajc$tjp_13 = bVar19.h(str128, bVar19.g("1", "setUnknown_7", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_7", "", "void"), 112);
        GenericMediaHeaderTextAtom.ajc$tjp_14 = bVar19.h(str128, bVar19.g("1", "getUnknown_8", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 116);
        GenericMediaHeaderTextAtom.ajc$tjp_15 = bVar19.h(str128, bVar19.g("1", "setUnknown_8", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_8", "", "void"), 120);
        GenericMediaHeaderTextAtom.ajc$tjp_16 = bVar19.h(str128, bVar19.g("1", "getUnknown_9", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 124);
        GenericMediaHeaderTextAtom.ajc$tjp_17 = bVar19.h(str128, bVar19.g("1", "setUnknown_9", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_9", "", "void"), 128);
        GenericMediaHeaderTextAtom.ajc$tjp_2 = bVar19.h(str128, bVar19.g("1", "getUnknown_2", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 68);
        GenericMediaHeaderTextAtom.ajc$tjp_3 = bVar19.h(str128, bVar19.g("1", "setUnknown_2", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_2", "", "void"), 72);
        GenericMediaHeaderTextAtom.ajc$tjp_4 = bVar19.h(str128, bVar19.g("1", "getUnknown_3", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 76);
        GenericMediaHeaderTextAtom.ajc$tjp_5 = bVar19.h(str128, bVar19.g("1", "setUnknown_3", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_3", "", "void"), 80);
        GenericMediaHeaderTextAtom.ajc$tjp_6 = bVar19.h(str128, bVar19.g("1", "getUnknown_4", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 84);
        GenericMediaHeaderTextAtom.ajc$tjp_7 = bVar19.h(str128, bVar19.g("1", "setUnknown_4", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_4", "", "void"), 88);
        GenericMediaHeaderTextAtom.ajc$tjp_8 = bVar19.h(str128, bVar19.g("1", "getUnknown_5", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 92);
        GenericMediaHeaderTextAtom.ajc$tjp_9 = bVar19.h(str128, bVar19.g("1", "setUnknown_5", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_5", "", "void"), 96);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.unknown_1 = byteBuffer.getInt();
        this.unknown_2 = byteBuffer.getInt();
        this.unknown_3 = byteBuffer.getInt();
        this.unknown_4 = byteBuffer.getInt();
        this.unknown_5 = byteBuffer.getInt();
        this.unknown_6 = byteBuffer.getInt();
        this.unknown_7 = byteBuffer.getInt();
        this.unknown_8 = byteBuffer.getInt();
        this.unknown_9 = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.unknown_1);
        byteBuffer.putInt(this.unknown_2);
        byteBuffer.putInt(this.unknown_3);
        byteBuffer.putInt(this.unknown_4);
        byteBuffer.putInt(this.unknown_5);
        byteBuffer.putInt(this.unknown_6);
        byteBuffer.putInt(this.unknown_7);
        byteBuffer.putInt(this.unknown_8);
        byteBuffer.putInt(this.unknown_9);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 36;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_1() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_0, this, this));
        return this.unknown_1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_2() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_2, this, this));
        return this.unknown_2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_3() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_4, this, this));
        return this.unknown_3;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_4() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_6, this, this));
        return this.unknown_4;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_5() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_8, this, this));
        return this.unknown_5;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_6() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_10, this, this));
        return this.unknown_6;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_7() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_12, this, this));
        return this.unknown_7;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_8() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_14, this, this));
        return this.unknown_8;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getUnknown_9() {
        d.b().c(b.c(GenericMediaHeaderTextAtom.ajc$tjp_16, this, this));
        return this.unknown_9;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_1(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_1, this, this, a.e(i)));
        this.unknown_1 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_2(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_3, this, this, a.e(i)));
        this.unknown_2 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_3(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_5, this, this, a.e(i)));
        this.unknown_3 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_4(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_7, this, this, a.e(i)));
        this.unknown_4 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_5(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_9, this, this, a.e(i)));
        this.unknown_5 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_6(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_11, this, this, a.e(i)));
        this.unknown_6 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_7(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_13, this, this, a.e(i)));
        this.unknown_7 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_8(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_15, this, this, a.e(i)));
        this.unknown_8 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setUnknown_9(int i) {
        d.b().c(b.d(GenericMediaHeaderTextAtom.ajc$tjp_17, this, this, a.e(i)));
        this.unknown_9 = i;
    }
}
