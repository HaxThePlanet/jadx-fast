package androidx.room.f1;

import android.database.Cursor;
import android.os.Build.VERSION;
import androidx.room.k0;
import d.s.a.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class g {

    public final String a;
    public final Map<String, androidx.room.f1.g.a> b;
    public final Set<androidx.room.f1.g.b> c;
    public final Set<androidx.room.f1.g.d> d;

    public static final class a {

        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        private final int g;
        public a(String string, String string2, boolean z3, int i4, String string5, int i6) {
            super();
            this.a = string;
            this.b = string2;
            this.d = z3;
            this.e = i4;
            this.c = g.a.c(string2);
            this.f = string5;
            this.g = i6;
        }

        private static boolean a(String string) {
            int i5;
            int i4;
            int i3;
            char charAt;
            int i;
            int i2;
            i4 = 0;
            if (string.length() == 0) {
                return i4;
            }
            i3 = i5;
            i = 1;
            while (i5 < string.length()) {
                charAt = string.charAt(i5);
                i2 = 40;
                i5++;
                i = 1;
                i3++;
            }
            if (i3 == 0) {
                i4 = i;
            }
            return i4;
        }

        public static boolean b(String string, String string2) {
            int i = 0;
            if (string2 == null) {
                return i;
            }
            final int i3 = 1;
            if (string.equals(string2)) {
                return i3;
            }
            if (g.a.a(string)) {
                return string.substring(i3, length -= i3).trim().equals(string2);
            }
            return i;
        }

        private static int c(String string) {
            boolean contains;
            boolean contains2;
            String obj2;
            int i = 5;
            if (string == null) {
                return i;
            }
            obj2 = string.toUpperCase(Locale.US);
            if (obj2.contains("INT")) {
                return 3;
            }
            if (!obj2.contains("CHAR") && !obj2.contains("CLOB")) {
                if (!obj2.contains("CLOB")) {
                    if (obj2.contains("TEXT")) {
                    } else {
                        if (obj2.contains("BLOB")) {
                            return i;
                        }
                        if (!obj2.contains("REAL") && !obj2.contains("FLOA") && obj2.contains("DOUB")) {
                            if (!obj2.contains("FLOA")) {
                                if (obj2.contains("DOUB")) {
                                }
                                return 1;
                            }
                        }
                    }
                    return 4;
                }
            }
            return 2;
        }

        public boolean d() {
            int i;
            i = this.e > 0 ? 1 : 0;
            return i;
        }

        public boolean equals(Object object) {
            int i5;
            int i7;
            int i6;
            int i4;
            String i;
            int i2;
            int i3;
            String str;
            i5 = 1;
            if (this == object) {
                return i5;
            }
            final int i9 = 0;
            if (!object instanceof g.a) {
                return i9;
            }
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.e != object.e) {
                    return i9;
                }
            } else {
                if (d() != (g.a)object.d()) {
                    return i9;
                }
            }
            if (!this.a.equals(object.a)) {
                return i9;
            }
            if (this.d != object.d) {
                return i9;
            }
            i3 = 2;
            i6 = this.f;
            if (this.g == i5 && object.g == i3 && i6 != null && !g.a.b(i6, object.f)) {
                if (object.g == i3) {
                    i6 = this.f;
                    if (i6 != null) {
                        if (!g.a.b(i6, object.f)) {
                            return i9;
                        }
                    }
                }
            }
            i4 = object.f;
            if (this.g == i3 && object.g == i5 && i4 != null && !g.a.b(i4, this.f)) {
                if (object.g == i5) {
                    i4 = object.f;
                    if (i4 != null) {
                        if (!g.a.b(i4, this.f)) {
                            return i9;
                        }
                    }
                }
            }
            i = this.g;
            if (i != 0 && i == object.g) {
                if (i == object.g) {
                    String str3 = this.f;
                    if (str3 != null) {
                        if (!g.a.b(str3, object.f)) {
                            return i9;
                        }
                    } else {
                        if (object.f != null) {
                        }
                    }
                }
            }
            if (this.c == object.c) {
            } else {
                i5 = i9;
            }
            return i5;
        }

        public int hashCode() {
            int i;
            i = this.d ? 1231 : 1237;
            return i7 += i10;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Column{name='");
            stringBuilder.append(this.a);
            int i = 39;
            stringBuilder.append(i);
            stringBuilder.append(", type='");
            stringBuilder.append(this.b);
            stringBuilder.append(i);
            stringBuilder.append(", affinity='");
            stringBuilder.append(this.c);
            stringBuilder.append(i);
            stringBuilder.append(", notNull=");
            stringBuilder.append(this.d);
            stringBuilder.append(", primaryKeyPosition=");
            stringBuilder.append(this.e);
            stringBuilder.append(", defaultValue='");
            stringBuilder.append(this.f);
            stringBuilder.append(i);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static final class b {

        public final String a;
        public final String b;
        public final String c;
        public final List<String> d;
        public final List<String> e;
        public b(String string, String string2, String string3, List<String> list4, List<String> list5) {
            super();
            this.a = string;
            this.b = string2;
            this.c = string3;
            this.d = Collections.unmodifiableList(list4);
            this.e = Collections.unmodifiableList(list5);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (!object instanceof g.b) {
                return i;
            }
            if (!this.a.equals(object.a)) {
                return i;
            }
            if (!this.b.equals(object.b)) {
                return i;
            }
            if (!this.c.equals(object.c)) {
                return i;
            }
            if (!this.d.equals(object.d)) {
                return i;
            }
            return this.e.equals(object.e);
        }

        public int hashCode() {
            return i8 += i13;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ForeignKey{referenceTable='");
            stringBuilder.append(this.a);
            int i = 39;
            stringBuilder.append(i);
            stringBuilder.append(", onDelete='");
            stringBuilder.append(this.b);
            stringBuilder.append(i);
            stringBuilder.append(", onUpdate='");
            stringBuilder.append(this.c);
            stringBuilder.append(i);
            stringBuilder.append(", columnNames=");
            stringBuilder.append(this.d);
            stringBuilder.append(", referenceColumnNames=");
            stringBuilder.append(this.e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static class c implements Comparable<androidx.room.f1.g.c> {

        final int a;
        final int b;
        final String c;
        final String v;
        c(int i, int i2, String string3, String string4) {
            super();
            this.a = i;
            this.b = i2;
            this.c = string3;
            this.v = string4;
        }

        @Override // java.lang.Comparable
        public int a(androidx.room.f1.g.c g$c) {
            int i;
            Object obj3;
            if (i2 -= i4 == 0) {
                i3 -= obj3;
            }
            return i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((g.c)object);
        }
    }

    public static final class d {

        public final String a;
        public final boolean b;
        public final List<String> c;
        public final List<String> d;
        public d(String string, boolean z2, List<String> list3, List<String> list4) {
            int obj1;
            boolean obj2;
            List obj4;
            super();
            this.a = string;
            this.b = z2;
            this.c = list3;
            if (list4 != null) {
                if (list4.size() == 0) {
                    obj4 = Collections.nCopies(list3.size(), k0.ASC.name());
                }
            } else {
            }
            this.d = obj4;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return 1;
            }
            int i = 0;
            if (!object instanceof g.d) {
                return i;
            }
            if (this.b != object.b) {
                return i;
            }
            if (!this.c.equals(object.c)) {
                return i;
            }
            if (!this.d.equals(object.d)) {
                return i;
            }
            String str3 = "index_";
            if (this.a.startsWith(str3)) {
                return object.a.startsWith(str3);
            }
            return this.a.equals(object.a);
        }

        public int hashCode() {
            int i;
            if (this.a.startsWith("index_")) {
                i = -1184239155;
            } else {
                i = this.a.hashCode();
            }
            return i6 += i9;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index{name='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", unique=");
            stringBuilder.append(this.b);
            stringBuilder.append(", columns=");
            stringBuilder.append(this.c);
            stringBuilder.append(", orders=");
            stringBuilder.append(this.d);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    public g(String string, Map<String, androidx.room.f1.g.a> map2, Set<androidx.room.f1.g.b> set3, Set<androidx.room.f1.g.d> set4) {
        int obj1;
        super();
        this.a = string;
        this.b = Collections.unmodifiableMap(map2);
        this.c = Collections.unmodifiableSet(set3);
        if (set4 == null) {
            obj1 = 0;
        } else {
            obj1 = Collections.unmodifiableSet(set4);
        }
        this.d = obj1;
    }

    public static androidx.room.f1.g a(g g, String string2) {
        g gVar = new g(string2, g.b(g, string2), g.d(g, string2), g.f(g, string2));
        return gVar;
    }

    private static Map<String, androidx.room.f1.g.a> b(g g, String string2) {
        int columnCount;
        String columnIndex2;
        int columnIndex3;
        int columnIndex4;
        int columnIndex;
        boolean moveToNext;
        androidx.room.f1.g.a aVar;
        int i;
        String str;
        String string3;
        int i3;
        int int;
        String string;
        int i2;
        androidx.room.f1.g.a aVar2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA table_info(`");
        stringBuilder.append(string2);
        stringBuilder.append("`)");
        final Cursor obj14 = g.H0(stringBuilder.toString());
        HashMap obj15 = new HashMap();
        if (obj14.getColumnCount() > 0) {
            while (obj14.moveToNext()) {
                moveToNext = obj14.getString(obj14.getColumnIndex("name"));
                if (obj14.getInt(obj14.getColumnIndex("notnull")) != 0) {
                } else {
                }
                i = 0;
                super(moveToNext, obj14.getString(obj14.getColumnIndex("type")), i, obj14.getInt(obj14.getColumnIndex("pk")), obj14.getString(obj14.getColumnIndex("dflt_value")), 2);
                obj15.put(moveToNext, aVar2);
                i = 1;
            }
        }
        obj14.close();
        return obj15;
    }

    private static List<androidx.room.f1.g.c> c(Cursor cursor) {
        int i;
        androidx.room.f1.g.c cVar;
        int int2;
        int int;
        String string;
        String string2;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < cursor.getCount()) {
            cursor.moveToPosition(i);
            cVar = new g.c(cursor.getInt(cursor.getColumnIndex("id")), cursor.getInt(cursor.getColumnIndex("seq")), cursor.getString(cursor.getColumnIndex("from")), cursor.getString(cursor.getColumnIndex("to")));
            arrayList.add(cVar);
            i++;
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<androidx.room.f1.g.b> d(g g, String string2) {
        int i;
        int bVar;
        androidx.room.f1.g.b bVar2;
        String string;
        String string3;
        String str;
        ArrayList arrayList;
        ArrayList list;
        ArrayList list2;
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA foreign_key_list(`");
        stringBuilder.append(string2);
        stringBuilder.append("`)");
        Cursor cursor = g.H0(stringBuilder.toString());
        i = 0;
        while (i < cursor.getCount()) {
            cursor.moveToPosition(i);
            if (cursor.getInt(cursor.getColumnIndex("seq")) != 0) {
            } else {
            }
            arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator = g.c(cursor).iterator();
            while (iterator.hasNext()) {
                string = iterator.next();
                if (string.a == cursor.getInt(cursor.getColumnIndex("id"))) {
                }
                arrayList.add(string.c);
                arrayList2.add(string.v);
            }
            super(cursor.getString(cursor.getColumnIndex("table")), cursor.getString(cursor.getColumnIndex("on_delete")), cursor.getString(cursor.getColumnIndex("on_update")), arrayList, arrayList2);
            hashSet.add(bVar);
            i++;
            string = iterator.next();
            if (string.a == cursor.getInt(cursor.getColumnIndex("id"))) {
            }
            arrayList.add(string.c);
            arrayList2.add(string.v);
        }
        cursor.close();
        return hashSet;
    }

    private static androidx.room.f1.g.d e(g g, String string2, boolean z3) {
        Integer valueOf;
        String string;
        String str;
        Integer valueOf2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA index_xinfo(`");
        stringBuilder.append(string2);
        stringBuilder.append("`)");
        final Cursor obj10 = g.H0(stringBuilder.toString());
        int columnIndex = obj10.getColumnIndex("seqno");
        int columnIndex2 = obj10.getColumnIndex("cid");
        int columnIndex3 = obj10.getColumnIndex("name");
        int columnIndex4 = obj10.getColumnIndex("desc");
        int i = -1;
        if (columnIndex != i && columnIndex2 != i && columnIndex3 != i) {
            if (columnIndex2 != i) {
                if (columnIndex3 != i) {
                    if (columnIndex4 == i) {
                    } else {
                        TreeMap treeMap = new TreeMap();
                        TreeMap treeMap2 = new TreeMap();
                        while (obj10.moveToNext()) {
                            if (obj10.getInt(columnIndex2) < 0) {
                            } else {
                            }
                            int int = obj10.getInt(columnIndex);
                            if (obj10.getInt(columnIndex4) > 0) {
                            } else {
                            }
                            str = "ASC";
                            treeMap.put(Integer.valueOf(int), obj10.getString(columnIndex3));
                            treeMap2.put(Integer.valueOf(int), str);
                            str = "DESC";
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    ArrayList arrayList2 = new ArrayList(treeMap2.size());
                    arrayList2.addAll(treeMap2.values());
                    g.d dVar = new g.d(string2, z3, arrayList, arrayList2);
                    obj10.close();
                    return dVar;
                }
            }
        }
        obj10.close();
        return null;
    }

    private static Set<androidx.room.f1.g.d> f(g g, String string2) {
        boolean equals;
        String str;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA index_list(`");
        stringBuilder.append(string2);
        stringBuilder.append("`)");
        Cursor obj9 = g.H0(stringBuilder.toString());
        int columnIndex = obj9.getColumnIndex("name");
        int columnIndex2 = obj9.getColumnIndex("origin");
        int columnIndex3 = obj9.getColumnIndex("unique");
        final int i2 = 0;
        int i3 = -1;
        if (columnIndex != i3 && columnIndex2 != i3) {
            if (columnIndex2 != i3) {
                if (columnIndex3 == i3) {
                } else {
                    HashSet hashSet = new HashSet();
                    while (obj9.moveToNext()) {
                        if (obj9.getInt(columnIndex3) == 1) {
                        } else {
                        }
                        i = 0;
                        equals = g.e(g, obj9.getString(columnIndex), i);
                        hashSet.add(equals);
                    }
                }
                obj9.close();
                return hashSet;
            }
        }
        obj9.close();
        return i2;
    }

    public boolean equals(Object object) {
        String equals2;
        Map equals3;
        Set equals;
        String str;
        Object obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof g) {
            return i2;
        }
        String str2 = this.a;
        if (str2 != null) {
            if (!str2.equals(object.a)) {
                return i2;
            }
        } else {
            if (object.a != null) {
            }
        }
        Map map = this.b;
        if (map != null) {
            if (!map.equals(object.b)) {
                return i2;
            }
        } else {
            if (object.b != null) {
            }
        }
        Set set = this.c;
        if (set != null) {
            if (!set.equals(object.c)) {
                return i2;
            }
        } else {
            if (object.c != null) {
            }
        }
        Set set2 = this.d;
        obj5 = object.d;
        if (set2 != null && obj5 == null) {
            obj5 = object.d;
            if (obj5 == null) {
            }
            return set2.equals(obj5);
        }
        return i;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i;
        String str = this.a;
        i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = i3;
        }
        Map map = this.b;
        if (map != null) {
            i = map.hashCode();
        } else {
            i = i3;
        }
        Set set = this.c;
        if (set != null) {
            i3 = set.hashCode();
        }
        return i6 += i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TableInfo{name='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", columns=");
        stringBuilder.append(this.b);
        stringBuilder.append(", foreignKeys=");
        stringBuilder.append(this.c);
        stringBuilder.append(", indices=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
