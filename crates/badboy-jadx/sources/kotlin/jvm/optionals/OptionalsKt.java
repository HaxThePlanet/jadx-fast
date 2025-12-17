package kotlin.jvm.optionals;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\u001a$\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a,\u0010\u0005\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0008\u0002H\u00020\u00042\u0006\u0010\u0006\u001a\u0002H\u0002H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aC\u0010\u0008\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0008\u0002H\u00020\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\tH\u0087\u0008ø\u0001\u0001ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u0004\u0018\u0001H\u0002\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u000c\u001a;\u0010\r\u001a\u0002H\u000e\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003\"\u0010\u0008\u0001\u0010\u000e*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u000f*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u0002H\u000eH\u0007¢\u0006\u0002\u0010\u0011\u001a$\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a$\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0004H\u0007\u0082\u0002\u000b\n\u0002\u00089\n\u0005\u0008\u009920\u0001¨\u0006\u0016", d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "T", "", "Ljava/util/Optional;", "getOrDefault", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/util/Optional;)Ljava/lang/Object;", "toCollection", "C", "", "destination", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "toList", "", "toSet", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class OptionalsKt {
    public static final <T> Sequence<T> asSequence(Optional<? extends T> $this$asSequence) {
        Sequence emptySequence;
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        if ($this$asSequence.isPresent()) {
            emptySequence = SequencesKt.sequenceOf(/* result */);
        } else {
            emptySequence = SequencesKt.emptySequence();
        }
        return emptySequence;
    }

    public static final <T> T getOrDefault(Optional<? extends T> $this$getOrDefault, T defaultValue) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$getOrDefault, "<this>");
        if ($this$getOrDefault.isPresent()) {
            obj = $this$getOrDefault.get();
        } else {
            obj = defaultValue;
        }
        return obj;
    }

    public static final <T> T getOrElse(Optional<? extends T> $this$getOrElse, Function0<? extends T> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter($this$getOrElse, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        if ($this$getOrElse.isPresent()) {
            invoke = $this$getOrElse.get();
        } else {
            invoke = defaultValue.invoke();
        }
        return invoke;
    }

    public static final <T> T getOrNull(Optional<T> $this$getOrNull) {
        Intrinsics.checkNotNullParameter($this$getOrNull, "<this>");
        return $this$getOrNull.orElse(0);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Optional<T> $this$toCollection, C destination) {
        boolean present;
        String str;
        Intrinsics.checkNotNullParameter($this$toCollection, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if ($this$toCollection.isPresent()) {
            present = $this$toCollection.get();
            Intrinsics.checkNotNullExpressionValue(present, "get(...)");
            destination.add(present);
        }
        return destination;
    }

    public static final <T> List<T> toList(Optional<? extends T> $this$toList) {
        List emptyList;
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        if ($this$toList.isPresent()) {
            emptyList = CollectionsKt.listOf($this$toList.get());
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public static final <T> Set<T> toSet(Optional<? extends T> $this$toSet) {
        Set emptySet;
        Intrinsics.checkNotNullParameter($this$toSet, "<this>");
        if ($this$toSet.isPresent()) {
            emptySet = SetsKt.setOf($this$toSet.get());
        } else {
            emptySet = SetsKt.emptySet();
        }
        return emptySet;
    }
}
