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

/* loaded from: classes2.dex */
public abstract class d<StateT>  {

    protected final h a;
    private final IntentFilter b;
    private final Context c;
    protected final Set<f.c.a.f.a.c.a<StateT>> d;
    private f.c.a.f.a.c.c e = null;
    private volatile boolean f = false;
    protected d(h h, IntentFilter intentFilter2, Context context3) {
        super();
        HashSet hashSet = new HashSet();
        this.d = hashSet;
        int i = 0;
        int i2 = 0;
        this.a = h;
        this.b = intentFilter2;
        this.c = e1.a(context3);
    }

    private final void b() {
        boolean cVar;
        boolean empty;
        Context context;
        IntentFilter intent;
        final int i = 0;
        if (!this.f) {
            if (!this.d.isEmpty() && this.e == null) {
                if (this.e == null) {
                    cVar = new c(this, i);
                    this.e = cVar;
                    this.c.registerReceiver(cVar, this.b);
                }
            }
        } else {
        }
        empty = this.e;
        if (!this.f && this.d.isEmpty() && empty != null) {
            if (this.d.isEmpty()) {
                empty = this.e;
                if (empty != null) {
                    this.c.unregisterReceiver(empty);
                    this.e = i;
                }
            }
        }
    }

    protected abstract void a(Context context, Intent intent2);

    public final void c(f.c.a.f.a.c.a<StateT> a) {
        this.a.d("registerListener", new Object[0]);
        i1.a(a, "Registered Play Core listener should not be null.");
        this.d.add(a);
        b();
        return;
        synchronized (this) {
            this.a.d("registerListener", new Object[0]);
            i1.a(a, "Registered Play Core listener should not be null.");
            this.d.add(a);
            b();
        }
    }

    public final void d(boolean z) {
        this.f = z;
        b();
        return;
        synchronized (this) {
            this.f = z;
            b();
        }
    }

    public final void e(f.c.a.f.a.c.a<StateT> a) {
        this.a.d("unregisterListener", new Object[0]);
        i1.a(a, "Unregistered Play Core listener should not be null.");
        this.d.remove(a);
        b();
        return;
        synchronized (this) {
            this.a.d("unregisterListener", new Object[0]);
            i1.a(a, "Unregistered Play Core listener should not be null.");
            this.d.remove(a);
            b();
        }
    }

    public final void f(StateT statet) {
        Set next;
        HashSet hashSet = new HashSet(this.d);
        Iterator iterator = hashSet.iterator();
        synchronized (this) {
            try {
                for (a next : iterator) {
                    next.a(statet);
                }
                (a)iterator.next().a(statet);
                throw statet;
            }
        }
    }

    public final boolean g() {
        int i;
        synchronized (this) {
            try {
                i = 1;
                return i;
            }
        }
    }
}
