package d.h.l;

import android.view.View;

/* loaded from: classes.dex */
public interface o {
    public abstract boolean onNestedFling(View view, float f2, float f3, boolean z4);

    public abstract boolean onNestedPreFling(View view, float f2, float f3);

    public abstract void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4);

    public abstract void onNestedScroll(View view, int i2, int i3, int i4, int i5);

    public abstract void onNestedScrollAccepted(View view, View view2, int i3);

    public abstract boolean onStartNestedScroll(View view, View view2, int i3);

    public abstract void onStopNestedScroll(View view);
}
