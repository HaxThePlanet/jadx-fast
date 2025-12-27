package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: GenreBox.java */
/* loaded from: classes.dex */
public class GenreBox extends AbstractFullBox {

    public static final String TYPE = "gnre";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private String genre;
    private String language;
    static {
        GenreBox.ajc$preClinit();
    }

    public GenreBox() {
        super("gnre");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("GenreBox.java", GenreBox.class);
        final String str37 = "method-execution";
        GenreBox.ajc$tjp_0 = bVar.h(str37, bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.GenreBox", "", "", "", "java.lang.String"), 42);
        GenreBox.ajc$tjp_1 = bVar.h(str37, bVar.g("1", "getGenre", "com.coremedia.iso.boxes.GenreBox", "", "", "", "java.lang.String"), 46);
        GenreBox.ajc$tjp_2 = bVar.h(str37, bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.GenreBox", "java.lang.String", "language", "", "void"), 50);
        GenreBox.ajc$tjp_3 = bVar.h(str37, bVar.g("1", "setGenre", "com.coremedia.iso.boxes.GenreBox", "java.lang.String", "genre", "", "void"), 54);
        GenreBox.ajc$tjp_4 = bVar.h(str37, bVar.g("1", "toString", "com.coremedia.iso.boxes.GenreBox", "", "", "", "java.lang.String"), 77);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.genre = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.genre));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.genre) + 7);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getGenre() {
        d.b().c(b.c(GenreBox.ajc$tjp_1, this, this));
        return this.genre;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(GenreBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGenre(String str) {
        d.b().c(b.d(GenreBox.ajc$tjp_3, this, this, str));
        this.genre = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String str) {
        d.b().c(b.d(GenreBox.ajc$tjp_2, this, this, str));
        this.language = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(GenreBox.ajc$tjp_4, this, this));
        String str2 = "GenreBox[language=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String language = getLanguage();
        String str3 = ";genre=";
        String genre = getGenre();
        String str4 = "]";
        str = str2 + language + str3 + genre + str4;
        return str;
    }
}
