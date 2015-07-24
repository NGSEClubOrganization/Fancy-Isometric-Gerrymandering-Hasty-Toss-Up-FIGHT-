package com.ngse.utilities;

public class Toggle {

	public boolean b;

	public Toggle(boolean b) {
		this.b = b;
	}

	public Toggle toggle() {
		b = !b;
		return this;
	}

}
