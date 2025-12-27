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
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellSpecialProgramVariationsBindingImpl.java */
/* loaded from: classes.dex */
public class r7 extends q7 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131363329, 4);
    }

    public r7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, r7.V, r7.W));
    }

    @Override // app.dogo.com.dogo_android.h.q7
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q7
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.q7
    public void V(TrickItem trickItem) {
        this.S = trickItem;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.q7
    protected void m() {
        long l;
        int knowledge;
        boolean notRatedByUser;
        int cmp2;
        int i3;
        java.lang.CharSequence charSequence;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.U = l4;
            } catch (Throwable th) {
            }
        }
        i3 = 0;
        final long l5 = 3L;
        long l6 = l & l5;
        knowledge = 1;
        final int i4 = 4;
        long l7 = 4L;
        knowledge = 0;
        if (l6 != l4) {
            if (obj.S != null) {
                knowledge = obj.S.getKnowledge();
                String shortDescription = obj.S.getShortDescription();
            } else {
            }
            int r16 = knowledge >= i4 ? 1 : knowledge;
            if (l6 != l4) {
                l = knowledge != 0 ? l | l2 : l | l7;
            }
        } else {
        }
        long l8 = 4L & l;
        if (l8 == l4 || obj.S == null) {
        } else {
            notRatedByUser = obj.S.isNotRatedByUser();
        }
        long l9 = l & 3L;
        if (l9 != l4) {
            if (knowledge == 0) {
            }
            if (l9 != l4) {
                int r12 = notRatedByUser ? 32 : 16;
                l = l | (notRatedByUser ? 32 : 16);
            }
            int r10 = notRatedByUser ? R.color.transparent : R.color.specialty_brown;
        }
        l &= l5;
        if (obj.U != l4) {
            int i2 = 21;
            if (ViewDataBinding.t() >= 21) {
                obj.O.setImageTintList(b.a(knowledge));
            }
            ProgramBindingAdapters.setProgressText(obj.O, obj.S, obj.Q);
            obj.P.setActiveSegmentPosition(knowledge);
            ProgramBindingAdapters.n0(obj.P, obj.S, i4);
            g.c(obj.R, charSequence);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q7
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private r7(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[3], (SegmentedProgressBar)objectArr[2], (TextView)objectArr[4], (TextView)objectArr[1]);
        this.U = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.T = obj6;
        obj6.setTag(obj5);
        this.P.setTag(obj5);
        this.R.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
