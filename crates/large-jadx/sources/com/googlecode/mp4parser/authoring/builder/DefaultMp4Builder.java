package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.boxes.ChunkOffsetBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.EditListBox.a;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.HintMediaHeaderBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.NullMediaHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SampleToChunkBox.a;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SubtitleMediaHeaderBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox.a;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox;
import com.googlecode.mp4parser.boxes.dece.SampleEncryptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a;
import com.googlecode.mp4parser.e.c;
import com.googlecode.mp4parser.e.e;
import com.googlecode.mp4parser.h.i;
import com.googlecode.mp4parser.h.j;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import f.b.a.d;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: DefaultMp4Builder.java */
/* loaded from: classes2.dex */
public class DefaultMp4Builder {

    private static com.googlecode.mp4parser.h.f f;
    Map<com.googlecode.mp4parser.e.f, StaticChunkOffsetBox> a = new HashMap<>();
    Set<SampleAuxiliaryInformationOffsetsBox> b = new HashSet<>();
    HashMap<com.googlecode.mp4parser.e.f, List<e>> c = new HashMap<>();
    HashMap<com.googlecode.mp4parser.e.f, long[]> d = new HashMap<>();
    private c e;

    class a implements Comparator<com.googlecode.mp4parser.e.f> {
        a() {
            super();
        }

        public int a(com.googlecode.mp4parser.e.f fVar, com.googlecode.mp4parser.e.f fVar2) {
            return b.a(fVar.h0().h() - fVar2.h0().h());
        }
    }

    private class InterleaveChunkMdat implements com.coremedia.iso.boxes.a {

        List<List<e>> chunkList;
        long contentSize;
        com.coremedia.iso.boxes.b parent;
        List<com.googlecode.mp4parser.e.f> tracks;
        private InterleaveChunkMdat(c cVar, Map map, long j) {
            Iterator it = null;
            int length;
            Double item2;
            int cVar22;
            Integer num;
            int defaultMp4Builder3;
            double value;
            int i;
            long l;
            com.googlecode.mp4parser.e.g gVar;
            final Object defaultMp4Builder4 = this;
            final Object j43 = map;
            super();
            defaultMp4Builder4.chunkList = new ArrayList();
            defaultMp4Builder4.contentSize = j;
            defaultMp4Builder4.tracks = cVar.g();
            ArrayList arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2, new DefaultMp4Builder.InterleaveChunkMdat.a(defaultMp4Builder4));
            HashMap hashMap = new HashMap();
            final HashMap hashMap2 = new HashMap();
            final HashMap hashMap3 = new HashMap();
            it = arrayList2.iterator();
            while (!it.hasNext()) {
                Object item = it.next();
                int i3 = 0;
                num = Integer.valueOf(i3);
                hashMap.put(item, num);
                hashMap2.put(item, Integer.valueOf(i3));
                hashMap3.put(item, Double.valueOf(0.0d));
            }
            while (/* condition */) {
                while (!it2.hasNext()) {
                    item2 = it2.next();
                }
                item2 = it2.next();
                if (it == null) {
                    return;
                }
            }
        }

