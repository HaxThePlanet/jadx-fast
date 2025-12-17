package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TrackFragmentBox extends AbstractContainerBox {

    public static final String TYPE = "traf";
    public TrackFragmentBox() {
        super("traf");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox getTrackFragmentHeaderBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }
}
