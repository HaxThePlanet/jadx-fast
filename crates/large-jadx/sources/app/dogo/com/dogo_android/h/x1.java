package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;

/* compiled from: CellDogParentBindingImpl.java */
/* loaded from: classes.dex */
public class x1 extends w1 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private long R;
    public x1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, x1.S, x1.T));
    }

    @Override // app.dogo.com.dogo_android.h.w1
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.w1
    public boolean O(int i, Object object) {
        boolean z = true;
        if (66 == i) {
            W(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.w1
    public void W(DogParentUIState.DogParent dogParent) {
        this.Q = dogParent;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(66);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.w1
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
            DogProfileBindingAdapters.w(this.P, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.w1
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

    private x1(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (TextView)objectArr[1]);
        this.R = -1L;
        Object obj3 = null;
        this.O.setTag(obj3);
        this.P.setTag(obj3);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.w1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
