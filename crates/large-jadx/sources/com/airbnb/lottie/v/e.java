package com.airbnb.lottie.v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class e {

    public static final e c = new e();
    private final List<String> a;
    private f b;
    static {
        String[] strArr = new String[] {"COMPOSITION"};
    }

    public e(String... strArr) {
        super();
        this.a = Arrays.asList(strArr);
    }

    private boolean b() {
        return (String)this.a.get(this.a.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public e a(String str) {
        final com.airbnb.lottie.v.e eVar = new e(this);
        eVar.a.add(str);
        return eVar;
    }

    public boolean c(String str, int i) {
        boolean z2 = false;
        boolean z3 = false;
        boolean equals;
        int i4;
        boolean z;
        i = 0;
        if (i >= this.a.size()) {
            return false;
        }
        i = 1;
        int r0 = i;
        Object item = this.a.get(i);
        if (!item.equals("**")) {
            if (!item.equals(str)) {
                if (item.equals("*")) {
                } else {
                }
            }
            if (this.a == 0) {
                i = this.a.size() - 2;
                if (i == this.a.size() - 2 && this.b() && i != 0) {
                }
            }
            return z2;
        }
        if (this.a == 0) {
            i3 = i + 1;
            int r3 = i;
        }
        if (this.a != 0) {
            i4 = this.a.size() - 2;
            if (i != this.a.size() - 2) {
                i4 = this.a.size() - 3;
                if (i == this.a.size() - 3 && this.b()) {
                }
            }
            return z3;
        }
        if (this.a != 0) {
            return true;
        }
        i += i;
        if (i7 < this.a.size() - i) {
            return false;
        }
        return (String)this.a.get(i7).equals(str);
    }

    public f d() {
        return this.b;
    }

    public int e(String str, int i) {
        final int i3 = 0;
        if (f(str)) {
            return i3;
        }
        int i4 = 1;
        if (!(String)this.a.get(i).equals("**")) {
            return i4;
        }
        if (i == this.a.size() - i4) {
            return i3;
        }
        if ((String)this.a.get(i + i4).equals(str)) {
            return 2;
        }
        return i3;
    }

    public boolean g(String str, int i) {
        final boolean z2 = true;
        if (f(str)) {
            return true;
        }
        final boolean z3 = false;
        if (i >= this.a.size()) {
            return false;
        }
        if (!(String)this.a.get(i).equals(str)) {
            if (!(String)this.a.get(i).equals("**")) {
                str2 = "*";
                return false;
            }
        }
        return true;
    }

    public boolean h(String str, int i) {
        boolean z = true;
        int i3 = 1;
        if ("__container".equals(str)) {
            return true;
        }
        i = this.a.size() - i3;
        if (i >= this.a.size() - i3) {
            str2 = "**";
            if (!((String)this.a.get(i).equals(str2))) {
                int i4 = 0;
            }
        }
        return z;
    }

    public e i(f fVar) {
        final com.airbnb.lottie.v.e eVar = new e(this);
        eVar.b = fVar;
        return eVar;
    }

    public String toString() {
        boolean z = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyPath{keys=");
        stringBuilder.append(this.a);
        stringBuilder.append(",resolved=");
        int r1 = this.b != null ? 1 : 0;
        stringBuilder.append((this.b != null ? 1 : 0));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private e(e eVar) {
        super();
        this.a = new ArrayList(eVar.a);
        this.b = eVar.b;
    }
}
