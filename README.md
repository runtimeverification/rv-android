RV-Android
-----------
RV-Android is a comprehensive effort to bring runtime verification to
Android.  RV-Android uses RV-Monitor as a library generation backend
(runtimeverification.com/monitor) and JavaMOP for aspect weaving.  
RV-Cloud is also used in the GUI, on-device flavor of this project to
provide cloud weaving and instrumentation of binary applications.


RV-Android is currently under active development, and is only 
recommended for an advanced developer audience familiar with both
runtime verification and Android development and concepts.  We are 
working to add interfaces for developers not familiar with these 
technologies, so check back periodically for updates.


RV-Android comes in three flavors, and are represented by the directories:
- developer_src: Developer prototype for Android applciation developers 
  allowing for instrumentation of Android apps with known source only.

- beta/cli: A command-line, developer-targeted script allowing for
  arbitrary, binary applications to be instrumented with any monitors
  and aspects provided.  Instrumentation is currently separate from 
  library generation, so familiarity with both RV-Monitor and AspectJ
  is important.  **This is the version we recommend if you are interested
  in exploring RV-Android.**


- beta/gui: An unfinished, not yet working Android app allowing for on-device
  monitor generation and instrumentation together with RV-Cloud.


Please see the README.md files in each respective directory for more 
information and usage instructions, along with the RV-Monitor documentation
at runtimeverification.com/monitor/docs.
