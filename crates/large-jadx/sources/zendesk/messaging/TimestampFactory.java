package zendesk.messaging;

import android.content.Context;
import android.text.format.DateUtils;
import java.util.Date;

/* loaded from: classes3.dex */
class TimestampFactory {

    private final Context context;
    TimestampFactory(Context context) {
        super();
        this.context = context;
    }

    String createTimestamp(Date date) {
        return DateUtils.formatDateTime(this.context, date.getTime(), obj2);
    }
}
