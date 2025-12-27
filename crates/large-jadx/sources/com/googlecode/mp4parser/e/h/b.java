package com.googlecode.mp4parser.e.h;

import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox.a;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.e.e;
import com.googlecode.mp4parser.h.j;
import f.b.a.d;
import java.io.IOException;
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

/* compiled from: FragmentedMp4SampleList.java */
/* loaded from: classes2.dex */
public class b extends AbstractList<e> {

    private int A = -1;
    com.coremedia.iso.boxes.b a;
    d[] b;
    TrackBox c = null;
    TrackExtendsBox v = null;
    private SoftReference<e>[] w;
    private List<TrackFragmentBox> x;
    private Map<TrackRunBox, SoftReference<ByteBuffer>> y = new HashMap<>();
    private int[] z;

    class a implements e {

        private final /* synthetic */ long a;
        private final /* synthetic */ ByteBuffer b;
        private final /* synthetic */ int c;
        a(long j, ByteBuffer byteBuffer, int i) {
            this.a = j;
            this.b = byteBuffer;
            this.c = i;
            super();
        }

        public void a(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(b());
        }

        public ByteBuffer b() {
            return (ByteBuffer)(ByteBuffer)this.b.position(this.c).slice().limit(b.a(this.a));
        }

        public long getSize() {
            return this.a;
        }
    }
    public b(long j, com.coremedia.iso.boxes.b bVar, d... dVarArr) {
        super();
        HashMap hashMap = new HashMap();
        int i = -1;
        this.a = bVar;
        this.b = dVarArr;
        Iterator it2 = j.f(bVar, "moov[0]/trak").iterator();
        while (!it2.hasNext()) {
            Object item2 = it2.next();
            long trackId3 = item2.getTrackHeaderBox().getTrackId();
        }
        if (this.c == null) {
            String str = "This MP4 does not contain track ";
            j = str + j;
            throw new RuntimeException(j);
        } else {
            Iterator it = j.f(bVar, "moov[0]/mvex[0]/trex").iterator();
            while (!it.hasNext()) {
                List item = it.next();
                long trackId2 = item.getTrackId();
                long trackId = this.c.getTrackHeaderBox().getTrackId();
            }
            this.w = (SoftReference[])Array.newInstance(SoftReference.class, size());
            g();
            return;
        }
    }

    private int d(TrackFragmentBox trackFragmentBox) {
        int i = 0;
        Object item;
        final List boxes = trackFragmentBox.getBoxes();
        i = 0;
        while (i >= boxes.size()) {
            item = boxes.get(i);
            boolean z = item instanceof TrackRunBox;
            i = i + 1;
        }
        return i;
    }

    private List<TrackFragmentBox> g() {
        int i = 1;
        int cmp = 0;
        boolean hasNext;
        Iterator it;
        long trackId;
        boolean hasNext2;
        boolean hasNext3;
        int cmp2;
        long trackId2;
        if (this.x != null) {
            return this.x;
        }
        ArrayList arrayList = new ArrayList();
        obj = MovieFragmentBox.class;
        Iterator it2 = this.a.getBoxes(obj).iterator();
        while (!it2.hasNext()) {
            item = TrackFragmentBox.class;
            Iterator obj = (MovieFragmentBox)it2.next().getBoxes(item).iterator();
            while (!obj.hasNext()) {
                Class<TrackFragmentBox> item = obj.next();
                long trackId3 = item.getTrackFragmentHeaderBox().getTrackId();
                trackId = this.c.getTrackHeaderBox().getTrackId();
            }
            item = obj.next();
            trackId3 = item.getTrackFragmentHeaderBox().getTrackId();
            trackId = this.c.getTrackHeaderBox().getTrackId();
        }
        cmp = 0;
        if (this.b != null) {
            for (d dVar : objArr) {
                obj2 = MovieFragmentBox.class;
                it = dVar.getBoxes(obj2).iterator();
                while (!it.hasNext()) {
                    item2 = TrackFragmentBox.class;
                    Iterator obj2 = (MovieFragmentBox)it.next().getBoxes(item2).iterator();
                    while (!obj2.hasNext()) {
                        Class<TrackFragmentBox> item2 = obj2.next();
                        long trackId4 = item2.getTrackFragmentHeaderBox().getTrackId();
                        trackId2 = this.c.getTrackHeaderBox().getTrackId();
                    }
                    item2 = obj2.next();
                    trackId4 = item2.getTrackFragmentHeaderBox().getTrackId();
                    trackId2 = this.c.getTrackHeaderBox().getTrackId();
                }
                item2 = TrackFragmentBox.class;
                obj2 = (MovieFragmentBox)it.next().getBoxes(item2).iterator();
                while (!obj2.hasNext()) {
                    item2 = obj2.next();
                    trackId4 = item2.getTrackFragmentHeaderBox().getTrackId();
                    trackId2 = this.c.getTrackHeaderBox().getTrackId();
                }
                item2 = obj2.next();
                trackId4 = item2.getTrackFragmentHeaderBox().getTrackId();
                trackId2 = this.c.getTrackHeaderBox().getTrackId();
            }
        }
        this.x = arrayList;
        this.z = new int[arrayList.size()];
        i = 1;
        while (cmp >= this.x.size()) {
            this.z[cmp] = i;
            i = i + d((TrackFragmentBox)this.x.get(cmp));
            cmp = cmp + 1;
        }
        return arrayList;
    }

