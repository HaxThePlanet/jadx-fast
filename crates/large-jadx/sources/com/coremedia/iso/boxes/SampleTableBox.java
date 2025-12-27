package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* compiled from: SampleTableBox.java */
/* loaded from: classes.dex */
public class SampleTableBox extends AbstractContainerBox {

    public static final String TYPE = "stbl";
    private SampleToChunkBox sampleToChunkBox;
    public SampleTableBox() {
        super("stbl");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public ChunkOffsetBox getChunkOffsetBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof ChunkOffsetBox;
            if (item instanceof ChunkOffsetBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public CompositionTimeToSample getCompositionTimeToSample() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof CompositionTimeToSample;
            if (item instanceof CompositionTimeToSample) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public SampleDependencyTypeBox getSampleDependencyTypeBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof SampleDependencyTypeBox;
            if (item instanceof SampleDependencyTypeBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public SampleDescriptionBox getSampleDescriptionBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof SampleDescriptionBox;
            if (item instanceof SampleDescriptionBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public SampleSizeBox getSampleSizeBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof SampleSizeBox;
            if (item instanceof SampleSizeBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public SampleToChunkBox getSampleToChunkBox() {
        if (this.sampleToChunkBox != null) {
            return this.sampleToChunkBox;
        }
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof SampleToChunkBox;
            if (item instanceof SampleToChunkBox) {
                this.sampleToChunkBox = item;
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public SyncSampleBox getSyncSampleBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof SyncSampleBox;
            if (item instanceof SyncSampleBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public TimeToSampleBox getTimeToSampleBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof TimeToSampleBox;
            if (item instanceof TimeToSampleBox) {
                return item;
            }
        }
        return null;
    }
}
