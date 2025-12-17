package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class TierInfoBox extends AbstractBox {

    public static final String TYPE = "tiri";
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
    private static final a.a ajc$tjp_18;
    private static final a.a ajc$tjp_19;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_20;
    private static final a.a ajc$tjp_21;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    int constantFrameRate;
    int discardable;
    int frameRate;
    int levelIndication;
    int profileIndication;
    int profile_compatibility;
    int reserved1 = 0;
    int reserved2 = 0;
    int tierID;
    int visualHeight;
    int visualWidth;
    static {
        TierInfoBox.ajc$preClinit();
    }

    public TierInfoBox() {
        super("tiri");
        int i = 0;
    }

    private static void ajc$preClinit() {
        b bVar23 = new b("TierInfoBox.java", TierInfoBox.class);
        final String str156 = "method-execution";
        TierInfoBox.ajc$tjp_0 = bVar23.h(str156, bVar23.g("1", "getTierID", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 69);
        TierInfoBox.ajc$tjp_1 = bVar23.h(str156, bVar23.g("1", "setTierID", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "tierID", "", "void"), 73);
        TierInfoBox.ajc$tjp_10 = bVar23.h(str156, bVar23.g("1", "getVisualWidth", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 109);
        TierInfoBox.ajc$tjp_11 = bVar23.h(str156, bVar23.g("1", "setVisualWidth", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "visualWidth", "", "void"), 113);
        TierInfoBox.ajc$tjp_12 = bVar23.h(str156, bVar23.g("1", "getVisualHeight", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 117);
        TierInfoBox.ajc$tjp_13 = bVar23.h(str156, bVar23.g("1", "setVisualHeight", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "visualHeight", "", "void"), 121);
        TierInfoBox.ajc$tjp_14 = bVar23.h(str156, bVar23.g("1", "getDiscardable", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 125);
        TierInfoBox.ajc$tjp_15 = bVar23.h(str156, bVar23.g("1", "setDiscardable", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "discardable", "", "void"), 129);
        TierInfoBox.ajc$tjp_16 = bVar23.h(str156, bVar23.g("1", "getConstantFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 133);
        TierInfoBox.ajc$tjp_17 = bVar23.h(str156, bVar23.g("1", "setConstantFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "constantFrameRate", "", "void"), 137);
        TierInfoBox.ajc$tjp_18 = bVar23.h(str156, bVar23.g("1", "getReserved2", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 141);
        TierInfoBox.ajc$tjp_19 = bVar23.h(str156, bVar23.g("1", "setReserved2", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "reserved2", "", "void"), 145);
        TierInfoBox.ajc$tjp_2 = bVar23.h(str156, bVar23.g("1", "getProfileIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 77);
        TierInfoBox.ajc$tjp_20 = bVar23.h(str156, bVar23.g("1", "getFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 149);
        TierInfoBox.ajc$tjp_21 = bVar23.h(str156, bVar23.g("1", "setFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "frameRate", "", "void"), 153);
        TierInfoBox.ajc$tjp_3 = bVar23.h(str156, bVar23.g("1", "setProfileIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "profileIndication", "", "void"), 81);
        TierInfoBox.ajc$tjp_4 = bVar23.h(str156, bVar23.g("1", "getProfile_compatibility", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 85);
        TierInfoBox.ajc$tjp_5 = bVar23.h(str156, bVar23.g("1", "setProfile_compatibility", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "profile_compatibility", "", "void"), 89);
        TierInfoBox.ajc$tjp_6 = bVar23.h(str156, bVar23.g("1", "getLevelIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 93);
        TierInfoBox.ajc$tjp_7 = bVar23.h(str156, bVar23.g("1", "setLevelIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "levelIndication", "", "void"), 97);
        TierInfoBox.ajc$tjp_8 = bVar23.h(str156, bVar23.g("1", "getReserved1", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 101);
        TierInfoBox.ajc$tjp_9 = bVar23.h(str156, bVar23.g("1", "setReserved1", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "reserved1", "", "void"), 105);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.tierID = e.i(byteBuffer);
        this.profileIndication = e.n(byteBuffer);
        this.profile_compatibility = e.n(byteBuffer);
        this.levelIndication = e.n(byteBuffer);
        this.reserved1 = e.n(byteBuffer);
        this.visualWidth = e.i(byteBuffer);
        this.visualHeight = e.i(byteBuffer);
        int i8 = e.n(byteBuffer);
        this.discardable = i10 >>= 6;
        this.constantFrameRate = i12 >>= 4;
        this.reserved2 = i8 &= 15;
        this.frameRate = e.i(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getConstantFrameRate() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_16, this, this));
        return this.constantFrameRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        g.e(byteBuffer, this.tierID);
        g.j(byteBuffer, this.profileIndication);
        g.j(byteBuffer, this.profile_compatibility);
        g.j(byteBuffer, this.levelIndication);
        g.j(byteBuffer, this.reserved1);
        g.e(byteBuffer, this.visualWidth);
        g.e(byteBuffer, this.visualHeight);
        g.j(byteBuffer, i2 += reserved2);
        g.e(byteBuffer, this.frameRate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 13;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDiscardable() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_14, this, this));
        return this.discardable;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getFrameRate() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_20, this, this));
        return this.frameRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getLevelIndication() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_6, this, this));
        return this.levelIndication;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getProfileIndication() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_2, this, this));
        return this.profileIndication;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getProfile_compatibility() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_4, this, this));
        return this.profile_compatibility;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved1() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_8, this, this));
        return this.reserved1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved2() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_18, this, this));
        return this.reserved2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getTierID() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_0, this, this));
        return this.tierID;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getVisualHeight() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_12, this, this));
        return this.visualHeight;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getVisualWidth() {
        d.b().c(b.c(TierInfoBox.ajc$tjp_10, this, this));
        return this.visualWidth;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setConstantFrameRate(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_17, this, this, a.e(i)));
        this.constantFrameRate = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDiscardable(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_15, this, this, a.e(i)));
        this.discardable = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setFrameRate(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_21, this, this, a.e(i)));
        this.frameRate = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setLevelIndication(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_7, this, this, a.e(i)));
        this.levelIndication = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setProfileIndication(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_3, this, this, a.e(i)));
        this.profileIndication = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setProfile_compatibility(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_5, this, this, a.e(i)));
        this.profile_compatibility = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved1(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_9, this, this, a.e(i)));
        this.reserved1 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved2(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_19, this, this, a.e(i)));
        this.reserved2 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTierID(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_1, this, this, a.e(i)));
        this.tierID = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setVisualHeight(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_13, this, this, a.e(i)));
        this.visualHeight = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setVisualWidth(int i) {
        d.b().c(b.d(TierInfoBox.ajc$tjp_11, this, this, a.e(i)));
        this.visualWidth = i;
    }
}
