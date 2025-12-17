package androidx.compose.ui.modifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SpreadBuilder;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a?\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00032\u001a\u0010\u0005\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0006\"\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0005\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0006\"\u0006\u0012\u0002\u0008\u00030\u0003H\u0007¢\u0006\u0002\u0010\n\u001aA\u0010\u0000\u001a\u00020\u000122\u0010\u000b\u001a\u001a\u0012\u0016\u0008\u0001\u0012\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0004\u0012\u00020\r0\u000c0\u0006\"\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0004\u0012\u00020\r0\u000cH\u0007¢\u0006\u0002\u0010\u000e\u001ao\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u000f\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0004\u0012\u00020\r0\u000c2\u0016\u0010\u0010\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0004\u0012\u00020\r0\u000c22\u0010\u000b\u001a\u001a\u0012\u0016\u0008\u0001\u0012\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0004\u0012\u00020\r0\u000c0\u0006\"\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00082\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0003\u0012\u0004\u0012\u0002H\u00080\u000c¨\u0006\u0013", d2 = {"modifierLocalMapOf", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "key1", "Landroidx/compose/ui/modifier/ModifierLocal;", "key2", "keys", "", "(Landroidx/compose/ui/modifier/ModifierLocal;Landroidx/compose/ui/modifier/ModifierLocal;[Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "T", "key", "([Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entries", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry1", "entry2", "(Lkotlin/Pair;Lkotlin/Pair;[Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModifierLocalModifierNodeKt {
    public static final androidx.compose.ui.modifier.ModifierLocalMap modifierLocalMapOf() {
        return (ModifierLocalMap)EmptyMap.INSTANCE;
    }

    public static final <T> androidx.compose.ui.modifier.ModifierLocalMap modifierLocalMapOf(androidx.compose.ui.modifier.ModifierLocal<T> key) {
        SingleLocalMap singleLocalMap = new SingleLocalMap(key);
        return (ModifierLocalMap)singleLocalMap;
    }

    public static final androidx.compose.ui.modifier.ModifierLocalMap modifierLocalMapOf(androidx.compose.ui.modifier.ModifierLocal<?> key1, androidx.compose.ui.modifier.ModifierLocal<?> key2, androidx.compose.ui.modifier.ModifierLocal<?>... keys) {
        int i;
        Object obj;
        Pair it;
        int i2;
        int i3 = 0;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.to(key2, i3));
        Object[] objArr = keys;
        int i6 = 0;
        ArrayList arrayList = new ArrayList(objArr.length);
        Object[] objArr2 = objArr;
        final int i7 = 0;
        final int i8 = 0;
        i = i8;
        while (i < objArr2.length) {
            i2 = 0;
            (Collection)arrayList.add(TuplesKt.to(objArr2[i], i3));
            i++;
        }
        int i5 = 0;
        spreadBuilder.addSpread((Collection)(List)arrayList.toArray(new Pair[i8]));
        MultiLocalMap multiLocalMap = new MultiLocalMap(TuplesKt.to(key1, i3), (Pair[])spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
        return (ModifierLocalMap)multiLocalMap;
    }

    public static final <T> androidx.compose.ui.modifier.ModifierLocalMap modifierLocalMapOf(Pair<? extends androidx.compose.ui.modifier.ModifierLocal<T>, ? extends T> entry) {
        SingleLocalMap singleLocalMap = new SingleLocalMap((ModifierLocal)entry.getFirst());
        final int i = 0;
        singleLocalMap.set$ui_release((ModifierLocal)entry.getFirst(), entry.getSecond());
        return (ModifierLocalMap)singleLocalMap;
    }

    public static final androidx.compose.ui.modifier.ModifierLocalMap modifierLocalMapOf(Pair<? extends androidx.compose.ui.modifier.ModifierLocal<?>, ? extends Object> entry1, Pair<? extends androidx.compose.ui.modifier.ModifierLocal<?>, ? extends Object> entry2, Pair<? extends androidx.compose.ui.modifier.ModifierLocal<?>, ? extends Object>... entries) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(entry2);
        spreadBuilder.addSpread(entries);
        MultiLocalMap multiLocalMap = new MultiLocalMap(entry1, (Pair[])spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
        return (ModifierLocalMap)multiLocalMap;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final androidx.compose.ui.modifier.ModifierLocalMap modifierLocalMapOf(androidx.compose.ui.modifier.ModifierLocal... keys) {
        androidx.compose.ui.modifier.ModifierLocalMap singleLocalMap;
        Object copyOf;
        androidx.compose.ui.modifier.MultiLocalMap multiLocalMap;
        ArrayList list2;
        Pair[] arr;
        List list3;
        int i;
        int index$iv$iv;
        int size;
        Object obj2;
        Object obj;
        int i2;
        ArrayList list;
        Pair it;
        int i3;
        switch (length) {
            case 0:
                singleLocalMap = EmptyMap.INSTANCE;
                break;
            case 1:
                singleLocalMap = new SingleLocalMap((ModifierLocal)ArraysKt.first(keys));
                break;
            default:
                int i4 = 0;
                List drop = ArraysKt.drop(keys, 1);
                int i7 = 0;
                ArrayList arrayList = new ArrayList(drop.size());
                list3 = drop;
                i = 0;
                index$iv$iv = 0;
                i2 = 0;
                i3 = 0;
                (Collection)arrayList.add(TuplesKt.to((ModifierLocal)list3.get(index$iv$iv), i4));
                index$iv$iv++;
                int i6 = 0;
                Object[] $this$toTypedArray$iv = (Collection)(List)arrayList.toArray(new Pair[0]);
                multiLocalMap = new MultiLocalMap(TuplesKt.to(ArraysKt.first(keys), i4), (Pair[])Arrays.copyOf((Pair[])$this$toTypedArray$iv, $this$toTypedArray$iv.length));
                singleLocalMap = multiLocalMap;
        }
        return singleLocalMap;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final androidx.compose.ui.modifier.ModifierLocalMap modifierLocalMapOf(Pair... entries) {
        androidx.compose.ui.modifier.ModifierLocalMap multiLocalMap;
        int copyOf;
        Object first;
        int length;
        int i;
        List list;
        copyOf = 0;
        switch (length2) {
            case 0:
                multiLocalMap = EmptyMap.INSTANCE;
                break;
            case 1:
                multiLocalMap = new MultiLocalMap((Pair)ArraysKt.first(entries), new Pair[copyOf]);
                break;
            default:
                i = 0;
                Object[] array = (Collection)ArraysKt.drop(entries, 1).toArray(new Pair[copyOf]);
                multiLocalMap = new MultiLocalMap((Pair)ArraysKt.first(entries), (Pair[])Arrays.copyOf((Pair[])array, array.length));
        }
        return multiLocalMap;
    }
}
