package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.e0.g;
import com.facebook.e0.g.a;
import com.facebook.e0.i;
import com.facebook.e0.v.a;
import com.facebook.e0.v.c;
import com.facebook.e0.v.c.a;
import com.facebook.e0.x.a;
import com.facebook.internal.a;
import com.facebook.internal.a.a;
import com.facebook.internal.b;
import com.facebook.internal.b.a;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import com.facebook.internal.g0.e;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.l;
import com.facebook.internal.l.a;
import com.facebook.internal.l.b;
import com.facebook.internal.q;
import com.facebook.internal.u;
import com.facebook.internal.w;
import com.facebook.internal.z;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.q0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0017\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0011\n\u0002\u0008\u0016\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0004\u008e\u0001\u008f\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020=H\u0007J\u0008\u0010F\u001a\u00020DH\u0007J\u0008\u0010G\u001a\u00020DH\u0007J\u0008\u0010H\u001a\u00020(H\u0007J\u0008\u0010I\u001a\u00020$H\u0007J\u0008\u0010J\u001a\u00020\u0004H\u0007J\n\u0010K\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010L\u001a\u0004\u0018\u00010\u00042\u0008\u0010M\u001a\u0004\u0018\u00010$H\u0007J\u0008\u0010N\u001a\u00020(H\u0007J\u0008\u0010O\u001a\u00020(H\u0007J\n\u0010P\u001a\u0004\u0018\u00010+H\u0007J\u0008\u0010Q\u001a\u00020\u0015H\u0007J\n\u0010R\u001a\u0004\u0018\u00010\u0004H\u0007J\u0008\u0010S\u001a\u00020(H\u0007J\u0008\u0010T\u001a\u00020(H\u0007J\u0008\u0010U\u001a\u000200H\u0007J\u0008\u0010V\u001a\u00020\u0004H\u0007J\u0008\u0010W\u001a\u00020\u0004H\u0007J\u0008\u0010X\u001a\u00020\u0004H\u0007J\u0008\u0010Y\u001a\u00020\u0004H\u0007J\u0010\u0010Z\u001a\u00020(2\u0006\u0010M\u001a\u00020$H\u0007J\u000e\u0010[\u001a\u0008\u0012\u0004\u0012\u00020=0\\H\u0007J\u0008\u0010]\u001a\u00020(H\u0007J\u0008\u0010^\u001a\u00020_H\u0007J\u0008\u0010`\u001a\u00020\u0004H\u0007J\u0008\u0010a\u001a\u00020(H\u0007J\u0010\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u00020\u0015H\u0007J\u0008\u00109\u001a\u00020(H\u0007J\u0008\u0010d\u001a\u00020(H\u0007J\u0008\u0010:\u001a\u00020(H\u0007J\u0010\u0010e\u001a\u00020(2\u0006\u0010E\u001a\u00020=H\u0007J\u0017\u0010f\u001a\u00020D2\u0008\u0010M\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0008gJ\u0018\u0010h\u001a\u00020D2\u0006\u0010M\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0003J\u0018\u0010i\u001a\u00020D2\u0006\u0010M\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0007J\u0010\u0010j\u001a\u00020D2\u0006\u0010E\u001a\u00020=H\u0007J\u0010\u0010k\u001a\u00020D2\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u0010k\u001a\u00020D2\u0006\u0010#\u001a\u00020$2\u0008\u0010l\u001a\u0004\u0018\u00010mH\u0007J\u0018\u0010k\u001a\u00020D2\u0006\u0010#\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0015H\u0007J\"\u0010k\u001a\u00020D2\u0006\u0010#\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00152\u0008\u0010l\u001a\u0004\u0018\u00010mH\u0007J\u0010\u0010n\u001a\u00020D2\u0006\u0010o\u001a\u00020(H\u0007J\u0010\u0010p\u001a\u00020D2\u0006\u0010%\u001a\u00020\u0004H\u0007J\u0012\u0010q\u001a\u00020D2\u0008\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010r\u001a\u00020D2\u0006\u0010o\u001a\u00020(H\u0007J\u0010\u0010s\u001a\u00020D2\u0006\u0010o\u001a\u00020(H\u0007J\u0010\u0010t\u001a\u00020D2\u0006\u0010)\u001a\u00020+H\u0007J\u0012\u0010u\u001a\u00020D2\u0008\u0010v\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010w\u001a\u00020D2\u0006\u0010o\u001a\u00020(H\u0007J\u001d\u0010x\u001a\u00020D2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010zH\u0007¢\u0006\u0002\u0010{J-\u0010x\u001a\u00020D2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010z2\u0006\u0010|\u001a\u00020\u00152\u0006\u0010}\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010~J\u0010\u0010\u007f\u001a\u00020D2\u0006\u0010/\u001a\u000200H\u0007J\u0011\u0010\u0080\u0001\u001a\u00020D2\u0006\u00101\u001a\u00020\u0004H\u0007J\u0011\u0010\u0081\u0001\u001a\u00020D2\u0006\u00102\u001a\u00020\u0004H\u0007J\u0017\u0010\u0082\u0001\u001a\u00020D2\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0003\u0008\u0083\u0001J\u0012\u0010\u0084\u0001\u001a\u00020D2\u0007\u0010\u0085\u0001\u001a\u00020(H\u0007J\u0012\u0010\u0086\u0001\u001a\u00020D2\u0007\u0010\u0087\u0001\u001a\u00020(H\u0007J\u001a\u0010\u0088\u0001\u001a\u00020D2\u0006\u0010M\u001a\u00020$2\u0007\u0010\u0089\u0001\u001a\u00020(H\u0007J\u0011\u0010\u008a\u0001\u001a\u00020D2\u0006\u0010o\u001a\u00020(H\u0007J\u0012\u0010\u008b\u0001\u001a\u00020D2\u0007\u0010\u008c\u0001\u001a\u00020_H\u0007J\t\u0010\u008d\u0001\u001a\u00020DH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u0008\u0012\u0004\u0012\u00020+0*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u0012\u0012\u0004\u0012\u00020=0<j\u0008\u0012\u0004\u0012\u00020=`>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001", d2 = {"Lcom/facebook/FacebookSdk;", "", "()V", "ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY", "", "APPLICATION_ID_PROPERTY", "APPLICATION_NAME_PROPERTY", "APP_EVENT_PREFERENCES", "ATTRIBUTION_PREFERENCES", "AUTO_INIT_ENABLED_PROPERTY", "AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY", "CALLBACK_OFFSET_CHANGED_AFTER_INIT", "CALLBACK_OFFSET_NEGATIVE", "CALLBACK_OFFSET_PROPERTY", "CLIENT_TOKEN_PROPERTY", "CODELESS_DEBUG_LOG_ENABLED_PROPERTY", "DATA_PROCESSING_OPTIONS_PREFERENCES", "DATA_PROCESSION_OPTIONS", "DATA_PROCESSION_OPTIONS_COUNTRY", "DATA_PROCESSION_OPTIONS_STATE", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "", "FACEBOOK_COM", "FB_GG", "GAMING", "INSTAGRAM", "INSTAGRAM_COM", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "MAX_REQUEST_CODE_RANGE", "MONITOR_ENABLED_PROPERTY", "PUBLISH_ACTIVITY_PATH", "TAG", "WEB_DIALOG_THEME", "appClientToken", "applicationContext", "Landroid/content/Context;", "applicationId", "applicationName", "bypassAppSwitch", "", "cacheDir", "Lcom/facebook/internal/LockOnGetVariable;", "Ljava/io/File;", "callbackRequestCodeOffset", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "executor", "Ljava/util/concurrent/Executor;", "facebookDomain", "graphApiVersion", "graphRequestCreator", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "instagramDomain", "isDebugEnabledField", "isFullyInitialized", "isLegacyTokenUpgradeSupported", "loggingBehaviors", "Ljava/util/HashSet;", "Lcom/facebook/LoggingBehavior;", "Lkotlin/collections/HashSet;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "addLoggingBehavior", "", "behavior", "clearLoggingBehaviors", "fullyInitialize", "getAdvertiserIDCollectionEnabled", "getApplicationContext", "getApplicationId", "getApplicationName", "getApplicationSignature", "context", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCacheDir", "getCallbackRequestCodeOffset", "getClientToken", "getCodelessDebugLogEnabled", "getCodelessSetupEnabled", "getExecutor", "getFacebookDomain", "getGraphApiVersion", "getGraphDomain", "getInstagramDomain", "getLimitEventAndDataUsage", "getLoggingBehaviors", "", "getMonitorEnabled", "getOnProgressThreshold", "", "getSdkVersion", "isDebugEnabled", "isFacebookRequestCode", "requestCode", "isInitialized", "isLoggingBehaviorEnabled", "loadDefaultsFromMetadata", "loadDefaultsFromMetadata$facebook_core_release", "publishInstallAndWaitForResponse", "publishInstallAsync", "removeLoggingBehavior", "sdkInitialize", "callback", "Lcom/facebook/FacebookSdk$InitializeCallback;", "setAdvertiserIDCollectionEnabled", "flag", "setApplicationId", "setApplicationName", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setCacheDir", "setClientToken", "clientToken", "setCodelessDebugLogEnabled", "setDataProcessingOptions", "options", "", "([Ljava/lang/String;)V", "country", "state", "([Ljava/lang/String;II)V", "setExecutor", "setFacebookDomain", "setGraphApiVersion", "setGraphRequestCreator", "setGraphRequestCreator$facebook_core_release", "setIsDebugEnabled", "enabled", "setLegacyTokenUpgradeSupported", "supported", "setLimitEventAndDataUsage", "limitEventUsage", "setMonitorEnabled", "setOnProgressThreshold", "threshold", "updateGraphDebugBehavior", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class o {

    private static final String a = "com.facebook.o";
    private static final HashSet<com.facebook.v> b;
    private static Executor c;
    private static volatile String d;
    private static volatile String e;
    private static volatile String f;
    private static volatile Boolean g;
    private static AtomicLong h;
    private static volatile boolean i;
    private static boolean j;
    private static Context k;
    private static int l;
    private static final ReentrantLock m;
    private static String n;
    public static boolean o;
    public static boolean p;
    public static boolean q;
    private static final AtomicBoolean r;
    private static volatile String s;
    private static volatile String t;
    private static com.facebook.o.a u;
    private static boolean v;
    public static final com.facebook.o w;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008á\u0080\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u000c", d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", "", "createPostRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "publishUrl", "", "publishParams", "Lorg/json/JSONObject;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract com.facebook.p a(com.facebook.a a, String string2, JSONObject jSONObject3, com.facebook.p.b p$b4);
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", "", "onInitialized", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface b {
        public abstract void a();
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class d implements Runnable {

        final Context a;
        final String b;
        d(Context context, String string2) {
            this.a = context;
            this.b = string2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            final Context context = this.a;
            n.e(context, "applicationContext");
            o.c(o.w, context, this.b);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\u0008\u0003", d2 = {"<anonymous>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 5, 1})
    static final class e implements Callable {

        public static final com.facebook.o.e a;
        static {
            o.e eVar = new o.e();
            o.e.a = eVar;
        }

        @Override // java.util.concurrent.Callable
        public final File a() {
            return o.a(o.w).getCacheDir();
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\u0008\u0003", d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 5, 1})
    static final class k implements Callable {

        final com.facebook.o.b a;
        k(com.facebook.o.b o$b) {
            this.a = b;
            super();
        }

        @Override // java.util.concurrent.Callable
        public final Void a() {
            boolean z;
            com.facebook.w wVar;
            d.g.e().h();
            y.e.a().d();
            z = w.A;
            if (a.H.g() && z.b() == null) {
                z = w.A;
                if (z.b() == null) {
                    z.a();
                }
            }
            com.facebook.o.b bVar = this.a;
            if (bVar != null) {
                bVar.a();
            }
            g.a aVar3 = g.b;
            aVar3.e(o.f(), o.b(o.w));
            d0.m();
            Context applicationContext = o.f().getApplicationContext();
            n.e(applicationContext, "getApplicationContext().applicationContext");
            aVar3.f(applicationContext).a();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\u0008\n", d2 = {"<anonymous>", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "publishUrl", "", "publishParams", "Lorg/json/JSONObject;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createPostRequest"}, k = 3, mv = {1, 5, 1})
    static final class c implements com.facebook.o.a {

        public static final com.facebook.o.c a;
        static {
            o.c cVar = new o.c();
            o.c.a = cVar;
        }

        @Override // com.facebook.o$a
        public final com.facebook.p a(com.facebook.a a, String string2, JSONObject jSONObject3, com.facebook.p.b p$b4) {
            return p.t.x(a, string2, jSONObject3, b4);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class f implements l.a {

        public static final com.facebook.o.f a;
        static {
            o.f fVar = new o.f();
            o.f.a = fVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            if (z) {
                e.a();
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class g implements l.a {

        public static final com.facebook.o.g a;
        static {
            o.g gVar = new o.g();
            o.g.a = gVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            if (z) {
                i.a();
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class h implements l.a {

        public static final com.facebook.o.h a;
        static {
            o.h hVar = new o.h();
            o.h.a = hVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            int obj1;
            if (z != 0) {
                o.o = true;
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class i implements l.a {

        public static final com.facebook.o.i a;
        static {
            o.i iVar = new o.i();
            o.i.a = iVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            int obj1;
            if (z != 0) {
                o.p = true;
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class j implements l.a {

        public static final com.facebook.o.j a;
        static {
            o.j jVar = new o.j();
            o.j.a = jVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            int obj1;
            if (z != 0) {
                o.q = true;
            }
        }
    }
    static {
        o oVar = new o();
        o.w = oVar;
        com.facebook.v[] arr = new v[1];
        final int i3 = 0;
        arr[i3] = v.DEVELOPER_ERRORS;
        o.b = q0.c(arr);
        AtomicLong atomicLong = new AtomicLong(65536, obj4);
        o.h = atomicLong;
        o.l = 64206;
        ReentrantLock reentrantLock = new ReentrantLock();
        o.m = reentrantLock;
        o.n = z.a();
        AtomicBoolean atomicBoolean = new AtomicBoolean(i3);
        o.r = atomicBoolean;
        o.s = "instagram.com";
        o.t = "facebook.com";
        o.u = o.c.a;
    }

    public static final boolean A(com.facebook.v v) {
        Object obj2;
        n.f(v, "behavior");
        HashSet set = o.b;
        synchronized (set) {
            obj2 = set.contains(v) ? 1 : 0;
            return obj2;
        }
    }

    public static final void B(Context context) {
        String substring;
        String string2;
        String string;
        int int;
        Object str2;
        String str3;
        int str;
        String str4;
        int i;
        Object obj6;
        if (context == null) {
        }
        obj6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (obj6.metaData == null) {
            try {
                int i3 = 0;
                if (o.d == null) {
                }
                substring = obj6.metaData.get("com.facebook.sdk.ApplicationId");
                Locale rOOT = Locale.ROOT;
                n.e(rOOT, "Locale.ROOT");
                String lowerCase = (String)substring.toLowerCase(rOOT);
                n.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                i = 2;
                if (l.M(lowerCase, "fb", i3, i, 0)) {
                } else {
                }
                substring = substring.substring(i);
                n.e(substring, "(this as java.lang.String).substring(startIndex)");
                o.d = substring;
                o.d = substring;
                obj6 = new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                throw obj6;
                if (o.e == null) {
                }
                o.e = obj6.metaData.getString("com.facebook.sdk.ApplicationName");
                if (o.f == null) {
                }
                o.f = obj6.metaData.getString("com.facebook.sdk.ClientToken");
                int i4 = 64206;
            }
            o.l = obj6.metaData.getInt("com.facebook.sdk.CallbackOffset", i4);
            if (o.g == null) {
                o.g = Boolean.valueOf(obj6.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", i3));
            }
        }
    }

    private final void C(Context context, String string2) {
        com.facebook.o.a currentTimeMillis;
        Object obj12;
        int obj13;
        if (a.d(this)) {
        }
        int i = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("ping");
        String string = stringBuilder.toString();
        int i3 = 0;
        f0 f0Var = f0.a;
        int i4 = 1;
        Object[] arr = new Object[i4];
        arr[i] = string2;
        obj13 = String.format("%s/activities", Arrays.copyOf(arr, i4));
        n.e(obj13, "java.lang.String.format(format, *args)");
        int i2 = 0;
        if (Long.compare(long, i3) == 0 && o.u.a(i2, obj13, c.a(c.a.MOBILE_INSTALL_EVENT, a.h.e(context), g.b.b(context), o.s(context), context), i2).i().b() == null) {
            if (obj12.i().b() == null) {
                obj12 = sharedPreferences.edit();
                obj12.putLong(string, System.currentTimeMillis());
                obj12.apply();
            }
        }
    }

    public static final void D(Context context, String string2) {
        boolean obj3;
        if (a.d(o.class)) {
        }
        n.f(context, "context");
        n.f(string2, "applicationId");
        o.d dVar = new o.d(context.getApplicationContext(), string2);
        o.n().execute(dVar);
        if (l.g(l.b.OnDeviceEventProcessing) && a.b()) {
            if (a.b()) {
                a.d(string2, "com.facebook.sdk.attributionTracking");
            }
        }
    }

    public static final void E(Context context) {
        final Class<com.facebook.o> obj = o.class;
        n.f(context, "applicationContext");
        o.F(context, 0);
        return;
        synchronized (obj) {
            obj = o.class;
            n.f(context, "applicationContext");
            o.F(context, 0);
        }
    }

    public static final void F(Context context, com.facebook.o.b o$b2) {
        Object bool;
        boolean obj4;
        final Class<com.facebook.o> obj = o.class;
        n.f(context, "applicationContext");
        bool = o.r;
        synchronized (obj) {
            if (b2 != null) {
                b2.a();
            }
            try {
                int i = 0;
                c0.e(context, i);
                c0.f(context, i);
                Context applicationContext = context.getApplicationContext();
                n.e(applicationContext, "applicationContext.applicationContext");
                o.k = applicationContext;
                g.b.b(context);
                obj4 = o.k;
                int i2 = 0;
                o.B(obj4);
                if (b0.W(o.d)) {
                } else {
                }
                bool.set(true);
                if (o.i()) {
                }
                o.d();
                obj4 = o.k;
                if (obj4 == null) {
                } else {
                }
                if (obj4 instanceof Application && d0.g()) {
                }
                if (d0.g()) {
                }
                obj4 = o.k;
                if (obj4 == null) {
                } else {
                }
                if (obj4 == null) {
                } else {
                }
                a.x((Application)obj4, o.d);
                obj4 = new NullPointerException("null cannot be cast to non-null type android.app.Application");
                throw obj4;
                n.w("applicationContext");
                throw i2;
                q.k();
                w.z();
                Context context2 = o.k;
                if (context2 == null) {
                } else {
                }
                b.d.a(context2);
                obj4 = new u(o.e.a);
                l.a(l.b.Instrument, o.f.a);
                l.a(l.b.AppEvents, o.g.a);
                l.a(l.b.ChromeCustomTabsPrefetching, o.h.a);
                l.a(l.b.IgnoreAppSwitchToLoggedOut, o.i.a);
                l.a(l.b.BypassAppSwitch, o.j.a);
                o.k kVar = new o.k(b2);
                obj4 = new FutureTask(kVar);
                o.n().execute(obj4);
                n.w("applicationContext");
                throw i2;
                n.w("applicationContext");
                throw i2;
                obj4 = new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
                throw obj4;
            }
            n.w("applicationContext");
            throw i2;
        }
    }

    public static final Context a(com.facebook.o o) {
        Context obj0 = o.k;
        if (obj0 == null) {
        } else {
            return obj0;
        }
        n.w("applicationContext");
        throw 0;
    }

    public static final String b(com.facebook.o o) {
        return o.d;
    }

    public static final void c(com.facebook.o o, Context context2, String string3) {
        o.C(context2, string3);
    }

    public static final void d() {
        o.v = true;
    }

    public static final boolean e() {
        return d0.e();
    }

    public static final Context f() {
        c0.l();
        Context context = o.k;
        if (context == null) {
        } else {
            return context;
        }
        n.w("applicationContext");
        throw 0;
    }

    public static final String g() {
        c0.l();
        String str = o.d;
        if (str == null) {
        } else {
            return str;
        }
        FacebookException facebookException = new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
        throw facebookException;
    }

    public static final String h() {
        c0.l();
        return o.e;
    }

    public static final boolean i() {
        return d0.f();
    }

    public static final boolean j() {
        return d0.g();
    }

    public static final int k() {
        c0.l();
        return o.l;
    }

    public static final String l() {
        c0.l();
        return o.f;
    }

    public static final boolean m() {
        return d0.h();
    }

    public static final Executor n() {
        Executor tHREAD_POOL_EXECUTOR;
        ReentrantLock reentrantLock = o.m;
        reentrantLock.lock();
        if (o.c == null) {
            o.c = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        w wVar = w.a;
        reentrantLock.unlock();
        Executor executor = o.c;
        if (executor == null) {
        } else {
            return executor;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
        throw illegalStateException;
    }

    public static final String o() {
        return o.t;
    }

    public static final String p() {
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = o.n;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        b0.d0(o.a, format);
        return o.n;
    }

    public static final String q() {
        String str;
        com.facebook.a aVar = a.H.e();
        if (aVar != null) {
            str = aVar.i();
        } else {
            str = 0;
        }
        return b0.A(str);
    }

    public static final String r() {
        return o.s;
    }

    public static final boolean s(Context context) {
        n.f(context, "context");
        c0.l();
        final int i = 0;
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", i).getBoolean("limitEventUsage", i);
    }

    public static final long t() {
        c0.l();
        return o.h.get();
    }

    public static final String u() {
        return "12.3.0";
    }

    public static final boolean v() {
        return o.i;
    }

    public static final boolean w(int i) {
        int i2;
        int obj1;
        i2 = o.l;
        if (i >= i2 && i < i2 += 100) {
            obj1 = i < i2 += 100 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static final boolean x() {
        final Class<com.facebook.o> obj = o.class;
        return o.v;
        synchronized (obj) {
            obj = o.class;
            return o.v;
        }
    }

    public static final boolean y() {
        return o.r.get();
    }

    public static final boolean z() {
        return o.j;
    }
}
