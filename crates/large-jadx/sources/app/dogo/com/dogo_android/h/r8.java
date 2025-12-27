package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;

/* compiled from: DialogChallengeReportBindingImpl.java */
/* loaded from: classes.dex */
public class r8 extends q8 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout S;
    private androidx.databinding.g T;
    private long U;

    class a implements androidx.databinding.g {

        final /* synthetic */ r8 a;
        a() {
            this.a = r8Var;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.R != null ? 1 : i;
            if (i != 0 && codeInput != null) {
                if (i != 0) {
                    codeInput.setValue(g.a(this.a.P));
                }
            }
        }
    }
    static {
        obj.put(2131363423, 2);
        obj.put(2131362105, 3);
        obj.put(2131362911, 4);
    }

    public r8(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, r8.V, r8.W));
    }

    private boolean W(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.q8
    public void A() {
        synchronized (this) {
            try {
                this.U = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q8
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.q8
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.q8
    public void V(app.dogo.com.dogo_android.d.e.e eVar) {
        this.R = eVar;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.q8
    protected void m() {
        Object obj;
        java.lang.CharSequence charSequence;
        int i = 0;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        final androidx.databinding.k.g.c cVar = null;
        if (l4 != l3) {
            if (this.R != null) {
                x codeInput = this.R.getCodeInput();
            } else {
                int i2 = cVar;
            }
            i = 0;
            Q(i, obj);
            Object value = this.R != null ? (String)value : cVar;
        }
        if (l4 != l3) {
            g.c(this.P, charSequence);
        }
        long l2 = l & 4L;
        if (this.U != l3) {
            g.e(this.P, cVar, cVar, cVar, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q8
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

    private r8(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Button)objectArr[3], (AppCompatEditText)objectArr[1], (Button)objectArr[4], (TextView)objectArr[2]);
        this.T = new r8.a(this);
        this.U = -1L;
        Object obj5 = null;
        this.P.setTag(obj5);
        Object obj6 = objectArr[0];
        this.S = obj6;
        obj6.setTag(obj5);
        N(view);
        A();
    }
}
