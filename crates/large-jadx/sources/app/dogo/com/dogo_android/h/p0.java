package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.model.ChallengeDetailsTabModel;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class p0 extends app.dogo.com.dogo_android.h.o0 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final LinearLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0.U = sparseIntArray;
        sparseIntArray.put(2131363419, 3);
        sparseIntArray.put(2131362474, 4);
        sparseIntArray.put(2131362473, 5);
        sparseIntArray.put(2131362471, 6);
    }

    public p0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, p0.T, p0.U));
    }

    private p0(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (LinearLayout)object3Arr3[6], (ImageView)object3Arr3[5], (ImageView)object3Arr3[4], (TextView)object3Arr3[1], (LinearLayout)object3Arr3[0], (RelativeLayout)object3Arr3[3]);
        this.S = -1;
        int i8 = 0;
        this.O.setTag(i8);
        this.P.setTag(i8);
        Object obj12 = object3Arr3[2];
        this.R = (LinearLayout)obj12;
        obj12.setTag(i8);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o0
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o0
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o0
    public boolean O(int i, Object object2) {
        int obj2;
        if (110 == i) {
            T((ChallengeDetailsTabModel)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.o0
    public void T(ChallengeDetailsTabModel challengeDetailsTabModel) {
        this.Q = challengeDetailsTabModel;
        this.S = l |= i2;
        notifyPropertyChanged(110);
        super.I();
        return;
        synchronized (this) {
            this.Q = challengeDetailsTabModel;
            this.S = l |= i2;
            notifyPropertyChanged(110);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o0
    protected void m() {
        int cmp;
        int title;
        int cmp2;
        int bulletPointList;
        long l = this.S;
        final int i2 = 0;
        this.S = i2;
        ChallengeDetailsTabModel challengeDetailsTabModel = this.Q;
        cmp2 = Long.compare(i5, i2);
        final int i6 = 0;
        synchronized (this) {
            l = this.S;
            i2 = 0;
            this.S = i2;
            challengeDetailsTabModel = this.Q;
            cmp2 = Long.compare(i5, i2);
            i6 = 0;
        }
        try {
            if (challengeDetailsTabModel != null) {
            } else {
            }
            bulletPointList = challengeDetailsTabModel.bulletPointList;
            title = challengeDetailsTabModel.title;
            bulletPointList = title;
            if (cmp2 != 0) {
            }
            g.c(this.O, title);
            m.h(this.R, bulletPointList);
            if (Long.compare(i, i2) != 0) {
            }
            m.g(this.P, i6);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o0
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
