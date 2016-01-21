package com.google.gwt.user.client.ui;

import elemental.js.JsBrowser;
import elemental.js.html.JsDivElement;

public class Label extends WidgetBase
{
	public Label(String text)
	{
		JsDivElement div = JsBrowser.getDocument().createDivElement();
		setElement(div);

		setText(text);
	}

	public void setText(String text)
	{
		getElement().setInnerText(text);
	}
}
