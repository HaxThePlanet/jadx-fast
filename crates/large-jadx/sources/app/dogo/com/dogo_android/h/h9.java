package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.u.n.q.m.a;
import app.dogo.com.dogo_android.u.n.q.p;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogIntervalSelectBindingImpl.java */
/* loaded from: classes.dex */
public class h9 extends g9 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private long T;
    static {
        obj.put(2131363414, 2);
        obj.put(2131362105, 3);
    }

    public h9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, h9.U, h9.V));
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public void A() {
        synchronized (this) {
            try {
                this.T = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public void V(m.a aVar) {
        this.S = aVar;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public void W(p pVar) {
        this.R = pVar;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g9
    protected void m() {
        java.util.List list = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.T & 7L;
        if (l2 != l3 && this.R != null) {
            list = this.R.h();
        }
        if (l2 != l3) {
            BindingAdapters.e0(this.Q, list, this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private h9(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Button)objectArr[3], (ConstraintLayout)objectArr[0], (RecyclerView)objectArr[1], (TextView)objectArr[2]);
        this.T = -1L;
        Object obj5 = null;
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.g9
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
