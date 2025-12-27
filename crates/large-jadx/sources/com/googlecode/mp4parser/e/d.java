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
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox.a;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a;
import com.googlecode.mp4parser.h.i;
import com.googlecode.mp4parser.h.j;
import f.b.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Mp4TrackImpl.java */
/* loaded from: classes2.dex */
public class d extends a {

    private long[] A;
    private List<SampleDependencyTypeBox.a> B;
    private g C;
    private String D;
    private SubSampleInformationBox E;
    TrackBox c;
    d[] v;
    private List<e> w;
    private SampleDescriptionBox x;
    private long[] y;
    private List<CompositionTimeToSample.a> z;

    public d(String str, TrackBox trackBox, d... dVarArr) {
        MediaHeaderBox str2;
        List boxes2;
        Iterator trackBox22;
        int size2;
        List boxes4;
        long l;
        com.googlecode.mp4parser.e.g gVar;
        int i2;
        List boxes5;
        List list2;
        ArrayList arrayList;
        Map str3;
        com.coremedia.iso.boxes.fragment.a defaultSampleFlags;
        long l3 = 0;
        double d;
        Class<TrackFragmentBox> item2;
        Object obj;
        TrackBox trackBox23;
        long trackId;
        long timescale;
        AbstractContainerBox abstractContainerBox;
        TimeToSampleBox.a aVar3;
        int i5 = 1;
        ArrayList arrayList2;
        String str4;
        long defaultSampleDuration;
        long l5;
        Iterator it;
        Iterator it2;
        Object item;
        Iterator it3;
        Iterator it4;
        Object item22;
        obj = this;
        trackBox23 = trackBox;
        d[] dVarArr32 = dVarArr;
        str3 = SampleGroupDescriptionBox.class;
        super(str);
        long[] lArr = null;
        obj.A = lArr;
        obj.C = new g();
        obj.E = lArr;
        obj.c = trackBox23;
        trackId = trackBox.getTrackHeaderBox().getTrackId();
        obj.w = new a(trackBox23, dVarArr32);
        final SampleTableBox sampleTableBox = trackBox.getMediaBox().getMediaInformationBox().getSampleTableBox();
        obj.D = trackBox.getMediaBox().getHandlerBox().getHandlerType();
        arrayList2 = new ArrayList();
        obj.z = new ArrayList();
        obj.B = new ArrayList();
        arrayList2.addAll(sampleTableBox.getTimeToSampleBox().getEntries());
        if (sampleTableBox.getCompositionTimeToSample() != null) {
            obj.z.addAll(sampleTableBox.getCompositionTimeToSample().getEntries());
        }
        if (sampleTableBox.getSampleDependencyTypeBox() != null) {
            obj.B.addAll(sampleTableBox.getSampleDependencyTypeBox().getEntries());
        }
        if (sampleTableBox.getSyncSampleBox() != null) {
            obj.A = sampleTableBox.getSyncSampleBox().getSampleNumber();
        }
        str4 = "subs";
        obj.E = (SubSampleInformationBox)j.c(sampleTableBox, str4);
        new ArrayList().addAll((a)trackBox.getParent().getParent().getBoxes(MovieFragmentBox.class));
        i2 = 0;
        for (d dVar : dVarArr32) {
            arrayList.addAll(dVar.getBoxes(MovieFragmentBox.class));
            obj = this;
        }
        obj.x = sampleTableBox.getSampleDescriptionBox();
        List boxes = trackBox.getParent().getBoxes(MovieExtendsBox.class);
        if (boxes.size() > 0) {
            it = boxes.iterator();
            while (!it.hasNext()) {
                it2 = (MovieExtendsBox)it.next().getBoxes(TrackExtendsBox.class).iterator();
                while (!it2.hasNext()) {
                    long trackId2 = item.getTrackId();
                }
                trackId2 = item.getTrackId();
            }
        } else {
            List list = null;
            l3 = 0L;
            this.a(sampleTableBox.getBoxes(str3), list, sampleTableBox.getBoxes(SampleToGroupBox.class), str3, l3);
            obj.b = obj.b;
        }
        obj.y = TimeToSampleBox.blowupTimeToSamples(arrayList2);
        str2 = trackBox.getMediaBox().getMediaHeaderBox();
        TrackHeaderBox trackHeaderBox2 = trackBox.getTrackHeaderBox();
        obj.C.t(trackHeaderBox2.getTrackId());
        obj.C.l(str2.getCreationTime());
        obj.C.n(str2.getLanguage());
        obj.C.r(str2.getModificationTime());
        obj.C.s(str2.getTimescale());
        obj.C.m(trackHeaderBox2.getHeight());
        obj.C.v(trackHeaderBox2.getWidth());
        obj.C.o(trackHeaderBox2.getLayer());
        obj.C.p(trackHeaderBox2.getMatrix());
        obj.C.u(trackHeaderBox2.getVolume());
        com.coremedia.iso.boxes.a aVar2 = j.c(trackBox23, "edts/elst");
        if (aVar2 != null) {
            trackBox22 = aVar2.getEntries().iterator();
            while (!trackBox22.hasNext()) {
                com.googlecode.mp4parser.h.h matrix = trackBox22.next();
                d = (double)(MovieHeaderBox)j.c(trackBox23, "../mvhd").getTimescale();
                arrayList = (double)matrix.d() / d;
                super(matrix.c(), trackId, str2.getTimescale(), sampleTableBox, matrix.b(), str4, arrayList, it);
                obj.a.add(bVar);
                obj = this;
            }
        }
    }

