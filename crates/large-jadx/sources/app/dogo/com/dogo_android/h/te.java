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
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.welcome_v2.d0;
import app.dogo.com.dogo_android.welcome_v2.k0;

/* compiled from: FragmentOnboardingPagerBindingImpl.java */
/* loaded from: classes.dex */
public class te extends se {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0 = new SparseIntArray();
    private final ConstraintLayout Y;
    private long Z;
    static {
        obj.put(2131361983, 3);
        obj.put(2131361984, 4);
        obj.put(2131362571, 5);
        obj.put(2131363433, 6);
        obj.put(2131363436, 7);
        obj.put(2131363331, 8);
        obj.put(2131362887, 9);
        obj.put(2131362066, 10);
        obj.put(2131362586, 11);
    }

    public te(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, te.a0, te.b0));
    }

    @Override // app.dogo.com.dogo_android.h.se
    public void A() {
        synchronized (this) {
            try {
                this.Z = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.se
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
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

    @Override // app.dogo.com.dogo_android.h.se
    public void V(b bVar) {
        this.W = bVar;
        synchronized (this) {
            try {
                this.Z |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.se
    public void W(k0 k0Var) {
        this.X = k0Var;
        synchronized (this) {
            try {
                this.Z |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.se
    protected void m() {
        java.util.List connectedToInternet;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.Z = l4;
            } catch (Throwable th) {
            }
        }
        l = 7L & l2;
        final Boolean bool = null;
        int i3 = l == l4 || this.X == null ? bool : connectedToInternet;
        if (l != l4) {
            OnboardingBindingAdapters.e(this.R, this.S, this.W, this.P, this.O, connectedToInternet);
        }
        long l3 = l2 & 4L;
        if (this.Z != l4) {
            BindingAdapters.k0(this.V, bool);
        }
    }

    @Override // app.dogo.com.dogo_android.h.se
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

    private te(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (AppCompatImageView)objectArr[3], (AppCompatImageView)objectArr[4], (Guideline)objectArr[10], (AppCompatImageView)objectArr[5], (Guideline)objectArr[11], (Button)objectArr[9], (ViewPager2)objectArr[2], (TabLayout)objectArr[8], (MaterialToolbar)objectArr[6], (TextView)objectArr[7], (FrameLayout)objectArr[1]);
        eVar3.Z = -1L;
        Object obj12 = objectArr[0];
        eVar3.Y = obj12;
        Object obj13 = null;
        obj12.setTag(obj13);
        eVar3.R.setTag(obj13);
        eVar3.V.setTag(obj13);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.se
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
