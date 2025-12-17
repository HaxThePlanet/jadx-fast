package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.n.h.e;
import com.bumptech.glide.t.k;
import d.h.k.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode>  {

    private final Class<DataType> a;
    private final List<? extends j<DataType, ResourceType>> b;
    private final e<ResourceType, Transcode> c;
    private final f<List<Throwable>> d;
    private final String e;

    interface a {
        public abstract com.bumptech.glide.load.engine.u<ResourceType> a(com.bumptech.glide.load.engine.u<ResourceType> u);
    }
    public i(Class<DataType> class, Class<ResourceType> class2, Class<Transcode> class3, List<? extends j<DataType, ResourceType>> list4, e<ResourceType, Transcode> e5, f<List<Throwable>> f6) {
        super();
        this.a = class;
        this.b = list4;
        this.c = e5;
        this.d = f6;
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Failed DecodePath{");
        obj4.append(class.getSimpleName());
        String obj1 = "->";
        obj4.append(obj1);
        obj4.append(class2.getSimpleName());
        obj4.append(obj1);
        obj4.append(class3.getSimpleName());
        obj4.append("}");
        this.e = obj4.toString();
    }

    private com.bumptech.glide.load.engine.u<ResourceType> b(e<DataType> e, int i2, int i3, h h4) {
        Object obj = this.d.b();
        k.d(obj);
        this.d.a(obj);
        return this.c(e, i2, i3, h4, (List)obj);
    }

    private com.bumptech.glide.load.engine.u<ResourceType> c(e<DataType> e, int i2, int i3, h h4, List<Throwable> list5) {
        int i4;
        int i;
        Object string;
        Throwable th;
        int stringBuilder;
        String str;
        String str2;
        i4 = 0;
        i = 0;
        while (i < this.b.size()) {
            string = this.b.get(i);
            if ((j)string.a(e.a(), h4)) {
            }
            if (i4 != 0) {
                break;
            } else {
            }
            i++;
            i4 = string.b(e.a(), i2, i3, h4);
            stringBuilder = 2;
            str = "DecodePath";
            stringBuilder = Log.isLoggable(str, stringBuilder);
            if (stringBuilder != null) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to decode data for ");
            stringBuilder.append(string);
            string = stringBuilder.toString();
            Log.v(str, string, th);
            list5.add(th);
        }
        if (i4 == 0) {
        } else {
            return i4;
        }
        ArrayList obj11 = new ArrayList(list5);
        GlideException obj9 = new GlideException(this.e, obj11);
        throw obj9;
    }

    public com.bumptech.glide.load.engine.u<Transcode> a(e<DataType> e, int i2, int i3, h h4, com.bumptech.glide.load.engine.i.a<ResourceType> i$a5) {
        return this.c.a(a5.a(b(e, i2, i3, h4)), h4);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecodePath{ dataClass=");
        stringBuilder.append(this.a);
        stringBuilder.append(", decoders=");
        stringBuilder.append(this.b);
        stringBuilder.append(", transcoder=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
