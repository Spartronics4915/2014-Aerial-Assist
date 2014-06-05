* [How do I configure my personal development laptop and connect to cRIO?](#How do I configure my personal development laptop and connect to cRIO?)
* [How do I know if code deployed? (java)](#How do I know if code deployed? (java))
* [How do I troubleshoot code download problems to cRIO?](#How do I troubleshoot code download problems to cRIO?)
* [Failing to run robot code on cRIO - org.usfirst.frc0000.Robot, was not found](#Failing to run robot code on cRIO - org.usfirst.frc0000.Robot, was not found)
* [cRIO error codes](#cRIO error codes)

***

# How do I configure my personal development laptop and connect to cRIO?
1. Make sure cRIO is connected to wireless bridge and is on
2. Connect to wireless bridge - it will advertise itself as team number (4915) and specify password
3. Go into your network settings to configure your IP address and subnet mask to match wireless bridge and cRIO configuration


# How do I know if code deployed? (java)
1. Make sure code build with no errors ("Run/Clean & Build Project" if unsure)
2. Build log will indicate something about FTPing to the address of the robot
3. cRIO will reeboot (~7-12 seconds)
    * follow on messages will be from VXWorks and LabView runtime components to verify FPGA versions
    * any messages relating to method overload issues are warnings - default methods will ran from the library 

More info on: [Understanding the program download process](http://wpilib.screenstepslive.com/s/3120/m/7885/l/97458-understanding-the-program-download-process)

# How do I troubleshoot code download problems to cRIO?
1. Make sure NetBeans is properly configured with your FRC team number
2. If connection is timed out, verify your network configuration on your development system
    * If both wired and wireless connections are active - delete the appropriate one
    * If running wireless, make sure development is connected to wireless bridge (and cRIO is connected to wireless bridge)
    * You may need to disable the firewall on Windows

#cRIO error codes
These codes are displayed on the driver station's diagnostic panel. 
[FRC driver station warnings](http://wpilib.screenstepslive.com/s/3120/m/8559/l/96657-frc-driver-station-errors-warnings)

Note, this is 2010 information, but probably still valid (but not completely up to date?!?). 
[FRC error codes](http://zone.ni.com/reference/en-XX/help/372635F-01/frc/frc_error_codes/)

# Failing to run robot code on cRIO - org.usfirst.frc0000.Robot, was not found
... badly formatted text :(
> [cRIO] Welcome to LabVIEW Real-Time 13.0
> [cRIO] task 0xd00818 (sysapi-rpc) deleted: errno=0 (0) status=0 (0)
> [cRIO]
> [cRIO] [Squawk VM] Version: 2011 FRC, Nov 5 2011, 14:34:13
> [cRIO] Uncaught exception in Thread.run():
> [cRIO] on thread org.usfirst.frc0000.Robot - main
> [cRIO] java.lang.IllegalArgumentException: MIDlet class specified, org.usfirst.frc0000.Robot, was not found
> [cRIO] at com.sun.squawk.imp.MIDletMainWrapper.main(94)
> [cRIO] in virtual method #95 of com.sun.squawk.Klass(bci=25)
> [cRIO] at com.sun.squawk.Isolate.run(1506)
> [cRIO] at java.lang.Thread.run(231)
> [cRIO] in virtual method #47 of com.sun.squawk.VMThread(bci=42)
> [cRIO] in static method #3 of com.sun.squawk.VM(bci=6)
> [cRIO] 
> [cRIO] 
> [cRIO] --------------------------------------------------------------------
> [cRIO] GCs: 1 full, 0 partial
> [cRIO] ** VM stopped: exit code = 1 **

Make sure team number is properly updated in NetBeans, Robot Builder (reflected in java package), cRIO, etc. 