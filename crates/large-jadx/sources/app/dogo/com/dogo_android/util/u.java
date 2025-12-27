package app.dogo.com.dogo_android.util;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: NavFragmentCommunicationChannel.java */
/* loaded from: classes.dex */
public class u {

    private Map<h, Set<u.a>> a = new HashMap<>();

    public static abstract class a {

        private boolean a;
        private q b;
        private u c;
        private Set<h> d;
        public a(q qVar, Set<h> set) {
            super();
            this.b = qVar;
            this.d = set;
        }

        public void a(h hVar, Bundle bundle) {
            if (this.c != null) {
                str = "author";
                bundle.putSerializable(str, this.b);
                this.c.b(hVar, bundle);
            }
        }

        Set<h> b() {
            return this.d;
        }

        public boolean c() {
            return this.a;
        }

        public void e(u uVar) {
            if (this.c != null) {
                g();
            }
            this.c = uVar;
            uVar.a(this);
        }

        public boolean equals(Object object) {
            boolean z;
            boolean z2 = false;
            z = object instanceof u.a;
            if (object instanceof u.a) {
                object = this.b == object.b ? 1 : 0;
            }
            return (this.b == object.b ? 1 : 0);
        }

        public void f() {
            this.a = true;
            g();
        }

        public void g() {
            if (this.c != null) {
                this.c.d(this);
                app.dogo.com.dogo_android.util.u uVar = null;
                this.c = uVar;
            }
        }

        public abstract void d(h hVar, Bundle bundle);
    }

    public static class b {

        private h a;
        private Bundle b;
        public b(h hVar, Bundle bundle) {
            super();
            this.a = hVar;
            this.b = bundle;
        }

        public h a() {
            return this.a;
        }

        public Bundle b() {
            return this.b;
        }
    }
    public u() {
        super();
        final HashMap hashMap = new HashMap();
    }

    public void a(u.a aVar) {
        Map map2;
        Iterator it = aVar.b().iterator();
        while (it.hasNext()) {
            Object value = it.next();
        }
    }

    public void b(h hVar, Bundle bundle) {
        boolean z;
        if (this.a.containsKey(hVar)) {
            HashSet hashSet = new HashSet();
            Iterator it = (Set)this.a.get(hVar).iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            (Set)this.a.get(hVar).removeAll(hashSet);
        }
    }

    public void c(u.b bVar) {
        b(bVar.a(), bVar.b());
    }

    public void d(u.a aVar) {
        Iterator it = aVar.b().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }
}
