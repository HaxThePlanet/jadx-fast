package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.a0.g.f.d0;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogChallengeDetailsBindingImpl.java */
/* loaded from: classes.dex */
public class h8 extends g8 implements b.a, a.a {

    private static final ViewDataBinding.g q0 = new ViewDataBinding$g(22);
    private static final SparseIntArray r0 = new SparseIntArray();
    private final ConstraintLayout c0;
    private final FrameLayout d0;
    private final gi e0;
    private final FrameLayout f0;
    private final ok g0;
    private final LinearLayout h0;
    private final TextView i0;
    private final TextView j0;
    private final TextView k0;
    private final RelativeLayout l0;
    private final View.OnClickListener m0;
    private final View.OnClickListener n0;
    private final CompoundButton.OnCheckedChangeListener o0;
    private long p0;
    static {
        String str = "cell_challenge_details_tab";
        i.a(2, new String[] { str, str, str }, new int[] { 16, 17, 18 }, new int[] { R.layout.cell_challenge_details_tab, R.layout.cell_challenge_details_tab, R.layout.cell_challenge_details_tab });
        int i7 = 1;
        int[] iArr4 = new int[i7];
        final int i17 = 0;
        iArr4[i17] = 15;
        int[] iArr7 = new int[i7];
        iArr7[i17] = R.layout.layout_sponsor_universal_details_banner;
        i.a(7, new String[] { "layout_sponsor_universal_details_banner" }, iArr4, iArr7);
        int[] iArr5 = new int[i7];
        iArr5[i17] = 19;
        int[] iArr8 = new int[i7];
        iArr8[i17] = R.layout.layout_custom_fab;
        i.a(11, new String[] { "layout_custom_fab" }, iArr5, iArr8);
        int[] iArr6 = new int[i7];
        iArr6[i17] = 20;
        int[] iArr2 = new int[i7];
        iArr2[i17] = R.layout.layout_dog_creation_loading_spinner;
        i.a(12, new String[] { "layout_dog_creation_loading_spinner" }, iArr6, iArr2);
        i.put(2131362544, 13);
        i.put(2131362002, 14);
        i.put(2131363182, 21);
    }

