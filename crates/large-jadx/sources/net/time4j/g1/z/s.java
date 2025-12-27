package net.time4j.g1.z;

import java.text.ParsePosition;
import net.time4j.engine.q;

/* compiled from: ParseLog.java */
/* loaded from: classes3.dex */
public class s {

    private ParsePosition a;
    private String b;
    private q<?> c;
    private boolean d;
    public s() {
        this(0);
    }

    void a() {
        this.a.setErrorIndex(-1);
        this.b = "";
    }

    void b() {
        this.d = false;
    }

    public int c() {
        return this.a.getErrorIndex();
    }

    public String d() {
        return this.b;
    }

    ParsePosition e() {
        return this.a;
    }

    public int f() {
        return this.a.getIndex();
    }

    public q<?> g() {
        if (this.c == null) {
            int i = 0;
            this.c = new v(i, i);
        }
        return this.c;
    }

    q<?> h() {
        return this.c;
    }

    public boolean i() {
        boolean z = true;
        int r0 = this.a.getErrorIndex() != -1 ? 1 : 0;
        return (this.a.getErrorIndex() != -1 ? 1 : 0);
    }

    boolean j() {
        return this.d;
    }

    public void k(int i, String str) {
        String str3;
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str4 = "Undefined error index: ";
            i = str4 + i;
            throw new IllegalArgumentException(i);
        } else {
            if (str == null || str.isEmpty()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                str = "Error occurred at position: ";
                str3 = str + i;
            }
            this.b = str3;
            this.a.setErrorIndex(i);
            return;
        }
    }

    public void l(int i) {
        if (i < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Undefined position: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            this.a.setIndex(i);
            return;
        }
    }

    void m(q<?> qVar) {
        this.c = qVar;
    }

    public void n() {
        if (!i()) {
            this.b = "Warning state active.";
            this.a.setErrorIndex(f());
        }
        this.d = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("[position=");
        stringBuilder.append(f());
        stringBuilder.append(", error-index=");
        stringBuilder.append(c());
        stringBuilder.append(", error-message=\"");
        stringBuilder.append(this.b);
        stringBuilder.append('"');
        if (this.d) {
            stringBuilder.append(", warning-active");
        }
        if (this.c != null) {
            stringBuilder.append(", raw-values=");
            stringBuilder.append(this.c);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public s(int i) {
        super();
        if (i < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Undefined: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            this.a = new ParsePosition(i);
            this.b = "";
            this.c = null;
            this.d = false;
            return;
        }
    }
}
