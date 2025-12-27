package h.a.b.h;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.e0;
import h.a.b.b;
import java.util.List;

/* compiled from: AbstractFlexibleItem.java */
/* loaded from: classes2.dex */
public abstract class a<VH extends RecyclerView.e0> implements f<VH> {

    protected boolean mDraggable = true;
    protected boolean mEnabled = true;
    protected boolean mHidden = false;
    protected boolean mSelectable = true;
    protected boolean mSwipeable = true;
    public a() {
        super();
    }

    public String getBubbleText(int i) {
        return String.valueOf(i + 1);
    }

    public int getItemViewType() {
        return getLayoutRes();
    }

    public boolean isDraggable() {
        return this.mDraggable;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isHidden() {
        return this.mHidden;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public boolean isSwipeable() {
        return this.mSwipeable;
    }

    public void setDraggable(boolean z) {
        this.mDraggable = z;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setHidden(boolean z) {
        this.mHidden = z;
    }

    public void setSelectable(boolean z) {
        this.mSelectable = z;
    }

    public void setSwipeable(boolean z) {
        this.mSwipeable = z;
    }

    public abstract void bindViewHolder(b<f> bVar, VH vh, int i, List<Object> list);

    public abstract VH createViewHolder(View view, b<f> bVar);

    @Override // java.lang.Object
    public abstract boolean equals(Object object);

    public abstract int getLayoutRes();

    public int getSpanSize(int i, int i2) {
        return 1;
    }

    public void onViewAttached(b<f> bVar, VH vh, int i) {
    }

    public void onViewDetached(b<f> bVar, VH vh, int i) {
    }

    public boolean shouldNotifyChange(f fVar) {
        return true;
    }

    public void unbindViewHolder(b<f> bVar, VH vh, int i) {
    }
}
