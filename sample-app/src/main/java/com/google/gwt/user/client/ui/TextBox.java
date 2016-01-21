package com.google.gwt.user.client.ui;

import elemental.js.JsBrowser;
import elemental.js.html.JsInputElement;

public class TextBox extends Widget
{
	public TextBox()
	{
		JsInputElement div = JsBrowser.getDocument().createInputElement();
		setElement(div);
	}

	public void setText(String text)
	{
		((JsInputElement)getElement()).setValue(text);
	}

	public String getText()
	{
		return ((JsInputElement)getElement()).getValue();
	}
}
