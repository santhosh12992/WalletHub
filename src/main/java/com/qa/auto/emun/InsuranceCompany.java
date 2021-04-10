package com.qa.auto.emun;

public enum InsuranceCompany {
	ANNUITIES("Annuties"), HEALTH_INSURANCE("Health Insurance"), LIFE_INSURANCE("Life Insurance"),;

	public final String label;

	private InsuranceCompany(String label) {
		this.label = label;
	}
}
