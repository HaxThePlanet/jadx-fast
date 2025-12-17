package app.dogo.com.dogo_android.repository.domain;

import com.google.firebase.auth.FirebaseUser;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toUserAuthRecord", "Lapp/dogo/com/dogo_android/repository/domain/UserAuthRecord;", "Lcom/google/firebase/auth/FirebaseUser;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UserAuthRecordKt {
    public static final app.dogo.com.dogo_android.repository.domain.UserAuthRecord toUserAuthRecord(FirebaseUser firebaseUser) {
        n.f(firebaseUser, "<this>");
        UserAuthRecord userAuthRecord = new UserAuthRecord(firebaseUser.getEmail(), firebaseUser.getDisplayName());
        return userAuthRecord;
    }
}
