package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* compiled from: ActivityMainBindingImpl.java */
/* loaded from: classes.dex */
public class n extends m {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(7);
    private static final SparseIntArray V = new SparseIntArray();
    private final ml S;
    private long T;
    static {
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 2;
        int[] iArr2 = new int[i6];
        iArr2[i12] = R.layout.layout_loading_spinner;
        obj.a(i6, new String[] { "layout_loading_spinner" }, iArr, iArr2);
        obj.put(2131362533, 3);
        obj.put(2131363244, 4);
        obj.put(2131362866, 5);
        obj.put(2131362551, 6);
    }

    public n(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, n.U, n.V));
    }

    private boolean V(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(f.d.a.a<y<Boolean>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(f.d.a.a<y<Boolean>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void A() {
        synchronized (this) {
            try {
                this.T = 32L;
            } catch (Throwable th) {
            }
        }
        this.S.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return W(object, i2);
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void M(q qVar) {
        super.M(qVar);
        this.S.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.m
    public boolean O(int i, Object object) {
        int i2 = 138;
        boolean z = true;
        i2 = 138;
        if (138 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void T(l lVar) {
        this.R = lVar;
        synchronized (this) {
            try {
                this.T |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(138);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void U(app.dogo.com.dogo_android.a0.g.e eVar) {
        this.Q = eVar;
        synchronized (this) {
            try {
                this.T |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m
    protected void m() {
        int cmp;
        Object obj;
        int i;
        y yVar;
        Object value;
        y yVar2 = null;
        Object obj2;
        y yVar3;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 63L & l;
        i = 0;
        if (l4 != l3) {
            if (this.R != null) {
                x xVar = this.R.B();
                f.d.a.a aVar = this.R.D();
            } else {
            }
            Q(0, obj2);
            Q(2, obj);
            if (this.Q != null) {
                f.d.a.a aVar2 = this.Q.s();
            } else {
            }
            int i2 = 1;
            Q(i2, value);
            Object value3 = obj2 != null ? (LoadResult)value3 : i;
            Object value2 = this.R != null ? (LoadResult)value2 : i;
            if (this.Q != null) {
            }
        } else {
        }
        long l2 = l & 44L;
        if (this.T != l3) {
            BindingAdapters.x0(this.P, yVar2);
        }
        if (l4 != l3) {
            BindingAdapters.setAdapter(this.P, yVar, yVar2, yVar3);
        }
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.m
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.S.y()) {
            return true;
        }
        return false;
    }

    private n(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 3, (ConstraintLayout)objectArr[0], (FrameLayout)objectArr[3], (FrameLayout)objectArr[6], (BottomNavigationView)objectArr[5], (FrameLayout)objectArr[1], (CoordinatorLayout)objectArr[4]);
        this.T = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        Object obj8 = objectArr[2];
        this.S = obj8;
        L(obj8);
        this.P.setTag(obj7);
        N(view);
        A();
    }
}
