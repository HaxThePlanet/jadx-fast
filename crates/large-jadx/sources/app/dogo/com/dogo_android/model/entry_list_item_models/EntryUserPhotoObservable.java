package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.ImageView;
import app.dogo.com.dogo_android.k.a;
import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.k2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.m2.c;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.n0.u;
import app.dogo.com.dogo_android.util.w;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.t;
import app.dogo.com.dogo_android.w.v2;
import com.google.android.gms.tasks.j;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Query.Direction;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.a.a;

/* loaded from: classes.dex */
public class EntryUserPhotoObservable extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable {

    private final a1 challengeLocalRepository;
    private final k2 dynamicLinkService;
    private final m2 firestoreService;
    private final Resources resources;
    private final s2 stateManager;
    private final t2 storageService;
    private final o3 tracker;
    private final u2 userLocalCacheService;
    private final v2 utilities;
    public EntryUserPhotoObservable() {
        super(App.h(), App.b(), App.a().getResources(), App.o(), App.m(), App.j(), App.g(), App.p(), App.f(), App.e(), App.i(), App.c(), App.l());
    }

    public EntryUserPhotoObservable(m2 m2, h2 h22, Resources resources3, o3 o34, t2 t25, q2 q26, u2 u27, v2 v28, k2 k29, a1 a110, p2 p211, i2 i212, s2 s213) {
        final Object obj2 = this;
        super(m2, h22, o34, q26, u27, v28, resources3, a110, t25, k29, p211, i212);
        obj2.firestoreService = m2;
        obj2.resources = resources3;
        obj2.tracker = o34;
        obj2.storageService = t25;
        obj2.userLocalCacheService = u27;
        obj2.dynamicLinkService = k29;
        obj2.challengeLocalRepository = a110;
        obj2.utilities = v28;
        obj2.stateManager = s213;
    }

    private void g(a0 a0, j j2) {
        Object result;
        int i;
        i1 i1Var;
        String documentId;
        c1 c1Var;
        String challengeId;
        Intent obj8;
        a0.s();
        if (!j2.isSuccessful()) {
        }
        if (j2.getResult() != null) {
            result = new Intent("android.intent.action.SEND");
            result.setType("text/plain");
            result.putExtra("android.intent.extra.TEXT", (ShortDynamicLink)j2.getResult().getShortLink().toString());
            i1Var = new i1();
            c1Var = new c1();
            this.tracker.d(t.a.c(i1Var, getModel().getDocumentId(), c1Var, getModel().getChallengeId()));
            a0.startActivity(Intent.createChooser(result, this.resources.getString(2131887330)));
        }
    }

    private void i(a0 a0, j j2) {
        boolean successful;
        int obj3;
        a0.s();
        if (j2.isSuccessful() && j2.getResult() != null) {
            if (j2.getResult() != null) {
                a0.h0((Uri)j2.getResult(), getModel());
            } else {
                a0.t0(2131886123);
            }
        } else {
        }
    }

