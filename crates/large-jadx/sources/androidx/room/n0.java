package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class n0 {

    final Context a;
    final String b;
    int c;
    final androidx.room.m0 d;
    final androidx.room.m0.c e;
    androidx.room.j0 f;
    final Executor g;
    final androidx.room.i0 h;
    final AtomicBoolean i;
    final ServiceConnection j;
    final Runnable k;
    final Runnable l;

    class b implements ServiceConnection {

        final androidx.room.n0 a;
        b(androidx.room.n0 n0) {
            this.a = n0;
            super();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            obj1.f = j0.a.j(iBinder2);
            androidx.room.n0 obj1 = this.a;
            obj1.g.execute(obj1.k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            androidx.room.n0 obj2 = this.a;
            obj2.g.execute(obj2.l);
            obj2.f = 0;
        }
    }

    class c implements Runnable {

        final androidx.room.n0 a;
        c(androidx.room.n0 n0) {
            this.a = n0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object n0Var;
            Object j0Var;
            Object str2;
            String str;
            try {
                n0Var = this.a;
                j0Var = n0Var.f;
                if (j0Var != null) {
                }
                n0Var.c = j0Var.e0(n0Var.h, n0Var.b);
                androidx.room.n0 n0Var2 = this.a;
                n0Var2.d.a(n0Var2.e);
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", th);
            }
        }
    }

    class d implements Runnable {

        final androidx.room.n0 a;
        d(androidx.room.n0 n0) {
            this.a = n0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.room.n0 n0Var = this.a;
            n0Var.d.i(n0Var.e);
        }
    }

    class e extends androidx.room.m0.c {

        final androidx.room.n0 b;
        e(androidx.room.n0 n0, String[] string2Arr2) {
            this.b = n0;
            super(string2Arr2);
        }

        @Override // androidx.room.m0$c
        boolean a() {
            return 1;
        }

        public void b(Set<String> set) {
            androidx.room.n0 n0Var;
            androidx.room.j0 j0Var;
            String[] strArr;
            Throwable obj4;
            if (n0Var2.i.get()) {
            }
            n0Var = this.b;
            j0Var = n0Var.f;
            if (j0Var != null) {
                j0Var.X1(n0Var.c, (String[])set.toArray(new String[0]));
            }
        }
    }

    class a extends androidx.room.i0.a {

        final androidx.room.n0 a;
        a(androidx.room.n0 n0) {
            this.a = n0;
            super();
        }

        @Override // androidx.room.i0$a
        public void N(String[] stringArr) {
            n0.a.a aVar = new n0.a.a(this, stringArr);
            n0Var.g.execute(aVar);
        }
    }
    n0(Context context, String string2, Intent intent3, androidx.room.m0 m04, Executor executor5) {
        super();
        n0.a aVar = new n0.a(this);
        this.h = aVar;
        final int i = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i);
        this.i = atomicBoolean;
        n0.b bVar = new n0.b(this);
        this.j = bVar;
        n0.c cVar = new n0.c(this);
        this.k = cVar;
        n0.d dVar = new n0.d(this);
        this.l = dVar;
        final Context obj4 = context.getApplicationContext();
        this.a = obj4;
        this.b = string2;
        this.d = m04;
        this.g = executor5;
        n0.e obj7 = new n0.e(this, (String[])m04.a.keySet().toArray(new String[i]));
        this.e = obj7;
        obj4.bindService(intent3, bVar, 1);
    }
}
