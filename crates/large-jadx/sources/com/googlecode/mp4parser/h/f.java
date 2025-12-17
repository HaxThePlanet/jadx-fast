package com.googlecode.mp4parser.h;

/* loaded from: classes2.dex */
public abstract class f {
    public static com.googlecode.mp4parser.h.f a(Class class) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            a aVar = new a(class.getSimpleName());
            return aVar;
        }
        d dVar = new d(class.getSimpleName());
        return dVar;
    }

    public abstract void b(String string);

    public abstract void c(String string);

    public abstract void d(String string);
}
