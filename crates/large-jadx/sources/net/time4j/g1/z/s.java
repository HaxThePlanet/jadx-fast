package net.time4j.g1.z;

import java.text.ParsePosition;
import net.time4j.engine.q;

/* loaded from: classes3.dex */
public class s {

    private ParsePosition a;
    private String b;
    private q<?> c;
    private boolean d;
    public s() {
        super(0);
    }

    public s(int i) {
        super();
        if (i < 0) {
        } else {
            ParsePosition parsePosition = new ParsePosition(i);
            this.a = parsePosition;
            this.b = "";
            this.c = 0;
            this.d = false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Undefined: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
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
        q vVar;
        int i;
        if (this.c == null) {
            i = 0;
            vVar = new v(i, i);
            this.c = vVar;
        }
        return this.c;
    }

    q<?> h() {
        return this.c;
    }

    public boolean i() {
        int i;
        i = this.a.getErrorIndex() != -1 ? 1 : 0;
        return i;
    }

    boolean j() {
        return this.d;
    }

    public void k(int i, String string2) {
        boolean empty;
        String obj4;
        if (i < 0) {
        } else {
            if (string2 != null) {
                if (string2.isEmpty()) {
                    obj4 = new StringBuilder();
                    obj4.append("Error occurred at position: ");
                    obj4.append(i);
                    obj4 = obj4.toString();
                }
            } else {
            }
            this.b = obj4;
            this.a.setErrorIndex(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Undefined error index: ");
        stringBuilder.append(i);
        obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    public void l(int i) {
        if (i < 0) {
        } else {
            this.a.setIndex(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Undefined position: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    void m(q<?> q) {
        this.c = q;
    }

    public void n() {
        boolean z;
        int i;
        if (!i()) {
            this.b = "Warning state active.";
            this.a.setErrorIndex(f());
        }
        this.d = true;
    }

    public String toString() {
        boolean str;
        q qVar;
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
}
