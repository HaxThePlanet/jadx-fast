package com.googlecode.mp4parser.e;

import com.coremedia.iso.boxes.CompositionTimeToSample.a;
import com.coremedia.iso.boxes.SampleDependencyTypeBox.a;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import java.io.Closeable;
import java.util.List;
import java.util.Map;

/* compiled from: Track.java */
/* loaded from: classes2.dex */
public interface f extends Closeable {
    long[] F0();

    String Q1();

    Map<b, long[]> S();

    long d();

    List<e> d1();

    List<SampleDependencyTypeBox.a> f2();

    SampleDescriptionBox getSampleDescriptionBox();

    g h0();

    long[] q0();

    SubSampleInformationBox s0();

    List<b> u();

    List<CompositionTimeToSample.a> y();
}
