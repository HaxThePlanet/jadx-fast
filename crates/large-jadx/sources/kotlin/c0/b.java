package kotlin.c0;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\u0008\u001a\u0002H\t\"\n\u0008\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\u0008¢\u0006\u0002\u0010\u000c\u001a\u0008\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class b {

    public static final kotlin.c0.a a;
    static {
        int instance;
        Object aVar;
        final Class<kotlin.c0.a> obj = a.class;
        instance = b.a();
        final String str2 = "ClassCastException(\"Inst…baseTypeCL\").initCause(e)";
        final String str3 = ", base type classloader: ";
        final String str4 = "Instance classloader: ";
        final String str6 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";
        final String str7 = "Class.forName(\"kotlin.in…entations\").newInstance()";
        if (instance >= 65544) {
            aVar = Class.forName("kotlin.c0.e.a").newInstance();
            n.e(aVar, str7);
            if (aVar == null) {
            } else {
                b.a = aVar;
            }
            NullPointerException nullPointerException2 = new NullPointerException(str6);
            throw nullPointerException2;
        }
        if (instance >= 65543) {
            instance = Class.forName("kotlin.c0.d.a").newInstance();
            n.e(instance, str7);
            if (instance == null) {
            } else {
                aVar = instance;
            }
            NullPointerException nullPointerException = new NullPointerException(str6);
            throw nullPointerException;
        }
        aVar = new a();
    }

    private static final int a() {
        String property;
        int length;
        int i2;
        String substring;
        String str2;
        String str;
        int i6;
        int i7;
        int i3;
        int i4;
        int i5;
        int i;
        property = System.getProperty("java.specification.version");
        i3 = 65542;
        i4 = l.d0(property, '.', 0, false, 6, 0);
        i5 = 65536;
        if (property != null && i4 < 0) {
            i4 = l.d0(property, '.', 0, false, 6, 0);
            i5 = 65536;
            if (i4 < 0) {
                return int * i5;
            }
            i = i4 + 1;
            if (l.d0(property, '.', i, false, 4, 0) < 0) {
                length = property.length();
            }
            str2 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(property, str2);
            substring = property.substring(0, i4);
            str = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            n.e(substring, str);
            Objects.requireNonNull(property, str2);
            String substring2 = property.substring(i, length);
            n.e(substring2, str);
            i3 = i2 + property;
        }
        return i3;
    }
}
