package zendesk.core;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import f.g.c.a;
import f.g.e.g;

/* loaded from: classes3.dex */
class LegacyIdentityMigrator {

    private static final String ANONYMOUS_EMAIL_KEY = "email";
    private static final String ANONYMOUS_NAME_KEY = "name";
    private static final String JWT_TOKEN_KEY = "token";
    private static final String LEGACY_ACCESS_TOKEN_KEY = "access_token";
    private static final String LEGACY_ACCESS_TOKEN_USER_ID_KEY = "user_id";
    private static final String LEGACY_IDENTITY_KEY = "zendesk-identity";
    private static final String LEGACY_IDENTITY_TYPE_KEY = "zendesk-identity-type";
    private static final String LEGACY_PUSH_DEVICE_ID_KEY = "identifier";
    private static final String LEGACY_PUSH_RESPONSE_KEY = "pushRegResponseIdentifier";
    private static final String LEGACY_SDK_GUID_KEY = "uuid";
    private static final String LEGACY_STORED_TOKEN_KEY = "stored_token";
    private static final String LEGACY_USER_ID_KEY = "user_id";
    private static final String LOG_TAG = "LegacyIdentityStorage";
    private zendesk.core.IdentityManager identityManager;
    private zendesk.core.IdentityStorage identityStorage;
    private zendesk.core.SharedPreferencesStorage legacyIdentityStorage;
    private zendesk.core.SharedPreferencesStorage legacyPushStorage;
    private zendesk.core.PushDeviceIdStorage pushDeviceIdStorage;
    LegacyIdentityMigrator(zendesk.core.SharedPreferencesStorage sharedPreferencesStorage, zendesk.core.SharedPreferencesStorage sharedPreferencesStorage2, zendesk.core.IdentityStorage identityStorage3, zendesk.core.IdentityManager identityManager4, zendesk.core.PushDeviceIdStorage pushDeviceIdStorage5) {
        super();
        this.legacyIdentityStorage = sharedPreferencesStorage;
        this.legacyPushStorage = sharedPreferencesStorage2;
        this.identityStorage = identityStorage3;
        this.identityManager = identityManager4;
        this.pushDeviceIdStorage = pushDeviceIdStorage5;
    }

    private void clear() {
        this.legacyIdentityStorage.remove("zendesk-identity-type");
        this.legacyIdentityStorage.remove("zendesk-identity");
        this.legacyIdentityStorage.remove("stored_token");
        this.legacyIdentityStorage.remove("uuid");
        this.legacyIdentityStorage.remove("user_id");
        this.legacyPushStorage.remove("pushRegResponseIdentifier");
    }

    private zendesk.core.AccessToken getLegacyAccessToken() {
        JsonElement parse;
        JsonParser jsonParser;
        String str;
        String str2 = this.legacyIdentityStorage.get("stored_token");
        final int i = 0;
        if (g.e(str2)) {
            return i;
        }
        jsonParser = new JsonParser();
        parse = jsonParser.parse(str2);
        if (parse != null) {
            if (!parse.isJsonObject()) {
            } else {
                JsonObject asJsonObject = parse.getAsJsonObject();
                jsonParser = asJsonObject.get("access_token");
                parse = asJsonObject.get("user_id");
                if (jsonParser != null && parse != null) {
                    if (parse != null) {
                        AccessToken accessToken = new AccessToken(jsonParser.getAsString(), parse.getAsString());
                        return accessToken;
                    }
                }
            }
        }
        return i;
    }

