package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.k0.c;

/* loaded from: classes.dex */
public class tk extends app.dogo.com.dogo_android.h.sk implements b.a {

    private static final ViewDataBinding.g u0;
    private static final SparseIntArray v0;
    private final ConstraintLayout l0;
    private final AppCompatImageView m0;
    private final TextView n0;
    private final AppCompatImageView o0;
    private final View.OnClickListener p0;
    private final View.OnClickListener q0;
    private final View.OnClickListener r0;
    private final View.OnClickListener s0;
    private long t0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(29);
        tk.u0 = gVar;
        int i11 = 1;
        final int[] iArr2 = new int[i11];
        final int i23 = 0;
        iArr2[i23] = 19;
        int[] iArr = new int[i11];
        iArr[i23] = 2131558743;
        gVar.a(i23, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        tk.v0 = sparseIntArray;
        sparseIntArray.put(2131362148, 20);
        sparseIntArray.put(2131362286, 21);
        sparseIntArray.put(2131362971, 22);
        sparseIntArray.put(2131362350, 23);
        sparseIntArray.put(2131361987, 24);
        sparseIntArray.put(2131362724, 25);
        sparseIntArray.put(2131363477, 26);
        sparseIntArray.put(2131361929, 27);
        sparseIntArray.put(2131362492, 28);
    }

