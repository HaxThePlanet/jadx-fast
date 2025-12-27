package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutProgramProgressBarBindingImpl.java */
/* loaded from: classes.dex */
public class lm extends km {

    private static final ViewDataBinding.g Z = new ViewDataBinding$g(9);
    private static final SparseIntArray a0 = null;
    private long Y;
    static {
        String str = "layout_program_module_progress_bar";
        obj.a(0, new String[] { str, str, str, str }, new int[] { 5, 6, 7, 8 }, new int[] { R.layout.layout_program_module_progress_bar, R.layout.layout_program_module_progress_bar, R.layout.layout_program_module_progress_bar, R.layout.layout_program_module_progress_bar });
    }

    public lm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, lm.Z, lm.a0));
    }

    private boolean U(em emVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean V(em emVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(em emVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(em emVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.km
    public void A() {
        synchronized (this) {
            try {
                this.Y = 32L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        this.P.A();
        this.Q.A();
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.km
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return U(object, i2);
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.km
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
        this.P.M(qVar);
        this.Q.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.km
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

    @Override // app.dogo.com.dogo_android.h.km
    public void T(ProgramCompletionSummary programCompletionSummary) {
        this.X = programCompletionSummary;
        synchronized (this) {
            try {
                this.Y |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.km
    protected void m() {
        app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary moduleCompletionSummary;
        int i;
        long l;
        String str;
        app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary moduleCompletionSummary2 = null;
        int i2 = 0;
        java.util.List moduleProgress;
        app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary moduleCompletionSummary3;
        app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary moduleCompletionSummary4;
        int i3 = 4096;
        int i4 = 256;
        long l2;
        int i5 = 64;
        int i6 = 1024;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l6 = 0L;
                obj.Y = l6;
            } catch (Throwable th) {
            }
        }
        final long l7 = 48L;
        long l8 = l & l7;
        i = 0;
        i2 = 0;
        if (l8 != l6) {
            if (obj.X != null) {
                moduleProgress = obj.X.getModuleProgress();
                String programBackgroundColor = obj.X.getProgramBackgroundColor();
            } else {
            }
            i2 = 1;
            if (moduleProgress != null) {
                Object obj2 = ViewDataBinding.v(moduleProgress, 3);
                Object obj4 = ViewDataBinding.v(moduleProgress, i2);
                Object obj5 = ViewDataBinding.v(moduleProgress, 2);
                Object obj3 = ViewDataBinding.v(moduleProgress, i2);
            } else {
            }
            int r15 = i2;
            int r16 = i2;
            int r17 = i2;
            if (i == 0) {
            }
            if (l8 != l6) {
                int r18 = i2 != 0 ? 8192 : 4096;
                l = l | (i2 != 0 ? 8192 : 4096);
            }
            l3 = l & 48L;
            if (l3 != l6) {
                r18 = i2 != 0 ? 2048 : 1024;
                l = l | (i2 != 0 ? 2048 : 1024);
            }
            l4 = l & 48L;
            if (l4 != l6) {
                r18 = i2 != 0 ? 128 : 64;
                l = l | (i2 != 0 ? 128 : 64);
            }
            l2 = l & 48L;
            if (l2 != l6 && i2 != 0) {
                i4 = 512;
                l = l | i4;
            }
            i2 = 8;
            r15 = i2;
            r16 = i2;
            r17 = i2;
            if (i2 == 0) {
            }
        } else {
        }
        l &= l7;
        if (obj.Y != l6) {
            obj.O.w().setVisibility(i2);
            obj.O.T(moduleCompletionSummary2);
            obj.P.w().setVisibility(i2);
            obj.P.T(moduleCompletionSummary3);
            obj.Q.w().setVisibility(i2);
            obj.Q.T(moduleCompletionSummary4);
            obj.R.w().setVisibility(i2);
            obj.R.T(moduleCompletionSummary);
            ProgramBindingAdapters.setHtmlText(obj.S, moduleCompletionSummary2);
            BindingAdapters.j0(obj.S, str);
            ProgramBindingAdapters.setHtmlText(obj.T, moduleCompletionSummary3);
            BindingAdapters.j0(obj.T, str);
            ProgramBindingAdapters.setHtmlText(obj.U, moduleCompletionSummary4);
            BindingAdapters.j0(obj.U, str);
            ProgramBindingAdapters.setHtmlText(obj.V, moduleCompletionSummary);
            BindingAdapters.j0(obj.V, str);
        }
        ViewDataBinding.o(obj.O);
        ViewDataBinding.o(obj.P);
        ViewDataBinding.o(obj.Q);
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.km
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z5 = true;
                if (this.Y != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.O.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        if (this.Q.y()) {
            return true;
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private lm(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 4, (em)objectArr[5], (em)objectArr[6], (em)objectArr[7], (em)objectArr[8], (ImageView)objectArr[1], (ImageView)objectArr[2], (ImageView)objectArr[3], (ImageView)objectArr[4], (ConstraintLayout)objectArr[0]);
        eVar3.Y = -1L;
        L(eVar3.O);
        L(eVar3.P);
        L(eVar3.Q);
        L(eVar3.R);
        Object obj10 = null;
        eVar3.S.setTag(obj10);
        eVar3.T.setTag(obj10);
        eVar3.U.setTag(obj10);
        eVar3.V.setTag(obj10);
        eVar3.W.setTag(obj10);
        N(view);
        A();
    }
}
