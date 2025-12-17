package androidx.core.widget;

import android.view.View;
import android.widget.ListView;

/* loaded from: classes5.dex */
public class ListViewAutoScrollHelper extends androidx.core.widget.AutoScrollHelper {

    private final ListView mTarget;
    public ListViewAutoScrollHelper(ListView target) {
        super(target);
        this.mTarget = target;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int direction) {
        return 0;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int direction) {
        View childAt;
        int bottom;
        int height;
        final ListView mTarget = this.mTarget;
        final int count = mTarget.getCount();
        int i = 0;
        if (count == 0) {
            return i;
        }
        final int childCount = mTarget.getChildCount();
        final int firstVisiblePosition = mTarget.getFirstVisiblePosition();
        if (direction > 0) {
            if (firstVisiblePosition + childCount >= count && mTarget.getChildAt(childCount + -1).getBottom() <= mTarget.getHeight()) {
                if (mTarget.getChildAt(childCount + -1).getBottom() <= mTarget.getHeight()) {
                    return i;
                }
            }
            return 1;
        } else {
            if (direction < 0 && firstVisiblePosition <= 0 && mTarget.getChildAt(i).getTop() >= 0) {
                if (firstVisiblePosition <= 0) {
                    if (mTarget.getChildAt(i).getTop() >= 0) {
                        return i;
                    }
                }
            }
        }
        return i;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void scrollTargetBy(int deltaX, int deltaY) {
        this.mTarget.scrollListBy(deltaY);
    }
}
