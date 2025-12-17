package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class t6 extends app.dogo.com.dogo_android.h.s6 {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t6.Y = sparseIntArray;
        sparseIntArray.put(2131362986, 6);
        sparseIntArray.put(2131362355, 7);
        sparseIntArray.put(2131363036, 8);
        sparseIntArray.put(2131363387, 9);
        sparseIntArray.put(2131363149, 10);
        sparseIntArray.put(2131362511, 11);
        sparseIntArray.put(2131362335, 12);
        sparseIntArray.put(2131363202, 13);
    }

    public t6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 14, t6.X, t6.Y));
    }

    private t6(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 0, (TextView)object3Arr3[12], (ImageView)object3Arr3[7], (ImageView)object3Arr3[11], (CardView)object3Arr3[1], (CardView)object3Arr3[6], (ImageView)object3Arr3[2], (TextView)object3Arr3[3], (TextView)object3Arr3[8], (Button)object3Arr3[10], (ImageView)object3Arr3[13], (TextView)object3Arr3[4], (TextView)object3Arr3[9], (TextView)object3Arr3[5]);
        Object obj4 = this;
        obj4.W = -1;
        Object obj2 = object3Arr3[0];
        obj4.V = (ConstraintLayout)obj2;
        int i3 = 0;
        obj2.setTag(i3);
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.S.setTag(i3);
        obj4.T.setTag(i3);
        obj4.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s6
    public void A() {
        this.W = 2;
        I();
        return;
        synchronized (this) {
            this.W = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s6
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.s6
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.U = programDescriptionItem;
        this.W = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.U = programDescriptionItem;
            this.W = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s6
    protected void m() {
        int cmp;
        int iconUrl;
        int i2;
        int string;
        int numberOfSkills;
        int i3;
        int modulesCount;
        int cardBackgroundColor;
        int name;
        Resources resources;
        int i;
        Object[] arr;
        Object[] arr2;
        int i5 = 0;
        this.W = i5;
        ProgramDescriptionItem programDescriptionItem = this.U;
        cmp = Long.compare(i4, i5);
        iconUrl = 0;
        synchronized (this) {
            i5 = 0;
            this.W = i5;
            programDescriptionItem = this.U;
            cmp = Long.compare(i4, i5);
            iconUrl = 0;
        }
        try {
            int i6 = 0;
            if (programDescriptionItem != null) {
            } else {
            }
            iconUrl = programDescriptionItem.getIconUrl();
            numberOfSkills = programDescriptionItem.getNumberOfSkills();
            cardBackgroundColor = programDescriptionItem.getCardBackgroundColor();
            name = programDescriptionItem.getName();
            modulesCount = programDescriptionItem.getModulesCount();
            name = cardBackgroundColor;
            modulesCount = numberOfSkills;
            int i8 = 1;
            arr2 = new Object[i8];
            arr2[i6] = Integer.valueOf(numberOfSkills);
            string = this.S.getResources().getString(2131887593, arr2);
            arr = new Object[i8];
            arr[i6] = Integer.valueOf(modulesCount);
            i3 = string2;
            i2 = iconUrl;
            iconUrl = cardBackgroundColor;
            name = i3;
            if (cmp != 0) {
            }
            n.E(this.O, iconUrl);
            n.w(this.P, i2);
            g.c(this.Q, name);
            g.c(this.S, string);
            g.c(this.T, i3);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s6
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
