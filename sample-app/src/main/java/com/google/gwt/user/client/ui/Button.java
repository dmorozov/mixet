package com.google.gwt.user.client.ui;

import elemental.js.JsBrowser;
import elemental.js.html.JsButtonElement;

public class Button extends WidgetBase
{
	public Button(String text)
	{
		JsButtonElement div = JsBrowser.getDocument().createButtonElement();
		div.setInnerText(text);

		setElement(div);
	}
}
