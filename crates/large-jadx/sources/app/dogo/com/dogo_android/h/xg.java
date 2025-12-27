package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.x.b.d;

/* compiled from: FragmentTimeGoalNotAchievedScreenBindingImpl.java */
/* loaded from: classes.dex */
public class xg extends wg {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131363567, 6);
        obj.put(2131362563, 7);
        obj.put(2131362579, 8);
    }

    public xg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, xg.X, xg.Y));
    }

    @Override // app.dogo.com.dogo_android.h.wg
    public void A() {
        synchronized (this) {
            try {
                this.W = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wg
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

    @Override // app.dogo.com.dogo_android.h.wg
    public void V(d dVar) {
        this.U = dVar;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wg
    protected void m() {
        int i;
        Object obj;
        int motivationMessageRes = 0;
        app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics = null;
        long l;
        java.lang.CharSequence charSequence;
        synchronized (this) {
            try {
                l = 0L;
                this.W = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 3L & l2;
        motivationMessageRes = 0;
        i = 0;
        if (l4 != l) {
            if (this.U != null) {
                motivationMessageRes = this.U.getMotivationMessageRes();
                l = this.U.m();
                app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics2 = this.U.o();
                String str = this.U.l();
            } else {
            }
            int i2 = 2131886893;
            Object[] arr = new Object[1];
        } else {
        }
        if (l4 != l) {
            TrainingMetricsBindingAdapters.a(this.O, trainingTimeMetrics);
            g.c(this.P, obj);
            this.S.setText(motivationMessageRes);
            g.c(this.T, charSequence);
        }
        long l3 = l2 & 2L;
        if (this.W != l) {
            BindingAdapters.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
        }
    }

    @Override // app.dogo.com.dogo_android.h.wg
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

    private xg(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ArcProgressBar)objectArr[3], (TextView)objectArr[7], (TextView)objectArr[5], (MaterialButton)objectArr[8], (ImageView)objectArr[2], (TextView)objectArr[1], (TextView)objectArr[4], (ImageView)objectArr[6]);
        eVar3.W = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.V = obj9;
        obj9.setTag(obj10);
        eVar3.R.setTag(obj10);
        eVar3.S.setTag(obj10);
        eVar3.T.setTag(obj10);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wg
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
