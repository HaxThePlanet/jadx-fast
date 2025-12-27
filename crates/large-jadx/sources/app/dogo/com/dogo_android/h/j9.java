package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogInviteAccaptedBindingImpl.java */
/* loaded from: classes.dex */
public class j9 extends i9 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131363421, 3);
    }

    public j9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, j9.V, j9.W));
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void A() {
        synchronized (this) {
            try {
                this.U = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public boolean O(int i, Object object) {
        int i2 = 14;
        boolean z = true;
        i2 = 89;
        if (89 == i) {
            X(object);
            int i3 = 1;
        } else {
            i2 = 14;
            if (14 == i) {
                V(object);
            } else {
                i2 = 65;
                if (65 == i) {
                    W(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void V(String str) {
        this.S = str;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(14);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void W(String str) {
        this.Q = str;
        synchronized (this) {
            try {
                this.U |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(65);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void X(String str) {
        this.R = str;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(89);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i9
    protected void m() {
        int cmp;
        Object obj = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.U = l;
            } catch (Throwable th) {
            }
        }
        int i4 = 0;
        long l4 = 13L & l2;
        if (l4 != l) {
            int i = 2131886789;
            Object[] arr = new Object[2];
            int i2 = 0;
            arr[i2] = this.Q;
            arr[1] = this.R;
            String string = this.P.getResources().getString(i, arr);
        }
        long l3 = l2 & 10L;
        if (this.U != l) {
            BindingAdapters.m0(this.O, this.S, a.d(this.O.getContext(), 2131231085));
        }
        if (l4 != l) {
            g.c(this.P, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i9
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

    private j9(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[1], (TextView)objectArr[2], (TextView)objectArr[3]);
        this.U = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.T = obj5;
        obj5.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i9
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
