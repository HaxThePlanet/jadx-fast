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
import app.dogo.com.dogo_android.g.v;
import app.dogo.com.dogo_android.g.w;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutDashboardProgramCompleteBindingImpl.java */
/* loaded from: classes.dex */
public class hj extends gj implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private long W;
    static {
        obj.put(2131362711, 4);
        obj.put(2131361988, 5);
        obj.put(2131363156, 6);
        obj.put(2131363421, 7);
        obj.put(2131363306, 8);
    }

    public hj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, hj.X, hj.Y));
    }

    @Override // app.dogo.com.dogo_android.h.gj
    public void A() {
        synchronized (this) {
            try {
                this.W = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gj
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

    @Override // app.dogo.com.dogo_android.h.gj
    public void T(o oVar) {
        this.S = oVar;
        synchronized (this) {
            try {
                this.W |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gj
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.S != null) {
            }
            if (i2 != 0) {
                this.S.onOtherTrainingProgramsSelected(this.R);
            }
        } else {
            if (this.R == 2) {
                if (this.S != null) {
                }
                if (i2 != 0) {
                    this.S.onOtherTrainingProgramsSelected("program_completion");
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.gj
    protected void m() {
        int cmp;
        String cardBackgroundColor = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.W = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l4 = 5L & l;
        if (l4 != l3 && this.R != null) {
            cardBackgroundColor = this.R.getCardBackgroundColor();
        }
        long l2 = l & 4L;
        if (this.W != l3) {
            this.O.setOnClickListener(this.V);
            this.Q.setOnClickListener(this.U);
        }
        if (l4 != l3) {
            BindingAdapters.setRatingChange(this.P, cardBackgroundColor);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private hj(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i10 = 1;
        final int i11 = 2;
        super(eVar, view, 0, (ImageView)objectArr[5], (Button)objectArr[3], (ImageView)objectArr[4], (CardView)objectArr[i10], (ImageView)objectArr[6], (TextView)objectArr[8], (TextView)objectArr[7], (Button)objectArr[i11]);
        eVar3.W = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.T = obj9;
        obj9.setTag(obj10);
        eVar3.Q.setTag(obj10);
        N(view);
        eVar3.U = new b(this, i10);
        eVar3.V = new b(this, i11);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
