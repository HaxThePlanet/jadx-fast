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

/* compiled from: CellQuestionaireCardThreeBindingImpl.java */
/* loaded from: classes.dex */
public class p6 extends o6 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout U;
    private long V;
    public p6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, p6.W, p6.X));
    }

    @Override // app.dogo.com.dogo_android.h.o6
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o6
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

    @Override // app.dogo.com.dogo_android.h.o6
    public void W(SurveyQuestion surveyQuestion) {
        this.T = surveyQuestion;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.o6
    protected void m() {
        int i = 0;
        java.lang.CharSequence charSequence = null;
        Object obj;
        int currentQuestionPosition;
        java.lang.CharSequence charSequence2;
        java.lang.CharSequence charSequence3;
        java.lang.CharSequence charSequence4;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.V & 3L;
        i = 0;
        if (l2 != l3) {
            currentQuestionPosition = 0;
            if (this.T != null) {
                String answer1Text = this.T.getAnswer1Text();
                currentQuestionPosition = this.T.getTotalQuestions();
                String answer2Text = this.T.getAnswer2Text();
                String name = this.T.getName();
                currentQuestionPosition = this.T.getCurrentQuestionPosition();
                String answer3Text = this.T.getAnswer3Text();
            } else {
            }
            int i2 = 2131886246;
            Object[] arr = new Object[2];
            String string = this.P.getResources().getString(i2, new Object[] { Integer.valueOf(currentQuestionPosition), Integer.valueOf(currentQuestionPosition) });
        } else {
        }
        if (l2 != l3) {
            g.c(this.O, charSequence);
            g.c(this.P, obj);
            g.c(this.Q, charSequence4);
            g.c(this.R, charSequence3);
            g.c(this.S, charSequence2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o6
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private p6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Button)objectArr[3], (TextView)objectArr[1], (TextView)objectArr[2], (Button)objectArr[4], (Button)objectArr[5]);
        this.V = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        this.R.setTag(obj6);
        this.S.setTag(obj6);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.o6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
