# AugmentedRealityGame


### Directions for Setup


1. Clone repository, and open the folder SwipeBall in Unity
(Other folders represent other tutorials and different versions of our project)

2. Once project is opened in Unity, go to File -> Build Settings, select Android, then press the Switch Platform button. 

3. To confirm your SDK is properly configured, go to Edit -> Preferences, select External Tools, look under Android, and find the SDK field. Direct this entry box to where your SDK is located. If you have Android Studio Installed, you will find the SDK folder within Android Studio's directory. If you do not have an Android SDK package, download Android Studio [here]( https://developer.android.com/studio/index.html).

4. Confirm **App Bundle Identifier** is correct: The company name and product name sometimes revert to their default. To correct this possible error, in the top menu bar, go to XR -> App Key Settings, and confirm the following: 

   - Product Name: CORN
   - Company Name: CDK
   - Bundle Identifier: com.CDK.CORN

5. In the Build Setting screen, have your physical device connected to your computer and select your device from the drop down menu. Click Build and Run. 
 
Note: This project was devloped on Unity Version 2018.3.11f1, for purposes of compatibility between the project member's Operating Systems. When opening with a newer version of Unity, agree to Unity's suggestion to update the project, and it will run succesfully. 

