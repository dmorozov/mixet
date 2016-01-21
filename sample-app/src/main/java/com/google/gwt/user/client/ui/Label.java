package com.google.gwt.user.client.ui;

import elemental.js.JsBrowser;
import elemental.js.html.JsDivElement;

public class Label extends WidgetBase
{
	public Label(String text)
	{
		JsDivElement div = JsBrowser.getDocument().createDivElement();
		div.setInnerText(text);

		setElement(div);
	}
}
