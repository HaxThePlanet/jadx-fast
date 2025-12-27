package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentLibraryTrickDetailsBindingImpl.java */
/* loaded from: classes.dex */
public class zd extends yd implements b.a {

    private static final ViewDataBinding.g k0;
    private static final SparseIntArray l0 = new SparseIntArray();
    private final TextView h0;
    private final View.OnClickListener i0;
    private long j0;
    static {
        obj.put(2131362568, 14);
        obj.put(2131361936, 15);
        obj.put(2131362955, 16);
        obj.put(2131363331, 17);
        obj.put(2131363005, 18);
        obj.put(2131362118, 19);
        obj.put(2131362126, 20);
        obj.put(2131362121, 21);
        obj.put(2131362184, 22);
        obj.put(2131362185, 23);
        obj.put(2131363554, 24);
        obj.put(2131362182, 25);
    }

    public zd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 26, zd.k0, zd.l0));
    }

    private boolean W(x<y<TrickItem>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.j0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.j0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public void A() {
        synchronized (this) {
            try {
                this.j0 = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yd
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.yd
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
                Y(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public void V(k kVar) {
        this.g0 = kVar;
        synchronized (this) {
            try {
                this.j0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public void Y(app.dogo.com.dogo_android.n.m.u.n nVar) {
        this.f0 = nVar;
        synchronized (this) {
            try {
                this.j0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.f0 != null ? 1 : 0;
        if (i2 != 0) {
            this.f0.B();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
    protected void m() {
        int i = 0;
        long l;
        long l2;
        int i2;
        int i3 = 0;
        String str = null;
        int i4;
        java.lang.CharSequence charSequence = null;
        int i5;
        int i6 = 0;
        android.graphics.drawable.Drawable drawable;
        Long l11 = null;
        android.graphics.drawable.Drawable drawable2 = null;
        boolean z;
        Object obj2 = null;
        Boolean bool = null;
        int i9;
        Object obj3 = null;
        int i10 = 0;
        android.content.Context context;
        app.dogo.com.dogo_android.n.m.u.n.a aVar = null;
        y yVar;
        x xVar;
        int i12;
        k kVar;
        int i7 = 0;
        int i11 = 0;
        int i13 = 0;
        int i14 = 0;
        boolean z3 = false;
        int i15 = 0;
        int i16 = 16384;
        int cmp7;
        int cmp8 = 32768;
        int cmp9 = 1024;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l7 = 0L;
                obj.j0 = l7;
            } catch (Throwable th) {
            }
        }
        long l10 = 31L & l;
        long l12 = 24L;
        i = 0;
        if (l10 != l7) {
            long l14 = l & 25L;
            i = 8;
            if (l14 != l7) {
                xVar = obj.f0 != null ? xVar : 0;
                obj.Q(i, obj2);
                Object value2 = obj2 != null ? (Boolean)value2 : 0;
                z = ViewDataBinding.K(bool);
                if (l14 != l7) {
                    int r18 = z ? 256 : 128;
                    l = l | (z ? 256 : 128);
                }
                if (z) {
                } else {
                }
            }
            long l15 = l & 24L;
            i10 = 1;
            if (l15 != l7) {
                if (obj.f0 != null) {
                    Long l16 = obj.f0.p();
                    Long l17 = obj.f0.m();
                    boolean z2 = obj.f0.x();
                    TrickItem trickItem = obj.f0.u();
                    app.dogo.com.dogo_android.n.m.u.n.a aVar2 = obj.f0.t();
                    String str3 = obj.f0.s();
                } else {
                    i7 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    i9 = 0;
                    i2 = 0;
                }
                if (l15 != l7) {
                    if (i14 != 0) {
                        l2 = l | 64L;
                        i16 = 16384;
                    } else {
                        l2 = l | 32L;
                        i16 = 8192;
                    }
                    l = l2 | i16;
                }
                int r14 = i7 != 0 ? i10 : 0;
                int r25 = i7 == 0 ? i10 : 0;
                int r20 = i13 == 0 ? i10 : 0;
                int r26 = i14 != 0 ? 0 : 4;
                int r27 = i14 != 0 ? i : 0;
                long l18 = l & 24L;
                if (l18 != l7) {
                    int r28 = i10 != 0 ? 65536 : 32768;
                    l = l | (i10 != 0 ? 65536 : 32768);
                }
                long l19 = l & 24L;
                if (l19 != l7) {
                    r28 = i10 != 0 ? 1024 : 512;
                    l = l | (i10 != 0 ? 1024 : 512);
                }
                long l20 = l & 24L;
                if (l20 != l7) {
                    r28 = i10 != 0 ? 4096 : 2048;
                    l = l | (i10 != 0 ? 4096 : 2048);
                }
                if (i15 != 0) {
                    String name = i15.getName();
                } else {
                    i4 = 0;
                }
                if (i10 != 0) {
                    drawable = a.d(obj.b0.getContext(), 2131231072);
                } else {
                    int i8 = 2131231056;
                    drawable = a.d(obj.b0.getContext(), i8);
                }
                int r11 = i10 != 0 ? 0 : i;
                if (i10 == 0) {
                    i = 0;
                }
            } else {
                i6 = 0;
                i = 0;
                i = 0;
                i5 = 0;
                i7 = 0;
                i14 = 0;
                i4 = 0;
                i9 = 0;
                i2 = 0;
                i = 0;
            }
            l6 = l & 30L;
            if (l6 != l7) {
                if (obj.f0 != null) {
                    x xVar2 = obj.f0.q();
                    app.dogo.com.dogo_android.util.c0 c0Var = obj.f0.w();
                } else {
                    i3 = 0;
                    int i31 = 0;
                }
                obj.Q(i10, obj3);
                if (obj.b0 != null) {
                } else {
                    i11 = 0;
                }
            } else {
                i3 = 0;
            }
        } else {
            i = 0;
            int i17 = 0;
            int i22 = 0;
            i5 = 0;
            i = 0;
            int i25 = 0;
            int i27 = 0;
            int i28 = 0;
            i = 0;
            i11 = 0;
            int i32 = 0;
            i3 = 0;
            i = 0;
        }
        long l13 = 24L & l;
        if (l13 != l7) {
            obj.P.setVisibility(i5);
            obj.Q.setVisibility(i);
            obj.R.setVisibility(i);
            LibraryBindingAdapters.t(obj.S, aVar, str);
            g.c(obj.h0, charSequence);
            obj.V.setVisibility(i);
            LibraryBindingAdapters.v(obj.Z, obj.W, l11);
            obj.a0.setVisibility(i);
            obj.b0.setNavigationIcon(drawable2);
            LibraryBindingAdapters.u(obj.c0, Boolean.valueOf(z3));
        }
        long l8 = 26L & l;
        if (obj.V != l7) {
            BindingAdapters.z0(obj.U, i11);
        } else {
        }
        l4 = 16L & l;
        if (obj.V != l7) {
            obj.V.setOnClickListener(obj.i0);
        }
        long l9 = 25L & l;
        if (obj.V != l7) {
            obj.X.setVisibility(i);
        }
        long l5 = 30L;
        l3 = l & l5;
        if (obj.j0 != l7) {
            TrainingBindingAdapters.t(obj.d0, yVar, obj.Y, i3, kVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public boolean y() {
        synchronized (this) {
            try {
                if (this.j0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private zd(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (AppCompatImageView)objectArr[15], (ConstraintLayout)objectArr[0], (View)objectArr[13], (Barrier)objectArr[19], (Guideline)objectArr[21], (Barrier)objectArr[20], (ClickerSoundMaterialButton)objectArr[11], (View)objectArr[25], (Guideline)objectArr[22], (Guideline)objectArr[23], (Space)objectArr[12], (Button)objectArr[9], (Chip)objectArr[14], (FrameLayout)objectArr[10], (Chip)objectArr[5], (TextView)objectArr[16], (ProgressBar)objectArr[18], (LottieAnimationView)objectArr[7], (TabLayout)objectArr[17], (ConstraintLayout)objectArr[8], (ConstraintLayout)objectArr[4], (MaterialToolbar)objectArr[2], (ConstraintLayout)objectArr[1], (ViewPager2)objectArr[6], (View)objectArr[24]);
        Object eVar4 = this;
        eVar4.j0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.Q.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.S.setTag(obj2);
        eVar4.U.setTag(obj2);
        Object obj = objectArr[3];
        eVar4.h0 = obj;
        obj.setTag(obj2);
        eVar4.V.setTag(obj2);
        eVar4.X.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.a0.setTag(obj2);
        eVar4.b0.setTag(obj2);
        eVar4.c0.setTag(obj2);
        eVar4.d0.setTag(obj2);
        eVar4.N(view);
        eVar4.i0 = new b(eVar4, 1);
        A();
    }
}
