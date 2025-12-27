package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutInviteFriendsBannerBindingImpl.java */
/* loaded from: classes.dex */
public class vk extends uk {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private long P;
    static {
        obj.put(2131362536, 1);
        obj.put(2131363371, 2);
        obj.put(2131362342, 3);
    }

    public vk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, vk.Q, vk.R));
    }

    @Override // app.dogo.com.dogo_android.h.uk
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.uk
    protected void m() {
        synchronized (this) {
            try {
                this.P = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.uk
    public boolean y() {
        synchronized (this) {
            try {
                if (this.P != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private vk(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[3], (MaterialCardView)objectArr[1], (ConstraintLayout)objectArr[0], (TextView)objectArr[2]);
        this.P = -1L;
        this.O.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uk
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.uk
    public boolean O(int i, Object object) {
        return true;
    }
}
