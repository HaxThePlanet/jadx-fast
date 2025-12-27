package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* compiled from: CellClickerSelectRowBindingImpl.java */
/* loaded from: classes.dex */
public class f1 extends e1 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    public f1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, f1.S, f1.T));
    }

    @Override // app.dogo.com.dogo_android.h.e1
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e1
    public boolean O(int i, Object object) {
        boolean z = true;
        if (146 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.e1
    public void V(String str) {
        this.P = str;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(146);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.e1
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.R & 3L;
        if (l2 != l3) {
            g.c(this.O, this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.e1
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

    private f1(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (CheckedTextView)objectArr[1]);
        this.R = -1L;
        Object obj2 = objectArr[i2];
        this.Q = obj2;
        final Object obj3 = null;
        obj2.setTag(obj3);
        this.O.setTag(obj3);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.e1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
