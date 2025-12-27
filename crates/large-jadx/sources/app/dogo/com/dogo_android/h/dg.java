package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.d0.n.a;
import app.dogo.com.dogo_android.y.d0.o;

/* compiled from: FragmentProgramTrainingPlanBindingImpl.java */
/* loaded from: classes.dex */
public class dg extends cg {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(6);
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final ConstraintLayout U;
    private long V;
    static {
        int i5 = 1;
        final int[] iArr = new int[i5];
        final int i10 = 0;
        iArr[i10] = 2;
        int[] iArr2 = new int[i5];
        iArr2[i10] = R.layout.layout_program_training_plan;
        obj.a(i5, new String[] { "layout_program_training_plan" }, iArr, iArr2);
        obj.put(2131363433, 3);
        obj.put(2131363182, 4);
        obj.put(2131363287, 5);
    }

    public dg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, dg.W, dg.X));
    }

    private boolean Y(mm mmVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(x<TrickItem> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(LiveData<y<TrickItem>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void A() {
        synchronized (this) {
            try {
                this.V = 64L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cg
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return Y(object, i2);
        }
        return a0(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public boolean O(int i, Object object) {
        int i2 = 177;
        boolean z = true;
        i2 = 137;
        if (137 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                X(object);
            } else {
                i2 = 141;
                if (141 == i) {
                    W(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void V(n.a aVar) {
        this.R = aVar;
        synchronized (this) {
            try {
                this.V |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(137);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void X(o oVar) {
        this.S = oVar;
        synchronized (this) {
            try {
                this.V |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cg
    protected void m() {
        long l;
        Object value = null;
        o oVar;
        int cmp5 = 0;
        int i2 = 0;
        java.util.List list = null;
        int i3 = 1;
        int i = 0;
        LiveData result = null;
        Object value2 = null;
        y yVar = null;
        int i4 = 128;
        int cmp6;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l3 = 0L;
                obj.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 83L & l;
        long l5 = 82L;
        final long l8 = 80L;
        long l9 = 81L;
        i3 = 0;
        if (l4 != l3) {
            long l11 = l & 80L;
            if (l11 != l3) {
                if (obj.S != null) {
                    TrainingSession trainingSession = obj.S.i();
                } else {
                    cmp5 = 0;
                }
                if (cmp5 != 0) {
                    java.util.List trainingTricksList = cmp5.getTrainingTricksList();
                } else {
                    i2 = 0;
                }
            }
            long l12 = l & 81L;
            if (l12 != l3) {
                result = obj.S != null ? result : 0;
                obj.Q(0, result);
                value2 = result != null ? (LoadResult)value2 : 0;
            }
            long l13 = l & 82L;
            if (l13 != l3) {
                if (obj.S != null) {
                    x xVar = obj.S.h();
                } else {
                    int i5 = 0;
                }
                i3 = 1;
                obj.Q(i3, value);
                if (obj.S != null) {
                } else {
                    int i12 = 0;
                }
                if (value == null) {
                    i3 = 0;
                }
                if (l13 != l3) {
                    int r16 = i3 != 0 ? 256 : 128;
                    l = l | (i3 != 0 ? 256 : 128);
                }
                if (i3 != 0) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
        } else {
            int i7 = 0;
            i = 0;
            int i11 = 0;
        }
        long l10 = 81L & l;
        if (l10 != l3) {
            BindingAdapters.setTrainerAvatar(obj.T, yVar);
        }
        long l6 = 82L & l;
        if (l6 != l3) {
            obj.Q.w().setVisibility(i);
        }
        long l7 = 72L & l;
        if (l7 != l3) {
            obj.Q.T(obj.R);
        }
        l &= l8;
        if (obj.V != l3) {
            obj.Q.U(list);
        }
        ViewDataBinding.o(obj.Q);
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Q.y()) {
            return true;
        }
        return false;
    }

    private dg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 3, (NestedScrollView)objectArr[4], (Button)objectArr[5], (MaterialToolbar)objectArr[3], (mm)objectArr[2]);
        this.V = -1L;
        Object obj6 = objectArr[0];
        this.T = obj6;
        Object obj5 = null;
        obj6.setTag(obj5);
        Object obj7 = objectArr[1];
        this.U = obj7;
        obj7.setTag(obj5);
        L(this.Q);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void W(l lVar) {
    }
}
