package zendesk.support;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import f.g.c.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
class LegacyRequestMigrator implements zendesk.support.RequestMigrator {

    private static final String LOG_TAG = "LegacyRequestMigrator";
    private static final String PREFS_COMMENT_COUNT_KEY_PREFIX = "request-id-cc";
    private static final String REQUEST_KEY = "stored_requests";
    private SharedPreferences legacyRequestStorage;
    LegacyRequestMigrator(SharedPreferences sharedPreferences) {
        super();
        this.legacyRequestStorage = sharedPreferences;
    }

    private String getCommentCountKey(String string) {
        Object[] arr = new Object[2];
        return String.format(Locale.US, "%s-%s", "request-id-cc", string);
    }

    @Override // zendesk.support.RequestMigrator
    public void clearLegacyRequestStorage() {
        this.legacyRequestStorage.edit().clear().apply();
    }

    public List<zendesk.support.RequestData> getLegacyRequests() {
        int create;
        String str;
        SharedPreferences legacyRequestStorage;
        int i;
        String string = this.legacyRequestStorage.getString("stored_requests", 0);
        if (g.e(string)) {
            return Collections.emptyList();
        }
        int i2 = 0;
        a.b("LegacyRequestMigrator", "Migrating legacy request IDs.", new Object[i2]);
        List list = g.b(string);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            i = -1;
            str = this.legacyRequestStorage.getInt(getCommentCountKey((String)next2), i);
            if (str > i) {
            } else {
            }
            arrayList.add(RequestData.create(next2, i2, i2));
            arrayList.add(RequestData.create(next2, str, i2));
        }
        return arrayList;
    }
}
