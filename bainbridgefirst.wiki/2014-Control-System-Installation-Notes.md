Instructions for setting up the control system is documented on the [2014 FRC Control System](http://wpilib.screenstepslive.com/s/3120) site. This document captures our notes and observations. 

Note: Our classmate is: 2go Classmate PC (E12/Intel Atom). [Classmate website](http://ctl.net/first-robotics-competition)

**IMPORTANT: As I type this, FRC is updating their instructions on the website based on team feedback. So, make sure to review and double check!**

**IMPORTANT: After completing installations, please verify we have the correct versions: [Latest Software Revisions](http://wpilib.screenstepslive.com/s/3120/m/8559/l/155479-latest-software-revisions)**


# Step 1: Imaging the classmate
**IMPORTANT: This step requires internet connection**

Ideally, as a rookie team, we would be following the instructions for [Imaging your Classmate (Rookie USB stick)](http://wpilib.screenstepslive.com/s/3120/m/8559/l/92209-imaging-your-classmate-rookie-usb-stick). However, as the image on the USB stick was corrupted, we switched to: [Imaging your Classmate (Veteran/Rookie Image Download)](http://wpilib.screenstepslive.com/s/3120/m/8559/l/92211-imaging-your-classmate-veteran-rookie-image-download).

Note that there are two different images for each specific classmate configurations:
1. Exx_DRV_2014_version.7z: driver station images
2. Exx_DEV_2014_version.7z: development system images

Our classmate is installed with the DEV system. This process creates two user accounts on the classmate: developer and driver. 

## Step 1a: Validating Microsoft Windows
After some research, we found the fix through the [2014 FRC KOPs](http://www.usfirst.org/roboticsprograms/frc/control-system) site. Download, extract and run Windows 7 Activation files. **IMPORTANT: If activation is unsuccessful, run the Activate.bat file!** 

## Step 1b: Updating Microsoft Windows
At this point, start the update process and go to bed! When update is complete, classmate will reboot. Log into Developer account to complete the updates. If you log into Driver account, you maybe repeating some of the update steps!

## Step 1c: Checking if Driver station is installed
After Windows update is complete, log into Driver user. Ideally, you will be greeted with the Driver Station. However, in our case, I believe the DEV image did not have the driver files, even after applying the required patch (FRC _E12-DS_Update-2014-01.exe) Driver account did not load driver station. 

This takes us to Step 2: Updating NI Components.

# Step 2: Updating NI
**IMPORTANT: This step requires internet connection**

For this step, we followed the following instructions: [Installing the 2014 FRC NI Update (for ALL TEAMS)](http://wpilib.screenstepslive.com/s/3120/m/8559/l/89639?data-resolve-url=true&data-manual-id=8559).  

**IMPORTANT: Before starting, make sure you have the LabView Serial Number (back of the NI Software for FRC 2014 envelope)**

**IMPORTANT: If the NI files are protected, try the FRC 2014 password.**

At this point, you should be able to log on as the Driver user and see the driver station load! However, your screen resolution maybe a problem...

## Step 2a: Updating classmate drivers
For driver updates, goto [Classmate's Support Page](http://ctl.net/support). Link for the driver downloads is buried somewhere in the middle of the page. Direct link for our E12: [2go Classmate PC (E12/Intel Atom)](http://ctl.helpserve.com/Knowledgebase/Article/View/317/66/2go-classmate-pc-e12intel-atom) 

Download the required drivers and install under the Developer account. At reboot, Driver Station should be correctly loaded and displayed.

## Step 3: Update/Install NetBeans FRC plugins
Though this doesn't require direct internet connection, it is easier to do the install and updates directly through plugin manager. 

**IMPORTANT: NetBeans configuration is NOT complete!**

# Next steps:
Configure classmate with cRIO and finish control software installation and configuration. 

## Installing and setting up the SmartDashboard
download the installation package [here](http://firstforge.wpi.edu/sf/frs/do/listReleases/projects.smartdashboard/frs.installer).
You will also need to modify the ini file to get the SmartDashboard to run while logged in as the driver. [Here are the instructions for doing so](http://wpilib.screenstepslive.com/s/3120/m/7932/l/90078-getting-started-with-the-smartdashboard)

To add anything (such as a camera) in the SmartDashboard, go to view, then add and select what you would like to add.

## Configuring D-Link  
Follow these directions explicitly if you want everything to work. DON'T switch the d-link back to bridge mode - it should be in AP 2.4 GHz (the physical switch on the d-link that is)  

Instructions: [http://wpilib.screenstepslive.com/s/3120/m/8559/l/91405-programming-your-radio-for-home-use#!prettyPhoto](http://wpilib.screenstepslive.com/s/3120/m/8559/l/91405-programming-your-radio-for-home-use#!prettyPhoto)