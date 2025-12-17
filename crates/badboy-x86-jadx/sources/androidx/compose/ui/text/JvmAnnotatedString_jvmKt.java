package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0018\u00010\u00032\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a,\u0010\u0008\u001a\u00020\t*\u00020\t2\u001e\u0010\u0008\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0000¨\u0006\u000c", d2 = {"collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "target", "Ljava/util/SortedSet;", "", "transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JvmAnnotatedString_jvmKt {
    private static final void collectRangeTransitions(List<? extends androidx.compose.ui.text.AnnotatedString.Range<?>> ranges, SortedSet<Integer> target) {
        Object obj4;
        int i5;
        Object accumulator$iv;
        Object obj5;
        int i4;
        int index$iv$iv;
        int size;
        Object obj3;
        Object obj;
        int i2;
        Object obj2;
        Object obj6;
        int i3;
        Object obj7;
        int i;
        Integer valueOf;
        if (ranges != null) {
            i5 = 0;
            int i6 = 0;
            obj5 = obj4;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj5.size()) {
                i2 = 0;
                obj2 = obj;
                i3 = 0;
                obj7 = obj6;
                i = 0;
                obj7.add(Integer.valueOf((AnnotatedString.Range)obj2.getStart()));
                obj7.add(Integer.valueOf(obj2.getEnd()));
                index$iv$iv++;
            }
        }
    }

    public static final androidx.compose.ui.text.AnnotatedString transform(androidx.compose.ui.text.AnnotatedString $this$transform, Function3<? super String, ? super Integer, ? super Integer, String> transform) {
        ArrayList transitions;
        java.util.TreeSet sortedSetOf;
        List spanStylesOrNull$ui_text_release;
        int i;
        List paragraphStylesOrNull$ui_text_release;
        java.util.TreeSet set2;
        int i5;
        List annotations$ui_text_release;
        int arrayList2;
        ArrayList arrayList;
        List i3;
        int index$iv$iv;
        int index$iv$iv2;
        int size;
        Object obj3;
        Object obj;
        int i4;
        List $this$fastMap$iv2;
        Object obj2;
        int i2;
        java.util.TreeSet transitions2;
        java.util.TreeSet set;
        List $this$fastMap$iv;
        int end;
        int end2;
        ArrayList list;
        List list2;
        Integer[] arr = new Integer[2];
        int i7 = 0;
        Integer valueOf = Integer.valueOf(i7);
        arr[i7] = valueOf;
        int i8 = 1;
        arr[i8] = Integer.valueOf($this$transform.getText().length());
        sortedSetOf = SetsKt.sortedSetOf(arr);
        JvmAnnotatedString_jvmKt.collectRangeTransitions($this$transform.getSpanStylesOrNull$ui_text_release(), (SortedSet)sortedSetOf);
        JvmAnnotatedString_jvmKt.collectRangeTransitions($this$transform.getParagraphStylesOrNull$ui_text_release(), (SortedSet)sortedSetOf);
        JvmAnnotatedString_jvmKt.collectRangeTransitions($this$transform.getAnnotations$ui_text_release(), (SortedSet)sortedSetOf);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        kotlin.Pair[] arr2 = new Pair[i8];
        arr2[i7] = TuplesKt.to(valueOf, valueOf);
        Map mutableMapOf = MapsKt.mutableMapOf(arr2);
        final androidx.compose.ui.text.AnnotatedString str2 = $this$transform;
        JvmAnnotatedString_jvmKt.transform.1 anon = new JvmAnnotatedString_jvmKt.transform.1(objectRef, transform, str2, mutableMapOf);
        CollectionsKt.windowed$default((Iterable)sortedSetOf, 2, 0, false, (Function1)anon, 6, 0);
        spanStylesOrNull$ui_text_release = str2.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            arrayList2 = 0;
            arrayList = new ArrayList(spanStylesOrNull$ui_text_release.size());
            i3 = spanStylesOrNull$ui_text_release;
            index$iv$iv = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < i3.size()) {
                i4 = 0;
                obj2 = obj;
                i2 = 0;
                Object obj5 = mutableMapOf.get(Integer.valueOf(obj2.getStart()));
                Intrinsics.checkNotNull(obj5);
                Object obj7 = mutableMapOf.get(Integer.valueOf(obj2.getEnd()));
                Intrinsics.checkNotNull(obj7);
                AnnotatedString.Range transitions3 = new AnnotatedString.Range((AnnotatedString.Range)obj2.getItem(), (Number)obj5.intValue(), (Number)obj7.intValue());
                (Collection)arrayList.add(transitions3);
                index$iv$iv2++;
                sortedSetOf = set;
                spanStylesOrNull$ui_text_release = $this$fastMap$iv;
                arrayList2 = end2;
                arrayList = list;
            }
            transitions2 = sortedSetOf;
            $this$fastMap$iv = spanStylesOrNull$ui_text_release;
            end2 = arrayList2;
            transitions = list;
        } else {
            transitions2 = sortedSetOf;
            transitions = 0;
        }
        paragraphStylesOrNull$ui_text_release = str2.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release != null) {
            set2 = 0;
            arrayList2 = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
            i3 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < paragraphStylesOrNull$ui_text_release.size()) {
                obj = 0;
                obj2 = obj3;
                i2 = 0;
                Object obj4 = mutableMapOf.get(Integer.valueOf(obj2.getStart()));
                Intrinsics.checkNotNull(obj4);
                Object obj6 = mutableMapOf.get(Integer.valueOf(obj2.getEnd()));
                Intrinsics.checkNotNull(obj6);
                AnnotatedString.Range $this$fastMap$iv3 = new AnnotatedString.Range((AnnotatedString.Range)obj2.getItem(), (Number)obj4.intValue(), (Number)obj6.intValue());
                (Collection)arrayList2.add($this$fastMap$iv3);
                index$iv$iv++;
                paragraphStylesOrNull$ui_text_release = $this$fastMap$iv;
                set2 = end;
                arrayList2 = list;
                arrayList = list2;
            }
            $this$fastMap$iv = paragraphStylesOrNull$ui_text_release;
            end = set2;
            list2 = arrayList;
            i = list;
        } else {
            i = 0;
        }
        annotations$ui_text_release = str2.getAnnotations$ui_text_release();
        if (annotations$ui_text_release != null) {
            arrayList2 = 0;
            arrayList = new ArrayList(annotations$ui_text_release.size());
            index$iv$iv = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < annotations$ui_text_release.size()) {
                i4 = 0;
                obj2 = obj;
                i2 = 0;
                Object obj8 = mutableMapOf.get(Integer.valueOf(obj2.getStart()));
                Intrinsics.checkNotNull(obj8);
                Object obj9 = mutableMapOf.get(Integer.valueOf(obj2.getEnd()));
                Intrinsics.checkNotNull(obj9);
                AnnotatedString.Range $i$f$fastMap = new AnnotatedString.Range((AnnotatedString.Range)obj2.getItem(), (Number)obj8.intValue(), (Number)obj9.intValue());
                (Collection)arrayList.add($i$f$fastMap);
                index$iv$iv2++;
                annotations$ui_text_release = $this$fastMap$iv2;
                arrayList2 = $this$fastMap$iv;
                arrayList = end;
                i3 = list;
                index$iv$iv = list2;
            }
            $this$fastMap$iv2 = annotations$ui_text_release;
            $this$fastMap$iv = arrayList2;
            list = i3;
            list2 = index$iv$iv;
            i5 = end;
        } else {
            i5 = 0;
        }
        AnnotatedString annotatedString = new AnnotatedString((String)objectRef.element, transitions, i, i5);
        return annotatedString;
    }
}
