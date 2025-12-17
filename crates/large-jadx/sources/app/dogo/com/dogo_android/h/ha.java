package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.g0.a;

/* loaded from: classes.dex */
public class ha extends app.dogo.com.dogo_android.h.ga implements b.a {

    private static final ViewDataBinding.g e0;
    private static final SparseIntArray f0;
    private final ConstraintLayout Y;
    private final app.dogo.com.dogo_android.h.gi Z;
    private final Button a0;
    private final View.OnClickListener b0;
    private final View.OnClickListener c0;
    private long d0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(12);
        ha.e0 = gVar;
        int i5 = 1;
        int[] iArr2 = new int[i5];
        final int i13 = 0;
        iArr2[i13] = 8;
        int[] iArr4 = new int[i5];
        iArr4[i13] = 2131558743;
        gVar.a(i13, /* result */, iArr2, iArr4);
        int[] iArr3 = new int[i5];
        iArr3[i13] = 7;
        int[] iArr = new int[i5];
        iArr[i13] = 2131558745;
        gVar.a(3, /* result */, iArr3, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        ha.f0 = sparseIntArray;
        sparseIntArray.put(2131363019, 9);
        sparseIntArray.put(2131363323, 10);
        sparseIntArray.put(2131363042, 11);
    }

    public ha(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, ha.e0, ha.f0));
    }

    private ha(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        final int i14 = 2;
        final int i15 = 1;
        super(e, view2, 3, (ImageView)object3Arr3[4], (ci)object3Arr3[8], (FrameLayout)object3Arr3[3], (FrameLayout)object3Arr3[5], (RelativeLayout)object3Arr3[9], (ObservableRecyclerView)object3Arr3[11], (ImageView)object3Arr3[i14], (SwipeRefreshLayout)object3Arr3[10], (TextView)object3Arr3[i15]);
        obj24.d0 = -1;
        int i12 = 0;
        obj24.O.setTag(i12);
        obj24.L(obj24.P);
        obj24.Q.setTag(i12);
        Object obj11 = object3Arr3[0];
        obj24.Y = (ConstraintLayout)obj11;
        obj11.setTag(i12);
        Object obj12 = object3Arr3[7];
        obj24.Z = (gi)obj12;
        obj24.L(obj12);
        Object obj13 = object3Arr3[6];
        obj24.a0 = (Button)obj13;
        obj13.setTag(i12);
        obj24.R.setTag(i12);
        obj24.T.setTag(i12);
        obj24.V.setTag(i12);
        obj24.N(view2);
        b bVar = new b(obj24, i14);
        obj24.b0 = bVar;
        b bVar2 = new b(obj24, i15);
        obj24.c0 = bVar2;
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.ci ci, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(g0 g0, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.d0 = l4 |= i12;
            return obj5;
            synchronized (this) {
                this.d0 = l4 |= i12;
                return obj5;
            }
        }
        if (i2 == 27) {
            this.d0 = l3 |= i11;
            return obj5;
            synchronized (this) {
                this.d0 = l3 |= i11;
                return obj5;
            }
        }
        if (i2 == 117) {
            this.d0 = l |= i9;
            return obj5;
            synchronized (this) {
                this.d0 = l |= i9;
                return obj5;
            }
        }
        if (i2 == 46) {
            this.d0 = l2 |= i10;
            return obj5;
            synchronized (this) {
                this.d0 = l2 |= i10;
                return obj5;
            }
        }
        return 0;
    }

    private boolean Z(a a, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void A() {
        this.d0 = 128;
        this.Z.A();
        this.P.A();
        I();
        return;
        synchronized (this) {
            this.d0 = 128;
            this.Z.A();
            this.P.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ga
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return X((ci)object2, i3);
            }
            return Z((a)object2, i3);
        }
        return Y((g0)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void M(q q) {
        super.M(q);
        this.Z.M(q);
        this.P.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((g0)object2);
            obj2 = 1;
        } else {
            if (116 == i) {
                V((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void V(a0 a0) {
        this.X = a0;
        this.d0 = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.X = a0;
            this.d0 = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void W(g0 g0) {
        R(0, g0);
        this.W = g0;
        this.d0 = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, g0);
            this.W = g0;
            this.d0 = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public final void b(int i, View view2) {
        a0 a0Var;
        g0 obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                obj3 = this.W;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.c2(this.S);
                }
            }
        } else {
            obj3 = this.W;
            if (obj3 != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                obj3.Q2(this.X);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ga
    protected void m() {
        int i7;
        int cmp2;
        int cmp;
        int cmp4;
        boolean z2;
        int i4;
        int i3;
        int cmp3;
        View.OnClickListener list;
        int i;
        int i6;
        int i8;
        int i5;
        boolean z;
        int cmp5;
        int i2;
        final Object obj = this;
        long l = obj.d0;
        final int i10 = 0;
        obj.d0 = i10;
        g0 g0Var = obj.W;
        int i14 = 131;
        final int i19 = 193;
        final int i21 = 0;
        i5 = 0;
        synchronized (this) {
            obj = this;
            l = obj.d0;
            i10 = 0;
            obj.d0 = i10;
            g0Var = obj.W;
            i14 = 131;
            i19 = 193;
            i21 = 0;
            i5 = 0;
        }
        if (Long.compare(i24, i10) != 0 && g0Var != null) {
            if (g0Var != null) {
                try {
                    i4 = g0Var.T();
                    i4 = i5;
                    if (Long.compare(i25, i10) != 0 && g0Var != null) {
                    } else {
                    }
                    if (g0Var != null) {
                    } else {
                    }
                    z = g0Var.a1();
                    z = i5;
                }
                if (g0Var != null) {
                    i = cmp5;
                } else {
                    i = i21;
                }
                obj.R(1, i);
                if (Long.compare(i2, i10) != 0 && g0Var != null) {
                    if (g0Var != null) {
                        i5 = g0Var.Y();
                    }
                }
                i6 = i4;
                i7 = i5;
                z2 = z;
                if (Long.compare(i23, i10) != 0) {
                    n.g0(obj.O, i21);
                    obj.Q.setOnClickListener(obj.c0);
                    obj.a0.setOnClickListener(obj.b0);
                    n.g0(obj.T, i21);
                }
                if (Long.compare(i18, i10) != 0) {
                    obj.P.w().setVisibility(i7);
                }
                if (Long.compare(i15, i10) != 0) {
                    obj.Z.T(i);
                }
                if (Long.compare(i17, i10) != 0) {
                    m.i(obj.R, z2);
                }
                if (Long.compare(i9, i10) != 0) {
                    obj.V.setVisibility(i6);
                }
                ViewDataBinding.o(obj.Z);
                ViewDataBinding.o(obj.P);
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Z.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
