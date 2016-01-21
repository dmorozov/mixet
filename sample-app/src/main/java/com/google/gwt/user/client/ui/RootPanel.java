package com.google.gwt.user.client.ui;

import elemental.js.JsBrowser;

public class RootPanel
{
	private static final RootPanel INSTANCE = new RootPanel();

	public static RootPanel get()
	{
		return INSTANCE;
	}

	public void add(IsWidget child)
	{
		JsBrowser.getDocument().getBody().appendChild(child.asWidget().getElement());
	}
}
