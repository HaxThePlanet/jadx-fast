package com.google.firebase.firestore.model;

import com.google.firebase.Timestamp;
import com.google.protobuf.r1;
import com.google.protobuf.r1.b;
import com.google.protobuf.z.a;
import f.c.e.c.r;
import f.c.e.c.r.b;
import f.c.e.c.x;
import f.c.e.c.x.b;

/* loaded from: classes2.dex */
public final class ServerTimestamps {

    private static final String LOCAL_WRITE_TIME_KEY = "__local_write_time__";
    private static final String PREVIOUS_VALUE_KEY = "__previous_value__";
    private static final String SERVER_TIMESTAMP_SENTINEL = "server_timestamp";
    private static final String TYPE_KEY = "__type__";
    public static r1 getLocalWriteTime(x x) {
        return x.t().h("__local_write_time__").v();
    }

    public static x getPreviousValue(x x) {
        x obj2;
        obj2 = x.t().g("__previous_value__", 0);
        if (ServerTimestamps.isServerTimestamp(obj2)) {
            obj2 = ServerTimestamps.getPreviousValue(obj2);
        }
        return obj2;
    }

    public static boolean isServerTimestamp(x x) {
        x str2;
        String str;
        r obj2;
        if (x == null) {
        } else {
            str2 = x.t().g("__type__", 0);
        }
        if (str2 != null && "server_timestamp".equals(str2.getStringValue())) {
            obj2 = "server_timestamp".equals(str2.getStringValue()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public static x valueOf(Timestamp timestamp, x x2) {
        Object obj5;
        x.b bVar = x.x();
        bVar.o("server_timestamp");
        x.b bVar2 = x.x();
        r1.b bVar4 = r1.h();
        bVar4.c(timestamp.getSeconds());
        bVar4.b(timestamp.getNanoseconds());
        bVar2.p(bVar4);
        r.b bVar3 = r.l();
        bVar3.d("__type__", (x)bVar.build());
        bVar3.d("__local_write_time__", (x)bVar2.build());
        if (x2 != null) {
            bVar3.d("__previous_value__", x2);
        }
        obj5 = x.x();
        obj5.k(bVar3);
        return (x)obj5.build();
    }
}
