package com.beifeng.javasdk;
public class Test {
	public static void main(String[] args) {
		AnalyticsEngineSDK.onChargeSuccess("orderid123", "gerryliu123");
		AnalyticsEngineSDK.onChargeRefund("orderid456", "gerryliu456");
	}
}
