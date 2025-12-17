package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class n2 extends app.dogo.com.dogo_android.h.m2 {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ConstraintLayout a0;
    private long b0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n2.d0 = sparseIntArray;
        sparseIntArray.put(2131362963, 11);
        sparseIntArray.put(2131362494, 12);
        sparseIntArray.put(2131363414, 13);
        sparseIntArray.put(2131362322, 14);
        sparseIntArray.put(2131362707, 15);
        sparseIntArray.put(2131362003, 16);
    }

    public n2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 17, n2.c0, n2.d0));
    }

    private n2(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 0, (Barrier)object3Arr3[16], (TextView)object3Arr3[4], (ImageView)object3Arr3[14], (ImageView)object3Arr3[1], (TextView)object3Arr3[3], (TextView)object3Arr3[2], (CardView)object3Arr3[12], (ImageView)object3Arr3[5], (TextView)object3Arr3[9], (TextView)object3Arr3[10], (View)object3Arr3[15], (ImageView)object3Arr3[11], (Button)object3Arr3[8], (TextView)object3Arr3[13], (TextView)object3Arr3[7], (TextView)object3Arr3[6]);
        Object obj4 = this;
        obj4.b0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.S.setTag(i3);
        obj4.T.setTag(i3);
        obj4.U.setTag(i3);
        Object obj2 = object3Arr3[0];
        obj4.a0 = (ConstraintLayout)obj2;
        obj2.setTag(i3);
        obj4.W.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Y.setTag(i3);
        obj4.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m2
    public void A() {
        this.b0 = 2;
        I();
        return;
        synchronized (this) {
            this.b0 = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m2
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m2
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((ProgramExam)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m2
    public void V(ProgramExam programExam) {
        this.Z = programExam;
        this.b0 = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Z = programExam;
            this.b0 = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m2
    protected void m() {
        Object programExam;
        long l;
        int cmp3;
        int string;
        int string2;
        int i;
        int resources;
        int i2;
        int i4;
        int reviewComment;
        int evaluatedByAvatar;
        int reviewTimeMs;
        int i5;
        int userFeedbackSubmitted;
        int name;
        int evaluatedByName;
        int thumbnailUrl;
        boolean z;
        int retakable;
        int empty;
        int i3;
        int cmp2;
        int cmp;
        int i7;
        int i6;
        final Object obj = this;
        l = obj.b0;
        int i9 = 0;
        obj.b0 = i9;
        programExam = obj.Z;
        final int i14 = 3;
        int cmp4 = Long.compare(i15, i9);
        int i16 = 4;
        final int i18 = 0;
        synchronized (this) {
            obj = this;
            l = obj.b0;
            i9 = 0;
            obj.b0 = i9;
            programExam = obj.Z;
            i14 = 3;
            cmp4 = Long.compare(i15, i9);
            i16 = 4;
            i18 = 0;
        }
        if (programExam != null) {
            reviewComment = programExam.getReviewComment();
            evaluatedByAvatar = programExam.getEvaluatedByAvatar();
            reviewTimeMs = programExam.getReviewTimeMs();
            userFeedbackSubmitted = programExam.getUserFeedbackSubmitted();
            name = programExam.getName();
            evaluatedByName = programExam.getEvaluatedByName();
            thumbnailUrl = programExam.getThumbnailUrl();
            retakable = programExam.isRetakable();
        } else {
            try {
                userFeedbackSubmitted = i18;
                reviewComment = 0;
                evaluatedByAvatar = 0;
                reviewTimeMs = 0;
                name = 0;
                evaluatedByName = 0;
                thumbnailUrl = 0;
                retakable = 0;
                if (cmp4 != 0) {
                }
                if (userFeedbackSubmitted != 0) {
                } else {
                }
                i3 = 128;
                i3 = 64;
                l |= i3;
            }
            i5 = i;
            z = ViewDataBinding.K(retakable);
            if (Long.compare(i19, i9) != 0) {
                cmp2 = z ? 32 : 16;
                l |= cmp2;
            }
            if (evaluatedByName != 0) {
                empty = evaluatedByName.isEmpty();
            } else {
                empty = i18;
            }
            if (Long.compare(i20, i9) != 0) {
                l = empty ? l | cmp : l | i16;
            }
            if (z) {
                i = i18;
            }
            i4 = i5;
            i7 = name;
            i6 = thumbnailUrl;
            if (Long.compare(i17, i9) != 0) {
                Object[] arr = new Object[1];
                arr[i18] = evaluatedByName;
                string2 = obj.Y.getResources().getString(2131886554, arr);
            } else {
                string2 = 0;
            }
            cmp3 = Long.compare(i8, i13);
            if (cmp3 != 0) {
                if (empty != 0) {
                    string = obj.Y.getResources().getString(2131887564);
                } else {
                    string = string2;
                }
            } else {
                string = 0;
            }
            if (cmp3 != 0) {
                n.O(obj.O, reviewTimeMs);
                m.o(obj.P, i6);
                g.c(obj.Q, i7);
                i.q(obj.R, programExam);
                ImageView view = obj.S;
                n.m0(view, evaluatedByAvatar, a.d(view.getContext(), 2131231283));
                obj.T.setVisibility(i4);
                obj.U.setVisibility(i4);
                obj.W.setVisibility(i);
                g.c(obj.X, reviewComment);
                g.c(obj.Y, string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.m2
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
