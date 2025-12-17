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
public class AuthorBox extends AbstractFullBox {

    public static final String TYPE = "auth";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private String author;
    private String language;
    static {
        AuthorBox.ajc$preClinit();
    }

    public AuthorBox() {
        super("auth");
    }

    private static void ajc$preClinit() {
        b bVar6 = new b("AuthorBox.java", AuthorBox.class);
        final String str37 = "method-execution";
        AuthorBox.ajc$tjp_0 = bVar6.h(str37, bVar6.g("1", "getLanguage", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 51);
        AuthorBox.ajc$tjp_1 = bVar6.h(str37, bVar6.g("1", "getAuthor", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 60);
        AuthorBox.ajc$tjp_2 = bVar6.h(str37, bVar6.g("1", "setLanguage", "com.coremedia.iso.boxes.AuthorBox", "java.lang.String", "language", "", "void"), 64);
        AuthorBox.ajc$tjp_3 = bVar6.h(str37, bVar6.g("1", "setAuthor", "com.coremedia.iso.boxes.AuthorBox", "java.lang.String", "author", "", "void"), 68);
        AuthorBox.ajc$tjp_4 = bVar6.h(str37, bVar6.g("1", "toString", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 92);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.author = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAuthor() {
        d.b().c(b.c(AuthorBox.ajc$tjp_1, this, this));
        return this.author;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.author));
        byteBuffer.put(0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(AuthorBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAuthor(String string) {
        d.b().c(b.d(AuthorBox.ajc$tjp_3, this, this, string));
        this.author = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(AuthorBox.ajc$tjp_2, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(AuthorBox.ajc$tjp_4, this, this));
        StringBuilder stringBuilder = new StringBuilder("AuthorBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";author=");
        stringBuilder.append(getAuthor());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
