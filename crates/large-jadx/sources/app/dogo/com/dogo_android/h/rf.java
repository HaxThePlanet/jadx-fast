package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.w.l.b;
import app.dogo.com.dogo_android.y.w.o;

/* loaded from: classes.dex */
public class rf extends app.dogo.com.dogo_android.h.qf implements c.a {

    private static final ViewDataBinding.g f0;
    private static final SparseIntArray g0;
    private final SwipeRefreshLayout.j d0;
    private long e0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(12);
        rf.f0 = gVar;
        int i5 = 1;
        final int[] iArr2 = new int[i5];
        final int i12 = 0;
        iArr2[i12] = 8;
        int[] iArr = new int[i5];
        iArr[i12] = 2131558798;
        gVar.a(2, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        rf.g0 = sparseIntArray;
        sparseIntArray.put(2131363433, 9);
        sparseIntArray.put(2131362878, 10);
        sparseIntArray.put(2131363511, 11);
    }

    public rf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, rf.f0, rf.g0));
    }

    private rf(e e, View view2, Object[] object3Arr3) {
        Object obj27 = this;
        super(e, view2, 4, (gm)object3Arr3[8], (MaterialButton)object3Arr3[6], (FrameLayout)object3Arr3[5], (ConstraintLayout)object3Arr3[2], (NestedScrollView)object3Arr3[10], (TextView)object3Arr3[3], (TextView)object3Arr3[4], (RecyclerView)object3Arr3[7], (ConstraintLayout)object3Arr3[0], (SwipeRefreshLayout)object3Arr3[1], (MaterialToolbar)object3Arr3[9], (Button)object3Arr3[11]);
        Object obj15 = this;
        obj15.e0 = -1;
        obj15.L(obj15.O);
        int i13 = 0;
        obj15.P.setTag(i13);
        obj15.Q.setTag(i13);
        obj15.R.setTag(i13);
        obj15.T.setTag(i13);
        obj15.U.setTag(i13);
        obj15.V.setTag(i13);
        obj15.W.setTag(i13);
        obj15.X.setTag(i13);
        obj15.N(view2);
        c cVar = new c(obj15, 1);
        obj15.d0 = cVar;
        A();
    }

    private boolean Y(app.dogo.com.dogo_android.h.gm gm, int i2) {
        if (i2 == 0) {
            this.e0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.e0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<String> x, int i2) {
        if (i2 == 0) {
            this.e0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.e0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(x<String> x, int i2) {
        if (i2 == 0) {
            this.e0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.e0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(LiveData<y<Program>> liveData, int i2) {
        if (i2 == 0) {
            this.e0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.e0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void A() {
        this.e0 = 128;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.e0 = 128;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return Y((gm)object2, i3);
                }
                return a0((x)object2, i3);
            }
            return b0((LiveData)object2, i3);
        }
        return Z((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((l.b)object2);
            obj2 = 1;
        } else {
            if (38 == i) {
                W((Boolean)object2);
            } else {
                if (177 == i) {
                    X((o)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void V(l.b l$b) {
        this.b0 = b;
        this.e0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.b0 = b;
            this.e0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void W(Boolean boolean) {
        this.c0 = boolean;
        this.e0 = l |= i2;
        notifyPropertyChanged(38);
        super.I();
        return;
        synchronized (this) {
            this.c0 = boolean;
            this.e0 = l |= i2;
            notifyPropertyChanged(38);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void X(o o) {
        this.a0 = o;
        this.e0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.a0 = o;
            this.e0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public final void a(int i) {
        int i2;
        final o obj2 = this.a0;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    protected void m() {
        Boolean bool;
        int i;
        int cmp4;
        int cmp7;
        int cmp;
        int cmp3;
        long l;
        int i9;
        int i5;
        x value2;
        Object obj;
        int i4;
        int i3;
        int i11;
        int i6;
        Object value;
        int value3;
        int i12;
        int cmp8;
        int i10;
        int cmp5;
        int valueOf;
        int i7;
        int i8;
        int cmp6;
        app.dogo.com.dogo_android.h.gm gmVar;
        int i2;
        int result;
        int cmp2;
        final Object obj2 = this;
        l = obj2.e0;
        final int i13 = 0;
        obj2.e0 = i13;
        value2 = obj2.a0;
        int cmp9 = Long.compare(i15, i13);
        i10 = 0;
        synchronized (this) {
            obj2 = this;
            l = obj2.e0;
            i13 = 0;
            obj2.e0 = i13;
            value2 = obj2.a0;
            cmp9 = Long.compare(i15, i13);
            i10 = 0;
        }
        bool = ViewDataBinding.K(obj2.c0);
        if (cmp9 != 0) {
            if (bool) {
                try {
                    i7 = 512;
                    i7 = 256;
                    l |= i7;
                    if (bool) {
                    } else {
                    }
                    i = 8;
                    i = i10;
                }
                int i20 = 196;
                final int i24 = 210;
                final int i25 = 194;
                i2 = 0;
                if (Long.compare(i19, i13) != 0) {
                    if (Long.compare(result, i13) != 0) {
                        if (value2 != null) {
                            i4 = value2.p();
                            i6 = result;
                        } else {
                            i4 = i10;
                            i6 = i2;
                        }
                        obj2.Q(1, i6);
                        if (i6 != 0) {
                            value = i6.getValue();
                        } else {
                            value = i2;
                        }
                    } else {
                        i4 = i10;
                    }
                    if (Long.compare(i26, i13) != 0) {
                        if (value2 != null) {
                            cmp8 = value2.n();
                        } else {
                            cmp8 = i2;
                        }
                        obj2.Q(i10, cmp8);
                        if (cmp8 != 0) {
                            value3 = cmp8.getValue();
                        } else {
                            value3 = i2;
                        }
                    } else {
                    }
                    if (Long.compare(i27, i13) != 0 && value2 != null) {
                        if (value2 != null) {
                            i10 = value2.l();
                        }
                    }
                    if (Long.compare(i28, i13) != 0) {
                        if (value2 != null) {
                            value2 = value2.o();
                        } else {
                            value2 = i2;
                        }
                        obj2.Q(2, value2);
                        if (value2 != null) {
                            i2 = value2;
                        }
                    }
                    i5 = i4;
                    obj = value;
                    i3 = i2;
                } else {
                    i5 = i10;
                    value3 = i3;
                }
                if (Long.compare(i21, i13) != 0) {
                    n.w0(obj2.P, obj);
                    l.s0(obj2.R, obj, Boolean.valueOf(i10), obj2.O);
                    n.F0(obj2.W, obj);
                    n.y0(obj2.X, obj);
                }
                if (Long.compare(i23, i13) != 0) {
                    obj2.Q.setVisibility(i);
                }
                if (Long.compare(i16, i13) != 0) {
                    g.c(obj2.T, i3);
                }
                if (Long.compare(valueOf, i13) != 0) {
                    g.c(obj2.U, value3);
                }
                if (Long.compare(i11, i13) != 0) {
                    l.b0(obj2.V, obj, obj2.b0, obj2.Z, obj2.S, Boolean.valueOf(i5));
                }
                if (Long.compare(i9, i13) != 0) {
                    obj2.X.setOnRefreshListener(obj2.d0);
                }
                ViewDataBinding.o(obj2.O);
            } else {
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
