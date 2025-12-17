package com.airbnb.lottie.v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    public static final com.airbnb.lottie.v.e c;
    private final List<String> a;
    private com.airbnb.lottie.v.f b;
    static {
        e eVar = new e(/* result */);
        e.c = eVar;
    }

    private e(com.airbnb.lottie.v.e e) {
        super();
        ArrayList arrayList = new ArrayList(e.a);
        this.a = arrayList;
        this.b = e.b;
    }

    public e(String... stringArr) {
        super();
        this.a = Arrays.asList(stringArr);
    }

    private boolean b() {
        List list = this.a;
        return (String)list.get(size--).equals("**");
    }

    private boolean f(String string) {
        return "__container".equals(string);
    }

    public com.airbnb.lottie.v.e a(String string) {
        e eVar = new e(this);
        eVar.a.add(string);
        return eVar;
    }

    public boolean c(String string, int i2) {
        int i;
        int i4;
        int i3;
        Object equals;
        int equals2;
        int obj6;
        int obj7;
        i4 = 0;
        if (i2 >= this.a.size()) {
            return i4;
        }
        final int i7 = 1;
        i = i2 == size2 -= i7 ? i7 : i4;
        equals = this.a.get(i2);
        if (!(String)equals.equals("**")) {
            if (!equals.equals(string)) {
                if (equals.equals("*")) {
                    obj6 = i7;
                } else {
                    obj6 = i4;
                }
            } else {
            }
            if (i == 0) {
                if (i2 == size3 += -2 && b() && obj6 != null) {
                    if (b()) {
                        if (obj6 != null) {
                            i4 = i7;
                        }
                    }
                }
            } else {
            }
            return i4;
        }
        if (i == 0 && (String)this.a.get(i2 + 1).equals(string)) {
            i3 = (String)this.a.get(i2 + 1).equals(string) ? i7 : i4;
        } else {
        }
        if (i3 != 0) {
            if (i2 != obj6 += -2) {
                if (i2 == obj6 += -3 && b()) {
                    if (b()) {
                        i4 = i7;
                    }
                }
            } else {
            }
            return i4;
        }
        if (i != 0) {
            return i7;
        }
        i2 += i7;
        if (obj7 < size4 -= i7) {
            return i4;
        }
        return (String)this.a.get(obj7).equals(string);
    }

    public com.airbnb.lottie.v.f d() {
        return this.b;
    }

    public int e(String string, int i2) {
        final int i3 = 0;
        if (f(string)) {
            return i3;
        }
        int i4 = 1;
        if (!(String)this.a.get(i2).equals("**")) {
            return i4;
        }
        if (i2 == size -= i4) {
            return i3;
        }
        if ((String)this.a.get(i2 += i4).equals(string)) {
            return 2;
        }
        return i3;
    }

    public boolean g(String string, int i2) {
        Object str;
        boolean obj4;
        int obj5;
        final int i = 1;
        if (f(string)) {
            return i;
        }
        final int i3 = 0;
        if (i2 >= this.a.size()) {
            return i3;
        }
        if (!(String)this.a.get(i2).equals(string) && !(String)this.a.get(i2).equals("**") && (String)this.a.get(i2).equals("*")) {
            if (!(String)this.a.get(i2).equals("**")) {
                if ((String)this.a.get(i2).equals("*")) {
                }
                return i3;
            }
        }
        return i;
    }

    public boolean h(String string, int i2) {
        int i;
        int obj2;
        int obj3;
        i = 1;
        if ("__container".equals(string)) {
            return i;
        }
        if (i2 >= obj2 -= i) {
            if ((String)this.a.get(i2).equals("**")) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    public com.airbnb.lottie.v.e i(com.airbnb.lottie.v.f f) {
        e eVar = new e(this);
        eVar.b = f;
        return eVar;
    }

    public String toString() {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyPath{keys=");
        stringBuilder.append(this.a);
        stringBuilder.append(",resolved=");
        i = this.b != null ? 1 : 0;
        stringBuilder.append(i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
