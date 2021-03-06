package com.phantommentalists.Twenty15;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Author: Hunter Lawrence
 */
public class Elevator {

      private CANTalon leftMotor;
      private CANTalon rightMotor;
  public Elevator(int leftCANID,int rightCANID)
  {
	  leftMotor = new CANTalon(leftCANID);
	  rightMotor = new CANTalon(rightCANID);
	  
	  leftMotor.changeControlMode(ControlMode.PercentVbus);
	  rightMotor.changeControlMode(ControlMode.PercentVbus);
	  
	  leftMotor.enableBrakeMode(true);
	  rightMotor.enableBrakeMode(true);
	  
	  leftMotor.enableLimitSwitch(true, true);
	  rightMotor.enableLimitSwitch(true, true);
	  
	  leftMotor.enableControl();
	  rightMotor.enableControl();
  }
  public void processElevator()
  {
	  SmartDashboard.putBoolean("Stacker up left limit", leftMotor.isRevLimitSwitchClosed());
	  SmartDashboard.putBoolean("Stacker up right limit", rightMotor.isFwdLimitSwitchClosed());
	  SmartDashboard.putBoolean("Stacker down left limit", leftMotor.isFwdLimitSwitchClosed());
	  SmartDashboard.putBoolean("Stacker down right limit", rightMotor.isRevLimitSwitchClosed());
	  SmartDashboard.putBoolean("isUp", isUp());
	  SmartDashboard.putBoolean("isDown",isDown());

//	  if(isUp() || isDown())
//	  {
//		  stop();
//	  } 
  }
  /** 
   *  This method moves the elevator side to the up position.
   */
  public void goUp() {
	  leftMotor.set(-1.0);
	  rightMotor.set(0.92);
  }

  /** 
   *  This method moves the elevator side to the down position
   */
  public void goDown() {
	  leftMotor.set(1.0);
	  rightMotor.set(-0.92);
  }
  /**
   *  This method stops the elevator side
   */
  public void stop()
  {
	  leftMotor.set(0.0);
	  rightMotor.set(0.0);
  }
  public boolean isRaising()
  {
	  if(leftMotor.getBusVoltage() > 0.0 && rightMotor.getBusVoltage() > 0.0)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  public boolean isLowering()
  {
	  if(leftMotor.getBusVoltage() > 0.0 && rightMotor.getBusVoltage() > 0.0)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  /** 
   *  This method return true if the elevator side is up, false otherwise.
   */
  public boolean isUp() {
	  //TODO: Just thrown in there fwd/rev limit switches not known
	  if(leftMotor.isRevLimitSwitchClosed() && rightMotor.isFwdLimitSwitchClosed())
		  return true;
	  else
		  return false;
  }

  /** 
   *  This method returns true if the elevator side is down, false otherwise.
   */
  public boolean isDown() {
	  //TODO: Same as the TODO in isUp()
	  if(leftMotor.isFwdLimitSwitchClosed() && rightMotor.isRevLimitSwitchClosed())
		  return true;
	  else
		  return false;
  }

}