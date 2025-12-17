package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.c;
import com.googlecode.mp4parser.h.b;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public class MetaBox extends AbstractContainerBox {

    public static final String TYPE = "meta";
    private int flags;
    private boolean isFullBox = true;
    private int version;
    public MetaBox() {
        super("meta");
        int i = 1;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) {
        boolean isFullBox;
        writableByteChannel.write(getHeader());
        if (this.isFullBox) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            writeVersionAndFlags(allocate);
            writableByteChannel.write((ByteBuffer)allocate.rewind());
        }
        writeContainer(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getFlags() {
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long getSize() {
        int i2;
        boolean largeBox;
        int i;
        i2 = this.isFullBox ? 4 : 0;
        containerSize += i2;
        if (!this.largeBox) {
            if (Long.compare(i3, l2) >= 0) {
                i = 16;
            } else {
                i = 8;
            }
        } else {
        }
        return i3 += l;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        String str;
        c obj3;
        Object obj4;
        long obj5;
        obj4 = ByteBuffer.allocate(b.a(l3));
        a.read(obj4);
        obj4.position(4);
        if ("hdlr".equals(e.b(obj4))) {
            this.isFullBox = false;
            obj3 = new c((ByteBuffer)obj4.rewind());
            initContainer(obj3, l3, b4);
        } else {
            this.isFullBox = true;
            parseVersionAndFlags((ByteBuffer)obj4.rewind());
            obj3 = new c(obj4);
            initContainer(obj3, l3 -= str, b4);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    protected final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = e.n(byteBuffer);
        this.flags = e.j(byteBuffer);
        return 4;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void setFlags(int i) {
        this.flags = i;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void setVersion(int i) {
        this.version = i;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    protected final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        g.j(byteBuffer, this.version);
        g.f(byteBuffer, this.flags);
    }
}
