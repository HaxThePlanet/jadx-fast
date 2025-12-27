package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.k;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath.java */
/* loaded from: classes.dex */
public class s<Data, ResourceType, Transcode> {

    private final f<List<Throwable>> a;
    private final List<? extends i<Data, ResourceType, Transcode>> b;
    private final String c;
    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, f<List<Throwable>> fVar) {
        super();
        this.a = fVar;
        k.c(list);
        this.b = list;
        final StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "Failed LoadPath{";
        String simpleName = cls.getSimpleName();
        String str = "->";
        final String simpleName3 = cls2.getSimpleName();
        String simpleName2 = cls3.getSimpleName();
        String str2 = "}";
        str3 = str4 + simpleName + str + simpleName3 + str + simpleName2 + str2;
        this.c = str3;
    }

    private u<Transcode> b(e<Data> eVar, h hVar, int i, int i2, i.a<ResourceType> aVar, List<Throwable> list) {
        Object item;
        e eVar2;
        int i32;
        int i42;
        h hVar22;
        com.bumptech.glide.load.engine.i.a aVar52;
        final Object eVar3 = this;
        i = 0;
        i2 = 0;
        while (i2 < eVar3.b.size()) {
            try {
            } catch (com.bumptech.glide.load.engine.GlideException glide) {
                obj.add(glide);
            }
            if ((i)item.a(eVar, i, i2, hVar, aVar) != 0) {
                break;
            }
        }
        if (i == 0) {
            throw new GlideException(eVar3.c, new ArrayList(list));
        } else {
            return i;
        }
    }

    public u<Transcode> a(e<Data> eVar, h hVar, int i, int i2, i.a<ResourceType> aVar) {
        Object obj2 = this.a.b();
        k.d(obj2);
        try {
        } finally {
            this.a.a(obj);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) eVar;
        }
        this.a.a(obj2);
        return this.b(eVar, hVar, i, i2, aVar, obj2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LoadPath{decodePaths=";
        String str3 = Arrays.toString(this.b.toArray());
        str = str2 + str3 + 125;
        return str;
    }
}
