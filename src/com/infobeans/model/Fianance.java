package com.infobeans.model;

public class Fianance {
	  
		private int  fee_id;
		private int s_id;
		private int fees;
		public static int fixed =10000;
		public int getFees() {
			return fees;
		}
		public void setFixed() {
			int fixed = 10000;
		}
		public int getFixed() {
			return fixed;
		}
		
		public void setFees(int fees) {
			this.fees = fees;
		}
		
		public int getFee_id() {
			return fee_id;
		}
		public void setFee_id(int fee_id) {
			this.fee_id = fee_id;
		}
		public int getS_id() {
			return s_id;
		}
		public void setS_id(int s_id) {
			this.s_id = s_id;
		}
		public Fianance(int fee_id, int s_id, int fees) {
			super();
			this.fee_id = fee_id;
			this.s_id = s_id;
			this.fees = fees;
		}
		
}
