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

/* compiled from: CellDogLogTypeBindingImpl.java */
/* loaded from: classes.dex */
public class t1 extends s1 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    public t1(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, t1.V, t1.W));
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public void A() {
        synchronized (this) {
            try {
                this.U = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 135;
            if (135 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public void V(app.dogo.com.dogo_android.k.e eVar) {
        this.R = eVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public void W(Boolean boolean) {
        this.S = boolean;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(135);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s1
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        if (l4 != l3) {
            CalendarBindingAdapters.h(this.O, this.R, this.S);
        }
        long l2 = l & 5L;
        if (this.U != l3) {
            CalendarBindingAdapters.setDogLogSelectionAdapter(this.P, this.R);
            CalendarBindingAdapters.o(this.Q, this.R);
            CalendarBindingAdapters.p(this.Q, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s1
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

    private t1(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[1], (ImageView)objectArr[2], (TextView)objectArr[3]);
        this.U = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        this.P.setTag(obj4);
        Object obj5 = objectArr[0];
        this.T = obj5;
        obj5.setTag(obj4);
        this.Q.setTag(obj4);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.s1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
