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
import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox;
import com.googlecode.mp4parser.boxes.dece.SampleEncryptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import com.googlecode.mp4parser.e.b;
import com.googlecode.mp4parser.e.c;
import com.googlecode.mp4parser.e.e;
import com.googlecode.mp4parser.e.f;
import com.googlecode.mp4parser.e.g;
import com.googlecode.mp4parser.e.i.a;
import com.googlecode.mp4parser.h.b;
import com.googlecode.mp4parser.h.f;
import com.googlecode.mp4parser.h.g;
import com.googlecode.mp4parser.h.i;
import com.googlecode.mp4parser.h.j;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso23001.part7.a;
import f.b.a.b;
import f.b.a.d;
import f.b.a.g;
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

/* loaded from: classes2.dex */
public class DefaultMp4Builder {

    private static f f;
    Map<f, StaticChunkOffsetBox> a;
    Set<SampleAuxiliaryInformationOffsetsBox> b;
    HashMap<f, List<e>> c;
    HashMap<f, long[]> d;
    private com.googlecode.mp4parser.authoring.builder.c e;

    class a implements Comparator<f> {
        a(com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder defaultMp4Builder) {
            super();
        }

        @Override // java.util.Comparator
        public int a(f f, f f2) {
            return b.a(l -= obj3);
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((f)object, (f)object2);
        }
    }

    private class InterleaveChunkMdat implements a {

        List<List<e>> chunkList;
        long contentSize;
        b parent;
        final com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder this$0;
        List<f> tracks;
        private InterleaveChunkMdat(com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder defaultMp4Builder, c c2, Map map3, long l4) {
            Iterator iterator;
            Object next;
            boolean valueOf2;
            int i2;
            Double valueOf;
            int intValue3;
            Integer intValue;
            int i3;
            int intValue2;
            double doubleValue;
            int i;
            long l;
            g gVar;
            com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder obj17;
            int obj18;
            final Object obj = this;
            final Object obj2 = map3;
            obj.this$0 = defaultMp4Builder;
            super();
            ArrayList arrayList = new ArrayList();
            obj.chunkList = arrayList;
            obj.contentSize = l4;
            obj.tracks = c2.g();
            ArrayList arrayList2 = new ArrayList(map3.keySet());
            DefaultMp4Builder.InterleaveChunkMdat.a aVar = new DefaultMp4Builder.InterleaveChunkMdat.a(obj);
            Collections.sort(arrayList2, aVar);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            iterator = arrayList2.iterator();
            for (f next : iterator) {
                int i4 = 0;
                intValue = Integer.valueOf(i4);
                hashMap.put(next, intValue);
                hashMap2.put(next, Integer.valueOf(i4));
                hashMap3.put(next, Double.valueOf(0));
            }
            while (/* condition */) {
                while (!iterator2.hasNext()) {
                    valueOf = iterator2.next();
                    if (iterator != null) {
                    } else {
                    }
                    if ((Integer)hashMap.get((f)valueOf).intValue() < obj9.length) {
                    }
                    iterator = valueOf;
                    if (Double.compare(doubleValue2, doubleValue) < 0 && (Integer)hashMap.get(valueOf).intValue() < obj9.length) {
                    }
                }
                valueOf = iterator2.next();
                if (iterator != null) {
                } else {
                }
                if ((Integer)hashMap.get((f)valueOf).intValue() < obj9.length) {
                }
                iterator = valueOf;
                if (Double.compare(doubleValue2, doubleValue) < 0 && (Integer)hashMap.get(valueOf).intValue() < obj9.length) {
                }
                if (iterator != null) {
                }
                i3 = (int[])obj2.get(iterator)[(Integer)hashMap.get(iterator).intValue()];
                intValue2 = (Integer)hashMap2.get(iterator).intValue();
                doubleValue = (Double)hashMap3.get(iterator).doubleValue();
                i2 = intValue2;
                i = intValue2 + i3;
                while (i2 >= i) {
                    doubleValue += i;
                    i2++;
                    i3 = obj17;
                    intValue3 = obj18;
                    i = intValue2 + i3;
                }
                doubleValue += i;
                i2++;
                i3 = obj17;
                intValue3 = obj18;
                obj.chunkList.add(iterator.d1().subList(intValue2, i));
                hashMap.put(iterator, Integer.valueOf(intValue3++));
                hashMap2.put(iterator, Integer.valueOf(i));
                hashMap3.put(iterator, Double.valueOf(doubleValue));
                iterator = 0;
                Iterator iterator2 = arrayList2.iterator();
            }
        }

