package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class SubtitleMediaHeaderBox extends com.coremedia.iso.boxes.AbstractMediaHeaderBox {

    public static final String TYPE = "sthd";
    private static final a.a ajc$tjp_0;
    static {
        SubtitleMediaHeaderBox.ajc$preClinit();
    }

    public SubtitleMediaHeaderBox() {
        super("sthd");
    }

    private static void ajc$preClinit() {
        b bVar2 = new b("SubtitleMediaHeaderBox.java", SubtitleMediaHeaderBox.class);
        SubtitleMediaHeaderBox.ajc$tjp_0 = bVar2.h("method-execution", bVar2.g("1", "toString", "com.coremedia.iso.boxes.SubtitleMediaHeaderBox", "", "", "", "java.lang.String"), 30);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected long getContentSize() {
        return 4;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public String toString() {
        d.b().c(b.c(SubtitleMediaHeaderBox.ajc$tjp_0, this, this));
        return "SubtitleMediaHeaderBox";
    }
}
