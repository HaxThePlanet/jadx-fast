package com.coremedia.iso.boxes.apple;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public final class AppleLosslessSpecificBox extends AbstractFullBox {

    public static final String TYPE = "alac";
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
    private long bitRate;
    private int channels;
    private int historyMult;
    private int initialHistory;
    private int kModifier;
    private long maxCodedFrameSize;
    private long maxSamplePerFrame;
    private long sampleRate;
    private int sampleSize;
    private int unknown1;
    private int unknown2;
    static {
        AppleLosslessSpecificBox.ajc$preClinit();
    }

    public AppleLosslessSpecificBox() {
        super("alac");
    }

    private static void ajc$preClinit() {
        b bVar23 = new b("AppleLosslessSpecificBox.java", AppleLosslessSpecificBox.class);
        final String str156 = "method-execution";
        AppleLosslessSpecificBox.ajc$tjp_0 = bVar23.h(str156, bVar23.g("1", "getMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 34);
        AppleLosslessSpecificBox.ajc$tjp_1 = bVar23.h(str156, bVar23.g("1", "setMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxSamplePerFrame", "", "void"), 38);
        AppleLosslessSpecificBox.ajc$tjp_10 = bVar23.h(str156, bVar23.g("1", "getKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 74);
        AppleLosslessSpecificBox.ajc$tjp_11 = bVar23.h(str156, bVar23.g("1", "setKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "kModifier", "", "void"), 78);
        AppleLosslessSpecificBox.ajc$tjp_12 = bVar23.h(str156, bVar23.g("1", "getChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 82);
        AppleLosslessSpecificBox.ajc$tjp_13 = bVar23.h(str156, bVar23.g("1", "setChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "channels", "", "void"), 86);
        AppleLosslessSpecificBox.ajc$tjp_14 = bVar23.h(str156, bVar23.g("1", "getUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 90);
        AppleLosslessSpecificBox.ajc$tjp_15 = bVar23.h(str156, bVar23.g("1", "setUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown2", "", "void"), 94);
        AppleLosslessSpecificBox.ajc$tjp_16 = bVar23.h(str156, bVar23.g("1", "getMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 98);
        AppleLosslessSpecificBox.ajc$tjp_17 = bVar23.h(str156, bVar23.g("1", "setMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxCodedFrameSize", "", "void"), 102);
        AppleLosslessSpecificBox.ajc$tjp_18 = bVar23.h(str156, bVar23.g("1", "getBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 106);
        AppleLosslessSpecificBox.ajc$tjp_19 = bVar23.h(str156, bVar23.g("1", "setBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "bitRate", "", "void"), 110);
        AppleLosslessSpecificBox.ajc$tjp_2 = bVar23.h(str156, bVar23.g("1", "getUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 42);
        AppleLosslessSpecificBox.ajc$tjp_20 = bVar23.h(str156, bVar23.g("1", "getSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 114);
        AppleLosslessSpecificBox.ajc$tjp_21 = bVar23.h(str156, bVar23.g("1", "setSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleRate", "", "void"), 118);
        AppleLosslessSpecificBox.ajc$tjp_3 = bVar23.h(str156, bVar23.g("1", "setUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown1", "", "void"), 46);
        AppleLosslessSpecificBox.ajc$tjp_4 = bVar23.h(str156, bVar23.g("1", "getSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 50);
        AppleLosslessSpecificBox.ajc$tjp_5 = bVar23.h(str156, bVar23.g("1", "setSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleSize", "", "void"), 54);
        AppleLosslessSpecificBox.ajc$tjp_6 = bVar23.h(str156, bVar23.g("1", "getHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 58);
        AppleLosslessSpecificBox.ajc$tjp_7 = bVar23.h(str156, bVar23.g("1", "setHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "historyMult", "", "void"), 62);
        AppleLosslessSpecificBox.ajc$tjp_8 = bVar23.h(str156, bVar23.g("1", "getInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 66);
        AppleLosslessSpecificBox.ajc$tjp_9 = bVar23.h(str156, bVar23.g("1", "setInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "initialHistory", "", "void"), 70);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxSamplePerFrame = e.k(byteBuffer);
        this.unknown1 = e.n(byteBuffer);
        this.sampleSize = e.n(byteBuffer);
        this.historyMult = e.n(byteBuffer);
        this.initialHistory = e.n(byteBuffer);
        this.kModifier = e.n(byteBuffer);
        this.channels = e.n(byteBuffer);
        this.unknown2 = e.i(byteBuffer);
        this.maxCodedFrameSize = e.k(byteBuffer);
        this.bitRate = e.k(byteBuffer);
        this.sampleRate = e.k(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getBitRate() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_18, this, this));
        return this.bitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getChannels() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_12, this, this));
        return this.channels;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.maxSamplePerFrame);
        g.j(byteBuffer, this.unknown1);
        g.j(byteBuffer, this.sampleSize);
        g.j(byteBuffer, this.historyMult);
        g.j(byteBuffer, this.initialHistory);
        g.j(byteBuffer, this.kModifier);
        g.j(byteBuffer, this.channels);
        g.e(byteBuffer, this.unknown2);
        g.g(byteBuffer, this.maxCodedFrameSize);
        g.g(byteBuffer, this.bitRate);
        g.g(byteBuffer, this.sampleRate);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 28;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getHistoryMult() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_6, this, this));
        return this.historyMult;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getInitialHistory() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_8, this, this));
        return this.initialHistory;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getKModifier() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_10, this, this));
        return this.kModifier;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getMaxCodedFrameSize() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_16, this, this));
        return this.maxCodedFrameSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getMaxSamplePerFrame() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_0, this, this));
        return this.maxSamplePerFrame;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleRate() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_20, this, this));
        return this.sampleRate;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getSampleSize() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_4, this, this));
        return this.sampleSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getUnknown1() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_2, this, this));
        return this.unknown1;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getUnknown2() {
        d.b().c(b.c(AppleLosslessSpecificBox.ajc$tjp_14, this, this));
        return this.unknown2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setBitRate(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_19, this, this, a.e(i)));
        this.bitRate = (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setChannels(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_13, this, this, a.e(i)));
        this.channels = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHistoryMult(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_7, this, this, a.e(i)));
        this.historyMult = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInitialHistory(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_9, this, this, a.e(i)));
        this.initialHistory = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setKModifier(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_11, this, this, a.e(i)));
        this.kModifier = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMaxCodedFrameSize(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_17, this, this, a.e(i)));
        this.maxCodedFrameSize = (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMaxSamplePerFrame(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_1, this, this, a.e(i)));
        this.maxSamplePerFrame = (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleRate(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_21, this, this, a.e(i)));
        this.sampleRate = (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleSize(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_5, this, this, a.e(i)));
        this.sampleSize = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setUnknown1(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_3, this, this, a.e(i)));
        this.unknown1 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setUnknown2(int i) {
        d.b().c(b.d(AppleLosslessSpecificBox.ajc$tjp_15, this, this, a.e(i)));
        this.unknown2 = i;
    }
}
