package app.dogo.com.dogo_android.h;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.d;
import androidx.databinding.k.g;

/* compiled from: LayoutLibraryShortcutBindingImpl.java */
/* loaded from: classes.dex */
public class dl extends cl {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final View U;
    private long V;
    static {
        obj.put(2131362626, 4);
    }

    public dl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, dl.W, dl.X));
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public boolean O(int i, Object object) {
        int i2 = 142;
        boolean z = true;
        i2 = 80;
        if (80 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 142;
            if (142 == i) {
                U(object);
            } else {
                i2 = 152;
                if (152 == i) {
                    V(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void T(Drawable drawable) {
        this.S = drawable;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(80);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void U(Boolean boolean) {
        this.Q = boolean;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(142);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void V(String str) {
        this.R = str;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(152);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cl
    protected void m() {
        long l;
        int i = 0;
        int i2 = 16;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        final long l5 = 10L;
        long l6 = l & l5;
        i = 0;
        if (l6 != l3 && l6 != l3) {
            int r11 = z ? 32 : 16;
            l = l | (z ? 32 : 16);
            if (!(z)) {
            }
        }
        long l7 = 12L & l;
        if (l7 != l3) {
            g.c(this.O, this.R);
        }
        long l4 = l & 10L;
        if (this.O != l3) {
            this.U.setVisibility(i);
        }
        l &= 9;
        if (this.V != l3) {
            d.a(this.P, this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private dl(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (ImageView)objectArr[4], (AppCompatImageView)objectArr[1]);
        this.V = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.T = obj5;
        obj5.setTag(obj4);
        Object obj6 = objectArr[3];
        this.U = obj6;
        obj6.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cl
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
