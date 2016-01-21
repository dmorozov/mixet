package com.google.gwt.user.client;

import elemental.js.JsBrowser;

public class Window
{
	public static void alert(String message)
	{
		JsBrowser.getWindow().alert(message);
	}
}
