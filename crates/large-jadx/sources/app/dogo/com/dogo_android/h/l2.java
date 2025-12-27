package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: CellEntryUserPhotoItemBindingImpl.java */
/* loaded from: classes.dex */
public class l2 extends k2 implements b.a {

    private static final ViewDataBinding.g a0 = new ViewDataBinding$g(8);
    private static final SparseIntArray b0 = new SparseIntArray();
    private final LinearLayout W;
    private final LinearLayout X;
    private final View.OnClickListener Y;
    private long Z;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 6;
        int[] iArr = new int[i3];
        iArr[i7] = R.layout.layout_entry_base;
        obj.a(i7, new String[] { "layout_entry_base" }, iArr2, iArr);
        obj.put(2131362485, 7);
    }

    public l2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, l2.a0, l2.b0));
    }

    private boolean Y(sk skVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Z |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(EntryUserPhotoObservable entryUserPhotoObservable, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Z |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw entryUserPhotoObservable;
            }
        }
        if (i == 130) {
            synchronized (this) {
                try {
                    this.Z |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw entryUserPhotoObservable;
            }
        }
        if (i == 114) {
            synchronized (this) {
                try {
                    this.Z |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 129) {
            synchronized (this) {
                try {
                    this.Z |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void A() {
        synchronized (this) {
            try {
                this.Z = 64L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k2
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            X(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void W(a0 a0Var) {
        this.V = a0Var;
        synchronized (this) {
            try {
                this.Z |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void X(EntryUserPhotoObservable entryUserPhotoObservable) {
        R(1, entryUserPhotoObservable);
        this.U = entryUserPhotoObservable;
        synchronized (this) {
            try {
                this.Z |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public final void b(int i, View view) {
        int i2 = 1;
        int r0 = this.U != null ? 1 : 0;
        if (i2 != 0) {
            this.U.showEntryFans(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k2
    protected void m() {
        Object obj = null;
        long l;
        int i = 0;
        java.lang.CharSequence charSequence = null;
        int i2 = 0;
        int rankVisibility;
        Resources resources;
        boolean published;
        java.lang.CharSequence charSequence2 = null;
        int cmp6;
        long l3;
        int i3 = 128;
        final Object obj2 = this;
        synchronized (this) {
            try {
                final long l6 = 0L;
                obj2.Z = l6;
            } catch (Throwable th) {
            }
        }
        long l7 = 122L & l;
        long l8 = 98L;
        long l10 = 82L;
        long l12 = 66L;
        rankVisibility = 0;
        if (l7 != l6) {
            long l14 = l & 74L;
            if (l14 == l6 || obj2.U == null) {
                i = 0;
            } else {
                String rankText = obj2.U.getRankText();
            }
            long l15 = l & 66L;
            if (l15 != l6) {
                if (obj2.U != null) {
                    rankVisibility = obj2.U.getFanCount();
                    rankVisibility = obj2.U.getRankVisibility();
                } else {
                }
                Object[] arr = new Object[1];
                String string = obj2.P.getResources().getString(2131886283, new Object[] { Integer.valueOf(rankVisibility) });
            } else {
                i2 = 0;
            }
            l3 = l & 98L;
            if (l3 != l6) {
                if (obj2.U != null) {
                    published = obj2.U.isPublished();
                } else {
                }
                if (l3 != l6) {
                    int r19 = obj2.P ? 256 : 128;
                    l = l | (obj2.P ? 256 : 128);
                }
                if (!(obj2.P)) {
                    rankVisibility = 8;
                }
            }
            l4 = l & 82L;
            if (l4 == l6 || obj2.U == null) {
                int i4 = 0;
            } else {
            }
        } else {
            int i5 = 0;
            int i7 = 0;
            int i13 = 0;
        }
        long l13 = 66L & l;
        if (l13 != l6) {
            g.c(obj2.P, charSequence2);
            obj2.X.setVisibility(rankVisibility);
        }
        l2 = 64L & l;
        if (obj2.P != l6) {
            obj2.R.setOnClickListener(obj2.Y);
        }
        long l11 = 82L & l;
        if (l11 != l6) {
            g.c(obj2.S, obj);
        }
        long l9 = 98L & l;
        if (l9 != l6) {
            obj2.S.setVisibility(rankVisibility);
        }
        l &= 74;
        if (obj2.Z != l6) {
            g.c(obj2.T, charSequence);
        }
        ViewDataBinding.o(obj2.O);
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.Z != 0) {
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

    private l2(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (sk)objectArr[6], (TextView)objectArr[5], (LinearLayout)objectArr[7], (ConstraintLayout)objectArr[4], (TextView)objectArr[3], (TextView)objectArr[2]);
        this.Z = -1L;
        L(this.O);
        Object obj7 = null;
        this.P.setTag(obj7);
        this.R.setTag(obj7);
        Object obj8 = objectArr[0];
        this.W = obj8;
        obj8.setTag(obj7);
        int i10 = 1;
        Object obj9 = objectArr[i10];
        this.X = obj9;
        obj9.setTag(obj7);
        this.S.setTag(obj7);
        this.T.setTag(obj7);
        N(view);
        this.Y = new b(this, i10);
        A();
    }
}
