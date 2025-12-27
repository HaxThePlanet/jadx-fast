package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellProgramOverviewExamItemBindingImpl.java */
/* loaded from: classes.dex */
public class r5 extends q5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131363421, 2);
        obj.put(2131363306, 3);
        obj.put(2131362619, 4);
        obj.put(2131362180, 5);
    }

    public r5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, r5.T, r5.U));
    }

    @Override // app.dogo.com.dogo_android.h.q5
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q5
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

    @Override // app.dogo.com.dogo_android.h.q5
    public void V(ProgramLesson programLesson) {
        this.Q = programLesson;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.q5
    protected void m() {
        java.util.List moduleExams = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.S & 3L;
        if (l2 != l3 && this.Q != null) {
            moduleExams = this.Q.getModuleExams();
        }
        if (l2 != l3) {
            ProgramBindingAdapters.setupVariationUnlockedList(this.P, moduleExams);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q5
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

    private r5(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (View)objectArr[5], (RecyclerView)objectArr[1], (ImageView)objectArr[4], (TextView)objectArr[3], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj6 = null;
        this.P.setTag(obj6);
        Object obj7 = objectArr[0];
        this.R = obj7;
        obj7.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
