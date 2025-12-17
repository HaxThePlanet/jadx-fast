package app.dogo.com.dogo_android.k;

import app.dogo.com.dogo_android.service.l2.b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\u0008\u0017j\u0002\u0008\u0018¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/enums/StoragePath;", "", "(Ljava/lang/String;I)V", "bucketType", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "getBucketType", "()Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;", "setBucketType", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService$StorageBucket;)V", "challengeId", "", "id", "path", "getPath", "()Ljava/lang/String;", "photoId", "getChallengeId", "getId", "getPhotoId", "bucket", "setChallengeId", "setId", "setPhotoId", "DogAvatar", "entry_photo", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum p {

    DogAvatar,
    entry_photo;

    private l2.b bucketType;
    private String challengeId;
    private String id;
    private String photoId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[p.DogAvatar.ordinal()] = 1;
            iArr[p.entry_photo.ordinal()] = 2;
            p.a.a = iArr;
        }
    }
    private static final app.dogo.com.dogo_android.k.p[] $values() {
        app.dogo.com.dogo_android.k.p[] arr = new p[2];
        return arr;
    }

    @Override // java.lang.Enum
    public final l2.b getBucketType() {
        return this.bucketType;
    }

    @Override // java.lang.Enum
    public final String getChallengeId() {
        if (n.b(this.challengeId, "")) {
        } else {
            return this.challengeId;
        }
        RuntimeException runtimeException = new RuntimeException("No id to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getId() {
        if (n.b(this.id, "")) {
        } else {
            return this.id;
        }
        RuntimeException runtimeException = new RuntimeException("No id to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getPath() {
        String string;
        String str;
        String str2;
        int i = p.a.a[ordinal()];
        if (i != 1) {
            if (i != 2) {
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                int i4 = 47;
                stringBuilder.append(i4);
                stringBuilder.append(getChallengeId());
                stringBuilder.append(i4);
                stringBuilder.append(getId());
                stringBuilder.append(i4);
                stringBuilder.append(getPhotoId());
                stringBuilder.append(".jpg");
                string = stringBuilder.toString();
                return string;
            }
            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            throw noWhenBranchMatchedException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("/dogs/");
        stringBuilder2.append(getId());
        stringBuilder2.append("/avatar.jpg");
        string = stringBuilder2.toString();
    }

    @Override // java.lang.Enum
    public final String getPhotoId() {
        if (n.b(this.photoId, "")) {
        } else {
            return this.photoId;
        }
        RuntimeException runtimeException = new RuntimeException("No photoId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.p setBucketType(l2.b l2$b) {
        n.f(b, "bucket");
        this.bucketType = b;
        return this;
    }

    @Override // java.lang.Enum
    public final void setBucketType(l2.b l2$b) {
        n.f(b, "<set-?>");
        this.bucketType = b;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.p setChallengeId(String string) {
        n.f(string, "id");
        this.challengeId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.p setId(String string) {
        n.f(string, "id");
        this.id = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.p setPhotoId(String string) {
        n.f(string, "id");
        this.photoId = string;
        return this;
    }
}
