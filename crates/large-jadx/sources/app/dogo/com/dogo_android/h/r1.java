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
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle;
import app.dogo.com.dogo_android.u.n.p.e;

/* loaded from: classes.dex */
public class r1 extends app.dogo.com.dogo_android.h.q1 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r1.W = sparseIntArray;
        sparseIntArray.put(2131363345, 4);
    }

    public r1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, r1.V, r1.W));
    }

    private r1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (FrameLayout)object3Arr3[1], (TextView)object3Arr3[2], (TextView)object3Arr3[4], (TextView)object3Arr3[3]);
        this.U = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        this.R.setTag(i6);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q1
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.q1
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((DogLog)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.q1
    public void V(DogLog dogLog) {
        this.S = dogLog;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.S = dogLog;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q1
    protected void m() {
        int cmp;
        Long valueOf;
        int eventTimeMs;
        int style;
        int nameRes;
        eventTimeMs = 0;
        this.U = eventTimeMs;
        final DogLog dogLog = this.S;
        style = 0;
        nameRes = 0;
        cmp = Long.compare(i, eventTimeMs);
        synchronized (this) {
            eventTimeMs = 0;
            this.U = eventTimeMs;
            dogLog = this.S;
            style = 0;
            nameRes = 0;
            cmp = Long.compare(i, eventTimeMs);
        }
        try {
            if (dogLog != null) {
            }
            style = dogLog.getStyle();
            eventTimeMs = dogLog.getEventTimeMs();
            if (style != 0) {
            }
            nameRes = style.getNameRes();
            if (cmp != 0) {
            }
            e.l(this.O, dogLog, this.Q);
            this.P.setText(nameRes);
            e.q(this.R, Long.valueOf(eventTimeMs));
        }
    }

    @Override // app.dogo.com.dogo_android.h.q1
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
