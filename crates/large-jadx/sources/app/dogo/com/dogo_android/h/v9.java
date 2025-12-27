package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.p.b.d;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogTiktokInviteBindingImpl.java */
/* loaded from: classes.dex */
public class v9 extends u9 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final FrameLayout S;
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131363421, 2);
        obj.put(2131363532, 3);
        obj.put(2131362105, 4);
        obj.put(2131363530, 5);
        obj.put(2131362526, 6);
    }

    public v9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, v9.V, v9.W));
    }

    @Override // app.dogo.com.dogo_android.h.u9
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u9
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.u9
    public void V(d dVar) {
        this.R = dVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u9
    protected void m() {
        String tiktokFollowVideo = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.U & 3L;
        if (l2 != l3 && this.R != null) {
            tiktokFollowVideo = this.R.tiktokFollowVideo();
        }
        if (l2 != l3) {
            BindingAdapters.p0(this.T, this.Q, tiktokFollowVideo);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u9
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

    private v9(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (FrameLayout)objectArr[4], (FrameLayout)objectArr[6], (TextView)objectArr[2], (ImageView)objectArr[5], (VideoView)objectArr[3]);
        this.U = -1L;
        Object obj7 = objectArr[0];
        this.S = obj7;
        Object obj6 = null;
        obj7.setTag(obj6);
        Object obj8 = objectArr[1];
        this.T = obj8;
        obj8.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u9
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
