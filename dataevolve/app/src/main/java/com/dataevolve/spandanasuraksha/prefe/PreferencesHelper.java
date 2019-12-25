package com.dataevolve.spandanasuraksha.prefe;

public interface PreferencesHelper {

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    void setCurrentUserProfilein(int profile_in);


    String getCurrentUserId();

    void setCurrentUserId(String userId);

    int getCurrentUserLoggedInMode();

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);
}
