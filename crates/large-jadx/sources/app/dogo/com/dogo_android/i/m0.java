package app.dogo.com.dogo_android.i;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\u0008\t\nB\u0017\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0005\u000b\u000c\r\u000e\u000f¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/BaseDebugFeatureItem;", "name", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "BooleanDebugFeatureItem", "DoubleDebugFeatureItem", "JsonArrayDebugFeatureItem", "LongDebugFeatureItem", "StringDebugFeatureItem", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$BooleanDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$StringDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$DoubleDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$LongDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$JsonArrayDebugFeatureItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class m0 extends app.dogo.com.dogo_android.i.f0 {

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\r¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$BooleanDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "booleanValue", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBooleanValue", "()Z", "setBooleanValue", "(Z)V", "getKey", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends app.dogo.com.dogo_android.i.m0 {

        private final String c;
        private final String d;
        private boolean e;
        public a(String string, String string2, boolean z3) {
            n.f(string, "name");
            n.f(string2, "key");
            super(string, string2, 0);
            this.c = string;
            this.d = string2;
            this.e = z3;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String a() {
            return this.d;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String b() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final boolean c() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final void d(boolean z) {
            this.e = z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m0.a) {
                return i2;
            }
            if (!n.b(b(), (m0.a)object.b())) {
                return i2;
            }
            if (!n.b(a(), object.a())) {
                return i2;
            }
            if (this.e != object.e) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            boolean z;
            if (this.e) {
                z = 1;
            }
            return i4 += z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BooleanDebugFeatureItem(name=");
            stringBuilder.append(b());
            stringBuilder.append(", key=");
            stringBuilder.append(a());
            stringBuilder.append(", booleanValue=");
            stringBuilder.append(this.e);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\r¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$DoubleDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "doubleValue", "", "(Ljava/lang/String;Ljava/lang/String;D)V", "getDoubleValue", "()D", "setDoubleValue", "(D)V", "getKey", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.i.m0 {

        private final String c;
        private final String d;
        private double e;
        @Override // app.dogo.com.dogo_android.i.m0
        public String a() {
            return this.d;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String b() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final double c() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m0.b) {
                return i2;
            }
            if (!n.b(b(), (m0.b)object.b())) {
                return i2;
            }
            if (!n.b(a(), object.a())) {
                return i2;
            }
            if (!n.b(Double.valueOf(this.e), Double.valueOf(object.e))) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return i4 += i7;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DoubleDebugFeatureItem(name=");
            stringBuilder.append(b());
            stringBuilder.append(", key=");
            stringBuilder.append(a());
            stringBuilder.append(", doubleValue=");
            stringBuilder.append(this.e);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$JsonArrayDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "listValue", "", "selectionList", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getListValue", "()Ljava/util/List;", "getName", "getSelectionList", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.i.m0 {

        private final String c;
        private final String d;
        private final List<String> e;
        private final List<String> f;
        public c(String string, String string2, List<String> list3, List<String> list4) {
            n.f(string, "name");
            n.f(string2, "key");
            n.f(list3, "listValue");
            n.f(list4, "selectionList");
            super(string, string2, 0);
            this.c = string;
            this.d = string2;
            this.e = list3;
            this.f = list4;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String a() {
            return this.d;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String b() {
            return this.c;
        }

        public final List<String> c() {
            return this.e;
        }

        public final List<String> d() {
            return this.f;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m0.c) {
                return i2;
            }
            if (!n.b(b(), (m0.c)object.b())) {
                return i2;
            }
            if (!n.b(a(), object.a())) {
                return i2;
            }
            if (!n.b(this.e, object.e)) {
                return i2;
            }
            if (!n.b(this.f, object.f)) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return i6 += i10;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JsonArrayDebugFeatureItem(name=");
            stringBuilder.append(b());
            stringBuilder.append(", key=");
            stringBuilder.append(a());
            stringBuilder.append(", listValue=");
            stringBuilder.append(this.e);
            stringBuilder.append(", selectionList=");
            stringBuilder.append(this.f);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\t¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$LongDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "longValue", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getKey", "()Ljava/lang/String;", "getLongValue", "()J", "setLongValue", "(J)V", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends app.dogo.com.dogo_android.i.m0 {

        private final String c;
        private final String d;
        private long e;
        public d(String string, String string2, long l3) {
            n.f(string, "name");
            n.f(string2, "key");
            super(string, string2, 0);
            this.c = string;
            this.d = string2;
            this.e = l3;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String a() {
            return this.d;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String b() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final long c() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final void d(long l) {
            this.e = l;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m0.d) {
                return i2;
            }
            if (!n.b(b(), (m0.d)object.b())) {
                return i2;
            }
            if (!n.b(a(), object.a())) {
                return i2;
            }
            if (Long.compare(l, l2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return i4 += i7;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LongDebugFeatureItem(name=");
            stringBuilder.append(b());
            stringBuilder.append(", key=");
            stringBuilder.append(a());
            stringBuilder.append(", longValue=");
            stringBuilder.append(this.e);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0008\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$StringDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "stringValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "getStringValue", "setStringValue", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends app.dogo.com.dogo_android.i.m0 {

        private final String c;
        private final String d;
        private String e;
        public e(String string, String string2, String string3) {
            n.f(string, "name");
            n.f(string2, "key");
            n.f(string3, "stringValue");
            super(string, string2, 0);
            this.c = string;
            this.d = string2;
            this.e = string3;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String a() {
            return this.d;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String b() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final String c() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final void d(String string) {
            n.f(string, "<set-?>");
            this.e = string;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m0.e) {
                return i2;
            }
            if (!n.b(b(), (m0.e)object.b())) {
                return i2;
            }
            if (!n.b(a(), object.a())) {
                return i2;
            }
            if (!n.b(this.e, object.e)) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return i4 += i7;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("StringDebugFeatureItem(name=");
            stringBuilder.append(b());
            stringBuilder.append(", key=");
            stringBuilder.append(a());
            stringBuilder.append(", stringValue=");
            stringBuilder.append(this.e);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    private m0(String string, String string2) {
        super(string, string2);
    }

    public m0(String string, String string2, g g3) {
        super(string, string2);
    }
}
