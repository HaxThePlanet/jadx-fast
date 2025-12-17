package app.dogo.com.dogo_android.util;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class u {

    private Map<h, Set<app.dogo.com.dogo_android.util.u.a>> a;

    public static abstract class a {

        private boolean a;
        private q b;
        private app.dogo.com.dogo_android.util.u c;
        private Set<h> d;
        public a(q q, Set<h> set2) {
            super();
            this.b = q;
            this.d = set2;
        }

        public void a(h h, Bundle bundle2) {
            app.dogo.com.dogo_android.util.u uVar;
            String str;
            if (this.c != null) {
                bundle2.putSerializable("author", this.b);
                this.c.b(h, bundle2);
            }
        }

        Set<h> b() {
            return this.d;
        }

        public boolean c() {
            return this.a;
        }

        public abstract void d(h h, Bundle bundle2);

        public void e(app.dogo.com.dogo_android.util.u u) {
            if (this.c != null) {
                g();
            }
            this.c = u;
            u.a(this);
        }

        public boolean equals(Object object) {
            boolean z;
            Object obj2;
            if (object instanceof u.a && this.b == object.b) {
                obj2 = this.b == object.b ? 1 : 0;
            } else {
            }
            return obj2;
        }

        public void f() {
            this.a = true;
            g();
        }

        public void g() {
            app.dogo.com.dogo_android.util.u uVar;
            uVar = this.c;
            if (uVar != null) {
                uVar.d(this);
                this.c = 0;
            }
        }
    }

    public static class b {

        private h a;
        private Bundle b;
        public b(h h, Bundle bundle2) {
            super();
            this.a = h;
            this.b = bundle2;
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
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public void a(app.dogo.com.dogo_android.util.u.a u$a) {
        Object next;
        Object hashSet;
        Map map;
        Iterator iterator = a.b().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (this.a.containsKey((h)next)) {
            } else {
            }
            hashSet = new HashSet();
            hashSet.add(a);
            this.a.put(next, hashSet);
            (Set)this.a.get(next).add(a);
        }
    }

    public void b(h h, Bundle bundle2) {
        boolean hashSet;
        Iterator iterator;
        boolean next;
        boolean z;
        Object obj5;
        Object obj6;
        if (this.a.containsKey(h)) {
            hashSet = new HashSet();
            iterator = (Set)this.a.get(h).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((u.a)next.c()) {
                } else {
                }
                next.d(h, bundle2);
                hashSet.add(next);
            }
            (Set)this.a.get(h).removeAll(hashSet);
        }
    }

    public void c(app.dogo.com.dogo_android.util.u.b u$b) {
        b(b.a(), b.b());
    }

    public void d(app.dogo.com.dogo_android.util.u.a u$a) {
        Object next;
        boolean empty;
        Iterator iterator = a.b().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            Object obj = this.a.get(next);
            (Set)obj.remove(a);
            if (this.a.containsKey((h)next) && obj.isEmpty()) {
            }
            obj = this.a.get(next);
            (Set)obj.remove(a);
            if (obj.isEmpty()) {
            }
            this.a.remove(next);
        }
    }
}
