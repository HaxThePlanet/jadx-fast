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

/* compiled from: LayoutWorkoutStreaksWithLongestBindingImpl.java */
/* loaded from: classes.dex */
public class pn extends on {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362261, 3);
        obj.put(2131362260, 4);
        obj.put(2131362262, 5);
        obj.put(2131362322, 6);
        obj.put(2131362756, 7);
        obj.put(2131362755, 8);
    }

    public pn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, pn.U, pn.V));
    }

    @Override // app.dogo.com.dogo_android.h.on
    public void A() {
        synchronized (this) {
            try {
                this.T = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.on
    public boolean O(int i, Object object) {
        int i2 = 57;
        boolean z = true;
        i2 = 57;
        if (57 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 105;
            if (105 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.on
    public void T(Integer integer) {
        this.Q = integer;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(57);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.on
    public void U(Integer integer) {
        this.R = integer;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(105);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.on
    protected void m() {
        Resources resources;
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.T = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 5L & l2;
        final int i3 = 0;
        final int i4 = 1;
        final int i5 = 2131755018;
        if (l4 != l) {
            Object[] arr4 = new Object[i4];
            this.O.getResources().getQuantityString(i5, this.Q.intValue(), new Object[] { num });
            Object[] arr2 = new Object[i4];
            String quantityString = this.O.getResources().getQuantityString(i5, this.Q.intValue(), new Object[] { num });
        } else {
        }
        long l3 = l2 & 6L;
        if (this.T != l) {
            Object[] arr3 = new Object[i4];
            this.P.getResources().getQuantityString(i5, this.R.intValue(), new Object[] { num2 });
            Object[] arr = new Object[i4];
            String quantityString2 = this.P.getResources().getQuantityString(i5, this.R.intValue(), new Object[] { num2 });
        }
        if (l4 != l) {
            g.c(this.O, obj);
        }
        if (this.T != l) {
            g.c(this.P, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.on
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

    private pn(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (TextView)objectArr[1], (ImageView)objectArr[4], (ConstraintLayout)objectArr[3], (TextView)objectArr[5], (View)objectArr[6], (TextView)objectArr[2], (ImageView)objectArr[8], (ConstraintLayout)objectArr[7]);
        eVar3.T = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.S = obj9;
        obj9.setTag(obj10);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.on
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
