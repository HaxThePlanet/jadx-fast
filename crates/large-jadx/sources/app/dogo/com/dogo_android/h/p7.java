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
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellSpecialProgramLockedVariationsBindingImpl.java */
/* loaded from: classes.dex */
public class p7 extends o7 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131363329, 4);
    }

    public p7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, p7.V, p7.W));
    }

    @Override // app.dogo.com.dogo_android.h.o7
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o7
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

    @Override // app.dogo.com.dogo_android.h.o7
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

    @Override // app.dogo.com.dogo_android.h.o7
    protected void m() {
        int knowledge = 0;
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        knowledge = 0;
        int i = 0;
        long l2 = this.U & 3L;
        if (l2 != l3 && this.S != null) {
            knowledge = this.S.getKnowledge();
            String shortDescription = this.S.getShortDescription();
        }
        if (l2 != l3) {
            ProgramBindingAdapters.setProgressText(this.O, this.S, this.Q);
            this.P.setActiveSegmentPosition(knowledge);
            g.c(this.R, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o7
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

    private p7(e eVar, View view, Object[] objectArr) {
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

    @Override // app.dogo.com.dogo_android.h.o7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
