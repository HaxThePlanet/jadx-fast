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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J&\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\rJ$\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "", "resources", "Landroid/content/res/Resources;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "firebaseDynamicLinks", "Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;", "(Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;)V", "generateDogInvitationUrl", "Lio/reactivex/Single;", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink;", "dogName", "", "dogAvatar", "inviteId", "generateSharingLink", "Lcom/google/android/gms/tasks/Task;", "linkType", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "generateShortContentLink", "baseUrl", "Landroid/net/Uri;", "imageUrl", "title", "description", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k2 {

    private final Resources a;
    private final app.dogo.com.dogo_android.service.r2 b;
    private final FirebaseDynamicLinks c;
    public k2(Resources resources, app.dogo.com.dogo_android.service.r2 r22, FirebaseDynamicLinks firebaseDynamicLinks3) {
        n.f(resources, "resources");
        n.f(r22, "remoteConfigService");
        n.f(firebaseDynamicLinks3, "firebaseDynamicLinks");
        super();
        this.a = resources;
        this.b = r22;
        this.c = firebaseDynamicLinks3;
    }

    private static final void b(app.dogo.com.dogo_android.service.k2 k2, Uri uri2, String string3, String string4, String string5, c0 c06) {
        n.f(k2, "this$0");
        n.f(string4, "$title");
        n.f(string5, "$description");
        n.f(c06, "emitter");
        n.e(uri2, "baseUrl");
        j0 obj2 = new j0(c06);
        k2.e(uri2, string3, string4, string5).addOnCompleteListener(obj2);
    }

    private static final void c(c0 c0, j j2) {
        boolean successful;
        Object obj2;
        n.f(c0, "$emitter");
        if (j2.isSuccessful()) {
            c0.onSuccess(j2.getResult());
        } else {
            if (j2.getException() == null) {
                obj2 = new Exception("deeplink not generated");
            }
            c0.onError(obj2);
        }
    }

    private final j<ShortDynamicLink> e(Uri uri, String string2, String string3, String string4) {
        String obj6;
        String string = this.a.getString(2131886794);
        n.e(string, "resources.getString(string.ios_app_store_id)");
        String string5 = this.a.getString(2131886793);
        n.e(string5, "resources.getString(string.ios_app_bundle_id)");
        DynamicLink.SocialMetaTagParameters.Builder builder = new DynamicLink.SocialMetaTagParameters.Builder();
        if (string2 != null) {
        } else {
            obj6 = "";
        }
        obj6 = new DynamicLink.IosParameters.Builder(string5);
        obj6 = new DynamicLink.AndroidParameters.Builder();
        j obj5 = this.c.createDynamicLink().setLink(uri).setDomainUriPrefix(this.b.j()).setSocialMetaTagParameters(builder.setImageUrl(Uri.parse(obj6)).setTitle(string3).setDescription(string4).build()).setIosParameters(obj6.setAppStoreId(string).build()).setAndroidParameters(obj6.build()).buildShortDynamicLink(2);
        n.e(obj5, "firebaseDynamicLinks\n            .createDynamicLink()\n            .setLink(baseUrl)\n            .setDomainUriPrefix(domain)\n            .setSocialMetaTagParameters(\n                DynamicLink.SocialMetaTagParameters.Builder()\n                    .setImageUrl(Uri.parse(imageUrl.orEmpty()))\n                    .setTitle(title)\n                    .setDescription(description)\n                    .build()\n            )\n            .setIosParameters(\n                DynamicLink.IosParameters.Builder(iosAppBundleId)\n                    .setAppStoreId(iosAppStoreId)\n                    .build()\n            )\n            .setAndroidParameters(\n                DynamicLink.AndroidParameters.Builder().build()\n            )\n            .buildShortDynamicLink(Suffix.SHORT)");
        return obj5;
    }

    public static void f(c0 c0, j j2) {
        k2.c(c0, j2);
    }

    public static void g(app.dogo.com.dogo_android.service.k2 k2, Uri uri2, String string3, String string4, String string5, c0 c06) {
        k2.b(k2, uri2, string3, string4, string5, c06);
    }

    public final a0<ShortDynamicLink> a(String string, String string2, String string3) {
        n.f(string, "dogName");
        n.f(string3, "inviteId");
        Object[] arr = new Object[1];
        final String string4 = this.a.getString(2131886792, string);
        n.e(string4, "resources.getString(string.invite_parent_train_dog_header, dogName)");
        final String string5 = this.a.getString(2131886779);
        n.e(string5, "resources.getString(string.invite_description_train_together)");
        StringBuilder obj9 = new StringBuilder();
        obj9.append("https://dogo.app/invite/");
        obj9.append(string3);
        obj9.append("?utm_medium=native&utm_source=Android");
        super(this, Uri.parse(obj9.toString()), string2, string4, string5);
        obj9 = a0.create(obj9);
        n.e(obj9, "create { emitter ->\n            generateShortContentLink(baseUrl, dogAvatar, title, description).addOnCompleteListener { task ->\n                if (task.isSuccessful) {\n                    emitter.onSuccess(task.result)\n                } else {\n                    emitter.onError(task.exception ?: Exception(\"deeplink not generated\"))\n                }\n            }\n        }");
        return obj9;
    }

    public final j<ShortDynamicLink> d(String string, ChallengeEntryModel challengeEntryModel2, ChallengeModel challengeModel3) {
        n.f(string, "linkType");
        n.f(challengeEntryModel2, "entryModel");
        n.f(challengeModel3, "challengeModel");
        String obj9 = challengeEntryModel2.getDogName();
        Object[] arr = new Object[2];
        final int i2 = 0;
        arr[i2] = obj9;
        final int i3 = 1;
        arr[i3] = challengeModel3.getName();
        String obj10 = this.a.getString(2131887332, arr);
        n.e(obj10, "resources.getString(string.social_share_challenges_my_photo_title, dogName, challengeName)");
        Object[] arr2 = new Object[i3];
        arr2[i2] = obj9;
        obj9 = this.a.getString(2131887331, arr2);
        n.e(obj9, "resources.getString(string.social_share_challenges_my_photo_description, dogName)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://dogo.pro/?entryId=");
        stringBuilder.append(challengeEntryModel2.getDocumentId());
        stringBuilder.append("&challengeId=");
        stringBuilder.append(challengeModel3.getId());
        stringBuilder.append("&linkType=");
        stringBuilder.append(string);
        Uri obj8 = Uri.parse(stringBuilder.toString());
        n.e(obj8, "baseUrl");
        return e(obj8, challengeEntryModel2.getImageUrl(), obj10, obj9);
    }
}
