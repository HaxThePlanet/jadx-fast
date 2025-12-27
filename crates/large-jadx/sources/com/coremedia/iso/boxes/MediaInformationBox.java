package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaInformationBox.java */
/* loaded from: classes.dex */
public class MediaInformationBox extends AbstractContainerBox {

    public static final String TYPE = "minf";
    public MediaInformationBox() {
        super("minf");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof AbstractMediaHeaderBox;
            if (item instanceof AbstractMediaHeaderBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public SampleTableBox getSampleTableBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof SampleTableBox;
            if (item instanceof SampleTableBox) {
                return item;
            }
        }
        return null;
    }
}
