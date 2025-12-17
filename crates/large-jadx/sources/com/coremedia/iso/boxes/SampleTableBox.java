package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SampleTableBox extends AbstractContainerBox {

    public static final String TYPE = "stbl";
    private com.coremedia.iso.boxes.SampleToChunkBox sampleToChunkBox;
    public SampleTableBox() {
        super("stbl");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.ChunkOffsetBox getChunkOffsetBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.CompositionTimeToSample getCompositionTimeToSample() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SampleDependencyTypeBox getSampleDependencyTypeBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SampleDescriptionBox getSampleDescriptionBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SampleSizeBox getSampleSizeBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SampleToChunkBox getSampleToChunkBox() {
        Object next;
        boolean z;
        com.coremedia.iso.boxes.SampleToChunkBox sampleToChunkBox = this.sampleToChunkBox;
        if (sampleToChunkBox != null) {
            return sampleToChunkBox;
        }
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SyncSampleBox getSyncSampleBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.TimeToSampleBox getTimeToSampleBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }
}
