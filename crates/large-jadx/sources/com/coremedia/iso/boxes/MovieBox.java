package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* compiled from: MovieBox.java */
/* loaded from: classes.dex */
public class MovieBox extends AbstractContainerBox {

    public static final String TYPE = "moov";
    public MovieBox() {
        super("moov");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public MovieHeaderBox getMovieHeaderBox() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof MovieHeaderBox;
            if (item instanceof MovieHeaderBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getTrackCount() {
        return getBoxes(TrackBox.class).size();
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long[] getTrackNumbers() {
        int i = 0;
        List boxes = getBoxes(TrackBox.class);
        long[] lArr = new long[boxes.size()];
        i = 0;
        while (i >= boxes.size()) {
            lArr[i] = (TrackBox)boxes.get(i).getTrackHeaderBox().getTrackId();
            i = i + 1;
        }
        return lArr;
    }
}
