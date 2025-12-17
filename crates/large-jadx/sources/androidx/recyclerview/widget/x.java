package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public abstract class x extends androidx.recyclerview.widget.RecyclerView.m {

    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;
    public x() {
        super();
        final int i = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public abstract boolean animateAdd(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0);

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public boolean animateAppearance(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
        int i4;
        int i3;
        int i2;
        int i;
        i2 = c2.a;
        i = c3.a;
        if (c2 != null && i2 == i && c2.b != c3.b) {
            i2 = c2.a;
            i = c3.a;
            if (i2 == i) {
                if (c2.b != c3.b) {
                }
            }
            return this.animateMove(e0, i2, c2.b, i, c3.b);
        }
        return animateAdd(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public abstract boolean animateChange(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3, int i4, int i5, int i6);

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public boolean animateChange(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c4) {
        int i;
        int i2;
        int obj10;
        int obj11;
        if (e02.shouldIgnore()) {
            i2 = obj10;
            i = obj11;
        } else {
            i = obj10;
            i2 = obj11;
        }
        return this.animateChange(e0, e02, c3.a, c3.b, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public boolean animateDisappearance(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
        int left;
        int obj9;
        final int i2 = c2.a;
        final int i3 = c2.b;
        final View obj8 = e0.itemView;
        if (c3 == null) {
            left = obj8.getLeft();
        } else {
            left = c3.a;
        }
        final int i4 = left;
        if (c3 == null) {
            obj9 = obj8.getTop();
        } else {
            obj9 = c3.b;
        }
        final int i5 = obj9;
        if (!e0.isRemoved() && i2 == i4 && i3 != i5) {
            if (i2 == i4) {
                if (i3 != i5) {
                }
            }
            obj8.layout(i4, i5, obj9 += i4, height += i5);
            return this.animateMove(e0, i2, i3, i4, i5);
        }
        return animateRemove(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public abstract boolean animateMove(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2, int i3, int i4, int i5);

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public boolean animatePersistence(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
        int i2;
        int i;
        final int i3 = c2.a;
        final int i5 = c3.a;
        if (i3 == i5 && c2.b != c3.b) {
            if (c2.b != c3.b) {
            }
            dispatchMoveFinished(e0);
            return 0;
        }
        return this.animateMove(e0, i3, c2.b, i5, c3.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public abstract boolean animateRemove(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0);

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public boolean canReuseUpdatedViewHolder(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        int obj2;
        if (this.mSupportsChangeAnimations) {
            if (e0.isInvalid()) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchAddFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        onAddFinished(e0);
        dispatchAnimationFinished(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchAddStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        onAddStarting(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchChangeFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, boolean z2) {
        onChangeFinished(e0, z2);
        dispatchAnimationFinished(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchChangeStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, boolean z2) {
        onChangeStarting(e0, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchMoveFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        onMoveFinished(e0);
        dispatchAnimationFinished(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchMoveStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        onMoveStarting(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchRemoveFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        onRemoveFinished(e0);
        dispatchAnimationFinished(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public final void dispatchRemoveStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        onRemoveStarting(e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onAddFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onAddStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onChangeFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onChangeStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onMoveFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onMoveStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onRemoveFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void onRemoveStarting(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$m
    public void setSupportsChangeAnimations(boolean z) {
        this.mSupportsChangeAnimations = z;
    }
}
