package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutTopBarBindingImpl.java */
/* loaded from: classes.dex */
public class dn extends cn implements b.a {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0;
    private final ImageView X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private final View.OnClickListener a0;
    private final View.OnClickListener b0;
    private long c0;
    public dn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, dn.d0, dn.e0));
    }

    private boolean V(app.dogo.com.dogo_android.util.k0.g gVar, int i) {
        int i14 = 1;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw gVar;
            }
        }
        if (i == 15) {
            synchronized (this) {
                try {
                    this.c0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw gVar;
            }
        }
        if (i == 160) {
            synchronized (this) {
                try {
                    this.c0 |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw gVar;
            }
        }
        if (i == 22) {
            synchronized (this) {
                try {
                    this.c0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == i14) {
            synchronized (this) {
                try {
                    this.c0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 72) {
            synchronized (this) {
                try {
                    this.c0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 113) {
            synchronized (this) {
                try {
                    this.c0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public void A() {
        synchronized (this) {
            try {
                this.c0 = 128L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cn
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public boolean O(int i, Object object) {
        boolean z = true;
        if (162 == i) {
            U(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public void U(app.dogo.com.dogo_android.util.k0.g gVar) {
        R(0, gVar);
        this.W = gVar;
        synchronized (this) {
            try {
                this.c0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(162);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.W != null) {
            }
            if (i2 != 0) {
                this.W.onBack();
            }
        } else {
            int i3 = 2;
            if (this.W == 2) {
                if (this.W != null) {
                }
                if (i2 != 0) {
                    this.W.onBlockAction();
                }
            } else {
                i3 = 3;
                if (this.W == 3) {
                    if (this.W != null) {
                    }
                    if (i2 != 0) {
                        this.W.onAction();
                    }
                } else {
                    i3 = 4;
                    if (this.W == 4) {
                        if (this.W != null) {
                        }
                        if (i2 != 0) {
                            this.W.onMoreAction(w().getContext(), view);
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.cn
    protected void m() {
        int i = 0;
        int backgroundColorRes;
        long l;
        java.lang.CharSequence charSequence;
        java.lang.CharSequence charSequence2;
        String actionName;
        float elevationDimension;
        int i3 = 0;
        int i4;
        int i5 = 131072;
        long l7;
        int i6 = 4096;
        int i7;
        final Object obj = this;
        synchronized (this) {
            try {
                long l2 = 0L;
                obj.c0 = l2;
            } catch (Throwable th) {
            }
        }
        i = 0;
        long l15 = 255L & l;
        long l17 = 129L;
        final long l18 = 161L;
        long l19 = 145L;
        i3 = 0;
        backgroundColorRes = 0;
        if (l15 != l2) {
            long l21 = l & 161L;
            backgroundColorRes = 8;
            if (l21 != l2) {
                if (obj.W != null) {
                    boolean flagVisible = obj.W.isFlagVisible();
                } else {
                }
                if (l21 != l2) {
                    int r26 = backgroundColorRes != 0 ? 512 : 256;
                    l = l | (backgroundColorRes != 0 ? 512 : 256);
                }
                if (backgroundColorRes != 0) {
                } else {
                }
            }
            long l22 = l & 129L;
            if (l22 != l2) {
                if (obj.W != null) {
                    backgroundColorRes = obj.W.getBackgroundColorRes(obj.U);
                    backgroundColorRes = obj.W.getTextColorRes(obj.O);
                    actionName = obj.W.getActionName();
                    elevationDimension = obj.W.getElevationDimension(obj.U);
                    backgroundColorRes = obj.W.getBackArrowColorRes(obj.R);
                    backgroundColorRes = obj.W.getTextColorRes(obj.V);
                } else {
                }
                int r9 = actionName != null ? 1 : backgroundColorRes;
                if (l22 != l2) {
                    int r32 = backgroundColorRes != 0 ? 131072 : 65536;
                    l = l | (backgroundColorRes != 0 ? 131072 : 65536);
                }
                r9 = backgroundColorRes;
            } else {
            }
            l7 = l & 193L;
            if (l7 != l2) {
                if (obj.W != null) {
                    boolean moreActionVisible = obj.W.isMoreActionVisible();
                } else {
                }
                if (l7 != l2) {
                    r32 = backgroundColorRes != 0 ? 8192 : 4096;
                    l = l | (backgroundColorRes != 0 ? 8192 : 4096);
                }
                if (backgroundColorRes != 0) {
                } else {
                }
            }
            long l23 = l & 145L;
            if (l23 == l2 || obj.W == null) {
            } else {
                String actionName2 = obj.W.getActionName();
            }
            long l6 = 131L;
            long l24 = l & l6;
            if (l24 != l2) {
                if (obj.W != null) {
                    boolean backVisible = obj.W.isBackVisible();
                } else {
                }
                if (l24 != l2) {
                    int r34 = backgroundColorRes != 0 ? 2048 : 1024;
                    l = l | (backgroundColorRes != 0 ? 2048 : 1024);
                }
                if (backgroundColorRes != 0) {
                } else {
                }
            }
            long l5 = 137L;
            long l25 = l & l5;
            if (l25 != l2 && obj.W != null) {
                boolean blockVisible = obj.W.isBlockVisible();
                if (l25 != l2) {
                    int r35 = backgroundColorRes != 0 ? 32768 : 16384;
                    l = l | (backgroundColorRes != 0 ? 32768 : 16384);
                }
                if (backgroundColorRes == 0) {
                }
            }
            long l4 = 133L;
            l8 = l & l4;
            if (l8 != l2 && obj.W != null) {
                String title = obj.W.getTitle();
            }
        } else {
        }
        long l20 = l & 145L;
        if (l20 != l2) {
            g.c(obj.O, charSequence);
        }
        long l10 = l & 129L;
        if (obj.O != 0) {
            obj.O.setTextColor(backgroundColorRes);
            obj.P.setVisibility(backgroundColorRes);
            BindingAdapters.i0(obj.R, Integer.valueOf(backgroundColorRes));
            h.a(obj.U, b.b(backgroundColorRes));
            obj.V.setTextColor(backgroundColorRes);
            int i2 = 21;
            if (ViewDataBinding.t() >= 21) {
                obj.P.setBackgroundTintList(b.a(backgroundColorRes));
                obj.Q.setBackgroundTintList(b.a(backgroundColorRes));
                obj.S.setBackgroundTintList(b.a(backgroundColorRes));
                obj.T.setBackgroundTintList(b.a(backgroundColorRes));
                obj.U.setElevation(i);
            }
        }
        l3 = 128L & l;
        if (obj.S != 0) {
            obj.P.setOnClickListener(obj.Y);
            obj.Q.setOnClickListener(obj.Z);
            obj.S.setOnClickListener(obj.b0);
            obj.T.setOnClickListener(obj.a0);
        }
        long l11 = 131L & l;
        long l16 = 0L;
        if (obj.S != l16) {
            obj.Q.setVisibility(backgroundColorRes);
        }
        long l12 = 137L & l;
        if (obj.S != l16) {
            obj.S.setVisibility(backgroundColorRes);
        }
        long l13 = l & 161L;
        if (obj.S != l16) {
            obj.X.setVisibility(backgroundColorRes);
        }
        long l14 = 193L & l;
        if (obj.S != l16) {
            obj.T.setVisibility(backgroundColorRes);
        }
        l &= 133;
        if (obj.c0 != l16) {
            g.c(obj.V, charSequence2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public boolean y() {
        synchronized (this) {
            try {
                if (this.c0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private dn(e eVar, View view, Object[] objectArr) {
        final Object eVar4 = this;
        final int i10 = 1;
        final int i12 = 4;
        int i = 3;
        super(eVar, view, 1, (TextView)objectArr[6], (FrameLayout)objectArr[5], (FrameLayout)objectArr[i10], (AppCompatImageView)objectArr[2], (FrameLayout)objectArr[i12], (FrameLayout)objectArr[8], (ConstraintLayout)objectArr[0], (TextView)obj);
        eVar4.c0 = -1L;
        Object obj10 = null;
        eVar4.O.setTag(obj10);
        eVar4.P.setTag(obj10);
        eVar4.Q.setTag(obj10);
        eVar4.R.setTag(obj10);
        eVar4.S.setTag(obj10);
        Object obj9 = objectArr[7];
        eVar4.X = obj9;
        obj9.setTag(obj10);
        eVar4.T.setTag(obj10);
        eVar4.U.setTag(obj10);
        eVar4.V.setTag(obj10);
        eVar4.N(view);
        eVar4.Y = new b(eVar4, i);
        eVar4.Z = new b(eVar4, i10);
        eVar4.a0 = new b(eVar4, i12);
        eVar4.b0 = new b(eVar4, 2);
        A();
    }

}
