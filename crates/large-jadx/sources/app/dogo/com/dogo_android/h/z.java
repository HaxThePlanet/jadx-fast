package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellBitingTrickVariationBindingImpl.java */
/* loaded from: classes.dex */
public class z extends y {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final MaterialCardView Q;
    private long R;
    static {
        obj.put(2131362619, 2);
        obj.put(2131361940, 3);
    }

    public z(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, z.S, z.T));
    }

    @Override // app.dogo.com.dogo_android.h.y
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.y
    public void V(TrickItem trickItem) {
        this.P = trickItem;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y
    protected void m() {
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.R & 3L;
        if (l2 != l3 && this.P != null) {
            String shortDescription = this.P.getShortDescription();
        }
        if (l2 != l3) {
            g.c(this.O, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.y
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

    private z(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[3], (AppCompatImageView)objectArr[2], (TextView)objectArr[1]);
        this.R = -1L;
        Object obj4 = objectArr[0];
        this.Q = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
