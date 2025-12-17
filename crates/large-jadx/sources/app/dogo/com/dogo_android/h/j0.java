package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.d.b.z.j;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.k0.c;

/* loaded from: classes.dex */
public class j0 extends app.dogo.com.dogo_android.h.i0 implements b.a {

    private static final ViewDataBinding.g j0;
    private static final SparseIntArray k0;
    private final ConstraintLayout g0;
    private final View.OnClickListener h0;
    private long i0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j0.k0 = sparseIntArray;
        sparseIntArray.put(2131362404, 14);
        sparseIntArray.put(2131362724, 15);
        sparseIntArray.put(2131361915, 16);
        sparseIntArray.put(2131362635, 17);
        sparseIntArray.put(2131361929, 18);
    }

    public j0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 19, j0.j0, j0.k0));
    }

    private j0(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 2, (ImageView)object3Arr3[6], (View)object3Arr3[16], (ImageView)object3Arr3[18], (TextView)object3Arr3[8], (TextView)object3Arr3[1], (ImageView)object3Arr3[13], (ViewPager)object3Arr3[14], (AppCompatImageView)object3Arr3[3], (ImageView)object3Arr3[17], (FrameLayout)object3Arr3[15], (ProgressBar)object3Arr3[12], (LinearLayout)object3Arr3[9], (ImageView)object3Arr3[7], (ImageView)object3Arr3[5], (FrameLayout)object3Arr3[4], (TextView)object3Arr3[11], (RelativeLayout)object3Arr3[10], (TextView)object3Arr3[2]);
        Object obj4 = this;
        obj4.i0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.S.setTag(i3);
        obj4.U.setTag(i3);
        Object obj2 = object3Arr3[0];
        obj4.g0 = (ConstraintLayout)obj2;
        obj2.setTag(i3);
        obj4.W.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Y.setTag(i3);
        obj4.Z.setTag(i3);
        obj4.a0.setTag(i3);
        obj4.b0.setTag(i3);
        obj4.c0.setTag(i3);
        obj4.d0.setTag(i3);
        obj4.N(view2);
        b bVar = new b(obj4, 1);
        obj4.h0 = bVar;
        A();
    }

    private boolean X(c c, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.i0 = l3 |= i9;
            return obj5;
            synchronized (this) {
                this.i0 = l3 |= i9;
                return obj5;
            }
        }
        if (i2 == 121) {
            this.i0 = l2 |= i8;
            return obj5;
            synchronized (this) {
                this.i0 = l2 |= i8;
                return obj5;
            }
        }
        if (i2 == 123) {
            this.i0 = l |= i7;
            return obj5;
            synchronized (this) {
                this.i0 = l |= i7;
                return obj5;
            }
        }
        return 0;
    }

    private boolean Y(j j, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.i0 = l13 |= i39;
            return obj5;
            synchronized (this) {
                this.i0 = l13 |= i39;
                return obj5;
            }
        }
        if (i2 == 36) {
            this.i0 = l12 |= i38;
            return obj5;
            synchronized (this) {
                this.i0 = l12 |= i38;
                return obj5;
            }
        }
        if (i2 == 184) {
            this.i0 = l11 |= i37;
            return obj5;
            synchronized (this) {
                this.i0 = l11 |= i37;
                return obj5;
            }
        }
        if (i2 == 101) {
            this.i0 = l10 |= i36;
            return obj5;
            synchronized (this) {
                this.i0 = l10 |= i36;
                return obj5;
            }
        }
        if (i2 == 133) {
            this.i0 = l9 |= i35;
            return obj5;
            synchronized (this) {
                this.i0 = l9 |= i35;
                return obj5;
            }
        }
        if (i2 == 63) {
            this.i0 = l8 |= i34;
            return obj5;
            synchronized (this) {
                this.i0 = l8 |= i34;
                return obj5;
            }
        }
        if (i2 == 32) {
            this.i0 = l7 |= i33;
            return obj5;
            synchronized (this) {
                this.i0 = l7 |= i33;
                return obj5;
            }
        }
        try {
            if (i2 == 7) {
            }
            this.i0 = l |= i27;
            return obj5;
            throw j;
            if (i2 == 73) {
            }
            this.i0 = l2 |= i28;
            return obj5;
            throw j;
            if (i2 == 165) {
            }
            this.i0 = l3 |= i29;
            return obj5;
            throw j;
            if (i2 == 164) {
            }
            this.i0 = l6 |= i32;
            return obj5;
        } catch (Throwable th) {
        }
        if (i2 == 147) {
            this.i0 = l5 |= i31;
            return obj5;
            synchronized (this) {
                this.i0 = l5 |= i31;
                return obj5;
            }
        }
        if (i2 == 23) {
            this.i0 = l4 |= i30;
            return obj5;
            synchronized (this) {
                this.i0 = l4 |= i30;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public void A() {
        this.i0 = 65536;
        I();
        return;
        synchronized (this) {
            this.i0 = 65536;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i0
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((c)object2, i3);
        }
        return Y((j)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((j)object2);
            obj2 = 1;
        } else {
            if (106 == i) {
                V((c)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public void V(c c) {
        R(1, c);
        this.f0 = c;
        this.i0 = l |= i3;
        notifyPropertyChanged(106);
        super.I();
        return;
        synchronized (this) {
            R(1, c);
            this.f0 = c;
            this.i0 = l |= i3;
            notifyPropertyChanged(106);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public void W(j j) {
        R(0, j);
        this.e0 = j;
        this.i0 = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, j);
            this.e0 = j;
            this.i0 = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public final void b(int i, View view2) {
        int obj2;
        final j obj1 = this.e0;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.onTranslateButtonPress();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i0
    protected void m() {
        j cmp6;
        int i35;
        int cmp11;
        int cmp;
        int cmp14;
        int cmp2;
        int cmp10;
        int cmp16;
        int cmp12;
        int cmp4;
        int cmp17;
        int cmp8;
        int cmp13;
        int cmp7;
        int cmp3;
        long l;
        int i;
        int i13;
        int i10;
        int i14;
        int i7;
        int i27;
        int i5;
        int i31;
        int pagePosition;
        int i3;
        int i19;
        int i9;
        int i16;
        int i20;
        int i8;
        int i29;
        int i37;
        int i30;
        int i32;
        int i4;
        int i36;
        int cmp5;
        int i25;
        int i6;
        int i15;
        int voteCount;
        int i17;
        int dogAvatar;
        int i21;
        int translationButtonString;
        int i33;
        int borderVisible;
        int i34;
        int premiumBadgeVisible;
        int i22;
        int cmp15;
        int likeState;
        int i26;
        int i28;
        int photoCount;
        int cmp9;
        int i12;
        int translateButtonVisible;
        int spinnerVisible;
        int ambassadorBadgeVisible;
        long l2;
        int i2;
        int i11;
        int i18;
        int i24;
        int i23;
        final Object obj = this;
        l = obj.i0;
        i13 = 0;
        obj.i0 = i13;
        cmp6 = obj.e0;
        c cVar = obj.f0;
        final int i57 = 65553;
        int i58 = 16777216;
        final int i63 = 8388608;
        final int i64 = 73729;
        final int i65 = 66561;
        final int i66 = 65541;
        final int i67 = 65601;
        final int i68 = 66049;
        final int i69 = 65921;
        final int i70 = 65665;
        voteCount = 0;
        i17 = 8;
        final int i71 = 0;
        synchronized (this) {
            obj = this;
            l = obj.i0;
            i13 = 0;
            obj.i0 = i13;
            cmp6 = obj.e0;
            cVar = obj.f0;
            i57 = 65553;
            i58 = 16777216;
            i63 = 8388608;
            i64 = 73729;
            i65 = 66561;
            i66 = 65541;
            i67 = 65601;
            i68 = 66049;
            i69 = 65921;
            i70 = 65665;
            voteCount = 0;
            i17 = 8;
            i71 = 0;
        }
        if (Long.compare(i72, i13) != 0 && cmp6 != null) {
            if (cmp6 != null) {
                try {
                    i3 = cmp6.j();
                    i3 = voteCount;
                    if (Long.compare(i73, i13) != 0 && cmp6 != null) {
                    } else {
                    }
                    if (cmp6 != null) {
                    } else {
                    }
                    dogAvatar = cmp6.getDogAvatar();
                    dogAvatar = voteCount;
                }
                if (cmp6 != null) {
                    i21 = cmp6.g();
                } else {
                    i21 = voteCount;
                }
                if (Long.compare(i75, i13) != 0 && cmp6 != null) {
                    if (cmp6 != null) {
                        translationButtonString = cmp6.getTranslationButtonString();
                    } else {
                        translationButtonString = voteCount;
                    }
                } else {
                }
                int cmp26 = Long.compare(i76, i13);
                if (cmp26 != 0) {
                    if (cmp6 != null) {
                        borderVisible = cmp6.isBorderVisible();
                    } else {
                        borderVisible = i71;
                    }
                    if (cmp26 != 0) {
                        i34 = borderVisible != 0 ? 67108864 : 33554432;
                        l |= i34;
                    }
                    if (borderVisible != 0) {
                        i33 = i71;
                    } else {
                        i33 = i17;
                    }
                } else {
                }
                int cmp27 = Long.compare(i77, i13);
                if (cmp27 != 0) {
                    if (cmp6 != null) {
                        i34 = cmp6.k();
                        premiumBadgeVisible = cmp6.isPremiumBadgeVisible();
                    } else {
                        premiumBadgeVisible = i34;
                    }
                    if (cmp27 != 0) {
                        l = i34 != 0 ? l | i58 : l | i63;
                    }
                    if (Long.compare(i22, i13) != 0) {
                        i22 = premiumBadgeVisible != 0 ? 17179869184L : 8589934592L;
                        l |= i22;
                    }
                    borderVisible = i34 != 0 ? i71 : i17;
                } else {
                    premiumBadgeVisible = i34;
                }
                cmp15 = Long.compare(i79, i13);
                if (cmp15 != 0) {
                    if (cmp6 != null) {
                        likeState = cmp6.getLikeState();
                    } else {
                        likeState = i71;
                    }
                    if (cmp15 != 0) {
                        i26 = likeState != 0 ? 262144 : 131072;
                        l |= i26;
                    }
                    i16 = likeState != 0 ? R.color.secondary : R.color.icon_gray;
                    i19 = ViewDataBinding.u(obj.U, i16);
                } else {
                    likeState = i19;
                }
                int cmp21 = Long.compare(i12, i13);
                if (cmp21 != 0) {
                    if (cmp6 != null) {
                        cmp15 = cmp6.l();
                    } else {
                        cmp15 = i71;
                    }
                    if (cmp21 != 0) {
                        i12 = cmp15 != 0 ? 1073741824 : 536870912;
                        l |= i12;
                    }
                    if (cmp15 != 0) {
                        i9 = i71;
                    } else {
                        i9 = i17;
                    }
                } else {
                }
                if (Long.compare(i82, i13) != 0 && cmp6 != null) {
                    if (cmp6 != null) {
                        voteCount = cmp6.getVoteCount();
                    }
                }
                int cmp30 = Long.compare(translateButtonVisible, i13);
                if (cmp30 != 0) {
                    if (cmp6 != null) {
                        translateButtonVisible = cmp6.isTranslateButtonVisible();
                    } else {
                        translateButtonVisible = i71;
                    }
                    if (cmp30 != 0) {
                        spinnerVisible = translateButtonVisible != 0 ? 268435456 : 134217728;
                        l |= spinnerVisible;
                    }
                    if (translateButtonVisible != 0) {
                        i22 = i71;
                    } else {
                        i22 = i17;
                    }
                } else {
                }
                int cmp31 = Long.compare(i83, i13);
                if (cmp31 != 0) {
                    if (cmp6 != null) {
                        spinnerVisible = cmp6.isSpinnerVisible();
                    } else {
                        spinnerVisible = i71;
                    }
                    if (cmp31 != 0) {
                        l2 = spinnerVisible != 0 ? 4294967296L : 2147483648L;
                        l |= l2;
                    }
                    if (spinnerVisible != 0) {
                        i28 = i71;
                    } else {
                        i28 = i17;
                    }
                } else {
                }
                spinnerVisible = Long.compare(i84, i13);
                if (spinnerVisible != 0) {
                    if (cmp6 != null) {
                        ambassadorBadgeVisible = cmp6.isAmbassadorBadgeVisible();
                    } else {
                        ambassadorBadgeVisible = i71;
                    }
                    if (spinnerVisible != 0) {
                        i2 = ambassadorBadgeVisible != 0 ? 1048576 : 524288;
                        l |= i2;
                    }
                    i8 = voteCount;
                } else {
                    i8 = voteCount;
                    ambassadorBadgeVisible = i71;
                }
                i30 = dogAvatar;
                i37 = i21;
                i20 = translationButtonString;
                i32 = i33;
                i4 = borderVisible;
                i15 = i34;
                i11 = i22;
                i18 = likeState;
                i24 = i28;
                int i78 = 114690;
                if (Long.compare(i80, i13) != 0 && cVar != null) {
                    if (cVar != null) {
                        pagePosition = cVar.getPagePosition();
                        i23 = photoCount;
                    } else {
                        i23 = pagePosition;
                    }
                } else {
                }
                if (Long.compare(i81, i13) != 0 && cmp6 != null) {
                    if (cmp6 != null) {
                        i15 = cmp6.k();
                    }
                    if (Long.compare(cmp9, i13) != 0) {
                        l = i15 != 0 ? l | i58 : l | i63;
                    }
                }
                int cmp18 = Long.compare(i36, i13);
                if (cmp18 != 0) {
                    i36 = ambassadorBadgeVisible != 0 ? i15 : i71;
                    if (cmp18 != 0) {
                        i6 = i36 != 0 ? 4194304 : 2097152;
                        l |= i6;
                    }
                    if (i36 != 0) {
                        i35 = i71;
                    } else {
                        i35 = i17;
                    }
                } else {
                }
                cmp5 = Long.compare(i59, i13);
                if (cmp5 != 0) {
                    if (premiumBadgeVisible != 0) {
                    } else {
                        i15 = i71;
                    }
                    if (cmp5 != 0) {
                        cmp5 = i15 != 0 ? 68719476736L : 34359738368L;
                        l |= cmp5;
                    }
                    if (i15 != 0) {
                        i17 = i71;
                    }
                    i25 = i8;
                    i29 = i17;
                } else {
                    i25 = i8;
                    i29 = i71;
                }
                if (Long.compare(i60, i13) != 0) {
                    obj.O.setVisibility(i35);
                }
                int i61 = 0;
                if (Long.compare(i38, i61) != 0) {
                    g.c(obj.Q, i3);
                }
                if (Long.compare(i39, i61) != 0) {
                    obj.Q.setVisibility(i4);
                    obj.Y.setVisibility(i29);
                    obj.Z.setVisibility(i4);
                    obj.c0.setVisibility(i4);
                }
                int i62 = 0;
                if (Long.compare(i40, i62) != 0) {
                    g.c(obj.R, i37);
                }
                if (Long.compare(i41, i62) != 0) {
                    obj.S.setVisibility(i32);
                }
                obj.U.setEnabled(i18);
                if (Long.compare(i10, i62) != 0 && ViewDataBinding.t() >= 21) {
                    obj.U.setEnabled(i18);
                    if (ViewDataBinding.t() >= 21) {
                        obj.U.setImageTintList(b.a(i19));
                    }
                }
                int i53 = 0;
                if (Long.compare(i14, i53) != 0) {
                    obj.W.setVisibility(i24);
                }
                if (Long.compare(i7, i53) != 0) {
                    m.j(obj.X, pagePosition, i23, 10);
                }
                if (Long.compare(i43, i53) != 0) {
                    m.o(obj.Z, i30);
                }
                if (Long.compare(i45, i53) != 0) {
                    obj.a0.setVisibility(i9);
                }
                if (Long.compare(i46, i53) != 0) {
                    g.c(obj.b0, i20);
                }
                if (Long.compare(i27, i53) != 0) {
                    obj.b0.setVisibility(i11);
                }
                if (Long.compare(i5, i53) != 0) {
                    obj.b0.setOnClickListener(obj.h0);
                }
                if (Long.compare(i, i53) != 0) {
                    g.c(obj.d0, i25);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.i0
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
