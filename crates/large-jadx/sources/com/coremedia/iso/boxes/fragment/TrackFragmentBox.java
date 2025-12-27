package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* compiled from: TrackFragmentBox.java */
/* loaded from: classes.dex */
public class TrackFragmentBox extends AbstractContainerBox {

    public static final String TYPE = "traf";
    public TrackFragmentBox() {
        super("traf");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public TrackFragmentHeaderBox getTrackFragmentHeaderBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof TrackFragmentHeaderBox;
            if (item instanceof TrackFragmentHeaderBox) {
                return item;
            }
        }
        return null;
    }
}
