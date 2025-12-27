package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* compiled from: TooltipWorkoutTrickBindingImpl.java */
/* loaded from: classes.dex */
public class zn extends yn {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362298, 2);
        obj.put(2131362093, 3);
    }

    public zn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, zn.S, zn.T));
    }

    @Override // app.dogo.com.dogo_android.h.yn
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yn
    protected void m() {
        synchronized (this) {
            try {
                long l = 0L;
                this.R = l;
            } catch (Throwable th) {
            }
        }
        long l2 = 1L;
        long l4 = this.R & l2;
        if (l4 != l) {
            int i3 = 2;
            Object[] arr = new Object[i3];
            arr[0] = Integer.valueOf(i3);
            int i = 1;
            arr[i] = Integer.valueOf(i3);
            g.c(this.P, this.P.getResources().getString(2131887701, arr));
        }
    }

    @Override // app.dogo.com.dogo_android.h.yn
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

    private zn(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (MaterialButton)objectArr[3], (TextView)objectArr[2], (TextView)objectArr[1]);
        this.R = -1L;
        Object obj4 = objectArr[0];
        this.Q = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yn
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.yn
    public boolean O(int i, Object object) {
        return true;
    }
}
