package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008&\u0018\u0000 72\u00020\u0001:\u0003678B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J#\u0010\u0015\u001a\u00020\u0016\"\u0004\u0008\u0000\u0010\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u0002H\u0017H\u0007¢\u0006\u0002\u0010\u001aJ\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J8\u0010\u001e\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u00172\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\n2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0006H\u0002J\u0008\u0010 \u001a\u00020\nH\u0002JG\u0010!\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00170$2\u0006\u0010%\u001a\u0002H\"2\u0008\u0010&\u001a\u0004\u0018\u00010'H'¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00122\u0008\u0010*\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u000fJB\u0010-\u001a\u0008\u0012\u0004\u0012\u0002H\"0.\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u00172\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00170$2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\u001700JJ\u0010-\u001a\u0008\u0012\u0004\u0012\u0002H\"0.\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u00172\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u00101\u001a\u0002022\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00170$2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\u001700J\u0010\u00103\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0015\u00104\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00085R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00080\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069", d2 = {"Landroidx/activity/result/ActivityResultRegistry;", "", "()V", "keyToCallback", "", "", "Landroidx/activity/result/ActivityResultRegistry$CallbackAndContract;", "keyToLifecycleContainers", "Landroidx/activity/result/ActivityResultRegistry$LifecycleContainer;", "keyToRc", "", "launchedKeys", "", "parsedPendingResults", "pendingResults", "Landroid/os/Bundle;", "rcToKey", "bindRcKey", "", "rc", "key", "dispatchResult", "", "O", "requestCode", "result", "(ILjava/lang/Object;)Z", "resultCode", "data", "Landroid/content/Intent;", "doDispatch", "callbackAndContract", "generateRandomNumber", "onLaunch", "I", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "register", "Landroidx/activity/result/ActivityResultLauncher;", "callback", "Landroidx/activity/result/ActivityResultCallback;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "registerKey", "unregister", "unregister$activity_release", "CallbackAndContract", "Companion", "LifecycleContainer", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ActivityResultRegistry {

    private static final androidx.activity.result.ActivityResultRegistry.Companion Companion = null;
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    private final transient Map<String, androidx.activity.result.ActivityResultRegistry.CallbackAndContract<?>> keyToCallback;
    private final Map<String, androidx.activity.result.ActivityResultRegistry.LifecycleContainer> keyToLifecycleContainers;
    private final Map<String, Integer> keyToRc;
    private final List<String> launchedKeys;
    private final Map<String, Object> parsedPendingResults;
    private final Bundle pendingResults;
    private final Map<Integer, String> rcToKey;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B%\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0010\u0005\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u0005\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Landroidx/activity/result/ActivityResultRegistry$CallbackAndContract;", "O", "", "callback", "Landroidx/activity/result/ActivityResultCallback;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "(Landroidx/activity/result/ActivityResultCallback;Landroidx/activity/result/contract/ActivityResultContract;)V", "getCallback", "()Landroidx/activity/result/ActivityResultCallback;", "getContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CallbackAndContract {

        private final androidx.activity.result.ActivityResultCallback<O> callback;
        private final ActivityResultContract<?, O> contract;
        public CallbackAndContract(androidx.activity.result.ActivityResultCallback<O> callback, ActivityResultContract<?, O> contract) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(contract, "contract");
            super();
            this.callback = callback;
            this.contract = contract;
        }

        public final androidx.activity.result.ActivityResultCallback<O> getCallback() {
            return this.callback;
        }

        public final ActivityResultContract<?, O> getContract() {
            return this.contract;
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Landroidx/activity/result/ActivityResultRegistry$Companion;", "", "()V", "INITIAL_REQUEST_CODE_VALUE", "", "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", "", "KEY_COMPONENT_ACTIVITY_PENDING_RESULTS", "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", "LOG_TAG", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Landroidx/activity/result/ActivityResultRegistry$LifecycleContainer;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "observers", "", "Landroidx/lifecycle/LifecycleEventObserver;", "addObserver", "", "observer", "clearObservers", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LifecycleContainer {

        private final Lifecycle lifecycle;
        private final List<LifecycleEventObserver> observers;
        public LifecycleContainer(Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            super();
            this.lifecycle = lifecycle;
            ArrayList arrayList = new ArrayList();
            this.observers = (List)arrayList;
        }

        public final void addObserver(LifecycleEventObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.lifecycle.addObserver((LifecycleObserver)observer);
            this.observers.add(observer);
        }

        public final void clearObservers() {
            Object next;
            Object obj;
            int i;
            Lifecycle lifecycle;
            Object obj2;
            final int i2 = 0;
            final Iterator iterator = (Iterable)this.observers.iterator();
            for (Object next : iterator) {
                i = 0;
                this.lifecycle.removeObserver((LifecycleObserver)(LifecycleEventObserver)next);
            }
            this.observers.clear();
        }

        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }
    }
    public static void $r8$lambda$TWvtyPFk-iHdx0R-btWVLevVLT0(androidx.activity.result.ActivityResultRegistry activityResultRegistry, String string2, androidx.activity.result.ActivityResultCallback activityResultCallback3, ActivityResultContract activityResultContract4, LifecycleOwner lifecycleOwner5, Lifecycle.Event lifecycle$Event6) {
        ActivityResultRegistry.register$lambda$1(activityResultRegistry, string2, activityResultCallback3, activityResultContract4, lifecycleOwner5, event6);
    }

    static {
        ActivityResultRegistry.Companion companion = new ActivityResultRegistry.Companion(0);
        ActivityResultRegistry.Companion = companion;
    }

    public ActivityResultRegistry() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.rcToKey = (Map)linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.keyToRc = (Map)linkedHashMap2;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        this.keyToLifecycleContainers = (Map)linkedHashMap3;
        ArrayList arrayList = new ArrayList();
        this.launchedKeys = (List)arrayList;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        this.keyToCallback = (Map)linkedHashMap4;
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        this.parsedPendingResults = (Map)linkedHashMap5;
        Bundle bundle = new Bundle();
        this.pendingResults = bundle;
    }

    public static final Map access$getKeyToRc$p(androidx.activity.result.ActivityResultRegistry $this) {
        return $this.keyToRc;
    }

    public static final List access$getLaunchedKeys$p(androidx.activity.result.ActivityResultRegistry $this) {
        return $this.launchedKeys;
    }

    private final void bindRcKey(int rc, String key) {
        this.rcToKey.put(Integer.valueOf(rc), key);
        this.keyToRc.put(key, Integer.valueOf(rc));
    }

    private final <O> void doDispatch(String key, int resultCode, Intent data, androidx.activity.result.ActivityResultRegistry.CallbackAndContract<O> callbackAndContract) {
        int contains;
        Object pendingResults;
        Object activityResult;
        List launchedKeys;
        if (callbackAndContract != null) {
            contains = callbackAndContract.getCallback();
        } else {
            contains = 0;
        }
        if (contains != 0 && this.launchedKeys.contains(key)) {
            if (this.launchedKeys.contains(key)) {
                callbackAndContract.getCallback().onActivityResult(callbackAndContract.getContract().parseResult(resultCode, data));
                this.launchedKeys.remove(key);
            } else {
                this.parsedPendingResults.remove(key);
                activityResult = new ActivityResult(resultCode, data);
                this.pendingResults.putParcelable(key, (Parcelable)activityResult);
            }
        } else {
        }
    }

    private final int generateRandomNumber() {
        Object next;
        int intValue;
        int i;
        boolean key;
        Integer valueOf;
        final int i2 = 0;
        Iterator iterator = SequencesKt.generateSequence((Function0)ActivityResultRegistry.generateRandomNumber.1.INSTANCE).iterator();
        for (Object next : iterator) {
            i = 0;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Sequence contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final void register$lambda$1(androidx.activity.result.ActivityResultRegistry this$0, String $key, androidx.activity.result.ActivityResultCallback $callback, ActivityResultContract $contract, LifecycleOwner lifecycleOwner5, Lifecycle.Event event) {
        String result;
        Object parsedPendingResults;
        Intent data;
        Object obj6;
        Intrinsics.checkNotNullParameter(lifecycleOwner5, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (Lifecycle.Event.ON_START == event) {
            parsedPendingResults = new ActivityResultRegistry.CallbackAndContract($callback, $contract);
            this$0.keyToCallback.put($key, parsedPendingResults);
            if (this$0.parsedPendingResults.containsKey($key)) {
                this$0.parsedPendingResults.remove($key);
                $callback.onActivityResult(this$0.parsedPendingResults.get($key));
            }
            obj6 = BundleCompat.getParcelable(this$0.pendingResults, $key, ActivityResult.class);
            if ((ActivityResult)obj6 != null) {
                this$0.pendingResults.remove($key);
                $callback.onActivityResult($contract.parseResult((ActivityResult)obj6.getResultCode(), obj6.getData()));
            }
        } else {
            if (Lifecycle.Event.ON_STOP == event) {
                this$0.keyToCallback.remove($key);
            } else {
                if (Lifecycle.Event.ON_DESTROY == event) {
                    this$0.unregister$activity_release($key);
                }
            }
        }
    }

    private final void registerKey(String key) {
        if ((Integer)this.keyToRc.get(key) != null) {
        }
        bindRcKey(generateRandomNumber(), key);
    }

    public final boolean dispatchResult(int requestCode, int resultCode, Intent data) {
        Object obj = this.rcToKey.get(Integer.valueOf(requestCode));
        if ((String)obj == null) {
            return 0;
        }
        doDispatch(obj, resultCode, data, (ActivityResultRegistry.CallbackAndContract)this.keyToCallback.get((String)obj));
        return 1;
    }

    public final <O> boolean dispatchResult(int requestCode, O result) {
        androidx.activity.result.ActivityResultCallback callback;
        Object parsedPendingResults;
        boolean remove;
        Object obj = this.rcToKey.get(Integer.valueOf(requestCode));
        if ((String)obj == null) {
            return 0;
        }
        Object obj2 = this.keyToCallback.get((String)obj);
        if ((ActivityResultRegistry.CallbackAndContract)obj2 != null) {
            callback = (ActivityResultRegistry.CallbackAndContract)obj2.getCallback();
        } else {
            callback = 0;
        }
        if (callback == null) {
            this.pendingResults.remove(obj);
            this.parsedPendingResults.put(obj, result);
        } else {
            parsedPendingResults = obj2.getCallback();
            Intrinsics.checkNotNull(parsedPendingResults, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
            if (this.launchedKeys.remove(obj)) {
                parsedPendingResults.onActivityResult(result);
            }
        }
        return 1;
    }

    public abstract <I, O> void onLaunch(int i, ActivityResultContract<I, O> activityResultContract2, I i3, ActivityOptionsCompat activityOptionsCompat4);

    public final void onRestoreInstanceState(Bundle savedInstanceState) {
        List launchedKeys;
        ArrayList pendingResults;
        int i;
        Object obj;
        int intValue;
        boolean remove;
        Object mutableMap;
        String str;
        if (savedInstanceState == null) {
        }
        ArrayList integerArrayList = savedInstanceState.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList stringArrayList = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null) {
            if (integerArrayList == null) {
            } else {
                ArrayList stringArrayList2 = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                if (stringArrayList2 != null) {
                    this.launchedKeys.addAll((Collection)stringArrayList2);
                }
                Bundle bundle = savedInstanceState.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                if (bundle != null) {
                    this.pendingResults.putAll(bundle);
                }
                i = 0;
                while (i < (Collection)stringArrayList.size()) {
                    obj = stringArrayList.get(i);
                    if (this.keyToRc.containsKey((String)obj) && !this.pendingResults.containsKey(obj)) {
                    }
                    Object obj2 = integerArrayList.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj2, "rcs[i]");
                    mutableMap = stringArrayList.get(i);
                    Intrinsics.checkNotNullExpressionValue(mutableMap, "keys[i]");
                    bindRcKey((Number)obj2.intValue(), (String)mutableMap);
                    i++;
                    if (!this.pendingResults.containsKey(obj)) {
                    }
                    TypeIntrinsics.asMutableMap(this.rcToKey).remove((Integer)this.keyToRc.remove(obj));
                }
            }
        }
    }

    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        ArrayList arrayList = new ArrayList(this.keyToRc.values());
        outState.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", arrayList);
        ArrayList arrayList2 = new ArrayList((Collection)this.keyToRc.keySet());
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", arrayList2);
        ArrayList arrayList3 = new ArrayList((Collection)this.launchedKeys);
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", arrayList3);
        Bundle bundle = new Bundle(this.pendingResults);
        outState.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", bundle);
    }

    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> register(String key, ActivityResultContract<I, O> contract, androidx.activity.result.ActivityResultCallback<O> callback) {
        boolean key2;
        Object parsedPendingResults;
        Class<androidx.activity.result.ActivityResult> result;
        Intent data;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        registerKey(key);
        parsedPendingResults = new ActivityResultRegistry.CallbackAndContract(callback, contract);
        this.keyToCallback.put(key, parsedPendingResults);
        if (this.parsedPendingResults.containsKey(key)) {
            this.parsedPendingResults.remove(key);
            callback.onActivityResult(this.parsedPendingResults.get(key));
        }
        Object parcelable = BundleCompat.getParcelable(this.pendingResults, key, ActivityResult.class);
        if ((ActivityResult)parcelable != null) {
            this.pendingResults.remove(key);
            callback.onActivityResult(contract.parseResult((ActivityResult)parcelable.getResultCode(), parcelable.getData()));
        }
        ActivityResultRegistry.register.3 anon = new ActivityResultRegistry.register.3(this, key, contract);
        return (ActivityResultLauncher)anon;
    }

    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> register(String key, LifecycleOwner lifecycleOwner, ActivityResultContract<I, O> contract, androidx.activity.result.ActivityResultCallback<O> callback) {
        Object lifecycleContainer;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
        } else {
            registerKey(key);
            if ((ActivityResultRegistry.LifecycleContainer)this.keyToLifecycleContainers.get(key) == null) {
                lifecycleContainer = new ActivityResultRegistry.LifecycleContainer(lifecycle);
            }
            ActivityResultRegistry$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ActivityResultRegistry$$ExternalSyntheticLambda0(this, key, callback, contract);
            lifecycleContainer.addObserver(externalSyntheticLambda0);
            this.keyToLifecycleContainers.put(key, lifecycleContainer);
            ActivityResultRegistry.register.2 anon = new ActivityResultRegistry.register.2(this, key, contract);
            return (ActivityResultLauncher)anon;
        }
        int lifecycleContainer2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("LifecycleOwner ").append(lifecycleOwner).append(" is attempting to register while current state is ").append(lifecycle.getCurrentState()).append(". LifecycleOwners must call register before they are STARTED.").toString().toString());
        throw illegalStateException;
    }

    public final void unregister$activity_release(String key) {
        boolean contains;
        boolean parsedPendingResults;
        boolean parcelable;
        Map rcToKey;
        Object keyToLifecycleContainers;
        Object append;
        Object stringBuilder;
        Intrinsics.checkNotNullParameter(key, "key");
        contains = this.keyToRc.remove(key);
        if (!this.launchedKeys.contains(key) && (Integer)contains != null) {
            contains = this.keyToRc.remove(key);
            if ((Integer)(Integer)contains != null) {
                this.rcToKey.remove((Integer)(Integer)contains);
            }
        }
        this.keyToCallback.remove(key);
        keyToLifecycleContainers = ": ";
        append = "Dropping pending result for request ";
        final String str2 = "ActivityResultRegistry";
        if (this.parsedPendingResults.containsKey(key)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            Log.w(str2, stringBuilder2.append(append).append(key).append(keyToLifecycleContainers).append(this.parsedPendingResults.get(key)).toString());
            this.parsedPendingResults.remove(key);
        }
        if (this.pendingResults.containsKey(key)) {
            stringBuilder = new StringBuilder();
            Log.w(str2, stringBuilder.append(append).append(key).append(keyToLifecycleContainers).append((ActivityResult)BundleCompat.getParcelable(this.pendingResults, key, ActivityResult.class)).toString());
            this.pendingResults.remove(key);
        }
        Object obj = this.keyToLifecycleContainers.get(key);
        if ((ActivityResultRegistry.LifecycleContainer)obj != null) {
            (ActivityResultRegistry.LifecycleContainer)obj.clearObservers();
            this.keyToLifecycleContainers.remove(key);
        }
    }
}
