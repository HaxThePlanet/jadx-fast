package zendesk.answerbot;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes3.dex */
final class DeflectionRequest {

    @SerializedName("deflection_channel_id")
    private final int deflectionChannelId;
    @SerializedName("enquiry")
    private final String enquiry;
    @SerializedName("interaction_reference")
    private final String interactionReference;
    @SerializedName("interaction_reference_type")
    private final int interactionReferenceType;
    @SerializedName("labels")
    private final List<String> labels;
    @SerializedName("locale")
    private final String locale;
    @SerializedName("via_id")
    private final int viaId;
    DeflectionRequest(int i, int i2, String string3, String string4, List<String> list5, String string6, int i7) {
        super();
        this.viaId = i;
        this.deflectionChannelId = i2;
        this.enquiry = string3;
        this.locale = string4;
        this.labels = list5;
        this.interactionReference = string6;
        this.interactionReferenceType = i7;
    }

    public boolean equals(Object object) {
        int equals3;
        boolean enquiry;
        boolean equals2;
        boolean equals;
        Class<zendesk.answerbot.DeflectionRequest> obj;
        String interactionReferenceType;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (DeflectionRequest.class != object.getClass()) {
            } else {
                if (this.viaId != object.viaId) {
                    return i;
                }
                if (this.deflectionChannelId != object.deflectionChannelId) {
                    return i;
                }
                if (this.interactionReferenceType != object.interactionReferenceType) {
                    return i;
                }
                String enquiry2 = this.enquiry;
                if (enquiry2 != null) {
                    if (!enquiry2.equals(object.enquiry)) {
                        return i;
                    }
                } else {
                    if (object.enquiry != null) {
                    }
                }
                String locale = this.locale;
                if (locale != null) {
                    if (!locale.equals(object.locale)) {
                        return i;
                    }
                } else {
                    if (object.locale != null) {
                    }
                }
                List labels = this.labels;
                if (labels != null) {
                    if (!labels.equals(object.labels)) {
                        return i;
                    }
                } else {
                    if (object.labels != null) {
                    }
                }
                String interactionReference = this.interactionReference;
                final String obj5 = object.interactionReference;
                if (interactionReference != null) {
                    equals3 = interactionReference.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals3 = i;
                    }
                }
            }
            return equals3;
        }
        return i;
    }

    public int hashCode() {
        int i3;
        int i2;
        int i4;
        int i;
        String enquiry = this.enquiry;
        i = 0;
        if (enquiry != null) {
            i3 = enquiry.hashCode();
        } else {
            i3 = i;
        }
        String locale = this.locale;
        if (locale != null) {
            i2 = locale.hashCode();
        } else {
            i2 = i;
        }
        List labels = this.labels;
        if (labels != null) {
            i4 = labels.hashCode();
        } else {
            i4 = i;
        }
        String interactionReference = this.interactionReference;
        if (interactionReference != null) {
            i = interactionReference.hashCode();
        }
        return i15 += interactionReferenceType;
    }
}
