package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.k;
import d.h.k.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {

    private final Class<DataType> a;
    private final List<? extends j<DataType, ResourceType>> b;
    private final com.bumptech.glide.load.n.h.e<ResourceType, Transcode> c;
    private final f<List<Throwable>> d;
    private final String e;

    interface a<ResourceType> {
        u<ResourceType> a(u<ResourceType> uVar);
    }
    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends j<DataType, ResourceType>> list, com.bumptech.glide.load.n.h.e<ResourceType, Transcode> eVar, f<List<Throwable>> fVar) {
        super();
        this.a = cls;
        this.b = list;
        this.c = eVar;
        this.d = fVar;
        final StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "Failed DecodePath{";
        String simpleName = cls.getSimpleName();
        String str = "->";
        final String simpleName3 = cls2.getSimpleName();
        String simpleName2 = cls3.getSimpleName();
        String str2 = "}";
        str3 = str4 + simpleName + str + simpleName3 + str + simpleName2 + str2;
        this.e = str3;
    }

    private u<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, h hVar) {
        Object obj2 = this.d.b();
        k.d(obj2);
        try {
        } finally {
            this.d.a(obj);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) eVar;
        }
        this.d.a(obj2);
        return this.c(eVar, i, i2, hVar, obj2);
    }

    private u<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, h hVar, List<Throwable> list) throws GlideException {
        int i4 = 0;
        String str;
        Object item;
        Throwable th;
        boolean z;
        int stringBuilder;
        int obj5;
        String str2;
        String obj8;
        String str3;
        String obj11;
        i = 0;
        i4 = 0;
        while (i4 < this.b.size()) {
            item = this.b.get(i4);
            try {
                com.bumptech.glide.load.engine.u uVar = item.b(eVar.a(), i, i2, hVar);
            } catch (java.lang.OutOfMemoryError e) {
            } catch (RuntimeException e1) {
            } catch (java.io.IOException ioException2) {
            }
            if (i != 0) {
                break;
            }
            stringBuilder = 2;
            str2 = "DecodePath";
            stringBuilder = Log.isLoggable(str2, stringBuilder);
            list.add(ioException2);
        }
        if (i == 0) {
            throw new GlideException(this.e, new ArrayList(list));
        } else {
            return i;
        }
    }

    public u<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, h hVar, i.a<ResourceType> aVar) {
        return this.c.a(aVar.a(b(eVar, i, i2, hVar)), hVar);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DecodePath{ dataClass=";
        String str3 = ", decoders=";
        String str4 = ", transcoder=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + 125;
        return str;
    }
}
