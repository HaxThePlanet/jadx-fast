package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellChallengeDogSelectRowBindingImpl.java */
/* loaded from: classes.dex */
public class r0 extends q0 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131362980, 1);
        obj.put(2131362982, 2);
        obj.put(2131362388, 3);
        obj.put(2131362157, 4);
    }

    public r0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, r0.T, r0.U));
    }

    @Override // app.dogo.com.dogo_android.h.q0
    public void A() {
        synchronized (this) {
            try {
                this.S = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q0
    protected void m() {
        synchronized (this) {
            try {
                this.S = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.q0
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

    private r0(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[4], (ImageView)objectArr[3], (ImageView)objectArr[1], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj5 = objectArr[0];
        this.R = obj5;
        obj5.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q0
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.q0
    public boolean O(int i, Object object) {
        return true;
    }
}
