package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.b0.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: ActivityLoginStateBindingImpl.java */
/* loaded from: classes.dex */
public class l extends k {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131363001, 2);
    }

    public l(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, l.S, l.T));
    }

    private boolean U(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean V(x<y<b0.a>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.k
    public void A() {
        synchronized (this) {
            try {
                this.R = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return U(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.k
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

    @Override // app.dogo.com.dogo_android.h.k
    public void T(b0 b0Var) {
        this.P = b0Var;
        synchronized (this) {
            try {
                this.R |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k
    protected void m() {
        int cmp;
        Object obj;
        y yVar = null;
        Object obj2;
        Object value2;
        y yVar2;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 15L & l;
        int i = 0;
        if (l4 != l3) {
            if (this.P != null) {
                x xVar2 = this.P.p();
                x xVar = this.P.q();
            } else {
            }
            Q(0, obj2);
            int i2 = 1;
            Q(i2, obj);
            value2 = obj2 != null ? (LoadResult)value2 : i;
            if (this.P != null) {
            }
        } else {
        }
        long l2 = l & 14L;
        if (this.R != l3) {
            BindingAdapters.z0(this.Q, yVar);
        }
        if (l4 != l3) {
            BindingAdapters.animateArrow(this.O, yVar, yVar2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private l(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ProgressBar)objectArr[2], (TextView)objectArr[1]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        N(view);
        A();
    }
}