    public h8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 22, h8.q0, h8.r0));
    }

    private boolean X(o0 o0Var, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(o0 o0Var, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(o0 o0Var, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(um umVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(d0 d0Var, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw d0Var;
            }
        }
        if (i == 148) {
            synchronized (this) {
                try {
                    this.p0 |= 256;
                    return true;
                } catch (Throwable unused) {
                }
                throw d0Var;
            }
        }
        if (i == 76) {
            synchronized (this) {
                try {
                    this.p0 |= 512;
                    return true;
                } catch (Throwable unused) {
                }
                throw d0Var;
            }
        }
        if (i == 20) {
            synchronized (this) {
                try {
                    this.p0 |= 1024;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 168) {
            synchronized (this) {
                try {
                    this.p0 |= 2048;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 26) {
            synchronized (this) {
                try {
                    this.p0 |= 4096;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(app.dogo.com.dogo_android.util.g0.a aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean d0(LiveData<y<Boolean>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void A() {
        synchronized (this) {
            try {
                this.p0 = 8192L;
            } catch (Throwable th) {
            }
        }
        this.Z.A();
        this.U.A();
        this.V.A();
        this.T.A();
        this.e0.A();
        this.g0.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g8
    protected boolean E(int i, Object object, int i2) {
        switch (i) {
            case 0:
                return this.Y(object, i2);
            case 1:
                return this.b0(object, i2);
            case 2:
                return this.c0(object, i2);
            case 3:
                return this.X(object, i2);
            case 4:
                return this.Z(object, i2);
            case 5:
                return this.a0(object, i2);
            case 6:
                return this.d0(object, i2);
            default:
                return false;
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void M(q qVar) {
        super.M(qVar);
        this.Z.M(qVar);
        this.U.M(qVar);
        this.V.M(qVar);
        this.T.M(qVar);
        this.e0.M(qVar);
        this.g0.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void V(a0 a0Var) {
        this.b0 = a0Var;
        synchronized (this) {
            try {
                this.p0 |= 128;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void W(d0 d0Var) {
        R(1, d0Var);
        this.a0 = d0Var;
        synchronized (this) {
            try {
                this.p0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.a0 != null) {
            }
            if (i2 != 0) {
                this.a0.onTermAcceptClick(this.b0);
            }
        } else {
            if (this.a0 == 3) {
                if (this.a0 != null) {
                }
                if (i2 != 0) {
                    this.a0.onSponsorBannerClick(this.b0);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public final void c(int i, CompoundButton compoundButton, boolean z) {
        int i2 = 1;
        compoundButton = this.a0 != null ? 1 : 0;
        if (i2 != 0) {
            this.a0.setArguments(z);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    protected void m() {
        int cmp = 0;
        int i = 0;
        long l;
        y yVar;
        LiveData liveData;
        Object value;
        int i3 = 6;
        java.lang.CharSequence charSequence;
        String str;
        java.lang.CharSequence charSequence2;
        int i2;
        Object obj2;
        int i5 = 0;
        int cmp11;
        int i6 = 0;
        int i7;
        int i4;
        int i8;
        long l6;
        int i10 = 65536;
        int i9 = 16777216;
        int i11 = 0;
        int i12;
        int i13;
        int i14 = 1048576;
        long l8;
        int i15 = 4194304;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l10 = 0L;
                obj.p0 = l10;
            } catch (Throwable th) {
            }
        }
        long l11 = 16198L & l;
        long l3 = 10242L;
        long l4 = 8450L;
        final long l18 = 12290L;
        long l19 = 9218L;
        final long l22 = 8194L;
        final androidx.databinding.g gVar = null;
        if (l11 != l10) {
            long l23 = l & 12290L;
            cmp = 8;
            if (l23 != l10) {
                if (obj.a0 != null) {
                    boolean z3 = obj.a0.S();
                } else {
                    i6 = 0;
                }
                if (l23 != l10) {
                    int r27 = i6 != 0 ? 134217728 : 67108864;
                    l = l | (i6 != 0 ? 134217728 : 67108864);
                }
                if (i6 != 0) {
                    cmp = 0;
                } else {
                }
            }
            long l24 = l & 8194L;
            if (l24 != l10) {
                if (obj.a0 != null) {
                    boolean z4 = obj.a0.Q();
                    String str2 = obj.a0.H();
                    String str3 = obj.a0.O();
                    String str4 = obj.a0.F();
                    boolean z5 = obj.a0.I();
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                if (l24 != l10) {
                    int r32 = i7 != 0 ? 33554432 : 0x01000000 /* Unknown resource */;
                    l = l | (i7 != 0 ? 33554432 : 0x01000000 /* Unknown resource */);
                }
                l6 = l & 8194L;
                if (l6 != l10) {
                    r32 = i8 != 0 ? 131072 : 65536;
                    l = l | (i8 != 0 ? 131072 : 65536);
                }
                int r26 = i7 != 0 ? cmp : 0;
                if (i8 != 0) {
                    cmp = 0;
                } else {
                }
            } else {
                cmp = 0;
            }
            long l25 = l & 9218L;
            if (l25 != l10) {
                if (obj.a0 != null) {
                    boolean z6 = obj.a0.R();
                } else {
                    i11 = 0;
                }
                if (l25 != l10) {
                    int r33 = i11 != 0 ? 32768 : 16384;
                    l = l | (i11 != 0 ? 32768 : 16384);
                }
                if (i11 != 0) {
                    cmp = 0;
                } else {
                }
            }
            long l26 = l & 8450L;
            if (l26 != l10) {
                if (obj.a0 != null) {
                    boolean z7 = obj.a0.W();
                } else {
                    i12 = 0;
                }
                if (l26 != l10) {
                    int r34 = i12 != 0 ? 524288 : 262144;
                    l = l | (i12 != 0 ? 524288 : 262144);
                }
                if (i12 != 0) {
                    cmp = 0;
                } else {
                }
            }
            long l27 = l & 8198L;
            if (l27 != l10) {
                app.dogo.com.dogo_android.util.g0.a aVar = obj.a0 != null ? aVar : gVar;
                obj.R(2, obj2);
            } else {
                i2 = gVar;
            }
            long l17 = l & 10242L;
            if (l17 != l10) {
                if (obj.a0 != null) {
                    boolean z2 = obj.a0.X();
                } else {
                    i5 = 0;
                }
                if (l17 != l10) {
                    int r36 = i5 != 0 ? 2097152 : 1048576;
                    l = l | (i5 != 0 ? 2097152 : 1048576);
                }
                if (i5 != 0) {
                    cmp = 0;
                } else {
                }
            }
            l7 = l & 8258L;
            if (l7 != l10) {
                liveData = obj.a0 != null ? liveData : gVar;
                i3 = 6;
                obj.Q(i3, liveData);
                value = liveData != null ? (LoadResult)value : gVar;
            }
            long l5 = 8706L;
            l8 = l & l5;
            if (l8 != l10) {
                if (obj.a0 != null) {
                    boolean z = obj.a0.V();
                } else {
                    i = 0;
                }
                if (l8 != l10) {
                    int r38 = obj.a0 != 0 ? 8388608 : 4194304;
                    l = l | (obj.a0 != 0 ? 8388608 : 4194304);
                }
                r33 = obj.a0 != 0 ? 0 : cmp;
                cmp = (obj.a0 != 0 ? 0 : cmp);
            } else {
                cmp = 0;
            }
        } else {
            cmp = 0;
            cmp = 0;
            cmp = 0;
            cmp = 0;
            cmp = 0;
            cmp = 0;
            cmp = 0;
        }
        long l20 = l & 9218L;
        if (l20 != l10) {
            obj.O.setVisibility(cmp);
        }
        long l21 = l & 8194L;
        if (l21 != l10) {
            BindingAdapters.w(obj.P, str);
            obj.i0.setVisibility(cmp);
            g.c(obj.j0, charSequence2);
            g.c(obj.k0, charSequence);
            obj.l0.setVisibility(cmp);
            obj.Y.setTitle(charSequence2);
        }
        long l15 = 8192L & l;
        if (l15 != l10) {
            a.b(obj.Q, obj.o0, gVar);
            obj.R.setOnClickListener(obj.m0);
            obj.X.setOnClickListener(obj.n0);
        }
        long l16 = l & 12290L;
        if (l16 != l10) {
            obj.R.setVisibility(cmp);
            obj.d0.setVisibility(cmp);
        }
        long l13 = 8706L & l;
        if (l13 != l10) {
            obj.S.setVisibility(cmp);
        }
        long l14 = 8258L & l;
        if (l14 != l10) {
            BindingAdapters.setTrainerAvatar(obj.c0, yVar);
            BindingAdapters.setDebugJsonEntryItemAdapter(obj.f0, yVar);
        }
        long l12 = 8198L & l;
        if (obj.o0 != l10) {
            obj.e0.T(i2);
        }
        l2 = 8450L & l;
        if (obj.o0 != l10) {
            obj.U.w().setVisibility(cmp);
            obj.X.setVisibility(cmp);
        }
        l &= 10242;
        if (obj.p0 != l10) {
            obj.Z.w().setVisibility(cmp);
        }
        ViewDataBinding.o(obj.Z);
        ViewDataBinding.o(obj.U);
        ViewDataBinding.o(obj.V);
        ViewDataBinding.o(obj.T);
        ViewDataBinding.o(obj.e0);
        ViewDataBinding.o(obj.g0);
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z7 = true;
                if (this.p0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Z.y()) {
            return true;
        }
        if (this.U.y()) {
            return true;
        }
        if (this.V.y()) {
            return true;
        }
        if (this.T.y()) {
            return true;
        }
        if (this.e0.y()) {
            return true;
        }
        if (this.g0.y()) {
            return true;
        }
        return false;
    }

    private h8(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 7, (View)objectArr[14], (ImageView)objectArr[3], (CheckBox)objectArr[9], (FrameLayout)objectArr[11], (View)objectArr[13], (o0)objectArr[18], (o0)objectArr[16], (o0)objectArr[17], (ScrollView)objectArr[21], (FrameLayout)objectArr[7], (MaterialToolbar)obj, (um)obj2);
        Object eVar4 = this;
        eVar4.p0 = -1L;
        Object obj18 = null;
        eVar4.P.setTag(obj18);
        eVar4.Q.setTag(obj18);
        eVar4.R.setTag(obj18);
        Object obj13 = objectArr[0];
        eVar4.c0 = obj13;
        obj13.setTag(obj18);
        Object obj14 = objectArr[10];
        eVar4.d0 = obj14;
        obj14.setTag(obj18);
        Object obj15 = objectArr[19];
        eVar4.e0 = obj15;
        eVar4.L(obj15);
        Object obj16 = objectArr[12];
        eVar4.f0 = obj16;
        obj16.setTag(obj18);
        Object obj17 = objectArr[20];
        eVar4.g0 = obj17;
        eVar4.L(obj17);
        int i17 = 2;
        Object obj19 = objectArr[i17];
        eVar4.h0 = obj19;
        obj19.setTag(obj18);
        Object obj20 = objectArr[4];
        eVar4.i0 = obj20;
        obj20.setTag(obj18);
        Object obj21 = objectArr[5];
        eVar4.j0 = obj21;
        obj21.setTag(obj18);
        Object obj22 = objectArr[6];
        eVar4.k0 = obj22;
        obj22.setTag(obj18);
        Object obj23 = objectArr[8];
        eVar4.l0 = obj23;
        obj23.setTag(obj18);
        eVar4.L(eVar4.T);
        eVar4.L(eVar4.U);
        eVar4.L(eVar4.V);
        eVar4.X.setTag(obj18);
        eVar4.Y.setTag(obj18);
        eVar4.L(eVar4.Z);
        eVar4.N(view);
        eVar4.m0 = new b(eVar4, 3);
        eVar4.n0 = new b(eVar4, 1);
        eVar4.o0 = new a(eVar4, i17);
        A();
    }
}
