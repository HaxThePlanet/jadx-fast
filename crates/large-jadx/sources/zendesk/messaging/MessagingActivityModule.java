package zendesk.messaging;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.d;
import zendesk.belvedere.b;
import zendesk.belvedere.e;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
abstract class MessagingActivityModule {
    static e belvedereUi(d d) {
        return b.b(d);
    }

    static DateProvider dateProvider() {
        DateProvider dateProvider = new DateProvider();
        return dateProvider;
    }

    static Handler handler() {
        Handler handler = new Handler(Looper.getMainLooper());
        return handler;
    }

    static boolean multilineResponseOptionsEnabled(zendesk.messaging.MessagingComponent messagingComponent) {
        return messagingComponent.messagingConfiguration().isMultilineResponseOptionsEnabled();
    }
}
