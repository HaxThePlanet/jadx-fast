package app.dogo.com.dogo_android.s.a;

import android.content.res.Resources;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: GetCustomerExperienceInteractor.kt */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetCustomerExperienceInteractor;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "getListOfCustomerExperience", "", "Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j2, reason: from kotlin metadata */
public final class GetCustomerExperienceInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final Resources resources;
    public j2(Resources resources) {
        n.f(resources, "resources");
        super();
        this.resources = resources;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final List<CustomerExperience> getListOfCustomerExperience() throws android.content.res.Resources.NotFoundException {
        CustomerExperience[] arr = new CustomerExperience[5];
        String string = this.resources.getString(2131887494);
        n.e(string, "resources.getString(R.string.testimonials_01_name)");
        String string6 = this.resources.getString(2131887495);
        n.e(string6, "resources.getString(R.string.testimonials_01_text)");
        String string2 = this.resources.getString(2131887496);
        n.e(string2, "resources.getString(R.string.testimonials_02_name)");
        String string7 = this.resources.getString(2131887497);
        n.e(string7, "resources.getString(R.string.testimonials_02_text)");
        String string3 = this.resources.getString(2131887498);
        n.e(string3, "resources.getString(R.string.testimonials_03_name)");
        String string8 = this.resources.getString(2131887499);
        n.e(string8, "resources.getString(R.string.testimonials_03_text)");
        String string4 = this.resources.getString(2131887500);
        n.e(string4, "resources.getString(R.string.testimonials_04_name)");
        String string9 = this.resources.getString(2131887501);
        n.e(string9, "resources.getString(R.string.testimonials_04_text)");
        String string5 = this.resources.getString(2131887502);
        n.e(string5, "resources.getString(R.string.testimonials_05_name)");
        String string10 = this.resources.getString(2131887503);
        n.e(string10, "resources.getString(R.string.testimonials_05_text)");
        return p.j(new CustomerExperience[] { new CustomerExperience(string, 2131231322, string6), new CustomerExperience(string2, 2131231323, string7), new CustomerExperience(string3, 2131231324, string8), new CustomerExperience(string4, 2131231325, string9), new CustomerExperience(string5, 2131231326, string10) });
    }
}
