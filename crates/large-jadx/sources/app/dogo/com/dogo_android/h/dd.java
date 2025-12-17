package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Article;

/* loaded from: classes.dex */
public class dd extends app.dogo.com.dogo_android.h.cd {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        dd.V = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
    }

    public dd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, dd.U, dd.V));
    }

    private dd(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (TextView)object3Arr3[1], (MaterialToolbar)object3Arr3[3]);
        this.T = -1;
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        this.P.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cd
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cd
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.cd
    public boolean O(int i, Object object2) {
        int obj2;
        if (9 == i) {
            V((Article)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cd
    public void V(Article article) {
        this.R = article;
        this.T = l |= i2;
        notifyPropertyChanged(9);
        super.I();
        return;
        synchronized (this) {
            this.R = article;
            this.T = l |= i2;
            notifyPropertyChanged(9);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cd
    protected void m() {
        int cmp;
        int text;
        int title;
        int i2 = 0;
        this.T = i2;
        final Article article = this.R;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.T = i2;
            article = this.R;
            cmp = Long.compare(i, i2);
        }
        try {
            if (article != null) {
            } else {
            }
            text = article.getText();
            title = article.getTitle();
            title = text;
            if (cmp != 0) {
            }
            g.c(this.O, text);
            g.c(this.P, title);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.cd
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
