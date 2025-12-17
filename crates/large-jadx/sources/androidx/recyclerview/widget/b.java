package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class b implements androidx.recyclerview.widget.r {

    private final androidx.recyclerview.widget.RecyclerView.h a;
    public b(androidx.recyclerview.widget.RecyclerView.h recyclerView$h) {
        super();
        this.a = h;
    }

    @Override // androidx.recyclerview.widget.r
    public void onChanged(int i, int i2, Object object3) {
        this.a.notifyItemRangeChanged(i, i2, object3);
    }

    @Override // androidx.recyclerview.widget.r
    public void onInserted(int i, int i2) {
        this.a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.r
    public void onMoved(int i, int i2) {
        this.a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.r
    public void onRemoved(int i, int i2) {
        this.a.notifyItemRangeRemoved(i, i2);
    }
}
