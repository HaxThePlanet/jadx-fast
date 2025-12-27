package com.coremedia.iso.boxes.vodafone;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AlbumArtistBox.java */
/* loaded from: classes.dex */
public class AlbumArtistBox extends AbstractFullBox {

    public static final String TYPE = "albr";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private String albumArtist;
    private String language;
    static {
        AlbumArtistBox.ajc$preClinit();
    }

    public AlbumArtistBox() {
        super("albr");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AlbumArtistBox.java", AlbumArtistBox.class);
        final String str37 = "method-execution";
        AlbumArtistBox.ajc$tjp_0 = bVar.h(str37, bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 42);
        AlbumArtistBox.ajc$tjp_1 = bVar.h(str37, bVar.g("1", "getAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 46);
        AlbumArtistBox.ajc$tjp_2 = bVar.h(str37, bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "java.lang.String", "language", "", "void"), 50);
        AlbumArtistBox.ajc$tjp_3 = bVar.h(str37, bVar.g("1", "setAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "java.lang.String", "albumArtist", "", "void"), 54);
        AlbumArtistBox.ajc$tjp_4 = bVar.h(str37, bVar.g("1", "toString", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 76);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.albumArtist = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAlbumArtist() {
        d.b().c(b.c(AlbumArtistBox.ajc$tjp_1, this, this));
        return this.albumArtist;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.albumArtist));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.albumArtist) + 6) + 1;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(AlbumArtistBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAlbumArtist(String str) {
        d.b().c(b.d(AlbumArtistBox.ajc$tjp_3, this, this, str));
        this.albumArtist = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String str) {
        d.b().c(b.d(AlbumArtistBox.ajc$tjp_2, this, this, str));
        this.language = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(AlbumArtistBox.ajc$tjp_4, this, this));
        String str2 = "AlbumArtistBox[language=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String language = getLanguage();
        String str3 = ";albumArtist=";
        String albumArtist = getAlbumArtist();
        String str4 = "]";
        str = str2 + language + str3 + albumArtist + str4;
        return str;
    }
}
