package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: UnknownBox.java */
/* loaded from: classes.dex */
public class UnknownBox extends AbstractBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    ByteBuffer data;
    static {
        UnknownBox.ajc$preClinit();
    }

    public UnknownBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("UnknownBox.java", UnknownBox.class);
        final String str23 = "method-execution";
        UnknownBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getData", "com.coremedia.iso.boxes.UnknownBox", "", "", "", "java.nio.ByteBuffer"), 52);
        UnknownBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setData", "com.coremedia.iso.boxes.UnknownBox", "java.nio.ByteBuffer", "data", "", "void"), 56);
        UnknownBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.UnknownBox", "", "", "", "java.lang.String"), 61);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)this.data.limit();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public ByteBuffer getData() {
        d.b().c(b.c(UnknownBox.ajc$tjp_0, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setData(ByteBuffer byteBuffer) {
        d.b().c(b.d(UnknownBox.ajc$tjp_1, this, this, byteBuffer));
        this.data = byteBuffer;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(UnknownBox.ajc$tjp_2, this, this));
        String str2 = String.valueOf(getClass().getName());
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = "[";
        String type = getType();
        String str4 = "]@";
        String str5 = Integer.toHexString(hashCode());
        str = str2 + str3 + type + str4 + str5;
        return str;
    }
}
