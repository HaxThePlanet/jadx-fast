package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.i.q0;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellJsonArrayEditBindingImpl.java */
/* loaded from: classes.dex */
public class x2 extends w2 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final MaterialCardView R;
    private long S;
    public x2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, x2.T, x2.U));
    }

    @Override // app.dogo.com.dogo_android.h.w2
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.w2
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

    @Override // app.dogo.com.dogo_android.h.w2
    public void V(q0 q0Var) {
        this.Q = q0Var;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.w2
    protected void m() {
        Object obj = null;
        boolean z = false;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        int i2 = 0;
        long l2 = this.S & 3L;
        if (l2 != l3 && this.Q != null) {
            String component1 = this.Q.component1();
            z = this.Q.b();
        }
        if (l2 != l3) {
            a.a(this.O, z);
            g.c(this.P, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.w2
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

    private x2(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (CheckBox)objectArr[1], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj3 = null;
        this.O.setTag(obj3);
        Object obj4 = objectArr[0];
        this.R = obj4;
        obj4.setTag(obj3);
        this.P.setTag(obj3);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.w2
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
