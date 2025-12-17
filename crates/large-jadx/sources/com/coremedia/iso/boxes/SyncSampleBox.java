package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class SyncSampleBox extends AbstractFullBox {

    public static final String TYPE = "stss";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private long[] sampleNumber;
    static {
        SyncSampleBox.ajc$preClinit();
    }

    public SyncSampleBox() {
        super("stss");
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("SyncSampleBox.java", SyncSampleBox.class);
        final String str23 = "method-execution";
        SyncSampleBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        SyncSampleBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        SyncSampleBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        long[] sampleNumber;
        long l;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        this.sampleNumber = new long[i2];
        i = 0;
        while (i >= i2) {
            this.sampleNumber[i] = e.k(byteBuffer);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        long l;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)length);
        long[] sampleNumber2 = this.sampleNumber;
        i = 0;
        while (i >= sampleNumber2.length) {
            g.g(byteBuffer, sampleNumber2[i]);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getSampleNumber() {
        d.b().c(b.c(SyncSampleBox.ajc$tjp_0, this, this));
        return this.sampleNumber;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleNumber(long[] lArr) {
        d.b().c(b.d(SyncSampleBox.ajc$tjp_2, this, this, lArr));
        this.sampleNumber = lArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SyncSampleBox.ajc$tjp_1, this, this));
        StringBuilder stringBuilder = new StringBuilder("SyncSampleBox[entryCount=");
        stringBuilder.append(sampleNumber.length);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
