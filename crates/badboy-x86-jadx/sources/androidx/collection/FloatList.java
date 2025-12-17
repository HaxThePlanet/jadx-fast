package androidx.collection;

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
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001B\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J:\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0018H\u0086\u0002J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0000J\u0006\u0010\u001f\u001a\u00020\u0003J:\u0010\u001f\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0010\u0010 \u001a\u00020\u00182\u0008\u0008\u0001\u0010!\u001a\u00020\u0003J9\u0010\"\u001a\u00020\u00182\u0008\u0008\u0001\u0010!\u001a\u00020\u00032!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020\u00180\u0017H\u0086\u0008ø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00152\u0008\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010&\u001a\u00020\u0018J:\u0010&\u001a\u00020\u00182!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001Jb\u0010'\u001a\u0002H(\"\u0004\u0008\u0000\u0010(2\u0006\u0010)\u001a\u0002H(26\u0010*\u001a2\u0012\u0013\u0012\u0011H(¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(,\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002H(0+H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-Jw\u0010.\u001a\u0002H(\"\u0004\u0008\u0000\u0010(2\u0006\u0010)\u001a\u0002H(2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u0011H(¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(,\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002H(0/H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100Jb\u00101\u001a\u0002H(\"\u0004\u0008\u0000\u0010(2\u0006\u0010)\u001a\u0002H(26\u0010*\u001a2\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0013\u0012\u0011H(¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u0002H(0+H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-Jw\u00102\u001a\u0002H(\"\u0004\u0008\u0000\u0010(2\u0006\u0010)\u001a\u0002H(2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0013\u0012\u0011H(¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u0002H(0/H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100J:\u00103\u001a\u0002042!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002040\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001JO\u00106\u001a\u00020426\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002040+H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J:\u00107\u001a\u0002042!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002040\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001JO\u00108\u001a\u00020426\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002040+H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0013\u00109\u001a\u00020\u00182\u0008\u0008\u0001\u0010!\u001a\u00020\u0003H\u0086\u0002J\u0008\u0010:\u001a\u00020\u0003H\u0016J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018J:\u0010<\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J:\u0010=\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0006\u0010>\u001a\u00020\u0015J\u0006\u0010?\u001a\u00020\u0015J:\u0010@\u001a\u00020A2\u0008\u0008\u0002\u0010B\u001a\u00020C2\u0008\u0008\u0002\u0010D\u001a\u00020C2\u0008\u0008\u0002\u0010E\u001a\u00020C2\u0008\u0008\u0002\u0010F\u001a\u00020\u00032\u0008\u0008\u0002\u0010G\u001a\u00020CH\u0007JT\u0010@\u001a\u00020A2\u0008\u0008\u0002\u0010B\u001a\u00020C2\u0008\u0008\u0002\u0010D\u001a\u00020C2\u0008\u0008\u0002\u0010E\u001a\u00020C2\u0008\u0008\u0002\u0010F\u001a\u00020\u00032\u0008\u0008\u0002\u0010G\u001a\u00020C2\u0014\u0008\u0004\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020C0\u0017H\u0087\u0008ø\u0001\u0000J\u0006\u0010I\u001a\u00020\u0018J:\u0010I\u001a\u00020\u00182!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u000e\u0010J\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010K\u001a\u00020\u0015J:\u0010L\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0008\u0010M\u001a\u00020AH\u0016R\u0018\u0010\u0005\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R\u0018\u0010\u0008\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\n\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\u000c8Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0011\u0082\u0001\u0001N\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006O", d2 = {"Landroidx/collection/FloatList;", "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", "content", "", "getContent$annotations", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "element", "contains", "containsAll", "elements", "count", "elementAt", "index", "elementAtOrElse", "defaultValue", "equals", "other", "first", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "none", "reversedAny", "toString", "Landroidx/collection/MutableFloatList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FloatList {

    public int _size;
    public float[] content;
    private FloatList(int initialCapacity) {
        float[] emptyFloatArray;
        super();
        if (initialCapacity == 0) {
            emptyFloatArray = FloatSetKt.getEmptyFloatArray();
        } else {
            emptyFloatArray = new float[initialCapacity];
        }
        this.content = emptyFloatArray;
    }

    public FloatList(int i, DefaultConstructorMarker defaultConstructorMarker2) {
        super(i);
    }

    public static void getContent$annotations() {
    }

    public static void get_size$annotations() {
    }

    public static String joinToString$default(androidx.collection.FloatList floatList, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, int i7, Object object8) {
        String obj2;
        String obj3;
        String obj4;
        int obj5;
        String obj6;
        String obj8;
        if (object8 != null) {
        } else {
            if (i7 & 1 != 0) {
                obj2 = ", ";
            }
            final String str = "";
            if (i7 & 2 != 0) {
                obj3 = str;
            }
            if (i7 & 4 != 0) {
                obj4 = str;
            }
            if (i7 & 8 != 0) {
                obj5 = -1;
            }
            if (i7 &= 16 != 0) {
                obj8 = obj6;
            } else {
                obj8 = charSequence6;
            }
            return floatList.joinToString(obj2, obj3, obj4, obj5, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public static String joinToString$default(androidx.collection.FloatList $this, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1 transform, int i8, Object object9) {
        String separator2;
        String prefix2;
        String postfix2;
        int limit2;
        String truncated2;
        int i$iv;
        float f;
        int index;
        String obj18;
        String obj19;
        final Object obj = transform;
        if (object9 != null) {
        } else {
            if (i8 & 1 != 0) {
                separator2 = ", ";
            } else {
                separator2 = separator;
            }
            if (i8 & 2 != 0) {
                prefix2 = postfix2;
            } else {
                prefix2 = prefix;
            }
            if (i8 & 4 != 0) {
            } else {
                postfix2 = postfix;
            }
            limit2 = i8 & 8 != 0 ? -1 : limit;
            if (i8 & 16 != 0) {
                truncated2 = "...";
            } else {
                truncated2 = truncated;
            }
            Intrinsics.checkNotNullParameter(separator2, "separator");
            Intrinsics.checkNotNullParameter(prefix2, "prefix");
            Intrinsics.checkNotNullParameter(postfix2, "postfix");
            Intrinsics.checkNotNullParameter(truncated2, "truncated");
            Intrinsics.checkNotNullParameter(obj, "transform");
            int i6 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            final StringBuilder sb = stringBuilder;
            final int i7 = 0;
            sb.append(prefix2);
            final Object obj2 = $this;
            final int i9 = 0;
            i$iv = 0;
            while (i$iv < obj2._size) {
                index = 0;
                prefix2 = obj18;
                if (prefix2 != 0) {
                }
                sb.append((CharSequence)obj.invoke(Float.valueOf(obj2.content[i$iv])));
                i$iv++;
                separator2 = obj18;
                prefix2 = obj19;
                sb.append(separator2);
            }
            obj18 = separator2;
            obj19 = prefix2;
            sb.append(postfix2);
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw unsupportedOperationException;
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean any(Function1<? super Float, Boolean> predicate) {
        int i$iv;
        float f;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj = this;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            i$iv++;
        }
        return 0;
    }

    public final boolean contains(float element) {
        int i$iv;
        int i;
        float f;
        int i2;
        int cmp;
        int i3;
        final Object obj = this;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i2 = 0;
            i3 = 1;
            if (Float.compare(f, element) == 0) {
            }
            i$iv++;
            i = i3;
        }
        return 0;
    }

    public final boolean containsAll(androidx.collection.FloatList elements) {
        int i;
        int contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = 0;
        final int i4 = 0;
        IntRange this_$iv = RangesKt.until(i4, obj._size);
        int last = this_$iv.getLast();
        if (this_$iv.getFirst() <= last) {
        }
        return 1;
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1<? super Float, Boolean> predicate) {
        int count;
        int i$iv;
        float f;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        count = 0;
        final Object obj = this;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            if ((Boolean)predicate.invoke(Float.valueOf(obj.content[i$iv])).booleanValue()) {
            }
            i$iv++;
            count++;
        }
        return count;
    }

    public final float elementAt(int index) {
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

    public final float elementAtOrElse(int index, Function1<? super Integer, Float> defaultValue) {
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
            return (Number)defaultValue.invoke(Integer.valueOf(index)).floatValue();
        }
        return this.content[index];
    }

    public boolean equals(Object other) {
        boolean _size;
        int _size2;
        int i2;
        int i;
        float f;
        final int i3 = 0;
        if (other instanceof FloatList != null) {
            if (obj._size != this._size) {
            } else {
                int i4 = 0;
                IntRange this_$iv = RangesKt.until(i3, obj3._size);
                int last = this_$iv.getLast();
                int i5 = 1;
                if (this_$iv.getFirst() <= last) {
                }
            }
            return i5;
        }
        return i3;
    }

    public final float first() {
        if (isEmpty()) {
        } else {
            return this.content[0];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("FloatList is empty.");
        throw noSuchElementException;
    }

    public final float first(Function1<? super Float, Boolean> predicate) {
        int i$iv;
        float f;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj = this;
        int i3 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            f = obj.content[i$iv];
            i = 0;
            i$iv++;
        }
        NoSuchElementException this_$iv = new NoSuchElementException("FloatList contains no element matching the predicate.");
        throw this_$iv;
    }

    public final <R> R fold(R initial, Function2<? super R, ? super Float, ? extends R> operation) {
        Object acc;
        int i$iv;
        float f;
        int i;
        Float valueOf;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        int i3 = 0;
        acc = initial;
        final Object obj = this;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            acc = operation.invoke(acc, Float.valueOf(obj.content[i$iv]));
            i$iv++;
        }
        return acc;
    }

    public final <R> R foldIndexed(R initial, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        Object acc;
        int i$iv;
        float f;
        int i2;
        int i;
        Integer valueOf2;
        Float valueOf;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i3 = 0;
        int i4 = 0;
        acc = initial;
        final Object obj = this;
        final int i5 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            acc = operation.invoke(Integer.valueOf(i$iv), acc, Float.valueOf(obj.content[i$iv]));
            i$iv++;
        }
        return acc;
    }

    public final <R> R foldRight(R initial, Function2<? super Float, ? super R, ? extends R> operation) {
        Object acc;
        int i$iv;
        float f;
        int i;
        Float valueOf;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        int i3 = 0;
        acc = initial;
        final Object obj = this;
        final int i4 = 0;
        _size--;
        while (-1 < i$iv) {
            i = 0;
            acc = operation.invoke(Float.valueOf(obj.content[i$iv]), acc);
            i$iv--;
        }
        return acc;
    }

    public final <R> R foldRightIndexed(R initial, Function3<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        Object acc;
        int i$iv;
        float f;
        int i;
        int i2;
        Integer valueOf;
        Float valueOf2;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i3 = 0;
        int i4 = 0;
        acc = initial;
        final Object obj = this;
        final int i5 = 0;
        _size--;
        while (-1 < i$iv) {
            i2 = 0;
            acc = operation.invoke(Integer.valueOf(i$iv), Float.valueOf(obj.content[i$iv]), acc);
            i$iv--;
        }
        return acc;
    }

    public final void forEach(Function1<? super Float, Unit> block) {
        int i;
        Float valueOf;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        i = 0;
        while (i < this._size) {
            block.invoke(Float.valueOf(this.content[i]));
            i++;
        }
    }

    public final void forEachIndexed(Function2<? super Integer, ? super Float, Unit> block) {
        int i;
        Integer valueOf2;
        Float valueOf;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        i = 0;
        while (i < this._size) {
            block.invoke(Integer.valueOf(i), Float.valueOf(this.content[i]));
            i++;
        }
    }

    public final void forEachReversed(Function1<? super Float, Unit> block) {
        int i;
        Float valueOf;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        _size--;
        while (-1 < i) {
            block.invoke(Float.valueOf(this.content[i]));
            i--;
        }
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super Float, Unit> block) {
        int i;
        Integer valueOf;
        Float valueOf2;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        _size--;
        while (-1 < i) {
            block.invoke(Integer.valueOf(i), Float.valueOf(this.content[i]));
            i--;
        }
    }

    public final float get(int index) {
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
        float f;
        int i;
        int i2;
        hashCode = 0;
        final Object obj = this;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            hashCode += i2;
            i$iv++;
        }
        return hashCode;
    }

    public final int indexOf(float element) {
        int i$iv;
        float f;
        int i2;
        int i3;
        int i;
        Object obj = this;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i3 = 0;
            if (Float.compare(element, f) == 0) {
            } else {
            }
            i = 0;
            i$iv++;
            i = 1;
        }
        return -1;
    }

    public final int indexOfFirst(Function1<? super Float, Boolean> predicate) {
        int i$iv;
        float f;
        int i;
        int i2;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        Object obj = this;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i2 = 0;
            i$iv++;
        }
        return -1;
    }

    public final int indexOfLast(Function1<? super Float, Boolean> predicate) {
        int i$iv;
        float f;
        int i2;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        final Object obj = this;
        final int i4 = 0;
        _size--;
        int i5 = -1;
        while (i5 < i$iv) {
            i = 0;
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
        return FloatList.joinToString$default(this, 0, 0, 0, 0, 0, 31, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return FloatList.joinToString$default(this, charSequence, 0, 0, 0, 0, 30, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return FloatList.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 28, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return FloatList.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 24, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return FloatList.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 16, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated) {
        int i$iv;
        float f;
        int i3;
        int i;
        int i2;
        final Object obj = separator;
        final Object obj2 = prefix;
        final Object obj3 = postfix;
        final Object obj4 = truncated;
        Intrinsics.checkNotNullParameter(obj, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i4 = 0;
        sb.append(obj2);
        final Object obj5 = this;
        final int i5 = 0;
        i$iv = 0;
        while (i$iv < obj5._size) {
            i3 = i$iv;
            i = 0;
            if (i3 != 0) {
            }
            sb.append(obj5.content[i$iv]);
            i$iv++;
            sb.append(obj);
        }
        i2 = limit;
        sb.append(obj3);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super Float, ? extends java.lang.CharSequence> transform) {
        Object obj2;
        Object obj;
        int i3;
        int i$iv;
        float f;
        int i;
        int i2;
        obj = prefix;
        final Object obj3 = postfix;
        final Object obj4 = truncated;
        final Object obj5 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "truncated");
        Intrinsics.checkNotNullParameter(obj5, "transform");
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i5 = 0;
        sb.append(obj);
        final Object obj6 = this;
        final int i6 = 0;
        i$iv = 0;
        while (i$iv < obj6._size) {
            i = i$iv;
            i2 = 0;
            if (i != 0) {
            }
            sb.append((CharSequence)obj5.invoke(Float.valueOf(obj6.content[i$iv])));
            i$iv++;
            obj2 = separator;
            obj = prefix;
            sb.append(obj2);
        }
        i3 = limit;
        sb.append(obj3);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, Function1<? super Float, ? extends java.lang.CharSequence> transform) {
        Object obj2;
        Object obj;
        int i;
        int $i$f$joinToString;
        int i$iv$iv;
        float f;
        int index$iv;
        int index$iv2;
        obj = prefix;
        final Object obj3 = postfix;
        final Object obj4 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "transform");
        $i$f$joinToString = 0;
        final int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i4 = 0;
        sb.append(obj);
        final Object obj5 = this;
        final int i5 = 0;
        i$iv$iv = 0;
        while (i$iv$iv < obj5._size) {
            index$iv = 0;
            $i$f$joinToString = i2;
            if ($i$f$joinToString != null) {
            }
            sb.append((CharSequence)obj4.invoke(Float.valueOf(obj5.content[i$iv$iv])));
            i$iv$iv++;
            obj2 = separator;
            obj = prefix;
            $i$f$joinToString = index$iv2;
            sb.append(obj2);
        }
        i = limit;
        index$iv2 = $i$f$joinToString;
        sb.append(obj3);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, Function1<? super Float, ? extends java.lang.CharSequence> transform) {
        Object obj;
        Object obj2;
        int i$iv$iv;
        float f;
        int index$iv;
        int i;
        obj2 = prefix;
        final Object obj3 = postfix;
        final Object obj4 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "transform");
        int i2 = 0;
        final int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i5 = 0;
        sb.append(obj2);
        final Object obj5 = this;
        final int i6 = 0;
        i$iv$iv = 0;
        while (i$iv$iv < obj5._size) {
            index$iv = 0;
            obj2 = i;
            if (obj2 != null) {
            }
            sb.append((CharSequence)obj4.invoke(Float.valueOf(obj5.content[i$iv$iv])));
            i$iv$iv++;
            obj = separator;
            obj2 = prefix;
            sb.append(obj);
        }
        sb.append(obj3);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, Function1<? super Float, ? extends java.lang.CharSequence> transform) {
        Object obj;
        Object obj2;
        int i$iv$iv;
        float f;
        int index$iv;
        int i;
        obj2 = prefix;
        final Object obj3 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "transform");
        int i2 = 0;
        final int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i5 = 0;
        sb.append(obj2);
        final Object obj4 = this;
        final int i6 = 0;
        i$iv$iv = 0;
        while (i$iv$iv < obj4._size) {
            index$iv = 0;
            obj2 = i;
            if (obj2 != null) {
            }
            sb.append((CharSequence)obj3.invoke(Float.valueOf(obj4.content[i$iv$iv])));
            i$iv$iv++;
            obj = separator;
            obj2 = prefix;
            sb.append(obj);
        }
        sb.append((CharSequence)"");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, Function1<? super Float, ? extends java.lang.CharSequence> transform) {
        Object obj;
        int $i$f$joinToString2;
        int i$iv$iv;
        float f;
        int index$iv;
        int i;
        int $i$f$joinToString;
        final Object obj2 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj2, "transform");
        $i$f$joinToString2 = 0;
        final String str4 = "";
        final int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i4 = 0;
        sb.append((CharSequence)str4);
        final Object obj3 = this;
        final int i5 = 0;
        i$iv$iv = 0;
        while (i$iv$iv < obj3._size) {
            index$iv = 0;
            $i$f$joinToString2 = i;
            if ($i$f$joinToString2 != 0) {
            }
            sb.append((CharSequence)obj2.invoke(Float.valueOf(obj3.content[i$iv$iv])));
            i$iv$iv++;
            obj = separator;
            $i$f$joinToString2 = $i$f$joinToString;
            sb.append(obj);
        }
        $i$f$joinToString = $i$f$joinToString2;
        sb.append((CharSequence)str4);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(Function1<? super Float, ? extends java.lang.CharSequence> transform) {
        int $i$f$joinToString;
        int i$iv$iv;
        float f;
        int index$iv;
        int i;
        int $i$f$joinToString2;
        final Object obj = transform;
        Intrinsics.checkNotNullParameter(obj, "transform");
        $i$f$joinToString = 0;
        final String str3 = "";
        final int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i4 = 0;
        sb.append((CharSequence)str3);
        final Object obj2 = this;
        final int i5 = 0;
        i$iv$iv = 0;
        while (i$iv$iv < obj2._size) {
            index$iv = 0;
            $i$f$joinToString = i;
            if ($i$f$joinToString != null) {
            }
            i = $i$f$joinToString;
            sb.append((CharSequence)obj.invoke(Float.valueOf(obj2.content[i$iv$iv])));
            i$iv$iv++;
            $i$f$joinToString = $i$f$joinToString2;
            sb.append((CharSequence)", ");
        }
        $i$f$joinToString2 = $i$f$joinToString;
        sb.append((CharSequence)str3);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final float last() {
        if (isEmpty()) {
        } else {
            final int i = 0;
            return this.content[_size--];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("FloatList is empty.");
        throw noSuchElementException;
    }

    public final float last(Function1<? super Float, Boolean> predicate) {
        int i$iv;
        float f;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj = this;
        int i3 = 0;
        _size--;
        while (-1 < i$iv) {
            f = obj.content[i$iv];
            i = 0;
            i$iv--;
        }
        NoSuchElementException this_$iv = new NoSuchElementException("FloatList contains no element matching the predicate.");
        throw this_$iv;
    }

    public final int lastIndexOf(float element) {
        int i$iv;
        float f;
        int i;
        int i3;
        int i2;
        final Object obj = this;
        final int i4 = 0;
        final int i5 = 1;
        _size -= i5;
        int i6 = -1;
        while (i6 < i$iv) {
            i3 = 0;
            if (Float.compare(f, element) == 0) {
            } else {
            }
            i2 = 0;
            i$iv--;
            i6 = -1;
            i2 = i5;
        }
        return i6;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(Function1<? super Float, Boolean> predicate) {
        int i$iv;
        float f;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj = this;
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
        return FloatList.joinToString$default(this, 0, (CharSequence)"[", (CharSequence)"]", 0, 0, 25, 0);
    }
}
