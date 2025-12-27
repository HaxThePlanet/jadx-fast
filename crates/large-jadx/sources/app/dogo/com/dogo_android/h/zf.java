package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: FragmentProgramQuestionCorrectAnswerBindingImpl.java */
/* loaded from: classes.dex */
public class zf extends yf {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout W;
    private long X;
    static {
        obj.put(2131363433, 5);
        obj.put(2131362690, 6);
        obj.put(2131363414, 7);
        obj.put(2131361931, 8);
        obj.put(2131362483, 9);
        obj.put(2131362570, 10);
    }

    public zf(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, zf.Y, zf.Z));
    }

    @Override // app.dogo.com.dogo_android.h.yf
    public void A() {
        synchronized (this) {
            try {
                this.X = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yf
    public boolean O(int i, Object object) {
        boolean z = true;
        if (179 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.yf
    public void V(app.dogo.com.dogo_android.y.b0.e eVar) {
        this.V = eVar;
        synchronized (this) {
            try {
                this.X |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(179);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yf
    protected void m() {
        String correctAnswer;
        java.lang.CharSequence charSequence;
        int i = 0;
        Object obj = null;
        ProgramQuestion programQuestion;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 3L & l;
        i = 0;
        if (l4 != l3) {
            if (this.V != null) {
                programQuestion = this.V.i();
                correctAnswer = this.V.getCorrectAnswer();
            } else {
            }
            if (programQuestion != null) {
                String question = programQuestion.getQuestion();
            }
        } else {
        }
        if (l4 != l3) {
            g.c(this.O, obj);
            ProgramBindingAdapters.animateColorValue(this.S, programQuestion, this.P);
            g.c(this.T, charSequence);
        }
        long l2 = l & 2L;
        if (this.X != l3) {
            BindingAdapters.X(this.R, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yf
    public boolean y() {
        synchronized (this) {
            try {
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private zf(androidx.databinding.e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (TextView)objectArr[3], (CardView)objectArr[8], (ImageView)objectArr[9], (MaterialButton)objectArr[10], (KonfettiView)objectArr[6], (ConstraintLayout)objectArr[1], (WebView)objectArr[4], (TextView)objectArr[2], (TextView)objectArr[7], (MaterialToolbar)objectArr[5]);
        eVar3.X = -1L;
        Object obj12 = null;
        eVar3.O.setTag(obj12);
        eVar3.R.setTag(obj12);
        Object obj11 = objectArr[0];
        eVar3.W = obj11;
        obj11.setTag(obj12);
        eVar3.S.setTag(obj12);
        eVar3.T.setTag(obj12);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yf
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
