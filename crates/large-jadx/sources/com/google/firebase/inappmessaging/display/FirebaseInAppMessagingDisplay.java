package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader.FiamImageRequestCreator;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.Action.Builder;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import d.c.b.c;
import d.c.b.c.a;
import j.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {

    static final long DISMISS_THRESHOLD_MILLIS = 20000L;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000L;
    static final long INTERVAL_MILLIS = 1000L;
    private final FiamAnimator animator;
    private final Application application;
    private final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    private FirebaseInAppMessagingDisplayCallbacks callbacks;
    String currentlyBoundActivityName;
    private com.google.firebase.inappmessaging.display.FiamListener fiamListener;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    private final RenewableTimer impressionTimer;
    private InAppMessage inAppMessage;
    private final Map<String, a<InAppMessageLayoutConfig>> layoutConfigs;
    private final FiamWindowManager windowManager;
    FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, a<InAppMessageLayoutConfig>> map2, FiamImageLoader fiamImageLoader3, RenewableTimer renewableTimer4, RenewableTimer renewableTimer5, FiamWindowManager fiamWindowManager6, Application application7, BindingWrapperFactory bindingWrapperFactory8, FiamAnimator fiamAnimator9) {
        super();
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map2;
        this.imageLoader = fiamImageLoader3;
        this.impressionTimer = renewableTimer4;
        this.autoDismissTimer = renewableTimer5;
        this.windowManager = fiamWindowManager6;
        this.application = application7;
        this.bindingWrapperFactory = bindingWrapperFactory8;
        this.animator = fiamAnimator9;
    }

    private void a(Activity activity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        InAppMessage messagesSuppressed;
        if (this.inAppMessage == null && this.headlessInAppMessaging.areMessagesSuppressed()) {
            if (this.headlessInAppMessaging.areMessagesSuppressed()) {
            }
            this.inAppMessage = inAppMessage2;
            this.callbacks = firebaseInAppMessagingDisplayCallbacks3;
            showActiveFiam(activity);
        }
        Logging.logd("Active FIAM exists. Skipping trigger");
    }

    static void access$000(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity2, BindingWrapper bindingWrapper3) {
        firebaseInAppMessagingDisplay.inflateBinding(activity2, bindingWrapper3);
    }

    static FirebaseInAppMessagingDisplayCallbacks access$100(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        return firebaseInAppMessagingDisplay.callbacks;
    }

    static Application access$1000(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        return firebaseInAppMessagingDisplay.application;
    }

    static FirebaseInAppMessagingDisplayCallbacks access$102(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2) {
        firebaseInAppMessagingDisplay.callbacks = firebaseInAppMessagingDisplayCallbacks2;
        return firebaseInAppMessagingDisplayCallbacks2;
    }

    static FiamAnimator access$1100(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        return firebaseInAppMessagingDisplay.animator;
    }

    static void access$1200(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        firebaseInAppMessagingDisplay.cancelTimers();
    }

    static void access$200(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity2) {
        firebaseInAppMessagingDisplay.dismissFiam(activity2);
    }

    static void access$300(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity2, Uri uri3) {
        firebaseInAppMessagingDisplay.launchUriIntent(activity2, uri3);
    }

    static void access$400(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        firebaseInAppMessagingDisplay.notifyFiamClick();
    }

    static void access$500(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity2) {
        firebaseInAppMessagingDisplay.removeDisplayedFiam(activity2);
    }

    static InAppMessage access$600(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        return firebaseInAppMessagingDisplay.inAppMessage;
    }

    static InAppMessage access$602(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, InAppMessage inAppMessage2) {
        firebaseInAppMessagingDisplay.inAppMessage = inAppMessage2;
        return inAppMessage2;
    }

    static RenewableTimer access$700(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        return firebaseInAppMessagingDisplay.impressionTimer;
    }

    static RenewableTimer access$800(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        return firebaseInAppMessagingDisplay.autoDismissTimer;
    }

    static FiamWindowManager access$900(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        return firebaseInAppMessagingDisplay.windowManager;
    }

    private void bindFiamToActivity(Activity activity) {
        boolean currentlyBoundActivityName;
        Object localClassName;
        currentlyBoundActivityName = this.currentlyBoundActivityName;
        if (currentlyBoundActivityName != null) {
            if (!currentlyBoundActivityName.equals(activity.getLocalClassName())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Binding to activity: ");
                stringBuilder.append(activity.getLocalClassName());
                Logging.logi(stringBuilder.toString());
                localClassName = new a(this, activity);
                this.headlessInAppMessaging.setMessageDisplayComponent(localClassName);
                this.currentlyBoundActivityName = activity.getLocalClassName();
            }
        } else {
        }
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    private void cancelTimers() {
        this.impressionTimer.cancel();
        this.autoDismissTimer.cancel();
    }

    private void dismissFiam(Activity activity) {
        Logging.logd("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        final int obj2 = 0;
        this.inAppMessage = obj2;
        this.callbacks = obj2;
    }

    private List<Action> extractActions(InAppMessage inAppMessage) {
        int primaryAction;
        int i;
        Action obj4;
        ArrayList arrayList = new ArrayList();
        primaryAction = FirebaseInAppMessagingDisplay.5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (primaryAction != 1) {
            if (primaryAction != 2) {
                if (primaryAction != 3) {
                    if (primaryAction != 4) {
                        arrayList.add(Action.builder().build());
                    } else {
                        arrayList.add((CardMessage)inAppMessage.getPrimaryAction());
                        arrayList.add(inAppMessage.getSecondaryAction());
                    }
                } else {
                    arrayList.add((ImageOnlyMessage)inAppMessage.getAction());
                }
            } else {
                arrayList.add((ModalMessage)inAppMessage.getAction());
            }
        } else {
            arrayList.add((BannerMessage)inAppMessage.getAction());
        }
        return arrayList;
    }

    private ImageData extractImageData(InAppMessage inAppMessage) {
        ImageData portraitImageData;
        ImageData obj4 = inAppMessage.getLandscapeImageData();
        if (inAppMessage.getMessageType() == MessageType.CARD && FirebaseInAppMessagingDisplay.getScreenOrientation(this.application) == 1) {
            obj4 = inAppMessage.getLandscapeImageData();
            if (FirebaseInAppMessagingDisplay.getScreenOrientation(this.application) == 1) {
                if (isValidImageData((CardMessage)inAppMessage.getPortraitImageData())) {
                } else {
                    portraitImageData = obj4;
                }
                return portraitImageData;
            }
            if (isValidImageData(obj4)) {
                portraitImageData = obj4;
            }
            return portraitImageData;
        }
        return inAppMessage.getImageData();
    }

    public static com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay)FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application) {
        return obj0.orientation;
    }

    private void inflateBinding(Activity activity, BindingWrapper bindingWrapper2) {
        Object viewTreeObserver;
        Object next;
        com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.3 empty;
        FirebaseInAppMessagingDisplay.2 anon = new FirebaseInAppMessagingDisplay.2(this, activity);
        viewTreeObserver = new HashMap();
        Iterator iterator = extractActions(this.inAppMessage).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next != null && !TextUtils.isEmpty((Action)next.getActionUrl())) {
            } else {
            }
            Logging.logi("No action url found for action. Treating as dismiss.");
            empty = anon;
            viewTreeObserver.put(next, empty);
            if (!TextUtils.isEmpty(next.getActionUrl())) {
            } else {
            }
            empty = new FirebaseInAppMessagingDisplay.3(this, next, activity);
        }
        ViewTreeObserver.OnGlobalLayoutListener inflate = bindingWrapper2.inflate(viewTreeObserver, anon);
        if (inflate != null) {
            bindingWrapper2.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(inflate);
        }
        FirebaseInAppMessagingDisplay.4 anon2 = new FirebaseInAppMessagingDisplay.4(this, bindingWrapper2, activity, inflate);
        loadNullableImage(activity, bindingWrapper2, extractImageData(this.inAppMessage), anon2);
    }

    private boolean isValidImageData(ImageData imageData) {
        boolean obj1;
        if (imageData != null && !TextUtils.isEmpty(imageData.getImageUrl())) {
            obj1 = !TextUtils.isEmpty(imageData.getImageUrl()) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private boolean ishttpOrHttpsUri(Uri uri) {
        int i;
        boolean equalsIgnoreCase;
        String obj3;
        if (uri == null) {
            return 0;
        }
        obj3 = uri.getScheme();
        if (obj3 != null) {
            if (!obj3.equalsIgnoreCase("http")) {
                if (obj3.equalsIgnoreCase("https")) {
                    i = 1;
                }
            } else {
            }
        }
        return i;
    }

    private void launchUriIntent(Activity activity, Uri uri2) {
        boolean supportsCustomTabs;
        Object intent;
        int i;
        Object obj5;
        Object obj6;
        final int i2 = 268435456;
        final int i3 = 1073741824;
        if (ishttpOrHttpsUri(uri2) && supportsCustomTabs(activity)) {
            if (supportsCustomTabs(activity)) {
                c.a aVar = new c.a();
                intent = aVar.a();
                i = intent.a;
                i.addFlags(i3);
                i.addFlags(i2);
                intent.a(activity, uri2);
            } else {
                intent = new Intent("android.intent.action.VIEW", uri2);
                intent.addFlags(i3);
                intent.addFlags(i2);
                if (activity.getPackageManager().resolveActivity(intent, 0) != null) {
                    activity.startActivity(intent);
                } else {
                    Logging.loge("Device cannot resolve intent for: android.intent.action.VIEW");
                }
            }
        } else {
        }
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper2, ImageData imageData3, FiamImageLoader.Callback fiamImageLoader$Callback4) {
        FiamImageLoader validImageData;
        FiamImageLoader.FiamImageRequestCreator obj2;
        ImageView obj3;
        int obj4;
        if (isValidImageData(imageData3)) {
            this.imageLoader.load(imageData3.getImageUrl()).tag(activity.getClass()).placeholder(R.drawable.image_placeholder).into(bindingWrapper2.getImageView(), callback4);
        } else {
            callback4.onSuccess();
        }
    }

    private void notifyFiamClick() {
        final com.google.firebase.inappmessaging.display.FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        final com.google.firebase.inappmessaging.display.FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    private void notifyFiamTrigger() {
        final com.google.firebase.inappmessaging.display.FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    private void removeDisplayedFiam(Activity activity) {
        boolean fiamDisplayed;
        if (this.windowManager.isFiamDisplayed()) {
            this.windowManager.destroy(activity);
            cancelTimers();
        }
    }

    private void showActiveFiam(Activity activity) {
        BindingWrapper bannerBindingWrapper;
        InAppMessage messagesSuppressed;
        BindingWrapperFactory bindingWrapperFactory;
        InAppMessage inAppMessage;
        if (this.inAppMessage != null) {
            if (this.headlessInAppMessaging.areMessagesSuppressed()) {
            } else {
                if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
                    Logging.loge("The message being triggered is not supported by this version of the sdk.");
                }
                notifyFiamTrigger();
                Object obj2 = (a)this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), FirebaseInAppMessagingDisplay.getScreenOrientation(this.application))).get();
                int i = FirebaseInAppMessagingDisplay.5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[this.inAppMessage.getMessageType().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                Logging.loge("No bindings found for this message type");
                            }
                            bannerBindingWrapper = this.bindingWrapperFactory.createCardBindingWrapper((InAppMessageLayoutConfig)obj2, this.inAppMessage);
                        } else {
                            bannerBindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(obj2, this.inAppMessage);
                        }
                    } else {
                        bannerBindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper(obj2, this.inAppMessage);
                    }
                } else {
                    bannerBindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper(obj2, this.inAppMessage);
                }
            }
            FirebaseInAppMessagingDisplay.1 anon = new FirebaseInAppMessagingDisplay.1(this, activity, bannerBindingWrapper);
            activity.findViewById(16908290).post(anon);
        }
        Logging.loge("No active message found to render");
    }

    private boolean supportsCustomTabs(Activity activity) {
        int i;
        List obj3;
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intent.setPackage("com.android.chrome");
        obj3 = activity.getPackageManager().queryIntentServices(intent, 0);
        if (obj3 != null && !obj3.isEmpty()) {
            if (!obj3.isEmpty()) {
                i = 1;
            }
        }
        return i;
    }

    private void unbindFiamFromActivity(Activity activity) {
        String currentlyBoundActivityName;
        Object localClassName;
        Activity obj3;
        currentlyBoundActivityName = this.currentlyBoundActivityName;
        if (currentlyBoundActivityName != null && currentlyBoundActivityName.equals(activity.getLocalClassName())) {
            if (currentlyBoundActivityName.equals(activity.getLocalClassName())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unbinding from activity: ");
                stringBuilder.append(activity.getLocalClassName());
                Logging.logi(stringBuilder.toString());
                this.headlessInAppMessaging.clearDisplayListener();
                this.imageLoader.cancelTag(activity.getClass());
                removeDisplayedFiam(activity);
                this.currentlyBoundActivityName = 0;
            }
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl
    public void b(Activity activity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        a(activity, inAppMessage2, firebaseInAppMessagingDisplayCallbacks3);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl
    public void clearFiamListener() {
        this.fiamListener = 0;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl
    InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl
    public void onActivityPaused(Activity activity) {
        unbindFiamFromActivity(activity);
        this.headlessInAppMessaging.removeAllListeners();
        super.onActivityPaused(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        bindFiamToActivity(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl
    public void setFiamListener(com.google.firebase.inappmessaging.display.FiamListener fiamListener) {
        this.fiamListener = fiamListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl
    public void testMessage(Activity activity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        this.inAppMessage = inAppMessage2;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks3;
        showActiveFiam(activity);
    }
}
