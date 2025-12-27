package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SampleSizeBox.java */
/* loaded from: classes.dex */
public class SampleSizeBox extends AbstractFullBox {

    public static final String TYPE = "stsz";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
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

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SampleSizeBox.java", SampleSizeBox.class);
        final String str51 = "method-execution";
        SampleSizeBox.ajc$tjp_0 = bVar.h(str51, bVar.g("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        SampleSizeBox.ajc$tjp_1 = bVar.h(str51, bVar.g("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        SampleSizeBox.ajc$tjp_2 = bVar.h(str51, bVar.g("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", "index", "", "long"), 59);
        SampleSizeBox.ajc$tjp_3 = bVar.h(str51, bVar.g("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        SampleSizeBox.ajc$tjp_4 = bVar.h(str51, bVar.g("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        SampleSizeBox.ajc$tjp_5 = bVar.h(str51, bVar.g("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        SampleSizeBox.ajc$tjp_6 = bVar.h(str51, bVar.g("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        long l;
        parseVersionAndFlags(byteBuffer);
        this.sampleSize = e.k(byteBuffer);
        i = b.a(e.k(byteBuffer));
        this.sampleCount = i;
        if (this.sampleSize == 0) {
            this.sampleSizes = new long[i];
            i = 0;
            while (i >= this.sampleCount) {
                this.sampleSizes[i] = e.k(byteBuffer);
                i = i + 1;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i = 0;
        ByteBuffer byteBuffer2;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.sampleSize);
        long l2 = 0L;
        if (this.sampleSize == l2) {
            g.g(byteBuffer, (long)this.sampleSizes.length);
            length = sampleSizes22.length;
            i = 0;
            for (long l5 : sampleSizes22) {
                g.g(byteBuffer, l5);
            }
        } else {
            l = (long)this.sampleCount;
            g.g(byteBuffer, l);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 0;
        if (this.sampleSize == 0) {
            i = this.sampleSizes.length * 4;
        } else {
            i = 0;
        }
        return (long)(i + 12);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleCount() {
        int length;
        d.b().c(b.c(SampleSizeBox.ajc$tjp_3, this, this));
        length = this.sampleSize > 0 ? this.sampleCount : sampleSizes2.length;
        return (long)length;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleSize() {
        d.b().c(b.c(SampleSizeBox.ajc$tjp_0, this, this));
        return this.sampleSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSampleSizeAtIndex(int i) {
        d.b().c(b.d(SampleSizeBox.ajc$tjp_2, this, this, a.e(i)));
        if (this.sampleSize > 0) {
            return this.sampleSize;
        }
        return this.sampleSizes[i];
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getSampleSizes() {
        d.b().c(b.c(SampleSizeBox.ajc$tjp_4, this, this));
        return this.sampleSizes;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleSize(long j) {
        d.b().c(b.d(SampleSizeBox.ajc$tjp_1, this, this, a.f(j)));
        this.sampleSize = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleSizes(long[] jArr) {
        d.b().c(b.d(SampleSizeBox.ajc$tjp_5, this, this, jArr));
        this.sampleSizes = jArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SampleSizeBox.ajc$tjp_6, this, this));
        String str2 = "SampleSizeBox[sampleSize=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        long sampleSize = getSampleSize();
        String str3 = ";sampleCount=";
        long sampleCount = getSampleCount();
        String str4 = "]";
        str = str2 + sampleSize + str3 + sampleCount + str4;
        return str;
    }
}
