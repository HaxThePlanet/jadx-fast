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
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.k0.g;

/* loaded from: classes.dex */
public class dn extends app.dogo.com.dogo_android.h.cn implements b.a {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0;
    private final ImageView X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private final View.OnClickListener a0;
    private final View.OnClickListener b0;
    private long c0;
    static {
    }

    public dn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, dn.d0, dn.e0));
    }

    private dn(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        final int i11 = 1;
        final int i14 = 4;
        int i10 = 3;
        super(e, view2, 1, (TextView)object3Arr3[6], (FrameLayout)object3Arr3[5], (FrameLayout)object3Arr3[i11], (AppCompatImageView)object3Arr3[2], (FrameLayout)object3Arr3[i14], (FrameLayout)object3Arr3[8], (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[i10]);
        obj20.c0 = -1;
        int i7 = 0;
        obj20.O.setTag(i7);
        obj20.P.setTag(i7);
        obj20.Q.setTag(i7);
        obj20.R.setTag(i7);
        obj20.S.setTag(i7);
        Object obj10 = object3Arr3[7];
        obj20.X = (ImageView)obj10;
        obj10.setTag(i7);
        obj20.T.setTag(i7);
        obj20.U.setTag(i7);
        obj20.V.setTag(i7);
        obj20.N(view2);
        b bVar = new b(obj20, i10);
        obj20.Y = bVar;
        b bVar2 = new b(obj20, i11);
        obj20.Z = bVar2;
        b bVar3 = new b(obj20, i14);
        obj20.a0 = bVar3;
        b bVar4 = new b(obj20, 2);
        obj20.b0 = bVar4;
        A();
    }

    private boolean V(g g, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.c0 = l7 |= i20;
            return obj5;
            synchronized (this) {
                this.c0 = l7 |= i20;
                return obj5;
            }
        }
        if (i2 == 15) {
            this.c0 = l6 |= i19;
            return obj5;
            synchronized (this) {
                this.c0 = l6 |= i19;
                return obj5;
            }
        }
        if (i2 == 160) {
            this.c0 = l5 |= i18;
            return obj5;
            synchronized (this) {
                this.c0 = l5 |= i18;
                return obj5;
            }
        }
        if (i2 == 22) {
            this.c0 = l4 |= i17;
            return obj5;
            synchronized (this) {
                this.c0 = l4 |= i17;
                return obj5;
            }
        }
        if (i2 == obj5) {
            this.c0 = l3 |= i16;
            return obj5;
            synchronized (this) {
                this.c0 = l3 |= i16;
                return obj5;
            }
        }
        if (i2 == 72) {
            this.c0 = l2 |= i15;
            return obj5;
            synchronized (this) {
                this.c0 = l2 |= i15;
                return obj5;
            }
        }
        if (i2 == 113) {
            this.c0 = l |= i14;
            return obj5;
            synchronized (this) {
                this.c0 = l |= i14;
                return obj5;
            }
        }
        try {
            return 0;
        } catch (Throwable th) {
        }
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public void A() {
        this.c0 = 128;
        I();
        return;
        synchronized (this) {
            this.c0 = 128;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cn
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return V((g)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public boolean O(int i, Object object2) {
        int obj2;
        if (162 == i) {
            U((g)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public void U(g g) {
        R(0, g);
        this.W = g;
        this.c0 = l |= i3;
        notifyPropertyChanged(162);
        super.I();
        return;
        synchronized (this) {
            R(0, g);
            this.W = g;
            this.c0 = l |= i3;
            notifyPropertyChanged(162);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public final void b(int i, View view2) {
        int context;
        int i2;
        g obj4;
        context = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                    } else {
                        obj4 = this.W;
                        if (obj4 != null) {
                            context = i3;
                        }
                        if (context != null) {
                            obj4.onMoreAction(w().getContext(), view2);
                        }
                    }
                } else {
                    obj4 = this.W;
                    if (obj4 != null) {
                        context = i3;
                    }
                    if (context != null) {
                        obj4.onAction();
                    }
                }
            } else {
                obj4 = this.W;
                if (obj4 != null) {
                    context = i3;
                }
                if (context != null) {
                    obj4.onBlockAction();
                }
            }
        } else {
            obj4 = this.W;
            if (obj4 != null) {
                context = i3;
            }
            if (context != null) {
                obj4.onBack();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.cn
    protected void m() {
        int i18;
        int cmp4;
        int cmp7;
        int cmp3;
        int cmp5;
        int cmp;
        int cmp6;
        int backgroundColorRes;
        long l;
        int i7;
        int cmp2;
        int i5;
        int i2;
        String str;
        int i11;
        int i22;
        int textColorRes;
        int i21;
        int actionName;
        int i6;
        int i;
        int elevationDimension;
        int i8;
        int backArrowColorRes;
        int textColorRes2;
        int i9;
        int i19;
        int i12;
        int i13;
        int title;
        int i15;
        int cmp8;
        String flagVisible;
        int moreActionVisible;
        int i14;
        int i3;
        int i16;
        int i17;
        int i20;
        int backVisible;
        int blockVisible;
        int i4;
        int i10;
        final Object obj = this;
        l = obj.c0;
        i7 = 0;
        obj.c0 = i7;
        i18 = 0;
        g gVar = obj.W;
        int i39 = 129;
        final int i41 = 161;
        int i42 = 145;
        title = 0;
        i15 = 0;
        synchronized (this) {
            obj = this;
            l = obj.c0;
            i7 = 0;
            obj.c0 = i7;
            i18 = 0;
            gVar = obj.W;
            i39 = 129;
            i41 = 161;
            i42 = 145;
            title = 0;
            i15 = 0;
        }
        int cmp10 = Long.compare(i44, i7);
        int i45 = 8;
        if (cmp10 != 0) {
            if (gVar != null) {
                try {
                    flagVisible = gVar.isFlagVisible();
                    flagVisible = i15;
                    if (cmp10 != 0) {
                    }
                    if (flagVisible != 0) {
                    } else {
                    }
                    i14 = 512;
                    i14 = 256;
                    l |= i14;
                }
                if (flagVisible != 0) {
                    i22 = i15;
                } else {
                    i22 = i45;
                }
            } else {
            }
        } else {
        }
        moreActionVisible = Long.compare(i46, i7);
        if (moreActionVisible != 0) {
            if (gVar != null) {
                backgroundColorRes = gVar.getBackgroundColorRes(obj.U);
                textColorRes = gVar.getTextColorRes(obj.O);
                actionName = gVar.getActionName();
                elevationDimension = gVar.getElevationDimension(obj.U);
                backArrowColorRes = gVar.getBackArrowColorRes(obj.R);
                textColorRes2 = gVar.getTextColorRes(obj.V);
            } else {
                elevationDimension = i18;
                actionName = title;
                textColorRes2 = backArrowColorRes;
            }
            i6 = actionName != 0 ? 1 : i15;
            if (moreActionVisible != 0) {
                i17 = i6 != 0 ? 131072 : 65536;
                l |= i17;
            }
            i21 = i6 != 0 ? i15 : i45;
        } else {
            elevationDimension = i18;
            textColorRes2 = backArrowColorRes;
        }
        int cmp11 = Long.compare(i20, i7);
        if (cmp11 != 0) {
            if (gVar != null) {
                moreActionVisible = gVar.isMoreActionVisible();
            } else {
                moreActionVisible = i15;
            }
            if (cmp11 != 0) {
                i20 = moreActionVisible != 0 ? 8192 : 4096;
                l |= i20;
            }
            if (moreActionVisible != 0) {
                i19 = i15;
            } else {
                i19 = i45;
            }
        } else {
        }
        if (Long.compare(i47, i7) != 0 && gVar != null) {
            if (gVar != null) {
                flagVisible = gVar.getActionName();
            } else {
                flagVisible = title;
            }
        } else {
        }
        int cmp14 = Long.compare(i48, i7);
        if (cmp14 != 0) {
            if (gVar != null) {
                backVisible = gVar.isBackVisible();
            } else {
                backVisible = i15;
            }
            if (cmp14 != 0) {
                blockVisible = backVisible != 0 ? 2048 : 1024;
                l |= blockVisible;
            }
            if (backVisible != 0) {
                i17 = i15;
            } else {
                i17 = i45;
            }
        } else {
        }
        int cmp15 = Long.compare(i49, i7);
        if (cmp15 != 0) {
            if (gVar != null) {
                blockVisible = gVar.isBlockVisible();
            } else {
                blockVisible = i15;
            }
            if (cmp15 != 0) {
                i4 = blockVisible ? 32768 : 16384;
                l |= i4;
            }
            if (blockVisible) {
            } else {
                i15 = i45;
            }
        }
        if (Long.compare(backVisible, i7) != 0 && gVar != null) {
            if (gVar != null) {
                title = gVar.getTitle();
            }
        }
        i12 = i22;
        i13 = i19;
        i11 = title;
        i9 = i15;
        str = flagVisible;
        i15 = backArrowColorRes;
        i8 = i17;
        i = backgroundColorRes;
        i18 = i10;
        if (Long.compare(i43, i7) != 0) {
            g.c(obj.O, str);
        }
        obj.O.setTextColor(textColorRes);
        obj.P.setVisibility(i21);
        n.i0(obj.R, Integer.valueOf(i15));
        h.a(obj.U, b.b(i));
        obj.V.setTextColor(textColorRes2);
        if (Long.compare(i24, i40) != 0 && ViewDataBinding.t() >= 21) {
            obj.O.setTextColor(textColorRes);
            obj.P.setVisibility(i21);
            n.i0(obj.R, Integer.valueOf(i15));
            h.a(obj.U, b.b(i));
            obj.V.setTextColor(textColorRes2);
            if (ViewDataBinding.t() >= 21) {
                obj.P.setBackgroundTintList(b.a(i));
                obj.Q.setBackgroundTintList(b.a(i));
                obj.S.setBackgroundTintList(b.a(i));
                obj.T.setBackgroundTintList(b.a(i));
                obj.U.setElevation(i18);
            }
        }
        if (Long.compare(i5, i36) != 0) {
            obj.P.setOnClickListener(obj.Y);
            obj.Q.setOnClickListener(obj.Z);
            obj.S.setOnClickListener(obj.b0);
            obj.T.setOnClickListener(obj.a0);
        }
        int i37 = 0;
        if (Long.compare(i27, i37) != 0) {
            obj.Q.setVisibility(i8);
        }
        if (Long.compare(i29, i37) != 0) {
            obj.S.setVisibility(i9);
        }
        if (Long.compare(i30, i37) != 0) {
            obj.X.setVisibility(i12);
        }
        if (Long.compare(i32, i37) != 0) {
            obj.T.setVisibility(i13);
        }
        if (Long.compare(i23, i37) != 0) {
            g.c(obj.V, i11);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cn
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
