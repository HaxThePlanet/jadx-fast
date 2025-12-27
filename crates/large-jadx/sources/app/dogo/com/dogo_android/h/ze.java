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

/* compiled from: FragmentOnboardingSurveyBindingImpl.java */
/* loaded from: classes.dex */
public class ze extends ye {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(7);
    private static final SparseIntArray Z = new SparseIntArray();
    private final FrameLayout V;
    private final ml W;
    private long X;
    static {
        int i4 = 1;
        int[] iArr2 = new int[i4];
        final int i11 = 0;
        iArr2[i11] = 3;
        int[] iArr4 = new int[i4];
        iArr4[i11] = R.layout.layout_onboarding_tool_bar;
        obj.a(i11, new String[] { "layout_onboarding_tool_bar" }, iArr2, iArr4);
        int[] iArr3 = new int[i4];
        iArr3[i11] = 4;
        int[] iArr = new int[i4];
        iArr[i11] = R.layout.layout_loading_spinner;
        obj.a(2, new String[] { "layout_loading_spinner" }, iArr3, iArr);
        obj.put(2131362115, 5);
        obj.put(2131362246, 6);
    }

    public ze(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, ze.Y, ze.Z));
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

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ye
    public void M(q qVar) {
        super.M(qVar);
        this.S.M(qVar);
        this.W.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
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
        long l4 = 30L & l;
        if (l4 != l3) {
            if (this.T != null) {
                result = this.T.getResult();
            } else {
            }
            i2 = 1;
            Q(i2, result);
            if (this.T != null) {
            }
        }
        if (l4 != l3) {
            OnboardingBindingAdapters.setOnboardingDetailsTab(this.P, yVar, this.U, this.R, this.O);
        }
        long l2 = l & 26L;
        if (this.X != l3) {
            BindingAdapters.setDebugJsonEntryItemAdapter(this.V, yVar);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.ye
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

    private ze(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (View)objectArr[5], (CardStackView)objectArr[1], (ConstraintLayout)objectArr[0], (View)objectArr[6], (ql)objectArr[3]);
        this.X = -1L;
        Object obj6 = null;
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        Object obj7 = objectArr[2];
        this.V = obj7;
        obj7.setTag(obj6);
        Object obj8 = objectArr[4];
        this.W = obj8;
        L(obj8);
        L(this.S);
        N(view);
        A();
    }
}
