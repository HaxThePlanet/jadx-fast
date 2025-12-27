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

/* compiled from: CellDailyTrickBindingImpl.java */
/* loaded from: classes.dex */
public class j1 extends i1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    public j1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, j1.U, j1.V));
    }

    @Override // app.dogo.com.dogo_android.h.i1
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i1
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.i1
    public void T(TrickItem trickItem) {
        this.R = trickItem;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i1
    protected void m() {
        Object obj = null;
        Object obj2;
        String imageUrl;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.T & 3L;
        if (l2 == l3 || this.R == null) {
        } else {
            String name = this.R.getName();
        }
        if (l2 != l3) {
            g.c(this.O, obj);
            g.c(this.P, obj2);
            BindingAdapters.w(this.Q, imageUrl);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i1
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

    private j1(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[3], (TextView)objectArr[2], (ImageView)objectArr[1]);
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


    @Override // app.dogo.com.dogo_android.h.i1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
