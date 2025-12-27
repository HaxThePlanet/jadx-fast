package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.s0;

/* compiled from: FragmentOnboardingStartBindingImpl.java */
/* loaded from: classes.dex */
public class xe extends we {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(12);
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout U;
    private final FrameLayout V;
    private final ml W;
    private long X;
    static {
        int i10 = 1;
        int[] iArr = new int[i10];
        final int i21 = 0;
        iArr[i21] = 2;
        int[] iArr3 = new int[i10];
        iArr3[i21] = R.layout.layout_onboarding_tool_bar;
        obj.a(i21, new String[] { "layout_onboarding_tool_bar" }, iArr, iArr3);
        int[] iArr2 = new int[i10];
        iArr2[i21] = 3;
        int[] iArr4 = new int[i10];
        iArr4[i21] = R.layout.layout_loading_spinner;
        obj.a(i10, new String[] { "layout_loading_spinner" }, iArr2, iArr4);
        obj.put(2131362540, 4);
        obj.put(2131362633, 5);
        obj.put(2131363538, 6);
        obj.put(2131363421, 7);
        obj.put(2131363306, 8);
        obj.put(2131362557, 9);
        obj.put(2131362752, 10);
        obj.put(2131362585, 11);
    }

    public xe(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, xe.Y, xe.Z));
    }

    private boolean V(ql qlVar, int i) {
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

    private boolean W(x<y<Boolean>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.we
    public void A() {
        synchronized (this) {
            try {
                this.X = 8L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        this.W.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.we
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.we
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
        this.W.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.we
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            X(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.we
    public void X(s0 s0Var) {
        this.T = s0Var;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.we
    protected void m() {
        Object obj;
        s0 s0Var;
        y yVar = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.X = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 14L & l2;
        if (l4 != l) {
            if (this.T != null) {
                x userLoggedIn = this.T.isUserLoggedIn();
            } else {
            }
            int i2 = 1;
            Q(i2, obj);
            if (this.T != null) {
            }
        }
        if (l4 != l) {
            BindingAdapters.setTrainerAvatar(this.U, yVar);
            BindingAdapters.setDebugJsonEntryItemAdapter(this.V, yVar);
        }
        long l3 = l2 & 8L;
        if (this.X != l) {
            int i3 = 4;
            this.R.T(Integer.valueOf(i3));
            this.R.U(Integer.valueOf(i3));
        }
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.we
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
        if (this.R.y()) {
            return true;
        }
        if (this.W.y()) {
            return true;
        }
        return false;
    }

    private xe(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 2, (FrameLayout)objectArr[4], (Button)objectArr[9], (Guideline)objectArr[11], (AppCompatImageView)objectArr[5], (Button)objectArr[10], (TextView)objectArr[8], (TextView)objectArr[7], (ql)objectArr[2], (KonfettiView)objectArr[6]);
        eVar3.X = -1L;
        Object obj10 = objectArr[0];
        eVar3.U = obj10;
        Object obj13 = null;
        obj10.setTag(obj13);
        Object obj11 = objectArr[1];
        eVar3.V = obj11;
        obj11.setTag(obj13);
        Object obj12 = objectArr[3];
        eVar3.W = obj12;
        L(obj12);
        L(eVar3.R);
        N(view);
        A();
    }
}
