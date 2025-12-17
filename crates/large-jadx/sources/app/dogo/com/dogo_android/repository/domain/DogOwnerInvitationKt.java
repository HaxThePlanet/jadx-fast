package app.dogo.com.dogo_android.repository.domain;

import app.dogo.externalmodel.model.DogInviteModel;
import app.dogo.externalmodel.model.responses.GetDogInviteResponse;
import app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toDogOwnerInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "Lapp/dogo/externalmodel/model/responses/GetDogInviteResponse;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DogOwnerInvitationKt {
    public static final app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation toDogOwnerInvite(GetDogInviteResponse getDogInviteResponse) {
        Object invite;
        String str;
        Object invite2;
        DogInviteModel inviterName;
        Object obj5;
        n.f(getDogInviteResponse, "<this>");
        invite = getDogInviteResponse.getInvite();
        str = "";
        if (invite == null) {
            invite = str;
        } else {
        }
        invite2 = getDogInviteResponse.getInvite();
        if (invite2 == null) {
            invite2 = str;
        } else {
        }
        inviterName = getDogInviteResponse.getInvite();
        if (inviterName == null) {
            inviterName = str;
        } else {
        }
        obj5 = getDogInviteResponse.getInvite();
        if (obj5 == null) {
        } else {
            obj5 = obj5.getDog();
            if (obj5 == null) {
            } else {
                obj5 = obj5.getAvatarUrl();
                if (obj5 == null) {
                } else {
                    str = obj5;
                }
            }
        }
        DogOwnerInvitation dogOwnerInvitation = new DogOwnerInvitation(invite, invite2, inviterName, str);
        return dogOwnerInvitation;
    }
}