    public tk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 29, tk.u0, tk.v0));
    }

    private tk(e e, View view2, Object[] object3Arr3) {
        Object obj8 = this;
        super(e, view2, 2, (ImageView)object3Arr3[9], (ImageView)object3Arr3[5], (AppCompatImageView)object3Arr3[27], (Barrier)object3Arr3[24], (RelativeLayout)object3Arr3[13], (ViewPager)object3Arr3[20], (ci)object3Arr3[19], (TextView)object3Arr3[7], (Button)object3Arr3[21], (TextView)object3Arr3[6], (ImageView)object3Arr3[4], (RelativeLayout)object3Arr3[23], (ImageView)object3Arr3[17], (FrameLayout)object3Arr3[28], (AppCompatImageView)object3Arr3[10], (FrameLayout)object3Arr3[25], (ProgressBar)object3Arr3[16], (LinearLayout)object3Arr3[2], (ConstraintLayout)object3Arr3[22], (ImageView)object3Arr3[8], (FrameLayout)object3Arr3[11], (ImageView)object3Arr3[1], (TextView)object3Arr3[15], (RelativeLayout)object3Arr3[26], (TextView)object3Arr3[3]);
        Object obj7 = this;
        obj7.t0 = -1;
        int i6 = 0;
        obj7.O.setTag(i6);
        obj7.P.setTag(i6);
        obj7.R.setTag(i6);
        obj7.L(obj7.T);
        obj7.U.setTag(i6);
        obj7.W.setTag(i6);
        obj7.X.setTag(i6);
        obj7.Y.setTag(i6);
        obj7.a0.setTag(i6);
        Object obj2 = object3Arr3[0];
        obj7.l0 = (ConstraintLayout)obj2;
        obj2.setTag(i6);
        Object obj3 = object3Arr3[12];
        obj7.m0 = (AppCompatImageView)obj3;
        obj3.setTag(i6);
        Object obj4 = object3Arr3[14];
        obj7.n0 = (TextView)obj4;
        obj4.setTag(i6);
        Object obj5 = object3Arr3[18];
        obj7.o0 = (AppCompatImageView)obj5;
        obj5.setTag(i6);
        obj7.c0.setTag(i6);
        obj7.d0.setTag(i6);
        obj7.e0.setTag(i6);
        obj7.f0.setTag(i6);
        obj7.g0.setTag(i6);
        obj7.h0.setTag(i6);
        obj7.i0.setTag(i6);
        obj7.N(view2);
        b bVar = new b(obj7, 1);
        obj7.p0 = bVar;
        b bVar2 = new b(obj7, 2);
        obj7.q0 = bVar2;
        b bVar3 = new b(obj7, 3);
        obj7.r0 = bVar3;
        b bVar4 = new b(obj7, 4);
        obj7.s0 = bVar4;
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.ci ci, int i2) {
        if (i2 == 0) {
            this.t0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.t0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean W(c c, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.t0 = l21 |= i63;
            return obj5;
            synchronized (this) {
                this.t0 = l21 |= i63;
                return obj5;
            }
        }
        if (i2 == 140) {
            this.t0 = l20 |= i62;
            return obj5;
            synchronized (this) {
                this.t0 = l20 |= i62;
                return obj5;
            }
        }
        if (i2 == 121) {
            this.t0 = l19 |= i61;
            return obj5;
            synchronized (this) {
                this.t0 = l19 |= i61;
                return obj5;
            }
        }
        if (i2 == 123) {
            this.t0 = l18 |= i60;
            return obj5;
            synchronized (this) {
                this.t0 = l18 |= i60;
                return obj5;
            }
        }
        if (i2 == 184) {
            this.t0 = l17 |= i59;
            return obj5;
            synchronized (this) {
                this.t0 = l17 |= i59;
                return obj5;
            }
        }
        if (i2 == 63) {
            this.t0 = l16 |= i58;
            return obj5;
            synchronized (this) {
                this.t0 = l16 |= i58;
                return obj5;
            }
        }
        if (i2 == 7) {
            this.t0 = l15 |= i57;
            return obj5;
            synchronized (this) {
                this.t0 = l15 |= i57;
                return obj5;
            }
        }
        try {
            if (i2 == 65) {
            }
            this.t0 = l |= i43;
            return obj5;
            throw c;
            if (i2 == 56) {
            }
            this.t0 = l2 |= i44;
            return obj5;
            throw c;
            if (i2 == 125) {
            }
            this.t0 = l3 |= i45;
            return obj5;
            throw c;
            if (i2 == 5) {
            }
            this.t0 = l4 |= i46;
            return obj5;
        } catch (Throwable th) {
        }
        if (i2 == 101) {
            this.t0 = l5 |= i47;
            return obj5;
            synchronized (this) {
                this.t0 = l5 |= i47;
                return obj5;
            }
        }
        if (i2 == 58) {
            this.t0 = l6 |= i48;
            return obj5;
            synchronized (this) {
                this.t0 = l6 |= i48;
                return obj5;
            }
        }
        if (i2 == 30) {
            this.t0 = l7 |= i49;
            return obj5;
            synchronized (this) {
                this.t0 = l7 |= i49;
                return obj5;
            }
        }
        if (i2 == 31) {
            this.t0 = l8 |= i50;
            return obj5;
            synchronized (this) {
                this.t0 = l8 |= i50;
                return obj5;
            }
        }
        if (i2 == 165) {
            this.t0 = l9 |= i51;
            return obj5;
            synchronized (this) {
                this.t0 = l9 |= i51;
                return obj5;
            }
        }
        if (i2 == 164) {
            this.t0 = l10 |= i52;
            return obj5;
            synchronized (this) {
                this.t0 = l10 |= i52;
                return obj5;
            }
        }
        if (i2 == 147) {
            this.t0 = l11 |= i53;
            return obj5;
            synchronized (this) {
                this.t0 = l11 |= i53;
                return obj5;
            }
        }
        if (i2 == 187) {
            this.t0 = l12 |= i54;
            return obj5;
            synchronized (this) {
                this.t0 = l12 |= i54;
                return obj5;
            }
        }
        if (i2 == 23) {
            this.t0 = l13 |= i55;
            return obj5;
            synchronized (this) {
                this.t0 = l13 |= i55;
                return obj5;
            }
        }
        if (i2 == 69) {
            this.t0 = l14 |= i56;
            return obj5;
            synchronized (this) {
                this.t0 = l14 |= i56;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void A() {
        this.t0 = 8388608;
        this.T.A();
        I();
        return;
        synchronized (this) {
            this.t0 = 8388608;
            this.T.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sk
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((c)object2, i3);
        }
        return V((ci)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void M(q q) {
        super.M(q);
        this.T.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (106 == i) {
            T((c)object2);
            obj2 = 1;
        } else {
            if (116 == i) {
                U((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void T(c c) {
        R(1, c);
        this.j0 = c;
        this.t0 = l |= i3;
        notifyPropertyChanged(106);
        super.I();
        return;
        synchronized (this) {
            R(1, c);
            this.j0 = c;
            this.t0 = l |= i3;
            notifyPropertyChanged(106);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void U(a0 a0) {
        this.k0 = a0;
        this.t0 = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.k0 = a0;
            this.t0 = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public final void b(int i, View view2) {
        a0 a0Var;
        c obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                    } else {
                        obj3 = this.j0;
                        if (obj3 != null) {
                            obj4 = i2;
                        }
                        if (obj4 != null) {
                            obj3.onTranslateButtonPress();
                        }
                    }
                } else {
                    obj3 = this.j0;
                    if (obj3 != null) {
                        obj4 = i2;
                    }
                    if (obj4 != null) {
                        obj3.onCaptionClick();
                    }
                }
            } else {
                obj3 = this.j0;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.onEntryAvatarClick(this.k0);
                }
            }
        } else {
            obj3 = this.j0;
            if (obj3 != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                obj3.showEntryFans(this.k0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sk
    protected void m() {
        int i11;
        c shareButtonVisible;
        long l;
        int cmp11;
        int i26;
        int cmp9;
        int cmp18;
        int cmp17;
        int cmp8;
        int cmp10;
        int cmp19;
        int cmp21;
        int cmp;
        int cmp16;
        int cmp14;
        int cmp5;
        int cmp6;
        int cmp20;
        int cmp2;
        int cmp3;
        int cmp15;
        int cmp12;
        int i3;
        int valueOf;
        int i27;
        int i19;
        int valueOf2;
        int i5;
        int i2;
        int i20;
        int i16;
        int i;
        int i34;
        int i23;
        int string;
        int i24;
        int cmp7;
        int cmp4;
        int i7;
        int i12;
        int i37;
        int featured;
        int i21;
        int i14;
        int adminBadgeVisible;
        int voteCount;
        int i10;
        int i4;
        int i25;
        int translationButtonString;
        int i35;
        int premiumBadgeVisible;
        int i22;
        int winner;
        int ambassadorBadgeVisible;
        int i13;
        int i31;
        int dogName;
        int i32;
        long dogAvatar;
        int currentUserEntriesAuthor;
        int i15;
        int showReportDeleteButton;
        int pagePosition;
        int caption;
        int captionExapanded;
        int cmp13;
        int likeState;
        long l2;
        int i33;
        int borderVisible;
        int translateButtonVisible;
        long l3;
        int i18;
        int i28;
        int i29;
        int i8;
        int i36;
        int i30;
        int i6;
        int i9;
        int i17;
        int i38;
        final Object obj = this;
        l = obj.t0;
        final int i40 = 0;
        obj.t0 = i40;
        shareButtonVisible = obj.j0;
        final int i73 = 10485762;
        final int i74 = 8404994;
        final int i75 = 8388738;
        final int i76 = 9437186;
        final int i77 = 8421378;
        final int i78 = 8389634;
        final int i79 = 8390658;
        final int i80 = 8388866;
        final int i81 = 8519682;
        int i82 = 8392706;
        final int i84 = 8912898;
        int i85 = 8389122;
        i10 = 0;
        i4 = 0;
        synchronized (this) {
            obj = this;
            l = obj.t0;
            i40 = 0;
            obj.t0 = i40;
            shareButtonVisible = obj.j0;
            i73 = 10485762;
            i74 = 8404994;
            i75 = 8388738;
            i76 = 9437186;
            i77 = 8421378;
            i78 = 8389634;
            i79 = 8390658;
            i80 = 8388866;
            i81 = 8519682;
            i82 = 8392706;
            i84 = 8912898;
            i85 = 8389122;
            i10 = 0;
            i4 = 0;
        }
        int cmp23 = Long.compare(i87, i40);
        i25 = 8;
        if (cmp23 != 0) {
            if (shareButtonVisible != null) {
                try {
                    translationButtonString = shareButtonVisible.isSpinnerVisible();
                    translationButtonString = i4;
                    if (cmp23 != 0) {
                    }
                    if (translationButtonString != null) {
                    } else {
                    }
                    i35 = 2199023255552L;
                    i35 = 1099511627776L;
                    l |= i35;
                }
                if (translationButtonString != null) {
                    i3 = i4;
                } else {
                    i3 = i25;
                }
            } else {
            }
        } else {
        }
        if (Long.compare(i88, i40) != 0 && shareButtonVisible != null) {
            if (shareButtonVisible != null) {
                translationButtonString = shareButtonVisible.getTranslationButtonString();
            } else {
                translationButtonString = i10;
            }
        } else {
        }
        int cmp29 = Long.compare(i89, i40);
        if (cmp29 != 0) {
            if (shareButtonVisible != null) {
                premiumBadgeVisible = shareButtonVisible.isPremiumBadgeVisible();
            } else {
                premiumBadgeVisible = i4;
            }
            if (cmp29 != 0) {
                i22 = premiumBadgeVisible != 0 ? 536870912 : 268435456;
                l |= i22;
            }
            if (premiumBadgeVisible != 0) {
                i35 = i4;
            } else {
                i35 = i25;
            }
        } else {
        }
        if (Long.compare(i90, i40) != 0 && shareButtonVisible != null) {
            if (shareButtonVisible != null) {
                premiumBadgeVisible = shareButtonVisible.getCreationDate();
            } else {
                premiumBadgeVisible = i10;
            }
        } else {
        }
        int cmp31 = Long.compare(i91, i40);
        if (cmp31 != 0) {
            if (shareButtonVisible != null) {
                ambassadorBadgeVisible = shareButtonVisible.isAmbassadorBadgeVisible();
            } else {
                ambassadorBadgeVisible = i4;
            }
            if (cmp31 != 0) {
                i13 = ambassadorBadgeVisible != 0 ? 134217728 : 67108864;
                l |= i13;
            }
            if (ambassadorBadgeVisible != 0) {
                i22 = i4;
            } else {
                i22 = i25;
            }
        } else {
        }
        int cmp32 = Long.compare(i92, i40);
        if (cmp32 != 0) {
            if (shareButtonVisible != null) {
                dogName = shareButtonVisible.getDogName();
            } else {
                dogName = i10;
            }
            i32 = dogName != null ? i31 : i4;
            if (cmp32 != 0) {
                dogAvatar = i32 != 0 ? 8796093022208L : 4398046511104L;
                l |= dogAvatar;
            }
        } else {
            dogName = i10;
            i32 = i4;
        }
        if (Long.compare(i93, i40) != 0 && shareButtonVisible != null) {
            if (shareButtonVisible != null) {
                winner = shareButtonVisible.isWinner();
            } else {
                winner = i4;
            }
        } else {
        }
        if (Long.compare(i94, i40) != 0 && shareButtonVisible != null) {
            if (shareButtonVisible != null) {
                dogAvatar = shareButtonVisible.getDogAvatar();
            } else {
                dogAvatar = i10;
            }
        } else {
        }
        if (Long.compare(i95, i40) != 0 && shareButtonVisible != null) {
            if (shareButtonVisible != null) {
                currentUserEntriesAuthor = shareButtonVisible.isCurrentUserEntriesAuthor();
            } else {
                currentUserEntriesAuthor = i4;
            }
        } else {
        }
        int cmp36 = Long.compare(i96, i40);
        if (cmp36 != 0) {
            if (shareButtonVisible != null) {
                showReportDeleteButton = shareButtonVisible.showReportDeleteButton();
            } else {
                showReportDeleteButton = i4;
            }
            if (cmp36 != 0) {
                pagePosition = showReportDeleteButton ? 137438953472L : 68719476736L;
                l |= pagePosition;
            }
            if (showReportDeleteButton) {
                i15 = i4;
            } else {
                i15 = i25;
            }
        } else {
        }
        if (Long.compare(i97, i40) != 0 && shareButtonVisible != null) {
            if (shareButtonVisible != null) {
                showReportDeleteButton = shareButtonVisible.getPhotoCount();
                pagePosition = shareButtonVisible.getPagePosition();
            } else {
                pagePosition = showReportDeleteButton;
            }
        } else {
        }
        if (Long.compare(i98, i40) != 0) {
            if (shareButtonVisible != null) {
                caption = shareButtonVisible.getCaption();
                captionExapanded = shareButtonVisible.isCaptionExapanded();
            } else {
                caption = i10;
                captionExapanded = i4;
            }
            cmp13 = Long.compare(i99, i40);
            if (cmp13 != 0) {
                if (caption != 0) {
                } else {
                    i31 = i4;
                }
                if (cmp13 != 0) {
                    cmp13 = i31 != 0 ? 35184372088832L : 17592186044416L;
                    l |= cmp13;
                }
                if (i31 != 0) {
                    i13 = i4;
                } else {
                    i13 = i25;
                }
            } else {
            }
        } else {
            caption = i10;
            captionExapanded = i13;
        }
        int cmp39 = Long.compare(i100, i40);
        if (cmp39 != 0) {
            if (shareButtonVisible != null) {
                likeState = shareButtonVisible.getLikeState();
            } else {
                likeState = i4;
            }
            if (cmp39 != 0) {
                l2 = likeState != 0 ? 34359738368L : 17179869184L;
                l |= l2;
            }
            if (likeState != 0) {
                i16 = ViewDataBinding.u(obj.a0, 2131100352);
            } else {
                i16 = ViewDataBinding.u(obj.a0, 2131099847);
            }
        } else {
            likeState = i16;
        }
        int cmp24 = Long.compare(i21, i40);
        if (cmp24 != 0) {
            if (shareButtonVisible != null) {
                featured = shareButtonVisible.isFeatured();
            } else {
                featured = i4;
            }
            if (cmp24 != 0) {
                i33 = featured != 0 ? 33554432 : 0x01000000 /* Unknown resource */;
                l |= i33;
            }
            i21 = featured != 0 ? R.color.primary : R.color.lightestGray;
            i23 = ViewDataBinding.u(obj.o0, i21);
        } else {
            i23 = i4;
        }
        int cmp25 = Long.compare(i72, i40);
        if (cmp25 != 0) {
            if (shareButtonVisible != null) {
                adminBadgeVisible = shareButtonVisible.isAdminBadgeVisible();
            } else {
                adminBadgeVisible = i4;
            }
            if (cmp25 != 0) {
                i33 = adminBadgeVisible != 0 ? 2147483648L : 1073741824;
                l |= i33;
            }
            if (adminBadgeVisible != 0) {
                i12 = i4;
            } else {
                i12 = i25;
            }
        } else {
        }
        if (Long.compare(i102, i40) != 0 && shareButtonVisible != null) {
            if (shareButtonVisible != null) {
                voteCount = shareButtonVisible.getVoteCount();
            } else {
                voteCount = i10;
            }
        } else {
        }
        int cmp40 = Long.compare(borderVisible, i40);
        if (cmp40 != 0) {
            if (shareButtonVisible != null) {
                borderVisible = shareButtonVisible.isBorderVisible();
            } else {
                borderVisible = i4;
            }
            if (cmp40 != 0) {
                translateButtonVisible = borderVisible != 0 ? 140737488355328L : 70368744177664L;
                l |= translateButtonVisible;
            }
            if (borderVisible != 0) {
                cmp13 = i4;
            } else {
                cmp13 = i25;
            }
        } else {
        }
        int cmp41 = Long.compare(i104, i40);
        if (cmp41 != 0) {
            if (shareButtonVisible != null) {
                translateButtonVisible = shareButtonVisible.isTranslateButtonVisible();
            } else {
                translateButtonVisible = i4;
            }
            if (cmp41 != 0) {
                l3 = translateButtonVisible != 0 ? 549755813888L : 274877906944L;
                l |= l3;
            }
            if (translateButtonVisible != 0) {
                i33 = i4;
            } else {
                i33 = i25;
            }
        } else {
        }
        translateButtonVisible = Long.compare(i106, i40);
        if (translateButtonVisible != 0) {
            if (shareButtonVisible != null) {
                shareButtonVisible = shareButtonVisible.isShareButtonVisible();
            } else {
                shareButtonVisible = i4;
            }
            if (translateButtonVisible != 0) {
                translateButtonVisible = shareButtonVisible != 0 ? 8589934592L : 4294967296L;
                l |= translateButtonVisible;
            }
            if (shareButtonVisible != 0) {
            } else {
                i4 = i25;
            }
        }
        i28 = i3;
        i27 = i16;
        i11 = voteCount;
        i6 = i4;
        i17 = translationButtonString;
        i36 = i35;
        i19 = premiumBadgeVisible;
        i26 = i22;
        i20 = i13;
        i4 = i32;
        i2 = dogAvatar;
        i30 = i15;
        i8 = showReportDeleteButton;
        i29 = pagePosition;
        i38 = caption;
        i18 = captionExapanded;
        valueOf = likeState;
        i9 = i33;
        i14 = i23;
        i = cmp13;
        int cmp27 = Long.compare(i86, i40);
        if (cmp27 != 0) {
            if (i4 != 0) {
                i10 = dogName;
            } else {
                i10 = string;
            }
        }
        if (Long.compare(i83, i40) != 0) {
            obj.O.setVisibility(i12);
        }
        if (Long.compare(i68, i40) != 0) {
            obj.P.setVisibility(i26);
        }
        if (Long.compare(i7, i40) != 0) {
            obj.R.setOnClickListener(obj.r0);
            obj.X.setOnClickListener(obj.q0);
            obj.h0.setOnClickListener(obj.s0);
            obj.i0.setOnClickListener(obj.p0);
        }
        if (Long.compare(i70, i40) != 0) {
            obj.R.setVisibility(i20);
        }
        if (Long.compare(i71, i40) != 0) {
            g.c(obj.U, i19);
        }
        if (cmp27 != 0) {
            g.c(obj.W, i10);
        }
        if (Long.compare(i67, i40) != 0) {
            m.o(obj.X, i2);
        }
        if (Long.compare(valueOf2, i40) != 0) {
            n.G(obj.Y, Boolean.valueOf(winner));
        }
        if (Long.compare(i62, i40) != 0) {
            obj.Y.setVisibility(i);
        }
        if (Long.compare(i5, i40) != 0) {
            obj.a0.setEnabled(valueOf);
            n.i0(obj.a0, Integer.valueOf(i27));
        }
        if (Long.compare(i43, i40) != 0) {
            n.F(obj.m0, Boolean.valueOf(currentUserEntriesAuthor));
        }
        if (Long.compare(i45, i40) != 0) {
            m.b(obj.n0, i38, i18);
        }
        if (Long.compare(i47, i40) != 0) {
            n.i0(obj.o0, Integer.valueOf(i14));
        }
        if (Long.compare(i48, i40) != 0) {
            obj.c0.setVisibility(i28);
        }
        if (Long.compare(i50, i40) != 0) {
            m.j(obj.d0, i29, i8, 10);
        }
        if (Long.compare(i51, i40) != 0) {
            obj.e0.setVisibility(i36);
        }
        if (Long.compare(i53, i40) != 0) {
            obj.f0.setVisibility(i30);
        }
        if (Long.compare(i55, i40) != 0) {
            obj.g0.setVisibility(i6);
        }
        if (Long.compare(i56, i40) != 0) {
            g.c(obj.h0, i17);
        }
        if (Long.compare(i58, i40) != 0) {
            obj.h0.setVisibility(i9);
        }
        if (Long.compare(i39, i40) != 0) {
            g.c(obj.i0, i11);
        }
        ViewDataBinding.o(obj.T);
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.T.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
