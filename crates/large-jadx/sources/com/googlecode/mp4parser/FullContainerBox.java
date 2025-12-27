package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.FullBox;
import com.coremedia.iso.boxes.a;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: FullContainerBox.java */
/* loaded from: classes2.dex */
public abstract class FullContainerBox extends AbstractContainerBox implements FullBox {

    private static Logger LOG;
    private int flags;
    private int version;
    static {
        FullContainerBox.LOG = Logger.getLogger(FullContainerBox.class.getName());
    }

    public FullContainerBox(String str) {
        super(str);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) {
        super.getBox(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public <T extends a> List<T> getBoxes(Class<T> cls) {
        return getBoxes(cls, false);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getFlags() {
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    protected ByteBuffer getHeader() throws java.io.UnsupportedEncodingException {
        ByteBuffer wrap;
        long l = 4294967296L;
        int i = 8;
        int i4 = 7;
        int i5 = 2;
        final int i6 = 6;
        int i7 = 5;
        int i8 = 0;
        final int i9 = 4;
        final int i10 = 1;
        final int i11 = 3;
        if (!this.largeBox) {
            long size2 = getSize();
            l = 4294967296L;
            if (size2 >= l) {
                byte[] bArr2 = new byte[20];
                wrap = ByteBuffer.wrap(bArr2);
                wrap.position(i);
                g.i(wrap, getSize());
                writeVersionAndFlags(wrap);
            } else {
                byte[] bArr = new byte[12];
                byte b = this.type.getBytes()[i11];
                wrap = ByteBuffer.wrap(bArr);
                g.g(wrap, getSize());
                wrap.position(i);
                writeVersionAndFlags(wrap);
            }
        }
        wrap.rewind();
        return wrap;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        aVar.read(allocate);
        parseVersionAndFlags((ByteBuffer)allocate.rewind());
        super.parse(aVar, byteBuffer, j, bVar);
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
    public String toString() {
        String str2 = String.valueOf(getClass().getSimpleName());
        String str3 = "[childBoxes]";
        str = str2 + str3;
        return str;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    protected final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        g.j(byteBuffer, this.version);
        g.f(byteBuffer, this.flags);
    }
}
