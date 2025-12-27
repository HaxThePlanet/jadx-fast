package com.googlecode.mp4parser;

import org.mp4parser.aspectj.lang.NoAspectBoundException;
import org.mp4parser.aspectj.lang.a;

/* compiled from: RequiresParseDetailAspect.java */
/* loaded from: classes2.dex */
public class d {

    private static /* synthetic */ Throwable a;
    public static final /* synthetic */ d b;
    static {
        try {
            d.a();
        } catch (Throwable th) {
            d.a = th;
        }
    }

    private static /* synthetic */ void a() {
        d.b = new d();
    }

    public static d b() throws NoAspectBoundException {
        com.googlecode.mp4parser.d dVar = d.b;
        if (d.b == null) {
            throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", d.a);
        } else {
            return d.b;
        }
    }

    public void c(a aVar) {
        if (!(aVar.a() instanceof AbstractBox)) {
            String str = "Only methods in subclasses of ";
            StringBuilder stringBuilder = new StringBuilder(str);
            String name = AbstractBox.class.getName();
            String str2 = " can  be annotated with ParseDetail";
            r0 = str + name + str2;
            throw new RuntimeException(r0);
        } else {
            if (!(AbstractBox)aVar.a().isParsed()) {
                (AbstractBox)aVar.a().parseDetails();
            }
            return;
        }
    }
}
