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

/* compiled from: FragmentDogPreviewBindingImpl.java */
/* loaded from: classes.dex */
public class pc extends oc implements b.a {

    private static final ViewDataBinding.g c0 = new ViewDataBinding$g(13);
    private static final SparseIntArray d0 = new SparseIntArray();
    private final ConstraintLayout X;
    private final ConstraintLayout Y;
    private final FrameLayout Z;
    private final View.OnClickListener a0;
    private long b0;
    static {
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 8;
        int[] iArr2 = new int[i6];
        iArr2[i12] = R.layout.layout_welcome_challenge_participation;
        obj.a(i6, new String[] { "layout_welcome_challenge_participation" }, iArr, iArr2);
        obj.put(2131363183, 9);
        obj.put(2131362359, 10);
        obj.put(2131363333, 11);
        obj.put(2131363002, 12);
    }

    public pc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 13, pc.c0, pc.d0));
    }

    private boolean X(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 2;
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
                    this.b0 |= 1;
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
                    this.b0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 32L;
            } catch (Throwable th) {
            }
        }
        this.U.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.oc
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return Z(object, i2);
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public void M(q qVar) {
        super.M(qVar);
        this.U.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.oc
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

    @Override // app.dogo.com.dogo_android.h.oc
    public void V(v vVar) {
        this.V = vVar;
        synchronized (this) {
            try {
                this.b0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public void W(h0 h0Var) {
        this.W = h0Var;
        synchronized (this) {
            try {
                this.b0 |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.V != null ? 1 : 0;
        if (i2 != 0) {
            this.V.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oc
    protected void m() {
        Object obj;
        y yVar;
        Object obj2;
        int i2;
        y yVar2;
        int i3 = 0;
        int cmp6 = 1;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.b0 = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 57L & l2;
        long l6 = 59L & l2;
        final long l7 = 50L;
        final y yVar3 = null;
        if (l6 != l4) {
            if (l5 != l4) {
                if (this.W != null) {
                    x xVar2 = this.W.t();
                } else {
                    int i9 = yVar3;
                }
                i3 = 0;
                Q(i3, obj2);
                Object value2 = obj2 != null ? (LoadResult)value2 : yVar3;
            }
            long l8 = l2 & 50L;
            if (l8 != l4) {
                if (this.W != null) {
                    x xVar = this.W.q();
                } else {
                    int i4 = yVar3;
                }
                cmp6 = 1;
                Q(cmp6, obj);
                Object value = this.W != null ? (LoadResult)value : yVar3;
            }
        } else {
        }
        if (l5 != l4) {
            DogProfileBindingAdapters.D(this.O, yVar2, this.V);
            DogProfileBindingAdapters.H(this.P, yVar2, this.V);
            DogProfileBindingAdapters.Q(this.Y, yVar2, this.U, this.V);
            DogProfileBindingAdapters.z(this.S, this.T, this.V, yVar2);
        }
        long l9 = 49L & l2;
        if (this.T != l4) {
            DogProfileBindingAdapters.X(this.Q, yVar2);
            BindingAdapters.setTrainerAvatar(this.X, yVar2);
        }
        l = 32L & l2;
        if (this.S != l4) {
            this.R.setOnClickListener(this.a0);
        }
        long l3 = l2 & 50L;
        if (this.b0 != l4) {
            BindingAdapters.x0(this.Z, yVar);
            BindingAdapters.setAdapter(this.Z, yVar, yVar3, yVar3);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.U.y()) {
            return true;
        }
        return false;
    }

    private pc(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        super(eVar, view, 3, (ImageView)objectArr[4], (ImageView)objectArr[5], (TextView)objectArr[2], (View)objectArr[3], (ImageView)objectArr[10], (ProgressBar)objectArr[12], (ScrollView)objectArr[9], (ViewPager2)objectArr[6], (TabLayout)objectArr[11], (in)objectArr[8]);
        eVar3.b0 = -1L;
        Object obj12 = null;
        eVar3.O.setTag(obj12);
        eVar3.P.setTag(obj12);
        eVar3.Q.setTag(obj12);
        eVar3.R.setTag(obj12);
        Object obj11 = objectArr[0];
        eVar3.X = obj11;
        obj11.setTag(obj12);
        int i13 = 1;
        Object obj13 = objectArr[i13];
        eVar3.Y = obj13;
        obj13.setTag(obj12);
        Object obj14 = objectArr[7];
        eVar3.Z = obj14;
        obj14.setTag(obj12);
        eVar3.S.setTag(obj12);
        L(eVar3.U);
        N(view);
        eVar3.a0 = new b(this, i13);
        A();
    }
}
