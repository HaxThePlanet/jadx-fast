package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.b;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public final class VisualSampleEntry extends com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry implements b {

    static final boolean $assertionsDisabled = false;
    public static final String TYPE1 = "mp4v";
    public static final String TYPE2 = "s263";
    public static final String TYPE3 = "avc1";
    public static final String TYPE4 = "avc3";
    public static final String TYPE5 = "drmi";
    public static final String TYPE6 = "hvc1";
    public static final String TYPE7 = "hev1";
    public static final String TYPE_ENCRYPTED = "encv";
    private String compressorname;
    private int depth = 24;
    private int frameCount = 1;
    private int height;
    private double horizresolution = 72d;
    private long[] predefined;
    private double vertresolution = 72d;
    private int width;

    class a implements a {

        private final long a;
        private final a b;
        a(com.coremedia.iso.boxes.sampleentry.VisualSampleEntry visualSampleEntry, long l2, a a3) {
            this.a = l2;
            this.b = obj4;
            super();
        }

        @Override // com.googlecode.mp4parser.a
        public void Z1(long l) {
            this.b.Z1(l);
        }

        @Override // com.googlecode.mp4parser.a
        public void close() {
            this.b.close();
        }

        @Override // com.googlecode.mp4parser.a
        public ByteBuffer f1(long l, long l2) {
            return this.b.f1(l, l2);
        }

        @Override // com.googlecode.mp4parser.a
        public int read(ByteBuffer byteBuffer) {
            if (Long.compare(l, l4) == 0) {
                return -1;
            }
            if (Long.compare(l2, i3) > 0) {
                ByteBuffer allocate = ByteBuffer.allocate(b.a(l3 -= l6));
                this.b.read(allocate);
                byteBuffer.put((ByteBuffer)allocate.rewind());
                return allocate.capacity();
            }
            return this.b.read(byteBuffer);
        }

        @Override // com.googlecode.mp4parser.a
        public long size() {
            return this.a;
        }

        @Override // com.googlecode.mp4parser.a
        public long t(long l, long l2, WritableByteChannel writableByteChannel3) {
            return this.b.t(l, obj2, writableByteChannel3);
        }

        @Override // com.googlecode.mp4parser.a
        public long w0() {
            return this.b.w0();
        }
    }
    static {
        final Class<com.coremedia.iso.boxes.sampleentry.VisualSampleEntry> obj = VisualSampleEntry.class;
    }

    public VisualSampleEntry() {
        super("avc1");
        long l = 4634766966517661696L;
        int i = 1;
        this.compressorname = "";
        int i2 = 24;
        this.predefined = new long[3];
    }

    public VisualSampleEntry(String string) {
        super(string);
        final long l = 4634766966517661696L;
        int obj3 = 1;
        this.compressorname = "";
        obj3 = 24;
        this.predefined = new long[3];
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
        int i;
        long l;
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(78);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        int i4 = 0;
        g.e(allocate, i4);
        g.e(allocate, i4);
        g.g(allocate, this.predefined[i4]);
        g.g(allocate, this.predefined[1]);
        l = this.predefined[2];
        g.g(allocate, l);
        g.e(allocate, getWidth());
        g.e(allocate, getHeight());
        g.b(allocate, getHorizresolution());
        g.b(allocate, getVertresolution());
        g.g(allocate, 0);
        g.e(allocate, getFrameCount());
        g.j(allocate, j.c(getCompressorname()));
        allocate.put(j.b(getCompressorname()));
        i = j.c(getCompressorname());
        while (i >= 31L) {
            i++;
            allocate.put(i4);
        }
        g.e(allocate, getDepth());
        g.e(allocate, 65535);
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String getCompressorname() {
        return this.compressorname;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getDepth() {
        return this.depth;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getFrameCount() {
        return this.frameCount;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getHeight() {
        return this.height;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public double getHorizresolution() {
        return this.horizresolution;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int i;
        boolean largeBox;
        long l;
        containerSize += i4;
        if (!this.largeBox) {
            if (Long.compare(i6, l) >= 0) {
                i = 16;
            } else {
                i = 8;
            }
        } else {
        }
        return i2 += l2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public double getVertresolution() {
        return this.vertresolution;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getWidth() {
        return this.width;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        int bArr;
        int i;
        ByteBuffer obj8 = ByteBuffer.allocate(78);
        a.read(obj8);
        obj8.position(6);
        this.dataReferenceIndex = e.i(obj8);
        e.i(obj8);
        e.i(obj8);
        this.predefined[0] = e.k(obj8);
        this.predefined[1] = e.k(obj8);
        this.predefined[2] = e.k(obj8);
        this.width = e.i(obj8);
        this.height = e.i(obj8);
        this.horizresolution = e.d(obj8);
        this.vertresolution = e.d(obj8);
        e.k(obj8);
        this.frameCount = e.i(obj8);
        i = 31;
        if (e.n(obj8) > i) {
            bArr = i;
        }
        byte[] bArr2 = new byte[bArr];
        obj8.get(bArr2);
        this.compressorname = j.a(bArr2);
        if (bArr < i) {
            obj8.get(new byte[i -= bArr]);
        }
        this.depth = e.i(obj8);
        e.i(obj8);
        obj8 = new VisualSampleEntry.a(this, l += l3, obj1, a);
        initContainer(obj8, l3 -= i3, b4);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setCompressorname(String string) {
        this.compressorname = string;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setDepth(int i) {
        this.depth = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setFrameCount(int i) {
        this.frameCount = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setHorizresolution(double d) {
        this.horizresolution = d;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setType(String string) {
        this.type = string;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setVertresolution(double d) {
        this.vertresolution = d;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setWidth(int i) {
        this.width = i;
    }
}
