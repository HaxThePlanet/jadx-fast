package com.coremedia.iso.boxes.mdat;

import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.e.e;
import com.googlecode.mp4parser.e.h.a;
import com.googlecode.mp4parser.e.h.b;
import f.b.a.d;
import java.util.AbstractList;
import java.util.List;

/* loaded from: classes.dex */
public class a extends AbstractList<e> {

    List<e> a;
    public a(TrackBox trackBox, d... d2Arr2) {
        long trackId;
        Class<com.coremedia.iso.boxes.fragment.MovieExtendsBox> trackId2;
        TrackHeaderBox obj5;
        a obj6;
        super();
        b parent2 = (a)trackBox.getParent().getParent();
        trackId2 = MovieExtendsBox.class;
        if (trackBox.getParent().getBoxes(trackId2).isEmpty()) {
            if (d2Arr2.length > 0) {
            } else {
                obj6 = new a(trackBox.getTrackHeaderBox().getTrackId(), trackId2, parent2);
                this.a = obj6;
            }
            obj5 = new RuntimeException("The TrackBox comes from a standard MP4 file. Only use the additionalFragments param if you are dealing with ( fragmented MP4 files AND additional fragments in standalone files )");
            throw obj5;
        }
        trackId = new b(trackBox.getTrackHeaderBox().getTrackId(), obj3, parent2, d2Arr2);
        this.a = trackId;
    }

    @Override // java.util.AbstractList
    public e b(int i) {
        return (e)this.a.get(i);
    }

    @Override // java.util.AbstractList
    public Object get(int i) {
        return b(i);
    }

    @Override // java.util.AbstractList
    public int size() {
        return this.a.size();
    }
}
