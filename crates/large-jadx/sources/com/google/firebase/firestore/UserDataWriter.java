package com.google.firebase.firestore;

import android.accounts.Account;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ServerTimestamps;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import com.google.protobuf.r1;
import f.c.e.c.a;
import f.c.e.c.r;
import f.c.e.c.x;
import f.c.e.c.x.c;
import f.c.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class UserDataWriter {

    private final com.google.firebase.firestore.FirebaseFirestore firestore;
    private final com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior;
    public UserDataWriter(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        super();
        this.firestore = firebaseFirestore;
        this.serverTimestampBehavior = serverTimestampBehavior2;
    }

    private List<Object> convertArray(a a) {
        int convertValue;
        ArrayList arrayList = new ArrayList(a.k());
        Iterator obj3 = a.a().iterator();
        for (x next2 : obj3) {
            arrayList.add(convertValue(next2));
        }
        return arrayList;
    }

    private Object convertReference(x x) {
        Object name;
        Object databaseId;
        boolean equals;
        String projectId2;
        String projectId;
        name = DatabaseId.fromName(x.u());
        DocumentKey obj6 = DocumentKey.fromName(x.u());
        databaseId = this.firestore.getDatabaseId();
        if (!name.equals(databaseId)) {
            equals = new Object[5];
            Logger.warn("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", obj6.getPath(), name.getProjectId(), name.getDatabaseId(), databaseId.getProjectId(), databaseId.getDatabaseId());
        }
        DocumentReference documentReference = new DocumentReference(obj6, this.firestore);
        return documentReference;
    }

    private Object convertServerTimestamp(x x) {
        int i = UserDataWriter.1.$SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior[this.serverTimestampBehavior.ordinal()];
        final int i4 = 0;
        if (i != 1 && i != 2) {
            if (i != 2) {
                return i4;
            }
            return convertTimestamp(ServerTimestamps.getLocalWriteTime(x));
        }
        x obj4 = ServerTimestamps.getPreviousValue(x);
        if (obj4 == null) {
            return i4;
        }
        return convertValue(obj4);
    }

    private Object convertTimestamp(r1 r1) {
        Timestamp timestamp = new Timestamp(r1.g(), obj2, r1.f());
        return timestamp;
    }

    Map<String, Object> convertObject(Map<String, x> map) {
        Object convertValue;
        Object key;
        HashMap hashMap = new HashMap();
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            hashMap.put((String)next2.getKey(), convertValue((x)next2.getValue()));
        }
        return hashMap;
    }

    public Object convertValue(x x) {
        long doubleValue;
        Number obj6;
        switch (typeOrder) {
            case 0:
                return null;
            case 1:
                return Boolean.valueOf(x.o());
            case 2:
                x.c iNTEGER_VALUE = x.c.INTEGER_VALUE;
                obj6 = Double.valueOf(x.getDoubleValue());
                return obj6;
            case 3:
                return convertTimestamp(x.v());
            case 4:
                return convertServerTimestamp(x);
            case 5:
                return x.getStringValue();
            case 6:
                return Blob.fromByteString(x.p());
            case 7:
                return convertReference(x);
            case 8:
                GeoPoint geoPoint = new GeoPoint(x.r().f(), obj2, x.r().g(), obj4);
                return geoPoint;
            case 9:
                return convertArray(x.n());
            case 10:
                return convertObject(x.t().f());
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown value type: ");
                stringBuilder.append(x.w());
                throw Assert.fail(stringBuilder.toString(), new Object[0]);
        }
        obj6 = Long.valueOf(x.s());
    }
}
