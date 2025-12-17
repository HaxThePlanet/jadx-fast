package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.clock.AnimateXAsStateClock;
import androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock;
import androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock;
import androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock;
import androidx.compose.ui.tooling.animation.clock.TransitionClock;
import androidx.compose.ui.tooling.animation.clock.Utils_androidKt;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState.Companion;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u00105\u001a\u00020\u00042\u0008\u00106\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u00107\u001a\u00020\u0004J\u001a\u00108\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u0003\u0018\u00010\u000c2\u0006\u00109\u001a\u00020:H\u0002J\u0014\u0010;\u001a\u0008\u0012\u0004\u0012\u00020<0\u000b2\u0006\u00109\u001a\u00020:J\u001b\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020:ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008@\u0010AJ\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020CJ\u001c\u0010E\u001a\u0008\u0012\u0004\u0012\u00020F0\u000b2\u0006\u00109\u001a\u00020:2\u0006\u0010G\u001a\u00020CJ\u0010\u0010H\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0015J\u0010\u0010I\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0015J\u000e\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020CJ\u001a\u0010L\u001a\u00020\u00042\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020C0MJ\u000e\u0010N\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0001J\u0016\u0010O\u001a\u00020\u00042\u000e\u00109\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030PJ\u0012\u0010Q\u001a\u00020\u00042\n\u00109\u001a\u0006\u0012\u0002\u0008\u00030RJ\"\u0010S\u001a\u00020\u00042\n\u00109\u001a\u0006\u0012\u0002\u0008\u00030R2\u000e\u0008\u0002\u0010T\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003J$\u0010U\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00012\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040WH\u0002J\u0016\u0010X\u001a\u00020\u00042\u000e\u00109\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030YJ\u000e\u0010Z\u001a\u00020\u00042\u0006\u00109\u001a\u00020[J\u0016\u0010\\\u001a\u00020\u00042\u000e\u00109\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030]J\u0012\u0010^\u001a\u00020\u00042\n\u00109\u001a\u0006\u0012\u0002\u0008\u00030RJ\u0018\u0010_\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00012\u0006\u00106\u001a\u00020\tH\u0002J\u0016\u0010`\u001a\u00020\u00042\u0006\u0010?\u001a\u00020:2\u0006\u0010a\u001a\u00020\u0001J\u001e\u0010b\u001a\u00020\u00042\u0006\u0010?\u001a\u00020:2\u0006\u0010c\u001a\u00020\u00012\u0006\u0010d\u001a\u00020\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u000c0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\"\u0010\u000f\u001a\u0010\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u000c0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000eR8\u0010\u0011\u001a\u001e\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0013\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u00140\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018R0\u0010\u0019\u001a\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u001b0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001c\u0010\u0016\u001a\u0004\u0008\u001d\u0010\u0018R(\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008!\u0010\u0016\u001a\u0004\u0008\"\u0010\u0018R(\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008&\u0010\u0016\u001a\u0004\u0008'\u0010\u0018R\u000e\u0010(\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00010*j\u0008\u0012\u0004\u0012\u00020\u0001`+X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010,\u001a\u0012\u0012\u0004\u0012\u00020-0*j\u0008\u0012\u0004\u0012\u00020-`+8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008.\u0010\u0016\u001a\u0004\u0008/\u00100R0\u00101\u001a\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u000302\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u001b0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00083\u0010\u0016\u001a\u0004\u00084\u0010\u0018\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006e", d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "", "setAnimationsTimeCallback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "DEBUG", "", "TAG", "", "allClocks", "", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "getAllClocks", "()Ljava/util/List;", "allClocksExceptInfinite", "getAllClocksExceptInfinite", "animateXAsStateClocks", "", "Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimateXAsStateClock;", "getAnimateXAsStateClocks$ui_tooling_release$annotations", "()V", "getAnimateXAsStateClocks$ui_tooling_release", "()Ljava/util/Map;", "animatedContentClocks", "Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/TransitionClock;", "getAnimatedContentClocks$ui_tooling_release$annotations", "getAnimatedContentClocks$ui_tooling_release", "animatedVisibilityClocks", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimatedVisibilityClock;", "getAnimatedVisibilityClocks$ui_tooling_release$annotations", "getAnimatedVisibilityClocks$ui_tooling_release", "infiniteTransitionClocks", "Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/InfiniteTransitionClock;", "getInfiniteTransitionClocks$ui_tooling_release$annotations", "getInfiniteTransitionClocks$ui_tooling_release", "lock", "trackedAnimations", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "trackedUnsupportedAnimations", "Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation;", "getTrackedUnsupportedAnimations$annotations", "getTrackedUnsupportedAnimations", "()Ljava/util/LinkedHashSet;", "transitionClocks", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "getTransitionClocks$ui_tooling_release$annotations", "getTransitionClocks$ui_tooling_release", "createUnsupported", "label", "dispose", "findClock", "animation", "Landroidx/compose/animation/tooling/ComposeAnimation;", "getAnimatedProperties", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getAnimatedVisibilityState", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "composeAnimation", "getAnimatedVisibilityState-cc2g1to", "(Landroidx/compose/animation/tooling/ComposeAnimation;)Ljava/lang/String;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "notifySubscribe", "notifyUnsubscribe", "setClockTime", "animationTimeMillis", "setClockTimes", "", "trackAnimateContentSize", "trackAnimateXAsState", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimatedContent", "Landroidx/compose/animation/core/Transition;", "trackAnimatedVisibility", "onSeek", "trackAnimation", "createClockAndSubscribe", "Lkotlin/Function1;", "trackDecayAnimations", "Landroidx/compose/animation/core/DecayAnimation;", "trackInfiniteTransition", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackTargetBasedAnimations", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackTransition", "trackUnsupported", "updateAnimatedVisibilityState", "state", "updateFromAndToStates", "fromState", "toState", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PreviewAnimationClock {

    public static final int $stable = 8;
    private final boolean DEBUG;
    private final String TAG;
    private final Map<androidx.compose.ui.tooling.animation.AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> animateXAsStateClocks;
    private final Map<androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation<?>, TransitionClock<?>> animatedContentClocks;
    private final Map<androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> animatedVisibilityClocks;
    private final Map<androidx.compose.ui.tooling.animation.InfiniteTransitionComposeAnimation, InfiniteTransitionClock> infiniteTransitionClocks;
    private final Object lock;
    private final Function0<Unit> setAnimationsTimeCallback;
    private final LinkedHashSet<Object> trackedAnimations;
    private final LinkedHashSet<androidx.compose.ui.tooling.animation.UnsupportedComposeAnimation> trackedUnsupportedAnimations;
    private final Map<androidx.compose.ui.tooling.animation.TransitionComposeAnimation<?>, TransitionClock<?>> transitionClocks;
    static {
        final int i = 8;
    }

    public PreviewAnimationClock() {
        final int i = 0;
        super(i, 1, i);
    }

    public PreviewAnimationClock(Function0<Unit> setAnimationsTimeCallback) {
        super();
        this.setAnimationsTimeCallback = setAnimationsTimeCallback;
        this.TAG = "PreviewAnimationClock";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.transitionClocks = (Map)linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.animatedVisibilityClocks = (Map)linkedHashMap2;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        this.animateXAsStateClocks = (Map)linkedHashMap3;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        this.infiniteTransitionClocks = (Map)linkedHashMap4;
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        this.animatedContentClocks = (Map)linkedHashMap5;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.trackedUnsupportedAnimations = linkedHashSet;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        this.trackedAnimations = linkedHashSet2;
        Object object = new Object();
        this.lock = object;
    }

    public PreviewAnimationClock(Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        androidx.compose.ui.tooling.animation.PreviewAnimationClock.1 obj1;
        if (i2 &= 1 != 0) {
            obj1 = PreviewAnimationClock.1.INSTANCE;
        }
        super(obj1);
    }

    public static final void access$createUnsupported(androidx.compose.ui.tooling.animation.PreviewAnimationClock $this, String label) {
        $this.createUnsupported(label);
    }

    public static final List access$getAllClocksExceptInfinite(androidx.compose.ui.tooling.animation.PreviewAnimationClock $this) {
        return $this.getAllClocksExceptInfinite();
    }

    private final void createUnsupported(String label) {
        int i;
        androidx.compose.ui.tooling.animation.UnsupportedComposeAnimation unsupportedComposeAnimation;
        androidx.compose.ui.tooling.animation.UnsupportedComposeAnimation create = UnsupportedComposeAnimation.Companion.create(label);
        if (create != null) {
            i = 0;
            this.trackedUnsupportedAnimations.add(create);
            notifySubscribe((ComposeAnimation)create);
        }
    }

    private final ComposeAnimationClock<?, ?> findClock(ComposeAnimation animation) {
        Object obj;
        if ((TransitionClock)this.transitionClocks.get(animation) != null) {
        } else {
        }
        return obj;
    }

    private final List<ComposeAnimationClock<?, ?>> getAllClocks() {
        return CollectionsKt.plus((Collection)getAllClocksExceptInfinite(), (Iterable)this.infiniteTransitionClocks.values());
    }

    private final List<ComposeAnimationClock<?, ?>> getAllClocksExceptInfinite() {
        return CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)CollectionsKt.plus(this.transitionClocks.values(), (Iterable)this.animatedVisibilityClocks.values()), (Iterable)this.animateXAsStateClocks.values()), (Iterable)this.animatedContentClocks.values());
    }

    public static void getAnimateXAsStateClocks$ui_tooling_release$annotations() {
    }

    public static void getAnimatedContentClocks$ui_tooling_release$annotations() {
    }

    public static void getAnimatedVisibilityClocks$ui_tooling_release$annotations() {
    }

    public static void getInfiniteTransitionClocks$ui_tooling_release$annotations() {
    }

    public static void getTrackedUnsupportedAnimations$annotations() {
    }

    public static void getTransitionClocks$ui_tooling_release$annotations() {
    }

    public static void trackAnimatedVisibility$default(androidx.compose.ui.tooling.animation.PreviewAnimationClock previewAnimationClock, Transition transition2, Function0 function03, int i4, Object object5) {
        androidx.compose.ui.tooling.animation.PreviewAnimationClock.trackAnimatedVisibility.1 obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = PreviewAnimationClock.trackAnimatedVisibility.1.INSTANCE;
            }
            previewAnimationClock.trackAnimatedVisibility(transition2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAnimatedVisibility");
        throw obj0;
    }

    private final boolean trackAnimation(Object animation, Function1<Object, Unit> createClockAndSubscribe) {
        boolean dEBUG;
        int string2;
        boolean dEBUG2;
        Object trackedAnimations;
        String string;
        String str;
        Object lock = this.lock;
        string2 = 0;
        synchronized (lock) {
            if (this.DEBUG) {
                StringBuilder stringBuilder2 = new StringBuilder();
                Log.d(this.TAG, stringBuilder2.append("Animation ").append(animation).append(" is already being tracked").toString());
            }
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Log.d(this.TAG, stringBuilder.append("Animation ").append(animation).append(" is now tracked").toString());
        return 1;
    }

    private final void trackUnsupported(Object animation, String label) {
        PreviewAnimationClock.trackUnsupported.1 anon = new PreviewAnimationClock.trackUnsupported.1(this, label);
        trackAnimation(animation, (Function1)anon);
    }

    public final void dispose() {
        Object next;
        boolean next2;
        Object obj;
        int i;
        ComposeAnimation animation;
        int i2 = 0;
        Iterator iterator = (Iterable)getAllClocks().iterator();
        for (Object next : iterator) {
            i = 0;
            notifyUnsubscribe((ComposeAnimationClock)next.getAnimation());
        }
        int i3 = 0;
        Iterator iterator2 = (Iterable)this.trackedUnsupportedAnimations.iterator();
        for (Object next2 : iterator2) {
            i = 0;
            notifyUnsubscribe((ComposeAnimation)(UnsupportedComposeAnimation)next2);
        }
        this.trackedUnsupportedAnimations.clear();
        this.transitionClocks.clear();
        this.animatedVisibilityClocks.clear();
        this.trackedAnimations.clear();
    }

    public final Map<androidx.compose.ui.tooling.animation.AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> getAnimateXAsStateClocks$ui_tooling_release() {
        return this.animateXAsStateClocks;
    }

    public final Map<androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation<?>, TransitionClock<?>> getAnimatedContentClocks$ui_tooling_release() {
        return this.animatedContentClocks;
    }

    public final List<ComposeAnimatedProperty> getAnimatedProperties(ComposeAnimation animation) {
        List animatedProperties;
        animatedProperties = findClock(animation);
        if (animatedProperties != null) {
            if (animatedProperties.getAnimatedProperties() == null) {
                animatedProperties = CollectionsKt.emptyList();
            }
        } else {
        }
        return animatedProperties;
    }

    public final Map<androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> getAnimatedVisibilityClocks$ui_tooling_release() {
        return this.animatedVisibilityClocks;
    }

    public final String getAnimatedVisibilityState-cc2g1to(ComposeAnimation composeAnimation) {
        String state-jXw82LU;
        Object obj = this.animatedVisibilityClocks.get(composeAnimation);
        if ((AnimatedVisibilityClock)obj != null) {
            state-jXw82LU = (AnimatedVisibilityClock)obj.getState-jXw82LU();
        } else {
            state-jXw82LU = AnimatedVisibilityState.Companion.getEnter-jXw82LU();
        }
        return state-jXw82LU;
    }

    public final Map<androidx.compose.ui.tooling.animation.InfiniteTransitionComposeAnimation, InfiniteTransitionClock> getInfiniteTransitionClocks$ui_tooling_release() {
        return this.infiniteTransitionClocks;
    }

    public final long getMaxDuration() {
        Long num;
        int longValue;
        Long valueOf2;
        boolean next;
        int valueOf;
        int compareTo;
        Iterator iterator = (Iterable)getAllClocks().iterator();
        if (!iterator.hasNext()) {
            num = 0;
        } else {
            valueOf2 = Long.valueOf((ComposeAnimationClock)iterator.next().getMaxDuration());
            while (iterator.hasNext()) {
                valueOf = Long.valueOf((ComposeAnimationClock)iterator.next().getMaxDuration());
                if (valueOf2.compareTo((Comparable)valueOf) < 0) {
                }
                valueOf2 = valueOf;
            }
            num = valueOf2;
        }
        if ((Long)num != null) {
            longValue = (Long)num.longValue();
        } else {
            longValue = 0;
        }
        return longValue;
    }

    public final long getMaxDurationPerIteration() {
        Long num;
        int longValue;
        Long valueOf2;
        boolean next;
        int valueOf;
        int compareTo;
        Iterator iterator = (Iterable)getAllClocks().iterator();
        if (!iterator.hasNext()) {
            num = 0;
        } else {
            valueOf2 = Long.valueOf((ComposeAnimationClock)iterator.next().getMaxDurationPerIteration());
            while (iterator.hasNext()) {
                valueOf = Long.valueOf((ComposeAnimationClock)iterator.next().getMaxDurationPerIteration());
                if (valueOf2.compareTo((Comparable)valueOf) < 0) {
                }
                valueOf2 = valueOf;
            }
            num = valueOf2;
        }
        if ((Long)num != null) {
            longValue = (Long)num.longValue();
        } else {
            longValue = 0;
        }
        return longValue;
    }

    public final LinkedHashSet<androidx.compose.ui.tooling.animation.UnsupportedComposeAnimation> getTrackedUnsupportedAnimations() {
        return this.trackedUnsupportedAnimations;
    }

    public final Map<androidx.compose.ui.tooling.animation.TransitionComposeAnimation<?>, TransitionClock<?>> getTransitionClocks$ui_tooling_release() {
        return this.transitionClocks;
    }

    public final List<TransitionInfo> getTransitions(ComposeAnimation animation, long stepMillis) {
        List emptyList;
        emptyList = findClock(animation);
        if (emptyList != null) {
            if (emptyList.getTransitions(stepMillis) == null) {
                emptyList = CollectionsKt.emptyList();
            }
        } else {
        }
        return emptyList;
    }

    protected void notifySubscribe(ComposeAnimation animation) {
    }

    protected void notifyUnsubscribe(ComposeAnimation animation) {
    }

    public final void setClockTime(long animationTimeMillis) {
        Object next;
        Object obj;
        int i;
        final int i2 = 0;
        final Iterator iterator = (Iterable)getAllClocks().iterator();
        for (Object next : iterator) {
            i = 0;
            (ComposeAnimationClock)next.setClockTime(Utils_androidKt.millisToNanos(animationTimeMillis));
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void setClockTimes(Map<ComposeAnimation, Long> animationTimeMillis) {
        Object next;
        int i;
        Object key;
        long longValue;
        ComposeAnimationClock clock;
        long millisToNanos;
        final int i2 = 0;
        Iterator iterator = animationTimeMillis.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            i = 0;
            clock = findClock((ComposeAnimation)(Map.Entry)next.getKey());
            if (clock != null) {
            }
            clock.setClockTime(Utils_androidKt.millisToNanos((Number)next.getValue().longValue()));
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void trackAnimateContentSize(Object animation) {
        trackUnsupported(animation, "animateContentSize");
    }

    public final void trackAnimateXAsState(androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo<?, ?> animation) {
        PreviewAnimationClock.trackAnimateXAsState.1 anon = new PreviewAnimationClock.trackAnimateXAsState.1(animation, this);
        trackAnimation(animation.getAnimatable(), (Function1)anon);
    }

    public final void trackAnimatedContent(Transition<?> animation) {
        PreviewAnimationClock.trackAnimatedContent.1 anon = new PreviewAnimationClock.trackAnimatedContent.1(animation, this);
        trackAnimation(animation, (Function1)anon);
    }

    public final void trackAnimatedVisibility(Transition<?> animation, Function0<Unit> onSeek) {
        if (!currentState instanceof Boolean) {
        }
        PreviewAnimationClock.trackAnimatedVisibility.2 anon = new PreviewAnimationClock.trackAnimatedVisibility.2(animation, onSeek, this);
        trackAnimation(animation, (Function1)anon);
    }

    public final void trackDecayAnimations(DecayAnimation<?, ?> animation) {
        trackUnsupported(animation, "DecayAnimation");
    }

    public final void trackInfiniteTransition(androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo animation) {
        PreviewAnimationClock.trackInfiniteTransition.1 anon = new PreviewAnimationClock.trackInfiniteTransition.1(animation, this);
        trackAnimation(animation.getInfiniteTransition(), (Function1)anon);
    }

    public final void trackTargetBasedAnimations(TargetBasedAnimation<?, ?> animation) {
        trackUnsupported(animation, "TargetBasedAnimation");
    }

    public final void trackTransition(Transition<?> animation) {
        PreviewAnimationClock.trackTransition.1 anon = new PreviewAnimationClock.trackTransition.1(animation, this);
        trackAnimation(animation, (Function1)anon);
    }

    public final void updateAnimatedVisibilityState(ComposeAnimation composeAnimation, Object state) {
        int i2;
        int i;
        Object obj = this.animatedVisibilityClocks.get(composeAnimation);
        if ((AnimatedVisibilityClock)obj != null) {
            i = 0;
            ComposeAnimationClock.setStateParameters$default((ComposeAnimationClock)(AnimatedVisibilityClock)obj, state, i, 2, i);
        }
    }

    public final void updateFromAndToStates(ComposeAnimation composeAnimation, Object fromState, Object toState) {
        final ComposeAnimationClock clock = findClock(composeAnimation);
        if (clock != null) {
            clock.setStateParameters(fromState, toState);
        }
    }
}
