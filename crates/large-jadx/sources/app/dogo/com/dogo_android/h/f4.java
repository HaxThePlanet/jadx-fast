package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* compiled from: CellProgramExamAvailableHeaderBindingImpl.java */
/* loaded from: classes.dex */
public class f4 extends e4 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131363421, 2);
    }

    public f4(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, f4.S, f4.T));
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public void A() {
        synchronized (this) {
            try {
                this.R = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public boolean O(int i, Object object) {
        int i2 = 91;
        boolean z = true;
        i2 = 91;
        if (91 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 94;
            if (94 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public void V(Boolean boolean) {
        this.P = boolean;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(91);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.e4
    protected void m() {
        long l;
        Resources resources;
        int i = 2131886484;
        Object obj = null;
        int cmp2 = 8;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i2 = 0;
        final long l4 = 5L;
        long l5 = l & l4;
        if (l5 != l3 && l5 != l3) {
            int r8 = z ? 16 : 8;
            l = l | (z ? 16 : 8);
            if (z) {
                resources = this.O.getResources();
                i = 2131886484;
            } else {
                resources = this.O.getResources();
                i = 2131886655;
            }
        }
        l &= l4;
        if (this.R != l3) {
            g.c(this.O, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private f4(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (TextView)objectArr[2]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e4
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public void W(ProgramExam programExam) {
    }
}
