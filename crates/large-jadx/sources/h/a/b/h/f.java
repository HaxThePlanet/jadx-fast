package h.a.b.h;

import android.view.View;
import h.a.b.b;
import java.util.List;

/* loaded from: classes2.dex */
public interface f<VH extends androidx.recyclerview.widget.RecyclerView.e0>  {
    public abstract void bindViewHolder(b<h.a.b.h.f> b, VH vh2, int i3, List<Object> list4);

    public abstract VH createViewHolder(View view, b<h.a.b.h.f> b2);

    public abstract int getItemViewType();

    public abstract int getLayoutRes();

    public abstract boolean isDraggable();

    public abstract boolean isEnabled();

    public abstract boolean isHidden();

    public abstract boolean isSelectable();

    public abstract boolean isSwipeable();

    public abstract void onViewAttached(b<h.a.b.h.f> b, VH vh2, int i3);

    public abstract void onViewDetached(b<h.a.b.h.f> b, VH vh2, int i3);

    public abstract void setDraggable(boolean z);

    public abstract void setHidden(boolean z);

    public abstract void setSelectable(boolean z);

    public abstract boolean shouldNotifyChange(h.a.b.h.f f);

    public abstract void unbindViewHolder(b<h.a.b.h.f> b, VH vh2, int i3);
}
