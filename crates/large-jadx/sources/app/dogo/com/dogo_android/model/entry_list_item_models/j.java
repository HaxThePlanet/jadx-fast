package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import kotlin.d0.c.l;

/* loaded from: classes.dex */
public final class j implements l {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable a;
    public final ChallengeEntryModel b;
    public j(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable, ChallengeEntryModel challengeEntryModel2) {
        super();
        this.a = entryPhotoBaseObservable;
        this.b = challengeEntryModel2;
    }

    @Override // kotlin.d0.c.l
    public final Object invoke(Object object) {
        return this.a.f(this.b, (DogProfileModel)object);
    }
}
