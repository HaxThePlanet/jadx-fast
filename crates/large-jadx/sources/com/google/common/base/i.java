package com.google.common.base;

import java.util.Iterator;

/* loaded from: classes2.dex */
public class i {

    private final String a;
    private i(String string) {
        super();
        n.o(string);
        this.a = (String)string;
    }

    public static com.google.common.base.i e(char c) {
        i iVar = new i(String.valueOf(c));
        return iVar;
    }

    public <A extends java.lang.Appendable> A a(A a, Iterator<?> iterator2) {
        java.lang.CharSequence charSequence;
        boolean next;
        n.o(a);
        if (iterator2.hasNext()) {
            a.append(f(iterator2.next()));
            for (Object next3 : iterator2) {
                a.append(this.a);
                a.append(f(next3));
            }
        }
        return a;
    }

    public final StringBuilder b(StringBuilder stringBuilder, Iterator<?> iterator2) {
        try {
            a(stringBuilder, iterator2);
            return stringBuilder;
            iterator2 = new AssertionError(stringBuilder);
            throw iterator2;
        }
    }

    public final String c(Iterable<?> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<?> iterator) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder, iterator);
        return stringBuilder.toString();
    }

    java.lang.CharSequence f(Object object) {
        Object obj2;
        n.o(object);
        if (object instanceof CharSequence) {
        } else {
            obj2 = (CharSequence)object.toString();
        }
        return obj2;
    }
}
