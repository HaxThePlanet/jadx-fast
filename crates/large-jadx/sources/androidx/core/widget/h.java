package androidx.core.widget;

import android.view.View;
import android.widget.ListView;

/* loaded from: classes.dex */
public class h extends androidx.core.widget.c {

    private final ListView K;
    public h(ListView listView) {
        super(listView);
        this.K = listView;
    }

    @Override // androidx.core.widget.c
    public boolean a(int i) {
        return 0;
    }

    @Override // androidx.core.widget.c
    public boolean b(int i) {
        ListView height;
        int childCount;
        int obj8;
        height = this.K;
        final int count = height.getCount();
        final int i2 = 0;
        if (count == 0) {
            return i2;
        }
        childCount = height.getChildCount();
        final int firstVisiblePosition = height.getFirstVisiblePosition();
        final int i4 = 1;
        if (i > 0) {
            if (firstVisiblePosition + childCount >= count && height.getChildAt(childCount -= i4).getBottom() <= height.getHeight()) {
                if (height.getChildAt(childCount -= i4).getBottom() <= height.getHeight()) {
                    return i2;
                }
            }
            return i4;
        } else {
            if (i < 0 && firstVisiblePosition <= 0 && height.getChildAt(i2).getTop() >= 0) {
                if (firstVisiblePosition <= 0) {
                    if (height.getChildAt(i2).getTop() >= 0) {
                        return i2;
                    }
                }
            }
        }
        return i2;
    }

    @Override // androidx.core.widget.c
    public void j(int i, int i2) {
        i.b(this.K, i2);
    }
}
