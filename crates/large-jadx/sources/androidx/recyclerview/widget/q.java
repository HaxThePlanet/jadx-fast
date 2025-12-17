package androidx.recyclerview.widget;

import java.util.List;

/* loaded from: classes.dex */
public abstract class q<T, VH extends androidx.recyclerview.widget.RecyclerView.e0>  extends androidx.recyclerview.widget.RecyclerView.h<VH> {

    final androidx.recyclerview.widget.d<T> mDiffer;
    private final androidx.recyclerview.widget.d.b<T> mListener;

    class a implements androidx.recyclerview.widget.d.b<T> {

        final androidx.recyclerview.widget.q a;
        a(androidx.recyclerview.widget.q q) {
            this.a = q;
            super();
        }

        public void a(List<T> list, List<T> list2) {
            this.a.onCurrentListChanged(list, list2);
        }
    }
    protected q(androidx.recyclerview.widget.h.f<T> h$f) {
        super();
        q.a aVar = new q.a(this);
        this.mListener = aVar;
        b bVar = new b(this);
        c.a aVar2 = new c.a(f);
        d dVar = new d(bVar, aVar2.a());
        this.mDiffer = dVar;
        dVar.a(aVar);
    }

    protected T getItem(int i) {
        return this.mDiffer.b().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.mDiffer.b().size();
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    public void submitList(List<T> list) {
        this.mDiffer.e(list);
    }
}
