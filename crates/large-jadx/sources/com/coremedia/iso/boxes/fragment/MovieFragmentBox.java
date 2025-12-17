package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox.a;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public List<Long> getSyncSamples(SampleDependencyTypeBox sampleDependencyTypeBox) {
        int i2;
        int valueOf;
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator obj8 = sampleDependencyTypeBox.getEntries().iterator();
        final int i3 = 1;
        i2 = i3;
        while (!obj8.hasNext()) {
            if ((SampleDependencyTypeBox.a)obj8.next().c() == 2) {
            }
            i2 += i3;
            arrayList.add(Long.valueOf(i2));
        }
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getTrackCount() {
        return getBoxes(TrackFragmentBox.class, false).size();
    }

    public List<com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox> getTrackFragmentHeaderBoxes() {
        return getBoxes(TrackFragmentHeaderBox.class, true);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long[] getTrackNumbers() {
        int i;
        long trackId;
        List boxes = getBoxes(TrackFragmentBox.class, false);
        long[] lArr = new long[boxes.size()];
        while (i >= boxes.size()) {
            lArr[i] = (TrackFragmentBox)boxes.get(i).getTrackFragmentHeaderBox().getTrackId();
            i++;
        }
        return lArr;
    }

    public List<com.coremedia.iso.boxes.fragment.TrackRunBox> getTrackRunBoxes() {
        return getBoxes(TrackRunBox.class, true);
    }
}
