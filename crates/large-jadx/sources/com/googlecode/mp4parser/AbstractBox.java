package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.h.b;
import com.googlecode.mp4parser.h.f;
import com.googlecode.mp4parser.h.j;
import f.b.a.b;
import f.b.a.c;
import f.b.a.d;
import f.b.a.g;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public abstract class AbstractBox implements a {

    static final boolean $assertionsDisabled;
    private static f LOG;
    private ByteBuffer content;
    com.googlecode.mp4parser.a dataSource;
    private ByteBuffer deadBytes = null;
    boolean isParsed = true;
    long offset;
    private b parent;
    protected String type;
    private byte[] userType;
    static {
        AbstractBox.LOG = f.a(AbstractBox.class);
    }

    protected AbstractBox(String string) {
        super();
        final int i = 0;
        this.type = string;
        final int obj2 = 1;
    }

    protected AbstractBox(String string, byte[] b2Arr2) {
        super();
        final int i = 0;
        this.type = string;
        this.userType = b2Arr2;
        final int obj2 = 1;
    }

    private void getHeader(ByteBuffer byteBuffer) {
        byte[] size;
        boolean userType;
        if (isSmallBox()) {
            g.g(byteBuffer, getSize());
            byteBuffer.put(d.e(getType()));
        } else {
            g.g(byteBuffer, 1);
            byteBuffer.put(d.e(getType()));
            g.i(byteBuffer, getSize());
        }
        if ("uuid".equals(getType())) {
            byteBuffer.put(getUserType());
        }
    }

    private boolean isSmallBox() {
        int i;
        int limit;
        i = "uuid".equals(getType()) ? 24 : 8;
        final int i3 = 1;
        final long l3 = 4294967296L;
        final int i4 = 0;
        if (this.isParsed) {
            ByteBuffer deadBytes = this.deadBytes;
            if (deadBytes != null) {
                limit = deadBytes.limit();
            } else {
                limit = i4;
            }
            if (Long.compare(i6, l3) < 0) {
                return i3;
            }
            return i4;
        }
        if (Long.compare(l, l3) < 0) {
            return i3;
        }
        return i4;
    }

    private boolean verify(ByteBuffer byteBuffer) {
        ByteBuffer deadBytes;
        int limit;
        int i;
        int i2;
        byte b;
        byte b2;
        ByteBuffer deadBytes3 = this.deadBytes;
        final int i7 = 0;
        if (deadBytes3 != null) {
            limit = deadBytes3.limit();
        } else {
            limit = i7;
        }
        ByteBuffer allocate = ByteBuffer.allocate(b.a(contentSize += l));
        getContent(allocate);
        deadBytes = this.deadBytes;
        if (deadBytes != null) {
            deadBytes.rewind();
            while (this.deadBytes.remaining() <= 0) {
                allocate.put(this.deadBytes);
            }
        }
        byteBuffer.rewind();
        allocate.rewind();
        if (byteBuffer.remaining() != allocate.remaining()) {
            StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(getType()));
            String str5 = ": remaining differs ";
            stringBuilder3.append(str5);
            stringBuilder3.append(byteBuffer.remaining());
            String str7 = " vs. ";
            stringBuilder3.append(str7);
            stringBuilder3.append(allocate.remaining());
            System.err.print(stringBuilder3.toString());
            StringBuilder stringBuilder4 = new StringBuilder(String.valueOf(getType()));
            stringBuilder4.append(str5);
            stringBuilder4.append(byteBuffer.remaining());
            stringBuilder4.append(str7);
            stringBuilder4.append(allocate.remaining());
            AbstractBox.LOG.c(stringBuilder4.toString());
            return i7;
        }
        int i8 = 1;
        limit2 -= i8;
        limit3 -= i8;
        while (i < byteBuffer.position()) {
            b = byteBuffer.get(i);
            b2 = allocate.get(i2);
            i--;
            i2--;
        }
        return i8;
    }

    @Override // com.coremedia.iso.boxes.a
    protected abstract void _parseDetails(ByteBuffer byteBuffer);

    @Override // com.coremedia.iso.boxes.a
    public void getBox(WritableByteChannel writableByteChannel) {
        java.nio.Buffer position;
        int i2;
        ByteBuffer deadBytes;
        boolean equals;
        int i;
        if (this.isParsed) {
            ByteBuffer allocate = ByteBuffer.allocate(b.a(getSize()));
            getHeader(allocate);
            getContent(allocate);
            deadBytes = this.deadBytes;
            if (deadBytes != null) {
                deadBytes.rewind();
                while (this.deadBytes.remaining() <= 0) {
                    allocate.put(this.deadBytes);
                }
            }
            writableByteChannel.write((ByteBuffer)allocate.rewind());
        } else {
            i2 = isSmallBox() ? 8 : deadBytes;
            i = 0;
            if ("uuid".equals(getType())) {
            } else {
                deadBytes = i;
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i2 += deadBytes);
            getHeader(allocate2);
            writableByteChannel.write((ByteBuffer)allocate2.rewind());
            writableByteChannel.write((ByteBuffer)this.content.position(i));
        }
    }

    @Override // com.coremedia.iso.boxes.a
    protected abstract void getContent(ByteBuffer byteBuffer);

    @Override // com.coremedia.iso.boxes.a
    protected abstract long getContentSize();

    @Override // com.coremedia.iso.boxes.a
    public long getOffset() {
        return this.offset;
    }

    @Override // com.coremedia.iso.boxes.a
    public b getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.a
    public String getPath() {
        return j.a(this);
    }

    @Override // com.coremedia.iso.boxes.a
    public long getSize() {
        boolean isParsed;
        int i;
        int limit;
        long contentSize;
        int i2;
        limit = 0;
        if (this.isParsed) {
            contentSize = getContentSize();
        } else {
            ByteBuffer content = this.content;
            if (content != null) {
                isParsed = content.limit();
            } else {
                isParsed = limit;
            }
            contentSize = (long)isParsed;
        }
        int i7 = 8;
        i = Long.compare(contentSize, l2) >= 0 ? i7 : limit;
        i2 = "uuid".equals(getType()) ? 16 : limit;
        ByteBuffer deadBytes = this.deadBytes;
        if (deadBytes == null) {
        } else {
            limit = deadBytes.limit();
        }
        return i5 += l;
    }

    @Override // com.coremedia.iso.boxes.a
    public String getType() {
        return this.type;
    }

    @Override // com.coremedia.iso.boxes.a
    public byte[] getUserType() {
        return this.userType;
    }

    @Override // com.coremedia.iso.boxes.a
    public boolean isParsed() {
        return this.isParsed;
    }

    @Override // com.coremedia.iso.boxes.a
    public void parse(com.googlecode.mp4parser.a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer obj6;
        this.offset = l -= l2;
        this.dataSource = a;
        this.content = ByteBuffer.allocate(b.a(l3));
        while (this.content.remaining() <= 0) {
            a.read(this.content);
        }
        obj6 = 0;
        this.content.position(obj6);
        this.isParsed = obj6;
    }

    @Override // com.coremedia.iso.boxes.a
    public final void parseDetails() {
        ByteBuffer content;
        String remaining;
        StringBuilder stringBuilder = new StringBuilder("parsing details of ");
        stringBuilder.append(getType());
        AbstractBox.LOG.b(stringBuilder.toString());
        content = this.content;
        synchronized (this) {
            try {
                this.isParsed = true;
                content.rewind();
                _parseDetails(content);
                if (content.remaining() > 0) {
                }
                this.deadBytes = content.slice();
                this.content = 0;
                throw th;
            }
        }
    }

    @Override // com.coremedia.iso.boxes.a
    public void setParent(b b) {
        this.parent = b;
    }
}
