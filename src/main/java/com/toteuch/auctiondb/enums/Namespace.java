package com.toteuch.auctiondb.enums;

public enum Namespace {
	STATIC("static-"), DYNAMIC("dynamic-"), PROFILE("profile-");
	private String namespace;
	Namespace(String namespace) {
		this.namespace = namespace;
	}
	
	public String getNamespace() {
		return this.namespace;
	}
}
