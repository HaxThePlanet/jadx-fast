package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: PerformerBox.java */
/* loaded from: classes.dex */
public class PerformerBox extends AbstractFullBox {

    public static final String TYPE = "perf";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private String language;
    private String performer;
    static {
        PerformerBox.ajc$preClinit();
    }

    public PerformerBox() {
        super("perf");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("PerformerBox.java", PerformerBox.class);
        final String str37 = "method-execution";
        PerformerBox.ajc$tjp_0 = bVar.h(str37, bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 41);
        PerformerBox.ajc$tjp_1 = bVar.h(str37, bVar.g("1", "getPerformer", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 45);
        PerformerBox.ajc$tjp_2 = bVar.h(str37, bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.PerformerBox", "java.lang.String", "language", "", "void"), 49);
        PerformerBox.ajc$tjp_3 = bVar.h(str37, bVar.g("1", "setPerformer", "com.coremedia.iso.boxes.PerformerBox", "java.lang.String", "performer", "", "void"), 53);
        PerformerBox.ajc$tjp_4 = bVar.h(str37, bVar.g("1", "toString", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 76);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.performer = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.performer));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.performer) + 6) + 1;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(PerformerBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getPerformer() {
        d.b().c(b.c(PerformerBox.ajc$tjp_1, this, this));
        return this.performer;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String str) {
        d.b().c(b.d(PerformerBox.ajc$tjp_2, this, this, str));
        this.language = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setPerformer(String str) {
        d.b().c(b.d(PerformerBox.ajc$tjp_3, this, this, str));
        this.performer = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(PerformerBox.ajc$tjp_4, this, this));
        String str2 = "PerformerBox[language=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String language = getLanguage();
        String str3 = ";performer=";
        String performer = getPerformer();
        String str4 = "]";
        str = str2 + language + str3 + performer + str4;
        return str;
    }
}
