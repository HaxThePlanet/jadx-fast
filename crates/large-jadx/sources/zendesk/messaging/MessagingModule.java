package zendesk.messaging;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.picasso.t;
import com.squareup.picasso.t.b;
import zendesk.belvedere.a;

/* loaded from: classes3.dex */
abstract class MessagingModule {
    static a belvedere(Context context) {
        return a.c(context);
    }

    static t picasso(Context context) {
        t.b bVar = new t.b(context);
        return bVar.a();
    }

    static Resources resources(Context context) {
        return context.getResources();
    }
}
