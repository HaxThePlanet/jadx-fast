package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u001c\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0014\u0008\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0008ø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\t\"\u0004\u0008\u0002\u0010\u00082\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u000c2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u00050\u000eH\u0002¢\u0006\u0002\u0008\u001c\u001a)\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\u0008\u001e\u001a\"\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0008\u001a\u001e\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080'0&\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0008*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00080&0\u0001\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006(", d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt extends kotlin.sequences.SequencesKt__SequencesJVMKt {
    private static final <T> kotlin.sequences.Sequence<T> Sequence(Function0<? extends Iterator<? extends T>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        SequencesKt__SequencesKt.Sequence.1 anon = new SequencesKt__SequencesKt.Sequence.1(iterator);
        return (Sequence)anon;
    }

    public static final <T> kotlin.sequences.Sequence<T> asSequence(Iterator<? extends T> $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        SequencesKt__SequencesKt.asSequence$$inlined.Sequence.1 anon = new SequencesKt__SequencesKt.asSequence$$inlined.Sequence.1($this$asSequence);
        return SequencesKt.constrainOnce((Sequence)anon);
    }

    public static final <T> kotlin.sequences.Sequence<T> constrainOnce(kotlin.sequences.Sequence<? extends T> $this$constrainOnce) {
        Object constrainedOnceSequence;
        Intrinsics.checkNotNullParameter($this$constrainOnce, "<this>");
        if ($this$constrainOnce instanceof ConstrainedOnceSequence) {
            constrainedOnceSequence = $this$constrainOnce;
        } else {
            constrainedOnceSequence = new ConstrainedOnceSequence($this$constrainOnce);
        }
        return constrainedOnceSequence;
    }

    public static final <T> kotlin.sequences.Sequence<T> emptySequence() {
        return (Sequence)EmptySequence.INSTANCE;
    }

    public static final <T, C, R> kotlin.sequences.Sequence<R> flatMapIndexed(kotlin.sequences.Sequence<? extends T> source, Function2<? super Integer, ? super T, ? extends C> transform, Function1<? super C, ? extends Iterator<? extends R>> iterator) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        SequencesKt__SequencesKt.flatMapIndexed.1 anon = new SequencesKt__SequencesKt.flatMapIndexed.1(source, transform, iterator, 0);
        return SequencesKt.sequence((Function2)anon);
    }

    public static final <T> kotlin.sequences.Sequence<T> flatten(kotlin.sequences.Sequence<? extends kotlin.sequences.Sequence<? extends T>> $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        return SequencesKt__SequencesKt.flatten$SequencesKt__SequencesKt($this$flatten, (Function1)SequencesKt__SequencesKt.flatten.1.INSTANCE);
    }

    private static final <T, R> kotlin.sequences.Sequence<R> flatten$SequencesKt__SequencesKt(kotlin.sequences.Sequence<? extends T> $this$flatten, Function1<? super T, ? extends Iterator<? extends R>> iterator) {
        if ($this$flatten instanceof TransformingSequence) {
            return (TransformingSequence)$this$flatten.flatten$kotlin_stdlib(iterator);
        }
        FlatteningSequence flatteningSequence = new FlatteningSequence($this$flatten, (Function1)SequencesKt__SequencesKt.flatten.3.INSTANCE, iterator);
        return (Sequence)flatteningSequence;
    }

    public static final <T> kotlin.sequences.Sequence<T> flattenSequenceOfIterable(kotlin.sequences.Sequence<? extends Iterable<? extends T>> $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        return SequencesKt__SequencesKt.flatten$SequencesKt__SequencesKt($this$flatten, (Function1)SequencesKt__SequencesKt.flatten.2.INSTANCE);
    }

    public static final <T> kotlin.sequences.Sequence<T> generateSequence(T seed, Function1<? super T, ? extends T> nextFunction) {
        Object generatorSequence;
        kotlin.sequences.SequencesKt__SequencesKt.generateSequence.2 anon;
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        if (seed == null) {
            generatorSequence = EmptySequence.INSTANCE;
        } else {
            anon = new SequencesKt__SequencesKt.generateSequence.2(seed);
            generatorSequence = new GeneratorSequence((Function0)anon, nextFunction);
        }
        return generatorSequence;
    }

    public static final <T> kotlin.sequences.Sequence<T> generateSequence(Function0<? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        SequencesKt__SequencesKt.generateSequence.1 anon = new SequencesKt__SequencesKt.generateSequence.1(nextFunction);
        GeneratorSequence generatorSequence = new GeneratorSequence(nextFunction, (Function1)anon);
        return SequencesKt.constrainOnce((Sequence)generatorSequence);
    }

    public static final <T> kotlin.sequences.Sequence<T> generateSequence(Function0<? extends T> seedFunction, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        GeneratorSequence generatorSequence = new GeneratorSequence(seedFunction, nextFunction);
        return (Sequence)generatorSequence;
    }

    public static final <T> kotlin.sequences.Sequence<T> ifEmpty(kotlin.sequences.Sequence<? extends T> $this$ifEmpty, Function0<? extends kotlin.sequences.Sequence<? extends T>> defaultValue) {
        Intrinsics.checkNotNullParameter($this$ifEmpty, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        SequencesKt__SequencesKt.ifEmpty.1 anon = new SequencesKt__SequencesKt.ifEmpty.1($this$ifEmpty, defaultValue, 0);
        return SequencesKt.sequence((Function2)anon);
    }

    private static final <T> kotlin.sequences.Sequence<T> orEmpty(kotlin.sequences.Sequence<? extends T> $this$orEmpty) {
        kotlin.sequences.Sequence emptySequence;
        if ($this$orEmpty == null) {
            emptySequence = SequencesKt.emptySequence();
        } else {
            emptySequence = $this$orEmpty;
        }
        return emptySequence;
    }

    public static final <T> kotlin.sequences.Sequence<T> sequenceOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.asSequence(elements);
    }

    public static final <T> kotlin.sequences.Sequence<T> shuffled(kotlin.sequences.Sequence<? extends T> $this$shuffled) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        return SequencesKt.shuffled($this$shuffled, (Random)Random.Default);
    }

    public static final <T> kotlin.sequences.Sequence<T> shuffled(kotlin.sequences.Sequence<? extends T> $this$shuffled, Random random) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        SequencesKt__SequencesKt.shuffled.1 anon = new SequencesKt__SequencesKt.shuffled.1($this$shuffled, random, 0);
        return SequencesKt.sequence((Function2)anon);
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(kotlin.sequences.Sequence<? extends Pair<? extends T, ? extends R>> $this$unzip) {
        Object next;
        Object second;
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = $this$unzip.iterator();
        for (Pair next : iterator) {
            arrayList.add(next.getFirst());
            arrayList2.add(next.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
