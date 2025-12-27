package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.u.f;

/* compiled from: FragmentProgramLessonExamUnlockedBindingImpl.java */
/* loaded from: classes.dex */
public class pf extends of {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131362690, 4);
        obj.put(2131361985, 5);
        obj.put(2131363421, 6);
        obj.put(2131362411, 7);
        obj.put(2131362700, 8);
    }

    public pf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, pf.X, pf.Y));
    }

    private boolean W(LiveData<y<Boolean>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.of
    public void A() {
        synchronized (this) {
            try {
                this.W = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.of
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.of
    public boolean O(int i, Object object) {
        boolean z = true;
        if (179 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.of
    public void V(f fVar) {
        this.U = fVar;
        synchronized (this) {
            try {
                this.W |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(179);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.of
    protected void m() {
        long l;
        boolean z;
        int cmp2 = 4;
        y yVar = null;
        LiveData result;
        boolean z2;
        int i2 = 32;
        long l3;
        int i3 = 16;
        synchronized (this) {
            try {
                final long l5 = 0L;
                this.W = l5;
            } catch (Throwable th) {
            }
        }
        final long l6 = 7L;
        long l7 = l & l6;
        cmp2 = 0;
        if (l7 != l5) {
            if (this.U != null) {
                result = this.U.getResult();
            } else {
            }
            Q(cmp2, result);
            if (result != null) {
                Object value = result.getValue();
            }
            if (this.U != null) {
                z2 = this.U.l(yVar);
                z = this.U.k(yVar);
            } else {
            }
            if (l7 != l5) {
                int r11 = z2 ? 64 : 32;
                l = l | (z2 ? 64 : 32);
            }
            l3 = l & 7L;
            if (l3 != l5 && this.U) {
                i3 = 16;
                l = l | i3;
            }
            cmp2 = 4;
            int r9 = cmp2;
            if (!(this.U)) {
            }
        } else {
        }
        l2 = 4L & l;
        if (l2 != l5) {
            BindingAdapters.X(this.V, this.P);
            BindingAdapters.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
        }
        l &= l6;
        if (this.W != l5) {
            this.S.setVisibility(cmp2);
            this.T.setVisibility(cmp2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.of
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

    private pf(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 1, (ImageView)objectArr[5], (TextView)objectArr[7], (KonfettiView)objectArr[4], (TextView)objectArr[8], (ImageView)objectArr[1], (Button)objectArr[3], (TextView)objectArr[6], (Button)objectArr[2]);
        eVar3.W = -1L;
        Object obj9 = objectArr[0];
        eVar3.V = obj9;
        Object obj10 = null;
        obj9.setTag(obj10);
        eVar3.R.setTag(obj10);
        eVar3.S.setTag(obj10);
        eVar3.T.setTag(obj10);
        N(view);
        A();
    }
}
