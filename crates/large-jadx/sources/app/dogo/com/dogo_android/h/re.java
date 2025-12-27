package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.d0;
import app.dogo.com.dogo_android.welcome_v2.g0;

/* compiled from: FragmentOnboardingDogNameV2BindingImpl.java */
/* loaded from: classes.dex */
public class re extends qe {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(9);
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout V;
    private final ml W;
    private long X;
    static {
        int i5 = 1;
        int[] iArr2 = new int[i5];
        final int i13 = 0;
        iArr2[i13] = 4;
        int[] iArr4 = new int[i5];
        iArr4[i13] = R.layout.layout_onboarding_tool_bar;
        obj.a(i13, new String[] { "layout_onboarding_tool_bar" }, iArr2, iArr4);
        int[] iArr3 = new int[i5];
        iArr3[i13] = 5;
        int[] iArr = new int[i5];
        iArr[i13] = R.layout.layout_loading_spinner;
        obj.a(2, new String[] { "layout_loading_spinner" }, iArr3, iArr);
        obj.put(2131363421, 6);
        obj.put(2131362859, 7);
        obj.put(2131362888, 8);
    }

    public re(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, re.Y, re.Z));
    }

    private boolean W(ql qlVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(f.d.a.a<y<DogProfile>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public void A() {
        synchronized (this) {
            try {
                this.X = 8L;
            } catch (Throwable th) {
            }
        }
        this.T.A();
        this.W.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qe
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public void M(q qVar) {
        super.M(qVar);
        this.T.M(qVar);
        this.W.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.qe
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

    @Override // app.dogo.com.dogo_android.h.qe
    public void V(g0 g0Var) {
        this.U = g0Var;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qe
    protected void m() {
        int cmp;
        Object obj;
        y yVar = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 14L & l;
        if (l4 != l3 && this.U != null) {
            f.d.a.a aVar = this.U.o();
            int i2 = 1;
            Q(i2, obj);
            if (this.U != null) {
            }
        }
        long l2 = l & 8L;
        if (this.X != l3) {
            OnboardingBindingAdapters.d(this.O, this.R);
            this.T.U(4);
        }
        if (l4 != l3) {
            BindingAdapters.setDebugJsonEntryItemAdapter(this.P, yVar);
            BindingAdapters.setTrainerAvatar(this.S, yVar);
        }
        ViewDataBinding.o(this.T);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.T.y()) {
            return true;
        }
        if (this.W.y()) {
            return true;
        }
        return false;
    }

    private re(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (TextInputEditText)objectArr[1], (FrameLayout)objectArr[2], (TextInputLayout)objectArr[7], (Button)objectArr[8], (CoordinatorLayout)objectArr[3], (TextView)objectArr[6], (ql)objectArr[4]);
        this.X = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.P.setTag(obj8);
        Object obj9 = objectArr[0];
        this.V = obj9;
        obj9.setTag(obj8);
        Object obj10 = objectArr[5];
        this.W = obj10;
        L(obj10);
        this.S.setTag(obj8);
        L(this.T);
        N(view);
        A();
    }
}
