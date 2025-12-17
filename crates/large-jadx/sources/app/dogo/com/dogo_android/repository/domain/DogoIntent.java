package app.dogo.com.dogo_android.repository.domain;

import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0016\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0013\u0010%\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\u00122\u0008\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0008R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0008R\u0013\u0010 \u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008!\u0010\u0008R\u0013\u0010\"\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008#\u0010\u0008¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "challengeDeeplinkQuery", "", "getChallengeDeeplinkQuery", "()Ljava/lang/String;", "convertToString", "getConvertToString", "extras", "getExtras", "fcmMessageId", "getFcmMessageId", "fcmUri", "getFcmUri", "hasDeeplink", "", "getHasDeeplink", "()Z", "getIntent", "()Landroid/content/Intent;", "isChallengeDeeplink", "isDogoFcmNotificationIntent", "isGenericFcmNotificationIntent", "isPottyNotificationIntent", "isSpecialOfferNotificationIntent", "isTrainingNotificationIntent", "isUriDeeplink", "linkType", "getLinkType", "notificationStringId", "getNotificationStringId", "uri", "getUri", "component1", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogoIntent {

    private final Intent intent;
    public DogoIntent(Intent intent) {
        n.f(intent, "intent");
        super();
        this.intent = intent;
    }

    public static app.dogo.com.dogo_android.repository.domain.DogoIntent copy$default(app.dogo.com.dogo_android.repository.domain.DogoIntent dogoIntent, Intent intent2, int i3, Object object4) {
        Intent obj1;
        if (i3 &= 1 != 0) {
            obj1 = dogoIntent.intent;
        }
        return dogoIntent.copy(obj1);
    }

    public final Intent component1() {
        return this.intent;
    }

    public final app.dogo.com.dogo_android.repository.domain.DogoIntent copy(Intent intent) {
        n.f(intent, "intent");
        DogoIntent dogoIntent = new DogoIntent(intent);
        return dogoIntent;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof DogoIntent == null) {
            return i2;
        }
        if (!n.b(this.intent, object.intent)) {
            return i2;
        }
        return i;
    }

    public final String getChallengeDeeplinkQuery() {
        String string;
        String extras;
        if (isChallengeDeeplink()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("linkType=");
            stringBuilder.append(getLinkType());
            stringBuilder.append("&extra=");
            stringBuilder.append(getExtras());
            string = stringBuilder.toString();
        } else {
            string = 0;
        }
        return string;
    }

    public final String getConvertToString() {
        int i3;
        java.util.Set keySet;
        int i5;
        String str2;
        String str;
        int i2;
        int i6;
        app.dogo.com.dogo_android.repository.domain.DogoIntent.convertToString.extrasString.1 anon;
        int i4;
        int i;
        Bundle extras = this.intent.getExtras();
        i3 = 0;
        if (extras == null) {
        } else {
            keySet = extras.keySet();
            if (keySet == null) {
            } else {
                anon = new DogoIntent.convertToString.extrasString.1(this);
                i3 = p.h0(keySet, 0, "{", "}", 0, 0, anon, 25, 0);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Intent { ");
        stringBuilder.append(this.intent.getComponent());
        stringBuilder.append(", data=$(intent.dataString), extras=");
        stringBuilder.append(i3);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public final String getExtras() {
        return this.intent.getStringExtra("extras");
    }

    public final String getFcmMessageId() {
        return this.intent.getStringExtra("google.message_id");
    }

    public final String getFcmUri() {
        return this.intent.getStringExtra("uri");
    }

    public final boolean getHasDeeplink() {
        int i;
        i = this.intent.getData() != null ? 1 : 0;
        return i;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final String getLinkType() {
        return this.intent.getStringExtra("notificationType");
    }

    public final String getNotificationStringId() {
        return this.intent.getStringExtra("notification_string_id");
    }

    public final String getUri() {
        return this.intent.getStringExtra("uri");
    }

    public int hashCode() {
        return this.intent.hashCode();
    }

    public final boolean isChallengeDeeplink() {
        String linkType;
        int i;
        if (getLinkType() != null && getExtras() != null) {
            i = getExtras() != null ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean isDogoFcmNotificationIntent() {
        return n.b(this.intent.getStringExtra("source"), "fcm_notification");
    }

    public final boolean isGenericFcmNotificationIntent() {
        boolean extra;
        int i;
        String str;
        if (this.intent.hasExtra("google.sent_time") && this.intent.hasExtra("google.ttl") && this.intent.hasExtra("from") && this.intent.hasExtra("google.message_id")) {
            if (this.intent.hasExtra("google.ttl")) {
                if (this.intent.hasExtra("from")) {
                    i = this.intent.hasExtra("google.message_id") ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final boolean isPottyNotificationIntent() {
        return n.b(this.intent.getStringExtra("source"), "potty_notification");
    }

    public final boolean isSpecialOfferNotificationIntent() {
        return n.b(this.intent.getStringExtra("source"), "special_offer_notification");
    }

    public final boolean isTrainingNotificationIntent() {
        return n.b(this.intent.getStringExtra("source"), "training_notification");
    }

    public final boolean isUriDeeplink() {
        int i;
        i = getUri() != null ? 1 : 0;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogoIntent(intent=");
        stringBuilder.append(this.intent);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
