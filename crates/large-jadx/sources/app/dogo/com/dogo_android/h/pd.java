package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;

/* compiled from: FragmentInnAppOneTenBindingImpl.java */
/* loaded from: classes.dex */
public class pd extends od {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131363278, 4);
        obj.put(2131362389, 5);
        obj.put(2131362644, 6);
        obj.put(2131362476, 7);
        obj.put(2131362897, 8);
        obj.put(2131363309, 9);
    }

    public pd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 10, pd.X, pd.Y));
    }

    @Override // app.dogo.com.dogo_android.h.od
    public void A() {
        synchronized (this) {
            try {
                this.W = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.od
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.od
    public void V(app.dogo.com.dogo_android.inappmessaging.n nVar) {
        this.U = nVar;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.od
    protected void m() {
        int i;
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.W = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 3L & l2;
        i = 0;
        if (l4 != l) {
            if (this.U != null) {
                InAppMessageDataHolder showRateUsDialog = this.U.shouldShowRateUsDialog();
            } else {
            }
            if (this.U != 0) {
            } else {
            }
        }
        if (l4 != l) {
            g.c(this.O, obj2);
            g.c(this.P, obj);
        }
        long l3 = l2 & 2L;
        if (this.W != l) {
            BindingAdapters.showSmoothMultiLoading(this.S, this.Q, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.od
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private pd(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (TextView)objectArr[2], (TextView)objectArr[1], (Guideline)objectArr[5], (TextView)objectArr[7], (ImageView)objectArr[6], (Button)objectArr[8], (OneTenRadioGroup)objectArr[3], (Guideline)objectArr[4], (MaterialButton)objectArr[9]);
        eVar3.W = -1L;
        Object obj11 = null;
        eVar3.O.setTag(obj11);
        eVar3.P.setTag(obj11);
        Object obj10 = objectArr[0];
        eVar3.V = obj10;
        obj10.setTag(obj11);
        eVar3.S.setTag(obj11);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.od
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
