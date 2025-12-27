package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: FragmentExamExplanationBindingImpl.java */
/* loaded from: classes.dex */
public class vc extends uc {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362557, 1);
        obj.put(2131362105, 2);
        obj.put(2131362711, 3);
        obj.put(2131363156, 4);
        obj.put(2131362632, 5);
        obj.put(2131363314, 6);
        obj.put(2131363414, 7);
        obj.put(2131363159, 8);
        obj.put(2131362714, 9);
    }

    public vc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 10, vc.S, vc.T));
    }

    @Override // app.dogo.com.dogo_android.h.uc
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.uc
    protected void m() {
        synchronized (this) {
            try {
                this.R = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.uc
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private vc(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (TextView)objectArr[2], (Button)objectArr[1], (ImageView)objectArr[5], (ImageView)objectArr[3], (Guideline)objectArr[9], (ImageView)objectArr[4], (Guideline)objectArr[8], (TextView)objectArr[6], (TextView)objectArr[7]);
        eVar3.R = -1L;
        Object obj10 = objectArr[0];
        eVar3.Q = obj10;
        obj10.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uc
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.uc
    public boolean O(int i, Object object) {
        return true;
    }
}
