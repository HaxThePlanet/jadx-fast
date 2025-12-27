package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.ImageView;
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
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.n0.u;
import app.dogo.com.dogo_android.util.w;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.t;
import com.google.android.gms.tasks.j;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Query.Direction;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: EntryUserPhotoObservable.java */
/* loaded from: classes.dex */
public class EntryUserPhotoObservable extends EntryPhotoBaseObservable {

    private final a1 challengeLocalRepository;
    private final k2 dynamicLinkService;
    private final m2 firestoreService;
    private final Resources resources;
    private final s2 stateManager;
    private final t2 storageService;
    private final o3 tracker;
    private final u2 userLocalCacheService;
    private final app.dogo.com.dogo_android.service.v2 utilities;
    public EntryUserPhotoObservable() {
        this(App.h(), App.b(), App.onCreate().getResources(), App.o(), App.m(), App.j(), App.g(), App.p(), App.f(), App.e(), App.i(), App.c(), App.l());
    }

    private /* synthetic */ void g(a0 a0Var, j jVar) throws android.content.res.Resources.NotFoundException {
        a0Var.s();
        if (!jVar.isSuccessful()) {
            return;
        }
        if (jVar.getResult() != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", (ShortDynamicLink)jVar.getResult().getShortLink().toString());
            this.tracker.logEvent(E_ChallengeSharing.a.c(new EP_EntryId(), getModel().getDocumentId(), new EP_ChallengeId(), getModel().getChallengeId()));
            int i = 2131887330;
            a0Var.startActivity(Intent.createChooser(intent, this.resources.getString(i)));
        }
    }

    private /* synthetic */ void i(a0 a0Var, j jVar) {
        boolean successful;
        a0Var.s();
        if (!jVar.isSuccessful() || jVar.getResult() == null) {
            int i = 2131886123;
            a0Var.t0(i);
        } else {
            a0Var.h0((Uri)jVar.getResult(), getModel());
        }
    }

