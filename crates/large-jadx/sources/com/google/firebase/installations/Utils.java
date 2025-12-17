package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.Clock;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Utils {

    private static final Pattern API_KEY_FORMAT = null;
    private static final String APP_ID_IDENTIFICATION_SUBSTRING = ":";
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS;
    private static com.google.firebase.installations.Utils singleton;
    private final Clock clock;
    static {
        Utils.AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1);
        Utils.API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
    }

    private Utils(Clock clock) {
        super();
        this.clock = clock;
    }

    public static com.google.firebase.installations.Utils getInstance() {
        return Utils.getInstance(SystemClock.getInstance());
    }

    public static com.google.firebase.installations.Utils getInstance(Clock clock) {
        com.google.firebase.installations.Utils singleton;
        if (Utils.singleton == null) {
            singleton = new Utils(clock);
            Utils.singleton = singleton;
        }
        return Utils.singleton;
    }

    static boolean isValidApiKeyFormat(String string) {
        return Utils.API_KEY_FORMAT.matcher(string).matches();
    }

    static boolean isValidAppIdFormat(String string) {
        return string.contains(":");
    }

    public long currentTimeInMillis() {
        return this.clock.currentTimeMillis();
    }

    public long currentTimeInSecs() {
        return TimeUnit.MILLISECONDS.toSeconds(currentTimeInMillis());
    }

    public long getRandomDelayForSyncPrevention() {
        return (long)i;
    }

    public boolean isAuthTokenExpired(PersistedInstallationEntry persistedInstallationEntry) {
        final int i = 1;
        if (TextUtils.isEmpty(persistedInstallationEntry.getAuthToken())) {
            return i;
        }
        if (Long.compare(i2, i3) < 0) {
            return i;
        }
        return 0;
    }
}
