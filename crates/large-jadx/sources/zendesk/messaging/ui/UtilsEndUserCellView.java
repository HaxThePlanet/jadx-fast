package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import androidx.core.content.a;
import f.g.c.a;
import java.util.HashSet;
import java.util.Set;
import zendesk.commonui.d;
import zendesk.messaging.Attachment;
import zendesk.messaging.AttachmentSettings;
import zendesk.messaging.MessagingItem.FileQuery.FailureReason;
import zendesk.messaging.MessagingItem.Query.Status;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.string;

/* loaded from: classes3.dex */
class UtilsEndUserCellView {

    private static final int ATTACHMENTS_NOT_SUPPORTED;
    private static final int ATTACHMENT_COULD_NOT_BE_SENT;
    private static final int ATTACHMENT_TYPE_NOT_SUPPORTED;
    private static final int ERROR_BACKGROUND;
    private static final int ERROR_BACKGROUND_COLOR;
    private static final int EXCEEDING_MAX_FILE_SIZE;
    private static final int FILE_BACKGROUND;
    private static final int PENDING_COLOR;
    private static final int TAP_TO_RETRY;
    private static final int USER_MESSAGE_BACKGROUND;
    static {
        UtilsEndUserCellView.ERROR_BACKGROUND = R.drawable.zui_background_cell_errored;
        UtilsEndUserCellView.FILE_BACKGROUND = R.drawable.zui_background_cell_file;
        UtilsEndUserCellView.USER_MESSAGE_BACKGROUND = R.drawable.zui_background_end_user_cell;
        UtilsEndUserCellView.TAP_TO_RETRY = R.string.zui_label_tap_retry;
        UtilsEndUserCellView.EXCEEDING_MAX_FILE_SIZE = R.string.zui_message_log_message_file_exceeds_max_size;
        UtilsEndUserCellView.ATTACHMENTS_NOT_SUPPORTED = R.string.zui_message_log_message_attachments_not_supported;
        UtilsEndUserCellView.ATTACHMENT_TYPE_NOT_SUPPORTED = R.string.zui_message_log_message_attachment_type_not_supported;
        UtilsEndUserCellView.ATTACHMENT_COULD_NOT_BE_SENT = R.string.zui_message_log_attachment_sending_failed;
        UtilsEndUserCellView.ERROR_BACKGROUND_COLOR = R.color.zui_error_background_color;
        UtilsEndUserCellView.PENDING_COLOR = R.color.zui_color_white_60;
    }

    static Set access$000(MessagingItem.Query.Status messagingItem$Query$Status) {
        return UtilsEndUserCellView.getMenuOptions(status);
    }

    private static String getAttachmentLabelErrorMessage(zendesk.messaging.ui.EndUserCellFileState endUserCellFileState, Context context2) {
        if (endUserCellFileState.getStatus() == MessagingItem.Query.Status.FAILED) {
            return context2.getString(UtilsEndUserCellView.TAP_TO_RETRY);
        }
        return UtilsEndUserCellView.getAttachmentNonRetryableErrorMessage(endUserCellFileState, context2);
    }

