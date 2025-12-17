package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import f.b.a.b;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class AbstractContainerBox extends com.googlecode.mp4parser.BasicContainer implements a {

    protected boolean largeBox;
    private long offset;
    b parent;
    protected String type;
    public AbstractContainerBox(String string) {
        super();
        this.type = string;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void getBox(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(getHeader());
        writeContainer(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    protected ByteBuffer getHeader() {
        ByteBuffer wrap;
        boolean largeBox;
        long size;
        int i2;
        int bytes;
        int i;
        long bytes2;
        long l;
        int i4 = 8;
        final int i5 = 7;
        i2 = 2;
        final int i6 = 6;
        bytes = 5;
        i = 0;
        final int i7 = 4;
        final int i8 = 1;
        final int i9 = 3;
        if (!this.largeBox) {
            if (Long.compare(bytes2, l) >= 0) {
                byte[] bArr2 = new byte[16];
                bArr2[i9] = i8;
                bArr2[i7] = this.type.getBytes()[i];
                bArr2[bytes] = this.type.getBytes()[i8];
                bArr2[i6] = this.type.getBytes()[i2];
                bArr2[i5] = this.type.getBytes()[i9];
                wrap = ByteBuffer.wrap(bArr2);
                wrap.position(i4);
                g.i(wrap, getSize());
            } else {
                byte[] bArr = new byte[i4];
                bArr[i7] = this.type.getBytes()[i];
                bArr[bytes] = this.type.getBytes()[i8];
                bArr[i6] = this.type.getBytes()[i2];
                bArr[i5] = this.type.getBytes()[i9];
                g.g(ByteBuffer.wrap(bArr), getSize());
            }
        } else {
        }
        wrap.rewind();
        return wrap;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public long getOffset() {
        return this.offset;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public b getParent() {
        return this.parent;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public long getSize() {
        int i;
        boolean largeBox;
        long l;
        long containerSize = getContainerSize();
        if (!this.largeBox) {
            if (Long.compare(i4, l) >= 0) {
                i = 16;
            } else {
                i = 8;
            }
        } else {
        }
        return containerSize += l2;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String getType() {
        return this.type;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void initContainer(com.googlecode.mp4parser.a a, long l2, b b3) {
        int i;
        boolean largeBox;
        long l;
        this.dataSource = a;
        long l3 = a.w0();
        this.parsePosition = l3;
        if (!this.largeBox) {
            if (Long.compare(i5, l) >= 0) {
                i = 16;
            } else {
                i = 8;
            }
        } else {
        }
        this.startPosition = l3 -= l5;
        a.Z1(l4 += l2);
        this.endPosition = a.w0();
        this.boxParser = obj10;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void parse(com.googlecode.mp4parser.a a, ByteBuffer byteBuffer2, long l3, b b4) {
        int obj6;
        this.offset = l -= l2;
        obj6 = byteBuffer2.remaining() == 16 ? 1 : 0;
        this.largeBox = obj6;
        initContainer(a, l3, b4);
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void setParent(b b) {
        this.parent = b;
    }
}
