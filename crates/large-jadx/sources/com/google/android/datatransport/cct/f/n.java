package com.google.android.datatransport.cct.f;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes.dex */
public abstract class n {
    static com.google.android.datatransport.cct.f.n a(long l) {
        h hVar = new h(l, obj2);
        return hVar;
    }

    public static com.google.android.datatransport.cct.f.n b(Reader reader) {
        String str;
        Reader obj3;
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        obj3 = new IOException("Response is missing nextRequestWaitMillis field.");
        throw obj3;
    }

    public abstract long c();
}
