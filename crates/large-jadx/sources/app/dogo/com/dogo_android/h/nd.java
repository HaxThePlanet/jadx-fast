package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.inappmessaging.k;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import com.google.android.material.textfield.TextInputEditText;

/* compiled from: FragmentInnAppFeedbackBindingImpl.java */
/* loaded from: classes.dex */
public class nd extends md implements b.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout T;
    private final TextInputEditText U;
    private final View.OnClickListener V;
    private androidx.databinding.g W;
    private long X;

    class a implements androidx.databinding.g {

        final /* synthetic */ nd a;
        a() {
            this.a = ndVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.S != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.U));
                }
            }
        }
    }
    static {
        obj.put(2131363278, 5);
        obj.put(2131362389, 6);
        obj.put(2131362644, 7);
        obj.put(2131362919, 8);
        obj.put(2131362897, 9);
    }

    public nd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 10, nd.Y, nd.Z));
    }

    static /* synthetic */ TextInputEditText W(nd ndVar) {
        return ndVar.U;
    }

    private boolean X(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.md
    public void A() {
        synchronized (this) {
            try {
                this.X = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.md
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.md
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

    @Override // app.dogo.com.dogo_android.h.md
    public void V(k kVar) {
        this.S = kVar;
        synchronized (this) {
            try {
                this.X |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.md
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.md
    protected void m() {
        InAppMessageDataHolder inAppMessageDataHolder;
        Object obj;
        Object obj2;
        Object value;
        java.lang.CharSequence charSequence;
        Object obj3;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        long l5 = 6L;
        final androidx.databinding.k.g.c cVar = null;
        if (l4 != l3) {
            if (this.S != null) {
                x xVar = this.S.o();
            } else {
                int i7 = cVar;
            }
            Q(0, obj2);
            value = obj2 != null ? (String)value : cVar;
            long l7 = l & 6L;
            if (l7 != l3) {
                if (this.S != null) {
                    inAppMessageDataHolder = this.S.n();
                } else {
                    int i3 = cVar;
                }
                if (this.S != null) {
                    String title = inAppMessageDataHolder.getTitle();
                    String bodyText = inAppMessageDataHolder.getBodyText();
                } else {
                }
            }
        } else {
        }
        long l6 = 6L & l;
        if (l6 != l3) {
            g.c(this.O, obj);
            g.c(this.P, obj3);
        }
        if (l4 != l3) {
            g.c(this.U, charSequence);
        }
        long l2 = l & 4L;
        if (this.X != l3) {
            g.e(this.U, cVar, cVar, cVar, this.W);
            this.R.setOnClickListener(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.md
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

    private nd(e eVar, View view, Object[] objectArr) {
        final app.dogo.com.dogo_android.h.nd eVar3 = this;
        final int i12 = 1;
        super(eVar, view, 1, (TextView)objectArr[2], (TextView)objectArr[i12], (Guideline)objectArr[6], (ImageView)objectArr[7], (Button)objectArr[9], (TextInputLayout)objectArr[8], (Guideline)objectArr[5], (Button)objectArr[4]);
        eVar3.W = new nd.a(this);
        eVar3.X = -1L;
        Object obj11 = null;
        eVar3.O.setTag(obj11);
        eVar3.P.setTag(obj11);
        Object obj9 = objectArr[0];
        eVar3.T = obj9;
        obj9.setTag(obj11);
        Object obj10 = objectArr[3];
        eVar3.U = obj10;
        obj10.setTag(obj11);
        eVar3.R.setTag(obj11);
        N(view);
        eVar3.V = new b(this, i12);
        A();
    }
}
