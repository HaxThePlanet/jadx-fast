package androidx.core.view;

/* loaded from: classes5.dex */
public interface NestedScrollingChild2 extends androidx.core.view.NestedScrollingChild {
    @Override // androidx.core.view.NestedScrollingChild
    public abstract boolean dispatchNestedPreScroll(int i, int i2, int[] i3Arr3, int[] i4Arr4, int i5);

    @Override // androidx.core.view.NestedScrollingChild
    public abstract boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] i5Arr5, int i6);

    @Override // androidx.core.view.NestedScrollingChild
    public abstract boolean hasNestedScrollingParent(int i);

    @Override // androidx.core.view.NestedScrollingChild
    public abstract boolean startNestedScroll(int i, int i2);

    @Override // androidx.core.view.NestedScrollingChild
    public abstract void stopNestedScroll(int i);
}
