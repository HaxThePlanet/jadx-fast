package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0008\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0002\u001a#\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0008\u000f\u001a-\u0010\u0010\u001a\u00020\u000b*\u00020\u000b2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0008\u000f\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"lastIdentifier", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/compose/ui/platform/AtomicInt;", "generateSemanticsId", "", "addSemanticsPropertiesFrom", "", "Landroidx/compose/ui/platform/InspectorInfo;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "clearAndSetSemantics", "Landroidx/compose/ui/Modifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "semantics", "mergeDescendants", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsModifierKt {

    private static AtomicInteger lastIdentifier;
    static {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        SemanticsModifierKt.lastIdentifier = atomicInteger;
    }

    public static final void access$addSemanticsPropertiesFrom(InspectorInfo $receiver, androidx.compose.ui.semantics.SemanticsConfiguration semanticsConfiguration) {
        SemanticsModifierKt.addSemanticsPropertiesFrom($receiver, semanticsConfiguration);
    }

    private static final void addSemanticsPropertiesFrom(InspectorInfo $this$addSemanticsPropertiesFrom, androidx.compose.ui.semantics.SemanticsConfiguration semanticsConfiguration) {
        Object next;
        Object second;
        Object first;
        Object key;
        String name;
        Iterable iterable = semanticsConfiguration;
        final int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, 10)), 16));
        final int i4 = 0;
        final Iterator iterator = iterable.iterator();
        for (Object next : iterator) {
            Object obj = next;
            int i5 = 0;
            Pair value2 = TuplesKt.to((SemanticsPropertyKey)(Map.Entry)obj.getKey().getName(), obj.getValue());
            (Map)linkedHashMap.put(value2.getFirst(), value2.getSecond());
        }
        $this$addSemanticsPropertiesFrom.getProperties().set("properties", linkedHashMap);
    }

    public static final Modifier clearAndSetSemantics(Modifier $this$clearAndSetSemantics, Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties) {
        ClearAndSetSemanticsElement clearAndSetSemanticsElement = new ClearAndSetSemanticsElement(properties);
        return $this$clearAndSetSemantics.then((Modifier)clearAndSetSemanticsElement);
    }

    public static final int generateSemanticsId() {
        return SemanticsModifierKt.lastIdentifier.addAndGet(1);
    }

    public static final Modifier semantics(Modifier $this$semantics, boolean mergeDescendants, Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties) {
        AppendedSemanticsElement appendedSemanticsElement = new AppendedSemanticsElement(mergeDescendants, properties);
        return $this$semantics.then((Modifier)appendedSemanticsElement);
    }

    public static Modifier semantics$default(Modifier modifier, boolean z2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        return SemanticsModifierKt.semantics(modifier, obj1, function13);
    }
}
