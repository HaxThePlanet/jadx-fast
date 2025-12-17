package com.mp4parser.streaming;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public abstract class WriteOnlyBox implements a {

    private b parent;
    private final String type;
    public WriteOnlyBox(String string) {
        super();
        this.type = string;
    }

    @Override // com.coremedia.iso.boxes.a
    public abstract void getBox(WritableByteChannel writableByteChannel);

    @Override // com.coremedia.iso.boxes.a
    public long getOffset() {
        RuntimeException runtimeException = new RuntimeException("It's a´write only box");
        throw runtimeException;
    }

    @Override // com.coremedia.iso.boxes.a
    public b getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.a
    public abstract long getSize();

    @Override // com.coremedia.iso.boxes.a
    public String getType() {
        return this.type;
    }

    @Override // com.coremedia.iso.boxes.a
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        RuntimeException obj1 = new RuntimeException("It's a´write only box");
        throw obj1;
    }

    @Override // com.coremedia.iso.boxes.a
    public void setParent(b b) {
        this.parent = b;
    }
}
