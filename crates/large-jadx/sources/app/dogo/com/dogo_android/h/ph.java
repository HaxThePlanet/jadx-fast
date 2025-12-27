package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutBecomePremiumBannerBindingImpl.java */
/* loaded from: classes.dex */
public class ph extends oh {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private long Q;
    static {
        obj.put(2131362536, 1);
        obj.put(2131362342, 2);
        obj.put(2131363364, 3);
        obj.put(2131362979, 4);
    }

    public ph(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, ph.R, ph.S));
    }

    @Override // app.dogo.com.dogo_android.h.oh
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.oh
    protected void m() {
        synchronized (this) {
            try {
                this.Q = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.oh
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Q != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private ph(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (ImageView)objectArr[2], (MaterialCardView)objectArr[1], (ImageView)objectArr[4], (TextView)objectArr[3]);
        this.Q = -1L;
        this.O.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.oh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.oh
    public boolean O(int i, Object object) {
        return true;
    }
}
