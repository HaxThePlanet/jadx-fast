package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0000\u001a\u0010\u0010<\u001a\u00020=2\u0006\u0010:\u001a\u00020;H\u0000\u001a(\u0010>\u001a\u0004\u0018\u00010\u00042\u0008\u0010?\u001a\u0004\u0018\u00010\u00042\u0008\u0010@\u001a\u0004\u0018\u00010\u00042\u0008\u0010A\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0008\u0010B\u001a\u00020/H\u0007\u001a1\u0010C\u001a\u000e\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u0002HF0D\"\u0004\u0008\u0000\u0010E\"\u0008\u0008\u0001\u0010F*\u00020\u00042\u0006\u0010G\u001a\u00020\nH\u0002¢\u0006\u0002\u0010H\u001a\u0010\u0010I\u001a\u0002092\u0006\u0010?\u001a\u00020/H\u0000\u001a*\u0010I\u001a\u0002092\u0006\u0010?\u001a\u00020/2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020;0KH\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a\u0018\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010L\u001a\u00020;H\u0007\u001a\u0010\u0010O\u001a\u0002092\u0006\u0010M\u001a\u00020NH\u0007\u001a \u0010P\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010L\u001a\u00020;H\u0007\u001a\u0008\u0010R\u001a\u000209H\u0007\u001a(\u0010S\u001a\u0002092\u0006\u0010Q\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020;H\u0007\u001a\u0018\u0010S\u001a\u0002092\u0006\u0010Q\u001a\u00020\n2\u0006\u0010V\u001a\u00020;H\u0007\u001a\u000c\u0010W\u001a\u00020/*\u00020\nH\u0002\u001a\u000c\u0010X\u001a\u00020\n*\u00020/H\u0002\u001a3\u0010Y\u001a\u0002HZ\"\u0004\u0008\u0000\u0010Z*\u00020N2\u0006\u0010[\u001a\u00020/2\u0011\u0010\\\u001a\r\u0012\u0004\u0012\u0002HZ0K¢\u0006\u0002\u0008]H\u0087\u0008¢\u0006\u0002\u0010^\u001a\u001c\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040`*\u00020a2\u0006\u0010b\u001a\u00020cH\u0002\u001a\u0014\u0010d\u001a\u000209*\u0002022\u0006\u0010e\u001a\u00020fH\u0000\u001a\u001c\u0010g\u001a\u00020\n*\u0002002\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\nH\u0002\u001a(\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\u00020k*\u0008\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0002\u001a\u001a\u0010n\u001a\u00020\n*\u0008\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\nH\u0002\u001a\u001a\u0010p\u001a\u00020\n*\u0008\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\nH\u0002\u001a$\u0010q\u001a\u0004\u0018\u00010\u0002*\u0008\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0002\u001a,\u0010r\u001a\u000209*\u0008\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\n2\u0006\u0010s\u001a\u00020t2\u0008\u0010u\u001a\u0004\u0018\u00010\u0004H\u0002\u001a$\u0010v\u001a\u00020\n*\u0002002\u0006\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020\n2\u0006\u0010y\u001a\u00020\nH\u0002\u001a\u0014\u0010z\u001a\u000209*\u0002022\u0006\u0010e\u001a\u00020fH\u0000\u001a&\u0010{\u001a\u000209*\u0002022\u0006\u0010|\u001a\u00020\n2\u0006\u0010h\u001a\u00020\n2\u0008\u0010}\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u001c\u0010~\u001a\u0004\u0018\u00010\u0002*\u0008\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010o\u001a\u00020\nH\u0002\u001a\"\u0010\u007f\u001a\u000209*\u0008\u0012\u0004\u0012\u00020\u00020k2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0002\u001a<\u0010\u0080\u0001\u001a\u000209\"\u0005\u0008\u0000\u0010\u0081\u0001*\u0002022\u0008\u0010b\u001a\u0004\u0018\u00010c2\u001b\u0010\u0082\u0001\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0005\u0012\u0003H\u0081\u00010\u0083\u0001H\u0080\u0008\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0008\"\u0016\u0010\t\u001a\u00020\n8\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000b\u0010\u0006\"\u0016\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000e\u0010\u0006\"\u000e\u0010\u000f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0011\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0012\u0010\u0006\u001a\u0004\u0008\u0013\u0010\u0008\"\u0016\u0010\u0014\u001a\u00020\n8\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0015\u0010\u0006\"\u000e\u0010\u0016\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0017\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0018\u0010\u0006\u001a\u0004\u0008\u0019\u0010\u0008\"\u0016\u0010\u001a\u001a\u00020\n8\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u001b\u0010\u0006\"\u001c\u0010\u001c\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001d\u0010\u0006\u001a\u0004\u0008\u001e\u0010\u0008\"\u0016\u0010\u001f\u001a\u00020\n8\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008 \u0010\u0006\"\u001c\u0010!\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\"\u0010\u0006\u001a\u0004\u0008#\u0010\u0008\"\u0016\u0010$\u001a\u00020\n8\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008%\u0010\u0006\"\u001c\u0010&\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008'\u0010\u0006\u001a\u0004\u0008(\u0010\u0008\"\u0016\u0010)\u001a\u00020\n8\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008*\u0010\u0006\"\u0016\u0010+\u001a\u00020\n8\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008,\u0010\u0006\"\u000e\u0010-\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010.\u001a\u00020/*\u0002008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008.\u00101\"\u0018\u0010.\u001a\u00020/*\u0002028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008.\u00103\"\u0018\u00104\u001a\u00020\u0004*\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00086\u00107¨\u0006\u0084\u0001", d2 = {"InvalidationLocationAscending", "Ljava/util/Comparator;", "Landroidx/compose/runtime/Invalidation;", "compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "reuseKey", "getReuseKey$annotations", "rootKey", "isAfterFirstChild", "", "Landroidx/compose/runtime/SlotReader;", "(Landroidx/compose/runtime/SlotReader;)Z", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;)Z", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeImmediateRuntimeError", "", "message", "", "composeRuntimeError", "", "getKey", "value", "left", "right", "isTraceInProgress", "multiMap", "Landroidx/compose/runtime/MutableScatterMultiMap;", "K", "V", "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "runtimeCheck", "lazyMessage", "Lkotlin/Function0;", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", "T", "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "deactivateCurrentGroup", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "distanceFrom", "index", "root", "filterToRange", "", "start", "end", "findInsertLocation", "location", "findLocation", "firstInRange", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "nearestCommonRootOf", "a", "b", "common", "removeCurrentGroup", "removeData", "group", "data", "removeLocation", "removeRange", "withAfterAnchorInfo", "R", "cb", "Lkotlin/Function2;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComposerKt {

    private static final Comparator<androidx.compose.runtime.Invalidation> InvalidationLocationAscending = null;
    private static final Object compositionLocalMap = null;
    public static final int compositionLocalMapKey = 202;
    private static androidx.compose.runtime.CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    private static final Object invocation = null;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final Object provider = null;
    public static final int providerKey = 201;
    private static final Object providerMaps = null;
    public static final int providerMapsKey = 204;
    private static final Object providerValues = null;
    public static final int providerValuesKey = 203;
    private static final Object reference = null;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    public static int $r8$lambda$UXSvu71fSZnFJDgYvdjYUFl0jX4(androidx.compose.runtime.Invalidation invalidation, androidx.compose.runtime.Invalidation invalidation2) {
        return ComposerKt.InvalidationLocationAscending$lambda$15(invalidation, invalidation2);
    }

    static {
        String str = "provider";
        OpaqueKey opaqueKey = new OpaqueKey(str);
        ComposerKt.invocation = opaqueKey;
        OpaqueKey opaqueKey2 = new OpaqueKey(str);
        ComposerKt.provider = opaqueKey2;
        OpaqueKey opaqueKey3 = new OpaqueKey("compositionLocalMap");
        ComposerKt.compositionLocalMap = opaqueKey3;
        OpaqueKey opaqueKey4 = new OpaqueKey("providerValues");
        ComposerKt.providerValues = opaqueKey4;
        OpaqueKey opaqueKey5 = new OpaqueKey("providers");
        ComposerKt.providerMaps = opaqueKey5;
        OpaqueKey opaqueKey6 = new OpaqueKey("reference");
        ComposerKt.reference = opaqueKey6;
        ComposerKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ComposerKt$$ExternalSyntheticLambda0();
        ComposerKt.InvalidationLocationAscending = externalSyntheticLambda0;
    }

    private static final int InvalidationLocationAscending$lambda$15(androidx.compose.runtime.Invalidation i1, androidx.compose.runtime.Invalidation i2) {
        return Intrinsics.compare(i1.getLocation(), i2.getLocation());
    }

    public static final boolean access$asBool(int $receiver) {
        return ComposerKt.asBool($receiver);
    }

    public static final int access$asInt(boolean $receiver) {
        return ComposerKt.asInt($receiver);
    }

    public static final List access$collectNodesFrom(androidx.compose.runtime.SlotTable $receiver, androidx.compose.runtime.Anchor anchor) {
        return ComposerKt.collectNodesFrom($receiver, anchor);
    }

    public static final List access$filterToRange(List $receiver, int start, int end) {
        return ComposerKt.filterToRange($receiver, start, end);
    }

    public static final androidx.compose.runtime.Invalidation access$firstInRange(List $receiver, int start, int end) {
        return ComposerKt.firstInRange($receiver, start, end);
    }

    public static final Comparator access$getInvalidationLocationAscending$p() {
        return ComposerKt.InvalidationLocationAscending;
    }

    public static final Object access$getJoinedKey(androidx.compose.runtime.KeyInfo $receiver) {
        return ComposerKt.getJoinedKey($receiver);
    }

    public static final Object access$getKey(Object value, Object left, Object right) {
        return ComposerKt.getKey(value, left, right);
    }

    public static final void access$insertIfMissing(List $receiver, int location, androidx.compose.runtime.RecomposeScopeImpl scope, Object instance) {
        ComposerKt.insertIfMissing($receiver, location, scope, instance);
    }

    public static final MutableScatterMap access$multiMap(int initialCapacity) {
        return ComposerKt.multiMap(initialCapacity);
    }

    public static final int access$nearestCommonRootOf(androidx.compose.runtime.SlotReader $receiver, int a, int b, int common) {
        return ComposerKt.nearestCommonRootOf($receiver, a, b, common);
    }

    public static final androidx.compose.runtime.Invalidation access$removeLocation(List $receiver, int location) {
        return ComposerKt.removeLocation($receiver, location);
    }

    public static final void access$removeRange(List $receiver, int start, int end) {
        ComposerKt.removeRange($receiver, start, end);
    }

    public static final void access$setCompositionTracer$p(androidx.compose.runtime.CompositionTracer <set-?>) {
        ComposerKt.compositionTracer = <set-?>;
    }

    private static final boolean asBool(int $this$asBool) {
        int i;
        i = $this$asBool != 0 ? 1 : 0;
        return i;
    }

    private static final int asInt(boolean $this$asInt) {
        return $this$asInt;
    }

    @ComposeCompilerApi
    public static final <T> T cache(androidx.compose.runtime.Composer $this$cache, boolean invalid, Function0<? extends T> block) {
        Object invoke;
        Object empty;
        final int i = 0;
        final Object rememberedValue = $this$cache.rememberedValue();
        final int i2 = 0;
        if (!invalid) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                $this$cache.updateRememberedValue(block.invoke());
            } else {
                invoke = rememberedValue;
            }
        } else {
        }
        return invoke;
    }

    private static final List<Object> collectNodesFrom(androidx.compose.runtime.SlotTable $this$collectNodesFrom, androidx.compose.runtime.Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        final int i = 0;
        final androidx.compose.runtime.SlotReader reader = $this$collectNodesFrom.openReader();
        final int i2 = 0;
        final int i3 = 0;
        ComposerKt.collectNodesFrom$lambda$10$collectFromGroup(reader, (List)arrayList, $this$collectNodesFrom.anchorIndex(anchor));
        Unit reader3 = Unit.INSTANCE;
        reader.close();
        return arrayList;
    }

    private static final void collectNodesFrom$lambda$10$collectFromGroup(androidx.compose.runtime.SlotReader $reader, List<Object> result, int group) {
        Object current;
        int i;
        int groupSize;
        if ($reader.isNode(group)) {
            result.add($reader.node(group));
        } else {
            current = group + 1;
            while (current < groupSize2 += group) {
                ComposerKt.collectNodesFrom$lambda$10$collectFromGroup($reader, result, current);
                current += groupSize;
            }
        }
    }

    public static final void composeImmediateRuntimeError(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        ComposeRuntimeError composeRuntimeError = new ComposeRuntimeError(stringBuilder.append("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (").append(message).append("). Please report to Google or use https://goo.gle/compose-feedback").toString());
        throw composeRuntimeError;
    }

    public static final Void composeRuntimeError(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        ComposeRuntimeError composeRuntimeError = new ComposeRuntimeError(stringBuilder.append("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (").append(message).append("). Please report to Google or use https://goo.gle/compose-feedback").toString());
        throw composeRuntimeError;
    }

    public static final void deactivateCurrentGroup(androidx.compose.runtime.SlotWriter $this$deactivateCurrentGroup, androidx.compose.runtime.RememberManager rememberManager) {
        int currentGroup;
        boolean start2;
        int anchor$iv;
        int group;
        Object node;
        androidx.compose.runtime.SlotWriter endRelativeOrder;
        boolean i6;
        int i7;
        int i;
        int i9;
        int i8;
        int slot$iv;
        int i2;
        Object obj;
        int i3;
        boolean wrapped;
        int start;
        androidx.compose.runtime.SlotWriter $this$withAfterAnchorInfo$iv;
        int end;
        int i5;
        int i10;
        int endRelativeAfter$iv;
        Object node2;
        int slotsEndAllIndex$runtime_release;
        int i4;
        androidx.compose.runtime.Anchor anchor;
        final androidx.compose.runtime.SlotWriter writer = $this$deactivateCurrentGroup;
        final Object obj2 = rememberManager;
        anchor$iv = writer.getCurrentGroupEnd();
        group = currentGroup;
        while (group < anchor$iv) {
            node = writer.node(group);
            if (node instanceof ComposeNodeLifecycleCallback != null) {
            }
            endRelativeOrder = $this$deactivateCurrentGroup;
            i7 = 0;
            i9 = SlotWriter.access$slotIndex(endRelativeOrder, SlotWriter.access$getGroups$p(endRelativeOrder), SlotWriter.access$groupIndexToAddress(endRelativeOrder, group));
            slot$iv = i9;
            while (slot$iv < SlotWriter.access$dataIndex(endRelativeOrder, SlotWriter.access$getGroups$p(endRelativeOrder), SlotWriter.access$groupIndexToAddress(endRelativeOrder, group + 1))) {
                i2 = slot$iv - i9;
                obj = SlotWriter.access$getSlots$p(endRelativeOrder)[SlotWriter.access$dataIndexToDataAddress(endRelativeOrder, slot$iv)];
                i3 = 0;
                if (obj instanceof RememberObserverHolder) {
                } else {
                }
                start = currentGroup;
                end = anchor$iv;
                node2 = node;
                $this$withAfterAnchorInfo$iv = endRelativeOrder;
                if (obj instanceof RecomposeScopeImpl) {
                }
                slot$iv++;
                currentGroup = start;
                endRelativeOrder = $this$withAfterAnchorInfo$iv;
                anchor$iv = end;
                node = node2;
                ComposerKt.removeData(writer, group, i2, obj);
                (RecomposeScopeImpl)obj.release();
                wrapped = (RememberObserverHolder)obj.getWrapped();
                start = currentGroup;
                if (!wrapped instanceof ReusableRememberObserver) {
                } else {
                }
                end = anchor$iv;
                node2 = node;
                $this$withAfterAnchorInfo$iv = endRelativeOrder;
                ComposerKt.removeData(writer, group, i2, obj);
                end = anchor$iv;
                androidx.compose.runtime.Anchor after = (RememberObserverHolder)obj.getAfter();
                androidx.compose.runtime.SlotWriter writer2 = $this$deactivateCurrentGroup;
                i5 = 0;
                i10 = -1;
                endRelativeAfter$iv = -1;
                if (after != null && after.getValid()) {
                } else {
                }
                node2 = node;
                node = writer2;
                $this$withAfterAnchorInfo$iv = endRelativeOrder;
                i4 = 0;
                anchor = after;
                obj2.forgetting(wrapped, slotsSize -= i2, i10, endRelativeAfter$iv);
                if (after.getValid()) {
                } else {
                }
                node2 = node;
                node = writer2;
                $this$withAfterAnchorInfo$iv = endRelativeOrder;
                endRelativeOrder = node.anchorIndex(after);
                endRelativeAfter$iv = slotsSize3 - slotsEndAllIndex$runtime_release;
                i10 = endRelativeOrder;
            }
            start = currentGroup;
            end = anchor$iv;
            node2 = node;
            $this$withAfterAnchorInfo$iv = endRelativeOrder;
            group++;
            i2 = slot$iv - i9;
            obj = SlotWriter.access$getSlots$p(endRelativeOrder)[SlotWriter.access$dataIndexToDataAddress(endRelativeOrder, slot$iv)];
            i3 = 0;
            if (obj instanceof RememberObserverHolder) {
            } else {
            }
            start = currentGroup;
            end = anchor$iv;
            node2 = node;
            $this$withAfterAnchorInfo$iv = endRelativeOrder;
            if (obj instanceof RecomposeScopeImpl) {
            }
            slot$iv++;
            currentGroup = start;
            endRelativeOrder = $this$withAfterAnchorInfo$iv;
            anchor$iv = end;
            node = node2;
            ComposerKt.removeData(writer, group, i2, obj);
            (RecomposeScopeImpl)obj.release();
            wrapped = (RememberObserverHolder)obj.getWrapped();
            start = currentGroup;
            if (!wrapped instanceof ReusableRememberObserver) {
            } else {
            }
            end = anchor$iv;
            node2 = node;
            $this$withAfterAnchorInfo$iv = endRelativeOrder;
            ComposerKt.removeData(writer, group, i2, obj);
            end = anchor$iv;
            after = (RememberObserverHolder)obj.getAfter();
            writer2 = $this$deactivateCurrentGroup;
            i5 = 0;
            i10 = -1;
            endRelativeAfter$iv = -1;
            if (after != null && after.getValid()) {
            } else {
            }
            node2 = node;
            node = writer2;
            $this$withAfterAnchorInfo$iv = endRelativeOrder;
            i4 = 0;
            anchor = after;
            obj2.forgetting(wrapped, slotsSize -= i2, i10, endRelativeAfter$iv);
            if (after.getValid()) {
            } else {
            }
            node2 = node;
            node = writer2;
            $this$withAfterAnchorInfo$iv = endRelativeOrder;
            endRelativeOrder = node.anchorIndex(after);
            endRelativeAfter$iv = slotsSize3 - slotsEndAllIndex$runtime_release;
            i10 = endRelativeOrder;
            i = -1;
            obj2.deactivating((ComposeNodeLifecycleCallback)node, slotsSize2 -= slotsStartIndex$runtime_release, i, i);
        }
    }

    private static final int distanceFrom(androidx.compose.runtime.SlotReader $this$distanceFrom, int index, int root) {
        int count;
        int current;
        count = 0;
        current = index;
        while (current > 0) {
            if (current != root) {
            }
            current = $this$distanceFrom.parent(current);
            count++;
        }
        return count;
    }

    private static final List<androidx.compose.runtime.Invalidation> filterToRange(List<androidx.compose.runtime.Invalidation> $this$filterToRange, int start, int end) {
        int index;
        Object size;
        int location;
        ArrayList arrayList = new ArrayList();
        index = ComposerKt.findInsertLocation($this$filterToRange, start);
        while (index < $this$filterToRange.size()) {
            size = $this$filterToRange.get(index);
            if ((Invalidation)size.getLocation() >= end) {
                break;
            } else {
            }
            (List)arrayList.add(size);
            index++;
        }
        return arrayList;
    }

    private static final int findInsertLocation(List<androidx.compose.runtime.Invalidation> $this$findInsertLocation, int location) {
        int it;
        int i;
        it = ComposerKt.findLocation($this$findInsertLocation, location);
        final int i2 = 0;
        if (it < 0) {
            it = i;
        }
        return it;
    }

    private static final int findLocation(List<androidx.compose.runtime.Invalidation> $this$findLocation, int location) {
        int low;
        int high;
        int i;
        Object obj;
        int compare;
        low = 0;
        size--;
        while (low <= high) {
            i3 >>>= 1;
            compare = Intrinsics.compare((Invalidation)$this$findLocation.get(i).getLocation(), location);
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    private static final androidx.compose.runtime.Invalidation firstInRange(List<androidx.compose.runtime.Invalidation> $this$firstInRange, int start, int end) {
        int size;
        int location;
        final int insertLocation = ComposerKt.findInsertLocation($this$firstInRange, start);
        size = $this$firstInRange.get(insertLocation);
        if (insertLocation < $this$firstInRange.size() && (Invalidation)size.getLocation() < end) {
            size = $this$firstInRange.get(insertLocation);
            if ((Invalidation)size.getLocation() < end) {
                return size;
            }
        }
        return null;
    }

    public static final Object getCompositionLocalMap() {
        return ComposerKt.compositionLocalMap;
    }

    public static void getCompositionLocalMap$annotations() {
    }

    public static void getCompositionLocalMapKey$annotations() {
    }

    private static void getCompositionTracer$annotations() {
    }

    public static final Object getInvocation() {
        return ComposerKt.invocation;
    }

    public static void getInvocation$annotations() {
    }

    public static void getInvocationKey$annotations() {
    }

    private static final Object getJoinedKey(androidx.compose.runtime.KeyInfo $this$joinedKey) {
        Object joinedKey;
        Integer valueOf;
        Object objectKey;
        if ($this$joinedKey.getObjectKey() != null) {
            joinedKey = new JoinedKey(Integer.valueOf($this$joinedKey.getKey()), $this$joinedKey.getObjectKey());
        } else {
            joinedKey = Integer.valueOf($this$joinedKey.getKey());
        }
        return joinedKey;
    }

    private static final Object getKey(Object value, Object left, Object right) {
        int i;
        int i2;
        Object key;
        boolean equal;
        if (value instanceof JoinedKey) {
            i = value;
        } else {
            i = i2;
        }
        if (i != 0) {
            int i3 = 0;
            if (Intrinsics.areEqual(i.getLeft(), left) && Intrinsics.areEqual(i.getRight(), right)) {
                if (Intrinsics.areEqual(i.getRight(), right)) {
                    key = value;
                } else {
                    if (ComposerKt.getKey(i.getLeft(), left, right) == null) {
                        key = ComposerKt.getKey(i.getRight(), left, right);
                    }
                }
            } else {
            }
            i2 = key;
        }
        return i2;
    }

    public static final Object getProvider() {
        return ComposerKt.provider;
    }

    public static void getProvider$annotations() {
    }

    public static void getProviderKey$annotations() {
    }

    public static final Object getProviderMaps() {
        return ComposerKt.providerMaps;
    }

    public static void getProviderMaps$annotations() {
    }

    public static void getProviderMapsKey$annotations() {
    }

    public static final Object getProviderValues() {
        return ComposerKt.providerValues;
    }

    public static void getProviderValues$annotations() {
    }

    public static void getProviderValuesKey$annotations() {
    }

    public static final Object getReference() {
        return ComposerKt.reference;
    }

    public static void getReference$annotations() {
    }

    public static void getReferenceKey$annotations() {
    }

    public static void getReuseKey$annotations() {
    }

    private static final void insertIfMissing(List<androidx.compose.runtime.Invalidation> $this$insertIfMissing, int location, androidx.compose.runtime.RecomposeScopeImpl scope, Object instance) {
        int instances;
        int i2;
        androidx.compose.runtime.Invalidation mutableScatterSetOf;
        int i;
        final int location2 = ComposerKt.findLocation($this$insertIfMissing, location);
        if (location2 < 0) {
            i = 0;
            if (obj instanceof DerivedState) {
                instances = instance;
            }
            mutableScatterSetOf = new Invalidation(scope, location, instances);
            $this$insertIfMissing.add(-i3, mutableScatterSetOf);
        } else {
            i2 = $this$insertIfMissing.get(location2);
            if (instance instanceof DerivedState) {
                instances = (Invalidation)i2.getInstances();
                if (instances == null) {
                    i2.setInstances(instance);
                } else {
                    if (instances instanceof MutableScatterSet != null) {
                        Object obj2 = instances;
                        (MutableScatterSet)instances.add(instance);
                    } else {
                        i2.setInstances(ScatterSetKt.mutableScatterSetOf(instances, instance));
                    }
                }
            } else {
                i2.setInstances(0);
            }
        }
    }

    public static final boolean isAfterFirstChild(androidx.compose.runtime.SlotReader $this$isAfterFirstChild) {
        int i;
        if ($this$isAfterFirstChild.getCurrentGroup() > parent += i) {
        } else {
            i = 0;
        }
        return i;
    }

    public static final boolean isAfterFirstChild(androidx.compose.runtime.SlotWriter $this$isAfterFirstChild) {
        int i;
        if ($this$isAfterFirstChild.getCurrentGroup() > parent += i) {
        } else {
            i = 0;
        }
        return i;
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        boolean traceInProgress;
        int i;
        final androidx.compose.runtime.CompositionTracer compositionTracer = ComposerKt.compositionTracer;
        final int i2 = 0;
        if (compositionTracer != null && compositionTracer.isTraceInProgress()) {
            i = compositionTracer.isTraceInProgress() ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final <K, V> MutableScatterMap<K, Object> multiMap(int initialCapacity) {
        MutableScatterMap mutableScatterMap = new MutableScatterMap(initialCapacity);
        return MutableScatterMultiMap.constructor-impl(mutableScatterMap);
    }

    private static final int nearestCommonRootOf(androidx.compose.runtime.SlotReader $this$nearestCommonRootOf, int a, int b, int common) {
        int currentA;
        int currentB;
        int i4;
        int i3;
        int i;
        int i2;
        if (a == b) {
            return a;
        }
        if (a != common) {
            if (b == common) {
            } else {
                if ($this$nearestCommonRootOf.parent(a) == b) {
                    return b;
                }
                if ($this$nearestCommonRootOf.parent(b) == a) {
                    return a;
                }
                if ($this$nearestCommonRootOf.parent(a) == $this$nearestCommonRootOf.parent(b)) {
                    return $this$nearestCommonRootOf.parent(a);
                }
                int i5 = 0;
                currentA = a;
                int i6 = 0;
                currentB = b;
                final int distanceFrom = ComposerKt.distanceFrom($this$nearestCommonRootOf, a, common);
                final int distanceFrom2 = ComposerKt.distanceFrom($this$nearestCommonRootOf, b, common);
                i3 = i4;
                while (i3 < distanceFrom - distanceFrom2) {
                    i = i3;
                    i2 = 0;
                    currentA = $this$nearestCommonRootOf.parent(currentA);
                    i3++;
                }
                while (i4 < distanceFrom2 - distanceFrom) {
                    i3 = i4;
                    i = 0;
                    currentB = $this$nearestCommonRootOf.parent(currentB);
                    i4++;
                }
                while (currentA != currentB) {
                    currentA = $this$nearestCommonRootOf.parent(currentA);
                    currentB = $this$nearestCommonRootOf.parent(currentB);
                }
            }
            return currentA;
        }
        return common;
    }

    public static final void removeCurrentGroup(androidx.compose.runtime.SlotWriter $this$removeCurrentGroup, androidx.compose.runtime.RememberManager rememberManager) {
        int currentGroup;
        boolean group$iv;
        androidx.compose.runtime.SlotWriter this_$iv;
        int $i$f$forAllData;
        int slot$iv;
        int groupSize;
        int i;
        int i3;
        boolean endRelativeOrder;
        boolean i2;
        int after;
        int i4;
        int i5;
        int priority$iv;
        int endRelativeAfter$iv;
        int priority;
        int slotsEndAllIndex$runtime_release;
        int i6;
        androidx.compose.runtime.SlotWriter writer;
        int group$iv2;
        final Object obj = rememberManager;
        this_$iv = $this$removeCurrentGroup;
        $i$f$forAllData = 0;
        slot$iv = i8;
        while (slot$iv < SlotWriter.access$dataIndex(this_$iv, SlotWriter.access$getGroups$p(this_$iv), SlotWriter.access$groupIndexToAddress(this_$iv, currentGroup2 += groupSize))) {
            groupSize = SlotWriter.access$getSlots$p(this_$iv)[SlotWriter.access$dataIndexToDataAddress(this_$iv, slot$iv)];
            i = slot$iv;
            i3 = 0;
            if (groupSize instanceof ComposeNodeLifecycleCallback != null) {
            }
            if (groupSize instanceof RememberObserverHolder) {
            } else {
            }
            group$iv2 = currentGroup;
            writer = this_$iv;
            priority = $i$f$forAllData;
            if (groupSize instanceof RecomposeScopeImpl) {
            }
            slot$iv++;
            $i$f$forAllData = priority;
            this_$iv = writer;
            currentGroup = group$iv2;
            (RecomposeScopeImpl)groupSize.release();
            after = (RememberObserverHolder)groupSize.getAfter();
            i4 = $this$removeCurrentGroup;
            i5 = 0;
            priority$iv = -1;
            endRelativeAfter$iv = -1;
            if (after != null && after.getValid()) {
            }
            i6 = 0;
            group$iv2 = currentGroup;
            writer = this_$iv;
            priority = $i$f$forAllData;
            obj.forgetting((RememberObserverHolder)groupSize.getWrapped(), slotsSize2 -= i, priority$iv, endRelativeAfter$iv);
            if (after.getValid()) {
            }
            endRelativeAfter$iv = priority - slotsEndAllIndex$runtime_release;
            i4 = -1;
            obj.releasing((ComposeNodeLifecycleCallback)groupSize, slotsSize -= i, i4, i4);
        }
        $this$removeCurrentGroup.removeGroup();
    }

    private static final void removeData(androidx.compose.runtime.SlotWriter $this$removeData, int group, int index, Object data) {
        int i;
        String str;
        i = data == $this$removeData.set(group, index, Composer.Companion.getEmpty()) ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            ComposerKt.composeImmediateRuntimeError("Slot table is out of sync");
        }
    }

    private static final androidx.compose.runtime.Invalidation removeLocation(List<androidx.compose.runtime.Invalidation> $this$removeLocation, int location) {
        Object remove;
        final int location2 = ComposerKt.findLocation($this$removeLocation, location);
        if (location2 >= 0) {
            remove = $this$removeLocation.remove(location2);
        } else {
            remove = 0;
        }
        return remove;
    }

    private static final void removeRange(List<androidx.compose.runtime.Invalidation> $this$removeRange, int start, int end) {
        Object size;
        int location;
        final int insertLocation = ComposerKt.findInsertLocation($this$removeRange, start);
        while (insertLocation < $this$removeRange.size()) {
            if ((Invalidation)$this$removeRange.get(insertLocation).getLocation() >= end) {
                break;
            } else {
            }
            $this$removeRange.remove(insertLocation);
        }
    }

    public static final void runtimeCheck(boolean value) {
        String str;
        final int i = 0;
        if (value == null) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
    }

    public static final void runtimeCheck(boolean value, Function0<String> lazyMessage) {
        Object invoke;
        final int i = 0;
        if (value == null) {
            ComposerKt.composeImmediateRuntimeError((String)lazyMessage.invoke());
        }
    }

    @ComposeCompilerApi
    public static final void sourceInformation(androidx.compose.runtime.Composer composer, String sourceInformation) {
        composer.sourceInformation(sourceInformation);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(androidx.compose.runtime.Composer composer) {
        composer.sourceInformationMarkerEnd();
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(androidx.compose.runtime.Composer composer, int key, String sourceInformation) {
        composer.sourceInformationMarkerStart(key, sourceInformation);
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        final androidx.compose.runtime.CompositionTracer compositionTracer = ComposerKt.compositionTracer;
        if (compositionTracer != null) {
            compositionTracer.traceEventEnd();
        }
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int key, int dirty1, int dirty2, String info) {
        final androidx.compose.runtime.CompositionTracer compositionTracer = ComposerKt.compositionTracer;
        if (compositionTracer != null) {
            compositionTracer.traceEventStart(key, dirty1, dirty2, info);
        }
    }

    @ComposeCompilerApi
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload with $dirty metadata instead", replaceWith = @ReplaceWith(...))
    public static final void traceEventStart(int key, String info) {
        final int i = -1;
        ComposerKt.traceEventStart(key, i, i, info);
    }

    public static final <R> void withAfterAnchorInfo(androidx.compose.runtime.SlotWriter $this$withAfterAnchorInfo, androidx.compose.runtime.Anchor anchor, Function2<? super Integer, ? super Integer, ? extends R> cb) {
        int priority;
        int endRelativeAfter;
        boolean slotsSize;
        int slotsEndAllIndex$runtime_release;
        final int i = 0;
        priority = -1;
        endRelativeAfter = -1;
        if (anchor != null && anchor.getValid()) {
            if (anchor.getValid()) {
                endRelativeAfter = slotsSize - slotsEndAllIndex$runtime_release;
            }
        }
        cb.invoke(Integer.valueOf(priority), Integer.valueOf(endRelativeAfter));
    }
}
