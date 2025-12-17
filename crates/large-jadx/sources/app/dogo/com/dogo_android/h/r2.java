package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Article;

/* loaded from: classes.dex */
public class r2 extends app.dogo.com.dogo_android.h.q2 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final RelativeLayout P;
    private final TextView Q;
    private long R;
    static {
    }

    public r2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, r2.S, r2.T));
    }

    private r2(e e, View view2, Object[] object3Arr3) {
        int i = 0;
        super(e, view2, i);
        this.R = -1;
        Object obj4 = object3Arr3[i];
        this.P = (RelativeLayout)obj4;
        int i2 = 0;
        obj4.setTag(i2);
        obj4 = object3Arr3[1];
        this.Q = (TextView)obj4;
        obj4.setTag(i2);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q2
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q2
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.q2
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

    @Override // app.dogo.com.dogo_android.h.q2
    public void V(Article article) {
        this.O = article;
        this.R = l |= i2;
        notifyPropertyChanged(9);
        super.I();
        return;
        synchronized (this) {
            this.O = article;
            this.R = l |= i2;
            notifyPropertyChanged(9);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q2
    protected void m() {
        int cmp;
        int title;
        final int i2 = 0;
        this.R = i2;
        final Article article = this.O;
        title = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.R = i2;
            article = this.O;
            title = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (article != null) {
            }
            title = article.getTitle();
            if (cmp != 0) {
            }
            g.c(this.Q, title);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.q2
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
