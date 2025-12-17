package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaBox extends AbstractContainerBox {

    public static final String TYPE = "mdia";
    public MediaBox() {
        super("mdia");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.HandlerBox getHandlerBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.MediaHeaderBox getMediaHeaderBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.MediaInformationBox getMediaInformationBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }
}
