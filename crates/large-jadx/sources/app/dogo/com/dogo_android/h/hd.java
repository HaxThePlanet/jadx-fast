package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentFirstExamUnlcokedBindingImpl.java */
/* loaded from: classes.dex */
public class hd extends gd {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0 = new SparseIntArray();
    private long c0;
    static {
        obj.put(2131362193, 5);
        obj.put(2131361872, 6);
        obj.put(2131363456, 7);
        obj.put(2131363314, 8);
        obj.put(2131362510, 9);
        obj.put(2131363201, 10);
        obj.put(2131362530, 11);
        obj.put(2131362496, 12);
        obj.put(2131361927, 13);
        obj.put(2131363037, 14);
        obj.put(2131363534, 15);
        obj.put(2131363154, 16);
    }

    public hd(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 17, hd.d0, hd.e0));
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public void A() {
        synchronized (this) {
            try {
                this.c0 = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public boolean O(int i, Object object) {
        int i2 = 166;
        boolean z = true;
        i2 = 166;
        if (166 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public void V(TrickItem trickItem) {
        this.b0 = trickItem;
        synchronized (this) {
            try {
                this.c0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(166);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gd
    protected void m() {
        int i;
        String str;
        Object obj = null;
        java.lang.CharSequence charSequence;
        synchronized (this) {
            try {
                long l = 0L;
                this.c0 = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 5L & l2;
        i = 0;
        if (l4 != l) {
            if (this.b0 != null) {
            } else {
            }
            int i2 = 2131886568;
            Object[] arr = new Object[1];
            int i3 = 0;
            arr[i3] = i;
        } else {
        }
        if (l4 != l) {
            g.c(this.X, obj);
            BindingAdapters.n0(this.Z, str);
            g.c(this.a0, charSequence);
        }
        long l3 = l2 & 4L;
        if (this.c0 != l) {
            BindingAdapters.z(this.Y, a.d(this.Y.getContext(), 2131231318));
        }
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public boolean y() {
        synchronized (this) {
            try {
                if (this.c0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private hd(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[6], (kotlinx.coroutines.AnimatedTextView)objectArr[13], (ImageView)objectArr[5], (TextView)objectArr[12], (TextView)objectArr[9], (TextView)objectArr[11], (ConstraintLayout)objectArr[0], (CardView)objectArr[14], (ImageView)objectArr[16], (TextView)objectArr[10], (TextView)objectArr[8], (TextView)objectArr[2], (TextView)objectArr[7], (ImageView)objectArr[1], (ImageView)objectArr[3], (TextView)objectArr[15], (TextView)objectArr[4]);
        Object eVar3 = this;
        eVar3.c0 = -1L;
        Object obj = null;
        eVar3.T.setTag(obj);
        eVar3.X.setTag(obj);
        eVar3.Y.setTag(obj);
        eVar3.Z.setTag(obj);
        eVar3.a0.setTag(obj);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gd
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public void W(app.dogo.com.dogo_android.y.r.e eVar) {
    }
}