    private void k(u u, QuerySnapshot querySnapshot2) {
        w object;
        String challengeId;
        int i;
        super(getModel().getChallengeId(), 0, this.firestoreService, this.userLocalCacheService, this.stateManager, u, this.disposable);
        ArrayList obj10 = new ArrayList();
        Iterator obj11 = querySnapshot2.getDocuments().iterator();
        for (DocumentSnapshot next2 : obj11) {
            object = next2.toObject(ChallengeEntryVoter.class);
            (ChallengeEntryVoter)object.setDocumentId(next2.getId());
            obj10.add(object);
        }
        wVar.b(obj10);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void callChallengeShareDialog(ImageView imageView, a0 a02) {
        a02.m();
        if (!this.utilities.o(a.INSTAGRAM_PACKAGE_NAME.getTag())) {
            w wVar = new w(this, a02);
            this.dynamicLinkService.d("sharing_challenge_photo", getModel(), this.challengeLocalRepository.a(getModel().getChallengeId())).addOnCompleteListener(wVar);
        }
        t2 storageService = this.storageService;
        v vVar = new v(this, a02);
        storageService.a(storageService.d(imageView)).addOnCompleteListener(vVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean getEntryUploadState() {
        return uploadFailed ^= 1;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getFanCount() {
        int votes;
        if (getModel() != null) {
            votes = getModel().getVotes();
        } else {
            votes = 0;
        }
        return votes;
    }

    public void getFans(int i, u<List<ChallengeEntryVoter>> u2) {
        app.dogo.com.dogo_android.model.entry_list_item_models.x xVar;
        long l;
        String str;
        int obj4;
        if (i > 0) {
            m2.c cVar = this.firestoreService.L(f.entryFans.forEntryId(getModel().getDocumentId()));
            str = "date";
            cVar.e(str, Query.Direction.DESCENDING);
            xVar = new x(this, u2);
            cVar.a().limit((long)i).get().addOnSuccessListener(xVar);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getImageUrl() {
        int path;
        ChallengeEntryModel model = getModel();
        if (model == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(model.getDocumentId());
        stringBuilder.append(".jpg");
        Uri uri = this.storageService.h("challenge_failed", stringBuilder.toString());
        if (model.isUploadFailed() && uri != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(model.getDocumentId());
            stringBuilder.append(".jpg");
            uri = this.storageService.h("challenge_failed", stringBuilder.toString());
            if (uri != null) {
                path = uri.getPath();
            }
            return path;
        }
        return model.getImageUrl();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getMotivationalText() {
        ChallengeEntryModel model = getModel();
        if (!model.isUploadFailed() && model.getVotesRank() <= 3) {
            if (model.getVotesRank() <= 3) {
                Object[] arr = new Object[1];
                return this.resources.getString(2131886298, String.valueOf(model.getVotesRank()));
            }
            return this.resources.getString(2131886299);
        }
        return "";
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getPhotoCount() {
        return imageCount += photoUploading;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getRankText() {
        int i;
        String dogName;
        int i2;
        ChallengeEntryModel model = getModel();
        if (model.getPublished()) {
            i = model.hasChallengeEnded() ? R.string.challenge.ended.rank.text : R.string.challenge.active.rank.text;
            if (model.getDogName() == null) {
                dogName = this.resources.getString(2131887121);
            }
            Object[] arr = new Object[2];
            return this.resources.getString(i, dogName, Integer.valueOf(model.getVotesRank()));
        }
        if (model.isUploadFailed()) {
            return this.resources.getString(2131886573);
        }
        return this.resources.getString(2131887637);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getRankVisibility() {
        int i;
        ChallengeEntryModel votesRank;
        Object sINGLE_ENTRY_NEVER_ENDING;
        votesRank = getModel();
        sINGLE_ENTRY_NEVER_ENDING = this.challengeLocalRepository.a(votesRank.getChallengeId());
        if (sINGLE_ENTRY_NEVER_ENDING != null && votesRank.getVotesRank() != 0 && !sINGLE_ENTRY_NEVER_ENDING.getMediaType().equals(ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING)) {
            if (votesRank.getVotesRank() != 0) {
                i = !sINGLE_ENTRY_NEVER_ENDING.getMediaType().equals(ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING) ? 0 : 8;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void h(a0 a0, j j2) {
        g(a0, j2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isPublished() {
        return getModel().getPublished();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isShareButtonVisible() {
        boolean challengeEnded;
        int i;
        if (!getModel().hasChallengeEnded() && isPublished()) {
            i = isPublished() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isSpinnerVisible() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isTranslateButtonVisible() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void j(a0 a0, j j2) {
        i(a0, j2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void l(u u, QuerySnapshot querySnapshot2) {
        k(u, querySnapshot2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onShareClicked(a0 a0) {
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void trackError(String string, Exception exception2) {
        a.e(exception2, string, new Object[0]);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void update() {
        updateEntryView();
        notifyChange(129);
        notifyChange(130);
        notifyChange(114);
        notifyChange(67);
        notifyChange(140);
    }
}
