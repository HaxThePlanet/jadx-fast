package kotlin.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.f;
import kotlin.z.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000f\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\u000c\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\u0008ø\u0001\u0000\u001aC\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\u000c\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\u0008ø\u0001\u0000\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\u0008\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\u0008\u0000\u0010\u0007H\u0087\u0008\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\u0008\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aN\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\u0008\"\u0004\u0008\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\u0008\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\u0008\u001fH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\u0008\"\u0004\u0008\u0000\u0010\u001b2\u001f\u0008\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\u0008\u001fH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010 \u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007\u001a\u0015\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007H\u0087\u0008\u001a+\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0008\u0008\u0000\u0010\u0007*\u00020$2\u0008\u0010%\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010&\u001a3\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0008\u0008\u0000\u0010\u0007*\u00020$2\u0016\u0010\u0017\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\u0008\u0000\u0010\u0007H\u0087\u0008\u001a+\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010(\u001a\u00020\u001e2\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008+\u001a\u0008\u0010,\u001a\u00020\u001eH\u0001\u001a\u0008\u0010-\u001a\u00020\u001eH\u0001\u001a%\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010/\u001aS\u00100\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00082\u0006\u0010%\u001a\u0002H\u00072\u001a\u00101\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u000702j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0007`32\u0008\u0008\u0002\u0010)\u001a\u00020\u00062\u0008\u0008\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00104\u001a>\u00100\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00082\u0008\u0008\u0002\u0010)\u001a\u00020\u00062\u0008\u0008\u0002\u0010*\u001a\u00020\u00062\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00100\u001a\u00020\u0006\"\u000e\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u000706*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u00082\u0008\u0010%\u001a\u0004\u0018\u0001H\u00072\u0008\u0008\u0002\u0010)\u001a\u00020\u00062\u0008\u0008\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00107\u001ag\u00108\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u000e\u0008\u0001\u00109*\u0008\u0012\u0004\u0012\u0002H906*\u0008\u0012\u0004\u0012\u0002H\u00070\u00082\u0008\u0010:\u001a\u0004\u0018\u0001H92\u0008\u0008\u0002\u0010)\u001a\u00020\u00062\u0008\u0008\u0002\u0010*\u001a\u00020\u00062\u0016\u0008\u0004\u0010;\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H90\u000eH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010<\u001a,\u0010=\u001a\u00020>\"\t\u0008\u0000\u0010\u0007¢\u0006\u0002\u0008?*\u0008\u0012\u0004\u0012\u0002H\u00070\u00022\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\u0008\u001a;\u0010@\u001a\u0002HA\"\u0010\u0008\u0000\u0010B*\u0006\u0012\u0002\u0008\u00030\u0002*\u0002HA\"\u0004\u0008\u0001\u0010A*\u0002HB2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u0002HA0DH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010E\u001a\u0019\u0010F\u001a\u00020>\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\u0008\u001a,\u0010G\u001a\u00020>\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000\u001a\u001e\u0010H\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u0008H\u0000\u001a!\u0010I\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\u0008\u001a!\u0010I\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0008H\u0087\u0008\u001a&\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070K2\u0006\u0010L\u001a\u00020MH\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006N", d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", "", "random", "Lkotlin/random/Random;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
class r extends kotlin.y.q {
    public static <T> ArrayList<T> c(T... tArr) {
        int arrayList;
        kotlin.y.g gVar;
        int i;
        ArrayList obj3;
        n.f(tArr, "elements");
        if (tArr.length == 0) {
            obj3 = new ArrayList();
        } else {
            gVar = new g(tArr, 1);
            arrayList = new ArrayList(gVar);
            obj3 = arrayList;
        }
        return obj3;
    }

    public static final <T> Collection<T> d(T[] tArr) {
        n.f(tArr, "$this$asCollection");
        g gVar = new g(tArr, 0);
        return gVar;
    }

    public static final <T extends Comparable<? super T>> int e(List<? extends T> list, T t2, int i3, int i4) {
        int size;
        int i;
        int obj4;
        int obj5;
        n.f(list, "$this$binarySearch");
        r.o(list.size(), i3, i4);
        i4--;
        while (obj4 <= obj5) {
            i2 >>>= 1;
            i = a.c((Comparable)list.get(i5), t2);
            obj5 = size;
            obj4 = size;
        }
        return -obj4;
    }

    public static int f(List list, Comparable comparable2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = list.size();
        }
        return r.e(list, comparable2, obj2, obj3);
    }

    public static <T> List<T> g() {
        return b0.a;
    }

    public static f h(Collection<?> collection) {
        n.f(collection, "$this$indices");
        f fVar = new f(0, obj2--);
        return fVar;
    }

    public static <T> int i(List<? extends T> list) {
        n.f(list, "$this$lastIndex");
        return obj1--;
    }

    public static <T> List<T> j(T... tArr) {
        List obj1;
        n.f(tArr, "elements");
        if (tArr.length > 0) {
            obj1 = i.d(tArr);
        } else {
            obj1 = p.g();
        }
        return obj1;
    }

    public static <T> List<T> k(T t) {
        List obj0;
        if (t != null) {
            obj0 = p.b(t);
        } else {
            obj0 = p.g();
        }
        return obj0;
    }

    public static <T> List<T> l(T... tArr) {
        n.f(tArr, "elements");
        return m.v(tArr);
    }

    public static <T> List<T> m(T... tArr) {
        int arrayList;
        kotlin.y.g gVar;
        int i;
        ArrayList obj3;
        n.f(tArr, "elements");
        if (tArr.length == 0) {
            obj3 = new ArrayList();
        } else {
            gVar = new g(tArr, 1);
            arrayList = new ArrayList(gVar);
            obj3 = arrayList;
        }
        return obj3;
    }

    public static <T> List<T> n(List<? extends T> list) {
        int size;
        int i;
        Object obj2;
        n.f(list, "$this$optimizeReadOnlyList");
        size = list.size();
        if (size != 0) {
            if (size != 1) {
            } else {
                obj2 = p.b(list.get(0));
            }
        } else {
            obj2 = p.g();
        }
        return obj2;
    }

    private static final void o(int i, int i2, int i3) {
        final String str = ").";
        String str2 = "fromIndex (";
        if (i2 > i3) {
        } else {
            if (i2 < 0) {
            } else {
                if (i3 > i) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("toIndex (");
                stringBuilder.append(i3);
                stringBuilder.append(") is greater than size (");
                stringBuilder.append(i);
                stringBuilder.append(str);
                IndexOutOfBoundsException obj4 = new IndexOutOfBoundsException(stringBuilder.toString());
                throw obj4;
            }
            StringBuilder obj5 = new StringBuilder();
            obj5.append(str2);
            obj5.append(i2);
            obj5.append(") is less than zero.");
            IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException(obj5.toString());
            throw obj3;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(i2);
        stringBuilder2.append(") is greater than toIndex (");
        stringBuilder2.append(i3);
        stringBuilder2.append(str);
        obj3 = new IllegalArgumentException(stringBuilder2.toString());
        throw obj3;
    }

    public static void p() {
        ArithmeticException arithmeticException = new ArithmeticException("Count overflow has happened.");
        throw arithmeticException;
    }

    public static void q() {
        ArithmeticException arithmeticException = new ArithmeticException("Index overflow has happened.");
        throw arithmeticException;
    }
}