    private /* synthetic */ void k(u uVar, QuerySnapshot querySnapshot) {
        boolean z = false;
        QueueableEntryDataFetcher queueableEntryDataFetcher = new QueueableEntryDataFetcher(getModel().getChallengeId(), z, this.firestoreService, this.userLocalCacheService, this.stateManager, uVar, this.disposable);
        final ArrayList arrayList = new ArrayList();
        Iterator it = querySnapshot.getDocuments().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            queueableEntryDataFetcher = item.toObject(ChallengeEntryVoter.class);
            queueableEntryDataFetcher.setDocumentId(item.getId());
            arrayList.add(queueableEntryDataFetcher);
        }
        queueableEntryDataFetcher.searchForEntryData(arrayList);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void callChallengeShareDialog(ImageView imageView, a0 a0Var) {
        a0Var.m();
        if (!this.utilities.o(ApplicationPackageNames.INSTAGRAM_PACKAGE_NAME.getTag())) {
            this.dynamicLinkService.generateSharingLink("sharing_challenge_photo", getModel(), this.challengeLocalRepository.getChallenge(getModel().getChallengeId())).addOnCompleteListener(new w(this, a0Var));
            return;
        }
        this.storageService.a(this.storageService.d(imageView)).addOnCompleteListener(new v(this, a0Var));
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean getEntryUploadState() {
        return !getModel().isUploadFailed();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getFanCount() {
        int votes = 0;
        if (getModel() != null) {
            votes = getModel().getVotes();
        } else {
            votes = 0;
        }
        return votes;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void getFans(int i, u<List<ChallengeEntryVoter>> uVar) {
        if (i > 0) {
            m2.c cVar = this.firestoreService.L(FirestorePath.entryFans.forEntryId(getModel().getDocumentId()));
            str = "date";
            cVar.orderBy(str, Query.Direction.DESCENDING);
            l = (long)i;
            cVar.build().limit(l).get().addOnSuccessListener(new x(this, uVar));
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getImageUrl() {
        int i = 0;
        ChallengeEntryModel model = getModel();
        i = 0;
        if (model == null) {
            return null;
        }
        if (model.isUploadFailed()) {
            StringBuilder stringBuilder = new StringBuilder();
            String documentId = model.getDocumentId();
            String str = ".jpg";
            str2 = documentId + str;
            Uri uri = this.storageService.h("challenge_failed", str2);
            if (uri != null) {
                String path = uri.getPath();
            }
            return i;
        }
        return model.getImageUrl();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getMotivationalText() throws android.content.res.Resources.NotFoundException {
        ChallengeEntryModel model = getModel();
        if (!model.isUploadFailed()) {
            if (model.getVotesRank() <= 3) {
                Object[] arr = new Object[1];
                return this.resources.getString(2131886298, new Object[] { String.valueOf(model.getVotesRank()) });
            }
            return this.resources.getString(2131886299);
        }
        return "";
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getPhotoCount() {
        return getModel().getImageCount() + getModel().isPhotoUploading(this.utilities.g());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getRankText() throws android.content.res.Resources.NotFoundException {
        int i = 2131886260;
        String dogName;
        ChallengeEntryModel model = getModel();
        if (model.getPublished()) {
            int r1 = model.hasChallengeEnded() ? R.string.challenge.ended.rank.text : R.string.challenge.active.rank.text;
            if (model.getDogName() == null) {
                int i2 = 2131887121;
                dogName = this.resources.getString(i2);
            }
            Object[] arr = new Object[2];
            return this.resources.getString(i, new Object[] { dogName, Integer.valueOf(model.getVotesRank()) });
        }
        if (model.isUploadFailed()) {
            return this.resources.getString(2131886573);
        }
        return this.resources.getString(2131887637);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getRankVisibility() {
        int i = 0;
        ChallengeModel challenge;
        ChallengeEntryModel model = getModel();
        challenge = this.challengeLocalRepository.getChallenge(model.getChallengeId());
        if (challenge != null && model.getVotesRank() != 0) {
            int r0 = !challenge.getMediaType().equals(ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING) ? 0 : 8;
        }
        return (!challenge.getMediaType().equals(ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING) ? 0 : 8);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isPublished() {
        return getModel().getPublished();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isShareButtonVisible() {
        boolean z = false;
        int r0 = !getModel().hasChallengeEnded() && this.isPublished() ? 1 : 0;
        return (!getModel().hasChallengeEnded() && this.isPublished() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void trackError(String str, Exception exc) {
        a.e(exc, str, new Object[0]);
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

    public EntryUserPhotoObservable(m2 m2Var, h2 h2Var, Resources resources, o3 o3Var, t2 t2Var, q2 q2Var, u2 u2Var, app.dogo.com.dogo_android.service.v2 v2Var, k2 k2Var, a1 a1Var, p2 p2Var, i2 i2Var, s2 s2Var) {
        final Object m2Var3 = this;
        super(m2Var, h2Var, o3Var, q2Var, u2Var, v2Var, resources, a1Var, t2Var, k2Var, p2Var, i2Var);
        m2Var3.firestoreService = m2Var;
        m2Var3.resources = resources;
        m2Var3.tracker = o3Var;
        m2Var3.storageService = t2Var;
        m2Var3.userLocalCacheService = u2Var;
        m2Var3.dynamicLinkService = k2Var;
        m2Var3.challengeLocalRepository = a1Var;
        m2Var3.utilities = v2Var;
        m2Var3.stateManager = s2Var;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public /* synthetic */ void h(a0 a0Var, j jVar) {
        g(a0Var, jVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isSpinnerVisible() {
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isTranslateButtonVisible() {
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public /* synthetic */ void j(a0 a0Var, j jVar) {
        i(a0Var, jVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public /* synthetic */ void l(u uVar, QuerySnapshot querySnapshot) {
        k(uVar, querySnapshot);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onShareClicked(a0 a0Var) {
    }
}
