package app.dogo.com.dogo_android.util.e0;

import androidx.recyclerview.widget.RecyclerView.e0;
import h.a.b.h.f;

/* compiled from: SortableIFlexible.java */
/* loaded from: classes.dex */
public interface b0<VH extends RecyclerView.e0> extends f<VH> {
    String getId();

    int getSortingPriority();

    boolean isContentSame(b0 b0Var);
}
