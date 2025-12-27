package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutChallengeCommentDeleteReportBindingImpl.java */
/* loaded from: classes.dex */
public class bi extends ai {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131363059, 1);
        obj.put(2131362292, 2);
        obj.put(2131361935, 3);
    }

    public bi(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, bi.S, bi.T));
    }

    @Override // app.dogo.com.dogo_android.h.ai
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ai
    protected void m() {
        synchronized (this) {
            try {
                this.R = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ai
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

    private bi(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[3], (TextView)objectArr[2], (TextView)objectArr[1]);
        this.R = -1L;
        Object obj4 = objectArr[0];
        this.Q = obj4;
        obj4.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ai
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ai
    public boolean O(int i, Object object) {
        return true;
    }
}
