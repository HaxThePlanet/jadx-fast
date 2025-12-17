package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.tooling.PreviewUtils_androidKt;
import androidx.compose.ui.tooling.data.CallGroup;
import androidx.compose.ui.tooling.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\u0008\u0000\u0018\u00002\u00020\u0001:\u000c\u001e\u001f !\"#$%&'()B!\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0014\u0010\u0016\u001a\u00020\u00062\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014J\u000e\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\rH\u0002J\u0014\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014J\u0016\u0010\u0010\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u000e0\rH\u0002J\u0016\u0010\u001d\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u000e0\u0014H\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000c\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch;", "", "clock", "Lkotlin/Function0;", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "onSeek", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "animatedContentSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "animatedVisibilitySearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "setToSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "setToTrack", "supportedSearch", "transitionSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "animateXAsStateSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "attachAllAnimations", "slotTrees", "Landroidx/compose/ui/tooling/data/Group;", "infiniteTransitionSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "searchAny", "", "unsupportedSearch", "AnimateContentSizeSearch", "AnimateXAsStateSearch", "AnimateXAsStateSearchInfo", "AnimatedContentSearch", "AnimatedVisibilitySearch", "DecaySearch", "InfiniteTransitionSearch", "InfiniteTransitionSearchInfo", "RememberSearch", "Search", "TargetBasedSearch", "TransitionSearch", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimationSearch {

    public static final int $stable = 8;
    private final androidx.compose.ui.tooling.animation.AnimationSearch.AnimatedContentSearch animatedContentSearch;
    private final androidx.compose.ui.tooling.animation.AnimationSearch.AnimatedVisibilitySearch animatedVisibilitySearch;
    private final Function0<androidx.compose.ui.tooling.animation.PreviewAnimationClock> clock;
    private final Function0<Unit> onSeek;
    private final Set<androidx.compose.ui.tooling.animation.AnimationSearch.Search<? extends Object>> setToSearch;
    private final Set<androidx.compose.ui.tooling.animation.AnimationSearch.Search<? extends Object>> setToTrack;
    private final Set<androidx.compose.ui.tooling.animation.AnimationSearch.Search<? extends Object>> supportedSearch;
    private final androidx.compose.ui.tooling.animation.AnimationSearch.TransitionSearch transitionSearch;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008'\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\u00052\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH&J\u0014\u0010\u0012\u001a\u00020\u00102\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0013\u001a\u00020\u0005R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "T", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "animations", "", "getAnimations", "()Ljava/util/Set;", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "", "group", "hasAnimations", "track", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Search {

        public static final int $stable = 8;
        private final Set<T> animations;
        private final Function1<T, Unit> trackAnimation;
        static {
            final int i = 8;
        }

        public Search(Function1<? super T, Unit> trackAnimation) {
            super();
            this.trackAnimation = trackAnimation;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.animations = (Set)linkedHashSet;
        }

        public void addAnimations(Collection<? extends Group> groups) {
        }

        public final Set<T> getAnimations() {
            return this.animations;
        }

        public abstract boolean hasAnimation(Group group);

        public final boolean hasAnimations(Collection<? extends Group> groups) {
            boolean iterator;
            int i;
            boolean next;
            boolean it;
            int i2;
            final Object obj = groups;
            final int i3 = 0;
            i = 0;
            if (obj instanceof Collection != null && (Collection)(Iterable)obj.isEmpty()) {
                if ((Collection)obj.isEmpty()) {
                } else {
                    iterator = obj.iterator();
                    for (Object next : iterator) {
                        i2 = 0;
                    }
                }
            } else {
            }
            return i;
        }

        public final void track() {
            Object next;
            final int i = 0;
            final Iterator iterator = (Iterable)CollectionsKt.reversed((Iterable)this.animations).iterator();
            for (Object next : iterator) {
                this.trackAnimation.invoke(next);
            }
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000e", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateContentSizeSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "", "group", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimateContentSizeSearch extends androidx.compose.ui.tooling.animation.AnimationSearch.Search<Object> {

        public static final int $stable;
        static {
        }

        public AnimateContentSizeSearch(Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
        }

        public void addAnimations(Collection<? extends Group> groups) {
            Object next;
            int i;
            Iterator iterator2;
            Object next2;
            boolean modifierInfo;
            Object obj;
            int iterator;
            boolean empty;
            Object obj2;
            int i2;
            Modifier modifier;
            androidx.compose.ui.tooling.animation.AnimationSearch.AnimateContentSizeSearch.addAnimations.2.1.1 anon;
            int i4 = 0;
            ArrayList arrayList = new ArrayList();
            i = 0;
            iterator2 = (Iterable)groups.iterator();
            while (iterator2.hasNext()) {
                next2 = iterator2.next();
                iterator = 0;
                if (!(Collection)(Group)next2.getModifierInfo().isEmpty()) {
                }
                (Collection)arrayList.add(next2);
            }
            int i3 = 0;
            Iterator iterator3 = (Iterable)(List)arrayList.iterator();
            for (Object next : iterator3) {
                iterator2 = null;
                obj = 0;
                iterator = (Iterable)(Group)next.getModifierInfo().iterator();
                for (Object empty : iterator) {
                    i2 = 0;
                    anon = new AnimationSearch.AnimateContentSizeSearch.addAnimations.2.1.1(this);
                    (ModifierInfo)empty.getModifier().any((Function1)anon);
                }
                i2 = 0;
                anon = new AnimationSearch.AnimateContentSizeSearch.addAnimations.2.1.1(this);
                (ModifierInfo)iterator.next().getModifier().any((Function1)anon);
            }
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch$Search
        public boolean hasAnimation(Group group) {
            boolean $this$any$iv;
            int i;
            int i3;
            boolean iterator;
            int i4;
            Object next;
            boolean it;
            int i2;
            Modifier modifier;
            androidx.compose.ui.tooling.animation.AnimationSearch.AnimateContentSizeSearch.hasAnimation.1.1 iNSTANCE;
            i = 0;
            if (!(Collection)group.getModifierInfo().isEmpty()) {
                List modifierInfo2 = group.getModifierInfo();
                i3 = 0;
                i4 = 1;
                if (modifierInfo2 instanceof Collection != null && (Collection)(Iterable)modifierInfo2.isEmpty()) {
                    if ((Collection)modifierInfo2.isEmpty()) {
                        $this$any$iv = i;
                    } else {
                        iterator = modifierInfo2.iterator();
                        for (Object next : iterator) {
                            i2 = 0;
                        }
                        $this$any$iv = i;
                    }
                } else {
                }
                if ($this$any$iv != 0) {
                    i = i4;
                } else {
                }
            } else {
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u0010\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016J$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c\"\u0004\u0008\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0012\"\u0004\u0008\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J.\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000e0\u00020\u0014\"\u0004\u0008\u0000\u0010\r2\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0002J&\u0010\u0015\u001a\u0012\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0017\u0018\u00010\u0016\"\u0004\u0008\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002¨\u0006\u001b", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "findAnimatable", "Landroidx/compose/animation/core/Animatable;", "T", "Landroidx/compose/animation/core/AnimationVector;", "group", "Landroidx/compose/ui/tooling/data/CallGroup;", "findAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "findAnimations", "", "findToolingOverride", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/State;", "hasAnimation", "", "toAnimationGroup", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimateXAsStateSearch extends androidx.compose.ui.tooling.animation.AnimationSearch.Search<androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo<?, ?>> {

        public static final int $stable;
        static {
        }

        public AnimateXAsStateSearch(Function1<? super androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo<?, ?>, Unit> trackAnimation) {
            super(trackAnimation);
        }

        private final <T> Animatable<T, AnimationVector> findAnimatable(CallGroup group) {
            Group $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2;
            ArrayList it$iv$iv$iv$iv;
            ArrayList list;
            Object rememberCalls$iv$iv2;
            boolean $this$findRememberedData$iv;
            int i5;
            androidx.compose.ui.tooling.animation.AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1 $i$f$findRememberedData;
            boolean $this$firstOrNull$iv$iv;
            int i3;
            Collection $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv;
            boolean $this$findRememberedData$iv$iv;
            Object element$iv$iv;
            Object data$iv$iv;
            boolean it$iv;
            int i2;
            Iterator iterator2;
            boolean next5;
            Object next3;
            boolean next;
            Object obj;
            int i;
            Object obj3;
            int iNSTANCE;
            Object $this$firstOrNull$iv$iv$iv;
            int i6;
            Iterator $this$firstOrNull$iv$iv$iv2;
            Object next4;
            Object iterator;
            int next2;
            Object obj2;
            int i4;
            ArrayList rememberCalls$iv$iv;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2 = group;
            i5 = 0;
            i3 = 0;
            Iterator iterator3 = (Iterable)(Group)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2.getData().iterator();
            for (Object element$iv$iv : iterator3) {
                i2 = 0;
            }
            element$iv$iv = 0;
            if (!element$iv$iv instanceof Animatable) {
                element$iv$iv = 0;
            }
            if ((Animatable)element$iv$iv != null) {
                i3 = 0;
                if (CollectionsKt.listOf((Animatable)element$iv$iv) == null) {
                    $this$firstOrNull$iv$iv = CollectionsKt.emptyList();
                }
            } else {
            }
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv = $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2.getChildren();
            int i7 = 0;
            int i10 = 0;
            ArrayList arrayList3 = new ArrayList();
            int i13 = 0;
            int i16 = 0;
            iterator2 = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv.iterator();
            for (Object next3 : iterator2) {
                i = 0;
                iNSTANCE = 0;
                i6 = 0;
                $this$firstOrNull$iv$iv$iv2 = (Iterable)(Group)next3.getData().iterator();
                for (Object next4 : $this$firstOrNull$iv$iv$iv2) {
                    next2 = 0;
                }
                data$iv$iv = 0;
                if (!data$iv$iv instanceof Animatable) {
                }
                if ((Animatable)data$iv$iv != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2 = $this$firstOrNull$iv$iv$iv;
                $this$findRememberedData$iv = 0;
                (Collection)arrayList3.add((Animatable)data$iv$iv);
                data$iv$iv = 0;
                next4 = $this$firstOrNull$iv$iv$iv2.next();
                next2 = 0;
                if (obj5 instanceof Animatable) {
                } else {
                }
                data$iv$iv = next4;
            }
            Object $this$findRememberedData$iv2 = $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2;
            it$iv$iv$iv$iv = arrayList3;
            int i8 = 0;
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i14 = 0;
            Iterator iterator4 = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv.iterator();
            while (iterator4.hasNext()) {
                obj = 0;
                obj3 = 0;
                Group it$iv$iv = PreviewUtils_androidKt.firstOrNull((Group)iterator4.next(), (Function1)AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1.INSTANCE);
                if (it$iv$iv != null) {
                }
                it$iv$iv$iv$iv = i;
                i5 = i6;
                $i$f$findRememberedData = 0;
                (Collection)arrayList.add(it$iv$iv);
            }
            int i17 = i5;
            int i9 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            int i15 = 0;
            Iterator iterator5 = (Iterable)(List)arrayList.iterator();
            for (Object next5 : iterator5) {
                obj = 0;
                iNSTANCE = 0;
                next4 = 0;
                iterator = (Iterable)(Group)next5.getData().iterator();
                for (Object next2 : iterator) {
                    i4 = 0;
                    list = rememberCalls$iv$iv;
                }
                rememberCalls$iv$iv = list;
                rememberCalls$iv$iv2 = 0;
                if (!rememberCalls$iv$iv2 instanceof Animatable) {
                }
                if ((Animatable)rememberCalls$iv$iv2 != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv = $this$firstOrNull$iv$iv$iv2;
                list = rememberCalls$iv$iv;
                $this$findRememberedData$iv$iv = 0;
                (Collection)arrayList2.add((Animatable)rememberCalls$iv$iv2);
                rememberCalls$iv$iv2 = 0;
                next2 = iterator.next();
                i4 = 0;
                if (rememberCalls$iv$iv3 instanceof Animatable) {
                } else {
                }
                list = rememberCalls$iv$iv;
                rememberCalls$iv$iv2 = next2;
            }
            ArrayList rememberCalls$iv$iv5 = list;
            return (Animatable)CollectionsKt.firstOrNull(CollectionsKt.plus((Collection)$this$firstOrNull$iv$iv, (Iterable)CollectionsKt.plus((Collection)it$iv$iv$iv$iv, (Iterable)(List)arrayList2)));
        }

        private final <T> AnimationSpec<T> findAnimationSpec(CallGroup group) {
            Object next4;
            boolean it;
            Iterator iterator;
            boolean next;
            boolean next2;
            boolean next3;
            int next5;
            boolean it2;
            String it3;
            String str;
            int i4 = 0;
            ArrayList arrayList3 = new ArrayList();
            int i7 = 0;
            Iterator iterator2 = (Iterable)group.getChildren().iterator();
            while (iterator2.hasNext()) {
                next4 = iterator2.next();
                next5 = 0;
                if (Intrinsics.areEqual((Group)next4.getName(), "rememberUpdatedState")) {
                }
                (Collection)arrayList3.add(next4);
            }
            int i6 = 0;
            ArrayList arrayList6 = new ArrayList();
            int i13 = 0;
            iterator = (Iterable)arrayList3.iterator();
            for (Object next5 : iterator) {
                str = 0;
                CollectionsKt.addAll((Collection)arrayList6, (Iterable)(Group)next5.getChildren());
            }
            int i5 = 0;
            ArrayList arrayList4 = new ArrayList();
            int i9 = 0;
            Iterator iterator3 = (Iterable)CollectionsKt.plus((Collection)(List)arrayList3, (Iterable)(List)arrayList6).iterator();
            for (Object iterator : iterator3) {
                it3 = 0;
                CollectionsKt.addAll((Collection)arrayList4, (Iterable)(Group)iterator.getData());
            }
            int i = 0;
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            Iterator iterator4 = (Iterable)(List)arrayList4.iterator();
            while (iterator4.hasNext()) {
                next = iterator4.next();
                if (next instanceof State) {
                }
                (Collection)arrayList.add(next);
            }
            int i2 = 0;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)(List)arrayList, 10));
            int i11 = 0;
            Iterator iterator5 = arrayList.iterator();
            for (Object next2 : iterator5) {
                it3 = 0;
                (Collection)arrayList5.add((State)next2.getValue());
            }
            int i3 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            Iterator iterator6 = (Iterable)(List)arrayList5.iterator();
            while (iterator6.hasNext()) {
                next3 = iterator6.next();
                if (next3 instanceof AnimationSpec) {
                }
                (Collection)arrayList2.add(next3);
            }
            return (AnimationSpec)CollectionsKt.firstOrNull((List)arrayList2);
        }

        private final <T> List<androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo<T, AnimationVector>> findAnimations(Collection<? extends Group> groups) {
            androidx.compose.ui.tooling.animation.ToolingState it$iv$iv;
            int i4;
            int toolingOverride;
            ArrayList arrayList;
            Object next;
            boolean next2;
            Object obj;
            int i;
            CallGroup it;
            int i3;
            Animatable animatable;
            AnimationSpec animationSpec;
            int i2;
            androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo animateXAsStateSearchInfo;
            ArrayList $this$mapNotNull$iv;
            MutableState toolingOverride2;
            int i5 = 0;
            arrayList = new ArrayList();
            int i6 = 0;
            int i8 = 0;
            Iterator iterator = (Iterable)groups.iterator();
            while (iterator.hasNext()) {
                i = 0;
                i3 = 0;
                it = this.toAnimationGroup((Group)iterator.next());
                if (it != null) {
                }
                i3 = 0;
                (Collection)arrayList.add(it);
            }
            i4 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i7 = 0;
            int i9 = 0;
            Iterator iterator2 = (Iterable)(List)arrayList.iterator();
            while (iterator2.hasNext()) {
                i = 0;
                it = obj;
                i3 = 0;
                animatable = it$iv$iv.findAnimatable((CallGroup)it);
                animationSpec = it$iv$iv.findAnimationSpec(it);
                toolingOverride = it$iv$iv.findToolingOverride((Group)it);
                animateXAsStateSearchInfo = 0;
                if (animatable != null && animationSpec != null && toolingOverride != null) {
                } else {
                }
                toolingOverride2 = toolingOverride;
                $this$mapNotNull$iv = arrayList;
                if (animateXAsStateSearchInfo != null) {
                }
                it$iv$iv = this;
                i4 = i2;
                arrayList = $this$mapNotNull$iv;
                toolingOverride = 0;
                (Collection)arrayList2.add(animateXAsStateSearchInfo);
                if (animationSpec != null) {
                } else {
                }
                if (toolingOverride != null) {
                } else {
                }
                if (toolingOverride.getValue() == null) {
                } else {
                }
                $this$mapNotNull$iv = arrayList;
                arrayList = toolingOverride.getValue();
                toolingOverride2 = toolingOverride;
                if (arrayList instanceof ToolingState) {
                }
                if (animateXAsStateSearchInfo == 0) {
                } else {
                }
                toolingOverride = animateXAsStateSearchInfo;
                it$iv$iv = new AnimationSearch.AnimateXAsStateSearchInfo(animatable, animationSpec, toolingOverride);
                animateXAsStateSearchInfo = it$iv$iv;
                toolingOverride = new ToolingState(animatable.getValue());
                animateXAsStateSearchInfo = arrayList;
                $this$mapNotNull$iv = arrayList;
                it$iv$iv = new ToolingState(animatable.getValue());
                toolingOverride.setValue(it$iv$iv);
            }
            return (List)arrayList2;
        }

        private final <T> MutableState<State<T>> findToolingOverride(Group group) {
            Object $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv;
            ArrayList it$iv$iv$iv$iv;
            ArrayList list;
            Object rememberCalls$iv$iv2;
            boolean $this$findRememberedData$iv;
            int i6;
            androidx.compose.ui.tooling.animation.AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1 $i$f$findRememberedData;
            boolean $this$firstOrNull$iv$iv;
            int i5;
            Collection $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2;
            boolean $this$findRememberedData$iv$iv;
            Object element$iv$iv;
            Object data$iv$iv;
            boolean it$iv;
            int i;
            Iterator iterator;
            boolean next;
            Object next2;
            boolean next4;
            Object obj3;
            int i3;
            Object obj2;
            int iNSTANCE;
            Object $this$firstOrNull$iv$iv$iv2;
            int i4;
            Iterator $this$firstOrNull$iv$iv$iv;
            Object next5;
            Object iterator2;
            int next3;
            Object obj;
            int i2;
            ArrayList rememberCalls$iv$iv;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv = group;
            i6 = 0;
            i5 = 0;
            Iterator iterator3 = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv.getData().iterator();
            for (Object element$iv$iv : iterator3) {
                i = 0;
            }
            element$iv$iv = 0;
            if (!element$iv$iv instanceof MutableState) {
                element$iv$iv = 0;
            }
            if ((MutableState)element$iv$iv != null) {
                i5 = 0;
                if (CollectionsKt.listOf((MutableState)element$iv$iv) == null) {
                    $this$firstOrNull$iv$iv = CollectionsKt.emptyList();
                }
            } else {
            }
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2 = $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv.getChildren();
            int i7 = 0;
            int i10 = 0;
            ArrayList arrayList3 = new ArrayList();
            int i13 = 0;
            int i16 = 0;
            iterator = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2.iterator();
            for (Object next2 : iterator) {
                i3 = 0;
                iNSTANCE = 0;
                i4 = 0;
                $this$firstOrNull$iv$iv$iv = (Iterable)(Group)next2.getData().iterator();
                for (Object next5 : $this$firstOrNull$iv$iv$iv) {
                    next3 = 0;
                }
                data$iv$iv = 0;
                if (!data$iv$iv instanceof MutableState) {
                }
                if ((MutableState)data$iv$iv != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv = $this$firstOrNull$iv$iv$iv2;
                $this$findRememberedData$iv = 0;
                (Collection)arrayList3.add((MutableState)data$iv$iv);
                data$iv$iv = 0;
                next5 = $this$firstOrNull$iv$iv$iv.next();
                next3 = 0;
                if (obj5 instanceof MutableState) {
                } else {
                }
                data$iv$iv = next5;
            }
            Object $this$findRememberedData$iv2 = $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv;
            it$iv$iv$iv$iv = arrayList3;
            int i8 = 0;
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i14 = 0;
            Iterator iterator4 = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2.iterator();
            while (iterator4.hasNext()) {
                obj3 = 0;
                obj2 = 0;
                Group it$iv$iv = PreviewUtils_androidKt.firstOrNull((Group)iterator4.next(), (Function1)AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1.INSTANCE);
                if (it$iv$iv != null) {
                }
                it$iv$iv$iv$iv = i3;
                i6 = i4;
                $i$f$findRememberedData = 0;
                (Collection)arrayList.add(it$iv$iv);
            }
            int i17 = i6;
            int i9 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            int i15 = 0;
            Iterator iterator5 = (Iterable)(List)arrayList.iterator();
            for (Object next : iterator5) {
                obj3 = 0;
                iNSTANCE = 0;
                next5 = 0;
                iterator2 = (Iterable)(Group)next.getData().iterator();
                for (Object next3 : iterator2) {
                    i2 = 0;
                    list = rememberCalls$iv$iv;
                }
                rememberCalls$iv$iv = list;
                rememberCalls$iv$iv2 = 0;
                if (!rememberCalls$iv$iv2 instanceof MutableState) {
                }
                if ((MutableState)rememberCalls$iv$iv2 != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv$iv2 = $this$firstOrNull$iv$iv$iv;
                list = rememberCalls$iv$iv;
                $this$findRememberedData$iv$iv = 0;
                (Collection)arrayList2.add((MutableState)rememberCalls$iv$iv2);
                rememberCalls$iv$iv2 = 0;
                next3 = iterator2.next();
                i2 = 0;
                if (rememberCalls$iv$iv3 instanceof MutableState) {
                } else {
                }
                list = rememberCalls$iv$iv;
                rememberCalls$iv$iv2 = next3;
            }
            ArrayList rememberCalls$iv$iv5 = list;
            return (MutableState)CollectionsKt.firstOrNull(CollectionsKt.plus((Collection)$this$firstOrNull$iv$iv, (Iterable)CollectionsKt.plus((Collection)it$iv$iv$iv$iv, (Iterable)(List)arrayList2)));
        }

        private final CallGroup toAnimationGroup(Group group) {
            int it;
            int i2;
            androidx.compose.ui.tooling.data.SourceLocation location;
            int i;
            String str;
            int i3 = group;
            int i4 = 0;
            if (i3.getLocation() != null && Intrinsics.areEqual(i3.getName(), "animateValueAsState")) {
                i = Intrinsics.areEqual(i3.getName(), "animateValueAsState") ? 1 : 0;
            } else {
            }
            i2 = i != 0 ? group : it;
            i = 0;
            if (i2 != 0 && i2 instanceof CallGroup) {
                i = 0;
                if (i2 instanceof CallGroup) {
                    it = i2;
                }
            }
            return it;
        }

        public void addAnimations(Collection<? extends Group> groups) {
            getAnimations().addAll((Collection)findAnimations(groups));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch$Search
        public boolean hasAnimation(Group group) {
            int i;
            int i2;
            Object toolingOverride;
            final CallGroup animationGroup = toAnimationGroup(group);
            i = 0;
            if (animationGroup != null) {
                i2 = 0;
                if (findAnimatable(animationGroup) != null && findAnimationSpec(animationGroup) != null && findToolingOverride((Group)animationGroup) != null) {
                    if (findAnimationSpec(animationGroup) != null) {
                        if (findToolingOverride((Group)animationGroup) != null) {
                            i = 1;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B5\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008HÆ\u0003J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\nHÆ\u0003JK\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0008\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00082\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001d", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "animatable", "Landroidx/compose/animation/core/Animatable;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimateXAsStateSearchInfo {

        public static final int $stable = 8;
        private final Animatable<T, V> animatable;
        private final AnimationSpec<T> animationSpec;
        private final androidx.compose.ui.tooling.animation.ToolingState<T> toolingState;
        static {
            final int i = 8;
        }

        public AnimateXAsStateSearchInfo(Animatable<T, V> animatable, AnimationSpec<T> animationSpec, androidx.compose.ui.tooling.animation.ToolingState<T> toolingState) {
            super();
            this.animatable = animatable;
            this.animationSpec = animationSpec;
            this.toolingState = toolingState;
        }

        public static androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo copy$default(androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo animationSearch$AnimateXAsStateSearchInfo, Animatable animatable2, AnimationSpec animationSpec3, androidx.compose.ui.tooling.animation.ToolingState toolingState4, int i5, Object object6) {
            Animatable obj1;
            AnimationSpec obj2;
            androidx.compose.ui.tooling.animation.ToolingState obj3;
            if (i5 & 1 != 0) {
                obj1 = animateXAsStateSearchInfo.animatable;
            }
            if (i5 & 2 != 0) {
                obj2 = animateXAsStateSearchInfo.animationSpec;
            }
            if (i5 &= 4 != 0) {
                obj3 = animateXAsStateSearchInfo.toolingState;
            }
            return animateXAsStateSearchInfo.copy(obj1, obj2, obj3);
        }

        public final Animatable<T, V> component1() {
            return this.animatable;
        }

        public final AnimationSpec<T> component2() {
            return this.animationSpec;
        }

        public final androidx.compose.ui.tooling.animation.ToolingState<T> component3() {
            return this.toolingState;
        }

        public final androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo<T, V> copy(Animatable<T, V> animatable, AnimationSpec<T> animationSpec2, androidx.compose.ui.tooling.animation.ToolingState<T> toolingState3) {
            AnimationSearch.AnimateXAsStateSearchInfo animateXAsStateSearchInfo = new AnimationSearch.AnimateXAsStateSearchInfo(animatable, animationSpec2, toolingState3);
            return animateXAsStateSearchInfo;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AnimationSearch.AnimateXAsStateSearchInfo) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.animatable, obj.animatable)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.animationSpec, obj.animationSpec)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.toolingState, obj.toolingState)) {
                return i2;
            }
            return i;
        }

        public final Animatable<T, V> getAnimatable() {
            return this.animatable;
        }

        public final AnimationSpec<T> getAnimationSpec() {
            return this.animationSpec;
        }

        public final androidx.compose.ui.tooling.animation.ToolingState<T> getToolingState() {
            return this.toolingState;
        }

        public int hashCode() {
            return i2 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("AnimateXAsStateSearchInfo(animatable=").append(this.animatable).append(", animationSpec=").append(this.animationSpec).append(", toolingState=").append(this.toolingState).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH\u0002¨\u0006\u000f", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "", "group", "toAnimationGroup", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimatedContentSearch extends androidx.compose.ui.tooling.animation.AnimationSearch.Search<Transition<?>> {

        public static final int $stable;
        static {
        }

        public AnimatedContentSearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
        }

        private final Group toAnimationGroup(Group group) {
            int it;
            int i4;
            androidx.compose.ui.tooling.data.SourceLocation location;
            int i;
            String children;
            int i2;
            Iterator iterator;
            boolean next;
            boolean updateTransitionCall;
            int i3;
            String name;
            String str;
            int i5 = group;
            int i6 = 0;
            if (group.getLocation() != null && Intrinsics.areEqual(group.getName(), "AnimatedContent")) {
                i = Intrinsics.areEqual(group.getName(), "AnimatedContent") ? 1 : 0;
            } else {
            }
            i4 = i != 0 ? group : it;
            if (i4 != 0) {
                i = 0;
                i2 = 0;
                iterator = (Iterable)i4.getChildren().iterator();
                for (Object next : iterator) {
                    i3 = 0;
                }
            }
            return it;
        }

        public void addAnimations(Collection<? extends Group> groups) {
            int $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv;
            ArrayList it$iv$iv$iv;
            ArrayList list;
            Object rememberCalls$iv;
            boolean $i$f$findRememberedData;
            ArrayList $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2;
            boolean $this$findRememberedData$iv;
            Object next3;
            Object obj2;
            int next;
            boolean next4;
            Group it;
            int i4;
            Object obj7;
            int i2;
            Object obj;
            int iNSTANCE;
            int $this$firstOrNull$iv$iv;
            int i;
            Iterator $this$firstOrNull$iv$iv2;
            Object next5;
            Object iterator;
            int next2;
            Object obj3;
            int i3;
            ArrayList rememberCalls$iv2;
            int i5 = 0;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2 = new ArrayList();
            int i8 = 0;
            int i10 = 0;
            Iterator iterator2 = (Iterable)groups.iterator();
            while (iterator2.hasNext()) {
                next = 0;
                i4 = 0;
                it = this.toAnimationGroup((Group)iterator2.next());
                if (it != null) {
                }
                i4 = 0;
                (Collection)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2.add(it);
            }
            Object obj8 = this;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = 0;
            int i6 = 0;
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i14 = 0;
            Iterator iterator3 = (Iterable)(Collection)(List)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2.iterator();
            for (Object next : iterator3) {
                i2 = 0;
                iNSTANCE = 0;
                i = 0;
                $this$firstOrNull$iv$iv2 = (Iterable)(Group)next.getData().iterator();
                for (Object next5 : $this$firstOrNull$iv$iv2) {
                    next2 = 0;
                }
                it = 0;
                if (!it instanceof Transition) {
                }
                if ((Transition)it != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = $this$firstOrNull$iv$iv;
                $i$f$findRememberedData = 0;
                (Collection)arrayList.add((Transition)it);
                it = 0;
                next5 = $this$firstOrNull$iv$iv2.next();
                next2 = 0;
                if (obj6 instanceof Transition) {
                } else {
                }
                it = next5;
            }
            int $i$f$findRememberedData2 = $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv;
            it$iv$iv$iv = arrayList;
            int i7 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            int i15 = 0;
            Iterator iterator4 = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2.iterator();
            while (iterator4.hasNext()) {
                i4 = 0;
                obj = 0;
                Group firstOrNull = PreviewUtils_androidKt.firstOrNull((Group)iterator4.next(), (Function1)AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1.INSTANCE);
                if (firstOrNull != null) {
                }
                it$iv$iv$iv = i;
                i2 = 0;
                (Collection)arrayList2.add(firstOrNull);
            }
            int i9 = 0;
            ArrayList arrayList3 = new ArrayList();
            int i13 = 0;
            int i16 = 0;
            Iterator iterator5 = (Iterable)(List)arrayList2.iterator();
            for (Object it : iterator5) {
                i2 = 0;
                iNSTANCE = 0;
                next5 = 0;
                iterator = (Iterable)(Group)it.getData().iterator();
                for (Object next2 : iterator) {
                    i3 = 0;
                    list = rememberCalls$iv2;
                }
                rememberCalls$iv2 = list;
                rememberCalls$iv = 0;
                if (!rememberCalls$iv instanceof Transition) {
                }
                if ((Transition)rememberCalls$iv != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2 = $this$firstOrNull$iv$iv2;
                list = rememberCalls$iv2;
                $this$findRememberedData$iv = 0;
                (Collection)arrayList3.add((Transition)rememberCalls$iv);
                rememberCalls$iv = 0;
                next2 = iterator.next();
                i3 = 0;
                if (rememberCalls$iv3 instanceof Transition) {
                } else {
                }
                list = rememberCalls$iv2;
                rememberCalls$iv = next2;
            }
            ArrayList rememberCalls$iv5 = list;
            getAnimations().addAll((Collection)CollectionsKt.plus((Collection)it$iv$iv$iv, (Iterable)(List)arrayList3));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch$Search
        public boolean hasAnimation(Group group) {
            int i;
            i = toAnimationGroup(group) != null ? 1 : 0;
            return i;
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH\u0002¨\u0006\u000f", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "", "group", "toAnimationGroup", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimatedVisibilitySearch extends androidx.compose.ui.tooling.animation.AnimationSearch.Search<Transition<?>> {

        public static final int $stable;
        static {
        }

        public AnimatedVisibilitySearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
        }

        private final Group toAnimationGroup(Group group) {
            int it;
            int i2;
            androidx.compose.ui.tooling.data.SourceLocation location;
            int i3;
            String children;
            int i4;
            Iterator iterator;
            boolean next;
            boolean updateTransitionCall;
            int i;
            String name;
            String str;
            int i5 = group;
            int i6 = 0;
            if (i5.getLocation() != null && Intrinsics.areEqual(i5.getName(), "AnimatedVisibility")) {
                i3 = Intrinsics.areEqual(i5.getName(), "AnimatedVisibility") ? 1 : 0;
            } else {
            }
            i2 = i3 != 0 ? group : it;
            if (i2 != 0) {
                i3 = 0;
                i4 = 0;
                iterator = (Iterable)i2.getChildren().iterator();
                for (Object next : iterator) {
                    i = 0;
                }
            }
            return it;
        }

        public void addAnimations(Collection<? extends Group> groups) {
            int $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2;
            ArrayList it$iv$iv$iv;
            ArrayList list;
            Object rememberCalls$iv2;
            boolean $i$f$findRememberedData;
            ArrayList $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv;
            boolean $this$findRememberedData$iv;
            Object next2;
            Object obj;
            int next4;
            boolean next;
            Group it;
            int i4;
            Object obj7;
            int i3;
            Object obj2;
            int iNSTANCE;
            int $this$firstOrNull$iv$iv2;
            int i2;
            Iterator $this$firstOrNull$iv$iv;
            Object next5;
            Object iterator;
            int next3;
            Object obj3;
            int i;
            ArrayList rememberCalls$iv;
            int i5 = 0;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = new ArrayList();
            int i8 = 0;
            int i10 = 0;
            Iterator iterator2 = (Iterable)groups.iterator();
            while (iterator2.hasNext()) {
                next4 = 0;
                i4 = 0;
                it = this.toAnimationGroup((Group)iterator2.next());
                if (it != null) {
                }
                i4 = 0;
                (Collection)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv.add(it);
            }
            Object obj8 = this;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2 = 0;
            int i6 = 0;
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i14 = 0;
            Iterator iterator3 = (Iterable)(Collection)(List)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv.iterator();
            for (Object next4 : iterator3) {
                i3 = 0;
                iNSTANCE = 0;
                i2 = 0;
                $this$firstOrNull$iv$iv = (Iterable)(Group)next4.getData().iterator();
                for (Object next5 : $this$firstOrNull$iv$iv) {
                    next3 = 0;
                }
                it = 0;
                if (!it instanceof Transition) {
                }
                if ((Transition)it != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2 = $this$firstOrNull$iv$iv2;
                $i$f$findRememberedData = 0;
                (Collection)arrayList.add((Transition)it);
                it = 0;
                next5 = $this$firstOrNull$iv$iv.next();
                next3 = 0;
                if (obj6 instanceof Transition) {
                } else {
                }
                it = next5;
            }
            int $i$f$findRememberedData2 = $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2;
            it$iv$iv$iv = arrayList;
            int i7 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            int i15 = 0;
            Iterator iterator4 = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv.iterator();
            while (iterator4.hasNext()) {
                i4 = 0;
                obj2 = 0;
                Group firstOrNull = PreviewUtils_androidKt.firstOrNull((Group)iterator4.next(), (Function1)AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1.INSTANCE);
                if (firstOrNull != null) {
                }
                it$iv$iv$iv = i2;
                i3 = 0;
                (Collection)arrayList2.add(firstOrNull);
            }
            int i9 = 0;
            ArrayList arrayList3 = new ArrayList();
            int i13 = 0;
            int i16 = 0;
            Iterator iterator5 = (Iterable)(List)arrayList2.iterator();
            for (Object it : iterator5) {
                i3 = 0;
                iNSTANCE = 0;
                next5 = 0;
                iterator = (Iterable)(Group)it.getData().iterator();
                for (Object next3 : iterator) {
                    i = 0;
                    list = rememberCalls$iv;
                }
                rememberCalls$iv = list;
                rememberCalls$iv2 = 0;
                if (!rememberCalls$iv2 instanceof Transition) {
                }
                if ((Transition)rememberCalls$iv2 != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = $this$firstOrNull$iv$iv;
                list = rememberCalls$iv;
                $this$findRememberedData$iv = 0;
                (Collection)arrayList3.add((Transition)rememberCalls$iv2);
                rememberCalls$iv2 = 0;
                next3 = iterator.next();
                i = 0;
                if (rememberCalls$iv3 instanceof Transition) {
                } else {
                }
                list = rememberCalls$iv;
                rememberCalls$iv2 = next3;
            }
            ArrayList rememberCalls$iv5 = list;
            getAnimations().addAll((Collection)CollectionsKt.plus((Collection)it$iv$iv$iv, (Iterable)(List)arrayList3));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch$Search
        public boolean hasAnimation(Group group) {
            int i;
            i = toAnimationGroup(group) != null ? 1 : 0;
            return i;
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\u0008\u0017\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00082\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J+\u0010\u0011\u001a\u0004\u0018\u0001H\u0001\"\u0008\u0008\u0001\u0010\u0001*\u00020\u0002*\u00020\r2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0012J0\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0013\"\u0008\u0008\u0001\u0010\u0001*\u00020\u0002*\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "T", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "clazz", "Lkotlin/reflect/KClass;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "", "group", "findRememberCallWithType", "(Landroidx/compose/ui/tooling/data/Group;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class RememberSearch extends androidx.compose.ui.tooling.animation.AnimationSearch.Search<T> {

        public static final int $stable = 8;
        private final KClass<T> clazz;
        static {
            final int i = 8;
        }

        public RememberSearch(KClass<T> clazz, Function1<? super T, Unit> trackAnimation) {
            super(trackAnimation);
            this.clazz = clazz;
        }

        private final <T> T findRememberCallWithType(Group $this$findRememberCallWithType, KClass<T> clazz) {
            Object next;
            boolean equal;
            int kotlinClass;
            Object obj;
            int i;
            Class class;
            final int i2 = 0;
            final Iterator iterator = (Iterable)$this$findRememberCallWithType.getData().iterator();
            kotlinClass = 0;
            while (iterator.hasNext()) {
                next = iterator.next();
                obj = next;
                i = 0;
                class = obj.getClass();
                if (obj != null && class != null) {
                }
                kotlinClass = 0;
                class = obj.getClass();
                if (class != null) {
                }
                kotlinClass = JvmClassMappingKt.getKotlinClass(class);
            }
            return KClasses.safeCast(clazz, kotlinClass);
        }

        private final <T> List<T> findRememberCallWithType(Collection<? extends Group> $this$findRememberCallWithType, KClass<T> clazz) {
            Object next;
            Object obj;
            int i2;
            Object it;
            int i;
            final int i3 = 0;
            ArrayList arrayList = new ArrayList();
            final int i4 = 0;
            final int i5 = 0;
            final Iterator iterator = (Iterable)$this$findRememberCallWithType.iterator();
            while (iterator.hasNext()) {
                i2 = 0;
                i = 0;
                it = findRememberCallWithType((Group)iterator.next(), clazz);
                if (it != null) {
                }
                i = 0;
                (Collection)arrayList.add(it);
            }
            return (List)arrayList;
        }

        public void addAnimations(Collection<? extends Group> groups) {
            Object next;
            Object obj;
            int i;
            int i2;
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            final int i4 = 0;
            final Iterator iterator = (Iterable)groups.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                i = 0;
                if ((Group)next.getLocation() != null) {
                } else {
                }
                i2 = 0;
                if (i2 != 0) {
                }
                (Collection)arrayList.add(next);
                i2 = 1;
            }
            getAnimations().addAll((Collection)CollectionsKt.toSet((Iterable)findRememberCallWithType((Collection)(List)arrayList, this.clazz)));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch$Search
        public boolean hasAnimation(Group group) {
            Object rememberCallWithType;
            int i;
            if (group.getLocation() != null && findRememberCallWithType(group, this.clazz) != null) {
                i = findRememberCallWithType(group, this.clazz) != null ? 1 : 0;
            } else {
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u0010\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$DecaySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/DecayAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DecaySearch extends androidx.compose.ui.tooling.animation.AnimationSearch.RememberSearch<DecayAnimation<?, ?>> {

        public static final int $stable;
        static {
        }

        public DecaySearch(Function1<? super DecayAnimation<?, ?>, Unit> trackAnimation) {
            super(Reflection.getOrCreateKotlinClass(DecayAnimation.class), trackAnimation);
        }
    }

    @Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000c2\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0002J \u0010\r\u001a\u0012\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\nH\u0002¨\u0006\u0016", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "findAnimations", "", "findToolingOverride", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/State;", "", "group", "hasAnimation", "", "toAnimationGroup", "Landroidx/compose/ui/tooling/data/CallGroup;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InfiniteTransitionSearch extends androidx.compose.ui.tooling.animation.AnimationSearch.Search<androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo> {

        public static final int $stable;
        static {
        }

        public InfiniteTransitionSearch(Function1<? super androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo, Unit> trackAnimation) {
            super(trackAnimation);
        }

        private final List<androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo> findAnimations(Collection<? extends Group> groups) {
            int it$iv$iv;
            List plus;
            int dataToSearch$iv2;
            ArrayList arrayList;
            MutableState toolingOverride;
            ArrayList list$iv$iv$iv;
            int infiniteTransitionSearchInfo;
            Object toolingState2;
            Object next2;
            boolean next;
            Object obj;
            int i;
            CallGroup it;
            int i2;
            boolean toolingState;
            int valueOf;
            int i5;
            int i3;
            Iterator iterator;
            int next3;
            Collection collection;
            ArrayList list;
            int i4;
            Iterator iterator2;
            boolean dataToSearch$iv;
            Collection it$iv;
            ArrayList $i$a$FlatMapAnimationSearch_androidKt$findData$dataToSearch$2$iv;
            final Object obj2 = this;
            int i6 = 0;
            arrayList = new ArrayList();
            int i7 = 0;
            int i9 = 0;
            Iterator iterator3 = (Iterable)groups.iterator();
            while (iterator3.hasNext()) {
                i = 0;
                i2 = 0;
                it = obj2.toAnimationGroup((Group)iterator3.next());
                if (it != null) {
                }
                i2 = 0;
                (Collection)arrayList.add(it);
            }
            it$iv$iv = 0;
            ArrayList arrayList2 = new ArrayList();
            int i8 = 0;
            int i10 = 0;
            Iterator iterator4 = (Iterable)(List)arrayList.iterator();
            for (Object next : iterator4) {
                i = 0;
                it = obj;
                i2 = 0;
                toolingState = it;
                valueOf = 0;
                i5 = 0;
                int i11 = 0;
                next3 = 0;
                ArrayList arrayList3 = new ArrayList();
                ArrayList $this$mapNotNull$iv = arrayList3;
                i4 = 0;
                iterator2 = (Iterable)toolingState.getChildren().iterator();
                for (Object dataToSearch$iv : iterator2) {
                    int i12 = 0;
                    CollectionsKt.addAll((Collection)$this$mapNotNull$iv, (Iterable)(Group)dataToSearch$iv.getData());
                    list$iv$iv$iv = $i$a$FlatMapAnimationSearch_androidKt$findData$dataToSearch$2$iv;
                }
                infiniteTransitionSearchInfo = 0;
                iterator = (Iterable)CollectionsKt.plus((Group)toolingState.getData(), (Iterable)(List)$this$mapNotNull$iv).iterator();
                collection = null;
                for (Object next3 : iterator) {
                    iterator2 = null;
                    plus = dataToSearch$iv;
                    collection = null;
                }
                dataToSearch$iv = plus;
                dataToSearch$iv2 = collection;
                if (!dataToSearch$iv2 instanceof InfiniteTransition) {
                }
                toolingOverride = obj2.findToolingOverride((Group)(CallGroup)it);
                if ((InfiniteTransition)dataToSearch$iv2 != 0 && toolingOverride != null) {
                } else {
                }
                if (collection != null) {
                }
                it$iv$iv = i3;
                arrayList = list;
                list$iv$iv$iv = $i$a$FlatMapAnimationSearch_androidKt$findData$dataToSearch$2$iv;
                toolingOverride = 0;
                (Collection)arrayList2.add(collection);
                if (toolingOverride != null) {
                } else {
                }
                if (toolingOverride.getValue() == null) {
                } else {
                }
                iterator = 0;
                Object value = toolingOverride.getValue();
                if (value instanceof ToolingState) {
                }
                if (collection == null) {
                } else {
                }
                toolingState = collection;
                infiniteTransitionSearchInfo = new AnimationSearch.InfiniteTransitionSearchInfo((InfiniteTransition)dataToSearch$iv2, toolingState);
                collection = infiniteTransitionSearchInfo;
                toolingState = new ToolingState(Long.valueOf(iterator));
                collection = value;
                toolingState2 = new ToolingState(Long.valueOf(0));
                toolingOverride.setValue(toolingState2);
                dataToSearch$iv2 = collection;
                next3 = iterator.next();
                iterator2 = null;
                if (dataToSearch$iv3 instanceof InfiniteTransition) {
                } else {
                }
                plus = dataToSearch$iv;
                dataToSearch$iv2 = next3;
                i12 = 0;
                CollectionsKt.addAll($this$mapNotNull$iv, (Iterable)(Group)iterator2.next().getData());
                list$iv$iv$iv = $i$a$FlatMapAnimationSearch_androidKt$findData$dataToSearch$2$iv;
            }
            int $i$f$mapNotNull = it$iv$iv;
            return (List)arrayList2;
        }

        private final MutableState<State<Long>> findToolingOverride(Group group) {
            List element$iv$iv;
            int i;
            Iterator data$iv;
            int next;
            boolean next3;
            Iterator it$iv;
            Object next4;
            boolean next2;
            Collection child$iv;
            int i2;
            final int i3 = 1;
            final Object obj = group;
            final int i4 = 0;
            Collection children = obj.getChildren();
            int i6 = 0;
            int i8 = 0;
            ArrayList arrayList2 = new ArrayList();
            next = 0;
            it$iv = (Iterable)children.iterator();
            for (Object next4 : it$iv) {
                i2 = 0;
                CollectionsKt.addAll((Collection)arrayList2, (Iterable)(Group)next4.getChildren());
            }
            int i5 = 0;
            ArrayList arrayList = new ArrayList();
            i = 0;
            data$iv = (Iterable)(Collection)CollectionsKt.plus(children, (Iterable)(List)arrayList2).iterator();
            for (Object next : data$iv) {
                next2 = false;
                CollectionsKt.addAll((Collection)arrayList, (Iterable)(Group)next.getData());
            }
            int i7 = 0;
            Iterator iterator = (Iterable)CollectionsKt.plus(obj.getData(), (Iterable)(List)arrayList).iterator();
            for (Object element$iv$iv : iterator) {
                next3 = false;
            }
            element$iv$iv = i;
            if (!element$iv$iv instanceof MutableState) {
            } else {
                i = element$iv$iv;
            }
            return (MutableState)i;
        }

        private final CallGroup toAnimationGroup(Group group) {
            int it;
            int i;
            androidx.compose.ui.tooling.data.SourceLocation location;
            int i2;
            String str;
            int i3 = group;
            int i4 = 0;
            if (group.getLocation() != null && Intrinsics.areEqual(group.getName(), "rememberInfiniteTransition")) {
                i2 = Intrinsics.areEqual(group.getName(), "rememberInfiniteTransition") ? 1 : 0;
            } else {
            }
            i = i2 != 0 ? group : it;
            i2 = 0;
            if (i != 0 && i instanceof CallGroup) {
                i2 = 0;
                if (i instanceof CallGroup) {
                    it = i;
                }
            }
            return it;
        }

        public void addAnimations(Collection<? extends Group> groups) {
            getAnimations().addAll((Collection)findAnimations(groups));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch$Search
        public boolean hasAnimation(Group group) {
            int i2;
            int i5;
            Object toolingOverride;
            int i;
            int i3;
            List plus;
            boolean $this$firstOrNull$iv$iv;
            int i6;
            Iterator iterator;
            Collection element$iv$iv;
            int i4;
            Iterator data$iv;
            Object next;
            Collection it$iv;
            int i7;
            i2 = 0;
            if (toAnimationGroup(group) != null) {
                i5 = 0;
                toolingOverride = group;
                i = 0;
                i3 = 0;
                int i8 = 0;
                int i9 = 0;
                ArrayList arrayList = new ArrayList();
                i4 = 0;
                data$iv = (Iterable)toolingOverride.getChildren().iterator();
                for (Object next : data$iv) {
                    i7 = 0;
                    CollectionsKt.addAll((Collection)arrayList, (Iterable)(Group)next.getData());
                }
                i6 = 0;
                iterator = (Iterable)CollectionsKt.plus(toolingOverride.getData(), (Iterable)(List)arrayList).iterator();
                for (Object element$iv$iv : iterator) {
                    next = false;
                }
                element$iv$iv = i4;
                if (!element$iv$iv instanceof InfiniteTransition) {
                } else {
                    i4 = element$iv$iv;
                }
                if ((InfiniteTransition)i4 != null && findToolingOverride(group) != null) {
                    if (findToolingOverride(group) != null) {
                        i2 = 1;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i2;
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "", "infiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "", "(Landroidx/compose/animation/core/InfiniteTransition;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getInfiniteTransition", "()Landroidx/compose/animation/core/InfiniteTransition;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InfiniteTransitionSearchInfo {

        public static final int $stable;
        private final InfiniteTransition infiniteTransition;
        private final androidx.compose.ui.tooling.animation.ToolingState<Long> toolingState;
        static {
            AnimationSearch.InfiniteTransitionSearchInfo.$stable = InfiniteTransition.$stable;
        }

        public InfiniteTransitionSearchInfo(InfiniteTransition infiniteTransition, androidx.compose.ui.tooling.animation.ToolingState<Long> toolingState) {
            super();
            this.infiniteTransition = infiniteTransition;
            this.toolingState = toolingState;
        }

        public static androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo copy$default(androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo animationSearch$InfiniteTransitionSearchInfo, InfiniteTransition infiniteTransition2, androidx.compose.ui.tooling.animation.ToolingState toolingState3, int i4, Object object5) {
            InfiniteTransition obj1;
            androidx.compose.ui.tooling.animation.ToolingState obj2;
            if (i4 & 1 != 0) {
                obj1 = infiniteTransitionSearchInfo.infiniteTransition;
            }
            if (i4 &= 2 != 0) {
                obj2 = infiniteTransitionSearchInfo.toolingState;
            }
            return infiniteTransitionSearchInfo.copy(obj1, obj2);
        }

        public final InfiniteTransition component1() {
            return this.infiniteTransition;
        }

        public final androidx.compose.ui.tooling.animation.ToolingState<Long> component2() {
            return this.toolingState;
        }

        public final androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo copy(InfiniteTransition infiniteTransition, androidx.compose.ui.tooling.animation.ToolingState<Long> toolingState2) {
            AnimationSearch.InfiniteTransitionSearchInfo infiniteTransitionSearchInfo = new AnimationSearch.InfiniteTransitionSearchInfo(infiniteTransition, toolingState2);
            return infiniteTransitionSearchInfo;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AnimationSearch.InfiniteTransitionSearchInfo) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.infiniteTransition, obj.infiniteTransition)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.toolingState, obj.toolingState)) {
                return i2;
            }
            return i;
        }

        public final InfiniteTransition getInfiniteTransition() {
            return this.infiniteTransition;
        }

        public final androidx.compose.ui.tooling.animation.ToolingState<Long> getToolingState() {
            return this.toolingState;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("InfiniteTransitionSearchInfo(infiniteTransition=").append(this.infiniteTransition).append(", toolingState=").append(this.toolingState).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u0010\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TargetBasedSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TargetBasedSearch extends androidx.compose.ui.tooling.animation.AnimationSearch.RememberSearch<TargetBasedAnimation<?, ?>> {

        public static final int $stable;
        static {
        }

        public TargetBasedSearch(Function1<? super TargetBasedAnimation<?, ?>, Unit> trackAnimation) {
            super(Reflection.getOrCreateKotlinClass(TargetBasedAnimation.class), trackAnimation);
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH\u0002¨\u0006\u000f", d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "", "group", "toAnimationGroup", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransitionSearch extends androidx.compose.ui.tooling.animation.AnimationSearch.Search<Transition<?>> {

        public static final int $stable;
        static {
        }

        public TransitionSearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
        }

        private final Group toAnimationGroup(Group group) {
            int i2;
            androidx.compose.ui.tooling.data.SourceLocation location;
            int i;
            String str;
            int i3 = group;
            final int i4 = 0;
            if (i3.getLocation() != null && Intrinsics.areEqual(i3.getName(), "updateTransition")) {
                i = Intrinsics.areEqual(i3.getName(), "updateTransition") ? 1 : 0;
            } else {
            }
            i2 = i != 0 ? group : 0;
            return i2;
        }

        public void addAnimations(Collection<? extends Group> groups) {
            int $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv;
            ArrayList it$iv$iv$iv;
            ArrayList list;
            Object rememberCalls$iv2;
            boolean $i$f$findRememberedData;
            ArrayList $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2;
            boolean $this$findRememberedData$iv;
            Object next4;
            Object obj2;
            int next2;
            boolean next;
            Group it;
            int i;
            Object obj7;
            int i3;
            Object obj;
            int iNSTANCE;
            int $this$firstOrNull$iv$iv;
            int i2;
            Iterator $this$firstOrNull$iv$iv2;
            Object next3;
            Object iterator;
            int next5;
            Object obj3;
            int i4;
            ArrayList rememberCalls$iv;
            int i5 = 0;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2 = new ArrayList();
            int i8 = 0;
            int i10 = 0;
            Iterator iterator2 = (Iterable)groups.iterator();
            while (iterator2.hasNext()) {
                next2 = 0;
                i = 0;
                it = this.toAnimationGroup((Group)iterator2.next());
                if (it != null) {
                }
                i = 0;
                (Collection)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2.add(it);
            }
            Object obj8 = this;
            $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = 0;
            int i6 = 0;
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i14 = 0;
            Iterator iterator3 = (Iterable)(Collection)(List)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2.iterator();
            for (Object next2 : iterator3) {
                i3 = 0;
                iNSTANCE = 0;
                i2 = 0;
                $this$firstOrNull$iv$iv2 = (Iterable)(Group)next2.getData().iterator();
                for (Object next3 : $this$firstOrNull$iv$iv2) {
                    next5 = 0;
                }
                it = 0;
                if (!it instanceof Transition) {
                }
                if ((Transition)it != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = $this$firstOrNull$iv$iv;
                $i$f$findRememberedData = 0;
                (Collection)arrayList.add((Transition)it);
                it = 0;
                next3 = $this$firstOrNull$iv$iv2.next();
                next5 = 0;
                if (obj6 instanceof Transition) {
                } else {
                }
                it = next3;
            }
            int $i$f$findRememberedData2 = $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv;
            it$iv$iv$iv = arrayList;
            int i7 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            int i15 = 0;
            Iterator iterator4 = (Iterable)$i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2.iterator();
            while (iterator4.hasNext()) {
                i = 0;
                obj = 0;
                Group firstOrNull = PreviewUtils_androidKt.firstOrNull((Group)iterator4.next(), (Function1)AnimationSearch_androidKt.findRememberedData.rememberCalls.1.1.INSTANCE);
                if (firstOrNull != null) {
                }
                it$iv$iv$iv = i2;
                i3 = 0;
                (Collection)arrayList2.add(firstOrNull);
            }
            int i9 = 0;
            ArrayList arrayList3 = new ArrayList();
            int i13 = 0;
            int i16 = 0;
            Iterator iterator5 = (Iterable)(List)arrayList2.iterator();
            for (Object it : iterator5) {
                i3 = 0;
                iNSTANCE = 0;
                next3 = 0;
                iterator = (Iterable)(Group)it.getData().iterator();
                for (Object next5 : iterator) {
                    i4 = 0;
                    list = rememberCalls$iv;
                }
                rememberCalls$iv = list;
                rememberCalls$iv2 = 0;
                if (!rememberCalls$iv2 instanceof Transition) {
                }
                if ((Transition)rememberCalls$iv2 != null) {
                }
                $i$a$LetCollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv2 = $this$firstOrNull$iv$iv2;
                list = rememberCalls$iv;
                $this$findRememberedData$iv = 0;
                (Collection)arrayList3.add((Transition)rememberCalls$iv2);
                rememberCalls$iv2 = 0;
                next5 = iterator.next();
                i4 = 0;
                if (rememberCalls$iv3 instanceof Transition) {
                } else {
                }
                list = rememberCalls$iv;
                rememberCalls$iv2 = next5;
            }
            ArrayList rememberCalls$iv5 = list;
            getAnimations().addAll((Collection)CollectionsKt.plus((Collection)it$iv$iv$iv, (Iterable)(List)arrayList3));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch$Search
        public boolean hasAnimation(Group group) {
            int i;
            i = toAnimationGroup(group) != null ? 1 : 0;
            return i;
        }
    }
    static {
        final int i = 8;
    }

    public AnimationSearch(Function0<? extends androidx.compose.ui.tooling.animation.PreviewAnimationClock> clock, Function0<Unit> onSeek) {
        super();
        this.clock = clock;
        this.onSeek = onSeek;
        AnimationSearch.transitionSearch.1 anon = new AnimationSearch.transitionSearch.1(this);
        AnimationSearch.TransitionSearch transitionSearch = new AnimationSearch.TransitionSearch((Function1)anon);
        this.transitionSearch = transitionSearch;
        AnimationSearch.animatedContentSearch.1 anon2 = new AnimationSearch.animatedContentSearch.1(this);
        AnimationSearch.AnimatedContentSearch animatedContentSearch = new AnimationSearch.AnimatedContentSearch((Function1)anon2);
        this.animatedContentSearch = animatedContentSearch;
        AnimationSearch.animatedVisibilitySearch.1 anon3 = new AnimationSearch.animatedVisibilitySearch.1(this);
        AnimationSearch.AnimatedVisibilitySearch animatedVisibilitySearch = new AnimationSearch.AnimatedVisibilitySearch((Function1)anon3);
        this.animatedVisibilitySearch = animatedVisibilitySearch;
        this.supportedSearch = supportedSearch();
        this.setToTrack = SetsKt.plus(this.supportedSearch, (Iterable)unsupportedSearch());
        this.setToSearch = SetsKt.plus(this.setToTrack, (Iterable)SetsKt.setOf(this.animatedContentSearch));
    }

    public static final Function0 access$getClock$p(androidx.compose.ui.tooling.animation.AnimationSearch $this) {
        return $this.clock;
    }

    public static final Function0 access$getOnSeek$p(androidx.compose.ui.tooling.animation.AnimationSearch $this) {
        return $this.onSeek;
    }

    private final Collection<androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearch> animateXAsStateSearch() {
        Object emptyList;
        androidx.compose.ui.tooling.animation.AnimationSearch.animateXAsStateSearch.1 anon;
        if (AnimateXAsStateComposeAnimation.Companion.getApiAvailable()) {
            anon = new AnimationSearch.animateXAsStateSearch.1(this);
            AnimationSearch.AnimateXAsStateSearch animateXAsStateSearch = new AnimationSearch.AnimateXAsStateSearch((Function1)anon);
            emptyList = SetsKt.setOf(animateXAsStateSearch);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    private final Set<androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearch> infiniteTransitionSearch() {
        Set emptySet;
        androidx.compose.ui.tooling.animation.AnimationSearch.infiniteTransitionSearch.1 anon;
        if (InfiniteTransitionComposeAnimation.Companion.getApiAvailable()) {
            anon = new AnimationSearch.infiniteTransitionSearch.1(this);
            AnimationSearch.InfiniteTransitionSearch infiniteTransitionSearch = new AnimationSearch.InfiniteTransitionSearch((Function1)anon);
            emptySet = SetsKt.setOf(infiniteTransitionSearch);
        } else {
            emptySet = SetsKt.emptySet();
        }
        return emptySet;
    }

    private final Set<androidx.compose.ui.tooling.animation.AnimationSearch.Search<? extends Object>> supportedSearch() {
        Set emptySet;
        androidx.compose.ui.tooling.animation.AnimationSearch.Search[] arr = new AnimationSearch.Search[2];
        if (AnimatedContentComposeAnimation.Companion.getApiAvailable()) {
            emptySet = SetsKt.setOf(this.animatedContentSearch);
        } else {
            emptySet = SetsKt.emptySet();
        }
        return SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.setOf(this.transitionSearch, this.animatedVisibilitySearch), (Iterable)animateXAsStateSearch()), (Iterable)infiniteTransitionSearch()), (Iterable)emptySet);
    }

    private final Collection<androidx.compose.ui.tooling.animation.AnimationSearch.Search<? extends Object>> unsupportedSearch() {
        Object emptyList;
        androidx.compose.ui.tooling.animation.AnimationSearch.DecaySearch decaySearch;
        int i;
        if (UnsupportedComposeAnimation.Companion.getApiAvailable()) {
            androidx.compose.ui.tooling.animation.AnimationSearch.Search[] arr = new AnimationSearch.Search[3];
            AnimationSearch.unsupportedSearch.1 anon = new AnimationSearch.unsupportedSearch.1(this);
            AnimationSearch.AnimateContentSizeSearch animateContentSizeSearch = new AnimationSearch.AnimateContentSizeSearch((Function1)anon);
            AnimationSearch.unsupportedSearch.2 anon2 = new AnimationSearch.unsupportedSearch.2(this);
            AnimationSearch.TargetBasedSearch targetBasedSearch = new AnimationSearch.TargetBasedSearch((Function1)anon2);
            AnimationSearch.unsupportedSearch.3 anon3 = new AnimationSearch.unsupportedSearch.3(this);
            decaySearch = new AnimationSearch.DecaySearch((Function1)anon3);
            emptyList = SetsKt.setOf(animateContentSizeSearch, targetBasedSearch, decaySearch);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public final void attachAllAnimations(Collection<? extends Group> slotTrees) {
        Object next;
        boolean next3;
        Object obj;
        int i2;
        List all;
        Set animations2;
        Set animations;
        Iterator iterator;
        boolean next2;
        Object obj2;
        int i;
        List list;
        int i3 = 0;
        Iterator iterator2 = (Iterable)slotTrees.iterator();
        for (Object next : iterator2) {
            i2 = 0;
            int i5 = 0;
            iterator = (Iterable)this.setToSearch.iterator();
            for (Object next2 : iterator) {
                i = 0;
                (AnimationSearch.Search)next2.addAnimations((Collection)PreviewUtils_androidKt.findAll((Group)next, (Function1)AnimationSearch.attachAllAnimations.1.groups.1.INSTANCE));
            }
            this.transitionSearch.getAnimations().removeAll((Collection)this.animatedVisibilitySearch.getAnimations());
            this.transitionSearch.getAnimations().removeAll((Collection)this.animatedContentSearch.getAnimations());
            i = 0;
            (AnimationSearch.Search)iterator.next().addAnimations((Collection)all);
        }
        int i4 = 0;
        Iterator iterator3 = (Iterable)this.setToTrack.iterator();
        for (Object next3 : iterator3) {
            i2 = 0;
            (AnimationSearch.Search)next3.track();
        }
    }

    public final boolean searchAny(Collection<? extends Group> slotTrees) {
        boolean iterator2;
        int animations;
        int i5;
        boolean next;
        Object obj;
        int i;
        List all;
        Object obj2;
        Set supportedSearch;
        int i4;
        boolean iterator;
        int i2;
        boolean next2;
        Object obj3;
        int i3;
        final Object obj4 = slotTrees;
        final int i6 = 0;
        if (obj4 instanceof Collection != null && (Collection)(Iterable)obj4.isEmpty()) {
            if ((Collection)obj4.isEmpty()) {
                i5 = 0;
                obj2 = this;
            } else {
                iterator2 = obj4.iterator();
                while (iterator2.hasNext()) {
                    i = 0;
                    supportedSearch = obj2.supportedSearch;
                    i4 = 0;
                    i2 = 1;
                    if (supportedSearch instanceof Collection != null && (Collection)(Iterable)supportedSearch.isEmpty()) {
                    } else {
                    }
                    iterator = supportedSearch.iterator();
                    for (Object next2 : iterator) {
                        i3 = 0;
                    }
                    animations = 0;
                    i3 = 0;
                    if ((AnimationSearch.Search)iterator.next().hasAnimations((Collection)all)) {
                    } else {
                    }
                    animations = i2;
                    if ((Collection)supportedSearch.isEmpty()) {
                    } else {
                    }
                    animations = 0;
                }
                obj2 = this;
                i5 = 0;
            }
        } else {
        }
        return i5;
    }
}
