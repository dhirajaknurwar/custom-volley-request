# custom-volley-request
VOLLEY LIB ANDROID: 

A major advantage of Android Volley over AsyncTask is that you can do multiple requests simultaneously without the overhead
of thread management. Also I believe retry mechanism is a great feature of volley which gives it an edge over AsynTask.
Another advantage of volley over AsyncTask is that it provides you with multiple request types, through which complex 
requests can be made easily.

How to useVolley Lib :

Add this line to your gradle dependencies for your Android project's app module: 
compile 'com.android.volley:volley:1.0.0'
OR
First get latest volley with git (git clone https://android.googlesource.com/platform/frameworks/volley).
In your current project (android studio) click [File] --> [New] -->[Import Module].
Now select the directory where you downloaded Volley to.
Now Android studio might guide you to do the rest but continue guide to verify that everything works correct
Open settings.gradle 
(find in root) and add (or verify this is included):
include ':app', ':volley' 
Now go to your build.gradle in your project and add the dependency:
compile project(":volley")
