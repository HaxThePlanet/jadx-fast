package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Animation;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.tooling.animation.states.TargetState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010$\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a5\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u000c\u0018\u00010\u000b\"\u0004\u0008\u0000\u0010\u000c2\u0006\u0010\r\u001a\u0002H\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0013R\u0006\u0012\u0002\u0008\u00030\u00140\u0001*\u0006\u0012\u0002\u0008\u00030\u0014H\u0000\u001aH\u0010\u0015\u001a\u00020\u0016\"\u0004\u0008\u0000\u0010\u000c\"\u0008\u0008\u0001\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u0006H\u0000\u001a>\u0010\u0015\u001a\u00020\u0016\"\u0004\u0008\u0000\u0010\u000c\"\u0008\u0008\u0001\u0010\u0017*\u00020\u0018*\u0012\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\u00170\u001eR\u00020\u001f2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0000\u001aB\u0010\u0015\u001a\u00020\u0016\"\u0004\u0008\u0000\u0010\u000c\"\u0008\u0008\u0001\u0010\u0017*\u00020\u0018\"\u0004\u0008\u0002\u0010!*\u0018\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\u00170\u0013R\u0008\u0012\u0004\u0012\u0002H!0\u00142\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u0006H\u0000\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\"²\u0006\u001a\u0010#\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u000c\"\u0008\u0008\u0001\u0010\u0017*\u00020\u0018X\u008a\u0084\u0002²\u0006&\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000c0%\"\u0004\u0008\u0000\u0010\u000c\"\u0008\u0008\u0001\u0010\u0017*\u00020\u0018X\u008a\u0084\u0002²\u0006&\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000c0%\"\u0004\u0008\u0000\u0010\u000c\"\u0008\u0008\u0001\u0010\u0017*\u00020\u0018X\u008a\u0084\u0002", d2 = {"IGNORE_TRANSITIONS", "", "", "getIGNORE_TRANSITIONS", "()Ljava/util/List;", "millisToNanos", "", "timeMs", "nanosToMillis", "timeNs", "parseParametersToValue", "Landroidx/compose/ui/tooling/animation/states/TargetState;", "T", "currentValue", "par1", "", "par2", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/ui/tooling/animation/states/TargetState;", "allAnimations", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "createTransitionInfo", "Landroidx/compose/animation/tooling/TransitionInfo;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "label", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "stepMs", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "Landroidx/compose/animation/core/InfiniteTransition;", "endTimeMs", "S", "ui-tooling_release", "startTimeMs", "values", ""}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Utils_androidKt {

    private static final List<String> IGNORE_TRANSITIONS;
    static {
        Utils_androidKt.IGNORE_TRANSITIONS = CollectionsKt.listOf("TransformOriginInterruptionHandling");
    }

    public static final long access$createTransitionInfo$lambda$1(Lazy $startTimeMs$delegate) {
        return Utils_androidKt.createTransitionInfo$lambda$1($startTimeMs$delegate);
    }

    public static final List<Transition.TransitionAnimationState<?, ?, ?>> allAnimations(Transition<?> $this$allAnimations) {
        Object next;
        List it;
        int i;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        final int i3 = 0;
        final Iterator iterator = (Iterable)$this$allAnimations.getTransitions().iterator();
        for (Object next : iterator) {
            i = 0;
            CollectionsKt.addAll((Collection)arrayList, (Iterable)Utils_androidKt.allAnimations((Transition)next));
        }
        return CollectionsKt.plus((Collection)$this$allAnimations.getAnimations(), (Iterable)(List)arrayList);
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> TransitionInfo createTransitionInfo(Animation<T, V> $this$createTransitionInfo, String label, AnimationSpec<T> animationSpec, long stepMs) {
        long nanosToMillis = Utils_androidKt.nanosToMillis($this$createTransitionInfo.getDurationNanos());
        Utils_androidKt.createTransitionInfo.startTimeMs.2 anon = new Utils_androidKt.createTransitionInfo.startTimeMs.2(animationSpec);
        final Lazy lazy4 = LazyKt.lazy((Function0)anon);
        final Lazy lazy3 = stepMs;
        Utils_androidKt.createTransitionInfo.values.2 anon2 = new Utils_androidKt.createTransitionInfo.values.2($this$createTransitionInfo, nanosToMillis, obj5, lazy3, obj7, lazy4);
        final long l2 = nanosToMillis;
        TransitionInfo transitionInfo = new TransitionInfo(label, animationSpec.getClass().getName(), Utils_androidKt.createTransitionInfo$lambda$1(lazy4), lazy3, l2, lazy4, Utils_androidKt.createTransitionInfo$lambda$2(LazyKt.lazy((Function0)anon2)));
        long l = l2;
        return transitionInfo;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> TransitionInfo createTransitionInfo(InfiniteTransition.TransitionAnimationState<T, V> $this$createTransitionInfo, long stepMs, long endTimeMs) {
        int i = 0;
        final Object obj = stepMs;
        long l2 = obj11;
        Utils_androidKt.createTransitionInfo.values.4 anon = new Utils_androidKt.createTransitionInfo.values.4(i, obj2, $this$createTransitionInfo, l2, obj5, obj, obj7);
        final long l4 = l2;
        int i3 = i;
        TransitionInfo transitionInfo = new TransitionInfo($this$createTransitionInfo.getLabel(), $this$createTransitionInfo.getAnimationSpec().getClass().getName(), i3, l2, l4, obj, Utils_androidKt.createTransitionInfo$lambda$3(LazyKt.lazy((Function0)anon)));
        int i2 = i3;
        long l3 = l4;
        return transitionInfo;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector, S> TransitionInfo createTransitionInfo(Transition.TransitionAnimationState<S, T, V> $this$createTransitionInfo, long stepMs) {
        return Utils_androidKt.createTransitionInfo((Animation)$this$createTransitionInfo.getAnimation(), $this$createTransitionInfo.getLabel(), (AnimationSpec)$this$createTransitionInfo.getAnimationSpec(), stepMs);
    }

    public static TransitionInfo createTransitionInfo$default(Animation animation, String string2, AnimationSpec animationSpec3, long l4, int i5, Object object6) {
        int obj3;
        if (object6 &= 4 != 0) {
            obj3 = 1;
        }
        return Utils_androidKt.createTransitionInfo(animation, string2, animationSpec3, obj3);
    }

    public static TransitionInfo createTransitionInfo$default(InfiniteTransition.TransitionAnimationState infiniteTransition$TransitionAnimationState, long l2, long l3, int i4, Object object5) {
        int obj1;
        if (obj5 &= 1 != 0) {
            obj1 = 1;
        }
        return Utils_androidKt.createTransitionInfo(transitionAnimationState, obj1, l3);
    }

    public static TransitionInfo createTransitionInfo$default(Transition.TransitionAnimationState transition$TransitionAnimationState, long l2, int i3, Object object4) {
        int obj1;
        if (object4 &= 1 != 0) {
            obj1 = 1;
        }
        return Utils_androidKt.createTransitionInfo(transitionAnimationState, obj1);
    }

    private static final long createTransitionInfo$lambda$1(Lazy<Long> $startTimeMs$delegate) {
        return (Number)$startTimeMs$delegate.getValue().longValue();
    }

    private static final <T> Map<Long, T> createTransitionInfo$lambda$2(Lazy<? extends Map<Long, T>> $values$delegate) {
        return (Map)$values$delegate.getValue();
    }

    private static final <T> Map<Long, T> createTransitionInfo$lambda$3(Lazy<? extends Map<Long, T>> $values$delegate) {
        return (Map)$values$delegate.getValue();
    }

    public static final List<String> getIGNORE_TRANSITIONS() {
        return Utils_androidKt.IGNORE_TRANSITIONS;
    }

    public static final long millisToNanos(long timeMs) {
        return i *= timeMs;
    }

    public static final long nanosToMillis(long timeNs) {
        return i2 /= l2;
    }

    public static final <T> TargetState<T> parseParametersToValue(T currentValue, Object par1, Object par2) {
        boolean parametersToValue$parametersAreValid;
        TargetState parametersToValue$parseDp;
        boolean z;
        Object obj;
        Size floatValue7;
        Object floatValue;
        float floatValue5;
        Size box-impl;
        Object floatValue8;
        Object box-impl2;
        float floatValue6;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        int i3;
        int i;
        int i2;
        final Object obj8 = currentValue;
        final Object obj9 = par1;
        final Object obj10 = par2;
        int i4 = 0;
        if (obj8 == null) {
            return i4;
        }
        TargetState parametersToValue$parseDp2 = Utils_androidKt.parseParametersToValue$parseDp(currentValue, par1, par2);
        if (parametersToValue$parseDp2 != null) {
            int i5 = 0;
            return parametersToValue$parseDp2;
        }
        if (!Utils_androidKt.parseParametersToValue$parametersAreValid(par1, par2)) {
            return i4;
        }
        Intrinsics.checkNotNull(obj10);
        if (Utils_androidKt.parseParametersToValue$parametersHasTheSameType(currentValue, par1, par2)) {
            TargetState targetState = new TargetState(obj9, obj10);
            return targetState;
        }
        if (obj9 instanceof List != null && obj10 instanceof List != null) {
            if (obj10 instanceof List != null) {
                String str = "null cannot be cast to non-null type kotlin.Int";
                floatValue = 1;
                floatValue5 = 0;
                if (obj8 instanceof IntSize) {
                    Object obj34 = (List)obj9.get(floatValue5);
                    Intrinsics.checkNotNull(obj34, str);
                    Object obj46 = (List)obj9.get(floatValue);
                    Intrinsics.checkNotNull(obj46, str);
                    int intValue6 = (Integer)obj46.intValue();
                    Object obj26 = (List)obj10.get(floatValue5);
                    Intrinsics.checkNotNull(obj26, str);
                    floatValue = (List)obj10.get(floatValue);
                    Intrinsics.checkNotNull(floatValue, str);
                    parametersToValue$parseDp = new TargetState(IntSize.box-impl(IntSizeKt.IntSize((Integer)obj34.intValue(), intValue6)), IntSize.box-impl(IntSizeKt.IntSize((Integer)obj26.intValue(), (Integer)floatValue.intValue())));
                    Intrinsics.checkNotNull(parametersToValue$parseDp, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.states.TargetState<T of androidx.compose.ui.tooling.animation.clock.Utils_androidKt.parseParametersToValue>");
                    return parametersToValue$parseDp;
                } else {
                    if (obj8 instanceof IntOffset != null) {
                        Object obj32 = (List)obj9.get(floatValue5);
                        Intrinsics.checkNotNull(obj32, str);
                        Object obj43 = (List)obj9.get(floatValue);
                        Intrinsics.checkNotNull(obj43, str);
                        int intValue5 = (Integer)obj43.intValue();
                        Object obj25 = (List)obj10.get(floatValue5);
                        Intrinsics.checkNotNull(obj25, str);
                        floatValue = (List)obj10.get(floatValue);
                        Intrinsics.checkNotNull(floatValue, str);
                        parametersToValue$parseDp = new TargetState(IntOffset.box-impl(IntOffsetKt.IntOffset((Integer)obj32.intValue(), intValue5)), IntOffset.box-impl(IntOffsetKt.IntOffset((Integer)obj25.intValue(), (Integer)floatValue.intValue())));
                    } else {
                        String str2 = "null cannot be cast to non-null type kotlin.Float";
                        if (obj8 instanceof Size) {
                            Object obj28 = (List)obj9.get(floatValue5);
                            Intrinsics.checkNotNull(obj28, str2);
                            Object obj36 = (List)obj9.get(floatValue);
                            Intrinsics.checkNotNull(obj36, str2);
                            float floatValue13 = (Float)obj36.floatValue();
                            Object obj21 = (List)obj10.get(floatValue5);
                            Intrinsics.checkNotNull(obj21, str2);
                            floatValue = (List)obj10.get(floatValue);
                            Intrinsics.checkNotNull(floatValue, str2);
                            parametersToValue$parseDp = new TargetState(Size.box-impl(SizeKt.Size((Float)obj28.floatValue(), floatValue13)), Size.box-impl(SizeKt.Size((Float)obj21.floatValue(), (Float)floatValue.floatValue())));
                        } else {
                            if (obj8 instanceof Offset != null) {
                                Object obj30 = (List)obj9.get(floatValue5);
                                Intrinsics.checkNotNull(obj30, str2);
                                Object obj40 = (List)obj9.get(floatValue);
                                Intrinsics.checkNotNull(obj40, str2);
                                float floatValue14 = (Float)obj40.floatValue();
                                Object obj24 = (List)obj10.get(floatValue5);
                                Intrinsics.checkNotNull(obj24, str2);
                                floatValue = (List)obj10.get(floatValue);
                                Intrinsics.checkNotNull(floatValue, str2);
                                parametersToValue$parseDp = new TargetState(Offset.box-impl(OffsetKt.Offset((Float)obj30.floatValue(), floatValue14)), Offset.box-impl(OffsetKt.Offset((Float)obj24.floatValue(), (Float)floatValue.floatValue())));
                            } else {
                                box-impl = 3;
                                floatValue8 = 2;
                                if (obj8 instanceof Rect) {
                                    Object obj58 = (List)obj9.get(floatValue5);
                                    Intrinsics.checkNotNull(obj58, str2);
                                    Object obj60 = (List)obj9.get(floatValue);
                                    Intrinsics.checkNotNull(obj60, str2);
                                    Object obj65 = (List)obj9.get(floatValue8);
                                    Intrinsics.checkNotNull(obj65, str2);
                                    Object obj67 = (List)obj9.get(box-impl);
                                    Intrinsics.checkNotNull(obj67, str2);
                                    box-impl2 = new Rect((Float)obj58.floatValue(), (Float)obj60.floatValue(), (Float)obj65.floatValue(), (Float)obj67.floatValue());
                                    Object obj23 = (List)obj10.get(floatValue5);
                                    Intrinsics.checkNotNull(obj23, str2);
                                    Object obj20 = (List)obj10.get(floatValue);
                                    Intrinsics.checkNotNull(obj20, str2);
                                    Object obj38 = (List)obj10.get(floatValue8);
                                    Intrinsics.checkNotNull(obj38, str2);
                                    box-impl = (List)obj10.get(box-impl);
                                    Intrinsics.checkNotNull(box-impl, str2);
                                    floatValue6 = new Rect((Float)obj23.floatValue(), (Float)obj20.floatValue(), (Float)obj38.floatValue(), (Float)box-impl.floatValue());
                                    parametersToValue$parseDp = new TargetState(box-impl2, floatValue6);
                                } else {
                                    if (obj8 instanceof Color) {
                                        Object obj49 = (List)obj9.get(floatValue5);
                                        Intrinsics.checkNotNull(obj49, str2);
                                        float floatValue15 = (Float)obj49.floatValue();
                                        Object obj51 = (List)obj9.get(floatValue);
                                        Intrinsics.checkNotNull(obj51, str2);
                                        Object obj53 = (List)obj9.get(floatValue8);
                                        Intrinsics.checkNotNull(obj53, str2);
                                        Object obj55 = (List)obj9.get(box-impl);
                                        Intrinsics.checkNotNull(obj55, str2);
                                        Object obj22 = (List)obj10.get(floatValue5);
                                        Intrinsics.checkNotNull(obj22, str2);
                                        Object obj16 = (List)obj10.get(floatValue);
                                        Intrinsics.checkNotNull(obj16, str2);
                                        Object obj18 = (List)obj10.get(floatValue8);
                                        Intrinsics.checkNotNull(obj18, str2);
                                        floatValue = (List)obj10.get(box-impl);
                                        Intrinsics.checkNotNull(floatValue, str2);
                                        parametersToValue$parseDp = new TargetState(Color.box-impl(ColorKt.Color$default(floatValue15, (Float)obj51.floatValue(), (Float)obj53.floatValue(), (Float)obj55.floatValue(), 0, 16, 0)), Color.box-impl(ColorKt.Color$default((Float)obj22.floatValue(), (Float)obj16.floatValue(), (Float)obj18.floatValue(), (Float)floatValue.floatValue(), 0, 16, 0)));
                                    } else {
                                        if (obj8 instanceof Dp) {
                                            Object obj7 = (List)obj9.get(floatValue5);
                                            Intrinsics.checkNotNull(obj7);
                                            floatValue7 = (List)obj10.get(floatValue5);
                                            Intrinsics.checkNotNull(floatValue7);
                                            parametersToValue$parseDp = Utils_androidKt.parseParametersToValue$parseDp(obj8, obj7, floatValue7);
                                        } else {
                                            Object obj5 = (List)obj9.get(floatValue5);
                                            Intrinsics.checkNotNull(obj5);
                                            obj = (List)obj10.get(floatValue5);
                                            Intrinsics.checkNotNull(obj);
                                            if (Utils_androidKt.parseParametersToValue$parametersAreValid((List)obj9.get(floatValue5), (List)obj10.get(floatValue5)) && Utils_androidKt.parseParametersToValue$parametersHasTheSameType(obj8, obj5, obj)) {
                                                obj5 = (List)obj9.get(floatValue5);
                                                Intrinsics.checkNotNull(obj5);
                                                obj = (List)obj10.get(floatValue5);
                                                Intrinsics.checkNotNull(obj);
                                                if (Utils_androidKt.parseParametersToValue$parametersHasTheSameType(obj8, obj5, obj)) {
                                                    parametersToValue$parseDp = new TargetState((List)obj9.get(floatValue5), (List)obj10.get(floatValue5));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return i4;
            }
        }
        return i4;
    }

    private static final Dp parseParametersToValue$getDp(Object par) {
        Object $this$dp$iv;
        int i;
        Object obj;
        Object box-impl;
        int doubleValue;
        float f;
        box-impl = 0;
        if (par instanceof Dp) {
            $this$dp$iv = par;
        } else {
            $this$dp$iv = box-impl;
        }
        if ($this$dp$iv == null) {
            if (par instanceof Float) {
                i = par;
            } else {
                i = box-impl;
            }
            if (i != 0) {
                doubleValue = 0;
                $this$dp$iv = Dp.box-impl(Dp.constructor-impl(i.floatValue()));
            } else {
                $this$dp$iv = box-impl;
            }
            if ($this$dp$iv == 0) {
                if (par instanceof Double) {
                    obj = par;
                } else {
                    obj = box-impl;
                }
                if (obj != null) {
                    int i2 = 0;
                    $this$dp$iv = Dp.box-impl(Dp.constructor-impl((float)doubleValue));
                } else {
                    $this$dp$iv = box-impl;
                }
                if ($this$dp$iv == null) {
                    if (par instanceof Integer) {
                        $this$dp$iv = par;
                    } else {
                        $this$dp$iv = box-impl;
                    }
                    if ($this$dp$iv != 0) {
                        int i3 = 0;
                        box-impl = Dp.box-impl(Dp.constructor-impl((float)intValue));
                    }
                } else {
                    box-impl = $this$dp$iv;
                }
            } else {
            }
        } else {
        }
        return box-impl;
    }

    private static final boolean parseParametersToValue$parametersAreValid(Object par1, Object par2) {
        int i;
        Class class2;
        Class class;
        if (par1 != null && par2 != null && par1.getClass() == par2.getClass()) {
            if (par2 != null) {
                i = par1.getClass() == par2.getClass() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean parseParametersToValue$parametersHasTheSameType(Object value, Object par1, Object par2) {
        Class class;
        int i;
        Class class2;
        if (value.getClass() == par1.getClass() && value.getClass() == par2.getClass()) {
            i = value.getClass() == par2.getClass() ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final <T> TargetState<Dp> parseParametersToValue$parseDp(T $currentValue, Object par1, Object par2) {
        Dp parametersToValue$getDp;
        TargetState targetState;
        Dp parametersToValue$getDp2;
        if ($currentValue instanceof Dp) {
            if (par2 == null) {
            } else {
                if (par1 instanceof Dp && par2 instanceof Dp) {
                    if (par2 instanceof Dp) {
                        targetState = new TargetState(par1, par2);
                    } else {
                        parametersToValue$getDp = Utils_androidKt.parseParametersToValue$getDp(par1);
                        parametersToValue$getDp2 = Utils_androidKt.parseParametersToValue$getDp(par2);
                        if (parametersToValue$getDp != null && parametersToValue$getDp2 != null) {
                            if (parametersToValue$getDp2 != null) {
                                targetState = new TargetState(parametersToValue$getDp, parametersToValue$getDp2);
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
            return targetState;
        }
        return 0;
    }
}
