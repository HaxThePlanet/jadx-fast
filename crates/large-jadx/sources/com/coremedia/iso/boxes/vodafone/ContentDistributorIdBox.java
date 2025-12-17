package com.coremedia.iso.boxes.vodafone;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class ContentDistributorIdBox extends AbstractFullBox {

    public static final String TYPE = "cdis";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private String contentDistributorId;
    private String language;
    static {
        ContentDistributorIdBox.ajc$preClinit();
    }

    public ContentDistributorIdBox() {
        super("cdis");
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("ContentDistributorIdBox.java", ContentDistributorIdBox.class);
        final String str23 = "method-execution";
        ContentDistributorIdBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 40);
        ContentDistributorIdBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "getContentDistributorId", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 44);
        ContentDistributorIdBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 68);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.contentDistributorId = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.contentDistributorId));
        byteBuffer.put(0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getContentDistributorId() {
        d.b().c(b.c(ContentDistributorIdBox.ajc$tjp_1, this, this));
        return this.contentDistributorId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i3;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(ContentDistributorIdBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(ContentDistributorIdBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("ContentDistributorIdBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";contentDistributorId=");
        stringBuilder.append(getContentDistributorId());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
