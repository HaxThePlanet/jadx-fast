package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class v6 extends app.dogo.com.dogo_android.h.u6 {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0;
    private final ConstraintLayout Z;
    private long a0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v6.c0 = sparseIntArray;
        sparseIntArray.put(2131362692, 10);
        sparseIntArray.put(2131363418, 11);
        sparseIntArray.put(2131362322, 12);
        sparseIntArray.put(2131362711, 13);
        sparseIntArray.put(2131363414, 14);
        sparseIntArray.put(2131363156, 15);
        sparseIntArray.put(2131363235, 16);
        sparseIntArray.put(2131363386, 17);
        sparseIntArray.put(2131362415, 18);
        sparseIntArray.put(2131363388, 19);
        sparseIntArray.put(2131362397, 20);
    }

    public v6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 21, v6.b0, v6.c0));
    }

    private v6(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 0, (View)object3Arr3[12], (TextView)object3Arr3[9], (ImageView)object3Arr3[20], (TextView)object3Arr3[8], (ImageView)object3Arr3[18], (TextView)object3Arr3[3], (TextView)object3Arr3[10], (LinearLayout)object3Arr3[5], (ImageView)object3Arr3[13], (CardView)object3Arr3[1], (ImageView)object3Arr3[2], (TextView)object3Arr3[4], (Button)object3Arr3[6], (ImageView)object3Arr3[15], (TextView)object3Arr3[7], (ImageView)object3Arr3[16], (View)object3Arr3[17], (View)object3Arr3[19], (TextView)object3Arr3[14], (Guideline)object3Arr3[11]);
        Object obj4 = this;
        obj4.a0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        Object obj2 = object3Arr3[0];
        obj4.Z = (ConstraintLayout)obj2;
        obj2.setTag(i3);
        obj4.S.setTag(i3);
        obj4.T.setTag(i3);
        obj4.U.setTag(i3);
        obj4.V.setTag(i3);
        obj4.W.setTag(i3);
        obj4.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public void A() {
        this.a0 = 4;
        I();
        return;
        synchronized (this) {
            this.a0 = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            if (92 == i) {
                T((Boolean)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public void T(Boolean boolean) {
        this.Y = boolean;
        this.a0 = l |= i2;
        notifyPropertyChanged(92);
        super.I();
        return;
        synchronized (this) {
            this.Y = boolean;
            this.a0 = l |= i2;
            notifyPropertyChanged(92);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.X = programDescriptionItem;
        this.a0 = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.X = programDescriptionItem;
            this.a0 = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u6
    protected void m() {
        int i5;
        int cmp3;
        int name;
        long l;
        String string;
        int i6;
        Boolean bool;
        int cmp;
        String string2;
        int i;
        int cmp2;
        int numberOfExams;
        String i4;
        int numberOfEnrolledUsers;
        int i2;
        int iconUrl;
        Integer valueOf;
        int surveyCompatibility;
        int numberOfSkills;
        int dogSkillsHighlights;
        int cardBackgroundColor;
        int i3;
        final Object obj = this;
        l = obj.a0;
        int i8 = 0;
        obj.a0 = i8;
        ProgramDescriptionItem programDescriptionItem = obj.X;
        i4 = 0;
        i2 = 0;
        synchronized (this) {
            obj = this;
            l = obj.a0;
            i8 = 0;
            obj.a0 = i8;
            programDescriptionItem = obj.X;
            i4 = 0;
            i2 = 0;
        }
        if (programDescriptionItem != null) {
            numberOfExams = programDescriptionItem.getNumberOfExams();
            numberOfEnrolledUsers = programDescriptionItem.getNumberOfEnrolledUsers();
            iconUrl = programDescriptionItem.getIconUrl();
            surveyCompatibility = programDescriptionItem.getSurveyCompatibility();
            numberOfSkills = programDescriptionItem.getNumberOfSkills();
            dogSkillsHighlights = programDescriptionItem.getDogSkillsHighlights();
            cardBackgroundColor = programDescriptionItem.getCardBackgroundColor();
            name = programDescriptionItem.getName();
        } else {
            try {
                cardBackgroundColor = dogSkillsHighlights;
                numberOfSkills = surveyCompatibility;
                int i10 = 1;
                Object[] arr2 = new Object[i10];
                arr2[i2] = Integer.valueOf(numberOfExams);
                Object[] arr3 = new Object[i10];
                arr3[i2] = Integer.valueOf(surveyCompatibility);
                string2 = obj.Q.getResources().getString(2131887171, arr3);
                Object[] arr = new Object[i10];
                arr[i2] = Integer.valueOf(numberOfSkills);
                string = obj.W.getResources().getString(2131887593, arr);
                i = name;
                i5 = numberOfEnrolledUsers;
                i4 = string3;
                i6 = cardBackgroundColor;
                dogSkillsHighlights = iconUrl;
                i5 = i2;
                int i15 = 6;
                int cmp4 = Long.compare(i3, i19);
                bool = ViewDataBinding.K(obj.Y);
                i3 = 16;
            }
            if (Long.compare(i17, i18) != 0) {
                l.m0(obj.O, i5);
                g.c(obj.P, i4);
                g.c(obj.Q, string2);
                l.J0(obj.R, dogSkillsHighlights);
                n.E(obj.S, i6);
                n.w(obj.T, iconUrl);
                g.c(obj.U, i);
                g.c(obj.W, string);
            }
            if (Long.compare(i7, i9) != 0) {
                obj.V.setVisibility(i2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.u6
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
