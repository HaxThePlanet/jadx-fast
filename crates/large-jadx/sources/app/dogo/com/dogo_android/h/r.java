package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.k.k;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.p0;

/* compiled from: ActivityWelcomeScreenV2BindingImpl.java */
/* loaded from: classes.dex */
public class r extends q {

    private static final ViewDataBinding.g T = new ViewDataBinding$g(8);
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout Q;
    private final ml R;
    private long S;
    static {
        int i7 = 1;
        final int[] iArr = new int[i7];
        final int i14 = 0;
        iArr[i14] = 2;
        int[] iArr2 = new int[i7];
        iArr2[i14] = R.layout.layout_loading_spinner;
        obj.a(i7, new String[] { "layout_loading_spinner" }, iArr, iArr2);
        obj.put(2131362712, 3);
        obj.put(2131362713, 4);
        obj.put(2131363157, 5);
        obj.put(2131363158, 6);
        obj.put(2131362533, 7);
    }

    public r(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, r.T, r.U));
    }

    private boolean U(LiveData<y<k>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.S |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean V(LiveData<y<Boolean>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.S |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.q
    public void A() {
        synchronized (this) {
            try {
                this.S = 8L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return U(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.q
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.q
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.q
    public void T(p0 p0Var) {
        this.P = p0Var;
        synchronized (this) {
            try {
                this.S |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.q
    protected void m() {
        int cmp;
        LiveData liveData;
        y yVar;
        LiveData connectedToInternet;
        Object value;
        y yVar3;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 15L & l;
        final y yVar2 = null;
        if (l4 != l3) {
            if (this.P != null) {
                connectedToInternet = this.P.isConnectedToInternet();
                liveData = this.P.o();
            } else {
            }
            Q(0, connectedToInternet);
            int i3 = 1;
            Q(i3, liveData);
            value = connectedToInternet != null ? (LoadResult)value : yVar2;
            Object value2 = this.P != null ? (LoadResult)value2 : yVar2;
        } else {
        }
        long l2 = l & 14L;
        if (this.S != l3) {
            BindingAdapters.x0(this.Q, yVar);
        }
        if (l4 != l3) {
            BindingAdapters.setAdapter(this.O, yVar, yVar3, yVar2);
        }
        ViewDataBinding.o(this.R);
    }

    @Override // app.dogo.com.dogo_android.h.q
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private r(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (FrameLayout)objectArr[7], (ImageView)objectArr[3], (ImageView)objectArr[4], (FrameLayout)objectArr[1], (ImageView)objectArr[5], (ImageView)objectArr[6]);
        this.S = -1L;
        Object obj8 = objectArr[0];
        this.Q = obj8;
        Object obj7 = null;
        obj8.setTag(obj7);
        Object obj9 = objectArr[2];
        this.R = obj9;
        L(obj9);
        this.O.setTag(obj7);
        N(view);
        A();
    }
}
