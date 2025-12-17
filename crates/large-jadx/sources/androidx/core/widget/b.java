package androidx.core.widget;

/* loaded from: classes.dex */
public final class b implements Runnable {

    public final androidx.core.widget.ContentLoadingProgressBar a;
    public b(androidx.core.widget.ContentLoadingProgressBar contentLoadingProgressBar) {
        super();
        this.a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
