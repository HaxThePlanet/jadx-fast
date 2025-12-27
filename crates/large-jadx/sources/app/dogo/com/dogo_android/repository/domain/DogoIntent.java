package app.dogo.com.dogo_android.repository.domain;

import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: DogoIntent.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0016\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0013\u0010%\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\u00122\u0008\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0008R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0008R\u0013\u0010 \u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008!\u0010\u0008R\u0013\u0010\"\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008#\u0010\u0008¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "challengeDeeplinkQuery", "", "getChallengeDeeplinkQuery", "()Ljava/lang/String;", "convertToString", "getConvertToString", "extras", "getExtras", "fcmMessageId", "getFcmMessageId", "fcmUri", "getFcmUri", "hasDeeplink", "", "getHasDeeplink", "()Z", "getIntent", "()Landroid/content/Intent;", "isChallengeDeeplink", "isDogoFcmNotificationIntent", "isGenericFcmNotificationIntent", "isPottyNotificationIntent", "isSpecialOfferNotificationIntent", "isTrainingNotificationIntent", "isUriDeeplink", "linkType", "getLinkType", "notificationStringId", "getNotificationStringId", "uri", "getUri", "component1", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogoIntent {

    private final Intent intent;
    public DogoIntent(Intent intent) {
        n.f(intent, "intent");
        super();
        this.intent = intent;
    }

    public final String getChallengeDeeplinkQuery() {
        String str = null;
        if (isChallengeDeeplink()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "linkType=";
            String linkType = getLinkType();
            String str3 = "&extra=";
            String extras = getExtras();
            str = str2 + linkType + str3 + extras;
        } else {
            int i = 0;
        }
        return str;
    }

    public final String getConvertToString() {
        String str = null;
        Bundle extras = this.intent.getExtras();
        int i3 = 0;
        if (extras != null) {
            java.util.Set keys = extras.keySet();
            if (keys != null) {
                java.lang.CharSequence charSequence = null;
                int i = 0;
                java.lang.CharSequence charSequence2 = null;
                int i2 = 25;
                Object obj = null;
                str2 = "{";
                str3 = "}";
                str = p.h0(keys, charSequence, str2, str3, i, charSequence2, new DogoIntent.convertToString.extrasString.AnonymousClass1(this), i2, obj);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str6 = "Intent { ";
        android.content.ComponentName component = this.intent.getComponent();
        String str7 = ", data=$(intent.dataString), extras=";
        String str5 = " }";
        str4 = str6 + component + str7 + str + str5;
        return str4;
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
        boolean z = true;
        int r0 = this.intent.getData() != null ? 1 : 0;
        return (this.intent.getData() != null ? 1 : 0);
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

    public final boolean isChallengeDeeplink() {
        boolean z = false;
        int r0 = getLinkType() != null && this.getExtras() != null ? 1 : 0;
        return (getLinkType() != null && this.getExtras() != null ? 1 : 0);
    }

    public final boolean isDogoFcmNotificationIntent() {
        return n.b(this.intent.getStringExtra("source"), "fcm_notification");
    }

    public final boolean isGenericFcmNotificationIntent() {
        boolean z = true;
        String str;
        str = "google.sent_time";
        if (this.intent.hasExtra(str)) {
            str = "google.ttl";
            if (this.intent.hasExtra(str)) {
                str = "from";
                if (this.intent.hasExtra(str)) {
                    str = "google.message_id";
                    int r0 = this.intent.hasExtra(str) ? 1 : 0;
                }
            }
        }
        return (this.intent.hasExtra(str) ? 1 : 0);
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
        boolean z = true;
        int r0 = getUri() != null ? 1 : 0;
        return (getUri() != null ? 1 : 0);
    }

    public static /* synthetic */ DogoIntent copy$default(DogoIntent dogoIntent, Intent intent, int i, Object object) {
        Intent intent22;
        if (i & 1 != 0) {
        }
        return dogoIntent.copy(intent22);
    }

    /* operator */ public final Intent component1() {
        return this.intent;
    }

    public final DogoIntent copy(Intent intent) {
        n.f(intent, "intent");
        return new DogoIntent(intent);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof DogoIntent)) {
            return false;
        }
        return !n.b(this.intent, other.intent) ? z3 : z;
    }

    public int hashCode() {
        return this.intent.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogoIntent(intent=";
        str = str2 + this.intent + 41;
        return str;
    }
}