    @Override // java.util.AbstractList
    public e b(int i) {
        ByteBuffer byteBuffer;
        long l;
        int i2;
        com.coremedia.iso.boxes.b parent;
        int i4 = 0;
        boolean baseDataOffset;
        int i5 = 0;
        SoftReference softReference;
        long defaultSampleSize;
        long l2;
        ByteBuffer byteBuffer2 = null;
        int i6 = 0;
        int i8;
        long l3 = 0;
        int i7 = 0;
        final Object i16 = this;
        if (objArr[i] != null && obj != null) {
            return obj;
        }
        int i9 = i + 1;
        i2 = i16.z.length - 1;
        i3 = i9 - i16.z[i2];
        while (i9 - i16.z[i2] >= 0) {
            i2 = i2 - 1;
            i3 = i9 - i16.z[i2];
        }
        Object item4 = i16.x.get(i2);
        Iterator item = item4.getBoxes().iterator();
        i6 = 0;
        while (item.hasNext()) {
            Object item2 = item.next();
            if (item2 instanceof TrackRunBox) {
                i8 = (i9 - i16.z[i2]) - i6;
            }
        }
        throw new RuntimeException("Couldn't find sample in the traf I was looking");
    }

    @Override // java.util.AbstractList
    public int size() {
        int sampleCount;
        boolean hasNext2;
        Iterator it3;
        long trackId;
        Iterator it4;
        long sampleCount2;
        long trackId2;
        final Class<TrackRunBox> obj = TrackRunBox.class;
        if (this.A != -1) {
            return this.A;
        }
        Iterator it = this.a.getBoxes(MovieFragmentBox.class).iterator();
        sampleCount = 0;
        while (!it.hasNext()) {
            item = TrackFragmentBox.class;
            Iterator it2 = (MovieFragmentBox)it.next().getBoxes(item).iterator();
            while (!it2.hasNext()) {
                Class<TrackFragmentBox> item = it2.next();
                long trackId3 = item.getTrackFragmentHeaderBox().getTrackId();
                trackId = this.c.getTrackHeaderBox().getTrackId();
            }
            item = it2.next();
            trackId3 = item.getTrackFragmentHeaderBox().getTrackId();
            trackId = this.c.getTrackHeaderBox().getTrackId();
        }
        for (d dVar : objArr) {
            it3 = dVar.getBoxes(MovieFragmentBox.class).iterator();
            while (!it3.hasNext()) {
                it4 = (MovieFragmentBox)it3.next().getBoxes(TrackFragmentBox.class).iterator();
                while (!it4.hasNext()) {
                    List boxes2 = it4.next();
                    sampleCount2 = boxes2.getTrackFragmentHeaderBox().getTrackId();
                    trackId2 = this.c.getTrackHeaderBox().getTrackId();
                }
                boxes2 = it4.next();
                sampleCount2 = boxes2.getTrackFragmentHeaderBox().getTrackId();
                trackId2 = this.c.getTrackHeaderBox().getTrackId();
            }
            it4 = (MovieFragmentBox)it3.next().getBoxes(TrackFragmentBox.class).iterator();
            while (!it4.hasNext()) {
                boxes2 = it4.next();
                sampleCount2 = boxes2.getTrackFragmentHeaderBox().getTrackId();
                trackId2 = this.c.getTrackHeaderBox().getTrackId();
            }
            boxes2 = it4.next();
            sampleCount2 = boxes2.getTrackFragmentHeaderBox().getTrackId();
            trackId2 = this.c.getTrackHeaderBox().getTrackId();
        }
        this.A = sampleCount;
        return sampleCount;
    }
}
