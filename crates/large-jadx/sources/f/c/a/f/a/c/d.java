package f.c.a.f.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.internal.e1;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i1;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public abstract class d<StateT> {

    protected final h a;
    private final IntentFilter b;
    private final Context c;
    protected final Set<a<StateT>> d = new HashSet<>();
    private c e = null;
    private volatile boolean f = false;
    protected d(h hVar, IntentFilter intentFilter, Context context) {
        super();
        HashSet hashSet = new HashSet();
        this.a = hVar;
        this.b = intentFilter;
        this.c = e1.a(context);
    }

    private final void b() {
        Context context;
        final f.c.a.f.a.c.b bVar = null;
        if (!this.f) {
            if (!this.d.isEmpty() && this.e == null) {
                f.c.a.f.a.c.c cVar = new c(this, bVar);
                this.e = cVar;
                this.c.registerReceiver(cVar, this.b);
            }
        }
        if (!this.f) {
            if (this.d.isEmpty() && this.e != null) {
                this.c.unregisterReceiver(this.e);
                this.e = bVar;
            }
        }
    }

    public final synchronized void c(a<StateT> aVar) {
        this.a.d("registerListener", new Object[0]);
        i1.a(aVar, "Registered Play Core listener should not be null.");
        this.d.add(aVar);
        b();
    }

    public final synchronized void d(boolean z) {
        this.f = z;
        b();
    }

    public final synchronized void e(a<StateT> aVar) {
        this.a.d("unregisterListener", new Object[0]);
        i1.a(aVar, "Unregistered Play Core listener should not be null.");
        this.d.remove(aVar);
        b();
    }

    public final synchronized void f(StateT statet) {
        Iterator it = new HashSet(this.d).iterator();
        (a)it.next().a(statet);
    }

    protected abstract void a(Context context, Intent intent);

    public final synchronized boolean g() {
        boolean z = false;
        Throwable th = this.e != null ? 1 : 0;
        return (this.e != null ? 1 : 0);
    }
}
