package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellSpecialProgramExerciseBindingImpl.java */
/* loaded from: classes.dex */
public class l7 extends k7 {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(4);
    private static final SparseIntArray V = new SparseIntArray();
    private final MaterialCardView Q;
    private final ConstraintLayout R;
    private final qm S;
    private long T;
    static {
        int i3 = 1;
        final int[] iArr = new int[i3];
        final int i6 = 0;
        iArr[i6] = 2;
        int[] iArr2 = new int[i3];
        iArr2[i6] = R.layout.layout_special_program_exercise_base;
        obj.a(i3, new String[] { "layout_special_program_exercise_base" }, iArr, iArr2);
        obj.put(2131363490, 3);
    }

    public l7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, l7.U, l7.V));
    }

    @Override // app.dogo.com.dogo_android.h.k7
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        this.S.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k7
    public void M(q qVar) {
        super.M(qVar);
        this.S.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.k7
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

    @Override // app.dogo.com.dogo_android.h.k7
    public void V(TrickItem trickItem) {
        this.P = trickItem;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k7
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.T & 3L;
        if (l2 != l3) {
            this.S.T(this.P);
        }
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.k7
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.S.y()) {
            return true;
        }
        return false;
    }

    private l7(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (View)objectArr[3]);
        this.T = -1L;
        Object obj3 = objectArr[i2];
        this.Q = obj3;
        Object obj2 = null;
        obj3.setTag(obj2);
        Object obj4 = objectArr[1];
        this.R = obj4;
        obj4.setTag(obj2);
        Object obj5 = objectArr[2];
        this.S = obj5;
        L(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
