package com.coremedia.iso.boxes.apple;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class AppleDataReferenceBox extends AbstractFullBox {

    public static final String TYPE = "rdrf";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private String dataReference;
    private int dataReferenceSize;
    private String dataReferenceType;
    static {
        AppleDataReferenceBox.ajc$preClinit();
    }

    public AppleDataReferenceBox() {
        super("rdrf");
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("AppleDataReferenceBox.java", AppleDataReferenceBox.class);
        final String str23 = "method-execution";
        AppleDataReferenceBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getDataReferenceSize", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "long"), 63);
        AppleDataReferenceBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "getDataReferenceType", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 67);
        AppleDataReferenceBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "getDataReference", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 71);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.dataReferenceType = e.b(byteBuffer);
        int i = b.a(e.k(byteBuffer));
        this.dataReferenceSize = i;
        this.dataReference = e.h(byteBuffer, i);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(d.e(this.dataReferenceType));
        g.g(byteBuffer, (long)dataReferenceSize);
        byteBuffer.put(j.b(this.dataReference));
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getDataReference() {
        d.b().c(b.c(AppleDataReferenceBox.ajc$tjp_2, this, this));
        return this.dataReference;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDataReferenceSize() {
        d.b().c(b.c(AppleDataReferenceBox.ajc$tjp_0, this, this));
        return (long)dataReferenceSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getDataReferenceType() {
        d.b().c(b.c(AppleDataReferenceBox.ajc$tjp_1, this, this));
        return this.dataReferenceType;
    }
}
