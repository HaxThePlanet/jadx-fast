package zendesk.belvedere;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public abstract class d<E>  {

    private boolean canceled = false;

    class a implements Runnable {

        final Object a;
        final zendesk.belvedere.d b;
        a(zendesk.belvedere.d d, Object object2) {
            this.b = d;
            this.a = object2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.success(this.a);
        }
    }
    public d() {
        super();
        final int i = 0;
    }

    public void cancel() {
        this.canceled = true;
    }

    void internalSuccess(E e) {
        boolean canceled;
        zendesk.belvedere.d.a aVar;
        if (!this.canceled) {
            canceled = new Handler(Looper.getMainLooper());
            aVar = new d.a(this, e);
            canceled.post(aVar);
        }
    }

    public abstract void success(E e);
}
