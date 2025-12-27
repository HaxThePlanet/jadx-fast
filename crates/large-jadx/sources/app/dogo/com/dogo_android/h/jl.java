package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.g;

/* compiled from: LayoutLibrarySubscribeBindingImpl.java */
/* loaded from: classes.dex */
public class jl extends il implements b.a {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final CardView Q;
    private final View.OnClickListener R;
    private final View.OnClickListener S;
    private long T;
    static {
        obj.put(2131361981, 2);
        obj.put(2131363414, 3);
        obj.put(2131362298, 4);
    }

    public jl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, jl.U, jl.V));
    }

    @Override // app.dogo.com.dogo_android.h.il
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.il
    public boolean O(int i, Object object) {
        boolean z = true;
        if (100 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.il
    public void T(g gVar) {
        this.P = gVar;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(100);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.il
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.P != null) {
            }
            if (i2 != 0) {
                this.P.c();
            }
        } else {
            int i3 = 2;
            if (this.P == 2) {
                if (this.P != null) {
                }
                if (i2 != 0) {
                    this.P.c();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.il
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.T & 2L;
        if (l2 != l3) {
            this.Q.setOnClickListener(this.S);
            this.O.setOnClickListener(this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.il
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private jl(e eVar, View view, Object[] objectArr) {
        final int i = 2;
        int i3 = 1;
        super(eVar, view, 0, (ImageView)objectArr[i], (TextView)objectArr[4], (Button)objectArr[i3], (TextView)objectArr[3]);
        this.T = -1L;
        Object obj5 = objectArr[0];
        this.Q = obj5;
        final Object obj6 = null;
        obj5.setTag(obj6);
        this.O.setTag(obj6);
        N(view);
        this.R = new b(this, i);
        this.S = new b(this, i3);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.il
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
