package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellChallengeNotificationItemBindingImpl.java */
/* loaded from: classes.dex */
public class d1 extends c1 {

    private static final ViewDataBinding.g i0;
    private static final SparseIntArray j0 = new SparseIntArray();
    private final FrameLayout c0;
    private final LinearLayout d0;
    private final TextView e0;
    private final TextView f0;
    private final FrameLayout g0;
    private long h0;
    static {
        obj.put(2131363033, 17);
        obj.put(2131362582, 18);
        obj.put(2131362344, 19);
    }

    public d1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 20, d1.i0, d1.j0));
    }

    @Override // app.dogo.com.dogo_android.h.c1
    public void A() {
        synchronized (this) {
            try {
                this.h0 = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c1
    public boolean O(int i, Object object) {
        boolean z = true;
        if (118 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.c1
    public void V(app.dogo.com.dogo_android.d.c.j.b bVar) {
        this.b0 = bVar;
        synchronized (this) {
            try {
                this.h0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(118);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c1
    protected void m() {
        int i = 0;
        long l;
        long l2;
        long l3;
        String str;
        int i2;
        java.lang.CharSequence charSequence;
        int i4;
        java.lang.CharSequence charSequence2;
        String str2 = null;
        int i5 = 0;
        java.lang.CharSequence charSequence3;
        int i3;
        int i6 = 0;
        int i7 = 0;
        String str4;
        int i8 = 0;
        int i9 = 0;
        app.dogo.com.dogo_android.d.c.j.b bVar;
        int i10 = 0;
        int i12 = 256;
        int i13 = 131072;
        int i14 = 16384;
        int i11 = 1024;
        int cmp2;
        final Object obj = this;
        synchronized (this) {
            try {
                long l11 = 0L;
                obj.h0 = l11;
            } catch (Throwable th) {
            }
        }
        long l12 = 3L;
        long l13 = l & l12;
        i3 = 0;
        if (l13 != l11) {
            if (obj.b0 != null) {
                boolean z = obj.b0.p();
                String str3 = obj.b0.k();
                boolean z2 = obj.b0.q();
                boolean z3 = obj.b0.o();
                String str5 = obj.b0.d();
                i8 = obj.b0.a();
                boolean z4 = obj.b0.n();
                String str6 = obj.b0.g();
                String str7 = obj.b0.h();
                String str8 = obj.b0.b();
                String str9 = obj.b0.l();
            } else {
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i10 = 0;
            }
            if (l13 != l11) {
                if (i5 != 0) {
                    l3 = (l | 8L) | 128L;
                    i11 = 2048;
                } else {
                    l3 = (l | 4L) | 64L;
                    i11 = 1024;
                }
                l = l3 | i11;
            }
            l4 = l & 3L;
            if (l4 != l11) {
                int r21 = i6 != 0 ? 512 : 256;
                l = l | (i6 != 0 ? 512 : 256);
            }
            l5 = l & 3L;
            if (l5 != l11) {
                if (i7 != 0) {
                    l2 = l | 32L;
                    i13 = 131072;
                } else {
                    l2 = l | 16L;
                    i13 = 65536;
                }
                l = l2 | i13;
            }
            l6 = l & 3L;
            if (l6 != l11 && i10 != 0) {
                i14 = 32768;
                l = l | i14;
            }
            int i16 = 2131099857;
            int i17 = 17170443;
            if (i5 != 0) {
                i2 = ViewDataBinding.u(obj.g0, i16);
            } else {
                i2 = ViewDataBinding.u(obj.g0, i17);
            }
            if (i5 != 0) {
                i4 = ViewDataBinding.u(obj.U, i16);
            } else {
                i4 = ViewDataBinding.u(obj.U, i17);
            }
            i = 8;
            int r9 = i5 != 0 ? 0 : i;
            int r10 = i6 != 0 ? 0 : i;
            int r12 = i7 != 0 ? i : 0;
            int r13 = i7 != 0 ? 0 : i;
            int r15 = i8 > 0 ? 1 : 0;
            int r16 = i10 != 0 ? 0 : i;
            long l14 = l & 3L;
            long l7 = 0L;
            if (l14 != l7) {
                int r24 = i9 != 0 ? 8192 : 4096;
                l = l | (i9 != 0 ? 8192 : 4096);
            }
            r21 = i9 != 0 ? 0 : i;
            i = (i9 != 0 ? 0 : i);
        } else {
            i = 0;
            i = 0;
            i = 0;
            i = 0;
            i = 0;
            i2 = 0;
            i4 = 0;
            i = 0;
        }
        l &= l12;
        if (obj.h0 != 0) {
            obj.O.setVisibility(i);
            obj.P.setVisibility(i);
            app.dogo.com.dogo_android.util.binding.m.o(obj.Q, str2);
            app.dogo.com.dogo_android.util.binding.m.o(obj.R, str4);
            obj.S.setVisibility(i);
            BindingAdapters.w(obj.T, str);
            h.a(obj.U, b.b(i4));
            obj.V.setVisibility(i);
            obj.d0.setVisibility(i);
            g.c(obj.e0, charSequence);
            g.c(obj.f0, charSequence2);
            obj.f0.setVisibility(i);
            g.c(obj.W, charSequence3);
            obj.X.setVisibility(i);
            BindingAdapters.Q(obj.Y, bVar);
            app.dogo.com.dogo_android.util.binding.m.o(obj.a0, str4);
            int cmp = 21;
            if (ViewDataBinding.t() >= 21) {
                obj.g0.setBackgroundTintList(b.a(i2));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.c1
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

    private d1(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[13], (ImageView)objectArr[10], (ImageView)objectArr[7], (ImageView)objectArr[12], (RelativeLayout)objectArr[11], (RelativeLayout)objectArr[19], (ImageView)objectArr[2], (ConstraintLayout)objectArr[1], (FrameLayout)objectArr[18], (ImageView)objectArr[16], (TextView)objectArr[15], (FrameLayout)objectArr[6], (TextView)objectArr[14], (RelativeLayout)objectArr[17], (ImageView)objectArr[9]);
        Object eVar3 = this;
        eVar3.h0 = -1L;
        Object obj6 = null;
        eVar3.O.setTag(obj6);
        eVar3.P.setTag(obj6);
        eVar3.Q.setTag(obj6);
        eVar3.R.setTag(obj6);
        eVar3.S.setTag(obj6);
        eVar3.T.setTag(obj6);
        eVar3.U.setTag(obj6);
        eVar3.V.setTag(obj6);
        Object obj = objectArr[0];
        eVar3.c0 = obj;
        obj.setTag(obj6);
        Object obj2 = objectArr[3];
        eVar3.d0 = obj2;
        obj2.setTag(obj6);
        Object obj3 = objectArr[4];
        eVar3.e0 = obj3;
        obj3.setTag(obj6);
        Object obj4 = objectArr[5];
        eVar3.f0 = obj4;
        obj4.setTag(obj6);
        Object obj5 = objectArr[8];
        eVar3.g0 = obj5;
        obj5.setTag(obj6);
        eVar3.W.setTag(obj6);
        eVar3.X.setTag(obj6);
        eVar3.Y.setTag(obj6);
        eVar3.a0.setTag(obj6);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
