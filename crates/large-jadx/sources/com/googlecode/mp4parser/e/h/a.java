package com.googlecode.mp4parser.e.h;

import com.coremedia.iso.boxes.ChunkOffsetBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SampleToChunkBox.a;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.e.e;
import com.googlecode.mp4parser.h.f;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultMp4SampleList.java */
/* loaded from: classes2.dex */
public class a extends AbstractList<e> {

    private static final f B;
    int A;
    com.coremedia.iso.boxes.b a;
    TrackBox b;
    SoftReference<ByteBuffer>[] c;
    int[] v;
    long[] w;
    long[] x;
    long[][] y;
    SampleSizeBox z;

    class a implements e {

        private int a;
        final /* synthetic */ a b;
        public a(int i) {
            this.b = aVar;
            super();
            this.a = i;
        }

        public void a(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(b());
        }

        public synchronized ByteBuffer b() {
            ByteBuffer byteBuffer;
            try {
                int i = this.b.g(this.a);
                SoftReference softReference = aVar2.c[i];
                int i8 = aVar2.v[i] - 1;
                l = (long)i;
                long[] lArr = aVar2.y[b.a(l)];
            } catch (java.io.IOException ioException) {
            }
            try {
                l2 = (lArr[lArr.length - 1]) + (this.b.z.getSampleSizeAtIndex((i8 + lArr.length) - 1));
                this.b.c[i] = new SoftReference(aVar5.a.getByteBuffer(aVar5.w[b.a(l)], l2));
            } catch (java.io.IOException ioException) {
            }
            try {
            } catch (java.io.IOException ioException) {
            }
            return (ByteBuffer)(ByteBuffer)byteBuffer.duplicate().position(b.a(lArr[this.a - i8])).slice().limit(b.a(this.b.z.getSampleSizeAtIndex(this.a)));
        }

        public long getSize() {
            return this.b.z.getSampleSizeAtIndex(this.a);
        }

        @Override // java.lang.Object
        public String toString() {
            String str2 = "Sample(index: ";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = " size: ";
            long sampleSizeAtIndex = this.b.z.getSampleSizeAtIndex(this.a);
            String str4 = ")";
            str = str2 + this.a + str3 + sampleSizeAtIndex + str4;
            return str;
        }
    }
    static {
        a.B = f.a(a.class);
    }

    public a(long j, com.coremedia.iso.boxes.b bVar) {
        int cmp;
        int i;
        long l;
        long sampleSizeAtIndex;
        int cmp3;
        Object obj;
        int i3 = 1;
        int i2;
        final Object j3 = this;
        long j2 = j;
        super();
        TrackBox trackBox4 = null;
        j3.b = trackBox4;
        j3.c = trackBox4;
        cmp = 0;
        j3.A = cmp;
        j3.a = bVar;
        item = TrackBox.class;
        Iterator it = (MovieBox)bVar.getBoxes(MovieBox.class).get(cmp).getBoxes(item).iterator();
        while (!it.hasNext()) {
            Class<TrackBox> item = it.next();
            long trackId = item.getTrackHeaderBox().getTrackId();
        }
        if (j3.b == null) {
            String str = "This MP4 does not contain track ";
            r1 = str + j2;
            throw new RuntimeException(r1);
        } else {
            long[] chunkOffsets = j3.b.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
            j3.w = chunkOffsets;
            j3.x = new long[chunkOffsets.length];
            SoftReference[] arr2 = new SoftReference[chunkOffsets.length];
            j3.c = arr2;
            Arrays.fill(arr2, new SoftReference(trackBox4));
            j3.y = new long[j3.w.length];
            j3.z = j3.b.getSampleTableBox().getSampleSizeBox();
            List entries = j3.b.getSampleTableBox().getSampleToChunkBox().getEntries();
            SampleToChunkBox.a[] arr3 = new SampleToChunkBox.a[entries.size()];
            Object obj2 = array[cmp];
            l = obj2.a();
            cmp = b.a(obj2.c());
            int size2 = size();
            i2 = 1;
            cmp = cmp + i2;
            long l10 = (long)cmp;
            cmp = -1;
            do {
                cmp = cmp + i2;
                l10 = (long)cmp;
                cmp = -1;
                j3.y[cmp - 1] = new long[cmp];
                i2 = i2 + cmp;
            } while (l10 == MovieBox.class);
            cmp += i2;
            j3.v = new int[i4];
            Object obj3 = array[cmp];
            sampleSizeAtIndex = obj3.a();
            cmp = b.a(obj3.c());
            lArr = cmp + 1;
            j3.v[cmp] = i2;
            long l5 = (long)lArr;
            while (l5 == MovieBox.class) {
                i2 = i2 + cmp;
            }
            j3.v[lArr] = 0x7fffffff /* Unknown resource */;
            i = 0;
            i3 = 1;
            long l4 = (long)i3;
            long sampleCount = j3.z.getSampleCount();
            while (MovieBox.class > sampleCount) {
                while (i3 != j3.v[cmp]) {
                    cmp = cmp + 1;
                }
                cmp = cmp + 1;
                int i6 = cmp - 1;
                int i8 = i3 - 1;
                j3.x[i6] = lArr5[i6] + j3.z.getSampleSizeAtIndex(i8);
                obj = i3 - j3.v[i6];
                j3.y[i6][obj] = i;
                i = i + j3.z.getSampleSizeAtIndex(i8);
                i3 = i3 + 1;
                l4 = (long)i3;
                sampleCount = j3.z.getSampleCount();
            }
            return;
        }
    }

    static /* synthetic */ f b() {
        return a.B;
    }

    @Override // java.util.AbstractList
    public e d(int i) {
        long l = (long)i;
        long sampleCount = this.z.getSampleCount();
        if (l >= sampleCount) {
            throw new IndexOutOfBoundsException();
        } else {
            return new a.a(this, i);
        }
    }

    @Override // java.util.AbstractList
    synchronized int g(int i) {
        int i6;
        i++;
        int i3 = 0;
        this.A = i3;
        i6 = i7 + 1;
        this.A++;
        while (/* condition */) {
            if (this.v[i6] > i10) {
                return i8;
            }
        }
        return i8;
    }

    @Override // java.util.AbstractList
    public int size() {
        return b.a(this.b.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }
}
