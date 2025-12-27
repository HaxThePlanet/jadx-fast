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

/* compiled from: CellQuestionaireCardTwoBindingImpl.java */
/* loaded from: classes.dex */
public class r6 extends q6 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    public r6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, r6.V, r6.W));
    }

    @Override // app.dogo.com.dogo_android.h.q6
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q6
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            W(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.q6
    public void W(SurveyQuestion surveyQuestion) {
        this.S = surveyQuestion;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.q6
    protected void m() {
        int i = 0;
        java.lang.CharSequence charSequence = null;
        Object obj;
        java.lang.CharSequence charSequence2;
        java.lang.CharSequence charSequence3;
        int currentQuestionPosition;
        synchronized (this) {
            try {
                long l4 = 0L;
                this.U = l4;
            } catch (Throwable th) {
            }
        }
        long l = 3L;
        long l3 = this.U & l;
        i = 0;
        if (l3 != l4) {
            currentQuestionPosition = 0;
            if (this.S != null) {
                String answer1Text = this.S.getAnswer1Text();
                String name = this.S.getName();
                currentQuestionPosition = this.S.getCurrentQuestionPosition();
                currentQuestionPosition = this.S.getTotalQuestions();
                String answer2Text = this.S.getAnswer2Text();
            } else {
            }
            int i2 = 2131886246;
            Object[] arr = new Object[2];
            String string = this.P.getResources().getString(i2, new Object[] { Integer.valueOf(currentQuestionPosition), Integer.valueOf(currentQuestionPosition) });
        } else {
        }
        if (l3 != l4) {
            g.c(this.O, charSequence);
            g.c(this.P, obj);
            g.c(this.Q, charSequence2);
            g.c(this.R, charSequence3);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q6
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private r6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Button)objectArr[4], (TextView)objectArr[1], (Button)objectArr[3], (TextView)objectArr[2]);
        this.U = -1L;
        Object obj5 = objectArr[0];
        this.T = obj5;
        final Object obj6 = null;
        obj5.setTag(obj6);
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        this.R.setTag(obj6);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.q6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