    private Map<com.googlecode.mp4parser.boxes.mp4.samplegrouping.b, long[]> a(List<SampleGroupDescriptionBox> list, List<SampleGroupDescriptionBox> list2, List<SampleToGroupBox> list3, Map<com.googlecode.mp4parser.boxes.mp4.samplegrouping.b, long[]> map, long j) {
        int i;
        boolean hasNext;
        long l;
        int i2;
        Object value;
        int cmp;
        long l6;
        Object obj;
        boolean hasNext3;
        long[] lArr;
        String groupingType;
        boolean equals;
        String groupingType2;
        long l2;
        final Object j52 = map;
        final Iterator it2 = list3.iterator();
        while (!it2.hasNext()) {
            Object item = it2.next();
            Iterator it = item.getEntries().iterator();
            i = 0;
            while (!it.hasNext()) {
                Object item2 = it.next();
                l = (long)i + item2.b();
                i = (int)l;
            }
            item2 = it.next();
            l = (long)i + item2.b();
            i = (int)l;
        }
        return j52;
    }

    @Override // com.googlecode.mp4parser.e.a
    public synchronized long[] F0() {
        return this.y;
    }

    @Override // com.googlecode.mp4parser.e.a
    public String Q1() {
        return this.D;
    }

    @Override // com.googlecode.mp4parser.e.a
    public void close() {
        int i = 0;
        d dVar;
        com.coremedia.iso.boxes.b parent = this.c.getParent();
        z = parent instanceof BasicContainer;
        if (parent instanceof BasicContainer) {
            parent.close();
        }
        if (this.v != null) {
            i = 0;
            for (d dVar : objArr) {
                dVar.close();
            }
        }
    }

    @Override // com.googlecode.mp4parser.e.a
    public List<e> d1() {
        return this.w;
    }

    @Override // com.googlecode.mp4parser.e.a
    public List<SampleDependencyTypeBox.a> f2() {
        return this.B;
    }

    @Override // com.googlecode.mp4parser.e.a
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.x;
    }

    @Override // com.googlecode.mp4parser.e.a
    public g h0() {
        return this.C;
    }

    @Override // com.googlecode.mp4parser.e.a
    public long[] q0() {
        if (this.A != null) {
            return this.A;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.e.a
    public SubSampleInformationBox s0() {
        return this.E;
    }

    @Override // com.googlecode.mp4parser.e.a
    public List<CompositionTimeToSample.a> y() {
        return this.z;
    }
}
