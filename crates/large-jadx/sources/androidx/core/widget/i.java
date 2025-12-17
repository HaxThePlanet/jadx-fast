package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class i {
    public static boolean a(ListView listView, int i2) {
        int count;
        int i;
        int obj4;
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i2);
        }
        int childCount = listView.getChildCount();
        i = 0;
        if (childCount == 0) {
            return i;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        final int i5 = 1;
        if (i2 > 0) {
            if (firstVisiblePosition += childCount >= listView.getCount()) {
                if (listView.getChildAt(childCount + -1).getBottom() > height -= obj4) {
                    i = i5;
                }
            } else {
            }
            return i;
        }
        if (firstVisiblePosition <= 0) {
            if (listView.getChildAt(i).getTop() < listView.getListPaddingTop()) {
                i = i5;
            }
        } else {
        }
        return i;
    }

    public static void b(ListView listView, int i2) {
        int firstVisiblePosition;
        int i;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i2);
        } else {
            firstVisiblePosition = listView.getFirstVisiblePosition();
            if (firstVisiblePosition == -1) {
            }
            View childAt = listView.getChildAt(0);
            if (childAt == null) {
            }
            listView.setSelectionFromTop(firstVisiblePosition, top -= i2);
        }
    }
}
