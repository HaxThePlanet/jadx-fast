package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;

/* compiled from: CellProgramLessonIntroductionBindingImpl.java */
/* loaded from: classes.dex */
public class d5 extends c5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final FrameLayout R;
    private long S;
    public d5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, d5.T, d5.U));
    }

    @Override // app.dogo.com.dogo_android.h.c5
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c5
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

    @Override // app.dogo.com.dogo_android.h.c5
    public void V(LessonIntroduction lessonIntroduction) {
        this.Q = lessonIntroduction;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c5
    protected void m() {
        Object obj = null;
        Object obj2;
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
            g.c(this.O, obj);
            g.c(this.P, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c5
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

    private d5(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (TextView)objectArr[1]);
        this.S = -1L;
        Object obj3 = null;
        this.O.setTag(obj3);
        Object obj4 = objectArr[0];
        this.R = obj4;
        obj4.setTag(obj3);
        this.P.setTag(obj3);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.c5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
