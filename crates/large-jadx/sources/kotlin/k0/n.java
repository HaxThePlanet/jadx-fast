package kotlin.k0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0008\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\u0008\u0007\u001a\u0014\u0010\u0008\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\u0008¢\u0006\u0002\u0008\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015", d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
class n extends kotlin.k0.m {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0003", d2 = {"<anonymous>", "", "line", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class a extends p implements l<String, String> {

        public static final kotlin.k0.n.a a;
        static {
            n.a aVar = new n.a();
            n.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final String a(String string) {
            n.f(string, "line");
            return string;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return object;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0003", d2 = {"<anonymous>", "", "line", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class b extends p implements l<String, String> {

        final String $indent;
        b(String string) {
            this.$indent = string;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final String a(String string) {
            n.f(string, "line");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.$indent);
            stringBuilder.append(string);
            return stringBuilder.toString();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((String)object);
        }
    }
    private static final l<String, String> b(String string) {
        int bVar;
        p obj1;
        bVar = string.length() == 0 ? 1 : 0;
        if (bVar != 0) {
            obj1 = n.a.a;
        } else {
            bVar = new n.b(string);
            obj1 = bVar;
        }
        return obj1;
    }

    private static final int c(String string) {
        int length;
        int i2;
        int i;
        length = 0;
        i2 = -1;
        while (length < string.length()) {
            length++;
            i2 = -1;
        }
        length = i2;
        if (length == i2) {
            length = string.length();
        }
        return length;
    }

    public static final String d(String string, String string2) {
        int intValue;
        int invoke;
        Object next2;
        int valueOf;
        int i2;
        Object next;
        int i;
        Object obj;
        n.f(string, "$this$replaceIndent");
        n.f(string2, "newIndent");
        List list = v.m0(string);
        ArrayList arrayList = new ArrayList();
        Iterator iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            next2 = iterator3.next();
            if (z ^= 1 != 0) {
            }
            arrayList.add(next2);
        }
        ArrayList arrayList2 = new ArrayList(p.r(arrayList, 10));
        Iterator iterator2 = arrayList.iterator();
        for (String next5 : iterator2) {
            arrayList2.add(Integer.valueOf(n.c(next5)));
        }
        Comparable comparable = p.o0(arrayList2);
        if ((Integer)comparable != null) {
            intValue = (Integer)comparable.intValue();
        } else {
            intValue = invoke;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator iterator = list.iterator();
        for (Object next : iterator) {
            if (invoke != 0) {
            } else {
            }
            if (l.z((String)next)) {
            } else {
            }
            invoke = x.b1(next, intValue);
            invoke = n.b(string2).invoke(invoke);
            if (invoke != null && (String)invoke != null) {
            } else {
            }
            obj = next;
            if (obj != null) {
            }
            invoke = i;
            arrayList3.add(obj);
            invoke = obj15.invoke(invoke);
            if ((String)(String)invoke != null) {
            } else {
            }
            obj = invoke;
            if (invoke == p.i(list) && l.z(next)) {
            } else {
            }
        }
        StringBuilder obj15 = new StringBuilder(obj14 += i5);
        p.f0(arrayList3, obj15, "\n", 0, 0, 0, 0, 0, 124, 0);
        String obj14 = obj15.toString();
        n.e(obj14, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return obj14;
    }

    public static final String e(String string, String string2, String string3) {
        int length;
        Object next;
        int i;
        int size;
        int i2;
        int i3;
        int i4;
        int substring;
        Object obj;
        int i5;
        int i6;
        n.f(string, "$this$replaceIndentByMargin");
        n.f(string2, "newIndent");
        n.f(string3, "marginPrefix");
        if (z ^= 1 == 0) {
        } else {
            List list = v.m0(string);
            ArrayList arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            int i10 = 0;
            length = i10;
            for (Object next : iterator) {
                obj = next;
                if (length != 0) {
                } else {
                }
                if (l.z((String)obj)) {
                } else {
                }
                next = i10;
                i = -1;
                while (next < obj.length()) {
                    next++;
                    i = -1;
                }
                i3 = i;
                if (i3 == i) {
                } else {
                }
                if (l.L(obj, string3, i3, false, 4, 0)) {
                }
                length = n.b(string2).invoke(substring);
                if (substring != null && (String)length != null) {
                } else {
                }
                substring = obj;
                if (substring != null) {
                }
                length = i4;
                arrayList.add(substring);
                length = lVar.invoke(substring);
                if ((String)(String)length != null) {
                } else {
                }
                substring = length;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                n.e(obj.substring(i6 + length3), "(this as java.lang.String).substring(startIndex)");
                if (z2 ^= 1 != 0) {
                } else {
                }
                next++;
                i3 = next;
                if (length == p.i(list) && l.z(obj)) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder(length2 + i);
            p.f0(arrayList, stringBuilder, "\n", 0, 0, 0, 0, 0, 124, 0);
            String string4 = stringBuilder.toString();
            n.e(string4, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return string4;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        throw illegalArgumentException;
    }

    public static String f(String string) {
        n.f(string, "$this$trimIndent");
        return n.d(string, "");
    }

    public static final String g(String string, String string2) {
        n.f(string, "$this$trimMargin");
        n.f(string2, "marginPrefix");
        return n.e(string, "", string2);
    }

    public static String h(String string, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = "|";
        }
        return n.g(string, obj1);
    }
}
