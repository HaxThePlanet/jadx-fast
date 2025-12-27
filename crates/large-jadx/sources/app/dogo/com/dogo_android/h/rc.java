package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.h0;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogPreviewFullscreenBindingImpl.java */
/* loaded from: classes.dex */
public class rc extends qc implements b.a {

    private static final ViewDataBinding.g d0 = new ViewDataBinding$g(15);
    private static final SparseIntArray e0 = new SparseIntArray();
    private final ConstraintLayout Y;
    private final ConstraintLayout Z;
    private final FrameLayout a0;
    private final View.OnClickListener b0;
    private long c0;
    static {
        int i8 = 1;
        final int[] iArr2 = new int[i8];
        final int i18 = 0;
        iArr2[i18] = 8;
        int[] iArr = new int[i8];
        iArr[i18] = R.layout.layout_welcome_challenge_participation;
        obj.a(4, new String[] { "layout_welcome_challenge_participation" }, iArr2, iArr);
        obj.put(2131362351, 9);
        obj.put(2131362359, 10);
        obj.put(2131361977, 11);
        obj.put(2131363184, 12);
        obj.put(2131363333, 13);
        obj.put(2131363002, 14);
    }

    public rc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 15, rc.d0, rc.e0));
    }

    private boolean X(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<y<ProfilePreview>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(in inVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public void A() {
        synchronized (this) {
            try {
                this.c0 = 32L;
            } catch (Throwable th) {
            }
        }
        this.V.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qc
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return X(object, i2);
        }
        return Z(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public void M(q qVar) {
        super.M(qVar);
        this.V.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.qc
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

    @Override // app.dogo.com.dogo_android.h.qc
    public void V(v vVar) {
        this.W = vVar;
        synchronized (this) {
            try {
                this.c0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public void W(h0 h0Var) {
        this.X = h0Var;
        synchronized (this) {
            try {
                this.c0 |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.W != null ? 1 : 0;
        if (i2 != 0) {
            this.W.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qc
    protected void m() {
        Object obj;
        y yVar;
        Object obj2;
        int i2;
        y yVar2;
        int i3 = 1;
        int cmp6 = 2;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.c0 = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 58L & l2;
        long l6 = 62L & l2;
        final long l7 = 52L;
        final y yVar3 = null;
        if (l6 != l4) {
            if (l5 != l4) {
                if (this.X != null) {
                    x xVar2 = this.X.t();
                } else {
                    int i9 = yVar3;
                }
                i3 = 1;
                Q(i3, obj2);
                Object value2 = obj2 != null ? (LoadResult)value2 : yVar3;
            }
            long l8 = l2 & 52L;
            if (l8 != l4) {
                if (this.X != null) {
                    x xVar = this.X.q();
                } else {
                    int i4 = yVar3;
                }
                cmp6 = 2;
                Q(cmp6, obj);
                Object value = this.X != null ? (LoadResult)value : yVar3;
            }
        } else {
        }
        if (l5 != l4) {
            DogProfileBindingAdapters.D(this.O, yVar2, this.W);
            DogProfileBindingAdapters.H(this.P, yVar2, this.W);
            DogProfileBindingAdapters.Q(this.Z, yVar2, this.V, this.W);
            DogProfileBindingAdapters.z(this.T, this.U, this.W, yVar2);
        }
        long l9 = 50L & l2;
        if (this.V != l4) {
            DogProfileBindingAdapters.X(this.R, yVar2);
            BindingAdapters.setTrainerAvatar(this.Y, yVar2);
        }
        l = 32L & l2;
        if (this.P != l4) {
            this.S.setOnClickListener(this.b0);
        }
        long l3 = l2 & 52L;
        if (this.c0 != l4) {
            BindingAdapters.x0(this.a0, yVar);
            BindingAdapters.setAdapter(this.a0, yVar, yVar3, yVar3);
        }
        ViewDataBinding.o(this.V);
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.c0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.V.y()) {
            return true;
        }
        return false;
    }

    private rc(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 3, (ImageView)objectArr[3], (ImageView)objectArr[5], (ImageView)objectArr[11], (TextView)objectArr[1], (View)objectArr[2], (ConstraintLayout)objectArr[9], (ImageView)objectArr[10], (ProgressBar)objectArr[14], (ScrollView)objectArr[12], (ViewPager2)objectArr[6], (TabLayout)obj, (in)obj2);
        Object eVar4 = this;
        eVar4.c0 = -1L;
        Object obj16 = null;
        eVar4.O.setTag(obj16);
        eVar4.P.setTag(obj16);
        eVar4.R.setTag(obj16);
        eVar4.S.setTag(obj16);
        Object obj13 = objectArr[0];
        eVar4.Y = obj13;
        obj13.setTag(obj16);
        Object obj14 = objectArr[4];
        eVar4.Z = obj14;
        obj14.setTag(obj16);
        Object obj15 = objectArr[7];
        eVar4.a0 = obj15;
        obj15.setTag(obj16);
        eVar4.T.setTag(obj16);
        eVar4.L(eVar4.V);
        eVar4.N(view);
        eVar4.b0 = new b(eVar4, 1);
        A();
    }
}
