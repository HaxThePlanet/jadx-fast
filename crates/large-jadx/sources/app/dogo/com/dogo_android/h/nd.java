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
import androidx.databinding.g;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.inappmessaging.k;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes.dex */
public class nd extends app.dogo.com.dogo_android.h.md implements b.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout T;
    private final TextInputEditText U;
    private final View.OnClickListener V;
    private g W;
    private long X;

    class a implements g {

        final app.dogo.com.dogo_android.h.nd a;
        a(app.dogo.com.dogo_android.h.nd nd) {
            this.a = nd;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object kVar;
            int i;
            int i2;
            kVar = ndVar2.S;
            final int i3 = 0;
            i2 = kVar != null ? i : i3;
            if (i2 != 0) {
                kVar = kVar.o();
                if (kVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    kVar.setValue(g.a(nd.W(this.a)));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nd.Z = sparseIntArray;
        sparseIntArray.put(2131363278, 5);
        sparseIntArray.put(2131362389, 6);
        sparseIntArray.put(2131362644, 7);
        sparseIntArray.put(2131362919, 8);
        sparseIntArray.put(2131362897, 9);
    }

    public nd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 10, nd.Y, nd.Z));
    }

    private nd(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        final int i13 = 1;
        super(e, view2, 1, (TextView)object3Arr3[2], (TextView)object3Arr3[i13], (Guideline)object3Arr3[6], (ImageView)object3Arr3[7], (Button)object3Arr3[9], (TextInputLayout)object3Arr3[8], (Guideline)object3Arr3[5], (Button)object3Arr3[4]);
        nd.a aVar = new nd.a(this);
        obj20.W = aVar;
        obj20.X = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        obj20.P.setTag(i11);
        Object obj9 = object3Arr3[0];
        obj20.T = (ConstraintLayout)obj9;
        obj9.setTag(i11);
        Object obj10 = object3Arr3[3];
        obj20.U = (TextInputEditText)obj10;
        obj10.setTag(i11);
        obj20.R.setTag(i11);
        N(view2);
        b bVar = new b(this, i13);
        obj20.V = bVar;
        A();
    }

    static TextInputEditText W(app.dogo.com.dogo_android.h.nd nd) {
        return nd.U;
    }

    private boolean X(x<String> x, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.md
    public void A() {
        this.X = 4;
        I();
        return;
        synchronized (this) {
            this.X = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.md
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.md
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((k)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.md
    public void V(k k) {
        this.S = k;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = k;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.md
    public final void b(int i, View view2) {
        int obj2;
        final k obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.md
    protected void m() {
        int cmp2;
        View.OnClickListener list;
        Object kVar;
        int bodyText;
        int cmp;
        int i;
        int value;
        int title;
        long l = this.X;
        final int i3 = 0;
        this.X = i3;
        kVar = this.S;
        int cmp3 = Long.compare(i6, i3);
        int i7 = 6;
        final int i9 = 0;
        synchronized (this) {
            l = this.X;
            i3 = 0;
            this.X = i3;
            kVar = this.S;
            cmp3 = Long.compare(i6, i3);
            i7 = 6;
            i9 = 0;
        }
        try {
            if (kVar != null) {
            } else {
            }
            i = kVar.o();
            i = i9;
            Q(0, i);
            if (i != 0) {
            } else {
            }
            value = i.getValue();
            value = i9;
        }
        if (kVar != null) {
            kVar = kVar.n();
        } else {
            kVar = i9;
        }
        if (kVar != null) {
            title = kVar.getTitle();
            bodyText = kVar.getBodyText();
        } else {
            title = bodyText;
        }
        if (Long.compare(i8, i3) != 0) {
            g.c(this.O, bodyText);
            g.c(this.P, title);
        }
        if (cmp3 != 0) {
            g.c(this.U, value);
        }
        if (Long.compare(i2, i3) != 0) {
            g.e(this.U, i9, i9, i9, this.W);
            this.R.setOnClickListener(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.md
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
