package com.google.firebase.firestore.bundle;

import android.util.Base64;
import com.google.android.material.floatingactionbutton.b.l;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.Filter.Operator;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.OrderBy.Direction;
import com.google.firebase.firestore.core.Query.LimitType;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.protobuf.c1;
import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.r1.b;
import com.google.protobuf.z.a;
import com.revenuecat.purchases.common.R.color;
import f.c.e.c.a;
import f.c.e.c.a.b;
import f.c.e.c.r;
import f.c.e.c.r.b;
import f.c.e.c.x;
import f.c.e.c.x.b;
import f.c.h.b;
import f.c.h.b.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BundleSerializer {

    private static final long MILLIS_PER_SECOND = 1000L;
    private final RemoteSerializer remoteSerializer;
    private final SimpleDateFormat timestampFormat;
    public BundleSerializer(RemoteSerializer remoteSerializer) {
        super();
        this.remoteSerializer = remoteSerializer;
        SimpleDateFormat obj5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        this.timestampFormat = obj5;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        Date date = new Date(Long.MIN_VALUE, obj3);
        gregorianCalendar.setGregorianChange(date);
        obj5.setCalendar(gregorianCalendar);
    }

    private void decodeArrayValue(x.b x$b, JSONArray jSONArray2) {
        int i;
        x decodeValue;
        final a.b bVar = a.l();
        if (jSONArray2 != null) {
            i = 0;
            while (i < jSONArray2.length()) {
                bVar.c(decodeValue(jSONArray2.getJSONObject(i)));
                i++;
            }
        }
        b.c(bVar);
    }

    private com.google.firebase.firestore.bundle.BundledQuery decodeBundledQuery(JSONObject jSONObject) {
        BasePath decodeName;
        String string;
        JSONObject jSONObject2 = jSONObject.getJSONObject("structuredQuery");
        verifyNoSelect(jSONObject2);
        JSONArray jSONArray = jSONObject2.getJSONArray("from");
        verifyCollectionSelector(jSONArray);
        int i = 0;
        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
        String str9 = "collectionId";
        if (jSONObject3.optBoolean("allDescendants", i)) {
            string = jSONObject3.getString(str9);
        } else {
            decodeName = decodeName(jSONObject.getString("parent")).append(jSONObject3.getString(str9));
            string = 0;
        }
        verifyNoOffset(jSONObject2);
        super(decodeName, string, decodeWhere(jSONObject2.optJSONObject("where")), decodeOrderBy(jSONObject2.optJSONArray("orderBy")), (long)decodeLimit, obj9, decodeStartAtBound(jSONObject2.optJSONObject("startAt")), decodeEndAtBound(jSONObject2.optJSONObject("endAt")));
        BundledQuery bundledQuery = new BundledQuery(target, decodeLimitType(jSONObject));
        return bundledQuery;
    }

    private void decodeCompositeFilter(List<Filter> list, JSONObject jSONObject2) {
        String str;
        String jSONObject;
        if (!jSONObject2.getString("op").equals("AND")) {
        } else {
            JSONArray obj4 = jSONObject2.optJSONArray("filters");
            if (obj4 != null) {
                str = 0;
                while (str < obj4.length()) {
                    decodeFilter(list, obj4.getJSONObject(str));
                    str++;
                }
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("The Android SDK only supports composite filters of type 'AND'");
        throw obj3;
    }

    private Bound decodeEndAtBound(JSONObject jSONObject) {
        if (jSONObject != null) {
            Bound bound = new Bound(decodePosition(jSONObject), optBoolean ^= 1);
            return bound;
        }
        return null;
    }

    private void decodeFieldFilter(List<Filter> list, JSONObject jSONObject2) {
        list.add(FieldFilter.create(decodeFieldReference(jSONObject2.getJSONObject("field")), decodeFieldFilterOperator(jSONObject2.getString("op")), decodeValue(jSONObject2.getJSONObject("value"))));
    }

    private Filter.Operator decodeFieldFilterOperator(String string) {
        return Filter.Operator.valueOf(string);
    }

    private FieldPath decodeFieldReference(JSONObject jSONObject) {
        return FieldPath.fromServerFormat(jSONObject.getString("fieldPath"));
    }

    private void decodeFilter(List<Filter> list, JSONObject jSONObject2) {
        String str;
        boolean z;
        JSONObject obj4;
        str = "compositeFilter";
        if (jSONObject2.has(str)) {
            decodeCompositeFilter(list, jSONObject2.getJSONObject(str));
        } else {
            str = "fieldFilter";
            if (jSONObject2.has(str)) {
                decodeFieldFilter(list, jSONObject2.getJSONObject(str));
            } else {
                str = "unaryFilter";
                if (jSONObject2.has(str)) {
                    decodeUnaryFilter(list, jSONObject2.getJSONObject(str));
                }
            }
        }
    }

    private void decodeGeoPoint(x.b x$b, JSONObject jSONObject2) {
        final b.b bVar = b.h();
        bVar.b(jSONObject2.optDouble("latitude"));
        bVar.c(jSONObject2.optDouble("longitude"));
        b.h(bVar);
    }

    private int decodeLimit(JSONObject jSONObject) {
        final String str = "limit";
        final JSONObject optJSONObject = jSONObject.optJSONObject(str);
        final int i = -1;
        if (optJSONObject != null) {
            return optJSONObject.optInt("value", i);
        }
        return jSONObject.optInt(str, i);
    }

    private Query.LimitType decodeLimitType(JSONObject jSONObject) {
        String str3 = "FIRST";
        String obj4 = jSONObject.optString("limitType", str3);
        if (obj4.equals(str3)) {
            return Query.LimitType.LIMIT_TO_FIRST;
        }
        if (!obj4.equals("LAST")) {
        } else {
            return Query.LimitType.LIMIT_TO_LAST;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid limit type for bundle query: ");
        stringBuilder.append(obj4);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private void decodeMapValue(x.b x$b, JSONObject jSONObject2) {
        Iterator keys;
        Object next;
        x decodeValue;
        final r.b bVar = r.l();
        if (jSONObject2 != null) {
            keys = jSONObject2.keys();
            for (String next : keys) {
                bVar.d(next, decodeValue(jSONObject2.getJSONObject(next)));
            }
        }
        b.k(bVar);
    }

    private ResourcePath decodeName(String string) {
        ResourcePath string2 = ResourcePath.fromString(string);
        if (!this.remoteSerializer.isLocalResourceName(string2)) {
        } else {
            return (ResourcePath)string2.popFirst(5);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resource name is not valid for current instance: ");
        stringBuilder.append(string);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private List<OrderBy> decodeOrderBy(JSONArray jSONArray) {
        int i;
        int instance;
        OrderBy.Direction dESCENDING;
        FieldPath decodeFieldReference;
        String str2;
        String str;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                str = "ASCENDING";
                if (jSONObject.optString("direction", str).equals(str)) {
                } else {
                }
                dESCENDING = OrderBy.Direction.DESCENDING;
                arrayList.add(OrderBy.getInstance(dESCENDING, decodeFieldReference(jSONObject.getJSONObject("field"))));
                i++;
                dESCENDING = OrderBy.Direction.ASCENDING;
            }
        }
        return arrayList;
    }

    private List<x> decodePosition(JSONObject jSONObject) {
        int str;
        x decodeValue;
        ArrayList arrayList = new ArrayList();
        final JSONArray obj4 = jSONObject.optJSONArray("values");
        if (obj4 != null) {
            str = 0;
            while (str < obj4.length()) {
                arrayList.add(decodeValue(obj4.getJSONObject(str)));
                str++;
            }
        }
        return arrayList;
    }

    private SnapshotVersion decodeSnapshotVersion(Object object) {
        SnapshotVersion snapshotVersion = new SnapshotVersion(decodeTimestamp(object));
        return snapshotVersion;
    }

    private Bound decodeStartAtBound(JSONObject jSONObject) {
        if (jSONObject != null) {
            Bound bound = new Bound(decodePosition(jSONObject), jSONObject.optBoolean("before", false));
            return bound;
        }
        return null;
    }

    private Timestamp decodeTimestamp(Object object) {
        if (object instanceof String != null) {
            return decodeTimestamp((String)object);
        }
        if (object instanceof JSONObject == null) {
        } else {
            return decodeTimestamp((JSONObject)object);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Timestamps must be either ISO 8601-formatted strings or JSON objects");
        throw obj2;
    }

    private Timestamp decodeTimestamp(String string) {
        int nanos;
        int substring3;
        int decodeTimezoneOffset;
        int i2;
        int indexOf;
        String substring;
        String substring2;
        int indexOf2;
        int i;
        char obj12;
        int indexOf3 = string.indexOf(84);
        substring3 = -1;
        if (indexOf3 == substring3) {
        } else {
            i2 = 90;
            final int i6 = 43;
            if (string.indexOf(i2, indexOf3) == substring3) {
                try {
                    indexOf = string.indexOf(i6, indexOf3);
                    if (indexOf == substring3) {
                    }
                    indexOf = string.indexOf(45, indexOf3);
                    if (indexOf == substring3) {
                    } else {
                    }
                    nanos = 0;
                    substring = string.substring(nanos, indexOf);
                    substring2 = "";
                    indexOf2 = substring.indexOf(46);
                    if (indexOf2 != substring3) {
                    }
                    substring2 = substring.substring(indexOf2++);
                    substring = substring3;
                    time /= i8;
                    if (substring2.isEmpty()) {
                    } else {
                    }
                    nanos = BundleSerializer.parseNanos(substring2);
                    if (string.charAt(indexOf) == i2) {
                    }
                    if (string.length() != indexOf + 1) {
                    } else {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Invalid timestamp: Invalid trailing data \"");
                    stringBuilder2.append(string.substring(indexOf));
                    stringBuilder2.append("\"");
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder2.toString());
                    throw illegalArgumentException3;
                    decodeTimezoneOffset = BundleSerializer.decodeTimezoneOffset(string.substring(indexOf + 1));
                    if (string.charAt(indexOf) == i6) {
                    } else {
                    }
                    i -= decodeTimezoneOffset;
                    i += decodeTimezoneOffset;
                    obj12 = new Timestamp(i, obj8, nanos);
                    return obj12;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Invalid timestamp: Missing valid timezone offset: ");
                    stringBuilder3.append(string);
                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(stringBuilder3.toString());
                    throw illegalArgumentException4;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid timestamp: ");
                    stringBuilder.append(string);
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException2;
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to parse timestamp", string);
                    throw illegalArgumentException;
                }
            }
        }
    }

    private Timestamp decodeTimestamp(JSONObject jSONObject) {
        Timestamp timestamp = new Timestamp(jSONObject.optLong("seconds"), obj2, jSONObject.optInt("nanos"));
        return timestamp;
    }

    private void decodeTimestamp(x.b x$b, Object object2) {
        Timestamp obj5 = decodeTimestamp(object2);
        final r1.b bVar = r1.h();
        bVar.c(obj5.getSeconds());
        bVar.b(obj5.getNanoseconds());
        b.p(bVar);
    }

    private static long decodeTimezoneOffset(String string) {
        int indexOf = string.indexOf(58);
        if (indexOf == -1) {
        } else {
            int i8 = 60;
            return i4 *= i8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid offset value: ");
        stringBuilder.append(string);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private void decodeUnaryFilter(List<Filter> list, JSONObject jSONObject2) {
        boolean equals;
        x nULL_VALUE;
        int i;
        FieldFilter obj5;
        FieldPath decodeFieldReference = decodeFieldReference(jSONObject2.getJSONObject("field"));
        obj5 = jSONObject2.getString("op");
        obj5.hashCode();
        i = -1;
        switch (obj5) {
            case "IS_NAN":
                i = 0;
                break;
            case "IS_NULL":
                i = 1;
                break;
            case "IS_NOT_NAN":
                i = 2;
                break;
            case "IS_NOT_NULL":
                i = 3;
                break;
            default:
        }
        switch (i) {
            case 0:
                list.add(FieldFilter.create(decodeFieldReference, Filter.Operator.EQUAL, Values.NAN_VALUE));
                break;
            case 1:
                list.add(FieldFilter.create(decodeFieldReference, Filter.Operator.EQUAL, Values.NULL_VALUE));
                break;
            case 2:
                list.add(FieldFilter.create(decodeFieldReference, Filter.Operator.NOT_EQUAL, Values.NAN_VALUE));
                break;
            case 3:
                list.add(FieldFilter.create(decodeFieldReference, Filter.Operator.NOT_EQUAL, Values.NULL_VALUE));
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected unary filter: ");
                stringBuilder.append(obj5);
                IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
                throw obj4;
        }
    }

    private x decodeValue(JSONObject jSONObject) {
        boolean optDouble;
        boolean str;
        int i;
        c1 obj5;
        x.b bVar = x.x();
        if (jSONObject.has("nullValue")) {
            bVar.m(c1.NULL_VALUE);
            return (x)bVar.build();
        } else {
            optDouble = "booleanValue";
            i = 0;
            if (jSONObject.has(optDouble)) {
                bVar.e(jSONObject.optBoolean(optDouble, i));
            } else {
                String str3 = "integerValue";
                str = jSONObject.has(str3);
                if (str != null) {
                    bVar.j(jSONObject.optLong(str3));
                } else {
                    String str4 = "doubleValue";
                    str = jSONObject.has(str4);
                    if (str != null) {
                        bVar.g(jSONObject.optDouble(str4));
                    } else {
                        optDouble = "timestampValue";
                        if (jSONObject.has(optDouble)) {
                            decodeTimestamp(bVar, jSONObject.get(optDouble));
                        } else {
                            optDouble = "stringValue";
                            if (jSONObject.has(optDouble)) {
                                bVar.o(jSONObject.optString(optDouble, ""));
                            } else {
                                optDouble = "bytesValue";
                                if (jSONObject.has(optDouble)) {
                                    bVar.f(j.s(Base64.decode(jSONObject.getString(optDouble), i)));
                                } else {
                                    optDouble = "referenceValue";
                                    if (jSONObject.has(optDouble)) {
                                        bVar.n(jSONObject.getString(optDouble));
                                    } else {
                                        optDouble = "geoPointValue";
                                        if (jSONObject.has(optDouble)) {
                                            decodeGeoPoint(bVar, jSONObject.getJSONObject(optDouble));
                                        } else {
                                            String str5 = "arrayValue";
                                            if (jSONObject.has(str5)) {
                                                decodeArrayValue(bVar, jSONObject.getJSONObject(str5).optJSONArray("values"));
                                            } else {
                                                String str6 = "mapValue";
                                                if (!jSONObject.has(str6)) {
                                                } else {
                                                    decodeMapValue(bVar, jSONObject.getJSONObject(str6).optJSONObject("fields"));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected value type: ");
        stringBuilder.append(jSONObject);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private List<Filter> decodeWhere(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            decodeFilter(arrayList, jSONObject);
        }
        return arrayList;
    }

    private static int parseNanos(String string) {
        int i3;
        int i4;
        int length;
        char charAt;
        int i;
        int i2;
        i4 = i3;
        while (i3 < 9) {
            i3++;
            i = 48;
            i4 += length;
        }
        return i4;
    }

    private void verifyCollectionSelector(JSONArray jSONArray) {
        if (jSONArray.length() != 1) {
        } else {
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Only queries with a single 'from' clause are supported by the Android SDK");
        throw obj2;
    }

    private void verifyNoOffset(JSONObject jSONObject) {
        if (jSONObject.has("offset")) {
        } else {
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Queries with offsets are not supported by the Android SDK");
        throw obj2;
    }

    private void verifyNoSelect(JSONObject jSONObject) {
        if (jSONObject.has("select")) {
        } else {
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Queries with 'select' statements are not supported by the Android SDK");
        throw obj2;
    }

    public com.google.firebase.firestore.bundle.BundleMetadata decodeBundleMetadata(JSONObject jSONObject) {
        super(jSONObject.getString("id"), jSONObject.getInt("version"), decodeSnapshotVersion(jSONObject.get("createTime")), jSONObject.getInt("totalDocuments"), jSONObject.getLong("totalBytes"), obj7);
        return obj9;
    }

    public com.google.firebase.firestore.bundle.BundledDocumentMetadata decodeBundledDocumentMetadata(JSONObject jSONObject) {
        int i;
        int length;
        JSONArray obj7 = jSONObject.optJSONArray("queries");
        ArrayList arrayList = new ArrayList();
        if (obj7 != null) {
        }
        obj7 = new BundledDocumentMetadata(DocumentKey.fromPath(decodeName(jSONObject.getString("name"))), decodeSnapshotVersion(jSONObject.get("readTime")), jSONObject.optBoolean("exists", false), arrayList);
        return obj7;
    }

    com.google.firebase.firestore.bundle.BundleDocument decodeDocument(JSONObject jSONObject) {
        x.b bVar = x.x();
        decodeMapValue(bVar, jSONObject.getJSONObject("fields"));
        BundleDocument obj5 = new BundleDocument(MutableDocument.newFoundDocument(DocumentKey.fromPath(decodeName(jSONObject.getString("name"))), decodeSnapshotVersion(jSONObject.get("updateTime")), ObjectValue.fromMap(bVar.b().f())));
        return obj5;
    }

    public com.google.firebase.firestore.bundle.NamedQuery decodeNamedQuery(JSONObject jSONObject) {
        NamedQuery namedQuery = new NamedQuery(jSONObject.getString("name"), decodeBundledQuery(jSONObject.getJSONObject("bundledQuery")), decodeSnapshotVersion(jSONObject.get("readTime")));
        return namedQuery;
    }
}
