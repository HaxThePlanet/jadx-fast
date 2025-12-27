package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: BaseMediaInfoAtom.java */
/* loaded from: classes2.dex */
public class BaseMediaInfoAtom extends AbstractFullBox {

    public static final String TYPE = "gmin";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_10;
    private static final /* synthetic */ a.a ajc$tjp_11;
    private static final /* synthetic */ a.a ajc$tjp_12;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    short balance;
    short graphicsMode = 64;
    int opColorB = 32768;
    int opColorG = 32768;
    int opColorR = 32768;
    short reserved;
    static {
        BaseMediaInfoAtom.ajc$preClinit();
    }

    public BaseMediaInfoAtom() {
        super("gmin");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("BaseMediaInfoAtom.java", BaseMediaInfoAtom.class);
        final String str93 = "method-execution";
        BaseMediaInfoAtom.ajc$tjp_0 = bVar.h(str93, bVar.g("1", "getGraphicsMode", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 54);
        BaseMediaInfoAtom.ajc$tjp_1 = bVar.h(str93, bVar.g("1", "setGraphicsMode", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "graphicsMode", "", "void"), 58);
        BaseMediaInfoAtom.ajc$tjp_10 = bVar.h(str93, bVar.g("1", "getReserved", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 94);
        BaseMediaInfoAtom.ajc$tjp_11 = bVar.h(str93, bVar.g("1", "setReserved", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "reserved", "", "void"), 98);
        BaseMediaInfoAtom.ajc$tjp_12 = bVar.h(str93, bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "java.lang.String"), 103);
        BaseMediaInfoAtom.ajc$tjp_2 = bVar.h(str93, bVar.g("1", "getOpColorR", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 62);
        BaseMediaInfoAtom.ajc$tjp_3 = bVar.h(str93, bVar.g("1", "setOpColorR", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorR", "", "void"), 66);
        BaseMediaInfoAtom.ajc$tjp_4 = bVar.h(str93, bVar.g("1", "getOpColorG", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 70);
        BaseMediaInfoAtom.ajc$tjp_5 = bVar.h(str93, bVar.g("1", "setOpColorG", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorG", "", "void"), 74);
        BaseMediaInfoAtom.ajc$tjp_6 = bVar.h(str93, bVar.g("1", "getOpColorB", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 78);
        BaseMediaInfoAtom.ajc$tjp_7 = bVar.h(str93, bVar.g("1", "setOpColorB", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorB", "", "void"), 82);
        BaseMediaInfoAtom.ajc$tjp_8 = bVar.h(str93, bVar.g("1", "getBalance", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 86);
        BaseMediaInfoAtom.ajc$tjp_9 = bVar.h(str93, bVar.g("1", "setBalance", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "balance", "", "void"), 90);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.graphicsMode = byteBuffer.getShort();
        this.opColorR = e.i(byteBuffer);
        this.opColorG = e.i(byteBuffer);
        this.opColorB = e.i(byteBuffer);
        this.balance = byteBuffer.getShort();
        this.reserved = byteBuffer.getShort();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public short getBalance() {
        d.b().c(b.c(BaseMediaInfoAtom.ajc$tjp_8, this, this));
        return this.balance;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.putShort(this.graphicsMode);
        g.e(byteBuffer, this.opColorR);
        g.e(byteBuffer, this.opColorG);
        g.e(byteBuffer, this.opColorB);
        byteBuffer.putShort(this.balance);
        byteBuffer.putShort(this.reserved);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public short getGraphicsMode() {
        d.b().c(b.c(BaseMediaInfoAtom.ajc$tjp_0, this, this));
        return this.graphicsMode;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getOpColorB() {
        d.b().c(b.c(BaseMediaInfoAtom.ajc$tjp_6, this, this));
        return this.opColorB;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getOpColorG() {
        d.b().c(b.c(BaseMediaInfoAtom.ajc$tjp_4, this, this));
        return this.opColorG;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getOpColorR() {
        d.b().c(b.c(BaseMediaInfoAtom.ajc$tjp_2, this, this));
        return this.opColorR;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public short getReserved() {
        d.b().c(b.c(BaseMediaInfoAtom.ajc$tjp_10, this, this));
        return this.reserved;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setBalance(short s) {
        d.b().c(b.d(BaseMediaInfoAtom.ajc$tjp_9, this, this, a.g(s)));
        this.balance = s;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGraphicsMode(short s) {
        d.b().c(b.d(BaseMediaInfoAtom.ajc$tjp_1, this, this, a.g(s)));
        this.graphicsMode = s;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setOpColorB(int i) {
        d.b().c(b.d(BaseMediaInfoAtom.ajc$tjp_7, this, this, a.e(i)));
        this.opColorB = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setOpColorG(int i) {
        d.b().c(b.d(BaseMediaInfoAtom.ajc$tjp_5, this, this, a.e(i)));
        this.opColorG = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setOpColorR(int i) {
        d.b().c(b.d(BaseMediaInfoAtom.ajc$tjp_3, this, this, a.e(i)));
        this.opColorR = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setReserved(short s) {
        d.b().c(b.d(BaseMediaInfoAtom.ajc$tjp_11, this, this, a.g(s)));
        this.reserved = s;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(BaseMediaInfoAtom.ajc$tjp_12, this, this));
        String str2 = "BaseMediaInfoAtom{graphicsMode=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", opColorR=";
        String str4 = ", opColorG=";
        String str5 = ", opColorB=";
        String str6 = ", balance=";
        String str7 = ", reserved=";
        str = str2 + this.graphicsMode + str3 + this.opColorR + str4 + this.opColorG + str5 + this.opColorB + str6 + this.balance + str7 + this.reserved + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 16;
    }
}
