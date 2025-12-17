package com.bumptech.glide.load.m;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.m.h {

    private final Map<String, List<com.bumptech.glide.load.m.i>> b;
    private volatile Map<String, String> c;

    public static final class a {

        private static final String d;
        private static final Map<String, List<com.bumptech.glide.load.m.i>> e;
        private boolean a = true;
        private Map<String, List<com.bumptech.glide.load.m.i>> b;
        private boolean c = true;
        static {
            Object singletonList;
            boolean empty;
            singletonList = j.a.g();
            j.a.d = singletonList;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(singletonList)) {
                j.b bVar = new j.b(singletonList);
                hashMap.put("User-Agent", Collections.singletonList(bVar));
            }
            j.a.e = Collections.unmodifiableMap(hashMap);
        }

        public a() {
            super();
            final int i = 1;
            this.b = j.a.e;
        }

        private Map<String, List<com.bumptech.glide.load.m.i>> d() {
            Object key;
            ArrayList arrayList;
            Object value;
            HashMap hashMap = new HashMap(this.b.size());
            Iterator iterator = this.b.entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                arrayList = new ArrayList((Collection)next2.getValue());
                hashMap.put(next2.getKey(), arrayList);
            }
            return hashMap;
        }

        private void e() {
            boolean z;
            if (this.a) {
                this.a = false;
                this.b = d();
            }
        }

        private List<com.bumptech.glide.load.m.i> f(String string) {
            Object arrayList;
            Map map;
            if ((List)this.b.get(string) == null) {
                arrayList = new ArrayList();
                this.b.put(string, arrayList);
            }
            return arrayList;
        }

        static String g() {
            int i;
            char charAt;
            int i2;
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            StringBuilder stringBuilder = new StringBuilder(property.length());
            i = 0;
            while (i < property.length()) {
                charAt = property.charAt(i);
                if (charAt <= 31) {
                } else {
                }
                if (charAt < 127) {
                } else {
                }
                stringBuilder.append('?');
                i++;
                stringBuilder.append(charAt);
                if (charAt == 9 && charAt < 127) {
                } else {
                }
            }
            return stringBuilder.toString();
        }

        public com.bumptech.glide.load.m.j.a a(String string, com.bumptech.glide.load.m.i i2) {
            boolean equalsIgnoreCase;
            if (this.c && "User-Agent".equalsIgnoreCase(string)) {
                if ("User-Agent".equalsIgnoreCase(string)) {
                    h(string, i2);
                    return this;
                }
            }
            e();
            f(string).add(i2);
            return this;
        }

        public com.bumptech.glide.load.m.j.a b(String string, String string2) {
            j.b bVar = new j.b(string2);
            a(string, bVar);
            return this;
        }

        public com.bumptech.glide.load.m.j c() {
            this.a = true;
            j jVar = new j(this.b);
            return jVar;
        }

        public com.bumptech.glide.load.m.j.a h(String string, com.bumptech.glide.load.m.i i2) {
            List list;
            Object obj2;
            Object obj3;
            e();
            if (i2 == null) {
                this.b.remove(string);
            } else {
                list = f(string);
                list.clear();
                list.add(i2);
            }
            if (this.c && "User-Agent".equalsIgnoreCase(string)) {
                if ("User-Agent".equalsIgnoreCase(string)) {
                    this.c = false;
                }
            }
            return this;
        }
    }

    static final class b implements com.bumptech.glide.load.m.i {

        private final String a;
        b(String string) {
            super();
            this.a = string;
        }

        @Override // com.bumptech.glide.load.m.i
        public String a() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.m.i
        public boolean equals(Object object) {
            if (object instanceof j.b) {
                return this.a.equals(object.a);
            }
            return 0;
        }

        @Override // com.bumptech.glide.load.m.i
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // com.bumptech.glide.load.m.i
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("StringHeaderFactory{value='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    j(Map<String, List<com.bumptech.glide.load.m.i>> map) {
        super();
        this.b = Collections.unmodifiableMap(map);
    }

    private String b(List<com.bumptech.glide.load.m.i> list) {
        int i;
        String str;
        boolean empty;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < list.size()) {
            str = (i)list.get(i).a();
            stringBuilder.append(str);
            if (!TextUtils.isEmpty(str) && i != size2--) {
            }
            i++;
            stringBuilder.append(str);
            if (i != size2--) {
            }
            stringBuilder.append(',');
        }
        return stringBuilder.toString();
    }

    private Map<String, String> c() {
        Object next;
        String str;
        boolean empty;
        HashMap hashMap = new HashMap();
        Iterator iterator = this.b.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            str = b((List)(Map.Entry)next.getValue());
            if (!TextUtils.isEmpty(str)) {
            }
            hashMap.put(next.getKey(), str);
        }
        return hashMap;
    }

    public Map<String, String> a() {
        Map unmodifiableMap;
        if (this.c == null && this.c == null) {
            synchronized (this) {
                this.c = Collections.unmodifiableMap(c());
            }
        }
        try {
            return this.c;
        }
    }

    @Override // com.bumptech.glide.load.m.h
    public boolean equals(Object object) {
        if (object instanceof j) {
            return this.b.equals(object.b);
        }
        return 0;
    }

    @Override // com.bumptech.glide.load.m.h
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.bumptech.glide.load.m.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LazyHeaders{headers=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
