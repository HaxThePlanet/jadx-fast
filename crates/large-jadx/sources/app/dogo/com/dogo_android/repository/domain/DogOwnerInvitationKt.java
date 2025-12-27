package app.dogo.com.dogo_android.repository.domain;

import app.dogo.externalmodel.model.DogInviteModel;
import app.dogo.externalmodel.model.responses.GetDogInviteResponse;
import app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogOwnerInvitation.kt */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toDogOwnerInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "Lapp/dogo/externalmodel/model/responses/GetDogInviteResponse;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DogOwnerInvitationKt {
    public static final DogOwnerInvitation toDogOwnerInvite(GetDogInviteResponse getDogInviteResponse) {
        String getDogInviteResponse2;
        n.f(getDogInviteResponse, "<this>");
        DogInviteModel invite = getDogInviteResponse.getInvite();
        getDogInviteResponse2 = "";
        String r1 = getDogInviteResponse2;
        DogInviteModel invite2 = getDogInviteResponse.getInvite();
        String r3 = getDogInviteResponse2;
        DogInviteModel invite3 = getDogInviteResponse.getInvite();
        String r4 = getDogInviteResponse2;
        DogInviteModel invite4 = getDogInviteResponse.getInvite();
        if (invite4 != null) {
            UserApiModel.PublicApiDogModel dog3 = invite4.getDog();
            if (dog3 != null) {
                getDogInviteResponse2 = dog3.getAvatarUrl();
                if (getDogInviteResponse2 != null) {
                }
            }
        }
        DogOwnerInvitation dogOwnerInvitation = new DogOwnerInvitation(getDogInviteResponse2, getDogInviteResponse2, getDogInviteResponse2, getDogInviteResponse2);
        return dogOwnerInvitation;
    }
}
