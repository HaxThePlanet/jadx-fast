package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
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
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* compiled from: CellProgramLessonActiveItemBindingImpl.java */
/* loaded from: classes.dex */
public class t4 extends s4 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362585, 4);
        obj.put(2131362626, 5);
    }

    public t4(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, t4.U, t4.V));
    }

    @Override // app.dogo.com.dogo_android.h.s4
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s4
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

    @Override // app.dogo.com.dogo_android.h.s4
    public void V(ProgramLesson programLesson) {
        this.R = programLesson;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s4
    protected void m() {
        String description = null;
        long l;
        int i = 2131887596;
        Object obj2 = null;
        int itemNumber;
        Object obj3 = null;
        long l3;
        int i3 = 32;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.T = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 3L;
        long l7 = l & l6;
        final long l9 = 4L;
        itemNumber = 0;
        if (l7 != l5) {
            if (obj.R != null) {
                boolean recap = obj.R.isRecap();
                itemNumber = obj.R.getItemNumber();
                boolean _new = obj.R.isNew();
            } else {
            }
            if (l7 != l5) {
                l = itemNumber != 0 ? l | l2 : l | l9;
            }
            l3 = l & 3L;
            if (l3 != l5 && itemNumber != 0) {
                i3 = 32;
                l = l | i3;
            }
            int i2 = 2131887585;
            Object[] arr = new Object[1];
            String string = obj.Q.getResources().getString(i2, new Object[] { Integer.valueOf(itemNumber) });
            if (itemNumber == 0) {
                itemNumber = 8;
            }
        } else {
            int i6 = 0;
        }
        long l8 = l & 4L;
        if (obj.Q == l5 || obj.R == null) {
            int i4 = 0;
        } else {
            description = obj.R.getDescription();
        }
        l &= 3;
        if (obj.T != l5) {
            if (itemNumber != 0) {
                i = 2131887596;
                description = obj.O.getResources().getString(i);
            }
        } else {
            int i8 = 0;
        }
        if (obj.T != l5) {
            g.c(obj.O, obj3);
            obj.P.setVisibility(itemNumber);
            g.c(obj.Q, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s4
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

    private t4(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (Guideline)objectArr[4], (ImageView)objectArr[3], (ImageView)objectArr[5], (TextView)objectArr[1]);
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

    @Override // app.dogo.com.dogo_android.h.s4
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
