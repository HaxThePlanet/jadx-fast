package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellProgramComingSoonCardBindingImpl.java */
/* loaded from: classes.dex */
public class d4 extends c4 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private long S;
    static {
        obj.put(2131362211, 3);
        obj.put(2131363418, 4);
    }

    public d4(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, d4.T, d4.U));
    }

    @Override // app.dogo.com.dogo_android.h.c4
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c4
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

    @Override // app.dogo.com.dogo_android.h.c4
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c4
    protected void m() {
        String cardBackgroundColor = null;
        String iconUrl;
        Object obj;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.S & 3L;
        if (l2 == l3 || this.R == null) {
        } else {
        }
        if (l2 != l3) {
            BindingAdapters.setRatingChange(this.O, cardBackgroundColor);
            BindingAdapters.w(this.P, iconUrl);
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c4
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

    private d4(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[3], (CardView)objectArr[0], (ImageView)objectArr[1], (TextView)objectArr[2], (Guideline)objectArr[4]);
        this.S = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c4
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
