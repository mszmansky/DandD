package org.agileandbeyond.dandd.tddexercise.exception;

public class CannotUseWeaponException extends Exception {

	private static final long serialVersionUID = 3260671429588045243L;

	public CannotUseWeaponException(){
		
	}
	
	public CannotUseWeaponException(String msg) {
		super(msg);
	}
}
