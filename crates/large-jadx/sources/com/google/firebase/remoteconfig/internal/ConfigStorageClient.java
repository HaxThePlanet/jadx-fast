package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigStorageClient {

    private static final String JSON_STRING_ENCODING = "UTF-8";
    private static final Map<String, com.google.firebase.remoteconfig.internal.ConfigStorageClient> clientInstances;
    private final Context context;
    private final String fileName;
    static {
        HashMap hashMap = new HashMap();
        ConfigStorageClient.clientInstances = hashMap;
    }

    private ConfigStorageClient(Context context, String string2) {
        super();
        this.context = context;
        this.fileName = string2;
    }

    public static void clearInstancesForTest() {
        final Class<com.google.firebase.remoteconfig.internal.ConfigStorageClient> obj = ConfigStorageClient.class;
        ConfigStorageClient.clientInstances.clear();
        return;
        synchronized (obj) {
            obj = ConfigStorageClient.class;
            ConfigStorageClient.clientInstances.clear();
        }
    }

    public static com.google.firebase.remoteconfig.internal.ConfigStorageClient getInstance(Context context, String string2) {
        boolean configStorageClient;
        final Class<com.google.firebase.remoteconfig.internal.ConfigStorageClient> obj = ConfigStorageClient.class;
        final Map clientInstances = ConfigStorageClient.clientInstances;
        synchronized (obj) {
            configStorageClient = new ConfigStorageClient(context, string2);
            clientInstances.put(string2, configStorageClient);
            return (ConfigStorageClient)clientInstances.get(string2);
        }
    }

    public Void clear() {
        this.context.deleteFile(this.fileName);
        return null;
        synchronized (this) {
            this.context.deleteFile(this.fileName);
            return null;
        }
    }

    String getFileName() {
        return this.fileName;
    }

    public com.google.firebase.remoteconfig.internal.ConfigContainer read() {
        Throwable th3;
        Throwable th;
        int i = 0;
        FileInputStream fileInput = this.context.openFileInput(this.fileName);
        int available = fileInput.available();
        byte[] bArr = new byte[available];
        fileInput.read(bArr, 0, available);
        String string = new String(bArr, "UTF-8");
        JSONObject jSONObject = new JSONObject(string);
        synchronized (this) {
            fileInput.close();
            try {
                return ConfigContainer.copyOf(jSONObject);
                th3 = th2;
                Throwable th2 = th;
                if (th3 == null) {
                } else {
                }
                th3.close();
                throw th2;
                th3 = th2;
                if (th3 != null) {
                }
                th3.close();
            } catch (org.json.JSONException jSON) {
            } catch (java.io.FileNotFoundException fileNotFound1) {
            } catch (Throwable th2) {
            }
            return th2;
        }
    }

    public Void write(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer) {
        FileOutputStream fileOutput = this.context.openFileOutput(this.fileName, 0);
        fileOutput.write(configContainer.toString().getBytes("UTF-8"));
        fileOutput.close();
        return null;
        synchronized (this) {
            fileOutput = this.context.openFileOutput(this.fileName, 0);
            fileOutput.write(configContainer.toString().getBytes("UTF-8"));
            fileOutput.close();
            return null;
        }
    }
}
