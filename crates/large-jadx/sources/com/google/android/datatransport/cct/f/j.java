package com.google.android.datatransport.cct.f;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* loaded from: classes.dex */
@Encodable
public abstract class j {
    public static com.google.android.datatransport.cct.f.j a(List<com.google.android.datatransport.cct.f.m> list) {
        d dVar = new d(list);
        return dVar;
    }

    public static DataEncoder b() {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        return jsonDataEncoderBuilder.configureWith(b.a).ignoreNullValues(true).build();
    }

    @Encodable$Field(name = "logRequest")
    public abstract List<com.google.android.datatransport.cct.f.m> c();
}
