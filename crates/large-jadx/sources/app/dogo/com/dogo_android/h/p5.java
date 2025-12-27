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
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: CellProgramOverviewExamApprovedGridItemBindingImpl.java */
/* loaded from: classes.dex */
public class p5 extends o5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131363485, 3);
        obj.put(2131363294, 4);
    }

    public p5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, p5.T, p5.U));
    }

    @Override // app.dogo.com.dogo_android.h.o5
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o5
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

    @Override // app.dogo.com.dogo_android.h.o5
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

    @Override // app.dogo.com.dogo_android.h.o5
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
            app.dogo.com.dogo_android.util.binding.m.p(this.O, trickImageUrl);
            g.c(this.P, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o5
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

    private p5(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[4], (ImageView)objectArr[1], (ConstraintLayout)objectArr[3], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj5 = objectArr[0];
        this.R = obj5;
        final Object obj6 = null;
        obj5.setTag(obj6);
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
