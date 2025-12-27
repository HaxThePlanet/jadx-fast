package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import app.dogo.com.dogo_android.u.n.p.m.b.a;

/* compiled from: DialogDogLogSelectBindingImpl.java */
/* loaded from: classes.dex */
public class x8 extends w8 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    public x8(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, x8.T, x8.U));
    }

    @Override // app.dogo.com.dogo_android.h.w8
    public void A() {
        synchronized (this) {
            try {
                this.S = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.w8
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

    @Override // app.dogo.com.dogo_android.h.w8
    public void V(b.a aVar) {
        this.Q = aVar;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.w8
    public void W(app.dogo.com.dogo_android.u.n.p.m.e eVar) {
        this.P = eVar;
        synchronized (this) {
            try {
                this.S |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.w8
    protected void m() {
        java.util.List list = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.S & 7L;
        if (l2 != l3 && this.P != null) {
            list = this.P.h();
        }
        if (l2 != l3) {
            CalendarBindingAdapters.f(this.O, list, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.w8
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private x8(androidx.databinding.e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (RecyclerView)objectArr[1]);
        this.S = -1L;
        Object obj2 = objectArr[i2];
        this.R = obj2;
        final Object obj3 = null;
        obj2.setTag(obj3);
        this.O.setTag(obj3);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.w8
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
