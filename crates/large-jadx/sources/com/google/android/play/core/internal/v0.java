package com.google.android.play.core.internal;

import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class v0<T>  {

    private final Object a;
    private final Field b;
    private final Class<T> c;
    v0(Object object, Field field2, Class<T> class3) {
        super();
        this.a = object;
        this.b = field2;
        this.c = class3;
    }

    public final T a() {
        try {
            return this.c.cast(this.b.get(this.a));
            int format = 3;
            format = new Object[format];
            int str = 0;
            Field name = this.b;
            name = name.getName();
            format[str] = name;
            str = 1;
            name = this.a;
            name = name.getClass();
            name = name.getName();
            format[str] = name;
            str = 2;
            name = this.c;
            name = name.getName();
            format[str] = name;
            str = "Failed to get value of field %s of type %s on object of type %s";
            format = String.format(str, format);
            zzbx zzbx = new zzbx(format, th);
            throw zzbx;
        }
    }

    protected final Field b() {
        return this.b;
    }

    public final void c(T t) {
        try {
            this.b.set(this.a, t);
            int format = 3;
            format = new Object[format];
            int str = 0;
            Field name = this.b;
            name = name.getName();
            format[str] = name;
            str = 1;
            name = this.a;
            name = name.getClass();
            name = name.getName();
            format[str] = name;
            str = 2;
            name = this.c;
            name = name.getName();
            format[str] = name;
            str = "Failed to set value of field %s of type %s on object of type %s";
            format = String.format(str, format);
            zzbx zzbx = new zzbx(format, t);
            throw zzbx;
        }
    }
}
