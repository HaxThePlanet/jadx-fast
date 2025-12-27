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
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* compiled from: CellProgramLessonLockedItemBindingImpl.java */
/* loaded from: classes.dex */
public class h5 extends g5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131362585, 3);
    }

    public h5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, h5.T, h5.U));
    }

    @Override // app.dogo.com.dogo_android.h.g5
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g5
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

    @Override // app.dogo.com.dogo_android.h.g5
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

    @Override // app.dogo.com.dogo_android.h.g5
    protected void m() {
        int i = 0;
        long l;
        int i2 = 2131887596;
        Object obj2 = null;
        int itemNumber = 0;
        java.lang.CharSequence charSequence = null;
        boolean recap;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.S = l4;
            } catch (Throwable th) {
            }
        }
        final long l5 = 3L;
        long l6 = l & l5;
        long l7 = 4L;
        itemNumber = 0;
        if (l6 != l4) {
            if (obj.Q != null) {
                recap = obj.Q.isRecap();
                itemNumber = obj.Q.getItemNumber();
            } else {
            }
            if (l6 != l4 && recap) {
                long l2 = 8L;
                l = l | l2;
            }
            int i3 = 2131887585;
            Object[] arr = new Object[1];
            String string2 = obj.P.getResources().getString(i3, new Object[] { Integer.valueOf(itemNumber) });
        } else {
            int i4 = 0;
        }
        long l8 = 4L & l;
        if (l8 == l4 || obj.Q == null) {
            i = 0;
        } else {
            String description = obj.Q.getDescription();
        }
        l &= l5;
        if (obj.S != l4) {
            if (itemNumber != 0) {
                i2 = 2131887596;
                String string = obj.O.getResources().getString(i2);
            }
        } else {
            int i6 = 0;
        }
        if (obj.S != l4) {
            g.c(obj.O, charSequence);
            g.c(obj.P, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g5
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

    private h5(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (Guideline)objectArr[3], (TextView)objectArr[1]);
        this.S = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.R = obj5;
        obj5.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.g5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
