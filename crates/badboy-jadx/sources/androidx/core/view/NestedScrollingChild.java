package androidx.core.view;

/* loaded from: classes5.dex */
public interface NestedScrollingChild {
    public abstract boolean dispatchNestedFling(float f, float f2, boolean z3);

    public abstract boolean dispatchNestedPreFling(float f, float f2);

    public abstract boolean dispatchNestedPreScroll(int i, int i2, int[] i3Arr3, int[] i4Arr4);

    public abstract boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] i5Arr5);

    public abstract boolean hasNestedScrollingParent();

    public abstract boolean isNestedScrollingEnabled();

    public abstract void setNestedScrollingEnabled(boolean z);

    public abstract boolean startNestedScroll(int i);

    public abstract void stopNestedScroll();
}
