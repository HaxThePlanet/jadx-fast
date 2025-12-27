package com.coremedia.iso.boxes.apple;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AppleDataRateBox.java */
/* loaded from: classes.dex */
public class AppleDataRateBox extends AbstractFullBox {

    public static final String TYPE = "rmdr";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private long dataRate;
    static {
        AppleDataRateBox.ajc$preClinit();
    }

    public AppleDataRateBox() {
        super("rmdr");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AppleDataRateBox.java", AppleDataRateBox.class);
        AppleDataRateBox.ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getDataRate", "com.coremedia.iso.boxes.apple.AppleDataRateBox", "", "", "", "long"), 53);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.dataRate = e.k(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.dataRate);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDataRate() {
        d.b().c(b.c(AppleDataRateBox.ajc$tjp_0, this, this));
        return this.dataRate;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 8;
    }
}
