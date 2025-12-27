package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellPottyOverviewNewReminderBindingImpl.java */
/* loaded from: classes.dex */
public class v3 extends u3 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private final MaterialCardView O;
    private long P;
    static {
        obj.put(2131361904, 1);
        obj.put(2131361905, 2);
        obj.put(2131361940, 3);
    }

    public v3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, v3.Q, v3.R));
    }

    @Override // app.dogo.com.dogo_android.h.u3
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u3
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

    @Override // app.dogo.com.dogo_android.h.u3
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

    private v3(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[1], (TextView)objectArr[2], (AppCompatImageView)objectArr[3]);
        this.P = -1L;
        Object obj4 = objectArr[0];
        this.O = obj4;
        obj4.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.u3
    public boolean O(int i, Object object) {
        return true;
    }
}
