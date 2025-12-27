package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.a;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: AbstractContainerBox.java */
/* loaded from: classes2.dex */
public class AbstractContainerBox extends BasicContainer implements a {

    protected boolean largeBox;
    private long offset;
    com.coremedia.iso.boxes.b parent;
    protected String type;
    public AbstractContainerBox(String str) {
        super();
        this.type = str;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        writableByteChannel.write(getHeader());
        writeContainer(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    protected ByteBuffer getHeader() throws java.io.UnsupportedEncodingException {
        ByteBuffer wrap;
        long l = 4294967296L;
        int i5 = 8;
        final int i6 = 7;
        int i = 2;
        final int i7 = 6;
        int i2 = 5;
        int i3 = 0;
        final int i8 = 4;
        final int i9 = 1;
        final int i10 = 3;
        if (!this.largeBox) {
            long size2 = getSize();
            l = 4294967296L;
            if (size2 >= l) {
                byte[] bArr2 = new byte[16];
                wrap = ByteBuffer.wrap(bArr2);
                wrap.position(i5);
                g.i(wrap, getSize());
            } else {
                byte[] bArr = new byte[i5];
                g.g(ByteBuffer.wrap(bArr), getSize());
            }
        }
        wrap.rewind();
        return wrap;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public long getOffset() {
        return this.offset;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public com.coremedia.iso.boxes.b getParent() {
        return this.parent;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public long getSize() {
        int i = 8;
        long l = 4294967296L;
        long containerSize = getContainerSize();
        if (!this.largeBox) {
            long l3 = 8L + containerSize;
            l = 4294967296L;
            if (this.largeBox >= l) {
                i = 16;
            } else {
                i = 8;
            }
        }
        return containerSize + (long)i;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String getType() {
        return this.type;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void initContainer(a aVar, long j, f.b.a.b bVar) {
        int i = 8;
        long l = 4294967296L;
        this.dataSource = aVar;
        long l2 = aVar.w0();
        this.parsePosition = l2;
        if (!this.largeBox) {
            long l6 = 8L + j;
            l = 4294967296L;
            if (this.largeBox >= l) {
                i = 16;
            } else {
                i = 8;
            }
        }
        this.startPosition = l2 - (long)i;
        aVar.Z1(aVar.w0() + j);
        this.endPosition = aVar.w0();
        this.boxParser = bVar;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void parse(a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        int i = 1;
        this.offset = aVar.w0() - (long)byteBuffer.remaining();
        byteBuffer = byteBuffer.remaining() == 16 ? 1 : 0;
        this.largeBox = (byteBuffer.remaining() == 16 ? 1 : 0);
        initContainer(aVar, j, bVar);
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void setParent(com.coremedia.iso.boxes.b bVar) {
        this.parent = bVar;
    }
}
