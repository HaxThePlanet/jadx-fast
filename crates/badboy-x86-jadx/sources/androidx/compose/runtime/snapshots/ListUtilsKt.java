package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\"\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001a8\u0010\n\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\u000e\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001aS\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0010H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\u0015\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a>\u0010\u0017\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0010H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001aP\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u000c0\u0019\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u001a*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001a0\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a}\u0010\u001c\u001a\u0002H\u001d\"\u0004\u0008\u0000\u0010\u0002\"\u000c\u0008\u0001\u0010\u001d*\u00060\u0003j\u0002`\u0004*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0006\u0010\u001e\u001a\u0002H\u001d2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00082\u0008\u0008\u0002\u0010 \u001a\u00020\u00082\u0008\u0008\u0002\u0010!\u001a\u00020\u00082\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010#\u001a\u00020\u00082\u0016\u0008\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010$\u001ab\u0010%\u001a\u00020&\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00082\u0008\u0008\u0002\u0010 \u001a\u00020\u00082\u0008\u0008\u0002\u0010!\u001a\u00020\u00082\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010#\u001a\u00020\u00082\u0016\u0008\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007H\u0000\u001aD\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H(0\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010(*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H(0\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001aF\u0010)\u001a\u0008\u0012\u0004\u0012\u0002H(0\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010(*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H(0\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a\u001e\u0010*\u001a\u0008\u0012\u0004\u0012\u0002H\u00020+\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000cH\u0000¨\u0006,", d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAll", "", "", "predicate", "fastAny", "fastFilterIndexed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "fastForEach", "action", "fastForEachIndexed", "fastGroupBy", "", "K", "keySelector", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMap", "R", "fastMapNotNull", "fastToSet", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListUtilsKt {
    private static final <T> void appendElement(java.lang.Appendable $this$appendElement, T element, Function1<? super T, ? extends java.lang.CharSequence> transform) {
        String charValue;
        int i;
        if (transform != null) {
            $this$appendElement.append((CharSequence)transform.invoke(element));
        } else {
            i = element == null ? 1 : element instanceof CharSequence;
            if (i != 0) {
                $this$appendElement.append((CharSequence)element);
            } else {
                if (element instanceof Character) {
                    $this$appendElement.append((Character)element.charValue());
                } else {
                    $this$appendElement.append((CharSequence)String.valueOf(element));
                }
            }
        }
    }

    public static final <T> boolean fastAll(List<? extends T> $this$fastAll, Function1<? super T, Boolean> predicate) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        boolean booleanValue;
        final int i2 = 0;
        Object obj3 = $this$fastAll;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            index$iv++;
        }
        return 1;
    }

    public static final <T> boolean fastAny(List<? extends T> $this$fastAny, Function1<? super T, Boolean> predicate) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        boolean booleanValue;
        final int i2 = 0;
        Object obj3 = $this$fastAny;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            index$iv++;
        }
        return 0;
    }

    public static final <T> List<T> fastFilterIndexed(List<? extends T> $this$fastFilterIndexed, Function2<? super Integer, ? super T, Boolean> predicate) {
        int index$iv;
        Object obj2;
        int i2;
        Object obj;
        int i;
        boolean booleanValue;
        final int i3 = 0;
        ArrayList arrayList = new ArrayList($this$fastFilterIndexed.size());
        Object obj3 = $this$fastFilterIndexed;
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj = obj2;
            i = 0;
            if ((Boolean)predicate.invoke(Integer.valueOf(index$iv), obj).booleanValue()) {
            }
            index$iv++;
            (Collection)arrayList.add(obj);
        }
        return (List)arrayList;
    }

    public static final <T> void fastForEach(List<? extends T> $this$fastForEach, Function1<? super T, Unit> action) {
        int index;
        Object obj;
        final int i = 0;
        index = 0;
        while (index < $this$fastForEach.size()) {
            action.invoke($this$fastForEach.get(index));
            index++;
        }
    }

    public static final <T> void fastForEachIndexed(List<? extends T> $this$fastForEachIndexed, Function2<? super Integer, ? super T, Unit> action) {
        int index;
        Object obj;
        Integer valueOf;
        final int i = 0;
        index = 0;
        while (index < $this$fastForEachIndexed.size()) {
            action.invoke(Integer.valueOf(index), $this$fastForEachIndexed.get(index));
            index++;
        }
    }

    public static final <T, K> Map<K, List<T>> fastGroupBy(List<? extends T> $this$fastGroupBy, Function1<? super T, ? extends K> keySelector) {
        int index$iv;
        Object obj;
        Object obj3;
        int i;
        Object obj5;
        Object invoke;
        ArrayList $this$getOrPut$iv;
        int i2;
        Object obj2;
        int i3;
        ArrayList arrayList;
        final int i4 = 0;
        HashMap hashMap = new HashMap($this$fastGroupBy.size());
        Object obj4 = $this$fastGroupBy;
        final int i5 = 0;
        index$iv = 0;
        while (index$iv < obj4.size()) {
            obj3 = obj;
            i = 0;
            invoke = keySelector.invoke(obj3);
            HashMap map = hashMap;
            i2 = 0;
            obj2 = (Map)map.get(invoke);
            if (obj2 == null) {
            } else {
            }
            arrayList = obj2;
            (ArrayList)arrayList.add(obj3);
            index$iv++;
            i3 = 0;
            arrayList = new ArrayList();
            map.put(invoke, arrayList);
        }
        Object obj6 = keySelector;
        return (Map)hashMap;
    }

    private static final <T, A extends java.lang.Appendable> A fastJoinTo(List<? extends T> $this$fastJoinTo, A buffer, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super T, ? extends java.lang.CharSequence> transform) {
        int count;
        int index;
        Object obj;
        int i;
        buffer.append(prefix);
        count = 0;
        index = 0;
        while (index < $this$fastJoinTo.size()) {
            count++;
            if (count > 1) {
            }
            if (limit >= 0) {
                break;
            } else {
            }
            ListUtilsKt.appendElement(buffer, $this$fastJoinTo.get(index), transform);
            index++;
            if (count > limit) {
                break;
            } else {
            }
            buffer.append(separator);
        }
        if (limit >= 0 && count > limit) {
            if (count > limit) {
                buffer.append(truncated);
            }
        }
        buffer.append(postfix);
        return buffer;
    }

    static java.lang.Appendable fastJoinTo$default(List list, java.lang.Appendable appendable2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, java.lang.CharSequence charSequence5, int i6, java.lang.CharSequence charSequence7, Function1 function18, int i9, Object object10) {
        String str4;
        String str2;
        String str3;
        int i;
        String str;
        int i2;
        if (i9 & 2 != 0) {
            str4 = ", ";
        } else {
            str4 = charSequence3;
        }
        if (i9 & 4 != 0) {
            str2 = str3;
        } else {
            str2 = charSequence4;
        }
        if (i9 & 8 != 0) {
        } else {
            str3 = charSequence5;
        }
        i = i9 & 16 != 0 ? -1 : i6;
        if (i9 & 32 != 0) {
            str = "...";
        } else {
            str = charSequence7;
        }
        i2 = i9 & 64 != 0 ? 0 : function18;
        return ListUtilsKt.fastJoinTo(list, appendable2, str4, str2, str3, i, str, i2);
    }

    public static final <T> String fastJoinToString(List<? extends T> $this$fastJoinToString, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super T, ? extends java.lang.CharSequence> transform) {
        StringBuilder stringBuilder = new StringBuilder();
        return (StringBuilder)ListUtilsKt.fastJoinTo($this$fastJoinToString, (Appendable)stringBuilder, separator, prefix, postfix, limit, truncated, transform).toString();
    }

    public static String fastJoinToString$default(List list, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, Function1 function17, int i8, Object object9) {
        String obj2;
        String obj3;
        String obj4;
        int obj5;
        String obj6;
        int obj7;
        int obj9;
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
        return ListUtilsKt.fastJoinToString(list, obj2, obj3, obj4, obj5, obj6, obj9);
    }

    public static final <T, R> List<R> fastMap(List<? extends T> $this$fastMap, Function1<? super T, ? extends R> transform) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        ArrayList list;
        Object invoke;
        final int i2 = 0;
        ArrayList arrayList = new ArrayList($this$fastMap.size());
        Object obj3 = $this$fastMap;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            (Collection)arrayList.add(transform.invoke(obj3.get(index$iv)));
            index$iv++;
        }
        return (List)arrayList;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> $this$fastMapNotNull, Function1<? super T, ? extends R> transform) {
        int index$iv;
        Object obj;
        Object obj2;
        int i2;
        Object invoke;
        int i;
        ArrayList list;
        final int i3 = 0;
        ArrayList arrayList = new ArrayList($this$fastMapNotNull.size());
        Object obj3 = $this$fastMapNotNull;
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i2 = 0;
            invoke = transform.invoke(obj3.get(index$iv));
            if (invoke != null) {
            }
            index$iv++;
            i = 0;
            (Collection)arrayList.add(invoke);
        }
        return (List)arrayList;
    }

    public static final <T> Set<T> fastToSet(List<? extends T> $this$fastToSet) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        HashSet hashSet = new HashSet($this$fastToSet.size());
        final int i2 = 0;
        final Object obj3 = $this$fastToSet;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            hashSet.add(obj3.get(index$iv));
            index$iv++;
        }
        return (Set)hashSet;
    }
}
