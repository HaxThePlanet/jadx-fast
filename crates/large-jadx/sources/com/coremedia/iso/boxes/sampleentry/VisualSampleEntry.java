package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: VisualSampleEntry.java */
/* loaded from: classes.dex */
public final class VisualSampleEntry extends AbstractSampleEntry implements com.coremedia.iso.boxes.b {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE1 = "mp4v";
    public static final String TYPE2 = "s263";
    public static final String TYPE3 = "avc1";
    public static final String TYPE4 = "avc3";
    public static final String TYPE5 = "drmi";
    public static final String TYPE6 = "hvc1";
    public static final String TYPE7 = "hev1";
    public static final String TYPE_ENCRYPTED = "encv";
    private String compressorname = "";
    private int depth = 24;
    private int frameCount = 1;
    private int height;
    private double horizresolution = 72d;
    private long[] predefined;
    private double vertresolution = 72d;
    private int width;

    class a implements a {

        private final /* synthetic */ long a;
        private final /* synthetic */ a b;
        a(long j, a aVar) {
            this.a = j;
            this.b = aVar;
            super();
        }

        public void Z1(long j) {
            this.b.Z1(j);
        }

        public void close() {
            this.b.close();
        }

        public ByteBuffer f1(long j, long j2) {
            return this.b.f1(j, j2);
        }

        public int read(ByteBuffer byteBuffer) {
            long l6 = this.b.w0();
            if (this.a == l6) {
                return -1;
            }
            long l2 = (long)byteBuffer.remaining();
            long l8 = this.a - this.b.w0();
            if (this.a > this.a) {
                ByteBuffer allocate = ByteBuffer.allocate(b.a(this.a - this.b.w0()));
                this.b.read(allocate);
                byteBuffer.put((ByteBuffer)allocate.rewind());
                return allocate.capacity();
            }
            return this.b.read(byteBuffer);
        }

        public long size() {
            return this.a;
        }

        public long t(long j, long j2, WritableByteChannel writableByteChannel) {
            return this.b.t(j, j2, writableByteChannel);
        }

        public long w0() {
            return this.b.w0();
        }
    }

    public VisualSampleEntry() {
        super("avc1");
        this.predefined = new long[3];
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        int i;
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(78);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        int i4 = 0;
        g.e(allocate, i4);
        g.e(allocate, i4);
        g.g(allocate, this.predefined[i4]);
        g.g(allocate, this.predefined[1]);
        long l = this.predefined[2];
        g.g(allocate, l);
        g.e(allocate, getWidth());
        g.e(allocate, getHeight());
        g.b(allocate, getHorizresolution());
        g.b(allocate, getVertresolution());
        g.g(allocate, 0L);
        g.e(allocate, getFrameCount());
        g.j(allocate, j.c(getCompressorname()));
        allocate.put(j.b(getCompressorname()));
        i = j.c(getCompressorname());
        l = 31L;
        while (i >= 31L) {
            i = i + 1;
            allocate.put(i4);
            l = 31L;
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
        int i = 8;
        long l = 4294967296L;
        long l2 = getContainerSize() + 78L;
        if (!this.largeBox) {
            long l4 = 8L + l2;
            l = 4294967296L;
            if (this.largeBox >= l) {
                i = 16;
            } else {
                i = 8;
            }
        }
        return l2 + (long)i;
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
    public void parse(a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        int i;
        ByteBuffer allocate = ByteBuffer.allocate(78);
        aVar.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = e.i(allocate);
        e.i(allocate);
        e.i(allocate);
        this.predefined[0] = e.k(allocate);
        this.predefined[1] = e.k(allocate);
        this.predefined[2] = e.k(allocate);
        this.width = e.i(allocate);
        this.height = e.i(allocate);
        this.horizresolution = e.d(allocate);
        this.vertresolution = e.d(allocate);
        e.k(allocate);
        this.frameCount = e.i(allocate);
        i = 31;
        if (e.n(allocate) > i) {
        }
        byte[] bArr2 = new byte[i];
        allocate.get(bArr2);
        this.compressorname = j.a(bArr2);
        if (this.predefined < i) {
            i = i - i;
            allocate.get(new byte[i]);
        }
        this.depth = e.i(allocate);
        e.i(allocate);
        initContainer(new VisualSampleEntry.a(this, aVar.w0() + j, r1, aVar), j - 78L, bVar);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setCompressorname(String str) {
        this.compressorname = str;
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
    public void setType(String str) {
        this.type = str;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setVertresolution(double d) {
        this.vertresolution = d;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setWidth(int i) {
        this.width = i;
    }

    public VisualSampleEntry(String str) {
        super(str);
        this.predefined = new long[3];
    }
}
