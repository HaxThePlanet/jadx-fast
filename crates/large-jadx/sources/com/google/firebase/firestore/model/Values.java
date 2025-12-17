package com.google.firebase.firestore.model;

import android.accounts.Account;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.c1;
import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.r1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import f.c.e.c.a;
import f.c.e.c.b;
import f.c.e.c.r;
import f.c.e.c.x;
import f.c.e.c.x.b;
import f.c.e.c.x.c;
import f.c.h.b;
import f.c.h.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class Values {

    public static final x NAN_VALUE = null;
    public static final x NULL_VALUE = null;
    public static final int TYPE_ORDER_ARRAY = 9;
    public static final int TYPE_ORDER_BLOB = 6;
    public static final int TYPE_ORDER_BOOLEAN = 1;
    public static final int TYPE_ORDER_GEOPOINT = 8;
    public static final int TYPE_ORDER_MAP = 10;
    public static final int TYPE_ORDER_NULL = 0;
    public static final int TYPE_ORDER_NUMBER = 2;
    public static final int TYPE_ORDER_REFERENCE = 7;
    public static final int TYPE_ORDER_SERVER_TIMESTAMP = 4;
    public static final int TYPE_ORDER_STRING = 5;
    public static final int TYPE_ORDER_TIMESTAMP = 3;
    static {
        x.b bVar = x.x();
        bVar.g(9221120237041090560L);
        Values.NAN_VALUE = (x)bVar.build();
        x.b bVar2 = x.x();
        bVar2.m(c1.NULL_VALUE);
        Values.NULL_VALUE = (x)bVar2.build();
    }

    private static boolean arrayEquals(x x, x x2) {
        int i;
        int equals;
        x xVar;
        a obj4 = x.n();
        final a obj5 = x2.n();
        final int i4 = 0;
        if (obj4.k() != obj5.k()) {
            return i4;
        }
        i = i4;
        while (i < obj4.k()) {
            i++;
        }
        return 1;
    }

    public static String canonicalId(x x) {
        StringBuilder stringBuilder = new StringBuilder();
        Values.canonifyValue(stringBuilder, x);
        return stringBuilder.toString();
    }

    private static void canonifyArray(StringBuilder stringBuilder, a a2) {
        int i;
        int str;
        stringBuilder.append("[");
        i = 0;
        while (i < a2.k()) {
            Values.canonifyValue(stringBuilder, a2.j(i));
            if (i != i3--) {
            }
            i++;
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
    }

    private static void canonifyGeoPoint(StringBuilder stringBuilder, b b2) {
        Object[] arr = new Object[2];
        final int i3 = 0;
        arr[i3] = Double.valueOf(b2.f());
        arr[1] = Double.valueOf(b2.g());
        stringBuilder.append(String.format("geo(%s,%s)", arr));
    }

    private static void canonifyObject(StringBuilder stringBuilder, r r2) {
        int i;
        x xVar;
        String str;
        ArrayList arrayList = new ArrayList(r2.f().keySet());
        Collections.sort(arrayList);
        stringBuilder.append("{");
        Iterator iterator = arrayList.iterator();
        i = 1;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (i == 0) {
            } else {
            }
            i = 0;
            stringBuilder.append((String)next2);
            stringBuilder.append(":");
            Values.canonifyValue(stringBuilder, r2.h(next2));
            stringBuilder.append(",");
        }
        stringBuilder.append("}");
    }

    private static void canonifyReference(StringBuilder stringBuilder, x x2) {
        Assert.hardAssert(Values.isReferenceValue(x2), "Value should be a ReferenceValue", new Object[0]);
        stringBuilder.append(DocumentKey.fromName(x2.u()));
    }

    private static void canonifyTimestamp(StringBuilder stringBuilder, r1 r12) {
        Object[] arr = new Object[2];
        stringBuilder.append(String.format("time(%s,%s)", Long.valueOf(r12.g()), Integer.valueOf(r12.f())));
    }

    private static void canonifyValue(StringBuilder stringBuilder, x x2) {
        int doubleValue;
        String obj3;
        int ordinal = x2.w().ordinal();
        switch (doubleValue) {
            case 1:
                stringBuilder.append("null");
                break;
            case 2:
                stringBuilder.append(x2.o());
                break;
            case 3:
                stringBuilder.append(x2.s());
                break;
            case 4:
                stringBuilder.append(x2.getDoubleValue());
                break;
            case 5:
                Values.canonifyTimestamp(stringBuilder, x2.v());
                break;
            case 6:
                stringBuilder.append(x2.getStringValue());
                break;
            case 7:
                stringBuilder.append(Util.toDebugString(x2.p()));
                break;
            case 8:
                Values.canonifyReference(stringBuilder, x2);
                break;
            case 9:
                Values.canonifyGeoPoint(stringBuilder, x2.r());
                break;
            case 10:
                Values.canonifyArray(stringBuilder, x2.n());
                break;
            case 11:
                Values.canonifyObject(stringBuilder, x2.t());
                break;
            default:
                StringBuilder obj2 = new StringBuilder();
                obj2.append("Invalid value type: ");
                obj2.append(x2.w());
                throw Assert.fail(obj2.toString(), new Object[0]);
        }
    }

    public static int compare(x x, x x2) {
        final int typeOrder = Values.typeOrder(x);
        int typeOrder2 = Values.typeOrder(x2);
        if (typeOrder != typeOrder2) {
            return Util.compareIntegers(typeOrder, typeOrder2);
        }
        int i = 0;
        switch (typeOrder) {
            case 0:
                return i;
            case 1:
                return Util.compareBooleans(x.o(), x2.o());
            case 2:
                return Values.compareNumbers(x, x2);
            case 3:
                return Values.compareTimestamps(x.v(), x2.v());
            case 4:
                return Values.compareTimestamps(ServerTimestamps.getLocalWriteTime(x), ServerTimestamps.getLocalWriteTime(x2));
            case 5:
                return x.getStringValue().compareTo(x2.getStringValue());
            case 6:
                return Util.compareByteStrings(x.p(), x2.p());
            case 7:
                return Values.compareReferences(x.u(), x2.u());
            case 8:
                return Values.compareGeoPoints(x.r(), x2.r());
            case 9:
                return Values.compareArrays(x.n(), x2.n());
            case 10:
                return Values.compareMaps(x.t(), x2.t());
            default:
                StringBuilder obj2 = new StringBuilder();
                obj2.append("Invalid value type: ");
                obj2.append(typeOrder);
                throw Assert.fail(obj2.toString(), new Object[i]);
        }
    }

    private static int compareArrays(a a, a a2) {
        int i;
        int compare;
        x xVar;
        i = 0;
        while (i < Math.min(a.k(), a2.k())) {
            compare = Values.compare(a.j(i), a2.j(i));
            i++;
        }
        return Util.compareIntegers(a.k(), a2.k());
    }

    private static int compareGeoPoints(b b, b b2) {
        int compareDoubles = Util.compareDoubles(b.f(), obj1);
        if (compareDoubles == 0) {
            return Util.compareDoubles(b.g(), obj1);
        }
        return compareDoubles;
    }

    private static int compareMaps(r r, r r2) {
        TreeMap treeMap;
        boolean next;
        Object value;
        int compareTo;
        Object key;
        TreeMap treeMap2 = new TreeMap(r.f());
        Iterator obj4 = treeMap2.entrySet().iterator();
        treeMap = new TreeMap(r2.f());
        Iterator obj5 = treeMap.entrySet().iterator();
        while (obj4.hasNext()) {
            Object next2 = obj4.next();
            Object next3 = obj5.next();
            compareTo = (String)(Map.Entry)next2.getKey().compareTo((String)(Map.Entry)next3.getKey());
            treeMap = Values.compare((x)next2.getValue(), (x)next3.getValue());
        }
        return Util.compareBooleans(obj4.hasNext(), obj5.hasNext());
    }

    private static int compareNumbers(x x, x x2) {
        x.c cVar;
        x.c iNTEGER_VALUE;
        x.c iNTEGER_VALUE2;
        double d;
        iNTEGER_VALUE = x.c.DOUBLE_VALUE;
        if (x.w() == iNTEGER_VALUE) {
            iNTEGER_VALUE2 = x.getDoubleValue();
            if (x2.w() == iNTEGER_VALUE) {
                return Util.compareDoubles(iNTEGER_VALUE2, obj3);
            }
            if (x2.w() != x.c.INTEGER_VALUE) {
            } else {
                return Util.compareMixed(iNTEGER_VALUE2, obj3);
            }
        } else {
            iNTEGER_VALUE2 = x.c.INTEGER_VALUE;
            if (x.w() != iNTEGER_VALUE2) {
            } else {
                d = x.s();
                if (x2.w() == iNTEGER_VALUE2) {
                    return Util.compareLongs(d, obj4);
                }
                if (x2.w() != iNTEGER_VALUE) {
                } else {
                    return obj5 *= -1;
                }
            }
        }
        Object[] arr = new Object[2];
        throw Assert.fail("Unexpected values: %s vs %s", x, x2);
    }

    private static int compareReferences(String string, String string2) {
        int i;
        int compareTo;
        String str;
        String str2 = "/";
        int i3 = -1;
        String[] obj4 = string.split(str2, i3);
        String[] obj5 = string2.split(str2, i3);
        i = 0;
        while (i < Math.min(obj4.length, obj5.length)) {
            compareTo = obj4[i].compareTo(obj5[i]);
            i++;
        }
        return Util.compareIntegers(obj4.length, obj5.length);
    }

    private static int compareTimestamps(r1 r1, r1 r12) {
        int compareLongs = Util.compareLongs(r1.g(), obj1);
        if (compareLongs != 0) {
            return compareLongs;
        }
        return Util.compareIntegers(r1.f(), r12.f());
    }

    public static boolean contains(b b, x x2) {
        boolean equals;
        Iterator obj1 = b.a().iterator();
        for (x next2 : obj1) {
        }
        return 0;
    }

    public static boolean equals(x x, x x2) {
        if (x == null && x2 == null) {
            if (x2 == null) {
                return 1;
            }
        }
        int i = 0;
        if (x != null) {
            if (x2 == null) {
            } else {
                final int typeOrder = Values.typeOrder(x);
                if (typeOrder != Values.typeOrder(x2)) {
                    return i;
                }
                if (typeOrder != 2 && typeOrder != 4 && typeOrder != 9 && typeOrder != 10) {
                    if (typeOrder != 4) {
                        if (typeOrder != 9) {
                            if (typeOrder != 10) {
                                return x.equals(x2);
                            }
                            return Values.objectEquals(x, x2);
                        }
                        return Values.arrayEquals(x, x2);
                    }
                    return ServerTimestamps.getLocalWriteTime(x).equals(ServerTimestamps.getLocalWriteTime(x2));
                }
            }
            return Values.numberEquals(x, x2);
        }
        return i;
    }

    public static x getLowerBound(x.c x$c) {
        int ordinal = c.ordinal();
        switch (i) {
            case 1:
                return Values.NULL_VALUE;
            case 2:
                x.b obj3 = x.x();
                obj3.e(false);
                return (x)obj3.build();
            case 3:
                obj3 = x.x();
                obj3.g(9221120237041090560L);
                return (x)obj3.build();
            case 4:
                obj3 = x.x();
                r1.b bVar = r1.h();
                bVar.c(Long.MIN_VALUE);
                obj3.p(bVar);
                return (x)obj3.build();
            case 5:
                obj3 = x.x();
                obj3.o("");
                return (x)obj3.build();
            case 6:
                obj3 = x.x();
                obj3.f(j.a);
                return (x)obj3.build();
            case 7:
                return Values.refValue(DatabaseId.EMPTY, DocumentKey.empty());
            case 8:
                obj3 = x.x();
                b.b bVar2 = b.h();
                bVar2.b(-4587338432941916160L);
                bVar2.c(-4582834833314545664L);
                obj3.h(bVar2);
                return (x)obj3.build();
            case 9:
                obj3 = x.x();
                obj3.d(a.i());
                return (x)obj3.build();
            case 10:
                obj3 = x.x();
                obj3.l(r.d());
                return (x)obj3.build();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown value type: ");
                stringBuilder.append(c);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
        }
    }

    public static x getUpperBound(x.c x$c) {
        switch (i) {
            case 1:
                return Values.getLowerBound(x.c.BOOLEAN_VALUE);
            case 2:
                return Values.getLowerBound(x.c.INTEGER_VALUE);
            case 3:
                return Values.getLowerBound(x.c.TIMESTAMP_VALUE);
            case 4:
                return Values.getLowerBound(x.c.STRING_VALUE);
            case 5:
                return Values.getLowerBound(x.c.BYTES_VALUE);
            case 6:
                return Values.getLowerBound(x.c.REFERENCE_VALUE);
            case 7:
                return Values.getLowerBound(x.c.GEO_POINT_VALUE);
            case 8:
                return Values.getLowerBound(x.c.ARRAY_VALUE);
            case 9:
                return Values.getLowerBound(x.c.MAP_VALUE);
            case 10:
                return null;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown value type: ");
                stringBuilder.append(c);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
        }
    }

    public static boolean isArray(x x) {
        x.c aRRAY_VALUE;
        x.c obj1;
        if (x != null && x.w() == x.c.ARRAY_VALUE) {
            obj1 = x.w() == x.c.ARRAY_VALUE ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean isDouble(x x) {
        x.c dOUBLE_VALUE;
        x.c obj1;
        if (x != null && x.w() == x.c.DOUBLE_VALUE) {
            obj1 = x.w() == x.c.DOUBLE_VALUE ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean isInteger(x x) {
        x.c iNTEGER_VALUE;
        x.c obj1;
        if (x != null && x.w() == x.c.INTEGER_VALUE) {
            obj1 = x.w() == x.c.INTEGER_VALUE ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean isMapValue(x x) {
        x.c mAP_VALUE;
        x.c obj1;
        if (x != null && x.w() == x.c.MAP_VALUE) {
            obj1 = x.w() == x.c.MAP_VALUE ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean isNanValue(x x) {
        double doubleValue;
        boolean obj2;
        if (x && Double.isNaN(x.getDoubleValue())) {
            obj2 = Double.isNaN(x.getDoubleValue()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public static boolean isNullValue(x x) {
        x.c nULL_VALUE;
        x.c obj1;
        if (x != null && x.w() == x.c.NULL_VALUE) {
            obj1 = x.w() == x.c.NULL_VALUE ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean isNumber(x x) {
        int obj1;
        if (!Values.isInteger(x)) {
            if (Values.isDouble(x)) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static boolean isReferenceValue(x x) {
        x.c rEFERENCE_VALUE;
        x.c obj1;
        if (x != null && x.w() == x.c.REFERENCE_VALUE) {
            obj1 = x.w() == x.c.REFERENCE_VALUE ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static x max(x x, x x2) {
        x obj1;
        if (x == null && x2 == null) {
            if (x2 == null) {
                return null;
            }
        }
        if (x == null) {
            return x2;
        }
        if (x2 == null) {
            return x;
        }
        if (Values.compare(x, x2) > 0) {
        } else {
            obj1 = x2;
        }
        return obj1;
    }

    public static x min(x x, x x2) {
        x obj1;
        if (x == null && x2 == null) {
            if (x2 == null) {
                return null;
            }
        }
        if (x == null) {
            return x2;
        }
        if (x2 == null) {
            return x;
        }
        if (Values.compare(x, x2) < 0) {
        } else {
            obj1 = x2;
        }
        return obj1;
    }

    private static boolean numberEquals(x x, x x2) {
        x.c cVar2;
        x.c cVar;
        int i;
        x.c iNTEGER_VALUE = x.c.INTEGER_VALUE;
        i = 1;
        final int i2 = 0;
        if (x.w() == iNTEGER_VALUE && x2.w() == iNTEGER_VALUE) {
            if (x2.w() == iNTEGER_VALUE) {
                if (Long.compare(l, obj4) == 0) {
                } else {
                    i = i2;
                }
                return i;
            }
        }
        x.c dOUBLE_VALUE = x.c.DOUBLE_VALUE;
        if (x.w() == dOUBLE_VALUE && x2.w() == dOUBLE_VALUE) {
            if (x2.w() == dOUBLE_VALUE) {
                if (Long.compare(doubleToLongBits, obj4) == 0) {
                } else {
                    i = i2;
                }
                return i;
            }
        }
        return i2;
    }

    private static boolean objectEquals(x x, x x2) {
        int equals;
        int i;
        Object key;
        r obj4 = x.t();
        final r obj5 = x2.t();
        final int i2 = 0;
        if (obj4.e() != obj5.e()) {
            return i2;
        }
        obj4 = obj4.f().entrySet().iterator();
        for (Map.Entry next2 : obj4) {
        }
        return 1;
    }

    public static x refValue(com.google.firebase.firestore.model.DatabaseId databaseId, com.google.firebase.firestore.model.DocumentKey documentKey2) {
        final x.b bVar = x.x();
        Object[] arr = new Object[3];
        bVar.n(String.format("projects/%s/databases/%s/documents/%s", databaseId.getProjectId(), databaseId.getDatabaseId(), documentKey2.toString()));
        return (x)bVar.build();
    }

    public static int typeOrder(x x) {
        final int i3 = 0;
        switch (i) {
            case 1:
                return i3;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 4;
                return 10;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid value type: ");
                stringBuilder.append(x.w());
                throw Assert.fail(stringBuilder.toString(), new Object[i3]);
        }
    }
}
