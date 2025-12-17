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

/* loaded from: classes.dex */
public class x3 extends app.dogo.com.dogo_android.h.w3 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final MaterialCardView S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x3.V = sparseIntArray;
        sparseIntArray.put(2131363050, 3);
    }

    public x3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, x3.U, x3.V));
    }

    private x3(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[1], (SwitchCompat)object3Arr3[3], (TextView)object3Arr3[2]);
        this.T = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.S = (MaterialCardView)obj9;
        obj9.setTag(i5);
        this.Q.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w3
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((PottyRemindersItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w3
    public void V(PottyRemindersItem pottyRemindersItem) {
        this.R = pottyRemindersItem;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = pottyRemindersItem;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w3
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.T = i2;
        final PottyRemindersItem pottyRemindersItem = this.R;
        synchronized (this) {
            i2 = 0;
            this.T = i2;
            pottyRemindersItem = this.R;
        }
        try {
            l.i0(this.O, pottyRemindersItem);
            l.h0(this.Q, pottyRemindersItem);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w3
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
