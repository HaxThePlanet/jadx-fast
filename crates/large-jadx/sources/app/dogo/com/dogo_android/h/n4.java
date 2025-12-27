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

/* compiled from: CellProgramExamReadyCardBindingImpl.java */
/* loaded from: classes.dex */
public class n4 extends m4 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362413, 4);
        obj.put(2131363295, 5);
    }

    public n4(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, n4.U, n4.V));
    }

    @Override // app.dogo.com.dogo_android.h.m4
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m4
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

    @Override // app.dogo.com.dogo_android.h.m4
    public void V(ProgramExam programExam) {
        this.R = programExam;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m4
    protected void m() {
        long l;
        String trickImageUrl;
        int cmp2 = 8;
        Boolean hasNewUpdates = null;
        String name;
        Object obj;
        int i2;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 3L;
        long l5 = l & l4;
        cmp2 = 0;
        int i = 0;
        if (l5 != l3) {
            if (this.R != null) {
                hasNewUpdates = this.R.getHasNewUpdates();
                name = this.R.getName();
                trickImageUrl = this.R.getTrickImageUrl();
            } else {
            }
            boolean z = ViewDataBinding.K(hasNewUpdates);
            if (l5 != l3) {
                int r11 = z ? 8 : 4;
                l = l | (z ? 8 : 4);
            }
            if (!(z)) {
                cmp2 = 8;
            }
        } else {
        }
        l &= l4;
        if (this.T != l3) {
            app.dogo.com.dogo_android.util.binding.m.o(this.O, trickImageUrl);
            g.c(this.P, obj);
            this.Q.setVisibility(cmp2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m4
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private n4(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[1], (TextView)objectArr[2], (TextView)objectArr[4], (ImageView)objectArr[3], (ImageView)objectArr[5]);
        this.T = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        Object obj7 = objectArr[0];
        this.S = obj7;
        obj7.setTag(obj6);
        this.Q.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m4
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
