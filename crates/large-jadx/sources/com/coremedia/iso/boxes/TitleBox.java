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
public class TitleBox extends AbstractFullBox {

    public static final String TYPE = "titl";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private String language;
    private String title;
    static {
        TitleBox.ajc$preClinit();
    }

    public TitleBox() {
        super("titl");
    }

    private static void ajc$preClinit() {
        b bVar6 = new b("TitleBox.java", TitleBox.class);
        final String str37 = "method-execution";
        TitleBox.ajc$tjp_0 = bVar6.h(str37, bVar6.g("1", "getLanguage", "com.coremedia.iso.boxes.TitleBox", "", "", "", "java.lang.String"), 46);
        TitleBox.ajc$tjp_1 = bVar6.h(str37, bVar6.g("1", "getTitle", "com.coremedia.iso.boxes.TitleBox", "", "", "", "java.lang.String"), 50);
        TitleBox.ajc$tjp_2 = bVar6.h(str37, bVar6.g("1", "setLanguage", "com.coremedia.iso.boxes.TitleBox", "java.lang.String", "language", "", "void"), 59);
        TitleBox.ajc$tjp_3 = bVar6.h(str37, bVar6.g("1", "setTitle", "com.coremedia.iso.boxes.TitleBox", "java.lang.String", "title", "", "void"), 63);
        TitleBox.ajc$tjp_4 = bVar6.h(str37, bVar6.g("1", "toString", "com.coremedia.iso.boxes.TitleBox", "", "", "", "java.lang.String"), 86);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.title = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.title));
        byteBuffer.put(0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(TitleBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getTitle() {
        d.b().c(b.c(TitleBox.ajc$tjp_1, this, this));
        return this.title;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(TitleBox.ajc$tjp_2, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTitle(String string) {
        d.b().c(b.d(TitleBox.ajc$tjp_3, this, this, string));
        this.title = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TitleBox.ajc$tjp_4, this, this));
        StringBuilder stringBuilder = new StringBuilder("TitleBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";title=");
        stringBuilder.append(getTitle());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
