package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.DateFormats;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: JwtMap.java */
/* loaded from: classes3.dex */
public class JwtMap implements Map<String, Object> {

    private final Map<String, Object> map;
    public JwtMap() {
        super();
        this.map = new LinkedHashMap();
    }

    private static Date parseIso8601Date(String str, String str2) {
        try {
        } catch (java.text.ParseException parse) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "'";
            str2 = "' value does not appear to be ISO-8601-formatted: ";
            str = str3 + str2 + str2 + str;
            str2 = new IllegalArgumentException(str, parse);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        }
        return DateFormats.parseIso8601Date(str);
    }

    protected static Date toDate(Object object, String str) {
        if (object == null) {
            return null;
        }
        if (object instanceof Date) {
            return object;
        }
        if (object instanceof Calendar) {
            return object.getTime();
        }
        if (object instanceof Number) {
            return new Date(object.longValue(), str);
        }
        if (!(object instanceof String)) {
            final StringBuilder stringBuilder = new StringBuilder();
            str = "Cannot create Date from '";
            final String str4 = "' value '";
            String str3 = "'.";
            object = str + str + str4 + object + str3;
            throw new IllegalStateException(object);
        } else {
            return JwtMap.parseIso8601Date(object, str);
        }
    }

    protected static Date toSpecDate(Object object, String str) {
        if (object == null) {
            return null;
        }
        final long l2 = 1000L;
        if (object instanceof Number) {
            Long num = Long.valueOf(object.longValue() * 1000L);
        } else {
            if (object instanceof String) {
                try {
                    num = Long.valueOf(Long.parseLong((String)object) * 1000L);
                } catch (java.lang.NumberFormatException unused) {
                    return JwtMap.toDate(num, str);
                }
            }
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    @Override // java.util.Map
    public boolean containsValue(Object object) {
        return this.map.containsValue(object);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        return this.map.equals(object);
    }

    @Override // java.util.Map
    public Object get(Object object) {
        return this.map.get(object);
    }

    protected String getString(String str) {
        String str2 = null;
        Object value = get(str);
        if (value != null) {
            str2 = String.valueOf(value);
        } else {
            int i = 0;
        }
        return str2;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ?> map) {
        if (map == null) {
            return;
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            put(item, map.get(item));
        }
    }

    @Override // java.util.Map
    public Object remove(Object object) {
        return this.map.remove(object);
    }

    @Deprecated
    protected void setDate(String str, Date date) {
        if (date == null) {
            this.map.remove(str);
        } else {
            long l = 1000L;
            this.map.put(str, Long.valueOf(date.getTime() / l));
        }
    }

    protected Object setDateAsSeconds(String str, Date date) {
        if (date == null) {
            return this.map.remove(str);
        }
        return this.map.put(str, Long.valueOf(date.getTime() / 1000L));
    }

    protected void setValue(String str, Object object) {
        if (object == null) {
            this.map.remove(str);
        } else {
            this.map.put(str, object);
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.map.toString();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    @Override // java.util.Map
    public Object put(String str, Object object) {
        if (object == null) {
            return this.map.remove(str);
        }
        return this.map.put(str, object);
    }

    public JwtMap(Map<String, ?> map) {
        this();
        Assert.notNull(map, "Map argument cannot be null.");
        putAll(map);
    }
}
