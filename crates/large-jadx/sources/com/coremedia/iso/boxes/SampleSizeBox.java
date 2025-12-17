package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class SampleSizeBox extends AbstractFullBox {

    public static final String TYPE = "stsz";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    int sampleCount;
    private long sampleSize;
    private long[] sampleSizes;
    static {
        SampleSizeBox.ajc$preClinit();
    }

    public SampleSizeBox() {
        super("stsz");
        this.sampleSizes = new long[0];
    }

    private static void ajc$preClinit() {
        b bVar8 = new b("SampleSizeBox.java", SampleSizeBox.class);
        final String str51 = "method-execution";
        SampleSizeBox.ajc$tjp_0 = bVar8.h(str51, bVar8.g("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        SampleSizeBox.ajc$tjp_1 = bVar8.h(str51, bVar8.g("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        SampleSizeBox.ajc$tjp_2 = bVar8.h(str51, bVar8.g("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", "index", "", "long"), 59);
        SampleSizeBox.ajc$tjp_3 = bVar8.h(str51, bVar8.g("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        SampleSizeBox.ajc$tjp_4 = bVar8.h(str51, bVar8.g("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        SampleSizeBox.ajc$tjp_5 = bVar8.h(str51, bVar8.g("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        SampleSizeBox.ajc$tjp_6 = bVar8.h(str51, bVar8.g("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        int sampleCount;
        long l;
        parseVersionAndFlags(byteBuffer);
        this.sampleSize = e.k(byteBuffer);
        i = b.a(e.k(byteBuffer));
        this.sampleCount = i;
        if (Long.compare(sampleSize, i2) == 0) {
            this.sampleSizes = new long[i];
            i = 0;
            while (i >= this.sampleCount) {
                this.sampleSizes[i] = e.k(byteBuffer);
                i++;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long sampleSizes;
        long length;
        int i;
        long l;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.sampleSize);
        if (Long.compare(sampleSize2, i) == 0) {
            g.g(byteBuffer, (long)length2);
            sampleSizes = this.sampleSizes;
            i = 0;
            while (i >= sampleSizes.length) {
                g.g(byteBuffer, sampleSizes[i]);
                i++;
            }
        } else {
            g.g(byteBuffer, (long)sampleCount);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (Long.compare(sampleSize, i3) == 0) {
            length *= 4;
        } else {
            i = 0;
        }
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleCount() {
        int sampleCount;
        d.b().c(b.c(SampleSizeBox.ajc$tjp_3, this, this));
        sampleCount = Long.compare(sampleSize, i) > 0 ? this.sampleCount : sampleSizes.length;
        return (long)sampleCount;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleSize() {
        d.b().c(b.c(SampleSizeBox.ajc$tjp_0, this, this));
        return this.sampleSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleSizeAtIndex(int i) {
        d.b().c(b.d(SampleSizeBox.ajc$tjp_2, this, this, a.e(i)));
        long sampleSize = this.sampleSize;
        if (Long.compare(sampleSize, i2) > 0) {
            return sampleSize;
        }
        return this.sampleSizes[i];
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getSampleSizes() {
        d.b().c(b.c(SampleSizeBox.ajc$tjp_4, this, this));
        return this.sampleSizes;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleSize(long l) {
        d.b().c(b.d(SampleSizeBox.ajc$tjp_1, this, this, a.f(l)));
        this.sampleSize = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleSizes(long[] lArr) {
        d.b().c(b.d(SampleSizeBox.ajc$tjp_5, this, this, lArr));
        this.sampleSizes = lArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SampleSizeBox.ajc$tjp_6, this, this));
        StringBuilder stringBuilder = new StringBuilder("SampleSizeBox[sampleSize=");
        stringBuilder.append(getSampleSize());
        stringBuilder.append(";sampleCount=");
        stringBuilder.append(getSampleCount());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