    private zendesk.core.Identity getLegacyIdentity() {
        zendesk.core.AuthenticationType legacyIdentityType = getLegacyIdentityType();
        final int i2 = 0;
        if (legacyIdentityType == null) {
            return i2;
        }
        int i = LegacyIdentityMigrator.1.$SwitchMap$zendesk$core$AuthenticationType[legacyIdentityType.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 2) {
                return i2;
            }
            return readLegacyJwtIdentity();
        }
        return readLegacyAnonymousIdentity();
    }

    private zendesk.core.AuthenticationType getLegacyIdentityType() {
        return AuthenticationType.getAuthType(this.legacyIdentityStorage.get("zendesk-identity-type"));
    }

    private String getLegacyPushId() {
        Object str4;
        JsonParser jsonParser;
        boolean str3;
        String str;
        String str2;
        str4 = this.legacyPushStorage.get("pushRegResponseIdentifier");
        final int i = 0;
        jsonParser = new JsonParser();
        JsonElement parse = jsonParser.parse(str4);
        if (g.c(str4) && parse != null) {
            jsonParser = new JsonParser();
            parse = jsonParser.parse(str4);
            if (parse != null) {
                if (!parse.isJsonObject()) {
                } else {
                    str4 = parse.getAsJsonObject().get("identifier");
                    if (str4 != null) {
                        return str4.getAsString();
                    }
                }
            }
            return i;
        }
        return i;
    }

    private String getLegacySdkGuid() {
        return this.legacyIdentityStorage.get("uuid");
    }

    private long getLegacyUserId() {
        return this.legacyIdentityStorage.getLong("user_id");
    }

    private zendesk.core.AnonymousIdentity readLegacyAnonymousIdentity() {
        Object asString2;
        JsonParser jsonParser;
        Object asString;
        String str = this.legacyIdentityStorage.get("zendesk-identity");
        final int i = 0;
        if (g.e(str)) {
            return i;
        }
        jsonParser = new JsonParser();
        JsonElement parse = jsonParser.parse(str);
        if (parse != null) {
            if (!parse.isJsonObject()) {
            } else {
                JsonObject asJsonObject = parse.getAsJsonObject();
                AnonymousIdentity.Builder builder = new AnonymousIdentity.Builder();
                asString = asJsonObject.get("email");
                if (asString != null) {
                    builder.withEmailIdentifier(asString.getAsString());
                }
                asString2 = asJsonObject.get("name");
                if (asString2 != null) {
                    builder.withNameIdentifier(asString2.getAsString());
                }
            }
            return (AnonymousIdentity)builder.build();
        }
        return i;
    }

    private zendesk.core.JwtIdentity readLegacyJwtIdentity() {
        Object asJsonObject;
        Object jwtIdentity;
        int i;
        String str = this.legacyIdentityStorage.get("zendesk-identity");
        i = 0;
        if (g.e(str)) {
            return i;
        }
        jwtIdentity = new JsonParser();
        JsonElement parse = jwtIdentity.parse(str);
        if (parse == null) {
            return i;
        }
        asJsonObject = parse.getAsJsonObject();
        asJsonObject = asJsonObject.get("token");
        if (asJsonObject != null && asJsonObject != null) {
            asJsonObject = asJsonObject.get("token");
            if (asJsonObject != null) {
                jwtIdentity = new JwtIdentity(asJsonObject.getAsString());
                i = jwtIdentity;
            }
        }
        return i;
    }

    void checkAndMigrateIdentity() {
        long legacyUserId;
        Object legacyIdentityType;
        Object identityStorage;
        zendesk.core.AuthenticationType identityStorage2;
        boolean pushDeviceIdStorage;
        int identityStorage3;
        zendesk.core.Identity legacyIdentity = getLegacyIdentity();
        if (legacyIdentity == null) {
        }
        identityStorage = this.identityStorage;
        identityStorage.storeIdentity(legacyIdentity);
        legacyUserId = getLegacyUserId();
        if (Long.compare(legacyUserId, i) != 0) {
            this.identityStorage.storeUserId(Long.valueOf(legacyUserId));
        }
        zendesk.core.AccessToken legacyAccessToken = getLegacyAccessToken();
        if (legacyAccessToken != null) {
            this.identityManager.storeAccessToken(legacyAccessToken);
        }
        legacyIdentityType = getLegacySdkGuid();
        if (getLegacyIdentityType() == AuthenticationType.ANONYMOUS && g.c(legacyIdentityType)) {
            legacyIdentityType = getLegacySdkGuid();
            if (g.c(legacyIdentityType)) {
                this.identityStorage.storeSdkGuid(legacyIdentityType);
            }
        }
        String legacyPushId = getLegacyPushId();
        if (g.c(legacyPushId)) {
            this.pushDeviceIdStorage.storeRegisteredDeviceId(legacyPushId);
        }
        clear();
    }
}
