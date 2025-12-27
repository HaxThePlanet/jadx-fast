package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: CellChallengeFilterRowBindingImpl.java */
/* loaded from: classes.dex */
public class b1 extends a1 implements b.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout T;
    private final FrameLayout U;
    private final View.OnClickListener V;
    private final View.OnClickListener W;
    private long X;
    static {
        obj.put(2131362733, 3);
    }

    public b1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, b1.Y, b1.Z));
    }

    private boolean Y(g0 g0Var, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(EntryFilterViewModel entryFilterViewModel, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw entryFilterViewModel;
            }
        }
        if (i == 104) {
            synchronized (this) {
                try {
                    this.X |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void A() {
        synchronized (this) {
            try {
                this.X = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a1
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 176;
        if (176 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 183;
            if (183 == i) {
                X(object);
            } else {
                i2 = 116;
                if (116 == i) {
                    V(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void V(a0 a0Var) {
        this.S = a0Var;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void W(g0 g0Var) {
        R(0, g0Var);
        this.R = g0Var;
        synchronized (this) {
            try {
                this.X |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(176);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void X(EntryFilterViewModel entryFilterViewModel) {
        R(1, entryFilterViewModel);
        this.Q = entryFilterViewModel;
        synchronized (this) {
            try {
                this.X |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.R != null) {
            }
            if (i2 != 0) {
                this.R.B(this.S);
            }
        } else {
            if (this.R == 2) {
                if (this.R != null) {
                }
                if (i2 != 0) {
                    this.R.B(this.S);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
    protected void m() {
        long l;
        boolean listEmpty;
        int i = 0;
        int i2;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 26L;
        long l5 = l & l4;
        i = 0;
        if (l5 != l3 && this.Q != null) {
            listEmpty = this.Q.isListEmpty();
            if (l5 != l3) {
                int r9 = this.Q ? 64 : 32;
                l = l | (this.Q ? 64 : 32);
            }
            if (!(this.Q)) {
            }
        }
        long l6 = 16L & l;
        if (l6 != l3) {
            this.O.setOnClickListener(this.W);
            this.U.setOnClickListener(this.V);
        }
        l &= l4;
        if (this.X != l3) {
            this.U.setVisibility(i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public boolean y() {
        synchronized (this) {
            try {
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private b1(e eVar, View view, Object[] objectArr) {
        final int i = 2;
        super(eVar, view, 2, (LinearLayout)objectArr[i], (RecyclerView)objectArr[3]);
        this.X = -1L;
        Object obj3 = null;
        this.O.setTag(obj3);
        Object obj4 = objectArr[0];
        this.T = obj4;
        obj4.setTag(obj3);
        int i6 = 1;
        final Object obj5 = objectArr[i6];
        this.U = obj5;
        obj5.setTag(obj3);
        N(view);
        this.V = new b(this, i6);
        this.W = new b(this, i);
        A();
    }
}
