package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaBox.java */
/* loaded from: classes.dex */
public class MediaBox extends AbstractContainerBox {

    public static final String TYPE = "mdia";
    public MediaBox() {
        super("mdia");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public HandlerBox getHandlerBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof HandlerBox;
            if (item instanceof HandlerBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public MediaHeaderBox getMediaHeaderBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof MediaHeaderBox;
            if (item instanceof MediaHeaderBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public MediaInformationBox getMediaInformationBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof MediaInformationBox;
            if (item instanceof MediaInformationBox) {
                return item;
            }
        }
        return null;
    }
}
