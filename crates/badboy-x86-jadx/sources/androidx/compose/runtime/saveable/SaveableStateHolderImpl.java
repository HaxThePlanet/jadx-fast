package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB/\u0012(\u0008\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00050\u0003¢\u0006\u0002\u0010\u0008J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0015¢\u0006\u0002\u0008\u0016H\u0017¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J*\u0010\u0019\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u0005\u0018\u00010\u0003H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0008\u0012\u00060\u0010R\u00020\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "savedStates", "", "", "", "", "", "(Ljava/util/Map;)V", "parentSaveableStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getParentSaveableStateRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "setParentSaveableStateRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "registryHolders", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "saveAll", "Companion", "RegistryHolder", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SaveableStateHolderImpl implements androidx.compose.runtime.saveable.SaveableStateHolder {

    public static final androidx.compose.runtime.saveable.SaveableStateHolderImpl.Companion Companion;
    private static final androidx.compose.runtime.saveable.Saver<androidx.compose.runtime.saveable.SaveableStateHolderImpl, ?> Saver;
    private androidx.compose.runtime.saveable.SaveableStateRegistry parentSaveableStateRegistry;
    private final Map<Object, androidx.compose.runtime.saveable.SaveableStateHolderImpl.RegistryHolder> registryHolders;
    private final Map<Object, Map<String, List<Object>>> savedStates;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.runtime.saveable.Saver<androidx.compose.runtime.saveable.SaveableStateHolderImpl, ?> getSaver() {
            return SaveableStateHolderImpl.access$getSaver$cp();
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J.\u0010\u0010\u001a\u00020\u00112&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u00140\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "", "key", "(Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "shouldSave", "", "getShouldSave", "()Z", "setShouldSave", "(Z)V", "saveTo", "", "map", "", "", "", "", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class RegistryHolder {

        private final Object key;
        private final androidx.compose.runtime.saveable.SaveableStateRegistry registry;
        private boolean shouldSave = true;
        final androidx.compose.runtime.saveable.SaveableStateHolderImpl this$0;
        public RegistryHolder(androidx.compose.runtime.saveable.SaveableStateHolderImpl this$0, Object key) {
            this.this$0 = this$0;
            super();
            this.key = key;
            int i = 1;
            SaveableStateHolderImpl.RegistryHolder.registry.1 anon = new SaveableStateHolderImpl.RegistryHolder.registry.1(this.this$0);
            this.registry = SaveableStateRegistryKt.SaveableStateRegistry((Map)SaveableStateHolderImpl.access$getSavedStates$p(this.this$0).get(this.key), (Function1)anon);
        }

        public final Object getKey() {
            return this.key;
        }

        public final androidx.compose.runtime.saveable.SaveableStateRegistry getRegistry() {
            return this.registry;
        }

        public final boolean getShouldSave() {
            return this.shouldSave;
        }

        public final void saveTo(Map<Object, Map<String, List<Object>>> map) {
            boolean shouldSave;
            Object key;
            if (this.shouldSave) {
                shouldSave = this.registry.performSave();
                if (shouldSave.isEmpty()) {
                    map.remove(this.key);
                } else {
                    map.put(this.key, shouldSave);
                }
            }
        }

        public final void setShouldSave(boolean <set-?>) {
            this.shouldSave = <set-?>;
        }
    }
    static {
        SaveableStateHolderImpl.Companion companion = new SaveableStateHolderImpl.Companion(0);
        SaveableStateHolderImpl.Companion = companion;
        SaveableStateHolderImpl.Saver = SaverKt.Saver((Function2)SaveableStateHolderImpl.Companion.Saver.1.INSTANCE, (Function1)SaveableStateHolderImpl.Companion.Saver.2.INSTANCE);
    }

    public SaveableStateHolderImpl() {
        final int i = 0;
        super(i, 1, i);
    }

    public SaveableStateHolderImpl(Map<Object, Map<String, List<Object>>> savedStates) {
        super();
        this.savedStates = savedStates;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.registryHolders = (Map)linkedHashMap;
    }

    public SaveableStateHolderImpl(Map map, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        LinkedHashMap obj1;
        if (i2 &= 1 != 0) {
            obj1 = new LinkedHashMap();
        }
        super(obj1);
    }

    public static final Map access$getRegistryHolders$p(androidx.compose.runtime.saveable.SaveableStateHolderImpl $this) {
        return $this.registryHolders;
    }

    public static final Map access$getSavedStates$p(androidx.compose.runtime.saveable.SaveableStateHolderImpl $this) {
        return $this.savedStates;
    }

    public static final androidx.compose.runtime.saveable.Saver access$getSaver$cp() {
        return SaveableStateHolderImpl.Saver;
    }

    public static final Map access$saveAll(androidx.compose.runtime.saveable.SaveableStateHolderImpl $this) {
        return $this.saveAll();
    }

    private final Map<Object, Map<String, List<Object>>> saveAll() {
        Map map;
        Object next;
        Object obj;
        int i;
        Map mutableMap = MapsKt.toMutableMap(this.savedStates);
        final int i3 = 0;
        final Iterator iterator = (Iterable)this.registryHolders.values().iterator();
        for (Object next : iterator) {
            i = 0;
            (SaveableStateHolderImpl.RegistryHolder)next.saveTo(mutableMap);
        }
        if (mutableMap.isEmpty()) {
            int i2 = 0;
            map = 0;
        } else {
            map = mutableMap;
        }
        return map;
    }

    public void SaveableStateProvider(Object key, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int beSaved;
        Object registryHolder;
        Object restartGroup;
        int $dirty;
        int i4;
        int i5;
        int i6;
        boolean skipping;
        boolean traceInProgress2;
        int str;
        Composer composer;
        int i2;
        Unit iNSTANCE;
        int i;
        Composer composer2;
        int i7;
        Object rememberedValue;
        int i3;
        int companion;
        Composer $composer2;
        int obj22;
        final Object obj = this;
        final Object obj2 = key;
        final Object obj3 = content;
        final int i8 = $changed;
        traceInProgress = -1198538093;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SaveableStateProvider)P(1)76@3032L923:SaveableStateHolder.kt#r2ddri");
        if (i8 & 6 == 0) {
            i4 = restartGroup.changedInstance(obj2) ? 4 : 2;
            $dirty |= i4;
        }
        if (i8 & 48 == 0) {
            i5 = restartGroup.changedInstance(obj3) ? 32 : 16;
            $dirty |= i5;
        }
        if (i8 & 384 == 0) {
            i6 = restartGroup.changedInstance(obj) ? 256 : 128;
            $dirty |= i6;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:75)");
                }
                int i9 = $dirty & 14;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 444418301, "CC(ReusableContent)P(1)149@5444L9:Composables.kt#9igjgp");
                restartGroup.startReusableGroup(207, obj2);
                i15 &= 14;
                composer = restartGroup;
                i2 = 0;
                ComposerKt.sourceInformationMarkerStart(composer, 1358150931, "C77@3088L321,84@3422L150,88@3608L337,88@3585L360:SaveableStateHolder.kt#r2ddri");
                String str6 = "CC(remember):SaveableStateHolder.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer, -233283229, str6);
                int i18 = 0;
                Composer composer3 = composer;
                int i23 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i25 = 0;
                obj22 = i9;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    companion = i10;
                    androidx.compose.runtime.saveable.SaveableStateRegistry parentSaveableStateRegistry = obj.parentSaveableStateRegistry;
                    if (parentSaveableStateRegistry != null) {
                        beSaved = parentSaveableStateRegistry.canBeSaved(obj2);
                    } else {
                        beSaved = 1;
                    }
                    if (beSaved == 0) {
                    } else {
                        registryHolder = new SaveableStateHolderImpl.RegistryHolder(obj, obj2);
                        composer3.updateRememberedValue(registryHolder);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        CompositionLocalKt.CompositionLocalProvider(SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides((SaveableStateHolderImpl.RegistryHolder)registryHolder.getRegistry()), obj3, composer, $stable |= i24);
                        ComposerKt.sourceInformationMarkerStart(composer, -233266573, str6);
                        composer2 = composer;
                        i7 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i3 = 0;
                        if (i19 |= changedInstance6 == 0) {
                            $composer2 = restartGroup;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                companion = $composer3;
                                restartGroup = new SaveableStateHolderImpl.SaveableStateProvider.1.1.1(obj, obj2, registryHolder);
                                composer2.updateRememberedValue((Function1)restartGroup);
                            } else {
                                restartGroup = rememberedValue;
                            }
                        } else {
                            $composer2 = restartGroup;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        EffectsKt.DisposableEffect(Unit.INSTANCE, (Function1)restartGroup, composer, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        $composer2.endReusableGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int i26 = i11;
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Type of the key ").append(obj2).append(" is not supported. On Android you can only use types which can be stored inside the Bundle.").toString().toString());
                    throw illegalArgumentException;
                }
                registryHolder = rememberedValue2;
            } else {
                restartGroup.skipToGroupEnd();
                $composer2 = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new SaveableStateHolderImpl.SaveableStateProvider.2(obj, obj2, obj3, i8);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final androidx.compose.runtime.saveable.SaveableStateRegistry getParentSaveableStateRegistry() {
        return this.parentSaveableStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void removeState(Object key) {
        int savedStates;
        Object obj = this.registryHolders.get(key);
        if ((SaveableStateHolderImpl.RegistryHolder)obj != null) {
            (SaveableStateHolderImpl.RegistryHolder)obj.setShouldSave(false);
        } else {
            this.savedStates.remove(key);
        }
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final void setParentSaveableStateRegistry(androidx.compose.runtime.saveable.SaveableStateRegistry <set-?>) {
        this.parentSaveableStateRegistry = <set-?>;
    }
}
