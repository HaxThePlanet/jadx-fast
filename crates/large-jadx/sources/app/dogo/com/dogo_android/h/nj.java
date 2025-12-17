package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
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
import app.dogo.com.dogo_android.g.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class nj extends app.dogo.com.dogo_android.h.mj implements b.a {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0;
    private final ConstraintLayout Z;
    private final View.OnClickListener a0;
    private final View.OnClickListener b0;
    private long c0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nj.e0 = sparseIntArray;
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

    public nj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 21, nj.d0, nj.e0));
    }

    private nj(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 0, (View)object3Arr3[12], (TextView)object3Arr3[9], (ImageView)object3Arr3[20], (TextView)object3Arr3[8], (ImageView)object3Arr3[18], (TextView)object3Arr3[3], (TextView)object3Arr3[10], (LinearLayout)object3Arr3[5], (ImageView)object3Arr3[13], (CardView)object3Arr3[1], (ImageView)object3Arr3[2], (TextView)object3Arr3[4], (Button)object3Arr3[6], (ImageView)object3Arr3[15], (TextView)object3Arr3[7], (ImageView)object3Arr3[16], (View)object3Arr3[17], (View)object3Arr3[19], (TextView)object3Arr3[14], (Guideline)object3Arr3[11]);
        Object obj4 = this;
        obj4.c0 = -1;
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
        b bVar = new b(obj4, 2);
        obj4.a0 = bVar;
        b bVar2 = new b(obj4, 1);
        obj4.b0 = bVar2;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public void A() {
        this.c0 = 4;
        I();
        return;
        synchronized (this) {
            this.c0 = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((x)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public void T(x x) {
        this.Y = x;
        this.c0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Y = x;
            this.c0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.X = programDescriptionItem;
        this.c0 = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.X = programDescriptionItem;
            this.c0 = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public final void b(int i, View view2) {
        x xVar;
        ProgramDescriptionItem obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                xVar = this.Y;
                if (xVar != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    xVar.F(this.X);
                }
            }
        } else {
            xVar = this.Y;
            if (xVar != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                xVar.F(this.X);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.mj
    protected void m() {
        int name;
        int cmp;
        int i2;
        int string2;
        int string3;
        int cmp2;
        int string;
        int numberOfExams;
        int i;
        int numberOfEnrolledUsers;
        int iconUrl;
        Resources resources;
        int surveyCompatibility;
        Integer valueOf;
        int numberOfSkills;
        int dogSkillsHighlights;
        int cardBackgroundColor;
        int i3;
        final Object obj = this;
        long l = obj.c0;
        int i4 = 0;
        obj.c0 = i4;
        ProgramDescriptionItem programDescriptionItem = obj.X;
        cmp2 = Long.compare(i9, i4);
        string = 0;
        i = 0;
        synchronized (this) {
            obj = this;
            l = obj.c0;
            i4 = 0;
            obj.c0 = i4;
            programDescriptionItem = obj.X;
            cmp2 = Long.compare(i9, i4);
            string = 0;
            i = 0;
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
                int i7 = 1;
                Object[] arr = new Object[i7];
                arr[i] = Integer.valueOf(numberOfExams);
                string = obj.P.getResources().getString(2131886974, arr);
                Object[] arr3 = new Object[i7];
                arr3[i] = Integer.valueOf(surveyCompatibility);
                string2 = obj.Q.getResources().getString(2131887171, arr3);
                Object[] arr2 = new Object[i7];
                arr2[i] = Integer.valueOf(numberOfSkills);
                string3 = obj.W.getResources().getString(2131887593, arr2);
                i = numberOfEnrolledUsers;
                cardBackgroundColor = dogSkillsHighlights;
                if (cmp2 != 0) {
                }
                l.m0(obj.O, i);
                g.c(obj.P, string);
                g.c(obj.Q, string2);
                l.J0(obj.R, dogSkillsHighlights);
                n.E(obj.S, cardBackgroundColor);
                n.w(obj.T, iconUrl);
                g.c(obj.U, name);
                g.c(obj.W, string3);
                if (Long.compare(i2, i6) != 0) {
                }
                obj.S.setOnClickListener(obj.b0);
                obj.V.setOnClickListener(obj.a0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.mj
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
