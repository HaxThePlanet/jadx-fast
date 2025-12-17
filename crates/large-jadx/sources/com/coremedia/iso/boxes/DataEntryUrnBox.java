package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class DataEntryUrnBox extends AbstractFullBox {

    public static final String TYPE = "urn ";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private String location;
    private String name;
    static {
        DataEntryUrnBox.ajc$preClinit();
    }

    public DataEntryUrnBox() {
        super("urn ");
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("DataEntryUrnBox.java", DataEntryUrnBox.class);
        final String str23 = "method-execution";
        DataEntryUrnBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getName", "com.coremedia.iso.boxes.DataEntryUrnBox", "", "", "", "java.lang.String"), 40);
        DataEntryUrnBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "getLocation", "com.coremedia.iso.boxes.DataEntryUrnBox", "", "", "", "java.lang.String"), 44);
        DataEntryUrnBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.DataEntryUrnBox", "", "", "", "java.lang.String"), 67);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.name = e.g(byteBuffer);
        this.location = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(j.b(this.name));
        int i = 0;
        byteBuffer.put(i);
        byteBuffer.put(j.b(this.location));
        byteBuffer.put(i);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLocation() {
        d.b().c(b.c(DataEntryUrnBox.ajc$tjp_1, this, this));
        return this.location;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getName() {
        d.b().c(b.c(DataEntryUrnBox.ajc$tjp_0, this, this));
        return this.name;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(DataEntryUrnBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("DataEntryUrlBox[name=");
        stringBuilder.append(getName());
        stringBuilder.append(";location=");
        stringBuilder.append(getLocation());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
