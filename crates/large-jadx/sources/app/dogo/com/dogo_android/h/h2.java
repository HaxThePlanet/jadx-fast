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
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.d.d.r.h;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class h2 extends app.dogo.com.dogo_android.h.g2 {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final ConstraintLayout X;
    private long Y;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h2.a0 = sparseIntArray;
        sparseIntArray.put(2131362343, 9);
        sparseIntArray.put(2131362641, 10);
    }

    public h2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, h2.Z, h2.a0));
    }

    private h2(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        super(e, view2, 1, (ImageView)object3Arr3[5], (ImageView)object3Arr3[2], (TextView)object3Arr3[6], (ImageView)object3Arr3[1], (RelativeLayout)object3Arr3[9], (TextView)object3Arr3[3], (AppCompatImageView)object3Arr3[10], (TextView)object3Arr3[7], (ImageView)object3Arr3[4], (TextView)object3Arr3[8]);
        obj24.Y = -1;
        int i13 = 0;
        obj24.O.setTag(i13);
        obj24.P.setTag(i13);
        obj24.Q.setTag(i13);
        obj24.R.setTag(i13);
        obj24.S.setTag(i13);
        Object obj12 = object3Arr3[0];
        obj24.X = (ConstraintLayout)obj12;
        obj12.setTag(i13);
        obj24.T.setTag(i13);
        obj24.U.setTag(i13);
        obj24.V.setTag(i13);
        N(view2);
        A();
    }

    private boolean W(h h, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.Y = l6 |= i18;
            return obj5;
            synchronized (this) {
                this.Y = l6 |= i18;
                return obj5;
            }
        }
        if (i2 == 63) {
            this.Y = l5 |= i17;
            return obj5;
            synchronized (this) {
                this.Y = l5 |= i17;
                return obj5;
            }
        }
        if (i2 == 7) {
            this.Y = l |= i13;
            return obj5;
            synchronized (this) {
                this.Y = l |= i13;
                return obj5;
            }
        }
        if (i2 == 65) {
            this.Y = l2 |= i14;
            return obj5;
            synchronized (this) {
                this.Y = l2 |= i14;
                return obj5;
            }
        }
        if (i2 == 125) {
            this.Y = l3 |= i15;
            return obj5;
            synchronized (this) {
                this.Y = l3 |= i15;
                return obj5;
            }
        }
        if (i2 == 5) {
            this.Y = l4 |= i16;
            return obj5;
            synchronized (this) {
                this.Y = l4 |= i16;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.g2
    public void A() {
        this.Y = 64;
        I();
        return;
        synchronized (this) {
            this.Y = 64;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g2
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((h)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.g2
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((h)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g2
    public void V(h h) {
        R(0, h);
        this.W = h;
        this.Y = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, h);
            this.W = h;
            this.Y = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g2
    protected void m() {
        int i12;
        int cmp5;
        int cmp;
        int adminBadgeVisible;
        long l;
        int i15;
        int dogAvatar;
        int cmp2;
        int i8;
        int i5;
        int i7;
        int cmp4;
        int cmp3;
        int i14;
        int i10;
        int i6;
        int i9;
        int i2;
        int i11;
        int ambassadorBadgeVisible;
        int i3;
        int i4;
        int premiumBadgeVisible;
        int i;
        int i13;
        final Object obj = this;
        l = obj.Y;
        final int i16 = 0;
        obj.Y = i16;
        adminBadgeVisible = obj.W;
        final int i28 = 69;
        final int i29 = 67;
        int i30 = 97;
        i6 = 0;
        i9 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i16 = 0;
            obj.Y = i16;
            adminBadgeVisible = obj.W;
            i28 = 69;
            i29 = 67;
            i30 = 97;
            i6 = 0;
            i9 = 0;
        }
        if (Long.compare(i32, i16) != 0 && adminBadgeVisible != null) {
            if (adminBadgeVisible != null) {
                try {
                    dogAvatar = adminBadgeVisible.getDogAvatar();
                    dogAvatar = i6;
                    int cmp9 = Long.compare(i33, i16);
                    i11 = 8;
                    if (adminBadgeVisible != null) {
                    } else {
                    }
                    ambassadorBadgeVisible = adminBadgeVisible.isAmbassadorBadgeVisible();
                    ambassadorBadgeVisible = i9;
                }
                i2 = i9;
                if (Long.compare(i34, i16) != 0 && adminBadgeVisible != null) {
                    if (adminBadgeVisible != null) {
                        ambassadorBadgeVisible = adminBadgeVisible.getDogName();
                    } else {
                        ambassadorBadgeVisible = i6;
                    }
                } else {
                }
                if (Long.compare(i35, i16) != 0 && adminBadgeVisible != null) {
                    if (adminBadgeVisible != null) {
                        i6 = adminBadgeVisible.a();
                        i3 = adminBadgeVisible.b();
                    } else {
                        i3 = i6;
                    }
                } else {
                }
                int cmp12 = Long.compare(i36, i16);
                if (cmp12 != 0) {
                    if (adminBadgeVisible != null) {
                        premiumBadgeVisible = adminBadgeVisible.isPremiumBadgeVisible();
                    } else {
                        premiumBadgeVisible = i9;
                    }
                    if (cmp12 != 0) {
                        i = premiumBadgeVisible != 0 ? 256 : 128;
                        l |= i;
                    }
                    if (premiumBadgeVisible != 0) {
                        i4 = i9;
                    } else {
                        i4 = i11;
                    }
                } else {
                }
                premiumBadgeVisible = Long.compare(i37, i16);
                if (premiumBadgeVisible != 0) {
                    if (adminBadgeVisible != null) {
                        adminBadgeVisible = adminBadgeVisible.isAdminBadgeVisible();
                    } else {
                        adminBadgeVisible = i9;
                    }
                    if (premiumBadgeVisible != 0) {
                        premiumBadgeVisible = adminBadgeVisible != 0 ? 4096 : 2048;
                        l |= premiumBadgeVisible;
                    }
                    if (adminBadgeVisible != 0) {
                    } else {
                        i9 = i11;
                    }
                }
                i8 = i6;
                i7 = i9;
                i14 = i2;
                i12 = ambassadorBadgeVisible;
                i5 = i3;
                i13 = i4;
                if (Long.compare(i31, i16) != 0) {
                    obj.O.setVisibility(i7);
                }
                if (Long.compare(i27, i16) != 0) {
                    obj.P.setVisibility(i14);
                    obj.Q.setVisibility(i14);
                }
                if (Long.compare(i22, i16) != 0) {
                    m.o(obj.R, dogAvatar);
                }
                if (Long.compare(i24, i16) != 0) {
                    g.c(obj.S, i12);
                }
                if (Long.compare(i26, i16) != 0) {
                    g.c(obj.T, i8);
                    g.c(obj.V, i5);
                }
                if (Long.compare(i15, i16) != 0) {
                    obj.U.setVisibility(i13);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.g2
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
