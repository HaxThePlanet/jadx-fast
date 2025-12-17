package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
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
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;

/* loaded from: classes.dex */
public class r6 extends app.dogo.com.dogo_android.h.q6 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
    }

    public r6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, r6.V, r6.W));
    }

    private r6(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (Button)object3Arr3[4], (TextView)object3Arr3[1], (Button)object3Arr3[3], (TextView)object3Arr3[2]);
        this.U = -1;
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        final int obj12 = 0;
        obj10.setTag(obj12);
        this.O.setTag(obj12);
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        this.R.setTag(obj12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q6
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.q6
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            W((SurveyQuestion)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.q6
    public void W(SurveyQuestion surveyQuestion) {
        this.S = surveyQuestion;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.S = surveyQuestion;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q6
    protected void m() {
        int cmp;
        int answer1Text;
        int string;
        int i2;
        int name;
        int i;
        int answer2Text;
        int valueOf;
        int currentQuestionPosition;
        int totalQuestions;
        Resources resources;
        int i3;
        Object[] arr;
        int i4;
        int i6 = 0;
        this.U = i6;
        SurveyQuestion surveyQuestion = this.S;
        cmp = Long.compare(i5, i6);
        answer1Text = 0;
        synchronized (this) {
            i6 = 0;
            this.U = i6;
            surveyQuestion = this.S;
            cmp = Long.compare(i5, i6);
            answer1Text = 0;
        }
        try {
            int i7 = 0;
            if (surveyQuestion != null) {
            } else {
            }
            answer1Text = surveyQuestion.getAnswer1Text();
            name = surveyQuestion.getName();
            currentQuestionPosition = surveyQuestion.getCurrentQuestionPosition();
            totalQuestions = surveyQuestion.getTotalQuestions();
            answer2Text = surveyQuestion.getAnswer2Text();
            answer2Text = name;
            totalQuestions = currentQuestionPosition;
            arr = new Object[2];
            arr[i7] = Integer.valueOf(currentQuestionPosition);
            arr[1] = Integer.valueOf(totalQuestions);
            string = this.P.getResources().getString(2131886246, arr);
            i2 = answer1Text;
            answer1Text = answer2Text;
            i = i4;
            i = i2;
            if (cmp != 0) {
            }
            g.c(this.O, answer1Text);
            g.c(this.P, string);
            g.c(this.Q, i2);
            g.c(this.R, i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q6
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
