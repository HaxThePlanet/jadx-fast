package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutCustomerBenefitsBindingImpl.java */
/* loaded from: classes.dex */
public class ji extends ii {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private final ConstraintLayout O;
    private long P;
    static {
        obj.put(2131362542, 1);
        obj.put(2131362975, 2);
        obj.put(2131362022, 3);
        obj.put(2131362019, 4);
        obj.put(2131362021, 5);
        obj.put(2131362018, 6);
        obj.put(2131362030, 7);
        obj.put(2131362028, 8);
        obj.put(2131362025, 9);
        obj.put(2131362027, 10);
        obj.put(2131362024, 11);
        obj.put(2131362035, 12);
        obj.put(2131362032, 13);
        obj.put(2131362034, 14);
        obj.put(2131362031, 15);
        obj.put(2131362041, 16);
        obj.put(2131362040, 17);
        obj.put(2131362038, 18);
        obj.put(2131362039, 19);
        obj.put(2131362037, 20);
        obj.put(2131362045, 21);
        obj.put(2131362043, 22);
        obj.put(2131362044, 23);
        obj.put(2131362042, 24);
        obj.put(2131362050, 25);
        obj.put(2131362049, 26);
        obj.put(2131362047, 27);
        obj.put(2131362048, 28);
        obj.put(2131362046, 29);
    }

    public ji(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 30, ji.Q, ji.R));
    }

    @Override // app.dogo.com.dogo_android.h.ii
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ii
    protected void m() {
        synchronized (this) {
            try {
                this.P = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ii
    public boolean y() {
        synchronized (this) {
            try {
                if (this.P != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private ji(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[6], (TextView)objectArr[4], (TextView)objectArr[5], (TextView)objectArr[3], (ImageView)objectArr[11], (TextView)objectArr[9], (ImageView)objectArr[10], (TextView)objectArr[8], (ConstraintLayout)objectArr[7], (ImageView)objectArr[15], (TextView)objectArr[13], (ImageView)objectArr[14], (TextView)objectArr[12], (ImageView)objectArr[20], (ImageView)objectArr[18], (ImageView)objectArr[19], (TextView)objectArr[17], (ConstraintLayout)objectArr[16], (ImageView)objectArr[24], (ImageView)objectArr[22], (ImageView)objectArr[23], (TextView)objectArr[21], (ImageView)objectArr[29], (ImageView)objectArr[27], (ImageView)objectArr[28], (TextView)objectArr[26], (ConstraintLayout)objectArr[25], (TextView)objectArr[1], (TextView)objectArr[2]);
        Object eVar3 = this;
        eVar3.P = -1L;
        Object obj = objectArr[0];
        eVar3.O = obj;
        obj.setTag(null);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ii
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ii
    public boolean O(int i, Object object) {
        return true;
    }
}
