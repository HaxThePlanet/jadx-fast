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

/* loaded from: classes.dex */
public class f extends b<app.dogo.com.dogo_android.util.n0.f.b> {

    app.dogo.com.dogo_android.util.n0.h C0;
    HashMap<String, Long> D0;

    class a implements Comparator<app.dogo.com.dogo_android.util.n0.f.b> {
        a(app.dogo.com.dogo_android.util.n0.f f) {
            super();
        }

        @Override // java.util.Comparator
        public int a(app.dogo.com.dogo_android.util.n0.f.b f$b, app.dogo.com.dogo_android.util.n0.f.b f$b2) {
            return b.h().compareTo(b2.h());
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((f.b)object, (f.b)object2);
        }
    }

    public static class b extends a<app.dogo.com.dogo_android.util.n0.f.b.a> {

        private String a;
        ChallengeFilterItem.FilterTypes b;
        String c;
        public b(ChallengeFilterItem.FilterTypes challengeFilterItem$FilterTypes, String string2, String string3) {
            super();
            this.a = string2;
            this.c = string3;
            this.b = filterTypes;
            setSelectable(false);
        }

        @Override // h.a.b.h.a
        public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
            e(b, (f.b.a)e02, i3, list4);
        }

        @Override // h.a.b.h.a
        public RecyclerView.e0 createViewHolder(View view, b b2) {
            return f(view, b2);
        }

        public void e(b<f> b, app.dogo.com.dogo_android.util.n0.f.b.a f$b$a2, int i3, List<Object> list4) {
            a2.a(this.c);
        }

        @Override // h.a.b.h.a
        public boolean equals(Object object) {
            if (object instanceof f.b) {
                return this.a.equals(object.a);
            }
            return 0;
        }

        @Override // h.a.b.h.a
        public app.dogo.com.dogo_android.util.n0.f.b.a f(View view, b b2) {
            f.b.a aVar = new f.b.a(view, b2);
            return aVar;
        }

        @Override // h.a.b.h.a
        public ChallengeFilterItem.FilterTypes g() {
            return this.b;
        }

        @Override // h.a.b.h.a
        public int getLayoutRes() {
            return 2131558470;
        }

        @Override // h.a.b.h.a
        public String h() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.getId());
            stringBuilder.append(this.a);
            return stringBuilder.toString();
        }

        @Override // h.a.b.h.a
        public String i() {
            return this.a;
        }

        @Override // h.a.b.h.a
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("InstagramItem[");
            stringBuilder.append(super.toString());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
    public f(List<app.dogo.com.dogo_android.util.n0.f.b> list, app.dogo.com.dogo_android.util.n0.h h2) {
        super(list, 0, 1);
        HashSet obj3 = new HashSet();
        obj3 = new HashMap();
        this.D0 = obj3;
        this.C0 = h2;
    }

    private void d2(RecyclerView.e0 recyclerView$e0, View view2) {
        this.C0.a(e0.getAdapterPosition());
    }

    public void Z1(List<app.dogo.com.dogo_android.util.n0.f.b> list, boolean z2) {
        Object next;
        boolean key;
        Object valueOf;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!this.D0.containsKey((f.b)next.h())) {
            }
            this.D0.put(next.h(), Long.valueOf((long)size));
        }
        f.a aVar = new f.a(this);
        Collections.sort(list, aVar);
        super.Z1(list, z2);
    }

    @Override // h.a.b.b
    public void e2(RecyclerView.e0 recyclerView$e0, View view2) {
        d2(e0, view2);
    }

    @Override // h.a.b.b
    public long getItemId(int i) {
        Object valueOf;
        Object str;
        Long valueOf2;
        Object obj5;
        obj5 = O0(i);
        str = (f.b)obj5.h();
        if (obj5 != null && (Long)this.D0.get(str) == null) {
            str = obj5.h();
            if ((Long)this.D0.get(str) == null) {
                valueOf = Long.valueOf((long)size);
                this.D0.put(obj5.h(), Long.valueOf((long)size2));
            }
            return valueOf.longValue();
        }
        return 0;
    }

    @Override // h.a.b.b
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        final RecyclerView.e0 obj2 = super.onCreateViewHolder(viewGroup, i2);
        a aVar = new a(this, obj2);
        obj2.itemView.setOnClickListener(aVar);
        return obj2;
    }

    @Override // h.a.b.b
    public void removeItem(int i) {
        super.removeItem(i);
    }
}
