package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellProgramTaskCompletedItemBindingImpl.java */
/* loaded from: classes.dex */
public class f6 extends e6 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362160, 2);
    }

    public f6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, f6.S, f6.T));
    }

    @Override // app.dogo.com.dogo_android.h.e6
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e6
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

    @Override // app.dogo.com.dogo_android.h.e6
    public void V(ProgramTasks programTasks) {
        this.P = programTasks;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.e6
    protected void m() {
        String text = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.R & 3L;
        if (l2 != l3 && this.P != null) {
            text = this.P.getText();
        }
        if (l2 != l3) {
            ProgramBindingAdapters.X(this.O, text);
        }
    }

    @Override // app.dogo.com.dogo_android.h.e6
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

    private f6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[2], (TextView)objectArr[1]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
