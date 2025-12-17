package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;

/* loaded from: classes.dex */
public class rj extends app.dogo.com.dogo_android.h.qj implements b.a {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final View.OnClickListener S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        rj.V = sparseIntArray;
        sparseIntArray.put(2131362307, 2);
        sparseIntArray.put(2131363414, 3);
        sparseIntArray.put(2131361940, 4);
        sparseIntArray.put(2131362322, 5);
        sparseIntArray.put(2131363364, 6);
    }

    public rj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, rj.U, rj.V));
    }

    private rj(e e, View view2, Object[] object3Arr3) {
        final Object obj16 = this;
        final int i10 = 1;
        super(e, view2, 0, (TextView)object3Arr3[i10], (ImageView)object3Arr3[4], (ImageView)object3Arr3[2], (ImageView)object3Arr3[5], (MaterialCardView)object3Arr3[0], (TextView)object3Arr3[6], (TextView)object3Arr3[3]);
        obj16.T = -1;
        int i8 = 0;
        obj16.O.setTag(i8);
        obj16.P.setTag(i8);
        View view4 = view2;
        N(view2);
        b bVar = new b(this, i10);
        obj16.S = bVar;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public void A() {
        this.T = 4;
        I();
        return;
        synchronized (this) {
            this.T = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((PottyProgramProgress)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public void T(a0 a0) {
        this.R = a0;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = a0;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public void U(PottyProgramProgress pottyProgramProgress) {
        this.Q = pottyProgramProgress;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = pottyProgramProgress;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public final void b(int i, View view2) {
        int i2;
        final a0 obj3 = this.R;
        i2 = obj3 != null ? 1 : 0;
        if (i2 != 0) {
            obj3.F0(this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qj
    protected void m() {
        int cmp;
        View.OnClickListener list;
        PottyProgramProgress pottyProgramProgress;
        int cleanDaysStreak;
        int string;
        Resources resources;
        int i;
        Object[] arr;
        long l = this.T;
        final int i3 = 0;
        this.T = i3;
        pottyProgramProgress = this.Q;
        string = 0;
        int cmp2 = Long.compare(i8, i3);
        synchronized (this) {
            l = this.T;
            i3 = 0;
            this.T = i3;
            pottyProgramProgress = this.Q;
            string = 0;
            cmp2 = Long.compare(i8, i3);
        }
        try {
            int i5 = 0;
            if (pottyProgramProgress != null) {
            } else {
            }
            cleanDaysStreak = pottyProgramProgress.getCleanDaysStreak();
            cleanDaysStreak = i5;
            arr = new Object[2];
            arr[i5] = Integer.valueOf(cleanDaysStreak);
            arr[1] = 14;
            string = this.O.getResources().getString(2131886246, arr);
            if (cmp2 != 0) {
            }
            g.c(this.O, string);
        }
        this.P.setOnClickListener(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.qj
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
