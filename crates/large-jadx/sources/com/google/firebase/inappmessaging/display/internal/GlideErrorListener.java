package com.google.firebase.inappmessaging.display.internal;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.k.h;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public class GlideErrorListener implements f<Object> {

    private FirebaseInAppMessagingDisplayCallbacks displayCallbacks;
    private InAppMessage inAppMessage;
    public boolean onLoadFailed(GlideException glideException, Object object2, h<Object> h3, boolean z4) {
        FirebaseInAppMessagingDisplayCallbacks obj1;
        Object obj2;
        obj2 = new StringBuilder();
        obj2.append("Image Downloading  Error : ");
        obj2.append(glideException.getMessage());
        obj2.append(":");
        obj2.append(glideException.getCause());
        Logging.logd(obj2.toString());
        if (this.inAppMessage != null && this.displayCallbacks != null) {
            if (this.displayCallbacks != null) {
                if (glideException.getLocalizedMessage().contains("Failed to decode")) {
                    this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT);
                } else {
                    this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR);
                }
            }
        }
        return 0;
    }

    public boolean onResourceReady(Object object, Object object2, h<Object> h3, a a4, boolean z5) {
        StringBuilder obj2 = new StringBuilder();
        obj2.append("Image Downloading  Success : ");
        obj2.append(object);
        Logging.logd(obj2.toString());
        return 0;
    }

    @Override // com.bumptech.glide.r.f
    public void setInAppMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2) {
        this.inAppMessage = inAppMessage;
        this.displayCallbacks = firebaseInAppMessagingDisplayCallbacks2;
    }
}
