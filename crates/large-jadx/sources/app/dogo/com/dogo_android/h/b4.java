package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class b4 extends app.dogo.com.dogo_android.h.a4 {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final Group X;
    private long Y;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b4.a0 = sparseIntArray;
        sparseIntArray.put(2131363387, 9);
        sparseIntArray.put(2131363418, 10);
    }

    public b4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, b4.Z, b4.a0));
    }

    private b4(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        super(e, view2, 0, (ConstraintLayout)object3Arr3[2], (ImageView)object3Arr3[3], (CardView)object3Arr3[0], (ImageView)object3Arr3[1], (TextView)object3Arr3[4], (TextView)object3Arr3[5], (TextView)object3Arr3[6], (TextView)object3Arr3[9], (Guideline)object3Arr3[10], (TextView)object3Arr3[7]);
        obj24.Y = -1;
        int i13 = 0;
        obj24.O.setTag(i13);
        obj24.P.setTag(i13);
        Object obj12 = object3Arr3[8];
        obj24.X = (Group)obj12;
        obj12.setTag(i13);
        obj24.Q.setTag(i13);
        obj24.R.setTag(i13);
        obj24.S.setTag(i13);
        obj24.T.setTag(i13);
        obj24.U.setTag(i13);
        obj24.V.setTag(i13);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a4
    public void A() {
        this.Y = 2;
        I();
        return;
        synchronized (this) {
            this.Y = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.a4
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

    @Override // app.dogo.com.dogo_android.h.a4
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.W = programDescriptionItem;
        this.Y = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.W = programDescriptionItem;
            this.Y = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a4
    protected void m() {
        Object programDescriptionItem;
        long l;
        int cmp;
        int i16;
        int i7;
        int i15;
        int string;
        int i6;
        int i;
        int i13;
        int i14;
        int special;
        int i12;
        int i9;
        int iconUrl;
        int numberOfSkills;
        int i4;
        int i11;
        int programState;
        Integer valueOf;
        int cardBackgroundColor;
        int name;
        int modulesCount;
        int i2;
        int i3;
        int i8;
        int i10;
        int i5;
        final Object obj = this;
        l = obj.Y;
        int i18 = 0;
        obj.Y = i18;
        programDescriptionItem = obj.W;
        int i21 = 3;
        int cmp4 = Long.compare(i22, i18);
        i12 = 0;
        i9 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i18 = 0;
            obj.Y = i18;
            programDescriptionItem = obj.W;
            i21 = 3;
            cmp4 = Long.compare(i22, i18);
            i12 = 0;
            i9 = 0;
        }
        if (programDescriptionItem != null) {
            special = programDescriptionItem.isSpecial();
            iconUrl = programDescriptionItem.getIconUrl();
            numberOfSkills = programDescriptionItem.getNumberOfSkills();
            programState = programDescriptionItem.getProgramState();
            cardBackgroundColor = programDescriptionItem.getCardBackgroundColor();
            name = programDescriptionItem.getName();
            modulesCount = programDescriptionItem.getModulesCount();
        } else {
            try {
                name = cardBackgroundColor;
                modulesCount = numberOfSkills;
                if (cmp4 != 0) {
                }
                if (special != 0) {
                } else {
                }
                i3 = 8;
                i3 = 4;
                l |= i3;
            }
            i14 = 4;
            int i20 = 1;
            Object[] arr2 = new Object[i20];
            arr2[i9] = Integer.valueOf(numberOfSkills);
            i16 = programState == ProgramDescriptionItem.State.COMPLETED ? i20 : i9;
            i6 = programState == ProgramDescriptionItem.State.NOT_STARTED ? i20 : i9;
            Object[] arr = new Object[i20];
            arr[i9] = Integer.valueOf(modulesCount);
            string = obj.V.getResources().getString(2131887581, arr);
            i4 = 3;
            i2 = 0;
            if (Long.compare(i10, i2) != 0) {
                i8 = i16 != 0 ? 128 : 64;
                l |= i8;
            }
            if (Long.compare(i5, i2) != 0) {
                i4 = i6 != 0 ? 32 : 16;
                l |= i4;
            }
            i13 = 8;
            i7 = i16 != 0 ? i9 : i13;
            if (i6 != 0) {
                i9 = i13;
            }
            i = i7;
            i15 = string2;
            i12 = cardBackgroundColor;
            i11 = 3;
            if (Long.compare(i17, i24) != 0) {
                obj.O.setVisibility(i9);
                obj.P.setVisibility(i);
                obj.X.setVisibility(i14);
                n.E(obj.Q, i12);
                n.w(obj.R, iconUrl);
                l.Y(obj.S, programDescriptionItem);
                g.c(obj.T, name);
                g.c(obj.U, i15);
                g.c(obj.V, string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.a4
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
