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
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellProgramOverviewExamLockedGridItemBindingImpl.java */
/* loaded from: classes.dex */
public class t5 extends s5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131362749, 3);
    }

    public t5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, t5.T, t5.U));
    }

    @Override // app.dogo.com.dogo_android.h.s5
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s5
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

    @Override // app.dogo.com.dogo_android.h.s5
    public void V(ProgramExam programExam) {
        this.Q = programExam;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s5
    protected void m() {
        String trickImageUrl = null;
        Object obj;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.S & 3L;
        if (l2 == l3 || this.Q == null) {
        } else {
        }
        if (l2 != l3) {
            BindingAdapters.U(this.O, trickImageUrl);
            g.c(this.P, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s5
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private t5(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[3], (ImageView)objectArr[1], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj4 = objectArr[0];
        this.R = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
