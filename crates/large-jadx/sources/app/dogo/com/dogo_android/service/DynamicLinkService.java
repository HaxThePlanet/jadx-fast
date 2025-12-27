package app.dogo.com.dogo_android.service;

import android.content.res.Resources;
import android.net.Uri;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import com.google.android.gms.tasks.j;
import com.google.firebase.dynamiclinks.DynamicLink.AndroidParameters.Builder;
import com.google.firebase.dynamiclinks.DynamicLink.Builder;
import com.google.firebase.dynamiclinks.DynamicLink.IosParameters.Builder;
import com.google.firebase.dynamiclinks.DynamicLink.SocialMetaTagParameters.Builder;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import i.b.a0;
import i.b.c0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DynamicLinkService.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J&\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\rJ$\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "", "resources", "Landroid/content/res/Resources;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "firebaseDynamicLinks", "Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;", "(Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;)V", "generateDogInvitationUrl", "Lio/reactivex/Single;", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink;", "dogName", "", "dogAvatar", "inviteId", "generateSharingLink", "Lcom/google/android/gms/tasks/Task;", "linkType", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "generateShortContentLink", "baseUrl", "Landroid/net/Uri;", "imageUrl", "title", "description", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k2, reason: from kotlin metadata */
public final class DynamicLinkService {

    /* renamed from: a, reason: from kotlin metadata */
    private final Resources firebaseDynamicLinks;
    /* renamed from: b, reason: from kotlin metadata */
    private final r2 remoteConfigService;
    /* renamed from: c, reason: from kotlin metadata */
    private final FirebaseDynamicLinks resources;
    public k2(Resources resources, r2 r2Var, FirebaseDynamicLinks firebaseDynamicLinks) {
        n.f(resources, "resources");
        n.f(r2Var, "remoteConfigService");
        n.f(firebaseDynamicLinks, "firebaseDynamicLinks");
        super();
        this.firebaseDynamicLinks = resources;
        this.remoteConfigService = r2Var;
        this.resources = firebaseDynamicLinks;
    }

    private static final void b(k2 k2Var, Uri uri, String str, String str2, String str3, c0 c0Var) {
        n.f(k2Var, "this$0");
        n.f(str2, "$title");
        n.f(str3, "$description");
        n.f(c0Var, "emitter");
        n.e(uri, "baseUrl");
        k2Var.generateShortContentLink(uri, str, str2, str3).addOnCompleteListener(new j0(c0Var));
    }

    private static final void c(c0 c0Var, j jVar) {
        boolean successful;
        Exception exception;
        n.f(c0Var, "$emitter");
        if (jVar.isSuccessful()) {
            c0Var.onSuccess(jVar.getResult());
        } else {
            if (jVar.getException() == null) {
                exception = new Exception("deeplink not generated");
            }
            c0Var.onError(exception);
        }
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final j<ShortDynamicLink> generateShortContentLink(Uri baseUrl, String imageUrl, String title, String description) throws android.content.res.Resources.NotFoundException {
        String str;
        String string = this.firebaseDynamicLinks.getString(2131886794);
        n.e(string, "resources.getString(string.ios_app_store_id)");
        String string2 = this.firebaseDynamicLinks.getString(2131886793);
        n.e(string2, "resources.getString(string.ios_app_bundle_id)");
        if (imageUrl == null) {
            str = "";
        }
        j shortDynamicLink = this.resources.createDynamicLink().setLink(baseUrl).setDomainUriPrefix(this.remoteConfigService.j()).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(str)).setTitle(title).setDescription(description).build()).setIosParameters(new DynamicLink.IosParameters.Builder(string2).setAppStoreId(string).build()).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink(2);
        n.e(shortDynamicLink, "firebaseDynamicLinks\n            .createDynamicLink()\n            .setLink(baseUrl)\n            .setDomainUriPrefix(domain)\n            .setSocialMetaTagParameters(\n                DynamicLink.SocialMetaTagParameters.Builder()\n                    .setImageUrl(Uri.parse(imageUrl.orEmpty()))\n                    .setTitle(title)\n                    .setDescription(description)\n                    .build()\n            )\n            .setIosParameters(\n                DynamicLink.IosParameters.Builder(iosAppBundleId)\n                    .setAppStoreId(iosAppStoreId)\n                    .build()\n            )\n            .setAndroidParameters(\n                DynamicLink.AndroidParameters.Builder().build()\n            )\n            .buildShortDynamicLink(Suffix.SHORT)");
        return shortDynamicLink;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<ShortDynamicLink> generateDogInvitationUrl(String dogName, String dogAvatar, String inviteId) throws android.content.res.Resources.NotFoundException {
        n.f(dogName, "dogName");
        n.f(inviteId, "inviteId");
        Object[] arr = new Object[1];
        final String string = this.firebaseDynamicLinks.getString(2131886792, new Object[] { dogName });
        n.e(string, "resources.getString(string.invite_parent_train_dog_header, dogName)");
        final String string2 = this.firebaseDynamicLinks.getString(2131886779);
        n.e(string2, "resources.getString(string.invite_description_train_together)");
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "https://dogo.app/invite/";
        final String str8 = "?utm_medium=native&utm_source=Android";
        str6 = str3 + inviteId + str8;
        k0 dogName2 = new k0(this, Uri.parse(str6), dogAvatar, string, string2);
        a0 a0Var = a0.create(dogName2);
        n.e(a0Var, "create { emitter ->\n            generateShortContentLink(baseUrl, dogAvatar, title, description).addOnCompleteListener { task ->\n                if (task.isSuccessful) {\n                    emitter.onSuccess(task.result)\n                } else {\n                    emitter.onError(task.exception ?: Exception(\"deeplink not generated\"))\n                }\n            }\n        }");
        return a0Var;
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final j<ShortDynamicLink> generateSharingLink(String linkType, ChallengeEntryModel entryModel, ChallengeModel challengeModel) throws android.content.res.Resources.NotFoundException {
        n.f(linkType, "linkType");
        n.f(entryModel, "entryModel");
        n.f(challengeModel, "challengeModel");
        String documentId = entryModel.getDocumentId();
        final String id = challengeModel.getId();
        String dogName = entryModel.getDogName();
        Object[] arr = new Object[2];
        final int i2 = 0;
        arr[i2] = dogName;
        final int i3 = 1;
        arr[i3] = challengeModel.getName();
        String string2 = this.firebaseDynamicLinks.getString(2131887332, arr);
        n.e(string2, "resources.getString(string.social_share_challenges_my_photo_title, dogName, challengeName)");
        Object[] arr2 = new Object[i3];
        arr2[i2] = dogName;
        String string = this.firebaseDynamicLinks.getString(2131887331, arr2);
        n.e(string, "resources.getString(string.social_share_challenges_my_photo_description, dogName)");
        StringBuilder stringBuilder = new StringBuilder();
        String str9 = "https://dogo.pro/?entryId=";
        String str4 = "&challengeId=";
        String str5 = "&linkType=";
        str10 = str9 + documentId + str4 + id + str5 + linkType;
        Uri parse = Uri.parse(str10);
        n.e(parse, "baseUrl");
        return generateShortContentLink(parse, entryModel.getImageUrl(), string2, string);
    }

    public static /* synthetic */ void f(c0 c0Var, j jVar) {
        DynamicLinkService.c(c0Var, jVar);
    }

    public static /* synthetic */ void g(k2 k2Var, Uri uri, String str, String str2, String str3, c0 c0Var) {
        DynamicLinkService.b(k2Var, uri, str, str2, str3, c0Var);
    }
}
