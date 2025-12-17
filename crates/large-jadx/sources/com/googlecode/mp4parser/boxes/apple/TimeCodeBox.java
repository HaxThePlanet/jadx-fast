package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class TimeCodeBox extends AbstractBox implements SampleEntry, b {

    public static final String TYPE = "tmcd";
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
    private static final a.a ajc$tjp_22;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    int dataReferenceIndex;
    long flags;
    int frameDuration;
    int numberOfFrames;
    int reserved1;
    int reserved2;
    byte[] rest;
    int timeScale;
    static {
        TimeCodeBox.ajc$preClinit();
    }

    public TimeCodeBox() {
        super("tmcd");
        this.rest = new byte[0];
    }

    private static void ajc$preClinit() {
        b bVar24 = new b("TimeCodeBox.java", TimeCodeBox.class);
        final String str163 = "method-execution";
        TimeCodeBox.ajc$tjp_0 = bVar24.h(str163, bVar24.g("1", "getDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 88);
        TimeCodeBox.ajc$tjp_1 = bVar24.h(str163, bVar24.g("1", "setDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "dataReferenceIndex", "", "void"), 92);
        TimeCodeBox.ajc$tjp_10 = bVar24.h(str163, bVar24.g("1", "setReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved1", "", "void"), 137);
        TimeCodeBox.ajc$tjp_11 = bVar24.h(str163, bVar24.g("1", "getReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 141);
        TimeCodeBox.ajc$tjp_12 = bVar24.h(str163, bVar24.g("1", "setReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved2", "", "void"), 145);
        TimeCodeBox.ajc$tjp_13 = bVar24.h(str163, bVar24.g("1", "getFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "long"), 149);
        TimeCodeBox.ajc$tjp_14 = bVar24.h(str163, bVar24.g("1", "setFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long", "flags", "", "void"), 153);
        TimeCodeBox.ajc$tjp_15 = bVar24.h(str163, bVar24.g("1", "getRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "[B"), 157);
        TimeCodeBox.ajc$tjp_16 = bVar24.h(str163, bVar24.g("1", "setRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "[B", "rest", "", "void"), 161);
        TimeCodeBox.ajc$tjp_17 = bVar24.h(str163, bVar24.g("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.util.List"), 166);
        TimeCodeBox.ajc$tjp_18 = bVar24.h(str163, bVar24.g("1", "setBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.util.List", "boxes", "", "void"), 170);
        TimeCodeBox.ajc$tjp_19 = bVar24.h(str163, bVar24.g("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class", "clazz", "", "java.util.List"), 174);
        TimeCodeBox.ajc$tjp_2 = bVar24.h(str163, bVar24.g("1", "toString", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.lang.String"), 98);
        TimeCodeBox.ajc$tjp_20 = bVar24.h(str163, bVar24.g("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class:boolean", "clazz:recursive", "", "java.util.List"), 178);
        TimeCodeBox.ajc$tjp_21 = bVar24.h(str163, bVar24.g("1", "getByteBuffer", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long:long", "start:size", "java.io.IOException", "java.nio.ByteBuffer"), 182);
        TimeCodeBox.ajc$tjp_22 = bVar24.h(str163, bVar24.g("1", "writeContainer", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.nio.channels.WritableByteChannel", "bb", "java.io.IOException", "void"), 186);
        TimeCodeBox.ajc$tjp_3 = bVar24.h(str163, bVar24.g("1", "getTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 109);
        TimeCodeBox.ajc$tjp_4 = bVar24.h(str163, bVar24.g("1", "setTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "timeScale", "", "void"), 113);
        TimeCodeBox.ajc$tjp_5 = bVar24.h(str163, bVar24.g("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 117);
        TimeCodeBox.ajc$tjp_6 = bVar24.h(str163, bVar24.g("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "frameDuration", "", "void"), 121);
        TimeCodeBox.ajc$tjp_7 = bVar24.h(str163, bVar24.g("1", "getNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 125);
        TimeCodeBox.ajc$tjp_8 = bVar24.h(str163, bVar24.g("1", "setNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "numberOfFrames", "", "void"), 129);
        TimeCodeBox.ajc$tjp_9 = bVar24.h(str163, bVar24.g("1", "getReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 133);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        byteBuffer.position(6);
        this.dataReferenceIndex = e.i(byteBuffer);
        this.reserved1 = byteBuffer.getInt();
        this.flags = e.k(byteBuffer);
        this.timeScale = byteBuffer.getInt();
        this.frameDuration = byteBuffer.getInt();
        this.numberOfFrames = e.n(byteBuffer);
        this.reserved2 = e.j(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.rest = bArr;
        byteBuffer.get(bArr);
    }

    public List<a> getBoxes() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_17, this, this));
        return Collections.emptyList();
    }

    public <T extends a> List<T> getBoxes(Class<T> class) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_19, this, this, class));
        return Collections.emptyList();
    }

    public <T extends a> List<T> getBoxes(Class<T> class, boolean z2) {
        d.b().c(b.e(TimeCodeBox.ajc$tjp_20, this, this, class, a.a(z2)));
        return Collections.emptyList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public ByteBuffer getByteBuffer(long l, long l2) {
        d.b().c(b.e(TimeCodeBox.ajc$tjp_21, this, this, a.f(l), a.f(obj4)));
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[6]);
        g.e(byteBuffer, this.dataReferenceIndex);
        byteBuffer.putInt(this.reserved1);
        g.g(byteBuffer, this.flags);
        byteBuffer.putInt(this.timeScale);
        byteBuffer.putInt(this.frameDuration);
        g.j(byteBuffer, this.numberOfFrames);
        g.f(byteBuffer, this.reserved2);
        byteBuffer.put(this.rest);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDataReferenceIndex() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_0, this, this));
        return this.dataReferenceIndex;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getFlags() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_13, this, this));
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getFrameDuration() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_5, this, this));
        return this.frameDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getNumberOfFrames() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_7, this, this));
        return this.numberOfFrames;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved1() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_9, this, this));
        return this.reserved1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved2() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_11, this, this));
        return this.reserved2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getRest() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_15, this, this));
        return this.rest;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getTimeScale() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_3, this, this));
        return this.timeScale;
    }

    public void setBoxes(List<a> list) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_18, this, this, list));
        RuntimeException obj2 = new RuntimeException("Time Code Box doesn't accept any children");
        throw obj2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDataReferenceIndex(int i) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_1, this, this, a.e(i)));
        this.dataReferenceIndex = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setFlags(long l) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_14, this, this, a.f(l)));
        this.flags = l;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setFrameDuration(int i) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_6, this, this, a.e(i)));
        this.frameDuration = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setNumberOfFrames(int i) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_8, this, this, a.e(i)));
        this.numberOfFrames = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved1(int i) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_10, this, this, a.e(i)));
        this.reserved1 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved2(int i) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_12, this, this, a.e(i)));
        this.reserved2 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setRest(byte[] bArr) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_16, this, this, bArr));
        this.rest = bArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTimeScale(int i) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_4, this, this, a.e(i)));
        this.timeScale = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(TimeCodeBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("TimeCodeBox{timeScale=");
        stringBuilder.append(this.timeScale);
        stringBuilder.append(", frameDuration=");
        stringBuilder.append(this.frameDuration);
        stringBuilder.append(", numberOfFrames=");
        stringBuilder.append(this.numberOfFrames);
        stringBuilder.append(", reserved1=");
        stringBuilder.append(this.reserved1);
        stringBuilder.append(", reserved2=");
        stringBuilder.append(this.reserved2);
        stringBuilder.append(", flags=");
        stringBuilder.append(this.flags);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void writeContainer(WritableByteChannel writableByteChannel) {
        d.b().c(b.d(TimeCodeBox.ajc$tjp_22, this, this, writableByteChannel));
    }
}
