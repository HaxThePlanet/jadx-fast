package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class AlbumBox extends AbstractFullBox {

    public static final String TYPE = "albm";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private String albumTitle;
    private String language;
    private int trackNumber;
    static {
        AlbumBox.ajc$preClinit();
    }

    public AlbumBox() {
        super("albm");
    }

    private static void ajc$preClinit() {
        b bVar8 = new b("AlbumBox.java", AlbumBox.class);
        final String str51 = "method-execution";
        AlbumBox.ajc$tjp_0 = bVar8.h(str51, bVar8.g("1", "getLanguage", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 51);
        AlbumBox.ajc$tjp_1 = bVar8.h(str51, bVar8.g("1", "getAlbumTitle", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 55);
        AlbumBox.ajc$tjp_2 = bVar8.h(str51, bVar8.g("1", "getTrackNumber", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "int"), 59);
        AlbumBox.ajc$tjp_3 = bVar8.h(str51, bVar8.g("1", "setLanguage", "com.coremedia.iso.boxes.AlbumBox", "java.lang.String", "language", "", "void"), 63);
        AlbumBox.ajc$tjp_4 = bVar8.h(str51, bVar8.g("1", "setAlbumTitle", "com.coremedia.iso.boxes.AlbumBox", "java.lang.String", "albumTitle", "", "void"), 67);
        AlbumBox.ajc$tjp_5 = bVar8.h(str51, bVar8.g("1", "setTrackNumber", "com.coremedia.iso.boxes.AlbumBox", "int", "trackNumber", "", "void"), 71);
        AlbumBox.ajc$tjp_6 = bVar8.h(str51, bVar8.g("1", "toString", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 103);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int obj2;
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.albumTitle = e.g(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.trackNumber = e.n(byteBuffer);
        } else {
            this.trackNumber = -1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAlbumTitle() {
        d.b().c(b.c(AlbumBox.ajc$tjp_1, this, this));
        return this.albumTitle;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.albumTitle));
        byteBuffer.put(0);
        int trackNumber = this.trackNumber;
        if (trackNumber != -1) {
            g.j(byteBuffer, trackNumber);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (this.trackNumber == -1) {
            i = 0;
        }
        return (long)i5;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(AlbumBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getTrackNumber() {
        d.b().c(b.c(AlbumBox.ajc$tjp_2, this, this));
        return this.trackNumber;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAlbumTitle(String string) {
        d.b().c(b.d(AlbumBox.ajc$tjp_4, this, this, string));
        this.albumTitle = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(AlbumBox.ajc$tjp_3, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackNumber(int i) {
        d.b().c(b.d(AlbumBox.ajc$tjp_5, this, this, a.e(i)));
        this.trackNumber = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        int trackNumber;
        d.b().c(b.c(AlbumBox.ajc$tjp_6, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AlbumBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";");
        stringBuilder.append("albumTitle=");
        stringBuilder.append(getAlbumTitle());
        if (this.trackNumber >= 0) {
            stringBuilder.append(";trackNumber=");
            stringBuilder.append(getTrackNumber());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
