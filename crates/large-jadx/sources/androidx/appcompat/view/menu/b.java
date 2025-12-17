package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements androidx.appcompat.view.menu.m {

    private int A;
    protected Context a;
    protected Context b;
    protected androidx.appcompat.view.menu.g c;
    protected LayoutInflater v;
    private androidx.appcompat.view.menu.m.a w;
    private int x;
    private int y;
    protected androidx.appcompat.view.menu.n z;
    public b(Context context, int i2, int i3) {
        super();
        this.a = context;
        this.v = LayoutInflater.from(context);
        this.x = i2;
        this.y = i3;
    }

    @Override // androidx.appcompat.view.menu.m
    protected void a(View view, int i2) {
        android.view.ViewParent parent = view.getParent();
        if ((ViewGroup)parent != null) {
            (ViewGroup)parent.removeView(view);
        }
        (ViewGroup)this.z.addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.m
    public abstract void b(androidx.appcompat.view.menu.i i, androidx.appcompat.view.menu.n.a n$a2);

    @Override // androidx.appcompat.view.menu.m
    public void c(androidx.appcompat.view.menu.g g, boolean z2) {
        final androidx.appcompat.view.menu.m.a aVar = this.w;
        if (aVar != null) {
            aVar.c(g, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void d(boolean z) {
        Object gVar;
        int i2;
        int size;
        int i3;
        int i;
        Object obj;
        boolean childAt;
        androidx.appcompat.view.menu.i itemData;
        View view;
        final androidx.appcompat.view.menu.n obj10 = this.z;
        if ((ViewGroup)obj10 == null) {
        }
        gVar = this.c;
        i2 = 0;
        if (gVar != null) {
            gVar.t();
            gVar = this.c.G();
            i = i3;
            while (i3 < gVar.size()) {
                obj = gVar.get(i3);
                if (s(i, (i)obj)) {
                }
                i3++;
                childAt = (ViewGroup)obj10.getChildAt(i);
                if (childAt instanceof n.a) {
                } else {
                }
                itemData = 0;
                view = p(obj, childAt, obj10);
                if (obj != itemData) {
                }
                if (view != childAt) {
                }
                i++;
                a(view, i);
                view.setPressed(i2);
                view.jumpDrawablesToCurrentState();
                itemData = (n.a)childAt.getItemData();
            }
            i2 = i;
        }
        while (i2 < obj10.getChildCount()) {
            if (n(obj10, i2) == null) {
            }
            i2++;
        }
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
        return this.A;
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(androidx.appcompat.view.menu.m.a m$a) {
        this.w = a;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Context context, androidx.appcompat.view.menu.g g2) {
        this.b = context;
        LayoutInflater.from(context);
        this.c = g2;
    }

    @Override // androidx.appcompat.view.menu.m
    public androidx.appcompat.view.menu.n.a k(ViewGroup viewGroup) {
        return (n.a)this.v.inflate(this.y, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean l(androidx.appcompat.view.menu.r r) {
        androidx.appcompat.view.menu.g obj2;
        final androidx.appcompat.view.menu.m.a aVar = this.w;
        if (aVar != null) {
            if (r != null) {
            } else {
                obj2 = this.c;
            }
            return aVar.d(obj2);
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    protected boolean n(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return 1;
    }

    @Override // androidx.appcompat.view.menu.m
    public androidx.appcompat.view.menu.m.a o() {
        return this.w;
    }

    @Override // androidx.appcompat.view.menu.m
    public View p(androidx.appcompat.view.menu.i i, View view2, ViewGroup viewGroup3) {
        Object obj3;
        if (view2 instanceof n.a) {
        } else {
            obj3 = k(viewGroup3);
        }
        b(i, obj3);
        return (View)obj3;
    }

    @Override // androidx.appcompat.view.menu.m
    public androidx.appcompat.view.menu.n q(ViewGroup viewGroup) {
        Object nVar;
        int i;
        int i2;
        ViewGroup obj4;
        if (this.z == null) {
            obj4 = this.v.inflate(this.x, viewGroup, false);
            this.z = (n)obj4;
            obj4.b(this.c);
            d(true);
        }
        return this.z;
    }

    @Override // androidx.appcompat.view.menu.m
    public void r(int i) {
        this.A = i;
    }

    @Override // androidx.appcompat.view.menu.m
    public abstract boolean s(int i, androidx.appcompat.view.menu.i i2);
}
