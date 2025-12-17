package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class DescriptionBox extends AbstractFullBox {

    public static final String TYPE = "dscp";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private String description;
    private String language;
    static {
        DescriptionBox.ajc$preClinit();
    }

    public DescriptionBox() {
        super("dscp");
    }

    private static void ajc$preClinit() {
        b bVar6 = new b("DescriptionBox.java", DescriptionBox.class);
        final String str37 = "method-execution";
        DescriptionBox.ajc$tjp_0 = bVar6.h(str37, bVar6.g("1", "getLanguage", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 40);
        DescriptionBox.ajc$tjp_1 = bVar6.h(str37, bVar6.g("1", "getDescription", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 44);
        DescriptionBox.ajc$tjp_2 = bVar6.h(str37, bVar6.g("1", "toString", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 67);
        DescriptionBox.ajc$tjp_3 = bVar6.h(str37, bVar6.g("1", "setLanguage", "com.coremedia.iso.boxes.DescriptionBox", "java.lang.String", "language", "", "void"), 71);
        DescriptionBox.ajc$tjp_4 = bVar6.h(str37, bVar6.g("1", "setDescription", "com.coremedia.iso.boxes.DescriptionBox", "java.lang.String", "description", "", "void"), 75);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.description = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.description));
        byteBuffer.put(0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getDescription() {
        d.b().c(b.c(DescriptionBox.ajc$tjp_1, this, this));
        return this.description;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(DescriptionBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDescription(String string) {
        d.b().c(b.d(DescriptionBox.ajc$tjp_4, this, this, string));
        this.description = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(DescriptionBox.ajc$tjp_3, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(DescriptionBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("DescriptionBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";description=");
        stringBuilder.append(getDescription());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
