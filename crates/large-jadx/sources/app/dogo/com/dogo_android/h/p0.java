package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.model.ChallengeDetailsTabModel;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: CellChallengeDetailsTabBindingImpl.java */
/* loaded from: classes.dex */
public class p0 extends o0 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final LinearLayout R;
    private long S;
    static {
        obj.put(2131363419, 3);
        obj.put(2131362474, 4);
        obj.put(2131362473, 5);
        obj.put(2131362471, 6);
    }

    public p0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, p0.T, p0.U));
    }

    @Override // app.dogo.com.dogo_android.h.o0
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o0
    public boolean O(int i, Object object) {
        boolean z = true;
        if (110 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.o0
    public void T(ChallengeDetailsTabModel challengeDetailsTabModel) {
        this.Q = challengeDetailsTabModel;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(110);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.o0
    protected void m() {
        Object obj;
        java.util.List bulletPointList2;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 3L & l;
        final Void obj2 = null;
        if (l4 == l3 || this.Q == null) {
        } else {
        }
        if (l4 != l3) {
            g.c(this.O, obj);
            app.dogo.com.dogo_android.util.binding.m.h(this.R, bulletPointList2);
        }
        long l2 = l & 2L;
        if (this.S != l3) {
            app.dogo.com.dogo_android.util.binding.m.g(this.P, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o0
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private p0(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (LinearLayout)objectArr[6], (ImageView)objectArr[5], (ImageView)objectArr[4], (TextView)objectArr[1], (LinearLayout)objectArr[0], (RelativeLayout)objectArr[3]);
        this.S = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        this.P.setTag(obj7);
        Object obj8 = objectArr[2];
        this.R = obj8;
        obj8.setTag(obj7);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o0
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
