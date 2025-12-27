package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.Article;

/* compiled from: CellLibraryArticleItemBindingImpl.java */
/* loaded from: classes.dex */
public class b3 extends a3 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout U;
    private long V;
    static {
        obj.put(2131362111, 6);
        obj.put(2131361982, 7);
        obj.put(2131362003, 8);
        obj.put(2131363187, 9);
    }

    public b3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 10, b3.W, b3.X));
    }

    @Override // app.dogo.com.dogo_android.h.a3
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a3
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.a3
    public void V(Article article) {
        this.T = article;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a3
    protected void m() {
        long l;
        long l2;
        int readingTime = 8;
        Object obj;
        boolean read;
        String image = null;
        int i2 = 16;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.V = l4;
            } catch (Throwable th) {
            }
        }
        final long l5 = 3L;
        long l6 = l & l5;
        int i = 0;
        readingTime = 0;
        if (l6 != l4) {
            if (this.T != null) {
                read = this.T.isRead();
                image = this.T.getImage();
                readingTime = this.T.getReadingTime();
            } else {
            }
            if (l6 != l4 && read) {
                l2 = l | 8L;
                i2 = 32;
                l = l2 | i2;
            }
            readingTime = 8;
            int r12 = read ? 8 : readingTime;
            if (read) {
            }
            int i3 = 2131886145;
            Object[] arr = new Object[1];
        } else {
        }
        l &= l5;
        if (this.V != l4) {
            LibraryBindingAdapters.setArticleListTab(this.O, image);
            this.P.setVisibility(readingTime);
            LibraryBindingAdapters.setLibraryProgramAdapter(this.Q, this.T);
            LibraryBindingAdapters.setBigTimerDescriptionButton(this.R, this.T);
            g.c(this.S, obj);
            this.S.setVisibility(readingTime);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a3
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

    private b3(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ImageView)objectArr[2], (TextView)objectArr[4], (TextView)objectArr[1], (ImageView)objectArr[7], (Barrier)objectArr[8], (CardView)objectArr[6], (ChipGroupWithState)objectArr[5], (TextView)objectArr[3], (HorizontalScrollView)objectArr[9]);
        eVar3.V = -1L;
        Object obj11 = null;
        eVar3.O.setTag(obj11);
        eVar3.P.setTag(obj11);
        eVar3.Q.setTag(obj11);
        eVar3.R.setTag(obj11);
        Object obj10 = objectArr[0];
        eVar3.U = obj10;
        obj10.setTag(obj11);
        eVar3.S.setTag(obj11);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
