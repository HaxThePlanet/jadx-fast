package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: DataEntryUrlBox.java */
/* loaded from: classes.dex */
public class DataEntryUrlBox extends AbstractFullBox {

    public static final String TYPE = "url ";
    private static final /* synthetic */ a.a ajc$tjp_0;
    static {
        DataEntryUrlBox.ajc$preClinit();
    }

    public DataEntryUrlBox() {
        super("url ");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("DataEntryUrlBox.java", DataEntryUrlBox.class);
        DataEntryUrlBox.ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(DataEntryUrlBox.ajc$tjp_0, this, this));
        return "DataEntryUrlBox[]";
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 4;
    }
}
