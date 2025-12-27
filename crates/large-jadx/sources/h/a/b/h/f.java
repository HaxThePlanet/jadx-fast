package h.a.b.h;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.e0;
import h.a.b.b;
import java.util.List;

/* compiled from: IFlexible.java */
/* loaded from: classes2.dex */
public interface f<VH extends RecyclerView.e0> {
    void bindViewHolder(b<f> bVar, VH vh, int i, List<Object> list);

    VH createViewHolder(View view, b<f> bVar);

    int getItemViewType();

    int getLayoutRes();

    boolean isDraggable();

    boolean isEnabled();

    boolean isHidden();

    boolean isSelectable();

    boolean isSwipeable();

    void onViewAttached(b<f> bVar, VH vh, int i);

    void onViewDetached(b<f> bVar, VH vh, int i);

    void setDraggable(boolean z);

    void setHidden(boolean z);

    void setSelectable(boolean z);

    boolean shouldNotifyChange(f fVar);

    void unbindViewHolder(b<f> bVar, VH vh, int i);
}
