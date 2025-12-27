package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.c0.a;
import app.dogo.com.dogo_android.welcome_v2.d0;
import app.dogo.com.dogo_android.welcome_v2.v0;
import java.util.List;

/* compiled from: FragmentDashboardSurveyBindingImpl.java */
/* loaded from: classes.dex */
public class za extends ya {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(11);
    private static final SparseIntArray Z = new SparseIntArray();
    private final FrameLayout V;
    private final ml W;
    private long X;
    static {
        int i8 = 1;
        int[] iArr2 = new int[i8];
        final int i19 = 0;
        iArr2[i19] = 3;
        int[] iArr4 = new int[i8];
        iArr4[i19] = R.layout.layout_onboarding_tool_bar;
        obj.a(i19, new String[] { "layout_onboarding_tool_bar" }, iArr2, iArr4);
        int[] iArr3 = new int[i8];
        iArr3[i19] = 4;
        int[] iArr = new int[i8];
        iArr[i19] = R.layout.layout_loading_spinner;
        obj.a(2, new String[] { "layout_loading_spinner" }, iArr3, iArr);
        obj.put(2131362712, 5);
        obj.put(2131362713, 6);
        obj.put(2131363157, 7);
        obj.put(2131363158, 8);
        obj.put(2131362115, 9);
        obj.put(2131362246, 10);
    }

    public za(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, za.Y, za.Z));
    }

    private boolean X(ql qlVar, int i) {
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

    private boolean Y(LiveData<y<List<SurveyQuestion>>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.ya
    public void A() {
        synchronized (this) {
            try {
                this.X = 16L;
            } catch (Throwable th) {
            }
        }
        this.S.A();
        this.W.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ya
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public void M(q qVar) {
        super.M(qVar);
        this.S.M(qVar);
        this.W.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public boolean O(int i, Object object) {
        int i2 = 8;
        boolean z = true;
        i2 = 8;
        if (8 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public void V(c0.a aVar) {
        this.U = aVar;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(8);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public void W(v0 v0Var) {
        this.T = v0Var;
        synchronized (this) {
            try {
                this.X |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ya
    protected void m() {
        LiveData result;
        v0 v0Var;
        y yVar = null;
        int i2 = 1;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        long l5 = 30L & l;
        if (l5 != l3) {
            if (this.T != null) {
                result = this.T.getResult();
            } else {
            }
            i2 = 1;
            Q(i2, result);
            if (this.T != null) {
            }
        }
        if (l5 != l3) {
            OnboardingBindingAdapters.setOnboardingDetailsTab(this.P, yVar, this.U, this.R, this.O);
        }
        long l4 = 26L & l;
        if (this.U != l3) {
            BindingAdapters.setDebugJsonEntryItemAdapter(this.V, yVar);
        }
        long l2 = l & 16L;
        if (this.X != l3) {
            this.S.U(4);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.ya
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
        if (this.S.y()) {
            return true;
        }
        if (this.W.y()) {
            return true;
        }
        return false;
    }

    private za(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 2, (View)objectArr[9], (CardStackView)objectArr[1], (ConstraintLayout)objectArr[0], (View)objectArr[10], (ImageView)objectArr[5], (ImageView)objectArr[6], (ImageView)objectArr[7], (ImageView)objectArr[8], (ql)objectArr[3]);
        eVar3.X = -1L;
        Object obj12 = null;
        eVar3.P.setTag(obj12);
        eVar3.Q.setTag(obj12);
        Object obj10 = objectArr[2];
        eVar3.V = obj10;
        obj10.setTag(obj12);
        Object obj11 = objectArr[4];
        eVar3.W = obj11;
        L(obj11);
        L(eVar3.S);
        N(view);
        A();
    }
}
