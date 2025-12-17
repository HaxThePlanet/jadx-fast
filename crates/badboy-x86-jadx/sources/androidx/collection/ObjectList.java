package androidx.collection;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u001c\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u000f\u0008\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J:\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u000e\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001eH&J\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u00172\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000J\u0019\u0010!\u001a\u00020\u00172\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010#J\u0014\u0010!\u001a\u00020\u00172\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000$J\u0014\u0010!\u001a\u00020\u00172\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001eJ\u0006\u0010%\u001a\u00020\u0004J:\u0010%\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0015\u0010&\u001a\u00028\u00002\u0008\u0008\u0001\u0010'\u001a\u00020\u0004¢\u0006\u0002\u0010(J>\u0010)\u001a\u00028\u00002\u0008\u0008\u0001\u0010'\u001a\u00020\u00042!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008('\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00172\u0008\u0010-\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u000b\u0010.\u001a\u00028\u0000¢\u0006\u0002\u0010/J?\u0010.\u001a\u00028\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0010\u00101\u001a\u0004\u0018\u00018\u0000H\u0086\u0008¢\u0006\u0002\u0010/JA\u00101\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100Jb\u00102\u001a\u0002H3\"\u0004\u0008\u0001\u001032\u0006\u00104\u001a\u0002H326\u00105\u001a2\u0012\u0013\u0012\u0011H3¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(7\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u0002H306H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u00109\u001a\u0002H3\"\u0004\u0008\u0001\u001032\u0006\u00104\u001a\u0002H32K\u00105\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008('\u0012\u0013\u0012\u0011H3¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(7\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u0002H30:H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;Jb\u0010<\u001a\u0002H3\"\u0004\u0008\u0001\u001032\u0006\u00104\u001a\u0002H326\u00105\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u0011H3¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(7\u0012\u0004\u0012\u0002H306H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u0010=\u001a\u0002H3\"\u0004\u0008\u0001\u001032\u0006\u00104\u001a\u0002H32K\u00105\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008('\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u0011H3¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(7\u0012\u0004\u0012\u0002H30:H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;J:\u0010>\u001a\u00020?2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020?0\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001JO\u0010A\u001a\u00020?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008('\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020?06H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J:\u0010B\u001a\u00020?2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020?0\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001JO\u0010C\u001a\u00020?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008('\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020?06H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0018\u0010D\u001a\u00028\u00002\u0008\u0008\u0001\u0010'\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010(J\u0008\u0010E\u001a\u00020\u0004H\u0016J\u0013\u0010F\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010GJ:\u0010H\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J:\u0010I\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0006\u0010J\u001a\u00020\u0017J\u0006\u0010K\u001a\u00020\u0017JR\u0010L\u001a\u00020M2\u0008\u0008\u0002\u0010N\u001a\u00020O2\u0008\u0008\u0002\u0010P\u001a\u00020O2\u0008\u0008\u0002\u0010Q\u001a\u00020O2\u0008\u0008\u0002\u0010R\u001a\u00020\u00042\u0008\u0008\u0002\u0010S\u001a\u00020O2\u0016\u0008\u0002\u0010T\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020O\u0018\u00010\u0019H\u0007J\u000b\u0010U\u001a\u00028\u0000¢\u0006\u0002\u0010/J?\u0010U\u001a\u00028\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0013\u0010V\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010GJ\u0010\u0010W\u001a\u0004\u0018\u00018\u0000H\u0086\u0008¢\u0006\u0002\u0010/JA\u0010W\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0006\u0010X\u001a\u00020\u0017J:\u0010Y\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0008\u0010Z\u001a\u00020MH\u0016R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0008R\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000c\u0012\u0004\u0008\u000b\u0010\u0008R\u0012\u0010\r\u001a\u00020\u000e8Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00048Ç\u0002¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0013\u0082\u0001\u0001[\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\\", d2 = {"Landroidx/collection/ObjectList;", "E", "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", "content", "", "getContent$annotations", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "asList", "", "contains", "(Ljava/lang/Object;)Z", "containsAll", "elements", "([Ljava/lang/Object;)Z", "", "count", "elementAt", "index", "(I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "equals", "other", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "lastOrNull", "none", "reversedAny", "toString", "Landroidx/collection/MutableObjectList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ObjectList<E>  {

    public int _size;
    public Object[] content;
    private ObjectList(int initialCapacity) {
        Object[] arr;
        super();
        if (initialCapacity == 0) {
            arr = ObjectListKt.access$getEmptyArray$p();
        } else {
            arr = new Object[initialCapacity];
        }
        this.content = arr;
    }

    public ObjectList(int i, DefaultConstructorMarker defaultConstructorMarker2) {
        super(i);
    }

    public static void getContent$annotations() {
    }

    public static void get_size$annotations() {
    }

    public static String joinToString$default(androidx.collection.ObjectList objectList, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, Function1 function17, int i8, Object object9) {
        String obj2;
        String obj3;
        String obj4;
        int obj5;
        String obj6;
        int obj7;
        int obj9;
        if (object9 != null) {
        } else {
            if (i8 & 1 != 0) {
                obj2 = ", ";
            }
            final String str = "";
            if (i8 & 2 != 0) {
                obj3 = str;
            }
            if (i8 & 4 != 0) {
                obj4 = str;
            }
            if (i8 & 8 != 0) {
                obj5 = -1;
            }
            if (i8 & 16 != 0) {
                obj6 = "...";
            }
            obj9 = i8 &= 32 != 0 ? obj7 : function17;
            return objectList.joinToString(obj2, obj3, obj4, obj5, obj6, obj9);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean any(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj2 = this;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            i$iv++;
        }
        return 0;
    }

    public abstract List<E> asList();

    public final boolean contains(E element) {
        int i;
        i = indexOf(element) >= 0 ? 1 : 0;
        return i;
    }

    public final boolean containsAll(androidx.collection.ObjectList<E> elements) {
        int i$iv;
        Object obj;
        int i;
        boolean contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj2 = elements;
        final int i2 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            i$iv++;
        }
        return 1;
    }

    public final boolean containsAll(Iterable<? extends E> elements) {
        Object next;
        Object obj;
        int i;
        boolean contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i2 = 0;
        Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i = 0;
        }
        return 1;
    }

    public final boolean containsAll(List<? extends E> elements) {
        int i;
        boolean contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        i = 0;
        while (i < elements.size()) {
            i++;
        }
        return 1;
    }

    public final boolean containsAll(E[] elements) {
        int i;
        boolean contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        i = 0;
        while (i < elements.length) {
            i++;
        }
        return 1;
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1<? super E, Boolean> predicate) {
        int count;
        int i$iv;
        Object obj;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        count = 0;
        final Object obj2 = this;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            if ((Boolean)predicate.invoke(obj2.content[i$iv]).booleanValue()) {
            }
            i$iv++;
            count++;
        }
        return count;
    }

    public final E elementAt(int index) {
        int i;
        int _size;
        int i2 = 1;
        i = 0;
        if (index >= 0 && index < this._size) {
            if (index < this._size) {
                i = i2;
            }
        }
        if (i == 0) {
        } else {
            return this.content[index];
        }
        StringBuilder stringBuilder = new StringBuilder();
        final int i3 = 0;
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(_size2 -= i2).toString());
        throw indexOutOfBoundsException;
    }

    public final E elementAtOrElse(int index, Function1<? super Integer, ? extends E> defaultValue) {
        int i;
        int _size;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i2 = 0;
        i = 0;
        if (index >= 0 && index < this._size) {
            if (index < this._size) {
                i = 1;
            }
        }
        if (i == 0) {
            return defaultValue.invoke(Integer.valueOf(index));
        }
        return this.content[index];
    }

    public boolean equals(Object other) {
        boolean _size3;
        int _size;
        int i;
        int _size2;
        Object obj;
        int i2 = 0;
        if (other instanceof ObjectList != null) {
            if (obj2._size != this._size) {
            } else {
                int i4 = 0;
                IntRange this_$iv = RangesKt.until(i2, obj4._size);
                int last = this_$iv.getLast();
                if (this_$iv.getFirst() <= last) {
                }
            }
            return 1;
        }
        return i2;
    }

    public final E first() {
        if (isEmpty()) {
        } else {
            return this.content[0];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ObjectList is empty.");
        throw noSuchElementException;
    }

    public final E first(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj2 = this;
        int i3 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            obj = obj2.content[i$iv];
            i = 0;
            i$iv++;
        }
        NoSuchElementException this_$iv = new NoSuchElementException("ObjectList contains no element matching the predicate.");
        throw this_$iv;
    }

    public final E firstOrNull() {
        int i;
        final int i2 = 0;
        if (isEmpty()) {
            i = 0;
        } else {
            i = get(0);
        }
        return i;
    }

    public final E firstOrNull(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj2 = this;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            obj = obj2.content[i$iv];
            i = 0;
            i$iv++;
        }
        return 0;
    }

    public final <R> R fold(R initial, Function2<? super R, ? super E, ? extends R> operation) {
        Object acc;
        int i$iv;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        int i3 = 0;
        acc = initial;
        final Object obj2 = this;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            acc = operation.invoke(acc, obj2.content[i$iv]);
            i$iv++;
        }
        return acc;
    }

    public final <R> R foldIndexed(R initial, Function3<? super Integer, ? super R, ? super E, ? extends R> operation) {
        Object acc;
        int i$iv;
        Object obj;
        int i2;
        int i;
        Integer valueOf;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i3 = 0;
        int i4 = 0;
        acc = initial;
        final Object obj2 = this;
        final int i5 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            acc = operation.invoke(Integer.valueOf(i$iv), acc, obj2.content[i$iv]);
            i$iv++;
        }
        return acc;
    }

    public final <R> R foldRight(R initial, Function2<? super E, ? super R, ? extends R> operation) {
        Object acc;
        int i$iv;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        int i3 = 0;
        acc = initial;
        final Object obj2 = this;
        final int i4 = 0;
        _size--;
        while (-1 < i$iv) {
            i = 0;
            acc = operation.invoke(obj2.content[i$iv], acc);
            i$iv--;
        }
        return acc;
    }

    public final <R> R foldRightIndexed(R initial, Function3<? super Integer, ? super E, ? super R, ? extends R> operation) {
        Object acc;
        int i$iv;
        Object obj;
        int i;
        int i2;
        Integer valueOf;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i3 = 0;
        int i4 = 0;
        acc = initial;
        final Object obj2 = this;
        final int i5 = 0;
        _size--;
        while (-1 < i$iv) {
            i2 = 0;
            acc = operation.invoke(Integer.valueOf(i$iv), obj2.content[i$iv], acc);
            i$iv--;
        }
        return acc;
    }

    public final void forEach(Function1<? super E, Unit> block) {
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        i = 0;
        while (i < this._size) {
            block.invoke(this.content[i]);
            i++;
        }
    }

    public final void forEachIndexed(Function2<? super Integer, ? super E, Unit> block) {
        int i;
        Integer valueOf;
        Object obj;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        i = 0;
        while (i < this._size) {
            block.invoke(Integer.valueOf(i), this.content[i]);
            i++;
        }
    }

    public final void forEachReversed(Function1<? super E, Unit> block) {
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        _size--;
        while (-1 < i) {
            block.invoke(this.content[i]);
            i--;
        }
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super E, Unit> block) {
        int i;
        Integer valueOf;
        Object obj;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        _size--;
        while (-1 < i) {
            block.invoke(Integer.valueOf(i), this.content[i]);
            i--;
        }
    }

    public final E get(int index) {
        int i;
        int _size;
        int i2 = 1;
        i = 0;
        if (index >= 0 && index < this._size) {
            if (index < this._size) {
                i = i2;
            }
        }
        if (i == 0) {
        } else {
            return this.content[index];
        }
        StringBuilder stringBuilder = new StringBuilder();
        final int i3 = 0;
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(_size2 -= i2).toString());
        throw indexOutOfBoundsException;
    }

    public final IntRange getIndices() {
        final int i = 0;
        return RangesKt.until(0, this._size);
    }

    public final int getLastIndex() {
        final int i = 0;
        return _size--;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int hashCode;
        int i$iv;
        Object obj;
        int i;
        int i3;
        int i2;
        hashCode = 0;
        final Object obj2 = this;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            obj = obj2.content[i$iv];
            i = 0;
            if (obj != null) {
            } else {
            }
            i2 = 0;
            hashCode += i3;
            i$iv++;
            i2 = obj.hashCode();
        }
        return hashCode;
    }

    public final int indexOf(E element) {
        Object obj2;
        int i2;
        Object[] content;
        int i$iv;
        int _size;
        Object obj;
        int i3;
        int i;
        boolean equals;
        if (element == 0) {
            obj2 = this;
            i2 = 0;
            i$iv = 0;
            while (i$iv < obj2._size) {
                i = 0;
                i$iv++;
            }
        } else {
            obj2 = this;
            i2 = 0;
            i$iv = 0;
            while (i$iv < obj2._size) {
                i = 0;
                i$iv++;
            }
        }
        return -1;
    }

    public final int indexOfFirst(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i2;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        Object obj2 = this;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            i$iv++;
        }
        return -1;
    }

    public final int indexOfLast(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i;
        int i2;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        final Object obj2 = this;
        final int i4 = 0;
        _size--;
        int i5 = -1;
        while (i5 < i$iv) {
            i2 = 0;
            i$iv--;
            i5 = -1;
        }
        return i5;
    }

    public final boolean isEmpty() {
        int i;
        i = this._size == 0 ? 1 : 0;
        return i;
    }

    public final boolean isNotEmpty() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final String joinToString() {
        return ObjectList.joinToString$default(this, 0, 0, 0, 0, 0, 0, 63, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return ObjectList.joinToString$default(this, charSequence, 0, 0, 0, 0, 0, 62, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return ObjectList.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 0, 60, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ObjectList.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 0, 56, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ObjectList.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 0, 48, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4, java.lang.CharSequence charSequence5) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence5, "truncated");
        return ObjectList.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, charSequence5, 0, 32, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super E, ? extends java.lang.CharSequence> transform) {
        Object obj;
        Object obj2;
        int i;
        int i$iv;
        Object obj3;
        int i3;
        int i2;
        Object invoke;
        obj2 = prefix;
        final Object obj4 = postfix;
        final Object obj5 = truncated;
        final Object obj6 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj4, "postfix");
        Intrinsics.checkNotNullParameter(obj5, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i4 = 0;
        sb.append(obj2);
        final Object obj7 = this;
        final int i5 = 0;
        i$iv = 0;
        while (i$iv < obj7._size) {
            obj3 = obj7.content[i$iv];
            i3 = i$iv;
            i2 = 0;
            if (i3 != 0) {
            }
            if (obj6 == null) {
            } else {
            }
            sb.append((CharSequence)obj6.invoke(obj3));
            i$iv++;
            obj = separator;
            obj2 = prefix;
            sb.append(obj3);
            sb.append(obj);
        }
        i = limit;
        sb.append(obj4);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final E last() {
        if (isEmpty()) {
        } else {
            final int i = 0;
            return this.content[_size--];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ObjectList is empty.");
        throw noSuchElementException;
    }

    public final E last(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj2 = this;
        int i3 = 0;
        _size--;
        while (-1 < i$iv) {
            obj = obj2.content[i$iv];
            i = 0;
            i$iv--;
        }
        NoSuchElementException this_$iv = new NoSuchElementException("ObjectList contains no element matching the predicate.");
        throw this_$iv;
    }

    public final int lastIndexOf(E element) {
        Object obj;
        int i2;
        Object[] content;
        int i$iv;
        Object obj2;
        int i;
        int i3;
        boolean equals;
        final int i4 = -1;
        if (element == 0) {
            obj = this;
            i2 = 0;
            _size2--;
            while (i4 < i$iv) {
                i3 = 0;
                i$iv--;
            }
        } else {
            obj = this;
            i2 = 0;
            _size--;
            while (i4 < i$iv) {
                i3 = 0;
                i$iv--;
            }
        }
        return i4;
    }

    public final E lastOrNull() {
        int i;
        Object obj;
        int i2;
        int i3;
        final int i4 = 0;
        if (isEmpty()) {
            i = 0;
        } else {
            i2 = 0;
            i = this.content[_size--];
        }
        return i;
    }

    public final E lastOrNull(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj2 = this;
        final int i3 = 0;
        _size--;
        while (-1 < i$iv) {
            obj = obj2.content[i$iv];
            i = 0;
            i$iv--;
        }
        return 0;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(Function1<? super E, Boolean> predicate) {
        int i$iv;
        Object obj;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj2 = this;
        final int i3 = 0;
        final int i4 = 1;
        _size -= i4;
        while (-1 < i$iv) {
            i = 0;
            i$iv--;
        }
        return 0;
    }

    public String toString() {
        ObjectList.toString.1 anon = new ObjectList.toString.1(this);
        return ObjectList.joinToString$default(this, 0, (CharSequence)"[", (CharSequence)"]", 0, 0, (Function1)anon, 25, 0);
    }
}
