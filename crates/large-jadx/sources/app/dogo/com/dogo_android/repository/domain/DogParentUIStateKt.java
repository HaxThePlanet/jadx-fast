package app.dogo.com.dogo_android.repository.domain;

import app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogParentUIState.kt */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toDogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse$DogParentData;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DogParentUIStateKt {
    public static final DogParentUIState.DogParent toDogParent(GetDogParentsResponse.DogParentData dogParentData) {
        String name;
        n.f(dogParentData, "<this>");
        if (dogParentData.getName() == null) {
            name = "";
        }
        DogParentUIState_DogParent dogParentUIState_DogParent = new DogParentUIState_DogParent(name, dogParentData.getId(), dogParentData.isCreator());
        return dogParentUIState_DogParent;
    }
}
