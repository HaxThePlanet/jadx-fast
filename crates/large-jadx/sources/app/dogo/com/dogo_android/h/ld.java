package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.m.b;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: FragmentGoodExampleVideoBindingImpl.java */
/* loaded from: classes.dex */
public class ld extends kd {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0 = new SparseIntArray();
    private final ConstraintLayout Y;
    private long Z;
    static {
        obj.put(2131363433, 5);
        obj.put(2131362346, 6);
        obj.put(2131361947, 7);
        obj.put(2131363331, 8);
        obj.put(2131361948, 9);
        obj.put(2131362590, 10);
    }

    public ld(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, ld.a0, ld.b0));
    }

    private boolean W(x<y<List<GoodTrickExample>>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Z |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.kd
    public void A() {
        synchronized (this) {
            try {
                this.Z = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kd
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.kd
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

    @Override // app.dogo.com.dogo_android.h.kd
    public void V(b bVar) {
        this.X = bVar;
        synchronized (this) {
            try {
                this.Z |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kd
    protected void m() {
        app.dogo.com.dogo_android.util.c0 c0Var;
        int i = 0;
        y yVar = null;
        Object obj;
        int i2 = 0;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.Z = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        i = 0;
        if (l4 != l3) {
            if (this.X != null) {
                x xVar = this.X.n();
                c0Var = this.X.p();
            } else {
            }
            i2 = 0;
            Q(i2, obj);
            if (obj != null) {
                Object value = obj.getValue();
            }
        } else {
        }
        if (l4 != l3) {
            TrainingBindingAdapters.B(this.R, yVar, c0Var, this.V, this.Q, this.O, this.P);
            BindingAdapters.z0(this.T, yVar);
        }
        long l2 = l & 4L;
        if (this.Z != l3) {
            TrainingBindingAdapters.setSimpleTrickListAdapter(this.S, this.R);
            TrainingBindingAdapters.setWorkoutCoverAdapter(this.U, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kd
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Z != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private ld(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 1, (ImageView)objectArr[7], (ImageView)objectArr[9], (TextView)objectArr[6], (ViewPager2)objectArr[1], (Guideline)objectArr[10], (View)objectArr[2], (ProgressBar)objectArr[4], (View)objectArr[3], (TabLayout)objectArr[8], (MaterialToolbar)objectArr[5]);
        eVar3.Z = -1L;
        Object obj12 = null;
        eVar3.R.setTag(obj12);
        eVar3.S.setTag(obj12);
        Object obj11 = objectArr[0];
        eVar3.Y = obj11;
        obj11.setTag(obj12);
        eVar3.T.setTag(obj12);
        eVar3.U.setTag(obj12);
        N(view);
        A();
    }
}
