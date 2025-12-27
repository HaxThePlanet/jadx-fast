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

/* compiled from: CellEntryProfileTitleItemBindingImpl.java */
/* loaded from: classes.dex */
public class h2 extends g2 {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final ConstraintLayout X;
    private long Y;
    static {
        obj.put(2131362343, 9);
        obj.put(2131362641, 10);
    }

    public h2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, h2.Z, h2.a0));
    }

    private boolean W(h hVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw hVar;
            }
        }
        if (i == 63) {
            synchronized (this) {
                try {
                    this.Y |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw hVar;
            }
        }
        if (i == 7) {
            synchronized (this) {
                try {
                    this.Y |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw hVar;
            }
        }
        if (i == 65) {
            synchronized (this) {
                try {
                    this.Y |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 125) {
            synchronized (this) {
                try {
                    this.Y |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 5) {
            synchronized (this) {
                try {
                    this.Y |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.g2
    public void A() {
        synchronized (this) {
            try {
                this.Y = 64L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g2
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.g2
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

    @Override // app.dogo.com.dogo_android.h.g2
    public void V(h hVar) {
        R(0, hVar);
        this.W = hVar;
        synchronized (this) {
            try {
                this.Y |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g2
    protected void m() {
        java.lang.CharSequence charSequence;
        int i2;
        long l;
        String str2;
        int i;
        Object obj2;
        Object obj3;
        android.text.SpannableStringBuilder totalVoteCount = null;
        int i3 = 512;
        String str;
        int cmp6;
        int i4;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.Y = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 127L & l;
        long l3 = 73L;
        final long l10 = 69L;
        final long l11 = 67L;
        long l12 = 97L;
        i = 0;
        i2 = 0;
        if (l5 != l4) {
            long l14 = l & 67L;
            if (l14 == l4 || obj.W == null) {
            } else {
                String dogAvatar = obj.W.getDogAvatar();
            }
            long l15 = l & 69L;
            i2 = 8;
            if (l15 != l4) {
                if (obj.W != null) {
                    boolean ambassadorBadgeVisible = obj.W.isAmbassadorBadgeVisible();
                } else {
                }
                if (l15 != l4) {
                    int r24 = i2 != 0 ? 1024 : 512;
                    l = l | (i2 != 0 ? 1024 : 512);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l16 = l & 73L;
            if (l16 == l4 || obj.W == null) {
            } else {
                String dogName = obj.W.getDogName();
            }
            long l17 = l & 65L;
            if (l17 == l4 || obj.W == null) {
            } else {
                totalVoteCount = obj.W.getTotalVoteCount();
                str = obj.W.b();
            }
            long l18 = l & 81L;
            if (l18 != l4) {
                if (obj.W != null) {
                    boolean premiumBadgeVisible = obj.W.isPremiumBadgeVisible();
                } else {
                }
                if (l18 != l4) {
                    int r27 = i2 != 0 ? 256 : 128;
                    l = l | (i2 != 0 ? 256 : 128);
                }
                if (i2 != 0) {
                } else {
                }
            }
            long l19 = l & 97L;
            if (l19 != l4) {
                if (obj.W != null) {
                    boolean adminBadgeVisible = obj.W.isAdminBadgeVisible();
                } else {
                }
                if (l19 != l4) {
                    int r26 = obj.W != 0 ? 4096 : 2048;
                    l = l | (obj.W != 0 ? 4096 : 2048);
                }
                if (obj.W == 0) {
                }
            }
        } else {
        }
        long l13 = l & 97L;
        if (l13 != l4) {
            obj.O.setVisibility(i2);
        }
        long l9 = l & 69L;
        if (obj.O != l4) {
            obj.P.setVisibility(i2);
            obj.Q.setVisibility(i2);
        }
        long l6 = l & 67L;
        if (obj.Q != l4) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.R, str2);
        }
        long l7 = 73L & l;
        if (obj.Q != l4) {
            g.c(obj.S, charSequence);
        }
        long l8 = 65L & l;
        if (obj.Q != l4) {
            g.c(obj.T, obj2);
            g.c(obj.V, obj3);
        }
        l2 = l & 81L;
        if (obj.Y != l4) {
            obj.U.setVisibility(i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g2
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Y != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private h2(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 1, (ImageView)objectArr[5], (ImageView)objectArr[2], (TextView)objectArr[6], (ImageView)objectArr[1], (RelativeLayout)objectArr[9], (TextView)objectArr[3], (AppCompatImageView)objectArr[10], (TextView)objectArr[7], (ImageView)objectArr[4], (TextView)objectArr[8]);
        eVar3.Y = -1L;
        Object obj12 = null;
        eVar3.O.setTag(obj12);
        eVar3.P.setTag(obj12);
        eVar3.Q.setTag(obj12);
        eVar3.R.setTag(obj12);
        eVar3.S.setTag(obj12);
        Object obj11 = objectArr[0];
        eVar3.X = obj11;
        obj11.setTag(obj12);
        eVar3.T.setTag(obj12);
        eVar3.U.setTag(obj12);
        eVar3.V.setTag(obj12);
        N(view);
        A();
    }
}
