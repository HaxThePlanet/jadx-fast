package com.coremedia.iso.boxes.mdat;

import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.e.e;
import f.b.a.d;
import java.util.AbstractList;
import java.util.List;

/* compiled from: SampleList.java */
/* loaded from: classes.dex */
public class a extends AbstractList<e> {

    List<e> a;
    public a(TrackBox trackBox, d... dVarArr) {
        super();
        com.coremedia.iso.boxes.b parent2 = (a)trackBox.getParent().getParent();
        obj = MovieExtendsBox.class;
        if (trackBox.getParent().getBoxes(obj).isEmpty()) {
            if (dVarArr.length > 0) {
                throw new RuntimeException("The TrackBox comes from a standard MP4 file. Only use the additionalFragments param if you are dealing with ( fragmented MP4 files AND additional fragments in standalone files )");
            } else {
                this.a = new a(trackBox.getTrackHeaderBox().getTrackId(), obj, parent2);
                return;
            }
        }
        this.a = new b(trackBox.getTrackHeaderBox().getTrackId(), r3, parent2, dVarArr);
    }

    @Override // java.util.AbstractList
    public e b(int i) {
        return (e)this.a.get(i);
    }

    @Override // java.util.AbstractList
    public int size() {
        return this.a.size();
    }
}
