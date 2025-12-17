package com.google.firebase.storage;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.firebase.storage.internal.Slashes;
import com.google.firebase.storage.internal.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class StorageMetadata {

    private static final String BUCKET_KEY = "bucket";
    private static final String CACHE_CONTROL = "cacheControl";
    private static final String CONTENT_DISPOSITION = "contentDisposition";
    private static final String CONTENT_ENCODING = "contentEncoding";
    private static final String CONTENT_LANGUAGE = "contentLanguage";
    private static final String CONTENT_TYPE_KEY = "contentType";
    private static final String CUSTOM_METADATA_KEY = "metadata";
    private static final String GENERATION_KEY = "generation";
    private static final String MD5_HASH_KEY = "md5Hash";
    private static final String META_GENERATION_KEY = "metageneration";
    private static final String NAME_KEY = "name";
    private static final String SIZE_KEY = "size";
    private static final String TAG = "StorageMetadata";
    private static final String TIME_CREATED_KEY = "timeCreated";
    private static final String TIME_UPDATED_KEY = "updated";
    private String mBucket;
    private com.google.firebase.storage.StorageMetadata.MetadataValue<String> mCacheControl;
    private com.google.firebase.storage.StorageMetadata.MetadataValue<String> mContentDisposition;
    private com.google.firebase.storage.StorageMetadata.MetadataValue<String> mContentEncoding;
    private com.google.firebase.storage.StorageMetadata.MetadataValue<String> mContentLanguage;
    private com.google.firebase.storage.StorageMetadata.MetadataValue<String> mContentType;
    private String mCreationTime;
    private com.google.firebase.storage.StorageMetadata.MetadataValue<Map<String, String>> mCustomMetadata;
    private String mGeneration;
    private String mMD5Hash;
    private String mMetadataGeneration;
    private String mPath;
    private long mSize;
    private com.google.firebase.storage.FirebaseStorage mStorage;
    private com.google.firebase.storage.StorageReference mStorageRef;
    private String mUpdatedTime;

    public static class Builder {

        boolean mFromJSON;
        com.google.firebase.storage.StorageMetadata mMetadata;
        public Builder() {
            super();
            StorageMetadata storageMetadata = new StorageMetadata();
            this.mMetadata = storageMetadata;
        }

        public Builder(com.google.firebase.storage.StorageMetadata storageMetadata) {
            super();
            StorageMetadata storageMetadata2 = new StorageMetadata(storageMetadata, 0, 0);
            this.mMetadata = storageMetadata2;
        }

        Builder(JSONObject jSONObject) {
            JSONObject obj2;
            super();
            StorageMetadata storageMetadata = new StorageMetadata();
            this.mMetadata = storageMetadata;
            if (jSONObject != null) {
                parseJSON(jSONObject);
                this.mFromJSON = true;
            }
        }

        Builder(JSONObject jSONObject, com.google.firebase.storage.StorageReference storageReference2) {
            super(jSONObject);
            StorageMetadata.access$102(this.mMetadata, storageReference2);
        }

        private String extractString(JSONObject jSONObject, String string2) {
            boolean null;
            if (jSONObject.has(string2) && !jSONObject.isNull(string2)) {
                if (!jSONObject.isNull(string2)) {
                    return jSONObject.getString(string2);
                }
            }
            return null;
        }

        private void parseJSON(JSONObject jSONObject) {
            Object jSONObject2;
            boolean null;
            long next;
            String string;
            StorageMetadata.access$202(this.mMetadata, jSONObject.optString("generation"));
            StorageMetadata.access$302(this.mMetadata, jSONObject.optString("name"));
            StorageMetadata.access$402(this.mMetadata, jSONObject.optString("bucket"));
            StorageMetadata.access$502(this.mMetadata, jSONObject.optString("metageneration"));
            StorageMetadata.access$602(this.mMetadata, jSONObject.optString("timeCreated"));
            StorageMetadata.access$702(this.mMetadata, jSONObject.optString("updated"));
            StorageMetadata.access$802(this.mMetadata, jSONObject.optLong("size"));
            StorageMetadata.access$902(this.mMetadata, jSONObject.optString("md5Hash"));
            jSONObject2 = "metadata";
            if (jSONObject.has(jSONObject2) && !jSONObject.isNull(jSONObject2)) {
                if (!jSONObject.isNull(jSONObject2)) {
                    jSONObject2 = jSONObject.getJSONObject(jSONObject2);
                    null = jSONObject2.keys();
                    for (String next : null) {
                        setCustomMetadata(next, jSONObject2.getString(next));
                    }
                }
            }
            String string2 = extractString(jSONObject, "contentType");
            if (string2 != null) {
                setContentType(string2);
            }
            String string3 = extractString(jSONObject, "cacheControl");
            if (string3 != null) {
                setCacheControl(string3);
            }
            String string4 = extractString(jSONObject, "contentDisposition");
            if (string4 != null) {
                setContentDisposition(string4);
            }
            String string5 = extractString(jSONObject, "contentEncoding");
            if (string5 != null) {
                setContentEncoding(string5);
            }
            final String obj5 = extractString(jSONObject, "contentLanguage");
            if (obj5 != null) {
                setContentLanguage(obj5);
            }
        }

        public com.google.firebase.storage.StorageMetadata build() {
            StorageMetadata storageMetadata = new StorageMetadata(this.mMetadata, this.mFromJSON, 0);
            return storageMetadata;
        }

        public String getCacheControl() {
            return (String)StorageMetadata.access$1300(this.mMetadata).getValue();
        }

        public String getContentDisposition() {
            return (String)StorageMetadata.access$1200(this.mMetadata).getValue();
        }

        public String getContentEncoding() {
            return (String)StorageMetadata.access$1100(this.mMetadata).getValue();
        }

        public String getContentLanguage() {
            return (String)StorageMetadata.access$1000(this.mMetadata).getValue();
        }

        public String getContentType() {
            return (String)StorageMetadata.access$1500(this.mMetadata).getValue();
        }

        public com.google.firebase.storage.StorageMetadata.Builder setCacheControl(String string) {
            StorageMetadata.access$1302(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(string));
            return this;
        }

        public com.google.firebase.storage.StorageMetadata.Builder setContentDisposition(String string) {
            StorageMetadata.access$1202(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(string));
            return this;
        }

        public com.google.firebase.storage.StorageMetadata.Builder setContentEncoding(String string) {
            StorageMetadata.access$1102(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(string));
            return this;
        }

        public com.google.firebase.storage.StorageMetadata.Builder setContentLanguage(String string) {
            StorageMetadata.access$1002(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(string));
            return this;
        }

        public com.google.firebase.storage.StorageMetadata.Builder setContentType(String string) {
            StorageMetadata.access$1502(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(string));
            return this;
        }

        public com.google.firebase.storage.StorageMetadata.Builder setCustomMetadata(String string, String string2) {
            boolean userProvided;
            com.google.firebase.storage.StorageMetadata.MetadataValue userValue;
            if (StorageMetadata.access$1400(this.mMetadata).isUserProvided() == null) {
                HashMap hashMap = new HashMap();
                StorageMetadata.access$1402(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(hashMap));
            }
            (Map)StorageMetadata.access$1400(this.mMetadata).getValue().put(string, string2);
            return this;
        }
    }

    private static class MetadataValue {

        private final boolean userProvided;
        private final T value;
        MetadataValue(T t, boolean z2) {
            super();
            this.userProvided = z2;
            this.value = t;
        }

        static <T> com.google.firebase.storage.StorageMetadata.MetadataValue<T> withDefaultValue(T t) {
            StorageMetadata.MetadataValue metadataValue = new StorageMetadata.MetadataValue(t, 0);
            return metadataValue;
        }

        static <T> com.google.firebase.storage.StorageMetadata.MetadataValue<T> withUserValue(T t) {
            StorageMetadata.MetadataValue metadataValue = new StorageMetadata.MetadataValue(t, 1);
            return metadataValue;
        }

        T getValue() {
            return this.value;
        }

        boolean isUserProvided() {
            return this.userProvided;
        }
    }
    public StorageMetadata() {
        super();
        int i = 0;
        this.mPath = i;
        this.mStorage = i;
        this.mStorageRef = i;
        this.mBucket = i;
        this.mGeneration = i;
        final String str = "";
        this.mContentType = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mMetadataGeneration = i;
        this.mCreationTime = i;
        this.mUpdatedTime = i;
        this.mMD5Hash = i;
        this.mCacheControl = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mContentDisposition = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mContentEncoding = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mContentLanguage = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mCustomMetadata = StorageMetadata.MetadataValue.withDefaultValue(Collections.emptyMap());
    }

    private StorageMetadata(com.google.firebase.storage.StorageMetadata storageMetadata, boolean z2) {
        com.google.firebase.storage.StorageMetadata.MetadataValue mCustomMetadata;
        Object obj4;
        String obj5;
        super();
        int i = 0;
        this.mPath = i;
        this.mStorage = i;
        this.mStorageRef = i;
        this.mBucket = i;
        this.mGeneration = i;
        final String str = "";
        this.mContentType = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mMetadataGeneration = i;
        this.mCreationTime = i;
        this.mUpdatedTime = i;
        this.mMD5Hash = i;
        this.mCacheControl = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mContentDisposition = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mContentEncoding = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mContentLanguage = StorageMetadata.MetadataValue.withDefaultValue(str);
        this.mCustomMetadata = StorageMetadata.MetadataValue.withDefaultValue(Collections.emptyMap());
        r.j(storageMetadata);
        this.mPath = storageMetadata.mPath;
        this.mStorage = storageMetadata.mStorage;
        this.mStorageRef = storageMetadata.mStorageRef;
        this.mBucket = storageMetadata.mBucket;
        this.mContentType = storageMetadata.mContentType;
        this.mCacheControl = storageMetadata.mCacheControl;
        this.mContentDisposition = storageMetadata.mContentDisposition;
        this.mContentEncoding = storageMetadata.mContentEncoding;
        this.mContentLanguage = storageMetadata.mContentLanguage;
        this.mCustomMetadata = storageMetadata.mCustomMetadata;
        if (z2 != null) {
            this.mMD5Hash = storageMetadata.mMD5Hash;
            this.mSize = storageMetadata.mSize;
            this.mUpdatedTime = storageMetadata.mUpdatedTime;
            this.mCreationTime = storageMetadata.mCreationTime;
            this.mMetadataGeneration = storageMetadata.mMetadataGeneration;
            this.mGeneration = storageMetadata.mGeneration;
        }
    }

    StorageMetadata(com.google.firebase.storage.StorageMetadata storageMetadata, boolean z2, com.google.firebase.storage.StorageMetadata.1 storageMetadata$13) {
        super(storageMetadata, z2);
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1000(com.google.firebase.storage.StorageMetadata storageMetadata) {
        return storageMetadata.mContentLanguage;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1002(com.google.firebase.storage.StorageMetadata storageMetadata, com.google.firebase.storage.StorageMetadata.MetadataValue storageMetadata$MetadataValue2) {
        storageMetadata.mContentLanguage = metadataValue2;
        return metadataValue2;
    }

    static com.google.firebase.storage.StorageReference access$102(com.google.firebase.storage.StorageMetadata storageMetadata, com.google.firebase.storage.StorageReference storageReference2) {
        storageMetadata.mStorageRef = storageReference2;
        return storageReference2;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1100(com.google.firebase.storage.StorageMetadata storageMetadata) {
        return storageMetadata.mContentEncoding;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1102(com.google.firebase.storage.StorageMetadata storageMetadata, com.google.firebase.storage.StorageMetadata.MetadataValue storageMetadata$MetadataValue2) {
        storageMetadata.mContentEncoding = metadataValue2;
        return metadataValue2;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1200(com.google.firebase.storage.StorageMetadata storageMetadata) {
        return storageMetadata.mContentDisposition;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1202(com.google.firebase.storage.StorageMetadata storageMetadata, com.google.firebase.storage.StorageMetadata.MetadataValue storageMetadata$MetadataValue2) {
        storageMetadata.mContentDisposition = metadataValue2;
        return metadataValue2;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1300(com.google.firebase.storage.StorageMetadata storageMetadata) {
        return storageMetadata.mCacheControl;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1302(com.google.firebase.storage.StorageMetadata storageMetadata, com.google.firebase.storage.StorageMetadata.MetadataValue storageMetadata$MetadataValue2) {
        storageMetadata.mCacheControl = metadataValue2;
        return metadataValue2;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1400(com.google.firebase.storage.StorageMetadata storageMetadata) {
        return storageMetadata.mCustomMetadata;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1402(com.google.firebase.storage.StorageMetadata storageMetadata, com.google.firebase.storage.StorageMetadata.MetadataValue storageMetadata$MetadataValue2) {
        storageMetadata.mCustomMetadata = metadataValue2;
        return metadataValue2;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1500(com.google.firebase.storage.StorageMetadata storageMetadata) {
        return storageMetadata.mContentType;
    }

    static com.google.firebase.storage.StorageMetadata.MetadataValue access$1502(com.google.firebase.storage.StorageMetadata storageMetadata, com.google.firebase.storage.StorageMetadata.MetadataValue storageMetadata$MetadataValue2) {
        storageMetadata.mContentType = metadataValue2;
        return metadataValue2;
    }

    static String access$202(com.google.firebase.storage.StorageMetadata storageMetadata, String string2) {
        storageMetadata.mGeneration = string2;
        return string2;
    }

    static String access$302(com.google.firebase.storage.StorageMetadata storageMetadata, String string2) {
        storageMetadata.mPath = string2;
        return string2;
    }

    static String access$402(com.google.firebase.storage.StorageMetadata storageMetadata, String string2) {
        storageMetadata.mBucket = string2;
        return string2;
    }

    static String access$502(com.google.firebase.storage.StorageMetadata storageMetadata, String string2) {
        storageMetadata.mMetadataGeneration = string2;
        return string2;
    }

    static String access$602(com.google.firebase.storage.StorageMetadata storageMetadata, String string2) {
        storageMetadata.mCreationTime = string2;
        return string2;
    }

    static String access$702(com.google.firebase.storage.StorageMetadata storageMetadata, String string2) {
        storageMetadata.mUpdatedTime = string2;
        return string2;
    }

    static long access$802(com.google.firebase.storage.StorageMetadata storageMetadata, long l2) {
        storageMetadata.mSize = l2;
        return l2;
    }

    static String access$902(com.google.firebase.storage.StorageMetadata storageMetadata, String string2) {
        storageMetadata.mMD5Hash = string2;
        return string2;
    }

    JSONObject createJSONObject() {
        boolean userProvided3;
        boolean userProvided;
        boolean userProvided2;
        boolean contentDisposition;
        boolean contentEncoding;
        boolean contentLanguage;
        String str;
        HashMap hashMap = new HashMap();
        if (this.mContentType.isUserProvided()) {
            hashMap.put("contentType", getContentType());
        }
        if (this.mCustomMetadata.isUserProvided()) {
            userProvided = new JSONObject((Map)this.mCustomMetadata.getValue());
            hashMap.put("metadata", userProvided);
        }
        if (this.mCacheControl.isUserProvided()) {
            hashMap.put("cacheControl", getCacheControl());
        }
        if (this.mContentDisposition.isUserProvided()) {
            hashMap.put("contentDisposition", getContentDisposition());
        }
        if (this.mContentEncoding.isUserProvided()) {
            hashMap.put("contentEncoding", getContentEncoding());
        }
        if (this.mContentLanguage.isUserProvided()) {
            hashMap.put("contentLanguage", getContentLanguage());
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        return jSONObject;
    }

    public String getBucket() {
        return this.mBucket;
    }

    public String getCacheControl() {
        return (String)this.mCacheControl.getValue();
    }

    public String getContentDisposition() {
        return (String)this.mContentDisposition.getValue();
    }

    public String getContentEncoding() {
        return (String)this.mContentEncoding.getValue();
    }

    public String getContentLanguage() {
        return (String)this.mContentLanguage.getValue();
    }

    public String getContentType() {
        return (String)this.mContentType.getValue();
    }

    public long getCreationTimeMillis() {
        return Util.parseDateTime(this.mCreationTime);
    }

    public String getCustomMetadata(String string) {
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (String)(Map)this.mCustomMetadata.getValue().get(string);
    }

    public Set<String> getCustomMetadataKeys() {
        return (Map)this.mCustomMetadata.getValue().keySet();
    }

    public String getGeneration() {
        return this.mGeneration;
    }

    public String getMd5Hash() {
        return this.mMD5Hash;
    }

    public String getMetadataGeneration() {
        return this.mMetadataGeneration;
    }

    public String getName() {
        String substring;
        int lastIndexOf;
        substring = getPath();
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        lastIndexOf = substring.lastIndexOf(47);
        if (lastIndexOf != -1) {
            substring = substring.substring(lastIndexOf++);
        }
        return substring;
    }

    public String getPath() {
        String mPath;
        if (this.mPath != null) {
        } else {
            mPath = "";
        }
        return mPath;
    }

    public com.google.firebase.storage.StorageReference getReference() {
        com.google.firebase.storage.StorageReference mStorageRef;
        Object mStorage;
        boolean empty;
        String bucket = getBucket();
        mStorage = getPath();
        if (this.mStorageRef == null && this.mStorage != null && !TextUtils.isEmpty(bucket) && TextUtils.isEmpty(mStorage) != null) {
            if (this.mStorage != null) {
                bucket = getBucket();
                mStorage = getPath();
                if (!TextUtils.isEmpty(bucket)) {
                    if (TextUtils.isEmpty(mStorage) != null) {
                    }
                    Uri.Builder builder = new Uri.Builder();
                    StorageReference storageReference = new StorageReference(builder.scheme("gs").authority(bucket).encodedPath(Slashes.preserveSlashEncode(mStorage)).build(), this.mStorage);
                    return storageReference;
                }
                mStorageRef = 0;
            }
        }
        return mStorageRef;
    }

    public long getSizeBytes() {
        return this.mSize;
    }

    public long getUpdatedTimeMillis() {
        return Util.parseDateTime(this.mUpdatedTime);
    }
}
