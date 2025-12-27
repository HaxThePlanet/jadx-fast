package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: DialogChallengeShareBindingImpl.java */
/* loaded from: classes.dex */
public class t8 extends s8 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final FrameLayout R;
    private long S;
    static {
        obj.put(2131363421, 1);
        obj.put(2131362611, 2);
        obj.put(2131362673, 3);
        obj.put(2131362927, 4);
        obj.put(2131362105, 5);
    }

    public t8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, t8.T, t8.U));
    }

    @Override // app.dogo.com.dogo_android.h.s8
    public void A() {
        synchronized (this) {
            try {
                this.S = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s8
    protected void m() {
        synchronized (this) {
            try {
                this.S = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.s8
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

    private t8(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Button)objectArr[5], (ImageView)objectArr[2], (RelativeLayout)objectArr[3], (RelativeLayout)objectArr[4], (TextView)objectArr[1]);
        this.S = -1L;
        Object obj6 = objectArr[0];
        this.R = obj6;
        obj6.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s8
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.s8
    public boolean O(int i, Object object) {
        return true;
    }
}
