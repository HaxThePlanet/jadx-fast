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
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;

/* compiled from: LayoutDashboardTimerSquareSegmentBindingImpl.java */
/* loaded from: classes.dex */
public class dk extends ck {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131363412, 2);
        obj.put(2131363413, 3);
    }

    public dk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, dk.V, dk.W));
    }

    @Override // app.dogo.com.dogo_android.h.ck
    public void A() {
        synchronized (this) {
            try {
                this.U = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ck
    public boolean O(int i, Object object) {
        int i2 = 156;
        boolean z = true;
        i2 = 156;
        if (156 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 158;
            if (158 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ck
    public void T(Long long) {
        this.S = long;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(156);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ck
    public void U(v2.b bVar) {
        this.R = bVar;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(158);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ck
    protected void m() {
        int cmp;
        synchronized (this) {
            try {
                long l = 0L;
                this.U = l;
            } catch (Throwable th) {
            }
        }
        long l5 = 5L & l2;
        long l3 = l2 & 6L;
        if (this.U != l) {
            SubscriptionBindingAdapters.setDiscountTimerLabel(this.O, this.R);
        }
        if (l5 != l) {
            SubscriptionBindingAdapters.setupTimerSegment(this.T, this.S, this.Q, this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ck
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private dk(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (TextView)objectArr[2], (TextView)objectArr[3]);
        this.U = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.T = obj5;
        obj5.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ck
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
