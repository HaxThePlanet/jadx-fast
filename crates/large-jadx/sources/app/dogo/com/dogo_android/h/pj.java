package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.y;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* compiled from: LayoutDashboardResubscribeBindingImpl.java */
/* loaded from: classes.dex */
public class pj extends oj implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final CardView R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        obj.put(2131363414, 3);
        obj.put(2131362298, 4);
        obj.put(2131362572, 5);
        obj.put(2131362574, 6);
        obj.put(2131362575, 7);
        obj.put(2131362577, 8);
        obj.put(2131362578, 9);
        obj.put(2131362478, 10);
    }

    public pj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, pj.V, pj.W));
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public boolean O(int i, Object object) {
        boolean z = true;
        if (29 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public void T(o oVar) {
        this.Q = oVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.Q != null) {
            }
            if (i2 != 0) {
                this.Q.onClosePressed();
            }
        } else {
            int i3 = 2;
            if (this.Q == 2) {
                if (this.Q != null) {
                }
                if (i2 != 0) {
                    this.Q.a0();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.oj
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.U & 2L;
        if (l2 != l3) {
            this.O.setOnClickListener(this.S);
            this.P.setOnClickListener(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private pj(e eVar, View view, Object[] objectArr) {
        final Object eVar4 = this;
        final int i14 = 1;
        super(eVar, view, 0, (ImageView)objectArr[i14], (TextView)objectArr[4], (TextView)objectArr[10], (ImageView)objectArr[5], (TextView)objectArr[6], (TextView)objectArr[7], (TextView)objectArr[8], (TextView)objectArr[9], (MaterialButton)objectArr[2], (TextView)obj);
        eVar4.U = -1L;
        Object obj12 = null;
        eVar4.O.setTag(obj12);
        Object obj11 = objectArr[0];
        eVar4.R = obj11;
        obj11.setTag(obj12);
        eVar4.P.setTag(obj12);
        eVar4.N(view);
        eVar4.S = new b(eVar4, i14);
        eVar4.T = new b(eVar4, 2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.oj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
