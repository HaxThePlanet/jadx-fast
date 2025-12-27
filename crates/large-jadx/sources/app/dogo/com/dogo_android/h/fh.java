package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentUnlockHelplineBindingImpl.java */
/* loaded from: classes.dex */
public class fh extends eh {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362193, 1);
        obj.put(2131362229, 2);
        obj.put(2131363414, 3);
        obj.put(2131362298, 4);
        obj.put(2131363454, 5);
        obj.put(2131363310, 6);
    }

    public fh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, fh.S, fh.T));
    }

    @Override // app.dogo.com.dogo_android.h.eh
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.eh
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.R & 1L;
        if (l2 != l3) {
            Boolean bool = null;
            BindingAdapters.k0(this.Q, bool);
        }
    }

    @Override // app.dogo.com.dogo_android.h.eh
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

    private fh(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[1], (ImageView)objectArr[2], (TextView)objectArr[4], (MaterialButton)objectArr[6], (TextView)objectArr[3], (AppCompatImageView)objectArr[5]);
        this.R = -1L;
        Object obj7 = objectArr[0];
        this.Q = obj7;
        obj7.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.eh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.eh
    public boolean O(int i, Object object) {
        return true;
    }
}
