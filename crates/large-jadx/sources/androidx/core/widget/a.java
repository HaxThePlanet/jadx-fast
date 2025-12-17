package androidx.core.widget;

/* loaded from: classes.dex */
public final class a implements Runnable {

    public final androidx.core.widget.ContentLoadingProgressBar a;
    public a(androidx.core.widget.ContentLoadingProgressBar contentLoadingProgressBar) {
        super();
        this.a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
