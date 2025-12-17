package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class p {

    public static final class a {

        private final List<String> a;
        private final Object b;
        a(Object object, com.google.android.gms.common.internal.b1 b12) {
            super();
            r.j(object);
            this.b = object;
            ArrayList obj1 = new ArrayList();
            this.a = obj1;
        }

        public com.google.android.gms.common.internal.p.a a(String string, Object object2) {
            r.j(string);
            final String obj6 = String.valueOf(object2);
            StringBuilder stringBuilder = new StringBuilder(i += length2);
            stringBuilder.append(string);
            stringBuilder.append("=");
            stringBuilder.append(obj6);
            this.a.add(stringBuilder.toString());
            return this;
        }

        public String toString() {
            int i;
            int str;
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append(this.b.getClass().getSimpleName());
            stringBuilder.append('{');
            int size = this.a.size();
            i = 0;
            while (i < size) {
                stringBuilder.append((String)this.a.get(i));
                if (i < size + -1) {
                }
                i++;
                stringBuilder.append(", ");
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    public static boolean a(Object object, Object object2) {
        int i;
        boolean obj2;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    i = i2;
                }
                return 0;
            }
        } else {
        }
        return i;
    }

    public static int b(Object... objectArr) {
        return Arrays.hashCode(objectArr);
    }

    public static com.google.android.gms.common.internal.p.a c(Object object) {
        p.a aVar = new p.a(object, 0);
        return aVar;
    }
}