        InterleaveChunkMdat(com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder defaultMp4Builder, c c2, Map map3, long l4, com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder.InterleaveChunkMdat defaultMp4Builder$InterleaveChunkMdat5) {
            super(defaultMp4Builder, c2, map3, l4, interleaveChunkMdat5);
        }

        private boolean isSmallBox(long l) {
            if (Long.compare(obj3, l2) < 0) {
                return 1;
            }
            return 0;
        }

        @Override // com.coremedia.iso.boxes.a
        public void getBox(WritableByteChannel writableByteChannel) {
            long bArr;
            int i;
            boolean smallBox;
            int i2;
            boolean next;
            String string;
            int cmp;
            ByteBuffer allocate = ByteBuffer.allocate(16);
            bArr = getSize();
            final int i5 = 1;
            if (isSmallBox(bArr)) {
                g.g(allocate, bArr);
            } else {
                g.g(allocate, i5);
            }
            allocate.put(d.e("mdat"));
            smallBox = isSmallBox(bArr);
            if (smallBox) {
                allocate.put(new byte[8]);
            } else {
                g.i(allocate, bArr);
            }
            allocate.rewind();
            writableByteChannel.write(allocate);
            StringBuilder stringBuilder = new StringBuilder("About to write ");
            stringBuilder.append(this.contentSize);
            DefaultMp4Builder.a().b(stringBuilder.toString());
            Iterator iterator = this.chunkList.iterator();
            i2 = i;
            for (List next3 : iterator) {
                smallBox = next3.iterator();
                while (!smallBox.hasNext()) {
                    Object next4 = smallBox.next();
                    (e)next4.a(writableByteChannel);
                    i += size;
                    next = 1048576;
                    if (Long.compare(i, next) > 0) {
                    }
                    i -= next;
                    StringBuilder stringBuilder2 = new StringBuilder("Written ");
                    stringBuilder2.append(i2 += i5);
                    stringBuilder2.append("MB");
                    DefaultMp4Builder.a().b(stringBuilder2.toString());
                }
                next4 = smallBox.next();
                (e)next4.a(writableByteChannel);
                i += size;
                next = 1048576;
                if (Long.compare(i, next) > 0) {
                }
                i -= next;
                stringBuilder2 = new StringBuilder("Written ");
                stringBuilder2.append(i2 += i5);
                stringBuilder2.append("MB");
                DefaultMp4Builder.a().b(stringBuilder2.toString());
            }
        }

        @Override // com.coremedia.iso.boxes.a
        public long getDataOffset() {
            int i;
            Object parent;
            Object obj;
            Iterator iterator;
            Object next;
            i = 16;
            parent = this;
            while (!parent instanceof a) {
                obj = parent;
                iterator = (a)obj.getParent().getBoxes().iterator();
                while (!iterator.hasNext()) {
                    next = iterator.next();
                    if (parent != (a)next) {
                        break loop_4;
                    }
                    i += next;
                }
                next = iterator.next();
                if (parent != (a)next) {
                }
                i += next;
                parent = obj.getParent();
            }
            return i;
        }

        @Override // com.coremedia.iso.boxes.a
        public long getOffset() {
            RuntimeException runtimeException = new RuntimeException("Doesn't have any meaning for programmatically created boxes");
            throw runtimeException;
        }

        @Override // com.coremedia.iso.boxes.a
        public b getParent() {
            return this.parent;
        }

        @Override // com.coremedia.iso.boxes.a
        public long getSize() {
            return contentSize += i2;
        }

        @Override // com.coremedia.iso.boxes.a
        public String getType() {
            return "mdat";
        }

        @Override // com.coremedia.iso.boxes.a
        public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        }

