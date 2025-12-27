package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoObservable;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellEntryOldPhotoItemBindingImpl.java */
/* loaded from: classes.dex */
public class b2 extends a2 {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(6);
    private static final SparseIntArray X = null;
    private final ConstraintLayout S;
    private final TextView T;
    private final TextView U;
    private long V;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i6 = 0;
        iArr2[i6] = 5;
        int[] iArr = new int[i3];
        iArr[i6] = R.layout.layout_entry_base;
        obj.a(i6, new String[] { "layout_entry_base" }, iArr2, iArr);
    }

    public b2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, b2.W, b2.X));
    }

    private boolean W(sk skVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(EntryOldPhotoObservable entryOldPhotoObservable, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw entryOldPhotoObservable;
            }
        }
        if (i == 187) {
            synchronized (this) {
                try {
                    this.V |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw entryOldPhotoObservable;
            }
        }
        if (i == 71) {
            synchronized (this) {
                try {
                    this.V |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 188) {
            synchronized (this) {
                try {
                    this.V |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 107) {
            synchronized (this) {
                try {
                    this.V |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.a2
    public void A() {
        synchronized (this) {
            try {
                this.V = 64L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a2
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.a2
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.a2
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

    @Override // app.dogo.com.dogo_android.h.a2
    public void V(EntryOldPhotoObservable entryOldPhotoObservable) {
        R(1, entryOldPhotoObservable);
        this.R = entryOldPhotoObservable;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a2
    protected void m() {
        int cmp;
        long l;
        java.lang.CharSequence charSequence;
        int i;
        int i2 = 16384;
        long l2;
        long l3;
        int i3 = 512;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l7 = 0L;
                obj.V = l7;
            } catch (Throwable th) {
            }
        }
        long l8 = 126L & l;
        long l12 = 4096L;
        final long l14 = 2048L;
        final long l15 = 82L;
        long l16 = 128L;
        i = 0;
        cmp = 8;
        final long l19 = 70L;
        final long l20 = 74L;
        final long l21 = 78L;
        cmp = 0;
        if (l8 != l7) {
            long l22 = l & 82L;
            if (l22 == l7 || obj.R == null) {
            } else {
                String winnerString = obj.R.getWinnerString();
            }
            long l23 = l & 74L;
            if (l23 != l7) {
                if (obj.R != null) {
                    boolean firstRunnerUp2 = obj.R.isFirstRunnerUp();
                } else {
                }
                if (l23 != l7) {
                    long r2 = cmp != 0 ? l | l12 : l | l14;
                }
                int r26 = cmp;
            } else {
            }
            long l24 = l & 98L;
            if (l24 != l7 && obj.R != null) {
                String medalUrl = obj.R.getMedalUrl();
            }
            long l25 = l & 78L;
            if (l25 != l7) {
                if (obj.R != null) {
                    boolean winner = obj.R.isWinner();
                } else {
                }
                if (l25 != l7) {
                    l = cmp != 0 ? l | l4 : l | l16;
                }
                l5 = l & 70L;
                if (l5 != l7) {
                    int r30 = cmp != 0 ? 1024 : 512;
                    l = l | (cmp != 0 ? 1024 : 512);
                }
                l3 = l & 70L;
                if (l3 != l7) {
                    int r28 = cmp;
                    cmp = cmp;
                } else {
                }
            } else {
            }
        } else {
        }
        long l17 = 128L & l;
        if (l17 != l7 && obj.R != null) {
            boolean firstRunnerUp = obj.R.isFirstRunnerUp();
            long l18 = l & 74L;
            if (l18 != l7) {
                r2 = cmp != 0 ? l | l12 : l | l14;
            }
        }
        l2 = (cmp != 0 ? l | l12 : l | l14) & 78L;
        if (l2 != l7) {
            if (cmp != 0) {
                cmp = 1;
            }
            if (l2 != l7) {
                int r7 = cmp != 0 ? 16384 : 8192;
                l = r2 | (cmp != 0 ? 16384 : 8192);
            }
            if (cmp != 0) {
            }
        } else {
        }
        long l13 = l & 82L;
        if (l13 != l7) {
            g.c(obj.T, charSequence);
        }
        long l9 = l & 70L;
        if (l9 != l7) {
            obj.T.setVisibility(cmp);
            obj.P.setVisibility(cmp);
        }
        long l10 = l & 74L;
        if (obj.T != l7) {
            obj.U.setVisibility(cmp);
        }
        long l11 = 98L & l;
        if (obj.T != l7) {
            BindingAdapters.w(obj.P, i);
        }
        l &= l21;
        if (obj.V != l7) {
            obj.Q.setVisibility(cmp);
        }
        ViewDataBinding.o(obj.O);
    }

    @Override // app.dogo.com.dogo_android.h.a2
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private b2(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (sk)objectArr[5], (ImageView)objectArr[4], (RelativeLayout)objectArr[1]);
        this.V = -1L;
        L(this.O);
        Object obj5 = objectArr[0];
        this.S = obj5;
        Object obj4 = null;
        obj5.setTag(obj4);
        Object obj6 = objectArr[2];
        this.T = obj6;
        obj6.setTag(obj4);
        Object obj7 = objectArr[3];
        this.U = obj7;
        obj7.setTag(obj4);
        this.P.setTag(obj4);
        this.Q.setTag(obj4);
        N(view);
        A();
    }
}
