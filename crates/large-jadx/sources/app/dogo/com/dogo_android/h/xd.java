package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.m.s.i;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentLibraryTrickBigTimerBindingImpl.java */
/* loaded from: classes.dex */
public class xd extends wd implements b.a {

    private static final ViewDataBinding.g i0;
    private static final SparseIntArray j0 = new SparseIntArray();
    private final TextView f0;
    private final View.OnClickListener g0;
    private long h0;
    static {
        obj.put(2131363441, 15);
        obj.put(2131362568, 16);
        obj.put(2131363004, 17);
        obj.put(2131362118, 18);
        obj.put(2131362126, 19);
        obj.put(2131362121, 20);
        obj.put(2131362184, 21);
        obj.put(2131362185, 22);
        obj.put(2131363554, 23);
        obj.put(2131362182, 24);
    }

    public xd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 25, xd.i0, xd.j0));
    }

    private boolean V(x<Long> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.h0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.h0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.wd
    public void A() {
        synchronized (this) {
            try {
                this.h0 = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wd
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.wd
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

    @Override // app.dogo.com.dogo_android.h.wd
    public void X(i iVar) {
        this.e0 = iVar;
        synchronized (this) {
            try {
                this.h0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wd
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.e0 != null ? 1 : 0;
        if (i2 != 0) {
            this.e0.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wd
    protected void m() {
        Object obj2 = null;
        int i;
        java.lang.CharSequence charSequence = null;
        long l;
        long l2;
        int i2;
        int i3;
        TrickItem trickItem = null;
        Object value2 = null;
        Object obj = null;
        Long l12 = null;
        Object value = null;
        Boolean bool = null;
        int i4 = 0;
        boolean z2;
        int i5 = 1024;
        int cmp5 = 256;
        boolean z3;
        int cmp6 = 128;
        long l4;
        x xVar;
        final Object obj3 = this;
        synchronized (this) {
            try {
                l4 = 0L;
                obj3.h0 = l4;
            } catch (Throwable th) {
            }
        }
        long l6 = 15L & l;
        long l8 = 13L;
        final long l11 = 12L;
        i2 = 0;
        if (l6 != l4) {
            long l13 = l & 12L;
            i2 = 1;
            if (l13 != l4) {
                if (obj3.e0 != null) {
                    Long l14 = obj3.e0.i();
                    boolean z = obj3.e0.q();
                    TrickItem trickItem2 = obj3.e0.p();
                } else {
                    i4 = 0;
                    i3 = 0;
                }
                if (l13 != l4) {
                    if (i2 != 0) {
                        l2 = l | 32L;
                        i5 = 2048;
                    } else {
                        l2 = l | 16L;
                        i5 = 1024;
                    }
                    l = l2 | i5;
                }
                int r6 = i2;
                int r16 = i2 != 0 ? i2 : 4;
                i2 = 8;
                int r20 = i2;
                long l15 = l & 12L;
                if (l15 != l4) {
                    int r21 = i2 != 0 ? 512 : 256;
                    l = l | (i2 != 0 ? 512 : 256);
                }
                if (i3 != 0) {
                    String name = i3.getName();
                    boolean variation = i3.isVariation();
                } else {
                    i = 0;
                }
                long l16 = l & 12L;
                if (l16 != l4) {
                    int r23 = i2 != 0 ? 128 : 64;
                    l = l | (i2 != 0 ? 128 : 64);
                }
                r6 = i2;
                if (i2 == 0) {
                }
            } else {
                i3 = 0;
                i = 0;
            }
            long l17 = l & 13L;
            if (l17 != l4) {
                if (obj3.e0 != null) {
                    l4 = obj3.e0.o();
                } else {
                    int i13 = 0;
                }
                obj3.Q(i2, obj);
                value2 = obj != null ? (Long)value2 : 0;
            } else {
            }
            l5 = l & 14L;
            if (l5 != l4) {
                if (obj3.e0 != null) {
                    x xVar2 = obj3.e0.n();
                } else {
                    int i6 = 0;
                }
                obj3.Q(i2, obj2);
                if (obj3.e0 != null) {
                } else {
                    int i16 = 0;
                }
            }
        } else {
            int i7 = 0;
            int i11 = 0;
            int i15 = 0;
            int i17 = 0;
        }
        long l9 = 13L & l;
        if (l9 != l4) {
            LibraryBindingAdapters.a(obj3.O, l12, Long.valueOf(l4));
            LibraryBindingAdapters.s(obj3.X, l12, Long.valueOf(l4));
            LibraryBindingAdapters.l(obj3.b0, l12, Long.valueOf(l4));
        }
        long l10 = l & 12L;
        if (obj3.O != l4) {
            obj3.Q.setVisibility(i2);
            obj3.R.setVisibility(i2);
            obj3.S.setVisibility(i2);
            LibraryBindingAdapters.k(obj3.T, Boolean.valueOf(z3));
            g.c(obj3.f0, charSequence);
            obj3.W.setVisibility(i2);
            obj3.Z.setVisibility(i2);
            LibraryBindingAdapters.u(obj3.c0, Boolean.valueOf(z2));
            LibraryBindingAdapters.m(obj3.d0, trickItem);
        }
        long l7 = 14L & l;
        if (l7 != l4) {
            LibraryBindingAdapters.b(obj3.U, bool);
            BindingAdapters.J0(obj3.Y, bool);
        }
        l3 = l & 8L;
        if (obj3.h0 != l4) {
            obj3.W.setOnClickListener(obj3.g0);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wd
    public boolean y() {
        synchronized (this) {
            try {
                if (this.h0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private xd(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ArcProgressBar)objectArr[5], (ConstraintLayout)objectArr[0], (View)objectArr[14], (Barrier)objectArr[18], (Guideline)objectArr[20], (Barrier)objectArr[19], (ClickerSoundMaterialButton)objectArr[12], (View)objectArr[24], (Guideline)objectArr[21], (Guideline)objectArr[22], (Space)objectArr[13], (Button)objectArr[9], (Button)objectArr[11], (Chip)objectArr[16], (Chip)objectArr[4], (TextView)objectArr[8], (Guideline)objectArr[17], (TextView)objectArr[7], (ConstraintLayout)objectArr[3], (MaterialToolbar)objectArr[15], (TextView)objectArr[6], (ConstraintLayout)objectArr[1], (TextView)objectArr[10], (View)objectArr[23]);
        Object eVar4 = this;
        eVar4.h0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.Q.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.S.setTag(obj2);
        eVar4.T.setTag(obj2);
        eVar4.U.setTag(obj2);
        Object obj = objectArr[2];
        eVar4.f0 = obj;
        obj.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.X.setTag(obj2);
        eVar4.Y.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.b0.setTag(obj2);
        eVar4.c0.setTag(obj2);
        eVar4.d0.setTag(obj2);
        eVar4.N(view);
        eVar4.g0 = new b(eVar4, 1);
        A();
    }
}
