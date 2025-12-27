package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle;

/* compiled from: CellDogLogSelectionBindingImpl.java */
/* loaded from: classes.dex */
public class r1 extends q1 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131363345, 4);
    }

    public r1(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, r1.V, r1.W));
    }

    @Override // app.dogo.com.dogo_android.h.q1
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q1
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

    @Override // app.dogo.com.dogo_android.h.q1
    public void V(DogLog dogLog) {
        this.S = dogLog;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.q1
    protected void m() {
        long eventTimeMs = 0;
        int i = 0;
        int nameRes = 0;
        synchronized (this) {
            try {
                eventTimeMs = 0L;
                this.U = eventTimeMs;
            } catch (Throwable th) {
            }
        }
        i = 0;
        nameRes = 0;
        long l2 = this.U & 3L;
        if (l2 != eventTimeMs && this.S != null) {
            DogLog.LogStyle style = this.S.getStyle();
            eventTimeMs = this.S.getEventTimeMs();
            if (i != 0) {
                nameRes = i.getNameRes();
            }
        }
        if (l2 != eventTimeMs) {
            CalendarBindingAdapters.l(this.O, this.S, this.Q);
            this.P.setText(nameRes);
            CalendarBindingAdapters.q(this.R, Long.valueOf(eventTimeMs));
        }
    }

    @Override // app.dogo.com.dogo_android.h.q1
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

    private r1(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (FrameLayout)objectArr[1], (TextView)objectArr[2], (TextView)objectArr[4], (TextView)objectArr[3]);
        this.U = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.T = obj6;
        obj6.setTag(obj5);
        this.P.setTag(obj5);
        this.R.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
