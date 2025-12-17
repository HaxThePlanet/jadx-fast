package com.bumptech.glide.q;

import com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    private final List<String> a;
    private final Map<String, List<com.bumptech.glide.q.e.a<?, ?>>> b;

    private static class a {

        private final Class<T> a;
        final Class<R> b;
        final j<T, R> c;
        public a(Class<T> class, Class<R> class2, j<T, R> j3) {
            super();
            this.a = class;
            this.b = class2;
            this.c = j3;
        }

        public boolean a(Class<?> class, Class<?> class2) {
            boolean obj2;
            if (this.a.isAssignableFrom(class) && class2.isAssignableFrom(this.b)) {
                obj2 = class2.isAssignableFrom(this.b) ? 1 : 0;
            } else {
            }
            return obj2;
        }
    }
    public e() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
    }

    private List<com.bumptech.glide.q.e.a<?, ?>> c(String string) {
        boolean contains;
        Object arrayList;
        Map map;
        synchronized (this) {
            try {
                this.a.add(string);
                if ((List)this.b.get(string) == null) {
                }
                arrayList = new ArrayList();
                this.b.put(string, arrayList);
                return arrayList;
                throw string;
            }
        }
    }

    public <T, R> void a(String string, j<T, R> j2, Class<T> class3, Class<R> class4) {
        e.a aVar = new e.a(class3, class4, j2);
        c(string).add(aVar);
        return;
        synchronized (this) {
            aVar = new e.a(class3, class4, j2);
            c(string).add(aVar);
        }
    }

    public <T, R> List<j<T, R>> b(Class<T> class, Class<R> class2) {
        Object iterator;
        Map next;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = this.a.iterator();
        synchronized (this) {
            try {
                while (iterator2.hasNext()) {
                    iterator = this.b.get((String)iterator2.next());
                    if ((List)iterator == null) {
                    } else {
                    }
                    iterator = (List)iterator.iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((e.a)next.a(class, class2)) {
                        }
                        arrayList.add(next.c);
                    }
                    next = iterator.next();
                    if ((e.a)next.a(class, class2)) {
                    }
                    arrayList.add(next.c);
                }
                iterator = this.b.get((String)iterator2.next());
                if ((List)iterator == null) {
                } else {
                }
                iterator = (List)iterator.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((e.a)next.a(class, class2)) {
                    }
                    arrayList.add(next.c);
                }
                next = iterator.next();
                if ((e.a)next.a(class, class2)) {
                }
                arrayList.add(next.c);
                return arrayList;
                throw class;
            }
        }
    }

    public <T, R> List<Class<R>> d(Class<T> class, Class<R> class2) {
        Object iterator;
        Map next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = this.a.iterator();
        synchronized (this) {
            try {
                while (iterator2.hasNext()) {
                    iterator = this.b.get((String)iterator2.next());
                    if ((List)iterator == null) {
                    } else {
                    }
                    iterator = (List)iterator.iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((e.a)next.a(class, class2) && !arrayList.contains(next.b)) {
                        }
                        if (!arrayList.contains(next.b)) {
                        }
                        arrayList.add(next.b);
                    }
                    next = iterator.next();
                    if ((e.a)next.a(class, class2) && !arrayList.contains(next.b)) {
                    }
                    if (!arrayList.contains(next.b)) {
                    }
                    arrayList.add(next.b);
                }
                iterator = this.b.get((String)iterator2.next());
                if ((List)iterator == null) {
                } else {
                }
                iterator = (List)iterator.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((e.a)next.a(class, class2) && !arrayList.contains(next.b)) {
                    }
                    if (!arrayList.contains(next.b)) {
                    }
                    arrayList.add(next.b);
                }
                next = iterator.next();
                if ((e.a)next.a(class, class2) && !arrayList.contains(next.b)) {
                }
                if (!arrayList.contains(next.b)) {
                }
                arrayList.add(next.b);
                return arrayList;
                throw class;
            }
        }
    }

    public void e(List<String> list) {
        Iterator iterator;
        Object next;
        boolean contains;
        List list2;
        ArrayList arrayList = new ArrayList(this.a);
        this.a.clear();
        iterator = list.iterator();
        synchronized (this) {
            try {
                for (String next : iterator) {
                    this.a.add(next);
                }
                this.a.add((String)iterator.next());
                Iterator iterator2 = arrayList.iterator();
                while (iterator2.hasNext()) {
                    iterator = iterator2.next();
                    if (!list.contains((String)iterator)) {
                    }
                    this.a.add(iterator);
                }
                iterator = iterator2.next();
                if (!list.contains((String)iterator)) {
                }
                this.a.add(iterator);
                throw list;
            }
        }
    }
}
