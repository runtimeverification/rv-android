Building the Final, Instrumented Application (as provided)
--------------
SimpleMediaPlayer: Simple RV-Monitor Example
==============

Initial Setup
--------------
Before building, modify local.properties to point to the absolute path of the Android SDK you downloaded in the installation steps.  This will be *inside* the ADT folder you extracted and should be named "sdk" (eg - /home/user/adt/sdk)

Building the Final, Instrumented Application (as provided)
--------------
In this case, we provide the final generated monitoring libraries for the properties included with this application.

This means that you do not have to use RV-Monitor to generate them, and can simply build a final version of the application with "ant debug".

Once the execution of "ant debug" has completed, a file named "MonitoredApp-debug.apk" will be generated in the "bin" subfolder of the project.  Simply copy this file to your device and install as any other Android application APK (eg - copy it over with USB, use a file manager to click it)

Building the Final, Uninstrumented Application (as provided)
--------------
To avoid instrumenting and monitoring the application and simply build the vanilla application with no calls to the monitoring library inserted, simply rename custom_rules.xml to custom_rules.xml.bak.  Then, run ant debug and install as above.

Building the Final, Instrumented Application (from scratch)
--------------
To generate from scratch the monitoring libraries via rv-monitor, run the following:
- cd mop_properties
- rv-monitor SetOnPreparedListener.rvm
- cp SetOnPreparedListenerRuntimeMonitor.java ../src/com/example/myapp/.
- ant debug to build and install as above

Also, feel free to browse and modify the instrumentation in the "aspects" directory, which defines the instrumentation for the monitoring libraries generated above.
