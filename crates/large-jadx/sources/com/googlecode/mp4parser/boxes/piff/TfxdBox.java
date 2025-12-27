package com.googlecode.mp4parser.boxes.piff;

import com.google.android.exoplayer2.l2.v.r.a;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: TfxdBox.java */
/* loaded from: classes2.dex */
public class TfxdBox extends AbstractFullBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    public long fragmentAbsoluteDuration;
    public long fragmentAbsoluteTime;
    static {
        TfxdBox.ajc$preClinit();
    }

    public TfxdBox() {
        super("uuid");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TfxdBox.java", TfxdBox.class);
        final String str16 = "method-execution";
        TfxdBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getFragmentAbsoluteTime", "com.googlecode.mp4parser.boxes.piff.TfxdBox", "", "", "", "long"), 79);
        TfxdBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "getFragmentAbsoluteDuration", "com.googlecode.mp4parser.boxes.piff.TfxdBox", "", "", "", "long"), 83);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.fragmentAbsoluteTime = e.m(byteBuffer);
            this.fragmentAbsoluteDuration = e.m(byteBuffer);
        } else {
            this.fragmentAbsoluteTime = e.k(byteBuffer);
            this.fragmentAbsoluteDuration = e.k(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        final int i = 1;
        if (getVersion() == i) {
            g.i(byteBuffer, this.fragmentAbsoluteTime);
            g.i(byteBuffer, this.fragmentAbsoluteDuration);
        } else {
            g.g(byteBuffer, this.fragmentAbsoluteTime);
            g.g(byteBuffer, this.fragmentAbsoluteDuration);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 20;
        int r0 = getVersion() == 1 ? 20 : 12;
        return (getVersion() == 1 ? 20 : 12);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getFragmentAbsoluteDuration() {
        d.b().c(b.c(TfxdBox.ajc$tjp_1, this, this));
        return this.fragmentAbsoluteDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getFragmentAbsoluteTime() {
        d.b().c(b.c(TfxdBox.ajc$tjp_0, this, this));
        return this.fragmentAbsoluteTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public byte[] getUserType() {
        return new byte[] { 109, 29, -101, 5, 66, -43, 68, -26, -128, -30, 20, 29, -81, -9, 87, -78 };
    }
}
