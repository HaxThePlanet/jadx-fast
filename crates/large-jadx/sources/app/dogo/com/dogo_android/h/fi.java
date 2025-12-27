package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* compiled from: LayoutCurrentDogViewV2BindingImpl.java */
/* loaded from: classes.dex */
public class fi extends ei {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0 = new SparseIntArray();
    private long a0;
    static {
        obj.put(2131362256, 5);
        obj.put(2131362346, 6);
        obj.put(2131362359, 7);
        obj.put(2131362347, 8);
        obj.put(2131362183, 9);
        obj.put(2131362231, 10);
    }

    public fi(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, fi.b0, fi.c0));
    }

    private boolean V(v<y<DogProfile>> vVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ei
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 141;
            if (141 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public void T(app.dogo.com.dogo_android.util.k0.e eVar) {
        this.Z = eVar;
        synchronized (this) {
            try {
                this.a0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public void U(l lVar) {
        this.Y = lVar;
        synchronized (this) {
            try {
                this.a0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(141);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ei
    protected void m() {
        int i = 0;
        long l;
        int i2;
        long l3;
        int i3 = 2048;
        Object obj2;
        int i4;
        Object obj3;
        Integer num;
        java.lang.CharSequence charSequence;
        int cmp4;
        int i5 = 32;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l11 = 0L;
                obj.a0 = l11;
            } catch (Throwable th) {
            }
        }
        long l12 = 31L & l;
        long l13 = 256L;
        long l5 = 128L;
        long l15 = 1024L;
        final long l16 = 25L;
        final long l17 = 24L;
        i4 = 0;
        i2 = 0;
        if (l12 != l11) {
            long l18 = l & 25L;
            i2 = 1;
            if (l18 != l11) {
                if (obj.Y != null) {
                    x xVar = obj.Y.J();
                } else {
                }
                obj.Q(i2, obj3);
                Object value2 = obj3 != null ? (Integer)value2 : i4;
                int i7 = ViewDataBinding.J(num);
                int r25 = i2;
                String integer = Integer.toString(i7);
                if (l18 != l11) {
                    l = i2 != 0 ? l | l15 : l | l8;
                }
            } else {
            }
            long l19 = l & 24L;
            if (l19 != l11) {
                if (obj.Y != null) {
                    boolean z = obj.Y.N();
                    boolean z2 = obj.Y.b0();
                } else {
                }
                if (l19 != l11) {
                    int r28 = i2 != 0 ? 64 : 32;
                    l = l | (i2 != 0 ? 64 : 32);
                }
                l9 = l & 24L;
                if (l9 != l11) {
                    long r2 = i2 != 0 ? l | l13 : l | l5;
                }
                int r6 = i2 != 0 ? i2 : 8;
                int r26 = i2 != 0 ? i2 : 8;
            } else {
            }
            long l7 = 30L;
            long l20 = l & 30L;
            if (l20 != l11) {
                v vVar = obj.Y != null ? vVar : i4;
                obj.Q(i2, obj2);
                if (obj2 != null) {
                }
            }
        } else {
            i2 = 0;
            i2 = 0;
            i2 = 0;
            i2 = 0;
        }
        l6 = 1024L & l;
        if (l6 != l11 && obj.Y != null) {
            boolean z3 = obj.Y.b0();
            l6 = l & 24L;
            if (l6 != l11) {
                r2 = i2 != 0 ? l | l13 : l | l5;
            }
        }
        l3 = (i2 != 0 ? l | l13 : l | l5) & 25L;
        if (l3 != l11) {
            if (i2 == 0) {
                i2 = 0;
            }
            if (l3 != l11) {
                int r7 = i2 != 0 ? 4096 : 2048;
                l = r2 | (i2 != 0 ? 4096 : 2048);
            }
            int r22 = i2 != 0 ? 0 : 8;
            i = (i2 != 0 ? 0 : 8);
        } else {
            i = 0;
        }
        long l14 = l & 25L;
        if (l14 != l11) {
            obj.O.setVisibility(i);
            g.c(obj.P, charSequence);
        }
        l4 = l & 24L;
        if (obj.O != l11) {
            obj.R.setVisibility(i2);
            obj.X.setVisibility(i2);
        }
        long l2 = 30L;
        l &= l2;
        if (obj.a0 != l11) {
            DogProfileBindingAdapters.J(obj.W, i4, obj.U, obj.T, obj.Z, obj.Q, obj.V, obj.X, obj.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public boolean y() {
        synchronized (this) {
            try {
                if (this.a0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private fi(androidx.databinding.e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 2, (FrameLayout)objectArr[3], (TextView)objectArr[4], (ImageView)objectArr[9], (ImageView)objectArr[1], (ImageView)objectArr[10], (ImageView)objectArr[5], (TextView)objectArr[6], (View)objectArr[8], (ConstraintLayout)objectArr[0], (ImageView)objectArr[7], (ImageView)objectArr[2]);
        eVar3.a0 = -1L;
        Object obj12 = null;
        eVar3.O.setTag(obj12);
        eVar3.P.setTag(obj12);
        eVar3.R.setTag(obj12);
        eVar3.W.setTag(obj12);
        eVar3.X.setTag(obj12);
        eVar3.N(view);
        A();
    }
}
