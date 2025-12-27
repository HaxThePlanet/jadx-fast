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
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.d.b.z.j;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.k0.c;

/* compiled from: CellChallengeCommentCaptionItemBindingImpl.java */
/* loaded from: classes.dex */
public class j0 extends i0 implements b.a {

    private static final ViewDataBinding.g j0;
    private static final SparseIntArray k0 = new SparseIntArray();
    private final ConstraintLayout g0;
    private final View.OnClickListener h0;
    private long i0;
    static {
        obj.put(2131362404, 14);
        obj.put(2131362724, 15);
        obj.put(2131361915, 16);
        obj.put(2131362635, 17);
        obj.put(2131361929, 18);
    }

    public j0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 19, j0.j0, j0.k0));
    }

    private boolean X(c cVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.i0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw cVar;
            }
        }
        if (i == 121) {
            synchronized (this) {
                try {
                    this.i0 |= 16384;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 123) {
            synchronized (this) {
                try {
                    this.i0 |= 32768;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(j jVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.i0 |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw jVar;
            }
        }
        if (i == 36) {
            synchronized (this) {
                try {
                    this.i0 |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw jVar;
            }
        }
        if (i == 184) {
            synchronized (this) {
                try {
                    this.i0 |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw jVar;
            }
        }
        if (i == 101) {
            synchronized (this) {
                try {
                    this.i0 |= 16;
                    return true;
                } catch (Throwable unused) {
                }
                throw jVar;
            }
        }
        if (i == 133) {
            synchronized (this) {
                try {
                    this.i0 |= 32;
                    return true;
                } catch (Throwable unused) {
                }
                throw jVar;
            }
        }
        if (i == 63) {
            synchronized (this) {
                try {
                    this.i0 |= 64;
                    return true;
                } catch (Throwable unused) {
                }
                throw jVar;
            }
        }
        if (i == 32) {
            synchronized (this) {
                try {
                    this.i0 |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 7) {
            synchronized (this) {
                try {
                    this.i0 |= 256;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 73) {
            synchronized (this) {
                try {
                    this.i0 |= 512;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 165) {
            synchronized (this) {
                try {
                    this.i0 |= 1024;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 164) {
            synchronized (this) {
                try {
                    this.i0 |= 2048;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 147) {
            synchronized (this) {
                try {
                    this.i0 |= 4096;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 23) {
            synchronized (this) {
                try {
                    this.i0 |= 8192;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public void A() {
        synchronized (this) {
            try {
                this.i0 = 65536L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i0
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 106;
            if (106 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public void V(c cVar) {
        R(1, cVar);
        this.f0 = cVar;
        synchronized (this) {
            try {
                this.i0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(106);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public void W(j jVar) {
        R(0, jVar);
        this.e0 = jVar;
        synchronized (this) {
            try {
                this.i0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.e0 != null ? 1 : 0;
        if (i2 != 0) {
            this.e0.onTranslateButtonPress();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i0
    protected void m() {
        int pagePosition;
        long l;
        java.lang.CharSequence charSequence2;
        int i;
        int i2 = 2131099847;
        java.lang.CharSequence charSequence3;
        Object obj2;
        String str2;
        long l10 = 34359738368L;
        long l9;
        int i3;
        String str;
        int i4 = 67108864;
        long l11;
        int i5;
        long l13;
        int i6 = 536870912;
        long l14;
        long l15 = 2147483648L;
        int i7 = 524288;
        final Object obj = this;
        synchronized (this) {
            try {
                long l3 = 0L;
                obj.i0 = l3;
            } catch (Throwable th) {
            }
        }
        long l23 = 81917L & l;
        final long l25 = 65553L;
        long l26 = 16777216L;
        final long l31 = 8388608L;
        final long l32 = 73729L;
        final long l33 = 66561L;
        final long l34 = 65541L;
        final long l35 = 65601L;
        final long l36 = 66049L;
        final long l37 = 65921L;
        final long l38 = 65665L;
        i = 0;
        pagePosition = 8;
        pagePosition = 0;
        if (l23 != l3) {
            long l39 = l & 66049L;
            if (l39 == l3 || obj.e0 == null) {
            } else {
                android.text.SpannableStringBuilder spannableStringBuilder = obj.e0.j();
            }
            long l40 = l & 65601L;
            if (l40 == l3 || obj.e0 == null) {
            } else {
                String dogAvatar = obj.e0.getDogAvatar();
            }
            long l41 = l & 65541L;
            if (l41 == l3 || obj.e0 == null) {
            } else {
                str = obj.e0.g();
            }
            long l42 = l & 66561L;
            if (l42 == l3 || obj.e0 == null) {
            } else {
                String translationButtonString = obj.e0.getTranslationButtonString();
            }
            long l43 = l & 73729L;
            if (l43 != l3) {
                if (obj.e0 != null) {
                    boolean borderVisible = obj.e0.isBorderVisible();
                } else {
                }
                if (l43 != l3) {
                    int r44 = pagePosition != 0 ? 67108864 : 33554432;
                    l = l | (pagePosition != 0 ? 67108864 : 33554432);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l44 = l & 65665L;
            if (l44 != l3) {
                if (obj.e0 != null) {
                    boolean z3 = obj.e0.k();
                    boolean premiumBadgeVisible = obj.e0.isPremiumBadgeVisible();
                } else {
                }
                if (l44 != l3) {
                    long r2 = pagePosition != 0 ? l | l26 : l | l31;
                }
                l11 = (pagePosition != 0 ? l | l26 : l | l31) & 65665L;
                if (l11 != l3) {
                    int r46 = pagePosition != 0 ? 17179869184L : 8589934592L;
                    l = r2 | (pagePosition != 0 ? 17179869184L : 8589934592L);
                }
                int r43 = pagePosition;
            } else {
            }
            long l46 = l & 65553L;
            if (l46 != l3) {
                if (obj.e0 != null) {
                    boolean likeState = obj.e0.getLikeState();
                } else {
                }
                if (l46 != l3) {
                    int r48 = pagePosition != 0 ? 262144 : 131072;
                    l = l | (pagePosition != 0 ? 262144 : 131072);
                }
                int r9 = pagePosition != 0 ? R.color.secondary : R.color.icon_gray;
                pagePosition = ViewDataBinding.u(obj.U, (pagePosition != 0 ? R.color.secondary : R.color.icon_gray));
            } else {
            }
            l13 = l & 65569L;
            if (l13 != l3) {
                if (obj.e0 != null) {
                    boolean z4 = obj.e0.l();
                } else {
                }
                if (l13 != l3) {
                    int r50 = pagePosition != 0 ? 1073741824 : 536870912;
                    l = l | (pagePosition != 0 ? 1073741824 : 536870912);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l51 = l & 65545L;
            if (l51 != l3 && obj.e0 != null) {
                String voteCount = obj.e0.getVoteCount();
            }
            l14 = l & 67585L;
            if (l14 != l3) {
                if (obj.e0 != null) {
                    boolean translateButtonVisible = obj.e0.isTranslateButtonVisible();
                } else {
                }
                if (l14 != l3) {
                    int r51 = pagePosition != 0 ? 268435456 : 134217728;
                    l = l | (pagePosition != 0 ? 268435456 : 134217728);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l12 = 69633L;
            long l52 = l & l12;
            if (l52 != l3) {
                if (obj.e0 != null) {
                    boolean spinnerVisible = obj.e0.isSpinnerVisible();
                } else {
                }
                if (l52 != l3) {
                    int r52 = pagePosition != 0 ? 4294967296L : 2147483648L;
                    l = l | (pagePosition != 0 ? 4294967296L : 2147483648L);
                }
                if (pagePosition != 0) {
                } else {
                }
            }
            long l53 = l & 65921L;
            if (l53 != l3) {
                if (obj.e0 != null) {
                    boolean ambassadorBadgeVisible = obj.e0.isAmbassadorBadgeVisible();
                } else {
                }
                if (l53 != l3) {
                    int r53 = pagePosition != 0 ? 1048576 : 524288;
                    l = l | (pagePosition != 0 ? 1048576 : 524288);
                }
            } else {
            }
        } else {
        }
        long l45 = 114690L;
        long l47 = l & l45;
        if (l47 == l3 || obj.f0 == null) {
        } else {
            pagePosition = obj.f0.getPagePosition();
        }
        long l49 = l & 17180917760L;
        if (l49 != l3 && obj.e0 != null) {
            boolean z2 = obj.e0.k();
            long l50 = l & 65665L;
            if (l50 != l3) {
                r2 = pagePosition != 0 ? l | l26 : l | l31;
            }
        }
        l9 = (pagePosition != 0 ? l | l26 : l | l31) & 65921L;
        if (l9 != l3) {
            int r18 = pagePosition;
            if (l9 != l3) {
                int r19 = pagePosition != 0 ? 4194304 : 2097152;
                l = r2 | (pagePosition != 0 ? 4194304 : 2097152);
            }
            if (pagePosition != 0) {
            } else {
            }
        }
        long l27 = l & 65665L;
        if (l27 != l3) {
            if (pagePosition == 0) {
            }
            if (l27 != l3) {
                r18 = pagePosition != 0 ? 68719476736L : 34359738368L;
                l = l | (pagePosition != 0 ? 68719476736L : 34359738368L);
            }
            if (pagePosition != 0) {
            }
        } else {
        }
        long l28 = l & 65921L;
        if (l28 != l3) {
            obj.O.setVisibility(pagePosition);
        }
        long l16 = l & 66049L;
        long l29 = 0L;
        if (obj.O != l29) {
            g.c(obj.Q, charSequence2);
        }
        long l17 = l & 65665L;
        if (obj.O != l29) {
            obj.Q.setVisibility(pagePosition);
            obj.Y.setVisibility(pagePosition);
            obj.Z.setVisibility(pagePosition);
            obj.c0.setVisibility(pagePosition);
        }
        long l18 = l & 65541L;
        long l30 = 0L;
        if (obj.O != l30) {
            g.c(obj.R, obj2);
        }
        long l19 = l & 73729L;
        if (obj.O != l30) {
            obj.S.setVisibility(pagePosition);
        }
        l4 = l & 65553L;
        if (obj.O != l30) {
            obj.U.setEnabled(pagePosition);
            if (ViewDataBinding.t() >= 21) {
                obj.U.setImageTintList(b.a(pagePosition));
            }
        }
        l5 = 69633L & l;
        long l24 = 0L;
        if (obj.O != l24) {
            obj.W.setVisibility(pagePosition);
        }
        l6 = l & 114690L;
        if (obj.O != l24) {
            app.dogo.com.dogo_android.util.binding.m.j(obj.X, pagePosition, pagePosition, 10);
        }
        long l20 = l & 65601L;
        if (obj.O != l24) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.Z, str2);
        }
        long l21 = 65569L & l;
        if (obj.O != l24) {
            obj.a0.setVisibility(pagePosition);
        }
        long l22 = l & 66561L;
        if (obj.O != l24) {
            g.c(obj.b0, charSequence3);
        }
        l7 = 67585L & l;
        if (obj.O != l24) {
            obj.b0.setVisibility(pagePosition);
        }
        l8 = 65536L & l;
        if (obj.O != l24) {
            obj.b0.setOnClickListener(obj.h0);
        }
        l2 = l & 65545L;
        if (obj.i0 != l24) {
            g.c(obj.d0, i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i0
    public boolean y() {
        synchronized (this) {
            try {
                if (this.i0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private j0(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ImageView)objectArr[6], (View)objectArr[16], (ImageView)objectArr[18], (TextView)objectArr[8], (TextView)objectArr[1], (ImageView)objectArr[13], (ViewPager)objectArr[14], (AppCompatImageView)objectArr[3], (ImageView)objectArr[17], (FrameLayout)objectArr[15], (ProgressBar)objectArr[12], (LinearLayout)objectArr[9], (ImageView)objectArr[7], (ImageView)objectArr[5], (FrameLayout)objectArr[4], (TextView)objectArr[11], (RelativeLayout)objectArr[10], (TextView)objectArr[2]);
        Object eVar4 = this;
        eVar4.i0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.Q.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.S.setTag(obj2);
        eVar4.U.setTag(obj2);
        Object obj = objectArr[0];
        eVar4.g0 = obj;
        obj.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.X.setTag(obj2);
        eVar4.Y.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.a0.setTag(obj2);
        eVar4.b0.setTag(obj2);
        eVar4.c0.setTag(obj2);
        eVar4.d0.setTag(obj2);
        eVar4.N(view);
        eVar4.h0 = new b(eVar4, 1);
        A();
    }
}
