package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChallengeFilterListAdapter.java */
/* loaded from: classes.dex */
public class f extends b<f.b> {

    h C0;
    HashMap<String, Long> D0 = new HashMap<>();

    class a implements Comparator<f.b> {
        a() {
            super();
        }

        public int a(f.b bVar, f.b bVar2) {
            return bVar.h().compareTo(bVar2.h());
        }
    }

    public static class b extends a<f.b.a> {

        private String a;
        ChallengeFilterItem.FilterTypes b;
        String c;
        public b(ChallengeFilterItem.FilterTypes filterTypes, String str, String str2) {
            super();
            this.a = str;
            this.c = str2;
            this.b = filterTypes;
            setSelectable(false);
        }

        @Override // h.a.b.h.a
        public void e(b<f> bVar, f.b.a aVar, int i, List<Object> list) {
            aVar.a(this.c);
        }

        @Override // h.a.b.h.a
        public boolean equals(Object object) {
            if (object instanceof app.dogo.com.dogo_android.util.recycle_views.f.b) {
                return this.a.equals(object.a);
            }
            return false;
        }

        @Override // h.a.b.h.a
        public f.b.a f(View view, b bVar) {
            return new app.dogo.com.dogo_android.util.recycle_views.f.b.a(view, bVar);
        }

        @Override // h.a.b.h.a
        public ChallengeFilterItem.FilterTypes g() {
            return this.b;
        }

        @Override // h.a.b.h.a
        public String h() {
            StringBuilder stringBuilder = new StringBuilder();
            String id = this.b.getId();
            str = id + this.a;
            return str;
        }

        @Override // h.a.b.h.a
        public String i() {
            return this.a;
        }

        @Override // h.a.b.h.a
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "InstagramItem[";
            String object = super.toString();
            String str3 = "]";
            str = str2 + object + str3;
            return str;
        }

        @Override // h.a.b.h.a
        public int getLayoutRes() {
            return R.layout.cell_challenge_filter_list_row;
        }
    }
    public f(List<f.b> list, h hVar) {
        super(list, null, true);
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        this.C0 = hVar;
    }

    private /* synthetic */ void d2(RecyclerView.e0 e0Var, View view) {
        this.C0.a(e0Var.getAdapterPosition());
    }

    @Override // h.a.b.b
    public void Z1(List<f.b> list, boolean z) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        Collections.sort(list, new app.dogo.com.dogo_android.util.recycle_views.f.a(this));
        super.Z1(list, z);
    }

    @Override // h.a.b.b
    public long getItemId(int i) {
        Object value;
        f fVar = O0(i);
        if (fVar != null) {
            String str = fVar.h();
            if ((Long)this.D0.get(str) == null) {
                Long num2 = Long.valueOf((long)this.D0.size());
                this.D0.put(fVar.h(), Long.valueOf((long)this.D0.size()));
            }
            return value.longValue();
        }
        return 0;
    }

    @Override // h.a.b.b
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        final RecyclerView.e0 onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        onCreateViewHolder.itemView.setOnClickListener(new app.dogo.com.dogo_android.util.recycle_views.a(this, onCreateViewHolder));
        return onCreateViewHolder;
    }

    @Override // h.a.b.b
    public void removeItem(int i) {
        super.removeItem(i);
    }

    @Override // h.a.b.b
    public /* synthetic */ void e2(RecyclerView.e0 e0Var, View view) {
        d2(e0Var, view);
    }
}
