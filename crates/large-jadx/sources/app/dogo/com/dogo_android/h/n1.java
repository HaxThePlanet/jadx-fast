package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.u.n.p.g.a;

/* compiled from: CellDogLogCalendarDayBindingImpl.java */
/* loaded from: classes.dex */
public class n1 extends m1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362731, 3);
        obj.put(2131362345, 4);
    }

    public n1(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, n1.U, n1.V));
    }

    @Override // app.dogo.com.dogo_android.h.m1
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m1
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.m1
    public void V(g.a aVar) {
        this.R = aVar;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m1
    protected void m() {
        long l;
        long l2;
        int i;
        Object obj = null;
        boolean z = false;
        int i3 = 2131099715;
        int i2 = 64;
        synchronized (this) {
            try {
                final long l6 = 0L;
                this.T = l6;
            } catch (Throwable th) {
            }
        }
        int i5 = 0;
        final long l7 = 3L;
        long l8 = l & l7;
        i = 0;
        if (l8 != l6) {
            if (this.R != null) {
                z = this.R.g();
                i = this.R.f();
                i = this.R.b();
            } else {
            }
            if (l8 != l6) {
                if (z) {
                    l2 = (l | 8L) | 32L;
                    i2 = 128;
                } else {
                    l2 = (l | 4L) | 16L;
                    i2 = 64;
                }
                l = l2 | i2;
            }
            int r10 = z ? R.color.calendar_active : R.color.white;
            int i6 = 2131100352;
            int i4 = 2131099840;
            if (z) {
                i = ViewDataBinding.u(this.Q, i6);
            } else {
                i = ViewDataBinding.u(this.Q, i4);
            }
            if (z) {
                i = ViewDataBinding.u(this.P, i6);
            } else {
                i = ViewDataBinding.u(this.P, i4);
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "";
            str = i + str2;
        } else {
        }
        l &= l7;
        if (this.T != l6) {
            h.a(this.S, b.b(i));
            this.P.setTextColor(i);
            g.c(this.P, obj);
            this.Q.setTextColor(i);
            CalendarBindingAdapters.s(this.Q, Integer.valueOf(i));
        }
    }

    @Override // app.dogo.com.dogo_android.h.m1
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

    private n1(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (DogLogView)objectArr[4], (LinearLayout)objectArr[3], (TextView)objectArr[1], (TextView)objectArr[2]);
        this.T = -1L;
        Object obj5 = objectArr[0];
        this.S = obj5;
        final Object obj6 = null;
        obj5.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
