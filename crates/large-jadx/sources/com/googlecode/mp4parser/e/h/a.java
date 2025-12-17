package com.googlecode.mp4parser.e.h;

import com.coremedia.iso.boxes.ChunkOffsetBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SampleToChunkBox.a;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.e.e;
import com.googlecode.mp4parser.h.b;
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

/* loaded from: classes2.dex */
public class a extends AbstractList<e> {

    private static final f B;
    int A;
    b a;
    TrackBox b;
    SoftReference<ByteBuffer>[] c;
    int[] v;
    long[] w;
    long[] x;
    long[][] y;
    SampleSizeBox z;

    class a implements e {

        private int a;
        final com.googlecode.mp4parser.e.h.a b;
        public a(com.googlecode.mp4parser.e.h.a a, int i2) {
            this.b = a;
            super();
            this.a = i2;
        }

        @Override // com.googlecode.mp4parser.e.e
        public void a(WritableByteChannel writableByteChannel) {
            writableByteChannel.write(b());
        }

        @Override // com.googlecode.mp4parser.e.e
        public ByteBuffer b() {
            long[] lArr;
            Object byteBuffer;
            int softReference;
            int i2;
            long l;
            int i;
            int i3 = this.b.g(this.a);
            com.googlecode.mp4parser.e.h.a aVar2 = this.b;
            byteBuffer = aVar2.c[i3];
            i9--;
            l = (long)i3;
            lArr = aVar2.y[b.a(l)];
            synchronized (this) {
                try {
                    if ((ByteBuffer)byteBuffer.get() == null) {
                    }
                    com.googlecode.mp4parser.e.h.a aVar5 = this.b;
                    softReference = new SoftReference(aVar5.a.getByteBuffer(aVar5.w[b.a(l)], obj6));
                    aVar4.c[i3] = softReference;
                    int i7 = this.a;
                    return (ByteBuffer)(ByteBuffer)byteBuffer.duplicate().position(b.a(lArr[i12 -= softReference])).slice().limit(b.a(aVar3.z.getSampleSizeAtIndex(i7)));
                    StringWriter indexOutOfBoundsException = new StringWriter();
                    PrintWriter writer = new PrintWriter(indexOutOfBoundsException);
                    th.printStackTrace(writer);
                    writer = a.b();
                    indexOutOfBoundsException = indexOutOfBoundsException.toString();
                    writer.c(indexOutOfBoundsException);
                    Throwable th = th.getMessage();
                    indexOutOfBoundsException = new IndexOutOfBoundsException(th);
                    throw indexOutOfBoundsException;
                    throw th;
                } catch (java.io.IOException ioException) {
                } catch (Throwable th1) {
                }
            }
        }

        @Override // com.googlecode.mp4parser.e.e
        public long getSize() {
            return aVar.z.getSampleSizeAtIndex(this.a);
        }

        @Override // com.googlecode.mp4parser.e.e
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Sample(index: ");
            stringBuilder.append(this.a);
            stringBuilder.append(" size: ");
            final int i2 = this.a;
            stringBuilder.append(aVar.z.getSampleSizeAtIndex(i2));
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }
    static {
        a.B = f.a(a.class);
    }

