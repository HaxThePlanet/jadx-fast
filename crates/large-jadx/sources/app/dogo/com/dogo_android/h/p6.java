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
public class p6 extends app.dogo.com.dogo_android.h.o6 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout U;
    private long V;
    static {
    }

    public p6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, p6.W, p6.X));
    }

    private p6(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (Button)object3Arr3[3], (TextView)object3Arr3[1], (TextView)object3Arr3[2], (Button)object3Arr3[4], (Button)object3Arr3[5]);
        this.V = -1;
        int i7 = 0;
        this.O.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        this.P.setTag(i7);
        this.Q.setTag(i7);
        this.R.setTag(i7);
        this.S.setTag(i7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o6
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o6
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

    @Override // app.dogo.com.dogo_android.h.o6
    public void W(SurveyQuestion surveyQuestion) {
        this.T = surveyQuestion;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.T = surveyQuestion;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o6
    protected void m() {
        int cmp;
        int answer1Text;
        int string;
        Integer valueOf;
        int totalQuestions;
        int answer3Text;
        int answer2Text;
        int name;
        Integer valueOf2;
        int currentQuestionPosition;
        Resources resources;
        int i;
        Object[] arr;
        int i3 = 0;
        this.V = i3;
        SurveyQuestion surveyQuestion = this.T;
        cmp = Long.compare(i2, i3);
        answer1Text = 0;
        synchronized (this) {
            i3 = 0;
            this.V = i3;
            surveyQuestion = this.T;
            cmp = Long.compare(i2, i3);
            answer1Text = 0;
        }
        try {
            int i4 = 0;
            if (surveyQuestion != null) {
            } else {
            }
            answer1Text = surveyQuestion.getAnswer1Text();
            totalQuestions = surveyQuestion.getTotalQuestions();
            answer2Text = surveyQuestion.getAnswer2Text();
            name = surveyQuestion.getName();
            currentQuestionPosition = surveyQuestion.getCurrentQuestionPosition();
            answer3Text = surveyQuestion.getAnswer3Text();
            name = answer2Text;
            currentQuestionPosition = totalQuestions;
            arr = new Object[2];
            arr[i4] = Integer.valueOf(currentQuestionPosition);
            arr[1] = Integer.valueOf(totalQuestions);
            string = this.P.getResources().getString(2131886246, arr);
            name = answer2Text;
            if (cmp != 0) {
            }
            g.c(this.O, answer1Text);
            g.c(this.P, string);
            g.c(this.Q, name);
            g.c(this.R, answer2Text);
            g.c(this.S, answer3Text);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o6
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
