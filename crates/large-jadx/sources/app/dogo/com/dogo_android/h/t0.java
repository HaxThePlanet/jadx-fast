package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: CellChallengeFanEntryItemBindingImpl.java */
/* loaded from: classes.dex */
public class t0 extends s0 {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0 = new SparseIntArray();
    private final ConstraintLayout a0;
    private long b0;
    static {
        obj.put(2131361915, 10);
        obj.put(2131361929, 11);
        obj.put(2131362723, 12);
        obj.put(2131362406, 13);
        obj.put(2131362728, 14);
    }

    public t0(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 15, t0.c0, t0.d0));
    }

    private boolean W(app.dogo.com.dogo_android.d.a.n.e eVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw eVar;
            }
        }
        if (i == 174) {
            synchronized (this) {
                try {
                    this.b0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw eVar;
            }
        }
        if (i == 11) {
            synchronized (this) {
                try {
                    this.b0 |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw eVar;
            }
        }
        if (i == 12) {
            synchronized (this) {
                try {
                    this.b0 |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw eVar;
            }
        }
        if (i == 10) {
            synchronized (this) {
                try {
                    this.b0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 65) {
            synchronized (this) {
                try {
                    this.b0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 36) {
            synchronized (this) {
                try {
                    this.b0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 184) {
            synchronized (this) {
                try {
                    this.b0 |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 101) {
            synchronized (this) {
                try {
                    this.b0 |= 256;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.s0
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 512L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s0
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.s0
    public boolean O(int i, Object object) {
        boolean z = true;
        if (183 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.s0
    public void V(app.dogo.com.dogo_android.d.a.n.e eVar) {
        R(0, eVar);
        this.Z = eVar;
        synchronized (this) {
            try {
                this.b0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s0
    protected void m() {
        java.lang.CharSequence charSequence;
        long l;
        int i2;
        int i;
        String str;
        boolean z;
        int i3 = 2131099847;
        Object obj2;
        String voteCount;
        int i4;
        int i5 = 4096;
        android.text.SpannableStringBuilder spannableStringBuilder;
        int cmp9 = 65536;
        int i6;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.b0 = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 1023L & l;
        long l4 = 769L;
        final long l13 = 577L;
        final long l15 = 517L;
        final long l16 = 521L;
        long l17 = 529L;
        i = 0;
        i2 = 0;
        if (l6 != l5) {
            long l19 = l & 521L;
            i2 = 8;
            if (l19 != l5) {
                if (obj.Z != null) {
                    boolean z2 = obj.Z.g();
                } else {
                }
                if (l19 != l5) {
                    int r27 = i2 != 0 ? 32768 : 16384;
                    l = l | (i2 != 0 ? 32768 : 16384);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l20 = l & 641L;
            if (l20 == l5 || obj.Z == null) {
            } else {
                voteCount = obj.Z.getVoteCount();
            }
            long l21 = l & 529L;
            if (l21 != l5) {
                if (obj.Z != null) {
                    boolean z3 = obj.Z.e();
                } else {
                }
                if (l21 != l5) {
                    int r29 = i2 != 0 ? 8192 : 4096;
                    l = l | (i2 != 0 ? 8192 : 4096);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l22 = l & 577L;
            if (l22 == l5 || obj.Z == null) {
            } else {
                String str3 = obj.Z.a();
            }
            long l23 = l & 517L;
            if (l23 != l5) {
                if (obj.Z != null) {
                    boolean z4 = obj.Z.f();
                } else {
                }
                if (l23 != l5) {
                    int r31 = i2 != 0 ? 2048 : 1024;
                    l = l | (i2 != 0 ? 2048 : 1024);
                }
                if (i2 != 0) {
                }
            }
            long l24 = l & 545L;
            if (l24 == l5 || obj.Z == null) {
            } else {
                spannableStringBuilder = obj.Z.b();
            }
            long l25 = l & 515L;
            if (l25 != l5 && obj.Z != null) {
                String str2 = obj.Z.d();
            }
            long l26 = l & 769L;
            if (l26 != l5) {
                if (obj.Z != null) {
                    boolean likeState = obj.Z.getLikeState();
                }
                if (l26 != l5) {
                    int r30 = i2 != 0 ? 131072 : 65536;
                    l = l | (i2 != 0 ? 131072 : 65536);
                }
                int r15 = i2 != 0 ? R.color.secondary : R.color.icon_gray;
            } else {
            }
        } else {
        }
        long l18 = l & 529L;
        if (l18 != l5) {
            obj.O.setVisibility(i2);
        }
        long l12 = l & 517L;
        if (obj.O != l5) {
            obj.P.setVisibility(i2);
        }
        long l9 = 512L & l;
        if (obj.P != l5) {
            app.dogo.com.dogo_android.util.binding.m.l(obj.R, obj.X);
        }
        long l10 = l & 577L;
        if (obj.R != l5) {
            g.c(obj.S, charSequence);
        }
        long l11 = 769L & l;
        if (obj.R != l5 && ViewDataBinding.t() >= 21) {
            obj.T.setImageTintList(b.a(i2));
        }
        l3 = l & 521L;
        if (l3 != l5) {
            obj.V.setVisibility(i2);
        }
        long l8 = 515L & l;
        if (l8 != l5) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.W, str);
        }
        long l7 = 545L & l;
        if (l7 != l5) {
            g.c(obj.X, obj2);
        }
        l2 = l & 641L;
        if (obj.b0 != l5) {
            g.c(obj.Y, i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s0
    public boolean y() {
        synchronized (this) {
            try {
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private t0(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ImageView)objectArr[4], (ImageView)objectArr[2], (View)objectArr[10], (ImageView)objectArr[11], (ViewPager)objectArr[5], (TextView)objectArr[7], (ConstraintLayout)objectArr[13], (FrameLayout)objectArr[12], (ImageView)objectArr[9], (FrameLayout)objectArr[14], (ImageView)objectArr[3], (ImageView)objectArr[1], (TextView)objectArr[6], (TextView)objectArr[8]);
        Object eVar3 = this;
        eVar3.b0 = -1L;
        Object obj2 = null;
        eVar3.O.setTag(obj2);
        eVar3.P.setTag(obj2);
        eVar3.R.setTag(obj2);
        eVar3.S.setTag(obj2);
        eVar3.T.setTag(obj2);
        Object obj = objectArr[0];
        eVar3.a0 = obj;
        obj.setTag(obj2);
        eVar3.V.setTag(obj2);
        eVar3.W.setTag(obj2);
        eVar3.X.setTag(obj2);
        eVar3.Y.setTag(obj2);
        eVar3.N(view);
        A();
    }
}
