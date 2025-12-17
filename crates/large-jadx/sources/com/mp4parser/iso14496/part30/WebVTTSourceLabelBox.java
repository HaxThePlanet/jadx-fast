package com.mp4parser.iso14496.part30;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class WebVTTSourceLabelBox extends AbstractBox {

    public static final String TYPE = "vlab";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    String sourceLabel;
    static {
        WebVTTSourceLabelBox.ajc$preClinit();
    }

    public WebVTTSourceLabelBox() {
        super("vlab");
        this.sourceLabel = "";
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("WebVTTSourceLabelBox.java", WebVTTSourceLabelBox.class);
        final String str16 = "method-execution";
        WebVTTSourceLabelBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getSourceLabel", "com.mp4parser.iso14496.part30.WebVTTSourceLabelBox", "", "", "", "java.lang.String"), 37);
        WebVTTSourceLabelBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setSourceLabel", "com.mp4parser.iso14496.part30.WebVTTSourceLabelBox", "java.lang.String", "sourceLabel", "", "void"), 41);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.sourceLabel = e.h(byteBuffer, byteBuffer.remaining());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(j.b(this.sourceLabel));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getSourceLabel() {
        d.b().c(b.c(WebVTTSourceLabelBox.ajc$tjp_0, this, this));
        return this.sourceLabel;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setSourceLabel(String string) {
        d.b().c(b.d(WebVTTSourceLabelBox.ajc$tjp_1, this, this, string));
        this.sourceLabel = string;
    }
}
