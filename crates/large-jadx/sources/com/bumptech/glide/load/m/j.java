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

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements h {

    private final Map<String, List<i>> b;
    private volatile Map<String, String> c;

    public static final class a {

        private static final String d;
        private static final Map<String, List<i>> e;
        private boolean a = true;
        private Map<String, List<i>> b;
        private boolean c = true;
        static {
            String str = j.a.g();
            j.a.d = str;
            final HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("User-Agent", Collections.singletonList(new j.b(str)));
            }
            j.a.e = Collections.unmodifiableMap(hashMap);
        }

        public a() {
            super();
            this.b = j.a.e;
        }

        private Map<String, List<i>> d() {
            final HashMap hashMap = new HashMap(this.b.size());
            Iterator it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                hashMap.put(item.getKey(), new ArrayList((Collection)item.getValue()));
            }
            return hashMap;
        }

        private void e() {
            if (this.a) {
                this.a = false;
                this.b = d();
            }
        }

        private List<i> f(String str) {
            Object value;
            if ((List)this.b.get(str) == null) {
                this.b.put(str, new ArrayList());
            }
            return value;
        }

        static String g() {
            int i = 0;
            char charAt = 63;
            char c = 127;
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            final StringBuilder stringBuilder = new StringBuilder(property.length());
            i = 0;
            while (i < property.length()) {
                charAt = property.charAt(i);
                c = '\u001f';
                i = i + 1;
            }
            return stringBuilder.toString();
        }

        public j.a a(String str, i iVar) {
            if (this.c) {
                if ("User-Agent".equalsIgnoreCase(str)) {
                    h(str, iVar);
                    return this;
                }
            }
            e();
            f(str).add(iVar);
            return this;
        }

        public j.a b(String str, String str2) {
            a(str, new j.b(str2));
            return this;
        }

        public j c() {
            this.a = true;
            return new j(this.b);
        }

        public j.a h(String str, i iVar) {
            e();
            if (iVar == null) {
                this.b.remove(str);
            } else {
                List list = f(str);
                list.clear();
                list.add(iVar);
            }
            if (this.c) {
                if ("User-Agent".equalsIgnoreCase(str)) {
                    boolean equalsIgnoreCase = false;
                    this.c = equalsIgnoreCase;
                }
            }
            return this;
        }
    }

    static final class b implements i {

        private final String a;
        b(String str) {
            super();
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            if (object instanceof j.b) {
                return this.a.equals(object.a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "StringHeaderFactory{value='";
            str = str2 + this.a + 39 + 125;
            return str;
        }
    }
    j(Map<String, List<i>> map) {
        super();
        this.b = Collections.unmodifiableMap(map);
    }

    private String b(List<i> list) {
        int i = 0;
        String str;
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < list.size()) {
            str = (i)list.get(i).a();
            i = i + 1;
        }
        return stringBuilder.toString();
    }

    private Map<String, String> c() {
        final HashMap hashMap = new HashMap();
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String str = b((List)item.getValue());
        }
        return hashMap;
    }

    public Map<String, String> a() {
        Map unmodifiable;
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.c = Collections.unmodifiableMap(c());
                    }
                } catch (Throwable th) {
                }
            }
        }
        return this.c;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof j) {
            return this.b.equals(object.b);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LazyHeaders{headers=";
        str = str2 + this.b + 125;
        return str;
    }
}
