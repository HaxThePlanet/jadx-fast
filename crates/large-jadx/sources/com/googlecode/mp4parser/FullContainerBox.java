package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.FullBox;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class FullContainerBox extends com.googlecode.mp4parser.AbstractContainerBox implements FullBox {

    private static Logger LOG;
    private int flags;
    private int version;
    static {
        FullContainerBox.LOG = Logger.getLogger(FullContainerBox.class.getName());
    }

    public FullContainerBox(String string) {
        super(string);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) {
        super.getBox(writableByteChannel);
    }

    public <T extends com.coremedia.iso.boxes.a> List<T> getBoxes(Class<T> class) {
        return getBoxes(class, false);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getFlags() {
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    protected ByteBuffer getHeader() {
        ByteBuffer wrap;
        boolean largeBox;
        int size3;
        long size2;
        byte b;
        byte[] bytes;
        byte b2;
        byte[] bytes2;
        long size;
        long l;
        size3 = 8;
        size2 = 7;
        int i3 = 2;
        final int i4 = 6;
        int i5 = 5;
        int i6 = 0;
        final int i7 = 4;
        final int i8 = 1;
        final int i9 = 3;
        if (!this.largeBox) {
            if (Long.compare(size, l) >= 0) {
                byte[] bArr2 = new byte[20];
                bArr2[i9] = i8;
                bArr2[i7] = this.type.getBytes()[i6];
                bArr2[i5] = this.type.getBytes()[i8];
                bArr2[i4] = this.type.getBytes()[i3];
                bArr2[size2] = this.type.getBytes()[i9];
                wrap = ByteBuffer.wrap(bArr2);
                wrap.position(size3);
                g.i(wrap, getSize());
                writeVersionAndFlags(wrap);
            } else {
                byte[] bArr = new byte[12];
                bArr[i7] = this.type.getBytes()[i6];
                bArr[i5] = this.type.getBytes()[i8];
                bArr[i4] = this.type.getBytes()[i3];
                b = this.type.getBytes()[i9];
                bArr[size2] = b;
                wrap = ByteBuffer.wrap(bArr);
                g.g(wrap, getSize());
                wrap.position(size3);
                writeVersionAndFlags(wrap);
            }
        } else {
        }
        wrap.rewind();
        return wrap;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(com.googlecode.mp4parser.a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        a.read(allocate);
        parseVersionAndFlags((ByteBuffer)allocate.rewind());
        super.parse(a, byteBuffer2, l3, b4);
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
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(getClass().getSimpleName()));
        stringBuilder.append("[childBoxes]");
        return stringBuilder.toString();
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    protected final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        g.j(byteBuffer, this.version);
        g.f(byteBuffer, this.flags);
    }
}
