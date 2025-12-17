package androidx.compose.ui.tooling.animation;

import androidx.compose.ui.tooling.PreviewUtils_androidKt;
import androidx.compose.ui.tooling.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0000\u001a&\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0006\u0008\u0000\u0010\n\u0018\u0001*\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0082\u0008¢\u0006\u0002\u0010\u000e\u001a\u001b\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0010\"\u0006\u0008\u0000\u0010\n\u0018\u0001*\u00020\u000bH\u0082\u0008\u001a!\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0010\"\u0006\u0008\u0000\u0010\n\u0018\u0001*\u0008\u0012\u0004\u0012\u00020\u000b0\u0011H\u0082\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"ANIMATED_CONTENT", "", "ANIMATED_VISIBILITY", "ANIMATE_VALUE_AS_STATE", "REMEMBER", "REMEMBER_INFINITE_TRANSITION", "REMEMBER_UPDATED_STATE", "SIZE_ANIMATION_MODIFIER", "UPDATE_TRANSITION", "findData", "T", "Landroidx/compose/ui/tooling/data/Group;", "includeGrandchildren", "", "(Landroidx/compose/ui/tooling/data/Group;Z)Ljava/lang/Object;", "findRememberedData", "", "", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimationSearch_androidKt {

    private static final String ANIMATED_CONTENT = "AnimatedContent";
    private static final String ANIMATED_VISIBILITY = "AnimatedVisibility";
    private static final String ANIMATE_VALUE_AS_STATE = "animateValueAsState";
    private static final String REMEMBER = "remember";
    private static final String REMEMBER_INFINITE_TRANSITION = "rememberInfiniteTransition";
    private static final String REMEMBER_UPDATED_STATE = "rememberUpdatedState";
    private static final String SIZE_ANIMATION_MODIFIER = "androidx.compose.animation.SizeAnimationModifierElement";
    private static final String UPDATE_TRANSITION = "updateTransition";
    private static final <T> T findData(Group $this$findData, boolean includeGrandchildren) {
        Object it;
        List plus;
        int i;
        Collection element$iv;
        ArrayList arrayList;
        int str;
        Collection collection;
        Iterator data;
        int next2;
        boolean next3;
        Iterator it2;
        boolean next;
        Collection child;
        int i2;
        final int i3 = 0;
        it = $this$findData.getChildren();
        int i4 = 0;
        if (includeGrandchildren) {
            i = 0;
            arrayList = new ArrayList();
            next2 = 0;
            it2 = (Iterable)(Collection)it.iterator();
            for (Object next : it2) {
                i2 = 0;
                CollectionsKt.addAll((Collection)arrayList, (Iterable)(Group)next.getChildren());
            }
            it = plus;
        }
        int i5 = 0;
        ArrayList arrayList2 = new ArrayList();
        str = 0;
        data = (Iterable)it.iterator();
        for (Object next2 : data) {
            next = false;
            CollectionsKt.addAll((Collection)arrayList2, (Iterable)(Group)next2.getData());
        }
        int i6 = 0;
        Iterator iterator = (Iterable)CollectionsKt.plus($this$findData.getData(), (Iterable)(List)arrayList2).iterator();
        str = "T";
        for (Object element$iv : iterator) {
            next3 = false;
            Intrinsics.reifiedOperationMarker(3, str);
            str = "T";
        }
        element$iv = 0;
        Intrinsics.reifiedOperationMarker(2, str);
        Collection collection2 = element$iv;
        return element$iv;
    }

    static Object findData$default(Group $this$findData_u24default, boolean includeGrandchildren, int i3, Object object4) {
        Object it;
        List plus;
        int i;
        Collection element$iv;
        ArrayList arrayList;
        int str;
        Collection collection;
        Iterator data;
        int next2;
        boolean next3;
        Iterator it2;
        Object next;
        Collection child;
        int i2;
        int obj12;
        if (i3 &= 1 != 0) {
            obj12 = 0;
        }
        int obj13 = 0;
        it = $this$findData_u24default.getChildren();
        int i5 = 0;
        if (obj12 != null) {
            i = 0;
            arrayList = new ArrayList();
            next2 = 0;
            it2 = (Iterable)(Collection)it.iterator();
            for (Object next : it2) {
                i2 = 0;
                CollectionsKt.addAll((Collection)arrayList, (Iterable)(Group)next.getChildren());
            }
            it = plus;
        }
        int i6 = 0;
        ArrayList arrayList2 = new ArrayList();
        str = 0;
        data = (Iterable)it.iterator();
        for (Object next2 : data) {
            next = false;
            CollectionsKt.addAll((Collection)arrayList2, (Iterable)(Group)next2.getData());
        }
        int i7 = 0;
        Iterator iterator = (Iterable)CollectionsKt.plus($this$findData_u24default.getData(), (Iterable)(List)arrayList2).iterator();
        str = "T";
        for (Object element$iv : iterator) {
            next3 = false;
            Intrinsics.reifiedOperationMarker(3, str);
            str = "T";
        }
        element$iv = 0;
        Intrinsics.reifiedOperationMarker(2, str);
        int i4 = element$iv;
        return element$iv;
    }

    private static final <T> List<T> findRememberedData(Group $this$findRememberedData) {
        int data$iv2;
        int i6;
        int $this$firstOrNull$iv;
        List it;
        Object $i$a$LetAnimationSearch_androidKt$findRememberedData$2;
        Object element$iv;
        int i;
        androidx.compose.ui.tooling.animation.AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1 anon;
        int data$iv;
        String str;
        boolean it2;
        int i3;
        Object next2;
        boolean next4;
        boolean next;
        Object obj2;
        int i4;
        Object obj3;
        int i5;
        Collection iNSTANCE;
        int i7;
        Iterator iterator2;
        int element$iv$iv;
        Object iterator;
        int next3;
        Object obj;
        int i2;
        int $i$f$findRememberedData;
        data$iv2 = 0;
        int i8 = 0;
        $i$a$LetAnimationSearch_androidKt$findRememberedData$2 = (Iterable)$this$findRememberedData.getData().iterator();
        i = 3;
        str = "T";
        for (Object element$iv : $i$a$LetAnimationSearch_androidKt$findRememberedData$2) {
            i3 = 0;
            Intrinsics.reifiedOperationMarker(i, str);
            i = 3;
            str = "T";
        }
        element$iv = 0;
        $this$firstOrNull$iv = 2;
        Intrinsics.reifiedOperationMarker($this$firstOrNull$iv, str);
        it = element$iv;
        int i9 = 0;
        it = CollectionsKt.listOf(element$iv);
        $i$a$LetAnimationSearch_androidKt$findRememberedData$2 = it;
        if (element$iv != null && it != null) {
            i9 = 0;
            it = CollectionsKt.listOf(element$iv);
            $i$a$LetAnimationSearch_androidKt$findRememberedData$2 = it;
            if (it != null) {
                $i$a$LetAnimationSearch_androidKt$findRememberedData$2 = it;
            } else {
                it = CollectionsKt.emptyList();
            }
        } else {
        }
        Collection children = $this$findRememberedData.getChildren();
        int i10 = 0;
        int i11 = 0;
        ArrayList arrayList = new ArrayList();
        int i14 = 0;
        int i17 = 0;
        Iterator iterator3 = (Iterable)children.iterator();
        for (Object next2 : iterator3) {
            i4 = 0;
            i5 = 0;
            i7 = 0;
            iterator2 = (Iterable)(Group)next2.getData().iterator();
            for (Object element$iv$iv : iterator2) {
                next3 = 0;
                Intrinsics.reifiedOperationMarker(i, str);
            }
            element$iv$iv = 0;
            Intrinsics.reifiedOperationMarker($this$firstOrNull$iv, str);
            data$iv = element$iv$iv;
            if (element$iv$iv != 0) {
            }
            obj3 = 0;
            (Collection)arrayList.add(element$iv$iv);
            next3 = 0;
            Intrinsics.reifiedOperationMarker(i, str);
            if (obj6 instanceof Object != null) {
            } else {
            }
        }
        int i12 = 0;
        ArrayList arrayList2 = new ArrayList();
        int i15 = 0;
        int i18 = 0;
        Iterator iterator4 = (Iterable)children.iterator();
        while (iterator4.hasNext()) {
            i4 = 0;
            i5 = 0;
            Group it$iv = PreviewUtils_androidKt.firstOrNull((Group)iterator4.next(), (Function1)AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1.INSTANCE);
            if (it$iv != null) {
            }
            $this$firstOrNull$iv = 2;
            i = 3;
            anon = 0;
            (Collection)arrayList2.add(it$iv);
        }
        int i13 = 0;
        ArrayList arrayList3 = new ArrayList();
        int i16 = 0;
        int i19 = 0;
        Iterator iterator5 = (Iterable)(List)arrayList2.iterator();
        for (Object next : iterator5) {
            i4 = 0;
            iNSTANCE = 0;
            element$iv$iv = 0;
            iterator = (Iterable)(Group)next.getData().iterator();
            for (Object next3 : iterator) {
                i2 = 0;
                Intrinsics.reifiedOperationMarker(3, str);
                data$iv2 = $i$f$findRememberedData;
            }
            $i$f$findRememberedData = data$iv2;
            next3 = 0;
            Intrinsics.reifiedOperationMarker(2, str);
            obj3 = next3;
            if (next3 != null) {
            }
            data$iv2 = $i$f$findRememberedData;
            i5 = 0;
            (Collection)arrayList3.add(next3);
            i2 = 0;
            Intrinsics.reifiedOperationMarker(3, str);
            if (obj4 instanceof Object != null) {
            } else {
            }
            data$iv2 = $i$f$findRememberedData;
        }
        int $i$f$findRememberedData3 = data$iv2;
        return CollectionsKt.plus((Collection)it, (Iterable)CollectionsKt.plus((Collection)(List)arrayList, (Iterable)(List)arrayList3));
    }

    private static final <T> List<T> findRememberedData(Collection<? extends Group> $this$findRememberedData) {
        int it$iv$iv;
        int i2;
        Object next;
        int i5;
        int it$iv$iv2;
        int i;
        androidx.compose.ui.tooling.animation.AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1 anon;
        int data;
        boolean next3;
        String str;
        Object obj;
        int i3;
        Object obj2;
        int i4;
        Collection iNSTANCE;
        int i7;
        Iterator iterator;
        boolean next4;
        Object iterator2;
        int next2;
        Object obj3;
        int i6;
        int $i$f$findRememberedData;
        it$iv$iv = 0;
        int i8 = 0;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i13 = 0;
        Iterator iterator3 = (Iterable)$this$findRememberedData.iterator();
        str = "T";
        for (Object next : iterator3) {
            i3 = 0;
            i4 = 0;
            i7 = 0;
            iterator = (Iterable)(Group)next.getData().iterator();
            for (Object next4 : iterator) {
                next2 = 0;
                Intrinsics.reifiedOperationMarker(3, str);
            }
            data = 0;
            Intrinsics.reifiedOperationMarker(2, str);
            i5 = data;
            if (data != null) {
            }
            str = "T";
            i5 = 0;
            (Collection)arrayList.add(data);
            next4 = iterator.next();
            next2 = 0;
            Intrinsics.reifiedOperationMarker(3, str);
            if (obj8 instanceof Object != null) {
            } else {
            }
            data = next4;
        }
        int i9 = 0;
        ArrayList arrayList2 = new ArrayList();
        int i12 = 0;
        int i14 = 0;
        Iterator iterator4 = (Iterable)$this$findRememberedData.iterator();
        while (iterator4.hasNext()) {
            i3 = 0;
            i4 = 0;
            Group it = PreviewUtils_androidKt.firstOrNull((Group)iterator4.next(), (Function1)AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1.INSTANCE);
            if (it != null) {
            }
            it$iv$iv2 = 2;
            i = 3;
            anon = 0;
            (Collection)arrayList2.add(it);
        }
        int i11 = 0;
        ArrayList arrayList3 = new ArrayList();
        int i15 = 0;
        int i16 = 0;
        Iterator iterator5 = (Iterable)(List)arrayList2.iterator();
        for (Object next3 : iterator5) {
            i3 = 0;
            iNSTANCE = 0;
            next4 = 0;
            iterator2 = (Iterable)(Group)next3.getData().iterator();
            for (Object next2 : iterator2) {
                i6 = 0;
                Intrinsics.reifiedOperationMarker(3, str);
                it$iv$iv = $i$f$findRememberedData;
            }
            $i$f$findRememberedData = it$iv$iv;
            next2 = 0;
            Intrinsics.reifiedOperationMarker(2, str);
            obj2 = next2;
            if (next2 != 0) {
            }
            it$iv$iv = $i$f$findRememberedData;
            i4 = 0;
            (Collection)arrayList3.add(next2);
            i6 = 0;
            Intrinsics.reifiedOperationMarker(3, str);
            if (obj4 instanceof Object != null) {
            } else {
            }
            it$iv$iv = $i$f$findRememberedData;
        }
        int $i$f$findRememberedData3 = it$iv$iv;
        return CollectionsKt.plus((Collection)(List)arrayList, (Iterable)(List)arrayList3);
    }
}
