package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.n.o.a;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutPottyOverviewRemindersBindingImpl.java */
/* loaded from: classes.dex */
public class xl extends wl {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131363207, 2);
        obj.put(2131362301, 3);
    }

    public xl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, xl.T, xl.U));
    }

    @Override // app.dogo.com.dogo_android.h.wl
    public void A() {
        synchronized (this) {
            try {
                this.S = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wl
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

    @Override // app.dogo.com.dogo_android.h.wl
    public void V(o.a aVar) {
        this.Q = aVar;
        synchronized (this) {
            try {
                this.S |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wl
    public void W(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.P = specialProgramOverviewItem;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wl
    protected void m() {
        java.util.List reminders = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.S & 7L;
        if (l2 != l3 && this.P != null) {
            reminders = this.P.getReminders();
        }
        if (l2 != l3) {
            ProgramBindingAdapters.cleanHtmlTagsAndFindHighlightIndex(this.O, reminders, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wl
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

    private xl(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[3], (RecyclerView)objectArr[1], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj4 = objectArr[0];
        this.R = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wl
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
