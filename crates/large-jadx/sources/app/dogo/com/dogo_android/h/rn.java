package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengePagerCardItem;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class rn extends app.dogo.com.dogo_android.h.qn {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout U;
    private final TextView V;
    private long W;
    static {
    }

    public rn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, rn.X, rn.Y));
    }

    private rn(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (CardView)object3Arr3[1], (TextView)object3Arr3[6], (ImageView)object3Arr3[3], (TextView)object3Arr3[4], (TextView)object3Arr3[5]);
        this.W = -1;
        int i7 = 0;
        this.O.setTag(i7);
        this.P.setTag(i7);
        this.Q.setTag(i7);
        this.R.setTag(i7);
        this.S.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        obj11 = object3Arr3[2];
        this.V = (TextView)obj11;
        obj11.setTag(i7);
        N(view2);
        A();
    }

    private boolean W(ChallengePagerCardItem challengePagerCardItem, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.W = l7 |= i21;
            return obj5;
            synchronized (this) {
                this.W = l7 |= i21;
                return obj5;
            }
        }
        if (i2 == 77) {
            this.W = l6 |= i20;
            return obj5;
            synchronized (this) {
                this.W = l6 |= i20;
                return obj5;
            }
        }
        if (i2 == 157) {
            this.W = l5 |= i19;
            return obj5;
            synchronized (this) {
                this.W = l5 |= i19;
                return obj5;
            }
        }
        if (i2 == 159) {
            this.W = l4 |= i18;
            return obj5;
            synchronized (this) {
                this.W = l4 |= i18;
                return obj5;
            }
        }
        if (i2 == 87) {
            this.W = l3 |= i17;
            return obj5;
            synchronized (this) {
                this.W = l3 |= i17;
                return obj5;
            }
        }
        if (i2 == 115) {
            this.W = l2 |= i16;
            return obj5;
            synchronized (this) {
                this.W = l2 |= i16;
                return obj5;
            }
        }
        if (i2 == 62) {
            this.W = l |= i15;
            return obj5;
            synchronized (this) {
                this.W = l |= i15;
                return obj5;
            }
        }
        try {
            return 0;
        } catch (Throwable th) {
        }
    }

    @Override // app.dogo.com.dogo_android.h.qn
    public void A() {
        this.W = 128;
        I();
        return;
        synchronized (this) {
            this.W = 128;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qn
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((ChallengePagerCardItem)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qn
    public boolean O(int i, Object object2) {
        int obj2;
        if (110 == i) {
            V((ChallengePagerCardItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qn
    public void V(ChallengePagerCardItem challengePagerCardItem) {
        R(0, challengePagerCardItem);
        this.T = challengePagerCardItem;
        this.W = l |= i3;
        notifyPropertyChanged(110);
        super.I();
        return;
        synchronized (this) {
            R(0, challengePagerCardItem);
            this.T = challengePagerCardItem;
            this.W = l |= i3;
            notifyPropertyChanged(110);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qn
    protected void m() {
        int i6;
        int cmp;
        int cmp3;
        long l;
        int i15;
        int i14;
        int cmp6;
        int cmp4;
        int cmp5;
        int imageUrl;
        int i;
        int i17;
        int i4;
        int i3;
        int i2;
        String string;
        int i11;
        int i16;
        int i12;
        int description;
        int i9;
        int i7;
        int name;
        int timeLeft;
        int i13;
        int cmp2;
        int timeVisible;
        int i8;
        int i5;
        int i10;
        final Object obj = this;
        l = obj.W;
        i14 = 0;
        obj.W = i14;
        ChallengePagerCardItem challengePagerCardItem = obj.T;
        final int i37 = 193;
        final int i40 = 131;
        timeLeft = 0;
        i13 = 0;
        synchronized (this) {
            obj = this;
            l = obj.W;
            i14 = 0;
            obj.W = i14;
            challengePagerCardItem = obj.T;
            i37 = 193;
            i40 = 131;
            timeLeft = 0;
            i13 = 0;
        }
        if (Long.compare(i41, i14) != 0 && challengePagerCardItem != null) {
            if (challengePagerCardItem != null) {
                try {
                    imageUrl = challengePagerCardItem.getImageUrl();
                    imageUrl = timeLeft;
                    int cmp12 = Long.compare(i42, i14);
                    if (challengePagerCardItem != null) {
                    } else {
                    }
                    timeVisible = challengePagerCardItem.getHasEnded();
                    timeVisible = i13;
                }
                string = timeLeft;
                i2 = i3;
                if (Long.compare(i38, i14) != 0 && challengePagerCardItem != null) {
                    if (challengePagerCardItem != null) {
                        description = challengePagerCardItem.getDescription();
                    } else {
                        description = timeLeft;
                    }
                } else {
                }
                if (Long.compare(i43, i14) != 0 && challengePagerCardItem != null) {
                    if (challengePagerCardItem != null) {
                        name = challengePagerCardItem.getName();
                    } else {
                        name = timeLeft;
                    }
                } else {
                }
                int cmp13 = Long.compare(i10, i14);
                if (cmp13 != 0) {
                    if (challengePagerCardItem != null) {
                        timeVisible = challengePagerCardItem.isTimeVisible();
                    } else {
                        timeVisible = i13;
                    }
                    if (cmp13 != 0) {
                        i10 = timeVisible ? 32768 : 16384;
                        l |= i10;
                    }
                    if (timeVisible) {
                    } else {
                        i13 = 8;
                    }
                }
                if (Long.compare(i5, i14) != 0 && challengePagerCardItem != null) {
                    if (challengePagerCardItem != null) {
                        timeLeft = challengePagerCardItem.getTimeLeft();
                    }
                }
                i16 = i3;
                i6 = name;
                i12 = i13;
                i4 = i17;
                i = timeLeft;
                if (Long.compare(i39, i14) != 0) {
                    obj.O.setCardBackgroundColor(i2);
                    g.c(obj.R, string);
                    obj.R.setTextColor(i4);
                    obj.S.setTextColor(i16);
                }
                int i34 = 0;
                if (Long.compare(i23, i34) != 0) {
                    g.c(obj.P, description);
                }
                if (Long.compare(i25, i34) != 0) {
                    m.o(obj.Q, imageUrl);
                }
                if (Long.compare(i27, i34) != 0) {
                    g.c(obj.S, i6);
                }
                if (Long.compare(i29, i34) != 0) {
                    g.c(obj.V, i);
                }
                if (Long.compare(i18, i34) != 0) {
                    obj.V.setVisibility(i12);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.qn
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
