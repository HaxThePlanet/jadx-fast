package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class x0 extends app.dogo.com.dogo_android.h.w0 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
    }

    public x0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, x0.T, x0.U));
    }

    private x0(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (Button)object3Arr3[2], (TextView)object3Arr3[1]);
        this.S = -1;
        int i4 = 0;
        this.O.setTag(i4);
        Object obj8 = object3Arr3[0];
        this.R = (ConstraintLayout)obj8;
        obj8.setTag(i4);
        this.P.setTag(i4);
        N(view2);
        A();
    }

    private boolean W(ChallengeFeedEndObservable challengeFeedEndObservable, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.S = l5 |= i15;
            return obj5;
            synchronized (this) {
                this.S = l5 |= i15;
                return obj5;
            }
        }
        if (i2 == 18) {
            this.S = l4 |= i14;
            return obj5;
            synchronized (this) {
                this.S = l4 |= i14;
                return obj5;
            }
        }
        if (i2 == 16) {
            this.S = l |= i11;
            return obj5;
            synchronized (this) {
                this.S = l |= i11;
                return obj5;
            }
        }
        if (i2 == 108) {
            this.S = l2 |= i12;
            return obj5;
            synchronized (this) {
                this.S = l2 |= i12;
                return obj5;
            }
        }
        if (i2 == 26) {
            this.S = l3 |= i13;
            return obj5;
            synchronized (this) {
                this.S = l3 |= i13;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w0
    public void A() {
        this.S = 32;
        I();
        return;
        synchronized (this) {
            this.S = 32;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w0
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((ChallengeFeedEndObservable)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.w0
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((ChallengeFeedEndObservable)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w0
    public void V(ChallengeFeedEndObservable challengeFeedEndObservable) {
        R(0, challengeFeedEndObservable);
        this.Q = challengeFeedEndObservable;
        this.S = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, challengeFeedEndObservable);
            this.Q = challengeFeedEndObservable;
            this.S = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w0
    protected void m() {
        int i3;
        int cmp4;
        int cmp2;
        long l;
        int i;
        int i2;
        int cmp;
        int cmp3;
        int backgroundDrawable;
        int messageText;
        boolean buttonVisible;
        int backgroundColor;
        int cmp5;
        int i4;
        final Object obj = this;
        l = obj.S;
        final int i6 = 0;
        obj.S = i6;
        ChallengeFeedEndObservable challengeFeedEndObservable = obj.Q;
        int i9 = 37;
        final int i11 = 41;
        int i12 = 35;
        int i14 = 49;
        backgroundDrawable = 0;
        synchronized (this) {
            obj = this;
            l = obj.S;
            i6 = 0;
            obj.S = i6;
            challengeFeedEndObservable = obj.Q;
            i9 = 37;
            i11 = 41;
            i12 = 35;
            i14 = 49;
            backgroundDrawable = 0;
        }
        int cmp7 = Long.compare(buttonVisible, i6);
        if (cmp7 != 0) {
            if (challengeFeedEndObservable != null) {
                try {
                    buttonVisible = challengeFeedEndObservable.isButtonVisible();
                    buttonVisible = backgroundDrawable;
                    if (cmp7 != 0) {
                    }
                    if (buttonVisible) {
                    } else {
                    }
                    backgroundColor = 128;
                    backgroundColor = 64;
                    l |= backgroundColor;
                }
                if (buttonVisible) {
                    i2 = backgroundDrawable;
                } else {
                    i2 = 8;
                }
            } else {
            }
        } else {
        }
        if (Long.compare(i16, i6) != 0 && challengeFeedEndObservable != null) {
            if (challengeFeedEndObservable != null) {
                messageText = challengeFeedEndObservable.getMessageText();
            } else {
                messageText = backgroundDrawable;
            }
        } else {
        }
        if (Long.compare(i17, i6) != 0 && challengeFeedEndObservable != null) {
            if (challengeFeedEndObservable != null) {
                backgroundColor = challengeFeedEndObservable.getBackgroundColor();
            } else {
                backgroundColor = backgroundDrawable;
            }
        } else {
        }
        if (Long.compare(i18, i6) != 0 && challengeFeedEndObservable != null) {
            if (challengeFeedEndObservable != null) {
                backgroundDrawable = challengeFeedEndObservable.getBackgroundDrawable();
            }
        }
        i3 = backgroundDrawable;
        i4 = messageText;
        backgroundDrawable = i2;
        i = backgroundColor;
        if (Long.compare(i15, i6) != 0) {
            obj.O.setVisibility(backgroundDrawable);
        }
        if (Long.compare(i13, i6) != 0) {
            m.r(obj.R, i3);
        }
        if (Long.compare(i10, i6) != 0) {
            n.C(obj.R, i);
        }
        if (Long.compare(i5, i6) != 0) {
            obj.P.setText(i4);
        }
    }

    @Override // app.dogo.com.dogo_android.h.w0
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
