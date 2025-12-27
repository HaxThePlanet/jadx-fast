package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellProgramLessonHeaderCardBindingImpl.java */
/* loaded from: classes.dex */
public class z4 extends y4 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private long T;
    static {
        obj.put(2131362547, 4);
        obj.put(2131362548, 5);
        obj.put(2131362549, 6);
    }

    public z4(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, z4.U, z4.V));
    }

    @Override // app.dogo.com.dogo_android.h.y4
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y4
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

    @Override // app.dogo.com.dogo_android.h.y4
    public void V(LessonCardItem lessonCardItem) {
        this.S = lessonCardItem;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y4
    protected void m() {
        long l;
        int cmp2;
        LessonCardItem.CardStatus status = null;
        Object obj2 = null;
        int moduleNumber = 0;
        String programName;
        final Object obj = this;
        synchronized (this) {
            try {
                long l2 = 0L;
                obj.T = l2;
            } catch (Throwable th) {
            }
        }
        final long l4 = 3L;
        long l5 = l & l4;
        moduleNumber = 0;
        if (l5 != l2 && obj.S != null) {
            int i2 = 2131887594;
            moduleNumber = 1;
            Object[] arr = new Object[moduleNumber];
            arr[moduleNumber] = Integer.valueOf(moduleNumber);
            String string = obj.R.getResources().getString(i2, arr);
            if (status != LessonCardItem_CardStatus.COMPLETED) {
            }
            if (l5 != l2) {
                int r8 = moduleNumber != 0 ? 8 : 4;
                l = l | (moduleNumber != 0 ? 8 : 4);
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str = " - ";
            str2 = string + str;
            if (moduleNumber == 0) {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            str3 = str2 + programName;
        }
        l &= l4;
        if (obj.T != 0) {
            obj.P.setVisibility(moduleNumber);
            ProgramBindingAdapters.setupPottyOverview(obj.Q, obj.S);
            g.c(obj.R, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.y4
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

    private z4(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (TextView)objectArr[4], (ImageView)objectArr[5], (View)objectArr[6], (ImageView)objectArr[3], (TextView)objectArr[2], (TextView)objectArr[1]);
        this.T = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.P.setTag(obj8);
        this.Q.setTag(obj8);
        this.R.setTag(obj8);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y4
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
