package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {

    private final DataSetObservable a;
    private DataSetObserver b;
    public a() {
        super();
        DataSetObservable dataSetObservable = new DataSetObservable();
        this.a = dataSetObservable;
    }

    public abstract void a(ViewGroup viewGroup, int i2, Object object3);

    @Deprecated
    public void b(View view) {
    }

    public void c(ViewGroup viewGroup) {
        b(viewGroup);
    }

    public abstract int d();

    public int e(Object object) {
        return -1;
    }

    public java.lang.CharSequence f(int i) {
        return null;
    }

    public float g(int i) {
        return 1065353216;
    }

    public abstract Object h(ViewGroup viewGroup, int i2);

    public abstract boolean i(View view, Object object2);

    public void j() {
        DataSetObserver set = this.b;
        synchronized (this) {
            try {
                set.onChanged();
                this.a.notifyChanged();
                throw th;
            }
        }
    }

    public void k(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public void l(Parcelable parcelable, java.lang.ClassLoader classLoader2) {
    }

    public Parcelable m() {
        return null;
    }

    @Deprecated
    public void n(View view, int i2, Object object3) {
    }

    public void o(ViewGroup viewGroup, int i2, Object object3) {
        n(viewGroup, i2, object3);
    }

    void p(DataSetObserver dataSetObserver) {
        this.b = dataSetObserver;
        return;
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }

    @Deprecated
    public void q(View view) {
    }

    public void r(ViewGroup viewGroup) {
        q(viewGroup);
    }

    public void s(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
