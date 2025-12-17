package androidx.lifecycle;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003", d2 = {"createMutuallyExclusiveErrorMessage", "", "key", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandle_androidKt {
    public static final String access$createMutuallyExclusiveErrorMessage(String key) {
        return SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(key);
    }

    private static final String createMutuallyExclusiveErrorMessage(String key) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("StateFlow and LiveData are mutually exclusive for the same key. Please use either 'getMutableStateFlow' or 'getLiveData' for key '").append(key).append("', but not both.").toString();
    }
}
