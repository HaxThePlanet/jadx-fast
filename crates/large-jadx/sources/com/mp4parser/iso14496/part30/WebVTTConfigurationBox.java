package com.mp4parser.iso14496.part30;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: WebVTTConfigurationBox.java */
/* loaded from: classes2.dex */
public class WebVTTConfigurationBox extends AbstractBox {

    public static final String TYPE = "vttC";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    String config = "";
    static {
        WebVTTConfigurationBox.ajc$preClinit();
    }

    public WebVTTConfigurationBox() {
        super("vttC");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("WebVTTConfigurationBox.java", WebVTTConfigurationBox.class);
        final String str16 = "method-execution";
        WebVTTConfigurationBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getConfig", "com.mp4parser.iso14496.part30.WebVTTConfigurationBox", "", "", "", "java.lang.String"), 36);
        WebVTTConfigurationBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setConfig", "com.mp4parser.iso14496.part30.WebVTTConfigurationBox", "java.lang.String", "config", "", "void"), 40);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.config = e.h(byteBuffer, byteBuffer.remaining());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getConfig() {
        d.b().c(b.c(WebVTTConfigurationBox.ajc$tjp_0, this, this));
        return this.config;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(j.b(this.config));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)j.c(this.config);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setConfig(String str) {
        d.b().c(b.d(WebVTTConfigurationBox.ajc$tjp_1, this, this, str));
        this.config = str;
    }
}
