package com.coremedia.iso.boxes.vodafone;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: LyricsUriBox.java */
/* loaded from: classes.dex */
public class LyricsUriBox extends AbstractFullBox {

    public static final String TYPE = "lrcu";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private String lyricsUri;
    static {
        LyricsUriBox.ajc$preClinit();
    }

    public LyricsUriBox() {
        super("lrcu");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("LyricsUriBox.java", LyricsUriBox.class);
        final String str23 = "method-execution";
        LyricsUriBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 39);
        LyricsUriBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "java.lang.String", "lyricsUri", "", "void"), 43);
        LyricsUriBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 64);
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
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.lyricsUri) + 5);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLyricsUri() {
        d.b().c(b.c(LyricsUriBox.ajc$tjp_0, this, this));
        return this.lyricsUri;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLyricsUri(String str) {
        d.b().c(b.d(LyricsUriBox.ajc$tjp_1, this, this, str));
        this.lyricsUri = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(LyricsUriBox.ajc$tjp_2, this, this));
        String str2 = "LyricsUriBox[lyricsUri=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String lyricsUri = getLyricsUri();
        String str3 = "]";
        str = str2 + lyricsUri + str3;
        return str;
    }
}
