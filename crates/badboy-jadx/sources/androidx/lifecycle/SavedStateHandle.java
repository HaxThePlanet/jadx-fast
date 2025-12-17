package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\t\u0018\u0000 -2\u00020\u0001:\u0002,-B\u001f\u0008\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006B\t\u0008\u0016¢\u0006\u0004\u0008\u0005\u0010\u0007J\u0008\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0087\u0002J\u001c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J)\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u0016J1\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u0002H\u0014H\u0002¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u001b\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u001cJ)\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u001e\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00040!H\u0007J\u001e\u0010\"\u001a\u0004\u0018\u0001H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010#J&\u0010$\u001a\u00020%\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0008\u0010&\u001a\u0004\u0018\u0001H\u0014H\u0087\u0002¢\u0006\u0002\u0010'J\u001d\u0010(\u001a\u0004\u0018\u0001H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010#J\u0018\u0010)\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000eH\u0007J\u0010\u0010+\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u001e\u0010\u0008\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006.", d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "initialState", "", "", "<init>", "(Ljava/util/Map;)V", "()V", "liveDatas", "", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "impl", "Landroidx/lifecycle/internal/SavedStateHandleImpl;", "savedStateProvider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "contains", "", "key", "getLiveData", "Landroidx/lifecycle/MutableLiveData;", "T", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "hasInitialValue", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "getMutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "keys", "", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "setSavedStateProvider", "provider", "clearSavedStateProvider", "SavingStateLiveData", "Companion", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandle {

    public static final androidx.lifecycle.SavedStateHandle.Companion Companion;
    private SavedStateHandleImpl impl;
    private final Map<String, androidx.lifecycle.SavedStateHandle.SavingStateLiveData<?>> liveDatas;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u00082\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u0008H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r", d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "<init>", "()V", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "defaultState", "validateValue", "", "value", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        @JvmStatic
        public final androidx.lifecycle.SavedStateHandle createHandle(Bundle restoredState, Bundle defaultState) {
            Bundle bundle;
            bundle = restoredState == null ? defaultState : restoredState;
            if (bundle == null) {
                SavedStateHandle savedStateHandle = new SavedStateHandle();
                return savedStateHandle;
            }
            java.lang.ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            Intrinsics.checkNotNull(classLoader);
            bundle.setClassLoader(classLoader);
            final int i = 0;
            final int i2 = 0;
            SavedStateHandle $this$read$iv = new SavedStateHandle(SavedStateReader.toMap-impl(SavedStateReader.constructor-impl(bundle)));
            return $this$read$iv;
        }

        public final boolean validateValue(Object value) {
            return SavedStateHandleImpl_androidKt.isAcceptableType(value);
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0008\u0016\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\u0008\u0008\u0010\tB\u001b\u0008\u0016\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\u0008\u0008\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "key", "", "value", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "setValue", "", "(Ljava/lang/Object;)V", "detach", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavingStateLiveData extends androidx.lifecycle.MutableLiveData<T> {

        private androidx.lifecycle.SavedStateHandle handle;
        private String key;
        public SavingStateLiveData(androidx.lifecycle.SavedStateHandle handle, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            super();
            this.key = key;
            this.handle = handle;
        }

        public SavingStateLiveData(androidx.lifecycle.SavedStateHandle handle, String key, T value) {
            Intrinsics.checkNotNullParameter(key, "key");
            super(value);
            this.key = key;
            this.handle = handle;
        }

        @Override // androidx.lifecycle.MutableLiveData
        public final void detach() {
            this.handle = 0;
        }

        public void setValue(T value) {
            Object handle;
            String key;
            handle = this.handle;
            handle = SavedStateHandle.access$getImpl$p(handle);
            if (handle != null && handle != null) {
                handle = SavedStateHandle.access$getImpl$p(handle);
                if (handle != null) {
                    handle.set(this.key, value);
                }
            }
            super.setValue(value);
        }
    }
    static {
        SavedStateHandle.Companion companion = new SavedStateHandle.Companion(0);
        SavedStateHandle.Companion = companion;
    }

    public SavedStateHandle() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.liveDatas = (Map)linkedHashMap;
        final int i = 0;
        SavedStateHandleImpl savedStateHandleImpl = new SavedStateHandleImpl(i, 1, i);
        this.impl = savedStateHandleImpl;
    }

    public SavedStateHandle(Map<String, ? extends Object> initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.liveDatas = (Map)linkedHashMap;
        SavedStateHandleImpl savedStateHandleImpl = new SavedStateHandleImpl(initialState);
        this.impl = savedStateHandleImpl;
    }

    public static final SavedStateHandleImpl access$getImpl$p(androidx.lifecycle.SavedStateHandle $this) {
        return $this.impl;
    }

    @JvmStatic
    public static final androidx.lifecycle.SavedStateHandle createHandle(Bundle restoredState, Bundle defaultState) {
        return SavedStateHandle.Companion.createHandle(restoredState, defaultState);
    }

    private final <T> androidx.lifecycle.MutableLiveData<T> getLiveDataInternal(String key, boolean hasInitialValue, T initialValue) {
        int i;
        androidx.lifecycle.SavedStateHandle.SavingStateLiveData savingStateLiveData;
        Object obj;
        if (this.impl.getMutableFlows().containsKey(key)) {
        } else {
            Map liveDatas = this.liveDatas;
            int i3 = 0;
            final Object obj2 = liveDatas.get(key);
            if (obj2 == null) {
                i = 0;
                if (this.impl.getRegular().containsKey(key)) {
                    savingStateLiveData = new SavedStateHandle.SavingStateLiveData(this, key, this.impl.getRegular().get(key));
                } else {
                    if (hasInitialValue) {
                        this.impl.getRegular().put(key, initialValue);
                        savingStateLiveData = new SavedStateHandle.SavingStateLiveData(this, key, initialValue);
                    } else {
                        savingStateLiveData = new SavedStateHandle.SavingStateLiveData(this, key);
                    }
                }
                liveDatas.put(key, savingStateLiveData);
            } else {
                savingStateLiveData = obj2;
            }
            return (MutableLiveData)(SavedStateHandle.SavingStateLiveData)savingStateLiveData;
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(SavedStateHandle_androidKt.access$createMutuallyExclusiveErrorMessage(key).toString());
        throw illegalArgumentException;
    }

    public final void clearSavedStateProvider(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.impl.clearSavedStateProvider(key);
    }

    public final boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.contains(key);
    }

    public final <T> T get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.get(key);
    }

    public final <T> androidx.lifecycle.MutableLiveData<T> getLiveData(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        androidx.lifecycle.MutableLiveData liveDataInternal = getLiveDataInternal(key, false, 0);
        Intrinsics.checkNotNull(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    public final <T> androidx.lifecycle.MutableLiveData<T> getLiveData(String key, T initialValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getLiveDataInternal(key, true, initialValue);
    }

    public final <T> MutableStateFlow<T> getMutableStateFlow(String key, T initialValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.liveDatas.containsKey(key)) {
        } else {
            return this.impl.getMutableStateFlow(key, initialValue);
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(SavedStateHandle_androidKt.access$createMutuallyExclusiveErrorMessage(key).toString());
        throw illegalArgumentException;
    }

    public final <T> StateFlow<T> getStateFlow(String key, T initialValue) {
        StateFlow stateFlow;
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.impl.getMutableFlows().containsKey(key)) {
            stateFlow = FlowKt.asStateFlow(this.impl.getMutableStateFlow(key, initialValue));
        } else {
            stateFlow = this.impl.getStateFlow(key, initialValue);
        }
        return stateFlow;
    }

    public final Set<String> keys() {
        return SetsKt.plus(this.impl.keys(), (Iterable)this.liveDatas.keySet());
    }

    public final <T> T remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object remove = this.impl.remove(key);
        final Object obj = remove;
        final int i = 0;
        Object remove2 = this.liveDatas.remove(key);
        if ((SavedStateHandle.SavingStateLiveData)remove2 != null) {
            (SavedStateHandle.SavingStateLiveData)remove2.detach();
        }
        return remove;
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.impl.getSavedStateProvider();
    }

    public final <T> void set(String key, T value) {
        int obj;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!SavedStateHandle.Companion.validateValue(value)) {
        } else {
            if (obj instanceof MutableLiveData != null) {
            } else {
                obj = 0;
            }
            if (obj != null) {
                obj.setValue(value);
            }
            this.impl.set(key, value);
        }
        int mutableLiveData = 0;
        StringBuilder stringBuilder = new StringBuilder();
        Intrinsics.checkNotNull(value);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Can't put value with type ").append(value.getClass()).append(" into saved state").toString().toString());
        throw illegalArgumentException;
    }

    public final void setSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.impl.setSavedStateProvider(key, provider);
    }
}
