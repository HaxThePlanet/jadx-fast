package com.coremedia.iso.boxes.vodafone;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: CoverUriBox.java */
/* loaded from: classes.dex */
public class CoverUriBox extends AbstractFullBox {

    public static final String TYPE = "cvru";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private String coverUri;
    static {
        CoverUriBox.ajc$preClinit();
    }

    public CoverUriBox() {
        super("cvru");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("CoverUriBox.java", CoverUriBox.class);
        final String str23 = "method-execution";
        CoverUriBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getCoverUri", "com.coremedia.iso.boxes.vodafone.CoverUriBox", "", "", "", "java.lang.String"), 38);
        CoverUriBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setCoverUri", "com.coremedia.iso.boxes.vodafone.CoverUriBox", "java.lang.String", "coverUri", "", "void"), 42);
        CoverUriBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.vodafone.CoverUriBox", "", "", "", "java.lang.String"), 64);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.coverUri = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(j.b(this.coverUri));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.coverUri) + 5);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getCoverUri() {
        d.b().c(b.c(CoverUriBox.ajc$tjp_0, this, this));
        return this.coverUri;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCoverUri(String str) {
        d.b().c(b.d(CoverUriBox.ajc$tjp_1, this, this, str));
        this.coverUri = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(CoverUriBox.ajc$tjp_2, this, this));
        String str2 = "CoverUriBox[coverUri=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String coverUri = getCoverUri();
        String str3 = "]";
        str = str2 + coverUri + str3;
        return str;
    }
}
