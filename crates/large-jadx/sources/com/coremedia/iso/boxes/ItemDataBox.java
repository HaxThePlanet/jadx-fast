package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class ItemDataBox extends AbstractBox {

    public static final String TYPE = "idat";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    ByteBuffer data;
    static {
        ItemDataBox.ajc$preClinit();
    }

    public ItemDataBox() {
        super("idat");
        this.data = ByteBuffer.allocate(0);
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("ItemDataBox.java", ItemDataBox.class);
        final String str16 = "method-execution";
        ItemDataBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getData", "com.coremedia.iso.boxes.ItemDataBox", "", "", "", "java.nio.ByteBuffer"), 19);
        ItemDataBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setData", "com.coremedia.iso.boxes.ItemDataBox", "java.nio.ByteBuffer", "data", "", "void"), 23);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = byteBuffer.slice();
        byteBuffer.position(position += remaining);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)limit;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public ByteBuffer getData() {
        d.b().c(b.c(ItemDataBox.ajc$tjp_0, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setData(ByteBuffer byteBuffer) {
        d.b().c(b.d(ItemDataBox.ajc$tjp_1, this, this, byteBuffer));
        this.data = byteBuffer;
    }
}
