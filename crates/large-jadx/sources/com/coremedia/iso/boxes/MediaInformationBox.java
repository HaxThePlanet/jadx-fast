package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaInformationBox extends AbstractContainerBox {

    public static final String TYPE = "minf";
    public MediaInformationBox() {
        super("minf");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.AbstractMediaHeaderBox getMediaHeaderBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SampleTableBox getSampleTableBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }
}
