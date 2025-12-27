package app.dogo.com.dogo_android.i;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DebugFeatureItem.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\u0008\t\nB\u0017\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0005\u000b\u000c\r\u000e\u000f¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/BaseDebugFeatureItem;", "name", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "BooleanDebugFeatureItem", "DoubleDebugFeatureItem", "JsonArrayDebugFeatureItem", "LongDebugFeatureItem", "StringDebugFeatureItem", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$BooleanDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$StringDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$DoubleDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$LongDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$JsonArrayDebugFeatureItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m0, reason: from kotlin metadata */
public abstract /* sealed */ class DebugFeatureItem extends f0 {

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\r¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$BooleanDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "booleanValue", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBooleanValue", "()Z", "setBooleanValue", "(Z)V", "getKey", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends m0 {

        private final String c;
        /* renamed from: d, reason: from kotlin metadata */
        private final String name;
        private boolean e;
        public a(String str, String str2, boolean z) {
            n.f(str, "name");
            n.f(str2, "key");
            super(str, str2, null);
            this.c = str;
            this.name = str2;
            this.e = z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public String component1() {
            return this.name;
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
        /* renamed from: d, reason: from kotlin metadata */
        /* operator */ public final void equals(boolean other) {
            this.e = other;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z6 = false;
            if (!(object instanceof DebugFeatureItem_BooleanDebugFeatureItem)) {
                return false;
            }
            if (!n.b(b(), object.b())) {
                return false;
            }
            if (!n.b(component1(), object.component1())) {
                return false;
            }
            return this.e != object.e ? z6 : z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            boolean z = true;
            if (this.e) {
                int i7 = 1;
            }
            return (b().hashCode() * 31) + component1().hashCode() * 31 + z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "BooleanDebugFeatureItem(name=";
            String str3 = b();
            String str4 = ", key=";
            String component1 = component1();
            String str5 = ", booleanValue=";
            str = str2 + str3 + str4 + component1 + str5 + this.e + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\r¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$DoubleDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "doubleValue", "", "(Ljava/lang/String;Ljava/lang/String;D)V", "getDoubleValue", "()D", "setDoubleValue", "(D)V", "getKey", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends m0 {

        private final String c;
        /* renamed from: d, reason: from kotlin metadata */
        private final String name;
        private double e;
        @Override // app.dogo.com.dogo_android.i.m0
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public String component1() {
            return this.name;
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
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof DebugFeatureItem_DoubleDebugFeatureItem)) {
                return false;
            }
            if (!n.b(b(), other.b())) {
                return false;
            }
            if (!n.b(component1(), other.component1())) {
                return false;
            }
            return !n.b(Double.valueOf(this.e), Double.valueOf(other.e)) ? z5 : z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return (b().hashCode() * 31) + component1().hashCode() * 31 + Double.hashCode(this.e);
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DoubleDebugFeatureItem(name=";
            String str3 = b();
            String str4 = ", key=";
            String component1 = component1();
            String str5 = ", doubleValue=";
            str = str2 + str3 + str4 + component1 + str5 + this.e + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$JsonArrayDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "listValue", "", "selectionList", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getListValue", "()Ljava/util/List;", "getName", "getSelectionList", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends m0 {

        private final String c;
        /* renamed from: d, reason: from kotlin metadata */
        private final String name;
        /* renamed from: e, reason: from kotlin metadata */
        private final List<String> selectionList;
        private final List<String> f;
        public c(String str, String str2, List<String> list, List<String> list2) {
            n.f(str, "name");
            n.f(str2, "key");
            n.f(list, "listValue");
            n.f(list2, "selectionList");
            super(str, str2, null);
            this.c = str;
            this.name = str2;
            this.selectionList = list;
            this.f = list2;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public String component1() {
            return this.name;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String b() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final List<String> c() {
            return this.selectionList;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final List<String> d() {
            return this.f;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z6 = false;
            if (!(other instanceof DebugFeatureItem_JsonArrayDebugFeatureItem)) {
                return false;
            }
            if (!n.b(b(), other.b())) {
                return false;
            }
            if (!n.b(component1(), other.component1())) {
                return false;
            }
            if (!n.b(this.selectionList, other.selectionList)) {
                return false;
            }
            return !n.b(this.f, other.f) ? z6 : z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return (b().hashCode() * 31) + component1().hashCode() * 31 + this.selectionList.hashCode() * 31 + this.f.hashCode();
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "JsonArrayDebugFeatureItem(name=";
            String str3 = b();
            String str4 = ", key=";
            String component1 = component1();
            String str5 = ", listValue=";
            String str6 = ", selectionList=";
            str = str2 + str3 + str4 + component1 + str5 + this.selectionList + str6 + this.f + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\t¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$LongDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "longValue", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getKey", "()Ljava/lang/String;", "getLongValue", "()J", "setLongValue", "(J)V", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends m0 {

        private final String c;
        /* renamed from: d, reason: from kotlin metadata */
        private final String name;
        private long e;
        public d(String str, String str2, long j) {
            n.f(str, "name");
            n.f(str2, "key");
            super(str, str2, null);
            this.c = str;
            this.name = str2;
            this.e = j;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public String component1() {
            return this.name;
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
        /* renamed from: d, reason: from kotlin metadata */
        /* operator */ public final void equals(long other) {
            this.e = other;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z5 = false;
            if (!(object instanceof DebugFeatureItem_LongDebugFeatureItem)) {
                return false;
            }
            if (!n.b(b(), object.b())) {
                return false;
            }
            if (!n.b(component1(), object.component1())) {
                return false;
            }
            return this.e != object.e ? z5 : z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return (b().hashCode() * 31) + component1().hashCode() * 31 + Long.hashCode(this.e);
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LongDebugFeatureItem(name=";
            String str3 = b();
            String str4 = ", key=";
            String component1 = component1();
            String str5 = ", longValue=";
            str = str2 + str3 + str4 + component1 + str5 + this.e + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0008\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureItem$StringDebugFeatureItem;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "name", "", "key", "stringValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "getStringValue", "setStringValue", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends m0 {

        /* renamed from: c, reason: from kotlin metadata */
        private final String name;
        /* renamed from: d, reason: from kotlin metadata */
        private final String stringValue;
        private String e;
        public e(String str, String str2, String str3) {
            n.f(str, "name");
            n.f(str2, "key");
            n.f(str3, "stringValue");
            super(str, str2, null);
            this.name = str;
            this.stringValue = str2;
            this.e = str3;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public String component1() {
            return this.stringValue;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String b() {
            return this.name;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public final String c() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        /* renamed from: d, reason: from kotlin metadata */
        /* operator */ public final void equals(String other) {
            n.f(other, "<set-?>");
            this.e = other;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z5 = false;
            if (!(object instanceof DebugFeatureItem_StringDebugFeatureItem)) {
                return false;
            }
            if (!n.b(b(), object.b())) {
                return false;
            }
            if (!n.b(component1(), object.component1())) {
                return false;
            }
            return !n.b(this.e, object.e) ? z5 : z;
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public int hashCode() {
            return (b().hashCode() * 31) + component1().hashCode() * 31 + this.e.hashCode();
        }

        @Override // app.dogo.com.dogo_android.i.m0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "StringDebugFeatureItem(name=";
            String str3 = b();
            String str4 = ", key=";
            String component1 = component1();
            String str5 = ", stringValue=";
            str = str2 + str3 + str4 + component1 + str5 + this.e + 41;
            return str;
        }
    }
    private m0(String str, String str2) {
        super(str, str2);
    }

    public /* synthetic */ m0(String str, String str2, g gVar) {
        this(str, str2);
    }
}
