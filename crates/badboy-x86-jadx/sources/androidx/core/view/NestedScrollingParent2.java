package androidx.core.view;

import android.view.View;

/* loaded from: classes5.dex */
public interface NestedScrollingParent2 extends androidx.core.view.NestedScrollingParent {
    @Override // androidx.core.view.NestedScrollingParent
    public abstract void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4, int i5);

    @Override // androidx.core.view.NestedScrollingParent
    public abstract void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6);

    @Override // androidx.core.view.NestedScrollingParent
    public abstract void onNestedScrollAccepted(View view, View view2, int i3, int i4);

    @Override // androidx.core.view.NestedScrollingParent
    public abstract boolean onStartNestedScroll(View view, View view2, int i3, int i4);

    @Override // androidx.core.view.NestedScrollingParent
    public abstract void onStopNestedScroll(View view, int i2);
}
