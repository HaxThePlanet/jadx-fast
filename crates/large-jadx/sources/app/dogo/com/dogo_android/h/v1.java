package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;

/* compiled from: CellDogLogTypeSelectionBindingImpl.java */
/* loaded from: classes.dex */
public class v1 extends u1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    public v1(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, v1.U, v1.V));
    }

    @Override // app.dogo.com.dogo_android.h.u1
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u1
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

    @Override // app.dogo.com.dogo_android.h.u1
    public void V(app.dogo.com.dogo_android.k.e eVar) {
        this.R = eVar;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u1
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.T & 3L;
        if (l2 != l3) {
            CalendarBindingAdapters.setDogLogIcon(this.O, this.R);
            CalendarBindingAdapters.setDogLogCounter(this.P, this.R);
            CalendarBindingAdapters.o(this.Q, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u1
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

    private v1(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[1], (ImageView)objectArr[2], (TextView)objectArr[3]);
        this.T = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.S = obj5;
        obj5.setTag(obj4);
        this.P.setTag(obj4);
        this.Q.setTag(obj4);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.u1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
