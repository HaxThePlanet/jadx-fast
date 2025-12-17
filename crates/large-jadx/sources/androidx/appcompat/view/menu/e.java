package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import d.a.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e implements androidx.appcompat.view.menu.m, AdapterView.OnItemClickListener {

    androidx.appcompat.view.menu.e.a A;
    private int B;
    Context a;
    LayoutInflater b;
    androidx.appcompat.view.menu.g c;
    androidx.appcompat.view.menu.ExpandedMenuView v;
    int w;
    int x;
    int y;
    private androidx.appcompat.view.menu.m.a z;

    private class a extends BaseAdapter {

        private int a = -1;
        final androidx.appcompat.view.menu.e b;
        public a(androidx.appcompat.view.menu.e e) {
            this.b = e;
            super();
            final int obj1 = -1;
            a();
        }

        @Override // android.widget.BaseAdapter
        void a() {
            ArrayList list;
            int size;
            int i;
            Object obj;
            androidx.appcompat.view.menu.i iVar = eVar.c.x();
            if (iVar != null) {
                list = eVar2.c.B();
                i = 0;
                while (i < list.size()) {
                    i++;
                }
            }
            this.a = -1;
        }

        @Override // android.widget.BaseAdapter
        public androidx.appcompat.view.menu.i b(int i) {
            int obj3;
            i += i2;
            int i3 = this.a;
            if (i3 >= 0 && obj3 >= i3) {
                if (obj3 >= i3) {
                    obj3++;
                }
            }
            return (i)eVar.c.B().get(obj3);
        }

        @Override // android.widget.BaseAdapter
        public int getCount() {
            size -= i3;
            if (this.a < 0) {
                return i;
            }
            return i--;
        }

        @Override // android.widget.BaseAdapter
        public Object getItem(int i) {
            return b(i);
        }

        @Override // android.widget.BaseAdapter
        public long getItemId(int i) {
            return (long)i;
        }

        @Override // android.widget.BaseAdapter
        public View getView(int i, View view2, ViewGroup viewGroup3) {
            LayoutInflater layoutInflater;
            View obj4;
            final int i2 = 0;
            if (view2 == null) {
                obj4 = this.b;
                obj4 = obj4.b.inflate(obj4.y, viewGroup3, i2);
            }
            (n.a)obj4.h(b(i), i2);
            return obj4;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
    public e(int i, int i2) {
        super();
        this.y = i;
        this.x = i2;
    }

    public e(Context context, int i2) {
        super(i2, 0);
        this.a = context;
        this.b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.m
    public ListAdapter a() {
        androidx.appcompat.view.menu.e.a aVar;
        if (this.A == null) {
            aVar = new e.a(this);
            this.A = aVar;
        }
        return this.A;
    }

    @Override // androidx.appcompat.view.menu.m
    public androidx.appcompat.view.menu.n b(ViewGroup viewGroup) {
        Object view;
        int i2;
        int i;
        androidx.appcompat.view.menu.e.a obj4;
        this.v = (ExpandedMenuView)this.b.inflate(g.g, viewGroup, false);
        if (this.v == null && this.A == null) {
            this.v = (ExpandedMenuView)this.b.inflate(g.g, viewGroup, false);
            if (this.A == null) {
                obj4 = new e.a(this);
                this.A = obj4;
            }
            this.v.setAdapter(this.A);
            this.v.setOnItemClickListener(this);
        }
        return this.v;
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(androidx.appcompat.view.menu.g g, boolean z2) {
        final androidx.appcompat.view.menu.m.a aVar = this.z;
        if (aVar != null) {
            aVar.c(g, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void d(boolean z) {
        final androidx.appcompat.view.menu.e.a obj1 = this.A;
        if (obj1 != null) {
            obj1.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(androidx.appcompat.view.menu.g g, androidx.appcompat.view.menu.i i2) {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g(androidx.appcompat.view.menu.g g, androidx.appcompat.view.menu.i i2) {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(androidx.appcompat.view.menu.m.a m$a) {
        this.z = a;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Context context, androidx.appcompat.view.menu.g g2) {
        Object contextThemeWrapper;
        int i;
        Object obj3;
        if (this.x != 0) {
            contextThemeWrapper = new ContextThemeWrapper(context, this.x);
            this.a = contextThemeWrapper;
            this.b = LayoutInflater.from(contextThemeWrapper);
        } else {
            this.a = context;
            if (this.a != null && this.b == null) {
                this.a = context;
                if (this.b == null) {
                    this.b = LayoutInflater.from(context);
                }
            }
        }
        this.c = g2;
        obj3 = this.A;
        if (obj3 != null) {
            obj3.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Parcelable parcelable) {
        k((Bundle)parcelable);
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(Bundle bundle) {
        Object str;
        final SparseArray obj2 = bundle.getSparseParcelableArray("android:menu:list");
        if (obj2 != null) {
            this.v.restoreHierarchyState(obj2);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean l(androidx.appcompat.view.menu.r r) {
        if (!r.hasVisibleItems()) {
            return 0;
        }
        h hVar = new h(r);
        hVar.b(0);
        androidx.appcompat.view.menu.m.a aVar = this.z;
        if (aVar != null) {
            aVar.d(r);
        }
        return 1;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable m() {
        if (this.v == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.m
    public void n(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        androidx.appcompat.view.menu.ExpandedMenuView view = this.v;
        if (view != null) {
            view.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long l4) {
        this.c.O(this.A.b(i3), this, 0);
    }
}
