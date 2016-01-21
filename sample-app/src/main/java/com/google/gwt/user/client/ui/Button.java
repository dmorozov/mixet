package com.google.gwt.user.client.ui;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

import elemental.events.Event;
import elemental.events.EventListener;
import elemental.js.JsBrowser;
import elemental.js.html.JsButtonElement;

public class Button extends Widget
{
	public Button(String text)
	{
		JsButtonElement div = JsBrowser.getDocument().createButtonElement();
		div.setInnerText(text);

		setElement(div);
	}

	public HandlerRegistration addClickHandler(final ClickHandler handler)
	{
		getElement().addEventListener("click", new EventListener()
		{
			@Override
			public void handleEvent(Event evt)
			{
				handler.onClick(null);
			}
		}, false);

		return null;
	}
}
