package zendesk.belvedere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
class f extends RecyclerView.h<RecyclerView.e0> {

    private List<zendesk.belvedere.h.b> a;
    private List<zendesk.belvedere.h.b> b;
    private List<zendesk.belvedere.h.b> c;

    interface b {
        public abstract boolean a(zendesk.belvedere.h.b h$b);

        public abstract void b();
    }

    class a extends RecyclerView.e0 {
        a(zendesk.belvedere.f f, View view2) {
            super(view2);
        }
    }
    f() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.c = arrayList3;
    }

    private void i(List<zendesk.belvedere.h.b> list, List<zendesk.belvedere.h.b> list2) {
        ArrayList arrayList = new ArrayList(size += size2);
        arrayList.addAll(list);
        arrayList.addAll(list2);
        this.a = list;
        this.b = list2;
        this.c = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    void f(zendesk.belvedere.h.b h$b) {
        i(Collections.singletonList(b), this.b);
    }

    void g(List<zendesk.belvedere.h.b> list) {
        i(this.a, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public long getItemId(int i) {
        return (h.b)this.c.get(i).b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (h.b)this.c.get(i).c();
    }

    void h(List<zendesk.belvedere.s> list) {
        android.net.Uri uri;
        boolean next;
        boolean contains;
        ArrayList arrayList = new ArrayList(this.b);
        HashSet hashSet = new HashSet();
        Iterator obj5 = list.iterator();
        for (s next3 : obj5) {
            hashSet.add(next3.k());
        }
        obj5 = arrayList.iterator();
        for (h.b next : obj5) {
            next.f(hashSet.contains(next.d().k()));
        }
        i(this.a, arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        (h.b)this.c.get(i2).a(e0.itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        f.a obj4 = new f.a(this, LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
        return obj4;
    }
}
