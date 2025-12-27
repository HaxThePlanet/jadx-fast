package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* compiled from: TrackBox.java */
/* loaded from: classes.dex */
public class TrackBox extends AbstractContainerBox {

    public static final String TYPE = "trak";
    private SampleTableBox sampleTableBox;
    public TrackBox() {
        super("trak");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public MediaBox getMediaBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof MediaBox;
            if (item instanceof MediaBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public SampleTableBox getSampleTableBox() {
        if (this.sampleTableBox != null) {
            return this.sampleTableBox;
        }
        com.coremedia.iso.boxes.MediaBox mediaBox = getMediaBox();
        if (mediaBox != null && mediaInformationBox != null) {
            com.coremedia.iso.boxes.SampleTableBox sampleTableBox = mediaInformationBox.getSampleTableBox();
            this.sampleTableBox = sampleTableBox;
            return sampleTableBox;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public TrackHeaderBox getTrackHeaderBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof TrackHeaderBox;
            if (item instanceof TrackHeaderBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void setBoxes(List<a> list) {
        super.setBoxes(list);
        this.sampleTableBox = null;
    }
}
