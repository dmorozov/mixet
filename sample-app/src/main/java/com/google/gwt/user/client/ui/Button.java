package com.google.gwt.user.client.ui;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

import elemental.events.Event;
import elemental.events.EventListener;
import elemental.events.EventRemover;
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
		EventListener listener = new EventListener()
		{
			@Override
			public void handleEvent(Event evt)
			{
				handler.onClick(null);
			}
		};

		EventRemover remover = getElement().addEventListener("click", listener, false);

		return new HandlerRegistration()
		{
			@Override
			public void removeHandler()
			{
				remover.remove();
			}
		};
	}
}
