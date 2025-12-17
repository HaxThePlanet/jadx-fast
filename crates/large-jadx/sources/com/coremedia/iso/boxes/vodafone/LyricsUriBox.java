package com.coremedia.iso.boxes.vodafone;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class LyricsUriBox extends AbstractFullBox {

    public static final String TYPE = "lrcu";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private String lyricsUri;
    static {
        LyricsUriBox.ajc$preClinit();
    }

    public LyricsUriBox() {
        super("lrcu");
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("LyricsUriBox.java", LyricsUriBox.class);
        final String str23 = "method-execution";
        LyricsUriBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 39);
        LyricsUriBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "java.lang.String", "lyricsUri", "", "void"), 43);
        LyricsUriBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 64);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.lyricsUri = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(j.b(this.lyricsUri));
        byteBuffer.put(0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLyricsUri() {
        d.b().c(b.c(LyricsUriBox.ajc$tjp_0, this, this));
        return this.lyricsUri;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLyricsUri(String string) {
        d.b().c(b.d(LyricsUriBox.ajc$tjp_1, this, this, string));
        this.lyricsUri = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(LyricsUriBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("LyricsUriBox[lyricsUri=");
        stringBuilder.append(getLyricsUri());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
