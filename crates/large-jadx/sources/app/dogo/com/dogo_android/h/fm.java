package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutProgramModuleProgressBarBindingImpl.java */
/* loaded from: classes.dex */
public class fm extends em {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    public fm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, fm.T, fm.U));
    }

    @Override // app.dogo.com.dogo_android.h.em
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.em
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

    @Override // app.dogo.com.dogo_android.h.em
    public void T(ModuleCompletionSummary moduleCompletionSummary) {
        this.Q = moduleCompletionSummary;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.em
    protected void m() {
        boolean z = false;
        int moduleNumber;
        Object obj = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.S = l;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = 3L;
        long l4 = this.S & l2;
        moduleNumber = 0;
        if (l4 != l) {
            if (this.Q != null) {
                moduleNumber = this.Q.getModuleNumber();
                boolean currentModule = this.Q.isCurrentModule();
            } else {
            }
            Object[] arr = new Object[1];
            String string = this.P.getResources().getString(2131887141, new Object[] { Integer.valueOf(moduleNumber) });
        }
        if (l4 != l) {
            ProgramBindingAdapters.setMarginsForDashboardCard(this.O, this.Q);
            ProgramBindingAdapters.V(this.P, Boolean.valueOf(z));
            g.c(this.P, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.em
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

    private fm(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ProgressBar)objectArr[2], (TextView)objectArr[1]);
        this.S = -1L;
        Object obj3 = objectArr[0];
        this.R = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.em
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
