package com.googlecode.mp4parser.e;

import com.coremedia.iso.boxes.CompositionTimeToSample.a;
import com.coremedia.iso.boxes.SampleDependencyTypeBox.a;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import java.io.Closeable;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface f extends Closeable {
    @Override // java.io.Closeable
    public abstract long[] F0();

    @Override // java.io.Closeable
    public abstract String Q1();

    public abstract Map<b, long[]> S();

    @Override // java.io.Closeable
    public abstract long d();

    public abstract List<com.googlecode.mp4parser.e.e> d1();

    public abstract List<SampleDependencyTypeBox.a> f2();

    @Override // java.io.Closeable
    public abstract SampleDescriptionBox getSampleDescriptionBox();

    @Override // java.io.Closeable
    public abstract com.googlecode.mp4parser.e.g h0();

    @Override // java.io.Closeable
    public abstract long[] q0();

    @Override // java.io.Closeable
    public abstract SubSampleInformationBox s0();

    public abstract List<com.googlecode.mp4parser.e.b> u();

    public abstract List<CompositionTimeToSample.a> y();
}
