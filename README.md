Native Crosswalk Authentication
================================

Crosswalk in Android Studio, with Cordova, using native authentication.

- Uses [identity-toolkit-android](https://github.com/googlesamples/identity-toolkit-android)
  to authenticate through Google.
- Passes the token into a [Crosswalk](https://crosswalk-project.org/)
  web view with [Cordova](http://cordova.apache.org/) enabled, so you
  can build apps with [Ionic Framework](http://ionicframework.com/), for
  example, and still leverage Android native identity tools.
- *Coming soon* - example app with Ionic integration and with Facebook
  authentication too.

![demo gif](https://github.com/brentvatne/native-crosswalk-auth/blob/master/demo.gif)

Thanks [twilly86/CrossWalkAndroidStudio](https://github.com/twilly86/CrossWalkAndroidStudio)
for the base project to work off of.

### Try it out

1. Import this project into Android Studio 1.0
2. Edit `Application/AndroidManifest.xml` and follow [these steps to add your API credentials](https://developers.google.com/identity-toolkit/quickstart/android#step_2_configure_the_google_identity_toolkit_api).
3. Connect your device and run it.
