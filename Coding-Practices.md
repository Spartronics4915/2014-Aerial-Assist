**Constants**: These will be in all caps with spaces between each word. No non letters except underscores in the constant name. They should well describe the desired number for it's purpose, not its value. Example: MOTOR_SPEED is better than TWENTY_ONE for a constant describing how fast we drive our motor.  
  
**Variables**: These will be in camel case with an initial lowercase letter. Numbers should not be present as the first character of the variable name. The names should describe the purpose that they hold, not the values that they could possess. Example: numberOfLightFlashes is acceptable. 1-10Flashes is not.  
  
**Methods**: These will be in camel case with an initial lowercase letter. They should describe the action that the method does. Example: void driveLeftMotor(int joystickInput) is a good method declaration.  
  
**Commenting**: Each method will have 2-3 sentences describing it's actions, it's intended inputs and intended outputs. Each variable and constant will have a sentence describing it's use and possible values.  
  
**Versioning**: "xx.yy.zz" Each method, subcomponent and build will have its own number.  
* xx is the large version number that will always be the same as the current version of the project. Increment this whenever the purpose and capabilities of the project change. Ensure that each method, subcomponent and variable works with new version and update their version number accordingly.  
* yy is the unique version number that should be updated for each method, subcomponent and comprehensive project separately. Increment this whenever you have finished adding new functionality.  
* zz is the small unique version number that describes number of precise updates to efficiency and bug fixing. Increment this whenever the method or project is changed at all.