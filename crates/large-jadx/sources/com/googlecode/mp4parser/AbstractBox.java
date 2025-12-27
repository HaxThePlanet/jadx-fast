package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.a;
import com.googlecode.mp4parser.h.f;
import com.googlecode.mp4parser.h.j;
import f.b.a.c;
import f.b.a.d;
import f.b.a.g;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: AbstractBox.java */
/* loaded from: classes2.dex */
public abstract class AbstractBox implements a {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static f LOG;
    private ByteBuffer content;
    a dataSource;
    private ByteBuffer deadBytes = null;
    boolean isParsed = true;
    long offset;
    private com.coremedia.iso.boxes.b parent;
    protected String type;
    private byte[] userType;
    static {
        AbstractBox.LOG = f.a(AbstractBox.class);
    }

    protected AbstractBox(String str) {
        super();
        this.type = str;
    }

    private void getHeader(ByteBuffer byteBuffer) {
        if (isSmallBox()) {
            g.g(byteBuffer, getSize());
            byteBuffer.put(d.e(getType()));
        } else {
            g.g(byteBuffer, 1L);
            byteBuffer.put(d.e(getType()));
            g.i(byteBuffer, getSize());
        }
        if ("uuid".equals(getType())) {
            byteBuffer.put(getUserType());
        }
    }

    private boolean isSmallBox() {
        int i = 8;
        int limit;
        int r0 = "uuid".equals(getType()) ? 24 : 8;
        final boolean z = true;
        final long l3 = 4294967296L;
        limit = 0;
        if (this.isParsed) {
            if (this.deadBytes != null) {
                limit = this.deadBytes.limit();
            } else {
            }
            long l5 = (getContentSize() + (long)limit) + (long)i;
            return l5 < l3 ? z : limit;
        }
        long l = (long)(this.content.limit() + i);
        return l < l3 ? z : limit;
    }

    private boolean verify(ByteBuffer byteBuffer) {
        int limit;
        int i;
        int i2;
        limit = 0;
        if (this.deadBytes != null) {
            limit = this.deadBytes.limit();
        } else {
        }
        ByteBuffer allocate = ByteBuffer.allocate(b.a(getContentSize() + (long)limit));
        getContent(allocate);
        if (this.deadBytes != null) {
            this.deadBytes.rewind();
            while (this.deadBytes.remaining() <= 0) {
                allocate.put(this.deadBytes);
            }
        }
        byteBuffer.rewind();
        allocate.rewind();
        if (byteBuffer.remaining() != allocate.remaining()) {
            String str8 = String.valueOf(getType());
            StringBuilder stringBuilder3 = new StringBuilder(str8);
            String str9 = ": remaining differs ";
            int remaining6 = byteBuffer.remaining();
            String str11 = " vs. ";
            int remaining7 = allocate.remaining();
            str6 = str8 + str9 + remaining6 + str11 + remaining7;
            System.err.print(str6);
            String str12 = String.valueOf(getType());
            StringBuilder stringBuilder4 = new StringBuilder(str12);
            int remaining8 = byteBuffer.remaining();
            int remaining9 = allocate.remaining();
            str13 = str12 + str9 + remaining8 + str11 + remaining9;
            AbstractBox.LOG.c(str13);
            return false;
        }
        int i6 = 1;
        i = byteBuffer.limit() - i6;
        i2 = allocate.limit() - i6;
        while (this.deadBytes < byteBuffer.position()) {
            byte b = byteBuffer.get(i);
            byte b2 = allocate.get(i2);
            if (b != b2) {
                int i7 = 4;
                final Object[] arr = new Object[i7];
                arr[limit] = getType();
                arr[i6] = Integer.valueOf(i);
                arr[2] = Byte.valueOf(b);
                arr[3] = Byte.valueOf(b2);
                AbstractBox.LOG.c(String.format("%s: buffers differ at %d: %2X/%2X", arr));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[allocate.remaining()];
                byteBuffer.get(bArr);
                allocate.get(bArr2);
                String str10 = "original      : ";
                String str3 = c.b(bArr, i7);
                str = str10 + str3;
                System.err.println(str);
                String str4 = "reconstructed : ";
                String str5 = c.b(bArr2, i7);
                str2 = str4 + str5;
                System.err.println(str2);
                return false;
            }
        }
        return true;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        int i = 8;
        ByteBuffer deadBytes2;
        if (this.isParsed) {
            ByteBuffer allocate = ByteBuffer.allocate(b.a(getSize()));
            getHeader(allocate);
            getContent(allocate);
            if (this.deadBytes != null) {
                this.deadBytes.rewind();
                while (this.deadBytes.remaining() <= 0) {
                    allocate.put(this.deadBytes);
                }
            }
            writableByteChannel.write((ByteBuffer)allocate.rewind());
        } else {
            i = 16;
            int r0 = isSmallBox() ? 8 : 16;
            i = 0;
            if (!("uuid".equals(this.getType()))) {
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i + i);
            getHeader(allocate2);
            writableByteChannel.write((ByteBuffer)allocate2.rewind());
            writableByteChannel.write((ByteBuffer)this.content.position(i));
        }
    }

    public long getOffset() {
        return this.offset;
    }

    public com.coremedia.iso.boxes.b getParent() {
        return this.parent;
    }

    public String getPath() {
        return j.a(this);
    }

    public long getSize() {
        int limit;
        long contentSize;
        limit = 0;
        if (this.isParsed) {
            contentSize = getContentSize();
        } else {
            if (this.content != null) {
                limit = this.content.limit();
            } else {
            }
            contentSize = (long)limit;
        }
        limit = 8;
        int r0 = limit;
        int r4 = "uuid".equals(getType()) ? 16 : limit;
        if (this.deadBytes != null) {
            limit = this.deadBytes.limit();
        }
        return (contentSize + ("uuid".equals(getType()) ? 16 : limit)) + (long)limit;
    }

    public String getType() {
        return this.type;
    }

    public byte[] getUserType() {
        return this.userType;
    }

    public boolean isParsed() {
        return this.isParsed;
    }

    public void parse(a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        this.offset = aVar.w0() - (long)byteBuffer.remaining();
        this.dataSource = aVar;
        this.content = ByteBuffer.allocate(b.a(j));
        while (this.content.remaining() <= 0) {
            aVar.read(this.content);
        }
        int i2 = 0;
        this.content.position(i2);
        this.isParsed = false;
    }

    public final synchronized void parseDetails() {
        String str2 = "parsing details of ";
        String type = getType();
        str = str2 + type;
        AbstractBox.LOG.b(str);
        this.isParsed = true;
        this.content.rewind();
        _parseDetails(this.content);
        if (this.content.remaining() > 0) {
            this.deadBytes = this.content.slice();
        }
    }

    public void setParent(com.coremedia.iso.boxes.b bVar) {
        this.parent = bVar;
    }

    protected AbstractBox(String str, byte[] bArr) {
        super();
        this.type = str;
        this.userType = bArr;
    }

    protected abstract void _parseDetails(ByteBuffer byteBuffer);

    protected abstract void getContent(ByteBuffer byteBuffer);

    protected abstract long getContentSize();
}
