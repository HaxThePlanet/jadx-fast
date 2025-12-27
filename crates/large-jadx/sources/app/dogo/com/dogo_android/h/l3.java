package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep;

/* compiled from: CellLibraryTrickVideoStepBindingImpl.java */
/* loaded from: classes.dex */
public class l3 extends k3 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131362594, 2);
        obj.put(2131362595, 3);
        obj.put(2131362964, 4);
    }

    public l3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, l3.T, l3.U));
    }

    @Override // app.dogo.com.dogo_android.h.k3
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k3
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

    @Override // app.dogo.com.dogo_android.h.k3
    public void V(TrickItem.VideoStep videoStep) {
        this.Q = videoStep;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k3
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
            String description = this.Q.getDescription();
        }
        if (l2 != l3) {
            g.c(this.O, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k3
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

    private l3(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (Guideline)objectArr[2], (Guideline)objectArr[3], (PlayerView)objectArr[4]);
        this.S = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.R = obj6;
        obj6.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
