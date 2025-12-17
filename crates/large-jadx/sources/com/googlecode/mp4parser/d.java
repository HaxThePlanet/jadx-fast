package com.googlecode.mp4parser;

import org.mp4parser.aspectj.lang.NoAspectBoundException;
import org.mp4parser.aspectj.lang.a;

/* loaded from: classes2.dex */
public class d {

    private static Throwable a;
    public static final com.googlecode.mp4parser.d b;
    static {
        Throwable th;
        try {
            d.a();
            d.a = th;
        }
    }

    private static void a() {
        d dVar = new d();
        d.b = dVar;
    }

    public static com.googlecode.mp4parser.d b() {
        com.googlecode.mp4parser.d dVar = d.b;
        if (dVar == null) {
        } else {
            return dVar;
        }
        NoAspectBoundException noAspectBoundException = new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", d.a);
        throw noAspectBoundException;
    }

    public void c(a a) {
        Object obj3;
        if (!obj instanceof AbstractBox) {
        } else {
            if (!(AbstractBox)a.a().isParsed()) {
                (AbstractBox)a.a().parseDetails();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Only methods in subclasses of ");
        stringBuilder.append(AbstractBox.class.getName());
        stringBuilder.append(" can  be annotated with ParseDetail");
        obj3 = new RuntimeException(stringBuilder.toString());
        throw obj3;
    }
}