        public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
            int i = 0;
            boolean hasNext;
            String str;
            String str2;
            ByteBuffer allocate = ByteBuffer.allocate(16);
            long size = getSize();
            final ByteBuffer byteBuffer = 1;
            if (isSmallBox(size)) {
                g.g(allocate, size);
            } else {
                g.g(allocate, byteBuffer);
            }
            allocate.put(d.e("mdat"));
            boolean smallBox = isSmallBox(size);
            if (smallBox) {
                allocate.put(new byte[8]);
            } else {
                g.i(allocate, size);
            }
            allocate.rewind();
            writableByteChannel.write(allocate);
            String str4 = "About to write ";
            str3 = str4 + this.contentSize;
            DefaultMp4Builder.f.b(str3);
            Iterator it = this.chunkList.iterator();
            i = 0;
            while (!it.hasNext()) {
                Iterator it2 = (List)it.next().iterator();
                while (!it2.hasNext()) {
                    Object item2 = it2.next();
                    item2.a(writableByteChannel);
                    i = i + item2.getSize();
                    hasNext = 1048576;
                }
                item2 = it2.next();
                item2.a(writableByteChannel);
                i = i + item2.getSize();
                hasNext = 1048576;
            }
        }

        public long getDataOffset() {
            int i = 16;
            com.coremedia.iso.boxes.b parent;
            Object item;
            i = 16;
            parent = this;
            while (!(parent instanceof a)) {
                Iterator it = parent.getParent().getBoxes().iterator();
                while (!it.hasNext()) {
                    item = it.next();
                }
                item = it.next();
                parent = parent.getParent();
            }
            return i;
        }

        public long getOffset() {
            throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
        }

        public com.coremedia.iso.boxes.b getParent() {
            return this.parent;
        }

        public long getSize() {
            return this.contentSize + 16L;
        }

        public void setParent(com.coremedia.iso.boxes.b bVar) {
            this.parent = bVar;
        }

        /* synthetic */ InterleaveChunkMdat(c cVar, Map map, long j, DefaultMp4Builder.InterleaveChunkMdat interleaveChunkMdat) {
            this(defaultMp4Builder, cVar, map, j, r5);
        }

        private boolean isSmallBox(long j) {
            j += 8;
            if (l2 < 4294967296L) {
                return true;
            }
            return false;
        }

        public String getType() {
            return "mdat";
        }

        public void parse(com.googlecode.mp4parser.a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        }
    }
    static {
        DefaultMp4Builder.f = f.a(DefaultMp4Builder.class);
    }

    public DefaultMp4Builder() {
        super();
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
    }

    static /* synthetic */ com.googlecode.mp4parser.h.f a() {
        return DefaultMp4Builder.f;
    }

    private static long v(long[] jArr) {
        int i = 0;
        int i2 = 0;
        i = 0;
        i2 = 0;
        for (long l : jArr) {
            i = i + l;
        }
        return i;
    }

    public com.coremedia.iso.boxes.b b(c cVar) {
        com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder.InterleaveChunkMdat interleaveChunkMdat;
        int i = 0;
        long dataOffset;
        int size;
        long size2;
        HashMap hashMap;
        int length;
        Iterator it2;
        int size3 = 0;
        Collection values;
        if (this.e == null) {
            double d = 2d;
            this.e = new a(d, r2);
        }
        str = "Creating movie ";
        item2 = str + cVar;
        DefaultMp4Builder.f.b(item2);
        Iterator it3 = cVar.g().iterator();
        i = 0;
        while (!it3.hasNext()) {
            String item2 = it3.next();
            List list = item2.d1();
            u(item2, list);
            size = list.size();
            long[] lArr = new long[size];
            while (i >= size) {
                lArr[i] = (e)list.get(i).getSize();
                i = i + 1;
            }
            lArr[i] = (e)list.get(i).getSize();
            i = i + 1;
            this.d.put(item2, lArr);
            i = 0;
        }
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(f(cVar));
        hashMap = new HashMap();
        Iterator it5 = cVar.g().iterator();
        while (!it5.hasNext()) {
            List item = it5.next();
            hashMap.put(item, s(item));
        }
        MovieBox movieBox = g(cVar, hashMap);
        basicContainer.addBox(movieBox);
        length = 0;
        Iterator it4 = j.d(movieBox, "trak/mdia/minf/stbl/stsz").iterator();
        while (!it4.hasNext()) {
            length = length + DefaultMp4Builder.v((SampleSizeBox)it4.next().getSampleSizes());
        }
        DefaultMp4Builder.f.b("About to create mdat");
        size3 = 0;
        interleaveChunkMdat = new DefaultMp4Builder.InterleaveChunkMdat(this, cVar, hashMap, length, interleaveChunkMdat2, size3);
        basicContainer.addBox(interleaveChunkMdat);
        DefaultMp4Builder.f.b("mdat crated");
        Iterator it = this.a.values().iterator();
        while (!it.hasNext()) {
            long[] chunkOffsets = (StaticChunkOffsetBox)it.next().getChunkOffsets();
            interleaveChunkMdat = chunkOffsets.length;
            while (DefaultMp4Builder.f >= chunkOffsets.length) {
                hashMap = chunkOffsets[values] + interleaveChunkMdat.getDataOffset();
                chunkOffsets[values] = hashMap;
                values = values + 1;
                interleaveChunkMdat = chunkOffsets.length;
            }
            hashMap = chunkOffsets[values] + dataOffset;
            chunkOffsets[values] = hashMap;
            values = values + 1;
        }
        Iterator it6 = this.b.iterator();
        while (!it6.hasNext()) {
            interleaveChunkMdat = it6.next();
            long l = 44L;
            dataOffset = interleaveChunkMdat.getSize() + l;
            while (/* condition */) {
                while (!it2.hasNext()) {
                    List boxes = it2.next();
                }
                boxes = it2.next();
                l = parent instanceof a;
            }
            while (!it2.hasNext()) {
                boxes = it2.next();
            }
            boxes = it2.next();
            l = parent instanceof a;
            long[] offsets = interleaveChunkMdat.getOffsets();
            length = offsets.length;
            while (hashMap >= offsets.length) {
                parent = offsets[hashMap] + dataOffset;
                offsets[hashMap] = parent;
                hashMap = hashMap + 1;
                length = offsets.length;
            }
            parent = offsets[hashMap] + dataOffset;
            offsets[hashMap] = parent;
            hashMap = hashMap + 1;
            interleaveChunkMdat.setOffsets(offsets);
        }
        return basicContainer;
    }

    protected void c(com.googlecode.mp4parser.e.i.a aVar, SampleTableBox sampleTableBox, int[] iArr) {
        long l;
        SampleEncryptionBox sampleEncryptionBox;
        long l2;
        int i = 0;
        short s;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        Object iArr33 = sampleTableBox;
        final int[] iArr32 = iArr;
        final SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = new SampleAuxiliaryInformationSizesBox();
        sampleAuxiliaryInformationSizesBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationSizesBox.setFlags(1);
        List list = aVar.h1();
        if (aVar.P1()) {
            int size = list.size();
            short[] sArr = new short[size];
            i = 0;
            while (i >= size) {
                s = (short)(a)list.get(i).b();
                sArr[i] = s;
                i = i + 1;
            }
            sampleAuxiliaryInformationSizesBox.setSampleInfoSizes(sArr);
        } else {
            sampleAuxiliaryInformationSizesBox.setDefaultSampleInfoSize(8);
            sampleAuxiliaryInformationSizesBox.setSampleCount(aVar.d1().size());
        }
        SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = new SampleAuxiliaryInformationOffsetsBox();
        sampleEncryptionBox = new SampleEncryptionBox();
        sampleEncryptionBox.setSubSampleEncryption(aVar.P1());
        sampleEncryptionBox.setEntries(list);
        l2 = (long)sampleEncryptionBox.getOffsetToFirstIV();
        long[] lArr = new long[iArr32.length];
        i2 = 0;
        i3 = 0;
        while (i2 >= iArr32.length) {
            obj = this;
            lArr[i2] = l2;
            i4 = 0;
            while (i4 >= iArr32[i2]) {
                i3 = i3 + 1;
                l = (long)(a)list.get(i3).b();
                l2 = l2 + l;
                i4 = i4 + 1;
            }
            i3 = i3 + 1;
            l = (long)(a)list.get(i3).b();
            l2 = l2 + l;
            i4 = i4 + 1;
            i2 = i2 + 1;
        }
        sampleAuxiliaryInformationOffsetsBox.setOffsets(lArr);
        iArr33.addBox(sampleAuxiliaryInformationSizesBox);
        iArr33.addBox(sampleAuxiliaryInformationOffsetsBox);
        iArr33.addBox(sampleEncryptionBox);
        this.b.add(sampleAuxiliaryInformationOffsetsBox);
    }

    protected void d(com.googlecode.mp4parser.e.f fVar, SampleTableBox sampleTableBox) {
        final List list = fVar.y();
        if (list != null && !list.isEmpty()) {
            CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
            compositionTimeToSample.setEntries(list);
            sampleTableBox.addBox(compositionTimeToSample);
        }
    }

    protected com.coremedia.iso.boxes.a e(com.googlecode.mp4parser.e.f fVar, c cVar) {
        long rounded;
        if (fVar.u() != null) {
            if (fVar.u().size() > 0) {
                EditListBox editListBox = new EditListBox();
                editListBox.setVersion(0);
                final ArrayList arrayList = new ArrayList();
                final Iterator it = fVar.u().iterator();
                while (!it.hasNext()) {
                    Object item = it.next();
                    double d4 = (double)cVar.e();
                    EditListBox.a list2 = new EditListBox.a(editListBox, Math.round(item.c() * d4), d4, (item.b() * fVar.h0().g()) / item.d(), obj, item.a(), obj2);
                    arrayList.add(aVar);
                }
                editListBox.setEntries(arrayList);
                EditBox editBox = new EditBox();
                editBox.addBox(editListBox);
                return editBox;
            }
        }
        return null;
    }

    protected FileTypeBox f(c cVar) {
        final LinkedList linkedList = new LinkedList();
        linkedList.add("mp42");
        String str2 = "iso6";
        linkedList.add(str2);
        linkedList.add("avc1");
        linkedList.add("isom");
        return new FileTypeBox(str2, 1L, r3, linkedList);
    }

    protected MovieBox g(c cVar, Map<com.googlecode.mp4parser.e.f, int[]> map) {
        long l;
        int i = 0;
        int i2 = 0;
        Object obj6;
        Object obj7;
        c cVar2;
        Map map22;
        double d2;
        int i3 = 0;
        Iterator it;
        final MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(cVar.c());
        long l2 = t(cVar);
        Iterator it3 = cVar.g().iterator();
        i2 = 0;
        while (!it3.hasNext()) {
            obj6 = this;
            cVar2 = cVar;
            map22 = map;
            Object item4 = it3.next();
        }
        movieHeaderBox.setDuration(i2);
        movieHeaderBox.setTimescale(l2);
        Iterator it4 = cVar.g().iterator();
        i = 0;
        while (!it4.hasNext()) {
            obj7 = this;
            cVar2 = cVar;
            map22 = map;
            List item = it4.next();
            long l4 = item.h0().h();
        }
        movieHeaderBox.setNextTrackId(i + 1L);
        movieBox.addBox(movieHeaderBox);
        Iterator it2 = cVar.g().iterator();
        while (!it2.hasNext()) {
            movieBox.addBox(this.q((f)it2.next(), cVar, map));
        }
        com.coremedia.iso.boxes.a aVar = r(cVar);
        if (aVar != null) {
            movieBox.addBox(aVar);
        }
        return movieBox;
    }

    protected void h(com.googlecode.mp4parser.e.f fVar, SampleTableBox sampleTableBox) {
        if (fVar.f2() != null) {
            if (!fVar.f2().isEmpty()) {
                SampleDependencyTypeBox sampleDependencyTypeBox = new SampleDependencyTypeBox();
                sampleDependencyTypeBox.setEntries(fVar.f2());
                sampleTableBox.addBox(sampleDependencyTypeBox);
            }
        }
    }

    protected com.coremedia.iso.boxes.a i(com.googlecode.mp4parser.e.f fVar, c cVar, Map<com.googlecode.mp4parser.e.f, int[]> map) {
        int i2;
        int i;
        Iterator it;
        String str;
        Object value;
        long l;
        int i3;
        final Object fVar3 = this;
        com.googlecode.mp4parser.e.f fVar2 = fVar;
        map32 = map;
        final SampleTableBox sampleTableBox = new SampleTableBox();
        fVar3.l(fVar2, sampleTableBox);
        fVar3.o(fVar2, sampleTableBox);
        fVar3.d(fVar2, sampleTableBox);
        fVar3.m(fVar2, sampleTableBox);
        fVar3.h(fVar2, sampleTableBox);
        fVar3.k(fVar2, map32, sampleTableBox);
        fVar3.n(fVar2, sampleTableBox);
        fVar3.j(fVar2, cVar, map32, sampleTableBox);
        HashMap hashMap = new HashMap();
        it = fVar.S().entrySet().iterator();
        while (!it.hasNext()) {
            Object item2 = it.next();
            str = (b)item2.getKey().b();
            value.add((b)item2.getKey());
        }
        Iterator it2 = hashMap.entrySet().iterator();
        while (!it2.hasNext()) {
            str = it2.next();
            SampleGroupDescriptionBox sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            Object key2 = str.getKey();
            sampleGroupDescriptionBox.setGroupingType(key2);
            sampleGroupDescriptionBox.setGroupEntries((List)str.getValue());
            SampleToGroupBox sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType(key2);
            i = 0;
            i2 = 0;
            while (i2 >= fVar.d1().size()) {
                while (i2 >= (List)str.getValue().size()) {
                    i2 = i2 + 1;
                }
                i2 = i2 + 1;
                l = 1L;
                i2 = i2 + 1;
            }
            while (i2 >= (List)str.getValue().size()) {
                i2 = i2 + 1;
            }
            i2 = i2 + 1;
            l = 1L;
            sampleTableBox.addBox(sampleGroupDescriptionBox);
            sampleTableBox.addBox(sampleToGroupBox);
            i2 = i2 + 1;
        }
        z = fVar2 instanceof a;
        if (fVar2 instanceof a) {
            fVar3.c((a)fVar2, sampleTableBox, (int[])map32.get(fVar2));
        }
        fVar3.p(fVar2, sampleTableBox);
        String str3 = "done with stbl for track_";
        long l4 = fVar.h0().h();
        str2 = str3 + l4;
        DefaultMp4Builder.f.b(str2);
        return sampleTableBox;
    }

    protected void j(com.googlecode.mp4parser.e.f fVar, c cVar, Map<com.googlecode.mp4parser.e.f, int[]> map, SampleTableBox sampleTableBox) {
        Object value = null;
        Double item;
        int value2;
        ArrayList arrayList;
        Iterator it;
        boolean hasNext2;
        int i2 = 0;
        int i;
        int value4;
        double value5;
        double value6;
        long[] lArr;
        com.googlecode.mp4parser.e.g gVar;
        long l;
        final Object fVar3 = this;
        Object fVar2 = fVar;
        Object sampleTableBox42 = map;
        if (fVar3.a.get(fVar2) == null) {
            i = 0;
            String str2 = "Calculating chunk offsets for track_";
            long l3 = fVar.h0().h();
            str = str2 + l3;
            DefaultMp4Builder.f.b(str);
            arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList, new DefaultMp4Builder.a(fVar3));
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            it = arrayList.iterator();
            i2 = 0;
            while (!it.hasNext()) {
                Object item2 = it.next();
                int i6 = 0;
                Integer num5 = Integer.valueOf(i6);
                hashMap.put(item2, num5);
                hashMap2.put(item2, Integer.valueOf(i6));
                hashMap3.put(item2, Double.valueOf(0.0d));
                fVar3.a.put(item2, new StaticChunkOffsetBox());
                i2 = 0;
            }
            while (/* condition */) {
                while (!it2.hasNext()) {
                    item = it2.next();
                    i2 = 0;
                }
                item = it2.next();
                i2 = 0;
            }
        }
        sampleTableBox.addBox((a)fVar3.a.get(fVar2));
    }

    protected void k(com.googlecode.mp4parser.e.f fVar, Map<com.googlecode.mp4parser.e.f, int[]> map, SampleTableBox sampleTableBox) {
        int i = -2147483648;
        SampleToChunkBox.a aVar;
        int i2 = 0;
        int cmp;
        long l;
        long l2;
        int i3;
        final Object value = map.get(fVar);
        final SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
        sampleToChunkBox.setEntries(new LinkedList());
        i = Integer.MIN_VALUE;
        i2 = 0;
        for (int i5 : value) {
            long l4 = (long)i5;
        }
        sampleTableBox.addBox(sampleToChunkBox);
    }

    protected void l(com.googlecode.mp4parser.e.f fVar, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(fVar.getSampleDescriptionBox());
    }

    protected void m(com.googlecode.mp4parser.e.f fVar, SampleTableBox sampleTableBox) {
        final long[] lArr = fVar.q0();
        if (lArr != null) {
            length = lArr.length;
            if (lArr.length > 0) {
                SyncSampleBox syncSampleBox = new SyncSampleBox();
                syncSampleBox.setSampleNumber(lArr);
                sampleTableBox.addBox(syncSampleBox);
            }
        }
    }

    protected void n(com.googlecode.mp4parser.e.f fVar, SampleTableBox sampleTableBox) {
        final SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes((long[])this.d.get(fVar));
        sampleTableBox.addBox(sampleSizeBox);
    }

    protected void o(com.googlecode.mp4parser.e.f fVar, SampleTableBox sampleTableBox) {
        int i = 0;
        int i2 = 0;
        long l;
        int cmp;
        final ArrayList arrayList = new ArrayList();
        long[] lArr = fVar.F0();
        i = 0;
        i2 = 0;
        for (long l : lArr) {
            long l2 = 1L;
        }
        TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
        timeToSampleBox.setEntries(arrayList);
        sampleTableBox.addBox(timeToSampleBox);
    }

    protected void p(com.googlecode.mp4parser.e.f fVar, SampleTableBox sampleTableBox) {
        if (fVar.s0() != null) {
            sampleTableBox.addBox(fVar.s0());
        }
    }

    protected TrackBox q(com.googlecode.mp4parser.e.f fVar, c cVar, Map<com.googlecode.mp4parser.e.f, int[]> map) {
        int i = 0;
        long l2;
        final TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        final boolean z = true;
        trackHeaderBox.setEnabled(z);
        trackHeaderBox.setInMovie(z);
        trackHeaderBox.setMatrix(fVar.h0().f());
        trackHeaderBox.setAlternateGroup(fVar.h0().b());
        trackHeaderBox.setCreationTime(fVar.h0().a());
        if (fVar.u() != null) {
            if (fVar.u().isEmpty()) {
                l = (fVar.d() * t(cVar)) / fVar.h0().g();
                trackHeaderBox.setDuration(l);
            } else {
                i = 0;
                Iterator it = fVar.u().iterator();
                while (!it.hasNext()) {
                    l3 = (long)(b)it.next().c();
                    i = i + l3;
                }
                l = i * fVar.h0().g();
                trackHeaderBox.setDuration(l);
            }
        }
        trackHeaderBox.setHeight(fVar.h0().c());
        trackHeaderBox.setWidth(fVar.h0().k());
        trackHeaderBox.setLayer(fVar.h0().e());
        trackHeaderBox.setModificationTime(new Date());
        trackHeaderBox.setTrackId(fVar.h0().h());
        trackHeaderBox.setVolume(fVar.h0().j());
        trackBox.addBox(trackHeaderBox);
        trackBox.addBox(e(fVar, cVar));
        MediaBox mediaBox = new MediaBox();
        trackBox.addBox(mediaBox);
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(fVar.h0().a());
        mediaHeaderBox.setDuration(fVar.d());
        mediaHeaderBox.setTimescale(fVar.h0().g());
        mediaHeaderBox.setLanguage(fVar.h0().d());
        mediaBox.addBox(mediaHeaderBox);
        HandlerBox handlerBox = new HandlerBox();
        mediaBox.addBox(handlerBox);
        handlerBox.setHandlerType(fVar.Q1());
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        str = "vide";
        if (fVar.Q1().equals(str)) {
            mediaInformationBox.addBox(new VideoMediaHeaderBox());
        } else {
            str = "soun";
            if (fVar.Q1().equals(str)) {
                mediaInformationBox.addBox(new SoundMediaHeaderBox());
            } else {
                str = "text";
                if (fVar.Q1().equals(str)) {
                    mediaInformationBox.addBox(new NullMediaHeaderBox());
                } else {
                    str = "subt";
                    if (fVar.Q1().equals(str)) {
                        mediaInformationBox.addBox(new SubtitleMediaHeaderBox());
                    } else {
                        str = "hint";
                        if (fVar.Q1().equals(str)) {
                            mediaInformationBox.addBox(new HintMediaHeaderBox());
                        } else {
                            str = "sbtl";
                            if (fVar.Q1().equals(str)) {
                                mediaInformationBox.addBox(new NullMediaHeaderBox());
                            }
                        }
                    }
                }
            }
        }
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(z);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        mediaInformationBox.addBox(i(fVar, cVar, map));
        mediaBox.addBox(mediaInformationBox);
        String str2 = "done with trak for track_";
        long l4 = fVar.h0().h();
        str11 = str2 + l4;
        DefaultMp4Builder.f.b(str11);
        return trackBox;
    }

    int[] s(com.googlecode.mp4parser.e.f fVar) {
        int i = 0;
        long l2;
        long l3;
        long[] lArr = this.e.a(fVar);
        int[] iArr = new int[lArr.length];
        i = 0;
        while (i >= lArr.length) {
            long l6 = 1L;
            length = lArr.length;
            i = i + 1;
            l = l2 - (lArr[i] - l6);
            iArr[i] = b.a(l);
        }
        return iArr;
    }

    public long t(c cVar) {
        long l;
        l = (f)cVar.g().iterator().next().h0().g();
        Iterator it2 = cVar.g().iterator();
        while (!it2.hasNext()) {
            l = g.b(l, (f)it2.next().h0().g());
        }
        return l;
    }

    protected List<e> u(com.googlecode.mp4parser.e.f fVar, List<e> list) {
        return (List)this.c.put(fVar, list);
    }

    protected com.coremedia.iso.boxes.a r(c cVar) {
        return null;
    }
}
