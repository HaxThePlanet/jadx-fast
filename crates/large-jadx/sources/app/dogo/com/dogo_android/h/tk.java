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

/* compiled from: LayoutEntryBaseBindingImpl.java */
/* loaded from: classes.dex */
public class tk extends sk implements b.a {

    private static final ViewDataBinding.g u0 = new ViewDataBinding$g(29);
    private static final SparseIntArray v0 = new SparseIntArray();
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
        int i11 = 1;
        final int[] iArr2 = new int[i11];
        final int i23 = 0;
        iArr2[i23] = 19;
        int[] iArr = new int[i11];
        iArr[i23] = R.layout.layout_comment_input;
        obj.a(i23, new String[] { "layout_comment_input" }, iArr2, iArr);
        obj.put(2131362148, 20);
        obj.put(2131362286, 21);
        obj.put(2131362971, 22);
        obj.put(2131362350, 23);
        obj.put(2131361987, 24);
        obj.put(2131362724, 25);
        obj.put(2131363477, 26);
        obj.put(2131361929, 27);
        obj.put(2131362492, 28);
    }

    public tk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 29, tk.u0, tk.v0));
    }

    private boolean V(ci ciVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.t0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(c cVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.t0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 140) {
            synchronized (this) {
                try {
                    this.t0 |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 121) {
            synchronized (this) {
                try {
                    this.t0 |= 16;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 123) {
            synchronized (this) {
                try {
                    this.t0 |= 32;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 184) {
            synchronized (this) {
                try {
                    this.t0 |= 64;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 63) {
            synchronized (this) {
                try {
                    this.t0 |= 128;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 7) {
            synchronized (this) {
                try {
                    this.t0 |= 256;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 65) {
            synchronized (this) {
                try {
                    this.t0 |= 512;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 56) {
            synchronized (this) {
                try {
                    this.t0 |= 1024;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 125) {
            synchronized (this) {
                try {
                    this.t0 |= 2048;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 5) {
            synchronized (this) {
                try {
                    this.t0 |= 4096;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 101) {
            synchronized (this) {
                try {
                    this.t0 |= 8192;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 58) {
            synchronized (this) {
                try {
                    this.t0 |= 16384;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 30) {
            synchronized (this) {
                try {
                    this.t0 |= 32768;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 31) {
            synchronized (this) {
                try {
                    this.t0 |= 65536;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 165) {
            synchronized (this) {
                try {
                    this.t0 |= 131072;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 164) {
            synchronized (this) {
                try {
                    this.t0 |= 262144;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 147) {
            synchronized (this) {
                try {
                    this.t0 |= 524288;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 187) {
            synchronized (this) {
                try {
                    this.t0 |= 1048576;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 23) {
            synchronized (this) {
                try {
                    this.t0 |= 2097152;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 69) {
            synchronized (this) {
                try {
                    this.t0 |= 4194304;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void A() {
        synchronized (this) {
            try {
                this.t0 = 8388608L;
            } catch (Throwable th) {
            }
        }
        this.T.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sk
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void M(q qVar) {
        super.M(qVar);
        this.T.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public boolean O(int i, Object object) {
        int i2 = 106;
        boolean z = true;
        i2 = 106;
        if (106 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void T(c cVar) {
        R(1, cVar);
        this.j0 = cVar;
        synchronized (this) {
            try {
                this.t0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(106);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public void U(a0 a0Var) {
        this.k0 = a0Var;
        synchronized (this) {
            try {
                this.t0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.j0 != null) {
            }
            if (i2 != 0) {
                this.j0.showEntryFans(this.k0);
            }
        } else {
            if (this.j0 == 2) {
                if (this.j0 != null) {
                }
                if (i2 != 0) {
                    this.j0.onEntryAvatarClick(this.k0);
                }
            } else {
                if (this.j0 == 3) {
                    if (this.j0 != null) {
                    }
                    if (i2 != 0) {
                        this.j0.onCaptionClick();
                    }
                } else {
                    if (this.j0 == 4) {
                        if (this.j0 != null) {
                        }
                        if (i2 != 0) {
                            this.j0.onTranslateButtonPress();
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sk
    protected void m() {
        Object obj;
        int pagePosition;
        long l;
        int cmp4;
        boolean z;
        java.lang.CharSequence charSequence2;
        String str4;
        boolean featured;
        int i4 = 2131099860;
        String voteCount;
        int i = 0;
        long l7;
        int i5 = 268435456;
        boolean z3;
        int i6;
        long l8 = 4398046511104L;
        boolean z4;
        long l9;
        int cmp21;
        long l10 = 17592186044416L;
        long l11;
        int i7;
        long l12;
        long l13;
        int cmp22;
        long l14 = 4294967296L;
        long l15;
        final Object obj2 = this;
        synchronized (this) {
            try {
                final long l17 = 0L;
                obj2.t0 = l17;
            } catch (Throwable th) {
            }
        }
        long l18 = 16777210L & l;
        long l4 = 8396802L;
        long l6 = 8388610L;
        final long l36 = 10485762L;
        final long l37 = 8404994L;
        final long l38 = 8388738L;
        final long l39 = 9437186L;
        final long l40 = 8421378L;
        final long l41 = 8389634L;
        final long l42 = 8390658L;
        final long l43 = 8388866L;
        final long l44 = 8519682L;
        long l45 = 8392706L;
        final long l47 = 8912898L;
        long l48 = 8389122L;
        i = 0;
        pagePosition = 0;
        if (l18 != l17) {
            long l50 = l & 8912898L;
            pagePosition = 8;
            if (l50 != l17) {
                if (obj2.j0 != null) {
                    boolean spinnerVisible = obj2.j0.isSpinnerVisible();
                } else {
                }
                if (l50 != l17) {
                    int r45 = pagePosition != 0 ? 2199023255552L : 1099511627776L;
                    l = l | (pagePosition != 0 ? 2199023255552L : 1099511627776L);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l51 = l & 8519682L;
            if (l51 == l17 || obj2.j0 == null) {
            } else {
                String translationButtonString = obj2.j0.getTranslationButtonString();
            }
            long l52 = l & 8390658L;
            if (l52 != l17) {
                if (obj2.j0 != null) {
                    boolean premiumBadgeVisible = obj2.j0.isPremiumBadgeVisible();
                } else {
                }
                if (l52 != l17) {
                    int r47 = pagePosition != 0 ? 536870912 : 268435456;
                    l = l | (pagePosition != 0 ? 536870912 : 268435456);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l53 = l & 8389634L;
            if (l53 == l17 || obj2.j0 == null) {
            } else {
                String creationDate = obj2.j0.getCreationDate();
            }
            long l54 = l & 8388866L;
            if (l54 != l17) {
                if (obj2.j0 != null) {
                    boolean ambassadorBadgeVisible = obj2.j0.isAmbassadorBadgeVisible();
                } else {
                }
                if (l54 != l17) {
                    int r49 = pagePosition != 0 ? 134217728 : 67108864;
                    l = l | (pagePosition != 0 ? 134217728 : 67108864);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l55 = l & 8389122L;
            pagePosition = 1;
            if (l55 != l17) {
                if (obj2.j0 != null) {
                    String dogName = obj2.j0.getDogName();
                } else {
                }
                int r51 = i != 0 ? 1 : pagePosition;
                if (l55 != l17) {
                    int r52 = pagePosition != 0 ? 8796093022208L : 4398046511104L;
                    l = l | (pagePosition != 0 ? 8796093022208L : 4398046511104L);
                }
            } else {
            }
            long l56 = l & 9437186L;
            if (l56 == l17 || obj2.j0 == null) {
            } else {
                boolean winner = obj2.j0.isWinner();
            }
            long l57 = l & 8388738L;
            if (l57 == l17 || obj2.j0 == null) {
            } else {
                String dogAvatar = obj2.j0.getDogAvatar();
            }
            long l58 = l & 8404994L;
            if (l58 == l17 || obj2.j0 == null) {
            } else {
                boolean currentUserEntriesAuthor = obj2.j0.isCurrentUserEntriesAuthor();
            }
            long l59 = l & 8388610L;
            if (l59 != l17) {
                if (obj2.j0 != null) {
                    boolean showReportDeleteButton = obj2.j0.showReportDeleteButton();
                } else {
                }
                if (l59 != l17) {
                    int r56 = pagePosition != 0 ? 137438953472L : 68719476736L;
                    l = l | (pagePosition != 0 ? 137438953472L : 68719476736L);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l60 = l & 8388658L;
            if (l60 == l17 || obj2.j0 == null) {
            } else {
                pagePosition = obj2.j0.getPhotoCount();
                pagePosition = obj2.j0.getPagePosition();
            }
            long l61 = l & 8486914L;
            if (l61 != l17) {
                if (obj2.j0 != null) {
                    String caption = obj2.j0.getCaption();
                    boolean captionExapanded = obj2.j0.isCaptionExapanded();
                } else {
                }
                long l62 = l & 8421378L;
                if (l62 != l17) {
                    if (i == 0) {
                    }
                    if (l62 != l17) {
                        int r59 = pagePosition != 0 ? 35184372088832L : 17592186044416L;
                        l = l | (pagePosition != 0 ? 35184372088832L : 17592186044416L);
                    }
                    if (pagePosition != 0) {
                    } else {
                    }
                }
            } else {
            }
            long l63 = l & 8396802L;
            if (l63 != l17) {
                if (obj2.j0 != null) {
                    boolean likeState = obj2.j0.getLikeState();
                } else {
                }
                if (l63 != l17) {
                    int r61 = pagePosition != 0 ? 34359738368L : 17179869184L;
                    l = l | (pagePosition != 0 ? 34359738368L : 17179869184L);
                }
                if (pagePosition != 0) {
                    pagePosition = ViewDataBinding.u(obj2.a0, 2131100352);
                } else {
                    int i2 = 2131099847;
                    pagePosition = ViewDataBinding.u(obj2.a0, i2);
                }
            } else {
            }
            long l34 = l & 12582914L;
            if (obj2.a0 != l17) {
                if (obj2.j0 != null) {
                    featured = obj2.j0.isFeatured();
                } else {
                }
                if (obj2.a0 != l17) {
                    int r63 = obj2.a0 ? 33554432 : 0x01000000 /* Unknown resource */;
                    l = l | (obj2.a0 ? 33554432 : 0x01000000 /* Unknown resource */);
                }
                int r15 = obj2.a0 ? R.color.primary : R.color.lightestGray;
                pagePosition = ViewDataBinding.u(obj2.o0, (obj2.a0 ? R.color.primary : R.color.lightestGray));
            } else {
            }
            long l35 = l & 8392706L;
            if (obj2.a0 != l17) {
                if (obj2.j0 != null) {
                    boolean adminBadgeVisible = obj2.j0.isAdminBadgeVisible();
                } else {
                }
                if (obj2.a0 != l17) {
                    r63 = pagePosition != 0 ? 2147483648L : 1073741824;
                    l = l | (pagePosition != 0 ? 2147483648L : 1073741824);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l64 = l & 8388674L;
            if (l64 == l17 || obj2.j0 == null) {
            } else {
                voteCount = obj2.j0.getVoteCount();
            }
            l12 = l & 10485762L;
            if (l12 != l17) {
                if (obj2.j0 != null) {
                    boolean borderVisible = obj2.j0.isBorderVisible();
                } else {
                }
                if (l12 != l17) {
                    int r64 = pagePosition != 0 ? 140737488355328L : 70368744177664L;
                    l = l | (pagePosition != 0 ? 140737488355328L : 70368744177664L);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l65 = l & 8650754L;
            if (l65 != l17) {
                if (obj2.j0 != null) {
                    boolean translateButtonVisible = obj2.j0.isTranslateButtonVisible();
                } else {
                }
                if (l65 != l17) {
                    int r65 = pagePosition != 0 ? 549755813888L : 274877906944L;
                    l = l | (pagePosition != 0 ? 549755813888L : 274877906944L);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l66 = l & 8388618L;
            if (l66 != l17) {
                if (obj2.j0 != null) {
                    boolean shareButtonVisible = obj2.j0.isShareButtonVisible();
                } else {
                }
                if (l66 != l17) {
                    r64 = obj2.j0 != 0 ? 8589934592L : 4294967296L;
                    l = l | (obj2.j0 != 0 ? 8589934592L : 4294967296L);
                }
                if (obj2.j0 == 0) {
                }
            }
        } else {
        }
        long l49 = l & 8389122L;
        if (l49 != l17) {
            if (pagePosition != 0) {
            } else {
                int i3 = 2131887121;
            }
        }
        long l46 = l & 8392706L;
        if (l46 != l17) {
            obj2.O.setVisibility(pagePosition);
        }
        long l31 = l & 8388866L;
        if (obj2.O != l17) {
            obj2.P.setVisibility(pagePosition);
        }
        l5 = 8388608L & l;
        if (obj2.P != l17) {
            obj2.R.setOnClickListener(obj2.r0);
            obj2.X.setOnClickListener(obj2.q0);
            obj2.h0.setOnClickListener(obj2.s0);
            obj2.i0.setOnClickListener(obj2.p0);
        }
        long l32 = l & 8421378L;
        if (obj2.P != l17) {
            obj2.R.setVisibility(pagePosition);
        }
        long l33 = l & 8389634L;
        if (obj2.P != l17) {
            g.c(obj2.U, charSequence2);
        }
        if (l49 != l17) {
            g.c(obj2.W, i);
        }
        long l30 = l & 8388738L;
        if (obj2.W != l17) {
            app.dogo.com.dogo_android.util.binding.m.o(obj2.X, str4);
        }
        l2 = l & 9437186L;
        if (l2 != l17) {
            BindingAdapters.setVideoView(obj2.Y, Boolean.valueOf(z3));
        }
        long l29 = l & 10485762L;
        if (l29 != l17) {
            obj2.Y.setVisibility(pagePosition);
        }
        l3 = 8396802L & l;
        if (l3 != l17) {
            obj2.a0.setEnabled(z);
            BindingAdapters.i0(obj2.a0, Integer.valueOf(pagePosition));
        }
        long l19 = l & 8404994L;
        if (obj2.X != l17) {
            BindingAdapters.setReminderIntervalSelectAdapter(obj2.m0, Boolean.valueOf(z4));
        }
        long l20 = 8486914L & l;
        if (obj2.X != l17) {
            app.dogo.com.dogo_android.util.binding.m.b(obj2.n0, i, pagePosition);
        }
        long l21 = 12582914L & l;
        if (obj2.n0 != l17) {
            BindingAdapters.i0(obj2.o0, Integer.valueOf(pagePosition));
        }
        long l22 = l & 8912898L;
        if (obj2.n0 != l17) {
            obj2.c0.setVisibility(pagePosition);
        }
        long l23 = 8388658L & l;
        if (obj2.n0 != l17) {
            app.dogo.com.dogo_android.util.binding.m.j(obj2.d0, pagePosition, pagePosition, 10);
        }
        long l24 = l & 8390658L;
        if (obj2.n0 != l17) {
            obj2.e0.setVisibility(pagePosition);
        }
        long l25 = 8388610L & l;
        if (obj2.n0 != l17) {
            obj2.f0.setVisibility(pagePosition);
        }
        long l26 = 8388618L & l;
        if (obj2.n0 != l17) {
            obj2.g0.setVisibility(pagePosition);
        }
        long l27 = l & 8519682L;
        if (obj2.n0 != l17) {
            g.c(obj2.h0, i);
        }
        long l28 = 8650754L & l;
        if (obj2.n0 != l17) {
            obj2.h0.setVisibility(pagePosition);
        }
        l &= 8388674;
        if (obj2.t0 != l17) {
            g.c(obj2.i0, obj);
        }
        ViewDataBinding.o(obj2.T);
    }

    @Override // app.dogo.com.dogo_android.h.sk
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.t0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.T.y()) {
            return true;
        }
        return false;
    }

    private tk(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ImageView)objectArr[9], (ImageView)objectArr[5], (AppCompatImageView)objectArr[27], (Barrier)objectArr[24], (RelativeLayout)objectArr[13], (ViewPager)objectArr[20], (ci)objectArr[19], (TextView)objectArr[7], (Button)objectArr[21], (TextView)objectArr[6], (ImageView)objectArr[4], (RelativeLayout)objectArr[23], (ImageView)objectArr[17], (FrameLayout)objectArr[28], (AppCompatImageView)objectArr[10], (FrameLayout)objectArr[25], (ProgressBar)objectArr[16], (LinearLayout)objectArr[2], (ConstraintLayout)objectArr[22], (ImageView)objectArr[8], (FrameLayout)objectArr[11], (ImageView)objectArr[1], (TextView)objectArr[15], (RelativeLayout)objectArr[26], (TextView)objectArr[3]);
        Object eVar4 = this;
        eVar4.t0 = -1L;
        Object obj5 = null;
        eVar4.O.setTag(obj5);
        eVar4.P.setTag(obj5);
        eVar4.R.setTag(obj5);
        eVar4.L(eVar4.T);
        eVar4.U.setTag(obj5);
        eVar4.W.setTag(obj5);
        eVar4.X.setTag(obj5);
        eVar4.Y.setTag(obj5);
        eVar4.a0.setTag(obj5);
        Object obj = objectArr[0];
        eVar4.l0 = obj;
        obj.setTag(obj5);
        Object obj2 = objectArr[12];
        eVar4.m0 = obj2;
        obj2.setTag(obj5);
        Object obj3 = objectArr[14];
        eVar4.n0 = obj3;
        obj3.setTag(obj5);
        Object obj4 = objectArr[18];
        eVar4.o0 = obj4;
        obj4.setTag(obj5);
        eVar4.c0.setTag(obj5);
        eVar4.d0.setTag(obj5);
        eVar4.e0.setTag(obj5);
        eVar4.f0.setTag(obj5);
        eVar4.g0.setTag(obj5);
        eVar4.h0.setTag(obj5);
        eVar4.i0.setTag(obj5);
        eVar4.N(view);
        eVar4.p0 = new b(eVar4, 1);
        eVar4.q0 = new b(eVar4, 2);
        eVar4.r0 = new b(eVar4, 3);
        eVar4.s0 = new b(eVar4, 4);
        A();
    }
}
