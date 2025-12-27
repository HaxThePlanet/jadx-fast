package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.n0;

/* compiled from: FragmentOnboardingProgramGenerationBindingImpl.java */
/* loaded from: classes.dex */
public class ve extends ue implements b.a {

    private static final ViewDataBinding.g V = new ViewDataBinding$g(5);
    private static final SparseIntArray W = new SparseIntArray();
    private final View.OnClickListener T;
    private long U;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 3;
        int[] iArr = new int[i3];
        iArr[i7] = R.layout.layout_onboarding_tool_bar;
        obj.a(i7, new String[] { "layout_onboarding_tool_bar" }, iArr2, iArr);
        obj.put(2131361928, 4);
    }

    public ve(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, ve.V, ve.W));
    }

    private boolean W(ql qlVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(LiveData<y<RecommendedOrderedPrograms>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public void A() {
        synchronized (this) {
            try {
                this.U = 8L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ue
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ue
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

    @Override // app.dogo.com.dogo_android.h.ue
    public void V(n0 n0Var) {
        this.S = n0Var;
        synchronized (this) {
            try {
                this.U |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.m();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ue
    protected void m() {
        LiveData result;
        n0 n0Var;
        y yVar = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.U = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 14L & l2;
        if (l4 != l) {
            if (this.S != null) {
                result = this.S.getResult();
            } else {
            }
            int i2 = 1;
            Q(i2, result);
            if (this.S != null) {
            }
        }
        if (l4 != l) {
            BindingAdapters.setTrainerAvatar(this.O, yVar);
            BindingAdapters.getShortDogName(this.P, yVar);
        }
        long l3 = l2 & 8L;
        if (this.U != l) {
            this.P.setOnClickListener(this.T);
            int i3 = 4;
            this.Q.T(Integer.valueOf(i3));
            this.Q.U(Integer.valueOf(i3));
            str = "walking_dog";
            BindingAdapters.getMessageFromException(this.R, str);
        }
        ViewDataBinding.o(this.Q);
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.U != 0) {
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

    private ve(e eVar, View view, Object[] objectArr) {
        int i5 = 1;
        super(eVar, view, 2, (kotlinx.coroutines.AnimatedTextView)objectArr[4], (ConstraintLayout)objectArr[0], (Button)objectArr[2], (ql)objectArr[3], (ImageView)objectArr[i5]);
        this.U = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        L(this.Q);
        this.R.setTag(obj6);
        N(view);
        this.T = new b(this, i5);
        A();
    }
}
