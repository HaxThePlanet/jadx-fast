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
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentChallengeHomeBindingImpl.java */
/* loaded from: classes.dex */
public class ha extends ga implements b.a {

    private static final ViewDataBinding.g e0 = new ViewDataBinding$g(12);
    private static final SparseIntArray f0 = new SparseIntArray();
    private final ConstraintLayout Y;
    private final gi Z;
    private final Button a0;
    private final View.OnClickListener b0;
    private final View.OnClickListener c0;
    private long d0;
    static {
        int i5 = 1;
        int[] iArr2 = new int[i5];
        final int i13 = 0;
        iArr2[i13] = 8;
        int[] iArr4 = new int[i5];
        iArr4[i13] = R.layout.layout_comment_input;
        obj.a(i13, new String[] { "layout_comment_input" }, iArr2, iArr4);
        int[] iArr3 = new int[i5];
        iArr3[i13] = 7;
        int[] iArr = new int[i5];
        iArr[i13] = R.layout.layout_custom_fab;
        obj.a(3, new String[] { "layout_custom_fab" }, iArr3, iArr);
        obj.put(2131363019, 9);
        obj.put(2131363323, 10);
        obj.put(2131363042, 11);
    }

    public ha(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, ha.e0, ha.f0));
    }

    private boolean X(ci ciVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(g0 g0Var, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw g0Var;
            }
        }
        if (i == 27) {
            synchronized (this) {
                try {
                    this.d0 |= 16;
                    return true;
                } catch (Throwable unused) {
                }
                throw g0Var;
            }
        }
        if (i == 117) {
            synchronized (this) {
                try {
                    this.d0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 46) {
            synchronized (this) {
                try {
                    this.d0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(app.dogo.com.dogo_android.util.g0.a aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void A() {
        synchronized (this) {
            try {
                this.d0 = 128L;
            } catch (Throwable th) {
            }
        }
        this.Z.A();
        this.P.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ga
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return X(object, i2);
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void M(q qVar) {
        super.M(qVar);
        this.Z.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void V(a0 a0Var) {
        this.X = a0Var;
        synchronized (this) {
            try {
                this.d0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public void W(g0 g0Var) {
        R(0, g0Var);
        this.W = g0Var;
        synchronized (this) {
            try {
                this.d0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.W != null) {
            }
            if (i2 != 0) {
                this.W.Q2(this.X);
            }
        } else {
            if (this.W == 2) {
                if (this.W != null) {
                }
                if (i2 != 0) {
                    this.W.c2(this.S);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ga
    protected void m() {
        int i;
        boolean z;
        app.dogo.com.dogo_android.util.g0.a aVar2;
        Object obj;
        int cmp5;
        final Object obj2 = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj2.d0 = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 243L & l3;
        long l7 = 131L;
        long l = 161L;
        final long l11 = 193L;
        final String str = null;
        i = 0;
        if (l6 != l5) {
            long l13 = l3 & 145L;
            if (l13 == l5 || obj2.W == null) {
            } else {
                i = obj2.W.T();
            }
            long l14 = l3 & 161L;
            if (l14 == l5 || obj2.W == null) {
            } else {
                z = obj2.W.a1();
            }
            long l15 = l3 & 131L;
            if (l15 != l5) {
                app.dogo.com.dogo_android.util.g0.a aVar = obj2.W != null ? aVar : str;
                int i2 = 1;
                obj2.R(i2, obj);
            } else {
                int i8 = str;
            }
            l2 = l3 & 193L;
            if (l2 != l5 && obj2.W != null) {
                i = obj2.W.Y();
            }
        } else {
            int i9 = str;
        }
        long l12 = l3 & 128L;
        if (l12 != l5) {
            BindingAdapters.g0(obj2.O, str);
            obj2.Q.setOnClickListener(obj2.c0);
            obj2.a0.setOnClickListener(obj2.b0);
            BindingAdapters.g0(obj2.T, str);
        }
        long l10 = l3 & 193L;
        if (obj2.O != l5) {
            obj2.P.w().setVisibility(i);
        }
        long l8 = 131L & l3;
        if (l8 != l5) {
            obj2.Z.T(aVar2);
        }
        long l9 = 161L & l3;
        if (l9 != l5) {
            app.dogo.com.dogo_android.util.binding.m.i(obj2.R, z);
        }
        long l4 = l3 & 145L;
        if (obj2.d0 != l5) {
            obj2.V.setVisibility(i);
        }
        ViewDataBinding.o(obj2.Z);
        ViewDataBinding.o(obj2.P);
    }

    @Override // app.dogo.com.dogo_android.h.ga
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.d0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Z.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        return false;
    }

    private ha(e eVar, View view, Object[] objectArr) {
        final Object eVar4 = this;
        final int i13 = 2;
        final int i14 = 1;
        super(eVar, view, 3, (ImageView)objectArr[4], (ci)objectArr[8], (FrameLayout)objectArr[3], (FrameLayout)objectArr[5], (RelativeLayout)objectArr[9], (ObservableRecyclerView)objectArr[11], (ImageView)objectArr[i13], (SwipeRefreshLayout)objectArr[10], (TextView)objectArr[i14]);
        eVar4.d0 = -1L;
        Object obj13 = null;
        eVar4.O.setTag(obj13);
        eVar4.L(eVar4.P);
        eVar4.Q.setTag(obj13);
        Object obj10 = objectArr[0];
        eVar4.Y = obj10;
        obj10.setTag(obj13);
        Object obj11 = objectArr[7];
        eVar4.Z = obj11;
        eVar4.L(obj11);
        Object obj12 = objectArr[6];
        eVar4.a0 = obj12;
        obj12.setTag(obj13);
        eVar4.R.setTag(obj13);
        eVar4.T.setTag(obj13);
        eVar4.V.setTag(obj13);
        eVar4.N(view);
        eVar4.b0 = new b(eVar4, i13);
        eVar4.c0 = new b(eVar4, i14);
        A();
    }
}
