package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.DateFormats;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes3.dex */
public class JwtMap implements Map<String, Object> {

    private final Map<String, Object> map;
    public JwtMap() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.map = linkedHashMap;
    }

    public JwtMap(Map<String, ?> map) {
        super();
        Assert.notNull(map, "Map argument cannot be null.");
        putAll(map);
    }

    private static Date parseIso8601Date(String string, String string2) {
        try {
            return DateFormats.parseIso8601Date(string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            stringBuilder.append(string2);
            string2 = "' value does not appear to be ISO-8601-formatted: ";
            stringBuilder.append(string2);
            stringBuilder.append(string);
            string = stringBuilder.toString();
            string2 = new IllegalArgumentException(string, th);
            throw string2;
        }
    }

    protected static Date toDate(Object object, String string2) {
        if (object == null) {
            return null;
        }
        if (object instanceof Date) {
            return (Date)object;
        }
        if (object instanceof Calendar) {
            return (Calendar)object.getTime();
        }
        if (object instanceof Number) {
            Date date = new Date((Number)object.longValue(), string2);
            return date;
        }
        if (object instanceof String == null) {
        } else {
            return JwtMap.parseIso8601Date((String)object, string2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create Date from '");
        stringBuilder.append(string2);
        stringBuilder.append("' value '");
        stringBuilder.append(object);
        stringBuilder.append("'.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    protected static Date toSpecDate(Object object, String string2) {
        boolean z;
        int i;
        Object obj5;
        if (object == null) {
            return null;
        }
        final int i2 = 1000;
        if (object instanceof Number) {
            obj5 = Long.valueOf(longValue *= i2);
        } else {
            if (object instanceof String != null) {
                obj5 = Long.valueOf(long *= i2);
            }
        }
        return JwtMap.toDate(obj5, string2);
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

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object object) {
        return this.map.equals(object);
    }

    @Override // java.util.Map
    public Object get(Object object) {
        return this.map.get(object);
    }

    @Override // java.util.Map
    protected String getString(String string) {
        String obj1;
        obj1 = get(string);
        if (obj1 != null) {
            obj1 = String.valueOf(obj1);
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public Object put(Object object, Object object2) {
        return put((String)object, object2);
    }

    @Override // java.util.Map
    public Object put(String string, Object object2) {
        if (object2 == null) {
            return this.map.remove(string);
        }
        return this.map.put(string, object2);
    }

    public void putAll(Map<? extends String, ?> map) {
        Object next;
        Object obj;
        if (map == null) {
        }
        Iterator iterator = map.keySet().iterator();
        for (String next : iterator) {
            put(next, map.get(next));
        }
    }

    @Override // java.util.Map
    public Object remove(Object object) {
        return this.map.remove(object);
    }

    @Deprecated
    protected void setDate(String string, Date date2) {
        Long valueOf;
        int i;
        Map obj6;
        if (date2 == null) {
            this.map.remove(string);
        } else {
            this.map.put(string, Long.valueOf(time /= i));
        }
    }

    @Override // java.util.Map
    protected Object setDateAsSeconds(String string, Date date2) {
        if (date2 == null) {
            return this.map.remove(string);
        }
        return this.map.put(string, Long.valueOf(time /= i2));
    }

    @Override // java.util.Map
    protected void setValue(String string, Object object2) {
        Map map;
        Object obj3;
        if (object2 == null) {
            this.map.remove(string);
        } else {
            this.map.put(string, object2);
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public String toString() {
        return this.map.toString();
    }

    public Collection<Object> values() {
        return this.map.values();
    }
}
