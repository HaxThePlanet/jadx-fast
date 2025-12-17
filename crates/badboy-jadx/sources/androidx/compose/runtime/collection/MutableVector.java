package androidx.compose.runtime.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0003stuB\u001f\u0008\u0001\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001b\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\u0008J\u0019\u0010\"\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010$J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000%J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010\"\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000%J\u0017\u0010\"\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000&H\u0086\u0008J(\u0010'\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018J\u0006\u0010+\u001a\u00020\u001fJ\u0016\u0010,\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\u0014\u0010-\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010-\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010-\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010.\u001a\u00020\u001c2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0007J\u000b\u00102\u001a\u00028\u0000¢\u0006\u0002\u00103J-\u00102\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0010\u00105\u001a\u0004\u0018\u00018\u0000H\u0086\u0008¢\u0006\u0002\u00103J/\u00105\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104JP\u00106\u001a\u0002H7\"\u0004\u0008\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0013\u0012\u0011H7¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Je\u0010?\u001a\u0002H7\"\u0004\u0008\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008( \u0012\u0013\u0012\u0011H7¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70@H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJP\u0010B\u001a\u0002H7\"\u0004\u0008\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008(=\u0012\u0004\u0012\u0002H70:H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Je\u0010C\u001a\u0002H7\"\u0004\u0008\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008(=\u0012\u0004\u0012\u0002H70@H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJ(\u0010D\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J.\u0010F\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J(\u0010G\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J.\u0010H\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0016\u0010I\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007H\u0086\n¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ(\u0010M\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J(\u0010N\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0006\u0010O\u001a\u00020\u001cJ\u0006\u0010P\u001a\u00020\u001cJ\u000b\u0010Q\u001a\u00028\u0000¢\u0006\u0002\u00103J-\u0010Q\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0013\u0010R\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ\u0010\u0010S\u001a\u0004\u0018\u00018\u0000H\u0086\u0008¢\u0006\u0002\u00103J/\u0010S\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J;\u0010T\u001a\u0008\u0012\u0004\u0012\u0002H70\u0005\"\u0006\u0008\u0001\u00107\u0018\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010VJP\u0010W\u001a\u0008\u0012\u0004\u0012\u0002H70\u0005\"\u0006\u0008\u0001\u00107\u0018\u00012'\u0010U\u001a#\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010XJM\u0010Y\u001a\u0008\u0012\u0004\u0012\u0002H70\u0000\"\u0006\u0008\u0001\u00107\u0018\u00012)\u0010U\u001a%\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008;\u0012\u0008\u0008<\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70:H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J8\u0010Z\u001a\u0008\u0012\u0004\u0012\u0002H70\u0000\"\u0006\u0008\u0001\u00107\u0018\u00012\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0016\u0010[\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\\J\u0013\u0010^\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010_\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010_\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010_\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000&J\u0013\u0010`\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0002\u0010JJ\u001d\u0010a\u001a\u00020\u001f2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008J\u0016\u0010b\u001a\u00020\u001f2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007J\u0014\u0010e\u001a\u00020\u001c2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000%J(\u0010f\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u001e\u0010g\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010hJ\u0010\u0010i\u001a\u00020\u001f2\u0006\u0010j\u001a\u00020\u0007H\u0001J\u001e\u0010k\u001a\u00020\u001f2\u0016\u0010l\u001a\u0012\u0012\u0004\u0012\u00028\u00000mj\u0008\u0012\u0004\u0012\u00028\u0000`nJ(\u0010o\u001a\u00020\u00072\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070)H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0008\u0010q\u001a\u00020rH\u0001R.\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0012\u0010\u0010\u001a\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0016¨\u0006v", d2 = {"Landroidx/compose/runtime/collection/MutableVector;", "T", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "content", "", "size", "", "([Ljava/lang/Object;I)V", "getContent$annotations", "()V", "getContent", "()[Ljava/lang/Object;", "setContent", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "list", "", "<set-?>", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "([Ljava/lang/Object;)Z", "", "", "any", "predicate", "Lkotlin/Function1;", "asMutableList", "clear", "contains", "containsAll", "contentEquals", "other", "ensureCapacity", "capacity", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "map", "transform", "(Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "mapIndexedNotNull", "mapNotNull", "minusAssign", "(Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "removeIf", "removeRange", "start", "end", "retainAll", "reversedAny", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setSize", "newSize", "sortWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sumBy", "selector", "throwNoSuchElementException", "", "MutableVectorList", "SubList", "VectorListIterator", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableVector<T>  implements RandomAccess {

    public static final int $stable = 8;
    private T[] content;
    private List<T> list;
    private int size;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\t\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0008\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001dH\u0096\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*", d2 = {"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", "T", "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MutableVectorList implements List<T>, KMutableList {

        private final androidx.compose.runtime.collection.MutableVector<T> vector;
        public MutableVectorList(androidx.compose.runtime.collection.MutableVector<T> vector) {
            super();
            this.vector = vector;
        }

        public void add(int index, T element) {
            this.vector.add(index, element);
        }

        public boolean add(T element) {
            return this.vector.add(element);
        }

        public boolean addAll(int index, Collection<? extends T> elements) {
            return this.vector.addAll(index, elements);
        }

        public boolean addAll(Collection<? extends T> elements) {
            return this.vector.addAll(elements);
        }

        @Override // java.util.List
        public void clear() {
            this.vector.clear();
        }

        @Override // java.util.List
        public boolean contains(Object element) {
            return this.vector.contains(element);
        }

        public boolean containsAll(Collection<? extends Object> elements) {
            return this.vector.containsAll(elements);
        }

        public T get(int index) {
            MutableVectorKt.access$checkIndex((List)this, index);
            final int i = 0;
            return this.vector.getContent()[index];
        }

        @Override // java.util.List
        public int getSize() {
            return this.vector.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            return this.vector.indexOf(element);
        }

        @Override // java.util.List
        public boolean isEmpty() {
            return this.vector.isEmpty();
        }

        public Iterator<T> iterator() {
            MutableVector.VectorListIterator vectorListIterator = new MutableVector.VectorListIterator((List)this, 0);
            return (Iterator)vectorListIterator;
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            return this.vector.lastIndexOf(element);
        }

        public ListIterator<T> listIterator() {
            MutableVector.VectorListIterator vectorListIterator = new MutableVector.VectorListIterator((List)this, 0);
            return (ListIterator)vectorListIterator;
        }

        public ListIterator<T> listIterator(int index) {
            MutableVector.VectorListIterator vectorListIterator = new MutableVector.VectorListIterator((List)this, index);
            return (ListIterator)vectorListIterator;
        }

        public final T remove(int index) {
            return removeAt(index);
        }

        @Override // java.util.List
        public boolean remove(Object element) {
            return this.vector.remove(element);
        }

        public boolean removeAll(Collection<? extends Object> elements) {
            return this.vector.removeAll(elements);
        }

        public T removeAt(int index) {
            MutableVectorKt.access$checkIndex((List)this, index);
            return this.vector.removeAt(index);
        }

        public boolean retainAll(Collection<? extends Object> elements) {
            return this.vector.retainAll(elements);
        }

        public T set(int index, T element) {
            MutableVectorKt.access$checkIndex((List)this, index);
            return this.vector.set(index, element);
        }

        @Override // java.util.List
        public final int size() {
            return getSize();
        }

        public List<T> subList(int fromIndex, int toIndex) {
            MutableVectorKt.access$checkSubIndex((List)this, fromIndex, toIndex);
            MutableVector.SubList subList = new MutableVector.SubList((List)this, fromIndex, toIndex);
            return (List)subList;
        }

        @Override // java.util.List
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection)this);
        }

        public <T> T[] toArray(T[] tArr) {
            return CollectionToArray.toArray((Collection)this, tArr);
        }
    }

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\t\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00052\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u0008\u0010\u001c\u001a\u00020\u000cH\u0016J\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001eH\u0096\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+", d2 = {"Landroidx/compose/runtime/collection/MutableVector$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SubList implements List<T>, KMutableList {

        private int end;
        private final List<T> list;
        private final int start;
        public SubList(List<T> list, int start, int end) {
            super();
            this.list = list;
            this.start = start;
            this.end = end;
        }

        public void add(int index, T element) {
            this.list.add(start += index, element);
            this.end = end++;
        }

        public boolean add(T element) {
            final int end = this.end;
            this.end = end + 1;
            this.list.add(end, element);
            return 1;
        }

        public boolean addAll(int index, Collection<? extends T> elements) {
            int i;
            this.list.addAll(start += index, elements);
            this.end = end += size2;
            i = elements.size() > 0 ? 1 : 0;
            return i;
        }

        public boolean addAll(Collection<? extends T> elements) {
            int i;
            this.list.addAll(this.end, elements);
            this.end = end += size2;
            i = elements.size() > 0 ? 1 : 0;
            return i;
        }

        @Override // java.util.List
        public void clear() {
            int i;
            List list;
            final int start = this.start;
            if (start <= end--) {
            }
            this.end = this.start;
        }

        @Override // java.util.List
        public boolean contains(Object element) {
            int i;
            boolean equal;
            i = this.start;
            while (i < this.end) {
                i++;
            }
            return 0;
        }

        public boolean containsAll(Collection<? extends Object> elements) {
            Object next;
            Object obj;
            int i;
            boolean contains;
            final int i2 = 0;
            Iterator iterator = (Iterable)elements.iterator();
            for (Object next : iterator) {
                i = 0;
            }
            return 1;
        }

        public T get(int index) {
            MutableVectorKt.access$checkIndex((List)this, index);
            return this.list.get(start += index);
        }

        @Override // java.util.List
        public int getSize() {
            return end -= start;
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            int i;
            boolean equal;
            i = this.start;
            while (i < this.end) {
                i++;
            }
            return -1;
        }

        @Override // java.util.List
        public boolean isEmpty() {
            int i;
            i = this.end == this.start ? 1 : 0;
            return i;
        }

        public Iterator<T> iterator() {
            MutableVector.VectorListIterator vectorListIterator = new MutableVector.VectorListIterator((List)this, 0);
            return (Iterator)vectorListIterator;
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            int i;
            boolean equal;
            int start = this.start;
            if (start <= end--) {
            }
            return -1;
        }

        public ListIterator<T> listIterator() {
            MutableVector.VectorListIterator vectorListIterator = new MutableVector.VectorListIterator((List)this, 0);
            return (ListIterator)vectorListIterator;
        }

        public ListIterator<T> listIterator(int index) {
            MutableVector.VectorListIterator vectorListIterator = new MutableVector.VectorListIterator((List)this, index);
            return (ListIterator)vectorListIterator;
        }

        public final T remove(int index) {
            return removeAt(index);
        }

        @Override // java.util.List
        public boolean remove(Object element) {
            int i;
            boolean equal;
            i = this.start;
            while (i < this.end) {
                i++;
            }
            return 0;
        }

        public boolean removeAll(Collection<? extends Object> elements) {
            int i;
            Object next;
            Object obj;
            int i2;
            final int i3 = 0;
            final Iterator iterator = (Iterable)elements.iterator();
            for (Object next : iterator) {
                i2 = 0;
                remove(next);
            }
            i = this.end != this.end ? 1 : 0;
            return i;
        }

        public T removeAt(int index) {
            MutableVectorKt.access$checkIndex((List)this, index);
            this.end = end--;
            return this.list.remove(start += index);
        }

        public boolean retainAll(Collection<? extends Object> elements) {
            int i;
            int i2;
            Object obj;
            boolean contains;
            final int start = this.start;
            if (start <= end2 -= i2) {
            }
            if (this.end != this.end) {
            } else {
                i2 = 0;
            }
            return i2;
        }

        public T set(int index, T element) {
            MutableVectorKt.access$checkIndex((List)this, index);
            return this.list.set(start += index, element);
        }

        @Override // java.util.List
        public final int size() {
            return getSize();
        }

        public List<T> subList(int fromIndex, int toIndex) {
            MutableVectorKt.access$checkSubIndex((List)this, fromIndex, toIndex);
            MutableVector.SubList subList = new MutableVector.SubList((List)this, fromIndex, toIndex);
            return (List)subList;
        }

        @Override // java.util.List
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection)this);
        }

        public <T> T[] toArray(T[] tArr) {
            return CollectionToArray.toArray((Collection)this, tArr);
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bJ\t\u0010\u000c\u001a\u00020\rH\u0096\u0002J\u0008\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0013\u001a\u00020\u0006H\u0016J\u0008\u0010\u0014\u001a\u00020\tH\u0016J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class VectorListIterator implements ListIterator<T>, KMutableListIterator {

        private int index;
        private final List<T> list;
        public VectorListIterator(List<T> list, int index) {
            super();
            this.list = list;
            this.index = index;
        }

        public void add(T element) {
            this.list.add(this.index, element);
            this.index = index++;
        }

        @Override // java.util.ListIterator
        public boolean hasNext() {
            int i;
            i = this.index < this.list.size() ? 1 : 0;
            return i;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            int i;
            i = this.index > 0 ? 1 : 0;
            return i;
        }

        public T next() {
            final int index = this.index;
            this.index = index + 1;
            return this.list.get(index);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        public T previous() {
            this.index = index--;
            return this.list.get(this.index);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return index--;
        }

        @Override // java.util.ListIterator
        public void remove() {
            this.index = index--;
            this.list.remove(this.index);
        }

        public void set(T element) {
            this.list.set(this.index, element);
        }
    }
    static {
        final int i = 8;
    }

    public MutableVector(T[] content, int size) {
        super();
        this.content = content;
        this.size = size;
    }

    public static void getContent$annotations() {
    }

    public final void add(int index, T element) {
        int size2;
        int size;
        ensureCapacity(size3++);
        Object[] content = this.content;
        if (index != this.size) {
            ArraysKt.copyInto(content, content, index + 1, index, this.size);
        }
        content[index] = element;
        this.size = size4++;
    }

    public final boolean add(T element) {
        final int i3 = 1;
        ensureCapacity(size += i3);
        this.content[this.size] = element;
        this.size = size2 += i3;
        return i3;
    }

    public final boolean addAll(int index, androidx.compose.runtime.collection.MutableVector<T> elements) {
        int size;
        int size2;
        int i2 = 0;
        if (elements.isEmpty()) {
            return i2;
        }
        ensureCapacity(size3 += size5);
        Object[] content = this.content;
        if (index != this.size) {
            ArraysKt.copyInto(content, content, size6 += index, index, this.size);
        }
        ArraysKt.copyInto(elements.content, content, index, i2, elements.size);
        this.size = size4 += size7;
        return 1;
    }

    public final boolean addAll(int index, Collection<? extends T> elements) {
        int size;
        int size2;
        int i4;
        Object next;
        int i2;
        Object obj;
        int i3;
        int i;
        if (elements.isEmpty()) {
            return 0;
        }
        ensureCapacity(size3 += size4);
        Object[] content = this.content;
        if (index != this.size) {
            ArraysKt.copyInto(content, content, size5 += index, index, this.size);
        }
        int i9 = 0;
        i4 = 0;
        final Iterator iterator = (Iterable)elements.iterator();
        while (iterator.hasNext()) {
            if (i4 < 0) {
            }
            i3 = 0;
            content[index + i4] = iterator.next();
            i4 = i2;
            CollectionsKt.throwIndexOverflow();
        }
        this.size = $this$forEachIndexed$iv += size6;
        return 1;
    }

    public final boolean addAll(int index, List<? extends T> elements) {
        int size2;
        int i;
        int size;
        int i2;
        Object obj;
        if (elements.isEmpty()) {
            return 0;
        }
        ensureCapacity(size3 += size4);
        Object[] content = this.content;
        if (index != this.size) {
            ArraysKt.copyInto(content, content, size5 += index, index, this.size);
        }
        i = 0;
        while (i < elements.size()) {
            content[index + i] = elements.get(i);
            i++;
        }
        this.size = i5 += size7;
        return 1;
    }

    public final boolean addAll(androidx.compose.runtime.collection.MutableVector<T> elements) {
        final int i = 0;
        return addAll(getSize(), elements);
    }

    public final boolean addAll(Collection<? extends T> elements) {
        return addAll(this.size, elements);
    }

    public final boolean addAll(List<? extends T> elements) {
        final int i = 0;
        return addAll(getSize(), elements);
    }

    public final boolean addAll(T[] elements) {
        int i;
        final int i3 = 1;
        int i4 = 0;
        i = elements.length == 0 ? i3 : i4;
        if (i != 0) {
            return i4;
        }
        ensureCapacity(size += length3);
        Object[] objArr = elements;
        ArraysKt.copyInto$default(objArr, this.content, this.size, 0, 0, 12, 0);
        this.size = obj10 += length2;
        return i3;
    }

    public final boolean any(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            while ((Boolean)predicate.invoke(getContent()[i]).booleanValue()) {
            }
            return 1;
        }
        return 0;
    }

    public final List<T> asMutableList() {
        List mutableVectorList;
        androidx.compose.runtime.collection.MutableVector.MutableVectorList list;
        int i;
        androidx.compose.runtime.collection.MutableVector.MutableVectorList list2;
        if (this.list == null) {
            mutableVectorList = new MutableVector.MutableVectorList(this);
            i = 0;
            this.list = (List)mutableVectorList;
        }
        return mutableVectorList;
    }

    @Override // java.util.RandomAccess
    public final void clear() {
        Object obj;
        int i;
        final int i4 = 0;
        size--;
        while (-1 < i) {
            this.content[i] = null;
            i--;
        }
        this.size = 0;
    }

    public final boolean contains(T element) {
        int i2;
        boolean equal;
        int i;
        Object[] content;
        i = 0;
        final int i5 = 1;
        size -= i5;
        if (0 <= i4) {
        }
        return 0;
    }

    public final boolean containsAll(androidx.compose.runtime.collection.MutableVector<T> elements) {
        int i;
        IntRange intRange;
        int i2;
        Object[] content;
        int i3 = 0;
        final int i4 = 1;
        final int i5 = 0;
        intRange = new IntRange(i5, size -= i4);
        int last = intRange.getLast();
        if (intRange.getFirst() <= last) {
        }
        return i4;
    }

    public final boolean containsAll(Collection<? extends T> elements) {
        Object next;
        Object obj;
        int i;
        boolean contains;
        final int i2 = 0;
        Iterator iterator = (Iterable)elements.iterator();
        for (Object next : iterator) {
            i = 0;
        }
        return 1;
    }

    public final boolean containsAll(List<? extends T> elements) {
        int i;
        boolean contains;
        i = 0;
        while (i < elements.size()) {
            i++;
        }
        return 1;
    }

    public final boolean contentEquals(androidx.compose.runtime.collection.MutableVector<T> other) {
        int i2;
        Object equal;
        int this_$iv;
        int i;
        Object[] content;
        final int i3 = 0;
        if (other.size != this.size) {
            return i3;
        }
        this_$iv = 0;
        final int i6 = 1;
        size3 -= i6;
        if (0 <= i5) {
        }
        return i6;
    }

    @Override // java.util.RandomAccess
    public final void ensureCapacity(int capacity) {
        int length;
        Object[] copyOf;
        String str;
        final Object[] content = this.content;
        if (content.length < capacity) {
            copyOf = Arrays.copyOf(content, Math.max(capacity, length2 *= 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final T first() {
        if (isEmpty()) {
        } else {
            final int i2 = 0;
            return this.getContent()[0];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("MutableVector is empty.");
        throw noSuchElementException;
    }

    public final T first(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        Object obj;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size <= 0) {
        } else {
            i = 0;
            obj = getContent()[i];
            while ((Boolean)predicate.invoke(obj).booleanValue()) {
                obj = content[i];
            }
            return obj;
        }
        throwNoSuchElementException();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public final T firstOrNull() {
        int index$iv;
        Object obj2;
        int i;
        Object obj;
        final int i2 = 0;
        if (isEmpty()) {
            index$iv = 0;
        } else {
            i = 0;
            index$iv = obj;
        }
        return index$iv;
    }

    public final T firstOrNull(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        Object obj;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            obj = getContent()[i];
            while ((Boolean)predicate.invoke(obj).booleanValue()) {
                obj = content[i];
            }
            return obj;
        }
        return 0;
    }

    public final <R> R fold(R initial, Function2<? super R, ? super T, ? extends R> operation) {
        Object acc;
        int i;
        Object[] content;
        Object obj;
        final int i2 = 0;
        acc = initial;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            acc = operation.invoke(acc, getContent()[i]);
            while (i++ >= size) {
                acc = operation.invoke(acc, content[i]);
            }
        }
        return acc;
    }

    public final <R> R foldIndexed(R initial, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Object acc;
        int i;
        Object[] content;
        Integer valueOf;
        Object obj;
        final int i2 = 0;
        acc = initial;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            acc = operation.invoke(Integer.valueOf(i), acc, getContent()[i]);
            while (i++ >= size) {
                acc = operation.invoke(Integer.valueOf(i), acc, content[i]);
            }
        }
        return acc;
    }

    public final <R> R foldRight(R initial, Function2<? super T, ? super R, ? extends R> operation) {
        Object acc;
        int i;
        Object[] content;
        Object obj;
        final int i2 = 0;
        acc = initial;
        final int size = getSize();
        if (size > 0) {
            i = size + -1;
            acc = operation.invoke(getContent()[i], acc);
            while (i-- < 0) {
                acc = operation.invoke(content[i], acc);
            }
        }
        return acc;
    }

    public final <R> R foldRightIndexed(R initial, Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        Object acc;
        int i;
        Object[] content;
        Integer valueOf;
        Object obj;
        final int i2 = 0;
        acc = initial;
        final int size = getSize();
        if (size > 0) {
            i = size + -1;
            acc = operation.invoke(Integer.valueOf(i), getContent()[i], acc);
            while (i-- < 0) {
                acc = operation.invoke(Integer.valueOf(i), content[i], acc);
            }
        }
        return acc;
    }

    public final void forEach(Function1<? super T, Unit> block) {
        int i;
        Object[] content;
        Object obj;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            block.invoke(getContent()[i]);
            while (i++ >= size) {
                block.invoke(content[i]);
            }
        }
    }

    public final void forEachIndexed(Function2<? super Integer, ? super T, Unit> block) {
        int i;
        Object[] content;
        Integer valueOf;
        Object obj;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            block.invoke(Integer.valueOf(i), getContent()[i]);
            while (i++ >= size) {
                block.invoke(Integer.valueOf(i), content[i]);
            }
        }
    }

    public final void forEachReversed(Function1<? super T, Unit> block) {
        int i;
        Object[] content;
        Object obj;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = size + -1;
            block.invoke(getContent()[i]);
            while (i-- < 0) {
                block.invoke(content[i]);
            }
        }
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super T, Unit> block) {
        int i;
        Object[] content;
        Integer valueOf;
        Object obj;
        final int i2 = 0;
        if (getSize() > 0) {
            size--;
            block.invoke(Integer.valueOf(i), getContent()[i]);
            while (i-- < 0) {
                block.invoke(Integer.valueOf(i), content[i]);
            }
        }
    }

    public final T get(int index) {
        final int i = 0;
        return getContent()[index];
    }

    public final T[] getContent() {
        return this.content;
    }

    @Override // java.util.RandomAccess
    public final IntRange getIndices() {
        final int i = 0;
        IntRange intRange = new IntRange(0, size--);
        return intRange;
    }

    @Override // java.util.RandomAccess
    public final int getLastIndex() {
        final int i = 0;
        return size--;
    }

    @Override // java.util.RandomAccess
    public final int getSize() {
        return this.size;
    }

    public final int indexOf(T element) {
        int i;
        Object[] content;
        boolean equal;
        final int size = this.size;
        if (size > 0) {
            i = 0;
            while (Intrinsics.areEqual(element, this.content[i])) {
            }
            return i;
        }
        return -1;
    }

    public final int indexOfFirst(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            while ((Boolean)predicate.invoke(getContent()[i]).booleanValue()) {
            }
            return i;
        }
        return -1;
    }

    public final int indexOfLast(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = size + -1;
            while ((Boolean)predicate.invoke(getContent()[i]).booleanValue()) {
            }
            return i;
        }
        return -1;
    }

    @Override // java.util.RandomAccess
    public final boolean isEmpty() {
        int i;
        i = this.size == 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.RandomAccess
    public final boolean isNotEmpty() {
        int i;
        i = this.size != 0 ? 1 : 0;
        return i;
    }

    public final T last() {
        if (isEmpty()) {
        } else {
            Object obj = this;
            int i = 0;
            int i2 = 0;
            return obj.getContent()[size--];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("MutableVector is empty.");
        throw noSuchElementException;
    }

    public final T last(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        Object obj;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size <= 0) {
        } else {
            i = size + -1;
            obj = getContent()[i];
            while ((Boolean)predicate.invoke(obj).booleanValue()) {
                obj = content[i];
            }
            return obj;
        }
        throwNoSuchElementException();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public final int lastIndexOf(T element) {
        int i;
        Object[] content;
        boolean equal;
        final int size = this.size;
        if (size > 0) {
            i = size + -1;
            while (Intrinsics.areEqual(element, this.content[i])) {
            }
            return i;
        }
        return -1;
    }

    public final T lastOrNull() {
        int this_$iv;
        int i;
        int i2;
        Object obj;
        final int i3 = 0;
        if (isEmpty()) {
            this_$iv = 0;
        } else {
            Object obj2 = this;
            int i4 = 0;
            i = 0;
            this_$iv = obj;
        }
        return this_$iv;
    }

    public final T lastOrNull(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        Object obj;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = size + -1;
            obj = getContent()[i];
            while ((Boolean)predicate.invoke(obj).booleanValue()) {
                obj = content[i];
            }
            return obj;
        }
        return 0;
    }

    public final <R> R[] map(Function1<? super T, ? extends R> transform) {
        int i;
        Object invoke;
        int i2;
        Object obj;
        final int i3 = 0;
        final int size = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        Object[] arr = new Object[size];
        while (i < size) {
            i2 = 0;
            obj = this.getContent()[i];
            Object this_$iv = obj;
            arr[i] = transform.invoke(obj);
            i++;
        }
        return arr;
    }

    public final <R> R[] mapIndexed(Function2<? super Integer, ? super T, ? extends R> transform) {
        int i2;
        Object invoke;
        Object this_$iv;
        int i;
        Object obj;
        final int i3 = 0;
        final int size = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        Object[] arr = new Object[size];
        while (i2 < size) {
            i = 0;
            obj = this.getContent()[i2];
            this_$iv = obj;
            arr[i2] = transform.invoke(Integer.valueOf(i2), obj);
            i2++;
        }
        return arr;
    }

    public final <R> androidx.compose.runtime.collection.MutableVector<R> mapIndexedNotNull(Function2<? super Integer, ? super T, ? extends R> transform) {
        int i;
        Object[] content;
        int i2;
        Object invoke;
        Object obj;
        final int i3 = 0;
        final int size = getSize();
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] arr = new Object[size];
        i = 0;
        if (size > 0) {
            i2 = 0;
            invoke = transform.invoke(Integer.valueOf(i2), getContent()[i2]);
            do {
                invoke = transform.invoke(Integer.valueOf(i2), content[i2]);
                if (i2++ < size) {
                }
                arr[i] = invoke;
                i = obj;
            } while (invoke != null);
        }
        MutableVector content2 = new MutableVector(arr, i);
        return content2;
    }

    public final <R> androidx.compose.runtime.collection.MutableVector<R> mapNotNull(Function1<? super T, ? extends R> transform) {
        int i2;
        Object[] content;
        int i;
        Object invoke;
        int i3;
        final int i4 = 0;
        final int size = getSize();
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] arr = new Object[size];
        i2 = 0;
        if (size > 0) {
            i = 0;
            invoke = transform.invoke(getContent()[i]);
            do {
                invoke = transform.invoke(content[i]);
                if (i++ < size) {
                }
                arr[i2] = invoke;
                i2 = i3;
            } while (invoke != null);
        }
        MutableVector content2 = new MutableVector(arr, i2);
        return content2;
    }

    public final void minusAssign(T element) {
        final int i = 0;
        remove(element);
    }

    public final void plusAssign(T element) {
        final int i = 0;
        add(element);
    }

    public final boolean remove(T element) {
        final int indexOf = indexOf(element);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return 1;
        }
        return 0;
    }

    public final boolean removeAll(androidx.compose.runtime.collection.MutableVector<T> elements) {
        int i2;
        Object this_$iv;
        int i3;
        int i;
        Object[] content;
        i3 = 0;
        size2 -= i;
        if (0 <= i5) {
        }
        if (this.size != this.size) {
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean removeAll(Collection<? extends T> elements) {
        int i;
        Object next;
        Object obj;
        int i2;
        if (elements.isEmpty()) {
            return 0;
        }
        final int i3 = 0;
        final Iterator iterator = (Iterable)elements.iterator();
        for (Object next : iterator) {
            i2 = 0;
            remove(next);
        }
        if (this.size != this.size) {
            i = 1;
        }
        return i;
    }

    public final boolean removeAll(List<? extends T> elements) {
        int i;
        int i2;
        Object obj;
        i = 0;
        while (i < elements.size()) {
            remove(elements.get(i));
            i++;
        }
        i2 = this.size != this.size ? 1 : 0;
        return i2;
    }

    public final T removeAt(int index) {
        Object obj;
        int size;
        final Object[] content = this.content;
        size = 0;
        if (index != size4--) {
            ArraysKt.copyInto(content, content, index, index + 1, this.size);
        }
        this.size = size2--;
        content[this.size] = 0;
        return content[index];
    }

    public final void removeIf(Function1<? super T, Boolean> predicate) {
        int gap;
        int i2;
        boolean booleanValue;
        int i;
        Object obj;
        final int i3 = 0;
        gap = 0;
        final int size = getSize();
        i2 = 0;
        while (i2 < size) {
            if ((Boolean)predicate.invoke(getContent()[i2]).booleanValue()) {
            } else {
            }
            if (gap > 0) {
            }
            i2++;
            getContent()[i2 - gap] = getContent()[i2];
            gap++;
        }
        ArraysKt.fill(getContent(), 0, size - gap, size);
        setSize(size - gap);
    }

    @Override // java.util.RandomAccess
    public final void removeRange(int start, int end) {
        int i;
        int content2;
        int i3;
        Object content;
        int i2;
        int i4;
        if (end > start && end < this.size) {
            if (end < this.size) {
                ArraysKt.copyInto(this.content, this.content, start, end, this.size);
            }
            size -= i5;
            i2 = 0;
            size2--;
            if (i <= i4) {
            }
            this.size = i;
        }
    }

    public final boolean retainAll(Collection<? extends T> elements) {
        Object this_$iv;
        int contains;
        int i2;
        int i;
        Object[] content;
        contains = 0;
        size3 -= i;
        while (-1 < i2) {
            int i4 = 0;
            if (elements.contains(this.getContent()[i2]) == 0) {
            }
            i2--;
            removeAt(i2);
        }
        if (this.size != this.size) {
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean reversedAny(Function1<? super T, Boolean> predicate) {
        int i;
        Object[] content;
        boolean booleanValue;
        final int i2 = 0;
        final int size = getSize();
        if (size > 0) {
            i = size + -1;
            while ((Boolean)predicate.invoke(getContent()[i]).booleanValue()) {
            }
            return 1;
        }
        return 0;
    }

    public final T set(int index, T element) {
        final Object[] content = this.content;
        content[index] = element;
        return content[index];
    }

    public final void setContent(T[] <set-?>) {
        this.content = <set-?>;
    }

    @Override // java.util.RandomAccess
    public final void setSize(int newSize) {
        this.size = newSize;
    }

    public final void sortWith(Comparator<T> comparator) {
        ArraysKt.sortWith(this.content, comparator, 0, this.size);
    }

    public final int sumBy(Function1<? super T, Integer> selector) {
        int sum;
        Object[] content;
        int i;
        int intValue;
        final int i2 = 0;
        sum = 0;
        final int size = getSize();
        if (size > 0) {
            i = 0;
            sum += intValue;
            while (i++ >= size) {
                sum += intValue;
            }
        }
        return sum;
    }

    @Override // java.util.RandomAccess
    public final Void throwNoSuchElementException() {
        NoSuchElementException noSuchElementException = new NoSuchElementException("MutableVector contains no element matching the predicate.");
        throw noSuchElementException;
    }
}
