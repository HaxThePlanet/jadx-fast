package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.y.l;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellPottyOverviewReminderBindingImpl.java */
/* loaded from: classes.dex */
public class x3 extends w3 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final MaterialCardView S;
    private long T;
    static {
        obj.put(2131363050, 3);
    }

    public x3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, x3.U, x3.V));
    }

    @Override // app.dogo.com.dogo_android.h.w3
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.w3
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

    @Override // app.dogo.com.dogo_android.h.w3
    public void V(PottyRemindersItem pottyRemindersItem) {
        this.R = pottyRemindersItem;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.w3
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.T & 3L;
        if (l2 != l3) {
            ProgramBindingAdapters.i0(this.O, this.R);
            ProgramBindingAdapters.h0(this.Q, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.w3
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private x3(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (SwitchCompat)objectArr[3], (TextView)objectArr[2]);
        this.T = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.S = obj5;
        obj5.setTag(obj4);
        this.Q.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
