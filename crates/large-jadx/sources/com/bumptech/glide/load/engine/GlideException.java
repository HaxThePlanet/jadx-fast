package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.f;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class GlideException extends Exception {

    private static final java.lang.StackTraceElement[] a = null;
    private static final long serialVersionUID = 1L;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private a dataSource;
    private String detailMessage;
    private Exception exception;
    private f key;

    private static final class a implements java.lang.Appendable {

        private final java.lang.Appendable a;
        private boolean b = true;
        a(java.lang.Appendable appendable) {
            super();
            final int i = 1;
            this.a = appendable;
        }

        private java.lang.CharSequence a(java.lang.CharSequence charSequence) {
            String obj1;
            if (charSequence == null) {
                obj1 = "";
            }
            return obj1;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(char c) {
            boolean z;
            int i;
            String str;
            if (this.b) {
                this.b = false;
                this.a.append("  ");
            }
            if (c == 10) {
                i = 1;
            }
            this.b = i;
            this.a.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(java.lang.CharSequence charSequence) {
            final java.lang.CharSequence obj3 = a(charSequence);
            append(obj3, 0, obj3.length());
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(java.lang.CharSequence charSequence, int i2, int i3) {
            boolean z;
            int charAt;
            int i;
            String str;
            final java.lang.CharSequence obj4 = a(charSequence);
            if (this.b) {
                this.b = false;
                this.a.append("  ");
            }
            if (obj4.length() > 0 && obj4.charAt(i3 + -1) == 10) {
                if (obj4.charAt(i3 + -1) == 10) {
                    i = 1;
                }
            }
            this.b = i;
            this.a.append(obj4, i2, i3);
            return this;
        }
    }
    static {
        GlideException.a = new StackTraceElement[0];
    }

    public GlideException(String string) {
        super(string, Collections.emptyList());
    }

    public GlideException(String string, Throwable throwable2) {
        super(string, Collections.singletonList(throwable2));
    }

    public GlideException(String string, List<Throwable> list2) {
        super();
        this.detailMessage = string;
        setStackTrace(GlideException.a);
        this.causes = list2;
    }

    private void a(Throwable throwable, List<Throwable> list2) {
        boolean next;
        Object obj2;
        if (throwable instanceof GlideException != null) {
            obj2 = (GlideException)throwable.e().iterator();
            for (Throwable next : obj2) {
                a(next, list2);
            }
        } else {
            list2.add(throwable);
        }
    }

    private static void b(List<Throwable> list, java.lang.Appendable appendable2) {
        try {
            GlideException.c(list, appendable2);
            appendable2 = new RuntimeException(list);
            throw appendable2;
        }
    }

    private static void c(List<Throwable> list, java.lang.Appendable appendable2) {
        int i;
        boolean z;
        int i2;
        String str;
        final int size = list.size();
        i = 0;
        while (i < size) {
            i2 = i + 1;
            appendable2.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Object obj = list.get(i);
            if (obj instanceof GlideException != null) {
            } else {
            }
            GlideException.d((Throwable)obj, appendable2);
            i = i2;
            (GlideException)obj.h(appendable2);
        }
    }

    private static void d(Throwable throwable, java.lang.Appendable appendable2) {
        try {
            appendable2.append(throwable.getClass().toString()).append(": ").append(throwable.getMessage()).append('\n');
            appendable2 = new RuntimeException(throwable);
            throw appendable2;
        }
    }

    private void h(java.lang.Appendable appendable) {
        GlideException.d(this, appendable);
        GlideException.a aVar = new GlideException.a(appendable);
        GlideException.b(e(), aVar);
    }

    public List<Throwable> e() {
        return this.causes;
    }

    public List<Throwable> f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Exception
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Exception
    public void g(String string) {
        int i2;
        String string2;
        int i;
        String str;
        final List list = f();
        final int size = list.size();
        i2 = 0;
        while (i2 < size) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Root cause (");
            i = i2 + 1;
            stringBuilder.append(i);
            stringBuilder.append(" of ");
            stringBuilder.append(size);
            stringBuilder.append(")");
            Log.i(string, stringBuilder.toString(), (Throwable)list.get(i2));
            i2 = i;
        }
    }

    @Override // java.lang.Exception
    public String getMessage() {
        String string;
        String string2;
        Object stringBuilder;
        Object str2;
        String str;
        String string3;
        int i;
        Class dataSource;
        StringBuilder stringBuilder2 = new StringBuilder(71);
        stringBuilder2.append(this.detailMessage);
        str2 = ", ";
        string3 = "";
        if (this.dataClass != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str2);
            stringBuilder4.append(this.dataClass);
            string = stringBuilder4.toString();
        } else {
            string = string3;
        }
        stringBuilder2.append(string);
        if (this.dataSource != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str2);
            stringBuilder3.append(this.dataSource);
            string2 = stringBuilder3.toString();
        } else {
            string2 = string3;
        }
        stringBuilder2.append(string2);
        if (this.key != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(this.key);
            string3 = stringBuilder.toString();
        }
        stringBuilder2.append(string3);
        List list = f();
        if (list.isEmpty()) {
            return stringBuilder2.toString();
        }
        if (list.size() == 1) {
            stringBuilder2.append("\nThere was 1 root cause:");
        } else {
            stringBuilder2.append("\nThere were ");
            stringBuilder2.append(list.size());
            stringBuilder2.append(" root causes:");
        }
        Iterator iterator = list.iterator();
        for (Throwable next2 : iterator) {
            stringBuilder2.append('\n');
            stringBuilder2.append(next2.getClass().getName());
            stringBuilder2.append('(');
            stringBuilder2.append(next2.getMessage());
            stringBuilder2.append(')');
        }
        stringBuilder2.append("\n call GlideException#logRootCauses(String) for more detail");
        return stringBuilder2.toString();
    }

    @Override // java.lang.Exception
    void i(f f, a a2) {
        j(f, a2, 0);
    }

    void j(f f, a a2, Class<?> class3) {
        this.key = f;
        this.dataSource = a2;
        this.dataClass = class3;
    }

    @Override // java.lang.Exception
    public void k(Exception exception) {
        this.exception = exception;
    }

    @Override // java.lang.Exception
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Exception
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    @Override // java.lang.Exception
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }
}
