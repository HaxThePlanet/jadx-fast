package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TrackBox extends AbstractContainerBox {

    public static final String TYPE = "trak";
    private com.coremedia.iso.boxes.SampleTableBox sampleTableBox;
    public TrackBox() {
        super("trak");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.MediaBox getMediaBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SampleTableBox getSampleTableBox() {
        AbstractContainerBox mediaInformationBox;
        com.coremedia.iso.boxes.SampleTableBox sampleTableBox = this.sampleTableBox;
        if (sampleTableBox != null) {
            return sampleTableBox;
        }
        mediaInformationBox = getMediaBox();
        mediaInformationBox = mediaInformationBox.getMediaInformationBox();
        if (mediaInformationBox != null && mediaInformationBox != null) {
            mediaInformationBox = mediaInformationBox.getMediaInformationBox();
            if (mediaInformationBox != null) {
                com.coremedia.iso.boxes.SampleTableBox sampleTableBox2 = mediaInformationBox.getSampleTableBox();
                this.sampleTableBox = sampleTableBox2;
                return sampleTableBox2;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.TrackHeaderBox getTrackHeaderBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    public void setBoxes(List<com.coremedia.iso.boxes.a> list) {
        super.setBoxes(list);
        this.sampleTableBox = 0;
    }
}
