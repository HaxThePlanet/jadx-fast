package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.c;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: MetaBox.java */
/* loaded from: classes.dex */
public class MetaBox extends AbstractContainerBox {

    public static final String TYPE = "meta";
    private int flags;
    private boolean isFullBox = true;
    private int version;
    public MetaBox() {
        super("meta");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
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
        int i = 0;
        int i2 = 16;
        int r2 = this.isFullBox ? 4 : 0;
        long l = getContainerSize() + (this.isFullBox ? 4 : 0);
        if (!this.largeBox) {
            if (l >= 4294967296L) {
                i2 = 16;
            } else {
                i2 = 8;
            }
        }
        return l + (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(b.a(j));
        aVar.read(allocate);
        allocate.position(4);
        str = "hdlr";
        if (str.equals(e.b(allocate))) {
            this.isFullBox = false;
            initContainer(new c((ByteBuffer)allocate.rewind()), j, bVar);
        } else {
            this.isFullBox = true;
            parseVersionAndFlags((ByteBuffer)allocate.rewind());
            l = j - 4L;
            initContainer(new c(allocate), l, bVar);
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
