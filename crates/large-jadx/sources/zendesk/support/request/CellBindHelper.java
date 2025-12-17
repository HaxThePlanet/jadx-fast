package zendesk.support.request;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.a;
import com.squareup.picasso.t;
import d.h.l.f0.b;
import f.g.d.c;
import f.g.d.g;
import f.g.d.j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import o.b.f;
import zendesk.belvedere.a;

/* loaded from: classes3.dex */
class CellBindHelper {

    private static final SimpleDateFormat DATE_FORMAT;
    private final zendesk.support.request.ActionFactory af;
    private final zendesk.support.request.CellAttachmentLoadingUtil attachmentUtil;
    private final Context context;
    private final f dispatcher;
    private final String today;
    private final String yesterday;
    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy", Locale.getDefault());
        CellBindHelper.DATE_FORMAT = simpleDateFormat;
    }

    CellBindHelper(Context context, t t2, zendesk.support.request.ActionFactory actionFactory3, f f4) {
        super();
        this.context = context;
        this.af = actionFactory3;
        this.dispatcher = f4;
        CellAttachmentLoadingUtil obj3 = new CellAttachmentLoadingUtil(t2, context);
        this.attachmentUtil = obj3;
        this.today = context.getString(j.q);
        this.yesterday = context.getString(j.r);
    }

    static void access$000(zendesk.support.request.CellBindHelper cellBindHelper, Context context2, zendesk.support.request.StateRequestAttachment stateRequestAttachment3) {
        cellBindHelper.openAttachment(context2, stateRequestAttachment3);
    }

    static Context access$100(zendesk.support.request.CellBindHelper cellBindHelper) {
        return cellBindHelper.context;
    }

    static zendesk.support.request.ActionFactory access$200(zendesk.support.request.CellBindHelper cellBindHelper) {
        return cellBindHelper.af;
    }

    static f access$300(zendesk.support.request.CellBindHelper cellBindHelper) {
        return cellBindHelper.dispatcher;
    }

    private boolean basicCellChecks(zendesk.support.request.CellType.Base cellType$Base, zendesk.support.request.CellType.Base cellType$Base2) {
        final int i = 1;
        if (base == base2) {
            return i;
        }
        final int i2 = 0;
        if (base.getPositionType() != base2.getPositionType()) {
            return i2;
        }
        if (!base.getClass().isInstance(base2)) {
            return i2;
        }
        return i;
    }

    private int getPixelForDp(int i) {
        Resources resources;
        int obj2;
        if (i != 0) {
            obj2 = this.context.getResources().getDimensionPixelOffset(i);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    private boolean nullSafeEquals(Object object, Object object2) {
        if (object == object2) {
            return 1;
        }
        if (object != null && object2 == null) {
            if (object2 == null) {
            }
            return object.equals(object2);
        }
        return 0;
    }

    private void openAttachment(Context context, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
        android.content.Intent obj4 = a.c(context).f(stateRequestAttachment2.getParsedLocalUri(), stateRequestAttachment2.getMimeType());
        if (context.getPackageManager().queryIntentActivities(obj4, 0).size() > 0) {
            context.startActivity(obj4);
        }
    }

    void addOnClickListenerForFileAttachment(View view, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
        zendesk.support.request.CellBindHelper.1 anon;
        Object obj3;
        if (stateRequestAttachment2.isAvailableLocally()) {
            view.setAlpha(1065353216);
            anon = new CellBindHelper.1(this, stateRequestAttachment2);
            view.setOnClickListener(anon);
        } else {
            view.setAlpha(obj3 /= anon);
            obj3 = new CellBindHelper.2(this);
            view.setOnClickListener(obj3);
        }
    }

    void addOnClickListenerForImageAttachment(View view, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
        zendesk.support.request.CellBindHelper.3 availableLocally;
        zendesk.support.request.StateRequestAttachment obj3;
        if (stateRequestAttachment2.isAvailableLocally()) {
            availableLocally = new CellBindHelper.3(this, stateRequestAttachment2);
            view.setOnClickListener(availableLocally);
        } else {
            view.setOnClickListener(0);
        }
    }

    boolean areAgentCellContentsTheSame(zendesk.support.request.CellType.Agent cellType$Agent, zendesk.support.request.CellType.Base cellType$Base2) {
        int i2;
        int i;
        int obj7;
        i = 0;
        if (!basicCellChecks(agent, base2)) {
            return i;
        }
        if (!base2 instanceof CellType.Agent) {
            return i;
        }
        int i3 = 1;
        i2 = Long.compare(id, id2) == 0 ? i3 : i;
        obj7 = agent.isAgentNameVisible() == base2.isAgentNameVisible() ? i3 : i;
        if (i2 != 0 && agent.getAgent().getName().equals(base2.getAgent().getName()) && obj7 != null) {
            if (agent.getAgent().getName().equals(base2.getAgent().getName())) {
                if (obj7 != null) {
                    i = i3;
                }
            }
        }
        return i;
    }

    boolean areAttachmentCellContentsTheSame(zendesk.support.request.CellType.Attachment cellType$Attachment, zendesk.support.request.CellType.Base cellType$Base2) {
        int i;
        i = 0;
        if (!basicCellChecks(attachment, base2)) {
            return i;
        }
        if (!base2 instanceof CellType.Attachment) {
            return i;
        }
        zendesk.support.request.StateRequestAttachment obj5 = attachment.getAttachment();
        zendesk.support.request.StateRequestAttachment obj6 = (CellType.Attachment)base2.getAttachment();
        if (nullSafeEquals(obj5.getLocalFile(), obj6.getLocalFile()) != null && nullSafeEquals(obj5.getLocalUri(), obj6.getLocalUri()) && nullSafeEquals(obj5.getUrl(), obj6.getUrl())) {
            if (nullSafeEquals(obj5.getLocalUri(), obj6.getLocalUri())) {
                if (nullSafeEquals(obj5.getUrl(), obj6.getUrl())) {
                    i = 1;
                }
            }
        }
        return i;
    }

    boolean areMessageContentsTheSame(zendesk.support.request.CellType.Message cellType$Message, zendesk.support.request.CellType.Base cellType$Base2) {
        final int i = 0;
        if (!basicCellChecks(message, base2)) {
            return i;
        }
        if (!base2 instanceof CellType.Message) {
            return i;
        }
        return message.getMessage().equals((CellType.Message)base2.getMessage());
    }

    boolean areStatefulCellContentsTheSame(zendesk.support.request.CellType.Stateful cellType$Stateful, zendesk.support.request.CellType.Base cellType$Base2) {
        int i;
        int i4;
        int i3;
        int i2;
        int obj7;
        i4 = 0;
        if (!basicCellChecks(stateful, base2)) {
            return i4;
        }
        if (!base2 instanceof CellType.Stateful) {
            return i4;
        }
        final int i5 = 1;
        i = stateful.isErrorShown() == (CellType.Stateful)base2.isErrorShown() ? i5 : i4;
        i3 = stateful.isMarkedAsDelivered() == base2.isMarkedAsDelivered() ? i5 : i4;
        i2 = stateful.getErrorGroupMessages().size() == base2.getErrorGroupMessages().size() ? i5 : i4;
        obj7 = stateful.isLastErrorCellOfBlock() == base2.isLastErrorCellOfBlock() ? i5 : i4;
        if (i != 0 && i3 != 0 && i2 != 0 && obj7 != null) {
            if (i3 != 0) {
                if (i2 != 0) {
                    if (obj7 != null) {
                        i4 = i5;
                    }
                }
            }
        }
        return i4;
    }

    void bindAgentName(TextView textView, boolean z2, zendesk.support.request.StateRequestUser stateRequestUser3) {
        String obj2;
        if (z2) {
            textView.setVisibility(0);
            textView.setText(stateRequestUser3.getName());
        } else {
            textView.setVisibility(4);
        }
    }

    void bindAppInfo(ResolveInfo resolveInfo, TextView textView2, ImageView imageView3) {
        textView2.setText(UtilsAttachment.getAppName(this.context, resolveInfo));
        imageView3.setImageDrawable(UtilsAttachment.getAppIcon(this.context, resolveInfo));
    }

    void bindDate(TextView textView, Date date2) {
        boolean dATE_FORMAT;
        String obj3;
        if (UtilsDate.isToday(date2)) {
            obj3 = this.today;
        } else {
            if (UtilsDate.isYesterday(date2)) {
                obj3 = this.yesterday;
            } else {
                obj3 = CellBindHelper.DATE_FORMAT.format(date2);
            }
        }
        textView.setText(obj3.toUpperCase(Locale.getDefault()));
    }

    void bindImage(ImageView imageView, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
        this.attachmentUtil.bindImage(imageView, stateRequestAttachment2);
    }

    void bindStatusLabel(TextView textView, boolean z2, boolean z3) {
        int i;
        int i3;
        int i2;
        int obj6;
        int obj7;
        i3 = 0;
        obj6 = z2 ? j.u : z3 != 0 ? j.t : i;
        if (i > 0) {
            textView.setTextColor(a.d(this.context, i));
        }
        if (obj6 > 0) {
            textView.setText(obj6);
        }
        textView.clearAnimation();
        if (i3 == 0 && i3 != textView.getVisibility()) {
            if (i3 != textView.getVisibility()) {
                obj7 = 0;
                i = 1065353216;
                obj6 = new AlphaAnimation(obj7, i);
                obj6.setDuration(250);
                obj6.setInterpolator(b.a(obj7, obj7, 1045220557, i));
                textView.startAnimation(obj6);
            }
        }
        textView.setVisibility(i3);
    }

    int colorForError(boolean z) {
        int obj2;
        obj2 = z ? c.G : c.F;
        return a.d(this.context, obj2);
    }

    int colorForErrorImage(boolean z) {
        if (z) {
            return a.d(this.context, c.H);
        }
        return 0;
    }

    View.OnClickListener errorClickListener(boolean z, List<zendesk.support.request.StateMessage> list2) {
        if (z) {
            CellBindHelper.4 obj1 = new CellBindHelper.4(this, list2);
            return obj1;
        }
        return null;
    }

    ResolveInfo getAppInfo(String string) {
        return UtilsAttachment.getAppInfoForFile(this.context, string);
    }

    Rect getInsets(int i, int i2, int i3, int i4) {
        Rect rect = new Rect(getPixelForDp(i), getPixelForDp(i2), getPixelForDp(i3), getPixelForDp(i4));
        return rect;
    }
}
