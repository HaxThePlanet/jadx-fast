package com.facebook.share.a;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.b0;
import com.facebook.share.b.a;
import com.facebook.share.b.b;
import com.facebook.share.b.c;
import com.facebook.share.b.e;
import com.facebook.share.b.f;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0015", d2 = {"Lcom/facebook/share/internal/WebDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "appGroupCreationContent", "Lcom/facebook/share/model/AppGroupCreationContent;", "gameRequestContent", "Lcom/facebook/share/model/GameRequestContent;", "shareLinkContent", "Lcom/facebook/share/model/ShareLinkContent;", "shareOpenGraphContent", "Lcom/facebook/share/model/ShareOpenGraphContent;", "sharePhotoContent", "Lcom/facebook/share/model/SharePhotoContent;", "createBaseParameters", "shareContent", "Lcom/facebook/share/model/ShareContent;", "createForFeed", "shareFeedContent", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class d {
    static {
    }

    public static final Bundle a(c c) {
        n.f(c, "shareLinkContent");
        Bundle bundle = d.c(c);
        b0.l0(bundle, "href", c.a());
        b0.k0(bundle, "quote", c.d());
        return bundle;
    }

    public static final Bundle b(f f) {
        String str;
        int string;
        n.f(f, "shareOpenGraphContent");
        Bundle bundle = d.c(f);
        e eVar = f.d();
        if (eVar != null) {
            str = eVar.e();
        } else {
            str = string;
        }
        b0.k0(bundle, "action_type", str);
        JSONObject obj4 = c.e(c.f(f), false);
        if (obj4 != null) {
            string = obj4.toString();
        }
        b0.k0(bundle, "action_properties", string);
        return bundle;
    }

    public static final Bundle c(a<?, ?> a) {
        String obj2;
        n.f(a, "shareContent");
        Bundle bundle = new Bundle();
        obj2 = a.b();
        if (obj2 != null) {
            obj2 = obj2.a();
        } else {
            obj2 = 0;
        }
        b0.k0(bundle, "hashtag", obj2);
        return bundle;
    }
}
