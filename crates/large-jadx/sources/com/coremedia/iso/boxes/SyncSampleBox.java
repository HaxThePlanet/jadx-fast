package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SyncSampleBox.java */
/* loaded from: classes.dex */
public class SyncSampleBox extends AbstractFullBox {

    public static final String TYPE = "stss";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private long[] sampleNumber;
    static {
        SyncSampleBox.ajc$preClinit();
    }

    public SyncSampleBox() {
        super("stss");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SyncSampleBox.java", SyncSampleBox.class);
        final String str23 = "method-execution";
        SyncSampleBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        SyncSampleBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        SyncSampleBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        this.sampleNumber = new long[i2];
        i = 0;
        while (i >= i2) {
            this.sampleNumber[i] = e.k(byteBuffer);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i = 0;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)this.sampleNumber.length);
        i = 0;
        for (long l3 : sampleNumber22) {
            g.g(byteBuffer, l3);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.sampleNumber.length * 4) + 8;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] getSampleNumber() {
        d.b().c(b.c(SyncSampleBox.ajc$tjp_0, this, this));
        return this.sampleNumber;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSampleNumber(long[] jArr) {
        d.b().c(b.d(SyncSampleBox.ajc$tjp_2, this, this, jArr));
        this.sampleNumber = jArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SyncSampleBox.ajc$tjp_1, this, this));
        String str2 = "SyncSampleBox[entryCount=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        int length = this.sampleNumber.length;
        String str3 = "]";
        str = str2 + length + str3;
        return str;
    }
}
