package com.google.gwt.user.client.ui;

import elemental.js.dom.JsElement;

public class WidgetBase implements IsWidget, Widget
{
	private JsElement element;

	@Override
	public Widget asWidget()
	{
		return this;
	}

	@Override
	public JsElement getElement()
	{
		return element;
	}

	public void setElement(JsElement element)
	{
		assert this.element == null : "the root element of a widget cannot be changed once set";
		this.element = element;
	}
}
