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

/* compiled from: CellSimpleTextInputBindingImpl.java */
/* loaded from: classes.dex */
public class d7 extends c7 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final MaterialCardView T;
    private long U;
    static {
        obj.put(2131362264, 3);
        obj.put(2131362665, 4);
        obj.put(2131363172, 5);
    }

    public d7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, d7.V, d7.W));
    }

    @Override // app.dogo.com.dogo_android.h.c7
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c7
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

    @Override // app.dogo.com.dogo_android.h.c7
    public void V(m0 m0Var) {
        this.S = m0Var;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c7
    protected void m() {
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.U & 3L;
        if (l2 != l3 && this.S != null) {
            String str = this.S.b();
        }
        if (l2 != l3) {
            BindingAdapters.K(this.O, this.S);
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c7
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

    private d7(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (TextView)objectArr[3], (EditText)objectArr[4], (TextView)objectArr[1], (MaterialButton)objectArr[5]);
        this.U = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.T = obj7;
        obj7.setTag(obj6);
        this.Q.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
