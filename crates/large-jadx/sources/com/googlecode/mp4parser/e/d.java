package com.googlecode.mp4parser.e;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.CompositionTimeToSample.a;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.EditListBox.a;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox.a;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.SubSampleInformationBox.a;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox.a;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox.a;
import com.coremedia.iso.boxes.fragment.a;
import com.coremedia.iso.boxes.mdat.a;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import com.googlecode.mp4parser.h.b;
import com.googlecode.mp4parser.h.i;
import com.googlecode.mp4parser.h.j;
import f.b.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class d extends com.googlecode.mp4parser.e.a {

    private long[] A;
    private List<SampleDependencyTypeBox.a> B;
    private com.googlecode.mp4parser.e.g C;
    private String D;
    private SubSampleInformationBox E;
    TrackBox c;
    d[] v;
    private List<com.googlecode.mp4parser.e.e> w;
    private SampleDescriptionBox x;
    private long[] y;
    private List<CompositionTimeToSample.a> z;
    static {
        final Class<com.googlecode.mp4parser.e.d> obj = d.class;
    }

    public d(String string, TrackBox trackBox2, d... d3Arr3) {
        boolean next;
        MediaHeaderBox mediaHeaderBox;
        List boxes2;
        List iterator2;
        int subSampleInformationBox;
        Object iterator8;
        Object compositionTimeToSample;
        Object sampleDependencyTypeBox;
        SyncSampleBox syncSampleBox;
        List boxes4;
        Object iterator4;
        List boxes3;
        Object gVar;
        int trackFragmentHeaderBox;
        List boxes;
        com.googlecode.mp4parser.h.h matrix;
        List iterator6;
        int entries;
        ArrayList firstSampleFlagsPresent;
        a defaultSampleFlags;
        int bVar;
        int i2;
        int i;
        int size2;
        boolean sampleCompositionTimeOffsetPresent;
        double aVar;
        Object obj2;
        TrackBox trackBox;
        Map obj;
        long trackId;
        long timescale;
        int size;
        ArrayList arrayList2;
        String str2;
        long defaultSampleDuration;
        ArrayList arrayList;
        Iterator iterator5;
        Iterator iterator7;
        Object obj3;
        Iterator iterator;
        Iterator iterator3;
        List list;
        List cmp;
        int i3;
        String str;
        long l;
        ArrayList list2;
        String obj31;
        Object obj32;
        d[] obj33;
        obj2 = this;
        trackBox = trackBox2;
        d[] objArr = d3Arr3;
        obj = SampleGroupDescriptionBox.class;
        super(string);
        int i4 = 0;
        obj2.A = i4;
        gVar = new g();
        obj2.C = gVar;
        obj2.E = i4;
        obj2.c = trackBox;
        trackId = trackBox2.getTrackHeaderBox().getTrackId();
        a aVar2 = new a(trackBox, objArr);
        obj2.w = aVar2;
        final SampleTableBox sampleTableBox = trackBox2.getMediaBox().getMediaInformationBox().getSampleTableBox();
        obj2.D = trackBox2.getMediaBox().getHandlerBox().getHandlerType();
        arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        obj2.z = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        obj2.B = arrayList4;
        arrayList2.addAll(sampleTableBox.getTimeToSampleBox().getEntries());
        if (sampleTableBox.getCompositionTimeToSample() != null) {
            obj2.z.addAll(sampleTableBox.getCompositionTimeToSample().getEntries());
        }
        if (sampleTableBox.getSampleDependencyTypeBox() != null) {
            obj2.B.addAll(sampleTableBox.getSampleDependencyTypeBox().getEntries());
        }
        if (sampleTableBox.getSyncSampleBox() != null) {
            obj2.A = sampleTableBox.getSyncSampleBox().getSampleNumber();
        }
        str2 = "subs";
        obj2.E = (SubSampleInformationBox)j.c(sampleTableBox, str2);
        arrayList = new ArrayList();
        arrayList.addAll((a)trackBox2.getParent().getParent().getBoxes(MovieFragmentBox.class));
        bVar = 0;
        trackFragmentHeaderBox = bVar;
        while (trackFragmentHeaderBox >= objArr.length) {
            str = str2;
            int i10 = bVar;
            firstSampleFlagsPresent = list2;
            firstSampleFlagsPresent.addAll(objArr[trackFragmentHeaderBox].getBoxes(MovieFragmentBox.class));
            trackFragmentHeaderBox++;
            obj2 = this;
            arrayList = firstSampleFlagsPresent;
            trackId = l;
        }
        obj2.x = sampleTableBox.getSampleDescriptionBox();
        boxes2 = trackBox2.getParent().getBoxes(MovieExtendsBox.class);
        if (boxes2.size() > 0) {
            iterator5 = boxes2.iterator();
            for (MovieExtendsBox next2 : iterator5) {
                iterator7 = next2.getBoxes(TrackExtendsBox.class).iterator();
                while (iterator7.hasNext() == null) {
                    obj3 = next3;
                    if (Long.compare(trackId2, trackId) == null && j.f((a)trackBox2.getParent().getParent(), "/moof/traf/subs").size() > 0) {
                    }
                    if (j.f((a)trackBox2.getParent().getParent(), "/moof/traf/subs").size() > 0) {
                    }
                    iterator = arrayList.iterator();
                    iterator2 = boxes;
                    for (MovieFragmentBox next6 : iterator) {
                        iterator3 = next6.getBoxes(TrackFragmentBox.class).iterator();
                        list = iterator2;
                        while (!iterator3.hasNext()) {
                            aVar = next5;
                            trackFragmentHeaderBox = j.f(aVar, "sgpd");
                            obj31 = map;
                            int i11 = boxes;
                            int i12 = bVar;
                            timescale = aVar;
                            this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                            obj2.b = obj31;
                            iterator8 = j.c(timescale, str2);
                            if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                            }
                            trackFragmentHeaderBox = j.f(aVar, "sgpd");
                            obj31 = map;
                            i11 = boxes;
                            i12 = bVar;
                            timescale = aVar;
                            this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                            obj2.b = obj31;
                            iterator8 = j.c(timescale, str2);
                            if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                            }
                            iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                            for (TrackRunBox boxes3 : iterator2) {
                                trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                                iterator6 = boxes3.getEntries().iterator();
                                firstSampleFlagsPresent = i2;
                                while (iterator6.hasNext() == null) {
                                    aVar = iterator6.next();
                                    if (boxes3.isSampleDurationPresent()) {
                                    } else {
                                    }
                                    obj33 = aVar;
                                    str = str2;
                                    list2 = arrayList;
                                    i = 1;
                                    if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                    } else {
                                    }
                                    timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                                    arrayList2.add(timescale);
                                    if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                                    }
                                    if (boxes3.isSampleFlagsPresent()) {
                                    } else {
                                    }
                                    if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                                    } else {
                                    }
                                    if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                    } else {
                                    }
                                    defaultSampleFlags = obj3.getDefaultSampleFlags();
                                    if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                                    } else {
                                    }
                                    i2 = 1;
                                    list += i15;
                                    firstSampleFlagsPresent = i12;
                                    str2 = str;
                                    arrayList = list2;
                                    if (!defaultSampleFlags.b()) {
                                    } else {
                                    }
                                    aVar = new long[1];
                                    aVar[i12] = list;
                                    obj2.A = i.a(obj2.A, aVar);
                                    defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                    if (boxes3.isFirstSampleFlagsPresent()) {
                                    } else {
                                    }
                                    defaultSampleFlags = boxes3.getFirstSampleFlags();
                                    defaultSampleFlags = obj33.k();
                                    if (obj2.z.size() != 0) {
                                    } else {
                                    }
                                    timescale = 1;
                                    aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                                    obj2.z.add(aVar);
                                    List list5 = obj2.z;
                                    timescale = 1;
                                    if (Long.compare(l4, defaultSampleDuration) != 0) {
                                    } else {
                                    }
                                    List list6 = obj2.z;
                                    sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                                    sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                                    timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                                    arrayList2.add(timescale);
                                    if (arrayList2.size() != 0) {
                                    } else {
                                    }
                                    str = str2;
                                    list2 = arrayList;
                                    timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                                    arrayList2.add(timescale);
                                    if (Long.compare(cmp, list2) != 0) {
                                    } else {
                                    }
                                    timescale = arrayList2.get(size6 -= i2);
                                    obj33 = aVar;
                                    str = str2;
                                    list2 = arrayList;
                                    timescale.c(cmp + i);
                                }
                                aVar = iterator6.next();
                                if (boxes3.isSampleDurationPresent()) {
                                } else {
                                }
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                i = 1;
                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                } else {
                                }
                                timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                                }
                                if (boxes3.isSampleFlagsPresent()) {
                                } else {
                                }
                                if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                } else {
                                }
                                defaultSampleFlags = obj3.getDefaultSampleFlags();
                                if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                                } else {
                                }
                                i2 = 1;
                                list += i15;
                                firstSampleFlagsPresent = i12;
                                str2 = str;
                                arrayList = list2;
                                if (!defaultSampleFlags.b()) {
                                } else {
                                }
                                aVar = new long[1];
                                aVar[i12] = list;
                                obj2.A = i.a(obj2.A, aVar);
                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                if (boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                defaultSampleFlags = boxes3.getFirstSampleFlags();
                                defaultSampleFlags = obj33.k();
                                if (obj2.z.size() != 0) {
                                } else {
                                }
                                timescale = 1;
                                aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                                obj2.z.add(aVar);
                                list5 = obj2.z;
                                timescale = 1;
                                if (Long.compare(l4, defaultSampleDuration) != 0) {
                                } else {
                                }
                                list6 = obj2.z;
                                sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                                sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                                timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (arrayList2.size() != 0) {
                                } else {
                                }
                                str = str2;
                                list2 = arrayList;
                                timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                                arrayList2.add(timescale);
                                if (Long.compare(cmp, list2) != 0) {
                                } else {
                                }
                                timescale = arrayList2.get(size6 -= i2);
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                timescale.c(cmp + i);
                            }
                            boxes3 = iterator2.next();
                            trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                            iterator6 = boxes3.getEntries().iterator();
                            firstSampleFlagsPresent = i2;
                            while (iterator6.hasNext() == null) {
                                aVar = iterator6.next();
                                if (boxes3.isSampleDurationPresent()) {
                                } else {
                                }
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                i = 1;
                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                } else {
                                }
                                timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                                }
                                if (boxes3.isSampleFlagsPresent()) {
                                } else {
                                }
                                if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                } else {
                                }
                                defaultSampleFlags = obj3.getDefaultSampleFlags();
                                if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                                } else {
                                }
                                i2 = 1;
                                list += i15;
                                firstSampleFlagsPresent = i12;
                                str2 = str;
                                arrayList = list2;
                                if (!defaultSampleFlags.b()) {
                                } else {
                                }
                                aVar = new long[1];
                                aVar[i12] = list;
                                obj2.A = i.a(obj2.A, aVar);
                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                if (boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                defaultSampleFlags = boxes3.getFirstSampleFlags();
                                defaultSampleFlags = obj33.k();
                                if (obj2.z.size() != 0) {
                                } else {
                                }
                                timescale = 1;
                                aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                                obj2.z.add(aVar);
                                list5 = obj2.z;
                                timescale = 1;
                                if (Long.compare(l4, defaultSampleDuration) != 0) {
                                } else {
                                }
                                list6 = obj2.z;
                                sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                                sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                                timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (arrayList2.size() != 0) {
                                } else {
                                }
                                str = str2;
                                list2 = arrayList;
                                timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                                arrayList2.add(timescale);
                                if (Long.compare(cmp, list2) != 0) {
                                } else {
                                }
                                timescale = arrayList2.get(size6 -= i2);
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                timescale.c(cmp + i);
                            }
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                            bVar = i12;
                            trackId = l;
                            boxes = 1;
                            i5 -= entries;
                            iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                            while (!iterator8.hasNext()) {
                                Object next7 = iterator8.next();
                                firstSampleFlagsPresent = new SubSampleInformationBox.a();
                                aVar = (SubSampleInformationBox.a)next7.c();
                                firstSampleFlagsPresent.c().addAll(aVar);
                                i2 = 0;
                                if (Long.compare(boxes3, i2) != 0) {
                                } else {
                                }
                                firstSampleFlagsPresent.d(next7.a());
                                obj2.E.getEntries().add(firstSampleFlagsPresent);
                                firstSampleFlagsPresent.d(boxes3 += cmp);
                                boxes3 = i2;
                            }
                            next7 = iterator8.next();
                            firstSampleFlagsPresent = new SubSampleInformationBox.a();
                            aVar = (SubSampleInformationBox.a)next7.c();
                            firstSampleFlagsPresent.c().addAll(aVar);
                            i2 = 0;
                            if (Long.compare(boxes3, i2) != 0) {
                            } else {
                            }
                            firstSampleFlagsPresent.d(next7.a());
                            obj2.E.getEntries().add(firstSampleFlagsPresent);
                            firstSampleFlagsPresent.d(boxes3 += cmp);
                            boxes3 = i2;
                        }
                        aVar = next5;
                        trackFragmentHeaderBox = j.f(aVar, "sgpd");
                        obj31 = map;
                        i11 = boxes;
                        i12 = bVar;
                        timescale = aVar;
                        this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                        obj2.b = obj31;
                        iterator8 = j.c(timescale, str2);
                        if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                        }
                        trackFragmentHeaderBox = j.f(aVar, "sgpd");
                        obj31 = map;
                        i11 = boxes;
                        i12 = bVar;
                        timescale = aVar;
                        this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                        obj2.b = obj31;
                        iterator8 = j.c(timescale, str2);
                        if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                        }
                        iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                        for (TrackRunBox boxes3 : iterator2) {
                            trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                            iterator6 = boxes3.getEntries().iterator();
                            firstSampleFlagsPresent = i2;
                            while (iterator6.hasNext() == null) {
                                aVar = iterator6.next();
                                if (boxes3.isSampleDurationPresent()) {
                                } else {
                                }
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                i = 1;
                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                } else {
                                }
                                timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                                }
                                if (boxes3.isSampleFlagsPresent()) {
                                } else {
                                }
                                if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                } else {
                                }
                                defaultSampleFlags = obj3.getDefaultSampleFlags();
                                if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                                } else {
                                }
                                i2 = 1;
                                list += i15;
                                firstSampleFlagsPresent = i12;
                                str2 = str;
                                arrayList = list2;
                                if (!defaultSampleFlags.b()) {
                                } else {
                                }
                                aVar = new long[1];
                                aVar[i12] = list;
                                obj2.A = i.a(obj2.A, aVar);
                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                if (boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                defaultSampleFlags = boxes3.getFirstSampleFlags();
                                defaultSampleFlags = obj33.k();
                                if (obj2.z.size() != 0) {
                                } else {
                                }
                                timescale = 1;
                                aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                                obj2.z.add(aVar);
                                list5 = obj2.z;
                                timescale = 1;
                                if (Long.compare(l4, defaultSampleDuration) != 0) {
                                } else {
                                }
                                list6 = obj2.z;
                                sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                                sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                                timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (arrayList2.size() != 0) {
                                } else {
                                }
                                str = str2;
                                list2 = arrayList;
                                timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                                arrayList2.add(timescale);
                                if (Long.compare(cmp, list2) != 0) {
                                } else {
                                }
                                timescale = arrayList2.get(size6 -= i2);
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                timescale.c(cmp + i);
                            }
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        boxes3 = iterator2.next();
                        trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                        iterator6 = boxes3.getEntries().iterator();
                        firstSampleFlagsPresent = i2;
                        while (iterator6.hasNext() == null) {
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                        bVar = i12;
                        trackId = l;
                        boxes = 1;
                        i5 -= entries;
                        iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                        while (!iterator8.hasNext()) {
                            next7 = iterator8.next();
                            firstSampleFlagsPresent = new SubSampleInformationBox.a();
                            aVar = (SubSampleInformationBox.a)next7.c();
                            firstSampleFlagsPresent.c().addAll(aVar);
                            i2 = 0;
                            if (Long.compare(boxes3, i2) != 0) {
                            } else {
                            }
                            firstSampleFlagsPresent.d(next7.a());
                            obj2.E.getEntries().add(firstSampleFlagsPresent);
                            firstSampleFlagsPresent.d(boxes3 += cmp);
                            boxes3 = i2;
                        }
                        next7 = iterator8.next();
                        firstSampleFlagsPresent = new SubSampleInformationBox.a();
                        aVar = (SubSampleInformationBox.a)next7.c();
                        firstSampleFlagsPresent.c().addAll(aVar);
                        i2 = 0;
                        if (Long.compare(boxes3, i2) != 0) {
                        } else {
                        }
                        firstSampleFlagsPresent.d(next7.a());
                        obj2.E.getEntries().add(firstSampleFlagsPresent);
                        firstSampleFlagsPresent.d(boxes3 += cmp);
                        boxes3 = i2;
                        iterator2 = list;
                    }
                    iterator3 = (MovieFragmentBox)iterator.next().getBoxes(TrackFragmentBox.class).iterator();
                    list = iterator2;
                    while (!iterator3.hasNext()) {
                        aVar = next5;
                        trackFragmentHeaderBox = j.f(aVar, "sgpd");
                        obj31 = map;
                        i11 = boxes;
                        i12 = bVar;
                        timescale = aVar;
                        this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                        obj2.b = obj31;
                        iterator8 = j.c(timescale, str2);
                        if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                        }
                        trackFragmentHeaderBox = j.f(aVar, "sgpd");
                        obj31 = map;
                        i11 = boxes;
                        i12 = bVar;
                        timescale = aVar;
                        this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                        obj2.b = obj31;
                        iterator8 = j.c(timescale, str2);
                        if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                        }
                        iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                        for (TrackRunBox boxes3 : iterator2) {
                            trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                            iterator6 = boxes3.getEntries().iterator();
                            firstSampleFlagsPresent = i2;
                            while (iterator6.hasNext() == null) {
                                aVar = iterator6.next();
                                if (boxes3.isSampleDurationPresent()) {
                                } else {
                                }
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                i = 1;
                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                } else {
                                }
                                timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                                }
                                if (boxes3.isSampleFlagsPresent()) {
                                } else {
                                }
                                if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                } else {
                                }
                                defaultSampleFlags = obj3.getDefaultSampleFlags();
                                if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                                } else {
                                }
                                i2 = 1;
                                list += i15;
                                firstSampleFlagsPresent = i12;
                                str2 = str;
                                arrayList = list2;
                                if (!defaultSampleFlags.b()) {
                                } else {
                                }
                                aVar = new long[1];
                                aVar[i12] = list;
                                obj2.A = i.a(obj2.A, aVar);
                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                if (boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                defaultSampleFlags = boxes3.getFirstSampleFlags();
                                defaultSampleFlags = obj33.k();
                                if (obj2.z.size() != 0) {
                                } else {
                                }
                                timescale = 1;
                                aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                                obj2.z.add(aVar);
                                list5 = obj2.z;
                                timescale = 1;
                                if (Long.compare(l4, defaultSampleDuration) != 0) {
                                } else {
                                }
                                list6 = obj2.z;
                                sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                                sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                                timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (arrayList2.size() != 0) {
                                } else {
                                }
                                str = str2;
                                list2 = arrayList;
                                timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                                arrayList2.add(timescale);
                                if (Long.compare(cmp, list2) != 0) {
                                } else {
                                }
                                timescale = arrayList2.get(size6 -= i2);
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                timescale.c(cmp + i);
                            }
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        boxes3 = iterator2.next();
                        trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                        iterator6 = boxes3.getEntries().iterator();
                        firstSampleFlagsPresent = i2;
                        while (iterator6.hasNext() == null) {
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                        bVar = i12;
                        trackId = l;
                        boxes = 1;
                        i5 -= entries;
                        iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                        while (!iterator8.hasNext()) {
                            next7 = iterator8.next();
                            firstSampleFlagsPresent = new SubSampleInformationBox.a();
                            aVar = (SubSampleInformationBox.a)next7.c();
                            firstSampleFlagsPresent.c().addAll(aVar);
                            i2 = 0;
                            if (Long.compare(boxes3, i2) != 0) {
                            } else {
                            }
                            firstSampleFlagsPresent.d(next7.a());
                            obj2.E.getEntries().add(firstSampleFlagsPresent);
                            firstSampleFlagsPresent.d(boxes3 += cmp);
                            boxes3 = i2;
                        }
                        next7 = iterator8.next();
                        firstSampleFlagsPresent = new SubSampleInformationBox.a();
                        aVar = (SubSampleInformationBox.a)next7.c();
                        firstSampleFlagsPresent.c().addAll(aVar);
                        i2 = 0;
                        if (Long.compare(boxes3, i2) != 0) {
                        } else {
                        }
                        firstSampleFlagsPresent.d(next7.a());
                        obj2.E.getEntries().add(firstSampleFlagsPresent);
                        firstSampleFlagsPresent.d(boxes3 += cmp);
                        boxes3 = i2;
                    }
                    aVar = next5;
                    trackFragmentHeaderBox = j.f(aVar, "sgpd");
                    obj31 = map;
                    i11 = boxes;
                    i12 = bVar;
                    timescale = aVar;
                    this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                    obj2.b = obj31;
                    iterator8 = j.c(timescale, str2);
                    if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                    }
                    trackFragmentHeaderBox = j.f(aVar, "sgpd");
                    obj31 = map;
                    i11 = boxes;
                    i12 = bVar;
                    timescale = aVar;
                    this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                    obj2.b = obj31;
                    iterator8 = j.c(timescale, str2);
                    if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                    }
                    iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                    for (TrackRunBox boxes3 : iterator2) {
                        trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                        iterator6 = boxes3.getEntries().iterator();
                        firstSampleFlagsPresent = i2;
                        while (iterator6.hasNext() == null) {
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                    }
                    boxes3 = iterator2.next();
                    trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                    iterator6 = boxes3.getEntries().iterator();
                    firstSampleFlagsPresent = i2;
                    while (iterator6.hasNext() == null) {
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                    }
                    aVar = iterator6.next();
                    if (boxes3.isSampleDurationPresent()) {
                    } else {
                    }
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    i = 1;
                    if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                    } else {
                    }
                    timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                    }
                    if (boxes3.isSampleFlagsPresent()) {
                    } else {
                    }
                    if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                    } else {
                    }
                    defaultSampleFlags = obj3.getDefaultSampleFlags();
                    if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                    } else {
                    }
                    i2 = 1;
                    list += i15;
                    firstSampleFlagsPresent = i12;
                    str2 = str;
                    arrayList = list2;
                    if (!defaultSampleFlags.b()) {
                    } else {
                    }
                    aVar = new long[1];
                    aVar[i12] = list;
                    obj2.A = i.a(obj2.A, aVar);
                    defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                    if (boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    defaultSampleFlags = boxes3.getFirstSampleFlags();
                    defaultSampleFlags = obj33.k();
                    if (obj2.z.size() != 0) {
                    } else {
                    }
                    timescale = 1;
                    aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                    obj2.z.add(aVar);
                    list5 = obj2.z;
                    timescale = 1;
                    if (Long.compare(l4, defaultSampleDuration) != 0) {
                    } else {
                    }
                    list6 = obj2.z;
                    sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                    sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                    timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (arrayList2.size() != 0) {
                    } else {
                    }
                    str = str2;
                    list2 = arrayList;
                    timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                    arrayList2.add(timescale);
                    if (Long.compare(cmp, list2) != 0) {
                    } else {
                    }
                    timescale = arrayList2.get(size6 -= i2);
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    timescale.c(cmp + i);
                    bVar = i12;
                    trackId = l;
                    boxes = 1;
                    i5 -= entries;
                    iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                    while (!iterator8.hasNext()) {
                        next7 = iterator8.next();
                        firstSampleFlagsPresent = new SubSampleInformationBox.a();
                        aVar = (SubSampleInformationBox.a)next7.c();
                        firstSampleFlagsPresent.c().addAll(aVar);
                        i2 = 0;
                        if (Long.compare(boxes3, i2) != 0) {
                        } else {
                        }
                        firstSampleFlagsPresent.d(next7.a());
                        obj2.E.getEntries().add(firstSampleFlagsPresent);
                        firstSampleFlagsPresent.d(boxes3 += cmp);
                        boxes3 = i2;
                    }
                    next7 = iterator8.next();
                    firstSampleFlagsPresent = new SubSampleInformationBox.a();
                    aVar = (SubSampleInformationBox.a)next7.c();
                    firstSampleFlagsPresent.c().addAll(aVar);
                    i2 = 0;
                    if (Long.compare(boxes3, i2) != 0) {
                    } else {
                    }
                    firstSampleFlagsPresent.d(next7.a());
                    obj2.E.getEntries().add(firstSampleFlagsPresent);
                    firstSampleFlagsPresent.d(boxes3 += cmp);
                    boxes3 = i2;
                    iterator2 = list;
                    subSampleInformationBox = new SubSampleInformationBox();
                    obj2.E = subSampleInformationBox;
                }
                obj3 = next3;
                if (Long.compare(trackId2, trackId) == null && j.f((a)trackBox2.getParent().getParent(), "/moof/traf/subs").size() > 0) {
                }
                if (j.f((a)trackBox2.getParent().getParent(), "/moof/traf/subs").size() > 0) {
                }
                iterator = arrayList.iterator();
                iterator2 = boxes;
                for (MovieFragmentBox next6 : iterator) {
                    iterator3 = next6.getBoxes(TrackFragmentBox.class).iterator();
                    list = iterator2;
                    while (!iterator3.hasNext()) {
                        aVar = next5;
                        trackFragmentHeaderBox = j.f(aVar, "sgpd");
                        obj31 = map;
                        i11 = boxes;
                        i12 = bVar;
                        timescale = aVar;
                        this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                        obj2.b = obj31;
                        iterator8 = j.c(timescale, str2);
                        if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                        }
                        trackFragmentHeaderBox = j.f(aVar, "sgpd");
                        obj31 = map;
                        i11 = boxes;
                        i12 = bVar;
                        timescale = aVar;
                        this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                        obj2.b = obj31;
                        iterator8 = j.c(timescale, str2);
                        if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                        }
                        iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                        for (TrackRunBox boxes3 : iterator2) {
                            trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                            iterator6 = boxes3.getEntries().iterator();
                            firstSampleFlagsPresent = i2;
                            while (iterator6.hasNext() == null) {
                                aVar = iterator6.next();
                                if (boxes3.isSampleDurationPresent()) {
                                } else {
                                }
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                i = 1;
                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                } else {
                                }
                                timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                                }
                                if (boxes3.isSampleFlagsPresent()) {
                                } else {
                                }
                                if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                } else {
                                }
                                defaultSampleFlags = obj3.getDefaultSampleFlags();
                                if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                                } else {
                                }
                                i2 = 1;
                                list += i15;
                                firstSampleFlagsPresent = i12;
                                str2 = str;
                                arrayList = list2;
                                if (!defaultSampleFlags.b()) {
                                } else {
                                }
                                aVar = new long[1];
                                aVar[i12] = list;
                                obj2.A = i.a(obj2.A, aVar);
                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                if (boxes3.isFirstSampleFlagsPresent()) {
                                } else {
                                }
                                defaultSampleFlags = boxes3.getFirstSampleFlags();
                                defaultSampleFlags = obj33.k();
                                if (obj2.z.size() != 0) {
                                } else {
                                }
                                timescale = 1;
                                aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                                obj2.z.add(aVar);
                                list5 = obj2.z;
                                timescale = 1;
                                if (Long.compare(l4, defaultSampleDuration) != 0) {
                                } else {
                                }
                                list6 = obj2.z;
                                sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                                sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                                timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                                arrayList2.add(timescale);
                                if (arrayList2.size() != 0) {
                                } else {
                                }
                                str = str2;
                                list2 = arrayList;
                                timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                                arrayList2.add(timescale);
                                if (Long.compare(cmp, list2) != 0) {
                                } else {
                                }
                                timescale = arrayList2.get(size6 -= i2);
                                obj33 = aVar;
                                str = str2;
                                list2 = arrayList;
                                timescale.c(cmp + i);
                            }
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        boxes3 = iterator2.next();
                        trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                        iterator6 = boxes3.getEntries().iterator();
                        firstSampleFlagsPresent = i2;
                        while (iterator6.hasNext() == null) {
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                        bVar = i12;
                        trackId = l;
                        boxes = 1;
                        i5 -= entries;
                        iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                        while (!iterator8.hasNext()) {
                            next7 = iterator8.next();
                            firstSampleFlagsPresent = new SubSampleInformationBox.a();
                            aVar = (SubSampleInformationBox.a)next7.c();
                            firstSampleFlagsPresent.c().addAll(aVar);
                            i2 = 0;
                            if (Long.compare(boxes3, i2) != 0) {
                            } else {
                            }
                            firstSampleFlagsPresent.d(next7.a());
                            obj2.E.getEntries().add(firstSampleFlagsPresent);
                            firstSampleFlagsPresent.d(boxes3 += cmp);
                            boxes3 = i2;
                        }
                        next7 = iterator8.next();
                        firstSampleFlagsPresent = new SubSampleInformationBox.a();
                        aVar = (SubSampleInformationBox.a)next7.c();
                        firstSampleFlagsPresent.c().addAll(aVar);
                        i2 = 0;
                        if (Long.compare(boxes3, i2) != 0) {
                        } else {
                        }
                        firstSampleFlagsPresent.d(next7.a());
                        obj2.E.getEntries().add(firstSampleFlagsPresent);
                        firstSampleFlagsPresent.d(boxes3 += cmp);
                        boxes3 = i2;
                    }
                    aVar = next5;
                    trackFragmentHeaderBox = j.f(aVar, "sgpd");
                    obj31 = map;
                    i11 = boxes;
                    i12 = bVar;
                    timescale = aVar;
                    this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                    obj2.b = obj31;
                    iterator8 = j.c(timescale, str2);
                    if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                    }
                    trackFragmentHeaderBox = j.f(aVar, "sgpd");
                    obj31 = map;
                    i11 = boxes;
                    i12 = bVar;
                    timescale = aVar;
                    this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                    obj2.b = obj31;
                    iterator8 = j.c(timescale, str2);
                    if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                    }
                    iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                    for (TrackRunBox boxes3 : iterator2) {
                        trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                        iterator6 = boxes3.getEntries().iterator();
                        firstSampleFlagsPresent = i2;
                        while (iterator6.hasNext() == null) {
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                    }
                    boxes3 = iterator2.next();
                    trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                    iterator6 = boxes3.getEntries().iterator();
                    firstSampleFlagsPresent = i2;
                    while (iterator6.hasNext() == null) {
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                    }
                    aVar = iterator6.next();
                    if (boxes3.isSampleDurationPresent()) {
                    } else {
                    }
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    i = 1;
                    if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                    } else {
                    }
                    timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                    }
                    if (boxes3.isSampleFlagsPresent()) {
                    } else {
                    }
                    if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                    } else {
                    }
                    defaultSampleFlags = obj3.getDefaultSampleFlags();
                    if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                    } else {
                    }
                    i2 = 1;
                    list += i15;
                    firstSampleFlagsPresent = i12;
                    str2 = str;
                    arrayList = list2;
                    if (!defaultSampleFlags.b()) {
                    } else {
                    }
                    aVar = new long[1];
                    aVar[i12] = list;
                    obj2.A = i.a(obj2.A, aVar);
                    defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                    if (boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    defaultSampleFlags = boxes3.getFirstSampleFlags();
                    defaultSampleFlags = obj33.k();
                    if (obj2.z.size() != 0) {
                    } else {
                    }
                    timescale = 1;
                    aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                    obj2.z.add(aVar);
                    list5 = obj2.z;
                    timescale = 1;
                    if (Long.compare(l4, defaultSampleDuration) != 0) {
                    } else {
                    }
                    list6 = obj2.z;
                    sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                    sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                    timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (arrayList2.size() != 0) {
                    } else {
                    }
                    str = str2;
                    list2 = arrayList;
                    timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                    arrayList2.add(timescale);
                    if (Long.compare(cmp, list2) != 0) {
                    } else {
                    }
                    timescale = arrayList2.get(size6 -= i2);
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    timescale.c(cmp + i);
                    bVar = i12;
                    trackId = l;
                    boxes = 1;
                    i5 -= entries;
                    iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                    while (!iterator8.hasNext()) {
                        next7 = iterator8.next();
                        firstSampleFlagsPresent = new SubSampleInformationBox.a();
                        aVar = (SubSampleInformationBox.a)next7.c();
                        firstSampleFlagsPresent.c().addAll(aVar);
                        i2 = 0;
                        if (Long.compare(boxes3, i2) != 0) {
                        } else {
                        }
                        firstSampleFlagsPresent.d(next7.a());
                        obj2.E.getEntries().add(firstSampleFlagsPresent);
                        firstSampleFlagsPresent.d(boxes3 += cmp);
                        boxes3 = i2;
                    }
                    next7 = iterator8.next();
                    firstSampleFlagsPresent = new SubSampleInformationBox.a();
                    aVar = (SubSampleInformationBox.a)next7.c();
                    firstSampleFlagsPresent.c().addAll(aVar);
                    i2 = 0;
                    if (Long.compare(boxes3, i2) != 0) {
                    } else {
                    }
                    firstSampleFlagsPresent.d(next7.a());
                    obj2.E.getEntries().add(firstSampleFlagsPresent);
                    firstSampleFlagsPresent.d(boxes3 += cmp);
                    boxes3 = i2;
                    iterator2 = list;
                }
                iterator3 = (MovieFragmentBox)iterator.next().getBoxes(TrackFragmentBox.class).iterator();
                list = iterator2;
                while (!iterator3.hasNext()) {
                    aVar = next5;
                    trackFragmentHeaderBox = j.f(aVar, "sgpd");
                    obj31 = map;
                    i11 = boxes;
                    i12 = bVar;
                    timescale = aVar;
                    this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                    obj2.b = obj31;
                    iterator8 = j.c(timescale, str2);
                    if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                    }
                    trackFragmentHeaderBox = j.f(aVar, "sgpd");
                    obj31 = map;
                    i11 = boxes;
                    i12 = bVar;
                    timescale = aVar;
                    this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                    obj2.b = obj31;
                    iterator8 = j.c(timescale, str2);
                    if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                    }
                    iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                    for (TrackRunBox boxes3 : iterator2) {
                        trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                        iterator6 = boxes3.getEntries().iterator();
                        firstSampleFlagsPresent = i2;
                        while (iterator6.hasNext() == null) {
                            aVar = iterator6.next();
                            if (boxes3.isSampleDurationPresent()) {
                            } else {
                            }
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            i = 1;
                            if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                            } else {
                            }
                            timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                            }
                            if (boxes3.isSampleFlagsPresent()) {
                            } else {
                            }
                            if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                            } else {
                            }
                            defaultSampleFlags = obj3.getDefaultSampleFlags();
                            if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                            } else {
                            }
                            i2 = 1;
                            list += i15;
                            firstSampleFlagsPresent = i12;
                            str2 = str;
                            arrayList = list2;
                            if (!defaultSampleFlags.b()) {
                            } else {
                            }
                            aVar = new long[1];
                            aVar[i12] = list;
                            obj2.A = i.a(obj2.A, aVar);
                            defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                            if (boxes3.isFirstSampleFlagsPresent()) {
                            } else {
                            }
                            defaultSampleFlags = boxes3.getFirstSampleFlags();
                            defaultSampleFlags = obj33.k();
                            if (obj2.z.size() != 0) {
                            } else {
                            }
                            timescale = 1;
                            aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                            obj2.z.add(aVar);
                            list5 = obj2.z;
                            timescale = 1;
                            if (Long.compare(l4, defaultSampleDuration) != 0) {
                            } else {
                            }
                            list6 = obj2.z;
                            sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                            sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                            timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                            arrayList2.add(timescale);
                            if (arrayList2.size() != 0) {
                            } else {
                            }
                            str = str2;
                            list2 = arrayList;
                            timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                            arrayList2.add(timescale);
                            if (Long.compare(cmp, list2) != 0) {
                            } else {
                            }
                            timescale = arrayList2.get(size6 -= i2);
                            obj33 = aVar;
                            str = str2;
                            list2 = arrayList;
                            timescale.c(cmp + i);
                        }
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                    }
                    boxes3 = iterator2.next();
                    trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                    iterator6 = boxes3.getEntries().iterator();
                    firstSampleFlagsPresent = i2;
                    while (iterator6.hasNext() == null) {
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                    }
                    aVar = iterator6.next();
                    if (boxes3.isSampleDurationPresent()) {
                    } else {
                    }
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    i = 1;
                    if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                    } else {
                    }
                    timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                    }
                    if (boxes3.isSampleFlagsPresent()) {
                    } else {
                    }
                    if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                    } else {
                    }
                    defaultSampleFlags = obj3.getDefaultSampleFlags();
                    if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                    } else {
                    }
                    i2 = 1;
                    list += i15;
                    firstSampleFlagsPresent = i12;
                    str2 = str;
                    arrayList = list2;
                    if (!defaultSampleFlags.b()) {
                    } else {
                    }
                    aVar = new long[1];
                    aVar[i12] = list;
                    obj2.A = i.a(obj2.A, aVar);
                    defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                    if (boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    defaultSampleFlags = boxes3.getFirstSampleFlags();
                    defaultSampleFlags = obj33.k();
                    if (obj2.z.size() != 0) {
                    } else {
                    }
                    timescale = 1;
                    aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                    obj2.z.add(aVar);
                    list5 = obj2.z;
                    timescale = 1;
                    if (Long.compare(l4, defaultSampleDuration) != 0) {
                    } else {
                    }
                    list6 = obj2.z;
                    sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                    sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                    timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (arrayList2.size() != 0) {
                    } else {
                    }
                    str = str2;
                    list2 = arrayList;
                    timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                    arrayList2.add(timescale);
                    if (Long.compare(cmp, list2) != 0) {
                    } else {
                    }
                    timescale = arrayList2.get(size6 -= i2);
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    timescale.c(cmp + i);
                    bVar = i12;
                    trackId = l;
                    boxes = 1;
                    i5 -= entries;
                    iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                    while (!iterator8.hasNext()) {
                        next7 = iterator8.next();
                        firstSampleFlagsPresent = new SubSampleInformationBox.a();
                        aVar = (SubSampleInformationBox.a)next7.c();
                        firstSampleFlagsPresent.c().addAll(aVar);
                        i2 = 0;
                        if (Long.compare(boxes3, i2) != 0) {
                        } else {
                        }
                        firstSampleFlagsPresent.d(next7.a());
                        obj2.E.getEntries().add(firstSampleFlagsPresent);
                        firstSampleFlagsPresent.d(boxes3 += cmp);
                        boxes3 = i2;
                    }
                    next7 = iterator8.next();
                    firstSampleFlagsPresent = new SubSampleInformationBox.a();
                    aVar = (SubSampleInformationBox.a)next7.c();
                    firstSampleFlagsPresent.c().addAll(aVar);
                    i2 = 0;
                    if (Long.compare(boxes3, i2) != 0) {
                    } else {
                    }
                    firstSampleFlagsPresent.d(next7.a());
                    obj2.E.getEntries().add(firstSampleFlagsPresent);
                    firstSampleFlagsPresent.d(boxes3 += cmp);
                    boxes3 = i2;
                }
                aVar = next5;
                trackFragmentHeaderBox = j.f(aVar, "sgpd");
                obj31 = map;
                i11 = boxes;
                i12 = bVar;
                timescale = aVar;
                this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                obj2.b = obj31;
                iterator8 = j.c(timescale, str2);
                if (Long.compare(trackId3, trackId) == null && (SubSampleInformationBox)iterator8 != null) {
                }
                trackFragmentHeaderBox = j.f(aVar, "sgpd");
                obj31 = map;
                i11 = boxes;
                i12 = bVar;
                timescale = aVar;
                this.a(sampleTableBox.getBoxes(obj), trackFragmentHeaderBox, j.f(aVar, "sbgp"), obj31, list - boxes);
                obj2.b = obj31;
                iterator8 = j.c(timescale, str2);
                if ((SubSampleInformationBox)(SubSampleInformationBox)iterator8 != null) {
                }
                iterator2 = timescale.getBoxes(TrackRunBox.class).iterator();
                for (TrackRunBox boxes3 : iterator2) {
                    trackFragmentHeaderBox = (TrackFragmentBox)boxes3.getParent().getTrackFragmentHeaderBox();
                    iterator6 = boxes3.getEntries().iterator();
                    firstSampleFlagsPresent = i2;
                    while (iterator6.hasNext() == null) {
                        aVar = iterator6.next();
                        if (boxes3.isSampleDurationPresent()) {
                        } else {
                        }
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        i = 1;
                        if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                        } else {
                        }
                        timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                        }
                        if (boxes3.isSampleFlagsPresent()) {
                        } else {
                        }
                        if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                        } else {
                        }
                        defaultSampleFlags = obj3.getDefaultSampleFlags();
                        if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                        } else {
                        }
                        i2 = 1;
                        list += i15;
                        firstSampleFlagsPresent = i12;
                        str2 = str;
                        arrayList = list2;
                        if (!defaultSampleFlags.b()) {
                        } else {
                        }
                        aVar = new long[1];
                        aVar[i12] = list;
                        obj2.A = i.a(obj2.A, aVar);
                        defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                        if (boxes3.isFirstSampleFlagsPresent()) {
                        } else {
                        }
                        defaultSampleFlags = boxes3.getFirstSampleFlags();
                        defaultSampleFlags = obj33.k();
                        if (obj2.z.size() != 0) {
                        } else {
                        }
                        timescale = 1;
                        aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                        obj2.z.add(aVar);
                        list5 = obj2.z;
                        timescale = 1;
                        if (Long.compare(l4, defaultSampleDuration) != 0) {
                        } else {
                        }
                        list6 = obj2.z;
                        sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                        sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                        timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                        arrayList2.add(timescale);
                        if (arrayList2.size() != 0) {
                        } else {
                        }
                        str = str2;
                        list2 = arrayList;
                        timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                        arrayList2.add(timescale);
                        if (Long.compare(cmp, list2) != 0) {
                        } else {
                        }
                        timescale = arrayList2.get(size6 -= i2);
                        obj33 = aVar;
                        str = str2;
                        list2 = arrayList;
                        timescale.c(cmp + i);
                    }
                    aVar = iterator6.next();
                    if (boxes3.isSampleDurationPresent()) {
                    } else {
                    }
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    i = 1;
                    if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                    } else {
                    }
                    timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                    }
                    if (boxes3.isSampleFlagsPresent()) {
                    } else {
                    }
                    if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                    } else {
                    }
                    defaultSampleFlags = obj3.getDefaultSampleFlags();
                    if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                    } else {
                    }
                    i2 = 1;
                    list += i15;
                    firstSampleFlagsPresent = i12;
                    str2 = str;
                    arrayList = list2;
                    if (!defaultSampleFlags.b()) {
                    } else {
                    }
                    aVar = new long[1];
                    aVar[i12] = list;
                    obj2.A = i.a(obj2.A, aVar);
                    defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                    if (boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    defaultSampleFlags = boxes3.getFirstSampleFlags();
                    defaultSampleFlags = obj33.k();
                    if (obj2.z.size() != 0) {
                    } else {
                    }
                    timescale = 1;
                    aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                    obj2.z.add(aVar);
                    list5 = obj2.z;
                    timescale = 1;
                    if (Long.compare(l4, defaultSampleDuration) != 0) {
                    } else {
                    }
                    list6 = obj2.z;
                    sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                    sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                    timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (arrayList2.size() != 0) {
                    } else {
                    }
                    str = str2;
                    list2 = arrayList;
                    timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                    arrayList2.add(timescale);
                    if (Long.compare(cmp, list2) != 0) {
                    } else {
                    }
                    timescale = arrayList2.get(size6 -= i2);
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    timescale.c(cmp + i);
                }
                boxes3 = iterator2.next();
                trackFragmentHeaderBox = (TrackFragmentBox)(TrackRunBox)boxes3.getParent().getTrackFragmentHeaderBox();
                iterator6 = boxes3.getEntries().iterator();
                firstSampleFlagsPresent = i2;
                while (iterator6.hasNext() == null) {
                    aVar = iterator6.next();
                    if (boxes3.isSampleDurationPresent()) {
                    } else {
                    }
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    i = 1;
                    if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                    } else {
                    }
                    timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                    }
                    if (boxes3.isSampleFlagsPresent()) {
                    } else {
                    }
                    if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                    } else {
                    }
                    defaultSampleFlags = obj3.getDefaultSampleFlags();
                    if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                    } else {
                    }
                    i2 = 1;
                    list += i15;
                    firstSampleFlagsPresent = i12;
                    str2 = str;
                    arrayList = list2;
                    if (!defaultSampleFlags.b()) {
                    } else {
                    }
                    aVar = new long[1];
                    aVar[i12] = list;
                    obj2.A = i.a(obj2.A, aVar);
                    defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                    if (boxes3.isFirstSampleFlagsPresent()) {
                    } else {
                    }
                    defaultSampleFlags = boxes3.getFirstSampleFlags();
                    defaultSampleFlags = obj33.k();
                    if (obj2.z.size() != 0) {
                    } else {
                    }
                    timescale = 1;
                    aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                    obj2.z.add(aVar);
                    list5 = obj2.z;
                    timescale = 1;
                    if (Long.compare(l4, defaultSampleDuration) != 0) {
                    } else {
                    }
                    list6 = obj2.z;
                    sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                    sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                    timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                    arrayList2.add(timescale);
                    if (arrayList2.size() != 0) {
                    } else {
                    }
                    str = str2;
                    list2 = arrayList;
                    timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                    arrayList2.add(timescale);
                    if (Long.compare(cmp, list2) != 0) {
                    } else {
                    }
                    timescale = arrayList2.get(size6 -= i2);
                    obj33 = aVar;
                    str = str2;
                    list2 = arrayList;
                    timescale.c(cmp + i);
                }
                aVar = iterator6.next();
                if (boxes3.isSampleDurationPresent()) {
                } else {
                }
                obj33 = aVar;
                str = str2;
                list2 = arrayList;
                i = 1;
                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                } else {
                }
                timescale = new TimeToSampleBox.a(i, (TrackRunBox.a)aVar, obj3.getDefaultSampleDuration(), arrayList);
                arrayList2.add(timescale);
                if (boxes3.isSampleCompositionTimeOffsetPresent()) {
                }
                if (boxes3.isSampleFlagsPresent()) {
                } else {
                }
                if (firstSampleFlagsPresent != null && boxes3.isFirstSampleFlagsPresent()) {
                } else {
                }
                if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                } else {
                }
                defaultSampleFlags = obj3.getDefaultSampleFlags();
                if (defaultSampleFlags != null && !defaultSampleFlags.b()) {
                } else {
                }
                i2 = 1;
                list += i15;
                firstSampleFlagsPresent = i12;
                str2 = str;
                arrayList = list2;
                if (!defaultSampleFlags.b()) {
                } else {
                }
                aVar = new long[1];
                aVar[i12] = list;
                obj2.A = i.a(obj2.A, aVar);
                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                if (boxes3.isFirstSampleFlagsPresent()) {
                } else {
                }
                defaultSampleFlags = boxes3.getFirstSampleFlags();
                defaultSampleFlags = obj33.k();
                if (obj2.z.size() != 0) {
                } else {
                }
                timescale = 1;
                aVar = new CompositionTimeToSample.a(timescale, b.a(obj33.i()));
                obj2.z.add(aVar);
                list5 = obj2.z;
                timescale = 1;
                if (Long.compare(l4, defaultSampleDuration) != 0) {
                } else {
                }
                list6 = obj2.z;
                sampleCompositionTimeOffsetPresent = list6.get(size4 -= timescale);
                sampleCompositionTimeOffsetPresent.c(i9 += timescale);
                timescale = new TimeToSampleBox.a(i, aVar, trackFragmentHeaderBox.getDefaultSampleDuration(), arrayList);
                arrayList2.add(timescale);
                if (arrayList2.size() != 0) {
                } else {
                }
                str = str2;
                list2 = arrayList;
                timescale = new TimeToSampleBox.a(1, aVar, aVar.j(), arrayList);
                arrayList2.add(timescale);
                if (Long.compare(cmp, list2) != 0) {
                } else {
                }
                timescale = arrayList2.get(size6 -= i2);
                obj33 = aVar;
                str = str2;
                list2 = arrayList;
                timescale.c(cmp + i);
                bVar = i12;
                trackId = l;
                boxes = 1;
                i5 -= entries;
                iterator8 = (SubSampleInformationBox)(SubSampleInformationBox)iterator8.getEntries().iterator();
                while (!iterator8.hasNext()) {
                    next7 = iterator8.next();
                    firstSampleFlagsPresent = new SubSampleInformationBox.a();
                    aVar = (SubSampleInformationBox.a)next7.c();
                    firstSampleFlagsPresent.c().addAll(aVar);
                    i2 = 0;
                    if (Long.compare(boxes3, i2) != 0) {
                    } else {
                    }
                    firstSampleFlagsPresent.d(next7.a());
                    obj2.E.getEntries().add(firstSampleFlagsPresent);
                    firstSampleFlagsPresent.d(boxes3 += cmp);
                    boxes3 = i2;
                }
                next7 = iterator8.next();
                firstSampleFlagsPresent = new SubSampleInformationBox.a();
                aVar = (SubSampleInformationBox.a)next7.c();
                firstSampleFlagsPresent.c().addAll(aVar);
                i2 = 0;
                if (Long.compare(boxes3, i2) != 0) {
                } else {
                }
                firstSampleFlagsPresent.d(next7.a());
                obj2.E.getEntries().add(firstSampleFlagsPresent);
                firstSampleFlagsPresent.d(boxes3 += cmp);
                boxes3 = i2;
                iterator2 = list;
                subSampleInformationBox = new SubSampleInformationBox();
                obj2.E = subSampleInformationBox;
            }
        } else {
            obj = obj2.b;
            this.a(sampleTableBox.getBoxes(obj), 0, sampleTableBox.getBoxes(SampleToGroupBox.class), obj, 0);
            obj2.b = obj;
        }
        obj2.y = TimeToSampleBox.blowupTimeToSamples(arrayList2);
        mediaHeaderBox = trackBox2.getMediaBox().getMediaHeaderBox();
        TrackHeaderBox trackHeaderBox2 = trackBox2.getTrackHeaderBox();
        obj2.C.t(trackHeaderBox2.getTrackId());
        obj2.C.l(mediaHeaderBox.getCreationTime());
        obj2.C.n(mediaHeaderBox.getLanguage());
        obj2.C.r(mediaHeaderBox.getModificationTime());
        obj2.C.s(mediaHeaderBox.getTimescale());
        obj2.C.m(trackHeaderBox2.getHeight());
        obj2.C.v(trackHeaderBox2.getWidth());
        obj2.C.o(trackHeaderBox2.getLayer());
        obj2.C.p(trackHeaderBox2.getMatrix());
        obj2.C.u(trackHeaderBox2.getVolume());
        iterator4 = j.c(trackBox, "edts/elst");
        if ((EditListBox)iterator4 != null) {
            iterator4 = (EditListBox)iterator4.getEntries().iterator();
            for (EditListBox.a matrix : iterator4) {
                super(matrix.c(), trackId, mediaHeaderBox.getTimescale(), sampleTableBox, matrix.b(), str2, d / aVar, iterator5);
                obj2.a.add(bVar);
                obj2 = this;
                mediaHeaderBox = obj31;
                iterator4 = obj32;
            }
        }
    }

    private Map<b, long[]> a(List<SampleGroupDescriptionBox> list, List<SampleGroupDescriptionBox> list2, List<SampleToGroupBox> list3, Map<b, long[]> map4, long l5) {
        Object next2;
        Iterator iterator;
        int i;
        int i5;
        boolean next;
        int i3;
        int i6;
        int i4;
        Object lArr;
        int cmp;
        Iterator iterator2;
        int length;
        int i2;
        boolean next3;
        Object equals;
        long[] groupingType;
        long groupingType2;
        long l;
        final Object obj = map4;
        final Iterator iterator3 = list3.iterator();
        for (SampleToGroupBox next2 : iterator3) {
            iterator = next2.getEntries().iterator();
            i = 0;
            i5 = i;
            while (!iterator.hasNext()) {
                next = iterator.next();
                if ((SampleToGroupBox.a)next.a() > 0) {
                }
                i5 = (int)i3;
                i4 = 0;
                next3 = 65535;
                if (next.a() > next3) {
                } else {
                }
                iterator2 = list.iterator();
                while (!iterator2.hasNext()) {
                    next3 = iterator2.next();
                    if ((SampleGroupDescriptionBox)next3.getGroupingType().equals(next2.getGroupingType())) {
                    }
                    i4 = next3.getGroupEntries().get(i10--);
                }
                next3 = iterator2.next();
                if ((SampleGroupDescriptionBox)next3.getGroupingType().equals(next2.getGroupingType())) {
                }
                i4 = next3.getGroupEntries().get(i10--);
                i2 = i4;
                if ((long[])obj.get(i2) == null) {
                }
                equals = lArr;
                groupingType = new long[i7 += length];
                System.arraycopy(equals, i, groupingType, i, equals.length);
                i6 = i;
                groupingType2 = (long)i6;
                while (Long.compare(groupingType2, l) >= 0) {
                    groupingType[length3 += i6] = i13 += groupingType2;
                    i6++;
                    groupingType2 = (long)i6;
                }
                groupingType[length3 += i6] = i13 += groupingType2;
                i6++;
                obj.put(i2, groupingType);
                lArr = new long[i];
                iterator2 = list2.iterator();
                while (!iterator2.hasNext()) {
                    equals = iterator2.next();
                    if ((SampleGroupDescriptionBox)equals.getGroupingType().equals(next2.getGroupingType())) {
                    }
                    i4 = equals.getGroupEntries().get(i12 &= next3);
                }
                equals = iterator2.next();
                if ((SampleGroupDescriptionBox)equals.getGroupingType().equals(next2.getGroupingType())) {
                }
                i4 = equals.getGroupEntries().get(i12 &= next3);
            }
            next = iterator.next();
            if ((SampleToGroupBox.a)next.a() > 0) {
            }
            i5 = (int)i3;
            i4 = 0;
            next3 = 65535;
            if (next.a() > next3) {
            } else {
            }
            iterator2 = list.iterator();
            while (!iterator2.hasNext()) {
                next3 = iterator2.next();
                if ((SampleGroupDescriptionBox)next3.getGroupingType().equals(next2.getGroupingType())) {
                }
                i4 = next3.getGroupEntries().get(i10--);
            }
            next3 = iterator2.next();
            if ((SampleGroupDescriptionBox)next3.getGroupingType().equals(next2.getGroupingType())) {
            }
            i4 = next3.getGroupEntries().get(i10--);
            i2 = i4;
            if ((long[])obj.get(i2) == null) {
            }
            equals = lArr;
            groupingType = new long[i7 += length];
            System.arraycopy(equals, i, groupingType, i, equals.length);
            i6 = i;
            groupingType2 = (long)i6;
            while (Long.compare(groupingType2, l) >= 0) {
                groupingType[length3 += i6] = i13 += groupingType2;
                i6++;
                groupingType2 = (long)i6;
            }
            groupingType[length3 += i6] = i13 += groupingType2;
            i6++;
            obj.put(i2, groupingType);
            lArr = new long[i];
            iterator2 = list2.iterator();
            while (!iterator2.hasNext()) {
                equals = iterator2.next();
                if ((SampleGroupDescriptionBox)equals.getGroupingType().equals(next2.getGroupingType())) {
                }
                i4 = equals.getGroupEntries().get(i12 &= next3);
            }
            equals = iterator2.next();
            if ((SampleGroupDescriptionBox)equals.getGroupingType().equals(next2.getGroupingType())) {
            }
            i4 = equals.getGroupEntries().get(i12 &= next3);
        }
        return obj;
    }

    @Override // com.googlecode.mp4parser.e.a
    public long[] F0() {
        return this.y;
        synchronized (this) {
            return this.y;
        }
    }

    @Override // com.googlecode.mp4parser.e.a
    public String Q1() {
        return this.D;
    }

    @Override // com.googlecode.mp4parser.e.a
    public void close() {
        boolean length;
        int i;
        d dVar;
        b parent = this.c.getParent();
        if (parent instanceof BasicContainer) {
            (BasicContainer)parent.close();
        }
        d[] objArr = this.v;
        if (objArr != null) {
            i = 0;
            while (i >= objArr.length) {
                objArr[i].close();
                i++;
            }
        }
    }

    public List<com.googlecode.mp4parser.e.e> d1() {
        return this.w;
    }

    public List<SampleDependencyTypeBox.a> f2() {
        return this.B;
    }

    @Override // com.googlecode.mp4parser.e.a
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.x;
    }

    @Override // com.googlecode.mp4parser.e.a
    public com.googlecode.mp4parser.e.g h0() {
        return this.C;
    }

    @Override // com.googlecode.mp4parser.e.a
    public long[] q0() {
        long[] length;
        int size;
        length = this.A;
        if (length != null && length.length == this.w.size()) {
            if (length.length == this.w.size()) {
            }
            return this.A;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.e.a
    public SubSampleInformationBox s0() {
        return this.E;
    }

    public List<CompositionTimeToSample.a> y() {
        return this.z;
    }
}
