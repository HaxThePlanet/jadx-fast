package com.google.firebase.installations.local;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PersistedInstallation {

    private static final String AUTH_TOKEN_KEY = "AuthToken";
    private static final String EXPIRES_IN_SECONDS_KEY = "ExpiresInSecs";
    private static final String FIREBASE_INSTALLATION_ID_KEY = "Fid";
    private static final String FIS_ERROR_KEY = "FisError";
    private static final String PERSISTED_STATUS_KEY = "Status";
    private static final String REFRESH_TOKEN_KEY = "RefreshToken";
    private static final String SETTINGS_FILE_NAME_PREFIX = "PersistedInstallation";
    private static final String TOKEN_CREATION_TIME_IN_SECONDS_KEY = "TokenCreationEpochInSecs";
    private final File dataFile;
    private final FirebaseApp firebaseApp;

    public static enum RegistrationStatus {

        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR;
    }
    public PersistedInstallation(FirebaseApp firebaseApp) {
        super();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersistedInstallation.");
        stringBuilder.append(firebaseApp.getPersistenceKey());
        stringBuilder.append(".json");
        File file = new File(firebaseApp.getApplicationContext().getFilesDir(), stringBuilder.toString());
        this.dataFile = file;
        this.firebaseApp = firebaseApp;
    }

    private JSONObject readJSONFromFile() {
        Throwable th;
        File dataFile;
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 16384;
        final byte[] bArr = new byte[i];
        FileInputStream fileInputStream = new FileInputStream(this.dataFile);
        dataFile = null;
        read = fileInputStream.read(bArr, dataFile, i);
        while (read < 0) {
            byteArrayOutputStream.write(bArr, dataFile, read);
            dataFile = null;
            read = fileInputStream.read(bArr, dataFile, i);
        }
        JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream.toString());
        fileInputStream.close();
        return jSONObject2;
    }

    public void clearForTesting() {
        this.dataFile.delete();
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(com.google.firebase.installations.local.PersistedInstallationEntry persistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", persistedInstallationEntry.getFirebaseInstallationId());
            jSONObject.put("Status", persistedInstallationEntry.getRegistrationStatus().ordinal());
            jSONObject.put("AuthToken", persistedInstallationEntry.getAuthToken());
            jSONObject.put("RefreshToken", persistedInstallationEntry.getRefreshToken());
            jSONObject.put("TokenCreationEpochInSecs", persistedInstallationEntry.getTokenCreationEpochInSecs());
            jSONObject.put("ExpiresInSecs", persistedInstallationEntry.getExpiresInSecs());
            jSONObject.put("FisError", persistedInstallationEntry.getFisError());
            File tempFile = File.createTempFile("PersistedInstallation", "tmp", this.firebaseApp.getApplicationContext().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (tempFile.renameTo(this.dataFile) == null) {
            } else {
            }
            IOException iOException = new IOException("unable to rename the tmpfile to PersistedInstallation");
            throw iOException;
            return persistedInstallationEntry;
        }
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry readPersistedInstallationEntryValue() {
        JSONObject jSONFromFile = readJSONFromFile();
        int i = 0;
        final int i2 = 0;
        return PersistedInstallationEntry.builder().setFirebaseInstallationId(jSONFromFile.optString("Fid", i)).setRegistrationStatus(PersistedInstallation.RegistrationStatus.values()[jSONFromFile.optInt("Status", PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION.ordinal())]).setAuthToken(jSONFromFile.optString("AuthToken", i)).setRefreshToken(jSONFromFile.optString("RefreshToken", i)).setTokenCreationEpochInSecs(jSONFromFile.optLong("TokenCreationEpochInSecs", i2)).setExpiresInSecs(jSONFromFile.optLong("ExpiresInSecs", i2)).setFisError(jSONFromFile.optString("FisError", i)).build();
    }
}
