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
public class d3 extends app.dogo.com.dogo_android.h.c3 {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0;
    private final Group Y;
    private long Z;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d3.b0 = sparseIntArray;
        sparseIntArray.put(2131363387, 10);
        sparseIntArray.put(2131363418, 11);
    }

    public d3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, d3.a0, d3.b0));
    }

    private d3(e e, View view2, Object[] object3Arr3) {
        final Object obj26 = this;
        super(e, view2, 0, (ConstraintLayout)object3Arr3[2], (ImageView)object3Arr3[3], (TextView)object3Arr3[8], (CardView)object3Arr3[0], (ImageView)object3Arr3[1], (TextView)object3Arr3[4], (TextView)object3Arr3[5], (TextView)object3Arr3[6], (TextView)object3Arr3[10], (Guideline)object3Arr3[11], (TextView)object3Arr3[7]);
        obj26.Z = -1;
        int i14 = 0;
        obj26.O.setTag(i14);
        obj26.P.setTag(i14);
        obj26.Q.setTag(i14);
        Object obj13 = object3Arr3[9];
        obj26.Y = (Group)obj13;
        obj13.setTag(i14);
        obj26.R.setTag(i14);
        obj26.S.setTag(i14);
        obj26.T.setTag(i14);
        obj26.U.setTag(i14);
        obj26.V.setTag(i14);
        obj26.W.setTag(i14);
        obj26.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c3
    public void A() {
        this.Z = 2;
        I();
        return;
        synchronized (this) {
            this.Z = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            W((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c3
    public void W(ProgramDescriptionItem programDescriptionItem) {
        this.X = programDescriptionItem;
        this.Z = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.X = programDescriptionItem;
            this.Z = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c3
    protected void m() {
        Object programDescriptionItem;
        long l;
        int cmp2;
        int i9;
        int cmp;
        int string;
        int i17;
        int i16;
        int i14;
        int i;
        int i2;
        int special;
        int i18;
        int i10;
        int iconUrl;
        int i8;
        int numberOfSkills;
        int i6;
        int i15;
        int programState;
        int i11;
        int i13;
        int cardBackgroundColor;
        int name;
        int modulesCount;
        int i5;
        int i4;
        int i3;
        int i19;
        int i7;
        int i12;
        final Object obj = this;
        l = obj.Z;
        int i21 = 0;
        obj.Z = i21;
        programDescriptionItem = obj.X;
        int i22 = 3;
        int cmp6 = Long.compare(i23, i21);
        int i25 = 0;
        i18 = 1;
        i10 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Z;
            i21 = 0;
            obj.Z = i21;
            programDescriptionItem = obj.X;
            i22 = 3;
            cmp6 = Long.compare(i23, i21);
            i25 = 0;
            i18 = 1;
            i10 = 0;
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
                if (cmp6 != 0) {
                }
                if (special != 0) {
                } else {
                }
                i5 = 128;
                i5 = 64;
                l |= i5;
                Object[] arr = new Object[i18];
                arr[i10] = Integer.valueOf(numberOfSkills);
            }
            cmp = i18;
            i14 = programState == ProgramDescriptionItem.State.COMPLETED ? i18 : i10;
            i = programState == ProgramDescriptionItem.State.NOT_STARTED ? i18 : i10;
            Object[] arr2 = new Object[i18];
            arr2[i10] = Integer.valueOf(modulesCount);
            string = obj.W.getResources().getString(2131887581, arr2);
            i6 = 3;
            i4 = 0;
            if (Long.compare(i19, i4) != 0) {
                i19 = cmp != 0 ? 8192 : 4096;
                l |= i19;
            }
            if (Long.compare(i3, i4) != 0) {
                i3 = i14 != 0 ? 512 : 256;
                l |= i3;
            }
            if (Long.compare(i7, i4) != 0) {
                i6 = i != 0 ? 2048 : 1024;
                l |= i6;
            }
            i17 = cmp != 0 ? i10 : 8;
            i16 = i14 != 0 ? i10 : 8;
            i8 = string2;
            i15 = cardBackgroundColor;
            i9 = name;
            i11 = 3;
            int cmp7 = Long.compare(i12, i13);
            if (cmp7 != 0) {
                special = special != 0 ? i18 : cmp;
                if (i != 0) {
                } else {
                    i18 = cmp;
                }
                if (cmp7 != 0) {
                    i13 = special != 0 ? 32 : 16;
                    l |= i13;
                }
                if (Long.compare(i12, i13) != 0) {
                    i13 = i18 != 0 ? 8 : 4;
                    l |= i13;
                }
                i2 = special != 0 ? 8 : i10;
                if (i18 != 0) {
                    i10 = cmp;
                }
            } else {
                i2 = i10;
            }
            if (Long.compare(i20, i27) != 0) {
                obj.O.setVisibility(i10);
                obj.P.setVisibility(i16);
                obj.Q.setVisibility(i17);
                obj.Y.setVisibility(i2);
                n.E(obj.R, i15);
                n.w(obj.S, iconUrl);
                l.Y(obj.T, programDescriptionItem);
                g.c(obj.U, i9);
                g.c(obj.V, i8);
                g.c(obj.W, string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.c3
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
