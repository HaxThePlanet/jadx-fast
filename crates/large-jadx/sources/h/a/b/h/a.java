package h.a.b.h;

import android.view.View;
import h.a.b.b;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a<VH extends androidx.recyclerview.widget.RecyclerView.e0>  implements h.a.b.h.f<VH> {

    protected boolean mDraggable = true;
    protected boolean mEnabled = true;
    protected boolean mHidden = false;
    protected boolean mSelectable = true;
    protected boolean mSwipeable = true;
    public a() {
        super();
        final int i = 1;
        final int i2 = 0;
    }

    public abstract void bindViewHolder(b<h.a.b.h.f> b, VH vh2, int i3, List<Object> list4);

    public abstract VH createViewHolder(View view, b<h.a.b.h.f> b2);

    @Override // h.a.b.h.f
    public abstract boolean equals(Object object);

    @Override // h.a.b.h.f
    public String getBubbleText(int i) {
        return String.valueOf(i++);
    }

    @Override // h.a.b.h.f
    public int getItemViewType() {
        return getLayoutRes();
    }

    @Override // h.a.b.h.f
    public abstract int getLayoutRes();

    @Override // h.a.b.h.f
    public int getSpanSize(int i, int i2) {
        return 1;
    }

    @Override // h.a.b.h.f
    public boolean isDraggable() {
        return this.mDraggable;
    }

    @Override // h.a.b.h.f
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // h.a.b.h.f
    public boolean isHidden() {
        return this.mHidden;
    }

    @Override // h.a.b.h.f
    public boolean isSelectable() {
        return this.mSelectable;
    }

    @Override // h.a.b.h.f
    public boolean isSwipeable() {
        return this.mSwipeable;
    }

    public void onViewAttached(b<h.a.b.h.f> b, VH vh2, int i3) {
    }

    public void onViewDetached(b<h.a.b.h.f> b, VH vh2, int i3) {
    }

    @Override // h.a.b.h.f
    public void setDraggable(boolean z) {
        this.mDraggable = z;
    }

    @Override // h.a.b.h.f
    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    @Override // h.a.b.h.f
    public void setHidden(boolean z) {
        this.mHidden = z;
    }

    @Override // h.a.b.h.f
    public void setSelectable(boolean z) {
        this.mSelectable = z;
    }

    @Override // h.a.b.h.f
    public void setSwipeable(boolean z) {
        this.mSwipeable = z;
    }

    @Override // h.a.b.h.f
    public boolean shouldNotifyChange(h.a.b.h.f f) {
        return 1;
    }

    public void unbindViewHolder(b<h.a.b.h.f> b, VH vh2, int i3) {
    }
}
