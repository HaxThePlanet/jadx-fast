package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.u.n.p.e;
import app.dogo.com.dogo_android.u.n.p.f;
import app.dogo.com.dogo_android.u.n.p.g.a;
import app.dogo.com.dogo_android.u.n.p.j;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class lc extends app.dogo.com.dogo_android.h.kc implements c.a {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final CoordinatorLayout Z;
    private final SwipeRefreshLayout.j a0;
    private long b0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(14);
        lc.c0 = gVar;
        int i9 = 1;
        final int[] iArr2 = new int[i9];
        final int i20 = 0;
        iArr2[i20] = 6;
        int[] iArr = new int[i9];
        iArr[i20] = 2131558789;
        gVar.a(2, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        lc.d0 = sparseIntArray;
        sparseIntArray.put(2131363435, 7);
        sparseIntArray.put(2131362878, 8);
        sparseIntArray.put(2131362732, 9);
        sparseIntArray.put(2131362332, 10);
        sparseIntArray.put(2131362331, 11);
        sparseIntArray.put(2131363352, 12);
        sparseIntArray.put(2131363554, 13);
    }

    public lc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 14, lc.c0, lc.d0));
    }

    private lc(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 2, (ImageView)object3Arr3[11], (ImageView)object3Arr3[10], (LinearLayout)object3Arr3[9], (ConstraintLayout)object3Arr3[2], (NestedScrollView)object3Arr3[8], (RecyclerView)object3Arr3[3], (ConstraintLayout)object3Arr3[0], (SwipeRefreshLayout)object3Arr3[1], (RecyclerView)object3Arr3[5], (ConstraintLayout)object3Arr3[12], (ol)object3Arr3[6], (Toolbar)object3Arr3[7], (View)object3Arr3[13]);
        Object obj4 = this;
        obj4.b0 = -1;
        Object obj2 = object3Arr3[4];
        obj4.Z = (CoordinatorLayout)obj2;
        int i3 = 0;
        obj2.setTag(i3);
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.S.setTag(i3);
        obj4.L(obj4.U);
        obj4.N(view2);
        c cVar = new c(obj4, 1);
        obj4.a0 = cVar;
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.ol ol, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<y<List<g.a>>> x, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void A() {
        this.b0 = 16;
        this.U.A();
        I();
        return;
        synchronized (this) {
            this.b0 = 16;
            this.U.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kc
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((ol)object2, i3);
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void M(q q) {
        super.M(q);
        this.U.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((f)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((j)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void V(f f) {
        this.Y = f;
        this.b0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Y = f;
            this.b0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void W(j j) {
        this.X = j;
        this.b0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.X = j;
            this.b0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public final void a(int i) {
        int i2;
        final j obj2 = this.X;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kc
    protected void m() {
        int cmp5;
        int i2;
        int cmp;
        int cmp3;
        int i3;
        int i;
        int i4;
        int value;
        int cmp2;
        int cmp4;
        long l = this.b0;
        final int i6 = 0;
        this.b0 = i6;
        final f fVar = this.Y;
        j jVar = this.X;
        cmp = Long.compare(i8, i6);
        final int i9 = 28;
        i3 = 0;
        synchronized (this) {
            l = this.b0;
            i6 = 0;
            this.b0 = i6;
            fVar = this.Y;
            jVar = this.X;
            cmp = Long.compare(i8, i6);
            i9 = 28;
            i3 = 0;
        }
        try {
            if (jVar != null) {
            } else {
            }
            i4 = jVar.m();
            i4 = i3;
            Q(0, i4);
            if (i4 != 0) {
            } else {
            }
            value = i4.getValue();
            value = i3;
        }
        if (jVar != null) {
            i3 = jVar.o();
        }
        i2 = i3;
        i3 = value;
        if (Long.compare(i12, i6) != 0) {
            n.G0(this.Z, i3);
            n.y0(this.R, i3);
        }
        if (cmp != 0) {
            e.e(this.P, i3, fVar, this.U);
        }
        if (Long.compare(i, i6) != 0) {
            this.R.setOnRefreshListener(this.a0);
        }
        if (Long.compare(i5, i6) != 0) {
            e.m(this.S, i2, fVar);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.U.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
