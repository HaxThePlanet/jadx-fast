package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.f.k.h;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDailyWorkoutOverviewBindingImpl.java */
/* loaded from: classes.dex */
public class ra extends qa implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final CoordinatorLayout T;
    private final ConstraintLayout U;
    private final View.OnClickListener V;
    private long W;
    static {
        obj.put(2131363433, 4);
        obj.put(2131362649, 5);
        obj.put(2131362645, 6);
        obj.put(2131362338, 7);
        obj.put(2131362111, 8);
        obj.put(2131362662, 9);
        obj.put(2131363414, 10);
        obj.put(2131362298, 11);
        obj.put(2131363421, 12);
        obj.put(2131362063, 13);
    }

    public ra(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 14, ra.X, ra.Y));
    }

    private boolean W(LiveData<y<WorkoutSession>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.qa
    public void A() {
        synchronized (this) {
            try {
                this.W = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qa
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qa
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

    @Override // app.dogo.com.dogo_android.h.qa
    public void V(h hVar) {
        this.S = hVar;
        synchronized (this) {
            try {
                this.W |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qa
    public final void b(int i, View view) {
        int view22;
        view22 = 1;
        view22 = 0;
        int r1 = this.S != null ? 1 : view22;
        if (view22 != null && liveData != null) {
            if (view22 != null) {
                this.S.o((LoadResult)liveData.getValue());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.qa
    protected void m() {
        LiveData liveData;
        y yVar;
        int i = 0;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.W = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        final Boolean bool = null;
        if (l4 != l3) {
            if (this.S != null) {
                liveData = this.S.i();
            } else {
                int i2 = bool;
            }
            i = 0;
            Q(i, liveData);
            Object value = this.S != null ? (LoadResult)value : bool;
        }
        if (l4 != l3) {
            BindingAdapters.setTrainerAvatar(this.T, yVar);
            TrainingBindingAdapters.setLibraryTrickAdapter(this.R, yVar);
        }
        long l2 = l & 4L;
        if (this.W != l3) {
            BindingAdapters.k0(this.U, bool);
            this.P.setOnClickListener(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qa
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

    private ra(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Space)objectArr[13], (ConstraintLayout)objectArr[8], (TextView)objectArr[11], (ImageView)objectArr[7], (Guideline)objectArr[6], (Guideline)objectArr[5], (ImageView)objectArr[9], (Button)objectArr[2], (TextView)objectArr[10], (TextView)objectArr[12], (MaterialToolbar)objectArr[4], (RecyclerView)obj);
        Object eVar4 = this;
        eVar4.W = -1L;
        Object obj13 = objectArr[0];
        eVar4.T = obj13;
        Object obj14 = null;
        obj13.setTag(obj14);
        int i15 = 1;
        Object obj15 = objectArr[i15];
        eVar4.U = obj15;
        obj15.setTag(obj14);
        eVar4.P.setTag(obj14);
        eVar4.R.setTag(obj14);
        eVar4.N(view);
        eVar4.V = new b(eVar4, i15);
        A();
    }
}