    private static String getAttachmentNonRetryableErrorMessage(zendesk.messaging.ui.EndUserCellFileState endUserCellFileState, Context context2) {
        String string = context2.getString(UtilsEndUserCellView.ATTACHMENT_COULD_NOT_BE_SENT);
        if (endUserCellFileState.getFailureReason() == null) {
            return string;
        }
        int i = UtilsEndUserCellView.5.$SwitchMap$zendesk$messaging$MessagingItem$FileQuery$FailureReason[endUserCellFileState.getFailureReason().ordinal()];
        int i2 = 1;
        if (i != i2 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    return string;
                }
                return context2.getString(UtilsEndUserCellView.ATTACHMENT_TYPE_NOT_SUPPORTED);
            }
            return context2.getString(UtilsEndUserCellView.ATTACHMENTS_NOT_SUPPORTED);
        }
        if (endUserCellFileState.getAttachmentSettings() != null) {
            Object[] arr = new Object[i2];
            arr[0] = UtilsAttachment.formatFileSize(context2, endUserCellFileState.getAttachmentSettings().getMaxFileSize());
            return context2.getString(UtilsEndUserCellView.EXCEEDING_MAX_FILE_SIZE, arr);
        }
        return string;
    }

    static Drawable getImageLoadingPlaceholder(Context context) {
        int i3 = d.e(R.attr.colorPrimaryDark, context, R.color.zui_color_primary_dark);
        int[] iArr = new int[3];
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen.zui_cell_bubble_corner_radius));
        return gradientDrawable;
    }

    private static Set<zendesk.messaging.ui.MessagePopUpHelper.Option> getMenuOptions(MessagingItem.Query.Status messagingItem$Query$Status) {
        MessagingItem.Query.Status fAILED_NO_RETRY;
        Enum obj2;
        HashSet hashSet = new HashSet(2);
        if (status == MessagingItem.Query.Status.FAILED) {
            hashSet.add(MessagePopUpHelper.Option.DELETE);
            hashSet.add(MessagePopUpHelper.Option.RETRY);
        } else {
            if (status == MessagingItem.Query.Status.FAILED_NO_RETRY) {
                hashSet.add(MessagePopUpHelper.Option.DELETE);
            }
        }
        return hashSet;
    }

    static boolean isFailedCell(zendesk.messaging.ui.EndUserCellBaseState endUserCellBaseState) {
        MessagingItem.Query.Status fAILED_NO_RETRY;
        int obj1;
        obj1 = endUserCellBaseState.getStatus();
        if (obj1 != MessagingItem.Query.Status.FAILED) {
            if (obj1 == MessagingItem.Query.Status.FAILED_NO_RETRY) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private static void setAttachmentClickListener(zendesk.messaging.ui.EndUserCellFileState endUserCellFileState, View view2) {
        int anon;
        int i;
        int obj2;
        anon = UtilsEndUserCellView.5.$SwitchMap$zendesk$messaging$MessagingItem$Query$Status[endUserCellFileState.getStatus().ordinal()];
        if (anon != 1 && anon != 2) {
            if (anon != 2) {
                if (anon != 3) {
                    if (anon != 4) {
                    } else {
                        anon = new UtilsEndUserCellView.3(endUserCellFileState);
                        view2.setOnClickListener(anon);
                    }
                } else {
                    anon = new UtilsEndUserCellView.2(endUserCellFileState);
                    view2.setOnClickListener(anon);
                }
            } else {
                view2.setOnClickListener(0);
            }
        } else {
        }
    }

    static void setCellBackground(zendesk.messaging.ui.EndUserCellBaseState endUserCellBaseState, View view2) {
        boolean failedCell;
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuff.Mode sRC_ATOP;
        int obj3;
        String obj4;
        if (UtilsEndUserCellView.isFailedCell(endUserCellBaseState)) {
            view2.setBackgroundResource(UtilsEndUserCellView.ERROR_BACKGROUND);
        } else {
            if (endUserCellBaseState instanceof EndUserCellFileState != null) {
                view2.setBackgroundResource(UtilsEndUserCellView.FILE_BACKGROUND);
            } else {
                obj3 = a.f(view2.getContext(), UtilsEndUserCellView.USER_MESSAGE_BACKGROUND);
                if (obj3 != null) {
                    porterDuffColorFilter = new PorterDuffColorFilter(d.e(R.attr.colorPrimary, view2.getContext(), R.color.zui_color_primary), PorterDuff.Mode.SRC_ATOP);
                    obj3.setColorFilter(porterDuffColorFilter);
                    view2.setBackground(obj3);
                } else {
                    a.k("UtilsEndUserCellView", "Failed to set background, resource R.drawable.zui_background_end_user_cell could not be found", new Object[0]);
                }
            }
        }
    }

    static void setClickListener(zendesk.messaging.ui.EndUserCellBaseState endUserCellBaseState, View view2) {
        boolean z;
        if (endUserCellBaseState instanceof EndUserCellMessageState) {
            UtilsEndUserCellView.setMessageClickListener((EndUserCellMessageState)endUserCellBaseState, view2);
        } else {
            if (endUserCellBaseState instanceof EndUserCellFileState != null) {
                UtilsEndUserCellView.setAttachmentClickListener((EndUserCellFileState)endUserCellBaseState, view2);
            }
        }
    }

    static void setLabelErrorMessage(zendesk.messaging.ui.EndUserCellBaseState endUserCellBaseState, TextView textView2, Context context3) {
        String obj1;
        if (!UtilsEndUserCellView.isFailedCell(endUserCellBaseState)) {
            textView2.setVisibility(8);
        }
        textView2.setVisibility(0);
        if (endUserCellBaseState instanceof EndUserCellFileState != null) {
            textView2.setText(UtilsEndUserCellView.getAttachmentLabelErrorMessage((EndUserCellFileState)endUserCellBaseState, context3));
        } else {
            textView2.setText(context3.getString(UtilsEndUserCellView.TAP_TO_RETRY));
        }
    }

    static void setLongClickListener(zendesk.messaging.ui.EndUserCellBaseState endUserCellBaseState, View view2) {
        UtilsEndUserCellView.4 anon = new UtilsEndUserCellView.4(view2, endUserCellBaseState);
        view2.setOnLongClickListener(anon);
    }

    private static void setMessageClickListener(zendesk.messaging.ui.EndUserCellMessageState endUserCellMessageState, View view2) {
        Object status;
        MessagingItem.Query.Status fAILED_NO_RETRY;
        if (endUserCellMessageState.getStatus() != MessagingItem.Query.Status.FAILED) {
            if (endUserCellMessageState.getStatus() == MessagingItem.Query.Status.FAILED_NO_RETRY) {
                status = new UtilsEndUserCellView.1(endUserCellMessageState);
                view2.setOnClickListener(status);
            }
        } else {
        }
    }
}
