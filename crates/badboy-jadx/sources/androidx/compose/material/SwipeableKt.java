package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.InspectableValueKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aP\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002\u001a$\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00152\u0006\u0010\u000c\u001a\u00020\u000b2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u000fH\u0002\u001aZ\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0005\"\u0008\u0008\u0000\u0010\u0004*\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u00042\u000e\u0008\u0002\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001a2#\u0008\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020 0\u001cH\u0007¢\u0006\u0002\u0010!\u001aI\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0005\"\u0008\u0008\u0000\u0010\u0004*\u00020\u00172\u0006\u0010#\u001a\u0002H\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020%0\u001c2\u000e\u0008\u0002\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aH\u0001¢\u0006\u0002\u0010&\u001a-\u0010'\u001a\u0004\u0018\u00010\u000b\"\u0004\u0008\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00040(2\u0006\u0010)\u001a\u0002H\u0004H\u0002¢\u0006\u0002\u0010*\u001a¶\u0001\u0010+\u001a\u00020,\"\u0004\u0008\u0000\u0010\u0004*\u00020,2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00040(2\u0006\u0010-\u001a\u00020.2\u0008\u0008\u0002\u0010/\u001a\u00020 2\u0008\u0008\u0002\u00100\u001a\u00020 2\n\u0008\u0002\u00101\u001a\u0004\u0018\u00010228\u0008\u0002\u0010\u0010\u001a2\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(3\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(4\u0012\u0004\u0012\u0002050\u00112\n\u0008\u0002\u00106\u001a\u0004\u0018\u0001072\u0008\u0008\u0002\u0010\u0013\u001a\u000208H\u0007ø\u0001\u0000¢\u0006\u0004\u00089\u0010:\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"*\u0010\u0002\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00058@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006;", d2 = {"SwipeableDeprecation", "", "PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/compose/material/SwipeableState;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "computeTarget", "", "offset", "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberSwipeableState", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "getOffset", "", "state", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "swipeable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "from", "to", "Landroidx/compose/material/ThresholdConfig;", "resistance", "Landroidx/compose/material/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeableKt {

    private static final String SwipeableDeprecation = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.";
    public static final float access$computeTarget(float offset, float lastValue, Set anchors, Function2 thresholds, float velocity, float velocityThreshold) {
        return SwipeableKt.computeTarget(offset, lastValue, anchors, thresholds, velocity, velocityThreshold);
    }

    public static final List access$findBounds(float offset, Set anchors) {
        return SwipeableKt.findBounds(offset, anchors);
    }

    public static final Float access$getOffset(Map $receiver, Object state) {
        return SwipeableKt.getOffset($receiver, state);
    }

    private static final float computeTarget(float offset, float lastValue, Set<Float> anchors, Function2<? super Float, ? super Float, Float> thresholds, float velocity, float velocityThreshold) {
        float lower;
        int floatValue2;
        float floatValue;
        int cmp;
        final List bounds2 = SwipeableKt.findBounds(offset, anchors);
        floatValue2 = 0;
        switch (size) {
            case 0:
                lower = lastValue;
                break;
            case 1:
                lower = (Number)bounds2.get(floatValue2).floatValue();
                break;
            default:
                lower = (Number)bounds2.get(floatValue2).floatValue();
                floatValue2 = (Number)bounds2.get(1).floatValue();
                return floatValue2;
                return lower;
                lower = floatValue2;
        }
        return lower;
    }

    private static final List<Float> findBounds(float offset, Set<Float> anchors) {
        Object maxElem$iv;
        float minValue$iv;
        List listOfNotNull;
        Object minElem$iv;
        float maxValue$iv;
        int i$iv2;
        int i$iv;
        Object next;
        int lastIndex;
        int lastIndex2;
        Object cmp;
        Iterator iterator;
        float floatValue2;
        boolean floatValue;
        int compare;
        int i;
        int floatValue3;
        int i2;
        double d;
        long l;
        int i3;
        int i4;
        final Object obj = offset;
        int i7 = 0;
        ArrayList arrayList = new ArrayList();
        maxValue$iv = 0;
        i$iv2 = (Iterable)anchors.iterator();
        i = 0;
        while (i$iv2.hasNext()) {
            next = i$iv2.next();
            i2 = 0;
            if (Double.compare(d, i16) <= 0) {
            } else {
            }
            compare = i;
            if (compare != 0) {
            }
            i = 0;
            (Collection)arrayList.add(next);
            compare = 1;
        }
        int i6 = 0;
        if ((List)arrayList.isEmpty()) {
            maxElem$iv = minElem$iv;
        } else {
            maxValue$iv = (Number)arrayList.get(i).floatValue();
            int i14 = 0;
            lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
            }
        }
        Object $i$f$fastMaxBy = maxElem$iv;
        int i10 = 0;
        ArrayList arrayList2 = new ArrayList();
        lastIndex2 = 0;
        iterator = (Iterable)anchors.iterator();
        while (iterator.hasNext()) {
            floatValue2 = iterator.next();
            i2 = 0;
            if (Double.compare(d, i17) >= 0) {
            } else {
            }
            compare = 0;
            if (compare != 0) {
            }
            i = 0;
            (Collection)arrayList2.add(floatValue2);
            compare = i3;
        }
        int i9 = 0;
        if ((List)arrayList2.isEmpty()) {
        } else {
            minValue$iv = (Number)arrayList2.get(0).floatValue();
            int i15 = 0;
            lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
            }
        }
        Object $i$f$fastMinByOrNull = minElem$iv;
        if ((Float)$i$f$fastMaxBy == null) {
            listOfNotNull = CollectionsKt.listOfNotNull((Float)$i$f$fastMinByOrNull);
        } else {
            if ($i$f$fastMinByOrNull == null) {
                listOfNotNull = CollectionsKt.listOf((Float)$i$f$fastMaxBy);
            } else {
                if (Intrinsics.areEqual($i$f$fastMaxBy, $i$f$fastMinByOrNull)) {
                    listOfNotNull = CollectionsKt.listOf($i$f$fastMaxBy);
                } else {
                    Float[] arr = new Float[2];
                    listOfNotNull = CollectionsKt.listOf($i$f$fastMaxBy, $i$f$fastMinByOrNull);
                }
            }
        }
        return listOfNotNull;
    }

    private static final <T> Float getOffset(Map<Float, ? extends T> $this$getOffset, T state) {
        Object entrySet;
        Object element$iv;
        int i;
        boolean it;
        int i2;
        Object value;
        final int i3 = 0;
        final Iterator iterator = (Iterable)$this$getOffset.entrySet().iterator();
        for (Object element$iv : iterator) {
            i2 = 0;
        }
        element$iv = i;
        if ((Map.Entry)element$iv != null) {
            i = entrySet;
        }
        return i;
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(androidx.compose.material.SwipeableState<T> $this$PreUpPostDownNestedScrollConnection) {
        SwipeableKt.PreUpPostDownNestedScrollConnection.1 anon = new SwipeableKt.PreUpPostDownNestedScrollConnection.1($this$PreUpPostDownNestedScrollConnection);
        return (NestedScrollConnection)anon;
    }

    public static void getPreUpPostDownNestedScrollConnection$annotations(androidx.compose.material.SwipeableState swipeableState) {
    }

    @Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
    public static final <T> androidx.compose.material.SwipeableState<T> rememberSwipeableState(T initialValue, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmStateChange, Composer $composer, int $changed, int i6) {
        int i;
        boolean changedInstance;
        int animationSpec2;
        boolean changed;
        String str;
        Object empty;
        Object anon;
        androidx.compose.animation.core.SpringSpec obj10;
        androidx.compose.material.SwipeableKt.rememberSwipeableState.1 obj11;
        int obj14;
        int i2 = -1237755169;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberSwipeableState)P(2)485@19667L177,480@19500L344:Swipeable.kt#jmzs0o");
        if (i6 & 2 != 0) {
            obj10 = animationSpec2;
        }
        int i7 = 4;
        if (i6 &= i7 != 0) {
            obj11 = obj14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material.rememberSwipeableState (Swipeable.kt:479)");
        }
        obj14 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -400382047, "CC(remember):Swipeable.kt#9igjgp");
        int i10 = 1;
        if (i4 ^= 6 > i7) {
            if (!$composer.changedInstance(initialValue)) {
                i = $changed & 6 == i7 ? i10 : obj14;
            } else {
            }
        } else {
        }
        int i12 = 256;
        if (i8 ^= 384 > i12) {
            if (!$composer.changed(obj11)) {
                if ($changed & 384 == i12) {
                    obj14 = i10;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i9 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i13 = 0;
        if (obj14 |= i5 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SwipeableKt.rememberSwipeableState.2.1(initialValue, obj10, obj11);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (SwipeableState)RememberSaveableKt.rememberSaveable(new Object[obj14], SwipeableState.Companion.Saver(obj10, obj11), 0, (Function0)anon, composer2, 0, 4);
    }

    @Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
    public static final <T> androidx.compose.material.SwipeableState<T> rememberSwipeableStateFor(T value, Function1<? super T, Unit> onValueChange, AnimationSpec<Float> animationSpec, Composer $composer, int $changed, int i6) {
        Object anon2;
        Object mutableStateOf$default;
        androidx.compose.animation.core.SpringSpec animationSpec2;
        boolean traceInProgress;
        boolean changedInstance2;
        int i2;
        String str;
        int changed;
        boolean changedInstance;
        int i5;
        Object empty4;
        int i;
        int i3;
        int empty;
        Object empty2;
        Object swipeableState;
        int empty3;
        Object anon;
        androidx.compose.material.SwipeableKt.rememberSwipeableStateFor.swipeableState.1.1 iNSTANCE;
        Boolean valueOf;
        int i4;
        Composer.Companion companion;
        int obj19;
        final Object obj = value;
        final Object obj2 = onValueChange;
        final Composer composer = $composer;
        int i7 = $changed;
        int i8 = 1156387078;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(rememberSwipeableStateFor)P(2,1)510@20701L169,517@20901L34,518@20989L113,518@20940L162,523@21153L213,523@21107L259:Swipeable.kt#jmzs0o");
        int i11 = 4;
        if (i6 & 4 != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        } else {
            animationSpec2 = animationSpec;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i7, -1, "androidx.compose.material.rememberSwipeableStateFor (Swipeable.kt:509)");
        }
        String str3 = "CC(remember):Swipeable.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 2132120610, str3);
        int i10 = 0;
        Composer composer2 = $composer;
        int i21 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i29 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            swipeableState = new SwipeableState(obj, animationSpec2, (Function1)SwipeableKt.rememberSwipeableStateFor.swipeableState.1.1.INSTANCE);
            composer2.updateRememberedValue(swipeableState);
        } else {
            swipeableState = rememberedValue;
        }
        androidx.compose.material.SwipeableState invalid$iv = swipeableState;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 2132126875, str3);
        int i18 = 0;
        Composer composer4 = $composer;
        empty4 = 0;
        Object rememberedValue3 = composer4.rememberedValue();
        int i31 = 0;
        int i32 = 0;
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            empty3 = 0;
            composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, i32, 2, i32));
        } else {
            obj19 = 0;
            mutableStateOf$default = rememberedValue3;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 2132129770, str3);
        if (i23 ^= 6 > 4) {
            if (!composer.changedInstance(obj)) {
                i5 = i7 & 6 == 4 ? 1 : obj19;
            } else {
            }
        } else {
        }
        Composer composer5 = $composer;
        empty2 = 0;
        Object rememberedValue4 = composer5.rememberedValue();
        int i33 = 0;
        if (i5 == 0) {
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                empty4 = 0;
                anon2 = new SwipeableKt.rememberSwipeableStateFor.1.1(obj, (SwipeableState)invalid$iv, i32);
                composer5.updateRememberedValue((Function2)anon2);
            } else {
                anon2 = rememberedValue4;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(obj, (MutableState)mutableStateOf$default.getValue(), (Function2)anon2, composer, i24 |= i28);
        ComposerKt.sourceInformationMarkerStart(composer, 2132135118, str3);
        if (i14 ^= 6 > 4) {
            if (!composer.changedInstance(obj)) {
                i2 = $changed & 6 == 4 ? 1 : obj19;
            } else {
            }
        } else {
        }
        int i26 = 32;
        if (i20 ^= 48 > i26) {
            if (!composer.changed(obj2)) {
                i4 = $changed & 48 == i26 ? 1 : obj19;
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i27 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i30 = 0;
        if (i2 |= i4 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty2 = 0;
                anon = new SwipeableKt.rememberSwipeableStateFor.2.1(obj, invalid$iv, obj2, mutableStateOf$default);
                composer3.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(invalid$iv.getCurrentValue(), (Function1)anon, composer, $changed & 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return invalid$iv;
    }

    @Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
    public static final <T> Modifier swipeable-pPrIpRY(Modifier $this$swipeable_u2dpPrIpRY, androidx.compose.material.SwipeableState<T> state, Map<Float, ? extends T> anchors, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, Function2<? super T, ? super T, ? extends androidx.compose.material.ThresholdConfig> thresholds, androidx.compose.material.ResistanceConfig resistance, float velocityThreshold) {
        Function1 noInspectorInfo;
        androidx.compose.material.SwipeableState swipeableState;
        Map map;
        Orientation orientation2;
        boolean z2;
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        Function2 function2;
        androidx.compose.material.ResistanceConfig resistanceConfig;
        float f;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SwipeableKt.swipeable-pPrIpRY$$inlined.debugInspectorInfo.1(state, anchors, orientation, enabled, reverseDirection, interactionSource, thresholds, resistance, velocityThreshold);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SwipeableKt.swipeable.3 anon = new SwipeableKt.swipeable.3(anchors, state, resistance, thresholds, velocityThreshold, orientation, enabled, interactionSource, reverseDirection);
        return ComposedModifierKt.composed($this$swipeable_u2dpPrIpRY, noInspectorInfo, (Function3)anon);
    }

    public static Modifier swipeable-pPrIpRY$default(Modifier modifier, androidx.compose.material.SwipeableState swipeableState2, Map map3, Orientation orientation4, boolean z5, boolean z6, MutableInteractionSource mutableInteractionSource7, Function2 function28, androidx.compose.material.ResistanceConfig resistanceConfig9, float f10, int i11, Object object12) {
        int velocityThreshold-D9Ej5fM;
        int i2;
        int i3;
        int i6;
        int iNSTANCE;
        int resistanceConfig$default;
        int i7;
        int i5;
        int i4;
        androidx.compose.material.SwipeableKt.swipeable.1 anon;
        androidx.compose.material.ResistanceConfig resistanceConfig;
        Set keySet;
        float f;
        int i8;
        int i9;
        int i10;
        int i;
        int i12 = i11;
        i7 = i12 & 8 != 0 ? i2 : z5;
        i5 = i12 & 16 != 0 ? i3 : z6;
        i4 = i12 & 32 != 0 ? i6 : mutableInteractionSource7;
        if (i12 & 64 != 0) {
            anon = iNSTANCE;
        } else {
            anon = function28;
        }
        if (i12 & 128 != 0) {
            resistanceConfig = resistanceConfig$default;
        } else {
            resistanceConfig = resistanceConfig9;
        }
        if (i12 &= 256 != 0) {
            f = velocityThreshold-D9Ej5fM;
        } else {
            f = f10;
        }
        return SwipeableKt.swipeable-pPrIpRY(modifier, swipeableState2, map3, orientation4, i7, i5, i4, anon, resistanceConfig, f);
    }
}