    public a(long l, b b2) {
        int i13;
        int i10;
        int i12;
        int i14;
        int i2;
        int i15;
        Class<TrackBox> next;
        long l3;
        long sampleSizeAtIndex;
        int cmp2;
        int cmp3;
        int i;
        int cmp;
        int i4;
        int i7;
        int i8;
        int i5;
        int i11;
        int i3;
        int i9;
        long[][] arr;
        long[] sampleSizeAtIndex2;
        int i6;
        long l2;
        long l4;
        final Object obj = this;
        long l5 = l;
        b bVar = obj23;
        super();
        int i20 = 0;
        obj.b = i20;
        obj.c = i20;
        i15 = 0;
        obj.A = i15;
        obj.a = bVar;
        Iterator iterator = (MovieBox)bVar.getBoxes(MovieBox.class).get(i15).getBoxes(TrackBox.class).iterator();
        while (!iterator.hasNext()) {
            next = iterator.next();
            if (Long.compare(trackId, l5) == 0) {
            }
            obj.b = next;
        }
        TrackBox trackBox3 = obj.b;
        if (trackBox3 == null) {
        } else {
            long[] chunkOffsets = trackBox3.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
            obj.w = chunkOffsets;
            obj.x = new long[chunkOffsets.length];
            SoftReference[] arr2 = new SoftReference[chunkOffsets.length];
            obj.c = arr2;
            SoftReference softReference = new SoftReference(i20);
            Arrays.fill(arr2, softReference);
            obj.y = new long[lArr.length];
            obj.z = obj.b.getSampleTableBox().getSampleSizeBox();
            List entries = obj.b.getSampleTableBox().getSampleToChunkBox().getEntries();
            SampleToChunkBox.a[] arr3 = new SampleToChunkBox.a[entries.size()];
            Object[] objArr = array;
            Object obj2 = (SampleToChunkBox.a[])objArr[i15];
            l3 = obj2.a();
            i13 = b.a(obj2.c());
            int size2 = size();
            i = 1;
            i5 = i12;
            i3 = i7;
            i12 += i;
            i6 = -1;
            do {
                i12 += i;
                i6 = -1;
                obj.y[i12 + -1] = new long[i5];
                if (i3 += i5 <= size2) {
                }
                if (objArr.length > i7) {
                } else {
                }
                i5 = i13;
                i13 = i6;
                l3 = Long.MAX_VALUE;
                cmp3 = objArr[i7];
                i5 = i13;
                i13 = i25;
                i7 = i21;
                l3 = l2;
            } while (Long.compare(l13, l3) == 0);
            i12 += i;
            obj.v = new int[i17];
            Object obj3 = objArr[i15];
            sampleSizeAtIndex = obj3.a();
            i10 = b.a(obj3.c());
            i9 = i14;
            i11 = i8;
            sampleSizeAtIndex2 = i14 + 1;
            obj.v[i14] = i8;
            while (Long.compare(l9, sampleSizeAtIndex) == 0) {
                if (objArr.length > i11) {
                } else {
                }
                i9 = i10;
                i10 = i6;
                sampleSizeAtIndex = Long.MAX_VALUE;
                if (i18 + i9 <= size2) {
                }
                i14 = sampleSizeAtIndex2;
                i = 1;
                sampleSizeAtIndex2 = i14 + 1;
                obj.v[i14] = i8;
                cmp3 = objArr[i11];
                i9 = i10;
                i10 = cmp;
                i11 = i22;
                sampleSizeAtIndex = l4;
            }
            obj.v[sampleSizeAtIndex2] = Integer.MAX_VALUE;
            int i16 = 0;
            i2 = i16;
            i4 = 1;
            while (Long.compare(l8, sampleCount) > 0) {
                while (i4 != obj.v[i15]) {
                    i15++;
                    i2 = i16;
                }
                i15++;
                i2 = i16;
                long[] lArr4 = obj.x;
                int i23 = i15 + -1;
                arr = i4 + -1;
                lArr4[i23] = l12 += sampleSizeAtIndex2;
                obj.y[i23][i4 - i24] = i2;
                i2 += sampleSizeAtIndex;
                i4++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("This MP4 does not contain track ");
        stringBuilder.append(l5);
        RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
        throw runtimeException;
    }

    static f b() {
        return a.B;
    }

    @Override // java.util.AbstractList
    public e d(int i) {
        if (Long.compare(l, sampleCount) >= 0) {
        } else {
            a.a aVar = new a.a(this, i);
            return aVar;
        }
        IndexOutOfBoundsException obj5 = new IndexOutOfBoundsException();
        throw obj5;
    }

    @Override // java.util.AbstractList
    int g(int i) {
        int i2;
        int i6;
        int i4;
        int i5;
        int i3;
        i++;
        int[] iArr = this.v;
        i5 = this.A;
        synchronized (this) {
            if (obj4 < iArr[i5 + 1]) {
                return i5;
            }
            try {
                if (obj4 < iArr[i5]) {
                }
                this.A = 0;
                int i8 = this.A;
                while (this.v[i8 + 1] > obj4) {
                    this.A = i8++;
                    i8 = this.A;
                }
                return i8;
                this.A = i8++;
                this.A = i5++;
                int i7 = this.A;
                while (this.v[i7 + 1] > obj4) {
                    this.A = i7++;
                    i7 = this.A;
                }
                return i7;
                this.A = i7++;
                throw i;
            }
        }
    }

    @Override // java.util.AbstractList
    public Object get(int i) {
        return d(i);
    }

    @Override // java.util.AbstractList
    public int size() {
        return b.a(this.b.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }
}
