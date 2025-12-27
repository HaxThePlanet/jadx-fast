package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.c.i;

/* compiled from: FragmentRecordVideoBindingImpl.java */
/* loaded from: classes.dex */
public class jg extends ig {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private final ConstraintLayout O;
    private long P;
    static {
        obj.put(2131363547, 1);
        obj.put(2131362931, 2);
        obj.put(2131362110, 3);
    }

    public jg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, jg.Q, jg.R));
    }

    @Override // app.dogo.com.dogo_android.h.ig
    public void A() {
        synchronized (this) {
            try {
                this.P = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ig
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ig
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

    @Override // app.dogo.com.dogo_android.h.ig
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

    private jg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageButton)objectArr[3], (View)objectArr[2], (SurfaceView)objectArr[1]);
        this.P = -1L;
        Object obj4 = objectArr[0];
        this.O = obj4;
        obj4.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ig
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ig
    public void V(i iVar) {
    }
}
