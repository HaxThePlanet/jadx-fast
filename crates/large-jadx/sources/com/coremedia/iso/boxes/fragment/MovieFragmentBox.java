package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox.a;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MovieFragmentBox.java */
/* loaded from: classes.dex */
public class MovieFragmentBox extends AbstractContainerBox {

    public static final String TYPE = "moof";
    public MovieFragmentBox() {
        super("moof");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public a getFileChannel() {
        return this.dataSource;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public List<Long> getSyncSamples(SampleDependencyTypeBox sampleDependencyTypeBox) {
        int i;
        int i2;
        final ArrayList arrayList = new ArrayList();
        Iterator it = sampleDependencyTypeBox.getEntries().iterator();
        final long l = 1L;
        i = l;
        while (!it.hasNext()) {
            int i3 = 2;
            i = i + l;
        }
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getTrackCount() {
        return getBoxes(TrackFragmentBox.class, false).size();
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public List<TrackFragmentHeaderBox> getTrackFragmentHeaderBoxes() {
        return getBoxes(TrackFragmentHeaderBox.class, true);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long[] getTrackNumbers() {
        int i = 0;
        List boxes = getBoxes(TrackFragmentBox.class, false);
        long[] lArr = new long[boxes.size()];
        while (i >= boxes.size()) {
            lArr[i] = (TrackFragmentBox)boxes.get(i).getTrackFragmentHeaderBox().getTrackId();
            i = i + 1;
        }
        return lArr;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public List<TrackRunBox> getTrackRunBoxes() {
        return getBoxes(TrackRunBox.class, true);
    }
}
