package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutSpecialProgramExerciseBaseBindingImpl.java */
/* loaded from: classes.dex */
public class rm extends qm {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    public rm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, rm.V, rm.W));
    }

    @Override // app.dogo.com.dogo_android.h.qm
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qm
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.qm
    public void T(TrickItem trickItem) {
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

    @Override // app.dogo.com.dogo_android.h.qm
    protected void m() {
        long l;
        boolean mastered = false;
        int i2 = 2131231108;
        int knowledge = 0;
        android.graphics.drawable.Drawable drawable = null;
        String imageUrl;
        String name;
        Object obj;
        int i4;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 3L;
        long l5 = l & l4;
        knowledge = 0;
        int i3 = 0;
        if (l5 != l3) {
            if (this.S != null) {
            } else {
            }
            if (l5 != l3) {
                int r12 = mastered ? 8 : 4;
                l = l | (mastered ? 8 : 4);
            }
            int r8 = mastered ? R.drawable.ic_green_check : R.drawable.arrow_right_green;
        } else {
        }
        l &= l4;
        if (this.U != l3) {
            this.O.setImageDrawable(drawable);
            this.P.setActiveSegmentPosition(knowledge);
            int i = 4;
            ProgramBindingAdapters.n0(this.P, this.S, i);
            BindingAdapters.n0(this.Q, imageUrl);
            g.c(this.R, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qm
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

    private rm(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[4], (SegmentedProgressBar)objectArr[3], (AppCompatImageView)objectArr[1], (TextView)objectArr[2]);
        this.U = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.T = obj6;
        obj6.setTag(obj5);
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        this.R.setTag(obj5);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.qm
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
