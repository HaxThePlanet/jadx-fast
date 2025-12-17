package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class MetaDataStore {

    private static final String INTERNAL_KEYDATA_SUFFIX = "internal-keys";
    private static final String KEYDATA_SUFFIX = "keys";
    private static final String KEY_USER_ID = "userId";
    private static final String METADATA_EXT = ".meta";
    private static final String USERDATA_SUFFIX = "user";
    private static final Charset UTF_8;
    private final File filesDir;
    static {
        MetaDataStore.UTF_8 = Charset.forName("UTF-8");
    }

    public MetaDataStore(File file) {
        super();
        this.filesDir = file;
    }

    private static Map<String, String> jsonToKeysData(String string) {
        Object next;
        String valueOrNull;
        JSONObject jSONObject = new JSONObject(string);
        HashMap obj4 = new HashMap();
        final Iterator keys = jSONObject.keys();
        for (String next : keys) {
            obj4.put(next, MetaDataStore.valueOrNull(jSONObject, next));
        }
        return obj4;
    }

    private static com.google.firebase.crashlytics.internal.common.UserMetadata jsonToUserData(String string) {
        JSONObject jSONObject = new JSONObject(string);
        UserMetadata obj2 = new UserMetadata();
        obj2.setUserId(MetaDataStore.valueOrNull(jSONObject, "userId"));
        return obj2;
    }

    private static String keysDataToJson(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject(map);
        return jSONObject.toString();
    }

    private static String userDataToJson(com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata) {
        MetaDataStore.1 anon = new MetaDataStore.1(userMetadata);
        return anon.toString();
    }

    private static String valueOrNull(JSONObject jSONObject, String string2) {
        int optString;
        if (!jSONObject.isNull(string2)) {
            optString = jSONObject.optString(string2, 0);
        }
        return optString;
    }

    public File getInternalKeysFileForSession(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("internal-keys");
        stringBuilder.append(".meta");
        File file = new File(this.filesDir, stringBuilder.toString());
        return file;
    }

    public File getKeysFileForSession(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("keys");
        stringBuilder.append(".meta");
        File file = new File(this.filesDir, stringBuilder.toString());
        return file;
    }

    public File getUserDataFileForSession(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("user");
        stringBuilder.append(".meta");
        File file = new File(this.filesDir, stringBuilder.toString());
        return file;
    }

    public Map<String, String> readKeyData(String string) {
        return readKeyData(string, false);
    }

    Map<String, String> readKeyData(String string, boolean z2) {
        File obj4;
        if (z2 != null) {
            obj4 = getInternalKeysFileForSession(string);
        } else {
            obj4 = getKeysFileForSession(string);
        }
        if (!obj4.exists()) {
            return Collections.emptyMap();
        }
        int obj5 = 0;
        FileInputStream fileInputStream = new FileInputStream(obj4);
        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
        return MetaDataStore.jsonToKeysData(CommonUtils.streamToString(fileInputStream));
    }

    public com.google.firebase.crashlytics.internal.common.UserMetadata readUserData(String string) {
        java.io.Closeable closeable;
        File obj5 = getUserDataFileForSession(string);
        if (!obj5.exists()) {
            obj5 = new UserMetadata();
            return obj5;
        }
        int i = 0;
        FileInputStream fileInputStream = new FileInputStream(obj5);
        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
        return MetaDataStore.jsonToUserData(CommonUtils.streamToString(fileInputStream));
    }

    public void writeKeyData(String string, Map<String, String> map2) {
        writeKeyData(string, map2, false);
    }

    void writeKeyData(String string, Map<String, String> map2, boolean z3) {
        BufferedWriter bufferedWriter;
        File obj5;
        String obj6;
        int obj7;
        if (z3 != null) {
            obj5 = getInternalKeysFileForSession(string);
        } else {
            obj5 = getKeysFileForSession(string);
        }
        obj7 = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(obj5);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, MetaDataStore.UTF_8);
        bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(MetaDataStore.keysDataToJson(map2));
        bufferedWriter.flush();
        CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
    }

    public void writeUserData(String string, com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata2) {
        java.io.Closeable closeable;
        int i;
        BufferedWriter bufferedWriter;
        Charset obj6;
        String obj7;
        i = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(getUserDataFileForSession(string));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, MetaDataStore.UTF_8);
        bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(MetaDataStore.userDataToJson(userMetadata2));
        bufferedWriter.flush();
        CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
    }
}
