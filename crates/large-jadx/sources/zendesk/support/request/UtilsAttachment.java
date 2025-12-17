package zendesk.support.request;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.a;
import f.g.d.j;
import f.g.e.a;
import f.g.e.g;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import zendesk.belvedere.a;
import zendesk.belvedere.s;
import zendesk.support.IdUtil;

/* loaded from: classes3.dex */
class UtilsAttachment {

    private static final String ATTACHMENT_SEPARATOR = ", ";
    private static final String ATTACHMENT_TEXT_BODY = "[%s]";
    private static final String PATH_PLACEHOLDER = "%s%s%s";
    private static final zendesk.support.request.UtilsAttachment.AttachmentNameComparator REQUEST_ATTACHMENT_COMPARATOR;
    private static final String REQUEST_BELVEDERE_PATH;
    private static final String SUPPORT_BELVEDERE_BASE_PATH;

    private static class AttachmentNameComparator implements Comparator<zendesk.support.request.StateRequestAttachment> {
        AttachmentNameComparator(zendesk.support.request.UtilsAttachment.1 utilsAttachment$1) {
            super();
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return compare((StateRequestAttachment)object, (StateRequestAttachment)object2);
        }

        @Override // java.util.Comparator
        public int compare(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
            return stateRequestAttachment.getName().compareTo(stateRequestAttachment2.getName());
        }
    }
    static {
        Locale uS = Locale.US;
        int i = 3;
        Object[] arr2 = new Object[i];
        final int i3 = 0;
        arr2[i3] = "zendesk";
        String separator = File.separator;
        final int i4 = 1;
        arr2[i4] = separator;
        final int i5 = 2;
        arr2[i5] = "support";
        String str4 = "%s%s%s";
        String format2 = String.format(uS, str4, arr2);
        UtilsAttachment.SUPPORT_BELVEDERE_BASE_PATH = format2;
        Object[] arr = new Object[i];
        arr[i3] = format2;
        arr[i4] = separator;
        arr[i5] = "request";
        UtilsAttachment.REQUEST_BELVEDERE_PATH = String.format(uS, str4, arr);
        UtilsAttachment.AttachmentNameComparator attachmentNameComparator = new UtilsAttachment.AttachmentNameComparator(0);
        UtilsAttachment.REQUEST_ATTACHMENT_COMPARATOR = attachmentNameComparator;
    }

    static Drawable getAppIcon(Context context, ResolveInfo resolveInfo2) {
        PackageManager packageManager;
        Drawable obj2;
        if (resolveInfo2 != null) {
            obj2 = resolveInfo2.loadIcon(context.getPackageManager());
        } else {
            obj2 = 0;
        }
        if (obj2 != null) {
            return obj2;
        }
        return a.f(context, 17301651);
    }

    static ResolveInfo getAppInfoForFile(Context context, String string2) {
        s obj3 = a.c(context).d("tmp", string2);
        int obj4 = 0;
        if (obj3 == null) {
            return obj4;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(obj3.n());
        obj3 = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (!a.g(obj3)) {
            return (ResolveInfo)obj3.get(0);
        }
        return obj4;
    }

    static java.lang.CharSequence getAppName(Context context, ResolveInfo resolveInfo2) {
        PackageManager packageManager;
        Object obj2;
        if (resolveInfo2 != null) {
            obj2 = resolveInfo2.loadLabel(context.getPackageManager());
        } else {
            obj2 = "";
        }
        if (!TextUtils.isEmpty(obj2)) {
            return obj2;
        }
        return context.getString(j.d);
    }

    static String getAttachmentSubDir(String string, long l2) {
        Object[] arr = new Object[3];
        return String.format(Locale.US, "%s%s%s", string, File.separator, Long.valueOf(l2));
    }

    static String getCacheDirForRequestId(String string) {
        Object[] arr = new Object[3];
        return String.format(Locale.US, "%s%s%s", UtilsAttachment.REQUEST_BELVEDERE_PATH, File.separator, string);
    }

    static String getContentDescriptionForAttachmentButton(Context context, int i2) {
        String str;
        int i;
        int i3;
        String obj4;
        int obj5;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(j.p));
        stringBuilder.append(". ");
        if (i2 == 0) {
            stringBuilder.append(context.getString(j.P));
        } else {
            str = 1;
            if (i2 == str) {
                stringBuilder.append(context.getString(j.Q));
            } else {
                str = new Object[str];
                str[0] = Integer.valueOf(i2);
                stringBuilder.append(context.getString(j.O, str));
            }
        }
        return stringBuilder.toString();
    }

    static s getLocalFile(a a, String string2, long l3, String string4) {
        return a.d(UtilsAttachment.getAttachmentSubDir(UtilsAttachment.getCacheDirForRequestId(string2), l3), obj4);
    }

    static String getMessageBodyForAttachments(List<zendesk.support.request.StateRequestAttachment> list) {
        int i;
        int str;
        List obj5 = a.c(list);
        Collections.sort(obj5, UtilsAttachment.REQUEST_ATTACHMENT_COMPARATOR);
        StringBuilder stringBuilder = new StringBuilder();
        int size = obj5.size();
        final int i3 = 0;
        i = i3;
        while (i < size) {
            stringBuilder.append((StateRequestAttachment)obj5.get(i).getName());
            if (i < size + -1) {
            }
            i++;
            stringBuilder.append(", ");
        }
        Object[] arr = new Object[1];
        arr[i3] = stringBuilder.toString();
        return String.format(Locale.US, "[%s]", arr);
    }

    static String getTemporaryRequestCacheDir() {
        Object[] arr = new Object[3];
        return String.format(Locale.US, "%s%s%s", UtilsAttachment.REQUEST_BELVEDERE_PATH, File.separator, IdUtil.newStringId());
    }

    static boolean hasAttachmentBody(zendesk.support.request.StateMessage stateMessage) {
        if (a.i(stateMessage.getAttachments())) {
            return stateMessage.getBody().equals(UtilsAttachment.getMessageBodyForAttachments(stateMessage.getAttachments()));
        }
        return 0;
    }

    static boolean isImageAttachment(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
        boolean str;
        String obj1;
        obj1 = stateRequestAttachment.getMimeType();
        if (g.c(obj1) && obj1.toLowerCase(Locale.US).startsWith("image")) {
            obj1 = obj1.toLowerCase(Locale.US).startsWith("image") ? 1 : 0;
        } else {
        }
        return obj1;
    }
}
