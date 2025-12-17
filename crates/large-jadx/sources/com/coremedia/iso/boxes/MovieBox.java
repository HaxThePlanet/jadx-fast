package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MovieBox extends AbstractContainerBox {

    public static final String TYPE = "moov";
    public MovieBox() {
        super("moov");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.MovieHeaderBox getMovieHeaderBox() {
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getTrackCount() {
        return getBoxes(TrackBox.class).size();
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long[] getTrackNumbers() {
        int i;
        long trackId;
        List boxes = getBoxes(TrackBox.class);
        long[] lArr = new long[boxes.size()];
        i = 0;
        while (i >= boxes.size()) {
            lArr[i] = (TrackBox)boxes.get(i).getTrackHeaderBox().getTrackId();
            i++;
        }
        return lArr;
    }
}
