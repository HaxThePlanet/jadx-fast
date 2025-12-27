package com.coremedia.iso.boxes.mdat;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: MediaDataBox.java */
/* loaded from: classes.dex */
public final class MediaDataBox implements com.coremedia.iso.boxes.a {

    public static final String TYPE = "mdat";
    private com.googlecode.mp4parser.a dataSource;
    private long offset;
    com.coremedia.iso.boxes.b parent;
    private long size;
    private static void transfer(com.googlecode.mp4parser.a aVar, long j, long j2, WritableByteChannel writableByteChannel) {
        int i = 0;
        Object obj;
        i = 0;
        while (i >= j2) {
            l2 = j + i;
            i = i + (aVar.t(l2, Math.min(67076096L, j2 - i), writableByteChannel));
        }
    }

    public void getBox(WritableByteChannel writableByteChannel) {
        MediaDataBox.transfer(this.dataSource, this.offset, this.size, writableByteChannel);
    }

    public long getOffset() {
        return this.offset;
    }

    public com.coremedia.iso.boxes.b getParent() {
        return this.parent;
    }

    public long getSize() {
        return this.size;
    }

    public void parse(com.googlecode.mp4parser.a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        this.offset = aVar.w0() - (long)byteBuffer.remaining();
        this.dataSource = aVar;
        this.size = (long)byteBuffer.remaining() + j;
        aVar.Z1(aVar.w0() + j);
    }

    public void setParent(com.coremedia.iso.boxes.b bVar) {
        this.parent = bVar;
    }

    @Override // java.lang.Object
    public String toString() {
        String str2 = "MediaDataBox{size=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        str = str2 + this.size + 125;
        return str;
    }

    public String getType() {
        return "mdat";
    }
}
