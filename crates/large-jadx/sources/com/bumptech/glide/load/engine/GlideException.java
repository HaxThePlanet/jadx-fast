package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.f;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: GlideException.java */
/* loaded from: classes.dex */
public final class GlideException extends Exception {

    private static final java.lang.StackTraceElement[] a;
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
            this.a = appendable;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(char c) throws IOException {
            boolean z2 = false;
            z2 = false;
            if (this.b) {
                this.b = false;
                str = "  ";
                this.a.append(str);
            }
            if (c == 10) {
                int i2 = 1;
            }
            this.b = z2;
            this.a.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(java.lang.CharSequence charSequence) {
            final java.lang.CharSequence charSequence2 = a(charSequence);
            append(charSequence2, 0, charSequence2.length());
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(java.lang.CharSequence charSequence, int i, int i2) throws IOException {
            boolean z2 = false;
            String str;
            final java.lang.CharSequence charSequence2 = a(charSequence);
            z2 = false;
            if (this.b) {
                this.b = false;
                str = "  ";
                this.a.append(str);
            }
            if (charSequence2.length() > 0) {
                if (charSequence2.charAt(i2 - 1) == '\n') {
                    int i4 = 1;
                }
            }
            this.b = z2;
            this.a.append(charSequence2, i, i2);
            return this;
        }

        private java.lang.CharSequence a(java.lang.CharSequence charSequence) {
            String str;
            if (charSequence == null) {
                str = "";
            }
            return str;
        }
    }
    static {
        GlideException.a = new StackTraceElement[0];
    }

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        hasNext = th instanceof GlideException;
        if (th instanceof GlideException) {
            Iterator it = th.e().iterator();
            while (it.hasNext()) {
                a((Throwable)it.next(), list);
            }
        } else {
            list.add(th);
        }
    }

    private static void b(List<Throwable> list, java.lang.Appendable appendable) {
        try {
            GlideException.c(list, appendable);
        } catch (java.io.IOException ioException) {
            appendable = new RuntimeException(ioException);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) appendable;
        }
    }

    private static void c(List<Throwable> list, java.lang.Appendable appendable) throws IOException {
        int i = 0;
        final int size = list.size();
        i = 0;
        while (i < size) {
            i = i + 1;
            appendable.append("Cause (").append(String.valueOf(i)).append(" of ").append(String.valueOf(size)).append("): ");
            Object item = list.get(i);
            z = item instanceof GlideException;
        }
    }

    private static void d(Throwable th, java.lang.Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (java.io.IOException unused) {
            appendable = new RuntimeException(th);
            throw appendable;
        }
    }

    private void h(java.lang.Appendable appendable) {
        GlideException.d(this, appendable);
        GlideException.b(e(), new GlideException.a(appendable));
    }

    @Override // java.lang.Exception
    public List<Throwable> e() {
        return this.causes;
    }

    @Override // java.lang.Exception
    public List<Throwable> f() {
        final ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Exception
    public void g(String str) {
        int i = 0;
        final List list = f();
        final int size = list.size();
        i = 0;
        while (i < size) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "Root cause (";
            i = i + 1;
            String str5 = " of ";
            str3 = ")";
            str2 = str4 + i + str5 + size + str3;
            Log.i(str, str2, (Throwable)list.get(i));
        }
    }

    @Override // java.lang.Exception
    public String getMessage() {
        String str;
        String str3;
        Class dataClass2;
        StringBuilder stringBuilder = new StringBuilder(71);
        stringBuilder.append(this.detailMessage);
        str2 = ", ";
        str = "";
        if (this.dataClass != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            str = str2 + this.dataClass;
        } else {
        }
        stringBuilder.append(str);
        if (this.dataSource != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            str = str2 + this.dataSource;
        } else {
        }
        stringBuilder.append(str);
        if (this.key != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str = str2 + this.key;
        }
        stringBuilder.append(str);
        List list = f();
        if (list.isEmpty()) {
            return stringBuilder.toString();
        }
        int i = 1;
        if (list.size() == 1) {
            str3 = "\nThere was 1 root cause:";
            stringBuilder.append(str3);
        } else {
            stringBuilder.append("\nThere were ");
            stringBuilder.append(list.size());
            str3 = " root causes:";
            stringBuilder.append(str3);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            stringBuilder.append('\n');
            stringBuilder.append(item.getClass().getName());
            stringBuilder.append('(');
            stringBuilder.append(item.getMessage());
            stringBuilder.append(')');
        }
        stringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
        return stringBuilder.toString();
    }

    @Override // java.lang.Exception
    void i(f fVar, a aVar) {
        j(fVar, aVar, null);
    }

    @Override // java.lang.Exception
    void j(f fVar, a aVar, Class<?> cls) {
        this.key = fVar;
        this.dataSource = aVar;
        this.dataClass = cls;
    }

    @Override // java.lang.Exception
    public void k(Exception exc) {
        this.exception = exc;
    }

    @Override // java.lang.Exception
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    @Override // java.lang.Exception
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        super();
        this.detailMessage = str;
        setStackTrace(GlideException.a);
        this.causes = list;
    }

    @Override // java.lang.Exception
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    @Override // java.lang.Exception
    public Throwable fillInStackTrace() {
        return this;
    }
}
