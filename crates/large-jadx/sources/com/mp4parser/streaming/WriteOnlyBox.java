package com.mp4parser.streaming;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: WriteOnlyBox.java */
/* loaded from: classes2.dex */
public abstract class WriteOnlyBox implements com.coremedia.iso.boxes.a {

    private com.coremedia.iso.boxes.b parent;
    private final String type;
    public WriteOnlyBox(String str) {
        super();
        this.type = str;
    }

    public long getOffset() {
        throw new RuntimeException("It's a´write only box");
    }

    public com.coremedia.iso.boxes.b getParent() {
        return this.parent;
    }

    public String getType() {
        return this.type;
    }

    public void parse(com.googlecode.mp4parser.a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        throw new RuntimeException("It's a´write only box");
    }

    public void setParent(com.coremedia.iso.boxes.b bVar) {
        this.parent = bVar;
    }

    public abstract /* synthetic */ void getBox(WritableByteChannel writableByteChannel);

    public abstract /* synthetic */ long getSize();
}
