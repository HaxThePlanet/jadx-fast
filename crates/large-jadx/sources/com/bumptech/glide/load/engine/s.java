package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.k;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class s<Data, ResourceType, Transcode>  {

    private final f<List<Throwable>> a;
    private final List<? extends com.bumptech.glide.load.engine.i<Data, ResourceType, Transcode>> b;
    private final String c;
    public s(Class<Data> class, Class<ResourceType> class2, Class<Transcode> class3, List<com.bumptech.glide.load.engine.i<Data, ResourceType, Transcode>> list4, f<List<Throwable>> f5) {
        super();
        this.a = f5;
        k.c(list4);
        this.b = (List)list4;
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Failed LoadPath{");
        obj4.append(class.getSimpleName());
        String obj1 = "->";
        obj4.append(obj1);
        obj4.append(class2.getSimpleName());
        obj4.append(obj1);
        obj4.append(class3.getSimpleName());
        obj4.append("}");
        this.c = obj4.toString();
    }

    private com.bumptech.glide.load.engine.u<Transcode> b(e<Data> e, h h2, int i3, int i4, com.bumptech.glide.load.engine.i.a<ResourceType> i$a5, List<Throwable> list6) {
        int i2;
        int i;
        int i5;
        Object th;
        e eVar;
        int i6;
        int i7;
        h hVar;
        com.bumptech.glide.load.engine.i.a aVar;
        final Object obj2 = this;
        i5 = i8;
        i = i2;
        while (i5 < obj2.b.size()) {
            if ((i)obj2.b.get(i5).a(e, i3, i4, h2, a5) != 0) {
                break;
            } else {
            }
            i5++;
            obj2.add(th2);
        }
        if (i == 0) {
        } else {
            return i;
        }
        ArrayList arrayList = new ArrayList(list6);
        GlideException glideException = new GlideException(obj2.c, arrayList);
        throw glideException;
    }

    public com.bumptech.glide.load.engine.u<Transcode> a(e<Data> e, h h2, int i3, int i4, com.bumptech.glide.load.engine.i.a<ResourceType> i$a5) {
        Object obj = this.a.b();
        k.d(obj);
        this.a.a(obj);
        return this.b(e, h2, i3, i4, a5, (List)obj);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LoadPath{decodePaths=");
        stringBuilder.append(Arrays.toString(this.b.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
