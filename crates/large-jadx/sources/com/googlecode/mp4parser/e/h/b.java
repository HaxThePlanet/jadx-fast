package com.googlecode.mp4parser.e.h;

import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.b;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox.a;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.e.e;
import com.googlecode.mp4parser.h.b;
import com.googlecode.mp4parser.h.j;
import f.b.a.d;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class b extends AbstractList<e> {

    private int A = -1;
    b a;
    d[] b;
    TrackBox c = null;
    TrackExtendsBox v = null;
    private SoftReference<e>[] w;
    private List<TrackFragmentBox> x;
    private Map<TrackRunBox, SoftReference<ByteBuffer>> y;
    private int[] z;

    class a implements e {

        private final long a;
        private final ByteBuffer b;
        private final int c;
        a(com.googlecode.mp4parser.e.h.b b, long l2, ByteBuffer byteBuffer3, int i4) {
            this.a = l2;
            this.b = i4;
            this.c = obj5;
            super();
        }

        @Override // com.googlecode.mp4parser.e.e
        public void a(WritableByteChannel writableByteChannel) {
            writableByteChannel.write(b());
        }

        @Override // com.googlecode.mp4parser.e.e
        public ByteBuffer b() {
            return (ByteBuffer)(ByteBuffer)this.b.position(this.c).slice().limit(b.a(this.a));
        }

        @Override // com.googlecode.mp4parser.e.e
        public long getSize() {
            return this.a;
        }
    }
    public b(long l, b b2, d... d3Arr3) {
        int next;
        boolean trackId;
        int cmp;
        long trackId2;
        List obj5;
        int obj6;
        super();
        int i = 0;
        HashMap hashMap = new HashMap();
        this.y = hashMap;
        next = -1;
        this.a = d3Arr3;
        this.b = obj8;
        Iterator obj8 = j.f(d3Arr3, "moov[0]/trak").iterator();
        while (!obj8.hasNext()) {
            next = obj8.next();
            if (Long.compare(trackId3, l) == 0) {
            }
            this.c = next;
        }
        if (this.c == null) {
        } else {
            Iterator obj7 = j.f(d3Arr3, "moov[0]/mvex[0]/trex").iterator();
            while (!obj7.hasNext()) {
                obj5 = obj7.next();
                if (Long.compare(trackId, trackId2) == 0) {
                }
                this.v = obj5;
            }
            this.w = (SoftReference[])Array.newInstance(SoftReference.class, size());
            g();
        }
        obj8 = new StringBuilder("This MP4 does not contain track ");
        obj8.append(l);
        obj7 = new RuntimeException(obj8.toString());
        throw obj7;
    }

    private int d(TrackFragmentBox trackFragmentBox) {
        int i;
        int i2;
        Object obj;
        boolean z;
        final List obj5 = trackFragmentBox.getBoxes();
        i2 = i;
        while (i >= obj5.size()) {
            obj = obj5.get(i);
            z = obj instanceof TrackRunBox;
            if (z) {
            }
            i++;
            i2 += obj;
        }
        return i2;
    }

    private List<TrackFragmentBox> g() {
        int i;
        Class<com.coremedia.iso.boxes.fragment.MovieFragmentBox> iterator;
        int i2;
        boolean length;
        Class<TrackFragmentBox> next;
        int cmp2;
        Iterator iterator2;
        long trackId;
        Class<com.coremedia.iso.boxes.fragment.MovieFragmentBox> iterator3;
        boolean next2;
        Class<TrackFragmentBox> next3;
        int cmp;
        long trackId2;
        List list = this.x;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator4 = this.a.getBoxes(MovieFragmentBox.class).iterator();
        for (MovieFragmentBox next5 : iterator4) {
            iterator = next5.getBoxes(TrackFragmentBox.class).iterator();
            while (!iterator.hasNext()) {
                next = iterator.next();
                if (Long.compare(trackId3, trackId) == 0) {
                }
                arrayList.add(next);
            }
            next = iterator.next();
            if (Long.compare(trackId3, trackId) == 0) {
            }
            arrayList.add(next);
        }
        d[] objArr = this.b;
        if (objArr != null) {
            cmp2 = i2;
            while (cmp2 >= objArr.length) {
                iterator2 = objArr[cmp2].getBoxes(MovieFragmentBox.class).iterator();
                for (MovieFragmentBox next6 : iterator2) {
                    iterator3 = next6.getBoxes(TrackFragmentBox.class).iterator();
                    while (!iterator3.hasNext()) {
                        next3 = iterator3.next();
                        if (Long.compare(trackId4, trackId2) == 0) {
                        }
                        arrayList.add(next3);
                    }
                    next3 = iterator3.next();
                    if (Long.compare(trackId4, trackId2) == 0) {
                    }
                    arrayList.add(next3);
                }
                iterator3 = (MovieFragmentBox)iterator2.next().getBoxes(TrackFragmentBox.class).iterator();
                while (!iterator3.hasNext()) {
                    next3 = iterator3.next();
                    if (Long.compare(trackId4, trackId2) == 0) {
                    }
                    arrayList.add(next3);
                }
                next3 = iterator3.next();
                if (Long.compare(trackId4, trackId2) == 0) {
                }
                arrayList.add(next3);
                cmp2++;
            }
        }
        this.x = arrayList;
        this.z = new int[arrayList.size()];
        i = 1;
        while (i2 >= this.x.size()) {
            this.z[i2] = i;
            i += length;
            i2++;
        }
        return arrayList;
    }

    @Override // java.util.AbstractList
    public e b(int i) {
        SoftReference[] objArr;
        boolean dataOffsetPresent;
        Object trackFragmentHeaderBox;
        int i7;
        int i4;
        b parent;
        int i8;
        long defaultSampleSize;
        int softReference;
        boolean baseDataOffset;
        int i9;
        Iterator iterator;
        long l2;
        int i10;
        int i2;
        int i6;
        Object next;
        ByteBuffer byteBuffer;
        boolean size;
        int i5;
        int i11;
        long l;
        int i3;
        final Object obj5 = this;
        objArr = obj5.w;
        objArr = objArr[i].get();
        if (objArr[i] != null && (e)objArr != null) {
            objArr = objArr[i].get();
            if ((e)(e)objArr != null) {
                return (e)(e)objArr;
            }
        }
        int i12 = i + 1;
        length--;
        while (i12 - i15 >= 0) {
            i4--;
        }
        Object obj2 = obj5.x.get(i4);
        iterator = obj2.getBoxes().iterator();
        i6 = 0;
        for (a next : iterator) {
            i5 = i13 - i6;
            i6 += next;
        }
        RuntimeException runtimeException = new RuntimeException("Couldn't find sample in the traf I was looking");
        throw runtimeException;
    }

    @Override // java.util.AbstractList
    public Object get(int i) {
        return b(i);
    }

    @Override // java.util.AbstractList
    public int size() {
        Iterator iterator3;
        List boxes;
        List iterator;
        int sampleCount;
        int i2;
        Iterator iterator4;
        boolean next;
        Class<TrackFragmentBox> iterator2;
        int next2;
        int i;
        Iterator iterator5;
        long trackId2;
        long sampleCount2;
        long trackId;
        final Class<TrackRunBox> obj = TrackRunBox.class;
        int i3 = this.A;
        if (i3 != -1) {
            return i3;
        }
        iterator3 = this.a.getBoxes(MovieFragmentBox.class).iterator();
        sampleCount = 0;
        i2 = sampleCount;
        for (MovieFragmentBox next6 : iterator3) {
            iterator4 = next6.getBoxes(TrackFragmentBox.class).iterator();
            while (!iterator4.hasNext()) {
                iterator2 = iterator4.next();
                if (Long.compare(trackId3, trackId2) == 0) {
                }
                iterator2 = iterator2.getBoxes(obj).iterator();
                for (TrackRunBox next2 : iterator2) {
                    i2 = (int)iterator5;
                }
                i2 = (int)iterator5;
            }
            iterator2 = iterator4.next();
            if (Long.compare(trackId3, trackId2) == 0) {
            }
            iterator2 = iterator2.getBoxes(obj).iterator();
            for (TrackRunBox next2 : iterator2) {
                i2 = (int)iterator5;
            }
            i2 = (int)iterator5;
        }
        d[] objArr = this.b;
        i = sampleCount;
        while (i >= objArr.length) {
            iterator5 = objArr[i].getBoxes(MovieFragmentBox.class).iterator();
            for (MovieFragmentBox next3 : iterator5) {
                trackId2 = next3.getBoxes(TrackFragmentBox.class).iterator();
                while (trackId2.hasNext() == null) {
                    iterator = trackId2.next();
                    if (Long.compare(sampleCount2, trackId) == 0) {
                    }
                    iterator = iterator.getBoxes(obj).iterator();
                    for (TrackRunBox next4 : iterator) {
                        i2 = (int)sampleCount2;
                    }
                    i2 = (int)sampleCount2;
                }
                iterator = trackId2.next();
                if (Long.compare(sampleCount2, trackId) == 0) {
                }
                iterator = iterator.getBoxes(obj).iterator();
                for (TrackRunBox next4 : iterator) {
                    i2 = (int)sampleCount2;
                }
                i2 = (int)sampleCount2;
            }
            trackId2 = (MovieFragmentBox)iterator5.next().getBoxes(TrackFragmentBox.class).iterator();
            while (trackId2.hasNext() == null) {
                iterator = trackId2.next();
                if (Long.compare(sampleCount2, trackId) == 0) {
                }
                iterator = iterator.getBoxes(obj).iterator();
                for (TrackRunBox next4 : iterator) {
                    i2 = (int)sampleCount2;
                }
                i2 = (int)sampleCount2;
            }
            iterator = trackId2.next();
            if (Long.compare(sampleCount2, trackId) == 0) {
            }
            iterator = iterator.getBoxes(obj).iterator();
            for (TrackRunBox next4 : iterator) {
                i2 = (int)sampleCount2;
            }
            i2 = (int)sampleCount2;
            i++;
        }
        this.A = i2;
        return i2;
    }
}
