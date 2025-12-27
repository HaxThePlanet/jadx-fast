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
import androidx.databinding.k.g;

/* compiled from: CellTrickNumberBubbleBindingImpl.java */
/* loaded from: classes.dex */
public class v7 extends u7 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362633, 2);
        obj.put(2131363364, 3);
    }

    public v7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, v7.S, v7.T));
    }

    @Override // app.dogo.com.dogo_android.h.u7
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u7
    public boolean O(int i, Object object) {
        boolean z = true;
        if (167 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.u7
    public void V(String str) {
        this.P = str;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(167);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u7
    protected void m() {
        Object obj = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.R = l;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l3 = this.R & 3L;
        if (l3 != l) {
            StringBuilder stringBuilder = new StringBuilder();
            char c = '+';
            str2 = c + this.P;
        }
        if (l3 != l) {
            g.c(this.O, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u7
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

    private v7(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[2], (TextView)objectArr[1], (TextView)objectArr[3]);
        this.R = -1L;
        Object obj4 = objectArr[0];
        this.Q = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
