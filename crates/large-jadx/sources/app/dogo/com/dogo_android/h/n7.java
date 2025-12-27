package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.u.l.a;
import app.dogo.com.dogo_android.y.l;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellSpecialProgramExerciseWithVariationsBindingImpl.java */
/* loaded from: classes.dex */
public class n7 extends m7 {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(9);
    private static final SparseIntArray Z = new SparseIntArray();
    private final MaterialCardView V;
    private final ConstraintLayout W;
    private long X;
    static {
        int i5 = 1;
        final int[] iArr = new int[i5];
        final int i10 = 0;
        iArr[i10] = 5;
        int[] iArr2 = new int[i5];
        iArr2[i10] = R.layout.layout_special_program_exercise_base;
        obj.a(i5, new String[] { "layout_special_program_exercise_base" }, iArr, iArr2);
        obj.put(2131363483, 6);
        obj.put(2131363490, 7);
        obj.put(2131363525, 8);
    }

    public n7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, n7.Y, n7.Z));
    }

    private boolean X(qm qmVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.m7
    public void A() {
        synchronized (this) {
            try {
                this.X = 8L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m7
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public void V(l.a aVar) {
        this.U = aVar;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public void W(TrickItemWithVariations trickItemWithVariations) {
        this.T = trickItemWithVariations;
        synchronized (this) {
            try {
                this.X |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m7
    protected void m() {
        int i;
        long l;
        java.util.List variations;
        int i3 = 0;
        TrickItem trickItem = null;
        boolean z = false;
        int cmp3;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l3 = 0L;
                obj.X = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 14L;
        long l5 = l & l4;
        long l6 = 10L;
        i3 = 0;
        i = 0;
        if (l5 != l3) {
            if (obj.T != null) {
                variations = obj.T.getVariations();
            } else {
            }
            long l8 = l & 10L;
            if (l8 != l3) {
                if (obj.T != null) {
                    TrickItem coreTrick = obj.T.getCoreTrick();
                }
                if (i3 != 0) {
                    boolean mastered = i3.isMastered();
                } else {
                }
                if (l8 != l3) {
                    int r14 = obj.T != 0 ? 32 : 16;
                    l = l | (obj.T != 0 ? 32 : 16);
                }
                if (obj.T != 0) {
                    i = 8;
                }
            } else {
            }
        } else {
        }
        long l7 = 10L & l;
        if (l7 != l3) {
            obj.O.T(trickItem);
            ProgramBindingAdapters.T(obj.R, Boolean.valueOf(z));
            obj.S.setVisibility(i);
        }
        l &= l4;
        if (obj.X != l3) {
            ProgramBindingAdapters.F0(obj.P, variations, obj.U);
        }
        ViewDataBinding.o(obj.O);
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.X != 0) {
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

    private n7(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (qm)objectArr[5], (RecyclerView)objectArr[4], (ImageView)objectArr[6], (View)objectArr[7], (ImageView)objectArr[8], (TextView)objectArr[2], (TextView)objectArr[3]);
        this.X = -1L;
        L(this.O);
        Object obj9 = objectArr[0];
        this.V = obj9;
        Object obj8 = null;
        obj9.setTag(obj8);
        Object obj10 = objectArr[1];
        this.W = obj10;
        obj10.setTag(obj8);
        this.P.setTag(obj8);
        this.R.setTag(obj8);
        this.S.setTag(obj8);
        N(view);
        A();
    }
}
