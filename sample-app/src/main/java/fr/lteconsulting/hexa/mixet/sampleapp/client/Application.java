package fr.lteconsulting.hexa.mixet.sampleapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Application implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		Label label = new Label("This is a label");
		Button button = new Button("Bonjour !");

		RootPanel.get().add(label);
		RootPanel.get().add(button);
	}
}
