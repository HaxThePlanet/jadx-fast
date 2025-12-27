package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.z;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutDashboardSpecialProgramCompletedBindingImpl.java */
/* loaded from: classes.dex */
public class vj extends uj implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout S;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private long V;
    static {
        obj.put(2131362790, 3);
        obj.put(2131363414, 4);
        obj.put(2131362711, 5);
        obj.put(2131362298, 6);
        obj.put(2131363156, 7);
    }

    public vj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, vj.W, vj.X));
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public void A() {
        synchronized (this) {
            try {
                this.V = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                T(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public void T(o oVar) {
        this.R = oVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.Q = programDescriptionItem;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public final void b(int i, View view) {
        int view22;
        view22 = 0;
        view22 = 1;
        if (i == view22) {
            int r2 = view22;
            if (view22 != null && this.Q != null) {
                if (view22 != null) {
                    this.R.onProgramOverviewSelected(this.Q.getId());
                }
            }
        } else {
            if (this.Q == 2) {
                r2 = view22;
                if (view22 != null && this.Q != null) {
                    if (view22 != null) {
                        this.R.onProgramOverviewSelected(this.Q.getId());
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.uj
    protected void m() {
        int cmp;
        String cardBackgroundColor = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l4 = 5L & l;
        if (l4 != l3 && this.Q != null) {
            cardBackgroundColor = this.Q.getCardBackgroundColor();
        }
        long l2 = l & 4L;
        if (this.V != l3) {
            this.O.setOnClickListener(this.T);
            this.P.setOnClickListener(this.U);
        }
        if (l4 != l3) {
            BindingAdapters.setRatingChange(this.O, cardBackgroundColor);
        }
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private vj(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i9 = 1;
        final int i10 = 2;
        super(eVar, view, 0, (TextView)objectArr[6], (ImageView)objectArr[5], (ImageView)objectArr[3], (CardView)objectArr[i9], (Button)objectArr[i10], (ImageView)objectArr[7], (TextView)objectArr[4]);
        eVar3.V = -1L;
        Object obj8 = objectArr[0];
        eVar3.S = obj8;
        Object obj9 = null;
        obj8.setTag(obj9);
        eVar3.O.setTag(obj9);
        eVar3.P.setTag(obj9);
        N(view);
        eVar3.T = new b(this, i9);
        eVar3.U = new b(this, i10);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
