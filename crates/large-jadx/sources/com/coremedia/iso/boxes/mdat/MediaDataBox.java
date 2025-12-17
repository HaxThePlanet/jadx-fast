package com.coremedia.iso.boxes.mdat;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public final class MediaDataBox implements a {

    public static final String TYPE = "mdat";
    private a dataSource;
    private long offset;
    b parent;
    private long size;
    private static void transfer(a a, long l2, long l3, WritableByteChannel writableByteChannel4) {
        int i;
        long l;
        Object obj;
        int i2;
        long l4;
        Object obj2;
        i = 0;
        while (Long.compare(i, writableByteChannel4) >= 0) {
            i += l;
        }
    }

    @Override // com.coremedia.iso.boxes.a
    public void getBox(WritableByteChannel writableByteChannel) {
        MediaDataBox.transfer(this.dataSource, this.offset, obj2, this.size);
    }

    @Override // com.coremedia.iso.boxes.a
    public long getOffset() {
        return this.offset;
    }

    @Override // com.coremedia.iso.boxes.a
    public b getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.a
    public long getSize() {
        return this.size;
    }

    @Override // com.coremedia.iso.boxes.a
    public String getType() {
        return "mdat";
    }

    @Override // com.coremedia.iso.boxes.a
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        this.offset = l -= l5;
        this.dataSource = a;
        this.size = l2 += l3;
        a.Z1(l4 += l3);
    }

    @Override // com.coremedia.iso.boxes.a
    public void setParent(b b) {
        this.parent = b;
    }

    @Override // com.coremedia.iso.boxes.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MediaDataBox{size=");
        stringBuilder.append(this.size);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
