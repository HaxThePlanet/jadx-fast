package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u000c\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001J@\u00105\u001a\u000206\"\u0004\u0008\u0000\u00107\"\u0004\u0008\u0001\u001082\u0006\u00109\u001a\u0002H72\u001d\u0010:\u001a\u0019\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002060;¢\u0006\u0002\u0008<H'¢\u0006\u0002\u0010=J\u0008\u0010>\u001a\u00020?H'J\u0012\u0010@\u001a\u00020\"2\u0008\u00109\u001a\u0004\u0018\u00010\u0001H'J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020\"H\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020AH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020BH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020CH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020DH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0016H\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020EH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020FH\u0017J\u0012\u0010G\u001a\u00020\"2\u0008\u00109\u001a\u0004\u0018\u00010\u0001H\u0017J\u0008\u0010H\u001a\u000206H&J!\u0010I\u001a\u0002H8\"\u0004\u0008\u0000\u001082\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H80KH'¢\u0006\u0002\u0010LJ\u001c\u0010M\u001a\u000206\"\u0004\u0008\u0000\u001082\u000c\u0010N\u001a\u0008\u0012\u0004\u0012\u0002H80OH'J\u0010\u0010P\u001a\u0002062\u0006\u0010@\u001a\u00020\"H'J\u0008\u0010Q\u001a\u000206H'J\u0008\u0010R\u001a\u000206H'J\u0008\u0010S\u001a\u000206H'J\u0008\u0010T\u001a\u000206H'J\u0008\u0010U\u001a\u000206H'J\u0008\u0010V\u001a\u000206H'J\u0008\u0010W\u001a\u000206H'J\u0008\u0010X\u001a\u000206H'J\u0008\u0010Y\u001a\u000206H'J\u0008\u0010Z\u001a\u000206H'J\n\u0010[\u001a\u0004\u0018\u00010\\H'J\u0008\u0010]\u001a\u000206H'J\u0010\u0010^\u001a\u0002062\u0006\u0010_\u001a\u00020\u0016H'J\u001e\u0010`\u001a\u0002062\n\u00109\u001a\u0006\u0012\u0002\u0008\u00030a2\u0008\u0010b\u001a\u0004\u0018\u00010\u0001H'J$\u0010c\u001a\u0002062\u001a\u0010d\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020g\u0012\u0006\u0012\u0004\u0018\u00010g0f0eH'J\u001c\u0010h\u001a\u00020\u00012\u0008\u0010i\u001a\u0004\u0018\u00010\u00012\u0008\u0010j\u001a\u0004\u0018\u00010\u0001H'J\u0016\u0010k\u001a\u0002062\u000c\u0010l\u001a\u0008\u0012\u0004\u0012\u0002060OH'J\u0010\u0010m\u001a\u0002062\u0006\u0010n\u001a\u00020*H'J\n\u0010o\u001a\u0004\u0018\u00010\u0001H'J\u0008\u0010p\u001a\u000206H'J\u0008\u0010q\u001a\u000206H'J\u0010\u0010r\u001a\u0002062\u0006\u0010r\u001a\u00020sH&J\u0008\u0010t\u001a\u000206H&J\u0018\u0010u\u001a\u0002062\u0006\u0010J\u001a\u00020\u00162\u0006\u0010r\u001a\u00020sH&J\u0008\u0010v\u001a\u000206H'J\u001a\u0010w\u001a\u0002062\u0006\u0010J\u001a\u00020\u00162\u0008\u0010x\u001a\u0004\u0018\u00010\u0001H'J\u0008\u0010y\u001a\u000206H'J\u0014\u0010z\u001a\u0002062\n\u00109\u001a\u0006\u0012\u0002\u0008\u00030{H'J!\u0010|\u001a\u0002062\u0012\u0010}\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030{0~H'¢\u0006\u0002\u0010\u007fJ\u0011\u0010\u0080\u0001\u001a\u0002062\u0006\u0010J\u001a\u00020\u0016H'J\u0011\u0010\u0081\u0001\u001a\u0002062\u0006\u0010J\u001a\u00020\u0016H'J\u0011\u0010\u0082\u0001\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0016H'J\u001b\u0010\u0083\u0001\u001a\u0002062\u0006\u0010J\u001a\u00020\u00162\u0008\u0010x\u001a\u0004\u0018\u00010\u0001H'J\t\u0010\u0084\u0001\u001a\u000206H'J\u0013\u0010\u0085\u0001\u001a\u0002062\u0008\u00109\u001a\u0004\u0018\u00010\u0001H'J\t\u0010\u0086\u0001\u001a\u000206H'R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00038&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\t8gX§\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0005\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000e8gX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00168&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0017\u0010\u0005\u001a\u0004\u0008\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00168&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0005\u001a\u0004\u0008 \u0010\u0019R\u001a\u0010!\u001a\u00020\"8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008#\u0010\u0005\u001a\u0004\u0008$\u0010%R\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008'\u0010\u0005\u001a\u0004\u0008(\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010*8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008+\u0010\u0005\u001a\u0004\u0008,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u00018&X§\u0004¢\u0006\u000c\u0012\u0004\u0008/\u0010\u0005\u001a\u0004\u00080\u00101R\u001a\u00102\u001a\u00020\"8&X§\u0004¢\u0006\u000c\u0012\u0004\u00083\u0010\u0005\u001a\u0004\u00084\u0010%\u0082\u0001\u0002\u0088\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0089\u0001À\u0006\u0001", d2 = {"Landroidx/compose/runtime/Composer;", "", "applier", "Landroidx/compose/runtime/Applier;", "getApplier$annotations", "()V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compoundKeyHash", "", "getCompoundKeyHash$annotations", "getCompoundKeyHash", "()I", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker$annotations", "getCurrentMarker", "defaultsInvalid", "", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "()Z", "inserting", "getInserting$annotations", "getInserting", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope$annotations", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity$annotations", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "skipping", "getSkipping$annotations", "getSkipping", "apply", "", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "Landroidx/compose/runtime/CompositionContext;", "changed", "", "", "", "", "", "", "changedInstance", "collectParameterInformation", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "Lkotlin/Function0;", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "enableReusing", "endDefaults", "endMovableGroup", "endNode", "endProvider", "endProviders", "endReplaceGroup", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endToMarker", "marker", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "joinKey", "left", "right", "recordSideEffect", "effect", "recordUsed", "scope", "rememberedValue", "skipCurrentGroup", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "startDefaults", "startMovableGroup", "dataKey", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReplaceGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "updateRememberedValue", "useNode", "Companion", "Landroidx/compose/runtime/ComposerImpl;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Composer {

    public static final androidx.compose.runtime.Composer.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\n", d2 = {"Landroidx/compose/runtime/Composer$Companion;", "", "()V", "Empty", "getEmpty", "()Ljava/lang/Object;", "setTracer", "", "tracer", "Landroidx/compose/runtime/CompositionTracer;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.runtime.Composer.Companion $$INSTANCE;
        private static final Object Empty;
        static {
            Composer.Companion companion = new Composer.Companion();
            Composer.Companion.$$INSTANCE = companion;
            Composer.Companion.Empty.1 anon = new Composer.Companion.Empty.1();
            Composer.Companion.Empty = anon;
        }

        public final Object getEmpty() {
            return Composer.Companion.Empty;
        }

        public final void setTracer(androidx.compose.runtime.CompositionTracer tracer) {
            ComposerKt.access$setCompositionTracer$p(tracer);
        }
    }
    static {
        Composer.Companion = Composer.Companion.$$INSTANCE;
    }

    @ComposeCompilerApi
    public static void getApplier$annotations() {
    }

    public static void getApplyCoroutineContext$annotations() {
    }

    public static void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static void getCurrentMarker$annotations() {
    }

    @ComposeCompilerApi
    public static void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static void getInserting$annotations() {
    }

    public static void getRecomposeScope$annotations() {
    }

    @ComposeCompilerApi
    public static void getRecomposeScopeIdentity$annotations() {
    }

    @ComposeCompilerApi
    public static void getSkipping$annotations() {
    }

    @ComposeCompilerApi
    public abstract <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function22);

    public abstract androidx.compose.runtime.CompositionContext buildContext();

    @ComposeCompilerApi
    public boolean changed(byte value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public boolean changed(char value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public boolean changed(double value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public boolean changed(float value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public boolean changed(int value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public boolean changed(long value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public abstract boolean changed(Object object);

    @ComposeCompilerApi
    public boolean changed(short value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public boolean changed(boolean value) {
        return changed(value);
    }

    @ComposeCompilerApi
    public boolean changedInstance(Object value) {
        return changed(value);
    }

    public abstract void collectParameterInformation();

    public abstract <T> T consume(androidx.compose.runtime.CompositionLocal<T> compositionLocal);

    @ComposeCompilerApi
    public abstract <T> void createNode(Function0<? extends T> function0);

    @ComposeCompilerApi
    public abstract void deactivateToEndGroup(boolean z);

    @ComposeCompilerApi
    public abstract void disableReusing();

    public abstract void disableSourceInformation();

    @ComposeCompilerApi
    public abstract void enableReusing();

    @ComposeCompilerApi
    public abstract void endDefaults();

    @ComposeCompilerApi
    public abstract void endMovableGroup();

    @ComposeCompilerApi
    public abstract void endNode();

    public abstract void endProvider();

    public abstract void endProviders();

    @ComposeCompilerApi
    public abstract void endReplaceGroup();

    @ComposeCompilerApi
    public abstract void endReplaceableGroup();

    @ComposeCompilerApi
    public abstract androidx.compose.runtime.ScopeUpdateScope endRestartGroup();

    @ComposeCompilerApi
    public abstract void endReusableGroup();

    @ComposeCompilerApi
    public abstract void endToMarker(int i);

    public abstract androidx.compose.runtime.Applier<?> getApplier();

    public abstract CoroutineContext getApplyCoroutineContext();

    public abstract androidx.compose.runtime.ControlledComposition getComposition();

    public abstract CompositionData getCompositionData();

    public abstract int getCompoundKeyHash();

    public abstract androidx.compose.runtime.CompositionLocalMap getCurrentCompositionLocalMap();

    public abstract int getCurrentMarker();

    public abstract boolean getDefaultsInvalid();

    public abstract boolean getInserting();

    public abstract androidx.compose.runtime.RecomposeScope getRecomposeScope();

    public abstract Object getRecomposeScopeIdentity();

    public abstract boolean getSkipping();

    public abstract void insertMovableContent(androidx.compose.runtime.MovableContent<?> movableContent, Object object2);

    public abstract void insertMovableContentReferences(List<Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> list);

    @ComposeCompilerApi
    public abstract Object joinKey(Object object, Object object2);

    public abstract void recordSideEffect(Function0<Unit> function0);

    public abstract void recordUsed(androidx.compose.runtime.RecomposeScope recomposeScope);

    @ComposeCompilerApi
    public abstract Object rememberedValue();

    @ComposeCompilerApi
    public abstract void skipCurrentGroup();

    @ComposeCompilerApi
    public abstract void skipToGroupEnd();

    public abstract void sourceInformation(String string);

    public abstract void sourceInformationMarkerEnd();

    public abstract void sourceInformationMarkerStart(int i, String string2);

    @ComposeCompilerApi
    public abstract void startDefaults();

    @ComposeCompilerApi
    public abstract void startMovableGroup(int i, Object object2);

    @ComposeCompilerApi
    public abstract void startNode();

    public abstract void startProvider(androidx.compose.runtime.ProvidedValue<?> providedValue);

    public abstract void startProviders(androidx.compose.runtime.ProvidedValue<?>[] providedValueArr);

    @ComposeCompilerApi
    public abstract void startReplaceGroup(int i);

    @ComposeCompilerApi
    public abstract void startReplaceableGroup(int i);

    @ComposeCompilerApi
    public abstract androidx.compose.runtime.Composer startRestartGroup(int i);

    @ComposeCompilerApi
    public abstract void startReusableGroup(int i, Object object2);

    @ComposeCompilerApi
    public abstract void startReusableNode();

    @ComposeCompilerApi
    public abstract void updateRememberedValue(Object object);

    @ComposeCompilerApi
    public abstract void useNode();
}
