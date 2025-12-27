package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* compiled from: LayoutWorkoutStreaksJustCurrentBindingImpl.java */
/* loaded from: classes.dex */
public class nn extends mn {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final FrameLayout Q;
    private long R;
    static {
        obj.put(2131362260, 2);
        obj.put(2131362262, 3);
    }

    public nn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, nn.S, nn.T));
    }

    @Override // app.dogo.com.dogo_android.h.mn
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mn
    public boolean O(int i, Object object) {
        boolean z = true;
        if (57 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.mn
    public void T(Integer integer) {
        this.P = integer;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(57);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mn
    protected void m() {
        Object obj = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.R = l;
            } catch (Throwable th) {
            }
        }
        int i3 = 0;
        long l2 = 3L;
        long l4 = this.R & l2;
        if (l4 != l) {
            int i2 = 1;
            Object[] arr2 = new Object[i2];
            int i4 = 0;
            arr2[i4] = this.P;
            int i = 2131755018;
            this.O.getResources().getQuantityString(i, this.P.intValue(), arr2);
            Object[] arr = new Object[i2];
            arr[i4] = this.P;
            String quantityString = this.O.getResources().getQuantityString(i, this.P.intValue(), arr);
        }
        if (l4 != l) {
            g.c(this.O, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mn
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

    private nn(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (ImageView)objectArr[2], (TextView)objectArr[3]);
        this.R = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.Q = obj5;
        obj5.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mn
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
