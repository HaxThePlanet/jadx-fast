package d.h.l;

import android.view.View;

/* loaded from: classes.dex */
public interface m extends d.h.l.o {
    @Override // d.h.l.o
    public abstract void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4, int i5);

    @Override // d.h.l.o
    public abstract void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6);

    @Override // d.h.l.o
    public abstract void onNestedScrollAccepted(View view, View view2, int i3, int i4);

    @Override // d.h.l.o
    public abstract boolean onStartNestedScroll(View view, View view2, int i3, int i4);

    @Override // d.h.l.o
    public abstract void onStopNestedScroll(View view, int i2);
}
