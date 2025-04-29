package com.infobeans.model;

public class fee {
			private  String name;
			private int fees;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getFees() {
				return fees;
			}
			public void setFees(int fees) {
				this.fees = fees;
			}
			public fee(String name, int fees) {
				super();
				this.name = name;
				this.fees = fees;
			}
			
}
