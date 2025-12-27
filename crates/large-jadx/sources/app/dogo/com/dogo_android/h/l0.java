package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.d.b.z.l;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: CellChallengeCommentItemBindingImpl.java */
/* loaded from: classes.dex */
public class l0 extends k0 implements b.a {

    private static final ViewDataBinding.g i0;
    private static final SparseIntArray j0 = new SparseIntArray();
    private final ConstraintLayout e0;
    private final TextView f0;
    private final View.OnClickListener g0;
    private long h0;
    static {
        obj.put(2131363057, 17);
        obj.put(2131361915, 18);
        obj.put(2131363062, 19);
    }

    public l0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 20, l0.i0, l0.j0));
    }

    private boolean W(l lVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.h0 |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 132) {
            synchronized (this) {
                try {
                    this.h0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 102) {
            synchronized (this) {
                try {
                    this.h0 |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 101) {
            synchronized (this) {
                try {
                    this.h0 |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 185) {
            synchronized (this) {
                try {
                    this.h0 |= 16;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 13) {
            synchronized (this) {
                try {
                    this.h0 |= 32;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 11) {
            synchronized (this) {
                try {
                    this.h0 |= 64;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 12) {
            synchronized (this) {
                try {
                    this.h0 |= 128;
                    return true;
                } catch (Throwable unused) {
                }
                throw lVar;
            }
        }
        if (i == 10) {
            synchronized (this) {
                try {
                    this.h0 |= 256;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 48) {
            synchronized (this) {
                try {
                    this.h0 |= 512;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 49) {
            synchronized (this) {
                try {
                    this.h0 |= 1024;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 41) {
            synchronized (this) {
                try {
                    this.h0 |= 2048;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 61) {
            synchronized (this) {
                try {
                    this.h0 |= 4096;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 133) {
            synchronized (this) {
                try {
                    this.h0 |= 8192;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 164) {
            synchronized (this) {
                try {
                    this.h0 |= 16384;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 165) {
            synchronized (this) {
                try {
                    this.h0 |= 32768;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 147) {
            synchronized (this) {
                try {
                    this.h0 |= 65536;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.k0
    public void A() {
        synchronized (this) {
            try {
                this.h0 = 131072L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k0
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.k0
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

    @Override // app.dogo.com.dogo_android.h.k0
    public void V(l lVar) {
        R(0, lVar);
        this.d0 = lVar;
        synchronized (this) {
            try {
                this.h0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k0
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.d0 != null ? 1 : 0;
        if (i2 != 0) {
            this.d0.onTranslateButtonPress();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k0
    protected void m() {
        java.lang.CharSequence charSequence;
        long l;
        int i3 = 0;
        int i2;
        java.lang.CharSequence charSequence3;
        int i4 = 2131100379;
        boolean likeState;
        Object obj2;
        String str;
        int i5 = 2131099847;
        int i = 0;
        int i6;
        int i7;
        long l12;
        long l13;
        long l14;
        int cmp18;
        long l15;
        final Object obj = this;
        synchronized (this) {
            try {
                long l3 = 0L;
                obj.h0 = l3;
            } catch (Throwable th) {
            }
        }
        long l27 = 262143L & l;
        long l10 = 147457L;
        final long l30 = 139265L;
        final long l31 = 131089L;
        final long l32 = 135169L;
        final long l33 = 131081L;
        final long l34 = 132097L;
        final long l35 = 131105L;
        final long l36 = 131585L;
        final long l37 = 163841L;
        final long l38 = 133121L;
        final long l39 = 131077L;
        long l40 = 131137L;
        final long l42 = 131075L;
        long l43 = 131329L;
        i = 0;
        i2 = 0;
        if (l27 != l3) {
            long l45 = l & 131075L;
            i2 = 4;
            if (l45 != l3) {
                if (obj.d0 != null) {
                    boolean z2 = obj.d0.w();
                } else {
                }
                if (l45 != l3) {
                    int r46 = i2 != 0 ? 8388608 : 4194304;
                    l = l | (i2 != 0 ? 8388608 : 4194304);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l46 = l & 131077L;
            if (l46 != l3) {
                if (obj.d0 != null) {
                    boolean z3 = obj.d0.v();
                } else {
                }
                if (l46 != l3) {
                    int r47 = i2 != 0 ? 524288 : 262144;
                    l = l | (i2 != 0 ? 524288 : 262144);
                }
                if (i2 != 0) {
                }
            }
            long l47 = l & 163841L;
            if (l47 == l3 || obj.d0 == null) {
            } else {
                String translationButtonString = obj.d0.getTranslationButtonString();
            }
            long l48 = l & 131105L;
            if (l48 == l3 || obj.d0 == null) {
            } else {
                String str3 = obj.d0.d();
            }
            long l49 = l & 131081L;
            if (l49 != l3) {
                if (obj.d0 != null) {
                    likeState = obj.d0.getLikeState();
                } else {
                }
                if (l49 != l3) {
                    int r49 = likeState ? 536870912 : 268435456;
                    l = l | (likeState ? 536870912 : 268435456);
                }
                int r12 = likeState ? R.color.secondary : R.color.icon_gray;
                i2 = ViewDataBinding.u(obj.V, (likeState ? R.color.secondary : R.color.icon_gray));
            } else {
            }
            long l29 = l & 131089L;
            if (l29 == l3 || obj.d0 == null) {
            } else {
                str = obj.d0.o();
            }
            long l50 = l & 139265L;
            i2 = 8;
            if (l50 != l3) {
                if (obj.d0 != null) {
                    boolean z4 = obj.d0.x();
                } else {
                }
                if (l50 != l3) {
                    int r53 = i2 != 0 ? 8589934592L : 4294967296L;
                    l = l | (i2 != 0 ? 8589934592L : 4294967296L);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l51 = l & 131201L;
            if (l51 != l3) {
                if (obj.d0 != null) {
                    boolean z5 = obj.d0.r();
                } else {
                }
                if (l51 != l3) {
                    int r54 = i2 != 0 ? 137438953472L : 68719476736L;
                    l = l | (i2 != 0 ? 137438953472L : 68719476736L);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l52 = l & 131329L;
            if (l52 != l3) {
                if (obj.d0 != null) {
                    boolean z6 = obj.d0.p();
                } else {
                }
                if (l52 != l3) {
                    int r55 = i2 != 0 ? 2147483648L : 1073741824;
                    l = l | (i2 != 0 ? 2147483648L : 1073741824);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l53 = l & 131137L;
            if (l53 != l3) {
                if (obj.d0 != null) {
                    boolean z7 = obj.d0.q();
                } else {
                }
                if (l53 != l3) {
                    int r56 = i2 != 0 ? 134217728 : 67108864;
                    l = l | (i2 != 0 ? 134217728 : 67108864);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l54 = l & 147457L;
            if (l54 != l3) {
                if (obj.d0 != null) {
                    boolean translateButtonVisible = obj.d0.isTranslateButtonVisible();
                } else {
                }
                if (l54 != l3) {
                    int r57 = i2 != 0 ? 2097152 : 1048576;
                    l = l | (i2 != 0 ? 2097152 : 1048576);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l55 = l & 132097L;
            if (l55 == l3 || obj.d0 == null) {
                i3 = 0;
            } else {
                float f = obj.d0.h();
            }
            long l56 = l & 135169L;
            if (l56 != l3) {
                if (obj.d0 != null) {
                    boolean z8 = obj.d0.t();
                } else {
                }
                if (l56 != l3) {
                    int r58 = i2 != 0 ? 34359738368L : 17179869184L;
                    l = l | (i2 != 0 ? 34359738368L : 17179869184L);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l57 = l & 133121L;
            if (l57 == l3 || obj.d0 == null) {
            } else {
                String str4 = obj.d0.f();
            }
            long l58 = l & 196609L;
            if (l58 != l3) {
                if (obj.d0 != null) {
                    boolean spinnerVisible = obj.d0.isSpinnerVisible();
                } else {
                }
                if (l58 != l3) {
                    int r60 = i2 != 0 ? 549755813888L : 274877906944L;
                    l = l | (i2 != 0 ? 549755813888L : 274877906944L);
                }
                if (i2 != 0) {
                }
            }
            long l11 = 131073L;
            long l59 = l & l11;
            if (l59 != l3 && obj.d0 != null) {
                boolean z = obj.d0.m();
                if (l59 != l3) {
                    r58 = i2 != 0 ? 33554432 : 0x01000000 /* Unknown resource */;
                    l = l | (i2 != 0 ? 33554432 : 0x01000000 /* Unknown resource */);
                }
                int r9 = i2 != 0 ? R.color.light_green : R.color.white;
            }
            long l28 = l & 131585L;
            if (obj.e0 != l3 && obj.d0 != null) {
                android.text.SpannableStringBuilder spannableStringBuilder = obj.d0.g();
            }
        } else {
            i3 = 0;
        }
        long l44 = l & 131329L;
        if (l44 != l3) {
            obj.O.setVisibility(i2);
        }
        long l16 = l & 131137L;
        long l41 = 0L;
        if (obj.O != l41) {
            obj.P.setVisibility(i2);
        }
        long l17 = l & 133121L;
        if (obj.P != l41) {
            g.c(obj.Q, charSequence);
            g.c(obj.R, charSequence);
        }
        long l18 = l & 131585L;
        if (obj.P != l41) {
            g.c(obj.S, charSequence3);
        }
        long l19 = l & 132097L;
        if (obj.P != l41) {
            g.d(obj.S, i3);
        }
        long l20 = l & 135169L;
        if (obj.P != l41) {
            obj.T.setVisibility(i2);
        }
        long l21 = l & 131077L;
        if (obj.P != l41) {
            obj.U.setVisibility(i2);
        }
        l4 = l & 131081L;
        if (obj.P != l41) {
            obj.V.setEnabled(likeState);
            if (ViewDataBinding.t() >= 21) {
                obj.V.setImageTintList(b.a(i2));
            }
        }
        l5 = 131073L & l;
        long l26 = 0L;
        if (obj.P != l26) {
            h.a(obj.e0, b.b(i2));
        }
        long l22 = l & 131089L;
        if (obj.P != l26) {
            g.c(obj.f0, obj2);
        }
        long l23 = 196609L & l;
        if (obj.P != l26) {
            obj.W.setVisibility(i2);
        }
        long l24 = 131201L & l;
        if (obj.P != l26) {
            obj.X.setVisibility(i2);
        }
        l6 = l & 131105L;
        if (obj.P != l26) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.Y, i);
        }
        l7 = l & 131075L;
        if (obj.P != l26) {
            obj.Z.setVisibility(i2);
        }
        long l25 = l & 139265L;
        if (obj.P != l26) {
            obj.a0.setVisibility(i2);
        }
        l8 = 131072L & l;
        if (obj.P != l26) {
            obj.b0.setOnClickListener(obj.g0);
        }
        l9 = l & 163841L;
        if (obj.P != l26) {
            g.c(obj.b0, i);
        }
        l2 = l & 147457L;
        if (obj.h0 != l26) {
            obj.c0.setVisibility(i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k0
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

    private l0(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ImageView)objectArr[8], (ImageView)objectArr[6], (View)objectArr[18], (TextView)objectArr[10], (TextView)objectArr[11], (TextView)objectArr[9], (FrameLayout)objectArr[12], (RelativeLayout)objectArr[2], (ImageView)objectArr[3], (ProgressBar)objectArr[16], (ImageView)objectArr[7], (ImageView)objectArr[5], (TextView)objectArr[17], (FrameLayout)objectArr[1], (FrameLayout)objectArr[13], (FrameLayout)objectArr[19], (TextView)objectArr[15], (RelativeLayout)objectArr[14]);
        Object eVar4 = this;
        eVar4.h0 = -1L;
        Object obj3 = null;
        eVar4.O.setTag(obj3);
        eVar4.P.setTag(obj3);
        eVar4.Q.setTag(obj3);
        eVar4.R.setTag(obj3);
        eVar4.S.setTag(obj3);
        eVar4.T.setTag(obj3);
        eVar4.U.setTag(obj3);
        eVar4.V.setTag(obj3);
        Object obj = objectArr[0];
        eVar4.e0 = obj;
        obj.setTag(obj3);
        Object obj2 = objectArr[4];
        eVar4.f0 = obj2;
        obj2.setTag(obj3);
        eVar4.W.setTag(obj3);
        eVar4.X.setTag(obj3);
        eVar4.Y.setTag(obj3);
        eVar4.Z.setTag(obj3);
        eVar4.a0.setTag(obj3);
        eVar4.b0.setTag(obj3);
        eVar4.c0.setTag(obj3);
        eVar4.N(view);
        eVar4.g0 = new b(eVar4, 1);
        A();
    }
}