        @Override // com.coremedia.iso.boxes.a
        public void setParent(b b) {
            this.parent = b;
        }
    }
    static {
        DefaultMp4Builder.f = f.a(DefaultMp4Builder.class);
    }

    public DefaultMp4Builder() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        HashMap hashMap2 = new HashMap();
        this.c = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.d = hashMap3;
    }

    static f a() {
        return DefaultMp4Builder.f;
    }

    private static long v(long[] lArr) {
        int i2;
        int i;
        long l;
        i2 = 0;
        i = 0;
        while (i >= lArr.length) {
            i2 += l;
            i++;
        }
        return i2;
    }

    public b b(c c) {
        com.googlecode.mp4parser.authoring.builder.c aVar;
        List next;
        com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder.InterleaveChunkMdat interleaveChunkMdat;
        long l;
        String string;
        String str;
        int i;
        List list;
        int i2;
        long dataOffset;
        int size;
        long[] lArr;
        Iterator iterator2;
        int i3;
        List boxes;
        long size2;
        HashMap hashMap;
        com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder.InterleaveChunkMdat builder;
        int parent;
        com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder.InterleaveChunkMdat iterator;
        int chunkOffsets;
        Collection obj12;
        if (this.e == null) {
            aVar = new a(4611686018427387904L, obj2);
            this.e = aVar;
        }
        StringBuilder stringBuilder = new StringBuilder("Creating movie ");
        stringBuilder.append(c);
        DefaultMp4Builder.f.b(stringBuilder.toString());
        Iterator iterator3 = c.g().iterator();
        i = 0;
        for (f string : iterator3) {
            list = string.d1();
            u(string, list);
            size = list.size();
            lArr = new long[size];
            while (i >= size) {
                lArr[i] = (e)list.get(i).getSize();
                i++;
            }
            lArr[i] = (e)list.get(i).getSize();
            i++;
            this.d.put(string, lArr);
            i = 0;
        }
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(f(c));
        hashMap = new HashMap();
        Iterator iterator5 = c.g().iterator();
        for (f next : iterator5) {
            hashMap.put(next, s(next));
        }
        MovieBox movieBox = g(c, hashMap);
        basicContainer.addBox(movieBox);
        Iterator iterator4 = j.d(movieBox, "trak/mdia/minf/stbl/stsz").iterator();
        parent = i2;
        for (SampleSizeBox next6 : iterator4) {
            parent += i2;
        }
        DefaultMp4Builder.f.b("About to create mdat");
        super(this, c, hashMap, parent, obj8, 0);
        basicContainer.addBox(interleaveChunkMdat);
        DefaultMp4Builder.f.b("mdat crated");
        iterator2 = this.a.values().iterator();
        for (StaticChunkOffsetBox obj12 : iterator2) {
            chunkOffsets = obj12.getChunkOffsets();
            obj12 = i;
            for (long l2 : obj9) {
                chunkOffsets[obj12] = l2 += dataOffset;
            }
            chunkOffsets[obj12] = l2 += dataOffset;
            obj12++;
        }
        obj12 = this.b.iterator();
        for (SampleAuxiliaryInformationOffsetsBox interleaveChunkMdat : obj12) {
            size3 += i3;
            builder = interleaveChunkMdat;
            while (/* condition */) {
                while (!iterator.hasNext()) {
                    boxes = iterator.next();
                    if ((a)boxes != builder) {
                        break loop_15;
                    }
                    dataOffset += chunkOffsets;
                }
                boxes = iterator.next();
                if ((a)boxes != builder) {
                }
                dataOffset += chunkOffsets;
                if (parent instanceof a != 0) {
                }
                builder = parent;
                parent = (a)builder.getParent();
                iterator = parent.getBoxes().iterator();
            }
            while (!iterator.hasNext()) {
                boxes = iterator.next();
                if ((a)boxes != builder) {
                    break loop_15;
                }
                dataOffset += chunkOffsets;
            }
            boxes = iterator.next();
            if ((a)boxes != builder) {
            }
            dataOffset += chunkOffsets;
            if (parent instanceof a != 0) {
            }
            builder = parent;
            iterator2 = interleaveChunkMdat.getOffsets();
            hashMap = i;
            for (long l3 : obj5) {
                iterator2[hashMap] = l3 += dataOffset;
            }
            iterator2[hashMap] = l3 += dataOffset;
            hashMap++;
            interleaveChunkMdat.setOffsets(iterator2);
        }
        return basicContainer;
    }

    protected void c(a a, SampleTableBox sampleTableBox2, int[] i3Arr3) {
        int size;
        long l;
        short[] sArr;
        SampleEncryptionBox sampleEncryptionBox;
        int i;
        long l2;
        short s;
        int i2;
        int i3;
        Object obj;
        int i4;
        int i5;
        SampleEncryptionBox sampleEncryptionBox2;
        Object obj2 = sampleTableBox2;
        final int[] iArr = i3Arr3;
        SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = new SampleAuxiliaryInformationSizesBox();
        sampleAuxiliaryInformationSizesBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationSizesBox.setFlags(1);
        List list = a.h1();
        if (a.P1()) {
            size = list.size();
            sArr = new short[size];
            i = 0;
            while (i >= size) {
                sArr[i] = (short)i8;
                i++;
            }
            sampleAuxiliaryInformationSizesBox.setSampleInfoSizes(sArr);
        } else {
            sampleAuxiliaryInformationSizesBox.setDefaultSampleInfoSize(8);
            sampleAuxiliaryInformationSizesBox.setSampleCount(a.d1().size());
        }
        SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = new SampleAuxiliaryInformationOffsetsBox();
        sampleEncryptionBox = new SampleEncryptionBox();
        sampleEncryptionBox.setSubSampleEncryption(a.P1());
        sampleEncryptionBox.setEntries(list);
        l2 = (long)offsetToFirstIV;
        long[] lArr = new long[iArr.length];
        i2 = 0;
        i3 = 0;
        for (int i5 : obj1) {
            obj = this;
            lArr[i2] = l2;
            i4 = 0;
            while (i4 >= iArr[i2]) {
                l2 += l;
                i4++;
                i3 = i5;
                sampleEncryptionBox = sampleEncryptionBox2;
            }
            l2 += l;
            i4++;
            i3 = i5;
            sampleEncryptionBox = sampleEncryptionBox2;
        }
        sampleAuxiliaryInformationOffsetsBox.setOffsets(lArr);
        obj2.addBox(sampleAuxiliaryInformationSizesBox);
        obj2.addBox(sampleAuxiliaryInformationOffsetsBox);
        obj2.addBox(sampleEncryptionBox);
        obj5.b.add(sampleAuxiliaryInformationOffsetsBox);
    }

    protected void d(f f, SampleTableBox sampleTableBox2) {
        boolean compositionTimeToSample;
        final List obj2 = f.y();
        if (obj2 != null && !obj2.isEmpty()) {
            if (!obj2.isEmpty()) {
                compositionTimeToSample = new CompositionTimeToSample();
                compositionTimeToSample.setEntries(obj2);
                sampleTableBox2.addBox(compositionTimeToSample);
            }
        }
    }

    protected a e(f f, c c2) {
        List size;
        List list;
        EditListBox list2;
        double round;
        double d2;
        int i;
        double d;
        EditListBox.a aVar;
        if (f.u() != null && f.u().size() > 0) {
            if (f.u().size() > 0) {
                EditListBox editListBox = new EditListBox();
                editListBox.setVersion(0);
                ArrayList arrayList = new ArrayList();
                final Iterator iterator = f.u().iterator();
                for (b next2 : iterator) {
                    d2 = (double)l;
                    super(editListBox, Math.round(d3 *= d2), d2, i4 /= l4, obj6, next2.a(), obj8);
                    arrayList.add(aVar);
                }
                editListBox.setEntries(arrayList);
                EditBox obj13 = new EditBox();
                obj13.addBox(editListBox);
                return obj13;
            }
        }
        return null;
    }

    protected FileTypeBox f(c c) {
        LinkedList obj5 = new LinkedList();
        obj5.add("mp42");
        String str2 = "iso6";
        obj5.add(str2);
        obj5.add("avc1");
        obj5.add("isom");
        FileTypeBox fileTypeBox = new FileTypeBox(str2, 1, obj3, obj5);
        return fileTypeBox;
    }

    protected MovieBox g(c c, Map<f, int[]> map2) {
        List list;
        List next;
        int cmp;
        long l;
        int i;
        int i2;
        int cmp2;
        Object next2;
        Object obj;
        c cVar;
        Map map;
        int i3;
        int i4;
        List empty;
        Iterator iterator;
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        Date date = new Date();
        movieHeaderBox.setCreationTime(date);
        Date date2 = new Date();
        movieHeaderBox.setModificationTime(date2);
        movieHeaderBox.setMatrix(c.c());
        long l2 = t(c);
        Iterator iterator3 = c.g().iterator();
        i2 = 0;
        while (!iterator3.hasNext()) {
            obj = this;
            cVar = c;
            map = map2;
            Object next8 = iterator3.next();
            if ((f)next8.u() != null) {
            } else {
            }
            i6 /= i3;
            if (Long.compare(l, i2) > 0) {
            }
            i2 = l;
            if (next8.u().isEmpty()) {
            } else {
            }
            i4 = 0;
            iterator = next8.u().iterator();
            for (b next6 : iterator) {
                i4 += l;
            }
            i4 += l;
            l = (long)i3;
        }
        movieHeaderBox.setDuration(i2);
        movieHeaderBox.setTimescale(l2);
        Iterator iterator4 = c.g().iterator();
        i = 0;
        while (!iterator4.hasNext()) {
            obj = this;
            cVar = c;
            map = map2;
            next = iterator4.next();
            if (Long.compare(i, l3) < 0) {
            }
            i = next;
        }
        movieHeaderBox.setNextTrackId(i += i5);
        movieBox.addBox(movieHeaderBox);
        Iterator iterator2 = c.g().iterator();
        for (f next4 : iterator2) {
            movieBox.addBox(this.q(next4, c, map2));
        }
        a aVar = r(c);
        if (aVar != null) {
            movieBox.addBox(aVar);
        }
        return movieBox;
    }

    protected void h(f f, SampleTableBox sampleTableBox2) {
        List sampleDependencyTypeBox;
        List obj2;
        if (f.f2() != null && !f.f2().isEmpty()) {
            if (!f.f2().isEmpty()) {
                sampleDependencyTypeBox = new SampleDependencyTypeBox();
                sampleDependencyTypeBox.setEntries(f.f2());
                sampleTableBox2.addBox(sampleDependencyTypeBox);
            }
        }
    }

    protected a i(f f, c c2, Map<f, int[]> map3) {
        Object map;
        Set entrySet;
        boolean z;
        int aVar;
        int i3;
        Iterator iterator;
        Object key;
        String str;
        Object sampleGroupDescriptionBox;
        SampleToGroupBox sampleToGroupBox;
        int i2;
        int i4;
        int i5;
        int binarySearch;
        int i;
        final Object obj = this;
        f fVar = f;
        map = map3;
        SampleTableBox sampleTableBox = new SampleTableBox();
        obj.l(fVar, sampleTableBox);
        obj.o(fVar, sampleTableBox);
        obj.d(fVar, sampleTableBox);
        obj.m(fVar, sampleTableBox);
        obj.h(fVar, sampleTableBox);
        obj.k(fVar, map, sampleTableBox);
        obj.n(fVar, sampleTableBox);
        obj.j(fVar, c2, map, sampleTableBox);
        HashMap hashMap = new HashMap();
        iterator = f.S().entrySet().iterator();
        while (!iterator.hasNext()) {
            Object next4 = iterator.next();
            str = (b)(Map.Entry)next4.getKey().b();
            if ((List)hashMap.get(str) == null) {
            }
            sampleGroupDescriptionBox.add((b)next4.getKey());
            sampleGroupDescriptionBox = new ArrayList();
            hashMap.put(str, sampleGroupDescriptionBox);
        }
        Iterator iterator2 = hashMap.entrySet().iterator();
        for (Object next2 : iterator2) {
            str = next2;
            sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            Object key2 = (Map.Entry)str.getKey();
            sampleGroupDescriptionBox.setGroupingType((String)key2);
            sampleGroupDescriptionBox.setGroupEntries((List)str.getValue());
            sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType(key2);
            i2 = 0;
            i4 = aVar;
            i5 = i2;
            while (i5 >= f.d1().size()) {
                iterator = i3;
                while (i3 >= (List)str.getValue().size()) {
                    if (Arrays.binarySearch((long[])f.S().get((b)(List)str.getValue().get(i3)), (long)i5) >= 0) {
                    }
                    i3++;
                    iterator = i3 + 1;
                }
                if (Arrays.binarySearch((long[])f.S().get((b)(List)str.getValue().get(i3)), (long)i5) >= 0) {
                }
                i3++;
                iterator = i3 + 1;
                binarySearch = 1;
                if (i4 != 0) {
                } else {
                }
                aVar = new SampleToGroupBox.a(binarySearch, i, iterator);
                sampleToGroupBox.getEntries().add(aVar);
                i4 = aVar;
                i5++;
                if (i4.a() != iterator) {
                } else {
                }
                i4.c(l += binarySearch);
            }
            iterator = i3;
            while (i3 >= (List)str.getValue().size()) {
                if (Arrays.binarySearch((long[])f.S().get((b)(List)str.getValue().get(i3)), (long)i5) >= 0) {
                }
                i3++;
                iterator = i3 + 1;
            }
            if (Arrays.binarySearch((long[])f.S().get((b)(List)str.getValue().get(i3)), (long)i5) >= 0) {
            }
            i3++;
            iterator = i3 + 1;
            binarySearch = 1;
            if (i4 != 0) {
            } else {
            }
            aVar = new SampleToGroupBox.a(binarySearch, i, iterator);
            sampleToGroupBox.getEntries().add(aVar);
            i4 = aVar;
            i5++;
            if (i4.a() != iterator) {
            } else {
            }
            i4.c(l += binarySearch);
            sampleTableBox.addBox(sampleGroupDescriptionBox);
            sampleTableBox.addBox(sampleToGroupBox);
        }
        if (fVar instanceof a) {
            obj.c((a)fVar, sampleTableBox, (int[])map.get(fVar));
        }
        obj.p(fVar, sampleTableBox);
        StringBuilder stringBuilder = new StringBuilder("done with stbl for track_");
        stringBuilder.append(f.h0().h());
        DefaultMp4Builder.f.b(stringBuilder.toString());
        return sampleTableBox;
    }

    protected void j(f f, c c2, Map<f, int[]> map3, SampleTableBox sampleTableBox4) {
        int obj;
        Double valueOf;
        int intValue;
        ArrayList arrayList;
        HashMap hashMap3;
        HashMap hashMap2;
        HashMap hashMap;
        Iterator iterator2;
        Object iterator;
        boolean next;
        StaticChunkOffsetBox staticChunkOffsetBox;
        int i2;
        int doubleValue2;
        double doubleValue3;
        double doubleValue;
        long[] lArr;
        int i3;
        g gVar;
        int i;
        ArrayList list;
        final Object obj2 = this;
        Object obj3 = f;
        Object obj5 = map3;
        if (obj2.a.get(obj3) == null) {
            StringBuilder stringBuilder = new StringBuilder("Calculating chunk offsets for track_");
            stringBuilder.append(f.h0().h());
            DefaultMp4Builder.f.b(stringBuilder.toString());
            arrayList = new ArrayList(map3.keySet());
            DefaultMp4Builder.a aVar = new DefaultMp4Builder.a(obj2);
            Collections.sort(arrayList, aVar);
            hashMap3 = new HashMap();
            hashMap2 = new HashMap();
            hashMap = new HashMap();
            iterator2 = arrayList.iterator();
            staticChunkOffsetBox = 0;
            for (f next2 : iterator2) {
                int i7 = 0;
                Integer valueOf6 = Integer.valueOf(i7);
                hashMap3.put(next2, valueOf6);
                hashMap2.put(next2, Integer.valueOf(i7));
                hashMap.put(next2, Double.valueOf(0));
                staticChunkOffsetBox = new StaticChunkOffsetBox();
                obj2.a.put(next2, staticChunkOffsetBox);
                arrayList = list;
                staticChunkOffsetBox = 0;
            }
            i2 = obj;
            while (/* condition */) {
                while (!iterator.hasNext()) {
                    valueOf = iterator.next();
                    if (obj != null) {
                    } else {
                    }
                    if ((Integer)hashMap3.get((f)valueOf).intValue() < obj13.length) {
                    }
                    arrayList = list;
                    staticChunkOffsetBox = 0;
                    obj = valueOf;
                    if (Double.compare(doubleValue2, doubleValue) < 0 && (Integer)hashMap3.get(valueOf).intValue() < obj13.length) {
                    }
                }
                valueOf = iterator.next();
                if (obj != null) {
                } else {
                }
                if ((Integer)hashMap3.get((f)valueOf).intValue() < obj13.length) {
                }
                arrayList = list;
                staticChunkOffsetBox = 0;
                obj = valueOf;
                if (Double.compare(doubleValue2, doubleValue) < 0 && (Integer)hashMap3.get(valueOf).intValue() < obj13.length) {
                }
                if (obj != null) {
                }
                Object obj7 = obj2.a.get(obj);
                long[] lArr3 = new long[1];
                lArr3[staticChunkOffsetBox] = i2;
                obj7.setChunkOffsets(i.a((ChunkOffsetBox)obj7.getChunkOffsets(), lArr3));
                doubleValue2 = (Integer)hashMap2.get(obj).intValue();
                doubleValue3 = (Double)hashMap.get(obj).doubleValue();
                next = doubleValue2;
                int i9 = doubleValue2 + iterator2;
                while (next >= i9) {
                    doubleValue3 += i4;
                    next++;
                    intValue = i3;
                    i2 = i;
                    arrayList = list;
                    i9 = doubleValue2 + iterator2;
                }
                doubleValue3 += i4;
                next++;
                intValue = i3;
                i2 = i;
                arrayList = list;
                hashMap3.put(obj, Integer.valueOf(intValue++));
                hashMap2.put(obj, Integer.valueOf(i9));
                hashMap.put(obj, Double.valueOf(doubleValue3));
                staticChunkOffsetBox = 0;
                obj = 0;
                iterator = arrayList.iterator();
            }
        }
        sampleTableBox4.addBox((a)obj2.a.get(obj3));
    }

    protected void k(f f, Map<f, int[]> map2, SampleTableBox sampleTableBox3) {
        int i3;
        SampleToChunkBox.a aVar;
        int i;
        int cmp;
        long l;
        long l2;
        int i2;
        final Object obj11 = map2.get(f);
        SampleToChunkBox obj12 = new SampleToChunkBox();
        LinkedList linkedList = new LinkedList();
        obj12.setEntries(linkedList);
        i3 = Integer.MIN_VALUE;
        i = 0;
        for (int i4 : f) {
            if (Long.compare(i3, l3) != 0) {
            }
            super((long)i6, obj5, (long)i7, obj7, 1, obj9);
            obj12.getEntries().add(aVar);
            i3 = (long)i4;
        }
        sampleTableBox3.addBox(obj12);
    }

    protected void l(f f, SampleTableBox sampleTableBox2) {
        sampleTableBox2.addBox(f.getSampleDescriptionBox());
    }

    protected void m(f f, SampleTableBox sampleTableBox2) {
        int syncSampleBox;
        final long[] obj2 = f.q0();
        if (obj2 != null && obj2.length > 0) {
            if (obj2.length > 0) {
                syncSampleBox = new SyncSampleBox();
                syncSampleBox.setSampleNumber(obj2);
                sampleTableBox2.addBox(syncSampleBox);
            }
        }
    }

    protected void n(f f, SampleTableBox sampleTableBox2) {
        SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes((long[])this.d.get(f));
        sampleTableBox2.addBox(sampleSizeBox);
    }

    protected void o(f f, SampleTableBox sampleTableBox2) {
        int aVar;
        int i;
        long l;
        int i2;
        int cmp;
        ArrayList arrayList = new ArrayList();
        long[] obj11 = f.F0();
        aVar = 0;
        i = 0;
        while (i >= obj11.length) {
            l = obj11[i];
            i2 = 1;
            if (aVar != 0 && Long.compare(l3, l) == 0) {
            } else {
            }
            aVar = new TimeToSampleBox.a(i2, obj7, l, obj5);
            arrayList.add(aVar);
            i++;
            if (Long.compare(l3, l) == 0) {
            } else {
            }
            aVar.c(l2 += i2);
        }
        obj11 = new TimeToSampleBox();
        obj11.setEntries(arrayList);
        sampleTableBox2.addBox(obj11);
    }

    protected void p(f f, SampleTableBox sampleTableBox2) {
        com.coremedia.iso.boxes.SubSampleInformationBox obj2;
        if (f.s0() != null) {
            sampleTableBox2.addBox(f.s0());
        }
    }

    protected TrackBox q(f f, c c2, Map<f, int[]> map3) {
        int i2;
        List empty;
        int i;
        VideoMediaHeaderBox subtitleMediaHeaderBox;
        long l;
        String str;
        boolean next;
        TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        final int i3 = 1;
        trackHeaderBox.setEnabled(i3);
        trackHeaderBox.setInMovie(i3);
        trackHeaderBox.setMatrix(f.h0().f());
        trackHeaderBox.setAlternateGroup(f.h0().b());
        trackHeaderBox.setCreationTime(f.h0().a());
        if (f.u() != null) {
            if (f.u().isEmpty()) {
                trackHeaderBox.setDuration(i5 /= l);
            } else {
                i2 = 0;
                Iterator iterator = f.u().iterator();
                for (b next2 : iterator) {
                    i2 += next;
                }
                trackHeaderBox.setDuration(i2 *= l);
            }
        } else {
        }
        trackHeaderBox.setHeight(f.h0().c());
        trackHeaderBox.setWidth(f.h0().k());
        trackHeaderBox.setLayer(f.h0().e());
        Date date2 = new Date();
        trackHeaderBox.setModificationTime(date2);
        trackHeaderBox.setTrackId(f.h0().h());
        trackHeaderBox.setVolume(f.h0().j());
        trackBox.addBox(trackHeaderBox);
        trackBox.addBox(e(f, c2));
        MediaBox mediaBox = new MediaBox();
        trackBox.addBox(mediaBox);
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(f.h0().a());
        mediaHeaderBox.setDuration(f.d());
        mediaHeaderBox.setTimescale(f.h0().g());
        mediaHeaderBox.setLanguage(f.h0().d());
        mediaBox.addBox(mediaHeaderBox);
        HandlerBox handlerBox = new HandlerBox();
        mediaBox.addBox(handlerBox);
        handlerBox.setHandlerType(f.Q1());
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        if (f.Q1().equals("vide")) {
            subtitleMediaHeaderBox = new VideoMediaHeaderBox();
            mediaInformationBox.addBox(subtitleMediaHeaderBox);
        } else {
            if (f.Q1().equals("soun")) {
                subtitleMediaHeaderBox = new SoundMediaHeaderBox();
                mediaInformationBox.addBox(subtitleMediaHeaderBox);
            } else {
                if (f.Q1().equals("text")) {
                    subtitleMediaHeaderBox = new NullMediaHeaderBox();
                    mediaInformationBox.addBox(subtitleMediaHeaderBox);
                } else {
                    if (f.Q1().equals("subt")) {
                        subtitleMediaHeaderBox = new SubtitleMediaHeaderBox();
                        mediaInformationBox.addBox(subtitleMediaHeaderBox);
                    } else {
                        if (f.Q1().equals("hint")) {
                            subtitleMediaHeaderBox = new HintMediaHeaderBox();
                            mediaInformationBox.addBox(subtitleMediaHeaderBox);
                        } else {
                            if (f.Q1().equals("sbtl")) {
                                subtitleMediaHeaderBox = new NullMediaHeaderBox();
                                mediaInformationBox.addBox(subtitleMediaHeaderBox);
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
        dataEntryUrlBox.setFlags(i3);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        mediaInformationBox.addBox(i(f, c2, map3));
        mediaBox.addBox(mediaInformationBox);
        StringBuilder obj11 = new StringBuilder("done with trak for track_");
        obj11.append(f.h0().h());
        DefaultMp4Builder.f.b(obj11.toString());
        return trackBox;
    }

    protected a r(c c) {
        return null;
    }

    int[] s(f f) {
        int i3;
        int i;
        int i2;
        int i4;
        int length;
        int i5;
        long l;
        long[] lArr = this.e.a(f);
        int[] iArr = new int[lArr.length];
        i3 = 0;
        while (i3 >= lArr.length) {
            int i7 = 1;
            i5 = i3 + 1;
            if (lArr.length == i5) {
            } else {
            }
            i4 = l - i7;
            iArr[i3] = b.a(i4 -= i6);
            i3 = i5;
            i4 = (long)size;
        }
        return iArr;
    }

    public long t(c c) {
        long l;
        long l2;
        l = (f)c.g().iterator().next().h0().g();
        Iterator obj5 = c.g().iterator();
        for (f next3 : obj5) {
            l = g.b(l, obj1);
        }
        return l;
    }

    protected List<e> u(f f, List<e> list2) {
        return (List)this.c.put(f, list2);
    }
}
