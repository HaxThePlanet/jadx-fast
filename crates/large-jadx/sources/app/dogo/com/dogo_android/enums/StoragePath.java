package app.dogo.com.dogo_android.k;

import app.dogo.com.dogo_android.service.l2.b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;

/* compiled from: StoragePath.kt */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\u0008\u0017j\u0002\u0008\u0018¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/enums/StoragePath;", "", "(Ljava/lang/String;I)V", "bucketType", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "getBucketType", "()Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "setBucketType", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;)V", "challengeId", "", "id", "path", "getPath", "()Ljava/lang/String;", "photoId", "getChallengeId", "getId", "getPhotoId", "bucket", "setChallengeId", "setId", "setPhotoId", "DogAvatar", "entry_photo", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public enum StoragePath {

    DogAvatar,
    entry_photo;

    private l2.b bucketType;
    private String challengeId = "";
    private String id = "";
    private String photoId = "";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[StoragePath.values().length];
            iArr[StoragePath.DogAvatar.ordinal()] = 1;
            iArr[StoragePath.entry_photo.ordinal()] = 2;
            app.dogo.com.dogo_android.enums.p.a.a = iArr;
        }
    }
    @Override // java.lang.Enum
    public final l2.b getBucketType() {
        return this.bucketType;
    }

    @Override // java.lang.Enum
    public final String getChallengeId() {
        if (n.b(this.challengeId, "")) {
            throw new RuntimeException("No id to give");
        } else {
            return this.challengeId;
        }
    }

    @Override // java.lang.Enum
    public final String getId() {
        if (n.b(this.id, "")) {
            throw new RuntimeException("No id to give");
        } else {
            return this.id;
        }
    }

    @Override // java.lang.Enum
    public final String getPath() throws NoWhenBranchMatchedException {
        String str;
        int i = app.dogo.com.dogo_android.enums.p.a.a[ordinal()];
        if (app.dogo.com.dogo_android.enums.p.a.a != 1) {
            if (app.dogo.com.dogo_android.enums.p.a.a != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                char c = '/';
                String challengeId = getChallengeId();
                String str3 = getId();
                String photoId = getPhotoId();
                str2 = ".jpg";
                str = c + challengeId + c + str3 + c + photoId + str2;
                return str;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str4 = "/dogs/";
        String id = getId();
        str2 = "/avatar.jpg";
        str = str4 + id + str2;
    }

    @Override // java.lang.Enum
    public final String getPhotoId() {
        if (n.b(this.photoId, "")) {
            throw new RuntimeException("No photoId to give");
        } else {
            return this.photoId;
        }
    }

    @Override // java.lang.Enum
    public final void setBucketType(l2.b bVar) {
        n.f(bVar, "<set-?>");
        this.bucketType = bVar;
    }

    @Override // java.lang.Enum
    public final p setChallengeId(String id) {
        n.f(id, "id");
        this.challengeId = id;
        return this;
    }

    @Override // java.lang.Enum
    public final p setId(String id) {
        n.f(id, "id");
        this.id = id;
        return this;
    }

    @Override // java.lang.Enum
    public final p setPhotoId(String id) {
        n.f(id, "id");
        this.photoId = id;
        return this;
    }

    @Override // java.lang.Enum
    public final p setBucketType(l2.b bucket) {
        n.f(bucket, "bucket");
        this.bucketType = bucket;
        return this;
    }

    private static final /* synthetic */ p[] $values() {
        app.dogo.com.dogo_android.k.p[] arr = new p[2];
        return new p[] { StoragePath.DogAvatar, StoragePath.entry_photo };
    }
}
