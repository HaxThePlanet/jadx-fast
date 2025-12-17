package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CachedSettingsIo {

    private static final String SETTINGS_CACHE_FILENAME = "com.crashlytics.settings.json";
    private final Context context;
    public CachedSettingsIo(Context context) {
        super();
        this.context = context;
    }

    private File getSettingsFile() {
        FileStoreImpl fileStoreImpl = new FileStoreImpl(this.context);
        File file = new File(fileStoreImpl.getFilesDir(), "com.crashlytics.settings.json");
        return file;
    }

    public JSONObject readCachedSettings() {
        Throwable th2;
        int i;
        Throwable th;
        Object streamToString;
        Throwable th3;
        Object fileInputStream;
        int jSONObject;
        String str;
        Logger.getLogger().d("Checking for cached settings...");
        File settingsFile = getSettingsFile();
        if (settingsFile.exists() != null) {
            fileInputStream = new FileInputStream(settingsFile);
            jSONObject = new JSONObject(CommonUtils.streamToString(fileInputStream));
            i = fileInputStream;
        } else {
            Logger.getLogger().v("Settings file does not exist.");
            jSONObject = i;
        }
        CommonUtils.closeOrLog(i, "Error while closing settings cache file.");
        return jSONObject;
    }

    public void writeCachedSettings(long l, JSONObject jSONObject2) {
        long l2;
        Logger logger;
        String str;
        long obj4;
        Object obj5;
        String obj6;
        Logger.getLogger().v("Writing settings to cache file...");
        if (obj6 != null) {
            logger = 0;
            obj6.put("expires_at", l);
            obj4 = new FileWriter(getSettingsFile());
            obj4.write(obj6.toString());
            obj4.flush();
            CommonUtils.closeOrLog(obj4, "Failed to close settings writer.");
        }
    }
}
