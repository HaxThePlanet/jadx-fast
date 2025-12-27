package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.i.f0;
import app.dogo.com.dogo_android.i.m0;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellSimpleTextRoundedBindingImpl.java */
/* loaded from: classes.dex */
public class f7 extends e7 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final MaterialCardView R;
    private long S;
    static {
        obj.put(2131362264, 3);
    }

    public f7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, f7.T, f7.U));
    }

    @Override // app.dogo.com.dogo_android.h.e7
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e7
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

    @Override // app.dogo.com.dogo_android.h.e7
    public void V(m0 m0Var) {
        this.Q = m0Var;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.e7
    protected void m() {
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.S & 3L;
        if (l2 != l3 && this.Q != null) {
            String str = this.Q.b();
        }
        if (l2 != l3) {
            BindingAdapters.K(this.O, this.Q);
            g.c(this.P, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.e7
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

    private f7(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (TextView)objectArr[3], (TextView)objectArr[1]);
        this.S = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.R = obj5;
        obj5.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
