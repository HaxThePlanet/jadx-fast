package app.dogo.com.dogo_android.profile.invitation;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\u0004\u0005\u0006\u0007B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0004\u0008\t\n\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "DogIsAlreadyAdded", "DogIsDeleted", "InvitationDoesNotExist", "InvitationHasExpired", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$InvitationDoesNotExist;", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$InvitationHasExpired;", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$DogIsDeleted;", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$DogIsAlreadyAdded;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DogParentInvitationException extends Exception {

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$DogIsAlreadyAdded;", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException;", "dogName", "", "(Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogIsAlreadyAdded extends app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException {

        private final String dogName;
        @Override // app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException
        public final String a() {
            return this.dogName;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$DogIsDeleted;", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogIsDeleted extends app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException {
        public DogIsDeleted() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$InvitationDoesNotExist;", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class InvitationDoesNotExist extends app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException {
        public InvitationDoesNotExist() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException$InvitationHasExpired;", "Lapp/dogo/com/dogo_android/profile/invitation/DogParentInvitationException;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class InvitationHasExpired extends app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException {
        public InvitationHasExpired() {
            super(0);
        }
    }
    public DogParentInvitationException(g g) {
        super();
    }
}
