package app.dogo.com.dogo_android.repository.domain;

import app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toDogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse$DogParentData;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DogParentUIStateKt {
    public static final app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent toDogParent(GetDogParentsResponse.DogParentData getDogParentsResponse$DogParentData) {
        String name;
        n.f(dogParentData, "<this>");
        if (dogParentData.getName() == null) {
            name = "";
        }
        DogParentUIState.DogParent dogParent = new DogParentUIState.DogParent(name, dogParentData.getId(), dogParentData.isCreator());
        return dogParent;
    }
}
