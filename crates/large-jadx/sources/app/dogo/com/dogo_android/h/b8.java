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
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellWorkoutTrickBindingImpl.java */
/* loaded from: classes.dex */
public class b8 extends a8 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131362112, 4);
    }

    public b8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, b8.V, b8.W));
    }

    @Override // app.dogo.com.dogo_android.h.a8
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a8
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

    @Override // app.dogo.com.dogo_android.h.a8
    public void V(TrickItem trickItem) {
        this.S = trickItem;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a8
    protected void m() {
        Object obj = null;
        Object obj2;
        String imageUrl;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.U & 3L;
        if (l2 == l3 || this.S == null) {
        } else {
            String name = this.S.getName();
        }
        if (l2 != l3) {
            g.c(this.P, obj);
            g.c(this.Q, obj2);
            BindingAdapters.w(this.R, imageUrl);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a8
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

    private b8(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (CardView)objectArr[4], (TextView)objectArr[3], (TextView)objectArr[2], (ImageView)objectArr[1]);
        this.U = -1L;
        Object obj5 = null;
        this.P.setTag(obj5);
        Object obj6 = objectArr[0];
        this.T = obj6;
        obj6.setTag(obj5);
        this.Q.setTag(obj5);
        this.R.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a8
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
