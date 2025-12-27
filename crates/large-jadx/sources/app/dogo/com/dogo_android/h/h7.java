package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.i.m0.a;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellSimpleToogleSwitchBindingImpl.java */
/* loaded from: classes.dex */
public class h7 extends g7 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final MaterialCardView R;
    private long S;
    public h7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, h7.T, h7.U));
    }

    @Override // app.dogo.com.dogo_android.h.g7
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g7
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

    @Override // app.dogo.com.dogo_android.h.g7
    public void V(m0.a aVar) {
        this.Q = aVar;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g7
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
            String str = this.Q.b();
            z = this.Q.c();
        }
        if (l2 != l3) {
            g.c(this.O, obj);
            a.a(this.P, z);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g7
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

    private h7(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (SwitchMaterial)objectArr[2]);
        this.S = -1L;
        Object obj3 = objectArr[0];
        this.R = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.g7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
