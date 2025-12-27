package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import kotlin.d0.c.l;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class j implements l {

    public final /* synthetic */ EntryPhotoBaseObservable a;
    public final /* synthetic */ ChallengeEntryModel b;
    public /* synthetic */ j(EntryPhotoBaseObservable entryPhotoBaseObservable, ChallengeEntryModel challengeEntryModel) {
        super();
        this.a = entryPhotoBaseObservable;
        this.b = challengeEntryModel;
    }

    public final Object invoke(Object object) {
        return this.a.f(this.b, object);
    }
}
